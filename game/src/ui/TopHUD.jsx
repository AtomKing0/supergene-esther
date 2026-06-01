// TopHUD.jsx — 상단 HUD: 점수/최고점/골드/시대 + 설정·상점 버튼
export default function TopHUD({ score, highScore, coins, age, onSettings, onShop }) {
  return (
    <div className="hud">
      <div className="hud-row">
        <button className="hud-btn" onClick={onSettings} aria-label="settings">⚙</button>
        <div className="hud-coins">🪙 {coins}</div>
        <button className="hud-btn" onClick={onShop} aria-label="shop">🛒</button>
      </div>
      <div className="hud-row scores">
        <div className="score-box">
          <div className="score-label">SCORE</div>
          <div className="score-val">{score}</div>
        </div>
        <div className="age-box">
          <span className="age-icon">{age.icon}</span>
          <span className="age-name">{age.nameKo}</span>
        </div>
        <div className="score-box">
          <div className="score-label">BEST</div>
          <div className="score-val">{highScore}</div>
        </div>
      </div>
    </div>
  );
}
