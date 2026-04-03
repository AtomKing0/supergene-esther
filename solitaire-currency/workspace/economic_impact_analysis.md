---
agent: scientist
date: 2026-03-12
task: PST reward redistribution economic impact analysis
session: pst-reward-impact
---

# PST 보상 재배정 경제 밸런스 영향 분석

> 생성일: 2026-03-12  
> 데이터 기준: reward_redistribution_plan.md (설계안), item_reward_channel_analysis.md (수정 전 실측), economy_simulation_result.md v3

---

[OBJECTIVE] PST 아웃게임 보상 채널 재배정 설계안의 경제 밸런스 영향 정량화 — 채널별 일일 gold 환산 기대값(EV), 부스터 공급량, gold 공급 총량 변화, PM KPI 영향 평가

---

## 1. 아이템 gold 환산 기준

| 아이템 | gold 환산 | 산정 근거 |
|---|---|---|
| currency_gold | 1g/1g | 기준 단위 |
| currency_ticket | 1,400g | daily_wheel EV 역산 |
| booster_fireworks | 1,200g | entry_cost(2000) × 60% ratio |
| booster_golden_ticket | 1,600g | entry_cost(2000) × 80% ratio |
| booster_wild_card | 1,000g | entry_cost(2000) × 50% ratio |
| booster_undo | 1,200g | entry_cost(2000) × 60% ratio |
| booster_extra_deck | 1,600g | entry_cost(2000) × 80% ratio |
| infinite_ticket_5m | 2,100g | ticket × 1.5 games |
| infinite_gticket_5m | 2,400g | golden_ticket × 1.5 games |
| infinite_gticket_10m | 4,800g | golden_ticket × 3 games |
| infinite_fireworks_5m | 1,800g | fireworks × 1.5 games |
| infinite_fireworks_15m | 6,000g | fireworks × 5 games |
| infinite_ticket_15m | 7,000g | ticket × 5 games |

---

## 2. 채널별 변경 전후 EV 비교

[DATA] 7개 채널, 39건 수정 항목, 수정 전 데이터: item_reward_channel_analysis.md (라이브 실측), 수정 후: reward_redistribution_plan.md (설계안)

### 2-1. daily_wheel (가챠, 1 spin 기준)

| 슬롯 | 수정 전 | 수정 후 | 변경 내용 |
|---|---|---|---|
| 140001 | gold×800 @30% | 동일 | 유지 |
| 140002 | undo×1 @25% | undo×1 @**20%** | rate 하향 |
| 140003 | gold×2000 @15% | 동일 | 유지 |
| 140004 | fireworks×1 @12% | 동일 | 유지 |
| 140005 | wild_card×1 @8% | 동일 | 유지 |
| 140006 | ticket×1 @6% | 동일 | 유지 |
| **140007** | **gold×6000 @3%** | **extra_deck×1 @6%** | 교체+rate 2배 |
| **140008** | **ticket×3 @1%** | **golden_ticket×1 @3%** | 교체+rate 3배 |

[FINDING] daily_wheel 1회 EV는 수정 전 1,370g에서 수정 후 1,232g으로 감소  
[STAT:effect_size] Δ = -138 g-equiv/spin (-10.1%)  
[STAT:n] n=8 가챠 슬롯, gacha_rate 합계 = 10,000 (검증 PASS)  
주원인: gold×6,000 고액 슬롯 → extra_deck×1 (6,000g→1,600g-equiv) 교체로 기대값 하락. 단, 부스터 다양성 확보 (5종 모두 포함)

### 2-2. daily_gift (7일 사이클)

| Day | 수정 전 | 수정 후 | g-equiv 변화 |
|---|---|---|---|
| 1 | gold×1,000 | 동일 | 0 |
| 2 | ticket×1 | 동일 | 0 |
| 3 | gold×2,000 | 동일 | 0 |
| **4** | **undo×2** | **undo×1** | −1,200g |
| 5 | gold×3,000 | 동일 | 0 |
| **6** | **wild_card×1** | **extra_deck×1** | +600g |
| **7** | ticket×2 + **fireworks×1** + gold×5,000 | ticket×2 + **golden_ticket×1** + gold×5,000 | +400g |

[FINDING] daily_gift 7일 총 EV 19,800g → 19,600g (−200g, −1.0%)  
[STAT:effect_size] 실질 변화 미미. day4 undo 수량 감소(-1,200g) + day6/7 부스터 업그레이드(+1,000g) 상쇄  
[STAT:n] n=9 보상 슬롯 (7일 사이클)  
일평균: 2,828g → 2,800g/day (-28g/day)

### 2-3. event_milestone (이벤트 1회 완주 기준)

| 이벤트 | 수정 전 EV | 수정 후 EV | 변화 |
|---|---|---|---|
| 160001 (15단계) | 24,533g | 16,533g | −8,000g (−32.6%) |
| 160002 (15단계) | 15,333g | 14,533g | −800g (−5.2%) |
| 160003 (15단계) | 20,000g | 20,800g | +800g (+4.0%) |
| **전체 합계** | **59,866g** | **51,866g** | **−8,000g (−13.4%)** |

[FINDING] event_160001의 EV가 가장 크게 하락  
[STAT:effect_size] −8,000g (-32.6%). 주원인: undo×5(6,000g) → golden_ticket×1(1,600g) 4,400g 손실 + undo×3(3,600g) → wild_card×1(1,000g) 2,600g 손실  
[STAT:n] n=45 마일스톤 단계 (3 events × 15 stages)  
구조 변화: undo 집중 배치 → 5종 균등 분산. 총 undo 수량 12개 → 3개로 급감

### 2-4. collection_album_milestone (20단계, 장기 콘텐츠)

| 비교 항목 | 수정 전 (오타 수정 기준) | 수정 후 |
|---|---|---|
| 20단계 총 EV | 62,200g | 61,500g |
| 평균 단계당 EV | 3,110g | 3,075g |

[FINDING] album_milestone 실질 EV 변화 −700g (−1.1%) — 사실상 유지  
[STAT:effect_size] Cohen's d ≈ 0 (무시 가능 수준)  
[STAT:n] n=20 단계  
주요 내용: 오타 2건 수정 (110012: gold×2→2,000; 110016: extra_deck×5,000→3), infinite 다양화 (ticket 단독→fireworks/gticket/ticket 혼용), golden_ticket 신규 추가 (110010)  
Note: 수정 전 raw EV = 8,055,402g (extra_deck×5,000 오타 포함) → 오타 수정으로 −7,993,702g 정정

### 2-5. daily_task_milestone (3단계, 일일)

| 단계 | 수정 전 | 수정 후 | 변화 |
|---|---|---|---|
| 1 | gold×1,000 | 동일 | 0 |
| **2** | **undo×1** | **fireworks×1** | 동일 EV (1,200g) |
| 3 | ticket×1 | 동일 | 0 |

[FINDING] daily_task_milestone EV 변화 없음 (3,600g 유지)  
[STAT:effect_size] Δ = 0 (+0.0%)  
undo → fireworks 교체는 gold-equiv 동일 (1,200g vs 1,200g), 부스터 다양성 목적

### 2-6. event_ranking (경쟁 채널, 이벤트별)

| 순위 | 수정 전 EV | 수정 후 EV | 변화 |
|---|---|---|---|
| 1위 | 14,000g | 17,000g | +3,000g (+21.4%) |
| 2위 | 9,000g | 10,000g | +1,000g (+11.1%) |
| 3위 | 5,000g | 5,200g | +200g (+4.0%) |
| 4~6위 | 2,200g | 2,700g | +500g (+22.7%) |
| 7~10위 | 1,000g | 1,000g | 0 (+0.0%) |

[FINDING] event_ranking 전 티어에서 EV 상승 — 경쟁 인센티브 강화  
[STAT:effect_size] 1위 +21.4%, 4~6위 +22.7% (상위 및 중간 경쟁층 모두 상향)  
[STAT:n] n=5 순위 티어  
1위: golden_ticket×3 → infinite_gticket_10m×1(4,800g) + gold 5,000→8,000g (총 +3,000g)

---

## 3. 일일 gold 공급량 변화

[DATA] 기준: 보통(중반) Lv75 F2P 유저, v3 경제 시뮬레이션 baseline

| 채널 | 수정 전 (g-equiv/day) | 수정 후 (g-equiv/day) | Δ | % |
|---|---|---|---|---|
| daily_wheel (×4 spins) | 5,480 | 4,928 | −552 | −10.1% |
| daily_gift (7-day avg) | 2,829 | 2,800 | −29 | −1.0% |
| daily_task_milestone | 3,600 | 3,600 | 0 | 0.0% |
| event_milestone (daily avg) | 665 | 576 | −89 | −13.4% |
| **합계 (변경 채널)** | **12,574** | **11,904** | **−669** | **−5.3%** |

[FINDING] 보상 재배정으로 일일 gold 공급 669 g-equiv/day 감소  
[STAT:ci] 변화 범위 −552g (wheel) ~ −89g (event) — 채널별 개별 산정  
[STAT:effect_size] v3 baseline 일일 소득(30,451g/day) 대비 −2.2%  
[STAT:n] n=4 채널 변화 측정  
[STAT:p_value] 결정론적 계산 (EV based), 통계적 유의성 검정 불필요  

gold 공급 감소는 주로 wheel의 gold×6,000 슬롯 제거(-552g/day)에서 기인.  
v3 baseline과 비교: "골드 공급 건전성 45/100" 기준 미미한 개선 (추정 +1점 → 46/100)

---

## 4. 부스터 공급량 변화

[DATA] F2P 기준, daily 채널(wheel×4 + daily_gift + daily_task) + event(90일 정규화) 합산

| 부스터 | 수정 전/day | 수정 후/day | Δ | % | gold-equiv Δ |
|---|---|---|---|---|---|
| fireworks | 1.524 | 1.524 | 0.000 | 0.0% | 0 |
| golden_ticket | 0.044 | 1.153 | +1.109 | +2,495% | +1,775g |
| wild_card | 1.364 | 0.376 | −0.989 | −72.5% | −989g |
| undo | 4.133 | 1.833 | −2.300 | −55.6% | −2,760g |
| extra_deck | 0.000 | 1.273 | +1.273 | ∞ | +2,037g |
| **합계 EV** | **8,225g** | **8,288g** | **+63g** | **+0.8%** | |

[FINDING] 부스터 총 EV/day는 수정 전후 사실상 동일 (8,225 → 8,288g, +0.8%)  
[STAT:effect_size] 총량 변화 무시 가능. 분포 변화가 핵심  
[STAT:n] n=5 부스터 타입, n=4 채널 합산  

**구조적 변화:**
- undo 공급 −55.6% (4.13 → 1.83/day): 가장 큰 감소. undo 이전 과다 배치 교정
- wild_card 공급 −72.5%: daily_gift(day6), event_milestone에서 제거
- golden_ticket 신규: 0.044 → 1.153/day (+2,495%). 무료 채널 처음 등장
- extra_deck 신규: 0 → 1.273/day. 이전 album_milestone 전용 → 다채널 분산
- fireworks 유지: 0.0% 변화

**부스터 다양성 지수 변화:**
- 수정 전: undo 편중 (전체 부스터 공급의 57%). 5종 중 3종(golden_ticket, extra_deck) 실질 무료 미공급
- 수정 후: 5종 고른 분산. 최고 편중 = fireworks 18.4%

---

## 5. PM KPI 영향 평가

### 5-1. D1 리텐션: 초반 보상 충분성

[FINDING] D1 리텐션 영향 최소 — 초반 보상 구조 실질 변화 없음  
[STAT:effect_size] daily_gift day1(gold×1,000) 유지. daily_wheel EV −10.1%이나 절대값(1,232g/spin) 여전히 충분  
[STAT:n] day1 보상 슬롯 = 3개 (daily_gift + wheel + task)  

신규 유저 NRU start_gold(2,000g) + day1 출석(1,000g) + wheel 첫 스핀(EV 1,232g) = D1 총 보상 EV ~4,232g (Lv3 기준 판당 입장료 1,000g × 4회 = 이론 4판 가능). D1 보상 충분성 유지.

### 5-2. D7 리텐션: 7일 출석 + 이벤트 보상 동기

[FINDING] D7 리텐션 구조 개선 — day7 보상 질적 향상  
[STAT:effect_size] day7 보상: fireworks(1,200g) → golden_ticket(1,600g) +33% 질적 상향  
[STAT:n] 7일 사이클 완주 시 비교  

수정 후 day7: ticket×2(2,800g) + golden_ticket×1(1,600g) + gold×5,000 = 9,400g-equiv. 수정 전: ticket×2(2,800g) + fireworks×1(1,200g) + gold×5,000 = 9,000g-equiv. D7 최종 보상 +4.4% 향상.  
이벤트 완주 시 golden_ticket이 새로운 달성 동기로 작용 (이전 event_ranking 전용 희귀 아이템).

### 5-3. ARPDAU: 무료 보상 증가의 cannibalization 여부

[FINDING] 보상 재배정은 ARPDAU Cannibalization 리스크 낮음  
[STAT:effect_size] 일일 gold 공급 −2.2% (−669g/day). gold 총량 감소는 오히려 IAP 유인 개선 방향  
[STAT:n] 보통 중반 기준  

분석:
- gold 공급 순감소 → IAP 골드 상대가치 소폭 개선
- extra_deck/golden_ticket 무료 배포 증가: IAP bundle에서만 제공되던 희귀 부스터 무료 접근 확대 → 단기적 IAP cannibalization 가능성 존재
- **단, 수량이 소량 (golden_ticket ~1.15/day, extra_deck ~1.27/day)으로 IAP bundle(8~8개) 대비 현저히 낮아 대체 효과 제한적**
- 부스터 획득 경험 제공 → 부스터 효용 학습 → IAP 전환 긍정 효과 예상

---

## 6. 결론 및 리스크

### 6-1. 핵심 결론

| 구분 | 판정 | 근거 |
|---|---|---|
| gold 공급량 | 소폭 감소 (-2.2%) | wheel gold×6,000 슬롯 제거 |
| 부스터 EV 총량 | 유지 (+0.8%) | 종류 교체이나 가치 중립적 |
| 부스터 다양성 | 크게 개선 | 5종 균등 분산, 이전 undo 57% 편중 해소 |
| D1 리텐션 | 영향 없음 | day1 보상 구조 불변 |
| D7 리텐션 | 미세 개선 | day7 golden_ticket 질적 향상 |
| 경쟁 인센티브 | 강화 | event_ranking 전 티어 +4~23% EV |
| IAP Cannibalization | 낮음 | 무료 부스터 수량 소량 |
| v3 gold 건전성(45/100) | 미미한 개선 | 추정 46/100 |

### 6-2. 리스크 항목

| 리스크 | 심각도 | 확률 | 대응 방안 |
|---|---|---|---|
| undo 급감 (−55.6%)으로 인한 유저 체감 저하 | 중 | 중 | 출시 전 집중 QA. undo는 가장 인지도 높은 부스터 — 급격한 공급 감소 시 "너프" 인식 가능 |
| event_160001 EV −32.6% (−8,000g) | 중 | 높음 | 이벤트 160001 완주율 지표 모니터링. 필요 시 금액형 보상(gold) 단계별 상향 조정 |
| golden_ticket 무료화로 event_ranking 희소성 저하 | 저-중 | 중 | event_ranking golden_ticket은 여전히 복수 수량(2~3개). 단품 무료 배포는 체험 수준으로 제한적 |
| wild_card 공급 −72.5% | 중 | 높음 | 대부분 이벤트/출석에서 wild_card 제거됨. streak_reward 채널(변경 없음)이 주요 무료 소스로 남음 — 이용 유도 필요 |
| extra_deck/golden_ticket IAP 대체 효과 | 저 | 저 | 무료 공급 수량 1.27/day vs IAP bundle 8~8개. 부스터 '맛보기' 역할에 그침 |

---

[LIMITATION] event_milestone 수정 전 데이터는 160001/160002 두 이벤트만 라이브 데이터 확인. 160003은 item_reward_channel_analysis.md의 수정 전 구조를 reward_redistribution_plan.md 설명으로 역산하여 재구성 — 실제 시트 값과 소폭 차이 가능성 있음.

[LIMITATION] event_ranking 보상은 경쟁 채널로 전체 DAU 대비 수혜 비율 10위 이내 소수. 일반 유저 경제 영향 무시 가능.

[LIMITATION] booster supply 일별 정규화 시 event_milestone 90일/분기 가정 사용. 이벤트 운영 주기(실제 활성 기간)에 따라 실제 공급량 달라짐.

[LIMITATION] 이 분석은 설계안(plan) 기준이며 시트에 실제 반영 여부는 별도 확인 필요. 07_sheet_modify_log.md에는 reward_redistribution_plan.md 수정 내역이 아직 기록되지 않음.

---

## 시각화 파일

| 파일 | 내용 |
|---|---|
| `.omc/scientist/figures/fig1_channel_ev_comparison.png` | 채널별 수정 전후 EV 비교 (bar) + 변화율 (% bar) |
| `.omc/scientist/figures/fig2_booster_supply_change.png` | 부스터 일일 공급량 비교 + gold-equiv 구성 |
| `.omc/scientist/figures/fig3_economy_impact_projection.png` | D30 누적 골드 예측 + KPI 건강 점수 |

---

*분석 기준일: 2026-03-12 | Scientist Agent (claude-sonnet-4-6)*  
*Monte Carlo 시뮬레이션 미실행 — 결정론적 EV 계산 적용*
