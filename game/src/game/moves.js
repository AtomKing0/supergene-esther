// moves.js — 방향 이동 + 병합 (배포 번들 Lo 복원)
// move(grid, "left"|"right"|"up"|"down")
//   → { grid, moved, scoreGained, mergedCount, highest }
// 병합: 같은 레벨 두 타일 → level+1 한 타일 (justMerged, fromIds 기록).
// 점수: 병합마다 += 2^(newLevel) == Math.pow(2, level+1).

import { GRID_SIZE } from "../config/constants.js";
import { createTile, clearTransientFlags } from "./grid.js";

export function move(grid, direction) {
  const next = clearTransientFlags(grid);
  let moved = false;
  let scoreGained = 0;
  let mergedCount = 0;
  let highest = 0;

  // 한 줄(앞→뒤 진행방향)을 압축+병합해 길이 GRID_SIZE로 패딩 반환
  function collapse(line) {
    const filled = line.filter((t) => t);
    const out = [];
    let h = 0;
    while (h < filled.length) {
      if (h + 1 < filled.length && filled[h].level === filled[h + 1].level) {
        const merged = createTile(filled[h].level + 1, 0, 0);
        merged.justMerged = true;
        merged.fromIds = [filled[h].id, filled[h + 1].id];
        out.push(merged);
        scoreGained += Math.pow(2, filled[h].level + 1);
        mergedCount++;
        if (merged.level > highest) highest = merged.level;
        h += 2;
      } else {
        out.push({ ...filled[h], justMerged: false });
        h++;
      }
    }
    while (out.length < GRID_SIZE) out.push(null);
    return out;
  }

  // 진행방향 기준으로 줄을 뽑아 압축하고, 좌표(r,c) 갱신해 다시 써넣음
  for (let i = 0; i < GRID_SIZE; i++) {
    let line;
    if (direction === "left") line = next[i].slice();
    else if (direction === "right") line = next[i].slice().reverse();
    else if (direction === "up") line = next.map((row) => row[i]);
    else line = next.map((row) => row[i]).reverse(); // down

    const before = line.map((t) => (t ? t.id : null)).join(",");
    const result = collapse(line);
    const after = result.map((t) => (t ? t.id : null)).join(",");
    if (before !== after) moved = true;

    for (let f = 0; f < GRID_SIZE; f++) {
      let r, c;
      if (direction === "left") (r = i), (c = f);
      else if (direction === "right") (r = i), (c = GRID_SIZE - 1 - f);
      else if (direction === "up") (r = f), (c = i);
      else (r = GRID_SIZE - 1 - f), (c = i); // down
      next[r][c] = result[f];
      if (next[r][c]) {
        next[r][c].r = r;
        next[r][c].c = c;
      }
    }
  }

  return { grid: next, moved, scoreGained, mergedCount, highest };
}
