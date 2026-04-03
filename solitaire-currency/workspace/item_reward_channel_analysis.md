# PST 아이템별 보상 채널 분석

생성일: 2026-03-12 | 데이터 소스: PST Google Sheet (1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk)

---

## 1. 스프레드시트 시트 목록

| 시트명 | gid | 보상 관련 여부 | 비고 |
|---|---|---|---|
| `tool` | 11825551 | N | 툴/계산 시트 |
| `const` | 375222820 | N | 핵심 상수 |
| `gimmick_weight` | 1454730339 | N | 기믹 가중치 |
| `difficulty_tier` | 854311719 | N | 난이도 구간 |
| `dynamic_level` | 1439840956 | N | DDA 파라미터 |
| `level_entry_tier` | 144373391 | N | 티어별 입장료/콤보 보상 수식 참조 |
| `streak_reward` | 1504157865 | **Y** | 스트릭 가챠 풀 (req_length 3풀) |
| `item_list` | 1074709862 | N | 아이템 마스터 |
| `unlock` | 1177964140 | N | 해금 조건 |
| `meta_city_list` | 701245569 | N | 메타 도시 |
| `meta_decoration_list` | 680706612 | N | 메타 데코 |
| `collection_album_puzzle_list` | 493736418 | N | 앨범 퍼즐 목록 |
| `collection_puzzle_piece_list` | 1565997181 | N | 퍼즐 조각 목록 |
| `collection_album_milestone` | 1059746257 | **Y** | 앨범 마일스톤 보상 (20단계) |
| `collection_deck` | 1234711680 | N | 덱 목록 (보상 없음) |
| `daily_task` | 1786065596 | N | 일일 태스크 정의 |
| `daily_task_milestone` | 898038162 | **Y** | 일일 태스크 마일스톤 보상 (3단계) |
| `daily_wheel` | 550232648 | **Y** | 데일리 휠 가챠 풀 (8슬롯, 합계 10000) |
| `daily_gift` | 1558739348 | **Y** | 7일 출석 보상 |
| `event_schedule` | 587625663 | N | 이벤트 스케줄 |
| `event_ranking` | 1910606750 | **Y** | 이벤트 랭킹 보상 (순위별) |
| `event_milestone` | 1807743099 | **Y** | 이벤트 마일스톤 보상 (이벤트별) |
| `product` | 1626427544 | **Y** | IAP/AD 상품 (11개) |
| `string_code` | 3322884 | N | 문자열 코드 |

> 보상 관련 시트 7개: `daily_wheel`, `daily_gift`, `streak_reward`, `event_milestone`, `collection_album_milestone`, `daily_task_milestone`, `event_ranking`, `product`

---

## 2. 시트별 보상 구조 요약

### 2.1 daily_wheel (데일리 휠 가챠)

- 타입: 가챠 (gacha_rate 합계 = 10,000)
- 슬롯 수: 8개

| key | 아이템 | 수량 | gacha_rate | 확률 |
|---|---|---|---|---|
| 140001 | currency_gold | 800 | 3000 | 30.0% |
| 140002 | booster_undo | 1 | 2500 | 25.0% |
| 140003 | currency_gold | 2000 | 1500 | 15.0% |
| 140004 | booster_fireworks | 1 | 1200 | 12.0% |
| 140005 | booster_wild_card | 1 | 800 | 8.0% |
| 140006 | currency_ticket | 1 | 600 | 6.0% |
| 140007 | currency_gold | 6000 | 300 | 3.0% |
| 140008 | currency_ticket | 3 | 100 | 1.0% |

- gold 기댓값: 720g/회, ticket 기댓값: 0.090개/회

### 2.2 daily_gift (7일 출석 보상)

- 타입: 고정 (deterministic, 7일 사이클)

| key | 일차(day) | 보상1 | 수량1 | 보상2 | 수량2 | 보상3 | 수량3 |
|---|---|---|---|---|---|---|---|
| 150001 | 0 | currency_gold | 1000 | none | 0 | none | 0 |
| 150002 | 1 | currency_ticket | 1 | none | 0 | none | 0 |
| 150003 | 2 | currency_gold | 2000 | none | 0 | none | 0 |
| 150004 | 3 | booster_undo | 2 | none | 0 | none | 0 |
| 150005 | 4 | currency_gold | 3000 | none | 0 | none | 0 |
| 150006 | 5 | booster_wild_card | 1 | none | 0 | none | 0 |
| 150007 | 6 | currency_ticket | 2 | booster_fireworks | 1 | currency_gold | 5000 |

### 2.3 streak_reward (스트릭 가챠)

- 타입: 가챠 (req_length별 독립 풀 3개)
- 각 풀은 req_length(필요 콤보 연속)에 따라 독립적으로 추첨
- `reward_type=tier_combo_reward`: 수량 = `combo_reward_base + combo_reward_increase × (req_length-1)` (level_entry_tier 참조)
- `reward_type=fixed`: 수량 고정

**Pool req_length=4** (rate합=21000, 각 33.3%)**

| key | 아이템 | reward_type | 수량 | 확률 |
|---|---|---|---|---|
| 200001 | currency_gold | tier_combo_reward | (tier참조) | 33.3% |
| 200004 | currency_gold | fixed | 1 | 33.3% |
| 200007 | reward_plus_card_1 | fixed | 1 | 33.3% |

**Pool req_length=5** (rate합=15000, 각 33.3%)**

| key | 아이템 | reward_type | 수량 | 확률 |
|---|---|---|---|---|
| 200002 | booster_wild_card | fixed | 1 | 33.3% |
| 200005 | booster_fireworks | fixed | 1 | 33.3% |
| 200008 | currency_gold | tier_combo_reward | (tier참조) | 33.3% |

**Pool req_length=6** (rate합=9000, 각 33.3%)**

| key | 아이템 | reward_type | 수량 | 확률 |
|---|---|---|---|---|
| 200003 | reward_plus_card_1 | fixed | 2 | 33.3% |
| 200006 | reward_plus_card_1 | tier_combo_reward | (tier참조) | 33.3% |
| 200009 | booster_wild_card | fixed | 2 | 33.3% |


### 2.4 event_milestone (이벤트 마일스톤)

- 타입: 고정 (단계별 누적 목표 달성 시)
- 이벤트 160001 (15단계), 이벤트 160002 (9단계 이하, 데이터 24행)

| key | event_id | step | 아이템 | 수량 |
|---|---|---|---|---|
| 180001 | 160001 | 1 | currency_gold | 133 |
| 180002 | 160001 | 2 | currency_gold | 267 |
| 180004 | 160001 | 3 | booster_undo | 1 |
| 180005 | 160001 | 4 | currency_gold | 400 |
| 180007 | 160001 | 5 | currency_gold | 533 |
| 180008 | 160001 | 6 | booster_undo | 2 |
| 180010 | 160001 | 7 | currency_gold | 667 |
| 180012 | 160001 | 8 | currency_gold | 800 |
| 180014 | 160001 | 9 | booster_undo | 3 |
| 180016 | 160001 | 10 | currency_gold | 1000 |
| 180017 | 160001 | 11 | currency_ticket | 1 |
| 180019 | 160001 | 12 | currency_gold | 1333 |
| 180020 | 160001 | 13 | booster_undo | 5 |
| 180022 | 160001 | 14 | currency_gold | 2000 |
| 180023 | 160001 | 15 | currency_ticket | 2 |
| 180025 | 160002 | 1 | currency_gold | 133 |
| 180027 | 160002 | 2 | currency_gold | 267 |
| 180029 | 160002 | 3 | booster_fireworks | 1 |
| 180031 | 160002 | 4 | currency_gold | 400 |
| 180033 | 160002 | 5 | currency_gold | 533 |
| 180036 | 160002 | 6 | booster_fireworks | 1 |
| 180039 | 160002 | 7 | currency_gold | 667 |
| 180042 | 160002 | 8 | currency_gold | 800 |
| 180044 | 160002 | 9 | booster_wild_card | 1 |

### 2.5 collection_album_milestone (앨범 마일스톤)

- 타입: 고정 (퍼즐조각 누적 수량 달성 시, 20단계)
- ⚠️ key=110016 (req=1250): booster_extra_deck × 5000 → 데이터 이상값 의심 (다른 슬롯은 ×1~2)

| key | req_point | 아이템 | 수량 |
|---|---|---|---|
| 110001 | 10 | currency_gold | 1000 |
| 110002 | 30 | booster_undo | 2 |
| 110003 | 50 | currency_gold | 1000 |
| 110004 | 80 | booster_fireworks | 1 |
| 110005 | 120 | currency_ticket | 1 |
| 110006 | 170 | booster_wild_card | 1 |
| 110007 | 230 | currency_gold | 2000 |
| 110008 | 300 | infinite_ticket_5m | 1 |
| 110009 | 380 | booster_extra_deck | 1 |
| 110010 | 470 | infinite_ticket_5m | 1 |
| 110011 | 570 | currency_gold | 3000 |
| 110012 | 680 | currency_gold | 2 |
| 110013 | 800 | infinite_ticket_10m | 1 |
| 110014 | 930 | booster_wild_card | 2 |
| 110015 | 1070 | infinite_ticket_10m | 1 |
| 110016 | 1250 | booster_extra_deck | 5000 ⚠️이상 |
| 110017 | 1450 | booster_extra_deck | 2 |
| 110018 | 1650 | infinite_fireworks_15m | 1 |
| 110019 | 1850 | currency_gold | 10000 |
| 110020 | 2000 | infinite_ticket_15m | 1 |

### 2.6 daily_task_milestone (일일 태스크 마일스톤)

- 타입: 고정 (태스크 포인트 누적, 3단계)

| key | step | req_point | 아이템 | 수량 |
|---|---|---|---|---|
| 130001 | 1 | 30 | currency_gold | 1000 |
| 130002 | 2 | 50 | booster_undo | 1 |
| 130003 | 3 | 100 | currency_ticket | 1 |

### 2.7 event_ranking (이벤트 랭킹 보상)

- 타입: 경쟁 (이벤트 종료 후 순위별 지급)
- 이벤트 160004 기준, 10위까지 보상

| key | rank | 보상1 | 수량1 | 보상2 | 수량2 | 보상3 | 수량3 |
|---|---|---|---|---|---|---|---|
| 170001 | 1위 | booster_golden_ticket | 3 | currency_gold | 5000 | currency_ticket | 3 |
| 170002 | 2위 | booster_golden_ticket | 2 | currency_gold | 3000 | currency_ticket | 2 |
| 170003 | 3위 | booster_golden_ticket | 1 | currency_gold | 2000 | currency_ticket | 1 |
| 170004 | 4~6위 | currency_gold | 1000 | booster_undo | 1 | none | 0 |
| 170005 | 7~10위 | currency_gold | 1000 | none | 0 | none | 0 |

### 2.8 product (IAP/AD 상품)

- 타입: 유료(IAP) 및 광고(AD)
- 11개 상품 (AD 1개, IAP 일반 7개, IAP 스페셜오퍼 3개)

| key | 상품명 | pay_type | 보상1 | 보상2 | 보상3 | 보상4 | 보상5 |
|---|---|---|---|---|---|---|---|
| 190001 | T_SHOP_FREE_GOLD | AD | currency_gold×1000 | — | — | — | — |
| 190002 | T_SHOP_GOLD_1 | IAP | currency_gold×10000 | — | — | — | — |
| 190003 | T_SHOP_GOLD_2 | IAP | currency_gold×32000 | — | — | — | — |
| 190004 | T_SHOP_BUNDLE_1 | IAP | currency_gold×27000 | booster_undo×1 | currency_ticket×1 | — | — |
| 190005 | T_SHOP_BUNDLE_2 | IAP | currency_gold×50000 | booster_wild_card×1 | booster_extra_deck×1 | booster_undo×1 | currency_ticket×1 |
| 190006 | T_SHOP_BUNDLE_3 | IAP | currency_gold×85000 | booster_wild_card×2 | booster_extra_deck×2 | booster_undo×2 | currency_ticket×2 |
| 190007 | T_SHOP_BUNDLE_4 | IAP | currency_gold×170000 | booster_wild_card×4 | booster_extra_deck×4 | booster_undo×4 | currency_ticket×4 |
| 190008 | T_SHOP_BUNDLE_5 | IAP | currency_gold×370000 | booster_wild_card×8 | booster_extra_deck×8 | booster_undo×8 | currency_ticket×8 |
| 190101 | T_SHOP_SPECIAL_OFFER_1 | IAP | currency_gold×25000 | booster_extra_deck×2 | currency_ticket×2 | booster_undo×2 | booster_wild_card×2 |
| 190102 | T_SHOP_SPECIAL_OFFER_2 | IAP | currency_gold×70000 | booster_wild_card×2 | booster_extra_deck×2 | booster_undo×1 | booster_fireworks×1 |
| 190103 | T_SHOP_SPECIAL_OFFER_3 | IAP | currency_gold×100000 | infinite_fireworks_10m×1 | infinite_gticket_10m×1 | booster_undo×2 | booster_wild_card×2 |

---

## 3. 아이템별 채널 분포 크로스 표

표기법: `슬롯수슬롯/수량` (가챠: 확률% 포함) | — = 해당 채널 없음

| 아이템 | 타입 | daily_wheel | daily_gift | streak_reward | event_milestone | album_milestone | daily_task | event_ranking | product(AD) | product(IAP) |
|---|---|---|---|---|---|---|---|---|---|---|
| `currency_gold` | currency | 3슬롯/avg2933/48.0% | 4슬롯/avg2750 | 3슬롯/1개/42.2% | 15슬롯/avg662 | 6슬롯/avg2834 | 1슬롯/1000개 | 5슬롯/avg2400 | 1슬롯/1000개 | 10슬롯/avg93900 |
| `currency_hammer` | currency | — | — | — | — | — | — | — | — | — |
| `currency_puzzle_piece` | currency | — | — | — | — | — | — | — | — | — |
| `currency_streak_star` | currency | — | — | — | — | — | — | — | — | — |
| `currency_ticket` | currency | 2슬롯/avg2/7.0% | 2슬롯/avg2 | — | 2슬롯/avg2 | 1슬롯/1개 | 1슬롯/1개 | 3슬롯/avg2 | — | 6슬롯/avg3 |
| `booster_extra_deck` | booster | — | — | — | — | 3슬롯/avg1668 | — | — | — | 6슬롯/avg3 |
| `booster_fireworks` | booster | 1슬롯/1개/12.0% | 1슬롯/1개 | 1슬롯/1개/11.1% | 2슬롯/1개 | 1슬롯/1개 | — | — | — | 1슬롯/1개 |
| `booster_golden_ticket` | booster | — | — | — | — | — | — | 3슬롯/avg2 | — | — |
| `booster_undo` | booster | 1슬롯/1개/25.0% | 1슬롯/2개 | — | 4슬롯/avg3 | 1슬롯/2개 | 1슬롯/1개 | 1슬롯/1개 | — | 8슬롯/avg3 |
| `booster_wild_card` | booster | 1슬롯/1개/8.0% | 1슬롯/1개 | 2슬롯/avg2/17.8% | 1슬롯/1개 | 2슬롯/avg2 | — | — | — | 7슬롯/avg3 |
| `infinite_fireworks_10m` | infinite | — | — | — | — | — | — | — | — | 1슬롯/1개 |
| `infinite_fireworks_15m` | infinite | — | — | — | — | 1슬롯/1개 | — | — | — | — |
| `infinite_fireworks_5m` | infinite | — | — | — | — | — | — | — | — | — |
| `infinite_gticket_10m` | infinite | — | — | — | — | — | — | — | — | 1슬롯/1개 |
| `infinite_gticket_15m` | infinite | — | — | — | — | — | — | — | — | — |
| `infinite_gticket_5m` | infinite | — | — | — | — | — | — | — | — | — |
| `infinite_ticket_10m` | infinite | — | — | — | — | 2슬롯/1개 | — | — | — | — |
| `infinite_ticket_15m` | infinite | — | — | — | — | 1슬롯/1개 | — | — | — | — |
| `infinite_ticket_5m` | infinite | — | — | — | — | 2슬롯/1개 | — | — | — | — |
| `reward_plus_card_1` | gimmick | — | — | 3슬롯/avg2/28.9% | — | — | — | — | — | — |

---

## 4. 채널별 획득 가능 여부 요약

### 4.1 무료 채널 등장 아이템

(daily_wheel / daily_gift / streak_reward / event_milestone / collection_album_milestone / daily_task_milestone / event_ranking 중 1개 이상 등장)

| 아이템 | 무료채널 수 | 채널 목록 |
|---|---|---|
| `booster_extra_deck` | 1 | collection_album_milestone |
| `booster_fireworks` | 5 | daily_wheel, daily_gift, streak_reward, event_milestone, collection_album_milestone |
| `booster_golden_ticket` | 1 | event_ranking |
| `booster_undo` | 6 | daily_wheel, daily_gift, event_milestone, collection_album_milestone, daily_task_milestone, event_ranking |
| `booster_wild_card` | 5 | daily_wheel, daily_gift, streak_reward, event_milestone, collection_album_milestone |
| `currency_gold` | 7 | daily_wheel, daily_gift, streak_reward, event_milestone, collection_album_milestone, daily_task_milestone, event_ranking |
| `currency_ticket` | 6 | daily_wheel, daily_gift, event_milestone, collection_album_milestone, daily_task_milestone, event_ranking |
| `infinite_fireworks_15m` | 1 | collection_album_milestone |
| `infinite_ticket_10m` | 1 | collection_album_milestone |
| `infinite_ticket_15m` | 1 | collection_album_milestone |
| `infinite_ticket_5m` | 1 | collection_album_milestone |
| `reward_plus_card_1` | 1 | streak_reward |

### 4.2 무료 획득 불가 아이템

| 아이템 | 타입 | 획득 가능 채널 | 비고 |
|---|---|---|---|
| `currency_hammer` | currency | 없음(데이터 없음) | 인게임 직접 사용, 보상 채널 없음 |
| `currency_puzzle_piece` | currency | 없음(데이터 없음) | 앨범 퍼즐 완성 시 자동 지급 추정 |
| `currency_streak_star` | currency | 없음(데이터 없음) | streak_reward에서 star_amount로 별도 지급 |
| `infinite_fireworks_10m` | infinite | IAP | 유료 전용 또는 album_milestone 일부만 등장 |
| `infinite_fireworks_5m` | infinite | 없음(데이터 없음) | 유료 전용 또는 album_milestone 일부만 등장 |
| `infinite_gticket_10m` | infinite | IAP | 유료 전용 또는 album_milestone 일부만 등장 |
| `infinite_gticket_15m` | infinite | 없음(데이터 없음) | 유료 전용 또는 album_milestone 일부만 등장 |
| `infinite_gticket_5m` | infinite | 없음(데이터 없음) | 유료 전용 또는 album_milestone 일부만 등장 |

---

## 5. 아이템별 채널 상세 통계

### booster_extra_deck (ID=40014, type=booster)

**collection_album_milestone** (고정, 슬롯수=3)
  - req_point=380: 수량 1
  - req_point=1250: 수량 5000 ⚠️이상값
  - req_point=1450: 수량 2

**product** (유료, 슬롯수=6)
  - [IAP] T_SHOP_BUNDLE_2: 수량 1
  - [IAP] T_SHOP_BUNDLE_3: 수량 2
  - [IAP] T_SHOP_BUNDLE_4: 수량 4
  - [IAP] T_SHOP_BUNDLE_5: 수량 8
  - [IAP] T_SHOP_SPECIAL_OFFER_1: 수량 2
  - [IAP] T_SHOP_SPECIAL_OFFER_2: 수량 2

### booster_fireworks (ID=40010, type=booster)

**daily_wheel** (가챠, 슬롯수=1)
  - 수량 1, gacha_rate=1200, 확률 12.0%

**daily_gift** (고정, 슬롯수=1)
  - Day 6: 수량 1

**streak_reward** (가챠, 슬롯수=1)
  - 확률 11.1%, reward_type=fixed, 수량 1

**event_milestone** (고정, 슬롯수=2)
  - 이벤트별 단계 보상: min=1, max=1, avg=1
  - event=160002 step=3: 수량 1
  - event=160002 step=6: 수량 1

**collection_album_milestone** (고정, 슬롯수=1)
  - req_point=80: 수량 1

**product** (유료, 슬롯수=1)
  - [IAP] T_SHOP_SPECIAL_OFFER_2: 수량 1

### booster_golden_ticket (ID=40011, type=booster)

**event_ranking** (경쟁, 슬롯수=3)
  - rank 1~1위: 수량 3
  - rank 2~2위: 수량 2
  - rank 3~3위: 수량 1

### booster_undo (ID=40012, type=booster)

**daily_wheel** (가챠, 슬롯수=1)
  - 수량 1, gacha_rate=2500, 확률 25.0%

**daily_gift** (고정, 슬롯수=1)
  - Day 3: 수량 2

**event_milestone** (고정, 슬롯수=4)
  - 이벤트별 단계 보상: min=1, max=5, avg=3
  - event=160001 step=3: 수량 1
  - event=160001 step=6: 수량 2
  - event=160001 step=9: 수량 3
  - event=160001 step=13: 수량 5

**collection_album_milestone** (고정, 슬롯수=1)
  - req_point=30: 수량 2

**daily_task_milestone** (고정, 슬롯수=1)
  - step=2: 수량 1

**event_ranking** (경쟁, 슬롯수=1)
  - rank 4~6위: 수량 1

**product** (유료, 슬롯수=8)
  - [IAP] T_SHOP_BUNDLE_1: 수량 1
  - [IAP] T_SHOP_BUNDLE_2: 수량 1
  - [IAP] T_SHOP_BUNDLE_3: 수량 2
  - [IAP] T_SHOP_BUNDLE_4: 수량 4
  - [IAP] T_SHOP_BUNDLE_5: 수량 8
  - [IAP] T_SHOP_SPECIAL_OFFER_1: 수량 2
  - [IAP] T_SHOP_SPECIAL_OFFER_2: 수량 1
  - [IAP] T_SHOP_SPECIAL_OFFER_3: 수량 2

### booster_wild_card (ID=40013, type=booster)

**daily_wheel** (가챠, 슬롯수=1)
  - 수량 1, gacha_rate=800, 확률 8.0%

**daily_gift** (고정, 슬롯수=1)
  - Day 5: 수량 1

**streak_reward** (가챠, 슬롯수=2)
  - 확률 11.1%, reward_type=fixed, 수량 1
  - 확률 6.7%, reward_type=fixed, 수량 2

**event_milestone** (고정, 슬롯수=1)
  - 이벤트별 단계 보상: min=1, max=1, avg=1
  - event=160002 step=9: 수량 1

**collection_album_milestone** (고정, 슬롯수=2)
  - req_point=170: 수량 1
  - req_point=930: 수량 2

**product** (유료, 슬롯수=7)
  - [IAP] T_SHOP_BUNDLE_2: 수량 1
  - [IAP] T_SHOP_BUNDLE_3: 수량 2
  - [IAP] T_SHOP_BUNDLE_4: 수량 4
  - [IAP] T_SHOP_BUNDLE_5: 수량 8
  - [IAP] T_SHOP_SPECIAL_OFFER_1: 수량 2
  - [IAP] T_SHOP_SPECIAL_OFFER_2: 수량 2
  - [IAP] T_SHOP_SPECIAL_OFFER_3: 수량 2

### currency_gold (ID=40001, type=currency)

**daily_wheel** (가챠, 슬롯수=3)
  - 수량 800, gacha_rate=3000, 확률 30.0%
  - 수량 2000, gacha_rate=1500, 확률 15.0%
  - 수량 6000, gacha_rate=300, 확률 3.0%

**daily_gift** (고정, 슬롯수=4)
  - Day 0: 수량 1000
  - Day 2: 수량 2000
  - Day 4: 수량 3000
  - Day 6: 수량 5000

**streak_reward** (가챠, 슬롯수=3)
  - 확률 15.6%, reward_type=tier_combo_reward, 수량 (tier_combo_reward: 5~12g by tier)
  - 확률 15.6%, reward_type=fixed, 수량 1
  - 확률 11.1%, reward_type=tier_combo_reward, 수량 (tier_combo_reward: 5~12g by tier)

**event_milestone** (고정, 슬롯수=15)
  - 이벤트별 단계 보상: min=133, max=2000, avg=662
  - event=160001 step=1: 수량 133
  - event=160001 step=2: 수량 267
  - event=160001 step=4: 수량 400
  - event=160001 step=5: 수량 533
  - event=160001 step=7: 수량 667
  - event=160001 step=8: 수량 800
  - event=160001 step=10: 수량 1000
  - event=160001 step=12: 수량 1333
  - event=160001 step=14: 수량 2000
  - event=160002 step=1: 수량 133
  - event=160002 step=2: 수량 267
  - event=160002 step=4: 수량 400
  - event=160002 step=5: 수량 533
  - event=160002 step=7: 수량 667
  - event=160002 step=8: 수량 800

**collection_album_milestone** (고정, 슬롯수=6)
  - req_point=10: 수량 1000
  - req_point=50: 수량 1000
  - req_point=230: 수량 2000
  - req_point=570: 수량 3000
  - req_point=680: 수량 2
  - req_point=1850: 수량 10000

**daily_task_milestone** (고정, 슬롯수=1)
  - step=1: 수량 1000

**event_ranking** (경쟁, 슬롯수=5)
  - rank 1~1위: 수량 5000
  - rank 2~2위: 수량 3000
  - rank 3~3위: 수량 2000
  - rank 4~6위: 수량 1000
  - rank 7~10위: 수량 1000

**product** (유료, 슬롯수=11)
  - [AD] T_SHOP_FREE_GOLD: 수량 1000
  - [IAP] T_SHOP_GOLD_1: 수량 10000
  - [IAP] T_SHOP_GOLD_2: 수량 32000
  - [IAP] T_SHOP_BUNDLE_1: 수량 27000
  - [IAP] T_SHOP_BUNDLE_2: 수량 50000
  - [IAP] T_SHOP_BUNDLE_3: 수량 85000
  - [IAP] T_SHOP_BUNDLE_4: 수량 170000
  - [IAP] T_SHOP_BUNDLE_5: 수량 370000
  - [IAP] T_SHOP_SPECIAL_OFFER_1: 수량 25000
  - [IAP] T_SHOP_SPECIAL_OFFER_2: 수량 70000
  - [IAP] T_SHOP_SPECIAL_OFFER_3: 수량 100000

### currency_hammer (ID=40002, type=currency)

- 어떤 보상 채널에도 등장하지 않음

### currency_puzzle_piece (ID=40005, type=currency)

- 어떤 보상 채널에도 등장하지 않음

### currency_streak_star (ID=40004, type=currency)

- 어떤 보상 채널에도 등장하지 않음

### currency_ticket (ID=40003, type=currency)

**daily_wheel** (가챠, 슬롯수=2)
  - 수량 1, gacha_rate=600, 확률 6.0%
  - 수량 3, gacha_rate=100, 확률 1.0%

**daily_gift** (고정, 슬롯수=2)
  - Day 1: 수량 1
  - Day 6: 수량 2

**event_milestone** (고정, 슬롯수=2)
  - 이벤트별 단계 보상: min=1, max=2, avg=2
  - event=160001 step=11: 수량 1
  - event=160001 step=15: 수량 2

**collection_album_milestone** (고정, 슬롯수=1)
  - req_point=120: 수량 1

**daily_task_milestone** (고정, 슬롯수=1)
  - step=3: 수량 1

**event_ranking** (경쟁, 슬롯수=3)
  - rank 1~1위: 수량 3
  - rank 2~2위: 수량 2
  - rank 3~3위: 수량 1

**product** (유료, 슬롯수=6)
  - [IAP] T_SHOP_BUNDLE_1: 수량 1
  - [IAP] T_SHOP_BUNDLE_2: 수량 1
  - [IAP] T_SHOP_BUNDLE_3: 수량 2
  - [IAP] T_SHOP_BUNDLE_4: 수량 4
  - [IAP] T_SHOP_BUNDLE_5: 수량 8
  - [IAP] T_SHOP_SPECIAL_OFFER_1: 수량 2

### infinite_fireworks_10m (ID=40021, type=infinite)

**product** (유료, 슬롯수=1)
  - [IAP] T_SHOP_SPECIAL_OFFER_3: 수량 1

### infinite_fireworks_15m (ID=40022, type=infinite)

**collection_album_milestone** (고정, 슬롯수=1)
  - req_point=1650: 수량 1

### infinite_fireworks_5m (ID=40020, type=infinite)

- 어떤 보상 채널에도 등장하지 않음

### infinite_gticket_10m (ID=40024, type=infinite)

**product** (유료, 슬롯수=1)
  - [IAP] T_SHOP_SPECIAL_OFFER_3: 수량 1

### infinite_gticket_15m (ID=40025, type=infinite)

- 어떤 보상 채널에도 등장하지 않음

### infinite_gticket_5m (ID=40023, type=infinite)

- 어떤 보상 채널에도 등장하지 않음

### infinite_ticket_10m (ID=40027, type=infinite)

**collection_album_milestone** (고정, 슬롯수=2)
  - req_point=800: 수량 1
  - req_point=1070: 수량 1

### infinite_ticket_15m (ID=40028, type=infinite)

**collection_album_milestone** (고정, 슬롯수=1)
  - req_point=2000: 수량 1

### infinite_ticket_5m (ID=40026, type=infinite)

**collection_album_milestone** (고정, 슬롯수=2)
  - req_point=300: 수량 1
  - req_point=470: 수량 1

### reward_plus_card_1 (ID=40029, type=gimmick)

**streak_reward** (가챠, 슬롯수=3)
  - 확률 6.7%, reward_type=fixed, 수량 2
  - 확률 6.7%, reward_type=tier_combo_reward, 수량 (tier_combo_reward: 5~12g by tier)
  - 확률 15.6%, reward_type=fixed, 수량 1


---

## 6. 특이 패턴 및 발견 사항

### 6.1 streak_reward 가챠 구조 (3개 독립 풀)

streak_reward는 단일 가챠 풀이 아니라 **req_length 값으로 구분된 3개의 독립 풀**로 구성된다.
gacha_rate 합계가 10,000이 아닌 이유이다.

| Pool | req_length | rate합 | 아이템 구성 |
|---|---|---|---|
| req_length=4 | 4연속 | 21000 | gold(33.3%×2, tier_combo/fixed), reward_plus_card_1(33.3%, fixed×1) |
| req_length=5 | 5연속 | 15000 | booster_wild_card(33.3%), booster_fireworks(33.3%), gold(33.3%, tier_combo) |
| req_length=6 | 6연속 | 9000 | reward_plus_card_1(66.7%, fixed×1~2), booster_wild_card(33.3%, fixed×2) |

### 6.2 streak_reward currency_gold: tier_combo_reward 타입

gold가 `reward_type=tier_combo_reward`인 경우 수량은 `combo_reward_base + combo_reward_increase × (req_length-1)` 공식으로 결정된다.
실제 지급량은 **5~12g** 수준(레벨별 tier에 따라)으로 매우 소량이다.

| 레벨 구간 | gold(req=4) | gold(req=5) |
|---|---|---|
| Lv3~49 | 5g | 6g |
| Lv50~349 | 6~7g | 7~8g |
| Lv350~549 | 9g | 11g |
| Lv550+ | 10g | 12g |

### 6.3 daily_wheel gold 기댓값

- gold EV = **720g/회** (30%×800 + 15%×2000 + 3%×6000)
- ticket EV = **0.090개/회** (6%×1 + 1%×3)

### 6.4 booster_golden_ticket: 경쟁 채널 전용

- `booster_golden_ticket`은 `event_ranking`(이벤트 순위 1~3위)에만 등장한다.
- IAP/AD/무료 채널 없음 → **상위 랭커 전용 희귀 보상**
- 이벤트 160004(랭킹 이벤트) 1위: 3개, 2위: 2개, 3위: 1개

### 6.5 collection_album_milestone 이상값

- key=110016 (req_point=1250): `booster_extra_deck × 5000`
- 같은 아이템의 다른 슬롯은 ×1 (req=380), ×2 (req=1450)
- 5000은 오기 또는 다른 단위(예: '50개'를 '5000'으로 잘못 입력) 가능성 있음 → **PM 확인 필요**

### 6.6 무료 채널 완전 부재 아이템 (6종)

| 아이템 | 이유 |
|---|---|
| `currency_hammer` | 인게임 소비재, 별도 보상 없이 인게임 직접 사용 |
| `currency_puzzle_piece` | 카드 플레이 시 자동 획득 추정 (보상 채널 외 획득) |
| `currency_streak_star` | streak_reward에서 `reward_star_amount` 필드로 지급 (별도 컬럼, 아이템 key 아님) |
| `infinite_fireworks_5m` | 등록 없음 (5m는 스킵, 10m/15m만 실제 사용) |
| `infinite_gticket_5m` | 동상 |
| `infinite_gticket_15m` | 등록 없음 (15m는 IAP product에도 없음) |

### 6.7 currency_streak_star 특이 지급 방식

streak_reward 모든 9개 슬롯에서 `reward_star_amount=1`로 streak_star를 항상 1개씩 지급한다.
이는 `reward_item_key` 필드가 아닌 전용 컬럼으로 처리된다 → 실질적으로 모든 스트릭 보상에서 1 streak_star 보장.