#!/usr/bin/env python3
"""
converted/level_data/Tutorial/ 파일들에 CC 특수 카드 타입을 포팅하는 스크립트.

CC type → Our specialType 매핑:
  type=1  → specialType=5 (WildCard): suit=0, rank=0, random=false, symbol=0, value=0
  type=2  → specialType=1 (PlusCard): value=additionalData (카드 지급 수)
  type=7  → specialType=7 (GrandFireworksCard): 기존 rank/suit 보존
  type=11 → specialType=6 (RopeCard): removeCount=additionalData+1 (0→1, 1→2)
  type=13 → specialType=9 (RunnerCard): upDown=additionalData
  type=28 → specialType=1 (PlusCard): value=additionalData (1~3 클램프)
  기타    → type=0, specialType=0 (일반 카드, 기존 값 유지)
"""

import json
import os
import math

# 스크립트 위치 기준 경로
BASE_DIR = os.path.dirname(os.path.abspath(__file__))
CC_LEVEL_DIR = os.path.join(BASE_DIR, "..", "CC_DATA", "level_data")
TUTORIAL_OUT_DIR = os.path.join(BASE_DIR, "..", "converted", "level_data", "Tutorial")

# CC type → (our_type, our_specialType) 기본 매핑
# (None = 일반 카드로 처리)
KNOWN_MAPPINGS = {
    1: "wildcard",
    2: "pluscard",
    7: "fireworks",
    11: "ropecard",
    13: "runnercard",
    28: "pluscard",
}


def apply_special_type(our_card: dict, cc_type: int, additional_data: int) -> dict:
    """CC type에 따라 우리 포맷 카드에 specialType 필드를 설정."""
    card = our_card.copy()
    kind = KNOWN_MAPPINGS.get(cc_type)

    if kind == "wildcard":
        # WildCard: symbol/value는 0 (의미 없음), random=false
        card["type"] = 1
        card["specialType"] = 5
        card["symbol"] = 0
        card["value"] = 0
        card["random"] = False

    elif kind == "pluscard":
        # PlusCard: value = 지급 카드 수 (1~3 클램프)
        plus_value = max(1, min(3, additional_data if additional_data > 0 else 1))
        card["type"] = 1
        card["specialType"] = 1
        card["value"] = plus_value

    elif kind == "fireworks":
        # GrandFireworksCard: 기존 rank/suit 그대로 보존
        card["type"] = 1
        card["specialType"] = 7

    elif kind == "ropecard":
        # RopeCard: removeCount = additionalData + 1 (0→1줄, 1→2줄)
        card["type"] = 1
        card["specialType"] = 6
        card["removeCount"] = additional_data + 1

    elif kind == "runnercard":
        # RunnerCard: upDown = additionalData (방향/이동 값)
        card["type"] = 1
        card["specialType"] = 9
        card["upDown"] = additional_data

    return card


def patch_file(tutorial_json_path: str, cc_json_path: str) -> int:
    """변환된 Tutorial JSON 파일에 CC 특수 타입을 패치. 수정된 카드 수 반환."""
    with open(tutorial_json_path, encoding="utf-8") as f:
        our_data = json.load(f)
    with open(cc_json_path, encoding="utf-8") as f:
        cc_data = json.load(f)

    # stage.map 파싱
    our_cards = json.loads(our_data["stage"]["map"])
    cc_tableau = cc_data.get("Tableau", [])

    # CC 카드 중 특수 타입만 추출 (type != 0)
    cc_special = [c for c in cc_tableau if c.get("Definition", {}).get("type", 0) != 0]

    if not cc_special:
        return 0  # 특수 카드 없음

    # SCALE_X, SCALE_Z 는 convert_cc_to_our.py 와 동일
    SCALE_X = 15.0
    SCALE_Z_MULT = 16
    SCALE_Z_OFFSET = -170

    # CC 특수 카드의 변환된 좌표를 계산하여 our_cards와 매칭
    # (y-centering offset은 our_cards에 이미 적용되어 있으므로 보정 필요)
    # → y-centering offset을 역산: our_cards 필드 카드들의 y 평균에서 추정

    # CC 좌표 기준 예상 y 값을 계산
    def cc_to_our_xy(cc_card):
        pos = cc_card.get("Position", {})
        x = round(pos.get("x", 0.0) * SCALE_X)
        y = round(pos.get("z", 0.0) * SCALE_Z_MULT + SCALE_Z_OFFSET)
        return x, y

    # y-centering offset 계산 (non-draw 필드 카드 기준)
    field_cards_cc = [c for c in cc_tableau if True]  # 모든 tableau 카드
    ys_before_center = [round(c["Position"]["z"] * SCALE_Z_MULT + SCALE_Z_OFFSET)
                        for c in field_cards_cc]
    if ys_before_center:
        y_offset = round((min(ys_before_center) + max(ys_before_center)) / 2)
    else:
        y_offset = 0

    # 특수 카드별로 (x, y_centered) 좌표 계산 후 our_cards에서 매칭
    modified = 0
    for cc_card in cc_special:
        cc_type = cc_card["Definition"]["type"]
        additional_data = cc_card["Definition"].get("additionalData", 0)
        raw_x, raw_y = cc_to_our_xy(cc_card)
        centered_y = raw_y - y_offset

        # our_cards에서 가장 가까운 필드 카드 찾기
        best_match = None
        best_dist = float("inf")
        for oc in our_cards:
            if oc.get("isDrawCard", False):
                continue
            dx = oc["position"]["x"] - raw_x
            dy = oc["position"]["y"] - centered_y
            dist = math.sqrt(dx * dx + dy * dy)
            if dist < best_dist:
                best_dist = dist
                best_match = oc

        if best_match is None or best_dist > 5:
            print(f"  WARNING: CC 특수카드 type={cc_type} @ ({raw_x},{centered_y}) 매칭 실패 (최근접 거리={best_dist:.1f})")
            continue

        idx = our_cards.index(best_match)
        our_cards[idx] = apply_special_type(best_match, cc_type, additional_data)
        modified += 1

    # 업데이트된 map string 저장
    our_data["stage"]["map"] = json.dumps(our_cards, separators=(",", ":"), ensure_ascii=False)

    with open(tutorial_json_path, "w", encoding="utf-8") as f:
        json.dump(our_data, f, indent=2, ensure_ascii=False)

    return modified


def main():
    tutorial_files = sorted(f for f in os.listdir(TUTORIAL_OUT_DIR) if f.endswith(".json"))
    total_modified = 0
    no_cc_found = []

    for fname in tutorial_files:
        # Tutorial_obj_{id}_{id}.json → obj_{id}_{id}.json
        cc_name = fname.replace("Tutorial_", "", 1)
        cc_path = os.path.join(CC_LEVEL_DIR, cc_name)

        if not os.path.exists(cc_path):
            no_cc_found.append(fname)
            continue

        our_path = os.path.join(TUTORIAL_OUT_DIR, fname)
        modified = patch_file(our_path, cc_path)
        if modified > 0:
            print(f"  {fname}: {modified}개 특수 카드 포팅")
        total_modified += modified

    if no_cc_found:
        print(f"\nCC 소스 없음 ({len(no_cc_found)}개): {no_cc_found}")

    print(f"\n완료: {len(tutorial_files)}개 파일 처리, 특수 카드 총 {total_modified}개 포팅")


if __name__ == "__main__":
    main()
