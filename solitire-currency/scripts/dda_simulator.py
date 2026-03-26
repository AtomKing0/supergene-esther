#!/usr/bin/env python3
"""
DDA (Dynamic Difficulty Adjustment) Monte Carlo Simulator

Simulates the PST dynamic_level system to verify tier distribution
under various parameter configurations and player types.

Usage:
    python3 scripts/dda_simulator.py                          # v2 확정 파라미터
    python3 scripts/dda_simulator.py --hard-guarantee 10      # 파라미터 오버라이드
    python3 scripts/dda_simulator.py --players 5000 --levels 300
    python3 scripts/dda_simulator.py --player-type casual,hardcore
    python3 scripts/dda_simulator.py --params custom_params.json
    python3 scripts/dda_simulator.py --verbose                # 구간별 상세
"""

import argparse
import json
import math
import os
import random
import sys
from collections import defaultdict
from pathlib import Path

# ─── Tier IDs ───────────────────────────────────────────────

TIER_TUTORIAL = 1
TIER_NORMAL = 2
TIER_HARD = 3
TIER_SUPER_HARD = 4

TIER_NAMES = {
    TIER_TUTORIAL: "Tutorial",
    TIER_NORMAL: "Normal",
    TIER_HARD: "Hard",
    TIER_SUPER_HARD: "SuperHard",
}

# ─── v2 확정 파라미터 (2026-03-12 Go 판정) ──────────────────

V2_PARAMS = {
    "hard_cooldown": 3,
    "win_streak": 99,       # 사실상 비활성
    "sh_guarantee": 18,
    "hard_guarantee": 7,
    "fail_streak": 2,
    "fail_spiral_trigger": 5,
    "fail_spiral_normal": 5,
    "tutorial_level_min": 1,
    "tutorial_level_max": 8,
    "specific_level_min": 9,
    "specific_level_max": 10,
}

# ─── 구 파라미터 (workspace/06 기준) ────────────────────────

OLD_PARAMS = {
    "hard_cooldown": 5,
    "win_streak": 7,
    "sh_guarantee": 30,
    "hard_guarantee": 15,
    "fail_streak": 2,
    "fail_spiral_trigger": 0,  # 구버전에는 없음
    "fail_spiral_normal": 0,
    "tutorial_level_min": 1,
    "tutorial_level_max": 8,
    "specific_level_min": 9,
    "specific_level_max": 10,
}

# ─── 플레이어 유형별 승률 (workspace/09 기준) ────────────────

PLAYER_TYPES = {
    "casual": {
        "label": "Casual",
        "normal_wr": 0.70,
        "hard_wr": 0.40,
        "sh_wr": 0.20,
    },
    "average": {
        "label": "Average",
        "normal_wr": 0.80,
        "hard_wr": 0.55,
        "sh_wr": 0.35,
    },
    "hardcore": {
        "label": "Hardcore",
        "normal_wr": 0.92,
        "hard_wr": 0.75,
        "sh_wr": 0.55,
    },
    "struggling": {
        "label": "Struggling",
        "normal_wr": 0.60,
        "hard_wr": 0.30,
        "sh_wr": 0.15,
    },
    "improving": {
        "label": "Improving",
        "normal_wr_start": 0.65,
        "normal_wr_end": 0.85,
        "hard_wr_start": 0.40,
        "hard_wr_end": 0.65,
        "sh_wr_start": 0.20,
        "sh_wr_end": 0.45,
    },
    "streaky": {
        "label": "Streaky",
        "normal_wr": 0.80,
        "hard_wr": 0.55,
        "sh_wr": 0.35,
        "variance": 0.20,
    },
}


def get_win_rate(ptype_cfg, tier, level, max_level):
    """Return win probability for a given player type, tier, and level."""
    tier_key_map = {
        TIER_TUTORIAL: "tutorial",
        TIER_NORMAL: "normal",
        TIER_HARD: "hard",
        TIER_SUPER_HARD: "sh",
    }
    tier_key = tier_key_map.get(tier, "normal")

    if tier == TIER_TUTORIAL:
        return 0.98

    # Improving: linear interpolation over levels
    if f"{tier_key}_wr_start" in ptype_cfg:
        t = min(1.0, max(0.0, (level - 1) / max(1, max_level - 1)))
        start = ptype_cfg[f"{tier_key}_wr_start"]
        end = ptype_cfg[f"{tier_key}_wr_end"]
        return start + (end - start) * t

    base_wr = ptype_cfg.get(f"{tier_key}_wr", 0.80)

    # Streaky: oscillating pattern (sin wave over levels)
    if "variance" in ptype_cfg:
        v = ptype_cfg["variance"]
        # Period of ~20 levels, phase randomized per player (handled externally)
        offset = math.sin(level * 0.314)  # ~20 level period
        wr = base_wr + v * offset
        return max(0.05, min(0.99, wr))

    return base_wr


class PlayerState:
    """Tracks per-player DDA state."""

    __slots__ = (
        "level", "consecutive_wins", "consecutive_losses",
        "normal_since_hard", "normal_since_sh",
        "cooldown_remaining", "fail_spiral_remaining",
    )

    def __init__(self):
        self.level = 0
        self.consecutive_wins = 0
        self.consecutive_losses = 0
        self.normal_since_hard = 0    # resets on Hard or SH → hard_guarantee
        self.normal_since_sh = 0      # resets only on SH → sh_guarantee
        self.cooldown_remaining = 0   # hard_cooldown counter
        self.fail_spiral_remaining = 0  # fail_spiral Normal forced count


def evaluate_conditions(state, params):
    """
    Evaluate DDA conditions in priority order (P1→P99).
    Returns (tier_id, rule_name).
    """
    lv = state.level

    # P1: user_level_range (Tutorial)
    if params["tutorial_level_min"] <= lv <= params["tutorial_level_max"]:
        return TIER_TUTORIAL, "user_level_range"

    # P2: user_level_specific (lv 9-10 → Normal)
    if params["specific_level_min"] <= lv <= params["specific_level_max"]:
        return TIER_NORMAL, "user_level_specific"

    # P3: fail_spiral (5연패 → Normal 5판 강제)
    if params["fail_spiral_trigger"] > 0 and state.fail_spiral_remaining > 0:
        return TIER_NORMAL, "fail_spiral"

    if (params["fail_spiral_trigger"] > 0
            and state.consecutive_losses >= params["fail_spiral_trigger"]):
        state.fail_spiral_remaining = params["fail_spiral_normal"]
        return TIER_NORMAL, "fail_spiral"

    # P4: fail_streak (2연패 → Normal)
    if state.consecutive_losses >= params["fail_streak"]:
        return TIER_NORMAL, "fail_streak"

    # P5: hard_cooldown (Hard/SH 후 N레벨 Normal 강제)
    if state.cooldown_remaining > 0:
        return TIER_NORMAL, "hard_cooldown"

    # P6: win_streak (연승 → SH)
    if state.consecutive_wins >= params["win_streak"]:
        return TIER_SUPER_HARD, "win_streak"

    # P7: sh_guarantee (N판 Normal since last SH → SH)
    if state.normal_since_sh >= params["sh_guarantee"] and params["sh_guarantee"] > 0:
        return TIER_SUPER_HARD, "sh_guarantee"

    # P8: hard_guarantee (N판 Normal since last Hard/SH → Hard)
    if state.normal_since_hard >= params["hard_guarantee"] and params["hard_guarantee"] > 0:
        return TIER_HARD, "hard_guarantee"

    # P99: default
    return TIER_NORMAL, "default"


def simulate_player(params, ptype_cfg, max_level, rng):
    """Simulate one player through max_level levels. Returns per-level records."""
    state = PlayerState()
    records = []

    for lv in range(1, max_level + 1):
        state.level = lv

        # Evaluate DDA condition
        tier, rule = evaluate_conditions(state, params)

        # Determine win/loss
        wr = get_win_rate(ptype_cfg, tier, lv, max_level)
        won = rng.random() < wr

        records.append((lv, tier, rule, won))

        # ─── State update ─────────────────────────

        # Cooldown tracking
        if tier in (TIER_HARD, TIER_SUPER_HARD):
            state.cooldown_remaining = params["hard_cooldown"]
            state.normal_since_hard = 0
            if tier == TIER_SUPER_HARD:
                state.normal_since_sh = 0
        elif state.cooldown_remaining > 0:
            state.cooldown_remaining -= 1
            if tier == TIER_NORMAL:
                state.normal_since_hard += 1
                state.normal_since_sh += 1
        else:
            if tier == TIER_NORMAL:
                state.normal_since_hard += 1
                state.normal_since_sh += 1

        # fail_spiral countdown
        if state.fail_spiral_remaining > 0 and rule == "fail_spiral":
            state.fail_spiral_remaining -= 1

        # Win/loss streaks
        if won:
            state.consecutive_wins += 1
            state.consecutive_losses = 0
            state.fail_spiral_remaining = 0  # reset on any win
        else:
            state.consecutive_losses += 1
            state.consecutive_wins = 0

    return records


def run_simulation(params, player_types_cfg, num_players, max_level,
                   analysis_start=11, seed=None):
    """Run full Monte Carlo simulation. Returns results dict."""
    rng = random.Random(seed)

    results = {}
    for ptype_key, ptype_cfg in player_types_cfg.items():
        tier_counts = defaultdict(int)
        rule_counts = defaultdict(int)
        total_analyzed = 0
        fail_spiral_players = 0
        fail_spiral_total = 0

        for _ in range(num_players):
            records = simulate_player(params, ptype_cfg, max_level, rng)
            player_spiral = 0

            for lv, tier, rule, won in records:
                if lv < analysis_start:
                    continue
                tier_counts[tier] += 1
                rule_counts[rule] += 1
                total_analyzed += 1
                if rule == "fail_spiral":
                    player_spiral += 1

            if player_spiral > 0:
                fail_spiral_players += 1
            fail_spiral_total += player_spiral

        results[ptype_key] = {
            "label": ptype_cfg["label"],
            "tier_counts": dict(tier_counts),
            "rule_counts": dict(rule_counts),
            "total": total_analyzed,
            "fail_spiral_players": fail_spiral_players,
            "fail_spiral_total": fail_spiral_total,
            "num_players": num_players,
        }

    return results


def format_bar(pct, width=30):
    """Simple ASCII bar chart."""
    filled = int(pct / 100 * width)
    return "\u2588" * filled


def print_results(results, params, num_players, max_level, analysis_start,
                  verbose=False):
    """Pretty-print simulation results."""
    print()
    print("=" * 65)
    print(f"  DDA Simulation Results ({num_players:,} players x {max_level} levels)")
    print("=" * 65)

    # Parameters
    print()
    print("Parameters:")
    print(f"  hard_cooldown={params['hard_cooldown']}, "
          f"hard_guarantee={params['hard_guarantee']}, "
          f"sh_guarantee={params['sh_guarantee']}, "
          f"win_streak={params['win_streak']}")
    print(f"  fail_streak={params['fail_streak']}, "
          f"fail_spiral={params['fail_spiral_trigger']}/{params['fail_spiral_normal']}")
    print(f"  analysis_range=lv {analysis_start}-{max_level}")

    # Tier Distribution
    print()
    print("Tier Distribution (target: Normal 85% | Hard 10% | SH 5%):")
    print()
    header = f"  {'Type':<14}| {'Normal%':>8} | {'Hard%':>7} | {'SH%':>7} | {'Dev':>7}"
    print(header)
    print("  " + "-" * 14 + "|" + "-" * 10 + "|" + "-" * 9 + "|" + "-" * 9 + "|" + "-" * 8)

    for ptype_key, data in results.items():
        total = data["total"]
        if total == 0:
            continue
        n_pct = data["tier_counts"].get(TIER_NORMAL, 0) / total * 100
        h_pct = data["tier_counts"].get(TIER_HARD, 0) / total * 100
        sh_pct = data["tier_counts"].get(TIER_SUPER_HARD, 0) / total * 100

        # Max deviation from target
        dev = max(abs(n_pct - 85), abs(h_pct - 10), abs(sh_pct - 5))

        print(f"  {data['label']:<14}| {n_pct:>7.1f}% | {h_pct:>6.1f}% | {sh_pct:>6.1f}% | "
              f"\u00b1{dev:.1f}pp")

    print(f"  {'Target':<14}| {85.0:>7.1f}% | {10.0:>6.1f}% | {5.0:>6.1f}% |")

    # Rule Firing
    print()
    print("Rule Firing (all types combined):")
    print()

    combined_rules = defaultdict(int)
    combined_total = 0
    for data in results.values():
        for rule, count in data["rule_counts"].items():
            combined_rules[rule] += count
        combined_total += data["total"]

    rule_order = [
        "user_level_range", "user_level_specific", "fail_spiral",
        "fail_streak", "hard_cooldown", "win_streak",
        "sh_guarantee", "hard_guarantee", "default",
    ]

    for rule in rule_order:
        count = combined_rules.get(rule, 0)
        if count == 0 and rule in ("user_level_range", "user_level_specific"):
            continue  # skip tutorial rules in analysis range
        pct = count / combined_total * 100 if combined_total > 0 else 0
        bar = format_bar(pct)
        print(f"  {rule:<22} | {pct:>5.1f}% | {bar}")

    # fail_spiral detail
    print()
    print("fail_spiral Impact:")
    print()
    print(f"  {'Type':<14}| {'Experienced':>11} | {'Avg/Player':>11}")
    print("  " + "-" * 14 + "|" + "-" * 13 + "|" + "-" * 12)

    for ptype_key, data in results.items():
        n = data["num_players"]
        exp_pct = data["fail_spiral_players"] / n * 100
        avg = data["fail_spiral_total"] / n
        print(f"  {data['label']:<14}| {exp_pct:>10.1f}% | {avg:>10.2f}")

    print()

    # Verbose: per-segment breakdown
    if verbose:
        print_verbose(results, params, num_players, max_level, analysis_start)


def print_verbose(results, params, num_players, max_level, analysis_start):
    """Print per-segment tier distribution (requires re-simulation with segment tracking)."""
    print("-" * 65)
    print("  Segment Breakdown (re-running with segment tracking...)")
    print("-" * 65)

    # Quick re-simulation for segment data (use 'average' type)
    rng = random.Random(42)
    ptype_cfg = PLAYER_TYPES["average"]
    segments = {}
    seg_size = 20

    for start in range(analysis_start, max_level + 1, seg_size):
        end = min(start + seg_size - 1, max_level)
        segments[(start, end)] = defaultdict(int)

    for _ in range(num_players):
        records = simulate_player(params, ptype_cfg, max_level, rng)
        for lv, tier, rule, won in records:
            if lv < analysis_start:
                continue
            for (s, e), counts in segments.items():
                if s <= lv <= e:
                    counts[tier] += 1
                    break

    print()
    print(f"  {'Segment':<14}| {'Normal%':>8} | {'Hard%':>7} | {'SH%':>7}")
    print("  " + "-" * 14 + "|" + "-" * 10 + "|" + "-" * 9 + "|" + "-" * 8)

    for (s, e) in sorted(segments.keys()):
        counts = segments[(s, e)]
        total = sum(counts.values())
        if total == 0:
            continue
        n_pct = counts.get(TIER_NORMAL, 0) / total * 100
        h_pct = counts.get(TIER_HARD, 0) / total * 100
        sh_pct = counts.get(TIER_SUPER_HARD, 0) / total * 100
        print(f"  Lv{s:>3}-{e:<3}    | {n_pct:>7.1f}% | {h_pct:>6.1f}% | {sh_pct:>6.1f}%")

    print()


def load_params_from_json(filepath):
    """Load DDA parameters from a JSON file (PST_dynamic_level.json format)."""
    with open(filepath) as f:
        data = json.load(f)

    params = dict(V2_PARAMS)  # start with defaults

    for entry in data:
        ctype = entry.get("condition_type", "")
        p1 = entry.get("param_1", 0)
        p2 = entry.get("param_2", 0)

        if ctype == "user_level_range":
            params["tutorial_level_min"] = p1
            params["tutorial_level_max"] = p2
        elif ctype == "user_level_specific":
            params["specific_level_min"] = p1
            params["specific_level_max"] = p2
        elif ctype == "fail_spiral":
            params["fail_spiral_trigger"] = p1
            params["fail_spiral_normal"] = p2
        elif ctype == "fail_streak":
            params["fail_streak"] = p1
        elif ctype == "hard_cooldown":
            params["hard_cooldown"] = p1
        elif ctype == "win_streak":
            params["win_streak"] = p1
        elif ctype == "super_hard_guarantee":
            params["sh_guarantee"] = p1
        elif ctype == "hard_guarantee":
            params["hard_guarantee"] = p1

    return params


def main():
    parser = argparse.ArgumentParser(
        description="DDA Monte Carlo Simulator for PST dynamic_level system",
        formatter_class=argparse.RawDescriptionHelpFormatter,
        epilog="""
Examples:
  %(prog)s                                    # v2 확정 파라미터
  %(prog)s --hard-guarantee 10 --hard-cooldown 4
  %(prog)s --players 5000 --levels 300
  %(prog)s --player-type casual,hardcore
  %(prog)s --params reference/PST_dynamic_level.json
  %(prog)s --old-params                       # 구 파라미터로 실행
  %(prog)s --verbose                          # 구간별 상세
        """,
    )

    # Parameter overrides
    parser.add_argument("--hard-cooldown", type=int, help="Hard/SH 후 Normal 강제 레벨 수")
    parser.add_argument("--hard-guarantee", type=int, help="Normal 연속 N판 후 Hard 강제")
    parser.add_argument("--sh-guarantee", type=int, help="Normal 연속 N판 후 SH 강제")
    parser.add_argument("--win-streak", type=int, help="N연승 시 SH (99=비활성)")
    parser.add_argument("--fail-streak", type=int, help="N연패 시 Normal 강제")
    parser.add_argument("--fail-spiral-trigger", type=int, help="fail_spiral 발동 연패 수")
    parser.add_argument("--fail-spiral-normal", type=int, help="fail_spiral Normal 강제 판수")

    # Simulation config
    parser.add_argument("--players", type=int, default=1000, help="플레이어 수 (default: 1000)")
    parser.add_argument("--levels", type=int, default=200, help="최대 레벨 (default: 200)")
    parser.add_argument("--analysis-start", type=int, default=11, help="분석 시작 레벨 (default: 11)")
    parser.add_argument("--seed", type=int, default=None, help="난수 시드 (재현용)")

    # Player types
    parser.add_argument("--player-type", type=str, default=None,
                        help="쉼표 구분 유형: casual,average,hardcore,struggling,improving,streaky")

    # Parameter sources
    parser.add_argument("--params", type=str, default=None,
                        help="JSON 파라미터 파일 경로 (PST_dynamic_level.json 포맷)")
    parser.add_argument("--old-params", action="store_true",
                        help="구 파라미터로 실행 (workspace/06 기준)")

    # Output
    parser.add_argument("--verbose", action="store_true", help="구간별 상세 출력")
    parser.add_argument("--json", action="store_true", help="JSON 형식으로 출력")

    args = parser.parse_args()

    # ─── Build parameters ─────────────────────────

    if args.old_params:
        params = dict(OLD_PARAMS)
    elif args.params:
        params = load_params_from_json(args.params)
    else:
        params = dict(V2_PARAMS)

    # CLI overrides
    override_map = {
        "hard_cooldown": args.hard_cooldown,
        "hard_guarantee": args.hard_guarantee,
        "sh_guarantee": args.sh_guarantee,
        "win_streak": args.win_streak,
        "fail_streak": args.fail_streak,
        "fail_spiral_trigger": args.fail_spiral_trigger,
        "fail_spiral_normal": args.fail_spiral_normal,
    }
    for key, val in override_map.items():
        if val is not None:
            params[key] = val

    # ─── Select player types ─────────────────────

    if args.player_type:
        selected = [t.strip().lower() for t in args.player_type.split(",")]
        player_types_cfg = {}
        for t in selected:
            if t not in PLAYER_TYPES:
                print(f"Error: unknown player type '{t}'", file=sys.stderr)
                print(f"Available: {', '.join(PLAYER_TYPES.keys())}", file=sys.stderr)
                sys.exit(1)
            player_types_cfg[t] = PLAYER_TYPES[t]
    else:
        player_types_cfg = dict(PLAYER_TYPES)

    # ─── Run simulation ──────────────────────────

    results = run_simulation(
        params=params,
        player_types_cfg=player_types_cfg,
        num_players=args.players,
        max_level=args.levels,
        analysis_start=args.analysis_start,
        seed=args.seed,
    )

    # ─── Output ──────────────────────────────────

    if args.json:
        output = {
            "params": params,
            "config": {
                "players": args.players,
                "levels": args.levels,
                "analysis_start": args.analysis_start,
                "seed": args.seed,
            },
            "results": {},
        }
        for ptype_key, data in results.items():
            total = data["total"]
            output["results"][ptype_key] = {
                "label": data["label"],
                "normal_pct": round(data["tier_counts"].get(TIER_NORMAL, 0) / total * 100, 2) if total else 0,
                "hard_pct": round(data["tier_counts"].get(TIER_HARD, 0) / total * 100, 2) if total else 0,
                "sh_pct": round(data["tier_counts"].get(TIER_SUPER_HARD, 0) / total * 100, 2) if total else 0,
                "fail_spiral_avg": round(data["fail_spiral_total"] / data["num_players"], 2),
                "rule_counts": data["rule_counts"],
            }
        print(json.dumps(output, indent=2, ensure_ascii=False))
    else:
        print_results(results, params, args.players, args.levels,
                      args.analysis_start, verbose=args.verbose)


if __name__ == "__main__":
    main()
