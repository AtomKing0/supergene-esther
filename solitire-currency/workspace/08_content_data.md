---
agent: 08_content_team
mode: content-team
scope: Barcelona + Istanbul 메타 도시 콘텐츠 기획
executed: 2026-03-11T04:53:00+00:00
status: complete
approved_by: pm
cities: [barcelona, istanbul]
string_keys_defined: 2
unlock_conditions_defined: 0
handoff_to: 07_sheet_modifier
---

# 08 콘텐츠 팀 — Barcelona & Istanbul 메타 도시 콘텐츠 데이터

## 섹션 1: string_code 시트 구조 분석

**시트명:** `string_code` (GID: 3322884)
**총 행 수:** 221행 (헤더 2행 포함)

### 컬럼 정의

| 컬럼 인덱스 | 헤더 행 1 (언어명) | 헤더 행 2 (코드) | 비고 |
|------------|----------------|--------------|------|
| 0 | (없음) | Key | 문자열 식별자 (예: T_CITY_NAME_1) |
| 1 | english | en | **도시명 행에서는 골드 보상 수량** (정수 문자열) |
| 2 | arabic | ar | 아랍어 |
| 3 | spanish | es | 스페인어 |
| 4 | portuguese | pt | 포르투갈어 |
| 5 | indonesian | id | 인도네시아어 |
| 6 | russian | ru | 러시아어 |
| 7 | french | fr | 프랑스어 |
| 8 | thai | th | 태국어 |
| 9 | (없음) | ko | 한국어 |

### key_number 패턴

string_code 시트는 key_number 컬럼이 없다. 식별자는 `Key` 컬럼의 문자열 값(예: `T_CITY_NAME_16`)이다.

도시명 string_code 규칙:
- 패턴: `T_CITY_NAME_{N}` (N = key_number - 60000)
- 60001 → T_CITY_NAME_1, 60016 → T_CITY_NAME_16
- **60017(Barcelona) → T_CITY_NAME_17**
- **60018(Istanbul) → T_CITY_NAME_18**

### 도시명 행의 en 컬럼 특수 동작

`T_CITY_NAME_N` 행의 `en` 컬럼은 영어 도시 이름이 아닌 **건설 완료 골드 보상 수량**을 담는다.
예: T_CITY_NAME_1 en='5000' (New York 골드 보상), T_CITY_NAME_16 en='12500' (Rio de Janeiro 골드 보상)
이는 게임 엔진이 localization bundle에서 영어 도시명을 직접 읽고, string_code의 en 필드를 보상 수치로 활용하는 구조로 추정된다.

### 데코 string_code 구조

`meta_decoration_list`의 `name_key`(예: `deco_new_york_central_park`)에 대응하는 string_code 행이 시트에 **존재하지 않는다**. 데코 표시명은 게임 엔진 내부 에셋(localization bundle 또는 addressable 에셋)에서 직접 관리된다. 따라서 **데코 항목에 대한 string_code 추가는 불필요**하다.

---

## 섹션 2: unlock 시트 구조 분석

**시트명:** `unlock` (GID: 1177964140)
**총 행 수:** 22행 (헤더 2행 포함)

### 컬럼 정의

| 컬럼 | 내용 |
|------|------|
| key_number | unlock 항목 고유 번호 (50001~50106 범위) |
| content_id | 해금되는 콘텐츠 식별자 (예: content_shop, booster_fireworks) |
| condition_type | 해금 조건 유형 (현재 모든 행 = 'level') |
| condition_val | 조건 값 (레벨 숫자) |
| show_tutorial | 튜토리얼 표시 여부 (True/False) |
| description | 설명 (메모 용도) |

### 도시 언락 방식

**도시(city)는 unlock 시트를 사용하지 않는다.**
대신 `meta_city_list`의 `prev_city_id` 컬럼으로 도시 간 선후 관계를 정의한다.

- Barcelona(60017): `prev_city_id = 60016` → Rio de Janeiro 완료 후 자동 언락
- Istanbul(60018): `prev_city_id = 60017` → Barcelona 완료 후 자동 언락

따라서 unlock 시트에 신규 행 추가 불필요.

---

## 섹션 3: 신규 string_code 데이터 (2개)

기존 마지막 도시명 string_code: T_CITY_NAME_16 (Rio de Janeiro)
신규 배정: T_CITY_NAME_17 (Barcelona), T_CITY_NAME_18 (Istanbul)

| Key | en (골드보상) | ar | es | pt | id | ru | fr | th | ko |
|-----|-------------|----|----|----|----|----|----|----|----|
| T_CITY_NAME_17 | 14000 | برشلونة | Barcelona | Barcelona | Barcelona | Барселона | Barcelone | บาร์เซโลนา | 바르셀로나 |
| T_CITY_NAME_18 | 14000 | إسطنبول | Estambul | Istambul | Istanbul | Стамбул | Istanbul | อิสตันบูล | 이스탄불 |

**참고:** 데코 name_key(`deco_barcelona_*`, `deco_istanbul_*`)에 대한 string_code 행은 추가하지 않는다. 기존 데코 name_key도 시트에 없으며 엔진 내부 에셋에서 처리된다.

---

## 섹션 4: unlock 조건 데이터

unlock 시트 추가 행 없음. 도시 언락은 `meta_city_list.prev_city_id`로 관리된다.

| 도시 | 언락 방식 | 조건 |
|------|---------|------|
| Barcelona (60017) | prev_city_id = 60016 | Rio de Janeiro (60016) 완료 후 자동 언락 |
| Istanbul (60018) | prev_city_id = 60017 | Barcelona (60017) 완료 후 자동 언락 |

---

## 섹션 5: 07 에이전트 인계 데이터 (raw)

아래 데이터는 Google Sheet에 그대로 입력 가능한 형태이다. 각 섹션의 헤더는 참고용이며, 실제 입력 시 헤더 행 다음 줄부터 append한다.

---

### 5-1. meta_city_list — 추가 2행

**시트:** `meta_city_list` (GID: 701245569)
**추가 위치:** 기존 마지막 행(Row 18: key 60016) 아래

**헤더 (Row 2 참고):**
```
key_number | city_id | prev_city_id | reward_1_type | reward_1_amount | reward_2_type | reward_2_amount | reward_3_type | reward_3_amount | (empty) | old_reward_1_amount | old_reward_2_amount | old_reward_3_amount
```

**추가 데이터:**

| key_number | city_id | prev_city_id | reward_1_type | reward_1_amount | reward_2_type | reward_2_amount | reward_3_type | reward_3_amount | (empty) | old_reward_1_amount | old_reward_2_amount | old_reward_3_amount |
|------------|---------|-------------|--------------|----------------|--------------|----------------|--------------|----------------|---------|-------------------|-------------------|-------------------|
| 60017 | city_name_barcelona | 60016 | currency_gold | 14000 | infinite_ticket_15m | 1 | booster_golden_ticket | 3 | | 14000 | 1 | 3 |
| 60018 | city_name_istanbul | 60017 | currency_gold | 14000 | infinite_ticket_15m | 1 | booster_golden_ticket | 3 | | 14000 | 1 | 3 |

**raw (열 순서 그대로):**
```
60017	city_name_barcelona	60016	currency_gold	14000	infinite_ticket_15m	1	booster_golden_ticket	3		14000	1	3
60018	city_name_istanbul	60017	currency_gold	14000	infinite_ticket_15m	1	booster_golden_ticket	3		14000	1	3
```

---

### 5-2. meta_decoration_list — 추가 10행

**시트:** `meta_decoration_list` (GID: 680706612)
**추가 위치:** 기존 마지막 행(Row 81: key 70080) 아래

**헤더 (Row 2 참고):**
```
key_number | city_id | sort_order | name_key | cost_hammer1 | cost_hammer2 | cost_hammer3 | cost_hammer4 | cost_hammer5 | cost_gold_var1 | cost_gold_var2 | cost_gold_var3 | cost_gold_var4 | cost_gold_var5 | upgrade_max | is_ad_var
```

**추가 데이터 — Barcelona (70081~70085):**

| key_number | city_id | sort_order | name_key | cost_hammer1 | cost_hammer2 | cost_hammer3 | cost_hammer4 | cost_hammer5 | cost_gold_var1 | cost_gold_var2 | cost_gold_var3 | cost_gold_var4 | cost_gold_var5 | upgrade_max | is_ad_var |
|------------|---------|-----------|---------|-------------|-------------|-------------|-------------|-------------|--------------|--------------|--------------|--------------|--------------|------------|---------|
| 70081 | city_name_barcelona | 1 | deco_barcelona_sagrada_familia | 5 | 5 | 0 | 0 | 0 | 0 | 4900 | 0 | 0 | 0 | 2 | False |
| 70082 | city_name_barcelona | 2 | deco_barcelona_park_guell | 10 | 10 | 0 | 0 | 0 | 0 | 7700 | 0 | 0 | 0 | 2 | False |
| 70083 | city_name_barcelona | 3 | deco_barcelona_camp_nou | 16 | 16 | 0 | 0 | 0 | 0 | 11500 | 0 | 0 | 0 | 2 | False |
| 70084 | city_name_barcelona | 4 | deco_barcelona_gothic_quarter | 27 | 27 | 0 | 0 | 0 | 0 | 17300 | 0 | 0 | 0 | 2 | False |
| 70085 | city_name_barcelona | 5 | deco_barcelona_casa_batllo | 37 | 37 | 0 | 0 | 0 | 0 | 24100 | 0 | 0 | 0 | 2 | False |

**추가 데이터 — Istanbul (70086~70090):**

| key_number | city_id | sort_order | name_key | cost_hammer1 | cost_hammer2 | cost_hammer3 | cost_hammer4 | cost_hammer5 | cost_gold_var1 | cost_gold_var2 | cost_gold_var3 | cost_gold_var4 | cost_gold_var5 | upgrade_max | is_ad_var |
|------------|---------|-----------|---------|-------------|-------------|-------------|-------------|-------------|--------------|--------------|--------------|--------------|--------------|------------|---------|
| 70086 | city_name_istanbul | 1 | deco_istanbul_hagia_sophia | 5 | 5 | 0 | 0 | 0 | 0 | 4900 | 0 | 0 | 0 | 2 | False |
| 70087 | city_name_istanbul | 2 | deco_istanbul_blue_mosque | 10 | 10 | 0 | 0 | 0 | 0 | 7700 | 0 | 0 | 0 | 2 | False |
| 70088 | city_name_istanbul | 3 | deco_istanbul_grand_bazaar | 16 | 16 | 0 | 0 | 0 | 0 | 11500 | 0 | 0 | 0 | 2 | False |
| 70089 | city_name_istanbul | 4 | deco_istanbul_topkapi_palace | 27 | 27 | 0 | 0 | 0 | 0 | 17300 | 0 | 0 | 0 | 2 | False |
| 70090 | city_name_istanbul | 5 | deco_istanbul_bosphorus_bridge | 37 | 37 | 0 | 0 | 0 | 0 | 24100 | 0 | 0 | 0 | 2 | False |

**raw (열 순서 그대로):**
```
70081	city_name_barcelona	1	deco_barcelona_sagrada_familia	5	5	0	0	0	0	4900	0	0	0	2	False
70082	city_name_barcelona	2	deco_barcelona_park_guell	10	10	0	0	0	0	7700	0	0	0	2	False
70083	city_name_barcelona	3	deco_barcelona_camp_nou	16	16	0	0	0	0	11500	0	0	0	2	False
70084	city_name_barcelona	4	deco_barcelona_gothic_quarter	27	27	0	0	0	0	17300	0	0	0	2	False
70085	city_name_barcelona	5	deco_barcelona_casa_batllo	37	37	0	0	0	0	24100	0	0	0	2	False
70086	city_name_istanbul	1	deco_istanbul_hagia_sophia	5	5	0	0	0	0	4900	0	0	0	2	False
70087	city_name_istanbul	2	deco_istanbul_blue_mosque	10	10	0	0	0	0	7700	0	0	0	2	False
70088	city_name_istanbul	3	deco_istanbul_grand_bazaar	16	16	0	0	0	0	11500	0	0	0	2	False
70089	city_name_istanbul	4	deco_istanbul_topkapi_palace	27	27	0	0	0	0	17300	0	0	0	2	False
70090	city_name_istanbul	5	deco_istanbul_bosphorus_bridge	37	37	0	0	0	0	24100	0	0	0	2	False
```

**합계 검증:**
- Barcelona: 해머 (5+10+16+27+37)×2 = 190개 ✓, 골드 4,900+7,700+11,500+17,300+24,100 = 65,500g ✓
- Istanbul: 해머 (5+10+16+27+37)×2 = 190개 ✓, 골드 4,900+7,700+11,500+17,300+24,100 = 65,500g ✓

---

### 5-3. string_code — 추가 2행

**시트:** `string_code` (GID: 3322884)
**추가 위치:** T_CITY_NAME_16 행(Row 81) 바로 아래 (T_TODAY_GIFT_TITLE 앞)

**헤더 (Row 2 참고):**
```
Key | en | ar | es | pt | id | ru | fr | th | ko
```

**추가 데이터:**

| Key | en (골드보상) | ar | es | pt | id | ru | fr | th | ko |
|-----|-------------|----|----|----|----|----|----|----|----|
| T_CITY_NAME_17 | 14000 | برشلونة | Barcelona | Barcelona | Barcelona | Барселона | Barcelone | บาร์เซโลนา | 바르셀로나 |
| T_CITY_NAME_18 | 14000 | إسطنبول | Estambul | Istambul | Istanbul | Стамбул | Istanbul | อิสตันบูล | 이스탄불 |

**raw (열 순서 그대로):**
```
T_CITY_NAME_17	14000	برشلونة	Barcelona	Barcelona	Barcelona	Барселона	Barcelone	บาร์เซโลนา	바르셀로나
T_CITY_NAME_18	14000	إسطنبول	Estambul	Istambul	Istanbul	Стамбул	Istanbul	อิสตันบูล	이스탄불
```

---

### 5-4. unlock — 추가 행 없음

도시 언락은 `meta_city_list.prev_city_id` 체계로 관리된다. unlock 시트에 추가 행 불필요.

---

## 부록: 데이터 일관성 체크

| 검증 항목 | 결과 |
|---------|------|
| Barcelona key_number 연속성 (60016 다음 60017) | ✓ |
| Istanbul key_number 연속성 (60017 다음 60018) | ✓ |
| Barcelona deco key 연속성 (70080 다음 70081~70085) | ✓ |
| Istanbul deco key 연속성 (70085 다음 70086~70090) | ✓ |
| Barcelona prev_city_id = 60016 (Rio de Janeiro) | ✓ |
| Istanbul prev_city_id = 60017 (Barcelona) | ✓ |
| Barcelona 해머 합계 = 190 | ✓ |
| Istanbul 해머 합계 = 190 | ✓ |
| Barcelona 골드 합계 = 65,500g | ✓ |
| Istanbul 골드 합계 = 65,500g | ✓ |
| string_code T_CITY_NAME_17 en = 14000 (도시 보상과 일치) | ✓ |
| string_code T_CITY_NAME_18 en = 14000 (도시 보상과 일치) | ✓ |
| 기존 패턴(reward_2_type=infinite_ticket_15m, reward_3_type=booster_golden_ticket) 준수 | ✓ |
| 기존 패턴(cost_hammer1=cost_hammer2, cost_gold_var1=0, upgrade_max=2, is_ad_var=False) 준수 | ✓ |
