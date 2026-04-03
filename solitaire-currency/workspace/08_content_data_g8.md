---
agent: 08_content_team
mode: content-team
scope: Athens + Prague G8 메타 도시 콘텐츠 기획
executed: 2026-03-11T06:46:00+00:00
status: complete
approved_by: pm
cities: [athens, prague]
string_keys_defined: 2
unlock_conditions_defined: 2
handoff_to: 07_sheet_modifier
---

# G8 콘텐츠 데이터 — Athens & Prague

## 1. 데이터 소스 확인 결과

### Google Sheet 현황 (라이브 기준)

| 시트 | 현재 마지막 항목 | 신규 추가 시작 |
|------|----------------|--------------|
| `meta_city_list` | key 60018 (city_name_istanbul) | 60019 (Athens) |
| `meta_decoration_list` | key 70090 (istanbul_bosphorus_bridge) | 70091 (Athens deco 1) |
| `string_code` | T_CITY_NAME_18 (이스탄불) | T_CITY_NAME_19 (Athens) |

### string_code 시트 구조 확인

- **컬럼 순서**: key | en | ar | es | pt | id | ru | fr | th | ko
- **T_CITY_NAME의 en 컬럼**: 영문 도시명이 아닌 **reward_1_amount(골드)** 값이 기입되는 패턴
  - T_CITY_NAME_17 (Barcelona): en=`14000`, G7 완성 보상 일치
  - T_CITY_NAME_18 (Istanbul): en=`14000`, G7 완성 보상 일치
  - → G8 Athens/Prague도 동일하게 en=`14000` 적용

### deco name_key 미등록 정책 확인

- G7 Barcelona 데코(deco_barcelona_sagrada_familia 등) → string_code **미등록** 확인
- G7 Istanbul 데코(deco_istanbul_hagia_sophia 등) → string_code **미등록** 확인
- **결론**: Athens/Prague 데코 name_key 10개도 string_code 미등록 정책 유지

---

## 2. unlock 조건 확인

`meta_city_list`의 `prev_city_id` 컬럼으로 unlock 처리. 별도 unlock 시트 불필요.

| 도시 | key_number | prev_city_id | 의미 |
|------|-----------|-------------|------|
| Athens | 60019 | 60018 | Istanbul(60018) 완성 후 unlock |
| Prague | 60020 | 60019 | Athens(60019) 완성 후 unlock |

---

## 3. string_code 추가 2행 (완성형 raw)

### 패턴 기준

- `en` 컬럼: `14000` (G8 도시 완성 보상 골드, G7 동일)
- 다국어: 각 언어권 표준 표기 적용

### 완성형 데이터

| key | en | ar | es | pt | id | ru | fr | th | ko |
|-----|----|----|----|----|----|----|----|----|-----|
| T_CITY_NAME_19 | 14000 | أثينا | Atenas | Atenas | Athena | Афины | Athènes | เอเธนส์ | 아테네 |
| T_CITY_NAME_20 | 14000 | براغ | Praga | Praga | Praha | Прага | Prague | ปราก | 프라하 |

### Raw (시트 입력용, 탭 구분)

```
T_CITY_NAME_19	14000	أثينا	Atenas	Atenas	Athena	Афины	Athènes	เอเธนส์	아테네
T_CITY_NAME_20	14000	براغ	Praga	Praga	Praha	Прага	Prague	ปราก	프라하
```

---

## 4. meta_city_list 추가 2행 (완성형 raw)

### 패턴 기준 (G7 Barcelona/Istanbul 동일 구조)

```
key_number | city_id | prev_city_id | reward_1_type | reward_1_amount | reward_2_type | reward_2_amount | reward_3_type | reward_3_amount
```

### 완성형 데이터

| key_number | city_id | prev_city_id | reward_1_type | reward_1_amount | reward_2_type | reward_2_amount | reward_3_type | reward_3_amount |
|-----------|---------|-------------|--------------|----------------|--------------|----------------|--------------|----------------|
| 60019 | city_name_athens | 60018 | currency_gold | 14000 | infinite_ticket_15m | 1 | booster_golden_ticket | 3 |
| 60020 | city_name_prague | 60019 | currency_gold | 14000 | infinite_ticket_15m | 1 | booster_golden_ticket | 3 |

### Raw (시트 입력용, 탭 구분)

```
60019	city_name_athens	60018	currency_gold	14000	infinite_ticket_15m	1	booster_golden_ticket	3
60020	city_name_prague	60019	currency_gold	14000	infinite_ticket_15m	1	booster_golden_ticket	3
```

---

## 5. meta_decoration_list 추가 10행 (완성형 raw)

### 패턴 기준 (G8 해머/골드 수치)

- 해머 패턴: [5, 7, 12, 18, 25] (슬롯별 upgrade_max=2 → cost_hammer1=cost_hammer2)
- 골드 패턴: [3600, 5800, 8600, 13000, 18000] (cost_gold_var2에 기입, var1=0)
- cost_hammer3~5 = 0, cost_gold_var1=0, cost_gold_var3~5 = 0
- upgrade_max = 2, is_ad_var = False

### Athens (city_name_athens) — key 70091~70095

| key_number | city_id | sort_order | name_key | cost_hammer1 | cost_hammer2 | cost_hammer3 | cost_hammer4 | cost_hammer5 | cost_gold_var1 | cost_gold_var2 | cost_gold_var3 | cost_gold_var4 | cost_gold_var5 | upgrade_max | is_ad_var |
|-----------|---------|-----------|---------|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
| 70091 | city_name_athens | 1 | deco_athens_parthenon | 5 | 5 | 0 | 0 | 0 | 0 | 3600 | 0 | 0 | 0 | 2 | False |
| 70092 | city_name_athens | 2 | deco_athens_acropolis | 7 | 7 | 0 | 0 | 0 | 0 | 5800 | 0 | 0 | 0 | 2 | False |
| 70093 | city_name_athens | 3 | deco_athens_plaka_district | 12 | 12 | 0 | 0 | 0 | 0 | 8600 | 0 | 0 | 0 | 2 | False |
| 70094 | city_name_athens | 4 | deco_athens_panathenaic_stadium | 18 | 18 | 0 | 0 | 0 | 0 | 13000 | 0 | 0 | 0 | 2 | False |
| 70095 | city_name_athens | 5 | deco_athens_cape_sounion | 25 | 25 | 0 | 0 | 0 | 0 | 18000 | 0 | 0 | 0 | 2 | False |

### Prague (city_name_prague) — key 70096~70100

| key_number | city_id | sort_order | name_key | cost_hammer1 | cost_hammer2 | cost_hammer3 | cost_hammer4 | cost_hammer5 | cost_gold_var1 | cost_gold_var2 | cost_gold_var3 | cost_gold_var4 | cost_gold_var5 | upgrade_max | is_ad_var |
|-----------|---------|-----------|---------|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
| 70096 | city_name_prague | 1 | deco_prague_charles_bridge | 5 | 5 | 0 | 0 | 0 | 0 | 3600 | 0 | 0 | 0 | 2 | False |
| 70097 | city_name_prague | 2 | deco_prague_old_town_square | 7 | 7 | 0 | 0 | 0 | 0 | 5800 | 0 | 0 | 0 | 2 | False |
| 70098 | city_name_prague | 3 | deco_prague_prague_castle | 12 | 12 | 0 | 0 | 0 | 0 | 8600 | 0 | 0 | 0 | 2 | False |
| 70099 | city_name_prague | 4 | deco_prague_astronomical_clock | 18 | 18 | 0 | 0 | 0 | 0 | 13000 | 0 | 0 | 0 | 2 | False |
| 70100 | city_name_prague | 5 | deco_prague_wenceslas_square | 25 | 25 | 0 | 0 | 0 | 0 | 18000 | 0 | 0 | 0 | 2 | False |

### Raw (시트 입력용, 탭 구분)

```
70091	city_name_athens	1	deco_athens_parthenon	5	5	0	0	0	0	3600	0	0	0	2	False
70092	city_name_athens	2	deco_athens_acropolis	7	7	0	0	0	0	5800	0	0	0	2	False
70093	city_name_athens	3	deco_athens_plaka_district	12	12	0	0	0	0	8600	0	0	0	2	False
70094	city_name_athens	4	deco_athens_panathenaic_stadium	18	18	0	0	0	0	13000	0	0	0	2	False
70095	city_name_athens	5	deco_athens_cape_sounion	25	25	0	0	0	0	18000	0	0	0	2	False
70096	city_name_prague	1	deco_prague_charles_bridge	5	5	0	0	0	0	3600	0	0	0	2	False
70097	city_name_prague	2	deco_prague_old_town_square	7	7	0	0	0	0	5800	0	0	0	2	False
70098	city_name_prague	3	deco_prague_prague_castle	12	12	0	0	0	0	8600	0	0	0	2	False
70099	city_name_prague	4	deco_prague_astronomical_clock	18	18	0	0	0	0	13000	0	0	0	2	False
70100	city_name_prague	5	deco_prague_wenceslas_square	25	25	0	0	0	0	18000	0	0	0	2	False
```

---

## 6. 검증 체크리스트

| 항목 | 확인 결과 |
|------|---------|
| string_code T_CITY_NAME_19 미존재 (신규 등록 필요) | 확인 — 시트에 없음 |
| string_code T_CITY_NAME_20 미존재 (신규 등록 필요) | 확인 — 시트에 없음 |
| deco name_key 10개 string_code 미등록 정책 | 확인 — G7 동일 패턴 |
| meta_city_list 60019 prev_city_id=60018 (Istanbul) | 확인 |
| meta_city_list 60020 prev_city_id=60019 (Athens) | 확인 |
| 해머 수치 출처 (02 에이전트 확정값) | [5,7,12,18,25] — 02_meta_city_design_g8.md 섹션2 |
| 골드 수치 출처 (02 에이전트 확정값) | [3600,5800,8600,13000,18000] — 02_meta_city_design_g8.md 섹션3 |
| upgrade_max=2 패턴 (G7 동일) | 확인 |
| is_ad_var=False 패턴 (G7 동일) | 확인 |
| reward 구조 (G7 동일: gold 14000 + inf_ticket + golden_ticket) | 확인 |

---

## 7. 07 에이전트 인계 사항

### 시트별 입력 위치

| 시트 | 입력 행 위치 | 행 수 |
|------|------------|------|
| `string_code` | T_CITY_NAME_18 행 바로 아래 | 2행 |
| `meta_city_list` | key 60018 행 바로 아래 | 2행 |
| `meta_decoration_list` | key 70090 행 바로 아래 | 10행 |

### 주의사항

- `string_code`의 deco name_key (deco_athens_*, deco_prague_*) 10개는 **등록하지 않음** — G7 Barcelona/Istanbul 동일 정책
- `meta_city_list`의 old_reward 컬럼(col 11~13)은 G7 행 참고하여 동일 값으로 채울 것
  - old_reward_1_amount = 14000, old_reward_2_amount = 1, old_reward_3_amount = 3
- `meta_decoration_list` 추가 컬럼(col 17~20)은 G7 행과 동일하게 빈 칸 처리
