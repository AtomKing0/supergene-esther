```yaml
---
agent: 01_pm
mode: cp1
scope: 스트릭스타 리더보드 가이드 신규 추가 검수
executed: 2026-03-16T22:00:00+09:00
status: complete
verdict: Adjust
adjust_targets: [05_tutorial_system_spec, Google Sheet string_code]
---
```

# CP1 검수: 스트릭스타 리더보드 터치 유도 가이드 (SCR-10e)

## 1. 검수 항목별 판정표

| # | 검수 항목 | 판정 | 근거 |
|---|----------|------|------|
| 1 | 시스템 명세 정합성 (05 ↔ 06) | **WARN** | 05 spec `onLevel5Cleared_LobbyReturn()` 코드에 230026 enqueue 추가됨 — 06 spec 12.3절과 key/contentId/dimAlpha/bubble/arrow 값 **일치**. 단, 05 spec의 unlock 데이터 테이블(9.10.1)과 tutorial_guide 데이터 테이블(9.10.2)에 **신규 행 미반영** (상세: 이슈 #1, #2) |
| 2 | 시트 데이터 정합성 | **WARN** | Google Sheet 변경 내역(unlock 50024, tutorial_guide 230026)이 명시되었으나, 05 spec 문서 내 데이터 테이블에 반영되지 않아 **문서 ↔ 시트 간 불일치** 발생 (상세: 이슈 #1, #2) |
| 3 | KPI 연결성 | **Pass** | D1/D7 리텐션 기여 확인됨 (상세: 섹션 3) |
| 4 | 트리거 순서 적절성 | **Pass** | SCR-06(인게임 스트릭) → Lv 5 클리어 → SCR-09(출석체크 팝업) → SCR-10e(스트릭스타). 선행 학습(스트릭 메커닉) → 해금 팝업 → 기능 터치 유도 순서 적절 |
| 5 | 컴포넌트 완결성 | **Pass** | Dim(0.4)+Highlight+Bubble(마스코트)+Arrow(BOUNCE) — SCR-10a/10b/10c/10d 패턴과 일치. 로비 가이드 alpha 0.4 기준 준수 |
| 6 | string_code 연결 | **WARN** | `T_TUT_STREAK_STAR`가 05 spec 코드에서 titleKey로 사용되나, **05 spec 11.3절 string_code 매핑 테이블(44개)에 미등재**. 또한 다른 가이드와 달리 `descKey` 누락 — Bubble 컴포넌트 사양(1.1)에서 descKey는 **필수** 속성 (상세: 이슈 #3, #4) |

---

## 2. 수정 필요 항목

| # | 대상 문서/시트 | 항목 | 문제 | 수정 방향 | 심각도 |
|---|--------------|------|------|----------|--------|
| 1 | 05_tutorial_system_spec.md §9.10.1 | unlock 데이터 테이블 | 테이블이 50001~50023(23행)으로 종료. 50024 `content_streak_star` 행 **미추가**. 테이블 설명도 "23행, 5열"로 미갱신 | `50024 \| content_streak_star \| level \| 5 \| hidden` 행 추가. 테이블 설명 → "24행" 갱신. 넘버링 규칙("50001~50024") 갱신 | **높음** |
| 2 | 05_tutorial_system_spec.md §9.10.2 | tutorial_guide 데이터 테이블 | 테이블이 230001~230025(25행)으로 종료. 230026 행 **미추가**. 테이블 설명도 "25행, 11열"로 미갱신 | `230026 \| 50024 \| *(VLOOKUP)* \| TRUE \| focus_bubble \| lobby \| T_TUT_STREAK_STAR \| FALSE \| \| 스트릭스타 리더보드 터치 유도 \| *(VLOOKUP)*` 행 추가. "26행" 갱신. 넘버링 규칙("230001~230026") 갱신 | **높음** |
| 3 | 05_tutorial_system_spec.md §11.3 | string_code 매핑 테이블 | `T_TUT_STREAK_STAR` 미등재. 현재 "전체 44개"로 표기 | `T_TUT_STREAK_STAR_TITLE / _DESC` 행 추가 (Phase 3, Lv 5). "전체 46개"로 갱신 | **높음** |
| 4 | 05_tutorial_system_spec.md `onLevel5Cleared_LobbyReturn()` | TutorialGuide.enqueue bubble 객체 | `titleKey: "T_TUT_STREAK_STAR"`만 있고 **`descKey` 누락**. Bubble 컴포넌트 사양(06 spec §1.1)에서 descKey는 필수(`descKey (필수)`로 명시). 다른 모든 TutorialGuide.enqueue 호출은 titleKey + descKey 쌍으로 작성됨 | `descKey: "T_TUT_STREAK_STAR_DESC"` 추가. 일관성 위해 titleKey도 `"T_TUT_STREAK_STAR_TITLE"`로 변경 권장 (현재 `"T_TUT_STREAK_STAR"`는 패턴 불일치) | **높음** |
| 5 | 05_tutorial_system_spec.md §9.10.4 | 시트 간 관계 다이어그램 | `unlock (23행)`, `tutorial_guide (25행)`, `key: 50001~50023`, `key: 230001~230025` 수치 미갱신 | 각각 24행/26행, 50001~50024/230001~230026으로 갱신 | **중간** |
| 6 | Google Sheet string_code 시트 | `T_TUT_STREAK_STAR_TITLE`, `T_TUT_STREAK_STAR_DESC` | string_code 시트 등록 여부 미확인. 06 spec에서 Bubble 텍스트("스트릭 스타 리더보드가 해금되었어요! 다른 플레이어들과 경쟁해보세요!")가 와이어프레임에 하드코딩 | string_code 시트에 KR/EN 텍스트 등록. 06 spec 와이어프레임은 참조용이므로 변경 불요 | **중간** |
| 7 | 05_tutorial_system_spec.md | `shownUnlockPopups` 주석 | `shownUnlockPopups: ≤ 19개 (unlock 시트 전체 항목)` — unlock 시트가 24행이 되면 수치 불일치 (show_tutorial=TRUE 항목 수 기준이라면 별도 확인 필요) | 실제 show_tutorial=TRUE 항목 수 확인 후 주석 갱신 | **낮음** |

---

## 3. KPI 연결성 검토

| KPI | 기여도 | 근거 |
|-----|--------|------|
| **D1 리텐션** | 간접 기여 | Lv 5는 NRU D1 세션 도달 가능 구간. 스트릭스타 리더보드는 **사회적 경쟁 동기**를 부여하여 "다음 판도 해보자" 리텐션 루프 강화. SCR-06(스트릭 인게임 가이드)에서 스트릭 메커닉을 학습한 직후 리더보드로 연결하여 학습 → 목표 부여 흐름이 자연스러움 |
| **D7 리텐션** | 직접 기여 | 리더보드 순위 경쟁은 **7일 리텐션 코어 루프**(플레이 → 스트릭 점수 → 순위 확인 → 재방문)의 진입점. Lv 5에서 조기 노출하여 리텐션 습관 형성 촉진 |
| **ARPDAU** | 간접 기여 | 리더보드 경쟁 동기 → 더 많은 판 수 플레이 → 부스터 소비 증가 → 골드 싱크 강화. 직접 수익화 경로는 아니나 플레이 빈도 증가가 IAP 전환율에 기여 |

**KPI 판정**: 스트릭스타 리더보드 가이드의 Lv 5 배치는 D1/D7 리텐션 KPI에 적합. 스트릭 메커닉 학습(SCR-06) 직후 사회적 경쟁 목표를 부여하는 흐름은 이론적으로 건전함.

---

## 4. 트리거 순서 검증

```
Lv 5 인게임 진입
    │
    ▼
SCR-06: 첫 2콤보 → 스트릭미터 가이드 (Dim+Highlight+Bubble+Arrow)
    │  ← 스트릭 메커닉 학습
    ▼
Lv 5 클리어 → 로비 복귀
    │
    ▼
SCR-09: 출석체크 해금 팝업 (UnlockPopup — content_daily_check)
    │  ← 해금 알림 우선 처리 (기존 패턴)
    ▼
SCR-10e: 스트릭스타 리더보드 터치 유도 (Dim+Highlight+Bubble+Arrow)
    │  ← 학습한 스트릭의 활용처 안내
    ▼
자유 플레이
```

**판정**: 순서 적절. 근거:
- 출석체크(SCR-09)는 UnlockPopup으로 먼저 처리되는 것이 기존 패턴(해금 팝업 → 터치 유도 순서)과 일치
- 스트릭 학습(SCR-06) → 스트릭 활용처(SCR-10e) 흐름은 교육적으로 자연스러움
- Lv 5에서 동시에 2개 가이드(SCR-09 + SCR-10e)가 발생하나, 큐잉 시스템으로 순차 처리되므로 UX 충돌 없음

---

## 5. 컴포넌트 패턴 비교

| 항목 | SCR-10a (상점 Lv3) | SCR-10b (상점 Lv15) | SCR-10c (이벤트 Lv12) | SCR-10d (이벤트 Lv21) | **SCR-10e (스트릭스타 Lv5)** | 일치 |
|------|-------------------|--------------------|--------------------|--------------------|-----------------------------|------|
| DimOverlay | 0.6 | (미명시) | (미명시) | (미명시) | **0.4** | WARN |
| Highlight | O | O | O | O | **O** | OK |
| Bubble | O | O | O | O | **O (마스코트)** | OK |
| Arrow | BOUNCE | (미명시) | (미명시) | (미명시) | **BOUNCE** | OK |
| 강제 터치 | O | O | O | O | **O** | OK |

**참고**: SCR-10a는 DimOverlay alpha 0.6으로 표기되어 있으나, SCR-10e는 0.4를 사용. 06 spec §1.5에서 로비 가이드 alpha는 0.4로 개선된 바 있어, SCR-10e의 0.4가 최신 기준에 부합. SCR-10a의 0.6은 구버전 와이어프레임일 가능성 있으나 본 검수 범위 외.

---

## 6. 최종 판정

### **Adjust**

05_tutorial_system_spec.md의 데이터 테이블(unlock, tutorial_guide, string_code 매핑, 시트 간 관계 다이어그램)이 코드 변경 사항을 반영하지 못하고 있어 **문서 내부 정합성 불일치** 상태이다.

특히 이슈 #4(descKey 누락)는 Bubble 컴포넌트 필수 속성 위반으로, 구현 시 런타임 오류 또는 빈 Bubble 발생 가능성이 있어 반드시 수정이 필요하다.

06_tutorial_ui_ux_spec.md는 총괄표, 서브섹션(12.3), 플로우 다이어그램, 매핑표 모두 정합성 있게 작성되어 추가 수정 불요.

### 수정 우선순위

| 우선순위 | 이슈 # | 내용 |
|---------|--------|------|
| P0 (반영 필수) | #4 | descKey 누락 → `T_TUT_STREAK_STAR_DESC` 추가 |
| P0 (반영 필수) | #1, #2, #3 | unlock/tutorial_guide/string_code 데이터 테이블 행 추가 |
| P1 (반영 권장) | #5, #6 | 시트 관계 다이어그램 수치 갱신, string_code 시트 등록 |
| P2 (참고) | #7 | shownUnlockPopups 주석 수치 확인 |

### 재검수 조건

P0 이슈 4건(#1~#4) 수정 완료 후 재검수 불요 — 자기 확인 후 진행 가능.
단, string_code 시트 실등록은 Google Sheet 작업 시 확인 필수.
