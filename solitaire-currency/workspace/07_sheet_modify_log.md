---
agent: 07_sheet_modifier
mode: sheet-modify
scope: const
executed: 2026-03-09
status: complete
approved_by: pm
items_modified: 3
items_skipped: 0
---

# 시트 수정 완료 보고

## 수정 대상 시트

**Spreadsheet:** `1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk`
**시트명:** `const`

---

## 변경 내역

| Parameter | Original Data | Updated Data | 사유 |
|-----------|---------------|--------------|------|
| `inbox_free_gold_amount` (key 10058) | 2000 | **800** [가설] | 개선안 1: 1회 지급량 조정. 횟수(5회) 유지. |
| `popup_free_gold_amount` (key 10064) | 2000 | **800** [가설] | 개선안 1: 1회 지급량 조정. 횟수(10회) 유지. |
| `idle_gold_amount_increase` (key 10005) | 1200 | **400** | 시뮬 F-1: 방치 골드 인상폭 하향. Lv75 4h 수령량 6,600→4,200g. |

**Original Data 보존 위치:** 시트 T열 (행 7, 41, 47)
**Updated Data 기록 위치:** 시트 U열 (행 7, 41, 47)

---

## 미수정 항목 (정책 준수)

| Parameter | 이유 |
|-----------|------|
| `inbox_free_gold_limit` (10057) | 횟수 상한 도입 금지 — bugfix §3 |
| `popup_free_gold_limit` (10063) | 동상 |
| 개선안 3 관련 전 항목 | 골드 인플레이션 확정 발생 — bugfix §3 |

---

## 경제 영향 요약

### 1차 수정 (inbox/popup RV)

| 항목 | 변경 전 | 변경 후 |
|------|---------|---------|
| 일일 inbox RV 최대 | 10,000 (5×2,000) | **4,000** (5×800) |
| 일일 popup RV 최대 | 20,000 (10×2,000) | **8,000** (10×800) |
| 일일 RV 합산 최대 | 30,000 | **12,000** |
| 감소율 | — | 60% 감소 |

### 2차 수정 (idle_gold_amount_increase)

| 레벨 | 변경 전 (4h) | 변경 후 (4h) | 일 3회 기준 |
|------|------------|------------|-----------|
| Lv10 | 3,000g | 3,000g | 9,000g (동일) |
| Lv30 | 4,200g | 3,400g | 10,200g → 10,200g |
| Lv50 | 5,400g | 3,800g | 16,200g → 11,400g |
| **Lv75** | **6,600g** | **4,200g** | **19,800g → 12,600g** |
| Lv100 | 9,000g | 5,000g | 27,000g → 15,000g |
| Lv200+ | 10,000g (상한) | 5,800g (상한) | 30,000g → 17,400g |

> 방치 골드 패시브 공급 감소: Lv75 기준 **19,800g → 12,600g/일 (-36%)**
> 전체 패시브 공급 (Lv75): 36,971g → **29,771g/일**

---

## 검증 결과

| 항목 | 기대값 | 실제값 | 결과 |
|------|--------|--------|------|
| 행 41 const_value | 800 | 800 | ✅ |
| 행 47 const_value | 800 | 800 | ✅ |
| T41 Original 보존 | inbox_free_gold_amount=2000 | 확인 | ✅ |
| T47 Original 보존 | popup_free_gold_amount=2000 | 확인 | ✅ |
| 행 7 const_value | 400 | 400 | ✅ |
| T7 Original 보존 | idle_gold_amount_increase=1200 | 확인 | ✅ |

---

---
agent: 07_sheet_modifier
mode: sheet-modify
scope: level_entry_tier + item_list
executed: 2026-03-11T01:44:00+09:00
status: complete
approved_by: pm
revision: 2
---

# 시트 수정 완료 보고 (Revision 2)

## 수정 대상 시트

**Spreadsheet:** `1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk`
**시트명:** `level_entry_tier`, `item_list`

---

## 변경 내역

### 항목 1: `level_entry_tier` — Lv50-99 ratio 조정 (시나리오 A+B)

| 시트 행 | level_min | level_max | 컬럼 | 원본값 | 수정값 | 근거 |
|---------|-----------|-----------|------|--------|--------|------|
| 7 | 50 | 99 | `undo_ratio` | 5000 | **6000** | 08_booster_analysis.md 시나리오 A |
| 7 | 50 | 99 | `extra_deck_ratio` | 7000 | **8000** | 08_booster_analysis.md 시나리오 B |

### 항목 2: `level_entry_tier` — Lv200+ ratio 단계적 상향 (제안 4-E)

| 시트 행 | level_min | level_max | undo_ratio (전→후) | extra_deck_ratio (전→후) |
|---------|-----------|-----------|-------------------|------------------------|
| 9  | 200  | 349    | 5000 → **5500** | 7000 → **8000** |
| 10 | 350  | 549    | 5000 → **6000** | 7000 → **8500** |
| 11 | 550  | 799    | 5000 → **6500** | 7000 → **9000** |
| 12 | 800  | 1099   | 5000 → **6500** | 7000 → **9000** |
| 13 | 1100 | 1449   | 5000 → **6500** | 7000 → **9000** |
| 14 | 1450 | 999999 | 5000 → **6500** | 7000 → **9000** |

### 항목 3: `item_list` — fixed 부스터 누진화 (제안 1-3)

| 시트 행 | key_number | 명칭 | 컬럼 | 원본값 | 수정값 |
|---------|------------|------|------|--------|--------|
| 8  | 40010 | fireworks     | `use_count_increase_rate` | 0 | **2000** |
| 8  | 40010 | fireworks     | `use_count_max_ratio`     | 0 | **20000** |
| 9  | 40011 | golden_ticket | `use_count_increase_rate` | 0 | **2000** |
| 9  | 40011 | golden_ticket | `use_count_max_ratio`     | 0 | **20000** |
| 11 | 40013 | wild_card     | `use_count_increase_rate` | 0 | **2000** |
| 11 | 40013 | wild_card     | `use_count_max_ratio`     | 0 | **20000** |

**Original Data 보존 위치 (level_entry_tier):** 시트 K열 (undo_ratio 원본), L열 (extra_deck_ratio 원본), M열 (Note) — 행 7, 9, 10, 11, 12, 13, 14
**Original Data 보존 위치 (item_list):** 시트 N열 (use_count_increase_rate 원본), O열 (use_count_max_ratio 원본), P열 (Note) — 행 8, 9, 11

---

## 미수정 항목 (정책 준수)

| 시트 | 항목 | 이유 |
|------|------|------|
| level_entry_tier | Lv1-2, Lv3-9, Lv10-24, Lv25-49, Lv100-199 행 | 승인 목록 외 |
| item_list | 40012 (undo), 40014 (extra_deck) | 승인 목록 외 (tier 참조형이므로 별도 수정 불필요) |

---

## 검증 결과

### level_entry_tier

| 행 | level_min | undo_ratio (기대값) | undo_ratio (실제값) | extra_deck_ratio (기대값) | extra_deck_ratio (실제값) | 결과 |
|----|-----------|---------------------|---------------------|--------------------------|--------------------------|------|
| 7  | 50   | 6000 | 6000 | 8000 | 8000 | ✅ |
| 9  | 200  | 5500 | 5500 | 8000 | 8000 | ✅ |
| 10 | 350  | 6000 | 6000 | 8500 | 8500 | ✅ |
| 11 | 550  | 6500 | 6500 | 9000 | 9000 | ✅ |
| 12 | 800  | 6500 | 6500 | 9000 | 9000 | ✅ |
| 13 | 1100 | 6500 | 6500 | 9000 | 9000 | ✅ |
| 14 | 1450 | 6500 | 6500 | 9000 | 9000 | ✅ |

### item_list

| 행 | key_number | use_count_increase_rate (기대값) | 실제값 | use_count_max_ratio (기대값) | 실제값 | 결과 |
|----|------------|--------------------------------|--------|----------------------------|--------|------|
| 8  | 40010 | 2000 | 2000 | 20000 | 20000 | ✅ |
| 9  | 40011 | 2000 | 2000 | 20000 | 20000 | ✅ |
| 11 | 40013 | 2000 | 2000 | 20000 | 20000 | ✅ |

### 백업 확인

| 시트 | 위치 | 보존값 | 결과 |
|------|------|--------|------|
| level_entry_tier | K7 | 5000 (undo_ratio 원본) | ✅ |
| level_entry_tier | L7 | 7000 (extra_deck_ratio 원본) | ✅ |
| item_list | N8 | 0 (use_count_increase_rate 원본) | ✅ |
| item_list | O8 | 0 (use_count_max_ratio 원본) | ✅ |

**총 수정 셀: 16개 (level_entry_tier 14셀 + item_list 6셀) — 전체 검증 통과**

---

---
agent: 07_sheet_modifier
mode: sheet-modify (후처리)
scope: level_entry_tier + item_list
executed: 2026-03-11T02:00:00+09:00
status: complete
revision: 2 (post-process)
tasks: 숫자 포맷 확인, 원본 백업 기록, 하이라이트 적용
---

# 시트 수정 후처리 보고 (Revision 2 Post-process)

## 작업 1: 숫자 포맷 확인

Sheets API `userEnteredValue` 타입 직접 확인 결과, Revision 2에서 수정된 셀들은 이미 모두 `numberValue`로 저장되어 있었음. apostrophe 접두 문자열 없음.

| 시트 | 셀 | 타입 | 값 | 결과 |
|------|-----|------|-----|------|
| level_entry_tier | E7 (undo_ratio Lv50) | numberValue | 6000 | ✅ |
| level_entry_tier | F7 (extra_deck_ratio Lv50) | numberValue | 8000 | ✅ |
| level_entry_tier | E9 (undo_ratio Lv200) | numberValue | 5500 | ✅ |
| level_entry_tier | F9 (extra_deck_ratio Lv200) | numberValue | 8000 | ✅ |
| level_entry_tier | E10~F14 (Lv350+) | numberValue | 각 수정값 | ✅ |
| item_list | G8 (40010 increase_rate) | numberValue | 2000 | ✅ |
| item_list | H8 (40010 max_ratio) | numberValue | 20000 | ✅ |
| item_list | G9, G11, H9, H11 | numberValue | 각 수정값 | ✅ |

**재저장 불필요 — 모두 정수형으로 확인됨.**

---

## 작업 2: 원본값 우측 빈 열에 기록

### level_entry_tier — N:P열 (열 14~16, 0-based 13~15)

| 열 | 내용 |
|----|------|
| N1 | Parameter |
| O1 | Original |
| P1 | Updated |
| N2:P9 | 8개 파라미터 × 3열 (파라미터명 / 원본값 / 수정값) |

기록 내용:

| Parameter | Original | Updated |
|-----------|----------|---------|
| undo_ratio (Lv50-99) | 5000 | 6000 |
| extra_deck_ratio (Lv50-99) | 7000 | 8000 |
| undo_ratio (Lv200-349) | 5000 | 5500 |
| extra_deck_ratio (Lv200-349) | 7000 | 8000 |
| undo_ratio (Lv350-549) | 5000 | 6000 |
| extra_deck_ratio (Lv350-549) | 7000 | 8500 |
| undo_ratio (Lv550+) | 5000 | 6500 |
| extra_deck_ratio (Lv550+) | 7000 | 9000 |

### item_list — Q:S열 (열 17~19, 0-based 16~18)

| 열 | 내용 |
|----|------|
| Q1 | Parameter |
| R1 | Original |
| S1 | Updated |
| Q2:S7 | 6개 파라미터 × 3열 |

기록 내용:

| Parameter | Original | Updated |
|-----------|----------|---------|
| fireworks use_count_increase_rate | 0 | 2000 |
| fireworks use_count_max_ratio | 0 | 20000 |
| golden_ticket use_count_increase_rate | 0 | 2000 |
| golden_ticket use_count_max_ratio | 0 | 20000 |
| wild_card use_count_increase_rate | 0 | 2000 |
| wild_card use_count_max_ratio | 0 | 20000 |

---

## 작업 3: 수정 셀 하이라이트 (연두색 RGB 0.85, 0.93, 0.83)

### level_entry_tier — 14셀

| 행 | level_min | undo_ratio (E열) | extra_deck_ratio (F열) |
|----|-----------|-----------------|----------------------|
| 7  | 50   | ✅ 연두 | ✅ 연두 |
| 9  | 200  | ✅ 연두 | ✅ 연두 |
| 10 | 350  | ✅ 연두 | ✅ 연두 |
| 11 | 550  | ✅ 연두 | ✅ 연두 |
| 12 | 800  | ✅ 연두 | ✅ 연두 |
| 13 | 1100 | ✅ 연두 | ✅ 연두 |
| 14 | 1450 | ✅ 연두 | ✅ 연두 |

### item_list — 6셀

| 행 | key_number | use_count_increase_rate (G열) | use_count_max_ratio (H열) |
|----|------------|------------------------------|--------------------------|
| 8  | 40010 | ✅ 연두 | ✅ 연두 |
| 9  | 40011 | ✅ 연두 | ✅ 연두 |
| 11 | 40013 | ✅ 연두 | ✅ 연두 |

---

## 최종 검증 결과

| 확인 항목 | 기대값 | 결과 |
|---|---|---|
| level_entry_tier Lv50 undo_ratio 타입 | int 6000 | ✅ numberValue 6000 |
| level_entry_tier Lv200 extra_deck_ratio 타입 | int 8000 | ✅ numberValue 8000 |
| item_list 40010 use_count_increase_rate 타입 | int 2000 | ✅ numberValue 2000 |
| level_entry_tier 원본 백업 존재 | ✅ N:P열 | ✅ N1:P9 기록 완료 |
| item_list 원본 백업 존재 | ✅ Q:S열 | ✅ Q1:S7 기록 완료 |
| level_entry_tier 하이라이트 적용 | 연두색 14셀 | ✅ 14셀 확인 |
| item_list 하이라이트 적용 | 연두색 6셀 | ✅ 6셀 확인 |

**총 처리: 숫자 포맷 재저장 0셀 (이미 정수형) / 백업 기록 27셀 / 하이라이트 20셀**

---

---
agent: 07_sheet_modifier
mode: sheet-modify (후처리 — 열 재정렬)
scope: level_entry_tier + item_list
executed: 2026-03-11T02:05:00+09:00
status: complete
revision: 2 (post-process / column reorder)
tasks: 변경 노트 열 위치를 새 규칙에 맞게 재정렬
---

# 열 재정렬 보고 (Revision 2 Post-process — Column Reorder)

## 규칙

`[데이터 마지막 열] │ [빈 열 1개] │ Parameter │ Original │ Updated`

---

## 작업 결과

### level_entry_tier

| 항목 | 이전 위치 | 새 위치 |
|------|-----------|---------|
| (빈 구분 열) | N (col 13) — Parameter가 바로 붙어 있었음 | N (col 13) — 완전히 비움 |
| Parameter | N (col 13) | O (col 14) |
| Original | O (col 14) | P (col 15) |
| Updated | P (col 15) | Q (col 16) |

- 데이터 마지막 열: **M** (col 12) — `Note` (Original_undo_ratio, Original_extra_deck_ratio, Note 포함)
- 빈 열: **N** (col 13)
- Parameter 열: **O** (col 14)
- Original 열: **P** (col 15)
- Updated 열: **Q** (col 16)

### item_list

| 항목 | 이전 위치 | 새 위치 |
|------|-----------|---------|
| (빈 구분 열) | Q (col 16) — Parameter가 바로 붙어 있었음 | Q (col 16) — 완전히 비움 |
| Parameter | Q (col 16) | R (col 17) |
| Original | R (col 17) | S (col 18) |
| Updated | S (col 18) | T (col 19) |

- 데이터 마지막 열: **P** (col 15) — `Note` (Original_use_count_increase_rate, Original_use_count_max_ratio, Note 포함)
- 빈 열: **Q** (col 16)
- Parameter 열: **R** (col 17)
- Original 열: **S** (col 18)
- Updated 열: **T** (col 19)

---

## 열 위치 요약표

| 시트 | 데이터 마지막 열 | 빈 열 | Parameter 열 | Original 열 | Updated 열 |
|---|---|---|---|---|---|
| level_entry_tier | M (col 12) | N (col 13) | O (col 14) | P (col 15) | Q (col 16) |
| item_list | P (col 15) | Q (col 16) | R (col 17) | S (col 18) | T (col 19) |

---

## 검증

| 확인 항목 | 기대값 | 결과 |
|---|---|---|
| level_entry_tier N열 (col 13) 완전히 비어 있음 | 빈 열 | ✅ |
| level_entry_tier O1 | Parameter | ✅ |
| level_entry_tier P1 | Original | ✅ |
| level_entry_tier Q1 | Updated | ✅ |
| level_entry_tier O2:Q9 데이터 8행 | 변경 노트 8개 | ✅ |
| item_list Q열 (col 16) 완전히 비어 있음 | 빈 열 | ✅ |
| item_list R1 | Parameter | ✅ |
| item_list S1 | Original | ✅ |
| item_list T1 | Updated | ✅ |
| item_list R2:T7 데이터 6행 | 변경 노트 6개 | ✅ |

---

---
agent: 07_sheet_modifier
mode: format-fix
scope: 전체 시트
executed: 2026-03-11T21:00:00+09:00
status: complete
cells_fixed: 2024
---

# 숫자 포맷 일괄 수정

## 개요

**Spreadsheet:** `1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk`
**범위:** 전체 24개 시트 스캔
**방법:** `includeGridData=True` 로 각 셀 `userEnteredValue` 타입 확인 → `stringValue`이면서 순수 숫자 패턴(`-?\d+(\.\d+)?`)인 셀을 `numberValue`로 일괄 변환 (batchUpdate, 1000개 단위)

## 시트별 결과

| 시트명 | 스캔 셀 수 | 수정 대상 발견 | 수정 완료 |
|---|---|---|---|
| tool | 148 | 0 | 0 |
| const | 249 | 0 | 0 |
| gimmick_weight | 29 | 16 | 16 |
| difficulty_tier | 54 | 32 | 32 |
| dynamic_level | 67 | 40 | 40 |
| level_entry_tier | 192 | 106 | 106 |
| streak_reward | 96 | 27 | 27 |
| item_list | 256 | 94 | 94 |
| unlock | 131 | 40 | 40 |
| meta_city_list | 214 | 32 | 32 |
| meta_decoration_list | 1312 | 1040 | 1040 |
| collection_album_puzzle_list | 131 | 14 | 14 |
| collection_puzzle_piece_list | 95 | 28 | 28 |
| collection_album_milestone | 109 | 40 | 40 |
| collection_deck | 61 | 36 | 36 |
| daily_task | 552 | 192 | 192 |
| daily_task_milestone | 29 | 9 | 9 |
| daily_wheel | 49 | 16 | 16 |
| daily_gift | 96 | 14 | 14 |
| event_schedule | 63 | 16 | 16 |
| event_ranking | 88 | 20 | 20 |
| event_milestone | 515 | 135 | 135 |
| product | 369 | 77 | 77 |
| string_code | 2208 | 0 | 0 |
| **합계** | **7113** | **2024** | **2024** |

## 비고

- `tool`, `const`, `string_code` 시트는 수정 대상 없음 (이미 정상 numberValue 또는 텍스트 셀만 존재)
- `meta_decoration_list` 단일 최대 (1040셀) — 전체 수정 셀의 51.4%
- batchUpdate 2회 실행 (1000셀 + 1024셀)
- 빈 셀·텍스트 셀·수식 셀은 건드리지 않음

---

---
agent: 07_sheet_modifier
mode: sheet-modify
scope: event_milestone (골드 비율 60%→40%)
executed: 2026-03-11T04:46:00+00:00
status: complete
approved_by: pm
revision: 3
items_modified: 24
items_skipped: 0
---

# 시트 수정 완료 보고 (Revision 3)

## 수정 대상 시트

**Spreadsheet:** `1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk`
**시트명:** `event_milestone` (gid: 1807743099)

---

## 수정 개요

**승인된 비율 변경:** 이벤트 보상 골드 비율 60% → 40%
**계산식:** `new_value = round(original × 40/60)`
**대상 컬럼:** `reward_amount` (H열), `reward_item_key == 'currency_gold'`인 행만 적용

---

## 변경 내역

### 이벤트 160001 — Midnight (collect_color: black)

| 시트 행 | key_number | 단계 | 설명 | 원본값 | 수정값 |
|---------|------------|------|------|--------|--------|
| 3  | 180001 | 1  | Midnight Step 1  | 200  | **133** |
| 4  | 180002 | 2  | Midnight Step 2  | 400  | **267** |
| 6  | 180004 | 4  | Midnight Step 4  | 600  | **400** |
| 7  | 180005 | 5  | Midnight Step 5  | 800  | **533** |
| 9  | 180007 | 7  | Midnight Step 7  | 1000 | **667** |
| 10 | 180008 | 8  | Midnight Step 8  | 1200 | **800** |
| 12 | 180010 | 10 | Midnight Step 10 | 1500 | **1000** |
| 14 | 180012 | 12 | Midnight Step 12 | 2000 | **1333** |
| 16 | 180014 | 14 | Midnight Step 14 | 3000 | **2000** |

### 이벤트 160002 — Sunset (collect_color: red)

| 시트 행 | key_number | 단계 | 설명 | 원본값 | 수정값 |
|---------|------------|------|------|--------|--------|
| 18 | 180016 | 1  | Sunset Step 1  | 200  | **133** |
| 19 | 180017 | 2  | Sunset Step 2  | 400  | **267** |
| 21 | 180019 | 4  | Sunset Step 4  | 600  | **400** |
| 22 | 180020 | 5  | Sunset Step 5  | 800  | **533** |
| 24 | 180022 | 7  | Sunset Step 7  | 1000 | **667** |
| 25 | 180023 | 8  | Sunset Step 8  | 1200 | **800** |
| 27 | 180025 | 10 | Sunset Step 10 | 1500 | **1000** |
| 29 | 180027 | 12 | Sunset Step 12 | 2000 | **1333** |
| 31 | 180029 | 14 | Sunset Step 14 | 3000 | **2000** |

### 이벤트 160003 — Stamp (earn_point)

| 시트 행 | key_number | 단계 | 설명 | 원본값 | 수정값 |
|---------|------------|------|------|--------|--------|
| 33 | 180031 | 1  | Stamp Step 1  | 300  | **200** |
| 35 | 180033 | 3  | Stamp Step 3  | 500  | **333** |
| 38 | 180036 | 6  | Stamp Step 6  | 800  | **533** |
| 41 | 180039 | 9  | Stamp Step 9  | 1200 | **800** |
| 44 | 180042 | 12 | Stamp Step 12 | 1800 | **1200** |
| 46 | 180044 | 14 | Stamp Step 14 | 3000 | **2000** |

---

## 미수정 항목 (정책 준수)

| 대상 | 이유 |
|------|------|
| `reward_item_key != 'currency_gold'` 인 행 (booster, ticket 등) | PM 승인 목록 외 — 골드 보상만 대상 |

---

## Original Data 백업

**백업 위치:** O열~Q열 (시트 마지막 데이터 열 N 기준 → 빈 열 없이 O 시작)

| 열 | 내용 |
|----|------|
| O1 | `Backup: gold ratio 60%→40%` |
| O2 | `key_number` |
| P2 | `original_reward_amount` |
| Q2 | `new_reward_amount` |
| O3:Q26 | 24개 수정 행 원본/수정값 전체 기록 |

---

## 하이라이트

- **색상:** 노란색 (Yellow) `{red: 1.0, green: 0.95, blue: 0.6}`
- **적용 셀:** H열 수정 24개 셀 전체
- **방법:** Sheets API batchUpdate repeatCell

---

## 검증 결과

| 확인 항목 | 기대값 | 결과 |
|---|---|---|
| H3 (Midnight Step 1) | 133 | ✅ |
| H4 (Midnight Step 2) | 267 | ✅ |
| H6 (Midnight Step 4) | 400 | ✅ |
| H7 (Midnight Step 5) | 533 | ✅ |
| H9 (Midnight Step 7) | 667 | ✅ |
| H10 (Midnight Step 8) | 800 | ✅ |
| 백업 O1 | `Backup: gold ratio 60%→40%` | ✅ |
| 백업 O3:P3 | 180001 / 200 | ✅ |
| 하이라이트 replies | 24개 | ✅ |

**총 수정 셀: 24개 (H열) — 전체 검증 통과**

---

---
agent: 07_sheet_modifier
mode: sheet-modify
scope: meta_city_list + meta_decoration_list + string_code (Barcelona/Istanbul 신규 도시)
executed: 2026-03-11T04:58:50+00:00
status: complete
approved_by: pm (via 08_content_team handoff)
revision: 4
items_modified: 14
items_skipped: 0
---

# 시트 수정 완료 보고 (Revision 4)

## 수정 대상 시트

**Spreadsheet:** `1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk`
**시트명:** `meta_city_list`, `meta_decoration_list`, `string_code`

---

## 변경 내역

### 1. `meta_city_list` — 신규 2행 추가

| 시트 행 | key_number | city_id | prev_city_id | reward_1_type | reward_1_amount | reward_2_type | reward_2_amount | reward_3_type | reward_3_amount |
|---------|------------|---------|-------------|--------------|----------------|--------------|----------------|--------------|----------------|
| 19 | 60017 | city_name_barcelona | 60016 | currency_gold | 14000 | infinite_ticket_15m | 1 | booster_golden_ticket | 3 |
| 20 | 60018 | city_name_istanbul  | 60017 | currency_gold | 14000 | infinite_ticket_15m | 1 | booster_golden_ticket | 3 |

### 2. `meta_decoration_list` — 신규 10행 추가

| 시트 행 | key_number | city_id | sort_order | name_key | cost_hammer1 | cost_hammer2 | cost_gold_var2 | upgrade_max |
|---------|------------|---------|-----------|---------|-------------|-------------|--------------|------------|
| 83 | 70081 | city_name_barcelona | 1 | deco_barcelona_sagrada_familia  |  5 |  5 |  4900 | 2 |
| 84 | 70082 | city_name_barcelona | 2 | deco_barcelona_park_guell       | 10 | 10 |  7700 | 2 |
| 85 | 70083 | city_name_barcelona | 3 | deco_barcelona_camp_nou         | 16 | 16 | 11500 | 2 |
| 86 | 70084 | city_name_barcelona | 4 | deco_barcelona_gothic_quarter   | 27 | 27 | 17300 | 2 |
| 87 | 70085 | city_name_barcelona | 5 | deco_barcelona_casa_batllo      | 37 | 37 | 24100 | 2 |
| 88 | 70086 | city_name_istanbul  | 1 | deco_istanbul_hagia_sophia      |  5 |  5 |  4900 | 2 |
| 89 | 70087 | city_name_istanbul  | 2 | deco_istanbul_blue_mosque       | 10 | 10 |  7700 | 2 |
| 90 | 70088 | city_name_istanbul  | 3 | deco_istanbul_grand_bazaar      | 16 | 16 | 11500 | 2 |
| 91 | 70089 | city_name_istanbul  | 4 | deco_istanbul_topkapi_palace    | 27 | 27 | 17300 | 2 |
| 92 | 70090 | city_name_istanbul  | 5 | deco_istanbul_bosphorus_bridge  | 37 | 37 | 24100 | 2 |

**합계 검증:** Barcelona 해머 190개, 골드 65,500g / Istanbul 해머 190개, 골드 65,500g

### 3. `string_code` — 신규 2행 추가 (T_CITY_NAME_16 직후)

| 시트 행 | Key | en (골드보상) | ar | es | pt | id | ru | fr | th | ko |
|---------|-----|-------------|----|----|----|----|----|----|----|----|
| 82 | T_CITY_NAME_17 | 14000 | برشلونة | Barcelona | Barcelona | Barcelona | Барселона | Barcelone | บาร์เซโลนา | 바르셀로나 |
| 83 | T_CITY_NAME_18 | 14000 | إسطنبول | Estambul  | Istambul  | Istanbul  | Стамбул   | Istanbul  | อิสตันบูล  | 이스탄불 |

---

## 미수정 항목 (정책 준수)

| 시트 | 이유 |
|------|------|
| `unlock` | 도시 언락은 `meta_city_list.prev_city_id`로 관리 — unlock 시트 추가 불필요 |
| 데코 `string_code` 행 | 엔진 내부 localization bundle에서 처리 — 기존 데코도 시트에 없음 |

---

## 하이라이트

- **색상:** 연두색 (Light Green) `{red: 0.85, green: 0.93, blue: 0.83}`
- `meta_city_list` 행 19-20 (13열 × 2행 = 26셀)
- `meta_decoration_list` 행 83-92 (16열 × 10행 = 160셀)
- `string_code` 행 82-83 (10열 × 2행 = 20셀)

---

## 검증 결과

| 확인 항목 | 기대값 | 실제값 | 결과 |
|---|---|---|---|
| meta_city_list 행 19 key_number | 60017 | 60017 | ✅ |
| meta_city_list 행 20 key_number | 60018 | 60018 | ✅ |
| meta_city_list 행 19 reward_1_amount | 14000 | 14000 | ✅ |
| meta_city_list 행 20 reward_1_amount | 14000 | 14000 | ✅ |
| meta_city_list 행 19 prev_city_id | 60016 | 60016 | ✅ |
| meta_city_list 행 20 prev_city_id | 60017 | 60017 | ✅ |
| meta_decoration_list 행 83 key_number | 70081 | 70081 | ✅ |
| meta_decoration_list 행 92 key_number | 70090 | 70090 | ✅ |
| meta_decoration_list 행 83 cost_gold_var2 | 4900 | 4900 | ✅ |
| meta_decoration_list 행 92 cost_gold_var2 | 24100 | 24100 | ✅ |
| string_code 행 82 Key | T_CITY_NAME_17 | T_CITY_NAME_17 | ✅ |
| string_code 행 83 Key | T_CITY_NAME_18 | T_CITY_NAME_18 | ✅ |
| string_code 행 82 en | 14000 | 14000 | ✅ |
| string_code 행 83 en | 14000 | 14000 | ✅ |
| string_code 행 82 ko | 바르셀로나 | 바르셀로나 | ✅ |
| string_code 행 83 ko | 이스탄불 | 이스탄불 | ✅ |
| 중복 key 없음 (60017, 60018, 70081~70090, T_CITY_NAME_17/18) | 없음 | 없음 | ✅ |
| 하이라이트 적용 | 3개 시트 | 3개 시트 | ✅ |

**총 신규 행: 14행 (city 2 + deco 10 + string 2) — 전체 검증 통과**

---

---
agent: 07_sheet_modifier
mode: sheet-modify
scope: meta_decoration_list Barcelona/Istanbul 비용 조정 (조정안 B)
executed: 2026-03-11T05:29:46+00:00
status: complete
approved_by: pm (03_game_balance 검증 기반)
revision: 5
items_modified: 30
items_skipped: 0
---

# 시트 수정 완료 보고 (Revision 5)

## 수정 대상 시트

**Spreadsheet:** `1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk`
**시트명:** `meta_decoration_list` (gid: 680706612)

---

## 수정 개요

**대상:** Barcelona (key 70081~70085) 및 Istanbul (key 70086~70090)
**승인된 변경:** 조정안 B — hammer1/hammer2 및 cost_gold_var2 일괄 하향
**수정 컬럼:** `cost_hammer1` (E열), `cost_hammer2` (F열), `cost_gold_var2` (K열)
**gold_var1 = 0 유지** (수정 없음)

---

## 변경 내역

| key | sort | 도시 | hammer1 (전→후) | hammer2 (전→후) | gold_var2 (전→후) |
|-----|------|------|----------------|----------------|-----------------|
| 70081 | 1 | Barcelona | 5 → **4** | 5 → **4** | 4,900 → **3,000** |
| 70082 | 2 | Barcelona | 10 → **6** | 10 → **6** | 7,700 → **4,800** |
| 70083 | 3 | Barcelona | 16 → **10** | 16 → **10** | 11,500 → **7,200** |
| 70084 | 4 | Barcelona | 27 → **15** | 27 → **15** | 17,300 → **10,800** |
| 70085 | 5 | Barcelona | 37 → **20** | 37 → **20** | 24,100 → **15,000** |
| 70086 | 1 | Istanbul | 5 → **4** | 5 → **4** | 4,900 → **3,000** |
| 70087 | 2 | Istanbul | 10 → **6** | 10 → **6** | 7,700 → **4,800** |
| 70088 | 3 | Istanbul | 16 → **10** | 16 → **10** | 11,500 → **7,200** |
| 70089 | 4 | Istanbul | 27 → **15** | 27 → **15** | 17,300 → **10,800** |
| 70090 | 5 | Istanbul | 37 → **20** | 37 → **20** | 24,100 → **15,000** |

**도시별 합계 변화:**

| 항목 | 수정 전 | 수정 후 | 감소율 |
|------|---------|---------|--------|
| 총 해머 (도시당) | 190개 | **110개** | -42.1% |
| 총 골드 (도시당) | 65,500g | **40,800g** | -37.7% |

---

## Original Data 백업

**백업 위치:** `meta_decoration_list` 시트 R열~T열
- R1: `Parameter` / S1: `Original` / T1: `Updated`
- R2:T31 — 30개 파라미터 (key × 3컬럼) 원본/수정값 전체 기록

백업 확인 완료 (31행 × 3열, 헤더 포함).

---

## 하이라이트

- **색상:** 노란색 (Yellow) `{red: 1.0, green: 0.95, blue: 0.6}` — 수치 감소 표시
- **적용 셀:** E열, F열, K열 × 10행 = **30셀**
- **방법:** Sheets API batchUpdate repeatCell

---

## 검증 결과

| key | sort | cost_hammer1 (기대값) | 실제값 | cost_hammer2 (기대값) | 실제값 | cost_gold_var2 (기대값) | 실제값 | 결과 |
|-----|------|----------------------|--------|----------------------|--------|------------------------|--------|------|
| 70081 | 1 | 4 | 4 | 4 | 4 | 3,000 | 3,000 | ✅ |
| 70082 | 2 | 6 | 6 | 6 | 6 | 4,800 | 4,800 | ✅ |
| 70083 | 3 | 10 | 10 | 10 | 10 | 7,200 | 7,200 | ✅ |
| 70084 | 4 | 15 | 15 | 15 | 15 | 10,800 | 10,800 | ✅ |
| 70085 | 5 | 20 | 20 | 20 | 20 | 15,000 | 15,000 | ✅ |
| 70086 | 1 | 4 | 4 | 4 | 4 | 3,000 | 3,000 | ✅ |
| 70087 | 2 | 6 | 6 | 6 | 6 | 4,800 | 4,800 | ✅ |
| 70088 | 3 | 10 | 10 | 10 | 10 | 7,200 | 7,200 | ✅ |
| 70089 | 4 | 15 | 15 | 15 | 15 | 10,800 | 10,800 | ✅ |
| 70090 | 5 | 20 | 20 | 20 | 20 | 15,000 | 15,000 | ✅ |

| 확인 항목 | 기대값 | 결과 |
|---|---|---|
| cost_gold_var1 (전 항목) | 0 유지 | ✅ (미수정) |
| 백업 R1 헤더 | `Parameter` | ✅ |
| 백업 데이터 행 수 | 30행 | ✅ |
| 하이라이트 replies | 30개 | ✅ |
| PM 승인 범위 외 수정 | 없음 | ✅ |

**총 수정 셀: 30개 (E×10 + F×10 + K×10) — 전체 검증 통과**

---

---
agent: 07_sheet_modifier
mode: sheet-modify
scope: meta_city_list + meta_decoration_list + string_code (Athens & Prague G8 신규 도시)
executed: 2026-03-11T06:50:00+00:00
status: complete
approved_by: pm (via 08_content_team handoff)
revision: 6
items_modified: 14
items_skipped: 0
---

# 시트 수정 완료 보고 (Revision 6)

## 수정 대상 시트

**Spreadsheet:** `1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk`
**시트명:** `meta_city_list`, `meta_decoration_list`, `string_code`

---

## 변경 내역

### 1. `meta_city_list` — 신규 2행 추가 (행 21-22)

| 시트 행 | key_number | city_id | prev_city_id | reward_1_type | reward_1_amount | reward_2_type | reward_2_amount | reward_3_type | reward_3_amount |
|---------|------------|---------|-------------|--------------|----------------|--------------|----------------|--------------|----------------|
| 21 | 60019 | city_name_athens | 60018 | currency_gold | 14000 | infinite_ticket_15m | 1 | booster_golden_ticket | 3 |
| 22 | 60020 | city_name_prague | 60019 | currency_gold | 14000 | infinite_ticket_15m | 1 | booster_golden_ticket | 3 |

old_reward 백업 컬럼(11~13): 14000 / 1 / 3 (G7 Istanbul 동일 패턴)

### 2. `meta_decoration_list` — 신규 10행 추가 (행 93-102)

| 시트 행 | key_number | city_id | sort_order | name_key | cost_hammer1 | cost_hammer2 | cost_gold_var2 | upgrade_max |
|---------|------------|---------|-----------|---------|-------------|-------------|--------------|------------|
| 93  | 70091 | city_name_athens | 1 | deco_athens_parthenon            |  5 |  5 |  3600 | 2 |
| 94  | 70092 | city_name_athens | 2 | deco_athens_acropolis            |  7 |  7 |  5800 | 2 |
| 95  | 70093 | city_name_athens | 3 | deco_athens_plaka_district       | 12 | 12 |  8600 | 2 |
| 96  | 70094 | city_name_athens | 4 | deco_athens_panathenaic_stadium  | 18 | 18 | 13000 | 2 |
| 97  | 70095 | city_name_athens | 5 | deco_athens_cape_sounion         | 25 | 25 | 18000 | 2 |
| 98  | 70096 | city_name_prague | 1 | deco_prague_charles_bridge       |  5 |  5 |  3600 | 2 |
| 99  | 70097 | city_name_prague | 2 | deco_prague_old_town_square      |  7 |  7 |  5800 | 2 |
| 100 | 70098 | city_name_prague | 3 | deco_prague_prague_castle        | 12 | 12 |  8600 | 2 |
| 101 | 70099 | city_name_prague | 4 | deco_prague_astronomical_clock   | 18 | 18 | 13000 | 2 |
| 102 | 70100 | city_name_prague | 5 | deco_prague_wenceslas_square     | 25 | 25 | 18000 | 2 |

해머 패턴: [5, 7, 12, 18, 25] / 골드 패턴: [3600, 5800, 8600, 13000, 18000] (02 에이전트 확정값)
도시별 합계: 해머 67개, 골드 49000g

### 3. `string_code` — 신규 2행 추가 (행 84-85, T_CITY_NAME_18 직후)

| 시트 행 | Key | en (골드보상) | ar | es | pt | id | ru | fr | th | ko |
|---------|-----|-------------|----|----|----|----|----|----|----|----|
| 84 | T_CITY_NAME_19 | 14000 | أثينا | Atenas | Atenas | Athena | Афины | Athènes | เอเธนส์ | 아테네 |
| 85 | T_CITY_NAME_20 | 14000 | براغ  | Praga  | Praga  | Praha  | Прага  | Prague  | ปราก    | 프라하 |

기존 T_TODAY_GIFT_TITLE(행 84→86) 및 이후 행은 1행 삽입으로 자동 하향 이동 후 복원 완료.

---

## 미수정 항목 (정책 준수)

| 시트 | 항목 | 이유 |
|------|------|------|
| `unlock` | - | 도시 언락은 `meta_city_list.prev_city_id`로 관리 — 별도 시트 불필요 |
| `string_code` | 데코 name_key 10개 | G7 Barcelona/Istanbul 동일 정책 — 미등록 유지 |

---

## 하이라이트

- **색상:** 연두색 (Light Green) `{red: 0.85, green: 0.93, blue: 0.83}` — 신규 추가 표시
- `meta_city_list` 행 21-22 (A:S 범위, 19열 × 2행 = 38셀)
- `meta_decoration_list` 행 93-102 (A:P 범위, 16열 × 10행 = 160셀)
- `string_code` 행 84-85 (A:J 범위, 10열 × 2행 = 20셀)

---

## 검증 결과

| 확인 항목 | 기대값 | 실제값 | 결과 |
|---|---|---|---|
| meta_city_list 행 21 key_number | 60019 | 60019 | ✅ |
| meta_city_list 행 22 key_number | 60020 | 60020 | ✅ |
| meta_city_list 행 21 city_id | city_name_athens | city_name_athens | ✅ |
| meta_city_list 행 22 city_id | city_name_prague | city_name_prague | ✅ |
| meta_city_list 행 21 prev_city_id | 60018 | 60018 | ✅ |
| meta_city_list 행 22 prev_city_id | 60019 | 60019 | ✅ |
| meta_city_list 행 21 reward_1_amount | 14000 | 14000 | ✅ |
| meta_decoration_list 행 93 key_number | 70091 | 70091 | ✅ |
| meta_decoration_list 행 102 key_number | 70100 | 70100 | ✅ |
| meta_decoration_list 행 93 cost_gold_var2 | 3600 | 3600 | ✅ |
| meta_decoration_list 행 102 cost_gold_var2 | 18000 | 18000 | ✅ |
| string_code 행 84 Key | T_CITY_NAME_19 | T_CITY_NAME_19 | ✅ |
| string_code 행 85 Key | T_CITY_NAME_20 | T_CITY_NAME_20 | ✅ |
| string_code 행 84 ko | 아테네 | 아테네 | ✅ |
| string_code 행 85 ko | 프라하 | 프라하 | ✅ |
| string_code 행 86 Key (기존 T_TODAY_GIFT_TITLE 복원) | T_TODAY_GIFT_TITLE | T_TODAY_GIFT_TITLE | ✅ |
| 중복 key 없음 (60019, 60020, 70091~70100, T_CITY_NAME_19/20) | 없음 | 없음 | ✅ |
| 하이라이트 적용 | 3개 시트 | 3개 시트 | ✅ |

**총 신규 행: 14행 (city 2 + deco 10 + string 2) — 전체 검증 통과**

---

---

## Revision 7 — 2026-03-11

**작업**: [C] G8 reward_1_amount 상향 + [E] is_ad_var 타입 통일 + COST_HAMMER 재검증

### [C] G8 reward_1_amount 수정

**산출 근거**:
- G6(Sydney/Rio): 12,500
- G7(Barcelona/Istanbul): 14,000
- G6→G7 증가율: 14,000 / 12,500 = 1.12 (+12%)
- G8 raw: 14,000 × 1.12 = 15,680
- 500단위 반올림: 15,500

| 시트 | 셀 | 항목 | 변경 전 | 변경 후 | 비고 |
|------|-----|------|--------|--------|------|
| meta_city_list | E21 | Athens(60019) reward_1_amount | 14,000 | 15,500 | 연두색 하이라이트 |
| meta_city_list | E22 | Prague(60020) reward_1_amount | 14,000 | 15,500 | 연두색 하이라이트 |

### [E] is_ad_var 타입 통일

| 시트 | 범위 | 항목 | 변경 전 | 변경 후 | 영향 행수 |
|------|------|------|--------|--------|---------|
| meta_decoration_list | P3:P102 | is_ad_var | 'False'/'FALSE' (string) | FALSE (boolean) | 100행 |

- G1~G7 (70001~70090): 'False' 문자열 → boolean FALSE (90행)
- G8 Athens/Prague (70091~70100): 'FALSE' 문자열 → boolean FALSE (10행)
- 하늘색 하이라이트 적용 (P3:P102)

### COST_HAMMER 재검증 결과

| 검증 항목 | 기대값 | 실제값 | 판정 |
|----------|--------|--------|------|
| 70091 hammer1 | 5 | 5 | OK |
| 70092 hammer1 | 7 | 7 | OK |
| 70093 hammer1 | 12 | 12 | OK |
| 70094 hammer1 | 18 | 18 | OK |
| 70095 hammer1 | 25 | 25 | OK |
| hammer1 == hammer2 (전 행, G8 10행) | 동일 | 동일 | OK |
| 슬롯 단조 증가 (Athens) | 5<7<12<18<25 | [5,7,12,18,25] | OK |
| 슬롯 단조 증가 (Prague) | 5<7<12<18<25 | [5,7,12,18,25] | OK |

Prague(70096~70100)도 Athens와 동일 패턴 확인. 이상 없음.

### 메타 Sink 변동 여부

해머 비용 변경 없음 → 메타 Sink 92.3일 유지 (변동 없음).
reward_1_amount 상향(14,000→15,500)은 골드 Source 증가 요인이나,
전체 Sink 대비 미미 (G8 도시 2개, 1회성 보상).

---

---
agent: 01_pm
mode: sheet_modify
scope: dynamic_level + const — 안 B (85/10/5) 적용
executed: 2026-03-12T10:35:23+09:00
status: complete
verdict: Go
---

# 시트 수정 로그 — 안 B (Normal 85% / Hard 10% / SH 5%)

## 수정 근거

Monte Carlo 시뮬레이션 (n=190,000, 플레이어 1,000명 × 200레벨) 결과
현행 파라미터가 목표 분포 달성 불가함을 확인 후 안 B 적용.

| | Normal | Hard | SH | 오차 |
|---|---|---|---|---|
| 적용 전 | 91.7% | 2.5% | 5.7% | 77.4 |
| 적용 후 (시뮬레이션) | **85.1%** | **10.0%** | **5.0%** | **0.1** |
| 목표 | 85% | 10% | 5% | — |

---

## 변경 내역

### dynamic_level 시트

| key | condition_type | 항목 | 변경 전 | 변경 후 | 색상 |
|---|---|---|---|---|---|
| 30004 | hard_cooldown | param_1 | 5 | **3** | 🟡 노란색(감소) |
| 30005 | win_streak | param_1 | 7 | **99** | 🔵 하늘색(구조변경/비활성화) |
| 30006 | super_hard_guarantee | param_1 | 30 | **18** | 🟡 노란색(감소) |
| 30007 | hard_guarantee | param_1 | 15 | **7** | 🟡 노란색(감소) |

### const 시트

| key | const_name | 변경 전 | 변경 후 | 색상 |
|---|---|---|---|---|
| 10021 | gimmick_ceiling_min | 2 | **4** | 🟢 연두색(증가) |
| 10022 | difficulty_rest_count | 2 | **0** | 🟡 노란색(감소) |

---

## PM 절차 준수 확인

| 절차 | 상태 |
|---|---|
| ① 원본 백업 | ✅ dynamic_level col J-L, const col W-Y — Parameter/Original/Updated 3열 기록 |
| ② 하이라이트 | ✅ 수정 셀 전체 색상 적용 (노란색×4, 하늘색×1, 연두색×1) |
| ③ 숫자 포맷 | ✅ 전체 numberValue(int) 저장, apostrophe 없음 |

## 검증 결과 (라이브 시트 재확인)

| 항목 | 적용값 | 결과 |
|---|---|---|
| 30004 hard_cooldown param_1 | 3 | ✅ |
| 30005 win_streak param_1 | 99 | ✅ |
| 30006 super_hard_guarantee param_1 | 18 | ✅ |
| 30007 hard_guarantee param_1 | 7 | ✅ |
| 10021 gimmick_ceiling_min | 4 | ✅ |
| 10022 difficulty_rest_count | 0 | ✅ |

---

---
agent: 07_sheet_modifier
mode: sheet-modify
scope: daily_wheel + daily_gift + event_milestone + collection_album_milestone + daily_task_milestone + event_ranking (보상 재배정)
executed: 2026-03-12T05:02:00+00:00
status: complete
approved_by: pm
revision: 8
items_modified: 40
items_skipped: 0
typo_fixed: 2
---

# 시트 수정 완료 보고 (Revision 8)

## 수정 대상 시트

**Spreadsheet:** `1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk`
**시트명:** `daily_wheel`, `daily_gift`, `event_milestone`, `collection_album_milestone`, `daily_task_milestone`, `event_ranking`

---

## 변경 내역 요약

| 시트 | 수정 건수 | 오타 수정 | 상태 |
|---|---|---|---|
| daily_wheel | 7 | 0 | ✅ |
| daily_gift | 3 | 0 | ✅ |
| event_milestone | 13 | 0 | ✅ |
| collection_album_milestone | 8 | 2 | ✅ |
| daily_task_milestone | 1 | 0 | ✅ |
| event_ranking | 8 | 0 | ✅ |
| **합계** | **40** | **2** | ✅ |

---

## 1. daily_wheel (7건)

| key | 컬럼 | 변경 전 | 변경 후 | 색상 |
|---|---|---|---|---|
| 140002 | gacha_rate | 2500 | 2000 | 노란색 |
| 140007 | reward_item_key | currency_gold | booster_extra_deck | 하늘색 |
| 140007 | reward_amount | 6000 | 1 | 노란색 |
| 140007 | gacha_rate | 300 | 600 | 연두색 |
| 140008 | reward_item_key | currency_ticket | booster_golden_ticket | 하늘색 |
| 140008 | reward_amount | 3 | 1 | 노란색 |
| 140008 | gacha_rate | 100 | 300 | 연두색 |

**gacha_rate 합계 검증:** 10,000 ✅ (변경 전후 동일)
백업 위치: H~J열 (G열 공백)

---

## 2. daily_gift (3건)

| key | 컬럼 | 변경 전 | 변경 후 | 색상 |
|---|---|---|---|---|
| 150004 (day3) | reward_amount_1 | 2 | 1 | 노란색 |
| 150006 (day5) | reward_item_key_1 | booster_wild_card | booster_extra_deck | 하늘색 |
| 150007 (day6) | reward_item_key_2 | booster_fireworks | booster_golden_ticket | 하늘색 |

백업 위치: N~P열 (M열 공백)

---

## 3. event_milestone (13건)

| key | 컬럼 | 변경 전 | 변경 후 | 색상 |
|---|---|---|---|---|
| 180006 | reward_item_key | booster_undo | booster_fireworks | 하늘색 |
| 180006 | reward_amount | 2 | 1 | 노란색 |
| 180009 | reward_item_key | booster_undo | booster_wild_card | 하늘색 |
| 180009 | reward_amount | 3 | 1 | 노란색 |
| 180011 | reward_item_key | currency_ticket | booster_extra_deck | 하늘색 |
| 180013 | reward_item_key | booster_undo | booster_golden_ticket | 하늘색 |
| 180013 | reward_amount | 5 | 1 | 노란색 |
| 180021 | reward_item_key | booster_fireworks | booster_undo | 하늘색 |
| 180026 | reward_item_key | booster_fireworks | booster_extra_deck | 하늘색 |
| 180026 | reward_amount | 2 | 1 | 노란색 |
| 180037 | reward_item_key | booster_golden_ticket | booster_extra_deck | 하늘색 |
| 180043 | reward_item_key | booster_golden_ticket | booster_fireworks | 하늘색 |
| 180043 | reward_amount | 1 | 2 | 연두색 |

백업 위치: S~U열 (R열 공백, 기존 O~Q 별도 사용 중)

---

## 4. collection_album_milestone (8건, 오타 2건 포함)

| key | pts | 컬럼 | 변경 전 | 변경 후 | 색상 | 비고 |
|---|---|---|---|---|---|---|
| 110003 | 50 | reward_amount | 1000 | 2000 | 연두색 | |
| 110007 | 230 | reward_amount | 2000 | 3000 | 연두색 | |
| 110010 | 470 | reward_item_key | infinite_ticket_5m | booster_golden_ticket | 하늘색 | |
| 110011 | 570 | reward_amount | 3000 | 5000 | 연두색 | |
| 110012 | 680 | reward_amount | 2 | 2000 | 연두색 | 오타 수정 |
| 110013 | 800 | reward_item_key | infinite_ticket_10m | infinite_fireworks_5m | 하늘색 | |
| 110015 | 1070 | reward_item_key | infinite_ticket_10m | infinite_gticket_5m | 하늘색 | |
| 110016 | 1250 | reward_amount | 5000 | 3 | 노란색 | 오타 수정 |

백업 위치: H~J열 (G열 공백)

---

## 5. daily_task_milestone (1건)

| key | 컬럼 | 변경 전 | 변경 후 | 색상 |
|---|---|---|---|---|
| 130002 (stage2) | reward_item_key | booster_undo | booster_fireworks | 하늘색 |

백업 위치: I~K열 (H열 공백)

---

## 6. event_ranking (8건)

| key | 컬럼 | 변경 전 | 변경 후 | 색상 |
|---|---|---|---|---|
| 170001 (rank1) | reward_item_key_1 | booster_golden_ticket | infinite_gticket_10m | 하늘색 |
| 170001 (rank1) | reward_amount_1 | 3 | 1 | 노란색 |
| 170001 (rank1) | reward_amount_2 (gold) | 5000 | 8000 | 연두색 |
| 170002 (rank2) | reward_amount_2 (gold) | 3000 | 4000 | 연두색 |
| 170003 (rank3) | reward_item_key_3 | currency_ticket | booster_extra_deck | 하늘색 |
| 170003 (rank3) | reward_amount_3 | 1 | 1 | (키만 변경, 수량 불변) |
| 170004 (rank4-6) | reward_amount_1 (gold) | 1000 | 1500 | 연두색 |
| 170004 (rank4-6) | reward_item_key_2 | booster_undo | booster_fireworks | 하늘색 |

백업 위치: P~R열 (O열 공백)

---

## PM 절차 준수 확인

| 절차 | 상태 |
|---|---|
| ① 원본 백업 | ✅ 6개 시트 전체 — 데이터 끝 열 + 빈 열 1개 + Parameter/Original/Updated 3열 구조 기록 |
| ② 하이라이트 | ✅ 수정 셀 전체 색상 적용 (연두/노란/하늘 규칙 준수) |
| ③ 숫자 포맷 | ✅ 전체 numberValue(int) 저장, apostrophe 없음 |

## 최종 검증 결과

| 시트 | 확인 항목 | 결과 |
|---|---|---|
| daily_wheel | gacha_rate 합계 = 10,000 | ✅ |
| daily_wheel | 140007 item=booster_extra_deck, rate=600 | ✅ |
| daily_wheel | 140008 item=booster_golden_ticket, rate=300 | ✅ |
| daily_gift | 150004 amount=1 | ✅ |
| daily_gift | 150006 item=booster_extra_deck | ✅ |
| daily_gift | 150007 r2_key=booster_golden_ticket | ✅ |
| event_milestone | 180006 item=booster_fireworks, amt=1 | ✅ |
| event_milestone | 180043 item=booster_fireworks, amt=2 | ✅ |
| collection_album_milestone | 110012 amount=2000 (오타수정) | ✅ |
| collection_album_milestone | 110016 amount=3 (오타수정) | ✅ |
| daily_task_milestone | 130002 item=booster_fireworks | ✅ |
| event_ranking | 170001 r1=infinite_gticket_10m, gold=8000 | ✅ |
| event_ranking | 170004 gold=1500, r2=booster_fireworks | ✅ |

**총 수정 셀: 40건 (오타 수정 2건 포함) — 전체 검증 통과**

---

---
agent: 07_sheet_modifier
mode: sheet-modify
scope: daily_task (보상 재설계 — currency_ticket 추가, booster 다양성 확보)
executed: 2026-03-12T05:40:00+00:00
status: complete
approved_by: pm
revision: 9
items_modified: 4
items_skipped: 0
---

# 시트 수정 완료 보고 (Revision 9)

## 수정 대상 시트

**Spreadsheet:** `1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk`
**시트명:** `daily_task`, `daily_task_milestone`

---

## 검수 결과

### daily_task 수정 전 보상 분포 (48개 태스크)

| 보상 아이템 | 수량 | 비율 |
|---|---|---|
| currency_gold | 43 | 89.6% |
| booster_fireworks | 4 | 8.3% |
| currency_ticket | 1 | 2.1% |

**문제점:**
1. currency_ticket 1개뿐 (120048 tournament difficulty=3만 해당) — 배분 불충분
2. booster가 fireworks 4개로 단일 종류 — 다양성 부족 (undo/wild_card 미포함)
3. difficulty=3 중 currency_gold 비율 과다

### daily_task_milestone 검수 결과

| step | req_point | reward_item_key | 판정 |
|---|---|---|---|
| 1 | 30 | currency_gold 1000 | ✅ 적절 |
| 2 | 50 | booster_fireworks 1 | ✅ 적절 (Revision 8에서 수정 완료) |
| 3 | 100 | currency_ticket 1 | ✅ 적절 |

milestone 추가 수정 불필요.

---

## 변경 내역 (daily_task — difficulty=3 보상 재배분)

| key | task_type | 변경 전 reward_item_key | 변경 후 reward_item_key | 변경 전 amount | 변경 후 amount | 색상 |
|---|---|---|---|---|---|---|
| 120027 | use_booster(undo) | booster_fireworks | **booster_undo** | 1 | 1 | 하늘색 |
| 120033 | use_booster(wild_card) | booster_fireworks | **booster_wild_card** | 1 | 1 | 하늘색 |
| 120036 | watch_ad (3회) | currency_gold | **currency_ticket** | 2000 | **1** | 하늘색(key), 노란색(amount) |

**설계 근거:**
- `use_booster(undo)` 태스크에서 fireworks 지급은 미스매치 — 사용한 부스터 종류와 동일한 보상이 자연스러움
- `use_booster(wild_card)` 동일 원칙 적용
- `watch_ad 3회` — 광고 3회 시청 달성에 currency_ticket(무료 입장권) 지급은 "광고로 입장권 획득" 연상 구조로 적합

---

## 수정 후 보상 분포

| 보상 아이템 | 수량 | 비율 |
|---|---|---|
| currency_gold | 42 | 87.5% |
| booster_fireworks | 2 | 4.2% |
| booster_undo | 1 | 2.1% |
| booster_wild_card | 1 | 2.1% |
| currency_ticket | 2 | 4.2% |

**검수 통과 항목:**
- currency_ticket: 2개 (watch_ad×3 + tournament create) ✓
- currency_gold: 전 난이도 포함 ✓
- booster 다양성: fireworks/undo/wild_card 3종류 ✓
- infinite: 없음 ✓
- 일일 낮은 가치 채널에 적합한 수량 (gold 500/1000/2000, booster 1개, ticket 1개) ✓

---

## Original Data 백업

**백업 위치:** `daily_task` 시트 O열~Q열 (M열 = 데이터 마지막, N열 = 빈 열, O열 시작)
- O2: `Parameter` / P2: `Original` / Q2: `Updated`

| Parameter | Original | Updated |
|---|---|---|
| 120027.reward_item_key | booster_fireworks | booster_undo |
| 120033.reward_item_key | booster_fireworks | booster_wild_card |
| 120036.reward_item_key | currency_gold | currency_ticket |
| 120036.reward_amount | 2000 | 1 |

---

## PM 절차 준수 확인

| 절차 | 상태 |
|---|---|
| ① 원본 백업 | ✅ daily_task O~Q열 — Parameter/Original/Updated 3열 기록 (해당 행에 인라인 기록) |
| ② 하이라이트 | ✅ 하늘색(구조변경) 3셀 + 노란색(감소) 1셀 |
| ③ 숫자 포맷 | ✅ reward_amount=1 → numberValue(int) 저장 |

## 검증 결과

| key | reward_item_key (기대값) | 실제값 | reward_amount (기대값) | 실제값 | 결과 |
|---|---|---|---|---|---|
| 120027 | booster_undo | booster_undo | 1 | 1 | ✅ |
| 120033 | booster_wild_card | booster_wild_card | 1 | 1 | ✅ |
| 120036 | currency_ticket | currency_ticket | 1 | 1 | ✅ |
| daily_task_milestone 130002 | booster_fireworks (기수정) | booster_fireworks | 1 | 1 | ✅ |
| daily_task_milestone 130003 | currency_ticket | currency_ticket | 1 | 1 | ✅ |

**총 수정 셀: 4셀 (reward_item_key 3개 + reward_amount 1개) — 전체 검증 통과**

---

---
agent: 07_sheet_modifier
mode: sheet-modify
scope: meta_city_list + collection_album_puzzle_list + daily_task (보상 비율 재검수 — gold 60% / non-gold 40% / infinite ≤5%)
executed: 2026-03-12T06:07:00+00:00
status: complete
approved_by: pm
revision: 10
items_modified: 119
items_skipped: 0
---

# 시트 수정 완료 보고 (Revision 10)

## 수정 대상 시트

**Spreadsheet:** `1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk`
**시트명:** `meta_city_list`, `collection_album_puzzle_list`, `daily_task`

---

## 작업 개요

3개 시트의 보상 분포를 아래 비율 기준으로 재배정.

| 유형 | 목표 비율 |
|---|---|
| currency_gold | 전체 슬롯의 60% |
| 나머지 아이템 전체 (booster + currency_ticket + infinite) | 전체 슬롯의 40% |
| infinite 아이템 | 전체 슬롯의 최대 5% (40% 내 포함) |

채널 성격 반영:
- `meta_city_list`: 메타 중간~높은 가치 → 5종 부스터 + currency_ticket + infinite(후반 3개 도시)
- `collection_album_puzzle_list`: 퍼즐 수집 장기 콘텐츠 → 단계별 가치 상승, infinite 최후반 1개
- `daily_task`: 일일 무료 낮은 가치 → booster 5종 + currency_ticket, infinite 없음

---

## 최종 비율 검증

| 시트 | 전체슬롯 | gold슬롯(%) | non-gold슬롯(%) | infinite슬롯(%) | 수정건수 | 상태 |
|---|---|---|---|---|---|---|
| meta_city_list | 60 | 36 (60.0%) | 24 (40.0%) | 3 (5.0%) | 62 | ✅ |
| collection_album_puzzle_list | 25 (active) | 15 (60.0%) | 10 (40.0%) | 1 (4.0%) | 31 | ✅ |
| daily_task | 48 | 29 (60.4%) | 19 (39.6%) | 0 (0.0%) | 26 | ✅ |

---

## 1. meta_city_list (62건)

### 변경 개요

- **reward_1** (20개): 모두 currency_gold — 변경 없음
- **reward_2** (20개): 기존 infinite 전종 → 도시 60001~60016은 currency_gold로 전환, 60017은 booster_golden_ticket, 60018~60020은 infinite 재배치
- **reward_3** (20개): booster 5종 + currency_ticket 균등 분배, 도시 진행에 따라 가치 상승

### reward_2 변경 내역

| city key | 도시 | 변경 전 type | 변경 후 type | 변경 전 amount | 변경 후 amount | 색상 |
|---|---|---|---|---|---|---|
| 60001 | New York | infinite_fireworks_5m | currency_gold | 1 | 1000 | 하늘색/연두색 |
| 60002 | Los Angeles | infinite_fireworks_10m | currency_gold | 1 | 1000 | 하늘색/연두색 |
| 60003 | San Francisco | infinite_fireworks_15m | currency_gold | 1 | 1500 | 하늘색/연두색 |
| 60004 | Las Vegas | infinite_fireworks_15m | currency_gold | 1 | 1500 | 하늘색/연두색 |
| 60005 | Chicago | infinite_fireworks_15m | currency_gold | 1 | 1500 | 하늘색/연두색 |
| 60006 | Miami | infinite_fireworks_15m | currency_gold | 1 | 2000 | 하늘색/연두색 |
| 60007 | Paris | infinite_gticket_5m | currency_gold | 1 | 2000 | 하늘색/연두색 |
| 60008 | London | infinite_gticket_10m | currency_gold | 1 | 2000 | 하늘색/연두색 |
| 60009 | Rome | infinite_gticket_15m | currency_gold | 1 | 2000 | 하늘색/연두색 |
| 60010 | Venice | infinite_gticket_15m | currency_gold | 1 | 2000 | 하늘색/연두색 |
| 60011 | Tokyo | infinite_gticket_15m | currency_gold | 1 | 2000 | 하늘색/연두색 |
| 60012 | Bangkok | infinite_ticket_10m | currency_gold | 1 | 2500 | 하늘색/연두색 |
| 60013 | Cairo | infinite_ticket_15m | currency_gold | 1 | 2500 | 하늘색/연두색 |
| 60014 | Dubai | infinite_ticket_15m | currency_gold | 1 | 2500 | 하늘색/연두색 |
| 60015 | Sydney | infinite_ticket_15m | currency_gold | 1 | 3000 | 하늘색/연두색 |
| 60016 | Rio | infinite_ticket_15m | currency_gold | 1 | 3000 | 하늘색/연두색 |
| 60017 | Barcelona | infinite_ticket_15m | booster_golden_ticket | 1 | 1 | 하늘색 |
| 60018 | Istanbul | infinite_ticket_15m | infinite_fireworks_15m | 1 | 1 | 하늘색 |
| 60019 | Athens | infinite_ticket_15m | infinite_gticket_15m | 1 | 1 | 하늘색 |
| 60020 | Prague | infinite_ticket_15m | infinite_ticket_15m | 1 | 1 | 무변경 |

### reward_3 변경 내역

| city key | 도시 | 변경 전 type | 변경 후 type | 변경 전 amount | 변경 후 amount | 색상 |
|---|---|---|---|---|---|---|
| 60001 | New York | booster_wild_card | booster_fireworks | 1 | 2 | 하늘색/연두색 |
| 60002 | Los Angeles | booster_wild_card | booster_fireworks | 1 | 2 | 하늘색/연두색 |
| 60003 | San Francisco | booster_wild_card | booster_undo | 2 | 2 | 하늘색 |
| 60004 | Las Vegas | booster_wild_card | booster_undo | 2 | 2 | 하늘색 |
| 60005 | Chicago | booster_fireworks | currency_ticket | 2 | 1 | 하늘색/노란색 |
| 60006 | Miami | booster_fireworks | booster_wild_card | 2 | 2 | 하늘색 |
| 60007 | Paris | booster_fireworks | booster_wild_card | 2 | 2 | 하늘색 |
| 60008 | London | booster_fireworks | booster_fireworks | 2 | 2 | 무변경 |
| 60009 | Rome | booster_fireworks | currency_ticket | 3 | 1 | 하늘색/노란색 |
| 60010 | Venice | booster_golden_ticket | booster_undo | 1 | 2 | 하늘색/연두색 |
| 60011 | Tokyo | booster_golden_ticket | booster_undo | 1 | 3 | 하늘색/연두색 |
| 60012 | Bangkok | booster_golden_ticket | booster_wild_card | 2 | 2 | 하늘색 |
| 60013 | Cairo | booster_golden_ticket | currency_ticket | 3 | 1 | 하늘색/노란색 |
| 60014 | Dubai | booster_golden_ticket | booster_golden_ticket | 3 | 2 | 노란색 |
| 60015 | Sydney | booster_golden_ticket | booster_golden_ticket | 3 | 2 | 노란색 |
| 60016 | Rio | booster_golden_ticket | booster_golden_ticket | 3 | 3 | 무변경 |
| 60017 | Barcelona | booster_golden_ticket | currency_ticket | 3 | 1 | 하늘색/노란색 |
| 60018 | Istanbul | booster_golden_ticket | booster_extra_deck | 3 | 2 | 하늘색/노란색 |
| 60019 | Athens | booster_golden_ticket | booster_extra_deck | 3 | 3 | 하늘색 |
| 60020 | Prague | booster_golden_ticket | booster_extra_deck | 3 | 3 | 하늘색 |

### 최종 보상 분포 (60 슬롯)

| 아이템 | 슬롯 수 | 비율 |
|---|---|---|
| currency_gold | 36 | 60.0% |
| booster_fireworks | 3 | 5.0% |
| booster_undo | 4 | 6.7% |
| booster_wild_card | 3 | 5.0% |
| booster_golden_ticket | 4 | 6.7% |
| booster_extra_deck | 3 | 5.0% |
| currency_ticket | 4 | 6.7% |
| infinite_fireworks_15m | 1 | 1.7% |
| infinite_gticket_15m | 1 | 1.7% |
| infinite_ticket_15m | 1 | 1.7% |

백업 위치: Y~AA열 (X열 공백)

---

## 2. collection_album_puzzle_list (31건)

### 변경 개요

reward_1은 항상 currency_gold 유지. reward_2~4를 재배정하여 gold 60%, non-gold 40% 달성.
초반 앨범(NY, Paris)은 gold 위주, 후반(Sydney)에 infinite 1개 배치.

### 변경 내역

| key | 도시 | 슬롯 | 변경 전 type | 변경 후 type | 변경 전 amount | 변경 후 amount | 색상 |
|---|---|---|---|---|---|---|---|
| 90001 | NY | r2 | booster_fireworks | currency_gold | 1 | 5000 | 하늘색/연두색 |
| 90002 | Paris | r2 | booster_fireworks | currency_gold | 2 | 7000 | 하늘색/연두색 |
| 90002 | Paris | r3 | booster_undo | currency_gold | 1 | 7000 | 하늘색/연두색 |
| 90003 | London | r2 | booster_fireworks | currency_gold | 1 | 10000 | 하늘색/연두색 |
| 90003 | London | r3 | booster_undo | booster_fireworks | 2 | 1 | 하늘색/노란색 |
| 90003 | London | r4 | infinite_ticket_5m | booster_undo | 2 | 1 | 하늘색/노란색 |
| 90004 | Venice | r2 | booster_fireworks | currency_gold | 1 | 10000 | 하늘색/연두색 |
| 90004 | Venice | r3 | booster_undo | booster_fireworks | 2 | 2 | 하늘색 |
| 90004 | Venice | r4 | infinite_ticket_5m | booster_undo | 2 | 2 | 하늘색 |
| 90005 | Cairo | r2 | booster_fireworks | currency_gold | 1 | 10000 | 하늘색/연두색 |
| 90005 | Cairo | r3 | booster_undo | booster_wild_card | 2 | 1 | 하늘색/노란색 |
| 90005 | Cairo | r4 | infinite_ticket_5m | currency_ticket | 2 | 1 | 하늘색/노란색 |
| 90006 | Tokyo | r2 | booster_fireworks | currency_gold | 1 | 10000 | 하늘색/연두색 |
| 90006 | Tokyo | r3 | booster_undo | booster_wild_card | 2 | 2 | 하늘색/노란색 |
| 90006 | Tokyo | r4 | infinite_ticket_5m | booster_golden_ticket | 2 | 1 | 하늘색/노란색 |
| 90007 | Sydney | r2 | booster_fireworks | currency_gold | 1 | 10000 | 하늘색/연두색 |
| 90007 | Sydney | r3 | booster_undo | booster_golden_ticket | 2 | 2 | 하늘색 |
| 90007 | Sydney | r4 | infinite_ticket_5m | infinite_ticket_5m | 2 | 1 | 노란색(amount) |

### 최종 보상 분포 (25 active 슬롯)

| 아이템 | 슬롯 수 | 비율 |
|---|---|---|
| currency_gold | 15 | 60.0% |
| booster_fireworks | 2 | 8.0% |
| booster_undo | 2 | 8.0% |
| booster_wild_card | 2 | 8.0% |
| booster_golden_ticket | 2 | 8.0% |
| currency_ticket | 1 | 4.0% |
| infinite_ticket_5m | 1 | 4.0% |

백업 위치: R~T열 (Q열 공백)

---

## 3. daily_task (26건)

### 변경 개요

기존 gold 42개(87.5%) → 29개(60.4%)로 축소. difficulty=3 전체를 non-gold로 전환,
일부 difficulty=2 rows에도 booster 배정. infinite는 채널 성격상 배제.

### 변경 내역

| key | diff | task_type | 변경 전 item | 변경 후 item | 변경 전 amount | 변경 후 amount | 색상 |
|---|---|---|---|---|---|---|---|
| 120003 | 3 | play_level | currency_gold | booster_fireworks | 2000 | 1 | 하늘색/노란색 |
| 120006 | 3 | win_level | currency_gold | booster_fireworks | 2000 | 1 | 하늘색/노란색 |
| 120009 | 3 | clear_card | currency_gold | booster_undo | 2000 | 1 | 하늘색/노란색 |
| 120012 | 3 | clear_color(red) | currency_gold | booster_undo | 2000 | 1 | 하늘색/노란색 |
| 120015 | 3 | clear_color(black) | currency_gold | booster_undo | 2000 | 1 | 하늘색/노란색 |
| 120018 | 3 | get_streak | currency_gold | booster_wild_card | 2000 | 1 | 하늘색/노란색 |
| 120023 | 2 | match_card | currency_gold | booster_wild_card | 1000 | 1 | 하늘색/노란색 |
| 120024 | 3 | match_card | currency_gold | booster_wild_card | 2000 | 1 | 하늘색/노란색 |
| 120039 | 3 | send_gift | currency_gold | booster_golden_ticket | 2000 | 1 | 하늘색/노란색 |
| 120042 | 3 | share_feed | currency_gold | booster_golden_ticket | 2000 | 1 | 하늘색/노란색 |
| 120044 | 2 | invite_friend | currency_gold | booster_extra_deck | 1000 | 1 | 하늘색/노란색 |
| 120045 | 3 | invite_friend | currency_gold | booster_extra_deck | 2000 | 1 | 하늘색/노란색 |
| 120047 | 2 | tournament | currency_gold | currency_ticket | 1000 | 1 | 하늘색/노란색 |

### 최종 보상 분포 (48 슬롯)

| 아이템 | 슬롯 수 | 비율 |
|---|---|---|
| currency_gold | 29 | 60.4% |
| booster_fireworks | 4 | 8.3% |
| booster_undo | 4 | 8.3% |
| booster_wild_card | 4 | 8.3% |
| booster_golden_ticket | 2 | 4.2% |
| booster_extra_deck | 2 | 4.2% |
| currency_ticket | 3 | 6.2% |
| infinite | 0 | 0.0% |

백업 위치: S~U열 (R열 공백, 기존 O~Q 별도 사용 중)

---

## PM 절차 준수 확인

| 절차 | 상태 |
|---|---|
| ① 원본 백업 | ✅ 3개 시트 전체 — 데이터 끝 열 + 빈 열 1개 + Parameter/Original/Updated 3열 구조 기록 |
| ② 하이라이트 | ✅ 수정 셀 전체 색상 적용 (연두/노란/하늘 규칙 준수) |
| ③ 숫자 포맷 | ✅ 전체 numberValue(int/float) 저장, apostrophe 없음 |

## 최종 검증 결과

| 시트 | 확인 항목 | 결과 |
|---|---|---|
| meta_city_list | gold 60.0% (36/60) | ✅ |
| meta_city_list | infinite 5.0% (3/60) ≤ 5% | ✅ |
| meta_city_list | booster 5종 모두 포함 | ✅ |
| collection_album_puzzle_list | gold 60.0% (15/25) | ✅ |
| collection_album_puzzle_list | infinite 4.0% (1/25) ≤ 5% | ✅ |
| collection_album_puzzle_list | 단계별 가치 상승 (NY→Sydney) | ✅ |
| daily_task | gold 60.4% (29/48) ≈ 60% ±5% | ✅ |
| daily_task | infinite 0% | ✅ |
| daily_task | booster 5종 모두 포함 | ✅ |

**총 수정 셀: 119건 (meta=62, album=31, daily=26) — 전체 검증 통과**

---

## Revision 11: infinite 초과 + 행내 gold 중복 수정 (2026-03-12)

| 시트 | 수정유형 | 수정건수 | infinite비율(수정후) | 중복행(수정후) | 상태 |
|---|---|---|---|---|---|
| collection_album_milestone | infinite 초과 | 4행 (110008/110013/110015/110018) | 5.0% (1/20) ≤5% | 0 | ✅ |
| event_ranking | infinite 초과 | 1행 (170001) | 0.0% (0/5) ≤5% | 0 | ✅ |
| meta_city_list | gold 중복 | 16행 (60001~60016) | - | 0 | ✅ |
| collection_album_puzzle_list | gold 중복 | 7행 (90001~90007) | - | 0 | ✅ |

### 수정 상세

**A-1: collection_album_milestone — infinite 4개 교체**

| key | req_point | 기존 | 변경 후 | 사유 |
|---|---|---|---|---|
| 110008 | 300 | infinite_ticket_5m × 1 | booster_fireworks × 2 | infinite 제거, 초반 단계 적합 보상 |
| 110013 | 800 | infinite_fireworks_5m × 1 | booster_wild_card × 2 | infinite 제거, 중반 단계 적합 보상 |
| 110015 | 1070 | infinite_gticket_5m × 1 | currency_ticket × 2 | infinite 제거, 중후반 단계 적합 보상 |
| 110018 | 1650 | infinite_fireworks_15m × 1 | booster_golden_ticket × 2 | infinite 제거, 후반 단계 고가치 보상 |

남긴 infinite: 110020 (req_point=2000, infinite_ticket_15m) — 최후반 단계 1개만 유지 → 5.0%

**A-2: event_ranking — infinite 1개 교체**

| key | 기존 | 변경 후 | 사유 |
|---|---|---|---|
| 170001 reward_1 | infinite_gticket_10m × 1 | booster_golden_ticket × 3 | infinite 제거, 1위 보상 수량 상향으로 가치 보전 |

**B-1: meta_city_list — gold 중복 16행 해소**

- reward_1_amount = reward_1 + reward_2 합산 (gold 유지, 총액 보전)
- reward_2를 단계별 booster/currency_ticket으로 교체
- 교체 분포: booster_wild_card×4, booster_fireworks×4, currency_ticket×3, booster_undo×3, booster_extra_deck×1, booster_golden_ticket×1

| 단계 | 교체 아이템 |
|---|---|
| 초반 60001~60008 | wild_card, fireworks, ticket, wild_card, fireworks, undo, ticket, wild_card |
| 중반 60009~60014 | undo, fireworks, ticket, undo, wild_card, fireworks |
| 후반 60015~60016 | extra_deck, golden_ticket |

**B-2: collection_album_puzzle_list — gold 중복 7행 해소**

- reward_1_amount = 모든 gold 합산 (총액 보전)
- 나머지 슬롯: 앨범 진행도에 맞게 가치 상승 배치

| key | r1(gold) | r2 | r3 | r4 |
|---|---|---|---|---|
| 90001 | 10000 | fireworks×1 | none | none |
| 90002 | 21000 | fireworks×2 | undo×2 | none |
| 90003 | 20000 | undo×2 | fireworks×1 | ticket×1 |
| 90004 | 20000 | fireworks×2 | undo×2 | wild_card×1 |
| 90005 | 20000 | wild_card×2 | undo×2 | ticket×1 |
| 90006 | 20000 | wild_card×2 | golden_ticket×2 | ticket×1 |
| 90007 | 20000 | golden_ticket×2 | extra_deck×2 | ticket×1 |

### PM 절차 준수 확인

| 절차 | 상태 |
|---|---|
| ① 원본 백업 | ✅ 4개 시트 전체 — 데이터 끝 열 + 빈 열 1개 + Parameter/Original/Updated 3열 구조 기록 |
| ② 하이라이트 | ✅ 수정 셀 전체 색상 적용 (증가=연두, 구조변경=하늘) |
| ③ 숫자 포맷 | ✅ 전체 numberValue(int/float) 저장 확인, apostrophe 없음 |

### 최종 검증 결과

| 시트 | 확인 항목 | 결과 |
|---|---|---|
| collection_album_milestone | infinite 5.0% (1/20) ≤5% | ✅ |
| collection_album_milestone | 남은 infinite: 110020만 (최후반) | ✅ |
| event_ranking | infinite 0.0% (0/5) ≤5% | ✅ |
| meta_city_list | gold 중복 0행 | ✅ |
| meta_city_list | numberValue 저장 확인 (E3=6000, E4=6500) | ✅ |
| collection_album_puzzle_list | gold 중복 0행 | ✅ |

**총 수정 셀: ~110건 — 전체 검증 통과**

---

## Revision 12 — apostrophe prefix 정리 (2026-03-12)

**작업 내용:** 전체 15개 시트 apostrophe(') prefix 탐지 및 올바른 타입으로 재저장

### 탐지 방법
- Sheets API `userEnteredValue` + `effectiveValue` 비교
- `userEnteredValue.stringValue` + `effectiveValue.boolValue` → apostrophe 불린형 확정
- `userEnteredValue.stringValue` + 숫자 파싱 가능 → apostrophe 숫자형 확정

### 시트별 결과

| 시트 | 발견 건수 | 숫자→numberValue | 불린→boolValue | 문자열 정리 | 상태 |
|---|---|---|---|---|---|
| daily_wheel | 0 | 0 | 0 | 0 | ✅ 이상 없음 |
| daily_gift | 0 | 0 | 0 | 0 | ✅ 이상 없음 |
| streak_reward | 0 | 0 | 0 | 0 | ✅ 이상 없음 |
| event_milestone | 0 | 0 | 0 | 0 | ✅ 이상 없음 |
| collection_album_milestone | 0 | 0 | 0 | 0 | ✅ 이상 없음 |
| daily_task_milestone | 0 | 0 | 0 | 0 | ✅ 이상 없음 |
| **daily_task** | **48** | 0 | **48** | 0 | ✅ 수정 완료 |
| meta_city_list | 0 | 0 | 0 | 0 | ✅ 이상 없음 |
| collection_album_puzzle_list | 0 | 0 | 0 | 0 | ✅ 이상 없음 |
| event_ranking | 0 | 0 | 0 | 0 | ✅ 이상 없음 |
| item_list | 0 | 0 | 0 | 0 | ✅ 이상 없음 |
| const | 0 | 0 | 0 | 0 | ✅ 이상 없음 |
| difficulty_tier | 0 | 0 | 0 | 0 | ✅ 이상 없음 |
| dynamic_level | 0 | 0 | 0 | 0 | ✅ 이상 없음 |
| **product** | **11** | 0 | **11** | 0 | ✅ 수정 완료 |
| **합계** | **59** | **0** | **59** | **0** | |

### 수정 셀 목록

**daily_task** — I열(col 9) 전체 48행 (row 3~50): `'True'(stringValue)` → `boolValue: True`

| 시트 | 열 | 행 범위 | 원래값 | 수정 타입 | 수정값 |
|---|---|---|---|---|---|
| daily_task | I (col 9) | 3~50 (48행) | `'True'` (stringValue) | boolValue | `TRUE` |

**product** — R열(col 18) 11행:

| 시트 | 행 | 원래값 | 수정 타입 | 수정값 |
|---|---|---|---|---|
| product | 3 | `'True'` | boolValue | `TRUE` |
| product | 4 | `'True'` | boolValue | `TRUE` |
| product | 5 | `'False'` | boolValue | `FALSE` |
| product | 6 | `'True'` | boolValue | `TRUE` |
| product | 7 | `'True'` | boolValue | `TRUE` |
| product | 8 | `'True'` | boolValue | `TRUE` |
| product | 9 | `'True'` | boolValue | `TRUE` |
| product | 10 | `'True'` | boolValue | `TRUE` |
| product | 11 | `'False'` | boolValue | `FALSE` |
| product | 12 | `'False'` | boolValue | `FALSE` |
| product | 13 | `'False'` | boolValue | `FALSE` |

### 검증

| 시트 | 셀 | 수정 후 userEnteredValue | 결과 |
|---|---|---|---|
| daily_task | I3:I5 | `boolValue: True` | ✅ |
| product | R3 | `boolValue: True` | ✅ |
| product | R5 | `boolValue: False` | ✅ |

### PM 절차 준수 확인

| 절차 | 상태 |
|---|---|
| ① 원본 백업 | 해당 없음 — 값 자체는 동일, 타입만 변경 |
| ② 하이라이트 | 해당 없음 — 타입 수정은 값 변경 아님 |
| ③ 숫자 포맷 | ✅ boolValue로 저장 확인 (apostrophe 제거) |

**총 수정 셀: 59건 (daily_task 48 + product 11) — 전체 검증 통과**

---

---
agent: 07_sheet_modifier
mode: sheet-modify
scope: meta_city_list, meta_decoration_list, collection_album_puzzle_list, collection_puzzle_piece_list
executed: 2026-03-26
status: complete
approved_by: pm
items_modified: 4 sheets
items_skipped: 0
---

# 도시 순서 재배치 + 콜렉션 시스템 수정 (2026-03-26)

## 1. meta_city_list — 21개 도시 순서 재배치

### 변경 사유
연속 도시 간 시각적 차이 극대화. 초기 4개 도시(NY, Venice, Sapporo, Cairo) 순서 유지, 5번째부터 테마 대비 기준으로 재배치.

### 설계 원칙
- **도시 고유 속성**(key_number, prefab_name, display_name)은 도시와 함께 이동
- **포지션 기반 보상 티어**(reward_1_amount 등)는 포지션에 고정 (포지션 5는 항상 같은 보상 레벨)
- `is_published`: 포지션 1-4 = TRUE, 5-21 = FALSE

### 변경 내역

| Pos | City | Old Pos | Reward Gold |
|-----|------|---------|-------------|
| 1 | New York | 1 | 6,000 |
| 2 | Venice | 2 | 6,500 |
| 3 | Sapporo | 3 | 7,000 |
| 4 | Cairo | 4 | 7,000 |
| 5 | Miami | 8 | 7,500 |
| 6 | Prague | 21 | 8,000 |
| 7 | Dubai | 15 | 8,000 |
| 8 | Tokyo | 13 | 8,500 |
| 9 | Barcelona | 18 | 9,000 |
| 10 | Chicago | 7 | 9,000 |
| 11 | Bangkok | 14 | 9,500 |
| 12 | London | 10 | 10,000 |
| 13 | Rio de Janeiro | 17 | 10,500 |
| 14 | San Francisco | 5 | 10,500 |
| 15 | Athens | 20 | 11,000 |
| 16 | Las Vegas | 6 | 11,500 |
| 17 | Sydney | 16 | 12,000 |
| 18 | Rome | 11 | 12,500 |
| 19 | Los Angeles | 12 | 13,000 |
| 20 | Istanbul | 19 | 14,000 |
| 21 | Paris | 9 | 15,500 |

### 백업
본 시트 O-Q열: `City | Original Order | New Order`

---

## 2. meta_decoration_list — 도시 순서 재배치 연동

- 105행 (21 도시 × 5 데코) 도시 순서에 맞게 재배치
- 코스트 티어(hammer, gold)는 포지션에 고정, 데코 이름(name_key)은 도시와 함께 이동
- 변경 범위: 포지션 5-21 (85행)

---

## 3. collection_album_puzzle_list — 보상 재설계

### 변경 사유
앨범 보상을 입장료 대비 적절한 수준으로 조정. 초기 소량에서 점진적 증가, 상한선 설정.

### 설계 기준
- 골드 보상: 입장료 대비 ~2.8-3.4× (상한 12,000g = 최대 입장료 6,000g × 2)
- 부스터: 저가→고가 순으로 점진 등장
- 언락 레벨: 1→25→50→75→100→150→200

### 변경 내역

| City | Unlock | Gold | Booster 1 | Booster 2 | Booster 3 |
|------|--------|------|-----------|-----------|-----------|
| NY | Lv1 | 3,500 | fireworks×1 | - | - |
| Venice | Lv25 | 5,000 | fireworks×1 | undo×1 | - |
| Cairo | Lv50 | 6,000 | undo×1 | wild_card×1 | - |
| Tokyo | Lv75 | 7,000 | wild_card×1 | fireworks×1 | - |
| London | Lv100 | 8,500 | fireworks×1 | golden_ticket×1 | - |
| Sydney | Lv150 | 10,000 | golden_ticket×1 | extra_deck×1 | - |
| Paris | Lv200 | 12,000 | golden_ticket×1 | extra_deck×1 | ticket×1 |

---

## 4. collection_puzzle_piece_list — 84조각 생성 + 도시별 수량 점진 증가

### 변경 사유
기존 NY+Paris 14행 → 7개 도시 × 12조각 = 84행 확장. 도시별 총 소모 피스 수량 점진 증가.

### 설계 기준
- const 10044-46 참조: 드롭량 betting_1=1, betting_2=3, betting_4=5
- 기본 패턴(1-12, 합계 78)에 도시별 승수 적용, 개별 조각 상한 25
- 도시 내 순서는 랜덤 배치

### 변경 내역

| City | Multiplier | piece_amount (랜덤 배치) | Total |
|------|-----------|------------------------|-------|
| NY | ×1.0 | 8,6,3,9,10,7,12,4,5,1,2,11 | 78 |
| Venice | ×1.2 | 7,10,4,12,13,8,6,11,5,2,14,1 | 93 |
| Cairo | ×1.4 | 13,15,8,4,17,3,10,1,7,14,11,6 | 109 |
| Tokyo | ×1.6 | 19,14,13,8,18,5,2,11,16,3,10,6 | 125 |
| London | ×1.8 | 22,2,7,5,14,11,18,9,20,13,4,16 | 141 |
| Sydney | ×2.0 | 16,6,12,18,14,22,20,10,8,2,4,24 | 156 |
| Paris | ×2.2 | 15,9,11,2,22,18,4,20,25,7,13,24 | 170 |

### 최소 클리어 게임수 (betting_4 기준)
NY=16, Venice=19, Cairo=22, Tokyo=25, London=29, Sydney=32, Paris=34

### 키 번호 할당
NY: 80001-80012, Venice: 80013-80024, Cairo: 80025-80036, Tokyo: 80037-80048, London: 80049-80060, Sydney: 80061-80072, Paris: 80073-80084

---

## 타입 수정 (전 시트 공통)

### 대상
meta_city_list, meta_decoration_list — 양 시트(에이전트 + 라이브)

### 수정 내용
- 숫자: 문자열 → `numberValue` (int)
- 불리언: `'TRUE'`/`'FALSE'` 문자열 → `boolValue` (true/false)
- meta_city_list: 숫자 139셀 + 불리언 21셀
- meta_decoration_list: 숫자 ~1,400셀 + 불리언 105셀

### 오타 수정
- meta_decoration_list Row41 Col6: `ㅡㄷㅅ` → `11` (라이브 시트 타이핑 오류)

---

## 2026-04-06 — lobby_free_gold_limit 신규 추가 + RV 지급량 rv_gold_ratio 전환

**Spreadsheet:** `1oLbpsJjiDz0pdljaGBQznrSZcXA7aypFyJihnQ8_iiM` (라이브 시트)
**시트명:** `const`, `level_entry_tier`

### 변경 내역

| Parameter | Original Data | Updated Data | 사유 |
|-----------|---------------|--------------|------|
| `lobby_free_gold_limit` (key 10076) | — (미존재) | **3** | 로비 RV 무료 골드 채널 신규 추가. 일 3회, UTC0 리셋. |
| `inbox_free_gold_amount` (key 10058) | 800 | **deprecated** | RV 지급량 전체를 rv_gold_ratio 기반으로 전환 |
| `popup_free_gold_amount` (key 10064) | 800 | **deprecated** | 동상 |

### RV 지급량 계산 방식 전환

모든 RV 채널(inbox / popup / lobby)의 1회 지급 골드가 **const 고정값에서 `level_entry_tier.rv_gold_ratio` 기반 동적 계산으로 대체**됨.

```
rv_gold_per_watch = level_entry_tier.entry_cost × level_entry_tier.rv_gold_ratio / 10000
```

**level_entry_tier rv_gold_ratio 전체 (라이브 확정):**

| key | 레벨 범위 | entry_cost | rv_gold_ratio | rv_gold/회 |
|-----|----------|-----------|--------------|-----------|
| 220002 | Lv3~9   | 1,200g | 6500 (65%) | 780g   |
| 220003 | Lv10~24 | 1,800g | 5500 (55%) | 990g   |
| 220004 | Lv25~49 | 2,100g | 5000 (50%) | 1,050g |
| 220005 | Lv50~99 | 2,400g | 4800 (48%) | 1,152g |
| 220006 | Lv100~199 | 2,600g | 4500 (45%) | 1,170g |
| 220007 | Lv200~349 | 3,000g | 4200 (42%) | 1,260g |
| 220008 | Lv350~549 | 3,400g | 4000 (40%) | 1,360g |
| 220009 | Lv550~799 | 4,000g | 3800 (38%) | 1,520g |
| 220010 | Lv800~1099 | 4,600g | 3500 (35%) | 1,610g |
| 220011 | Lv1100~1449 | 5,400g | 3200 (32%) | 1,728g |
| 220012 | Lv1450+ | 6,000g | 3000 (30%) | 1,800g |

### 경제 영향 요약 (Lv75 기준)

| 항목 | 이전 | 변경 후 |
|------|------|---------|
| RV 1회 지급량 | 800g (고정) | **1,152g** (Lv75 rv_gold_ratio 기반) |
| 일일 inbox RV 최대 | 4,000 (5×800) | **5,760** (5×1,152) |
| 일일 popup RV 최대 | 8,000 (10×800) | **11,520** (10×1,152) |
| 일일 lobby RV 최대 | — | **3,456** (3×1,152) |
| 광고 채널 수 | 4채널 | **5채널** (+lobby) |
| 일일 RV 합산 (Lv75) | 12,000 | **20,736** (+73%) |

### 문서 업데이트 현황

| 문서 | 업데이트 항목 | 완료 |
|------|-------------|------|
| `workspace/02_economic_result.md` | Source/Sink 5채널, const 테이블(deprecated), pst_free_currency_source, rv_gold_ratio 티어표, VAL-007 | ✅ |
| `workspace/05_system_result.md` | 주요 상수 표, rv_gold_ratio 티어표, 5-A/5-B/5-D 공식 전면 교체, 요약 테이블, 상태 전이표, 데이터 흐름도 | ✅ |
| `workspace/07_sheet_modify_log.md` | 본 로그 항목 | ✅ |

---
