# City 2048 소스 재구성 계획

## 목표
2026-05-29 유실된 게임 소스를, 배포 번들(`city2048/assets/main-GbyoQFkY.js`)을
명세서 삼아 **깨끗한 편집 가능 원본 소스**로 재작성한다.
배포본 동작이 정답(ground truth) — 단계마다 대조 검증.

## 게임 사양 (번들 분석 확정)
- **장르**: City 2048 — 4×4 그리드 숫자 병합. 같은 수 합치면 다음 단계.
- **타일 단계**: `[2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096]` (12단계, level 인덱스)
- **시대(Age)**: classic/egypt/medieval/industrial/china/global/space/stone (8종, `src/config/ages.js` 복구완료)
  - 각 시대 14단계 빌딩명/색상/이미지. "COMPLETE EACH CITY TO ADVANCE" — 도시 완성 시 다음 시대.
- **상태(localStorage)**: `city2048-hs`(최고점), `city2048-streak`, `city2048-lastClaim`,
  `city2048-hpa`, `city2048-htp`(튜토리얼 봤는지)
- **렌더링**: PIXI 8 (보드/타일), React (HUD·팝업 오버레이)
- **애니메이션**: GSAP, **사운드**: @pixi/sound + HTMLAudio
- **UI 요소**: SHOP(MEGA PACK/BEST VALUE/FREE 70 COINS), Settings, How to play,
  Daily reward(streak), 아이템(Magic Wand x3, Cleaner x3), City/decoration 메타

## 기술 스택
React 18.3 · PIXI 8.8 · GSAP 3 · @pixi/sound 6 · Vite 5 · @vitejs/plugin-react

## 디렉토리 (신규 `game/` — 루트 PST 리포트 파일 보호)
```
game/
├── index.html
├── package.json / vite.config.js
├── public/assets/        ← public/ 또는 city2048/assets 에서 복사
└── src/
    ├── main.jsx          엔트리 (createRoot)
    ├── App.jsx           화면 전환 셸
    ├── config/
    │   ├── ages.js       ✅ 복구완료 (8시대×14단계)
    │   └── constants.js  타일값, 그리드크기(4), 점수 등
    ├── game/             순수 로직 (no React/PIXI)
    │   ├── grid.js       4x4 생성/조작
    │   ├── moves.js      slide/merge/이동 (상하좌우)
    │   └── spawn.js      새 타일 생성 규칙
    ├── state/
    │   └── useGameState.js  React 상태 + localStorage 저장
    ├── pixi/
    │   ├── BoardView.js  PIXI 보드/타일 렌더 + GSAP 애니
    │   └── tileSprite.js 타일 스프라이트(빌딩 이미지/색상)
    ├── audio/
    │   └── sound.js      @pixi/sound 래퍼
    └── ui/               React 오버레이
        ├── TopHUD.jsx    골드/점수/설정버튼
        ├── popups/       Shop, Settings, GameOver, DailyReward, HowToPlay, CityComplete
        └── ...
```

## 단계 (각 단계 끝 = 커밋 + 배포본 대조)
- [x] **0. 데이터 복구** — ages.js (완료, 검증됨)
- [ ] **1. 스캐폴드** — package.json/vite/index.html/main/App, npm install, 빈 빌드 성공
- [ ] **2. 게임 로직** — grid/moves/spawn (4x4 2048 엔진). 번들 `ut/Ai/move...` 함수 기반. 유닛 검증.
- [ ] **3. 상태 레이어** — useGameState + localStorage 키 5개
- [ ] **4. PIXI 렌더** — BoardView 타일 그리기 + 이동/병합 GSAP 애니
- [ ] **5. React UI 셸** — App 화면전환 + TopHUD
- [ ] **6. 팝업들** — Shop/Settings/GameOver/DailyReward/HowToPlay/CityComplete
- [ ] **7. 사운드/메타** — sound, 시대전환/도시완성
- [ ] **8. 통합 검증** — 배포본과 동작 대조, 빌드 산출물 비교, 커밋·push

## 검증 방법
- 배포본: `city2048/` (또는 `dist/`) 정적 서빙해서 정답 동작 관찰
- 로직: 번들에서 추출한 함수와 입출력 대조 (ages.js 검증과 동일 방식)
- 빌드: `npm run build` 성공 + 화면 렌더 확인

## 주의
- 컴포넌트/함수명은 번들에서 뭉개져 있어 **새로 명명**. 동작·데이터·문자열은 보존.
- 루트 `index.html`·`*.html` 리포트 파일 **절대 건드리지 말 것**.
- 단계마다 commit (소스 재유실 방지).
