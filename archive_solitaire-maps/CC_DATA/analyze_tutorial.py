import UnityPy
import json
import os

BUNDLE_PATH = "decompiled_resources/assets/aa/Android/levelsassetgroup_assets_levels_5a6ffb8d4dae6b85682f5d35a7e4c59f.bundle"
OUTPUT_DIR = "tutorial_data"

SUIT_MAP  = {0: "?", 1: "Spades(♠)", 2: "Hearts(♥)", 3: "Diamonds(♦)", 4: "Clubs(♣)"}
RANK_MAP  = {0: "?", 1: "A", 2: "2", 3: "3", 4: "4", 5: "5", 6: "6",
             7: "7", 8: "8", 9: "9", 10: "10", 11: "J", 12: "Q", 13: "K"}
DIFF_MAP  = {0: "Tutorial", 1: "VeryEasy", 2: "Easy", 3: "Normal", 4: "Hard", 5: "VeryHard", 6: "Special"}
TYPE_MAP  = {0: "Standard", 1: "Special"}


def parse_order(m_name: str) -> int:
    try:
        return int(m_name.split("-")[0])
    except (ValueError, IndexError):
        return 9999999


def load_all_levels(env) -> list[dict]:
    levels = []
    for obj in env.objects:
        if obj.type.name != "MonoBehaviour":
            continue
        try:
            tree = obj.read_typetree()
        except Exception:
            continue
        if "Tableau" not in tree:
            continue
        levels.append(tree)
    return levels


def is_tutorial(level: dict) -> bool:
    return level.get("Difficulty", -1) == 0


def summarize_card(card: dict) -> str:
    defn = card.get("Definition", {})
    suit = SUIT_MAP.get(defn.get("suit", 0), "?")
    rank = RANK_MAP.get(defn.get("rank", 0), "?")
    face_up = "↑" if defn.get("forceFaceUp") else "↓"
    layer   = card.get("Layer", 0)
    pos     = card.get("Position", {})
    return f"  Layer{layer} {face_up} {rank}{suit}  (x={pos.get('x',0):.1f}, z={pos.get('z',0):.1f})"


def print_level(level: dict, rank: int):
    name     = level.get("Name", "?")
    m_name   = level.get("m_Name", "?")
    diff     = DIFF_MAP.get(level.get("Difficulty", -1), str(level.get("Difficulty")))
    ltype    = TYPE_MAP.get(level.get("Type", 0), "?")
    tableau  = level.get("Tableau", [])
    ordinal  = level.get("currentLevelOrdinal", 0)
    seed     = level.get("SeedValue", 0)

    print(f"\n{'='*60}")
    print(f"  #{rank:3d}  LevelName={name}  ({m_name})")
    print(f"       Difficulty={diff}  Type={ltype}  Cards={len(tableau)}  ordinal={ordinal}  seed={seed}")
    print(f"  카드 배치:")
    for card in tableau:
        print(summarize_card(card))


def save_level(level: dict, rank: int):
    name = level.get("Name", "unknown")
    path = os.path.join(OUTPUT_DIR, f"{rank:04d}_{name}.json")
    with open(path, "w", encoding="utf-8") as f:
        json.dump(level, f, indent=2, ensure_ascii=False)
    return path


def main():
    print("번들 로딩 중...")
    env = UnityPy.load(BUNDLE_PATH)

    print("레벨 파싱 중...")
    all_levels = load_all_levels(env)
    all_levels.sort(key=lambda l: parse_order(l.get("m_Name", "")))

    tutorials = [(i + 1, l) for i, l in enumerate(all_levels) if is_tutorial(l)]

    print(f"\n전체 레벨: {len(all_levels)}개")
    print(f"튜토리얼 레벨 (Difficulty=0): {len(tutorials)}개")

    os.makedirs(OUTPUT_DIR, exist_ok=True)

    for rank, level in tutorials:
        print_level(level, rank)
        path = save_level(level, rank)
        print(f"  → 저장: {path}")

    # 요약 CSV
    csv_path = os.path.join(OUTPUT_DIR, "_summary.csv")
    with open(csv_path, "w", encoding="utf-8") as f:
        f.write("order,level_name,difficulty,type,card_count,ordinal,seed\n")
        for rank, level in tutorials:
            f.write(",".join([
                str(rank),
                str(level.get("Name", "")),
                DIFF_MAP.get(level.get("Difficulty", -1), "?"),
                TYPE_MAP.get(level.get("Type", 0), "?"),
                str(len(level.get("Tableau", []))),
                str(level.get("currentLevelOrdinal", 0)),
                str(level.get("SeedValue", 0)),
            ]) + "\n")
    print(f"\n요약 CSV 저장: {csv_path}")


if __name__ == "__main__":
    main()