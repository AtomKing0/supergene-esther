#!/usr/bin/env python3
"""
converted/ 디렉토리의 모든 맵 파일에서 depth 값을 y-position 기준으로 재계산.

문제:
  CC의 Layer 값을 그대로 depth로 사용하면, 같은 depth의 카드가 서로 다른 y-position에
  위치하게 됨. 예를 들어 depth=8 카드가 depth=7 카드보다 y가 낮아서
  시각적으로 7층이 8층을 덮는 레이어 꼬임이 발생.

수정:
  y-position(화면 세로 위치)을 기준으로 depth를 재계산.
  - 낮은 y → 낮은 depth (플레이어 쪽, 화면 아래)
  - 높은 y → 높은 depth (화면 위쪽, 상위 레이어)
  - 같은 위치의 스택된 카드들은 원래 depth 순서 유지

너비/높이 변경 없음: 카드 position은 변경하지 않고 depth만 재계산.
"""

import json
import os
import glob
from collections import defaultdict


def recompute_depths(data: dict) -> tuple[dict, bool]:
    """카드 배열의 depth 값을 y-position 기준으로 재계산.

    Returns:
        (수정된 data, 변경 여부)
    """
    cards_str = data["stage"]["map"]
    cards = json.loads(cards_str)

    draw_cards = [c for c in cards if c.get("isDrawCard", False)]
    field_cards = [c for c in cards if not c.get("isDrawCard", False)]

    if not field_cards:
        return data, False

    # 같은 위치(x, y)에 있는 카드들을 그룹화 (스택된 카드)
    pos_groups: dict[tuple, list] = defaultdict(list)
    for c in field_cards:
        key = (c["position"]["x"], c["position"]["y"])
        pos_groups[key].append(c)

    # 고유 y 값 오름차순 정렬 → 낮은 y = 낮은 depth
    unique_ys = sorted(set(pos[1] for pos in pos_groups))
    y_to_rank = {y: rank for rank, y in enumerate(unique_ys)}

    # 같은 위치의 최대 스택 크기 (서브 랭크 범위)
    max_stack = max(len(g) for g in pos_groups.values())

    # 기존 depth 저장 (변경 감지용)
    original_depths = {id(c): c["depth"] for c in field_cards}

    # 새 depth 할당:
    #   new_depth = y_rank * (max_stack + 1) + sub_rank
    #   - y_rank: y 위치 순위 (낮은 y → 0)
    #   - sub_rank: 같은 위치 내 원래 depth 순서 (스택 순서 유지)
    for pos, group in pos_groups.items():
        y = pos[1]
        y_rank = y_to_rank[y]
        # 원래 depth 순서로 정렬하여 스택 상대 순서 유지
        group.sort(key=lambda c: c["depth"])
        for sub_rank, card in enumerate(group):
            card["depth"] = y_rank * (max_stack + 1) + sub_rank

    # depth 값을 연속 정수로 압축 (0, 2, 4, ... → 0, 1, 2, ...)
    # 빈 레이어 노드 생성 낭비 방지
    used_depths = sorted(set(c["depth"] for c in field_cards))
    depth_remap = {old: new for new, old in enumerate(used_depths)}
    for c in field_cards:
        c["depth"] = depth_remap[c["depth"]]

    # 변경 여부 확인
    changed = any(c["depth"] != original_depths[id(c)] for c in field_cards)

    if changed:
        all_cards = field_cards + draw_cards
        data["stage"]["map"] = json.dumps(
            all_cards, separators=(",", ":"), ensure_ascii=False
        )

    return data, changed


def verify_no_violations(data: dict) -> bool:
    """수정 후 depth-y 순서 위반이 없는지 검증."""
    cards_str = data["stage"]["map"]
    cards = json.loads(cards_str)
    field = [c for c in cards if not c.get("isDrawCard", False)]

    CARD_W, CARD_H = 100, 150
    depth_cards: dict[int, list] = defaultdict(list)
    for c in field:
        depth_cards[c["depth"]].append(c)

    depths = sorted(depth_cards.keys())
    for i in range(len(depths) - 1):
        d_low, d_high = depths[i], depths[i + 1]
        for ca in depth_cards[d_low]:
            for cb in depth_cards[d_high]:
                dx = abs(ca["position"]["x"] - cb["position"]["x"])
                dy = abs(ca["position"]["y"] - cb["position"]["y"])
                if dx < CARD_W and dy < CARD_H:
                    if cb["position"]["y"] < ca["position"]["y"]:
                        return False
    return True


def process_directory(base_dir: str) -> dict:
    """converted/ 하위 모든 JSON 파일 처리."""
    stats = {"total": 0, "changed": 0, "errors": 0, "still_violated": 0}

    for dirpath, _dirs, files in os.walk(base_dir):
        for fname in sorted(files):
            if not fname.endswith(".json"):
                continue
            fpath = os.path.join(dirpath, fname)
            try:
                with open(fpath, "r", encoding="utf-8") as f:
                    data = json.load(f)

                new_data, was_changed = recompute_depths(data)
                stats["total"] += 1

                if was_changed:
                    # 검증
                    if not verify_no_violations(new_data):
                        stats["still_violated"] += 1

                    with open(fpath, "w", encoding="utf-8") as f:
                        json.dump(new_data, f, indent=2, ensure_ascii=False)
                    stats["changed"] += 1

            except Exception as e:
                print(f"  오류: {fpath}: {e}")
                stats["errors"] += 1

    return stats


if __name__ == "__main__":
    base = os.path.join(os.path.dirname(os.path.abspath(__file__)), "converted")
    print(f"처리 디렉토리: {base}")
    print("depth 재계산 시작...")

    stats = process_directory(base)

    print(f"\n=== 완료 ===")
    print(f"  전체 파일: {stats['total']}")
    print(f"  수정됨: {stats['changed']}")
    print(f"  오류: {stats['errors']}")
    if stats["still_violated"] > 0:
        print(f"  여전히 위반 (검증 실패): {stats['still_violated']}")
    else:
        print(f"  검증: 모든 수정된 파일에서 레이어 위반 없음 ✓")
