# PST 아웃게임 보상 채널 검수 보고서

**생성일:** 2026-03-12  
**대상 시트:** daily_wheel, daily_gift, streak_reward, event_milestone, collection_album_milestone, daily_task_milestone, daily_task, meta_city_list, collection_album_puzzle_list, event_ranking  
**작업:** 읽기 및 분석만 수행 (시트 수정 없음)

---

## 1. 검수 결과 종합 (gold/non-gold/infinite 비율)

| 시트 | 전체슬롯 | gold(%) | non-gold(%) | infinite(%) | 판정 |
|---|---|---|---|---|---|
| daily_wheel | 8 | 25.0% (슬롯기준) / 45.0% (확률기준) | 75.0% / 55.0% | 0.0% | FAIL (슬롯기준) / 주의 (확률기준) |
| daily_gift | 9 | 44.4% | 55.6% | 0.0% | FAIL |
| streak_reward | 9 | 33.3% | 66.7% | 0.0% | N/A (인게임, 비율규칙 제외) |
| event_milestone | 45 | 53.3% | 46.7% | 0.0% | FAIL |
| collection_album_milestone | 20 | 30.0% | 45.0% | 25.0% | FAIL ⚠️ (infinite 심각) |
| daily_task_milestone | 3 | 33.3% | 66.7% | 0.0% | FAIL |
| daily_task | 48 | 60.4% | 39.6% | 0.0% | PASS |
| meta_city_list | 60 | 60.0% | 35.0% | 5.0% | PASS |
| collection_album_puzzle_list | 25 | 60.0% | 36.0% | 4.0% | PASS |
| event_ranking | 12 | 41.7% | 50.0% | 8.3% | FAIL (infinite 초과) |

**gold 비율 목표: 60% ±5% (55~65%), infinite 최대 5%**

### daily_wheel 특이사항
daily_wheel은 가챠 풀로 확률(probability) 기반으로 평가가 필요하다.
- **슬롯 수 기준**: gold 2/8 = 25% → FAIL
- **확률 가중 기준**: gold 4,500/10,000 = 45.0% → 미달 (목표 60%)
- 두 기준 모두 gold 비율 부족. 슬롯 수 추가 또는 확률 재분배 필요.

---

## 2. Non-gold 아이템 가치 분포

### daily_wheel
| 아이템 | 횟수 | 확률 | Tier |
|---|---|---|---|
| booster_undo | 1 | 2,000 | mid |
| booster_fireworks | 1 | 1,200 | mid |
| booster_wild_card | 1 | 800 | low |
| currency_ticket | 1 | 600 | low |
| booster_extra_deck | 1 | 600 | high |
| booster_golden_ticket | 1 | 300 | high |

**낮은(low) 2개 vs 높은(high) 2개**: 균형 양호. 단, 전체 구성에서 non-gold 비율 자체가 과다.

### daily_gift
| 아이템 | 횟수 | Tier |
|---|---|---|
| currency_ticket | 2 | low |
| booster_undo | 1 | mid |
| booster_extra_deck | 1 | high |
| booster_golden_ticket | 1 | high |

**낮은(low) 2개 < 높은(high) 2개**: 고가치 비율이 높음. 일차5(150006)에 booster_extra_deck[high] 배치는 다소 이름.

### event_milestone (3개 이벤트 합산)
| 아이템 | 횟수 | Tier |
|---|---|---|
| booster_fireworks | 4 | mid |
| booster_wild_card | 4 | low |
| currency_ticket | 4 | low |
| booster_undo | 3 | mid |
| booster_extra_deck | 3 | high |
| booster_golden_ticket | 3 | high |

**낮은(low) 8개 vs 높은(high) 6개**: 낮은 비율 >= 높은 비율. 분포 규칙 준수.  
단, 고가치 아이템(booster_extra_deck, booster_golden_ticket)은 이벤트별 step 11~13(73~87% 구간)에 배치 → 후반 집중으로 적절.

### collection_album_milestone
| 아이템 | 횟수 | Tier |
|---|---|---|
| booster_extra_deck | 3 | high |
| booster_wild_card | 2 | low |
| booster_undo | 1 | mid |
| booster_fireworks | 1 | mid |
| currency_ticket | 1 | low |
| infinite_ticket_5m | 1 | mid |
| booster_golden_ticket | 1 | high |
| infinite_fireworks_5m | 1 | mid |
| infinite_gticket_5m | 1 | mid |
| infinite_fireworks_15m | 1 | top |
| infinite_ticket_15m | 1 | top |

**⚠️ 고가치 (high+top) 6개 > 낮은 (low) 3개**: 규칙 위반. infinite top 2개가 전체 과부하 주범.

### daily_task_milestone
| 아이템 | 횟수 | Tier |
|---|---|---|
| booster_fireworks | 1 | mid |
| currency_ticket | 1 | low |

낮은(low) 1개 vs 높은(high) 0개: 분포 양호. 비율만 수정 필요.

### daily_task
| 아이템 | 횟수 | Tier |
|---|---|---|
| booster_fireworks | 4 | mid |
| booster_undo | 4 | mid |
| booster_wild_card | 4 | low |
| currency_ticket | 3 | low |
| booster_golden_ticket | 2 | high |
| booster_extra_deck | 2 | high |

**낮은(low) 7개 vs 높은(high) 4개**: 양호. 비율도 PASS.

### meta_city_list
| 아이템 | 횟수 | Tier |
|---|---|---|
| booster_golden_ticket | 4 | high |
| booster_undo | 4 | mid |
| currency_ticket | 4 | low |
| booster_fireworks | 3 | mid |
| booster_wild_card | 3 | low |
| booster_extra_deck | 3 | high |
| infinite_fireworks_15m | 1 | top |
| infinite_gticket_15m | 1 | top |
| infinite_ticket_15m | 1 | top |

**낮은(low) 7개 vs 높은(high+top) 10개**: 고가치 > 낮은 가치 → 주의.  
단, top 3개(infinite_*_15m)는 최후반 도시(60018~60020)에만 배치되어 진행 구조상 적절.

### collection_album_puzzle_list
| 아이템 | 횟수 | Tier |
|---|---|---|
| booster_fireworks | 2 | mid |
| booster_wild_card | 2 | low |
| booster_golden_ticket | 2 | high |
| booster_undo | 2 | mid |
| currency_ticket | 1 | low |
| infinite_ticket_5m | 1 | mid |

**낮은(low) 3개 vs 높은(high) 2개**: 균형 양호.

### event_ranking
| 아이템 | 횟수 | Tier |
|---|---|---|
| booster_golden_ticket | 2 | high |
| currency_ticket | 2 | low |
| infinite_gticket_10m | 1 | high |
| booster_fireworks | 1 | mid |
| booster_extra_deck | 1 | high |

**낮은(low) 2개 vs 높은(high+infinite) 4개**: 고가치 > 낮은 가치 → 주의.  
단, event_ranking의 상위 순위 보상 특성상 고가치 집중은 의도된 설계.

---

## 3. 행 내 중복 아이템 키 검사

| 시트 | 행 key | 중복 아이템 | reward_N 위치들 |
|---|---|---|---|
| meta_city_list | 60001 (New York) | currency_gold | 보상1타입, 보상2타입 |
| meta_city_list | 60002 (Los Angeles) | currency_gold | 보상1타입, 보상2타입 |
| meta_city_list | 60003 (San Francisco) | currency_gold | 보상1타입, 보상2타입 |
| meta_city_list | 60004 (Las Vegas) | currency_gold | 보상1타입, 보상2타입 |
| meta_city_list | 60005 (Chicago) | currency_gold | 보상1타입, 보상2타입 |
| meta_city_list | 60006 (Miami) | currency_gold | 보상1타입, 보상2타입 |
| meta_city_list | 60007 (Paris) | currency_gold | 보상1타입, 보상2타입 |
| meta_city_list | 60008 (London) | currency_gold | 보상1타입, 보상2타입 |
| meta_city_list | 60009 (Rome) | currency_gold | 보상1타입, 보상2타입 |
| meta_city_list | 60010 (Venice) | currency_gold | 보상1타입, 보상2타입 |
| meta_city_list | 60011 (Tokyo) | currency_gold | 보상1타입, 보상2타입 |
| meta_city_list | 60012 (Bangkok) | currency_gold | 보상1타입, 보상2타입 |
| meta_city_list | 60013 (Cairo) | currency_gold | 보상1타입, 보상2타입 |
| meta_city_list | 60014 (Dubai) | currency_gold | 보상1타입, 보상2타입 |
| meta_city_list | 60015 (Sydney) | currency_gold | 보상1타입, 보상2타입 |
| meta_city_list | 60016 (Rio de Janeiro) | currency_gold | 보상1타입, 보상2타입 |
| collection_album_puzzle_list | 90001 (NY) | currency_gold | 보상1타입, 보상2타입 |
| collection_album_puzzle_list | 90002 (Paris) | currency_gold | 보상1타입×3 (보상1/2/3) |
| collection_album_puzzle_list | 90003 (London) | currency_gold | 보상1타입, 보상2타입 |
| collection_album_puzzle_list | 90004 (Venice) | currency_gold | 보상1타입, 보상2타입 |
| collection_album_puzzle_list | 90005 (Cairo) | currency_gold | 보상1타입, 보상2타입 |
| collection_album_puzzle_list | 90006 (Tokyo) | currency_gold | 보상1타입, 보상2타입 |
| collection_album_puzzle_list | 90007 (Sydney) | currency_gold | 보상1타입, 보상2타입 |

**중복 건수 요약**: meta_city_list 16행, collection_album_puzzle_list 7행 (90002는 3중 중복)

**설계 의도 추정**: 두 시트 모두 "메인 골드 + 보조 골드 + 아이템" 구조로 의도한 것으로 보임. 그러나 spec 기준 동일 item_key 반복은 오류. 엔진이 두 슬롯을 개별 보상으로 처리하는지, 합산하는지 명확히 해야 함.

---

## 4. 수정 필요 항목 전체 목록

| # | 시트 | 행 key | 문제유형 | 현재값 | 수정방향 |
|---|---|---|---|---|---|
| 1 | daily_wheel | PST_daily_wheel 전체 | 비율 (gold 부족) | gold=25%(슬롯) / 45%(확률), 목표 60% | 확률 기준: 800g prob 3000→4000, 2000g prob 1500→2500. non-gold 슬롯 1~2개 줄이고 gold 슬롯 추가 권장 |
| 2 | daily_gift | 150001~150007 | 비율 (gold 부족) | gold=44.4%(4/9) | 일차1(150002) currency_ticket→currency_gold, 일차3(150004) booster_undo→currency_gold 변경 → gold 6/9=66.7% |
| 3 | event_milestone | 180001~180045 | 비율 (gold 부족) | gold=53.3%(24/45) | 이벤트별 non-gold 1슬롯씩 gold로 전환. 예: 이벤트 160001 step15(currency_ticket×2)→gold, 160002 step15(golden_ticket)→gold+1슬롯 추가 |
| 4 | collection_album_milestone | 전체 20단계 | 비율 + infinite 초과 (심각) | gold=30%, infinite=25%(5/20). 목표 infinite≤5%(1개 이하) | infinite 5개 → 1개로 감소: 13단계 infinite_fireworks_5m→booster_wild_card, 15단계 infinite_gticket_5m→currency_ticket, 16단계 booster_extra_deck×3→currency_gold, 18단계 infinite_fireworks_15m→booster_extra_deck. 20단계 infinite_ticket_15m 유지 |
| 5 | daily_task_milestone | 130001~130003 | 비율 (gold 부족) | gold=33.3%(1/3) | 단계2(130002) booster_fireworks→currency_gold로 변경 → gold=66.7% |
| 6 | event_ranking | 전체 | 비율 + infinite 초과 | gold=41.7%(5/12), infinite=8.3%(1/12) | none 슬롯을 gold로 채워 gold 비율 상승. rank 7~10에 보상2=currency_gold 추가. infinite_gticket_10m은 1위 보상으로 유지하되 비율 조정 후 허용 범위 내 유지 여부 재확인 |
| 7 | collection_album_milestone | 단계9(pts=380), 단계10(pts=470) | 분포 (고가치 초반 배치) | step9: booster_extra_deck[high] (전체 19%), step10: booster_golden_ticket[high] (23%) | booster_extra_deck → step 14~15로 이동, booster_golden_ticket → step 13으로 이동. 해당 위치에 booster_wild_card 또는 currency_ticket 배치 |
| 8 | meta_city_list | 60001~60016 (16개 도시) | 중복 (currency_gold 행 내 2회) | 보상1=currency_gold, 보상2=currency_gold 동일 키 반복 | [설계 의도 확인 필요] 엔진이 다중 슬롯 gold를 합산 처리하면 단일 슬롯으로 병합(보상1에 합산 금액 기입, 보상2 슬롯 제거). 별도 처리면 현행 유지 허용 여부 기획 확정 필요 |
| 9 | collection_album_puzzle_list | 90001~90007 (7개 앨범) | 중복 (currency_gold 행 내 2~3회) | 90002: gold×3(21,000g), 나머지: gold×2 | [설계 의도 확인 필요] 90002: 7,000+7,000+7,000=21,000g → currency_gold 21,000 단일 슬롯 병합 권장. 나머지 행도 두 슬롯 합산 후 단일 currency_gold로 정리 |

---

## 5. 요약 및 우선순위

### 긴급 수정 (CRITICAL)
- **collection_album_milestone**: infinite 25% — 목표 대비 5배 초과. 5개 infinite 중 4개 즉시 비-infinite 아이템으로 교체.

### 필수 수정 (HIGH)
- **daily_gift**: gold 44.4% → 최소 2개 슬롯 전환 필요.
- **daily_task_milestone**: gold 33.3%, 단순 1개 슬롯 전환으로 해결 가능.
- **event_milestone**: gold 53.3% — 이벤트 3개 × 1슬롯씩 gold 전환.

### 설계 확인 필요 (DESIGN REVIEW)
- **meta_city_list**: currency_gold 이중 보상 설계 의도 확인. 엔진 처리 방식에 따라 수정 여부 결정.
- **collection_album_puzzle_list**: 동일 금액 currency_gold 중복 슬롯 의도 확인.

### 낮음 (LOW)
- **daily_wheel**: 확률 가중치 조정으로 해결 가능.
- **event_ranking**: none 슬롯 처리 방식에 따라 판정 변경될 수 있음. 설계 확인 필요.
- **collection_album_milestone** 고가치 초반 배치: 기능 이슈는 아니지만 보상 체감 최적화 관점에서 조정 권장.

---

*보고서 생성: Scientist Agent (claude-sonnet-4-6)*
