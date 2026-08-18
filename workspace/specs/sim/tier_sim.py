"""dynamic_level 티어 배정 시뮬레이터.
시트(PST_dynamic_level) 규칙 + ViewGame.getDynamicLevelInfosToUpsert 카운터 갱신을 그대로 옮김.
현행 vs 개선안(SPEC-039 재도전 재산정+1단계 하향, SPEC-041 연패 카운터 수정) 비교.
"""
import random

NORMAL, HARD, SH, TUT = 2, 3, 4, 1
CLEAR = {NORMAL: 0.972, HARD: 0.961, SH: 0.927}   # 실측 8/14~17
RETRY_P = 0.60                                     # 2223/2220 실측

def rules_for(level):
    """레벨 구간이 좁은 행이 이김. (priority, type, counter_key, param_1, param_2, result)"""
    hg = 5 if level < 100 else 4 if level < 350 else 3 if level < 800 else 2
    shg = 15 if level < 100 else 12 if level < 350 else 10 if level < 800 else 9
    return [
        (3, "fail_spiral",         30009, 5,   5, NORMAL),
        (4, "fail_streak",         30003, 2,   0, NORMAL),
        (5, "hard_cooldown",       30004, 1,   0, NORMAL),
        (6, "hard_guarantee",      30007, hg,  0, HARD),
        (7, "super_hard_guarantee",30006, shg, 0, SH),
    ]

def pick_tier(level, c, spiral_param2):
    for _, ctype, key, p1, p2, res in rules_for(level):
        v = c.get(key, 0)
        p2eff = spiral_param2 if ctype == "fail_spiral" else p2
        if p2eff == 0:
            if v >= p1: return res, ctype
        elif p1 <= v <= p2eff:
            return res, ctype
    return NORMAL, "default"

def entry_resets(tier, matched, c):
    if tier == SH: c[30006] = 0
    if tier >= HARD: c[30007] = 0
    if tier == NORMAL and matched == "fail_spiral": c[30006] = 0

def end_update(tier, win, c, improved):
    hard_or_above = tier >= HARD
    c[30005] = c.get(30005,0)+1 if win else 0
    if improved:
        c[30003] = 0 if win else c.get(30003,0)+1
        c[30009] = 0 if win else c.get(30009,0)+1
    else:
        c[30003] = 0 if win else (c.get(30003,0)+1 if not hard_or_above else c.get(30003,0))
        c[30009] = 0 if win else (c.get(30009,0)+1 if hard_or_above else c.get(30009,0))
    c[30004] = c.get(30004,0)+1 if hard_or_above else 0
    c[30006] = 0 if tier == SH else (c.get(30006,0)+1 if win else c.get(30006,0))
    c[30007] = 0 if hard_or_above else (c.get(30007,0)+1 if win else c.get(30007,0))

def run(level, skill, games, improved, seed, mode="full", counters=None):
    rng = random.Random(seed)
    c, out, relief = {}, {NORMAL:0, HARD:0, SH:0}, 0
    rout = {NORMAL:0, HARD:0, SH:0}
    counters = improved if counters is None else counters
    spiral_p2 = 0 if counters else 5
    prev_tier = None
    retry_pending = False
    for _ in range(games):
        if retry_pending:
            if improved:
                t, m = pick_tier(level, c, spiral_p2)
                if mode == "full":
                    t = HARD if t == SH else NORMAL      # 한 단계 하향(하한 Normal)
                m = "retry_relief"
            else:
                t, m = prev_tier, "retry_inherit"        # 현행: 티어 승계
        else:
            t, m = pick_tier(level, c, spiral_p2)
        entry_resets(t, m, c)
        out[t] += 1
        if retry_pending: rout[t] += 1
        if m in ("fail_streak","fail_spiral","retry_relief"): relief += 1
        fail_p = (1 - CLEAR[t]) * skill
        win = rng.random() > fail_p
        end_update(t, win, c, counters)
        prev_tier = t
        retry_pending = (not win) and (rng.random() < RETRY_P)
    n = sum(out.values()); rn = max(sum(rout.values()), 1)
    return ({k: round(100*v/n, 1) for k, v in out.items()}
            | {"relief": round(100*relief/n, 1),
               "retry_hardplus": round(100*(rout[HARD]+rout[SH])/rn, 1),
               "retry_n": sum(rout.values())})

PERSONAS = [
    ("신규 · 레벨 50",   50,  1.0),
    ("중급 · 레벨 200",  200, 1.0),
    ("숙련 · 레벨 500",  500, 0.5),
    ("고전 · 레벨 500",  500, 3.0),
    ("헤비 · 레벨 900",  900, 1.0),
]
GAMES, TRIALS = 4000, 40
print(f"{'persona':<16}{'mode':<24}{'Normal':>8}{'Hard':>8}{'SH':>8}{'relief':>8}{'retryH+':>9}")
RESULT = {}
MODES = [(False,"full",None,"현행"),
         (True,"recalc",False,"재산정만(카운터 현행)"),
         (True,"recalc",True,"재산정+카운터수정")]
for name, lv, sk in PERSONAS:
    for improved, mode, cnt, tag in MODES:
        agg = {NORMAL:0.0, HARD:0.0, SH:0.0, "relief":0.0, "retry_hardplus":0.0}
        for s in range(TRIALS):
            r = run(lv, sk, GAMES, improved, seed=1000+s, mode=mode, counters=cnt)
            for k in agg: agg[k] += r[k]
        agg = {k: round(v/TRIALS, 1) for k, v in agg.items()}
        RESULT[(name, tag)] = agg
        print(f"{name:<16}{tag:<24}{agg[NORMAL]:>8}{agg[HARD]:>8}{agg[SH]:>8}{agg['relief']:>8}{agg['retry_hardplus']:>9}")
import json
json.dump({f"{n}|{t}": v for (n,t),v in RESULT.items()},
          open('/tmp/tier_sim.json','w'), ensure_ascii=False)
