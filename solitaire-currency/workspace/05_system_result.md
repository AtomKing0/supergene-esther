---
agent: 05_system_spec
scope: PST 골드·부스터·보상·방치골드·광고·메타 6개 시스템
executed: 2026-03-09T19:30:00+09:00
status: complete
data_sources:
  - /tmp/pst_sheets.json (live sheet cache, 2026-03-09)
  - reference/PST_const.json (local snapshot — 일부 구버전 값 포함, 주석 표기)
  - workspace/06_simulation_result.md (시뮬레이션 v2 확정 수치)
  - workspace/08_booster_analysis.md (부스터 가격 분석)
---

# PST 시스템 명세서 — 6개 핵심 시스템 계산 공식·상태 전이·데이터 흐름

> **표기 규칙**
> - 출처: `시트명.필드명` 또는 `const[key_number]`
> - `[가설]` 표기: 라이브 시트에 "가설" 주석 달린 PM 승인 수정값
> - `[스냅샷 구버전]` 표기: 로컬 PST_const.json 값이 라이브 시트 확정값과 다를 경우
> - 확률 분모: 10000
> - 시간 단위: 초(sec)

---

## 시스템 1: 입장료 계산 (Entry Cost)

### 계산 공식 블록

```
[입장료 계산]

공식:
  entry_cost_final = entry_cost × betting_multiplier   (ticket 미사용 시)
  entry_cost_final = 0                                  (ticket 사용 시)

변수 정의:
  - entry_cost       : 레벨 구간별 기본 입장료 (출처: level_entry_tier.입장료(골드))
  - betting_multiplier: 베팅 배수 선택값 — x1=1, x2=2, x4=4
  - ticket           : currency_ticket (item key 40003) 보유 시 골드 대체 가능

예시 (Lv75, x2 베팅):
  입력:  level=75 → tier[50-99] → entry_cost=2000, betting=2
  출력:  entry_cost_final = 2000 × 2 = 4,000g

예시 (Lv75, x1 베팅, ticket 보유):
  입력:  level=75, ticket=1개 보유
  출력:  entry_cost_final = 0g  (ticket 1개 차감)
```

### level_entry_tier 전체 테이블 (출처: level_entry_tier 시트, 라이브 확정)

| level_min | level_max | entry_cost | undo_ratio | extra_deck_ratio | remaining_deck_reward | combo_reward_base | combo_reward_increase | streak_meter_gold |
|-----------|-----------|-----------|------------|------------------|-----------------------|-------------------|----------------------|-------------------|
| 1         | 2         | 0g        | 0          | 0                | 0                     | 0                 | 0                    | 0                 |
| 3         | 9         | 1,000g    | 1,000      | 3,000            | 10g                   | 2                 | 1                    | 40g               |
| 10        | 24        | 1,500g    | 3,000      | 4,000            | 15g                   | 2                 | 1                    | 60g               |
| 25        | 49        | 1,800g    | 5,000      | 5,000            | 18g                   | 2                 | 1                    | 72g               |
| 50        | 99        | 2,000g    | 5,000      | 7,000            | 20g                   | 3                 | 1                    | 80g               |
| 100       | 199       | 2,200g    | 5,000      | 7,000            | 22g                   | 3                 | 1                    | 88g               |
| 200       | 349       | 2,500g    | 5,000      | 7,000            | 25g                   | 3                 | 1                    | 100g              |
| 350       | 549       | 2,900g    | 5,000      | 7,000            | 29g                   | 3                 | 2                    | 116g              |
| 550       | 799       | 3,400g    | 5,000      | 7,000            | 34g                   | 4                 | 2                    | 136g              |
| 800       | 1099      | 3,900g    | 5,000      | 7,000            | 39g                   | 4                 | 2                    | 156g              |
| 1100      | 1449      | 4,500g    | 5,000      | 7,000            | 45g                   | 4                 | 2                    | 180g              |
| 1450      | ∞         | 5,000g    | 5,000      | 7,000            | 50g                   | 4                 | 2                    | 200g              |

### 상태 전이표

| 현재 상태       | 전이 조건                          | 다음 상태         | 조건 출처                        |
|-----------------|------------------------------------|-------------------|----------------------------------|
| 로비 대기       | 레벨 선택 + 베팅 배수 선택         | 결제 검증         | 클라이언트 UI                    |
| 결제 검증       | gold >= entry_cost_final           | 인게임 진입       | gold_max_limit (const[10059])    |
| 결제 검증       | gold < entry_cost_final AND ticket >= 1 | ticket 차감 → 인게임 진입 | item_list[40003]         |
| 결제 검증       | gold < entry_cost_final AND ticket == 0 | 결제 불가 팝업   | 클라이언트 처리                  |
| 결제 검증       | level <= 2 (tutorial)              | entry_cost = 0 진입 | level_entry_tier[1-2]          |

### 데이터 흐름도

```
[클라이언트]
    │ 요청: { level_id, betting_multiplier(1/2/4), use_ticket(bool) }
    ▼
[서버 로직]
    │ 1. level → level_entry_tier 조회 → entry_cost
    │ 2. use_ticket=false: cost = entry_cost × betting_multiplier
    │    use_ticket=true:  cost = 0, ticket_inventory -= 1
    ├─ gold >= cost  → gold -= cost, 인게임 세션 생성
    └─ gold < cost AND ticket=0 → 오류 응답 (INSUFFICIENT_GOLD)
    │ 응답: { session_id, entry_cost_paid, betting_multiplier, gold_remaining }
    ▼
[클라이언트 반영]
    │ gold 잔액 UI 갱신, 인게임 화면 전환
```

---

## 시스템 2: 부스터 가격 계산 (Booster Pricing)

### 부스터 아이템 정의 (출처: item_list 시트, 라이브 확정)

| key   | name_key              | interval_type    | entry_cost_ratio | use_count_increase_rate | use_count_max_ratio |
|-------|-----------------------|------------------|-----------------|------------------------|---------------------|
| 40010 | booster_fireworks     | fixed            | 6,000           | 0                      | 0                   |
| 40011 | booster_golden_ticket | fixed            | 8,000           | 0                      | 0                   |
| 40012 | booster_undo          | tier_undo        | 0 (ratio 참조)  | 4,000                  | 10,000              |
| 40013 | booster_wild_card     | fixed            | 5,000           | 0                      | 0                   |
| 40014 | booster_extra_deck    | tier_extra_deck  | 0 (ratio 참조)  | 4,000                  | 30,000              |

### 계산 공식 블록

#### 2-A. fixed 타입

```
[fixed 부스터 가격]

공식:
  price = entry_cost × betting_multiplier × (entry_cost_ratio / 10000)

변수 정의:
  - entry_cost        : level_entry_tier.entry_cost (레벨 구간별)
  - betting_multiplier: 현재 게임의 베팅 배수 (1/2/4)
  - entry_cost_ratio  : item_list.entry_cost_ratio

예시 (Lv75, x1 베팅, booster_fireworks):
  입력:  entry_cost=2000, betting=1, ratio=6000
  출력:  price = 2000 × 1 × (6000/10000) = 1,200g

예시 (Lv75, x2 베팅, booster_golden_ticket):
  입력:  entry_cost=2000, betting=2, ratio=8000
  출력:  price = 2000 × 2 × (8000/10000) = 3,200g
```

#### fixed 타입 전체 가격 표 (x1 베팅 기준)

| 레벨 구간  | entry_cost | fireworks(6000) | golden_ticket(8000) | wild_card(5000) |
|------------|-----------|----------------|--------------------|--------------|
| 3–9        | 1,000g    | 600g           | 800g               | 500g         |
| 10–24      | 1,500g    | 900g           | 1,200g             | 750g         |
| 25–49      | 1,800g    | 1,080g         | 1,440g             | 900g         |
| **50–99**  | **2,000g**| **1,200g**     | **1,600g**         | **1,000g**   |
| 100–199    | 2,200g    | 1,320g         | 1,760g             | 1,100g       |
| 200–349    | 2,500g    | 1,500g         | 2,000g             | 1,250g       |
| 350–549    | 2,900g    | 1,740g         | 2,320g             | 1,450g       |
| 550–799    | 3,400g    | 2,040g         | 2,720g             | 1,700g       |
| 800–1099   | 3,900g    | 2,340g         | 3,120g             | 1,950g       |
| 1100–1449  | 4,500g    | 2,700g         | 3,600g             | 2,250g       |
| 1450+      | 5,000g    | 3,000g         | 4,000g             | 2,500g       |

#### 2-B. tier_undo 타입 (booster_undo, key 40012)

```
[undo 누진 가격]

공식:
  base     = entry_cost × (undo_ratio / 10000)
             ※ undo_ratio = level_entry_tier.undo_ratio (1%=100 단위)
  cap      = entry_cost × (use_count_max_ratio / 10000)
             ※ use_count_max_ratio = item_list[40012].use_count_max_ratio = 10,000
             → cap = entry_cost × 1.0

  price_n  = min( base × 1.4^(n-1), cap )
             ※ use_count_increase_rate = 4,000 → 40% 증가율

변수 정의:
  - n            : 현재 게임 내 undo 누적 사용 횟수 (1회부터 시작)
  - undo_ratio   : level_entry_tier.undo_ratio (Lv50-99: 5,000)
  - use_count_increase_rate : item_list[40012] = 4,000 (40%/회)
  - use_count_max_ratio     : item_list[40012] = 10,000 (entry_cost × 1.0)

예시 (Lv75, x1 베팅):
  entry_cost=2000, undo_ratio=5000, cap=2000×1.0=2,000g
  base = 2000 × (5000/10000) = 1,000g

  회차별 가격:
  n=1: min(1000 × 1.4^0, 2000) = 1,000g
  n=2: min(1000 × 1.4^1, 2000) = 1,400g
  n=3: min(1000 × 1.4^2, 2000) = 1,960g
  n=4: min(1000 × 1.4^3, 2000) = min(2,744, 2000) = 2,000g (cap 도달)
  n≥4: 2,000g (cap 고정)
```

#### tier_undo 누진 가격표 (x1 베팅 기준)

| 레벨 구간 | entry_cost | undo_ratio | base  | cap   | n=1    | n=2    | n=3    | n≥4    |
|-----------|-----------|------------|-------|-------|--------|--------|--------|--------|
| 3–9       | 1,000g    | 1,000      | 100g  | 1,000g| 100g   | 140g   | 196g   | 274g…  |
| 10–24     | 1,500g    | 3,000      | 450g  | 1,500g| 450g   | 630g   | 882g   | 1,235g→cap |
| 25–49     | 1,800g    | 5,000      | 900g  | 1,800g| 900g   | 1,260g | 1,764g | 1,800g |
| **50–99** | **2,000g**| **5,000**  |**1,000g**|**2,000g**|**1,000g**|**1,400g**|**1,960g**|**2,000g**|
| 100–199   | 2,200g    | 5,000      | 1,100g| 2,200g| 1,100g | 1,540g | 2,156g→cap | 2,200g |
| 1450+     | 5,000g    | 5,000      | 2,500g| 5,000g| 2,500g | 3,500g | 4,900g | 5,000g |

#### 2-C. tier_extra_deck 타입 (booster_extra_deck, key 40014)

```
[extra_deck 누진 가격]

공식:
  base     = entry_cost × (extra_deck_ratio / 10000)
             ※ extra_deck_ratio = level_entry_tier.extra_deck_ratio (Lv50-99: 7,000)
  cap      = entry_cost × (use_count_max_ratio / 10000)
             ※ use_count_max_ratio = item_list[40014].use_count_max_ratio = 30,000
             → cap = entry_cost × 3.0

  price_n  = min( base × 1.4^(n-1), cap )
             ※ use_count_increase_rate = 4,000 → 40% 증가율

예시 (Lv75, x1 베팅):
  entry_cost=2000, extra_deck_ratio=7000, cap=2000×3.0=6,000g
  base = 2000 × (7000/10000) = 1,400g

  회차별 가격:
  n=1: 1,400g
  n=2: 1,960g
  n=3: 2,744g
  n=4: 3,842g
  n=5: 5,378g
  n=6: min(7,530, 6,000) = 6,000g (cap 도달)
  n≥6: 6,000g
```

#### tier_extra_deck 누진 가격표 (x1 베팅 기준, Lv50-99)

| n    | 계산                         | 가격    |
|------|------------------------------|---------|
| 1    | 1,400 × 1.4^0               | 1,400g  |
| 2    | 1,400 × 1.4^1               | 1,960g  |
| 3    | 1,400 × 1.4^2               | 2,744g  |
| 4    | 1,400 × 1.4^3               | 3,842g  |
| 5    | 1,400 × 1.4^4               | 5,378g  |
| 6+   | min(1,400 × 1.4^5, 6,000)   | 6,000g (cap) |

### 상태 전이표 (부스터)

| 현재 상태      | 전이 조건                                   | 다음 상태             | 조건 출처                             |
|----------------|---------------------------------------------|-----------------------|---------------------------------------|
| 인게임 대기    | 부스터 선택 버튼 탭                         | 가격 계산             | 서버: entry_cost × betting × ratio    |
| 가격 계산      | gold >= price_n                             | 골드 차감 + 부스터 발동 | gold_max_limit (const[10059]=10,000) |
| 가격 계산      | gold < price_n                             | 구매 불가 표시        | 클라이언트 처리                       |
| 부스터 발동    | interval_type = fixed                       | use_count 미증가      | item_list.interval_type               |
| 부스터 발동    | interval_type = tier_undo / tier_extra_deck | use_count += 1        | item_list.use_count_increase_rate     |
| use_count 증가 | price_n+1 >= cap                            | 이후 cap 고정         | item_list.use_count_max_ratio         |

### 데이터 흐름도

```
[클라이언트]
    │ 요청: { session_id, booster_key(40010~40014), current_use_count }
    ▼
[서버 로직]
    │ 1. item_list[booster_key] → interval_type, ratios
    │ 2. level_entry_tier[session.level] → entry_cost, tier_ratio
    │ 3. fixed:      price = entry_cost × betting × (entry_cost_ratio/10000)
    │    tier_undo:  price = min(base × 1.4^n, cap)
    │    tier_extra: price = min(base × 1.4^n, cap)
    ├─ gold >= price → gold -= price, use_count[booster_key] += 1
    └─ gold < price  → 오류 응답 (INSUFFICIENT_GOLD)
    │ 응답: { gold_remaining, use_count_updated, booster_activated }
    ▼
[클라이언트 반영]
    │ 골드 잔액 갱신, 부스터 효과 발동, 다음 회차 가격 표시
```

---

## 시스템 3: 인게임 보상 계산 (In-game Rewards)

### 계산 공식 블록

#### 3-A. 콤보 보상

```
[콤보 보상 계산]

공식:
  combo_reward(n) = combo_reward_base + combo_reward_increase × (n - 1)
  combo_reward(n) = min(combo_reward(n), ingame_combo_reward_max_cap)

  ※ n이 ingame_combo_reward_level_interval 레벨마다:
     combo_reward_base     += ingame_combo_reward_level_increase
     combo_reward_increase += ingame_combo_reward_level_increase

변수 정의:
  - n                                : 현재 판에서의 연속 콤보 횟수 (1부터)
  - combo_reward_base                : level_entry_tier.combo_reward_base (Lv50-99: 3g)
  - combo_reward_increase            : level_entry_tier.combo_reward_increase (Lv50-99: 1g)
  - ingame_combo_reward_max_cap      : const[10049] = 50g (판 내 1콤보당 상한)
  - ingame_combo_reward_level_interval: const[10050] = 10 레벨마다
  - ingame_combo_reward_level_increase: const[10051] = 1g

예시 (Lv75, base=3, increase=1):
  콤보 1회: 3 + 1×(1-1) = 3g
  콤보 2회: 3 + 1×(2-1) = 4g
  콤보 3회: 3 + 1×(3-1) = 5g
  콤보 n회: 3 + (n-1)g  (≤ 50g cap)
  콤보 10회: 12g
  10콤보 총합: 3+4+5+6+7+8+9+10+11+12 = 75g
```

#### 콤보 base/increase 레벨 구간별 값

| 레벨 구간 | combo_reward_base | combo_reward_increase |
|-----------|-------------------|----------------------|
| 3–9       | 2g                | 1g                   |
| 10–24     | 2g                | 1g                   |
| 25–49     | 2g                | 1g                   |
| **50–99** | **3g**            | **1g**               |
| 100–199   | 3g                | 1g                   |
| 200–349   | 3g                | 1g                   |
| 350–549   | 3g                | 2g                   |
| 550–799   | 4g                | 2g                   |
| 800–1099  | 4g                | 2g                   |
| 1100–1449 | 4g                | 2g                   |
| 1450+     | 4g                | 2g                   |

#### 3-B. 덱 보너스 (남은 카드 보상)

```
[덱 보너스 계산]

공식:
  deck_bonus = remaining_deck_reward × remaining_card_count
  deck_bonus = min(deck_bonus, remaining_deck_reward_max_cap)

  ※ remaining_deck_reward_level_interval 레벨마다:
     remaining_deck_reward += remaining_deck_reward_level_increase

변수 정의:
  - remaining_card_count             : 게임 종료 시 덱에 남은 카드 수
  - remaining_deck_reward            : level_entry_tier.remaining_deck_reward (Lv50-99: 20g)
  - remaining_deck_reward_base       : const[10052] = 15g (초기 기준값)
  - remaining_deck_reward_increase   : const[10053] = 15g (레벨 인상분)
  - remaining_deck_reward_max_cap    : const[10054] = 5,000g
  - remaining_deck_reward_level_interval: const[10055] = 5 레벨마다
  - remaining_deck_reward_level_increase: const[10056] = 5g

예시 (Lv75, remaining_deck_reward=20g, 남은카드 5장):
  deck_bonus = 20 × 5 = 100g

예시 (Lv75, 남은카드 250장, 상한 적용):
  deck_bonus = min(20 × 250, 5000) = min(5000, 5000) = 5,000g
```

#### 덱 보너스 레벨 구간별 카드당 골드

| 레벨 구간 | remaining_deck_reward(카드당) |
|-----------|------------------------------|
| 3–9       | 10g                          |
| 10–24     | 15g                          |
| 25–49     | 18g                          |
| **50–99** | **20g**                      |
| 100–199   | 22g                          |
| 200–349   | 25g                          |
| 350–549   | 29g                          |
| 550–799   | 34g                          |
| 800–1099  | 39g                          |
| 1100–1449 | 45g                          |
| 1450+     | 50g                          |

#### 3-C. 스트릭 미터 달성 보상

```
[스트릭 미터 보상]

공식:
  streak_reward = streak_meter_gold   (달성 시 고정 지급)
  streak_reward = 0                    (미달성)

변수 정의:
  - streak_meter_gold: level_entry_tier.streak_meter_gold (Lv50-99: 80g)
  - 달성 조건: 인게임 내 스트릭 스타(streak_star) 누적으로 미터 만충

예시 (Lv75):
  달성 시: 80g
  미달성:  0g
```

#### 3-D. 기대 수익 공식

```
[기대 수익 (Expected Return)]

공식:
  ingame_rewards = combo_total + deck_bonus + streak_reward
  gross_return   = clear_rate × (entry_cost_paid + ingame_rewards)
  net_per_game   = gross_return - entry_cost_paid

변수 정의:
  - clear_rate    : 레벨 클리어 확률 (가설: Lv75 = 85%)
  - entry_cost_paid: entry_cost × betting_multiplier
  - ingame_rewards: 3-A + 3-B + 3-C 합산

예시 (Lv75, x1, clear_rate=85%, 평균치):
  combo_total ≈ 65g (avg 10콤보 기준)
  deck_bonus  ≈ 100g (가설: avg 5장 잔존)
  streak_reward≈ 56g (가설: 달성률 70%)
  ingame_rewards = 221g
  gross_return   = 0.85 × (2000 + 221) = 1,888g
  net_per_game   = 1,888 - 2,000 = -112g/게임
```

### 상태 전이표 (인게임 보상)

| 현재 상태         | 전이 조건                        | 다음 상태           | 조건 출처                        |
|-------------------|----------------------------------|---------------------|----------------------------------|
| 인게임 진행 중    | 카드 매칭 성공 (연속)            | 콤보 카운터 +1      | const[10028] card_matching_gold  |
| 콤보 카운터 증가  | 콤보 n회                         | combo_reward(n) 지급| level_entry_tier.combo_reward    |
| 인게임 진행 중    | 콤보 단절                        | 콤보 카운터 리셋    | 클라이언트 처리                  |
| 게임 클리어       | remaining_card_count > 0         | 덱 보너스 지급      | level_entry_tier.remaining_deck_reward |
| 게임 클리어       | streak_meter 충만                | streak_meter_gold 지급 | level_entry_tier.streak_meter_gold |
| 게임 클리어       | 모든 보상 지급 완료              | 결과 화면 표시      | 클라이언트 처리                  |
| 게임 실패         | 카드 소진, 클리어 불가           | 보상 미지급 + 결과  | 클라이언트 처리                  |

### 데이터 흐름도

```
[클라이언트]
    │ 이벤트: { match_event, game_clear_event, streak_fill_event }
    ▼
[서버 로직 — 게임 클리어 시]
    │ 1. 콤보 누적 → combo_reward 합산
    │    combo_total = Σ combo_reward(n) for n=1..max_combo
    │ 2. 덱 잔존 카드 수 → deck_bonus
    │    deck_bonus = remaining_deck_reward × remaining_card_count
    │ 3. 스트릭 미터 달성 여부 → streak_reward
    │    streak_reward = streak_meter_gold (달성) or 0
    │ 4. 총 보상 = combo_total + deck_bonus + streak_reward
    ├─ 클리어  → gold += 총보상, 퍼즐 조각 지급 (is_album_collection_open 기준)
    └─ 실패    → 보상 미지급
    │ 응답: { gold_earned, puzzle_piece_earned, streak_star_consumed }
    ▼
[클라이언트 반영]
    │ 결과 화면 보상 애니메이션, gold 잔액 갱신
```

---

## 시스템 4: 방치 골드 충전 (Idle Gold)

### 주요 상수 (출처 비교)

| const_name                  | key    | 로컬 스냅샷 값 | 라이브 확정값 | 비고                         |
|-----------------------------|--------|---------------|---------------|------------------------------|
| idle_gold_charge_time       | 10002  | 14,400초      | 14,400초      | 4시간 주기                   |
| idle_gold_charge_amount     | 10003  | 3,000g        | 3,000g        | Lv1 기준 충전량              |
| idle_gold_interval          | 10004  | 20 레벨       | 20 레벨       | 충전량 인상 주기              |
| idle_gold_amount_increase   | 10005  | 1,200g [스냅샷 구버전] | **400g [가설, PM 승인]** | 시뮬레이션 v2 확정값 사용    |
| idle_gold_max_cap           | 10006  | 8,000g [스냅샷 구버전] | **10,000g**   | simulation v2 기준 10,000g  |

> **주의**: 로컬 PST_const.json은 구버전. `idle_gold_amount_increase`는 라이브 시트 PM 승인값 400g 적용. `idle_gold_max_cap`은 simulation v2에서 10,000g으로 사용.

### 계산 공식 블록

```
[방치 골드 충전량 계산]

공식:
  tier = floor((level - 1) / idle_gold_interval)
  charge_amount = idle_gold_charge_amount + tier × idle_gold_amount_increase
  charge_amount = min(charge_amount, idle_gold_max_cap)

변수 정의:
  - level                   : 현재 플레이어 레벨
  - idle_gold_charge_amount : const[10003] = 3,000g (초기값)
  - idle_gold_interval      : const[10004] = 20 레벨
  - idle_gold_amount_increase: const[10005] = 400g [가설, PM 승인]
  - idle_gold_max_cap       : 10,000g (simulation v2 확정)

공식 (일일 최대 획득량):
  max_collects_per_day = floor(86400 / idle_gold_charge_time)
                       = floor(86400 / 14400) = 6회/일 (이론)
  ※ 실제 수집 빈도 = 유저 행동에 따름 (simulation v2 기준: 3회/일 가정)
  daily_idle_gold = charge_amount × actual_collects
  daily_idle_gold = min(daily_idle_gold, idle_gold_max_cap × actual_collects)
  ※ cap은 지갑 상한이므로 수집 전 누적량에 적용

예시 (Lv75):
  tier = floor((75-1) / 20) = floor(74/20) = floor(3.7) = 3
  charge_amount = 3000 + 3 × 400 = 4,200g
  3회 수집/일: 4,200 × 3 = 12,600g/일
  4회 수집/일: 4,200 × 4 = 16,800g/일
```

### 레벨별 충전량 테이블 (idle_gold_amount_increase=400g 확정)

| 레벨   | tier | 4h당 충전량 | 3회/일     | 4회/일     |
|--------|------|------------|------------|------------|
| Lv1    | 0    | 3,000g     | 9,000g     | 12,000g    |
| Lv10   | 0    | 3,000g     | 9,000g     | 12,000g    |
| Lv20   | 0    | 3,000g     | 9,000g     | 12,000g    |
| Lv21   | 1    | 3,400g     | 10,200g    | 13,600g    |
| Lv30   | 1    | 3,400g     | 10,200g    | 13,600g    |
| Lv41   | 2    | 3,800g     | 11,400g    | 15,200g    |
| Lv50   | 2    | 3,800g     | 11,400g    | 15,200g    |
| **Lv75**|**3**| **4,200g** | **12,600g**| **16,800g**|
| Lv100  | 4    | 4,600g     | 13,800g    | 18,400g    |
| Lv150  | 7    | 5,800g     | 17,400g    | 23,200g    |
| Lv200  | 9    | 6,600g     | 19,800g    | 26,400g    |
| Lv350  | 17   | 9,800g→cap | cap적용    | cap적용    |

> ※ charge_amount ≥ idle_gold_max_cap(10,000g) 도달 레벨 계산:
> 10,000 = 3,000 + tier × 400 → tier = 17.5 → tier=18 (Lv18×20+1=361레벨 이상)에서 cap 도달

### 상태 전이표

| 현재 상태       | 전이 조건                               | 다음 상태           | 조건 출처                           |
|-----------------|-----------------------------------------|---------------------|-------------------------------------|
| 충전 대기       | 경과 시간 >= idle_gold_charge_time(14400초) | 충전 완료 (지갑 ready) | const[10002]                    |
| 충전 완료       | 플레이어 수집 액션                      | gold += charge_amount | const[10003+10004+10005]          |
| 충전 완료       | 미수집 상태로 2회 충전 경과            | 지갑 = cap(10,000g) | idle_gold_max_cap                  |
| gold += 충전량  | gold + charge_amount > gold_max_limit  | gold = gold_max_limit | const[10059] gold_max_limit=10,000|

> ※ idle_gold_max_cap(지갑 상한) vs gold_max_limit(골드 잔액 상한): 둘 다 10,000g이나 별개 상수. idle_gold_max_cap은 미수집 누적 상한, gold_max_limit은 총 보유 상한.

### 데이터 흐름도

```
[서버 타이머 — idle_gold_charge_time(14400초)마다]
    │ 조건: 경과 시간 >= 14,400초
    │ 계산: charge_amount = 3000 + floor((level-1)/20) × 400
    │       idle_wallet = min(idle_wallet + charge_amount, idle_gold_max_cap)
    ▼
[클라이언트 수집 요청]
    │ 요청: { collect_idle_gold }
    ▼
[서버 로직]
    │ gold_to_add = idle_wallet
    ├─ gold + gold_to_add <= gold_max_limit → gold += gold_to_add
    └─ gold + gold_to_add > gold_max_limit  → gold = gold_max_limit
    │ idle_wallet = 0
    │ 응답: { gold_added, gold_remaining, next_charge_time }
    ▼
[클라이언트 반영]
    │ 방치 골드 수집 애니메이션, gold 잔액 갱신, 다음 충전 타이머 표시
```

---

## 시스템 5: 광고 보상 (Ad Rewards)

### 주요 상수 (출처 비교)

| const_name              | key   | 로컬 스냅샷 값     | 라이브 확정값 (PM 승인)      |
|-------------------------|-------|-------------------|------------------------------|
| inbox_free_gold_limit   | 10057 | 5회/일            | 5회/일                       |
| inbox_free_gold_amount  | 10058 | 2,000g [스냅샷 구버전] | **800g [가설, PM 승인]**  |
| popup_free_gold_limit   | 10063 | 10회/일           | 10회/일                      |
| popup_free_gold_amount  | 10064 | 2,000g [스냅샷 구버전] | **800g [가설, PM 승인]**  |
| daily_wheel_ad_limit    | 10027 | 5회/일            | 5회/일                       |

> **주의**: inbox/popup free_gold_amount 값은 라이브 시트에 "가설" 주석 달린 PM 승인 수정값(800g). 로컬 스냅샷(2,000g)은 구버전.

### 계산 공식 블록

#### 5-A. 우편함(Inbox) RV 광고

```
[Inbox RV 광고 보상]

공식:
  inbox_daily_max = inbox_free_gold_limit × inbox_free_gold_amount
                  = 5 × 800 = 4,000g/일

리셋: UTC 00:00 일일 리셋

변수 정의:
  - inbox_free_gold_limit  : const[10057] = 5회/일
  - inbox_free_gold_amount : 800g [가설, PM 승인]

예시:
  1회 시청 → 800g 지급
  일 5회 시청 → 4,000g/일
```

#### 5-B. 팝업(Popup) RV 광고

```
[Popup RV 광고 보상]

공식:
  popup_daily_max = popup_free_gold_limit × popup_free_gold_amount
                  = 10 × 800 = 8,000g/일

리셋: UTC 00:00 일일 리셋

변수 정의:
  - popup_free_gold_limit  : const[10063] = 10회/일
  - popup_free_gold_amount : 800g [가설, PM 승인]

예시:
  1회 시청 → 800g 지급
  일 10회 시청 → 8,000g/일
```

#### 5-C. 데일리 휠 (Daily Wheel) 광고

```
[데일리 휠 보상 기대값]

가챠 풀 (출처: daily_wheel 시트, 라이브 확정):
  key 140001: currency_gold    800g  확률 3000/10000 (30.0%)
  key 140002: booster_undo     1개   확률 2500/10000 (25.0%)
  key 140003: currency_gold  2,000g  확률 1500/10000 (15.0%)
  key 140004: booster_fireworks 1개  확률 1200/10000 (12.0%)
  key 140005: booster_wild_card 1개  확률  800/10000  (8.0%)
  key 140006: currency_ticket   1개  확률  600/10000  (6.0%)
  key 140007: currency_gold   6,000g 확률  300/10000  (3.0%)
  key 140008: currency_ticket  3개   확률  100/10000  (1.0%)
  합계: 10,000/10,000 ✓

골드 기대값(EV) 계산:
  EV_gold = 800×(3000/10000) + 2000×(1500/10000) + 6000×(300/10000)
           = 240 + 300 + 180 = 720g/회

일일 최대:
  daily_wheel_ad_limit = 5회/일 (const[10027])
  일 골드 기대값 = 720 × 5 = 3,600g/일
```

#### 데일리 휠 가챠 확률표

| key    | 보상 아이템          | 수량 | 확률(/ 10000) | 확률(%) | 골드 EV  |
|--------|---------------------|------|--------------|---------|---------|
| 140001 | currency_gold       | 800g | 3,000        | 30.0%   | 240g    |
| 140002 | booster_undo        | 1개  | 2,500        | 25.0%   | —       |
| 140003 | currency_gold       | 2,000g | 1,500      | 15.0%   | 300g    |
| 140004 | booster_fireworks   | 1개  | 1,200        | 12.0%   | —       |
| 140005 | booster_wild_card   | 1개  | 800          | 8.0%    | —       |
| 140006 | currency_ticket     | 1개  | 600          | 6.0%    | —       |
| 140007 | currency_gold       | 6,000g | 300        | 3.0%    | 180g    |
| 140008 | currency_ticket     | 3개  | 100          | 1.0%    | —       |
| **합계** |                   |      | **10,000**   | **100%**| **720g/회** |

### 일일 패시브 광고 골드 공급량 요약 (Lv75 기준)

| 소스           | 1회 | 횟수/일  | 일 공급량    |
|----------------|-----|---------|-------------|
| Inbox RV       | 800g| 5회     | 4,000g      |
| Popup RV       | 800g| 10회    | 8,000g      |
| Daily Wheel EV | 720g| 5회     | 3,600g      |
| **합계**       |     |         | **15,600g** |

### 상태 전이표 (광고 보상)

| 현재 상태          | 전이 조건                                   | 다음 상태            | 조건 출처                          |
|--------------------|---------------------------------------------|----------------------|------------------------------------|
| 우편함 광고 대기   | RV 광고 시청 완료                           | inbox 보상 지급      | inbox_free_gold_limit(5회)         |
| 우편함 광고 대기   | 일일 횟수 >= inbox_free_gold_limit          | 광고 버튼 비활성화   | UTC0 리셋까지                      |
| 팝업 광고 대기     | RV 광고 시청 완료                           | popup 보상 지급      | popup_free_gold_limit(10회)        |
| 팝업 광고 대기     | 일일 횟수 >= popup_free_gold_limit          | 광고 버튼 비활성화   | UTC0 리셋까지                      |
| 데일리 휠 대기     | 광고 시청 + 휠 돌리기                       | 가챠 결과 지급       | daily_wheel 풀 + gacha_rate        |
| 데일리 휠 대기     | 일일 횟수 >= daily_wheel_ad_limit(5회)     | 휠 비활성화          | UTC0 리셋까지                      |
| 임의 상태          | UTC 00:00 도달                              | 모든 광고 카운터 리셋 | UTC0 일일 리셋                    |

### 데이터 흐름도

```
[클라이언트]
    │ 요청: { ad_type(inbox/popup/daily_wheel), ad_watch_complete=true }
    ▼
[서버 로직]
    │ 1. 일일 카운터 확인 (UTC0 기준)
    ├─ inbox:       daily_count < 5  → gold += 800
    ├─ popup:       daily_count < 10 → gold += 800
    ├─ daily_wheel: daily_count < 5  → gacha(daily_wheel 풀) → 보상 지급
    └─ 초과 시      → 오류 응답 (DAILY_LIMIT_EXCEEDED)
    │ 2. daily_count[ad_type] += 1
    │ 응답: { reward_item, reward_amount, gold_remaining, daily_count_remaining }
    ▼
[클라이언트 반영]
    │ 보상 애니메이션, gold 갱신, 잔여 시청 가능 횟수 UI 갱신
```

---

## 시스템 6: 메타 데코레이션 골드 Sink (Meta Decoration)

### 데이터 출처 및 총량 (출처: meta_decoration_list 시트, 라이브 확정)

| 항목                  | 수치                          |
|-----------------------|-------------------------------|
| 총 아이템 수          | 80개 (16개 도시 × 5개)        |
| 최대 업그레이드 단계   | 2단계/아이템 = 총 160업그레이드 |
| 총 해머(티켓) 소모    | 924매                         |
| 총 골드 소모          | 283,600g                      |
| 도시 수               | 16개 (NY, LA, SF, LV, CHI, MIA, PAR, LON, ROM, VEN, TKY, BKK, CAI, DUB, SYD, RIO) |

### 계산 공식 블록

```
[메타 업그레이드 비용]

공식 (단계별):
  업그레이드 실행 조건: hammer_inventory >= cost_hammerN AND gold >= cost_goldN
  업그레이드 후:
    hammer_inventory -= cost_hammerN
    gold -= cost_goldN
    decoration.upgrade_stage = N

변수 정의 (출처: meta_decoration_list 시트):
  - cost_hammerN  : 업그레이드 단계 N의 해머 소모량
  - cost_goldN    : 업그레이드 단계 N의 골드 소모량
  - upgrade_max   : 최대 업그레이드 단계 (대부분 2)
  - is_ad_var     : 광고 변형 활성 여부

예시 (deco_new_york_central_park, key 70001):
  단계 1: cost_hammer1=1, cost_gold1=0g   → 해머만 소모
  단계 2: cost_hammer2=1, cost_gold2=500g → 해머+골드 소모
```

### 도시별 Sink 규모 (출처: simulation v2 확정 수치)

| 도시 그룹         | 도시명                          | 해머 소모 | 골드 소모  | 이벤트 티켓 기준 완료 일수 |
|-------------------|---------------------------------|----------|----------|--------------------------|
| 초반 (6개 도시)   | NY, LA, SF, LV, CHI, MIA       | 216매    | 65,600g  | 14.1일                   |
| 중반 (4개 도시)   | PAR, LON, ROM, VEN              | 216매    | 64,200g  | 14.1일                   |
| 후반 (4개 도시)   | TKY, BKK, CAI, DUB              | 304매    | 88,300g  | 19.9일                   |
| 최후반 (2개 도시) | SYD, RIO                        | 188매    | 64,700g  | 12.3일                   |
| **전체**          | **16개 도시**                   | **924매**|**283,600g**| **60.4일**             |

### 해머 획득 경로 및 소진 기간

```
[해머 획득 경로]

주요 소스: 이벤트 마일스톤 보상 (출처: 08_booster_analysis.md, event_milestone 시트)
  - black_card_milestone : 3매/주기 (3일 운영)
  - winning_milestone    : 5매/주기 (3일 운영)
  ※ red_card_milestone은 티켓 보상 없음
  주당 총 획득: 8매/주 (이벤트 정상 참여 기준)

소진 기간 계산:
  total_hammer = 924매
  weekly_earn  = 8매/주
  weeks_needed = ceil(924 / 8) = 116주 (≈ 808일)

  ※ 실제 메타 진행 속도는 골드가 아닌 해머 수급이 병목.
     골드 283,600g은 패시브 소득(26,024g/일) 기준 약 10.9일치 — 골드는 메타 진행의 부수적 비용.
```

### 메타 골드 Sink 일별 소진 분석

```
[골드 Sink 소진 기간]

계산 기준: 이벤트 티켓(해머) 수급 속도 = 8매/주
  Lv75 기준 일 패시브 골드 소득: 26,024g/일 (simulation v2)
  메타 총 골드 비용: 283,600g

  패시브 소득 기준 골드 소진 기간: 283,600 / 26,024 ≈ 10.9일 (골드 단독)
  해머 수급 기준 실제 메타 완주: 924 / 8 ≈ 116주 (808일)

  → 메타는 해머가 게이팅. 골드는 메타 진행 중 산발적으로 소비됨.
  → 메타 골드 소비 속도: 283,600g / 808일 ≈ 351g/일 (해머 gate 기준)
  → 의미 있는 골드 Sink로서의 메타 기여도: 351g/일 ÷ 26,024g/일 = 1.3% (미미)
```

### 상태 전이표 (메타 업그레이드)

| 현재 상태          | 전이 조건                                        | 다음 상태                | 조건 출처                              |
|--------------------|--------------------------------------------------|--------------------------|----------------------------------------|
| 메타 로비 진입     | 도시 선택                                        | 업그레이드 대상 표시      | meta_decoration_list.city_id           |
| 업그레이드 선택    | hammer >= cost_hammerN AND gold >= cost_goldN    | 업그레이드 실행           | meta_decoration_list.cost_hammerN/goldN|
| 업그레이드 선택    | hammer < cost_hammerN                            | 해머 부족 팝업            | currency_hammer (item 40002)           |
| 업그레이드 선택    | gold < cost_goldN                                | 골드 부족 팝업            | gold_max_limit (const[10059])          |
| 업그레이드 실행    | upgrade_stage < upgrade_max                      | 다음 단계 잠금 해제       | meta_decoration_list.upgrade_max       |
| 업그레이드 실행    | upgrade_stage == upgrade_max                     | 최대 단계 완료 표시       | meta_decoration_list.upgrade_max       |
| 도시 전체 완료     | 모든 아이템 upgrade_stage == upgrade_max         | 도시 완주 보상 (가설)     | —                                      |
| 전체 메타 완주     | 16개 도시 전체 완료                              | 메타 골드 Sink 소멸       | simulation v2 60.4일 기준              |

### 데이터 흐름도

```
[클라이언트]
    │ 요청: { decoration_key(70001~), upgrade_stage(1/2) }
    ▼
[서버 로직]
    │ 1. meta_decoration_list[decoration_key] 조회
    │    → cost_hammerN, cost_goldN, upgrade_max
    │ 2. 조건 검증:
    ├─ hammer >= cost_hammerN AND gold >= cost_goldN
    │    → hammer -= cost_hammerN
    │    → gold   -= cost_goldN
    │    → decoration.upgrade_stage = N
    │    → 응답: 성공
    ├─ hammer < cost_hammerN → 오류 (INSUFFICIENT_HAMMER)
    └─ gold < cost_goldN    → 오류 (INSUFFICIENT_GOLD)
    │ 응답: { decoration_key, new_stage, hammer_remaining, gold_remaining }
    ▼
[클라이언트 반영]
    │ 데코레이션 비주얼 변경 애니메이션
    │ 해머·골드 잔액 갱신
    │ 다음 단계 잠금/잠금해제 UI 갱신
```

---

## 부록 A: 시스템 간 골드 흐름 요약 (Lv75 기준)

### 일일 골드 공급 (Source)

| 시스템      | 소스                          | 일 공급량      | 비율  |
|-------------|-------------------------------|---------------|-------|
| 시스템 4    | 방치 골드 (3회 수집/일)       | 12,600g       | 48.4% |
| 시스템 5    | 팝업 RV (10회)                | 8,000g        | 30.7% |
| 시스템 5    | 우편함 RV (5회)               | 4,000g        | 15.4% |
| 시스템 5    | 데일리 휠 (5회, EV)           | 3,600g        | 13.8% |
| 시스템 3    | 인게임 보상 (10게임, 221g/판) | 2,210g        | 8.5%  |
| —           | 7일 출석 보상                 | 224g          | 0.9%  |
| **합계**    |                               | **~30,634g**  |       |

> ※ 이벤트 보상(주당 29,000g) 제외. 인게임 보상은 gross 기준.

### 일일 골드 소모 (Sink)

| 시스템      | 소모처                          | 일 소모량 (평균 플레이 유저) | 비율  |
|-------------|-----------------------------------|-----------------------------|-------|
| 시스템 1    | 입장료 (10게임, x1 베팅)         | -20,000g                    | 69.4% |
| 시스템 3    | 인게임 보상 차감 후 순소모       | (-15,790g 상쇄됨)           | —     |
| 시스템 2    | 부스터 (평균 사용 기준)          | -3,000~-5,000g              | 가설  |
| 시스템 6    | 메타 골드 (해머 gate 기준)       | ~-351g                      | 1.2%  |
| **소모 합계 (비부스터)** |                    | **~-1,120g/일 (게임 순손실)**|       |

---

## 부록 B: 데이터 소스 신뢰도 등급

| 데이터                           | 소스                         | 신뢰도    |
|----------------------------------|------------------------------|-----------|
| level_entry_tier 전체            | pst_sheets.json (라이브)     | 확정      |
| item_list 부스터 5종             | pst_sheets.json (라이브)     | 확정      |
| daily_wheel 가챠 풀              | pst_sheets.json (라이브)     | 확정      |
| meta_decoration_list 도시/비용   | pst_sheets.json (라이브)     | 확정      |
| idle_gold_charge_time/amount     | PST_const.json (스냅샷)      | 확정 (불변) |
| idle_gold_amount_increase=400g   | pst_sheets.json Updated Data | 가설 (PM 승인) |
| idle_gold_max_cap=10,000g        | simulation v2 기준           | 가설      |
| inbox/popup_free_gold_amount=800g| pst_sheets.json Updated Data | 가설 (PM 승인) |
| ingame_combo/deck_reward 상수    | PST_const.json (스냅샷)      | 확정      |
| 클리어율 85% (Lv75)              | simulation v2                | 가설      |
| 덱 보너스 avg 5장 잔존           | simulation v2                | 가설      |
| 스트릭 미터 달성률 70%           | simulation v2                | 가설      |
| 메타 총 sink 283,600g / 924해머  | simulation v2 (시트 집계)    | 확정      |
