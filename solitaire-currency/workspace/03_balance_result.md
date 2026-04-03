---
agent: 03_game_balance
mode: phase-b
scope: PST 재화 시스템 (난이도·밸런스 관점)
executed: 2026-02-20T19:40:00+09:00
status: complete
schema_ref: workspace/04_schema_template.md
---

# PST 재화 시스템 — 스키마 기반 밸런스 설계 (Phase-B)

> 본 문서는 03_게임_밸런스 에이전트 담당 테이블인 `pst_event_schedule`과,
> 난이도 곡선·승률 가설·확률 테이블을 설계한다.
> 모든 수치는 reference JSON에서 직접 추출하거나, 추정 시 반드시 "가설" 표기 및 근거를 명시한다.
> CCS 열은 외부 리서치 권한 없음으로 전항목 "미확인" 처리한다.

---

## 1. 담당 테이블: `pst_event_schedule`

스키마 출처: `workspace/04_schema_template.md` — 테이블명 `pst_event_schedule` (담당: 03_게임_밸런스)
데이터 출처: `reference/PST_event_schedule.json`

스키마 정의 컬럼:
`key_number` / `event_type` / `start_day` / `end_day` / `start_time` / `end_time` / `repeat` / `base_date` / `interval_week` / `in_use`

### 1-1. 원문 추출 (PST_event_schedule.json)

원본 JSON에서 직접 추출한 값:

| key_number | type (원본) | start_day | end_day | start_time | end_time | repeat | base_date  | interval_week | in_use |
|---|---|---|---|---|---|---|---|---|---|
| 160001 | black_card_milestone | 1 | 3 | 0:00 | 23:59 | true | 2026-01-01 | 1 | true |
| 160002 | red_card_milestone   | 4 | 6 | 0:00 | 23:59 | true | 2026-01-01 | 1 | true |
| 160003 | winning_milestone    | 2 | 4 | 0:00 | 23:59 | true | 2026-01-01 | 1 | true |
| 160004 | clear_ranking        | 5 | 0 | 0:00 | 23:59 | true | 2026-01-01 | 1 | true |

주의: 원본 필드명은 `type`이나 스키마 컬럼명은 `event_type`임. 매핑 처리.
주의: 원본 `start_time/end_time` 값 `"0:00"/"23:59"`을 스키마 HH:MM 형식으로 `"00:00"/"23:59"` 표기.

### 1-2. 스키마 정규화 테이블

| key_number | event_type | start_day | end_day | start_time | end_time | repeat | base_date  | interval_week | in_use |
|---|---|---|---|---|---|---|---|---|---|
| 160001 | black_card_milestone | 1 | 3 | 00:00 | 23:59 | true | 2026-01-01 | 1 | true |
| 160002 | red_card_milestone   | 4 | 6 | 00:00 | 23:59 | true | 2026-01-01 | 1 | true |
| 160003 | winning_milestone    | 2 | 4 | 00:00 | 23:59 | true | 2026-01-01 | 1 | true |
| 160004 | clear_ranking        | 5 | 0 | 00:00 | 23:59 | true | 2026-01-01 | 1 | true |

### 1-3. VAL-017 검증 (이벤트 스케줄 기간 유효성)

규칙: start_day != end_day 이거나, 동일 day이면서 start_time < end_time이어야 함.

| key_number | start_day | end_day | start_day == end_day? | start_time < end_time? | VAL-017 |
|---|---|---|---|---|---|
| 160001 | 1 | 3 | No | - | PASS |
| 160002 | 4 | 6 | No | - | PASS |
| 160003 | 2 | 4 | No | - | PASS |
| 160004 | 5 | 0 | No | - | PASS |

전 항목 VAL-017 통과.

### 1-4. 이벤트 운영 스케줄 시각화 (start_day 기준, 0=일요일)

| 이벤트 유형 | 운영 요일 | 기간 (일수) | 중복 운영 여부 |
|---|---|---|---|
| black_card_milestone | 월(1) ~ 수(3) | 3일 | winning_milestone과 화(2)~수(3) 중복 |
| red_card_milestone   | 목(4) ~ 토(6) | 3일 | winning_milestone과 목(4) 중복 |
| winning_milestone    | 화(2) ~ 목(4) | 3일 | black/red 이벤트와 각각 중복 |
| clear_ranking        | 금(5) ~ 일(0) | 2일 (토~일) | red_card와 토(6) 중복 |

비고: 이벤트 중복 운영 구간 존재 (화/수: black + winning, 목: red + winning, 토: red + clear_ranking). 설계 의도 미기재 — 가설: 복수 이벤트 동시 참여를 통한 참여 동기 상승.

---

## 2. 난이도 곡선 표 (티어별, 스키마 컬럼 준수)

스키마 컬럼 기준: PST_difficulty_tier.json 원본 구조 + Phase-B 설계 컬럼 추가.
컬럼 구성: `tier_id` / `display_name` / `score_min` / `score_max` / `help_card_rate` / `pity_trigger_count` / `streak_sustain_count` / `reward_hammer` / `예상 체류 비율(%)` / `PST 레퍼런스` / `PBM 레퍼런스` / `CCS 레퍼런스` / `비고`

데이터 출처: `reference/PST_difficulty_tier.json` (key_number 20001~20004), `reference/PST_dynamic_level.json` (key_number 30001~30008)

| tier_id | display_name | score_min | score_max | help_card_rate (분모10000) | pity_trigger_count | streak_sustain_count | reward_hammer | 예상 체류 비율(%) | PST 레퍼런스 | PBM 레퍼런스 | CCS 레퍼런스 | 비고 |
|---|---|---|---|---|---|---|---|---|---|---|---|---|
| 1 | Tutorial    | 0   | 100  | 8000 | 3  | 5 | 1 | 가설: 10~15% | key_number 20001; dynamic_level 30001 (user_level 1~8 강제 Tutorial) | tier 1~2 empty_tile 57~66 (완화 구간), score_multiplier 10000 | 미확인 | 신규 유저 보호 구간. 레벨 1~8 강제 적용. help_card_rate 80%로 최고 지원 |
| 2 | Normal      | 101 | 350  | 5000 | 5  | 4 | 1 | 가설: 50~60% | key_number 20002; dynamic_level 30008 (default=Normal), 30003 (fail_streak 2→Normal), 30004 (hard_cooldown 5→Normal) | tier 3~8 empty_tile 46~56 (점진 상승), score_multiplier 10000 | 미확인 | DDA default 티어. fail_streak 2회 즉시 복귀. 다수 유저 체류 예상 |
| 3 | Hard        | 351 | 700  | 2000 | 8  | 3 | 2 | 가설: 20~25% | key_number 20003; dynamic_level 30007 (hard_guarantee 15회→Hard) | tier 9~15 empty_tile 33~44, score_multiplier 11000~12000 | 미확인 | 누적 15회 플레이 보장 진입. pity 8회로 완화 빈도 줄어듦 |
| 4 | Super Hard  | 701 | 9999 | 0    | 99 | 2 | 3 | 가설: 10~15% | key_number 20004; dynamic_level 30005 (win_streak 7→Super Hard), 30006 (super_hard_guarantee 30→Super Hard) | tier 16~20 small_w 재상승 + score_multiplier 12000~12500 (보상형 완화) | 미확인 | help_card_rate=0, pity=99로 사실상 보호 없음. 재화 소비 집중 구간 |

### 2-1. 예상 체류 비율 가설 근거

모든 비율 수치는 "가설"이며 실측 유저 분포 데이터 미보유. 근거는 DDA 룰 구조에서 추출.

- Tutorial(10~15%): dynamic_level 30001에서 user_level 1~8로 강제 지정. 초반 이탈 감소 목적. 레벨 1~8 구간이 전체 플레이 기간에서 차지하는 비중이 상대적으로 작음.
- Normal(50~60%): dynamic_level 30008 default=Normal, 30003 fail_streak 2연패 즉시 Normal 복귀. 가장 많은 유저가 체류할 기본값 티어.
- Hard(20~25%): dynamic_level 30007 hard_guarantee 15회 기준 진입 보장. pity 8회로 완화되나 빈도는 줄어듦.
- Super Hard(10~15%): dynamic_level 30005 win_streak 7연승 조건. 달성 유저 비율이 낮을 것으로 예상.

---

## 3. 승률 가설 표

> 모든 승률 수치는 "가설". 실측 데이터 미보유. PST_difficulty_tier.json + PST_dynamic_level.json 파라미터 기반 추정.

| 티어 | 레벨 구간 | 예상 승률(%) | 가설 | 가설 근거 | 레퍼런스 파라미터 |
|---|---|---|---|---|---|
| Tutorial (tier_id=1) | 레벨 1~8 (user_level_range 1~8) | 가설: 70~80% | 가설 | help_card_rate=8000(80%)로 최고 지원. pity_trigger_count=3으로 가장 빠른 완화 발동. streak_sustain_count=5로 연승 허용 범위 넓음. | PST_difficulty_tier key_number 20001: help_card_rate=8000, pity_trigger_count=3, streak_sustain_count=5 |
| Tutorial → Normal 전환 구간 (tier_id=1→2) | 레벨 9~10 (user_level_specific) | 가설: 60~70% | 가설 | dynamic_level 30002에서 레벨 9~10을 Normal로 완충 전환. Tutorial 직후 급격한 난이도 상승 방지 설계. | PST_dynamic_level key_number 30002: condition_type=user_level_specific, param_1=9, param_2=10, result_tier_id=2 |
| Normal (tier_id=2) | 레벨 10 이후 default 구간 | 가설: 55~65% | 가설 | default 티어로 최다 유저 체류. help_card_rate=5000(50%), pity_trigger_count=5. fail_streak 2연패 즉시 Normal 복귀로 하한 방어. | PST_difficulty_tier key_number 20002: help_card_rate=5000, pity_trigger_count=5; PST_dynamic_level 30003: fail_streak=2 |
| Hard (tier_id=3) | hard_guarantee 15회 플레이 이후 진입 구간 | 가설: 45~55% | 가설 | help_card_rate=2000(20%)으로 지원 대폭 감소. pity_trigger_count=8로 완화 빈도 하락. hard_cooldown 5회 경과 시 Normal 복귀(30004) → 체류 한시적. | PST_difficulty_tier key_number 20003: help_card_rate=2000, pity_trigger_count=8; PST_dynamic_level 30004: hard_cooldown=5 |
| Super Hard (tier_id=4) | win_streak 7연승 달성 이후 구간 | 가설: 35~45% | 가설 | help_card_rate=0(도움 카드 없음), pity_trigger_count=99(사실상 완화 없음). streak_sustain_count=2로 가장 낮음. 고스킬 유저 또는 재화 소비 유저 대상. | PST_difficulty_tier key_number 20004: help_card_rate=0, pity_trigger_count=99, streak_sustain_count=2; PST_dynamic_level 30005: win_streak=7 |

### 3-1. 승률 가설 보완: 기믹 조합 영향

출처: `reference/PST_gimmick_weight.json` (key_number 210001~210004)

기믹은 맵 score_weight를 통해 동일 티어 내 체감 난이도를 조정함.
기믹이 승률에 미치는 영향은 "가설"이며, 체감 난이도 변동 범위를 통한 간접 추정.

| 기믹 조합 시나리오 | 맵 score_weight 합산 변화 | 체감 난이도 방향 | 승률 영향 (가설) | 레퍼런스 파라미터 |
|---|---|---|---|---|
| plus_card 5개 (최대) | -10 × 5 = -50 | 난이도 완화 최대 | 승률 +5~10%p 수준 (가설) | key_number 210001: map_score_weight=-10, max_gimmick_count=5 |
| runner_card 5개 (최대) | +40 × 5 = +200 | 난이도 상승 최대 | 승률 -10~15%p 수준 (가설) | key_number 210003: map_score_weight=+40, max_gimmick_count=5 |
| rope_card 5개 (최대) | +30 × 5 = +150 | 난이도 상승 중간 | 승률 -8~12%p 수준 (가설) | key_number 210002: map_score_weight=+30, max_gimmick_count=5 |
| lock_key 5개 (최대) | +20 × 5 = +100 | 난이도 상승 | 승률 -5~8%p 수준 (가설) | key_number 210004: map_score_weight=+20, max_gimmick_count=5 |
| plus_card 3 + runner_card 2 혼합 | -30 + 80 = +50 | 소폭 상승 | 기준 대비 -3~5%p (가설) | key_number 210001, 210003 조합 |

비고: 기믹 등장 빈도(확률)가 PST_gimmick_weight.json에 미기재. 위 수치는 max_gimmick_count 상한 기준 최악/최선 시나리오 가설이며, 실제 맵 생성 로직의 기믹 배분 확률 없이는 평균 승률 영향 계산 불가.

---

## 4. 확률 테이블 (합계 10000 검증 포함)

### 4-1. help_card_rate 티어별 확률 테이블

출처: `reference/PST_difficulty_tier.json`
기준: 각 티어에서 help_card 등장 여부의 이진 확률.

#### Tutorial (tier_id=1, key_number=20001)

| 항목명 | 확률값 | 비고 |
|---|---|---|
| help_card 등장 | 8000 | 도움 카드 등장 확률 80% |
| help_card 미등장 | 2000 | 도움 카드 없이 일반 카드만 |
| 합계 | 10000 | PASS |

#### Normal (tier_id=2, key_number=20002)

| 항목명 | 확률값 | 비고 |
|---|---|---|
| help_card 등장 | 5000 | 도움 카드 등장 확률 50% |
| help_card 미등장 | 5000 | 도움 카드 없이 일반 카드만 |
| 합계 | 10000 | PASS |

#### Hard (tier_id=3, key_number=20003)

| 항목명 | 확률값 | 비고 |
|---|---|---|
| help_card 등장 | 2000 | 도움 카드 등장 확률 20% |
| help_card 미등장 | 8000 | 도움 카드 없이 일반 카드만 |
| 합계 | 10000 | PASS |

#### Super Hard (tier_id=4, key_number=20004)

| 항목명 | 확률값 | 비고 |
|---|---|---|
| help_card 등장 | 0 | 도움 카드 등장 없음 |
| help_card 미등장 | 10000 | 일반 카드만 |
| 합계 | 10000 | PASS |

---

### 4-2. 기믹 등장 weight 비율 환산 테이블 (가설)

출처: `reference/PST_gimmick_weight.json`
주의: 원본 `map_score_weight` 필드는 맵 난이도 점수 가중치이며, 등장 선택 확률이 아님.
기믹 선택 확률(spawn_rate/weight) 필드가 PST_gimmick_weight.json에 미존재.

아래는 map_score_weight의 절댓값을 가중치로 사용하여 상대 비율로 환산한 가설 테이블임.
근거: map_score_weight 절댓값이 클수록 해당 기믹의 난이도 영향력이 큼 → 등장 빈도 설계에도 비례할 수 있다는 가설.

| 기믹 ID | map_score_weight 절댓값 | 상대 비율 환산 (분모 10000) | 비고 |
|---|---|---|---|
| gimmick_plus_card   | 10 | 가설: 1000 (10%) | key_number 210001, weight=-10 (절댓값 10) |
| gimmick_rope_card   | 30 | 가설: 3000 (30%) | key_number 210002, weight=+30 |
| gimmick_runner_card | 40 | 가설: 4000 (40%) | key_number 210003, weight=+40 |
| gimmick_lock_key    | 20 | 가설: 2000 (20%) | key_number 210004, weight=+20 |
| 합계 | 100 | 10000 | PASS |

검증: 10 + 30 + 40 + 20 = 100 (절댓값 합). 비율 환산: 1000 + 3000 + 4000 + 2000 = 10000 PASS.

경고: 이 확률 테이블은 실제 기믹 선택 확률 데이터가 없는 상태에서 map_score_weight 절댓값을 proxy로 사용한 가설임. 실제 게임 로직의 기믹 spawn 확률과 일치하지 않을 수 있음. 반드시 "가설" 표기 유지.

---

### 4-3. DDA 티어 전환 조건 우선순위 테이블 (참고)

출처: `reference/PST_dynamic_level.json`
이 테이블은 확률 테이블이 아닌 우선순위 룰 체인 구조이므로 확률 합산 검증 대상 아님.

| priority | condition_type | param_1 | param_2 | result_tier_id | key_number |
|---|---|---|---|---|---|
| 1  | user_level_range       | 1  | 8  | 1 (Tutorial)   | 30001 |
| 2  | user_level_specific    | 9  | 10 | 2 (Normal)     | 30002 |
| 3  | fail_streak            | 2  | 0  | 2 (Normal)     | 30003 |
| 4  | hard_cooldown          | 5  | 0  | 2 (Normal)     | 30004 |
| 5  | win_streak             | 7  | 0  | 4 (Super Hard) | 30005 |
| 6  | super_hard_guarantee   | 30 | 0  | 4 (Super Hard) | 30006 |
| 7  | hard_guarantee         | 15 | 0  | 3 (Hard)       | 30007 |
| 99 | default                | 0  | 0  | 2 (Normal)     | 30008 |

비고: priority 순서대로 조건 평가. 상위 조건 충족 시 하위 조건 미평가. default(priority=99)는 모든 조건 미충족 시 최종 적용.

---

## 5. 확률 합 검증 요약

| 테이블명 | 그룹/대상 | 합계 | 검증 결과 |
|---|---|---|---|
| help_card_rate — Tutorial | tier_id=1 | 8000 + 2000 = 10000 | PASS |
| help_card_rate — Normal   | tier_id=2 | 5000 + 5000 = 10000 | PASS |
| help_card_rate — Hard     | tier_id=3 | 2000 + 8000 = 10000 | PASS |
| help_card_rate — Super Hard | tier_id=4 | 0 + 10000 = 10000 | PASS |
| 기믹 weight 비율 환산 (가설) | 전체 기믹 | 1000 + 3000 + 4000 + 2000 = 10000 | PASS (가설 테이블) |

---

## 6. 데이터 한계 및 후속 과제

| 항목 | 상태 | 내용 |
|---|---|---|
| CCS 비교 | 미확인 | WebSearch/WebFetch 권한 없음. 전 항목 "미확인" 유지 |
| 기믹 실제 spawn_rate | 데이터 없음 | PST_gimmick_weight.json에 기믹 등장 확률 필드 미존재. 4-2 테이블은 가설 |
| 유저 티어별 실측 분포 | 데이터 없음 | 승률 및 체류 비율은 DDA 파라미터 기반 추정. 실측값 필요 |
| super_hard_guarantee / hard_guarantee 조건 기준 | 가설 | param_1(30, 15)의 집계 단위(누적 플레이 횟수 등) 미명시. PST_dynamic_level.json에 condition_type만 존재, 상세 로직 미기재 |
| 기믹 등장 상한 (max_gimmick_count=5) 티어별 차등 여부 | 미확인 | PST_gimmick_weight.json에서 max_gimmick_count=5 전 기믹 동일. 티어별 차등화 미적용 확인. 의도 미기재 |

---

*문서 종료. Phase-B 완료 (CCS 미확인 항목은 전항목 "미확인" 유지)*
