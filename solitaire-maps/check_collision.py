"""
카드 OBB 충돌 검사 스크립트
card_collision_logic.md 기반: 카드 100x150 (StageModel.CARD_SIZE), OBB_OVERLAP_MARGIN=2

검사 항목:
  1. 같은 depth 카드 간 충돌 (동일 레이어 겹침)
  2. 크로스-파일 블로킹: 서로 다른 파일 계통(중심 거리 >= 150px)의
     높은 depth 카드가 낮은 depth 카드를 OBB 겹침으로 잘못 블로킹
"""

import json
import math
import os
import sys
from collections import defaultdict

CARD_W = 100
CARD_H = 150
OBB_OVERLAP_MARGIN = 2
CROSS_PILE_MIN_DIST = 150   # 이 거리 이상이면 다른 파일 계통으로 판별
CONVERTED_DIR = os.path.join(os.path.dirname(__file__), "converted")


def get_vertices(cx, cy, w, h, angle_deg):
    """OBB의 4개 꼭짓점 반환"""
    rad = math.radians(angle_deg)
    cos_a, sin_a = math.cos(rad), math.sin(rad)
    hw, hh = w / 2, h / 2
    corners = [(-hw, -hh), (hw, -hh), (hw, hh), (-hw, hh)]
    return [
        (cx + lx * cos_a - ly * sin_a, cy + lx * sin_a + ly * cos_a)
        for lx, ly in corners
    ]


def get_axes(angle_deg):
    """OBB의 2개 법선 축 반환"""
    rad = math.radians(angle_deg)
    cos_a, sin_a = math.cos(rad), math.sin(rad)
    return [(cos_a, sin_a), (-sin_a, cos_a)]


def project(vertices, axis):
    """꼭짓점들을 축에 투영, (min, max) 반환"""
    dots = [v[0] * axis[0] + v[1] * axis[1] for v in vertices]
    return min(dots), max(dots)


def get_overlap(r1, r2):
    """두 범위의 겹침량 반환"""
    return min(r1[1], r2[1]) - max(r1[0], r2[0])


def obb_collide(c1, c2):
    """
    두 카드가 충돌하면 True.
    c1, c2: {"x", "y", "angle"} dict
    """
    v1 = get_vertices(c1["x"], c1["y"], CARD_W, CARD_H, c1["angle"])
    v2 = get_vertices(c2["x"], c2["y"], CARD_W, CARD_H, c2["angle"])
    axes = get_axes(c1["angle"]) + get_axes(c2["angle"])

    for axis in axes:
        overlap = get_overlap(project(v1, axis), project(v2, axis))
        if overlap <= OBB_OVERLAP_MARGIN:
            return False
    return True


def obb_overlap_amount(c1, c2):
    """겹침량(px) 반환. 마진 이하면 0 반환."""
    v1 = get_vertices(c1["x"], c1["y"], CARD_W, CARD_H, c1["angle"])
    v2 = get_vertices(c2["x"], c2["y"], CARD_W, CARD_H, c2["angle"])
    axes = get_axes(c1["angle"]) + get_axes(c2["angle"])
    min_ov = float("inf")
    for axis in axes:
        ov = get_overlap(project(v1, axis), project(v2, axis))
        if ov <= OBB_OVERLAP_MARGIN:
            return 0
        min_ov = min(min_ov, ov)
    return round(min_ov, 1)


def check_file(path):
    """
    파일을 읽어 충돌 목록 2종 반환.
      same_depth_cols: list of (i, j, depth, dx, dy)
      cross_pile_cols: list of (lo_idx, hi_idx, lo_depth, hi_depth, dist, overlap)
    에러 시: (None, None, str)
    """
    try:
        with open(path, encoding="utf-8") as f:
            data = json.load(f)
        map_str = data.get("stage", {}).get("map", "[]")
        cards = json.loads(map_str)
    except Exception as e:
        return None, None, str(e)

    flat = []
    for idx, card in enumerate(cards):
        if card.get("isDrawCard"):
            continue
        pos = card.get("position", {})
        flat.append({
            "idx": idx,
            "x": pos.get("x", 0),
            "y": pos.get("y", 0),
            "angle": card.get("angle", 0.0),
            "depth": card.get("depth", 0),
        })

    # 1. 같은 depth 충돌
    by_depth = defaultdict(list)
    for c in flat:
        by_depth[c["depth"]].append(c)

    same_depth_cols = []
    for depth, group in by_depth.items():
        for i in range(len(group)):
            for j in range(i + 1, len(group)):
                c1, c2 = group[i], group[j]
                if obb_collide(c1, c2):
                    dx = abs(c1["x"] - c2["x"])
                    dy = abs(c1["y"] - c2["y"])
                    same_depth_cols.append((c1["idx"], c2["idx"], depth, round(dx, 1), round(dy, 1)))

    # 2. 크로스-파일 블로킹 (다른 depth, 중심 거리 >= CROSS_PILE_MIN_DIST)
    cross_pile_cols = []
    for i in range(len(flat)):
        for j in range(i + 1, len(flat)):
            ca, cb = flat[i], flat[j]
            if ca["depth"] == cb["depth"]:
                continue
            hi = ca if ca["depth"] > cb["depth"] else cb
            lo = cb if ca["depth"] > cb["depth"] else ca
            dx = hi["x"] - lo["x"]
            dy = hi["y"] - lo["y"]
            dist = math.sqrt(dx * dx + dy * dy)
            if dist < CROSS_PILE_MIN_DIST:
                continue  # 같은 파일 계통 정상 블로킹
            amt = obb_overlap_amount(hi, lo)
            if amt > 0:
                cross_pile_cols.append((
                    lo["idx"], hi["idx"],
                    lo["depth"], hi["depth"],
                    round(dist, 1), amt
                ))

    return same_depth_cols, cross_pile_cols, None


def main():
    print(f"검사 디렉토리: {CONVERTED_DIR}\n")
    all_files = []
    for root, _, files in os.walk(CONVERTED_DIR):
        for fname in files:
            if fname.endswith(".json"):
                all_files.append(os.path.join(root, fname))

    total = len(all_files)
    print(f"총 {total}개 파일 검사 중...\n")

    same_depth_problems = []
    cross_pile_problems = []
    error_files = []

    for i, path in enumerate(sorted(all_files), 1):
        if i % 500 == 0:
            print(f"  {i}/{total} 처리 중...", flush=True)

        same_cols, cross_cols, err = check_file(path)
        if err:
            error_files.append((path, err))
        else:
            rel = os.path.relpath(path, CONVERTED_DIR)
            if same_cols:
                same_depth_problems.append((rel, same_cols))
            if cross_cols:
                cross_pile_problems.append((rel, cross_cols))

    # 결과 출력
    print(f"\n{'='*70}")
    print(f"검사 완료: {total}개 파일")
    print(f"  [1] 같은 depth 충돌 맵:      {len(same_depth_problems)}개")
    print(f"  [2] 크로스-파일 블로킹 맵:   {len(cross_pile_problems)}개")
    print(f"  파싱 오류:                   {len(error_files)}개")
    print(f"{'='*70}\n")

    if same_depth_problems:
        print("[ [1] 같은 depth 충돌 맵 ]")
        for rel, cols in same_depth_problems:
            print(f"\n  {rel}")
            for (i, j, depth, dx, dy) in cols:
                print(f"    card[{i}] ↔ card[{j}]  depth={depth}  Δx={dx}  Δy={dy}")

    if cross_pile_problems:
        print("\n[ [2] 크로스-파일 블로킹 맵 ]")
        for rel, cols in cross_pile_problems:
            print(f"\n  {rel}")
            for (lo, hi, lo_d, hi_d, dist, amt) in cols:
                print(f"    card[{lo}](d{lo_d}) ← blocked by card[{hi}](d{hi_d})  dist={dist}px  겹침={amt}px")

    if error_files:
        print("\n[ 파싱 오류 파일 ]")
        for path, err in error_files:
            print(f"  {os.path.relpath(path, CONVERTED_DIR)}: {err}")

    # CSV 저장
    out_path = os.path.join(os.path.dirname(__file__), "collision_report.csv")
    with open(out_path, "w", encoding="utf-8") as f:
        f.write("type,file,card_lo,card_hi,depth_lo,depth_hi,dist,overlap_or_dx,delta_y\n")
        for rel, cols in same_depth_problems:
            for (i, j, depth, dx, dy) in cols:
                f.write(f"same_depth,{rel},{i},{j},{depth},{depth},0,{dx},{dy}\n")
        for rel, cols in cross_pile_problems:
            for (lo, hi, lo_d, hi_d, dist, amt) in cols:
                f.write(f"cross_pile,{rel},{lo},{hi},{lo_d},{hi_d},{dist},{amt},0\n")
    print(f"\nCSV 저장: {out_path}")

    return len(same_depth_problems) + len(cross_pile_problems)


if __name__ == "__main__":
    sys.exit(0 if main() == 0 else 1)
