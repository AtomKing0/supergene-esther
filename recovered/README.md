# 복구 자료 (recovered/)

## 배경
2026-05-29, city_2048 게임의 **편집 가능한 원본 소스**(`src/scenes/GameScene.jsx`,
`src/prefabs/ui.jsx`, `src/config/ages.json` 등)가 빌드(19:18)~zip백업(19:31) 사이에
삭제되어 디스크·모든 git 레포·백업 zip·에디터 히스토리 어디에서도 복구 불가능해짐.

유일하게 살아남은 것이 **배포 빌드 번들**(`city2048/assets/*.js`)이라,
거기서 역으로 복원한 자료를 모아둔 폴더.

## 내용

### `bundle-reference/` — beautify된 번들 (참고용)
원본 구조가 아니라 **Vite 프로덕션 빌드를 읽기 좋게 편 것**. 변수명은 뭉개져 있고
(`y`, `l`, `Po`...) JSX는 함수 호출로 컴파일된 상태. 소스 재작성 시 **로직 참고용**.
- `main-GbyoQFkY.beautified.js` (8,168줄) — 게임 전체 로직 (씬/보드/UI/팝업)
- `buildings-D3phTTcr.beautified.js` (275줄) — 시대/빌딩 데이터 청크
- `inspector-fJsWEHLo.beautified.js` (1,225줄) — 디버그 인스펙터
- 라이브러리 청크(`pixi`, `react-vendor`)는 외부 패키지라 제외

### 깔끔하게 복원 완료된 것
- **`../src/config/ages.js`** — 8개 시대 × 14단계 (색상 팔레트, 영/한 빌딩명,
  빌딩 이미지 경로). 번들 데이터와 **100% 일치 검증 완료** (무손실).

## 재작성 가이드
1. 데이터 설정(ages 등)은 `src/config/`에 깔끔히 복원됨 → 그대로 사용 가능
2. 컴포넌트/로직은 `bundle-reference/main-*.beautified.js`를 읽고 원본 구조
   (`src/scenes`, `src/prefabs`, `src/systems`)로 재작성
3. 빌드 환경(package.json, vite.config)도 유실됨 → 신규 Vite+React+PIXI 스캐폴드 필요
   (의존성: `@pixi/react`, `pixi.js`, `pixi-viewport`, `@pixi/sound`, `react`)

## ⚠️ 재발방지
- 게임 소스가 디스크에 생기는 즉시 **반드시 git add + commit + push** (origin: supergene-esther)
- `dist/`는 ignore해도 되지만 **`src/`·`recovered/`는 절대 ignore 금지**
