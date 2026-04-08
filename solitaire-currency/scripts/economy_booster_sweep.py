"""
부스터 사용률별 D30 영향 스윕
undo 4회 + wild_card 1회 기준 (한번 쓰면 이만큼 씀)
booster_use_rate: 0%, 10%, 20%, 30%, 50%
"""
import sys, os, copy
sys.path.insert(0, os.path.dirname(__file__))

import economy_simulator_v5 as sim
from economy_simulator_v5 import simulate_user, PARAMS_V4, USER_TYPES_V4

RATES = [0.0, 0.10, 0.20, 0.30, 0.50]

# 부스터 1게임 이론 비용 (Lv75 x1/x2 평균 배팅 1.5 기준)
UNDO_UCIR   = 0.20   # V4: 20% (V3 25%에서 인하)
WC_RATIO    = 0.65   # V4: 65% (V3 50%에서 인상)

def booster_cost_theory(entry, bet_mult, undo_n, wc_n):
    cost = 0
    for n in range(1, undo_n + 1):
        cost += entry * bet_mult * min(n * UNDO_UCIR, 1.50)
    cost += entry * bet_mult * WC_RATIO * wc_n
    return int(cost)

print("=" * 72)
print("부스터 사용률별 D30 시뮬레이션 (undo 4회 + wild_card 1회 기준)")
print("=" * 72)

# 단가 미리 출력
bet_mult = PARAMS_V4['bet_x1_ratio'] * 1.0 + PARAMS_V4['bet_x2_ratio'] * 2.0
print(f"\n배팅 평균 배수: x{bet_mult:.1f}  (x1×{PARAMS_V4['bet_x1_ratio']:.0%} + x2×{PARAMS_V4['bet_x2_ratio']:.0%})")
print()
print("부스터 사용 시 1게임 추가 싱크 (레벨별):")
for name, level, *_ in USER_TYPES_V4:
    entry = sim.get_entry_cost(level, PARAMS_V4['entry_tier_multiplier'])
    cost  = booster_cost_theory(entry, bet_mult, 4, 1)
    print(f"  {name:<18} Lv{level:<4} 입장료 {entry:,}g  → 부스터 {cost:,}g/판")

print()
print("=" * 72)
print(f"{'유저':<18} {'레벨':>4} ", end="")
for r in RATES:
    print(f"  {int(r*100):>3}%사용 D30", end="")
print()
print("-" * 72)

for name, level, games, idle_cols, ad_rate, win_rate in USER_TYPES_V4:
    print(f"  {name:<18} Lv{level:<4}", end="")
    for rate in RATES:
        p = copy.deepcopy(PARAMS_V4)
        p['booster_use_rate'] = rate
        p['undo_count_when_used'] = 4
        p['wildcard_count_when_used'] = 1
        p['undo_ucir'] = UNDO_UCIR
        p['wildcard_ratio'] = WC_RATIO
        r = simulate_user(name, level, games, idle_cols, ad_rate, win_rate,
                          p, runs=300, days=30)
        d30 = r['d30']
        print(f"  {d30:>+12,.0f}g", end="")
    print()

print()
print("=" * 72)
print("V3 D30 기준 (참고)")
print("-" * 72)
for r in sim.run_all(sim.PARAMS_V3, "V3", user_types=sim.USER_TYPES_V3):
    print(f"  {r['name']:<18} Lv{r['level']:<4}  V3 D30: {r['d30']:>+12,.0f}g  "
          f"(−60% 목표: {r['d30']*0.40:>+10,.0f}g)")
