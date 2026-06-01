import { AGES } from "./config/ages.js";
import { TILE_NUMBERS, GRID_SIZE } from "./config/constants.js";

// 스캐폴드 검증용 임시 화면. 복구된 데이터(ages/constants)가 연결되는지 확인.
// Phase 4~6 에서 실제 PIXI 보드 + React UI 로 교체 예정.
export default function App() {
  return (
    <div style={{ color: "#fff", fontFamily: "system-ui", padding: 20, maxWidth: 480, overflow: "auto", maxHeight: "100vh" }}>
      <h1 style={{ margin: "0 0 4px" }}>City 2048 — 재구성 스캐폴드</h1>
      <p style={{ color: "#9aa", margin: "0 0 16px" }}>
        그리드 {GRID_SIZE}×{GRID_SIZE} · 타일 {TILE_NUMBERS.length}단계 · 시대 {Object.keys(AGES).length}종
      </p>
      <div style={{ display: "grid", gap: 8 }}>
        {Object.values(AGES).map((age) => (
          <div key={age.id} style={{ display: "flex", alignItems: "center", gap: 10, background: "#222", padding: "8px 12px", borderRadius: 10 }}>
            <span style={{ fontSize: 22 }}>{age.icon}</span>
            <span style={{ fontWeight: 600 }}>{age.nameKo}</span>
            <span style={{ color: "#778", fontSize: 13 }}>{age.name} · {age.names.length}단계</span>
          </div>
        ))}
      </div>
    </div>
  );
}
