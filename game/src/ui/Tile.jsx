// Tile.jsx — 보드 타일 한 개 (DOM). 시대 팔레트 색상 + 빌딩 이름 + 숫자.
import { TILE_NUMBERS } from "../config/constants.js";

const CELL_PCT = 100 / 4; // GRID_SIZE=4

export default function Tile({ tile, age, lang = "ko" }) {
  const idx = Math.min(tile.level - 1, age.tilePalette.length - 1);
  const [light, mid, dark] = age.tilePalette[idx];
  const number = TILE_NUMBERS[Math.min(tile.level - 1, TILE_NUMBERS.length - 1)];
  const name = (lang === "ko" ? age.namesKo : age.names)[idx];

  const cls = tile.justMerged ? "tile pop-merge" : tile.justSpawned ? "tile pop-spawn" : "tile";

  return (
    <div
      className={cls}
      style={{
        left: `${tile.c * CELL_PCT}%`,
        top: `${tile.r * CELL_PCT}%`,
        background: `linear-gradient(160deg, ${light} 0%, ${mid} 55%, ${dark} 100%)`,
        boxShadow: `inset 0 2px 0 rgba(255,255,255,.35), inset 0 -3px 6px rgba(0,0,0,.25), 0 3px 8px rgba(0,0,0,.3)`,
      }}
    >
      <span className="tile-num">{number}</span>
      <span className="tile-name">{name}</span>
    </div>
  );
}
