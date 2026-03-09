---
agent: 03_game_balance
mode: phase-a
scope: PST 재화 시스템 (난이도·밸런스 관점)
executed: 2026-02-20T18:10:00+09:00
status: partial
note: WebSearch/WebFetch 권한 없음 — CCS 외부 리서치 전항목 미확인 처리
---

# Phase-A 시장조사 리포트 — 게임 밸런스 에이전트 (03)

---

## 1. PST 난이도 구조 분석

### 1-1. PST_difficulty_tier.json 원문 추출

출처: `reference/PST_difficulty_tier.json`

| key_number | tier_id | display_name | score_min | score_max | reward_hammer | pity_trigger_count | streak_sustain_count | help_card_rate (분모10000) |
|---|---|---|---|---|---|---|---|---|
| 20001 | 1 | Tutorial    | 0    | 100  | 1 | 3  | 5 | 8000 |
| 20002 | 2 | Normal      | 101  | 350  | 1 | 5  | 4 | 5000 |
| 20003 | 3 | Hard        | 351  | 700  | 2 | 8  | 3 | 2000 |
| 20004 | 4 | Super Hard  | 701  | 9999 | 3 | 99 | 2 | 0    |

**수치 해설**
- `score_min/max`: 해당 티어가 적용되는 점수(레벨 내 누적 스코어 기준으로 추정) 범위
- `pity_trigger_count`: 연패 시 난이도 완화(pity) 발동 기준 횟수. Super Hard는 99로 사실상 pity 없음
- `streak_sustain_count`: 연승 지속 허용 횟수 (이 이후 상위 티어 전환 가능성 시사)
- `help_card_rate`: 도움 카드 등장 확률 (분모 10000). Tutorial=80%, Normal=50%, Hard=20%, Super Hard=0%
- `reward_hammer`: 클리어 보상 해머 수량. 티어 상승 시 1→3으로 증가

**PST 난이도 설계 특징**
- 4단계 티어(Tutorial/Normal/Hard/Super Hard) 구조
- Super Hard 구간에서 help_card_rate=0, pity_trigger_count=99로 사실상 도움 차단
- 클리어 보상(해머)이 난이도에 비례하여 증가 → 고난도 도전 인센티브 설계

---

### 1-2. PST_dynamic_level.json 원문 추출

출처: `reference/PST_dynamic_level.json`

| key_number | priority | condition_type           | param_1 | param_2 | result_tier_id |
|---|---|---|---|---|---|
| 30001 | 1  | user_level_range       | 1  | 8  | 1 (Tutorial)    |
| 30002 | 2  | user_level_specific    | 9  | 10 | 2 (Normal)      |
| 30003 | 3  | fail_streak            | 2  | 0  | 2 (Normal)      |
| 30004 | 4  | hard_cooldown          | 5  | 0  | 2 (Normal)      |
| 30005 | 5  | win_streak             | 7  | 0  | 4 (Super Hard)  |
| 30006 | 6  | super_hard_guarantee   | 30 | 0  | 4 (Super Hard)  |
| 30007 | 7  | hard_guarantee         | 15 | 0  | 3 (Hard)        |
| 30008 | 99 | default                | 0  | 0  | 2 (Normal)      |

**수치 해설**
- `user_level_range 1~8 → Tutorial`: 신규 유저(레벨 1~8) 전용 보호 구간
- `user_level_specific 9~10 → Normal`: 튜토리얼 이탈 직후 완충 구간
- `fail_streak 2 → Normal`: 2연패 시 Normal 강제 조정 (DDA 쿨다운)
- `hard_cooldown 5 → Normal`: Hard 상태 5회 경과 후 Normal 복귀 조건
- `win_streak 7 → Super Hard`: 7연승 달성 시 Super Hard 진입
- `super_hard_guarantee 30 → Super Hard`: 조건 미상 30회 기준으로 Super Hard 보장 (가설: 누적 플레이 횟수 기준)
- `hard_guarantee 15 → Hard`: 15회 기준 Hard 보장 (가설: 누적 플레이 횟수 기준)
- `default → Normal`: 상기 조건 미해당 시 Normal이 기본값

**PST DDA 설계 특징**
- 우선순위(priority) 기반 다단계 룰 체인 구조
- 명시적 fail_streak 감지 → 즉시 난이도 하향 (2연패 기준)
- 승리 streak와 플레이 보장 횟수를 통한 상향 트리거 병행 운영
- 기본값(Normal)을 중심으로 상하 양방향 조정이 가능한 대칭 설계

---

### 1-3. PST_gimmick_weight.json 원문 추출

출처: `reference/PST_gimmick_weight.json`

| key_number | gimmick_id         | map_score_weight | max_gimmick_count | required_tier |
|---|---|---|---|---|
| 210001 | gimmick_plus_card  | -10 | 5 | 1 (Tutorial~) |
| 210002 | gimmick_rope_card  | +30 | 5 | 1 (Tutorial~) |
| 210003 | gimmick_runner_card| +40 | 5 | 1 (Tutorial~) |
| 210004 | gimmick_lock_key   | +20 | 5 | 1 (Tutorial~) |

**수치 해설**
- `map_score_weight`: 해당 기믹이 맵 난이도 점수에 미치는 가중치
  - `plus_card(-10)`: 난이도 완화 기믹 (플러스 카드, 혜택 제공)
  - `rope_card(+30)`, `runner_card(+40)`: 난이도 상승 기믹 (제약 조건 추가)
  - `lock_key(+20)`: 중간 난이도 기믹
- `max_gimmick_count 5`: 맵당 최대 5개까지 동시 등장 (전 기믹 동일)
- `required_tier 1`: 모든 기믹이 Tutorial(tier_id=1)부터 등장 가능 (초반부터 노출)

**PST 기믹 설계 특징**
- 기믹 4종 (plus_card / rope_card / runner_card / lock_key)
- 긍정 기믹(plus_card, 난이도 감소)과 부정 기믹(rope/runner/lock, 난이도 증가) 혼합
- 기믹 조합으로 동일 티어 내에서 맵별 체감 난이도 변동 가능
- runner_card가 weight +40으로 가장 높은 난이도 기여

---

## 2. PBM 난이도 구조 분석

### 2-1. PBM_difficulty_tier.json 원문 추출

출처: `reference/PBM_difficulty_tier.json`

| tier | empty_tile_min | empty_tile_max | small_w | mid_w | large_w | phase_diff_key | score_multiplier |
|---|---|---|---|---|---|---|---|
| 1  | 64 | 66 | 30 | 50 | 20 | 80001 | 10000 |
| 2  | 57 | 64 | 28 | 50 | 22 | 80001 | 10000 |
| 3  | 55 | 56 | 26 | 50 | 24 | 80002 | 10000 |
| 4  | 53 | 52 | 24 | 50 | 26 | 80003 | 10000 |
| 5  | 52 | 51 | 22 | 50 | 28 | 80004 | 11000 |
| 6  | 50 | 49 | 20 | 50 | 30 | 80005 | 11000 |
| 7  | 48 | 47 | 20 | 50 | 30 | 80006 | 11000 |
| 8  | 47 | 46 | 20 | 50 | 30 | 80007 | 11000 |
| 9  | 45 | 44 | 20 | 50 | 30 | 80008 | 11500 |
| 10 | 43 | 42 | 20 | 50 | 30 | 80008 | 11500 |
| 11 | 41 | 40 | 20 | 50 | 30 | 80008 | 11500 |
| 12 | 39 | 38 | 20 | 50 | 30 | 80008 | 11500 |
| 13 | 38 | 37 | 20 | 50 | 30 | 80008 | 12000 |
| 14 | 36 | 35 | 20 | 50 | 30 | 80008 | 12000 |
| 15 | 34 | 33 | 20 | 50 | 30 | 80008 | 12000 |
| 16 | 32 | 31 | 22 | 50 | 28 | 80008 | 12000 |
| 17 | 31 | 30 | 24 | 50 | 26 | 80008 | 12000 |
| 18 | 29 | 28 | 26 | 50 | 24 | 80008 | 12500 |
| 19 | 27 | 26 | 28 | 50 | 22 | 80008 | 12500 |
| 20 | 25 | 24 | 30 | 50 | 20 | 80008 | 12500 |

**수치 해설**
- `empty_tile`: 8x8 그리드(64칸) 중 비어있는 칸 수. 값이 낮을수록 배치 공간이 줄어 고난도
- `small/mid/large_weight`: 블록 크기 등장 가중치 (분모 100). mid는 50 고정, small↓·large↑로 난이도 상승
- `score_multiplier`: 점수 배율 (분모 10000). 10000=1.0x, 12500=1.25x
- `phase_diff_key`: 페이즈별 세부 파라미터 참조키 (80001~80008)

**PBM 난이도 구간 분류 (추출값 기반)**
- Tier 1~2: 완화 구간 (empty_tile 57~66, small_w 28~30, 1.0x 배율)
- Tier 3~8: 점진 상승 구간 (empty_tile 46~56, phase_diff 세분화, 1.0~1.1x)
- Tier 9~12: 안정 고난도 구간 (empty_tile 38~44, phase_diff 80008 고정, 1.15x)
- Tier 13~15: 고난도 구간 (empty_tile 33~37, 1.2x)
- Tier 16~20: 역완화 구간 — small_w 재상승(20→30), large_w 재하강(30→20), 1.2~1.25x
  - 가설: Tier 16~20의 블록 가중치 역전은 소형 블록 증가로 배치 유연성을 높이되 점수 배율은 유지하는 "보상형 완화" 설계. 데이터 패턴으로 확인되나 설계 의도는 문서에 미기재.

---

### 2-2. PBM_phase_diff.json 원문 추출 (요약)

출처: `reference/PBM_phase_diff.json` (총 20개 레코드, 주요 구간 발췌)

| phase_condition | full_clear_combo | line_clear_combo | normal_combo | small_block_rate | mid_block_rate | large_block_rate | hint_unique_slot_rate | hint_hover_simulation_rate | hint_game_over_risk_alert |
|---|---|---|---|---|---|---|---|---|---|
| 20   | 9900 | 50   | 50   | 6200 | 3300 | 500  | 10000 | 10000 | 10000 |
| 40   | 9000 | 950  | 50   | 5800 | 3500 | 700  | 10000 | 10000 | 10000 |
| 50   | 8000 | 1100 | 900  | 5000 | 3700 | 1300 | 10000 | 10000 | 10000 |
| 60   | 7000 | 1600 | 1400 | 4700 | 3900 | 1400 | 10000 | 5000  | 10000 |
| 70   | 5000 | 2600 | 2400 | 4400 | 4000 | 1600 | 10000 | 5000  | 10000 |
| 80   | 4500 | 2800 | 2700 | 4200 | 4000 | 1800 | 5000  | 0     | 10000 |
| 90   | 4000 | 3000 | 3000 | 4000 | 4100 | 1900 | 5000  | 0     | 10000 |
| 100  | 3000 | 3000 | 4000 | 3700 | 4200 | 2100 | 5000  | 0     | 10000 |
| 120  | 1500 | 3500 | 5000 | 3200 | 4400 | 2400 | 0     | 0     | 10000 |
| 150  | 1000 | 2500 | 6500 | 2600 | 4500 | 2900 | 0     | 0     | 10000 |
| 210  | 400  | 600  | 9000 | 2000 | 4600 | 3400 | 0     | 0     | 10000 |
| 300  | 50   | 450  | 9500 | 1400 | 4600 | 4000 | 0     | 0     | 10000 |
| 99999| 50   | 150  | 9800 | 1200 | 4500 | 4300 | 0     | 0     | 10000 |

**추출 패턴**
- `full_clear_combo`: 페이즈 초반(condition=20)에 9900(99%)로 매우 높고 후반(99999)에 50(0.5%)으로 급감
- `normal_combo`: 초반 50(0.5%) → 후반 9800(98%)으로 역전. 고페이즈일수록 일반 콤보 위주로 전환
- `small_block_rate`: 6200(62%) → 1200(12%)으로 감소. large_block_rate: 500(5%) → 4300(43%)으로 증가
- `hint_unique_slot_rate`: 10000(100%) → phase_condition=80부터 5000(50%) → 120부터 0으로 단계적 제거
- `hint_hover_simulation_rate`: 60에서 5000(50%)으로 반감 → 80에서 완전 제거(0)
- `hint_game_over_risk_alert`: 전 구간 10000(100%) 상시 활성

**PBM 힌트 시스템 단계적 제거 구조**
- phase_condition 20~50: 모든 힌트 풀 제공 (hint 3종 10000)
- phase_condition 60~70: hover_simulation 50% 축소
- phase_condition 80~110: unique_slot 50%로 축소, hover_simulation 완전 제거
- phase_condition 120 이상: unique_slot 완전 제거, game_over_risk_alert만 유지

---

### 2-3. PBM_ingame_gimmick.json 원문 추출

출처: `reference/PBM_ingame_gimmick.json`

| key_number | item_code   | unlock_score | max_concurrent | spawn_guarantee_interval | spawn_rate (분모10000) | min_interval_count | spawn_rate_2 (분모10000) | in_use |
|---|---|---|---|---|---|---|---|---|
| 160001 | copy_tile  | 2500 | 1 | 2500 | 1200 | 5 | 360  | true |
| 160002 | propeller  | 4500 | 3 | 2500 | 1000 | 5 | 800  | true |

**수치 해설**
- `copy_tile`: 점수 2500 이상에서 잠금 해제. 동시 최대 1개. 기본 등장률 12%, 최소 간격 5회 후 spawn_rate_2=3.6%
- `propeller`: 점수 4500 이상에서 잠금 해제. 동시 최대 3개. 기본 등장률 10%, 최소 간격 5회 후 spawn_rate_2=8%
- `spawn_guarantee_interval 2500`: 2500 점수 간격마다 등장 보장
- `in_use true`: 두 기믹 모두 현재 활성

---

### 2-4. PBM_block_list.json 원문 추출

출처: `reference/PBM_block_list.json`

| key_number | cell_count | size_category |
|---|---|---|
| 40001 | 1 | small  |
| 40002 | 2 | small  |
| 40003 | 3 | small  |
| 40010 | 2 | small  |
| 40011 | 3 | small  |
| 40004 | 3 | mid    |
| 40005 | 4 | mid    |
| 40006 | 4 | mid    |
| 40007 | 4 | mid    |
| 40008 | 5 | mid    |
| 40009 | 4 | mid    |
| 40015 | 4 | mid    |
| 40012 | 5 | large  |
| 40013 | 6 | large  |
| 40014 | 9 | large  |

**블록 구성 요약**
- 총 15종: small 5종 / mid 7종 / large 3종
- small: 1~3셀
- mid: 3~5셀 (4셀이 5종으로 가장 다양)
- large: 5~9셀 (최대 9셀 블록 존재)

---

### 2-5. PBM_dynamic_logic.json 원문 추출

출처: `reference/PBM_dynamic_logic.json`

| key_number | result_type | avg_blocks_min | avg_blocks_max | tier_adj |
|---|---|---|---|---|
| 20001 | success1 | 201 | 9999 | +5  |
| 20002 | success2 | 111 | 200  | +4  |
| 20003 | success3 | 81  | 110  | +3  |
| 20004 | fail1    | 51  | 80   | -3  |
| 20005 | fail2    | 21  | 50   | -5  |
| 20006 | fail3    | 0   | 20   | -7  |

**수치 해설**
- `avg_blocks`: 게임 결과 기준 지표 (추정: 평균 배치 블록 수 또는 누적 스코어 단위)
- `tier_adj`: 결과에 따른 티어 조정폭. 성공 시 +3~+5, 실패 시 -3~-7
- 실패 조정폭이 성공 조정폭보다 크게 설계됨 → 하향 조정 속도가 상향 조정보다 빠름

**PBM DDA 특징**
- 6단계 결과 분류 (성공 3등급 + 실패 3등급)
- 비대칭 조정: 최대 상향 +5 vs 최대 하향 -7 → 실패 시 빠른 난이도 감소로 이탈 방지 설계
- avg_blocks 기준으로 결과 품질을 세분화 → 단순 승패가 아닌 퍼포먼스 기반 조정

---

## 3. CCS 난이도 구조 요약

출처: WebSearch/WebFetch 권한 없음 — 모든 항목 미확인 처리

| 항목 | CCS 정보 | 출처/신뢰도 | 비고 |
|---|---|---|---|
| 난이도 티어 분류 기준 | 미확인 | - | WebSearch 권한 없음 |
| 초반/중반/후반 승률 패턴 | 미확인 | - | WebSearch 권한 없음 |
| DDA 또는 help 시스템 | 미확인 | - | WebSearch 권한 없음 |
| 기믹 및 특수 요소 등장 패턴 | 미확인 | - | WebSearch 권한 없음 |
| 부스터/파워업 시스템 | 미확인 | - | WebSearch 권한 없음 |

---

## 4. PST/PBM/CCS 3사 구조 비교 요약

### 4-1. 구조 개요표

| 게임 | 티어 수 | 분류 기준 | DDA 방식 | 기믹 종류 수 |
|---|---|---|---|---|
| PST | 4 (Tutorial/Normal/Hard/Super Hard) | score_min~score_max 범위 + 동적 룰 체인 | 우선순위 룰 체인 (fail_streak 2연패 즉시 하향, win_streak 7연승 상향) | 4종 (plus_card/rope_card/runner_card/lock_key) |
| PBM | 20 (tier 1~20) | empty_tile 수 + 블록 size 가중치 + score_multiplier | 6단계 결과 기반 tier_adj (-7~+5), 페이즈별 힌트 단계적 제거 | 2종 (copy_tile/propeller) |
| CCS | 미확인 | 미확인 | 미확인 | 미확인 |

---

### 4-2. PST vs PBM 공통점

1. **DDA(동적 난이도 조정) 적용**: 두 게임 모두 연패/성적 기반의 자동 난이도 조정 메커니즘 보유
2. **도움(help) 시스템 단계적 축소**: PST는 help_card_rate(80%→0%), PBM은 hint 3종 단계별 제거 — 고난도 구간에서 보조 제거
3. **보상 스케일링**: PST 클리어 보상(hammer 1→3), PBM score_multiplier(1.0x→1.25x) — 고난도 클리어에 인센티브 부여
4. **비대칭 조정 설계**: PST pity(연패 완화 즉시 발동) + PBM 실패 조정폭 우위(-7 vs +5) → 이탈 방지 우선

### 4-3. PST vs PBM 차이점

| 구분 | PST | PBM |
|---|---|---|
| 티어 세분화 | 4단계 (간결) | 20단계 (세밀) |
| DDA 트리거 | 이산적 룰(연패/연승 횟수) | 연속적 퍼포먼스(avg_blocks 구간) |
| Super Hard 보호 | pity_trigger_count=99(사실상 없음), help_card_rate=0 | 데이터 없음 (별도 Super Hard 개념 미확인) |
| 기믹 역할 | 맵 난이도 점수 가중치로 사전 반영 | 게임 중 등장(score 기반 unlock + spawn_rate) |
| 힌트 시스템 | help_card_rate 1개 파라미터 | hint 3종(unique_slot/hover_simulation/risk_alert) 독립 제어 |

### 4-4. CCS 부재로 인한 비교 한계

CCS 관련 외부 리서치 미수행(WebSearch 권한 없음)으로 3사 비교 불가. CCS 데이터 추가 시 아래 항목을 우선 수집 필요:
- 난이도 티어 명칭 및 레벨 구간 분류
- DDA 또는 booster 제공 조건
- 기믹 등장 스케줄 및 구간별 승률 공식 발표 여부

---

### 4-5. 우리 게임(PST) 참고 패턴 (reference 기반 추출, 가설 명시)

아래는 내부 데이터에서 추출한 관찰이며, 수치 설계는 Phase-B에서 수행함.

1. **Super Hard 구간 재화 수요 집중 가설**: help_card_rate=0, pity=99로 Super Hard 구간에서 외부 도움(아이템 구매) 수요가 가장 높을 것으로 예상됨. 가설 — 실측 데이터 미보유.
2. **Normal 구간이 트래픽 중심**: default 조건이 Normal(tier_id=2)이며, fail_streak 2회면 즉시 Normal 복귀 → 대다수 유저가 Normal 구간에 체류할 가능성. 가설 — 유저 분포 실측 필요.
3. **기믹 조합 설계 여지**: plus_card(-10)와 runner_card(+40) 조합으로 동일 티어 내 맵 체감 난이도를 ±50 범위로 조절 가능. 현재 max_gimmick_count=5 동일하게 고정되어 있어 티어별 기믹 한도 차등화 미적용 상태.
4. **PBM 힌트 단계적 제거 구조의 PST 적용 가능성**: PBM이 3종 힌트를 페이즈별로 독립 제어하는 반면, PST는 help_card_rate 단일 수치 제어. PST에 다차원 도움 시스템 도입 시 유저 경험 세분화 여지 있음. 가설 — 설계 타당성은 Phase-B에서 검토.

---

*리포트 종료. Phase-A 완료 (CCS 외부 리서치는 WebSearch 권한 부재로 미완료 — status: partial)*
