# PST 기획서 — 변경 이력

## 버전 관리 규칙

- 문서 번호는 파일명 접두어(07_, 09_ 등)로 고정
- 버전은 내용 변경 시 수동으로 index.html 업데이트
- 상태값: `최종` (검토 완료 · 배포 가능) / `진행중` (작성 중) / `라이브` (외부 문서 · 상시 최신)
- 인덱스 하단 "Last updated" 날짜도 함께 갱신

---

## 2026-04-10 — Esther Only 섹션 추가

- 인덱스 하단 footer 아래에 "🔒 Esther Only" 섹션 추가
- 비밀번호 입력 후 업데이트 기획서 티켓 칸반(내부 spec 인덱스)으로 이동하는 버튼 탑재

---

## 2026-04-01 — 사이트 IA 전면 재구조화

### 섹션 구조 변경 (주제별 → 목적별)

| 기존 섹션 | 신규 섹션 |
|---|---|
| 경제 시스템 | 수치 설계 (Design) |
| 게임 밸런스 | 시뮬레이션 & 검증 (Validation) |
| 기획 문서 (내부) | 구현 명세 (Spec) |
| 기획 문서 (외부) | 라이브 참조 (Reference) |

### 문서 제목 전면 개편 — `[대상] — [행위]` 명명 규칙 적용

| 파일 | 기존 제목 | 신규 제목 |
|---|---|---|
| economy_report_final | PST 경제 시스템 최종 보고서 | 골드 경제 설계 — Source/Sink v7 확정 |
| balance_sheet_guide | 경제 밸런스 시트 설명서 | 골드 수치 기준표 — 밸런스 시트 가이드 |
| reward_system_report | 보상 시스템 현황 보고서 | 보상 아이템 체계 — 채널별 지급 구조 |
| 09_gold_inflation | 골드 인플레이션 해소 — 론칭안 | 골드 인플레이션 진단 — V4 파라미터 조정안 |
| 10_dynamic_level | Dynamic Level 시뮬레이션 검증 보고서 | 난이도 자동 조정 (DDA) — 4개 유형 시뮬레이션 |
| 07_tutorial | 튜토리얼 기획서 | 신규 유저 온보딩 — 튜토리얼 기획서 |
| 11_city_decoration | 도시 꾸미기 개편 — 밸런스 시트 수정 + UI/UX 명세 | 도시 꾸미기 개편 — 밸런스·UX 통합 명세 |
| 12_art_production | 아트 제작 일정 & 꾸미기 소진 예측 | 아트 제작 일정 — Hammer Curve 기반 Gantt |

### 카드 배치 변경

| 문서 | 기존 섹션 | 신규 섹션 |
|---|---|---|
| 보상 아이템 체계 | 게임 밸런스 | 수치 설계 |
| 골드 인플레이션 진단 | 경제 시스템 | 시뮬레이션 & 검증 (pinned) |
| 외부 문서 3종 | 기획 문서 (혼재) | 라이브 참조 (독립 섹션) |

### 카드 설명 원칙 변경

- 기존: 콘텐츠 나열 ("~을 수록")
- 신규: 존재 이유 선행 ("~를 목표로 설계", "~를 진단하고")

---

## 2026-04-01 — Landing page 공통 스타일 통일

- 전체 8개 landing page에 Pretendard Variable 폰트 CDN 적용
- `--accent` 색상을 섹션별로 통일 (수치 설계=파랑, 검증=초록, 구현=보라)
- `10_dynamic_level_report.html` back button href 오류 수정 (`reports/index.html` → `index.html`)
- `economy_report_final.html`: KPI 숫자 36px, 섹션 타이틀 20px/800, 헤더 accent bar 추가
- `09_gold_inflation_report.html`: report-header 컴포넌트 추가, h2 border-left accent
- `balance_sheet_guide.html`, `10_dynamic_level_report.html`, `reward_system_report.html`: badge 추가, hero 상단 accent bar

---

## 2026-03-31 — 버전 관리 시작 + 인덱스 디자인 개편

### 버전 체계 정비

| 문서 | 이전 | 변경 후 | 비고 |
|------|------|---------|------|
| 튜토리얼 기획서 | — | v1 | 버전 관리 시작 |
| 도시 꾸미기 개편 | — | v1 | 버전 관리 시작 |
| 아트 제작 일정 | v1 | v1 | 유지 |
| 골드 경제 설계 | v7 | v7 | 유지 |
| 골드 수치 기준표 | v7 | v7 | 유지 |
| 골드 인플레이션 진단 | V4 | v4 | 표기 소문자 통일 |
| 난이도 자동 조정 (DDA) | DDA (타입 표기) | v1 | 버전·타입 분리, DDA는 태그로 이동 |
| 보상 아이템 체계 | — | v1 | 버전 관리 시작 |

---

## 현재 문서 현황

| 섹션 | 파일 | 제목 | 버전 | 상태 | 최종 수정 |
|---|---|---|---|---|---|
| 수치 설계 | economy_report_final | 골드 경제 설계 — Source/Sink v7 확정 | v7 | 최종 | 2026-03-30 |
| 수치 설계 | balance_sheet_guide | 골드 수치 기준표 — 밸런스 시트 가이드 | v7 | 최종 | 2026-03-30 |
| 수치 설계 | reward_system_report | 보상 아이템 체계 — 채널별 지급 구조 | v1 | 최종 | 2026-03-30 |
| 시뮬 & 검증 | 09_gold_inflation | 골드 인플레이션 진단 — V4 파라미터 조정안 | v4 | 최종 | 2026-03-30 |
| 시뮬 & 검증 | 10_dynamic_level | 난이도 자동 조정 (DDA) — 4개 유형 시뮬레이션 | v1 | 최종 | 2026-03-31 |
| 구현 명세 | 07_tutorial | 신규 유저 온보딩 — 튜토리얼 기획서 | v1 | 최종 | 2026-03-30 |
| 구현 명세 | 11_city_decoration | 도시 꾸미기 개편 — 밸런스·UX 통합 명세 | v1 | 최종 | 2026-03-30 |
| 구현 명세 | 12_art_production | 아트 제작 일정 — Hammer Curve 기반 Gantt | v1 | 최종 | 2026-03-30 |
| 라이브 참조 | (외부) | 밸런스 시트 | Sheets | 라이브 | — |
| 라이브 참조 | (외부) | UI/UX 기획서 | Slides | 라이브 | — |
| 라이브 참조 | (외부) | 로그 정의서 | Sheets | 라이브 | — |
