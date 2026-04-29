"""
A1안 매크로 경제 영향 검증 — v5 시뮬 baseline + streak_meter_gold 기여분 가산

목적:
  v5 시뮬레이터(전체 골드 source/sink)의 baseline 위에
  streak_meter_gold 변경분을 더해, 다음 매크로 KPI에 미치는 영향을 측정:
    - 일일 순소득 변화율
    - D30 잔액 (목표 ≤ 10,356g)
    - $1.99 IAP 가치 (목표 ≥ 1.0일치)
    - Source/Sink 균형 변동
"""

import sys
from pathlib import Path
import random

sys.path.insert(0, str(Path('/Users/estherpark/esther_solitaire/solitaire-esther-1/solitaire-currency/scripts')))

from economy_simulator_v5 import (
    PARAMS_V4, USER_TYPES_V4,
    simulate_user, get_entry_cost,
)
import json

REPO_ROOT = Path('/Users/estherpark/esther_solitaire/solitaire-esther-1')

# A1 적용 후 streak_meter_gold (라이브와 동일)
SMG_A1 = {
    (1, 2): 0,
    (3, 9): 60,
    (10, 24): 90,
    (25, 49): 105,
    (50, 99): 120,
    (100, 199): 130,
    (200, 349): 150,
    (350, 549): 170,
    (550, 799): 200,
    (800, 1099): 230,
    (1100, 1449): 270,
    (1450, 999999): 300,
}

# 변경 전 streak_meter_gold (백업 값)
SMG_BEFORE = {
    (1, 2): 0,
    (3, 9): 32,
    (10, 24): 48,
    (25, 49): 58,
    (50, 99): 64,
    (100, 199): 70,
    (200, 349): 80,
    (350, 549): 93,
    (550, 799): 109,
    (800, 1099): 125,
    (1100, 1449): 144,
    (1450, 999999): 160,
}


def get_smg(level, table):
    for (lo, hi), v in table.items():
        if lo <= level <= hi:
            return v
    return list(table.values())[-1]


# 가챠 풀 가중치 (workspace/balance_sheet/streak_reward.json 기반)
# 각 req_length 내 균등 가중 → gold tier_combo 트리거 확률
P_GOLD_AT_REQ = {4: 1/3, 5: 1/3, 6: 0.0}


def daily_streak_gold(level, games_per_day, win_rate, smg_table, runs=200, days=30):
    """30일 평균 일별 streak_meter_gold 수입 (시드 평균)."""
    smg = get_smg(level, smg_table)
    if smg == 0:
        return 0.0

    totals = []
    for seed in range(runs):
        rng = random.Random(seed * 7919 + level)
        streak = 0
        total = 0
        for _ in range(days * games_per_day):
            if rng.random() < win_rate:
                streak += 1
                for req in (4, 5, 6):
                    if streak == req and rng.random() < P_GOLD_AT_REQ[req]:
                        total += smg
            else:
                streak = 0
        totals.append(total)
    return (sum(totals) / runs) / days


def main():
    print("=" * 78)
    print("A1안 매크로 경제 영향 검증 — v5 baseline + streak_meter_gold 가산")
    print("=" * 78)
    print()

    # v5 baseline (PARAMS_V4 = 현재 라이브 가정)
    print("[v5 baseline 시뮬 실행 중 (V4 params)...]")
    baseline_results = []
    for spec in USER_TYPES_V4:
        name, level, games, idle_cols, ad_rate, win_rate = spec
        r = simulate_user(name, level, games, idle_cols, ad_rate, win_rate, PARAMS_V4, runs=200, days=30)
        baseline_results.append((spec, r))

    print()
    print("=" * 78)
    print("표 1. 유저 타입별 streak_meter_gold 일일 기여 (변경 전 vs A1)")
    print("=" * 78)
    print(f"{'유저':<18} {'레벨':>5} {'판수':>4} {'승률':>5} {'SMG(전)':>8} {'SMG(A1)':>8} {'일(전)':>7} {'일(A1)':>7} {'일Δ':>6} {'30일Δ':>8}")
    print("-" * 95)

    streak_impact = []
    for spec, _ in baseline_results:
        name, level, games, _, _, win_rate = spec
        smg_b = get_smg(level, SMG_BEFORE)
        smg_a = get_smg(level, SMG_A1)
        d_before = daily_streak_gold(level, games, win_rate, SMG_BEFORE)
        d_after = daily_streak_gold(level, games, win_rate, SMG_A1)
        delta = d_after - d_before
        m_delta = delta * 30
        streak_impact.append((name, d_before, d_after, delta, m_delta))
        print(f"  {name:<16} {level:>5} {games:>4} {win_rate:>5.0%} {smg_b:>8} {smg_a:>8} "
              f"{d_before:>+6.1f}g {d_after:>+6.1f}g {delta:>+5.1f}g {m_delta:>+7.0f}g")

    print()
    print("=" * 78)
    print("표 2. 매크로 KPI 영향 (baseline daily_net + streak Δ)")
    print("=" * 78)
    print(f"{'유저':<18} {'baseline':>10} {'+streakΔ':>10} {'신규순소득':>11} {'증가율':>7} {'D30(추정)':>11} {'IAP$1.99':>11}")
    print("-" * 95)

    iap_gold = 10000
    d30_target = 10356
    iap_target_days = 1.0

    for (spec, r), (name2, d_before, d_after, delta, m_delta) in zip(baseline_results, streak_impact):
        name = spec[0]
        baseline_net = r['daily_net']
        new_net = baseline_net + delta
        ratio = (new_net / baseline_net - 1) * 100 if baseline_net != 0 else 0
        # D30 추정: baseline d30 + streak 30일 누적
        d30_est = r['d30'] + m_delta
        # IAP 가치 일수
        iap_days = iap_gold / new_net if new_net > 0 else float('inf')
        iap_str = f"{iap_days:.1f}일" if iap_days < 999 else "∞"
        print(f"  {name:<16} {baseline_net:>+9,.0f}g {delta:>+9.1f}g {new_net:>+10,.0f}g "
              f"{ratio:>+6.1f}% {d30_est:>+10,.0f}g {iap_str:>10}")

    # 핵심 검증: 보통 유저 (Lv75 보통★)
    print()
    print("=" * 78)
    print("핵심 검증 — 보통(중반)★ Lv75 유저")
    print("=" * 78)
    spec_n = next(s for s in baseline_results if '보통' in s[0][0])
    spec, r = spec_n
    name, level, games, _, _, win_rate = spec
    d_before = daily_streak_gold(level, games, win_rate, SMG_BEFORE)
    d_after = daily_streak_gold(level, games, win_rate, SMG_A1)
    delta = d_after - d_before
    m_delta = delta * 30

    base_net = r['daily_net']
    new_net = base_net + delta
    base_d30 = r['d30']
    new_d30 = base_d30 + m_delta
    base_iap = iap_gold / base_net if base_net > 0 else float('inf')
    new_iap = iap_gold / new_net if new_net > 0 else float('inf')

    print(f"  baseline 일일 순소득          : {base_net:>+9,.0f}g")
    print(f"  streak_meter_gold 일일 기여   : 변경 전 {d_before:.1f}g → A1 {d_after:.1f}g  (Δ +{delta:.1f}g)")
    print(f"  신규 일일 순소득              : {new_net:>+9,.0f}g  (baseline 대비 +{(new_net/base_net-1)*100:.2f}%)")
    print()
    print(f"  D30 잔액 (baseline)           : {base_d30:>+9,.0f}g")
    print(f"  D30 잔액 (A1 적용 추정)       : {new_d30:>+9,.0f}g  (Δ +{m_delta:,.0f}g)")
    print(f"  D30 목표                      : ≤ {d30_target:,}g")
    print(f"  D30 판정                      : {'✅ PASS' if new_d30 <= d30_target else '❌ FAIL — 인플레 우려'}")
    print()
    print(f"  $1.99 IAP 가치 (baseline)     : {base_iap:.2f}일")
    print(f"  $1.99 IAP 가치 (A1)           : {new_iap:.2f}일")
    print(f"  $1.99 IAP 목표                : ≥ {iap_target_days}일")
    print(f"  IAP 판정                      : {'✅ PASS' if new_iap >= iap_target_days else '❌ FAIL — IAP 가치 침식'}")

    # Source 비중 분석
    print()
    print("=" * 78)
    print("Source 구성 변동 (보통★ Lv75)")
    print("=" * 78)
    print(f"{'항목':<16} {'baseline':>10} {'A1 적용':>10} {'기여 비중Δ':>10}")
    print("-" * 50)
    sources = [
        ("방치골드", r['daily_idle']),
        ("RV 합계", r['daily_inbox'] + r['daily_popup'] + r['daily_shop'] + r['daily_lobby']),
        ("데일리 휠", r['daily_wheel']),
        ("출석 보상", r['daily_gift']),
        ("게임플레이", r['daily_gameplay']),
        ("컬렉션", r['daily_collection']),
    ]
    base_total_source = sum(v for _, v in sources if v > 0)
    print(f"  {'streak SMG':<14} {d_before:>+9.1f}g {d_after:>+9.1f}g  (신규 추가 source)")
    for label, v in sources:
        print(f"  {label:<14} {v:>+9,.0f}g {v:>+9,.0f}g  (변화 없음)")
    new_total_source = base_total_source + d_after
    base_streak_pct = d_before / (base_total_source + d_before) * 100
    new_streak_pct = d_after / new_total_source * 100
    print()
    print(f"  baseline source 합계          : {base_total_source + d_before:>+9,.0f}g/일")
    print(f"  A1 적용 source 합계           : {new_total_source:>+9,.0f}g/일")
    print(f"  streak SMG 기여 비중 (변경 전): {base_streak_pct:.2f}%")
    print(f"  streak SMG 기여 비중 (A1)     : {new_streak_pct:.2f}%")

    # 헤비 유저 인플레 검증
    print()
    print("=" * 78)
    print("인플레 리스크 — 하드코어 유저 (Lv 300, 40판/일, 100% AD)")
    print("=" * 78)
    spec_h, r_h = next((s, r2) for (s, r2) in baseline_results if '하드코어' in s[0])
    name_h, level_h, games_h, _, _, wr_h = spec_h
    d_before_h = daily_streak_gold(level_h, games_h, wr_h, SMG_BEFORE)
    d_after_h = daily_streak_gold(level_h, games_h, wr_h, SMG_A1)
    delta_h = d_after_h - d_before_h
    new_d30_h = r_h['d30'] + delta_h * 30
    print(f"  baseline 일일 순소득          : {r_h['daily_net']:>+9,.0f}g")
    print(f"  streak SMG (변경 전 / A1)     : {d_before_h:.1f}g / {d_after_h:.1f}g  (Δ +{delta_h:.1f}g)")
    print(f"  D30 잔액 (baseline / A1)      : {r_h['d30']:>+9,.0f}g / {new_d30_h:>+9,.0f}g  (Δ +{delta_h*30:,.0f}g)")

    # 최종 판정
    print()
    print("=" * 78)
    print("최종 판정")
    print("=" * 78)
    pass_d30 = new_d30 <= d30_target
    pass_iap = new_iap >= iap_target_days
    pct_inflation = (new_net / base_net - 1) * 100
    print(f"  ✅ 보통(중반) D30 목표 유지   : {pass_d30}")
    print(f"  ✅ $1.99 IAP 가치 유지        : {pass_iap}")
    print(f"  ✅ 일일 순소득 변화율         : +{pct_inflation:.2f}% (5% 미만이면 통과)")
    print(f"  ✅ source 기여 비중 (streak)  : {new_streak_pct:.2f}% (5% 미만이면 안전)")
    print()
    overall = pass_d30 and pass_iap and pct_inflation < 5.0 and new_streak_pct < 5.0
    if overall:
        print("  → 🟢 매크로 영향 미미 (PASS) — A1 적용 후 경제 밸런스 유지됨")
    else:
        print("  → 🟡 추가 모니터링 권고")


if __name__ == "__main__":
    main()
