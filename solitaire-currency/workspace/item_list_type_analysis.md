# PST item_list 타입별 분포 분석

**분석 일시**: 2026-03-12  
**데이터 소스**: PST Google Sheet — `item_list` 시트  
**Spreadsheet ID**: `1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk`

---

## 1. 컬럼 구조 (실제 데이터 헤더 row 기준)

| 인덱스 | 컬럼명 | 설명 |
|--------|--------|------|
| 0 | `key_number` | 아이템 고유 ID (40001~40029) |
| 1 | `type` | 아이템 타입 (currency / booster / infinite / gimmick) |
| 2 | `usage_type` | 사용 타입 (inventory = 귀속, immediate = 즉시) |
| 3 | `name_key` | 명칭 키 |
| 4 | `entry_cost_ratio` | 입장료 배수 (1% = 100 단위). basePrice = entryCost × betting × (entry_cost_ratio / 10000) |
| 5 | `interval_type` | 비율 참조 방식 (none / fixed / tier_undo / tier_extra_deck) |
| 6 | `use_count_increase_rate` | 사용횟수 증가율 (1% = 100) |
| 7 | `use_count_max_ratio` | 사용횟수 상한 비율 (1% = 100) |
| 8 | `duration_sec` | 지속 시간 (초, infinite 전용) |
| 9 | `target_name_key` | 타겟 아이템 (infinite 전용) |
| 13 | `use_count_increase_rate_backup` | rev2 이전 백업값 |
| 14 | `use_count_max_ratio_backup` | rev2 이전 백업값 |

---

## 2. item_type 전체 고유값 목록

| type | 아이템 수 |
|------|----------|
| infinite | 9 |
| currency | 5 |
| booster | 5 |
| gimmick | 1 |
| **합계** | **20** |

> currency / booster / infinite 외 **gimmick** 타입 1개 존재 (`reward_plus_card_1`, usage_type=immediate).

---

## 3. TYPE: currency (5개)

[OBJECTIVE] currency 타입 아이템의 구조 및 파라미터 파악

[DATA] 5개 행, 모든 수치 파라미터 = 0, interval_type = none

### 아이템 목록

| key_number | name_key | entry_cost_ratio | interval_type | use_count_increase_rate | use_count_max_ratio | duration_sec | target_name_key |
|------------|----------|-----------------|---------------|------------------------|--------------------|--------------|-|
| 40001 | currency_gold | 0 | none | 0 | 0 | 0 | none |
| 40002 | currency_hammer | 0 | none | 0 | 0 | 0 | none |
| 40003 | currency_ticket | 0 | none | 0 | 0 | 0 | none |
| 40004 | currency_streak_star | 0 | none | 0 | 0 | 0 | none |
| 40005 | currency_puzzle_piece | 0 | none | 0 | 0 | 0 | none |

[FINDING] currency 타입 5종 모두 수치 파라미터가 전부 0이며 interval_type=none.  
[STAT:n] n=5 (전수)  
[STAT:effect_size] 수치 분산 없음 — 재화 자체는 게임 로직 파라미터 없이 단순 수량 보유/소비 단위로만 동작.  
[LIMITATION] 재화별 실제 획득/소비 경로는 이 시트에 포함되지 않음. const 시트 및 product 시트 참조 필요.

### 패턴 분석
- **usage_type = inventory (귀속)**: 5종 모두 동일. 획득 즉시 지갑에 귀속.
- **gold (40001)**: 기본 소프트 재화. 입장료·부스터 구매에 소비.
- **hammer (40002)**: 맵 에디터/장애물 제거 전용 하드 재화.
- **ticket (40003)**: 판 입장권. 판당 소비.
- **streak_star (40004)**: 스트릭 미터 전용 재화 (연승 포인트).
- **puzzle_piece (40005)**: 퍼즐/컬렉션 메타 재화.

---

## 4. TYPE: booster (5개)

[OBJECTIVE] booster 타입 아이템의 가격 구조 및 누진 메커니즘 파악

[DATA] 5개 행, interval_type 3종 (fixed / tier_undo / tier_extra_deck)

### 아이템 목록 (수치 단위 변환 포함)

| key_number | name_key | entry_cost_ratio (raw) | 실제배율 (%) | interval_type | use_count_increase_rate (raw) | 실제증가율 (%) | use_count_max_ratio (raw) | 실제상한배율 (%) |
|------------|----------|----------------------|-------------|---------------|------------------------------|--------------|--------------------------|----------------|
| 40010 | booster_fireworks | 6000 | **60%** | fixed | 0 | 0% | 0 | 0% |
| 40011 | booster_golden_ticket | 8000 | **80%** | fixed | 0 | 0% | 0 | 0% |
| 40012 | booster_undo | 0 | 0% | tier_undo | 4000 | **40%** | 10000 | **100%** |
| 40013 | booster_wild_card | 5000 | **50%** | fixed | 0 | 0% | 0 | 0% |
| 40014 | booster_extra_deck | 0 | 0% | tier_extra_deck | 4000 | **40%** | 30000 | **300%** |

[FINDING] booster는 가격 결정 방식에 따라 2개 군으로 명확히 분리된다.

**군 A — fixed (3종)**: fireworks / golden_ticket / wild_card  
- `entry_cost_ratio`로만 가격 결정. basePrice = entryCost × betting × 배율  
- fireworks 60% < wild_card 50% ← wild_card가 더 저렴 (주의: golden_ticket 80%로 가장 고가)
- `use_count_increase_rate = 0`, `use_count_max_ratio = 0` — 누진 없음

**군 B — tier 누진 (2종)**: undo / extra_deck  
- `entry_cost_ratio = 0` — 고정 배율 아님  
- `use_count_increase_rate = 40%` (동일) — 사용할수록 40%씩 가격 증가  
- `use_count_max_ratio`: undo=100%, extra_deck=300% — extra_deck의 상한이 3배 높음

[STAT:n] n=5 (전수)  
[STAT:effect_size] 군 A/B 분리: fixed 3종 vs tier 2종 (비율 60%:40%)  
[LIMITATION] actual entryCost 값은 const 시트 또는 difficulty_tier 시트에서 파악 필요. 이 시트만으로 절대 가격 산출 불가.

### backup 컬럼 비교 (rev2 이전 → 현재)

| name_key | ucir_backup (이전) | ucir (현재) | ucmr_backup (이전) | ucmr (현재) |
|----------|--------------------|------------|---------------------|------------|
| booster_fireworks | 0 | **0** | 0 | **0** |
| booster_golden_ticket | 0 | **0** | 0 | **0** |
| booster_wild_card | 0 | **0** | 0 | **0** |

> fireworks / golden_ticket / wild_card는 rev2 이전부터 ucir=0, ucmr=0 유지. CLAUDE.md 정책("ucir/ucmr → 0 복원")과 일치.

---

## 5. TYPE: infinite (9개)

[OBJECTIVE] infinite 타입의 시간 구성 및 타겟 부스터 매핑 파악

[DATA] 9개 행, 3종 부스터 × 3종 시간 단계 (5분/10분/15분)

### 아이템 목록

| key_number | name_key | duration_sec | duration_min | target_name_key |
|------------|----------|-------------|-------------|-----------------|
| 40020 | infinite_fireworks_5m | 300 | **5분** | booster_fireworks |
| 40021 | infinite_fireworks_10m | 600 | **10분** | booster_fireworks |
| 40022 | infinite_fireworks_15m | 900 | **15분** | booster_fireworks |
| 40023 | infinite_gticket_5m | 300 | **5분** | booster_golden_ticket |
| 40024 | infinite_gticket_10m | 600 | **10분** | booster_golden_ticket |
| 40025 | infinite_gticket_15m | 900 | **15분** | booster_golden_ticket |
| 40026 | infinite_ticket_5m | 300 | **5분** | currency_ticket |
| 40027 | infinite_ticket_10m | 600 | **10분** | currency_ticket |
| 40028 | infinite_ticket_15m | 900 | **15분** | currency_ticket |

[FINDING] infinite는 3종 타겟(fireworks / golden_ticket / ticket) × 3단계(5m/10m/15m) = 9개 조합으로 구성된다.  
[STAT:n] n=9 (전수)  
[STAT:effect_size] duration 단계 비율: 5m:10m:15m = 300:600:900 = 1:2:3 (등간격)

**타겟별 특이사항**:
- `infinite_ticket_*`: target = `currency_ticket` (부스터가 아닌 재화). 티켓 무제한 시간권.
- `infinite_fireworks_*`: target = `booster_fireworks` (부스터)
- `infinite_gticket_*`: target = `booster_golden_ticket` (부스터)

**모든 infinite**: `entry_cost_ratio=0`, `interval_type=none`, `use_count_*=0` — 가격 파라미터 없음. 가격은 product 시트에서 별도 정의됨.

[LIMITATION] infinite 아이템의 실제 판매 가격(IAP/광고)은 product 시트 참조 필요.

---

## 6. TYPE: gimmick (1개)

| key_number | name_key | usage_type | 기타 파라미터 |
|------------|----------|------------|--------------|
| 40029 | reward_plus_card_1 | **immediate** | 모두 0/none |

- usage_type=**immediate** — 유일한 즉시 사용 타입. 획득 시 인벤토리 귀속 없이 즉시 효과 발동.
- 다른 모든 타입(currency/booster/infinite)은 usage_type=inventory.

---

## 7. 타입별 패턴 종합 비교

| 구분 | currency | booster (fixed) | booster (tier) | infinite | gimmick |
|------|----------|----------------|----------------|----------|---------|
| 아이템 수 | 5 | 3 | 2 | 9 | 1 |
| usage_type | inventory | inventory | inventory | inventory | **immediate** |
| entry_cost_ratio | 0 | 5000~8000 | 0 | 0 | 0 |
| interval_type | none | fixed | tier_* | none | none |
| use_count_increase_rate | 0 | 0 | 4000 (40%) | 0 | 0 |
| use_count_max_ratio | 0 | 0 | 10000~30000 | 0 | 0 |
| duration_sec | 0 | 0 | 0 | 300~900 | 0 |
| target_name_key | none | none | none | 부스터/재화 참조 | none |

---

## 8. 주요 설계 패턴 및 시사점

1. **재화 분리 구조**: currency는 파라미터-free 단순 수량 단위. 실제 게임 로직(가격·누진)은 booster 시트에만 존재.
2. **booster 2분법**: fixed(비례 고정가) vs tier(사용횟수 누진가). undo와 extra_deck만 사용할수록 비싸짐. fireworks/golden_ticket/wild_card는 판당 일정 배율 고정.
3. **wild_card < fireworks < golden_ticket 가격 순서**: 50% < 60% < 80% (entry_cost_ratio 기준).
4. **infinite = 시간권 번들**: 3종 부스터·재화에 대해 5/10/15분 3단계. 가격은 product 시트에서 별도 정의.
5. **ticket infinite 존재**: currency_ticket을 타겟으로 하는 infinite — 티켓 무제한 시간제. ticket이 currency임에도 booster처럼 무제한 시간권이 존재.
6. **ucir/ucmr = 0 (fireworks/golden_ticket/wild_card)**: CLAUDE.md 정책과 일치. rev2 백업도 동일값으로, 원래부터 고정 배율 설계.

[LIMITATION] 이 분석은 item_list 시트 단일 소스 기준. 실제 게임 내 가격·획득처·소비처는 const / product / difficulty_tier 시트 교차 분석 필요.
