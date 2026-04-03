---
agent: 01_pm
mode: cp1
revision: 2
scope: PST 재화 시스템
executed: 2026-02-20T19:35:00+09:00
status: complete
verdict: Go
adjust_targets: []
---

# PST 재화 시스템 — CP1 스키마 검수 결과 (2차 재검수)

> 검수 기준: `workspace/04_schema_template.md` (12개 테이블, 수정 이력 포함)
> KPI 기준 참조: `reference/PST_const.json` (key_number 10001~10064, 64개 상수)
> 추가 참조: `reference/PST_item_list.json`, `reference/PST_daily_wheel.json`
> 검수일: 2026-02-20
> 검수 대상: 1차 CP1 Adjust 5개 항목 해소 여부 + 수정 과정에서 신규 결함 발생 여부

---

## 1. 1차 Adjust 해소 확인 표

| 순번 | 수정 항목 | 우선순위 | 해소 여부 | 확인 내용 |
|------|-----------|----------|-----------|-----------|
| 1 | `pst_streak_reward_pool` — `gacha_group_id` 컬럼 추가 및 VAL-003 GROUP BY 기준 명시 | 높음 | 해소 | `gacha_group_id` 컬럼이 테이블에 추가됨 (int, 1 이상 정수). VAL-003 검증 규칙에 "GROUP BY gacha_group_id" 기준이 명시되어 있으며 "동일 `gacha_group_id`를 가진 행들의 `gacha_rate` 합산 = 10000" 조건이 실행 가능한 수준으로 정의됨. 02 에이전트의 수치 입력 및 검증 수행 가능 |
| 2 | `pst_item_definition` — `entry_cost_ratio` 계산식 명시 | 높음 | 해소 | 컬럼 설명에 계산식 `아이템_비용 = entry_cost_base × entry_cost_ratio ÷ 10000` 명시됨. 예시(ratio=5000이면 입장비의 50%)와 currency·gimmick 유형은 0으로 표기하는 규칙도 추가됨. PST_item_list.json의 실제 값(예: booster_fireworks entry_cost_ratio=6000, booster_undo entry_cost_ratio=0)과 계산식이 정합함 |
| 3 | `pst_currency_config` — `param_category` enum에 `idle_charge`, `ingame_earn` 추가 | 중간 | 해소 | enum에 `idle_charge`와 `ingame_earn`이 추가됨. 각 범주에 PST_const.json 참조 key_number 대역이 명시됨(`idle_charge`: 10002~10006, `ingame_earn`: 10028~10031). PST_const.json 실제 상수(idle_gold_charge_time, idle_gold_charge_amount, idle_gold_interval, idle_gold_amount_increase, idle_gold_max_cap, card_maching_gold_amount 외 4개)와 대역이 일치함 |
| 4 | `pst_free_currency_source` — `daily_wheel_ad` 수량 출처 확정 또는 "데이터 없음" 명시 | 중간 | 부분 해소 | 테이블 주석 및 `amount_per_claim` 컬럼 설명에 "데이터 없음 — 02 에이전트 조사 필요" 명시됨. PST_const.json 10027(`daily_wheel_ad_limit`=5)은 출처 확인 가능 명기됨. 단, `PST_daily_wheel.json`이 존재하며(key 140001~140008, 8개 가챠 항목 확인됨) 스키마 주석이 이를 참조하지 않고 "PST_item_list.json, PST_daily_gift.json 등" 탐색 대상으로만 언급함. `daily_wheel_ad`의 1회 지급 수량은 가챠 풀 구조(가변 보상)이므로 고정값이 존재하지 않는 구조임이 PST_daily_wheel.json을 통해 확인됨 — 이는 `amount_per_claim`이 단일 정수가 아닌 별도 가챠 테이블 참조 구조임을 의미하며, "데이터 없음" 표기는 정확하나 참조 파일 명시가 미완성임. 02 에이전트가 PST_daily_wheel.json을 발견·참조하면 해소 가능한 수준이므로 Go 조건 충족 |
| 5 | `pst_item_definition` — `booster_infinite_undo_15m`/`30m` 가설 표기 | 낮음 | 해소 | 섹션 5 참조 아이템 키 목록에 두 키가 "(가설: PST_item_list에 미등재, event_milestone에서 발견)" 표기와 함께 포함됨. 가설 명시 주석도 추가됨. PST_item_list.json 재확인 결과 두 키는 실제로 미등재 상태임(40001~40029 범위 내 해당 키 없음). 가설 표기가 데이터 사실과 일치하며 02 에이전트에게 조사 필요성이 전달됨 |

---

## 2. 스키마 검수 결과 표

| 테이블명 | 컬럼 완결성 | KPI 연결성 | 판정 | 비고 |
|---|---|---|---|---|
| `pst_currency_config` | 완결 | 양호 | Go | `idle_charge`·`ingame_earn` 추가로 PST_const.json 전체 상수(idle 5개, ingame_earn 4개) 수용 가능. `friend`·`free_source`·`charge`·`cap`·`cost`·`reward`·`initial_grant` 범주 포함하여 64개 상수 전 범주 커버 |
| `pst_entry_cost_config` | 완결 | 양호 | Go | PST_const.json 10007~10011 상수 완전 대응. 수정 없음, 유지 |
| `pst_reward_margin_config` | 완결 | 보통 | Go | PST_const.json 10012~10013 대응. difficulty_tier 조인 가능 구조이나 직접 연결 컬럼 없음(허용 범위). 수정 없음, 유지 |
| `pst_ingame_reward_config` | 완결 | 양호 | Go | PST_const.json 10047~10056 완전 대응. 수정 없음, 유지 |
| `pst_item_definition` | 완결 | 양호 | Go | `entry_cost_ratio` 계산식 명시 완료. PST_item_list.json 실제 데이터(20개 아이템)와 구조 정합. `booster_infinite_undo_15m`/`30m` 가설 표기로 미등재 아이템 인지 구조 완비 |
| `pst_product_definition` | 완결 | 양호 | Go | 수정 없음, 유지. IAP/AD 분리·최대 5종 보상·노출 제어 완비 |
| `pst_daily_gift_schedule` | 완결 | 양호 | Go | 수정 없음, 유지. D1/D7 리텐션 초기·반복 보상 추적 가능 |
| `pst_daily_task_pool` | 완결 | 양호 | Go | 수정 없음, 유지. D7 리텐션 반복 참여 구조 포함 |
| `pst_streak_reward_pool` | 완결 | 양호 | Go | `gacha_group_id` 추가 및 VAL-003 GROUP BY 기준 명시로 검증 수행 가능. PST_streak_reward.json 기반 02 에이전트 수치 입력 가능 |
| `pst_event_schedule` | 완결 | 양호 | Go | 수정 없음, 유지. D7 리텐션 이벤트 반복 구조 추적 가능 |
| `pst_event_milestone_step` | 완결 | 양호 | Go | 수정 없음, 유지. VAL-008 단조 증가 검증 규칙과 일치 |
| `pst_free_currency_source` | 완결 | 양호 | Go | "데이터 없음" 명시 완료. `daily_wheel_ad`의 가챠 풀 구조는 PST_daily_wheel.json에 존재하나 해당 파일 참조가 주석에 명시되지 않음. 단, 스키마 구조 자체는 완결이며 02 에이전트 조사 지시 전달됨 — 수치 입력 단계에서 해소 가능 |

---

## 3. 잔여 수정 필요 항목

> 1차 Adjust 5건은 모두 해소(항목 4는 부분 해소이나 Go 조건 충족)되었으며, 수정 과정에서 스키마 구조에 새로운 결함은 발생하지 않음. 단, 다음 1건의 경미한 주석 미완성이 존재한다.

| 테이블명 | 컬럼명/항목 | 문제 | 수정 방향 |
|---|---|---|---|
| `pst_free_currency_source` | 테이블 주석 (`daily_wheel_ad` 참조 파일) | `daily_wheel_ad`의 1회 지급 수량은 고정값이 아닌 가챠 풀 구조임이 PST_daily_wheel.json(key 140001~140008)을 통해 확인됨. 스키마 주석의 탐색 대상 파일 목록에 "PST_item_list.json, PST_daily_gift.json 등"으로 열거되어 있으나 PST_daily_wheel.json이 명시되지 않아 02 에이전트가 탐색 범위를 확장해야 함 | 스키마 주석의 탐색 대상 파일에 `PST_daily_wheel.json` 명시 추가 권고. 단, 현 단계 Go 판정에 영향 없음 — 02 에이전트 수치 입력 단계에서 처리 가능 |

> **신규 결함 없음:** 수정 이력에 명시된 5개 항목 외 다른 테이블·컬럼에 추가 누락이나 규칙 충돌이 발생하지 않았음.

---

## 4. 검증 규칙 명확성 재검토

| 규칙 ID | 1차 명확성 | 2차 명확성 | 02·03 에이전트 실행 가능 여부 | 비고 |
|---|---|---|---|---|
| VAL-001 | 명확 | 명확 | 가능 | |
| VAL-002 | 명확 | 명확 | 가능 | |
| VAL-003 | 불명확 | **명확** | **가능** | `gacha_group_id` 추가로 GROUP BY 기준 확정됨 |
| VAL-004 | 명확 | 명확 | 가능 | |
| VAL-005 | 명확 | 명확 | 가능 | |
| VAL-006 | 명확 | 명확 | 가능 | |
| VAL-007 | 명확 | 명확 | 가능 | `gold_max_limit`=10000 (PST_const.json 10059) 확인됨 |
| VAL-008 | 명확 | 명확 | 가능 | |
| VAL-009 | 명확 | 명확 | 가능 | |
| VAL-010 | 명확 | 명확 | 가능 | |
| VAL-011 | 명확 | 명확 | 가능 | |
| VAL-012 | 명확 | 명확 | 가능 | |
| VAL-013 | 명확 | 명확 | 가능 | |
| VAL-014 | 명확 | 명확 | 가능 | |
| VAL-015 | 명확 | 명확 | 가능 | |
| VAL-016 | 명확 | 명확 | 가능 | |
| VAL-017 | 명확 | 명확 | 가능 | |
| VAL-018 | 명확 | 명확 | 가능 | |
| VAL-019 | 명확 | 명확 | 가능 | |
| VAL-020 | 명확 | 명확 | 가능 | |

> 1차에서 유일하게 불명확 판정을 받았던 VAL-003이 gacha_group_id 추가로 실행 가능 수준으로 확정됨. 전체 20개 검증 규칙 모두 명확 상태.

---

## 5. KPI 연결성 최종 확인

### D1 리텐션 (초기 보상 구조)

| KPI 데이터 요소 | 대응 테이블 | 수집 가능 여부 | 상태 |
|---|---|---|---|
| 신규 유저 초기 골드 지급 (`nru_start_gold`=1000) | `pst_currency_config` | 가능 | 유지 |
| 7일 출석 1일차 보상 | `pst_daily_gift_schedule` | 가능 | 유지 |
| 첫 레벨 입장비 면제 (`entry_cost_free_limit`=2) | `pst_entry_cost_config` | 가능 | 유지 |
| 초기 무료 재화 수령 경로 | `pst_free_currency_source` | 가능 | 유지 |
| idle_gold 충전 구조 (`idle_charge` 범주) | `pst_currency_config` | **가능 (신규)** | `idle_charge` 추가로 확보 |

### D7 리텐션 (반복 보상·이벤트)

| KPI 데이터 요소 | 대응 테이블 | 수집 가능 여부 | 상태 |
|---|---|---|---|
| 7일 출석 보상 전체 사이클 | `pst_daily_gift_schedule` | 가능 | 유지 |
| 데일리 태스크 반복 참여 구조 | `pst_daily_task_pool` | 가능 | 유지 |
| 이벤트 주기적 반복 구조 | `pst_event_schedule` | 가능 | 유지 |
| 스트릭 보상 가챠 검증 구조 | `pst_streak_reward_pool` | **가능 (신규)** | `gacha_group_id` 추가로 VAL-003 실행 가능 |

### ARPDAU (IAP 상품·소비 경로)

| KPI 데이터 요소 | 대응 테이블 | 수집 가능 여부 | 상태 |
|---|---|---|---|
| IAP 상품 종류 및 가격 | `pst_product_definition` | 가능 | 유지 |
| 아이템별 소비 원가 구조 | `pst_item_definition` | **가능 (신규)** | `entry_cost_ratio` 계산식 명시로 ARPDAU 원가 추적 가능 |
| 재화 소비 경로 (입장비) | `pst_entry_cost_config` | 가능 | 유지 |
| 인게임 골드 획득량 (`ingame_earn` 범주) | `pst_currency_config` | **가능 (신규)** | `ingame_earn` 추가로 소비 대비 획득 밸런스 추적 가능 |

---

## 6. CP1 최종 판정

**판정: Go**

1차 Adjust 5개 항목이 스키마에 모두 반영되었다. 특히 검증 수행을 차단하던 VAL-003(가챠율 합산 그룹 기준 미정의) 문제가 `gacha_group_id` 컬럼 추가로 완전 해소되었고, `entry_cost_ratio` 계산식 명시·`idle_charge`/`ingame_earn` enum 추가로 02 에이전트의 수치 입력 오류 유발 요소가 제거되었다.

수정 과정에서 기존 Go 테이블(8개)에 신규 결함이 발생하지 않았으며, 전체 20개 검증 규칙이 실행 가능 수준으로 정의된 상태이다. PST_daily_wheel.json 참조 미명시는 02 에이전트 수치 입력 단계에서 처리 가능한 경미한 주석 미완성으로 스키마 구조의 Go 판정에 영향을 미치지 않는다.

D1 리텐션, D7 리텐션, ARPDAU 수집을 위한 핵심 데이터 구조가 12개 테이블 전반에 걸쳐 확보되었으므로 Phase 1 수치 입력 단계로 진행한다.

### Go 조건 요약

| 조건 | 충족 여부 | 근거 |
|---|---|---|
| 1차 Adjust 5건 전체 해소 | 충족 (5건 중 5건) | 항목 4는 "데이터 없음" 명시로 처리 기준 확립, Go 조건 충족 |
| 수정 과정 신규 결함 없음 | 충족 | 12개 테이블 전체 재검토 결과 구조적 신규 결함 없음 |
| 전체 검증 규칙 실행 가능 | 충족 | VAL-003 해소로 20개 전 규칙 실행 가능 확정 |
| D1/D7 리텐션 수집 구조 유지 | 충족 | 수정 항목이 KPI 연결성을 저하시키지 않음, 일부 신규 확보 |
| ARPDAU 추적 구조 유지 | 충족 | entry_cost_ratio 계산식·ingame_earn 추가로 오히려 강화 |
