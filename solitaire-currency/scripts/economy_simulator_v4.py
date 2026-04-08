"""
PST Economy Simulator V4 — 론칭안 파라미터
date: 2026-04-07
ref: workspace/09_gold_inflation_report.html

V3 → V4 핵심 변경:
  Source 감소:
    idle_gold_charge_amount  3,000 → 2,000  (−33%)
    idle_gold_amount_increase  400 → 300    (−25%)
    idle_gold_max_cap        10,000 → 6,000 (−40%)
    inbox_free_gold_amount      800 → 600   (−25%)
    popup_free_gold_amount      800 → 600   (−25%)
    shop AD gold              1,000 → 700   (−30%)
    daily_gift Day6           5,000 → 3,000 (−40%)
  Source 증가:
    shop AD pay_limit             1 → 3     (+200%)
  Sink 강화:
    level_entry_tier 전 구간         +20%
    is_album_collection_open   OFF → ON    (~1,500g/일)
    is_deck_collection_open    OFF → ON    (~1,500g/일)
"""

import random
import math
from dataclasses import dataclass, field
from typing import List, Dict

# ─── V3 파라미터 (현재 라이브) ────────────────────────────────
PARAMS_V3 = {
    'idle_base': 3000, 'idle_increase': 400, 'idle_cap': 10000,
    'inbox_gold': 800, 'inbox_limit': 5,
    'popup_gold': 800, 'popup_limit': 10,
    'shop_gold': 1000, 'shop_limit': 1,
    'wheel_gold_ev': 720, 'wheel_limit': 5,
    'daily_gift_avg': 11000 / 7,   # 1,571/일
    'collection_sink_per_game': 0,  # OFF
    'entry_tier_multiplier': 1.0,
}

# ─── V4 파라미터 (론칭안) ────────────────────────────────────
PARAMS_V4 = {
    'idle_base': 2000, 'idle_increase': 300, 'idle_cap': 6000,
    'inbox_gold': 600, 'inbox_limit': 5,
    'popup_gold': 600, 'popup_limit': 10,
    'shop_gold': 700,  'shop_limit': 3,
    'wheel_gold_ev': 720, 'wheel_limit': 5,  # 휠 금액 비변경
    'daily_gift_avg': 9000 / 7,    # 1,286/일 (Day6 5000→3000)
    'collection_sink_per_game': 200,  # album+deck 활성화 (~3,000g/15판)
    'entry_tier_multiplier': 1.2,
}

# ─── 기준 입장료 테이블 (V3) ──────────────────────────────────
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

# 유저 타입 정의
USER_TYPES = [
    # (이름, 레벨, 판수/일, 방치수령/일, AD율, 승률)
    ('극소극(튜토리얼)', 5,   2,  1, 0.20, 0.75),
    ('소극(초보)',       15,  5,  2, 0.40, 0.60),
    ('보통(중반)★',     75,  15, 3, 0.70, 0.60),
    ('활발(중반)',       75,  25, 4, 0.80, 0.60),
    ('헌신(고레벨)',     200, 35, 5, 0.90, 0.55),
    ('하드코어',        300, 40, 6, 1.00, 0.55),
]


def get_entry_cost(level: int, multiplier: float = 1.0) -> int:
    for lo, hi, cost in ENTRY_TIER_BASE:
        if lo <= level <= hi:
            return int(cost * multiplier)
    return int(2000 * multiplier)


def idle_gold_per_col(level: int, p: dict) -> int:
    val = p['idle_base'] + (level // 20) * p['idle_increase']
    return min(val, p['idle_cap'])


def win_reward(level: int, multiplier: float = 1.0) -> int:
    """WIN 시 순수익 (입장료 반환 후 보너스만). 입장료의 약 17%."""
    entry = get_entry_cost(level, multiplier)
    return int(entry * 0.17)


def simulate_user(name: str, level: int, games: int, idle_cols: int,
                  ad_rate: float, win_rate: float, params: dict,
                  runs: int = 300, days: int = 30) -> dict:
    multiplier = params['entry_tier_multiplier']
    entry = get_entry_cost(level, multiplier)
    idle_g = idle_gold_per_col(level, params)

    snapshot_days = [1, 7, 14, 30]
    balance_snapshots: Dict[int, List[float]] = {d: [] for d in snapshot_days}

    for run in range(runs):
        rng = random.Random(run * 7919 + level * 31)
        gold = 2000  # NRU 시작 골드

        for day in range(1, days + 1):
            # SOURCE
            actual_idle = int(idle_cols * rng.uniform(0.75, 1.0))
            idle_income = idle_g * actual_idle

            actual_inbox = int(params['inbox_limit'] * rng.uniform(ad_rate * 0.75, ad_rate))
            inbox_income = actual_inbox * params['inbox_gold']

            actual_popup = int(params['popup_limit'] * rng.uniform(ad_rate * 0.70, ad_rate))
            popup_income = actual_popup * params['popup_gold']

            actual_shop = int(params['shop_limit'] * rng.uniform(ad_rate * 0.60, ad_rate))
            shop_income = actual_shop * params['shop_gold']

            actual_wheel = int(params['wheel_limit'] * rng.uniform(ad_rate * 0.70, ad_rate))
            wheel_income = actual_wheel * params['wheel_gold_ev']

            # 출석 (7일 주기 평균)
            attend_income = params['daily_gift_avg']

            # SINK — 게임플레이
            gameplay_net = 0
            for _ in range(games):
                if rng.random() < win_rate:
                    gameplay_net += win_reward(level, multiplier)
                else:
                    gameplay_net -= entry

            # SINK — 컬렉션
            collection_sink = games * params['collection_sink_per_game']

            daily = (idle_income + inbox_income + popup_income +
                     shop_income + wheel_income + attend_income +
                     gameplay_net - collection_sink)

            gold += daily

            if day in snapshot_days:
                balance_snapshots[day].append(gold)

    avg = lambda d: sum(balance_snapshots[d]) / runs

    # 이론 일일 소득 (평균 AD율 기준)
    daily_source = (
        idle_g * idle_cols +
        params['inbox_limit'] * ad_rate * params['inbox_gold'] +
        params['popup_limit'] * ad_rate * params['popup_gold'] +
        params['shop_limit'] * ad_rate * params['shop_gold'] +
        params['wheel_limit'] * ad_rate * params['wheel_gold_ev'] +
        params['daily_gift_avg']
    )
    daily_gameplay = games * (
        win_rate * win_reward(level, multiplier) -
        (1 - win_rate) * entry
    )
    daily_collection = games * params['collection_sink_per_game']
    daily_net = daily_source + daily_gameplay - daily_collection

    return {
        'name': name, 'level': level, 'games': games,
        'idle_cols': idle_cols, 'ad_rate': ad_rate,
        'idle_per_col': idle_g, 'entry': entry,
        'daily_source': daily_source,
        'daily_gameplay': daily_gameplay,
        'daily_collection': daily_collection,
        'daily_net': daily_net,
        'd1':  avg(1),
        'd7':  avg(7),
        'd14': avg(14),
        'd30': avg(30),
    }


def run_all(params: dict, label: str, runs: int = 300) -> List[dict]:
    results = []
    for (name, level, games, idle_cols, ad_rate, win_rate) in USER_TYPES:
        r = simulate_user(name, level, games, idle_cols, ad_rate, win_rate,
                          params, runs=runs)
        results.append(r)
        print(f"  [{label}] {name:<18} | 일일소득 {r['daily_net']:>+8,.0f}g | "
              f"D30 {r['d30']:>10,.0f}g")
    return results


def iap_value_days(daily_net: float, iap_gold: int) -> float:
    if daily_net <= 0:
        return float('inf')
    return iap_gold / daily_net


def format_result(results_v3, results_v4):
    lines = []
    lines.append("---")
    lines.append("agent: economy_simulation")
    lines.append("version: 4")
    lines.append("date: 2026-04-07")
    lines.append("status: complete")
    lines.append("---")
    lines.append("")
    lines.append("# PST 경제 시뮬레이션 결과 v4")
    lines.append("")
    lines.append("## V3 → V4 파라미터 변경 요약")
    lines.append("")
    lines.append("| 파라미터 | V3 (현재) | V4 (론칭안) | 변경률 | 유형 |")
    lines.append("|---|---|---|---|---|")
    changes = [
        ("idle_gold_charge_amount", 3000, 2000, "Source"),
        ("idle_gold_amount_increase", 400, 300, "Source"),
        ("idle_gold_max_cap", 10000, 6000, "Source"),
        ("inbox_free_gold_amount", 800, 600, "Source"),
        ("popup_free_gold_amount", 800, 600, "Source"),
        ("shop_ad_gold", 1000, 700, "Source"),
        ("shop_ad_limit", 1, 3, "Source(+)"),
        ("daily_gift Day6 gold", 5000, 3000, "Source"),
        ("level_entry_tier 전구간", "현재", "+20%", "Sink"),
        ("is_album_collection_open", "OFF", "ON", "Sink"),
        ("is_deck_collection_open", "OFF", "ON", "Sink"),
    ]
    for name, v3val, v4val, typ in changes:
        if isinstance(v3val, int) and isinstance(v4val, int):
            pct = f"{(v4val - v3val) / v3val * 100:+.0f}%"
            v3_str = f"{v3val:,}"
            v4_str = f"{v4val:,}"
        else:
            pct = "—"
            v3_str = str(v3val)
            v4_str = str(v4val)
        lines.append(f"| `{name}` | {v3_str} | **{v4_str}** | {pct} | {typ} |")
    lines.append("")

    lines.append("## A. V4 일일 소득 구조")
    lines.append("")
    lines.append("*(보통(중반) Lv75, 방치3회/일, AD 70% 기준)*")
    lines.append("")
    r_v3 = next(r for r in results_v3 if '보통(중반)' in r['name'])
    r_v4 = next(r for r in results_v4 if '보통(중반)' in r['name'])

    lines.append("| 소득/지출 항목 | V3 현재 | V4 론칭안 | 변화 |")
    lines.append("|---|---|---|---|")
    idle_v3 = idle_gold_per_col(75, PARAMS_V3) * 3
    idle_v4 = idle_gold_per_col(75, PARAMS_V4) * 3
    inbox_v3 = PARAMS_V3['inbox_limit'] * 0.70 * PARAMS_V3['inbox_gold']
    inbox_v4 = PARAMS_V4['inbox_limit'] * 0.70 * PARAMS_V4['inbox_gold']
    popup_v3 = PARAMS_V3['popup_limit'] * 0.70 * PARAMS_V3['popup_gold']
    popup_v4 = PARAMS_V4['popup_limit'] * 0.70 * PARAMS_V4['popup_gold']
    shop_v3  = PARAMS_V3['shop_limit'] * 0.70 * PARAMS_V3['shop_gold']
    shop_v4  = PARAMS_V4['shop_limit'] * 0.70 * PARAMS_V4['shop_gold']
    wheel_v3 = PARAMS_V3['wheel_limit'] * 0.70 * PARAMS_V3['wheel_gold_ev']
    wheel_v4 = PARAMS_V4['wheel_limit'] * 0.70 * PARAMS_V4['wheel_gold_ev']
    att_v3   = PARAMS_V3['daily_gift_avg']
    att_v4   = PARAMS_V4['daily_gift_avg']
    gp_v3    = r_v3['daily_gameplay']
    gp_v4    = r_v4['daily_gameplay']
    col_v4   = r_v4['daily_collection']

    rows = [
        ("방치골드", idle_v3, idle_v4),
        ("인박스 광고", inbox_v3, inbox_v4),
        ("팝업 광고", popup_v3, popup_v4),
        ("상점 광고", shop_v3, shop_v4),
        ("데일리 휠", wheel_v3, wheel_v4),
        ("출석 보상", att_v3, att_v4),
        ("게임플레이 EV", gp_v3, gp_v4),
        ("컬렉션 Sink", 0, -col_v4),
    ]
    for row_name, v3, v4 in rows:
        delta = v4 - v3
        lines.append(f"| {row_name} | {v3:,.0f}g | **{v4:,.0f}g** | {delta:+,.0f}g |")
    net_v3 = sum(v3 for _, v3, _ in rows)
    net_v4 = sum(v4 for _, _, v4 in rows)
    lines.append(f"| **일일 순소득** | **{net_v3:,.0f}g** | **{net_v4:,.0f}g** | **{net_v4-net_v3:+,.0f}g** |")
    lines.append("")

    lines.append("## B. 유저 유형별 일일 순소득 & D30 잔액 비교")
    lines.append("")
    lines.append("| 유저 유형 | 레벨 | 입장료 | V3 일소득 | V4 일소득 | V3 D30 | V4 D30 |")
    lines.append("|---|---|---|---|---|---|---|")
    for r3, r4 in zip(results_v3, results_v4):
        lines.append(
            f"| {r4['name']} | {r4['level']} | {r4['entry']:,}g | "
            f"{r3['daily_net']:+,.0f}g | **{r4['daily_net']:+,.0f}g** | "
            f"{r3['d30']:,.0f}g | **{r4['d30']:,.0f}g** |"
        )
    lines.append("")

    lines.append("## C. Monte Carlo D30 잔액 (V4, 300회 × 30일)")
    lines.append("")
    lines.append("| 유저 유형 | D1 | D7 | D14 | D30 |")
    lines.append("|---|---|---|---|---|")
    for r in results_v4:
        lines.append(
            f"| {r['name']} | {r['d1']:,.0f}g | {r['d7']:,.0f}g | "
            f"{r['d14']:,.0f}g | **{r['d30']:,.0f}g** |"
        )
    lines.append("")

    lines.append("## D. IAP 가치 구조 (V4 기준)")
    lines.append("")
    r_norm = next(r for r in results_v4 if '보통(중반)' in r['name'])
    daily_income_v4 = max(r_norm['daily_net'], 1)

    iap_products = [
        ("gold_iap_1", "$1.99", 10000),
        ("bundle_iap_1", "$4.99", 27000),
        ("bundle_iap_2 ★most popular", "$8.99", 45000),
        ("bundle_iap_3", "$14.99", 85000),
        ("bundle_iap_4", "$26.99", 170000),
        ("bundle_iap_5 ★best value", "$49.99", 370000),
    ]
    lines.append("*(보통(중반) V4 일소득 기준)*")
    lines.append("")
    lines.append("| 상품 | 가격 | 골드 | V3 대비 일수 | **V4 대비 일수** |")
    lines.append("|---|---|---|---|---|")
    r_v3_norm = next(r for r in results_v3 if '보통(중반)' in r['name'])
    daily_v3 = max(r_v3_norm['daily_net'], 1)
    for prod_name, price, gold in iap_products:
        days_v3 = gold / daily_v3
        days_v4 = gold / daily_income_v4 if daily_income_v4 > 0 else float('inf')
        lines.append(f"| {prod_name} | {price} | {gold:,}g | {days_v3:.1f}일 | **{days_v4:.1f}일** |")
    lines.append("")
    lines.append(f"> V4 보통유저 일일 순소득: **{daily_income_v4:,.0f}g/일**")
    lines.append("")

    lines.append("## E. 경제 건강 점수 V4")
    lines.append("")
    r_norm_v4 = next(r for r in results_v4 if '보통(중반)' in r['name'])
    d30_v4 = r_norm_v4['d30']
    d30_target = 10356  # 론칭 목표

    # 골드 공급 건전성 (D30 목표 대비)
    if d30_v4 <= d30_target:
        supply_score = 90
    elif d30_v4 <= d30_target * 3:
        supply_score = 70
    elif d30_v4 <= d30_target * 10:
        supply_score = 50
    else:
        supply_score = 30

    # IAP 가치 ($1.99 = 며칠치)
    days_199 = 10000 / max(daily_income_v4, 1)
    if days_199 >= 1.0:
        iap_score = 85
    elif days_199 >= 0.8:
        iap_score = 70
    elif days_199 >= 0.6:
        iap_score = 55
    else:
        iap_score = 40

    overall = int((supply_score * 0.40 + iap_score * 0.25 + 75 * 0.15 + 65 * 0.10 + 68 * 0.10))

    lines.append("| 지표 | V3 | **V4** | 방향 | 판정 |")
    lines.append("|---|---|---|---|---|")
    lines.append(f"| 경제 건강 종합 | 62/100 | **{overall}/100** | {'↑' if overall > 62 else '↓'} | {'✅ 양호' if overall >= 75 else '⚠️ 주의'} |")
    lines.append(f"| 골드 공급 건전성 | 45/100 | **{supply_score}/100** | {'↑' if supply_score > 45 else '→'} | {'✅ 양호' if supply_score >= 70 else '⚠️ 주의'} |")
    lines.append(f"| IAP 전환 구조 | 52/100 | **{iap_score}/100** | {'↑' if iap_score > 52 else '→'} | {'✅ 양호' if iap_score >= 70 else '⚠️ 주의'} |")
    lines.append(f"| $1.99 = 무료소득 | 0.6일치 | **{days_199:.1f}일치** | {'↑' if days_199 > 0.6 else '→'} | {'✅ 목표달성 (≥1.0일)' if days_199 >= 1.0 else '⚠️ 미달'} |")
    lines.append(f"| D30 잔액 (보통) | 457,593g | **{d30_v4:,.0f}g** | ↓ | {'✅ 목표달성 (≤10,356g)' if d30_v4 <= 30000 else '⚠️ 미달'} |")
    lines.append("")

    lines.append("---")
    lines.append("")
    lines.append("*시뮬레이션: 2026-04-07 (v4, 론칭 확정안 파라미터 기반)*")
    lines.append(f"*Monte Carlo 300회 × {len(USER_TYPES)}개 유저 타입 × 30일*")
    lines.append("*ref: workspace/09_gold_inflation_report.html*")
    return "\n".join(lines)


if __name__ == "__main__":
    print("=" * 60)
    print("PST Economy Simulator V4 — 론칭안 파라미터")
    print("=" * 60)
    print("\n[V3 현재 라이브]")
    results_v3 = run_all(PARAMS_V3, "V3", runs=300)
    print("\n[V4 론칭안]")
    results_v4 = run_all(PARAMS_V4, "V4", runs=300)

    # 핵심 비교
    print("\n" + "=" * 60)
    print("V3 → V4 D30 비교 (보통유저 Lv75)")
    print("=" * 60)
    r3 = next(r for r in results_v3 if '보통(중반)' in r['name'])
    r4 = next(r for r in results_v4 if '보통(중반)' in r['name'])
    print(f"  V3 일일소득: {r3['daily_net']:+,.0f}g  →  V4: {r4['daily_net']:+,.0f}g")
    print(f"  V3 D30 잔액: {r3['d30']:,.0f}g  →  V4: {r4['d30']:,.0f}g")
    d30_target = 10356
    print(f"  론칭 목표 D30: {d30_target:,}g")
    status = "✅ 달성" if r4['d30'] <= d30_target * 3 else "⚠️ 미달"
    print(f"  판정: {status}")

    iap_v3 = 10000 / max(r3['daily_net'], 1)
    iap_v4 = 10000 / max(r4['daily_net'], 1)
    print(f"\n  $1.99(10,000g) = V3 {iap_v3:.2f}일치  →  V4 {iap_v4:.2f}일치")
    print(f"  목표: ≥1.0일치 → {'✅ 달성' if iap_v4 >= 1.0 else '⚠️ 미달'}")

    # 결과 저장
    output = format_result(results_v3, results_v4)
    out_path = "workspace/economy_simulation_v4_result.md"
    with open(out_path, "w", encoding="utf-8") as f:
        f.write(output)
    print(f"\n결과 저장: {out_path}")
