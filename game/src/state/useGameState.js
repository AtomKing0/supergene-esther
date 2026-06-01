// useGameState.js — 게임 상태 + 영속화 (배포 번들 lc 컴포넌트의 상태/저장 로직 복원)
// 저장 키 "city2048-save": { v, grid(레벨 배열), score, coins, undoItems, removeItems, wandItems, age }
// 시대별 도시완성 임계 레벨(oc) 도달 시 다음 시대로 진행하며 보드 리셋.

import { useState, useEffect, useRef, useCallback } from "react";
import { createEmptyGrid, createTile, spawnRandomTile, canMove, maxLevel } from "../game/grid.js";
import { move as applyMove } from "../game/moves.js";
import { GRID_SIZE } from "../config/constants.js";

const SAVE_KEY = "city2048-save";
const HS_KEY = "city2048-hs";

// 시대 진행 순서 + 도시완성 임계 레벨 (번들 oc)
export const AGE_ORDER = ["stone", "egypt", "medieval", "industrial", "china", "classic", "global"];
export const CITY_COMPLETE_LEVEL = {
  stone: 9, egypt: 10, medieval: 11, industrial: 11, china: 12, classic: 12, global: 12,
};

function loadSave() {
  try {
    return JSON.parse(localStorage.getItem(SAVE_KEY) || "null") ?? {};
  } catch {
    return {};
  }
}

// 저장된 레벨 배열 → 타일 그리드 복원, 없으면 새 게임(두 칸 스폰)
function initGrid(saved) {
  if (saved.grid) {
    try {
      const g = createEmptyGrid();
      for (let r = 0; r < GRID_SIZE; r++)
        for (let c = 0; c < GRID_SIZE; c++) {
          const lv = saved.grid[r]?.[c];
          if (lv) g[r][c] = createTile(lv, r, c);
        }
      return g;
    } catch {}
  }
  return spawnRandomTile(spawnRandomTile(createEmptyGrid()));
}

export function useGameState() {
  const saved = loadSave();

  const [grid, setGrid] = useState(() => initGrid(saved));
  const [score, setScore] = useState(() => saved.score ?? 0);
  const [highScore, setHighScore] = useState(() => parseInt(localStorage.getItem(HS_KEY) || "0", 10));
  const [coins, setCoins] = useState(() => saved.coins ?? 250);
  const [age, setAge] = useState(() => saved.age || "stone");
  const [gameOver, setGameOver] = useState(false);
  const [cityComplete, setCityComplete] = useState(false);

  // 인게임 아이템
  const [undoItems, setUndoItems] = useState(() => saved.undoItems ?? 0);
  const [removeItems, setRemoveItems] = useState(() => saved.removeItems ?? 0);
  const [wandItems, setWandItems] = useState(() => saved.wandItems ?? 0);

  // undo 용 직전 스냅샷
  const prevSnapshot = useRef(null);

  // 디바운스 저장 (번들 500ms)
  const saveTimer = useRef(null);
  useEffect(() => {
    clearTimeout(saveTimer.current);
    saveTimer.current = setTimeout(() => {
      try {
        localStorage.setItem(
          SAVE_KEY,
          JSON.stringify({
            v: 1,
            grid: grid.map((row) => row.map((t) => t?.level ?? null)),
            score, coins, undoItems, removeItems, wandItems, age,
          })
        );
      } catch {}
    }, 500);
    return () => clearTimeout(saveTimer.current);
  }, [grid, score, coins, undoItems, removeItems, wandItems, age]);

  // 최고 점수 갱신
  useEffect(() => {
    if (score > highScore) {
      setHighScore(score);
      localStorage.setItem(HS_KEY, String(score));
    }
  }, [score, highScore]);

  // 도시 완성 판정
  useEffect(() => {
    const max = maxLevel(grid);
    if (max >= (CITY_COMPLETE_LEVEL[age] ?? 12) && !cityComplete) {
      setCityComplete(true);
    }
  }, [grid, age, cityComplete]);

  const tryMove = useCallback(
    (direction) => {
      if (gameOver || cityComplete) return;
      setGrid((cur) => {
        const result = applyMove(cur, direction);
        if (!result.moved) return cur;

        prevSnapshot.current = { grid: cur, score };
        const spawned = spawnRandomTile(result.grid);
        if (result.scoreGained) setScore((s) => s + result.scoreGained);
        if (!canMove(spawned)) setTimeout(() => setGameOver(true), 50);
        return spawned;
      });
    },
    [gameOver, cityComplete, score]
  );

  const undo = useCallback(() => {
    if (!prevSnapshot.current || undoItems <= 0) return;
    setGrid(prevSnapshot.current.grid);
    setScore(prevSnapshot.current.score);
    setUndoItems((n) => n - 1);
    prevSnapshot.current = null;
  }, [undoItems]);

  const newGame = useCallback(() => {
    setGrid(spawnRandomTile(spawnRandomTile(createEmptyGrid())));
    setScore(0);
    setGameOver(false);
    setCityComplete(false);
    prevSnapshot.current = null;
  }, []);

  // 다음 시대로 진행 (도시 완성 후)
  const advanceAge = useCallback(() => {
    const idx = AGE_ORDER.indexOf(age);
    const next = AGE_ORDER[Math.min(idx + 1, AGE_ORDER.length - 1)];
    setAge(next);
    setGrid(spawnRandomTile(spawnRandomTile(createEmptyGrid())));
    setScore(0);
    setCityComplete(false);
    prevSnapshot.current = null;
  }, [age]);

  return {
    grid, score, highScore, coins, age, gameOver, cityComplete,
    undoItems, removeItems, wandItems,
    setCoins, setUndoItems, setRemoveItems, setWandItems,
    tryMove, undo, newGame, advanceAge,
  };
}
