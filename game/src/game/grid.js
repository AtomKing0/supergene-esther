// grid.js — 4x4 보드 그리드 & 타일 순수 로직 (배포 번들 ut/Ai/Be/Qe/No/bi 복원)
// 타일: { id, level, r, c, justSpawned?, justMerged?, fromIds? }
//  - level 1 = 값 2, level 2 = 값 4, ... 값 = 2^level (constants.TILE_NUMBERS[level-1])

import { GRID_SIZE } from "../config/constants.js";

let _nextId = 1;

/** 다음 고유 타일 id (번들 os++/vr) */
export function nextId() {
  return _nextId++;
}

/** 빈 GRID_SIZE×GRID_SIZE 그리드 (번들 ut) */
export function createEmptyGrid() {
  return Array(GRID_SIZE)
    .fill(null)
    .map(() => Array(GRID_SIZE).fill(null));
}

/** 타일 생성 (번들 Ai) — 생성 시 justSpawned=true */
export function createTile(level, r, c) {
  return { id: _nextId++, level, r, c, justSpawned: true };
}

/** 빈 칸에 새 타일 스폰: 90% level 1(값2), 10% level 2(값4). 빈 칸 없으면 원본 반환 (번들 Be) */
export function spawnRandomTile(grid) {
  const empties = [];
  for (let r = 0; r < GRID_SIZE; r++)
    for (let c = 0; c < GRID_SIZE; c++) if (!grid[r][c]) empties.push([r, c]);
  if (empties.length === 0) return grid;

  const [r, c] = empties[Math.floor(Math.random() * empties.length)];
  const level = Math.random() < 0.9 ? 1 : 2;
  const next = grid.map((row) => row.slice());
  next[r][c] = createTile(level, r, c);
  return next;
}

/** justSpawned/justMerged 플래그 초기화한 그리드 사본 (번들 Qe) */
export function clearTransientFlags(grid) {
  return grid.map((row) =>
    row.map((t) => (t ? { ...t, justSpawned: false, justMerged: false } : null))
  );
}

/** 이동 가능 여부: 빈 칸 있거나 인접 동일 레벨 존재 (번들 No) */
export function canMove(grid) {
  for (let r = 0; r < GRID_SIZE; r++)
    for (let c = 0; c < GRID_SIZE; c++) {
      if (!grid[r][c]) return true;
      const lv = grid[r][c].level;
      if (
        (r + 1 < GRID_SIZE && grid[r + 1][c] && grid[r + 1][c].level === lv) ||
        (c + 1 < GRID_SIZE && grid[r][c + 1] && grid[r][c + 1].level === lv)
      )
        return true;
    }
  return false;
}

/** 그리드 내 최고 레벨 (번들 bi) */
export function maxLevel(grid) {
  let max = 0;
  for (const row of grid) for (const t of row) if (t && t.level > max) max = t.level;
  return max;
}
