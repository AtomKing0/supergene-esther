---
agent: 09_sheet_sync
mode: sheet-sync
src_spreadsheet: 1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk
dst_spreadsheet: 1oLbpsJjiDz0pdljaGBQznrSZcXA7aypFyJihnQ8_iiM
executed: 2026-03-26T00:30:00+09:00
status: complete
sheets_synced: 6
sheets_skipped: 18
total_cells_changed: 86
---

# 09 시트 동기화 로그

## 실행 일시

2026-03-26 00:30 KST

## 동기화 방향

에이전트 시트 → 라이브 시트

## 동기화 결과

| 시트명 | 처리 | 변경 셀 | 하이라이트 | 검증 |
|--------|------|---------|-----------|------|
| level_entry_tier | 데이터 열만 | 11 | 연두색 (수치 증가) | ✅ 통과 |
| daily_gift | 데이터 열만 | 1 | 노란색 (수치 감소) | ✅ 통과 |
| event_milestone | 데이터 열만 | 6 | 하늘색 (구조 변경) | ✅ 통과 |
| gimmick_weight | 데이터 열만 | 1 | 하늘색 (구조 변경) | ✅ 통과 |
| unlock | 데이터 열만 | 1 | 하늘색 (구조 변경) | ✅ 통과 |
| string_code | 데이터 열만 | 66 | 하늘색 (특수문자 치환) | ✅ 통과 |

## 건너뜀 시트 (동일 또는 주석 차이만)

difficulty_tier, dynamic_level, meta_city_list, meta_decoration_list, collection_album_puzzle_list, collection_album_milestone, collection_deck, daily_task_milestone, daily_wheel, event_schedule, event_ranking, const, streak_reward, item_list, daily_task, tutorial_guide, product, collection_puzzle_piece_list

## 주요 변경 상세

### level_entry_tier (11셀, 수치 증가)

입장료 Lv2~12 전 구간 인상

| 구간 | 변경 전 (라이브) | 변경 후 (에이전트) |
|------|-----------------|------------------|
| Lv2 | 1,000 | 1,200 |
| Lv3 | 1,500 | 1,800 |
| Lv4 | 1,800 | 2,160 |
| Lv5 | 2,000 | 2,400 |
| Lv6 | 2,200 | 2,640 |
| Lv7 | 2,500 | 3,000 |
| Lv8 | 2,900 | 3,480 |
| Lv9 | 3,400 | 4,080 |
| Lv10 | 3,900 | 4,680 |
| Lv11 | 4,500 | 5,400 |
| Lv12 | 5,000 | 6,000 |

### daily_gift (1셀, 수치 감소)

| 항목 | 변경 전 | 변경 후 |
|------|--------|--------|
| 7일차 보상 골드 | 5,000 | 3,000 |

### event_milestone (6셀, 구조 변경)

| 행 | 변경 전 | 변경 후 |
|----|--------|--------|
| 4 | currency_gold × 270 | currency_ticket × 1 |
| 19 | currency_gold × 270 | currency_ticket × 1 |
| 35 | currency_gold × 330 | currency_ticket × 1 |

### gimmick_weight / unlock (각 1셀, 구조 변경)

| 항목 | 변경 전 | 변경 후 |
|------|--------|--------|
| gimmick_weight 행4 | gimmick_rope_card | gimmick_ice_card |
| unlock 행27 콘텐츠ID | gimmick_rope_card | gimmick_ice_card |

### string_code (66셀, 특수문자 치환)

JSON 파싱 에러 유발 특수문자 일괄 치환:
- em-dash (U+2014) → hyphen (-)
- straight double quote (U+0022) → guillemets (« »)
- NBSP (U+00A0) → 일반 공백

## 사용자 확인

- 하이라이트 적용 후 사용자 확인 완료
- 하이라이트 제거 완료
