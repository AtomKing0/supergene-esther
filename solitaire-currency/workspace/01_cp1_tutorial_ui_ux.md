---
agent: 01_pm
mode: cp1
scope: 튜토리얼 UI/UX 화면별 명세 (06_tutorial_ui_ux_spec.md)
executed: 2026-03-16T21:30:00+09:00
status: complete
verdict: Adjust
adjust_targets: [06_tutorial_ui_ux_spec]
---

# CP1 스키마 검수 — 튜토리얼 UI/UX 명세

> 검수 대상: `workspace/06_tutorial_ui_ux_spec.md`
> 참조: `workspace/05_tutorial_system_spec.md`, `workspace/01_cp1_tutorial_schema.md`, Google Sheet (unlock, tutorial_guide)

---

## 1. 화면별 검수 결과 표

| 화면(SCR) | 시스템 명세 정합성 | 컴포넌트 완결성 | string_code 연결 | 판정 | 비고 |
|---|---|---|---|---|---|
| SCR-01: Phase 0 가이드 | Pass | Pass | Pass | **Adjust** | NRU 구제 메카닉 UI 미정의, const 10065 가설 미표기 |
| SCR-02: 로비 최초 진입 | **WARN** | **WARN** | Pass | Adjust | Step 2·4 와이어프레임 누락 |
| SCR-03: 도시 꾸미기 | Pass | Pass | Pass | Go | — |
| SCR-04: Pre-Level 가이드 | Pass | Pass | Pass | Go | — |
| SCR-05: 기믹 첫 등장 | Pass | Pass | Pass | Go | — |
| SCR-06: 스트릭 가이드 | Pass | Pass | Pass | Go | — |
| SCR-07: 언두 튜토리얼 | Pass | Pass | Pass | Go | — |
| SCR-08: 엑스트라 덱 | Pass | Pass | Pass | Go | — |
| SCR-09: 해금 팝업 | **FAIL** | Pass | Pass | Adjust | content_iap_popup(Lv 11) 일람 누락 |
| SCR-10: 아이콘 터치 유도 | Pass | Pass | Pass | Go | — |
| SCR-11: 파이어웍스 | Pass | Pass | Pass | Go | — |
| SCR-12: 타임아웃 힌트 | Pass | Pass | N/A | Go | — |
| SCR-13: 클리어+졸업 | **WARN** | Pass | **FAIL** | Adjust | 졸업 텍스트 하드코딩, string_code 미참조 |
| 공통 컴포넌트 (1.1~1.6) | Pass | Pass | N/A | Go | 4종 + 2종 보조 완결 |
| 화면 전환 플로우 (§16) | Pass | N/A | N/A | Go | NRU→Lv 24 전체 커버 |
| tutorial_guide 매핑 (§17) | Pass | N/A | Pass | Go | 25개 전수 매핑 |
| 디자이너 체크리스트 (부록 A) | Pass | N/A | N/A | Go | 에셋·애니메이션·색상 완결 |

---

## 2. 수정 필요 항목

| # | 대상 | 항목 | 문제 | 우선순위 | 수정 방향 |
|---|---|---|---|---|---|
| 1 | SCR-09 | content_iap_popup (Lv 11) | 섹션 17 매핑표(230015)에는 SCR-09로 등재되어 있으나, **섹션 11 해금 팝업 발생 일람 테이블에서 누락**. 디자이너·QA가 Lv 11 해금 팝업을 빠뜨릴 위험 | **높음** | 해금 팝업 발생 일람에 `Lv 11 │ content_iap_popup │ T_TUT_IAP_POPUP │ IAP 팝업 첫 노출` 행 추가 |
| 2 | SCR-13 | 졸업 텍스트 | "이제 본격적인 도전이 시작됩니다!" 가 **한국어 하드코딩**. 다른 모든 Bubble은 `T_TUT_*` string_code 참조인데 졸업만 예외. 다국어 대응 불가 | **높음** | `T_TUT_GRADUATION` string_code 키 정의 → string_code 시트 등록 → SCR-13 Bubble에 키 참조 적용 |
| 3 | SCR-01 (S1-5) | const 10065 가설 표기 | 보상 "골드 1,000g (const 10065)"가 **라이브 시트 실존 미확인** 상태. 01_cp1_tutorial_schema.md 이슈 #6에서 지적됨. PM 공통 규칙: 미확인 추정 → "가설" 명시 | **중간** | 보상 금액 옆에 `(가설 — const 10065 라이브 확인 필요)` 표기 추가 |
| 4 | SCR-01 | Phase 0 실패 UI | 05 spec §4.3에 NRU 구제 메카닉(덱 소진 + 매칭 불가 → **자동 5장 추가 드로우**, 최대 1회, 무료) 정의됨. UI/UX 문서에 **이 상황의 화면 연출 미정의** | **중간** | SCR-01에 "S1-6: NRU 구제 드로우" 서브섹션 추가. 발동 조건, 딤/Bubble/연출 정의 |
| 5 | SCR-02 | Step 2·4 와이어프레임 | Step 1→3→5만 와이어프레임 존재. **Step 2(도시 꾸미기 화면 진입 전환)**, **Step 4(업그레이드 완료 연출)** 의 레이아웃·컴포넌트 미정의 | **낮음** | Step 2: 화면 전환 연출 (딤 해제→슬라이드). Step 4: 업그레이드 완료 파티클 + Bubble(CELEBRATION) 와이어프레임 추가 |
| 6 | 부록 A | popup_timing 분류 체계 | tutorial_guide 시트의 popup_timing 5종(`lobby`, `pre_level`, `ingame`, `ingame_condition`, `hammer_zone`)이 **본문에서만 산발적 언급**. 디자이너가 트리거 시점을 이해할 통합 참조표 부재 | **낮음** | 부록 B로 popup_timing 분류표 추가: 각 값의 의미, 발동 위치, 해당 SCR 목록 |

---

## 3. KPI 연결성 검토

| KPI | UI/UX 문서 반영 | 판정 | 비고 |
|---|---|---|---|
| **D1 리텐션** | SCR-01(Phase 0 완주 가이드) + SCR-13a(클리어 축하) + SCR-02(로비 학습) | **Pass** | 첫 성공 경험 → 로비 복귀 → 플레이 유도 흐름 완결 |
| **D7 리텐션** | SCR-09(해금 팝업 큐) + SCR-10(아이콘 터치 유도) + SCR-03(도시 꾸미기 반복) | **Pass** | Lv 5~8 해금 경험 시각화 충분 |
| **ARPDAU** | SCR-07/08/11(FREE×3 부스터 체험) → 유료 전환 | **WARN** | 무료→유료 전환 시점(첫 유료 구매) UI가 미정의. 05 spec CP1에서도 `first_paid_booster_purchase` 이벤트 추가 권장됨 |
| **NRU 이탈** | SCR-12(타임아웃 힌트) + SCR-01(오류 처리: SHAKE+Blink) | **Pass** | 막힘 방지 UI 충분 |

---

## 4. 05_tutorial_system_spec 정합성 검토

| 확인 항목 | 05 spec 수치/정의 | 06 UI/UX 수치/정의 | 충돌 여부 | 비고 |
|---|---|---|---|---|
| Phase 0 맵 | Tutorial_0351 (필드 6장, 드로우 3장) | 동일 | 정합 | — |
| 타임아웃 시간 | 5,000ms | 5,000ms | 정합 | — |
| FREE×3 대상 | undo, extra_deck, fireworks | 동일 3종 | 정합 | — |
| 해금 레벨 매핑 | §9 Phase 5~6 테이블 | §17 매핑표 | 정합 | 25개 전수 일치 확인 |
| GuideUI 4종 | Bubble, Highlight, Arrow, Feedback | 동일 + DimOverlay, FreeTag 보조 | 정합 | 보조 2종은 UI 문서에서 추가 분류 (적절) |
| NRU 구제 메카닉 | §4.3: 자동 5장 드로우, 1회, 무료 | **미반영** | **누락** | 수정 항목 #4 |
| 졸업 Phase | Phase 4 완료 (Lv 8) | SCR-13b: Lv 8 클리어 | 정합 | — |
| help_card_rate | 80% (Phase 0) | SCR-01 S1-4: 80% | 정합 | — |
| unlock 동시 해금 큐 | Lv 12: 3종 순차 (color→stamp→race) | SCR-09: 0.3초 간격, 동일 순서 | 정합 | — |

---

## 5. 구조적 강점 (Go 판정 근거)

1. **SCR 번호 체계**: 13개 화면 유형으로 정리, tutorial_guide 25개 행 전수 매핑. 디자이너·QA가 시트 데이터 ↔ 화면을 즉시 대조 가능.

2. **ASCII 와이어프레임**: 각 화면의 딤·하이라이트·Bubble·Arrow 배치를 시각적으로 표현. 디자인 시안 없이도 컴포넌트 배치 의도 전달.

3. **컴포넌트 공통 사양 (§1)**: Bubble/Highlight/Arrow/Feedback/DimOverlay/FreeTag 6종의 속성값(사이즈, 색상, 애니메이션)이 구현 수준으로 정의됨.

4. **화면 전환 플로우 (§16)**: NRU 앱 시작 → Lv 24까지 전체 흐름을 1장 다이어그램으로 표현. 상황 트리거(SCR-03/08/12) 분리 표시.

5. **디자이너 체크리스트 (부록 A)**: 에셋 목록(사이즈·색상 포함), 애니메이션 파라미터, 색상 팔레트(HEX)가 즉시 작업 착수 가능 수준.

---

## 6. CP1 판정

### **Adjust**

> 전반적으로 양호하나, **2개 높음 우선순위 항목**의 수정이 필요하다.

**수정 필수 (높음 2건)**:
1. SCR-09 해금 팝업 일람에 `content_iap_popup`(Lv 11) 행 추가 — 일람-매핑표 불일치 해소
2. SCR-13 졸업 텍스트에 `T_TUT_GRADUATION` string_code 참조 적용 — 다국어 대응 필수

**수정 권장 (중간 2건)**:
3. SCR-01 S1-5 보상 금액에 const 10065 가설 표기 — PM 공통 규칙 준수
4. SCR-01에 NRU 구제 드로우(S1-6) UI 정의 추가 — 05 spec §4.3 반영

**수정 선택 (낮음 2건)**:
5. SCR-02 Step 2·4 와이어프레임 보완
6. popup_timing 분류 참조표 추가

**수정 후 재검수 불필요** — 06 에이전트가 위 항목 반영 후 self-check 가능.

---

## 7. 수정 후 체크리스트

- [ ] SCR-09 해금 팝업 발생 일람에 content_iap_popup (Lv 11) 행이 존재하는가
- [ ] SCR-13 졸업 Bubble에 `T_TUT_GRADUATION` string_code 참조가 적용되었는가
- [ ] SCR-01 S1-5 보상 금액에 가설 표기가 있는가
- [ ] SCR-01에 NRU 구제 드로우 UI 서브섹션(S1-6)이 존재하는가
- [ ] SCR-02 Step 2·4 와이어프레임이 존재하는가 (선택)
- [ ] popup_timing 분류 참조표가 존재하는가 (선택)
