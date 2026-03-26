#!/usr/bin/env python3
"""
Tripeaks simulator for converted (our game) format.

Key differences from CC format:
- Cards with isDrawCard=true are explicit draw deck cards
- randomCardCount = total draw deck size
- If randomCardCount > explicit draw cards, remaining are random
- Blocking: depth-based, position overlap (CARD_W=100, CARD_H=150)
"""

import json
import random
import sys
import os

CARD_W = 100
CARD_H = 150
OVERLAP_X = CARD_W / 2  # 50px overlap threshold
OVERLAP_Y = CARD_H / 2  # 75px overlap threshold


def parse_converted_map(filepath):
    """Parse a converted format JSON file."""
    with open(filepath, 'r') as f:
        data = json.load(f)

    map_str = data['stage']['map']
    cards = json.loads(map_str)
    random_card_count = data.get('randomCardCount', 0)

    tableau_cards = []
    draw_cards = []

    for c in cards:
        if c.get('isDrawCard'):
            draw_cards.append(c)
        else:
            tableau_cards.append(c)

    return tableau_cards, draw_cards, random_card_count


def cards_overlap(c1, c2):
    """Check if two cards overlap based on position and card size."""
    dx = abs(c1['position']['x'] - c2['position']['x'])
    dy = abs(c1['position']['y'] - c2['position']['y'])
    return dx < CARD_W and dy < CARD_H


def build_blocking_map(tableau_cards):
    """Build blocking relationships: higher depth cards block lower depth cards they overlap."""
    blocking = {}  # card_idx -> set of card_idx it blocks (prevents from being played)
    blocked_by = {}  # card_idx -> set of card_idx blocking it

    for i in range(len(tableau_cards)):
        blocking[i] = set()
        blocked_by[i] = set()

    for i in range(len(tableau_cards)):
        for j in range(len(tableau_cards)):
            if i == j:
                continue
            # Higher depth blocks lower depth if they overlap
            if tableau_cards[i]['depth'] > tableau_cards[j]['depth']:
                if cards_overlap(tableau_cards[i], tableau_cards[j]):
                    blocking[i].add(j)
                    blocked_by[j].add(i)

    return blocking, blocked_by


def simulate_game(tableau_cards, draw_cards, random_card_count, rng):
    """Simulate one game. Returns True if all tableau cards cleared."""
    n_tableau = len(tableau_cards)
    if n_tableau == 0:
        return True

    # Build blocking relationships
    blocking, blocked_by = build_blocking_map(tableau_cards)

    # Track which cards are removed
    removed = [False] * n_tableau

    # Build draw deck
    deck = []

    # Add explicit draw cards (with known values)
    for dc in draw_cards:
        if dc.get('random') or dc['value'] == 0:
            deck.append(rng.randint(1, 13))
        else:
            deck.append(dc['value'])

    # Fill remaining with random cards
    n_random_extra = max(0, random_card_count - len(draw_cards))
    for _ in range(n_random_extra):
        deck.append(rng.randint(1, 13))

    # Randomize tableau cards that have random=true
    card_values = []
    for c in tableau_cards:
        if c.get('random') or c['value'] == 0:
            card_values.append(rng.randint(1, 13))
        else:
            card_values.append(c['value'])

    # Active card starts as first draw card (or None)
    if not deck:
        return False

    active_value = deck.pop(0)
    total_removed = 0

    while True:
        # Find playable cards: not removed, not blocked
        made_move = False
        # Try to find a matching card (greedy: pick first match)
        # Better strategy: try all and pick one
        playable = []
        for i in range(n_tableau):
            if removed[i]:
                continue
            # Check if blocked
            is_blocked = False
            for blocker in blocked_by[i]:
                if not removed[blocker]:
                    is_blocked = True
                    break
            if is_blocked:
                continue

            # Check if matches (±1 with wrapping: K->A, A->K)
            v = card_values[i]
            if abs(v - active_value) == 1 or abs(v - active_value) == 12:
                playable.append(i)

        if playable:
            # Strategy: pick a random playable card
            chosen = rng.choice(playable)
            removed[chosen] = True
            active_value = card_values[chosen]
            total_removed += 1

            # Update blocking
            for blocked_idx in blocking[chosen]:
                blocked_by[blocked_idx].discard(chosen)

            if total_removed == n_tableau:
                return True
            continue

        # No match - draw from deck
        if deck:
            active_value = deck.pop(0)
        else:
            # No more draws, game over
            return False


def simulate_level(filepath, reps=1000, seed=42):
    """Simulate a level multiple times and return win rate."""
    tableau_cards, draw_cards, random_card_count = parse_converted_map(filepath)

    n_tableau = len(tableau_cards)
    n_draw_explicit = len(draw_cards)
    n_draw_total = random_card_count

    rng = random.Random(seed)
    wins = 0
    for _ in range(reps):
        if simulate_game(tableau_cards, draw_cards, random_card_count, rng):
            wins += 1

    win_rate = wins / reps * 100
    return {
        'file': os.path.basename(filepath),
        'tableau_cards': n_tableau,
        'draw_explicit': n_draw_explicit,
        'draw_total': n_draw_total,
        'win_rate': win_rate,
        'wins': wins,
        'reps': reps,
    }


if __name__ == '__main__':
    import argparse
    parser = argparse.ArgumentParser(description='Converted format tripeaks simulator')
    parser.add_argument('files', nargs='+', help='Converted format JSON files')
    parser.add_argument('--reps', type=int, default=1000, help='Repetitions per level')
    parser.add_argument('--seed', type=int, default=42, help='Random seed')
    args = parser.parse_args()

    print(f"Running {args.reps} reps per level...\n")
    print(f"{'File':<50} {'Tableau':>7} {'Draw':>5} {'WinRate':>8} {'Wins':>6}")
    print("-" * 80)

    for fpath in args.files:
        result = simulate_level(fpath, reps=args.reps, seed=args.seed)
        print(f"{result['file']:<50} {result['tableau_cards']:>7} {result['draw_total']:>5} {result['win_rate']:>7.1f}% {result['wins']:>6}")
