"""
부스터 파라미터 적정값 탐색
2D 스윕: bet_mult(배팅배수) × booster_use_rate(사용률)
undo 4회 + wild_card 1회 고정

목표: 보통★ D30 ≈ +98,937g (V3 × 40%)
      전 유저 D30 > 0
"""
import sys, os, copy
sys.path.insert(0, os.path.dirname(__file__))

import economy_simulator_v5 as sim
from economy_simulator_v5 import simulate_user, PARAMS_V4, USER_TYPES_V4

# ── 탐색 파라미터 ─────────────────────────────────────────────────
BET_MULTS = [
    (1.00, "x1전용  (x2=0%)"),
    (1.25, "x1주도  (x2=25%)"),
    (1.50, "반반    (x2=50%)"),
]
RATES = [0.10, 0.20, 0.30]
UNDO_N = 4
WC_N   = 1
UNDO_UCIR  = 0.20
WC_RATIO   = 0.65

V3_NORMAL_D30 = 247_343
TARGET_D30    = V3_NORMAL_D30 * 0.40   # +98,937g

# 보통★ 유저
NORMAL = next(u for u in USER_TYPES_V4 if '보통' in u[0])

print("=" * 76)
print("부스터 파라미터 2D 탐색  (undo 4회 + wild_card 1회 기준)")
print(f"목표 D30: {TARGET_D30:,.0f}g  (V3 보통★ × 40%)")
print("=" * 76)

# 1게임 부스터 단가 미리 출력
print("\n▶ bet_mult별 1게임 부스터 싱크 (Lv75 입장료 2,400g 기준)")
for bm, label in BET_MULTS:
    cost = sim.calc_booster_cost(2400, bm, UNDO_N, WC_N, UNDO_UCIR, WC_RATIO)
    print(f"  {label}  bet_mult={bm:.2f}  → {cost:,}g/판")

print()
print("=" * 76)
print("보통★ D30 (사용률 × 배팅배수)")
print(f"  {'':18}", end="")
for rate in RATES:
    print(f"  {int(rate*100):>3}%사용", end="")
print("   │ 판정 기준")
print("-" * 76)

results_all = []
for bm, label in BET_MULTS:
    print(f"  {label:<26}", end="")
    row = []
    for rate in RATES:
        p = copy.deepcopy(PARAMS_V4)
        p['bet_x1_ratio'] = 1.0 - (bm - 1.0)
        p['bet_x2_ratio'] = bm - 1.0
        p['booster_use_rate'] = rate
        p['undo_count_when_used'] = UNDO_N
        p['wildcard_count_when_used'] = WC_N
        p['undo_ucir'] = UNDO_UCIR
        p['wildcard_ratio'] = WC_RATIO
        name, level, games, idle_cols, ad_rate, win_rate = NORMAL
        r = simulate_user(name, level, games, idle_cols, ad_rate, win_rate,
                          p, runs=300, days=30)
        d30 = r['d30']
        row.append(d30)
        marker = "★" if abs(d30 - TARGET_D30) < 20_000 else " "
        print(f"  {d30:>+10,.0f}g{marker}", end="")
    print("   │")
    results_all.append((bm, label, row))

print()
print(f"  ★ = 목표 ±20,000g 범위 ({TARGET_D30-20000:,.0f}g ~ {TARGET_D30+20000:,.0f}g)")

# ── 전 유저 상세 (후보 조합) ─────────────────────────────────────
print()
print("=" * 76)
print("후보 조합 전 유저 D30")
print("=" * 76)

candidates = [
    (bm, label, rate)
    for bm, label, row in results_all
    for rate, d30 in zip(RATES, row)
    if abs(d30 - TARGET_D30) < 30_000
]

if not candidates:
    # 가장 근접한 것들
    best = []
    for bm, label, row in results_all:
        for rate, d30 in zip(RATES, row):
            best.append((abs(d30-TARGET_D30), bm, label, rate))
    best.sort()
    candidates = [(bm, label, rate) for _, bm, label, rate in best[:3]]

for bm, label, rate in candidates:
    p_base = copy.deepcopy(PARAMS_V4)
    p_base['bet_x1_ratio'] = 1.0 - (bm - 1.0)
    p_base['bet_x2_ratio'] = bm - 1.0
    p_base['booster_use_rate'] = rate
    p_base['undo_count_when_used'] = UNDO_N
    p_base['wildcard_count_when_used'] = WC_N
    p_base['undo_ucir'] = UNDO_UCIR
    p_base['wildcard_ratio'] = WC_RATIO

    print(f"\n  [{label}  사용률 {int(rate*100)}%]")
    print(f"  {'유저':<18} {'D30':>12}  {'V3대비':>8}")
    print(f"  {'-'*42}")
    all_pos = True
    for name, level, games, idle_cols, ad_rate, win_rate in USER_TYPES_V4:
        r = simulate_user(name, level, games, idle_cols, ad_rate, win_rate,
                          p_base, runs=300, days=30)
        v3 = sim.run_all(sim.PARAMS_V3, "V3", runs=100,
                         user_types=[(name, level, games, idle_cols, ad_rate, win_rate)])[0]['d30']
        pct = (1 - r['d30'] / v3) * 100 if v3 != 0 else 0
        flag = "" if r['d30'] >= 0 else " ❌"
        if r['d30'] < 0:
            all_pos = False
        print(f"  {name:<18} {r['d30']:>+12,.0f}g  {pct:>6.1f}%{flag}")
    print(f"  전 유저 플러스: {'✅' if all_pos else '❌'}")
