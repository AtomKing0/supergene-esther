---
agent: 02 경제 밸런스
mode: ECONOMIC-BALANCE — G8 신규 메타 도시 설계
executed: 2026-03-11
status: COMPLETE
cities_designed: [city_name_athens (60019), city_name_prague (60020)]
total_hammer_added: 268
sink_extension: 17.52일
---

# G8 신규 메타 도시 설계 — Athens & Prague

## 1. 데이터 소스 확인

- **meta_city_list** (gid=701245569): 총 18개 도시 (60001~60018), 마지막 key=60018 (city_name_istanbul)
- **meta_decoration_list** (gid=680706612): 총 90개 행 (70001~70090), G7 Plan B 마지막 key=70090 (istanbul_bosphorus_bridge)
- G7 Plan B (Barcelona/Istanbul) 적용 확인: 해머 [4,6,10,15,20], 골드 [3000,4800,7200,10800,15000]

---

## 2. G8 해머 패턴 산출

### 그룹별 도시 해머 총합 (도시당, max=2 업그레이드 적용)

| 그룹 | 대표 도시 | 업그레이드1 패턴 | 도시 해머 합계 | 직전 그룹 대비 |
|------|-----------|-----------------|--------------|--------------|
| G1 | New York / LA | [1,2,3,5,7] | 36 | — |
| G3 | Paris / London | [1,2,4,7,10] | 48 | ×1.333 |
| G4 | Rome / Venice | [2,3,5,8,12] | 60 | ×1.250 |
| G5 | Tokyo / Bangkok | [2,4,6,10,14] | 72 | ×1.200 |
| G6 | Cairo / Dubai | [2,4,7,11,16] | 80 | ×1.111 |
| G7 (old) | Sydney / Rio | [3,5,8,13,18] | 94 | ×1.175 |
| G7 Plan B | Barcelona / Istanbul | [4,6,10,15,20] | 110 | ×1.170 |
| **G8** | **Athens / Prague** | **[5,7,12,18,25]** | **134** | **×1.218** |

### G8 해머 패턴 결정 근거

- G7 Plan B → G8 비율: **×1.2~1.25** (G4~G7 평균 증가율 범위 내)
- 5-슬롯 패턴 상승 배율 (G8/G7 슬롯별): [1.25, 1.17, 1.20, 1.20, 1.25] — 균등 분포
- 도시당 합계: 5+7+12+18+25=67 → ×2 업그레이드 = **134 해머/도시**
- Sink 충족: 134 × 2도시 = **268 해머 > 233 해머 (15.2일 목표치)**

---

## 3. G8 골드 패턴 산출

### g1 기준 골드 단계 비율 (기존 전 그룹 공통)

| 슬롯 | 비율 |
|------|------|
| 1 | 1.00 |
| 2 | 1.60 |
| 3 | 2.40 |
| 4 | 3.60 |
| 5 | 5.00 |

*(G7 Plan B [3000,4800,7200,10800,15000]: 1.0 : 1.60 : 2.40 : 3.60 : 5.00 — 완전 일치)*

### G8 g1 골드 결정

- G7 Plan B g1 = 3,000
- g1 진행 패턴의 G7→G8 적용 비율: **×1.20** (G7 Plan B 적용 시 사용한 증가율과 동일)
- G8 g1 = 3,000 × 1.20 = **3,600**

### G8 골드 단계 계산 (200 단위 반올림)

| 슬롯 | 계산값 | 최종값 |
|------|--------|--------|
| 1 | 3,600 | **3,600** |
| 2 | 3,600 × 1.60 = 5,760 | **5,800** |
| 3 | 3,600 × 2.40 = 8,640 | **8,600** |
| 4 | 3,600 × 3.60 = 12,960 | **13,000** |
| 5 | 3,600 × 5.00 = 18,000 | **18,000** |

> **가설**: 슬롯2~4는 200 단위 반올림으로 인해 정확한 배율에서 ±0.01 오차 발생. 기존 G7 데이터에서도 동일 방식 적용 확인됨.

---

## 4. meta_city_list 행 데이터

### 신규 행 (key 60019, 60020)

| key_number | city_id | prev_city_id | reward_1_type | reward_1_amount | reward_2_type | reward_2_amount | reward_3_type | reward_3_amount |
|-----------|---------|-------------|--------------|----------------|--------------|----------------|--------------|----------------|
| 60019 | city_name_athens | 60018 | currency_gold | 14000 | infinite_ticket_15m | 1 | booster_golden_ticket | 3 |
| 60020 | city_name_prague | 60019 | currency_gold | 14000 | infinite_ticket_15m | 1 | booster_golden_ticket | 3 |

> **비고**: 건설 완료 보상(reward_1_amount)은 G7과 동일한 14,000 gold 유지. G7 Plan B 도시들과 동일한 보상 구조 사용 (inf_ticket_15m × 1, golden_ticket × 3).

---

## 5. meta_decoration_list 행 데이터 (완성형 raw)

### Athens (city_name_athens) — key 70091~70095

| key_number | city_id | sort_order | name_key | cost_hammer1 | cost_hammer2 | cost_hammer3 | cost_hammer4 | cost_hammer5 | cost_gold_var1 | cost_gold_var2 | cost_gold_var3 | cost_gold_var4 | cost_gold_var5 | upgrade_max | is_ad_var |
|-----------|---------|-----------|---------|-------------|-------------|-------------|-------------|-------------|--------------|--------------|--------------|--------------|--------------|------------|----------|
| 70091 | city_name_athens | 1 | deco_athens_parthenon | 5 | 5 | 0 | 0 | 0 | 0 | 3600 | 0 | 0 | 0 | 2 | False |
| 70092 | city_name_athens | 2 | deco_athens_acropolis | 7 | 7 | 0 | 0 | 0 | 0 | 5800 | 0 | 0 | 0 | 2 | False |
| 70093 | city_name_athens | 3 | deco_athens_plaka_district | 12 | 12 | 0 | 0 | 0 | 0 | 8600 | 0 | 0 | 0 | 2 | False |
| 70094 | city_name_athens | 4 | deco_athens_panathenaic_stadium | 18 | 18 | 0 | 0 | 0 | 0 | 13000 | 0 | 0 | 0 | 2 | False |
| 70095 | city_name_athens | 5 | deco_athens_cape_sounion | 25 | 25 | 0 | 0 | 0 | 0 | 18000 | 0 | 0 | 0 | 2 | False |

### Prague (city_name_prague) — key 70096~70100

| key_number | city_id | sort_order | name_key | cost_hammer1 | cost_hammer2 | cost_hammer3 | cost_hammer4 | cost_hammer5 | cost_gold_var1 | cost_gold_var2 | cost_gold_var3 | cost_gold_var4 | cost_gold_var5 | upgrade_max | is_ad_var |
|-----------|---------|-----------|---------|-------------|-------------|-------------|-------------|-------------|--------------|--------------|--------------|--------------|--------------|------------|----------|
| 70096 | city_name_prague | 1 | deco_prague_charles_bridge | 5 | 5 | 0 | 0 | 0 | 0 | 3600 | 0 | 0 | 0 | 2 | False |
| 70097 | city_name_prague | 2 | deco_prague_old_town_square | 7 | 7 | 0 | 0 | 0 | 0 | 5800 | 0 | 0 | 0 | 2 | False |
| 70098 | city_name_prague | 3 | deco_prague_prague_castle | 12 | 12 | 0 | 0 | 0 | 0 | 8600 | 0 | 0 | 0 | 2 | False |
| 70099 | city_name_prague | 4 | deco_prague_astronomical_clock | 18 | 18 | 0 | 0 | 0 | 0 | 13000 | 0 | 0 | 0 | 2 | False |
| 70100 | city_name_prague | 5 | deco_prague_wenceslas_square | 25 | 25 | 0 | 0 | 0 | 0 | 18000 | 0 | 0 | 0 | 2 | False |

---

## 6. Sink 검증

### 해머 누적 집계

| 구간 | 도시 수 | 해머 합계 | 환산 일수 (÷15.3) |
|------|--------|---------|-----------------|
| G1~G6 (기존 16개) | 16 | 924 | 60.40일 |
| G7 Barcelona/Istanbul (Plan B) | 2 | 220 | 14.38일 |
| **G8 Athens/Prague (신규)** | **2** | **268** | **17.52일** |
| **합계** | **20** | **1,412** | **92.32일** |

### 판정

| 지표 | 값 | 판정 |
|------|-----|------|
| 현재 합계 (G8 반영 전) | 74.8일 | — |
| G8 추가분 | +17.52일 | — |
| **G8 반영 후 합계** | **92.32일** | **A등급 PASS (≥90일)** |
| A등급 초과 마진 | +2.32일 | 여유 있음 |

---

## 7. string_code 연결 필요 항목 (08 에이전트 인계)

다음 name_key들은 `string_code` 시트에 로컬라이징 텍스트 등록이 필요합니다.

### city_name 키

| name_key | 표시 이름 (제안) |
|---------|--------------|
| city_name_athens | Athens |
| city_name_prague | Prague |

### deco 오브젝트 명칭 키 (10개)

| name_key | 표시 이름 (제안) |
|---------|--------------|
| deco_athens_parthenon | Parthenon |
| deco_athens_acropolis | Acropolis |
| deco_athens_plaka_district | Plaka District |
| deco_athens_panathenaic_stadium | Panathenaic Stadium |
| deco_athens_cape_sounion | Cape Sounion |
| deco_prague_charles_bridge | Charles Bridge |
| deco_prague_old_town_square | Old Town Square |
| deco_prague_prague_castle | Prague Castle |
| deco_prague_astronomical_clock | Astronomical Clock |
| deco_prague_wenceslas_square | Wenceslas Square |

> **08 에이전트 인계 사항**: `string_code` 시트에 위 12개 키(도시명 2개 + 데코명 10개)를 각 언어별로 추가 필요. 기존 G7 Barcelona/Istanbul 등록 방식 동일하게 적용.

---

## 부록: 그룹별 패턴 비교표

| 그룹 | 해머 패턴 (up1 기준) | 도시당 합계 | g1 골드 | 골드 패턴 |
|------|-------------------|-----------|--------|---------|
| G1~G3 early | [1,2,3,5,7] | 36 | 500~1000 | [×1.0,×1.6,×2.4,×3.6,×5.0] |
| G3 late | [1,2,4,7,10] | 48 | 1100 | 동일 비율 |
| G4 | [2,3,5,8,12] | 60 | 1300 | 동일 비율 |
| G5 | [2,4,6,10,14] | 72 | 1500 | 동일 비율 |
| G6 | [2,4,7,11,16] | 80 | 1700~2000 | 동일 비율 |
| G7 (old) | [3,5,8,13,18] | 94 | 2300~2500 | 동일 비율 |
| G7 Plan B | [4,6,10,15,20] | 110 | 3000 | 동일 비율 |
| **G8** | **[5,7,12,18,25]** | **134** | **3600** | **동일 비율** |
