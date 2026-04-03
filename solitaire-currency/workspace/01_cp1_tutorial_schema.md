---
agent: 01_pm
mode: cp1
scope: 튜토리얼 시스템 스키마 (05_tutorial_system_spec.md)
executed: 2026-03-13T15:45:00+09:00
status: complete
verdict: Adjust
adjust_targets: [05_tutorial_system_spec]
---

# CP1 스키마 검수 — 튜토리얼 시스템

> 검수 대상: `workspace/05_tutorial_system_spec.md`
> 참조: `workspace/04_schema_template.md`, Google Sheet (const, unlock, difficulty_tier, dynamic_level)

---

## 1. 스키마 검수 결과 표

| 테이블/구조 | 컬럼 완결성 | KPI 연결성 | 판정 | 비고 |
|---|---|---|---|---|
| `tutorial_schedule` (신규 시트) | **WARN** | Pass | Adjust | 검증 규칙 미정의, FK 참조 누락 |
| `TutorialState` (클라이언트 인터페이스) | **FAIL** | Pass | Adjust | `shownGimmickGuides` 필드 누락, 저장 크기 미명시 |
| `TutorialPhase` (enum) | Pass | Pass | Go | — |
| `string_code` (44개 추가) | Pass | N/A | Go | 기존 시트 구조 준수 |
| Analytics 이벤트 (10종) | **WARN** | Pass | Adjust | 파라미터 타입·범위 미정의 |
| GuideUI 컴포넌트 (4종) | Pass | N/A | Go | TypeScript 인터페이스 완결 |
| UnlockPopup 큐 시스템 | Pass | Pass | Go | — |
| Phase 전환 로직 | **WARN** | Pass | Adjust | 레벨 임계값 하드코딩, 시트 연동 불가 |
| 보상 시스템 (Lv 1~8) | **WARN** | Pass | Adjust | const key 10065/10066 가설 미표기 |
| NRU 제한 규칙 | Pass | Pass | Go | 슬라이드 근거 명시됨 |

---

## 2. 수정 필요 항목

| # | 대상 | 컬럼/항목 | 문제 | 우선순위 | 수정 방향 |
|---|---|---|---|---|---|
| 1 | `TutorialState` | `shownGimmickGuides` | **섹션 9.3 코드에서 사용**하나 **섹션 2.1 인터페이스에 미정의**. 런타임 오류 유발 | 높음 | `shownGimmickGuides: GimmickType[]` 필드를 TutorialState 인터페이스에 추가 |
| 2 | `tutorial_schedule` | 검증 규칙 | 04_schema_template.md는 VAL-001~020 검증 규칙 정의. tutorial_schedule에는 **검증 규칙 없음** | 높음 | 최소 5개 규칙 추가: ①key 중복 금지 ②user_level 1~8 범위 ③user_level 중복 금지 ④map_id 파일 존재 검증 ⑤free_booster 값이 item_list.name_key에 존재하거나 빈 값 |
| 3 | `tutorial_schedule` | `free_booster` | item_list FK 참조 관계 미명시. 잘못된 content_id 입력 시 런타임 무료 부스터 지급 실패 | 높음 | `free_booster ∈ pst_item_definition.name_key ∪ {빈 문자열}` FK 제약 명시 |
| 4 | Phase 전환 로직 | `checkPhaseTransition()` | 레벨 임계값(2,3,5,8,9,15,36)이 **코드 내 하드코딩**. dynamic_level/unlock 시트와 연동 불가. 기획 변경 시 클라이언트 업데이트 필요 | 중간 | 두 가지 중 택일: (A) tutorial_schedule에 `phase_end_level` 컬럼 추가하여 시트 기반 전환 (B) 하드코딩 유지하되 **"하드코딩 의도"** 명시 + 변경 시 클라이언트 패치 필요 명기 |
| 5 | Analytics 이벤트 | 파라미터 타입 | `duration_ms`, `gold_balance`, `remaining_cards` 등 파라미터의 **데이터 타입·범위** 미정의. BI 팀 스키마 설계 불가 | 중간 | 각 이벤트 파라미터에 타입(int/string/float), 범위(e.g. duration_ms: int, ≥0), 단위 명시 |
| 6 | 보상 시스템 | const 10065, 10066 | `level_1_base_reward`, `level_2_base_reward` 키가 **라이브 시트 const에 실존하는지 미확인**. 부록 A에 기재되어 있으나 **가설 표기 없음** | 중간 | 라이브 시트에서 실존 확인 후 확정 표기, 또는 미확인 시 "가설" 명시 (PM 공통 규칙 준수) |
| 7 | `TutorialState` | 저장 용량 | Facebook `setDataAsync()` 저장 한도 1MB. TutorialState의 배열 필드(`completedPhases`, `shownUnlockPopups`, `freeBoostersUsed` 등)가 무한정 누적 가능 | 낮음 | 각 배열 필드의 **최대 크기** 명시. 예: `shownUnlockPopups` ≤ 20개 (unlock 시트 기준) |
| 8 | Phase 0 실패 처리 | NRU 구제 메카닉 | "자동 5장 추가 드로우"의 **발동 조건·최대 횟수·골드 비용** 미명시 | 낮음 | 발동 조건(덱 소진 + 매칭 불가), 최대 횟수(1회), 골드 비용(0, NRU 전용 무료) 명시 |

---

## 3. KPI 연결성 검토

| KPI | 데이터 수집 구조 | 판정 | 비고 |
|---|---|---|---|
| **D1 리텐션** | `tutorial_graduated` 이벤트 + `tutorial_phase_complete` Phase별 완료율 | **Pass** | Phase 4 완료율 > 80% 목표 명시됨 |
| **D7 리텐션** | `tutorial_unlock_shown` (Lv 5~8 해금 경험) | **Pass** | Lv 5 스트릭 해금 경험률 > 70% 목표 명시됨 |
| **ARPDAU** | `tutorial_free_booster_used` → 첫 유료 구매 전환 | **WARN** | 전환 추적 이벤트 부재. 무료 체험 → 첫 유료 사용 사이 이벤트(`first_paid_booster_purchase`) 추가 권장 |
| **NRU 이탈 구간** | `tutorial_level_failed` + phase 부재 교차 분석 | **Pass** | — |

---

## 4. 기존 스키마(04_schema_template.md)와의 정합성

| 확인 항목 | 04_schema 수치 | 05_tutorial_spec 수치 | 충돌 여부 | 비고 |
|---|---|---|---|---|
| NRU 시작 골드 | `pst_currency_config` → `nru_start_gold` | const 10001 = 2,000g | 정합 | — |
| 부스터 가격 구조 | `pst_item_definition` → `entry_cost_ratio` | fireworks 0.6, golden_ticket 0.8 | **미확인** | 무료 부스터 1회 절약액(~1,900g) 산출 시 사용된 비율이 item_list 라이브값과 일치하는지 확인 필요 |
| 보상 아이템 키 | `pst_item_definition` 참조 키 목록 (Section 5) | `booster_undo`, `booster_fireworks`, `booster_golden_ticket` | 정합 | 키 일치 확인 |
| 방치 골드 상수 | `pst_currency_config` → `idle_gold_max_cap` | const 10006 = 10,000g | 정합 | 라이브 확정값 |
| 골드 상한 | `pst_currency_config` → `gold_max_limit` | const 10059 = 20,000g | 정합 | 판당 수령 상한 |

---

## 5. 구조적 강점 (Go 판정 근거)

1. **6-Phase 점진적 해금 설계**: CCS 레퍼런스 기반 + PST 고유 시스템(베팅, 스트릭) 통합. Phase별 학습 부하 분산이 D1 리텐션에 긍정적.

2. **GuideUI 4종 컴포넌트 인터페이스**: Bubble, Highlight, Arrow, Feedback의 TypeScript 인터페이스가 구현 가능 수준으로 정의됨. enum 값, 에셋 사이즈, 애니메이션 파라미터 포함.

3. **해금 팝업 큐 시스템**: 동시 해금(Lv 10: 3개, Lv 12/15/20: 2개) 순차 처리 로직 + 우선순위 규칙(기믹→부스터→시스템) 명확.

4. **NRU 제한 규칙**: 슬라이드 근거 명시(슬라이드 7, 8, 59, 95) + `shouldShowPopup()` 조건문으로 구현 가능.

5. **에지 케이스 처리**: 앱 중단, 시트 로드 실패, 기존 유저 TutorialState 부재 등 4개 시나리오 커버.

---

## 6. CP1 판정

### **Adjust**

> 스키마 구조는 전반적으로 양호하나, **3개 높음 우선순위 항목**의 수정이 필요하다.

**수정 필수 (높음 3건)**:
1. `TutorialState` 인터페이스에 `shownGimmickGuides` 필드 추가 — 코드-인터페이스 불일치 해소
2. `tutorial_schedule` 검증 규칙 5개 추가 — 04_schema_template.md VAL 패턴 준수
3. `tutorial_schedule.free_booster` FK 참조 관계 명시 — 런타임 오류 예방

**수정 권장 (중간 3건)**:
4. Phase 전환 레벨 임계값 하드코딩 의도 명시 또는 시트 연동
5. Analytics 이벤트 파라미터 타입·범위 정의
6. const 10065/10066 라이브 실존 확인 또는 가설 표기

**수정 후 재검수 불필요** — 05 에이전트가 위 항목 반영 후 self-check 가능.

---

## 7. 수정 후 체크리스트

- [ ] `shownGimmickGuides: GimmickType[]` 필드가 TutorialState에 존재하는가
- [ ] tutorial_schedule VAL 규칙 5개가 명세에 기재되었는가
- [ ] free_booster FK 제약이 명시되었는가
- [ ] Phase 전환 하드코딩 근거가 명시되었는가
- [ ] Analytics 파라미터에 타입·범위가 있는가
- [ ] const 10065/10066이 가설 또는 확정으로 표기되었는가
