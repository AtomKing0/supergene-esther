import { useEffect, useRef } from "react";
import { AGES } from "./config/ages.js";
import { useGameState } from "./state/useGameState.js";
import Board from "./ui/Board.jsx";
import TopHUD from "./ui/TopHUD.jsx";
import "./styles.css";

const KEY_DIR = {
  ArrowLeft: "left", ArrowRight: "right", ArrowUp: "up", ArrowDown: "down",
  a: "left", d: "right", w: "up", s: "down",
};

export default function App() {
  const game = useGameState();
  const { grid, age: ageId, gameOver, cityComplete, tryMove, newGame, advanceAge } = game;
  const age = AGES[ageId] || AGES.classic;
  const boardRef = useRef(null);

  // 시대 배경색 → CSS 변수
  useEffect(() => {
    document.documentElement.style.setProperty("--bg-from", age.bgFrom);
    document.documentElement.style.setProperty("--bg-to", age.bgTo);
  }, [age.bgFrom, age.bgTo]);

  // 키보드 입력
  useEffect(() => {
    const onKey = (e) => {
      const dir = KEY_DIR[e.key];
      if (dir) {
        e.preventDefault();
        tryMove(dir);
      }
    };
    window.addEventListener("keydown", onKey);
    return () => window.removeEventListener("keydown", onKey);
  }, [tryMove]);

  // 스와이프(터치/마우스) 입력
  useEffect(() => {
    const el = boardRef.current;
    if (!el) return;
    let sx = 0, sy = 0, down = false;
    const start = (ev) => {
      const p = ev.touches ? ev.touches[0] : ev;
      sx = p.clientX; sy = p.clientY; down = true;
    };
    const end = (ev) => {
      if (!down) return;
      down = false;
      const p = ev.changedTouches ? ev.changedTouches[0] : ev;
      const dx = p.clientX - sx, dy = p.clientY - sy;
      const adx = Math.abs(dx), ady = Math.abs(dy);
      if (Math.max(adx, ady) < 24) return; // 탭 무시
      if (adx > ady) tryMove(dx > 0 ? "right" : "left");
      else tryMove(dy > 0 ? "down" : "up");
    };
    el.addEventListener("touchstart", start, { passive: true });
    el.addEventListener("touchend", end);
    el.addEventListener("mousedown", start);
    el.addEventListener("mouseup", end);
    return () => {
      el.removeEventListener("touchstart", start);
      el.removeEventListener("touchend", end);
      el.removeEventListener("mousedown", start);
      el.removeEventListener("mouseup", end);
    };
  }, [tryMove]);

  return (
    <div className="app">
      <TopHUD
        score={game.score}
        highScore={game.highScore}
        coins={game.coins}
        age={age}
        onSettings={() => {}}
        onShop={() => {}}
      />
      <Board grid={grid} age={age} boardRef={boardRef} />

      {cityComplete && (
        <div className="overlay">
          <div className="panel">
            <h2>{age.icon} 도시 완성!</h2>
            <p>COMPLETE EACH CITY TO ADVANCE</p>
            <button className="big-btn" onClick={advanceAge}>다음 시대로</button>
          </div>
        </div>
      )}

      {gameOver && (
        <div className="overlay">
          <div className="panel">
            <h2>게임 오버</h2>
            <p>점수 {game.score} · 최고 {game.highScore}</p>
            <button className="big-btn" onClick={newGame}>다시 하기</button>
          </div>
        </div>
      )}
    </div>
  );
}
