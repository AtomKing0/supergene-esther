---
agent: 02_economic_balance
mode: phase-a
scope: PST 재화 시스템
executed: 2026-02-20T18:10:00+09:00
status: partial
note: WebSearch 권한 거부로 CCS 외부 조사 미수행. PST/PBM 내부 데이터 추출은 complete.
---

# 02 경제 밸런스 에이전트 — Phase-A 시장조사 결과

---

## 1. PST/PBM 재화 구조 요약

### 1-1. 통화 종류

| 게임 | 통화 코드 | 분류 | 설명 |
|---|---|---|---|
| PST | `currency_gold` | 소프트 통화 | 주요 게임 내 교환 매체 (입장비, 보상) |
| PST | `currency_ticket` | 준하드 통화 | 아이템·이벤트 관련 티켓 |
| PBM | `gold` | 소프트 통화 | 주요 게임 내 교환 매체 |
| PBM | `ad_skip_ticket` | 광고 스킵 티켓 | 광고 시청 대체 소비재 |

- PST는 `booster_*` 계열 (undo, wild_card, extra_deck, fireworks 등) 아이템을 별도 인벤토리로 운영
- PBM은 `undo`, `redeal`, `bomb` 3종 인게임 아이템을 별도 관리

---

### 1-2. PST 주요 Source (재화 획득 경로)

출처: `PST_const.json`, `PST_daily_gift.json`, `PST_event_milestone.json`, `PST_product.json`

| Source 유형 | 항목 | 수량/주기 | 근거 필드 |
|---|---|---|---|
| 초기 지급 | NRU 시작 골드 | 1,000 gold | `nru_start_gold: 1000` |
| 자연 회복 | 유휴 골드 충전 | 3,000 gold / 14,400초(4시간) 마다 | `idle_gold_charge_time: 14400`, `idle_gold_charge_amount: 3000` |
| 자연 회복 | 유휴 골드 인터벌 | 20초마다 일부 증가 (단계별 +1,200) | `idle_gold_interval: 20`, `idle_gold_amount_increase: 1200` |
| 자연 회복 | 유휴 골드 최대 캡 | 8,000 gold | `idle_gold_max_cap: 8000` |
| 데일리 출석 | Day 0 | 500 gold | `PST_daily_gift.json` day:0 |
| 데일리 출석 | Day 2 | 1,000 gold | `PST_daily_gift.json` day:2 |
| 데일리 출석 | Day 4 | 2,000 gold | `PST_daily_gift.json` day:4 |
| 데일리 출석 | Day 6 | 3,000 gold + 티켓 2 + fireworks 1 | `PST_daily_gift.json` day:6 |
| 인게임 | 콤보 보상 (기본) | 2 gold/콤보 (레벨에 따라 증가, 최대 50) | `ingame_combo_reward_base: 2`, `max_cap: 50` |
| 인게임 | 남은 덱 보상 | 15 gold 기본 (레벨에 따라 증가, 최대 5,000) | `remaining_deck_reward_base: 15`, `max_cap: 5000` |
| 인게임 | 카드 매칭 골드 | 2 gold/10매칭 기본 (최대 100) | `card_maching_gold_amount: 2`, `max_cap: 100` |
| 무료 샵 | 광고 시청 골드 | 2,000 gold / 1일 1회 | `shop_free_gold_amount: 2000`, `shop_free_gold_limit: 5` (일 최대 5회 표시) |
| 무료 받은편지함 | 광고 시청 골드 | 2,000 gold / 1일 최대 5회 | `inbox_free_gold_amount: 2000`, `inbox_free_gold_limit: 5` |
| 무료 팝업 | 광고 시청 골드 | 2,000 gold / 1일 최대 10회 | `popup_free_gold_amount: 2000`, `popup_free_gold_limit: 10` |
| 이벤트 마일스톤 | step 1~14 골드 보상 합계(event_id 160001 기준) | 200+400+600+800+1,000+1,200+1,500+2,000+3,000 = 10,700 gold | `PST_event_milestone.json` |
| 이벤트 마일스톤 | step 1~14 골드 보상 합계(event_id 160003 기준) | 300+500+800+1,200+1,800+3,000 = 7,600 gold | `PST_event_milestone.json` |
| 친구 초대 | 초대 보상 | 1,000 gold | `friend_invite_reward: 1000` |
| 친구 | 친구 전송 보상 | 1 (단위 미상) | `friend_send_reward: 1` |
| 데일리 휠 | 광고 시청 | 일 최대 5회 | `daily_wheel_ad_limit: 5` |
| 골드 최대 캡 | - | 10,000 gold | `gold_max_limit: 10000` |

---

### 1-3. PST 주요 Sink (재화 소비 경로)

출처: `PST_const.json`

| Sink 유형 | 항목 | 비용 | 근거 필드 |
|---|---|---|---|
| 레벨 입장 | 기본 입장비 | 1,000 gold (기본) | `entry_cost_base: 1000` |
| 레벨 입장 | 무료 입장 횟수 | 2회/일 | `entry_cost_free_limit: 2` |
| 레벨 입장 | 입장비 증가 구간 | 10레벨마다 +100 | `entry_cost_interval: 10`, `entry_cost_increase: 100` |
| 레벨 입장 | 입장비 최대 캡 | 5,000 gold | `entry_cost_max_cap: 5000` |
| 보상 마진 | 레벨 승리 시 지급 마진 범위 | 500~2,000 gold | `reward_margin_min: 500`, `reward_margin_max: 2000` |
| IAP 아이템 구매 | 부스터(undo, wild_card 등) 골드 소비 | 데이터 없음 (product에 IAP만 존재) | - |

---

### 1-4. PST IAP 패키지 구조

출처: `PST_product.json` (in_use: true 항목만 기재)

| product_id | 가격(USD) | 골드 | 부가 보상 | 라벨 | 비고 |
|---|---|---|---|---|---|
| gold_ad_1 | 0 (광고) | 1,000 gold | 없음 | - | 일 1회 한정 |
| gold_iap_1 | $1.99 | 10,000 gold | 없음 | - | in_use: true |
| bundle_iap_1 | $4.99 | 27,000 gold | undo×1, ticket×1 | - | in_use: true |
| bundle_iap_2 | $8.99 | 45,000 gold | wild_card×1, extra_deck×1, undo×1, ticket×1 | most_popular | in_use: true |
| bundle_iap_3 | $14.99 | 85,000 gold | wild_card×2, extra_deck×2, undo×2, ticket×2 | - | in_use: true |
| bundle_iap_4 | $26.99 | 170,000 gold | wild_card×4, extra_deck×4, undo×4, ticket×4 | - | in_use: true |
| bundle_iap_5 | $49.99 | 370,000 gold | wild_card×8, extra_deck×8, undo×8, ticket×8 | best_value | in_use: true |

- 비활성(in_use: false) 항목: `gold_iap_2` ($5.99/32,000 gold), special_offer 3종 ($1.99/$9.99/$14.99)
- 최저가(IAP): $1.99 / 최고가: $49.99
- 골드 단가 효율: $1.99 → 5,025 gold/USD / $49.99 → 7,402 gold/USD (규모 할인 구조)

---

### 1-5. PST 데일리 출석 보상 전체 (7일 사이클)

출처: `PST_daily_gift.json`

| Day | 보상 1 | 수량 | 보상 2 | 수량 | 보상 3 | 수량 |
|---|---|---|---|---|---|---|
| 0 | currency_gold | 500 | - | - | - | - |
| 1 | currency_ticket | 1 | booster_undo | 1 | - | - |
| 2 | currency_gold | 1,000 | - | - | - | - |
| 3 | booster_fireworks | 1 | - | - | - | - |
| 4 | currency_gold | 2,000 | - | - | - | - |
| 5 | booster_wild_card | 1 | - | - | - | - |
| 6 | currency_ticket | 2 | booster_fireworks | 1 | currency_gold | 3,000 |

- 7일 사이클 기준 골드 총합: 500 + 1,000 + 2,000 + 3,000 = **6,500 gold**
- 비골드 보상: ticket 3개, undo 1개, wild_card 1개, fireworks 2개

---

### 1-6. PST 이벤트 마일스톤 보상 구조 요약

출처: `PST_event_milestone.json`

**event_id 160001 (색상 수집형 — black, 15스텝)**

| step | 목표 누적 | 보상 유형 | 보상 수량 |
|---|---|---|---|
| 1 | 30 | currency_gold | 200 |
| 2 | 70 | currency_gold | 400 |
| 3 | 120 | booster_undo | 1 |
| 4 | 180 | currency_gold | 600 |
| 5 | 250 | currency_gold | 800 |
| 6 | 330 | booster_undo | 2 |
| 7 | 420 | currency_gold | 1,000 |
| 8 | 520 | currency_gold | 1,200 |
| 9 | 630 | booster_undo | 3 |
| 10 | 750 | currency_gold | 1,500 |
| 11 | 900 | currency_ticket | 1 |
| 12 | 1,100 | currency_gold | 2,000 |
| 13 | 1,350 | booster_undo | 5 |
| 14 | 1,650 | currency_gold | 3,000 |
| 15 | 2,000 | currency_ticket | 2 |

- 골드 총합: 10,700 gold (15스텝 완주 기준)
- 비골드 보상: undo 11개, ticket 3개

**event_id 160002 (색상 수집형 — red, 15스텝)**

- 골드 총합: 10,700 gold (스텝 구조 동일)
- 비골드 보상: fireworks 4개, wild_card 3개, booster_golden_ticket 1개

**event_id 160003 (포인트 획득형, 15스텝)**

- 골드 총합: 7,600 gold (300+500+800+1,200+1,800+3,000)
- 비골드 보상: undo 1개, ticket 5개, fireworks 1개, wild_card 1개, booster_infinite_undo_15m×1, booster_infinite_undo_30m×1, booster_golden_ticket×1

---

### 1-7. PBM 주요 Source (재화 획득 경로)

출처: `PBM_const.json`, `PBM_daily_streak.json`, `PBM_lucky_chest.json`, `PBM_product.json`

| Source 유형 | 항목 | 수량/주기 | 근거 필드 |
|---|---|---|---|
| 초기 지급 | NRU 시작 코인 | 100 gold | `nru_start_money: 100` |
| 인게임 | 기본 블록 배치 점수 | 2점/블록 | `block_place_score_unit: 2` |
| 인게임 | 라인 클리어 보너스 (2줄) | 26,000점 | `line_bonus_2: 26000` |
| 인게임 | 라인 클리어 보너스 (6줄) | 130,000점 | `line_bonus_6: 130000` |
| 인게임 | 올클리어 보너스 | 300점 | `all_clear_bonus: 300` |
| 인게임 | 스타 수집 보상 | 50 gold/스타 | `star_reward_gold: 50` |
| 광고 | 일일 광고 보상 | 100 gold / 일 최대 5회 (총 500) | `daily_ad_reward_coin: 100`, `daily_ad_reward_limit: 5` |
| 광고 | 로비 광고 무료 골드 | 30 gold / 일 최대 3회 | `lobby_ad_free_gold: 30`, `lobby_ad_free_gold_limit: 3` |
| 광고 | 인박스 광고 무료 골드 | 30 gold / 일 1회 | `inbox_ad_free_gold: 30`, `inbox_ad_free_gold_limit: 1` |
| 럭키 체스트 | 골드 보상 (확률 30%) | 100~500 gold | `lucky_chest_prob_gold: 3000`, `PBM_lucky_chest.json` |
| 럭키 체스트 | 아이템 보상 (확률 70%) | undo/redeal/bomb | `lucky_chest_prob_item: 7000` |
| 럭키 체스트 | 쿨다운 | 14,400초(4시간) | `lucky_chest_cooldown_sec: 14400` |
| 럭키 체스트 | 일일 최대 획득 | 4회 | `lucky_chest_daily_claim_limit: 4` |
| 데일리 스트리크 | Day 1 | 150 gold | `PBM_daily_streak.json` day_info:1 |
| 데일리 스트리크 | Day 3 | 300 gold | `PBM_daily_streak.json` day_info:3 |
| 데일리 스트리크 | Day 5 | 500 gold | `PBM_daily_streak.json` day_info:5 |
| 데일리 스트리크 | Day 7 | 1,000 gold | `PBM_daily_streak.json` day_info:7 |
| 토너먼트 | 상대 추월 시 | 100 coin | `tournament_overtake_coin: 100` |
| 친구 초대 | 초대 보상 | 500 gold | `invited_friends_reward: 500` |
| 동적 목표 | 코인 범위 | 1,000 ~ 1,000,000 | `dynamic_goal_min_coin`, `dynamic_goal_max_coin` |

**럭키 체스트 보상 상세 (PBM_lucky_chest.json)**

| 보상 유형 | 아이템 | 수량 범위 | 가챠 확률 (분모 10000) |
|---|---|---|---|
| gold | gold | 100~500 | - (prob_gold: 3000 = 30%) |
| ingame_item | undo | 2~3 | 6000 (60%) |
| ingame_item | redeal | 1~2 | 3000 (30%) |
| ingame_item | bomb | 1 | 1000 (10%) |

- 아이템 보상 선택 시 내부 가챠 확률: undo 60%, redeal 30%, bomb 10% (합계 10000)

---

### 1-8. PBM 주요 Sink (재화 소비 경로)

출처: `PBM_const.json`

| Sink 유형 | 항목 | 비용/조건 | 근거 필드 |
|---|---|---|---|
| 부활 | revive 사용 | 3,500 타일 제거 | `revive_remove_tiles: 3500` |
| 부활 | 최대 부활 횟수 | 2회/게임 | `revive_limit: 2` |
| 부활 | 최소 점수 조건 | 300점 이상 | `revive_score_limit: 300` |
| undo | 사용 제한 | 5회/게임 | `undo_limit: 5` |
| redeal | 사용 제한 | 5회/게임 | `redeal_limit: 5` |
| 광고 스킵 티켓 | IAP 구매 | $0.99 ~ $19.99 | `PBM_product.json` |
| gold IAP | IAP 구매 | $0.99 ~ $19.99 | `PBM_product.json` |

---

### 1-9. PBM IAP 패키지 구조

출처: `PBM_product.json` (in_use: true 항목만 기재)

**광고 스킵 티켓 상품**

| product_id | 가격(USD) | ad_skip_ticket 수량 | 비고 |
|---|---|---|---|
| special_deal_1 | $1.99 | 30개 | 1회 한정 (pay_limit: 1) |
| ad_skip_ticket_5 | $0.99 | 5개 | - |
| ad_skip_ticket_15 | $2.99 | 15개 | - |
| ad_skip_ticket_40 | $6.99 | 40개 | - |
| ad_skip_ticket_85 | $13.99 | 85개 | - |
| ad_skip_ticket_125 | $19.99 | 125개 | - |

**골드 상품**

| product_id | 가격(USD) | gold 수량 | 부가 보상 | 비고 |
|---|---|---|---|---|
| gold_50 (AD) | 0 (광고) | 30 gold | - | 일 1회 한정 |
| special_deal_2 | $9.99 | 6,000 gold | undo×10, redeal×10, bomb×10 | in_use: true |
| gold_1000 | $0.99 | 1,000 gold | - | - |
| gold_5500 | $4.99 | 5,500 gold | - | - |
| gold_12000 | $9.99 | 12,000 gold | - | - |
| gold_26000 | $19.99 | 26,000 gold | - | - |

- PBM 최저가(IAP): $0.99 / 최고가: $19.99
- 골드 단가 효율: $0.99 → 1,010 gold/USD / $19.99 → 1,301 gold/USD

---

### 1-10. PBM 데일리 스트리크 보상 전체 (7일 사이클)

출처: `PBM_daily_streak.json`

| Day | 보상 유형 | 보상 아이템 1 | 수량 | 보상 아이템 2 | 수량 |
|---|---|---|---|---|---|
| 1 | gold | gold | 150 | - | - |
| 2 | ingame_item | ad_skip_ticket | 2 | - | - |
| 3 | gold | gold | 300 | - | - |
| 4 | ingame_item | redeal | 1 | - | - |
| 5 | gold | gold | 500 | - | - |
| 6 | ingame_item | bomb | 1 | - | - |
| 7 | ingame_item | ad_skip_ticket | 3 | gold | 1,000 |

- 7일 사이클 기준 골드 총합: 150 + 300 + 500 + 1,000 = **1,950 gold**
- 비골드 보상: ad_skip_ticket 5개, redeal 1개, bomb 1개

---

### 1-11. PST/PBM 재화 구조 비교 요약 표

| 게임 | 통화 종류 | 주요 Source | 주요 Sink | 패키지 최저가(USD) | 패키지 최고가(USD) |
|---|---|---|---|---|---|
| PST | gold (소프트), ticket (준하드), booster 아이템 | 유휴 충전(3,000/4h), 데일리 출석(최대 3,000/일), 광고(2,000×최대 20회), 이벤트 마일스톤(최대 10,700), 인게임 콤보/덱 보상 | 레벨 입장비(1,000~5,000 gold), IAP 아이템 구매 | $1.99 | $49.99 |
| PBM | gold (소프트), ad_skip_ticket (광고 스킵), undo/redeal/bomb (인게임 소모) | 럭키 체스트(100~500 gold/4h), 광고(100 gold×5회=500/일), 데일리 스트리크(최대 1,000/7일), 인게임 스타 보상(50/스타) | 부활(소비성), IAP 티켓/골드 구매 | $0.99 | $19.99 |

---

## 2. CCS 재화 구조 요약

WebSearch 권한이 실행 환경에서 거부되어 외부 조사를 수행하지 못했다.

| 항목 | CCS 정보 | 출처/신뢰도 | 비고 |
|---|---|---|---|
| 통화 종류 | 미확인 | WebSearch 미수행 | - |
| 주요 Source | 미확인 | WebSearch 미수행 | - |
| 주요 Sink | 미확인 | WebSearch 미수행 | - |
| IAP 패키지 가격대 | 미확인 | WebSearch 미수행 | - |
| 무료 재화 지급 빈도 | 미확인 | WebSearch 미수행 | - |
| 무료 재화 지급 규모 | 미확인 | WebSearch 미수행 | - |

**처리 방침:** CCS 관련 항목 전체를 "미확인"으로 처리. 후속 단계에서 WebSearch 권한 확보 후 재조사 필요.

---

## 3. 3사 구조 비교 요약

WebSearch 권한 미확보로 CCS 데이터를 수집하지 못했으므로, PST/PBM 간 비교만 기술하고 CCS는 미확인으로 표기한다.

### PST와 PBM의 공통점

- 소프트 통화(gold) 단일 주요 통화 구조: 두 게임 모두 `gold` 계열 소프트 통화를 중심으로 경제 운영
- 광고 기반 무료 재화 지급 채널 운영: 일일 횟수 제한을 두고 광고 시청 보상 제공
- IAP 구조: 최저 $0.99~$1.99의 소액 진입 상품부터 최고가 패키지까지 다단계 가격 구조
- 데일리 출석/스트리크 보상: 7일 사이클 기준 누적 보상 구조 운영
- 인게임 소모 아이템(booster/undo/redeal/bomb) 별도 관리: gold와 별개 인벤토리
- 럭키/무작위 보상 요소 존재: PST(데일리 휠), PBM(럭키 체스트)

### PST와 PBM의 차이점

- 최고가 패키지: PST는 $49.99, PBM은 $19.99로 PST의 하이스펜더 타겟이 더 높음
- 골드 스케일: PST는 진입 상수부터 10,000 단위, PBM은 100~1,000 단위로 통화 단위 레벨이 다름 (PST가 인플레이션 단위 더 큼)
- 유휴 충전 구조: PST는 4시간마다 3,000 gold 자동 충전이 존재하나, PBM_const에는 해당 자동 충전 필드 없음 (PBM은 럭키 체스트 4시간 주기로 대체)
- 광고 스킵 티켓: PBM만 존재 — 광고 의존도 완화를 위한 별도 통화 레이어 운영
- 입장비 구조: PST는 레벨 입장비(1,000~5,000 gold) 명시적 Sink 존재; PBM은 입장비 필드 없음 (점수 기반 진행)
- 부활 비용: PBM은 타일 제거(3,500) 기반 비용, PST는 별도 부활 비용 필드 미확인
- 이벤트 마일스톤: PST는 15스텝 구조에서 최대 10,700 gold 지급; PBM 이벤트 마일스톤 보상 구조는 이번 조사 범위 미포함

### CCS 비교

- CCS 데이터 미확인으로 3사 비교 불가
- 후속 단계에서 WebSearch 권한 확보 시 재수행 필요

---

## 4. 조사 한계 및 후속 과제

| 항목 | 상태 | 사유 |
|---|---|---|
| PST 내부 데이터 추출 | 완료 | reference JSON 직접 분석 |
| PBM 내부 데이터 추출 | 완료 | reference JSON 직접 분석 |
| CCS 외부 조사 | 미수행 | WebSearch 권한 실행 환경에서 거부됨 |
| PST booster 소비 gold 비용 | 데이터 없음 | product.json에 골드 직접 구매 비용만 존재, booster 개별 gold 소비 단가 없음 |
| PBM 이벤트 마일스톤 보상 규모 | 미포함 | 실행 범위가 PST 재화 시스템으로 한정되어 PBM 이벤트 상세 미분석 |
