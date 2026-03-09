---
agent: 04_schema
mode: phase-a
scope: PST 재화 시스템
executed: 2026-02-20T19:30:00+09:00
status: complete
---

# PST 재화 시스템 — 스키마 틀 설계 (Phase-A)

> 본 문서는 수치를 포함하지 않는다. 컬럼명, 데이터 타입, 범위/허용값, 검증 규칙만 정의한다.
> 참조 파일: `PST_const.json`, `PST_product.json`, `PST_daily_gift.json`, `PST_event_milestone.json`, `PST_item_list.json`, `PST_daily_task.json`, `PST_streak_reward.json`, `PST_event_schedule.json`

---

## 1. 테이블 목록

| 테이블명 | 담당 에이전트 | 설명 |
|---|---|---|
| `pst_currency_config` | 02_경제_밸런스 | 소프트/하드 통화 기본 상수 (충전, 지급, 상한 등) |
| `pst_entry_cost_config` | 02_경제_밸런스 | 레벨 입장비 구조 (기본값, 증가 규칙, 상한) |
| `pst_reward_margin_config` | 02_경제_밸런스 | 레벨 클리어 보상 마진 범위 |
| `pst_ingame_reward_config` | 02_경제_밸런스 | 인게임 콤보·덱 잔여 보상 구조 |
| `pst_item_definition` | 02_경제_밸런스 | 아이템(재화·부스터·무한·기믹) 정의 및 속성 |
| `pst_product_definition` | 02_경제_밸런스 | 상점 상품 정의 (IAP·AD·스페셜 오퍼) |
| `pst_daily_gift_schedule` | 02_경제_밸런스 | 7일 출석 보상 스케줄 |
| `pst_daily_task_pool` | 02_경제_밸런스 | 데일리 태스크 풀 (타입·조건·보상) |
| `pst_streak_reward_pool` | 02_경제_밸런스 | 스트릭 보상 풀 (가챠율·연속 조건·보상) |
| `pst_event_schedule` | 03_게임_밸런스 | 이벤트 스케줄 (유형·기간·반복 주기) |
| `pst_event_milestone_step` | 02_경제_밸런스 | 이벤트 마일스톤 단계별 목표·보상 |
| `pst_free_currency_source` | 02_경제_밸런스 | 무료 재화 지급 경로 (광고·팝업·인박스·상점) |

---

## 2. 각 테이블의 컬럼 정의

---

### 테이블명: `pst_currency_config`
담당: 02_경제_밸런스

> PST_const.json의 통화 관련 상수(gold 충전, 보상, 상한 등)를 정규화한 테이블.

| 컬럼명 | 데이터 타입 | 범위/허용값 | 필수 여부 | 설명 |
|---|---|---|---|---|
| `key_number` | int | 양의 정수 | Y | 고유 식별 번호 |
| `const_name` | string | snake_case 문자열 | Y | 상수 식별 키 |
| `currency_type` | enum | `[gold, ticket, hammer, streak_star, puzzle_piece]` | Y | 적용 통화 유형 |
| `param_category` | enum | `[initial_grant, charge, cap, cost, reward, friend, free_source, idle_charge, ingame_earn]` | Y | 파라미터 범주 (`idle_charge`: idle 골드 충전 관련 상수 PST_const.json 10002~10006; `ingame_earn`: 인게임 카드 매칭 골드 획득 관련 상수 10028~10031) |
| `const_value` | int | 0 이상 정수 | Y | 설정값 (수치 입력 금지 — 구조 정의만) |
| `unit` | enum | `[amount, sec, count, ratio_10000]` | Y | 값의 단위 |
| `in_use` | bool | `[true, false]` | Y | 활성화 여부 |
| `description` | string | 자유 텍스트 | N | 설명 |

---

### 테이블명: `pst_entry_cost_config`
담당: 02_경제_밸런스

> 레벨 입장비의 무료 한도, 기본값, 증가 규칙, 상한을 정의.
> PST_const.json의 `entry_cost_*` 계열 상수에서 파생.

| 컬럼명 | 데이터 타입 | 범위/허용값 | 필수 여부 | 설명 |
|---|---|---|---|---|
| `key_number` | int | 양의 정수 | Y | 고유 식별 번호 |
| `free_play_limit` | int | 0 이상 정수 | Y | 무료 입장 횟수 한도 |
| `base_cost` | int | 0 이상 정수 | Y | 기본 입장 비용 (gold) |
| `cost_interval` | int | 1 이상 정수 | Y | 비용 증가 적용 레벨 간격 |
| `cost_increase_amount` | int | 0 이상 정수 | Y | 간격당 비용 증가량 (gold) |
| `cost_max_cap` | int | base_cost 이상 | Y | 입장 비용 상한 (gold) |
| `in_use` | bool | `[true, false]` | Y | 활성화 여부 |

---

### 테이블명: `pst_reward_margin_config`
담당: 02_경제_밸런스

> 레벨 클리어 시 지급되는 보상 마진 최소·최대 범위 정의.
> PST_const.json의 `reward_margin_*` 상수에서 파생.

| 컬럼명 | 데이터 타입 | 범위/허용값 | 필수 여부 | 설명 |
|---|---|---|---|---|
| `key_number` | int | 양의 정수 | Y | 고유 식별 번호 |
| `reward_margin_min` | int | 0 이상 정수 | Y | 보상 마진 하한 (gold) |
| `reward_margin_max` | int | reward_margin_min 이상 | Y | 보상 마진 상한 (gold) |
| `in_use` | bool | `[true, false]` | Y | 활성화 여부 |

---

### 테이블명: `pst_ingame_reward_config`
담당: 02_경제_밸런스

> 인게임 콤보 보상 및 덱 잔여 카드 보상의 기본값·증가 규칙·상한 정의.
> PST_const.json의 `ingame_combo_reward_*`, `remaining_deck_reward_*` 상수에서 파생.

| 컬럼명 | 데이터 타입 | 범위/허용값 | 필수 여부 | 설명 |
|---|---|---|---|---|
| `key_number` | int | 양의 정수 | Y | 고유 식별 번호 |
| `reward_source` | enum | `[combo, remaining_deck]` | Y | 보상 발생 경로 |
| `base_amount` | int | 0 이상 정수 | Y | 기본 지급량 (gold) |
| `amount_increase` | int | 0 이상 정수 | Y | 레벨 구간당 증가량 |
| `amount_max_cap` | int | base_amount 이상 | Y | 보상 상한 (gold) |
| `level_interval` | int | 1 이상 정수 | Y | 증가 적용 레벨 간격 |
| `level_increase` | int | 0 이상 정수 | Y | 간격당 레벨 증가 수치 |
| `in_use` | bool | `[true, false]` | Y | 활성화 여부 |

---

### 테이블명: `pst_item_definition`
담당: 02_경제_밸런스

> 모든 아이템(재화, 부스터, 무한 아이템, 기믹 보상)의 정의 및 속성.
> PST_item_list.json에서 파생.

| 컬럼명 | 데이터 타입 | 범위/허용값 | 필수 여부 | 설명 |
|---|---|---|---|---|
| `key_number` | int | 양의 정수 | Y | 고유 식별 번호 |
| `name_key` | string | snake_case 문자열 | Y | 아이템 식별 키 |
| `item_type` | enum | `[currency, booster, infinite, gimmick]` | Y | 아이템 유형 |
| `usage_type` | enum | `[inventory, immediate]` | Y | 사용 방식 |
| `entry_cost_ratio` | int | 0 ~ 10000 | Y | 입장비 대비 아이템 비용 비율 (분모 10000). 계산식: `아이템_비용 = entry_cost_base × entry_cost_ratio ÷ 10000`. 예: entry_cost_ratio = 5000이면 입장비의 50%. currency 및 gimmick 유형은 0으로 표기 (비용 없음) |
| `interval_type` | enum | `[none, fixed, tier_undo, tier_extra_deck]` | Y | 사용 횟수 증가 방식 |
| `use_count_increase_rate` | int | 0 ~ 10000 | Y | 횟수 증가율 (분모 10000) |
| `use_count_max_ratio` | int | 0 ~ 30000 | Y | 최대 횟수 배율 (분모 10000) |
| `duration_sec` | int | 0 이상 정수 | Y | 무한 아이템 지속 시간 (초, 비무한 아이템은 0) |
| `target_name_key` | string | snake_case 문자열 또는 `none` | Y | 무한 아이템이 대체하는 원본 아이템 키 |
| `in_use` | bool | `[true, false]` | Y | 활성화 여부 |

---

### 테이블명: `pst_product_definition`
담당: 02_경제_밸런스

> 상점 판매 상품 정의 (IAP, 광고 기반, 스페셜 오퍼 포함). 최대 5종 복합 보상 구조.
> PST_product.json에서 파생.

| 컬럼명 | 데이터 타입 | 범위/허용값 | 필수 여부 | 설명 |
|---|---|---|---|---|
| `key_number` | int | 양의 정수 | Y | 고유 식별 번호 |
| `product_name` | string | 대문자 + 언더스코어 문자열 | Y | 상품 표시 키 |
| `product_id` | string | 소문자 + 언더스코어 문자열 | Y | 스토어 상품 ID |
| `pay_type` | enum | `[IAP, AD]` | Y | 결제 유형 |
| `pay_amount` | float | 0.0 이상 | Y | 결제 금액 (USD, AD는 0.0) |
| `reward_type_1` | string | item name_key 또는 `none` | Y | 1번 보상 아이템 키 |
| `reward_amount_1` | int | 0 이상 정수 | Y | 1번 보상 수량 |
| `reward_type_2` | string | item name_key 또는 `none` | N | 2번 보상 아이템 키 |
| `reward_amount_2` | int | 0 이상 정수 | N | 2번 보상 수량 |
| `reward_type_3` | string | item name_key 또는 `none` | N | 3번 보상 아이템 키 |
| `reward_amount_3` | int | 0 이상 정수 | N | 3번 보상 수량 |
| `reward_type_4` | string | item name_key 또는 `none` | N | 4번 보상 아이템 키 |
| `reward_amount_4` | int | 0 이상 정수 | N | 4번 보상 수량 |
| `reward_type_5` | string | item name_key 또는 `none` | N | 5번 보상 아이템 키 |
| `reward_amount_5` | int | 0 이상 정수 | N | 5번 보상 수량 |
| `shop_order` | int | 1 이상 정수 | Y | 상점 내 노출 순서 |
| `label_type` | enum | `[none, most_popular, best_value]` | Y | 상품 레이블 |
| `limit_type` | enum | `[none, day, global, event, city]` | Y | 구매 제한 유형 |
| `pay_limit` | int | 0 이상 정수 | Y | 최대 구매 횟수 (0 = 무제한) |
| `max_display_count` | int | 0 이상 정수 | Y | 최대 노출 횟수 (0 = 무제한) |
| `validity_duration_sec` | int | 0 이상 정수 | Y | 상품 노출 유효 기간 (초, 0 = 영구) |
| `display_priority` | int | 0 이상 정수 | Y | 팝업 노출 우선순위 (0 = 일반) |
| `dismiss_cooldown_sec` | int | 0 이상 정수 | Y | 팝업 재노출 대기 시간 (초) |
| `in_use` | bool | `[true, false]` | Y | 활성화 여부 |

---

### 테이블명: `pst_daily_gift_schedule`
담당: 02_경제_밸런스

> 7일 주기 출석 보상 스케줄. 최대 3종 복합 보상 구조.
> PST_daily_gift.json에서 파생.

| 컬럼명 | 데이터 타입 | 범위/허용값 | 필수 여부 | 설명 |
|---|---|---|---|---|
| `key_number` | int | 양의 정수 | Y | 고유 식별 번호 |
| `day` | int | 0 ~ 6 | Y | 출석 일차 (0-indexed) |
| `reward_item_key_1` | string | item name_key | Y | 1번 보상 아이템 키 |
| `reward_amount_1` | int | 1 이상 정수 | Y | 1번 보상 수량 |
| `reward_item_key_2` | string | item name_key 또는 `none` | N | 2번 보상 아이템 키 |
| `reward_amount_2` | int | 0 이상 정수 | N | 2번 보상 수량 |
| `reward_item_key_3` | string | item name_key 또는 `none` | N | 3번 보상 아이템 키 |
| `reward_amount_3` | int | 0 이상 정수 | N | 3번 보상 수량 |
| `in_use` | bool | `[true, false]` | Y | 활성화 여부 |

---

### 테이블명: `pst_daily_task_pool`
담당: 02_경제_밸런스

> 매일 유저에게 제시되는 태스크 풀. 난이도 3단계, 다양한 태스크 타입·조건 포함.
> PST_daily_task.json에서 파생.

| 컬럼명 | 데이터 타입 | 범위/허용값 | 필수 여부 | 설명 |
|---|---|---|---|---|
| `key_number` | int | 양의 정수 | Y | 고유 식별 번호 |
| `difficulty` | int | `[1, 2, 3]` | Y | 태스크 난이도 (1=쉬움, 3=어려움) |
| `task_type` | enum | `[play_level, win_level, clear_card, clear_color, get_streak, collect_star, match_card, use_booster, watch_ad, send_gift, share_feed, invite_friend, tournament]` | Y | 태스크 종류 |
| `target_val` | int | 1 이상 정수 | Y | 달성 목표 수치 |
| `condition_detail` | string | item name_key, 색상 코드, 조건 문자열 또는 `none` | Y | 세부 조건 (색상·아이템·행동 타입 등) |
| `reward_item_key` | string | item name_key | Y | 보상 아이템 키 |
| `reward_amount` | int | 1 이상 정수 | Y | 보상 수량 |
| `milestone_point` | int | 1 이상 정수 | Y | 태스크 완료 시 획득 마일스톤 포인트 |
| `in_use` | bool | `[true, false]` | Y | 활성화 여부 |

---

### 테이블명: `pst_streak_reward_pool`
담당: 02_경제_밸런스

> 스트릭 달성 시 가챠로 지급되는 보상 풀. 연속 매칭 길이·가챠율·보상 유형 정의.
> PST_streak_reward.json에서 파생.

| 컬럼명 | 데이터 타입 | 범위/허용값 | 필수 여부 | 설명 |
|---|---|---|---|---|
| `key_number` | int | 양의 정수 | Y | 고유 식별 번호 |
| `gacha_group_id` | int | 1 이상 정수 | Y | 가챠 확률 합산 검증 그룹 ID. 동일 `gacha_group_id`를 가진 행들의 `gacha_rate` 합산이 10000이어야 함 (VAL-003 GROUP BY 기준) |
| `gacha_rate` | int | 0 ~ 10000 | Y | 가챠 선택 가중치 (분모 10000) |
| `req_length` | int | 1 이상 정수 | Y | 스트릭 발동에 필요한 연속 매칭 수 |
| `reward_item_key` | string | item name_key | Y | 보상 아이템 키 |
| `reward_type` | enum | `[fixed, tier_combo_reward]` | Y | 보상 수량 결정 방식 |
| `reward_amount` | int | 0 이상 정수 | Y | 보상 수량 (tier_combo_reward 시 0으로 표기, 런타임 계산) |
| `reward_star_amount` | int | 0 이상 정수 | Y | 지급되는 스트릭 스타 수 |
| `in_use` | bool | `[true, false]` | Y | 활성화 여부 |

---

### 테이블명: `pst_event_schedule`
담당: 03_게임_밸런스

> 이벤트 유형별 스케줄 (시작/종료 요일, 반복 주기, 활성화 여부).
> PST_event_schedule.json에서 파생.

| 컬럼명 | 데이터 타입 | 범위/허용값 | 필수 여부 | 설명 |
|---|---|---|---|---|
| `key_number` | int | 양의 정수 | Y | 고유 식별 번호 |
| `event_type` | enum | `[black_card_milestone, red_card_milestone, winning_milestone, clear_ranking]` | Y | 이벤트 유형 |
| `start_day` | int | 0 ~ 6 | Y | 시작 요일 (0=일요일 기준 또는 base_date 기준 확인 필요) |
| `end_day` | int | 0 ~ 6 | Y | 종료 요일 |
| `start_time` | string | `HH:MM` 형식 | Y | 일별 시작 시각 |
| `end_time` | string | `HH:MM` 형식 | Y | 일별 종료 시각 |
| `repeat` | bool | `[true, false]` | Y | 주기적 반복 여부 |
| `base_date` | string | `YYYY-MM-DD` 형식 | Y | 스케줄 기준 시작일 |
| `interval_week` | int | 1 이상 정수 | Y | 반복 주기 (주 단위) |
| `in_use` | bool | `[true, false]` | Y | 활성화 여부 |

---

### 테이블명: `pst_event_milestone_step`
담당: 02_경제_밸런스

> 이벤트 마일스톤의 단계별 목표 수치 및 보상 정의.
> PST_event_milestone.json에서 파생.

| 컬럼명 | 데이터 타입 | 범위/허용값 | 필수 여부 | 설명 |
|---|---|---|---|---|
| `key_number` | int | 양의 정수 | Y | 고유 식별 번호 |
| `event_id` | int | pst_event_schedule.key_number 참조 | Y | 연결된 이벤트 식별자 |
| `step` | int | 1 이상 정수 | Y | 마일스톤 단계 번호 (1부터 순서대로) |
| `goal_type` | enum | `[collect_color, earn_point]` | Y | 목표 유형 |
| `goal_param` | string | 색상명 또는 `none` | Y | 목표 세부 파라미터 |
| `goal_amount` | int | 1 이상 정수 | Y | 단계 달성 누적 목표 수치 |
| `reward_item_key` | string | item name_key | Y | 보상 아이템 키 |
| `reward_amount` | int | 1 이상 정수 | Y | 보상 수량 |
| `in_use` | bool | `[true, false]` | Y | 활성화 여부 |

---

### 테이블명: `pst_free_currency_source`
담당: 02_경제_밸런스

> 무료 재화 지급 경로별 한도 및 지급량 정의.
> PST_const.json의 `shop_free_gold_*`, `inbox_free_gold_*`, `popup_free_gold_*` 상수에서 파생.
> `daily_wheel_ad` 항목의 일일 횟수 한도는 PST_const.json 10027(`daily_wheel_ad_limit`)에서 확인 가능.
> 단, `daily_wheel_ad`의 1회 지급 수량(`amount_per_claim`)에 해당하는 상수가 PST_const.json에 존재하지 않음 — **데이터 없음: 02 에이전트 조사 필요** (PST_item_list.json, PST_daily_gift.json 등 추가 파일에서 출처 확인 요망).

| 컬럼명 | 데이터 타입 | 범위/허용값 | 필수 여부 | 설명 |
|---|---|---|---|---|
| `key_number` | int | 양의 정수 | Y | 고유 식별 번호 |
| `source_type` | enum | `[shop_ad, inbox, popup, daily_wheel_ad]` | Y | 지급 경로 유형 |
| `currency_type` | enum | `[gold, ticket, streak_star]` | Y | 지급 통화 유형 |
| `daily_limit` | int | 0 이상 정수 | Y | 일일 수령 횟수 한도 (0 = 무제한). `daily_wheel_ad` 참조: PST_const.json 10027 |
| `amount_per_claim` | int | 1 이상 정수 | Y | 1회 수령 수량. `daily_wheel_ad` 지급량: **데이터 없음 — 02 에이전트 조사 필요** |
| `in_use` | bool | `[true, false]` | Y | 활성화 여부 |

---

## 3. 공통 필수 컬럼 정의

모든 테이블에 반드시 포함되어야 하는 공통 컬럼.

| 컬럼명 | 타입 | 설명 |
|---|---|---|
| `key_number` | int | 전체 PST 데이터 내 고유 식별 번호 (1xxxx ~ 20xxxx 대역) |
| `in_use` | bool | 현재 활성화 여부 플래그; false 항목은 런타임에서 무시됨 |

---

## 4. 검증 규칙 목록

| 규칙 ID | 규칙 설명 | 통과 기준 | 실패 기준 | 대상 테이블 |
|---|---|---|---|---|
| VAL-001 | key_number 중복 금지 | 테이블 내 모든 key_number가 유일함 | 동일 key_number가 2개 이상 존재 | 전체 테이블 |
| VAL-002 | in_use 타입 검증 | in_use 값이 boolean (true/false)임 | 정수·문자열 등 다른 타입 사용 | 전체 테이블 |
| VAL-003 | 확률값 합산 검증 | 동일 `gacha_group_id` 그룹 내 `gacha_rate` 합산 = 10000 (GROUP BY gacha_group_id) | 합산값이 10000 미만 또는 초과 | `pst_streak_reward_pool` |
| VAL-004 | 비용 상한 일관성 | cost_max_cap >= base_cost | cost_max_cap < base_cost | `pst_entry_cost_config` |
| VAL-005 | 보상 마진 범위 일관성 | reward_margin_max >= reward_margin_min | reward_margin_max < reward_margin_min | `pst_reward_margin_config` |
| VAL-006 | 보상 상한 일관성 | amount_max_cap >= base_amount | amount_max_cap < base_amount | `pst_ingame_reward_config` |
| VAL-007 | 무료 지급 통화 상한 초과 방지 | 일일 무료 지급 총합 <= gold_max_limit (pst_currency_config 참조) | 일일 무료 지급 총합 > gold_max_limit | `pst_free_currency_source`, `pst_daily_gift_schedule` |
| VAL-008 | 이벤트 마일스톤 step 단조 증가 | 동일 event_id 내 goal_amount가 step 순서에 따라 엄격히 증가 | 이전 step의 goal_amount >= 현재 step의 goal_amount | `pst_event_milestone_step` |
| VAL-009 | 출석 보상 day 범위 검증 | day 값이 0 ~ 6 범위 내 | day < 0 또는 day > 6 | `pst_daily_gift_schedule` |
| VAL-010 | 출석 보상 day 중복 금지 | 모든 day 값이 유일함 | 동일 day 값이 2개 이상 존재 | `pst_daily_gift_schedule` |
| VAL-011 | IAP 결제 금액 양수 검증 | pay_type = IAP인 경우 pay_amount > 0 | pay_type = IAP이고 pay_amount = 0 | `pst_product_definition` |
| VAL-012 | AD 결제 금액 0 검증 | pay_type = AD인 경우 pay_amount = 0 | pay_type = AD이고 pay_amount > 0 | `pst_product_definition` |
| VAL-013 | 보상 수량 양수 검증 | in_use = true인 모든 항목의 1번 보상 수량 >= 1 | reward_amount_1 < 1 이고 in_use = true | `pst_product_definition`, `pst_daily_gift_schedule`, `pst_event_milestone_step`, `pst_daily_task_pool` |
| VAL-014 | 무한 아이템 duration_sec 양수 검증 | item_type = infinite인 경우 duration_sec >= 1 | item_type = infinite이고 duration_sec = 0 | `pst_item_definition` |
| VAL-015 | 무한 아이템 target_name_key 존재 검증 | item_type = infinite인 경우 target_name_key != `none` | item_type = infinite이고 target_name_key = `none` | `pst_item_definition` |
| VAL-016 | 스트릭 req_length 최소값 검증 | req_length >= 1 | req_length < 1 | `pst_streak_reward_pool` |
| VAL-017 | 이벤트 스케줄 기간 유효성 | start_day != end_day 또는 start_time < end_time | 동일 day이면서 start_time >= end_time | `pst_event_schedule` |
| VAL-018 | product_id 중복 금지 | 모든 product_id가 유일함 | 동일 product_id가 2개 이상 존재 | `pst_product_definition` |
| VAL-019 | 스페셜 오퍼 노출 유효기간 검증 | limit_type in [event, city, global]인 경우 validity_duration_sec > 0 | 해당 limit_type이고 validity_duration_sec = 0 | `pst_product_definition` |
| VAL-020 | 데일리 태스크 난이도 단조 목표 | 동일 task_type·condition_detail 조합에서 difficulty 증가 시 target_val도 증가 | 높은 difficulty의 target_val <= 낮은 difficulty의 target_val | `pst_daily_task_pool` |

---

## 5. 참조 아이템 키 목록 (구조 파악용)

> 수치가 아닌 식별자 목록. 실제 아이템 유효성 검증(VAL-013 등)의 기준 집합으로 활용.

| 아이템 키 | 유형 |
|---|---|
| `currency_gold` | currency |
| `currency_hammer` | currency |
| `currency_ticket` | currency |
| `currency_streak_star` | currency |
| `currency_puzzle_piece` | currency |
| `booster_fireworks` | booster |
| `booster_golden_ticket` | booster |
| `booster_undo` | booster |
| `booster_wild_card` | booster |
| `booster_extra_deck` | booster |
| `infinite_fireworks_5m` | infinite |
| `infinite_fireworks_10m` | infinite |
| `infinite_fireworks_15m` | infinite |
| `infinite_gticket_5m` | infinite |
| `infinite_gticket_10m` | infinite |
| `infinite_gticket_15m` | infinite |
| `infinite_ticket_5m` | infinite |
| `infinite_ticket_10m` | infinite |
| `infinite_ticket_15m` | infinite |
| `reward_plus_card_1` | gimmick |
| `booster_infinite_undo_15m` | infinite (가설: PST_item_list에 미등재, event_milestone에서 발견) |
| `booster_infinite_undo_30m` | infinite (가설: PST_item_list에 미등재, event_milestone에서 발견) |

> **가설 명시:** `booster_infinite_undo_15m`, `booster_infinite_undo_30m`은 `PST_event_milestone.json`에서 보상으로 등장하나 `PST_item_list.json`에 정식 등재되지 않음. 아이템 정의 누락 가능성이 있음. 02_경제_밸런스 에이전트가 수치 입력 전 확인 필요.

---

## 수정 이력

> CP1 Adjust 판정 반영 — 2026-02-20T19:30:00+09:00

| 번호 | 우선순위 | 대상 | 수정 내용 |
|---|---|---|---|
| 1 | 높음 | `pst_streak_reward_pool` | `gacha_group_id` 컬럼 추가 (int, 1 이상). VAL-003 검증 규칙에 `GROUP BY gacha_group_id` 기준 명시. 동일 그룹 내 `gacha_rate` 합산 = 10000 검증 가능하도록 수정 |
| 2 | 높음 | `pst_item_definition` | `entry_cost_ratio` 컬럼 설명에 계산식 명시: `아이템_비용 = entry_cost_base × entry_cost_ratio ÷ 10000`. 예시(0.5 = 입장비의 50%) 및 currency·gimmick 유형은 0 표기 규칙 추가 |
| 3 | 중간 | `pst_currency_config` | `param_category` enum에 `idle_charge`(PST_const.json 10002~10006 대역), `ingame_earn`(10028~10031 대역) 두 범주 추가. 각 범주 설명 컬럼에 참조 key_number 대역 명시 |
| 4 | 중간 | `pst_free_currency_source` | `daily_wheel_ad`의 1회 지급 수량(`amount_per_claim`) 참조 출처가 PST_const.json에 없음을 확인. 테이블 주석 및 컬럼 설명에 "데이터 없음 — 02 에이전트 조사 필요" 명시. 일일 횟수 한도는 PST_const.json 10027(`daily_wheel_ad_limit`) 참조 가능함을 병기 |
| 5 | 낮음 | `pst_item_definition` (Section 5) | `booster_infinite_undo_15m`, `booster_infinite_undo_30m`을 참조 아이템 키 목록에 가설로 포함. "(가설: PST_event_milestone.json 등장, PST_item_list.json 미등재)" 표기 및 가설 명시 주석 추가 |
