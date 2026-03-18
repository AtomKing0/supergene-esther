# PST Product EV Analysis Report
**생성일**: 2026-03-13  
**데이터 소스**: Google Sheets (Spreadsheet ID: 1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk)  
**시트**: product, item_list, difficulty_tier, level_entry_tier, const  
**분석 기준 레벨**: Lv50-99 (entry_cost=2,000g, 핵심 플레이어 구간)

---

## Step 1: 데이터 수집 요약

| 시트 | 행 수 | 주요 내용 |
|---|---|---|
| product | 11 | 8개 in_use=TRUE, 3개 special offer (in_use=FALSE) |
| item_list | 20 | 5 currencies, 5 boosters, 9 infinite, 1 gimmick |
| difficulty_tier | 4 | Tutorial / Normal / Hard / Super Hard |
| level_entry_tier | 12 | 레벨별 입장료 및 booster ratio |
| const | 46 | 라이브 확정값 포함 |

---

## Step 2: 아이템 골드 가치 기준표

### 고정 가격 부스터 (interval_type=fixed, Lv50-99 기준)

| 아이템 | entry_cost_ratio | 골드 가치 (Lv50-99) | 계산식 |
|---|---|---|---|
| booster_fireworks (40010) | 6,000 (60%) | **1,200g** | 2,000 × 60% |
| booster_golden_ticket (40011) | 8,000 (80%) | **1,600g** | 2,000 × 80% |
| booster_wild_card (40013) | 5,000 (50%) | **1,000g** | 2,000 × 50% |

### 가변 가격 부스터 (level_entry_tier 기반)

| 아이템 | interval_type | 최솟값 | 평균값 | 최댓값 |
|---|---|---|---|---|
| booster_undo (40012) | tier_undo | 100g (Lv3-9) | **1,617g** | 3,250g (Lv1450+) |
| booster_extra_deck (40014) | tier_extra_deck | 300g (Lv3-9) | **2,230g** | 4,500g (Lv1450+) |

> undo_ratio 범위: 1,000~6,500 / extra_deck_ratio 범위: 3,000~9,000 (level_entry_tier 기준)

### 기타 아이템

| 아이템 | 골드 가치 | 근거 |
|---|---|---|
| currency_ticket | **2,000g** | Lv50-99 entry_cost와 동일 (1장 = 1회 무료 입장) |
| infinite_fireworks_10m (40021) | **3,960g** (가설) | 3분/판 기준 3.3판 × fireworks 1,200g |
| infinite_gticket_10m (40024) | **5,280g** (가설) | 3분/판 기준 3.3판 × golden_ticket 1,600g |

---

## Step 3: 상품별 EV 분석 테이블

> 가변 부스터는 평균값 사용. (infinite 아이템 포함 상품은 "가설" 명시)

| key_number | product_id | pay($) | gold_amount | boosters | gold_per_$ | total_ev_gold | ev_per_$ | bonus_ratio% | label | in_use |
|---|---|---|---|---|---|---|---|---|---|---|
| 190001 | gold_ad_1 | AD | 1,000 | — | — | 1,000 | — | 0.0% | none | TRUE |
| 190002 | gold_iap_1 | $1.99 | 10,000 | — | 5,025 | 10,000 | **5,025** | 0.0% | none | TRUE |
| 190003 | gold_iap_2 | $5.99 | 32,000 | — | 5,342 | 32,000 | 5,342 | 0.0% | none | **FALSE** |
| 190004 | bundle_iap_1 | $4.99 | 27,000 | undo×1, ticket×1 | 5,411 | 30,617 | **6,136** | 11.8% | none | TRUE |
| 190005 | bundle_iap_2 | $8.99 | 50,000 | wild×1, extra×1, undo×1, ticket×1 | 5,562 | 56,847 | **6,323** | 12.0% | most_popular | TRUE |
| 190006 | bundle_iap_3 | $14.99 | 85,000 | wild×2, extra×2, undo×2, ticket×2 | 5,671 | 98,694 | **6,584** | 13.9% | none | TRUE |
| 190007 | bundle_iap_4 | $26.99 | 170,000 | wild×4, extra×4, undo×4, ticket×4 | 6,298 | 197,388 | **7,313** | 13.9% | none | TRUE |
| 190008 | bundle_iap_5 | $49.99 | 370,000 | wild×8, extra×8, undo×8, ticket×8 | 7,401 | 424,776 | **8,497** | 12.9% | best_value | TRUE |
| 190101 | special_offer_1 | $1.99 | 25,000 | extra×2, ticket×2, undo×2, wild×2 | 12,563 | 38,694 | **19,444** | 35.4% | none | FALSE |
| 190102 | special_offer_2 | $9.99 | 70,000 | wild×2, extra×2, undo×1, fireworks×1 | 7,007 | 79,277 | **7,936** | 11.7% | none | FALSE |
| 190103 | special_offer_3 | $14.99 | 100,000 | inf_fw×1(가설), inf_gt×1(가설), undo×2, wild×2 | 6,671 | 114,474 | **7,637** | 12.6% (가설) | none | FALSE |

---

## Step 4: 가격 티어 일관성 분석

### 기준선 설정
- **기준**: 190002 gold_iap_1 ($1.99, pure gold) = **5,025 g/$**

### In-Use IAP 단조성 검증

| product_id | pay($) | ev/$ (mean) | vs 기준선 | 단조성 |
|---|---|---|---|---|
| gold_iap_1 | $1.99 | 5,025 | +0.0% (기준) | ✅ 기준 |
| bundle_iap_1 | $4.99 | 6,136 | +22.1% | ✅ OK |
| bundle_iap_2 | $8.99 | 6,323 | +25.8% | ✅ OK |
| bundle_iap_3 | $14.99 | 6,584 | +31.0% | ✅ OK |
| bundle_iap_4 | $26.99 | 7,313 | +45.5% | ✅ OK |
| bundle_iap_5 | $49.99 | 8,497 | +69.1% | ✅ OK |

**단조성 결과: PASS** — 가격이 높을수록 ev/$ 단조 증가. 구조적으로 올바름.

### most_popular ($8.99) 라벨 검증

| 비교 대상 | ev/$ | 차이 |
|---|---|---|
| bundle_iap_1 ($4.99, 하위) | 6,136 | — |
| **bundle_iap_2 ($8.99, most_popular)** | 6,323 | +3.0% vs $4.99 |
| bundle_iap_3 ($14.99, 상위) | 6,584 | -4.0% vs $14.99 |

→ EV 차이는 +3.0%로 미미하지만, 구성 다양성(4종 부스터) 측면에서 심리적 가치가 높음. 라벨 자체는 plausible.

### best_value ($49.99) 라벨 검증

| 상품 | ev/$ |
|---|---|
| bundle_iap_5 ($49.99, best_value) | **8,497** (전체 최고) |
| bundle_iap_4 ($26.99) | 7,313 |

→ **JUSTIFIED** — 전체 in-use IAP 중 최고 ev/$.

---

## Step 5: Special Offer 비교 (in_use=FALSE)

| 비교 | Regular ev/$ | Special Offer ev/$ | SO 프리미엄 | 비고 |
|---|---|---|---|---|
| SO1($1.99) vs gold_iap_1($1.99) | 5,025 | **19,444** | **+286.9%** | SO1 압도적 우위 |
| SO2($9.99) vs bundle_iap_2($8.99) | 6,323 | **7,936** | +25.5% (g/$ 직접 비교) | SO2 우위 |
| SO3($14.99) vs bundle_iap_3($14.99) | 6,584 | **7,637** | +16.0% (가설) | SO3 우위 (가설 의존) |

→ 모든 special offer는 동일 가격대 정규 상품보다 EV 우위. 설계 의도(한정 특가) 부합.

---

## Step 6: 문제점 목록

### [P1] Special Offer 간 단조성 위반 (SO2→SO3)
- SO2 ($9.99): ev/$=7,936
- SO3 ($14.99): ev/$=7,637 (가설)
- **SO3가 SO2보다 ev/$ 낮음** → 비싼 special offer가 더 저렴한 대비 단가 열위
- 단, SO3 값에는 infinite 아이템 가설이 포함됨. infinite 실제 가치가 더 높으면 해소 가능.
- **권고**: infinite_fireworks_10m / infinite_gticket_10m의 실제 게임 내 활용도 기반 가치 재산출 필요.

### [P2] special_offer_1 ($1.99) 과도한 EV (+287% 프리미엄)
- total_ev = 38,694g vs 정규 gold_iap_1 = 10,000g (동일 $1.99)
- 활성화 시 $4.99 bundle_iap_1(ev=30,617g)보다 훨씬 저렴하게 유사 부스터 구성 제공
- **위험**: 정규 $4.99 상품의 구매 동기를 잠식할 수 있음
- **권고**: special_offer_1은 NRU/초반 온보딩 전용으로 엄격히 제한 운용 권장.

### [P3] bundle_iap_1 ($4.99) 부스터 구성 편협
- 4종 부스터 중 undo+ticket만 포함. fireworks, golden_ticket, wild_card, extra_deck 부재.
- bundle_iap_2 ($8.99)부터 4종 full 구성 시작.
- **ev/$ 격차**: $4.99 → $8.99: +3.0%만 차이. 구성 다양성은 크게 다름.
- **권고**: $4.99 번들에 wild_card 또는 extra_deck 1개 추가 검토 (ev/$ 큰 변동 없음).

### [정상 항목]
- gold_iap_2 ($5.99, in_use=FALSE): 올바르게 비활성화. bundle_iap_1 ($4.99)이 더 우수.
- best_value 라벨 ($49.99): 정당함 (전체 최고 ev/$).
- 전체 in-use IAP 단조성: 완전 통과.

---

## 전체 요약

1. **정규 상품(in_use=TRUE) 구조는 건전함**: 가격 상승에 따라 ev/$가 단조 증가(5,025→8,497 g/$)하며, best_value 라벨도 수치로 정당화된다.
2. **주의 필요 항목 2가지**: (a) special_offer_1이 활성화 시 정규 $4.99 상품을 잠식할 수준의 EV 과잉(+287%)이며, (b) SO2→SO3 간 단조성 위반이 있으나 infinite 아이템 실제 가치 재산출로 해소 가능성 있음.
3. **infinite 아이템 가치는 가설**: SO3 분석은 "판당 3분" 가정에 의존하므로, 실제 세션 데이터로 infinite 활용 횟수를 측정한 후 수치 확정 필요.

---

---

## PM 판정 (2026-03-13)

| 항목 | 판정 | 근거 |
|---|---|---|
| P1: special_offer_1 EV 과잉 | **유지** | 계정당 1회 전용 첫 구매 게이트웨이 상품 (`limit_type=global, pay_limit=1`). 정규 상품 잠식 위험 없음. |
| P2: SO2→SO3 단조성 위반 | **모니터링** | infinite 아이템이 레퍼런스 게임 기준 밸런스로 설계됨. 이상 없을 것으로 예상. 실제 세션 데이터 확보 후 재산출. |
| P3: bundle_iap_1 구성 보완 | **보류** | 현 단계에서 진행하지 않음. |

**최종 판정: Go** — 현재 in-use 상품 구조 그대로 서비스 운영 가능. special offer 3종은 in_use=FALSE 유지하며 활성화 시점에 개별 판단.

*Figure: `.omc/scientist/figures/product_ev_analysis.png`*
*분석 기준: 라이브 Google Sheets 데이터, 2026-03-13*
