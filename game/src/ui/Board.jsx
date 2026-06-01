// Board.jsx — 4x4 보드 (빈 셀 배경 + 타일 오버레이). 스와이프 입력은 부모(App)가 처리.
import { GRID_SIZE } from "../config/constants.js";
import Tile from "./Tile.jsx";

export default function Board({ grid, age, boardRef }) {
  const tiles = [];
  for (let r = 0; r < GRID_SIZE; r++)
    for (let c = 0; c < GRID_SIZE; c++) {
      const t = grid[r][c];
      if (t) tiles.push(<Tile key={t.id} tile={t} age={age} />);
    }

  const cells = [];
  for (let i = 0; i < GRID_SIZE * GRID_SIZE; i++)
    cells.push(<div key={i} className="cell" style={{ background: age.boardCell }} />);

  return (
    <div className="board" ref={boardRef} style={{ background: age.boardBg }}>
      <div className="cells">{cells}</div>
      <div className="tiles">{tiles}</div>
    </div>
  );
}
