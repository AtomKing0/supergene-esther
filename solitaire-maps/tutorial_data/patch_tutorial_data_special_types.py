#!/usr/bin/env python3
"""
converted/tutorial_data/ 파일들에 CC 특수 카드 타입을 포팅하는 스크립트.

대상: converted/tutorial_data/Tutorial_{ordinal}_{id}.json
소스: CC_DATA/tutorial_data/{ordinal}_{id}.json

CC type → Our specialType 매핑 (patch_tutorial_special_types.py 와 동일):
  type=1  → specialType=5 (WildCard)
  type=2  → specialType=1 (PlusCard): value=additionalData (1~3)
  type=7  → specialType=7 (GrandFireworksCard)
  type=11 → specialType=6 (RopeCard): removeCount=additionalData+1
  type=13 → specialType=9 (RunnerCard): upDown=additionalData
  type=28 → specialType=1 (PlusCard): value=additionalData (1~3)
"""

import json
import os
import math

BASE_DIR = os.path.dirname(os.path.abspath(__file__))
CC_TUTORIAL_DIR = os.path.join(BASE_DIR, "..", "CC_DATA", "tutorial_data")
OUR_TUTORIAL_DIR = os.path.join(BASE_DIR, "..", "converted", "tutorial_data")

KNOWN_MAPPINGS = {
    1: "wildcard",
    2: "pluscard",
    7: "fireworks",
    11: "ropecard",
    13: "runnercard",
    28: "pluscard",
}

SCALE_X = 15.0
SCALE_Z_MULT = 16
SCALE_Z_OFFSET = -170


def apply_special_type(our_card: dict, cc_type: int, additional_data: int) -> dict:
    card = our_card.copy()
    kind = KNOWN_MAPPINGS.get(cc_type)

    if kind == "wildcard":
        card["type"] = 1
        card["specialType"] = 5
        card["symbol"] = 0
        card["value"] = 0
        card["random"] = False

    elif kind == "pluscard":
        plus_value = max(1, min(3, additional_data if additional_data > 0 else 1))
        card["type"] = 1
        card["specialType"] = 1
        card["value"] = plus_value
        card["random"] = False

    elif kind == "fireworks":
        card["type"] = 1
        card["specialType"] = 7

    elif kind == "ropecard":
        card["type"] = 1
        card["specialType"] = 6
        card["removeCount"] = additional_data + 1

    elif kind == "runnercard":
        card["type"] = 1
        card["specialType"] = 9
        card["upDown"] = additional_data

    return card


def patch_file(our_path: str, cc_path: str) -> int:
    with open(our_path, encoding="utf-8") as f:
        our_data = json.load(f)
    with open(cc_path, encoding="utf-8") as f:
        cc_data = json.load(f)

    our_cards = json.loads(our_data["stage"]["map"])
    cc_tableau = cc_data.get("Tableau", [])

    cc_special = [c for c in cc_tableau if c.get("Definition", {}).get("type", 0) != 0]

    if not cc_special:
        return 0

    # y-centering offset 계산
    ys_before_center = [round(c["Position"]["z"] * SCALE_Z_MULT + SCALE_Z_OFFSET)
                        for c in cc_tableau]
    if ys_before_center:
        y_offset = round((min(ys_before_center) + max(ys_before_center)) / 2)
    else:
        y_offset = 0

    modified = 0
    for cc_card in cc_special:
        cc_type = cc_card["Definition"]["type"]
        additional_data = cc_card["Definition"].get("additionalData", 0)
        pos = cc_card.get("Position", {})
        raw_x = round(pos.get("x", 0.0) * SCALE_X)
        raw_y = round(pos.get("z", 0.0) * SCALE_Z_MULT + SCALE_Z_OFFSET)
        centered_y = raw_y - y_offset

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
            print(f"  WARNING: CC type={cc_type} @ ({raw_x},{centered_y}) 매칭 실패 (거리={best_dist:.1f})")
            continue

        idx = our_cards.index(best_match)
        our_cards[idx] = apply_special_type(best_match, cc_type, additional_data)
        modified += 1

    our_data["stage"]["map"] = json.dumps(our_cards, separators=(",", ":"), ensure_ascii=False)

    with open(our_path, "w", encoding="utf-8") as f:
        json.dump(our_data, f, indent=2, ensure_ascii=False)

    return modified


def main():
    our_files = sorted(f for f in os.listdir(OUR_TUTORIAL_DIR) if f.endswith(".json"))
    total_modified = 0
    no_cc = []
    patched_files = []

    for fname in our_files:
        # Tutorial_{ordinal}_{id}.json → {ordinal}_{id}.json
        cc_name = fname.replace("Tutorial_", "", 1)
        cc_path = os.path.join(CC_TUTORIAL_DIR, cc_name)

        if not os.path.exists(cc_path):
            no_cc.append(fname)
            continue

        our_path = os.path.join(OUR_TUTORIAL_DIR, fname)
        modified = patch_file(our_path, cc_path)
        if modified > 0:
            patched_files.append((fname, modified))
            print(f"  {fname}: {modified}개 특수 카드 포팅")
        total_modified += modified

    if no_cc:
        print(f"\nCC 소스 없음 ({len(no_cc)}개): {no_cc}")

    print(f"\n완료: {len(our_files)}개 파일 처리, {len(patched_files)}개 파일 수정, 특수 카드 총 {total_modified}개 포팅")


if __name__ == "__main__":
    main()
