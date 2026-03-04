#!/usr/bin/env python3
"""
CC 게임 맵 데이터를 우리 게임 포맷으로 변환하는 스크립트

CC format  →  Our game format

좌표 변환:
  our_x = round(cc_x * 13.75)
  our_y = round(cc_z * 16 - 170)

Difficulty 매핑 (our game: [노말, 어려움, 아주어려움]):
  0=Tutorial → [True, False, False]   # 노말에서만 플레이 가능
  1=VeryEasy → [True, False, False]   # 노말에서만 플레이 가능
  2=Easy     → [True, True, False]    # 노말 + 어려움
  3=Normal   → [True, True, True]     # 모든 난이도
  4=Hard     → [False, True, True]    # 어려움 + 아주어려움
  5=VeryHard → [False, False, True]   # 아주어려움에서만
  6=Special  → [False, True, True]    # 어려움 + 아주어려움
"""

import json
import os
import glob
import random

# 좌표 변환 스케일 (CC→Our)
# SCALE_X: 13.75 → 15.0 (카드 가로 겹침 방지, 7unit 간격 96px→105px)
SCALE_X = 15.0
SCALE_Z_MULT = 16
SCALE_Z_OFFSET = -170

# clearRandomCardCount 비율 (난이도별)
CLEAR_RANDOM_RATIO = {
    0: 0.35,  # Tutorial
    1: 0.35,  # VeryEasy
    2: 0.50,  # Easy
    3: 0.65,  # Normal
    4: 0.75,  # Hard
    5: 0.85,  # VeryHard
    6: 0.65,  # Special
}


def difficulty_to_array(cc_difficulty: int) -> list:
    """CC Difficulty 값을 our format의 difficultys 배열로 변환 [노말, 어려움, 아주어려움]"""
    mapping = {
        0: [True, False, False],    # Tutorial  → 노말
        1: [True, False, False],    # VeryEasy  → 노말
        2: [True, True, False],     # Easy      → 노말 + 어려움
        3: [True, True, True],      # Normal    → 전체
        4: [False, True, True],     # Hard      → 어려움 + 아주어려움
        5: [False, False, True],    # VeryHard  → 아주어려움
        6: [False, True, True],     # Special   → 어려움 + 아주어려움
    }
    return mapping.get(cc_difficulty, [True, False, False])


def center_y(cards: list) -> list:
    """필드 카드의 y 좌표를 중앙 정렬.

    (min_y + max_y) / 2 를 모든 필드 카드 y에서 차감하여
    맵이 화면 중앙(y=0)에 배치되도록 함.
    드로우 카드(isDrawCard=true)는 position이 {0,0}이므로 제외.
    """
    field = [c for c in cards if not c.get("isDrawCard", False)]
    if not field:
        return cards
    ys = [c["position"]["y"] for c in field]
    offset = round((min(ys) + max(ys)) / 2)
    for c in field:
        c["position"]["y"] -= offset
    return cards


def normalize_depths(cards: list) -> list:
    """CC Layer 값을 0-based 연속 정수로 정규화.

    CC Layer 값의 상대 순서를 그대로 보존하면서 0, 1, 2, ... 연속 정수로 압축.
    y-position 기반 재배열 없음 — CC 원본 레이어 구조 완전 보존.
    """
    field = [c for c in cards if not c.get("isDrawCard", False)]
    if not field:
        return cards

    used = sorted(set(c["depth"] for c in field))
    remap = {old: new for new, old in enumerate(used)}
    for c in field:
        c["depth"] = remap[c["depth"]]

    # Scattered 맵(회전 카드 포함) 처리: depth 역전
    # 게임 엔진은 depth 높을수록 앞(front)으로 렌더링.
    # CC Layer 0 = 최상위(front)이므로 역전 필요.
    is_scattered = any(c.get("angle", 0) != 0 for c in field)
    if is_scattered:
        max_d = max(c["depth"] for c in field)
        for c in field:
            c["depth"] = max_d - c["depth"]

    return cards


def convert_tableau_card(cc_card: dict, force_face_down: bool = False) -> dict:
    """CC Tableau 카드 하나를 our format 카드로 변환"""
    definition = cc_card.get("Definition", {})
    position = cc_card.get("Position", {})

    our_x = round(position.get("x", 0.0) * SCALE_X)
    our_y = round(position.get("z", 0.0) * SCALE_Z_MULT + SCALE_Z_OFFSET)

    card_type = definition.get("type", 0)
    symbol = definition.get("suit", 0)
    value = definition.get("rank", 0)
    # symbol=0 AND value=0이면 랜덤 카드 (type 값에 무관하게)
    is_random = (symbol == 0 and value == 0)
    # 랜덤 카드가 아닌데 symbol이 1~4 범위 밖이면 (0, 9, 10 등) → 1~4 랜덤 배정
    if not is_random and symbol not in (1, 2, 3, 4):
        symbol = random.randint(1, 4)
    # symbol은 유효한데 value=0이면 1~13 랜덤 배정
    if not is_random and value == 0:
        value = random.randint(1, 13)

    return {
        "type": 0,
        "symbol": symbol,
        "specialType": 0,
        "value": value,
        "position": {"x": our_x, "y": our_y},
        "isFaceUp": False if force_face_down else bool(definition.get("forceFaceUp", 0)),
        "angle": cc_card.get("Rotation", 0.0),
        "delay": 0,
        "random": is_random,
        "depth": cc_card.get("Layer", 0),
        "isDrawCard": False,
        "removeCount": 1,
        "linkedCard": None,
    }


def convert_rigged_card(rigged: dict) -> dict:
    """StockPileRiggedCards 항목을 draw card로 변환
    - Suit=0, Rank=0: random=true (완전 랜덤 카드)
    - Suit=0, Rank≠0: suit를 1~4 랜덤 배정
    """
    suit = rigged.get("Suit", 0)
    rank = rigged.get("Rank", 0)

    # type=0, symbol=0, value=0 → random=true
    if suit == 0 and rank == 0:
        return {
            "type": 0,
            "symbol": 0,
            "specialType": 0,
            "value": 0,
            "position": {"x": 0, "y": 0},
            "isFaceUp": False,
            "angle": 0,
            "delay": 0,
            "random": True,
            "depth": 0,
            "isDrawCard": True,
            "removeCount": 1,
            "linkedCard": None,
        }

    # Suit가 1~4 범위 밖이면 (0, 9, 10 등) → suit를 1~4 중 랜덤 배정
    if suit not in (1, 2, 3, 4):
        suit = random.randint(1, 4)
    # suit는 유효한데 rank=0이면 1~13 랜덤 배정
    if rank == 0:
        rank = random.randint(1, 13)

    return {
        "type": 0,
        "symbol": suit,
        "specialType": 0,
        "value": rank,
        "position": {"x": 0, "y": 0},
        "isFaceUp": False,
        "angle": 0,
        "delay": 0,
        "random": False,
        "depth": 0,
        "isDrawCard": True,
        "removeCount": 1,
        "linkedCard": None,
    }


def convert_level(cc_data: dict, force_face_down: bool = False) -> dict:
    """CC 레벨 JSON을 our format으로 변환"""
    difficulty = cc_data.get("Difficulty", 0)
    stock_pile_count = cc_data.get("StockPileCount", 0)
    rigged_cards = cc_data.get("StockPileRiggedCards", [])
    tableau = cc_data.get("Tableau", [])

    # 일반 카드 변환
    cards = [convert_tableau_card(c, force_face_down) for c in tableau]

    # 리깅된 드로우 카드 추가 (isDrawCard=true)
    for rigged in rigged_cards:
        cards.append(convert_rigged_card(rigged))

    # CC Layer 값을 0-based 연속 정수로 정규화 (원본 레이어 구조 보존)
    cards = normalize_depths(cards)

    # y-centering: 맵을 화면 중앙(y=0)에 정렬
    cards = center_y(cards)

    # stage.map은 카드 배열을 JSON 문자열로 직렬화
    map_string = json.dumps(cards, separators=(",", ":"), ensure_ascii=False)

    # clearRandomCardCount: 난이도별 비율 적용 (최소 1)
    ratio = CLEAR_RANDOM_RATIO.get(difficulty, 0.50)
    clear_count = max(1, round(stock_pile_count * ratio))

    return {
        "difficultys": difficulty_to_array(difficulty),
        "stage": {
            "map": map_string,
        },
        "clearRandomCardCount": clear_count,
        "randomCardCount": stock_pile_count,
    }


DIFFICULTY_PREFIX = {
    0: "Tutorial_",
    1: "VeryEasy_",
    2: "Easy_",
    3: "Normal_",
    4: "Hard_",
    5: "VeryHard_",
    6: "Special_",
}

DIFFICULTY_FOLDER = {
    0: "Tutorial",
    1: "VeryEasy",
    2: "Easy",
    3: "Normal",
    4: "Hard",
    5: "VeryHard",
    6: "Special",
}


def process_folder(
    input_folder: str,
    output_folder: str,
    force_face_down: bool = False,
    use_subfolders: bool = False,
) -> tuple[int, int]:
    """폴더 내 모든 CC JSON 파일을 변환하여 output_folder에 저장

    use_subfolders=True이면 Difficulty별 하위 폴더(Normal/, Hard/ 등)로 분류.
    """
    os.makedirs(output_folder, exist_ok=True)

    input_files = sorted(glob.glob(os.path.join(input_folder, "*.json")))
    # _summary.json 등 언더스코어로 시작하는 파일 제외
    input_files = [f for f in input_files if not os.path.basename(f).startswith("_")]

    success, errors = 0, 0
    for file_path in input_files:
        filename = os.path.basename(file_path)
        try:
            with open(file_path, "r", encoding="utf-8") as f:
                cc_data = json.load(f)
            difficulty = cc_data.get("Difficulty", 0)
            prefix = DIFFICULTY_PREFIX.get(difficulty, f"{difficulty}_")
            output_filename = prefix + filename

            if use_subfolders:
                subfolder = DIFFICULTY_FOLDER.get(difficulty, str(difficulty))
                dest_dir = os.path.join(output_folder, subfolder)
                os.makedirs(dest_dir, exist_ok=True)
            else:
                dest_dir = output_folder

            output_path = os.path.join(dest_dir, output_filename)
            our_data = convert_level(cc_data, force_face_down)
            with open(output_path, "w", encoding="utf-8") as f:
                json.dump(our_data, f, indent=2, ensure_ascii=False)
            success += 1
        except Exception as e:
            print(f"  오류: {filename} → {e}")
            errors += 1

    return success, errors


if __name__ == "__main__":
    base_dir = os.path.dirname(os.path.abspath(__file__))
    cc_base = os.path.join(base_dir, "..", "CC_DATA")
    out_base = os.path.join(base_dir, "converted")

    # Tutorial data 변환
    t_in = os.path.join(cc_base, "tutorial_data")
    t_out = os.path.join(out_base, "tutorial_data")
    print(f"=== Tutorial Data 변환: {t_in} ===")
    ok, err = process_folder(t_in, t_out)
    print(f"  완료: {ok}개 성공, {err}개 실패  →  {t_out}")

    # Level data 변환 (isFaceUp 강제 False)
    l_in = os.path.join(cc_base, "level_data")
    l_out = os.path.join(out_base, "level_data")
    print(f"\n=== Level Data 변환: {l_in} ===")
    ok, err = process_folder(l_in, l_out, force_face_down=True, use_subfolders=True)
    print(f"  완료: {ok}개 성공, {err}개 실패  →  {l_out}")
