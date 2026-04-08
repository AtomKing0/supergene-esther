"""
PST Economy Simulator V5 — rv_gold_ratio 기반 RV 시스템 반영
date: 2026-04-07
ref: workspace/05_system_result.md, workspace/09_gold_inflation_report.html

V3 → V4 핵심 변경 (정정판):
  Source 감소:
    idle_gold_charge_amount  3,000 → 2,000  (−33%)
    idle_gold_amount_increase  400 → 300    (−25%)
    idle_gold_max_cap        10,000 → 6,000 (−40%)
    daily_gift Day6           5,000 → 3,000 (−40%)
    RV 단가: 고정(inbox/popup 800g, shop 1000g) → entry_cost×rv_gold_ratio/10000 (레벨 비례)
  Source 증가/신규:
    shop AD pay_limit             1 → 3     (+200%)
    lobby RV 채널 신규           없음 → 3회/일
  Sink 강화:
    level_entry_tier 전 구간         +20%
    is_album_collection_open   OFF → ON    (~1,500g/일)
    is_deck_collection_open    OFF → ON    (~1,500g/일)

  ※ inbox_free_gold_amount (10058), popup_free_gold_amount (10064),
     shop_ad_reward_amount (product 190001) 는 deprecated.
     reward_amount=0 은 rv_gold_ratio 공식 사용을 의미함.
"""

import random
import math
from typing import List, Dict

# ─── RV 골드 비율 테이블 (rv_gold_ratio, level_entry_tier 기준) ──
RV_RATIO_TABLE = [
    (1,   2,    0),
    (3,   9,    3333),
    (10,  24,   3333),
    (25,  49,   3333),
    (50,  99,   3333),
    (100, 199,  3800),
    (200, 349,  3800),
    (350, 549,  4200),
    (550, 799,  4200),
    (800, 1099, 4200),
    (1100,1449, 4200),
    (1450,9999, 4200),
]

# ─── V3 파라미터 (현재 라이브, 고정 단가 방식) ──────────────────
PARAMS_V3 = {
    'idle_base': 3000, 'idle_increase': 400, 'idle_cap': 10000,
    'rv_mode': 'fixed',
    'inbox_gold': 800, 'inbox_limit': 5,
    'popup_gold': 800, 'popup_limit': 10,
    'shop_gold': 1000, 'shop_limit': 1,
    'lobby_limit': 0,
    'wheel_gold_ev': 720, 'wheel_limit': 5,
    'daily_gift_avg': 11000 / 7,
    'collection_sink_per_game': 0,
    'entry_tier_multiplier': 1.0,
    'avg_combos_per_win': 5,
    'avg_remaining_cards_per_win': 5,
    'combo_base_mult': 1.0,
    'deck_reward_mult': 1.0,
}

# ─── V4 파라미터 (rv_gold_ratio 기반, 론칭안) ────────────────────
PARAMS_V4 = {
    'idle_base': 1000, 'idle_increase': 300, 'idle_cap': 6000,
    'rv_mode': 'ratio',
    'inbox_limit': 5,
    'popup_limit': 10,
    'shop_limit': 3,
    'lobby_limit': 3,
    'wheel_gold_ev': 720, 'wheel_limit': 5,
    'daily_gift_avg': 9000 / 7,
    'collection_sink_per_game': 0,
    'bet_x1_ratio': 0.5,
    'bet_x2_ratio': 0.5,
    'entry_tier_multiplier': 1.2,
    'avg_combos_per_win': 5,
    'avg_remaining_cards_per_win': 5,
    'combo_base_mult': 1.0,
    'deck_reward_mult': 1.0,
    'booster_use_rate': 0.0,       # 게임당 부스터 사용 확률 (0~1)
    'undo_count_when_used': 4,     # 부스터 사용 시 undo 횟수
    'wildcard_count_when_used': 1, # 부스터 사용 시 wild_card 횟수
    'undo_ucir': 0.20,             # undo 사용횟수 증가율 (V4: 20%, V3: 25%)
    'wildcard_ratio': 0.65,        # wild_card 가격 비율 (V4: 65%, V3: 50%)
}

# ─── V4 설계 기준 시나리오 (A안 확정) ────────────────────────────
# 부스터가 주요 골드 싱크: 부스터 미사용 → D30 ≈ +100k (버퍼)
#                        부스터 10% 사용 → D30 ≈ 0 (IAP 압박)
# bet_mult = 1.0 (x1 전용), booster_use_rate = 0.10
# → 전 유저 플러스 유지하면서 골드 인플레이션 해소
import copy as _copy
PARAMS_V4_BASELINE = _copy.deepcopy(PARAMS_V4)
PARAMS_V4_BASELINE.update({
    'bet_x1_ratio': 1.0,
    'bet_x2_ratio': 0.0,
    'booster_use_rate': 0.10,
})

# ─── 인게임 보상 상수 (const 시트, 현재 라이브값) ────────────────
COMBO_BASE          = 2     # const[10047] ingame_combo_reward_base
COMBO_INCREASE      = 1     # const[10048] ingame_combo_reward_increase
COMBO_CAP           = 50    # const[10049] ingame_combo_reward_max_cap
COMBO_LVL_INTERVAL  = 10    # const[10050] ingame_combo_reward_level_interval
COMBO_LVL_INCREASE  = 1     # const[10051] ingame_combo_reward_level_increase

DECK_REWARD_CAP     = 5000  # const[10054] remaining_deck_reward_max_cap

# 남은 덱 보상 카드당 골드 (level_entry_tier 기준, 05_system_result.md)
DECK_REWARD_TIER = [
    (3,   9,    10),
    (10,  24,   15),
    (25,  49,   18),
    (50,  99,   20),
    (100, 199,  22),
    (200, 349,  25),
    (350, 549,  29),
    (550, 799,  34),
    (800, 1099, 39),
    (1100,1449, 45),
    (1450,9999, 50),
]

# ─── 컬렉션 보상 테이블 (라이브 시트 기준) ───────────────────────
# collection_album_puzzle_list: 앨범 완성 보상
ALBUM_PIECE_CUM  = [78, 171, 280, 405, 546, 702, 872]   # 누적 피스 기준
ALBUM_GOLD       = [3500, 5000, 6000, 7000, 8500, 10000, 12000]

# collection_album_milestone: 20개, 합계 23,000g, req_point 100~2000 (균등 가정)
MILESTONE_POINTS = list(range(100, 2001, 100))           # 100,200,...,2000
MILESTONE_GOLD   = 1150                                  # 23,000g / 20 (균등)

# ─── 기준 입장료 테이블 (V3 기준) ────────────────────────────────
ENTRY_TIER_BASE = [
    (1,   2,    0),
    (3,   9,    1000),
    (10,  24,   1500),
    (25,  49,   1800),
    (50,  99,   2000),
    (100, 199,  2200),
    (200, 349,  2500),
    (350, 549,  2900),
    (550, 799,  3400),
    (800, 1099, 3900),
    (1100,1449, 4500),
    (1450,9999, 5000),
]

# 유저 타입: (이름, 레벨, 판수/일, 방치수령/일, AD율, 승률)
# V3 기준 유저 타입 (라이브 행동 기반, V3 D30 기준선 산출용)
USER_TYPES_V3 = [
    ('극소극(튜토리얼)', 5,   2,  1, 0.20, 0.75),
    ('소극(초보)',       15,  5,  2, 0.40, 0.60),
    ('보통(중반)★',     75,  15, 3, 0.70, 0.60),
    ('활발(중반)',       75,  25, 4, 0.80, 0.60),
    ('헌신(고레벨)',     200, 35, 5, 0.90, 0.55),
    ('하드코어',        300, 40, 6, 1.00, 0.55),
]

# V4 기준 유저 타입 (판수 V3 동일 — RV 충전 로직이 행동 변화 반영)
USER_TYPES_V4 = [
    ('극소극(튜토리얼)', 5,   2,  1, 0.20, 0.75),
    ('소극(초보)',       15,  5,  2, 0.40, 0.60),
    ('보통(중반)★',     75,  15, 3, 0.70, 0.60),
    ('활발(중반)',       75,  25, 4, 0.80, 0.60),
    ('헌신(고레벨)',     200, 35, 5, 0.90, 0.55),
    ('하드코어',        300, 40, 6, 1.00, 0.55),
]

# 하위 호환용 alias (기존 스크립트 참조 대응)
USER_TYPES = USER_TYPES_V4


def get_entry_cost(level: int, multiplier: float = 1.0) -> int:
    for lo, hi, cost in ENTRY_TIER_BASE:
        if lo <= level <= hi:
            return int(cost * multiplier)
    return int(2000 * multiplier)


def get_rv_ratio(level: int) -> int:
    for lo, hi, ratio in RV_RATIO_TABLE:
        if lo <= level <= hi:
            return ratio
    return 3000


def get_rv_gold(level: int, entry_cost: int) -> int:
    """1회 RV 시청 시 골드 = entry_cost × rv_gold_ratio / 10000"""
    ratio = get_rv_ratio(level)
    return entry_cost * ratio // 10000


def get_deck_reward_per_card(level: int) -> int:
    for lo, hi, reward in DECK_REWARD_TIER:
        if lo <= level <= hi:
            return reward
    return 20


def get_combo_total(level: int, avg_combos: float, base_mult: float = 1.0,
                    inc_mult: float = 1.0, cap_mult: float = 1.0) -> int:
    """1게임 평균 콤보 보상 합계"""
    intervals = level // COMBO_LVL_INTERVAL
    base = int((COMBO_BASE + intervals * COMBO_LVL_INCREASE) * base_mult)
    increase = int((COMBO_INCREASE + intervals * COMBO_LVL_INCREASE) * inc_mult)
    cap  = int(COMBO_CAP * cap_mult)
    total = 0
    for i in range(int(avg_combos)):
        total += min(base + i * increase, cap)
    return total


def calc_booster_cost(entry: int, bet_mult: float,
                      undo_n: int, wc_n: int,
                      undo_ucir: float = 0.20,
                      wc_ratio: float = 0.65) -> int:
    """한 게임 부스터 사용 총 비용 (x1/x2 평균 배팅 기준)
    undo: n번째 사용 = entry × bet × min(n × undo_ucir, 150%)
    wild_card: entry × bet × wc_ratio (fixed)
    """
    cost = 0
    for n in range(1, undo_n + 1):
        cost += entry * bet_mult * min(n * undo_ucir, 1.50)
    cost += entry * bet_mult * wc_ratio * wc_n
    return int(cost)


def idle_gold_per_col(level: int, p: dict) -> int:
    val = p['idle_base'] + ((level - 1) // 20) * p['idle_increase']
    return min(val, p['idle_cap'])


def win_reward(level: int, multiplier: float = 1.0) -> int:
    entry = get_entry_cost(level, multiplier)
    return int(entry * 0.17)


def simulate_user(name: str, level: int, games: int, idle_cols: int,
                  ad_rate: float, win_rate: float, params: dict,
                  runs: int = 300, days: int = 30) -> dict:
    multiplier = params['entry_tier_multiplier']
    entry = get_entry_cost(level, multiplier)
    idle_g = idle_gold_per_col(level, params)

    # RV 골드 계산
    if params['rv_mode'] == 'fixed':
        rv_gold_watch = 0  # fixed 모드에서는 각 채널 개별 처리
    else:
        rv_gold_watch = get_rv_gold(level, entry)

    snapshot_days = [1, 7, 14, 30]
    balance_snapshots: Dict[int, List[float]] = {d: [] for d in snapshot_days}

    bet_x1 = params.get('bet_x1_ratio', 0.0)
    bet_x2 = params.get('bet_x2_ratio', 0.0)

    # 인게임 보상 사전 계산 (레벨·파라미터 고정값)
    win_combo = get_combo_total(
        level,
        params.get('avg_combos_per_win', 5),
        params.get('combo_base_mult', 1.0),
    )
    deck_per_card = int(get_deck_reward_per_card(level) * params.get('deck_reward_mult', 1.0))
    win_deck  = min(deck_per_card * int(params.get('avg_remaining_cards_per_win', 5)), DECK_REWARD_CAP)
    win_gold  = win_combo + win_deck

    for run in range(runs):
        rng = random.Random(run * 7919 + level * 31)
        gold = 2000
        cumul_pieces = 0
        album_rewarded    = [False] * len(ALBUM_PIECE_CUM)
        milestone_rewarded = [False] * len(MILESTONE_POINTS)

        for day in range(1, days + 1):
            # SOURCE — 방치골드
            actual_idle = int(idle_cols * rng.uniform(0.75, 1.0))
            idle_income = idle_g * actual_idle

            # SOURCE — RV 채널
            if params['rv_mode'] == 'fixed':
                actual_inbox = int(params['inbox_limit'] * rng.uniform(ad_rate * 0.75, ad_rate))
                inbox_income = actual_inbox * params['inbox_gold']
                actual_popup = int(params['popup_limit'] * rng.uniform(ad_rate * 0.70, ad_rate))
                popup_income = actual_popup * params['popup_gold']
                actual_shop = int(params['shop_limit'] * rng.uniform(ad_rate * 0.60, ad_rate))
                shop_income = actual_shop * params['shop_gold']
                lobby_income = 0
            else:
                actual_inbox = int(params['inbox_limit'] * rng.uniform(ad_rate * 0.75, ad_rate))
                inbox_income = actual_inbox * rv_gold_watch
                actual_popup = int(params['popup_limit'] * rng.uniform(ad_rate * 0.70, ad_rate))
                popup_income = actual_popup * rv_gold_watch
                actual_shop = int(params['shop_limit'] * rng.uniform(ad_rate * 0.60, ad_rate))
                shop_income = actual_shop * rv_gold_watch
                actual_lobby = int(params['lobby_limit'] * rng.uniform(ad_rate * 0.60, ad_rate))
                lobby_income = actual_lobby * rv_gold_watch

            # SOURCE — 휠
            actual_wheel = int(params['wheel_limit'] * rng.uniform(ad_rate * 0.70, ad_rate))
            wheel_income = actual_wheel * params['wheel_gold_ev']

            # SOURCE — 출석
            attend_income = params['daily_gift_avg']

            # SOURCE — 방치골드·휠·출석 먼저 수령 (게임 전)
            gold += idle_income + wheel_income + attend_income

            # RV — fixed 모드는 일괄 수령, ratio 모드는 게임 중 충전 풀로 운용
            if params['rv_mode'] == 'fixed':
                gold += inbox_income + popup_income + shop_income + lobby_income
                rv_pool = 0
            else:
                rv_pool = actual_inbox + actual_popup + actual_shop + actual_lobby

            # SINK — 게임플레이 / SOURCE — 컬렉션 피스
            # ratio 모드: 잔고 부족 시 RV 우선 충전 후 게임 진행
            clears_today = 0
            for _ in range(games):
                if params['rv_mode'] != 'fixed':
                    while gold < entry and rv_pool > 0:
                        gold += rv_gold_watch
                        rv_pool -= 1
                    if gold < entry:
                        break  # 충전해도 부족 → 이후 게임 스킵

                if rng.random() < win_rate:
                    gold += win_gold
                    clears_today += 1
                else:
                    gold -= entry

                # SINK — 부스터 (booster_use_rate 확률로 사용)
                if params.get('booster_use_rate', 0) > 0:
                    if rng.random() < params['booster_use_rate']:
                        bet_mult = (params.get('bet_x1_ratio', 0) * 1.0 +
                                    params.get('bet_x2_ratio', 0) * 2.0)
                        gold -= calc_booster_cost(
                            entry, bet_mult,
                            params.get('undo_count_when_used', 4),
                            params.get('wildcard_count_when_used', 1),
                            undo_ucir=params.get('undo_ucir', 0.20),
                            wc_ratio=params.get('wildcard_ratio', 0.65),
                        )

            # 남은 RV 수령 (게임 후)
            if params['rv_mode'] != 'fixed':
                gold += rv_pool * rv_gold_watch

            # SOURCE — 컬렉션 피스 적립 및 보상 지급
            collection_income = 0
            if bet_x1 + bet_x2 > 0:
                x1_c = round(clears_today * bet_x1 / (bet_x1 + bet_x2))
                x2_c = clears_today - x1_c
                pieces_today = x1_c * 1 + x2_c * 2
                cumul_pieces += pieces_today

                for i, threshold in enumerate(ALBUM_PIECE_CUM):
                    if not album_rewarded[i] and cumul_pieces >= threshold:
                        album_rewarded[i] = True
                        collection_income += ALBUM_GOLD[i]

                for i, threshold in enumerate(MILESTONE_POINTS):
                    if not milestone_rewarded[i] and cumul_pieces >= threshold:
                        milestone_rewarded[i] = True
                        collection_income += MILESTONE_GOLD

            gold += collection_income
            if day in snapshot_days:
                balance_snapshots[day].append(gold)

    avg = lambda d: sum(balance_snapshots[d]) / runs

    # 이론 일일 소득 (평균 AD율 기준)
    if params['rv_mode'] == 'fixed':
        daily_inbox  = params['inbox_limit'] * ad_rate * params['inbox_gold']
        daily_popup  = params['popup_limit'] * ad_rate * params['popup_gold']
        daily_shop   = params['shop_limit']  * ad_rate * params['shop_gold']
        daily_lobby  = 0
    else:
        daily_inbox  = params['inbox_limit'] * ad_rate * rv_gold_watch
        daily_popup  = params['popup_limit'] * ad_rate * rv_gold_watch
        daily_shop   = params['shop_limit']  * ad_rate * rv_gold_watch
        daily_lobby  = params['lobby_limit'] * ad_rate * rv_gold_watch

    daily_source = (
        idle_g * idle_cols +
        daily_inbox + daily_popup + daily_shop + daily_lobby +
        params['wheel_limit'] * ad_rate * params['wheel_gold_ev'] +
        params['daily_gift_avg']
    )
    daily_gameplay = games * (
        win_rate * win_gold -
        (1 - win_rate) * entry
    )
    daily_combo = games * win_rate * win_combo
    daily_deck  = games * win_rate * win_deck

    # 컬렉션 Source 이론치 (D30 평균)
    pieces_per_day = games * win_rate * (bet_x1 * 1 + bet_x2 * 2)
    cumul_d30 = pieces_per_day * 30
    col_total = (
        sum(r for t, r in zip(ALBUM_PIECE_CUM, ALBUM_GOLD) if t <= cumul_d30) +
        sum(MILESTONE_GOLD for t in MILESTONE_POINTS if t <= cumul_d30)
    )
    daily_collection_source = col_total / 30

    daily_net = daily_source + daily_gameplay + daily_collection_source

    return {
        'name': name, 'level': level, 'games': games,
        'idle_cols': idle_cols, 'ad_rate': ad_rate,
        'idle_per_col': idle_g, 'entry': entry,
        'rv_gold_per_watch': rv_gold_watch,
        'daily_idle': idle_g * idle_cols,
        'daily_inbox': daily_inbox,
        'daily_popup': daily_popup,
        'daily_shop': daily_shop,
        'daily_lobby': daily_lobby,
        'daily_wheel': params['wheel_limit'] * ad_rate * params['wheel_gold_ev'],
        'daily_gift': params['daily_gift_avg'],
        'daily_source': daily_source,
        'daily_gameplay': daily_gameplay,
        'daily_combo': daily_combo,
        'daily_deck': daily_deck,
        'win_gold': win_gold,
        'daily_collection': daily_collection_source,
        'daily_net': daily_net,
        'd1':  avg(1),
        'd7':  avg(7),
        'd14': avg(14),
        'd30': avg(30),
    }


def run_all(params: dict, label: str, runs: int = 300,
            user_types=None) -> List[dict]:
    if user_types is None:
        user_types = USER_TYPES
    results = []
    for (name, level, games, idle_cols, ad_rate, win_rate) in user_types:
        r = simulate_user(name, level, games, idle_cols, ad_rate, win_rate,
                          params, runs=runs)
        results.append(r)
        print(f"  [{label}] {name:<18} | 일일순소득 {r['daily_net']:>+9,.0f}g | "
              f"D30 {r['d30']:>+12,.0f}g")
    return results


def iap_value_days(daily_net: float, iap_gold: int) -> float:
    if daily_net <= 0:
        return float('inf')
    return iap_gold / daily_net


def main():
    print("=" * 70)
    print("PST Economy Simulator V5 — rv_gold_ratio 적용")
    print("=" * 70)
    print()

    print("[V3] 시뮬레이션 실행 중...")
    results_v3 = run_all(PARAMS_V3, "V3", user_types=USER_TYPES_V3)
    print()
    print("[V4] 시뮬레이션 실행 중...")
    results_v4 = run_all(PARAMS_V4, "V4", user_types=USER_TYPES_V4)
    print()

    # ── 보통(중반) 상세 breakdown ─────────────────────────────────
    r3 = next(r for r in results_v3 if '보통' in r['name'])
    r4 = next(r for r in results_v4 if '보통' in r['name'])

    print("=" * 70)
    print("보통(중반)★ Lv75 일일 소득 구조 (AD 70% 기준)")
    print("=" * 70)
    print(f"{'항목':<20} {'V3':>12} {'V4':>12} {'변화':>12}")
    print("-" * 56)
    rows = [
        ("방치골드",        r3['daily_idle'],      r4['daily_idle']),
        ("인박스 RV",       r3['daily_inbox'],     r4['daily_inbox']),
        ("팝업 RV",         r3['daily_popup'],     r4['daily_popup']),
        ("상점 RV",         r3['daily_shop'],      r4['daily_shop']),
        ("로비 RV (신규)",  r3['daily_lobby'],     r4['daily_lobby']),
        ("데일리 휠",       r3['daily_wheel'],     r4['daily_wheel']),
        ("출석 보상",       r3['daily_gift'],      r4['daily_gift']),
        ("게임플레이 EV",   r3['daily_gameplay'],  r4['daily_gameplay']),
        ("  └콤보 보상",    r3['daily_combo'],     r4['daily_combo']),
        ("  └덱 보너스",    r3['daily_deck'],      r4['daily_deck']),
        ("컬렉션 Source",   r3['daily_collection'],  r4['daily_collection']),
    ]
    for label, v3, v4 in rows:
        delta = v4 - v3
        print(f"  {label:<18} {v3:>+12,.0f}g {v4:>+12,.0f}g {delta:>+11,.0f}g")
    print("-" * 56)
    print(f"  {'일일 순소득':<18} {r3['daily_net']:>+12,.0f}g {r4['daily_net']:>+12,.0f}g "
          f"{r4['daily_net']-r3['daily_net']:>+11,.0f}g")

    print()
    print("rv_gold_per_watch (V4 보통★ Lv75):", r4['rv_gold_per_watch'], "g")
    print("RV 채널 합계 횟수:", PARAMS_V4['inbox_limit'],"+",PARAMS_V4['popup_limit'],"+",
          PARAMS_V4['shop_limit'],"+",PARAMS_V4['lobby_limit'],"=",
          PARAMS_V4['inbox_limit']+PARAMS_V4['popup_limit']+PARAMS_V4['shop_limit']+PARAMS_V4['lobby_limit'],"회/일")

    print()
    print("=" * 70)
    print("유저 유형별 V3 vs V4 비교")
    print("=" * 70)
    print(f"{'유저':<18} {'레벨':>5} {'입장료':>7} {'V3일소득':>10} {'V4일소득':>10} {'V3 D30':>12} {'V4 D30':>12}")
    print("-" * 78)
    for r3u, r4u in zip(results_v3, results_v4):
        print(f"  {r3u['name']:<16} {r3u['level']:>5} {r4u['entry']:>7,}g "
              f"{r3u['daily_net']:>+9,.0f}g {r4u['daily_net']:>+9,.0f}g "
              f"{r3u['d30']:>+11,.0f}g {r4u['d30']:>+11,.0f}g")

    print()
    print("=" * 70)
    print("IAP 가치 구조 (V4 보통★ 일소득 기준)")
    print("=" * 70)
    iaps = [
        ("gold_iap_1",    "$1.99",  10000),
        ("bundle_iap_1",  "$4.99",  27000),
        ("bundle_iap_2 ★","$8.99",  45000),
        ("bundle_iap_3",  "$14.99", 85000),
        ("bundle_iap_4",  "$26.99", 170000),
        ("bundle_iap_5 ★","$49.99", 370000),
    ]
    print(f"  {'상품':<22} {'가격':>7} {'골드':>9} {'V3 일수':>8} {'V4 일수':>8}")
    print("-" * 58)
    for pid, price, gold in iaps:
        days_v3 = iap_value_days(r3['daily_net'], gold)
        days_v4 = iap_value_days(r4['daily_net'], gold)
        days_v3_str = f"{days_v3:.1f}일" if days_v3 < 999 else "∞"
        days_v4_str = f"{days_v4:.1f}일" if days_v4 < 999 else "∞"
        print(f"  {pid:<22} {price:>7} {gold:>9,}g {days_v3_str:>7} {days_v4_str:>8}")

    # IAP 목표: $1.99 ≥ 1.0일치
    days_199 = iap_value_days(r4['daily_net'], 10000)
    print()
    print(f"  $1.99 IAP 가치: {days_199:.2f}일치  {'✅ PASS (≥1.0)' if days_199 >= 1.0 else '❌ FAIL (<1.0)'}")

    print()
    print("=" * 70)
    print("경제 건강 점수 (V4)")
    print("=" * 70)
    # D30 target for 보통 유저: ≤ 10,356g (기존 목표)
    d30_target = 10356
    d30_v4 = r4['d30']
    iap_target = 1.0
    iap_v4 = days_199

    print(f"  지표                      V3           V4         판정")
    print("-" * 60)
    print(f"  D30 보통 잔액    {r3['d30']:>+12,.0f}g {d30_v4:>+12,.0f}g  "
          f"{'✅' if d30_v4 <= d30_target else '❌'} 목표 ≤{d30_target:,}g")
    print(f"  $1.99 = X일치    "
          f"{iap_value_days(r3['daily_net'],10000):>11.1f}일 "
          f"{iap_v4:>11.1f}일  "
          f"{'✅' if iap_v4 >= iap_target else '❌'} 목표 ≥{iap_target}일")

    print()
    print("=" * 70)
    print("시뮬레이션 완료 (V5, rv_gold_ratio 적용)")
    print("=" * 70)

    return results_v3, results_v4


if __name__ == "__main__":
    main()
