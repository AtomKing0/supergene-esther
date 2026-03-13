# PST 아웃게임 보상 채널 재배정 설계 (Plan)

> 생성일: 2026-03-12  
> 단계: 설계(plan)만 수행 — **시트 수정 미포함**

---

## 1. 아이템 가치 환산 표

> 기준: Lv50-99 (entry_cost=2000g, betting=1)  
> gold 1g = 1 단위. booster_fixed = entry_cost × entry_cost_ratio / 10000

| 아이템 | 카테고리 | gold 환산 가치 | 산정 근거 |
|---|---|---|---|
| currency_gold | currency | 1g/1g | 기준 단위 |
| currency_ticket | currency | 1,400g | daily_wheel EV = 1,388g (반올림 1,400) |
| booster_fireworks | booster_fixed | 1,200g | 2000 × 6000/10000 |
| booster_golden_ticket | booster_fixed | 1,600g | 2000 × 8000/10000 |
| booster_wild_card | booster_fixed | 1,000g | 2000 × 5000/10000 |
| booster_undo | booster_tier | 1,200g | 2000 × 6000/10000 (Lv50 undo_ratio) |
| booster_extra_deck | booster_tier | 1,600g | 2000 × 8000/10000 (Lv50 extra_deck_ratio) |
| infinite_ticket_5m | infinite | 2,100g | ticket(1,400) × 1.5게임 |
| infinite_ticket_10m | infinite | 4,200g | ticket(1,400) × 3게임 |
| infinite_ticket_15m | infinite | 7,000g | ticket(1,400) × 5게임 |
| infinite_fireworks_5m | infinite | 1,800g | fireworks(1,200) × 1.5게임 |
| infinite_fireworks_10m | infinite | 3,600g | fireworks(1,200) × 3게임 |
| infinite_fireworks_15m | infinite | 6,000g | fireworks(1,200) × 5게임 |
| infinite_gticket_5m | infinite | 2,400g | golden_ticket(1,600) × 1.5게임 |
| infinite_gticket_10m | infinite | 4,800g | golden_ticket(1,600) × 3게임 |
| infinite_gticket_15m | infinite | 8,000g | golden_ticket(1,600) × 5게임 |

> **인게임 전용 — 아웃게임 설계 제외**: plus_card, hammer, streak_star, puzzle_piece

---

## 2. 채널 성격 분류

| 채널 | 성격 | 가치 등급 | 비고 |
|---|---|---|---|
| daily_wheel | 일일 무료 가챠 | 낮음 | AD 5회 제한, gacha |
| daily_gift | 일일 출석 보상 | 낮음 | 7일 리텐션 사이클 |
| daily_task_milestone | 일일 미션 | 낮음 | 3단계 |
| event_milestone | 이벤트 콘텐츠 | 중간 | 15단계 × 3 이벤트 |
| collection_album_milestone | 콜렉션 콘텐츠 | 중간-높음 | 20단계, 장기 |
| event_ranking | 경쟁 (PVP) | 높음 | 상위 10위 |
| product | 유료/무료 IAP+AD | 최고 | 변경 없음 |

---

## 3. 채널별 현재 vs 신규 분배 비교

### 3-1. daily_wheel (8 슬롯, gacha sum=10000)

| key | 아이템 | 수량 | gacha_rate | 변경 |
|---|---|---|---|---|
| 140001 | currency_gold | 800 | 3000 | 유지 |
| 140002 | booster_undo | 1 | **2000** | rate 2500→2000 |
| 140003 | currency_gold | 2000 | 1500 | 유지 |
| 140004 | booster_fireworks | 1 | 1200 | 유지 |
| 140005 | booster_wild_card | 1 | 800 | 유지 |
| 140006 | currency_ticket | 1 | 600 | 유지 |
| **140007** | **booster_extra_deck** | **1** | **600** | currency_gold x6000 @300 → extra_deck x1 @600 |
| **140008** | **booster_golden_ticket** | **1** | **300** | currency_ticket x3 @100 → golden_ticket x1 @300 |

- rate 합계: 3000+2000+1500+1200+800+600+600+300 = **10,000** ✓
- 추가: booster_extra_deck, booster_golden_ticket (5종 모두 포함)
- 제거: gold 6,000 슬롯 (일일 무료치고 과다), ticket x3 슬롯
- gold는 140001/140003 2개 슬롯 유지 ✓

### 3-2. daily_gift (7일, 9 reward instances)

| key | 일차 | 보상 1 | 수량 | 보상 2 | 수량 | 보상 3 | 수량 | 변경 |
|---|---|---|---|---|---|---|---|---|
| 150001 | 1 | currency_gold | 1000 | - | - | - | - | 유지 |
| 150002 | 2 | currency_ticket | 1 | - | - | - | - | 유지 |
| 150003 | 3 | currency_gold | 2000 | - | - | - | - | 유지 |
| **150004** | **4** | **booster_undo** | **1** | - | - | - | - | 수량 2→1 |
| 150005 | 5 | currency_gold | 3000 | - | - | - | - | 유지 |
| **150006** | **6** | **booster_extra_deck** | **1** | - | - | - | - | wild_card→extra_deck |
| **150007** | **7** | currency_ticket | 2 | **booster_golden_ticket** | **1** | currency_gold | 5000 | booster_fireworks→golden_ticket |

- gold: 1,3,5,7일 포함 ✓
- 추가: booster_golden_ticket(day7), booster_extra_deck(day6)
- 제거: booster_fireworks(day7 → event_milestone로 커버), booster_wild_card(daily_wheel 커버)

### 3-3. event_milestone 160001 (15슬롯, collect_color 이벤트)

| key | 단계 | 아이템 | 수량 | 변경 |
|---|---|---|---|---|
| 180001 | 1 | currency_gold | 133 | 유지 |
| 180002 | 2 | currency_gold | 267 | 유지 |
| 180003 | 3 | booster_undo | 1 | 유지 |
| 180004 | 4 | currency_gold | 400 | 유지 |
| 180005 | 5 | currency_gold | 533 | 유지 |
| **180006** | **6** | **booster_fireworks** | **1** | booster_undo x2→fireworks x1 |
| 180007 | 7 | currency_gold | 667 | 유지 |
| 180008 | 8 | currency_gold | 800 | 유지 |
| **180009** | **9** | **booster_wild_card** | **1** | booster_undo x3→wild_card x1 |
| 180010 | 10 | currency_gold | 1000 | 유지 |
| **180011** | **11** | **booster_extra_deck** | **1** | currency_ticket x1→extra_deck x1 |
| 180012 | 12 | currency_gold | 1333 | 유지 |
| **180013** | **13** | **booster_golden_ticket** | **1** | booster_undo x5→golden_ticket x1 |
| 180014 | 14 | currency_gold | 2000 | 유지 |
| 180015 | 15 | currency_ticket | 2 | 유지 |

- 부스터 5종 완전 분산: undo(3), fireworks(6), wild_card(9), extra_deck(11), golden_ticket(13) ✓

### 3-4. event_milestone 160002 (15슬롯, collect_color 이벤트 B)

| key | 단계 | 아이템 | 수량 | 변경 |
|---|---|---|---|---|
| 180016~180020 | 1-5 | gold | 133~533 | 유지 |
| **180021** | **6** | **booster_undo** | **1** | booster_fireworks x1→undo x1 |
| 180022~180023 | 7-8 | gold | 667/800 | 유지 |
| 180024 | 9 | booster_wild_card | 1 | 유지 |
| 180025 | 10 | currency_gold | 1000 | 유지 |
| **180026** | **11** | **booster_extra_deck** | **1** | booster_fireworks x2→extra_deck x1 |
| 180027 | 12 | currency_gold | 1333 | 유지 |
| 180028 | 13 | booster_wild_card | 2 | 유지 |
| 180029 | 14 | currency_gold | 2000 | 유지 |
| 180030 | 15 | booster_golden_ticket | 1 | 유지 |

- 추가: booster_undo(6), booster_extra_deck(11)
- 제거: fireworks 중복 (6, 11단계)
- wild_card 2회(9,13) 유지 — 이 이벤트의 테마 아이템으로 허용

### 3-5. event_milestone 160003 (15슬롯, earn_point 이벤트)

| key | 단계 | 아이템 | 수량 | 변경 |
|---|---|---|---|---|
| 180031-180036 | 1-6 | gold/undo/gold/ticket/fireworks/gold | 유지 | |
| **180037** | **7** | **booster_extra_deck** | **1** | golden_ticket→extra_deck |
| 180038 | 8 | currency_ticket | 1 | 유지 |
| 180039 | 9 | currency_gold | 800 | 유지 |
| 180040 | 10 | booster_wild_card | 1 | 유지 |
| 180041 | 11 | booster_golden_ticket | 1 | 유지 |
| 180042 | 12 | currency_gold | 1200 | 유지 |
| **180043** | **13** | **booster_fireworks** | **2** | golden_ticket x1→fireworks x2 |
| 180044 | 14 | currency_gold | 2000 | 유지 |
| 180045 | 15 | currency_ticket | 3 | 유지 |

- golden_ticket 3회→1회 (11단계 유지)
- extra_deck 추가 (7단계)
- fireworks x2 추가 (13단계 — 높은 수량으로 가치 보상)

### 3-6. collection_album_milestone (20슬롯, 장기 콘텐츠)

| key | 누적포인트 | 아이템 | 수량 | 변경 |
|---|---|---|---|---|
| 110001 | 10 | currency_gold | 1000 | 유지 |
| 110002 | 30 | booster_undo | 2 | 유지 |
| **110003** | **50** | **currency_gold** | **2000** | 수량 1000→2000 (소액 보정) |
| 110004 | 80 | booster_fireworks | 1 | 유지 |
| 110005 | 120 | currency_ticket | 1 | 유지 |
| 110006 | 170 | booster_wild_card | 1 | 유지 |
| **110007** | **230** | **currency_gold** | **3000** | 수량 2000→3000 (진행감) |
| 110008 | 300 | infinite_ticket_5m | 1 | 유지 |
| 110009 | 380 | booster_extra_deck | 1 | 유지 |
| **110010** | **470** | **booster_golden_ticket** | **1** | infinite_ticket_5m→golden_ticket (중복 제거) |
| **110011** | **570** | **currency_gold** | **5000** | 수량 3000→5000 |
| **110012** | **680** | **currency_gold** | **2000** | **수량 2→2000 (오타 수정)** |
| **110013** | **800** | **infinite_fireworks_5m** | **1** | infinite_ticket_10m→fireworks (다양화) |
| 110014 | 930 | booster_wild_card | 2 | 유지 |
| **110015** | **1070** | **infinite_gticket_5m** | **1** | infinite_ticket_10m→gticket (다양화) |
| **110016** | **1250** | **booster_extra_deck** | **3** | **수량 5000→3 (오타 수정)** |
| 110017 | 1450 | booster_extra_deck | 2 | 유지 |
| 110018 | 1650 | infinite_fireworks_15m | 1 | 유지 |
| 110019 | 1850 | currency_gold | 10000 | 유지 |
| 110020 | 2000 | infinite_ticket_15m | 1 | 유지 |

- **오타 수정**: 110012 (2→2000), 110016 (5000→3) — 필수 수정 항목
- infinite 다양화: ticket 단독→fireworks/gticket/ticket 혼용
- golden_ticket booster 추가 (110010)

### 3-7. daily_task_milestone (3슬롯)

| key | 단계 | 포인트 | 아이템 | 수량 | 변경 |
|---|---|---|---|---|---|
| 130001 | 1 | 30 | currency_gold | 1000 | 유지 |
| **130002** | **2** | **50** | **booster_fireworks** | **1** | booster_undo→fireworks |
| 130003 | 3 | 100 | currency_ticket | 1 | 유지 |

### 3-8. event_ranking (5티어, 경쟁 채널)

| key | 순위 | 보상1 | 수량 | 보상2 | 수량 | 보상3 | 수량 | 변경 |
|---|---|---|---|---|---|---|---|---|
| **170001** | **1** | **infinite_gticket_10m** | **1** | currency_gold | **8000** | currency_ticket | 3 | golden_ticket x3→infinite x1, gold 5000→8000 |
| **170002** | **2** | booster_golden_ticket | 2 | currency_gold | **4000** | currency_ticket | 2 | gold 3000→4000 |
| **170003** | **3** | booster_golden_ticket | 1 | currency_gold | 2000 | **booster_extra_deck** | **1** | currency_ticket→extra_deck |
| **170004** | **4-6** | currency_gold | **1500** | **booster_fireworks** | **1** | - | - | gold 1000→1500, undo→fireworks |
| 170005 | 7-10 | currency_gold | 1000 | - | - | - | - | 유지 |

---

## 4. Infinite 비율 검증

| 채널 | 전체 슬롯 | infinite 슬롯 | 비율 |
|---|---|---|---|
| daily_wheel | 8 | 0 | 0.0% |
| daily_gift | 9 | 0 | 0.0% |
| event_milestone_160001 | 15 | 0 | 0.0% |
| event_milestone_160002 | 15 | 0 | 0.0% |
| event_milestone_160003 | 15 | 0 | 0.0% |
| collection_album_milestone | 20 | 5 | 25.0% |
| daily_task_milestone | 3 | 0 | 0.0% |
| event_ranking | 12 | 1 | 8.3% |
| **TOTAL** | **97** | **6** | **6.2%** |

**결론: 6.2% < 15% 제약 PASS ✓**

infinite 슬롯 상세:
- collection_album_milestone: 110008(infinite_ticket_5m), 110013(infinite_fireworks_5m), 110015(infinite_gticket_5m), 110018(infinite_fireworks_15m), 110020(infinite_ticket_15m)
- event_ranking: 170001 rank1(infinite_gticket_10m)

---

## 5. 수정 필요 항목 전체 목록 (39건)

### 오타 수정 (필수, 2건)

| 시트명 | 행 식별자 | 컬럼명 | 현재값 | 변경값 | 비고 |
|---|---|---|---|---|---|
| collection_album_milestone | 110012 (pts=680) | 보상 수량 | 2 | 2000 | 2g는 의미없는 값 — 2000g으로 수정 |
| collection_album_milestone | 110016 (pts=1250) | 보상 수량 | 5000 | 3 | extra_deck 5000개 오타 → 3개 |

### daily_wheel (6건)

| 시트명 | 행 식별자 | 컬럼명 | 현재값 | 변경값 |
|---|---|---|---|---|
| daily_wheel | 140002 | gacha_rate | 2500 | 2000 |
| daily_wheel | 140007 | reward_item_key | currency_gold | booster_extra_deck |
| daily_wheel | 140007 | reward_amount | 6000 | 1 |
| daily_wheel | 140007 | gacha_rate | 300 | 600 |
| daily_wheel | 140008 | reward_item_key | currency_ticket | booster_golden_ticket |
| daily_wheel | 140008 | reward_amount | 3 | 1 |
| daily_wheel | 140008 | gacha_rate | 100 | 300 |

(7행 — rate 합계 검증: 3000+2000+1500+1200+800+600+600+300=10,000 ✓)

### daily_gift (3건)

| 시트명 | 행 식별자 | 컬럼명 | 현재값 | 변경값 |
|---|---|---|---|---|
| daily_gift | 150004 (day4) | 보상 1 수량 | 2 | 1 |
| daily_gift | 150006 (day6) | 보상 1 키 | booster_wild_card | booster_extra_deck |
| daily_gift | 150007 (day7) | 보상 2 키 | booster_fireworks | booster_golden_ticket |

### event_milestone (13건)

| 시트명 | 행 식별자 | 컬럼명 | 현재값 | 변경값 |
|---|---|---|---|---|
| event_milestone | 180006 (160001 stage6) | 보상 키 | booster_undo | booster_fireworks |
| event_milestone | 180006 (160001 stage6) | 수량 | 2 | 1 |
| event_milestone | 180009 (160001 stage9) | 보상 키 | booster_undo | booster_wild_card |
| event_milestone | 180009 (160001 stage9) | 수량 | 3 | 1 |
| event_milestone | 180011 (160001 stage11) | 보상 키 | currency_ticket | booster_extra_deck |
| event_milestone | 180013 (160001 stage13) | 보상 키 | booster_undo | booster_golden_ticket |
| event_milestone | 180013 (160001 stage13) | 수량 | 5 | 1 |
| event_milestone | 180021 (160002 stage6) | 보상 키 | booster_fireworks | booster_undo |
| event_milestone | 180026 (160002 stage11) | 보상 키 | booster_fireworks | booster_extra_deck |
| event_milestone | 180026 (160002 stage11) | 수량 | 2 | 1 |
| event_milestone | 180037 (160003 stage7) | 보상 키 | booster_golden_ticket | booster_extra_deck |
| event_milestone | 180043 (160003 stage13) | 보상 키 | booster_golden_ticket | booster_fireworks |
| event_milestone | 180043 (160003 stage13) | 수량 | 1 | 2 |

### collection_album_milestone (8건, 2건 오타 포함)

| 시트명 | 행 식별자 | 컬럼명 | 현재값 | 변경값 |
|---|---|---|---|---|
| collection_album_milestone | 110003 (pts=50) | 보상 수량 | 1000 | 2000 |
| collection_album_milestone | 110007 (pts=230) | 보상 수량 | 2000 | 3000 |
| collection_album_milestone | 110010 (pts=470) | 보상 아이템 키 | infinite_ticket_5m | booster_golden_ticket |
| collection_album_milestone | 110011 (pts=570) | 보상 수량 | 3000 | 5000 |
| collection_album_milestone | 110012 (pts=680) | 보상 수량 | **2** | **2000** ← 오타 수정 |
| collection_album_milestone | 110013 (pts=800) | 보상 아이템 키 | infinite_ticket_10m | infinite_fireworks_5m |
| collection_album_milestone | 110015 (pts=1070) | 보상 아이템 키 | infinite_ticket_10m | infinite_gticket_5m |
| collection_album_milestone | 110016 (pts=1250) | 보상 수량 | **5000** | **3** ← 오타 수정 |

### daily_task_milestone (1건)

| 시트명 | 행 식별자 | 컬럼명 | 현재값 | 변경값 |
|---|---|---|---|---|
| daily_task_milestone | 130002 (stage2) | 보상 아이템 키 | booster_undo | booster_fireworks |

### event_ranking (8건)

| 시트명 | 행 식별자 | 컬럼명 | 현재값 | 변경값 |
|---|---|---|---|---|
| event_ranking | 170001 (rank1) | 보상 1 키 | booster_golden_ticket | infinite_gticket_10m |
| event_ranking | 170001 (rank1) | 보상 1 수량 | 3 | 1 |
| event_ranking | 170001 (rank1) | 보상 2 수량 (currency_gold) | 5000 | 8000 |
| event_ranking | 170002 (rank2) | 보상 2 수량 (currency_gold) | 3000 | 4000 |
| event_ranking | 170003 (rank3) | 보상 3 키 | currency_ticket | booster_extra_deck |
| event_ranking | 170003 (rank3) | 보상 3 수량 | 1 | 1 |
| event_ranking | 170004 (rank4-6) | 보상 1 수량 (currency_gold) | 1000 | 1500 |
| event_ranking | 170004 (rank4-6) | 보상 2 키 | booster_undo | booster_fireworks |

---

## 6. 부스터 분산 커버리지 매트릭스 (신규)

| 채널 | FIRE | GTIC | WILD | UNDO | EDCK |
|---|---|---|---|---|---|
| daily_wheel | Y | Y | Y | Y | Y |
| daily_gift | - | Y | - | Y | Y |
| event_160001 | Y | Y | Y | Y | Y |
| event_160002 | Y | Y | Y | Y | Y |
| event_160003 | Y | Y | Y | Y | Y |
| collection_album | Y | Y | Y | Y | Y |
| daily_task | Y | - | - | - | - |
| event_ranking | Y | Y | - | - | Y |

> FIRE=fireworks, GTIC=golden_ticket, WILD=wild_card, UNDO=undo, EDCK=extra_deck

---

## 7. 제약 조건 준수 확인

| 조건 | 결과 |
|---|---|
| gold 모든 아웃게임 채널 포함 | PASS ✓ (전 채널 gold 슬롯 존재) |
| 인게임 전용 아이템 미수정 | PASS ✓ (plus_card/hammer/streak_star/puzzle_piece 미변경) |
| infinite < 15% | PASS ✓ (6.2% = 6/97 슬롯) |
| 슬롯 수 동일 유지 | PASS ✓ (각 채널 슬롯 수 변경 없음) |
| gacha rate 합계 = 10,000 | PASS ✓ (daily_wheel: 10,000) |
| 오타 수정 포함 | PASS ✓ (110012: 2→2000, 110016: 5000→3) |

---

## 8. 미수정 채널

- **streak_reward**: 인게임 채널 — 설계 제외 (변경 없음)
- **product**: 유료 상품 구조 변경은 별도 수익화 설계 검토 필요 — 이번 설계 범위 외
  - 현황 파악: BUNDLE 계열에 fireworks/golden_ticket 누락, 상위 번들에 infinite 미포함
  - 추후 검토 권고

---

*설계 완료. 시트 수정은 별도 실행 단계에서 수행.*
