# PST 보상 채널 분포 분석 보고서

**작성일:** 2026-03-12  
**분석 대상:** PST Google Sheet (ID: `1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk`)  
**분석 채널:** daily_wheel, daily_gift, streak_reward, event_milestone, product(IAP/AD)

---

## 분석 목적 (OBJECTIVE)

PST 게임의 모든 보상 채널에 걸쳐 보상 종류(아이템 유형)와 수량 분포를 정량화하고, 채널별 특성 및 전체 통합 통계를 산출한다.

---

## 데이터 개요 (DATA)

| 시트 | 유효 행 수 | 비고 |
|---|---|---|
| item_list | 20 | 아이템 정의 (40001~40029) |
| daily_wheel | 8 | 가챠 풀, 총 gacha_rate = 10,000 |
| daily_gift | 7 | 7일 출석 보상 (day 0~6) |
| streak_reward | 9 | req_length 4/5/6 별 3개 풀 |
| event_milestone | 24 | event_id 160001(15단계), 160002(9단계) |
| product | 11 (active: 7) | IAP 6종 + AD 1종 활성 |

**전체 보상 슬롯 합계:** 75개 (product_IAP 24, event_milestone 24, daily_gift 9, daily_wheel 8, streak_reward 9, product_AD 1)

---

## 채널별 분석

### CH1. daily_wheel (데일리 휠 가챠)

gacha_rate 합계 = 10,000 (1% = 100)

| item_key | 유형 | 수량 | 확률 | E[gold]/draw |
|---|---|---|---|---|
| currency_gold | gold | 800 | 30.0% | 240g |
| booster_undo | booster | 1 | 25.0% | - |
| currency_gold | gold | 2,000 | 15.0% | 300g |
| booster_fireworks | booster | 1 | 12.0% | - |
| booster_wild_card | booster | 1 | 8.0% | - |
| currency_ticket | ticket | 1 | 6.0% | - |
| currency_gold | gold | 6,000 | 3.0% | 180g |
| currency_ticket | ticket | 3 | 1.0% | - |
| **합계** | | | | **720g** |

**유형별 확률:**
- gold: 48.0% 확률, E[gold]/draw = **720g**
- booster: 45.0% (undo 25%, fireworks 12%, wild_card 8%)
- ticket: 7.0%

[STAT:n] n=8 가챠 슬롯

---

### CH2. daily_gift (7일 출석 보상)

| Day | 보상 1 | 수량 | 보상 2 | 수량 | 보상 3 | 수량 |
|---|---|---|---|---|---|---|
| 0 | currency_gold | 1,000 | - | - | - | - |
| 1 | currency_ticket | 1 | - | - | - | - |
| 2 | currency_gold | 2,000 | - | - | - | - |
| 3 | booster_undo | 2 | - | - | - | - |
| 4 | currency_gold | 3,000 | - | - | - | - |
| 5 | booster_wild_card | 1 | - | - | - | - |
| 6 | currency_ticket | 2 | booster_fireworks | 1 | currency_gold | 5,000 |

**7일 사이클 합계:**
- gold: 4 슬롯, **총 11,000g** (평균 2,750g/슬롯)
- booster: 3 슬롯 (undo×2, wild_card×1, fireworks×1)
- ticket: 2 슬롯 (총 3매)

**슬롯 비율:** gold 44.4% / booster 33.3% / ticket 22.2%

[STAT:n] n=9 보상 슬롯 (7일 9개 — Day6에 3개)

---

### CH3. streak_reward (스트릭 콤보 보상)

req_length별 3개 풀 (각 3엔트리, 균등 33.3% 확률):

| req_length | 아이템 | 확률 | 수량 | 비고 |
|---|---|---|---|---|
| 4 (combo≥4) | currency_gold | 33.3% | tier_table | tier_combo_reward |
| 4 | currency_gold | 33.3% | 1 | fixed |
| 4 | reward_plus_card_1 | 33.3% | 1 | fixed |
| 5 (combo≥5) | booster_wild_card | 33.3% | 1 | fixed |
| 5 | booster_fireworks | 33.3% | 1 | fixed |
| 5 | currency_gold | 33.3% | tier_table | tier_combo_reward |
| 6 (combo≥6) | reward_plus_card_1 | 33.3% | 2 | fixed |
| 6 | reward_plus_card_1 | 33.3% | tier_table | tier_combo_reward |
| 6 | booster_wild_card | 33.3% | 2 | fixed |

**특징:** req_length가 높을수록 booster/gimmick 비중 증가, gold 비중 감소 (combo 4: gold 66.7% → combo 6: gold 0%)

[STAT:n] n=9 풀 엔트리 (3 풀 × 3 엔트리)

---

### CH4. event_milestone (이벤트 마일스톤)

#### event_id=160001 (Midnight, 15단계)

| 유형 | 슬롯 수 | gold 합계 | 평균 gold/슬롯 | gold 범위 |
|---|---|---|---|---|
| gold | 9 | 7,133g | 792.6g | 133 ~ 2,000 |
| booster | 4 | 11개 (undo 누적) | 2.75/슬롯 | - |
| ticket | 2 | 3매 | 1.5/슬롯 | - |

#### event_id=160002 (9단계)

| 유형 | 슬롯 수 | gold 합계 | 평균 gold/슬롯 | gold 범위 |
|---|---|---|---|---|
| gold | 6 | 2,800g | 466.7g | 133 ~ 800 |
| booster | 3 | 3개 | 1.0/슬롯 | - |

**이벤트 전체 통합:**
- gold: 15슬롯 (62.5%), 총 9,933g, 평균 662g/슬롯
- booster: 7슬롯 (29.2%), 총 14개
- ticket: 2슬롯 (8.3%), 총 3매

[STAT:n] n=24 마일스톤 단계

---

### CH5. product (IAP / AD 상품)

#### 활성 상품 목록 (in_use=True)

| key | pay_type | 가격(USD) | product_id | 보상 요약 |
|---|---|---|---|---|
| 190001 | AD | $0 | gold_ad_1 | gold×1,000 (1회/일) |
| 190002 | IAP | $1.99 | gold_iap_1 | gold×10,000 |
| 190004 | IAP | $4.99 | bundle_iap_1 | gold×27,000 + undo×1 + ticket×1 |
| 190005 | IAP | $8.99 | bundle_iap_2 | gold×50,000 + wild_card×1 + extra_deck×1 + undo×1 + ticket×1 |
| 190006 | IAP | $14.99 | bundle_iap_3 | gold×85,000 + wild_card×2 + extra_deck×2 + undo×2 + ticket×2 |
| 190007 | IAP | $26.99 | bundle_iap_4 | gold×170,000 + wild_card×4 + extra_deck×4 + undo×4 + ticket×4 |
| 190008 | IAP | $49.99 | bundle_iap_5 | gold×370,000 + wild_card×8 + extra_deck×8 + undo×8 + ticket×8 |

**IAP 보상 슬롯 비율 (in_use 기준):**
- booster: 54.2% (13슬롯), 총 46개 (undo, wild_card, extra_deck, fireworks)
- gold: 25.0% (6슬롯), 총 712,000g
- ticket: 20.8% (5슬롯), 총 16매

**비활성 특가 상품 (in_use=False):** special_offer_1/2/3 ($1.99~$14.99, limit_type=global/event/city)

[STAT:n] n=7 활성 상품, n=11 전체 상품

---

## 전체 통합 통계

### 보상 유형별 슬롯 분포 (전 채널)

| 유형 | 슬롯 수 | 슬롯 비율 | 평균 수량 | 중앙값 | 최소 | 최대 | 합계 | 등장 채널 수 |
|---|---|---|---|---|---|---|---|---|
| gold | 32 | 42.7% | 24,757.8 | 1,000 | 1 | 370,000 | 742,734g | 6 |
| booster | 29 | 38.7% | 2.4 | 1 | 1 | 8 | 71개 | 5 |
| ticket | 11 | 14.7% | 2.4 | 2 | 1 | 8 | 26매 | 4 |
| gimmick/plus_card | 3 | 4.0% | 1.5 | 2 | 1 | 2 | 3개 | 1 (streak_reward) |

[STAT:n] n=75 전체 보상 슬롯

### 무료 채널 Gold 지급량 비교 (IAP 제외)

| 채널 | gold 슬롯 | 총 gold | 평균 gold/슬롯 | 최소 | 최대 |
|---|---|---|---|---|---|
| daily_gift | 4 | 11,000g | 2,750g | 1,000 | 5,000 |
| daily_wheel | 3 | 8,800g | 2,933g | 800 | 6,000 |
| event_milestone | 15 | 9,933g | 662g | 133 | 2,000 |
| product_AD | 1 | 1,000g | 1,000g | 1,000 | 1,000 |
| streak_reward | 3 | ~1g | ~0g (tier_table) | 0 | 1 |

**무료 채널 gold 합계 (고정 수치 기준):** 30,734g (streak tier_table 제외)

### 부스터 유형별 분포

| 부스터 | 슬롯 수 | 총 지급량 |
|---|---|---|
| booster_undo | 11 | 30개 |
| booster_wild_card | 9 | 21개 |
| booster_fireworks | 5 | 5개 |
| booster_extra_deck | 4 | 15개 |

---

## 주요 발견 사항 (FINDINGS)

[FINDING] **Gold가 슬롯 기준 최다 보상 유형이지만 채널 간 수량 격차가 극단적**
- 전체 슬롯의 42.7%(32/75슬롯)가 gold이며 6개 채널 전체에 분포
- 그러나 IAP 포함 시 gold 합계 742,734g 중 IAP가 712,000g(95.8%)을 차지
- 무료 채널 gold 합계는 30,734g으로 IAP 대비 23배 차이

[STAT:n] n=32 gold 슬롯
[STAT:effect_size] IAP/무료 gold 비율 = 23.2:1

[FINDING] **daily_wheel은 기대값 기준 gold 채널이지만 booster 출현 확률이 더 높음**
- gold 확률 합계 48.0%, E[gold]/draw = 720g
- booster 확률 합계 45.0% (undo 25% 단일 최고)
- gold 48% vs booster 45%로 거의 동등한 빈도이나, gold는 확률 가중 기대값 720g이 핵심

[STAT:n] n=8 가챠 슬롯, gacha_rate 합계=10,000
[STAT:effect_size] E[gold]/draw = 720g (daily_gift 1일 평균 1,571g 대비 46%)

[FINDING] **streak_reward는 combo 길이에 따라 보상 유형이 체계적으로 변화**
- req_length=4: gold 66.7%, gimmick 33.3% — 진입장벽 낮고 gold 중심
- req_length=5: booster 66.7%, gold 33.3%(tier_table) — 중간 단계
- req_length=6: booster+gimmick 100%, gold 0% — 최고 단계에서 gold 완전 배제
- gold는 req_length=4,5에서만 등장하며, 6에서는 plus_card와 wild_card로 대체

[STAT:n] n=9 풀 엔트리 (3풀×3엔트리)

[FINDING] **event_milestone의 gold 보상은 단계가 높을수록 증가하는 선형 패턴**
- event 160001(15단계): gold 792.6g/슬롯 평균, 초기 133g → 최대 2,000g
- event 160002(9단계): gold 466.7g/슬롯 평균, 초기 133g → 최대 800g
- 이벤트 간 골드 규모 차이 약 1.7x (7,133g vs 2,800g), 난이도/기간 차이를 반영

[STAT:n] n=24 마일스톤 단계 (160001: 15단계, 160002: 9단계)
[STAT:effect_size] 이벤트 간 gold 총량 비율 = 2.55:1 (7,133g / 2,800g)

[FINDING] **booster_undo가 전 채널에서 가장 광범위하게 배포되는 부스터**
- 11 슬롯(전체 booster 슬롯 29개의 37.9%)을 차지하며 총 30개 지급
- daily_wheel, daily_gift, streak_reward, event_milestone, product_IAP 5개 채널 모두에 등장
- booster_extra_deck은 product_IAP 전용 (4슬롯, 15개) — IAP 비구매자는 획득 불가

[STAT:n] n=29 booster 슬롯
[STAT:effect_size] undo 점유율 37.9%, extra_deck IAP 전용 비율 100%

---

## 제한 사항 (LIMITATIONS)

[LIMITATION] **streak_reward의 gold 수량은 tier_combo_reward(tier_table 참조)로 실제 값 미확정** — req_length=4,5의 일부 gold 슬롯은 `level_entry_tier` 시트 참조값이므로 실제 지급량 별도 확인 필요.

[LIMITATION] **event_milestone은 2개 이벤트(160001, 160002) 기준** — 추후 추가 이벤트가 등록될 경우 분포 변동 가능.

[LIMITATION] **product 분석은 in_use=True 기준** — 비활성 special_offer(190101~190103) 3종 제외. 활성화 시 IAP gold 총량 크게 증가 예상.

[LIMITATION] **daily_wheel은 1회 추첨 기준 분석** — 실제 플레이어 누적 수령량은 일별 시행 횟수에 따라 달라짐. 획득 빈도 데이터 없음.

[LIMITATION] **수량 분포 통계는 슬롯 단위** — 확률 가중 평균(E[amount])은 daily_wheel에만 적용. 나머지 채널은 미가중 단순 평균.

---

## 시각화 파일

| 파일 | 내용 |
|---|---|
| `.omc/scientist/figures/fig1_reward_type_distribution.png` | 채널별 보상 유형 분포 (누적 막대 + 파이차트) |
| `.omc/scientist/figures/fig2_gold_analysis.png` | 무료 채널 gold 총량 + daily_wheel 기대값 분석 |
| `.omc/scientist/figures/fig3_booster_event.png` | 부스터 유형별 슬롯/수량 + 이벤트 마일스톤 gold 진행 |

---

*분석 기준일: 2026-03-12 | 데이터 소스: PST Google Sheet (라이브)*
