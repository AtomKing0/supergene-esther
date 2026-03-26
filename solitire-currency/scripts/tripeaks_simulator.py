"""
Tripeaks Solitaire Simulator
Reads level data extracted from PST APK and simulates games to calculate win rates.

Usage:
    python3 scripts/tripeaks_simulator.py                    # Run sample levels
    python3 scripts/tripeaks_simulator.py --all              # Run all levels
    python3 scripts/tripeaks_simulator.py --level 1324973    # Run specific level
    python3 scripts/tripeaks_simulator.py --difficulty 4     # Run all difficulty 4
    python3 scripts/tripeaks_simulator.py --reps 1000        # Custom repetitions
"""

import json
import os
import glob
import random
import argparse
from dataclasses import dataclass, field
from typing import Optional
from collections import Counter

# Card type constants (inferred from data)
CARD_TYPE_NORMAL = 0
CARD_TYPE_FROZEN = 5        # Ice/frozen - needs extra hit
CARD_TYPE_LOCKED = 7        # Locked card
CARD_TYPE_VINE = 10         # Vine wrapped
CARD_TYPE_HONEY = 11        # Honey/sticky
CARD_TYPE_FACE_UP = 12      # Always face up
CARD_TYPE_CHAIN = 13        # Chained
CARD_TYPE_COBWEB = 16       # Cobweb
CARD_TYPE_LOCK2 = 17        # Double lock
CARD_TYPE_RIBBON = 19       # Ribbon wrapped
CARD_TYPE_GOLD = 21         # Gold card
CARD_TYPE_SHELL = 22        # Shell card
CARD_TYPE_BARNACLE = 23     # Barnacle
CARD_TYPE_SEAWEED = 24      # Seaweed
CARD_TYPE_BUBBLE = 26       # Bubble
CARD_TYPE_SAND = 27         # Sand covered
CARD_TYPE_CORAL = 28        # Coral
CARD_TYPE_CRYSTAL = 31      # Crystal

# Gimmick cards that need 1 extra match to clear
SINGLE_LAYER_GIMMICKS = {
    CARD_TYPE_FROZEN, CARD_TYPE_VINE, CARD_TYPE_HONEY,
    CARD_TYPE_CHAIN, CARD_TYPE_COBWEB, CARD_TYPE_RIBBON,
    CARD_TYPE_GOLD, CARD_TYPE_SHELL, CARD_TYPE_BARNACLE,
    CARD_TYPE_SEAWEED, CARD_TYPE_BUBBLE, CARD_TYPE_SAND,
    CARD_TYPE_CORAL, CARD_TYPE_CRYSTAL
}

# Gimmick cards that need 2 extra matches
DOUBLE_LAYER_GIMMICKS = {
    CARD_TYPE_LOCKED, CARD_TYPE_LOCK2
}

RANKS = 13  # A=1 through K=13
SUITS = 4


@dataclass
class Card:
    id: int
    x: float
    z: float
    layer: int
    card_type: int
    rank: int = 0       # 0 = not assigned yet (shuffled at game start)
    suit: int = 0
    force_face_up: bool = False
    gimmick_hits: int = 0  # remaining hits to remove gimmick
    removed: bool = False

    def is_playable(self, cards: list['Card']) -> bool:
        """Card is playable if no higher-layer card overlaps it."""
        if self.removed:
            return False
        for other in cards:
            if other.removed or other.id == self.id:
                continue
            if other.layer > self.layer:
                if self._overlaps(other):
                    return False
        return True

    def _overlaps(self, other: 'Card') -> bool:
        """Check if another card (higher layer) blocks this card.
        Based on actual data analysis of card spacing:
        - Adjacent-layer median X gap: 5.2, Z gap: 4.4
        - Cards overlap when both X and Z are within card half-dimensions
        - Card visual size is ~7.75 x 5.5 units
        """
        CARD_HALF_W = 6.0  # x-axis: generous to catch diagonal overlaps
        CARD_HALF_H = 5.0  # z-axis
        return (abs(self.x - other.x) < CARD_HALF_W and
                abs(self.z - other.z) < CARD_HALF_H)

    def matches(self, rank: int) -> bool:
        """Tripeaks rule: card matches if rank differs by ±1 (wrapping K->A, A->K)."""
        if self.rank == 0:
            return False
        diff = abs(self.rank - rank)
        return diff == 1 or diff == RANKS - 1  # wrap around


@dataclass
class GameState:
    tableau: list[Card]
    stockpile: list[int]  # list of ranks
    waste_rank: int        # current top of waste pile
    stock_index: int = 0   # current position in stockpile
    moves: int = 0

    def get_playable_cards(self) -> list[Card]:
        return [c for c in self.tableau if not c.removed and c.is_playable(self.tableau)]

    def is_won(self) -> bool:
        return all(c.removed for c in self.tableau)

    def is_stuck(self) -> bool:
        playable = self.get_playable_cards()
        matching = [c for c in playable if c.matches(self.waste_rank)]
        if matching:
            return False
        # Can we draw from stockpile?
        return self.stock_index >= len(self.stockpile)


def load_level(filepath: str) -> dict:
    with open(filepath) as f:
        return json.load(f)


def create_cards_from_level(level_data: dict) -> list[Card]:
    """Create Card objects from level tableau data."""
    cards = []
    for entry in level_data.get("Tableau", []):
        pos = entry.get("Position", {})
        defn = entry.get("Definition", {})
        card = Card(
            id=entry.get("Id", len(cards)),
            x=pos.get("x", 0),
            z=pos.get("z", 0),
            layer=entry.get("Layer", 0),
            card_type=defn.get("type", 0),
            force_face_up=bool(defn.get("forceFaceUp", 0)),
        )
        # Set gimmick hits
        if card.card_type in DOUBLE_LAYER_GIMMICKS:
            card.gimmick_hits = 2
        elif card.card_type in SINGLE_LAYER_GIMMICKS:
            card.gimmick_hits = 1
        cards.append(card)
    return cards


def assign_ranks(cards: list[Card], rng: random.Random) -> None:
    """Randomly assign ranks and suits to tableau cards."""
    for card in cards:
        card.rank = rng.randint(1, RANKS)
        card.suit = rng.randint(0, SUITS - 1)


def create_stockpile(count: int, rng: random.Random) -> list[int]:
    """Create a stockpile of random card ranks."""
    return [rng.randint(1, RANKS) for _ in range(count)]


def simulate_game(level_data: dict, rng: random.Random, strategy: str = "greedy") -> bool:
    """
    Simulate one game of Tripeaks.
    Returns True if won, False if lost.

    Uses a proper deck: shuffle a full deck, deal tableau cards from it,
    remainder becomes stockpile. StockPileCount from data is used as the
    actual stockpile size (the game limits how many cards you can draw).

    Strategy:
        - "greedy": always play a matching card (prefer higher layers first)
        - "random": randomly pick among matching playable cards
    """
    cards = create_cards_from_level(level_data)
    if not cards:
        return True  # empty level = win

    tableau_size = len(cards)

    # Build a full deck (may need multiple decks for large tableaus)
    deck_count = (tableau_size // 52) + 2  # enough cards
    full_deck = []
    for _ in range(deck_count):
        for suit in range(SUITS):
            for rank in range(1, RANKS + 1):
                full_deck.append((rank, suit))
    rng.shuffle(full_deck)

    # Deal to tableau
    for i, card in enumerate(cards):
        card.rank = full_deck[i][0]
        card.suit = full_deck[i][1]

    # Stockpile = limited by StockPileCount from data
    stock_count = level_data.get("StockPileCount", 5)
    remaining = full_deck[tableau_size:]
    stockpile = [r for r, s in remaining[:stock_count]]

    # First card on waste (deal one from stockpile)
    if stockpile:
        waste_rank = stockpile[0]
        stock_idx = 1
    else:
        waste_rank = rng.randint(1, RANKS)
        stock_idx = 0

    state = GameState(
        tableau=cards,
        stockpile=stockpile,
        waste_rank=waste_rank,
        stock_index=stock_idx,
    )

    max_moves = 500  # safety limit
    while state.moves < max_moves:
        if state.is_won():
            return True

        playable = state.get_playable_cards()
        matching = [c for c in playable if c.matches(state.waste_rank)]

        if matching:
            # Pick card to play
            if strategy == "greedy":
                # Prefer higher layer cards (they block others)
                matching.sort(key=lambda c: -c.layer)
                chosen = matching[0]
            else:
                chosen = rng.choice(matching)

            # Handle gimmick
            if chosen.gimmick_hits > 0:
                chosen.gimmick_hits -= 1
                # Gimmick removed but card stays (just remove gimmick layer)
                if chosen.gimmick_hits > 0:
                    state.waste_rank = chosen.rank  # still counts as a play
                    state.moves += 1
                    continue

            state.waste_rank = chosen.rank
            chosen.removed = True
            state.moves += 1

        elif state.stock_index < len(state.stockpile):
            # Draw from stockpile
            state.waste_rank = state.stockpile[state.stock_index]
            state.stock_index += 1
            state.moves += 1

        else:
            # No moves, no stock = lose
            return False

    return state.is_won()


def simulate_level(level_data: dict, reps: int = 500, strategy: str = "greedy") -> dict:
    """Run multiple simulations of a level and return stats."""
    wins = 0
    for i in range(reps):
        rng = random.Random(i)  # deterministic seed per iteration
        if simulate_game(level_data, rng, strategy):
            wins += 1

    name = level_data.get("m_Name", "unknown")
    difficulty = level_data.get("Difficulty", -1)
    tableau_size = len(level_data.get("Tableau", []))
    stock_count = level_data.get("StockPileCount", 0)

    return {
        "name": name,
        "unique_id": level_data.get("uniqueId", ""),
        "difficulty": difficulty,
        "tableau_size": tableau_size,
        "stock_count": stock_count,
        "reps": reps,
        "wins": wins,
        "win_rate": wins / reps if reps > 0 else 0,
    }


def main():
    parser = argparse.ArgumentParser(description="Tripeaks Solitaire Simulator")
    parser.add_argument("--all", action="store_true", help="Run all levels")
    parser.add_argument("--level", type=str, help="Run specific level by name/uniqueId")
    parser.add_argument("--difficulty", type=int, help="Run all levels of specific difficulty")
    parser.add_argument("--reps", type=int, default=500, help="Simulations per level")
    parser.add_argument("--strategy", default="greedy", choices=["greedy", "random"])
    parser.add_argument("--sample", type=int, default=10, help="Sample N levels per difficulty")
    args = parser.parse_args()

    level_dir = os.path.join(os.path.dirname(__file__), "..", "extracted_levels")
    files = sorted(glob.glob(os.path.join(level_dir, "*.json")))

    if not files:
        print(f"No level files found in {level_dir}")
        return

    print(f"Found {len(files)} levels")

    # Filter levels
    if args.level:
        files = [f for f in files if args.level in os.path.basename(f)]
        if not files:
            print(f"Level '{args.level}' not found")
            return
    elif args.difficulty is not None:
        filtered = []
        for f in files:
            with open(f) as fp:
                d = json.load(fp)
            if d.get("Difficulty") == args.difficulty:
                filtered.append(f)
        files = filtered
        print(f"Filtered to {len(files)} levels with difficulty {args.difficulty}")
    elif not args.all:
        # Sample mode: pick N levels per difficulty
        by_diff = {}
        for f in files:
            with open(f) as fp:
                d = json.load(fp)
            diff = d.get("Difficulty", -1)
            by_diff.setdefault(diff, []).append(f)

        sampled = []
        for diff in sorted(by_diff.keys()):
            lvls = by_diff[diff]
            rng = random.Random(42)
            sample = rng.sample(lvls, min(args.sample, len(lvls)))
            sampled.extend(sample)
        files = sampled
        print(f"Sampled {len(files)} levels ({args.sample} per difficulty)")

    # Run simulations
    results = []
    for i, f in enumerate(files):
        level_data = load_level(f)
        result = simulate_level(level_data, reps=args.reps, strategy=args.strategy)
        results.append(result)
        print(f"[{i+1}/{len(files)}] {result['name']}: "
              f"Diff={result['difficulty']}, Cards={result['tableau_size']}, "
              f"Stock={result['stock_count']}, "
              f"WinRate={result['win_rate']:.1%}")

    # Summary by difficulty
    print("\n" + "=" * 60)
    print("SUMMARY BY DIFFICULTY")
    print("=" * 60)
    by_diff = {}
    for r in results:
        by_diff.setdefault(r["difficulty"], []).append(r["win_rate"])

    for diff in sorted(by_diff.keys()):
        rates = by_diff[diff]
        avg = sum(rates) / len(rates)
        min_r = min(rates)
        max_r = max(rates)
        print(f"  Difficulty {diff}: avg={avg:.1%}, min={min_r:.1%}, max={max_r:.1%}, n={len(rates)}")

    # Save results
    output_path = os.path.join(os.path.dirname(__file__), "..", "simulation_results.json")
    with open(output_path, "w") as f:
        json.dump(results, f, indent=2, ensure_ascii=False)
    print(f"\nResults saved to {output_path}")


if __name__ == "__main__":
    main()
