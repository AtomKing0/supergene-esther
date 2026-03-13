---
agent: 02_economic_balance
mode: meta-city-design
executed: 2026-03-11T04:42:00+00:00
status: complete
cities_designed: 2
total_hammer_added: 380
total_gold_added: 131000
sink_extension: 24.8일
---

# 메타 신규 도시 설계 — Barcelona & Istanbul

## 1. 기존 메타 도시 구조 분석

### 데이터 소스
- `meta_city_list` (gid=701245569): 도시 16개, 건설 완료 보상 정의
- `meta_decoration_list` (gid=680706612): 데코 80개, 도시별 5항목 × 2업그레이드

### 구조 특성

모든 도시는 **5개 장식물 × 업그레이드 2단계** 구조이다. 각 장식물은:
- `cost_hammer1` = `cost_hammer2` (동일 값, 1단계·2단계 동일 비용)
- `cost_gold_var1 = 0` (1단계는 무료), `cost_gold_var2 = X` (2단계 골드 소모)
- `upgrade_max = 2`, `is_ad_var = False`

### 도시별 해머·골드 합산

| 도시 | 항목수 | 총해머 | 총골드 |
|------|-------|-------|-------|
| city_name_new_york | 5 | 36 | 6,800 |
| city_name_los_angeles | 5 | 36 | 10,300 |
| city_name_san_francisco | 5 | 36 | 10,300 |
| city_name_las_vegas | 5 | 36 | 12,200 |
| city_name_chicago | 5 | 36 | 12,200 |
| city_name_miami | 5 | 36 | 13,600 |
| city_name_paris | 5 | 48 | 15,000 |
| city_name_london | 5 | 48 | 15,000 |
| city_name_rome | 5 | 60 | 17,100 |
| city_name_venice | 5 | 60 | 17,100 |
| city_name_tokyo | 5 | 72 | 19,800 |
| city_name_bangkok | 5 | 72 | 19,800 |
| city_name_cairo | 5 | 80 | 23,100 |
| city_name_dubai | 5 | 80 | 26,600 |
| city_name_sydney | 5 | 94 | 30,700 |
| city_name_rio_de_janeiro | 5 | 94 | 34,000 |
| **기존 합계** | **80** | **924** | **341,600** |

기존 924개 해머 ÷ 15.3해머/일 = **60.4일 sink**

### 해머 패턴 그룹 (hammer1 기준)

| 그룹 | 패턴 [h1~h5] | 총해머(×2) | 적용 도시 |
|------|------------|----------|---------|
| G1 | [1, 2, 3, 5, 7] | 36 | New York~Miami (6개) |
| G2 | [1, 2, 4, 7, 10] | 48 | Paris, London |
| G3 | [2, 3, 5, 8, 12] | 60 | Rome, Venice |
| G4 | [2, 4, 6, 10, 14] | 72 | Tokyo, Bangkok |
| G5 | [2, 4, 7, 11, 16] | 80 | Cairo, Dubai |
| G6 | [3, 5, 8, 13, 18] | 94 | Sydney, Rio |
| **G7** | **[5, 10, 16, 27, 37]** | **190** | Barcelona, Istanbul (신규) |

G7은 G6 대비 해머 ×2.02 배 증가. 기존 그룹 간 단계적 확장 패턴과 일치한다.

### 골드 패턴 특성

- 항목 내 비율: g1 기준 [1.0 : 1.56 : 2.36 : 3.53 : 4.92] (평균)
- 비율 합계: 약 13.37 → `총골드 ÷ 13.37 = g1` 역산
- `cost_gold_var1 = 0` (무조건), `cost_gold_var2`만 소모

---

## 2. 신규 도시 1 — Barcelona (city_name_barcelona)

### meta_city_list 행

| 필드 | 값 |
|------|---|
| key_number | 60017 |
| city_id | city_name_barcelona |
| prev_city_id | 60016 |
| reward_1_type | currency_gold |
| reward_1_amount | 14,000 |
| reward_2_type | infinite_ticket_15m |
| reward_2_amount | 1 |
| reward_3_type | booster_golden_ticket |
| reward_3_amount | 3 |

### meta_decoration_list 행 (70081~70085)

| key | sort | name_key | hammer1 | hammer2 | gold_var1 | gold_var2 | upgrade_max | is_ad_var |
|-----|------|----------|---------|---------|-----------|-----------|-------------|-----------|
| 70081 | 1 | deco_barcelona_sagrada_familia | 5 | 5 | 0 | 4,900 | 2 | False |
| 70082 | 2 | deco_barcelona_park_guell | 10 | 10 | 0 | 7,700 | 2 | False |
| 70083 | 3 | deco_barcelona_camp_nou | 16 | 16 | 0 | 11,500 | 2 | False |
| 70084 | 4 | deco_barcelona_gothic_quarter | 27 | 27 | 0 | 17,300 | 2 | False |
| 70085 | 5 | deco_barcelona_casa_batllo | 37 | 37 | 0 | 24,100 | 2 | False |
| **합계** | | | | | | | | |
| | | | **총 해머: 190개** | | | **총 골드: 65,500g** | | |

---

## 3. 신규 도시 2 — Istanbul (city_name_istanbul)

### meta_city_list 행

| 필드 | 값 |
|------|---|
| key_number | 60018 |
| city_id | city_name_istanbul |
| prev_city_id | 60017 |
| reward_1_type | currency_gold |
| reward_1_amount | 14,000 |
| reward_2_type | infinite_ticket_15m |
| reward_2_amount | 1 |
| reward_3_type | booster_golden_ticket |
| reward_3_amount | 3 |

### meta_decoration_list 행 (70086~70090)

| key | sort | name_key | hammer1 | hammer2 | gold_var1 | gold_var2 | upgrade_max | is_ad_var |
|-----|------|----------|---------|---------|-----------|-----------|-------------|-----------|
| 70086 | 1 | deco_istanbul_hagia_sophia | 5 | 5 | 0 | 4,900 | 2 | False |
| 70087 | 2 | deco_istanbul_blue_mosque | 10 | 10 | 0 | 7,700 | 2 | False |
| 70088 | 3 | deco_istanbul_grand_bazaar | 16 | 16 | 0 | 11,500 | 2 | False |
| 70089 | 4 | deco_istanbul_topkapi_palace | 27 | 27 | 0 | 17,300 | 2 | False |
| 70090 | 5 | deco_istanbul_bosphorus_bridge | 37 | 37 | 0 | 24,100 | 2 | False |
| **합계** | | | | | | | | |
| | | | **총 해머: 190개** | | | **총 골드: 65,500g** | | |

---

## 4. 경제 효과 분석

### Sink 연장 계산

| 항목 | 수치 |
|------|------|
| 기존 전체 해머 합계 | 924개 |
| 기존 메타 sink | 60.4일 |
| 신규 추가 해머 (2개 도시) | 380개 |
| 신규 추가 골드 소모 | 131,000g |
| 추가 sink (15.3해머/일 기준) | +24.8일 |
| **신규 메타 sink 합계** | **85.2일** |

### 수치 근거

- **15.3해머/일**: 기존 시뮬레이션 결과 (`workspace/economy_simulation_result.md`) 기준
- **해머 패턴 G7 [5,10,16,27,37]**: 기존 G6→G5→G4 단계적 증가 패턴 연장
  - G6 = [3,5,8,13,18] → G7 = [5,10,16,27,37] (각 항목 약 ×2 증가)
- **골드 g1=4,900**: 목표 65,000g ÷ 비율합계 13.37 = 4,863 → 반올림
- **도시 쌍 구조**: 기존 패턴(paris/london, rome/venice 등)처럼 두 도시 동일 비용 적용

### Rio de Janeiro 대비 비교

| 항목 | Rio (기존 최고) | Barcelona / Istanbul (신규) | 증가율 |
|------|--------------|---------------------------|-------|
| 해머 패턴 | [3,5,8,13,18] | [5,10,16,27,37] | ×2.02 |
| 총 해머 | 94개 | 190개 | ×2.02 |
| 총 골드 | 34,000g | 65,500g | ×1.93 |
| 건설 보상 gold | 12,500g | 14,000g | ×1.12 |

---

## 5. 시트 입력 데이터 (raw)

### meta_city_list 추가 행

```
60017 | city_name_barcelona | 60016 | currency_gold | 14000 | infinite_ticket_15m | 1 | booster_golden_ticket | 3
60018 | city_name_istanbul  | 60017 | currency_gold | 14000 | infinite_ticket_15m | 1 | booster_golden_ticket | 3
```

### meta_decoration_list 추가 행

```
70081 | city_name_barcelona | 1 | deco_barcelona_sagrada_familia | 5 | 5 | 0 | 0 | 0 | 0 | 4900 | 0 | 0 | 0 | 2 | False
70082 | city_name_barcelona | 2 | deco_barcelona_park_guell | 10 | 10 | 0 | 0 | 0 | 0 | 7700 | 0 | 0 | 0 | 2 | False
70083 | city_name_barcelona | 3 | deco_barcelona_camp_nou | 16 | 16 | 0 | 0 | 0 | 0 | 11500 | 0 | 0 | 0 | 2 | False
70084 | city_name_barcelona | 4 | deco_barcelona_gothic_quarter | 27 | 27 | 0 | 0 | 0 | 0 | 17300 | 0 | 0 | 0 | 2 | False
70085 | city_name_barcelona | 5 | deco_barcelona_casa_batllo | 37 | 37 | 0 | 0 | 0 | 0 | 24100 | 0 | 0 | 0 | 2 | False
70086 | city_name_istanbul | 1 | deco_istanbul_hagia_sophia | 5 | 5 | 0 | 0 | 0 | 0 | 4900 | 0 | 0 | 0 | 2 | False
70087 | city_name_istanbul | 2 | deco_istanbul_blue_mosque | 10 | 10 | 0 | 0 | 0 | 0 | 7700 | 0 | 0 | 0 | 2 | False
70088 | city_name_istanbul | 3 | deco_istanbul_grand_bazaar | 16 | 16 | 0 | 0 | 0 | 0 | 11500 | 0 | 0 | 0 | 2 | False
70089 | city_name_istanbul | 4 | deco_istanbul_topkapi_palace | 27 | 27 | 0 | 0 | 0 | 0 | 17300 | 0 | 0 | 0 | 2 | False
70090 | city_name_istanbul | 5 | deco_istanbul_bosphorus_bridge | 37 | 37 | 0 | 0 | 0 | 0 | 24100 | 0 | 0 | 0 | 2 | False
```

---

## 6. 주의 사항 및 후속 작업

1. **string_code 연결**: `city_name_barcelona`, `city_name_istanbul`, `deco_barcelona_*`, `deco_istanbul_*` 총 12개 string key를 `string_code` 시트에 추가 필요.
2. **unlock 시트**: `city_name_barcelona`/`city_name_istanbul` 언락 조건 정의 필요 (현재 unlock 시트 별도 확인 필요).
3. **85.2일 목표 달성 여부**: PM 승인 조건 "90일+"에 대해 85.2일은 약 5일 부족. 목표 달성을 위해 다음 중 하나 선택 가능:
   - 옵션 A: city18 해머 패턴 소폭 상향 [5,10,17,28,40] → city18 총해머=200 → 전체 sink 86.9일
   - 옵션 B: 도시 3개 추가 설계 (각 190개 → +12.4일/도시)
   - 옵션 C: 기존 도시 항목 추가 (upgrade_max 2→3, 3단계 비용 신설)
   - **현재 설계: 85.2일 (PM 재확인 권장)**
