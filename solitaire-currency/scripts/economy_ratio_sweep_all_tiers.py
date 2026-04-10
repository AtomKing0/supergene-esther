"""
전 구간 rv_gold_ratio 독립 탐색
목표: 각 유저 타입 D30 = V3 × 40% (−60%)
각 레벨 구간의 ratio를 개별 탐색 (나머지 구간은 V4 기본값 유지)
"""
import sys, os, copy
sys.path.insert(0, os.path.dirname(__file__))

import economy_simulator_v5 as sim
from economy_simulator_v5 import simulate_user, PARAMS_V4, USER_TYPES, get_entry_cost

# ── V3 D30 기준값 (시뮬레이션 결과 고정) ─────────────────────────
V3_D30 = {
    5:   65_844,
    15:  186_226,
    75:  278_373,
    200: 235_590,
    300: 600_158,
}

# ── 구간별 대표 유저 매핑 ─────────────────────────────────────────
# 티어 lo → (유저명, level, games, idle_cols, ad_rate, win_rate)
TIER_USERS = {
    3:   next(u for u in USER_TYPES if u[1] == 5),     # 극소극 Lv5
    10:  next(u for u in USER_TYPES if u[1] == 15),    # 소극 Lv15
    50:  next(u for u in USER_TYPES if '보통' in u[0]), # 보통★ Lv75
    200: next(u for u in USER_TYPES if '헌신' in u[0]), # 헌신 Lv200
}

# ── 탐색 함수 ─────────────────────────────────────────────────────
def sweep_tier(tier_lo: int, tier_hi: int, user_tuple: tuple,
               v3_d30: float, runs: int = 200) -> dict:
    name, level, games, idle_cols, ad_rate, win_rate = user_tuple
    target = v3_d30 * 0.40
    entry  = get_entry_cost(level, 1.2)

    best = None
    print(f"\n  [{tier_lo}-{tier_hi}] 대표유저: {name} Lv{level}  "
          f"입장료: {entry:,}g  목표D30: {target:,.0f}g")
    print(f"  {'ratio':>7} {'rv_g':>6} {'D30':>12} {'V3대비':>8}")

    for ratio in range(500, 6600, 100):
        # 이 구간만 ratio 교체, 나머지 V4 기본값
        custom = []
        for lo, hi, r in sim.RV_RATIO_TABLE:
            if lo == tier_lo and hi == tier_hi:
                custom.append((lo, hi, ratio))
            else:
                custom.append((lo, hi, r))

        orig = sim.RV_RATIO_TABLE
        sim.RV_RATIO_TABLE = custom

        p = copy.deepcopy(PARAMS_V4)
        res = simulate_user(name, level, games, idle_cols, ad_rate, win_rate,
                            p, runs=runs, days=30)
        sim.RV_RATIO_TABLE = orig

        d30 = res['d30']
        gap = abs(d30 - target)
        rv_g = entry * ratio // 10000

        if best is None or gap < best['gap']:
            best = {
                'tier': f"{tier_lo}-{tier_hi}",
                'ratio': ratio,
                'rv_gold': rv_g,
                'd30': d30,
                'daily_net': res['daily_net'],
                'gap': gap,
                'target': target,
                'v3_d30': v3_d30,
            }

    return best


# ── 메인 탐색 ────────────────────────────────────────────────────
print("=" * 70)
print("전 구간 rv_gold_ratio 독립 최적화")
print("=" * 70)

# 직접 유저 타입이 있는 구간
TIERS_DIRECT = [
    (3,   9,   TIER_USERS[3],   V3_D30[5]),
    (10,  24,  TIER_USERS[10],  V3_D30[15]),
    (50,  99,  TIER_USERS[50],  V3_D30[75]),
    (200, 349, TIER_USERS[200], V3_D30[200]),
]

results = []
for lo, hi, user, v3d30 in TIERS_DIRECT:
    b = sweep_tier(lo, hi, user, v3d30)
    results.append(b)

# ── 요약 출력 ────────────────────────────────────────────────────
print()
print("=" * 70)
print("최적 rv_gold_ratio 요약")
print("=" * 70)
print(f"  {'구간':<12} {'현재ratio':>10} {'최적ratio':>10} {'rv_gold':>8} "
      f"{'D30':>12} {'V3대비':>8}")
print("-" * 70)

V4_DEFAULT_RATIO = {3: 6500, 10: 5500, 50: 4800, 200: 4200}
for b in results:
    lo = int(b['tier'].split('-')[0])
    cur = V4_DEFAULT_RATIO.get(lo, '—')
    vr  = (1 - b['d30'] / b['v3_d30']) * 100
    entry_str = get_entry_cost(
        {'3': 5, '10': 15, '50': 75, '200': 200}[str(lo)], 1.2
    )
    print(f"  Lv{b['tier']:<10} {cur:>10,}  {b['ratio']:>10,}  "
          f"{b['rv_gold']:>7,}g  {b['d30']:>11,.0f}g  {vr:>6.1f}%  "
          f"±{b['gap']:>5,.0f}")

print()
print("  ※ 유저 타입 미존재 구간 (Lv25-49, Lv100-199, Lv350+)")
print("    → 인접 구간 최적값 기준 선형 보간 권장")
print()

# ── 보간 제안 ────────────────────────────────────────────────────
r_map = {int(b['tier'].split('-')[0]): b['ratio'] for b in results}

def interp(lo_key, hi_key, weight=0.5):
    return int(r_map.get(lo_key, 0) * (1-weight) + r_map.get(hi_key, 0) * weight)

tier_25_49  = interp(10, 50, 0.5)
tier_100    = interp(50, 200, 0.5)
tier_350    = r_map.get(200, 4200)  # 200+ 구간과 동일하게

print("  보간 제안:")
print(f"    Lv25-49:   {tier_25_49:,}  (Lv10-24·Lv50-99 중간)")
print(f"    Lv100-199: {tier_100:,}  (Lv50-99·Lv200-349 중간)")
print(f"    Lv350+:    {tier_350:,}  (Lv200-349 기준)")

print()
print("=" * 70)
print("제안 rv_gold_ratio 테이블")
print("=" * 70)
proposed = [
    (1,   2,    0),
    (3,   9,    r_map.get(3, 6500)),
    (10,  24,   r_map.get(10, 5500)),
    (25,  49,   tier_25_49),
    (50,  99,   r_map.get(50, 4800)),
    (100, 199,  tier_100),
    (200, 349,  r_map.get(200, 4200)),
    (350, 549,  tier_350),
    (550, 799,  tier_350),
    (800, 1099, tier_350),
    (1100,1449, tier_350),
    (1450,9999, tier_350),
]
print(f"  {'레벨 구간':<14} {'현재':>8} {'제안':>8}  {'rv_gold(Lv중간)':>16}")
for lo, hi, r_new in proposed:
    r_old = dict([(lo2, r2) for lo2, hi2, r2 in sim.RV_RATIO_TABLE]).get(lo, r_new)
    mid_lv = (lo + hi) // 2 if hi < 9999 else lo
    entry_mid = get_entry_cost(mid_lv, 1.2)
    rv_g_new = entry_mid * r_new // 10000
    print(f"  Lv{lo:<5}-{hi:<6}  {r_old:>8,}  {r_new:>8,}  {rv_g_new:>8,}g/watch")
