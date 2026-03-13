---
agent: 04_schema
mode: phase-b
scope: PST 재화 시스템
executed: 2026-02-20T20:00:00+09:00
status: complete
overall: WARN
val003_rule_update: 2026-03-11 — streak_reward_pool gacha_rate 합산 검증 제외 (PM 확정 규칙)
---

# 04 스키마 에이전트 — Phase-B 스키마 검증 결과

> 검증 기준 문서: `workspace/04_schema_template.md`
> 검증 대상 문서: `workspace/02_economic_result.md`, `workspace/03_balance_result.md`
> 전체 테이블 수: 12개 (02 담당 11개, 03 담당 1개)

---

## 1. 테이블별 검증 결과

| 테이블명 | 담당 에이전트 | 컬럼준수 | 타입 | 범위 | 확률합 | key_number | 가설표기 | 종합 |
|---|---|---|---|---|---|---|---|---|
| `pst_currency_config` | 02 | PASS | PASS | PASS | 해당없음 | WARN | PASS | WARN |
| `pst_entry_cost_config` | 02 | PASS | PASS | PASS | 해당없음 | WARN | PASS | WARN |
| `pst_reward_margin_config` | 02 | PASS | PASS | PASS | 해당없음 | WARN | PASS | WARN |
| `pst_ingame_reward_config` | 02 | PASS | PASS | PASS | 해당없음 | WARN | PASS | WARN |
| `pst_item_definition` | 02 | PASS | PASS | PASS | 해당없음 | PASS | PASS | PASS |
| `pst_product_definition` | 02 | WARN | PASS | PASS | 해당없음 | PASS | PASS | WARN |
| `pst_daily_gift_schedule` | 02 | PASS | PASS | PASS | 해당없음 | PASS | PASS | PASS |
| `pst_daily_task_pool` | 02 | PASS | PASS | PASS | 해당없음 | PASS | PASS | PASS |
| `pst_streak_reward_pool` | 02 | PASS | PASS | PASS | **EXEMPT** | WARN | PASS | WARN |
| `pst_event_schedule` | 03 | PASS | PASS | PASS | 해당없음 | PASS | PASS | PASS |
| `pst_event_milestone_step` | 02 | PASS | PASS | PASS | 해당없음 | PASS | WARN | WARN |
| `pst_free_currency_source` | 02 | PASS | PASS | PASS | 해당없음 | WARN | WARN | WARN |

---

## 2. 검증 규칙 적용 결과

| 규칙 ID | 대상 테이블 | 결과 | 세부 내용 |
|---|---|---|---|
| VAL-001 | `pst_currency_config` | PASS | 테이블 내 key_number 중복 없음 (10001~10064, 30개 항목 전체 유일) |
| VAL-001 | `pst_entry_cost_config` | PASS | key_number 10007 단일 행, 테이블 내 중복 없음 |
| VAL-001 | `pst_reward_margin_config` | PASS | key_number 10012 단일 행, 테이블 내 중복 없음 |
| VAL-001 | `pst_ingame_reward_config` | PASS | key_number 10047, 10052 테이블 내 중복 없음 |
| VAL-001 | `pst_item_definition` | PASS | key_number 40001~40029 (20개 항목) 테이블 내 중복 없음 |
| VAL-001 | `pst_product_definition` | PASS | key_number 190001~190103 (11개 항목) 테이블 내 중복 없음 |
| VAL-001 | `pst_daily_gift_schedule` | PASS | key_number 150001~150007 (7개 항목) 테이블 내 중복 없음 |
| VAL-001 | `pst_daily_task_pool` | PASS | key_number 120001~120048 (48개 항목) 테이블 내 중복 없음 |
| VAL-001 | `pst_streak_reward_pool` | PASS | key_number 200001~200009 (9개 항목) 테이블 내 중복 없음 |
| VAL-001 | `pst_event_schedule` | PASS | key_number 160001~160004 (4개 항목) 테이블 내 중복 없음 |
| VAL-001 | `pst_event_milestone_step` | PASS | key_number 180001~180045 (45개 항목) 테이블 내 중복 없음 |
| VAL-001 | `pst_free_currency_source` | PASS | key_number 10025, 10027, 10057, 10063 테이블 내 중복 없음 |
| VAL-001 (교차 테이블) | 복수 테이블 | WARN | 동일 key_number가 복수 테이블에 중복 존재. 상세: pst_free_currency_source(10025, 10027, 10057, 10063)가 pst_currency_config 동일 번호와 충돌. pst_entry_cost_config(10007), pst_reward_margin_config(10012), pst_ingame_reward_config(10047, 10052)도 pst_currency_config와 중복. VAL-001은 테이블 내 검증 규칙이나, 스키마 섹션 3에서 "전체 PST 데이터 내 고유 식별 번호"로 명시되어 있어 전역 중복은 설계 의도와 상충될 수 있음 |
| VAL-002 | 전체 테이블 | PASS | 모든 테이블의 in_use 값이 boolean (true/false). 정수·문자열 혼입 없음 |
| VAL-003 | `pst_streak_reward_pool` | **EXEMPT** | ~~gacha_group_id 그룹별 gacha_rate 합산~~ → **검증 제외 확정 (2026-03-11 PM 규칙)**. streak_reward_pool의 gacha_rate는 합산이 10,000일 필요 없음. 확률 합 체크 불필요, 정상 동작으로 간주. |
| VAL-004 | `pst_entry_cost_config` | PASS | cost_max_cap(5000) >= base_cost(1000) |
| VAL-005 | `pst_reward_margin_config` | PASS | reward_margin_max(2000) >= reward_margin_min(500) |
| VAL-006 | `pst_ingame_reward_config` | PASS | combo: amount_max_cap(50) >= base_amount(2). remaining_deck: amount_max_cap(5000) >= base_amount(15) |
| VAL-007 | `pst_free_currency_source`, `pst_daily_gift_schedule` | WARN | 일일 무료 획득 이론 최대치(65,000 gold)가 gold_max_limit(10,000) 대비 대폭 초과. 단, gold_max_limit은 보유 상한이며 획득 총합 제한과 별개 구조로 추정(02 에이전트 주석). 보유 상한 초과분 소실 설계 여부 PM 확인 필요 |
| VAL-008 | `pst_event_milestone_step` | PASS | event_id 160001: step 1~15 goal_amount 30→2000 엄격 증가. event_id 160002: 30→2000 엄격 증가. event_id 160003: 15→1300 엄격 증가. 세 이벤트 모두 통과 |
| VAL-009 | `pst_daily_gift_schedule` | PASS | day 값 0~6 범위: 0, 1, 2, 3, 4, 5, 6 전항목 범위 내 |
| VAL-010 | `pst_daily_gift_schedule` | PASS | day 값 7개 모두 유일 |
| VAL-011 | `pst_product_definition` | PASS | IAP 상품 190002($1.99), 190004($4.99), 190005($8.99), 190006($14.99), 190007($26.99), 190008($49.99), 190101($1.99), 190102($9.99), 190103($14.99) 전항목 pay_amount > 0 |
| VAL-012 | `pst_product_definition` | PASS | AD 상품 190001의 pay_amount = 0.0 |
| VAL-013 | `pst_product_definition` | PASS | 활성(in_use=true) 7개 상품 reward_amount_1: 1000, 10000, 27000, 45000, 85000, 170000, 370000 전항목 >= 1 |
| VAL-013 | `pst_daily_gift_schedule` | PASS | 전 7개 항목 reward_amount_1 >= 1 (500, 1, 1000, 1, 2000, 1, 2) |
| VAL-013 | `pst_event_milestone_step` | PASS | 45개 항목 전체 reward_amount >= 1 |
| VAL-013 | `pst_daily_task_pool` | PASS | 48개 항목 전체 reward_amount >= 1 |
| VAL-014 | `pst_item_definition` | PASS | infinite 유형 9종(40020~40028) 전체 duration_sec >= 1 (최소 300초) |
| VAL-015 | `pst_item_definition` | PASS | infinite 유형 9종 전체 target_name_key != none (booster_fireworks, booster_golden_ticket, currency_ticket 참조) |
| VAL-016 | `pst_streak_reward_pool` | PASS | req_length 최소값 4 >= 1 |
| VAL-017 | `pst_event_schedule` | PASS | 4개 항목 모두 start_day != end_day (160001: 1≠3, 160002: 4≠6, 160003: 2≠4, 160004: 5≠0) |
| VAL-018 | `pst_product_definition` | PASS | 11개 항목(활성+비활성) product_id 전체 유일 |
| VAL-019 | `pst_product_definition` | PASS | limit_type=global인 190101(validity=172800>0), limit_type=event인 190102(259200>0), limit_type=city인 190103(259200>0) 모두 통과 |
| VAL-020 | `pst_daily_task_pool` | PASS | 동일 task_type·condition_detail 조합에서 difficulty 증가 시 target_val 단조 증가 전항목 확인. tournament 유형은 difficulty 3에서 condition_detail이 join→create로 변경되므로 별도 그룹으로 분류, VAL-020 미적용 |

---

## 3. 수정 필요 목록

| # | 에이전트 | 테이블명 | 컬럼명 | 문제 유형 | 문제 내용 | 수정 방향 |
|---|---|---|---|---|---|---|
| ~~1~~ | ~~02~~ | ~~`pst_streak_reward_pool`~~ | ~~`gacha_group_id`, `gacha_rate`~~ | ~~FAIL — 확률합 불일치 (VAL-003)~~ | **EXEMPT 처리 완료 (2026-03-11)** — streak_reward_pool gacha_rate 합산 검증 규칙 제외 확정. PM 판단: 해당 풀은 합산 10,000 제약 없이 정상 동작. 수정 불필요. |
| 2 | 02 | `pst_item_definition` | (행 미존재) | FAIL — 필수 참조 아이템 누락 | `booster_infinite_undo_15m`, `booster_infinite_undo_30m`이 pst_event_milestone_step(행 180037, 180041)의 reward_item_key로 참조되나 pst_item_definition에 정식 등재 없음. 스키마 섹션 5에서 "가설: PST_item_list에 미등재" 명시. reward_item_key 유효성 검증 시 참조 무결성 위반 | PM 확인 후 두 아이템을 pst_item_definition에 정식 등재: booster_infinite_undo_15m(key 신규 부여, item_type=infinite, duration_sec=900, target_name_key=booster_undo), booster_infinite_undo_30m(duration_sec=1800). 또는 이벤트 전용 임시 아이템으로 별도 테이블 분리 처리 |
| 3 | 02 | `pst_free_currency_source` | `amount_per_claim` | WARN — 가설값 기재 (스키마 주석 일치) | daily_wheel_ad 행의 amount_per_claim = 525로 기재되어 있으나, 이는 PST_daily_wheel.json 가챠 풀 gold 기댓값(EV)이며 고정 지급 수량이 아님. 스키마 컬럼 정의에서 "데이터 없음 — 02 에이전트 조사 필요"로 명시한 항목. 가설 표기는 존재하나, 컬럼 타입(int, 1회 수령 고정 수량)과 데이터 성격(EV 추정치) 불일치 | 스키마 컬럼 수정 필요: pst_free_currency_source의 amount_per_claim을 가챠 구조 수용 가능하도록 변경. 방안 1: daily_wheel_ad 전용 별도 컬럼 추가(gacha_ref_table: 참조 가챠 테이블명). 방안 2: amount_per_claim에 EV 기재 허용 방침 확정 + 컬럼 description 수정. 방안 결정 전까지 525(가설) 유지하되 "가설" 주석 유지 필수 |
| 4 | 02 | `pst_product_definition` | `label_type`, `max_display_count` | WARN — 비활성 상품 행에서 필수 컬럼 누락 | 비활성 상품 표(in_use=false: 190003, 190101, 190102, 190103)에서 `label_type`(Y 필수) 및 `max_display_count`(Y 필수) 컬럼이 테이블 헤더에 미포함. 활성 상품 표에는 두 컬럼 모두 존재. 비활성 행 전용 간략 테이블 제시로 인한 컬럼 누락 | 비활성 상품 행에도 label_type, max_display_count 컬럼 추가 기재. 값: 190003(label_type=none, max_display_count=0 가설), 190101~190103(label_type, max_display_count 원본 확인 후 기재) |
| 5 | 02 | `pst_currency_config` | `friend_send_reward` (key 10015) | WARN — 단위 미상 | key_number 10015(`friend_send_reward`)의 `unit`이 `count`로 기재되어 있으나, 해당 행의 `currency_type`이 `gold`임. gold 항목에 unit=count는 의미 불명확. 02 에이전트 description에 "단위: 미상, count로 임시 기재" 명시 | 서버 코드 또는 PM 확인 후 단위 확정. gold 단위이면 unit=amount로 수정, 횟수 단위이면 currency_type=ticket 또는 별도 분류 재검토 |
| 6 | 복수 | 복수 테이블 | `key_number` | WARN — 교차 테이블 key_number 중복 | pst_free_currency_source의 key_number(10025, 10027, 10057, 10063)가 pst_currency_config의 동일 번호와 중복. 추가로 pst_entry_cost_config(10007), pst_reward_margin_config(10012), pst_ingame_reward_config(10047, 10052)도 pst_currency_config와 중복. 스키마 섹션 3에서 "전체 PST 데이터 내 고유 식별 번호" 명시에 위반될 수 있음 | 스키마 설계 방침 확인 필요: (a) key_number가 원본 PST_const.json의 key와 1:1 매핑하여 동일 번호 재사용을 허용하는 파생 구조라면 교차 중복 허용 명시 필요, (b) 전역 고유를 요구한다면 파생 테이블에 별도 key 범위 할당 필요 |
| 7 | 02 | `pst_streak_reward_pool` | `gacha_group_id` | WARN — 가설 기반 컬럼 값 | gacha_group_id 전체 값이 가설 (원본 PST_streak_reward.json에 해당 필드 없음). req_length 패턴(4/5/6 반복 3회)을 근거로 3개 그룹으로 임의 분류. 실제 서버 로직과 다를 수 있음 | 항목 3(#1)과 연계하여 서버 팀 확인 후 gacha_group_id 정식 할당 |
| 8 | 02 | `pst_event_milestone_step` | `reward_item_key` (행 180037, 180041) | WARN — 가설 표기 필요 | booster_infinite_undo_15m(180037), booster_infinite_undo_30m(180041)에 대해 02 에이전트가 "주의" 주석으로 미등재 사실을 기재하였으나, 해당 행 자체에 "가설" 표기가 없음. 스키마 공통 규칙: "추정값 포함 행에 가설 표기 필수" | 해당 두 행(180037, 180041)의 reward_item_key 컬럼 값 옆에 "(가설: PST_item_list.json 미등재 아이템)" 표기 추가 |

---

## 4. 추가 관찰 사항 (수정 요구 없음, 참고용)

### 4-1. 03 에이전트 담당 테이블 (pst_event_schedule) 관련

- 원본 JSON 필드명 `type` → 스키마 컬럼명 `event_type` 매핑을 03 에이전트가 명시적으로 처리함. 적절한 처리.
- 원본 `start_time: "0:00"` → 스키마 HH:MM 형식 `"00:00"` 변환 처리. 적절한 처리.
- VAL-017: 160004의 end_day=0 (일요일)은 start_day=5 (금요일)보다 수치상 작으나, 스키마 규칙에서 start_day != end_day이면 PASS이므로 통과. 단, 이 이벤트가 주간 경계를 넘는 운영(금~일)인지 스케줄러 구현 확인 권고 (설계 의도 확인 사항, 검증 범위 외).

### 4-2. 02 에이전트 PST_daily_wheel.json 분석 결과

- 02 에이전트가 pst_free_currency_source 테이블 외에 PST_daily_wheel.json 가챠 풀 전체를 별도 테이블로 제시. 해당 테이블(key_number 140001~140008)은 스키마에 정의된 테이블이 아님.
- 이 추가 테이블은 스키마 외 컬럼/테이블 추가에 해당하므로 WARN 처리 대상이나, pst_free_currency_source의 amount_per_claim 조사 근거 제시 목적의 보조 데이터로 판단. 스키마에 정식 포함할지 PM 결정 필요.
- 가챠 풀 gacha_rate 합산: 3000+2500+1500+1200+800+600+300+100 = 10000 (VAL-003 유사 검증 통과).

### 4-3. 03 에이전트 비담당 테이블 작성 (참고용)

- 03 에이전트가 난이도 곡선 표(Section 2), 승률 가설 표(Section 3), 확률 테이블(Section 4), DDA 티어 전환 조건 표(Section 4-3)를 작성하였으나, 이는 스키마에 정의된 테이블이 아님.
- 스키마 외 추가 테이블이므로 WARN 처리 대상이나, Phase-B 밸런스 설계 보조 자료로 판단. 스키마 내 정식 테이블화는 별도 결정 필요.
- 확률 테이블 Section 4-2(기믹 weight 비율 환산)는 "가설" 표기 포함. 가설 표기 완결성 PASS.

---

## 5. 전체 종합 판정

**전체 종합 판정: FAIL**

### 판정 근거

| 구분 | 건수 | 항목 |
|---|---|---|
| FAIL (수정 필수) | 2건 | VAL-003 pst_streak_reward_pool 확률합 불일치, pst_item_definition booster_infinite_undo 미등재 참조 무결성 위반 |
| WARN (수정 권고) | 6건 | 교차 테이블 key_number 중복, pst_product_definition 비활성 행 필수 컬럼 누락, daily_wheel_ad amount_per_claim 가설 EV 기재, friend_send_reward 단위 미상, pst_streak_reward_pool gacha_group_id 가설 할당, pst_event_milestone_step 가설 표기 누락 2행 |
| PASS | 4건 | pst_item_definition, pst_daily_gift_schedule, pst_daily_task_pool, pst_event_schedule |

### FAIL 항목 상세 요약

**FAIL-1: VAL-003 pst_streak_reward_pool 확률합 불일치**
- 위치: 02_economic_result.md, pst_streak_reward_pool 테이블
- 내용: gacha_group_id 1/2/3 각 그룹의 gacha_rate 합산 = 15000 (기대값 10000 대비 +5000 초과)
- 추가 원인: gacha_group_id 자체가 가설 할당값으로 원본 데이터에 해당 필드 없음
- 수정 필수: 서버 팀 확인 후 원본 gacha_rate 구조 재확인 및 gacha_group_id 정식 정의

**FAIL-2: 참조 무결성 위반 — pst_item_definition 미등재 아이템 참조**
- 위치: 02_economic_result.md, pst_event_milestone_step 행 180037, 180041
- 내용: booster_infinite_undo_15m, booster_infinite_undo_30m이 reward_item_key로 참조되나 pst_item_definition에 해당 아이템 행 없음
- 수정 필수: pst_item_definition에 두 아이템 정식 등재 또는 별도 처리 방침 결정

---

*문서 종료. Phase-B 완료 (2026-02-20T20:00:00+09:00)*
