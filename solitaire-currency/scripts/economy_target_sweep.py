"""
D30 목표 −60% 달성 파라미터 탐색 (rv_gold_ratio 기반)
목표: D30 보통★ ≈ 111,349g (V3 278,373g × 40%)
rv_gold_ratio(Lv50-99) 단독 탐색 — collection_sink=0 확정
"""
import sys, os
sys.path.insert(0, os.path.dirname(__file__))

from economy_simulator_v5 import (
    simulate_user, PARAMS_V4, USER_TYPES,
    RV_RATIO_TABLE, get_entry_cost
)
import copy

V3_NORMAL_D30 = 278_373
TARGET_D30    = V3_NORMAL_D30 * 0.40   # −60% = 40% of V3
TOLERANCE     = 5_000                  # ±5K

NORMAL_USER = next(u for u in USER_TYPES if '보통' in u[0])

print(f"V3 보통★ D30 : {V3_NORMAL_D30:>10,.0f}g")
print(f"목표 D30 (−60%): {TARGET_D30:>10,.0f}g  (±{TOLERANCE:,}g)")
print()

# ── Lv50-99 기준 입장료 ────────────────────────────────────────────
# entry_cost base = 2,000g, V4 multiplier 1.2 → 2,400g
lv75_entry = get_entry_cost(75, 1.2)
print(f"Lv75 입장료 (V4): {lv75_entry:,}g")
print()

# ── 탐색 그리드: rv_gold_ratio(Lv50-99) ──────────────────────────
candidates = []

for ratio in range(500, 4900, 100):
    # RV_RATIO_TABLE 복사 후 Lv50-99 구간만 교체
    custom_ratio_table = []
    for lo, hi, r in RV_RATIO_TABLE:
        if lo == 50 and hi == 99:
            custom_ratio_table.append((lo, hi, ratio))
        else:
            custom_ratio_table.append((lo, hi, r))

    # economy_simulator_v5의 RV_RATIO_TABLE을 monkey-patch
    import economy_simulator_v5 as sim
    orig_table = sim.RV_RATIO_TABLE
    sim.RV_RATIO_TABLE = custom_ratio_table

    p = copy.deepcopy(PARAMS_V4)
    name, level, games, idle_cols, ad_rate, win_rate = NORMAL_USER
    r_result = simulate_user(name, level, games, idle_cols, ad_rate, win_rate,
                             p, runs=200, days=30)

    sim.RV_RATIO_TABLE = orig_table  # 복원

    d30 = r_result['d30']
    gap = abs(d30 - TARGET_D30)
    rv_gold = lv75_entry * ratio // 10000

    if gap < TOLERANCE * 4:
        candidates.append({
            'ratio':     ratio,
            'rv_gold':   rv_gold,
            'd30':       d30,
            'daily_net': r_result['daily_net'],
            'gap':       gap,
        })

# ── 결과 정렬 ────────────────────────────────────────────────────
candidates.sort(key=lambda x: x['gap'])
best = candidates[:10]

print(f"{'ratio':>7} {'rv_gold':>8} {'D30':>12} {'daily_net':>11} {'V3 대비':>8} {'gap':>8}")
print("-" * 64)
for c in best:
    ratio_pct = (1 - c['d30'] / V3_NORMAL_D30) * 100
    marker = " ★" if c['gap'] == min(x['gap'] for x in best) else ""
    print(f"  {c['ratio']:>5,}  {c['rv_gold']:>7,}g  {c['d30']:>11,.0f}g "
          f"{c['daily_net']:>+10,.0f}g  {ratio_pct:>6.1f}%  ±{c['gap']:>6,.0f}{marker}")

if best:
    b = best[0]
    pct = b['ratio'] / 100
    print()
    print("=" * 64)
    print(f"최적 rv_gold_ratio (Lv50-99): {b['ratio']:,}  ({pct:.0f}%)")
    print(f"  watch당 골드: {b['rv_gold']:,}g  (입장료 {lv75_entry:,}g × {pct:.0f}%)")
    print(f"  D30 보통★: {b['d30']:,.0f}g  (목표: {TARGET_D30:,.0f}g)")
    print(f"  일일 순소득: {b['daily_net']:+,.0f}g")
    print(f"  V3 대비: {(1-b['d30']/V3_NORMAL_D30)*100:.1f}% 감소")
    print("=" * 64)
