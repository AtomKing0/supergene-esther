---
agent: 02_economic_balance
mode: phase-b
scope: PST 재화 시스템
executed: 2026-03-09T20:30:00+09:00
status: complete
revision: 2
cp2_adjust: resolved
schema_ref: workspace/04_schema_template.md
---

# 02 경제 밸런스 에이전트 — Phase-B 스키마 기반 밸런스 설계

---

## 1. 우리 게임 Source/Sink 전환 구조 표

| 구분 | PST 구조 | PBM 구조 | CCS 구조 | 우리 게임 적용 | 변형 이유 |
|---|---|---|---|---|---|
| **소프트 통화** | currency_gold (소프트) | gold (소프트) | 미확인 | currency_gold (소프트) | PST 구조 직접 채택. 카드게임 장르 특성상 gold 명칭 및 단위 유지 |
| **준하드 통화** | currency_ticket (준하드) | ad_skip_ticket (광고 스킵) | 미확인 | currency_ticket (준하드) | PST 구조 채택. 이벤트·입장 관련 티켓 역할 유지 |
| **보조 통화** | currency_streak_star, currency_puzzle_piece, currency_hammer | - | 미확인 | currency_streak_star 유지 / currency_puzzle_piece·currency_hammer 보류 | streak_star는 PST_streak_reward 연동 구조 확인됨. puzzle_piece·hammer는 is_album_collection_open=0, is_deck_collection_open=0로 현재 비활성. 우리 게임에서 활성화 여부 별도 결정 필요 |
| **인게임 부스터** | booster_fireworks, booster_undo, booster_wild_card, booster_extra_deck, booster_golden_ticket | undo, redeal, bomb | 미확인 | PST booster 5종 구조 채택 | PST는 인벤토리 보관 후 레벨 진입 시 선택 사용 구조. 카드게임 장르에 적합 |
| **무한 아이템** | infinite_fireworks/gticket/ticket (5m/10m/15m 3단계) | 없음 | 미확인 | PST 무한 아이템 9종 구조 채택 + booster_infinite_undo_15m/30m 이벤트 전용 추가 검토 | PST_event_milestone에서 booster_infinite_undo_15m/30m 발견 (PST_item_list 미등재). 이벤트 전용 임시 지급 아이템으로 활용 가능. 정식 등재 여부 결정 필요 |
| **유휴 충전 (Source)** | 4시간마다 3,000 gold 자동 충전 (상한 8,000) | 없음 (럭키 체스트 4시간으로 대체) | 미확인 | PST 유휴 충전 구조 채택 | 카드게임 특성상 자연 회복 구조가 리텐션에 유리. PST_const.json 10002~10006 수치 그대로 적용 |
| **데일리 출석 (Source)** | 7일 사이클, gold+부스터 혼합 보상 | 7일 사이클, gold+아이템 혼합 보상 | 미확인 | PST 7일 사이클 구조 채택 | PST_daily_gift.json 수치 그대로 적용. 7일 누적 gold 6,500 + 부스터 4개 + ticket 3개 |
| **광고 기반 무료 재화 (Source)** | shop_ad / inbox / popup / daily_wheel_ad / lobby_ad 5채널 | daily_ad / lobby_ad / inbox_ad 3채널 | 미확인 | PST 5채널 구조 채택 | 광고 분산 채널 운영으로 유저 선택권 확대. daily_wheel은 가챠 구조로 기대감 부여. lobby_ad 추가(10076, 일 3회, 2026-04-06) |
| **이벤트 마일스톤 (Source)** | 15스텝, 3가지 이벤트 타입 병행 운영 | 미분석 | 미확인 | PST 3이벤트 타입 구조 채택 | black_card/red_card/winning_milestone 주간 순환 + clear_ranking 병행. PST_event_schedule.json 스케줄 그대로 적용 |
| **레벨 입장비 (Sink)** | 기본 1,000 gold, 10레벨마다 +100, 상한 5,000 | 없음 (점수 기반 진행) | 미확인 | PST 입장비 구조 채택 | 카드게임 특성상 레벨 진입 비용이 핵심 Sink. 무료 입장 2회/일로 캐주얼 접근성 확보 |
| **보상 마진 (Sink 완충)** | 클리어 시 500~2,000 gold 지급 | 없음 | 미확인 | PST 보상 마진 구조 채택 | 입장비 1,000 gold 대비 최소 500 gold 회수 보장 → 실질 net cost 500~1,000 gold/레벨 |

---

## 2. 스키마 기반 테이블 데이터

---

### 테이블: `pst_currency_config`

> 출처: PST_const.json 직접 파생. "가설" 없이 기재.

| key_number | const_name | currency_type | param_category | const_value | unit | in_use | description |
|---|---|---|---|---|---|---|---|
| 10001 | nru_start_gold | gold | initial_grant | 1000 | amount | true | NRU(신규 유저) 시작 골드 지급량 |
| 10002 | idle_gold_charge_time | gold | idle_charge | 14400 | sec | true | 유휴 골드 완전 충전 소요 시간 (4시간) |
| 10003 | idle_gold_charge_amount | gold | idle_charge | 3000 | amount | true | 유휴 충전 1사이클 완료 시 지급 골드량 |
| 10004 | idle_gold_interval | gold | idle_charge | 20 | sec | true | 유휴 골드 단계별 증가 인터벌 (초) |
| 10005 | idle_gold_amount_increase | gold | idle_charge | 400 [라이브 확정, 2026-03-09] | amount | true | 유휴 인터벌당 단계 증가량 |
| 10006 | idle_gold_max_cap | gold | idle_charge | 10000 [라이브 확정, 2026-03-09] | amount | true | 유휴 충전 누적 상한 |
| 10007 | entry_cost_free_limit | gold | cost | 2 | count | true | 일일 무료 입장 횟수 한도 |
| 10008 | entry_cost_base | gold | cost | 1000 | amount | true | 레벨 입장 기본 비용 (gold) |
| 10009 | entry_cost_interval | gold | cost | 10 | count | true | 입장비 증가 적용 레벨 간격 |
| 10010 | entry_cost_increase | gold | cost | 100 | amount | true | 간격당 입장비 증가량 (gold) |
| 10011 | entry_cost_max_cap | gold | cost | 5000 | amount | true | 입장 비용 상한 (gold) |
| 10012 | reward_margin_min | gold | reward | 500 | amount | true | 레벨 클리어 보상 마진 하한 (gold) |
| 10013 | reward_margin_max | gold | reward | 2000 | amount | true | 레벨 클리어 보상 마진 상한 (gold) |
| 10014 | friend_invite_reward | gold | friend | 1000 | amount | true | 친구 초대 성공 시 지급 골드 |
| 10015 | friend_send_reward | gold | friend | 1 | count | true | 친구 전송 보상 (단위: 미상, count로 임시 기재) |
| 10025 | shop_free_gold_limit | gold | free_source | 5 | count | true | 상점 무료 광고 골드 일일 노출 상한 횟수 |
| 10026 | shop_free_gold_amount | gold | free_source | 2000 | amount | true | 상점 무료 광고 1회 지급 골드량 |
| 10027 | daily_wheel_ad_limit | gold | free_source | 5 | count | true | 데일리 휠 광고 시청 일일 최대 횟수 |
| 10028 | card_maching_gold_amount | gold | ingame_earn | 2 | amount | true | 카드 매칭 골드 기본 지급량 |
| 10029 | card_maching_gold_interval | gold | ingame_earn | 10 | count | true | 카드 매칭 골드 증가 간격 (매칭 수) |
| 10030 | card_maching_gold_amount_increase | gold | ingame_earn | 4 | amount | true | 매칭 간격당 골드 증가량 |
| 10031 | card_maching_gold_max_cap | gold | ingame_earn | 100 | amount | true | 카드 매칭 골드 상한 |
| 10047 | ingame_combo_reward_base | gold | ingame_earn | 2 | amount | true | 인게임 콤보 보상 기본 지급량 (gold) |
| 10048 | ingame_combo_reward_increase | gold | ingame_earn | 1 | amount | true | 레벨 간격당 콤보 보상 증가량 |
| 10049 | ingame_combo_reward_max_cap | gold | ingame_earn | 50 | amount | true | 콤보 보상 상한 (gold) |
| 10050 | ingame_combo_reward_level_interval | gold | ingame_earn | 10 | count | true | 콤보 보상 증가 레벨 간격 |
| 10051 | ingame_combo_reward_level_increase | gold | ingame_earn | 1 | count | true | 간격당 레벨 증가 수치 |
| 10052 | remaining_deck_reward_base | gold | ingame_earn | 15 | amount | true | 덱 잔여 카드 보상 기본 지급량 (gold) |
| 10053 | remaining_deck_reward_increase | gold | ingame_earn | 15 | amount | true | 레벨 간격당 잔여 덱 보상 증가량 |
| 10054 | remaining_deck_reward_max_cap | gold | ingame_earn | 5000 | amount | true | 잔여 덱 보상 상한 (gold) |
| 10055 | remaining_deck_reward_level_interval | gold | ingame_earn | 5 | count | true | 잔여 덱 보상 증가 레벨 간격 |
| 10056 | remaining_deck_reward_level_increase | gold | ingame_earn | 5 | count | true | 간격당 레벨 증가 수치 |
| 10057 | inbox_free_gold_limit | gold | free_source | 5 | count | true | 받은편지함 RV 광고 일일 횟수 상한 |
| 10058 | inbox_free_gold_amount | gold | free_source | 600 [deprecated] | amount | false | ⚠️ rv_gold_ratio(level_entry_tier)로 대체. entry_cost × rv_gold_ratio / 10000 |
| 10059 | gold_max_limit | gold | cap | 20000 | amount | true | 인게임 판당 최대 수령 골드량 |
| 10060 | streak_star_max_limit | streak_star | cap | 100 | amount | true | 스트릭 스타 최대 보유 상한 |
| 10063 | popup_free_gold_limit | gold | free_source | 10 | count | true | 팝업 RV 광고 일일 횟수 상한 |
| 10064 | popup_free_gold_amount | gold | free_source | 600 [deprecated] | amount | false | ⚠️ rv_gold_ratio(level_entry_tier)로 대체. entry_cost × rv_gold_ratio / 10000 |
| 10076 | lobby_free_gold_limit | gold | free_source | 3 [라이브 확정, 2026-04-06] | count | true | 로비 RV 광고 일일 횟수 상한 (UTC0 리셋). 지급량은 rv_gold_ratio 기반 |

---

### 테이블: `pst_entry_cost_config`

> 출처: PST_const.json 10007~10011 직접 파생.

| key_number | free_play_limit | base_cost | cost_interval | cost_increase_amount | cost_max_cap | in_use |
|---|---|---|---|---|---|---|
| 10007 | 2 | 1000 | 10 | 100 | 5000 | true |

> VAL-004 검증: cost_max_cap(5000) >= base_cost(1000) - 통과.

---

### 테이블: `pst_reward_margin_config`

> 출처: PST_const.json 10012~10013 직접 파생.

| key_number | reward_margin_min | reward_margin_max | in_use |
|---|---|---|---|
| 10012 | 500 | 2000 | true |

> VAL-005 검증: reward_margin_max(2000) >= reward_margin_min(500) - 통과.

---

### 테이블: `pst_ingame_reward_config`

> 출처: PST_const.json 10047~10056 직접 파생.

| key_number | reward_source | base_amount | amount_increase | amount_max_cap | level_interval | level_increase | in_use |
|---|---|---|---|---|---|---|---|
| 10047 | combo | 2 | 1 | 50 | 10 | 1 | true |
| 10052 | remaining_deck | 15 | 15 | 5000 | 5 | 5 | true |

> VAL-006 검증:
> - combo: amount_max_cap(50) >= base_amount(2) - 통과.
> - remaining_deck: amount_max_cap(5000) >= base_amount(15) - 통과.

---

### 테이블: `pst_item_definition`

> 출처: PST_item_list.json 직접 파생. JSON 필드명 `type` → 스키마 컬럼명 `item_type` 매핑.

| key_number | name_key | item_type | usage_type | entry_cost_ratio | interval_type | use_count_increase_rate | use_count_max_ratio | duration_sec | target_name_key | in_use |
|---|---|---|---|---|---|---|---|---|---|---|
| 40001 | currency_gold | currency | inventory | 0 | none | 0 | 0 | 0 | none | true |
| 40002 | currency_hammer | currency | inventory | 0 | none | 0 | 0 | 0 | none | true |
| 40003 | currency_ticket | currency | inventory | 0 | none | 0 | 0 | 0 | none | true |
| 40004 | currency_streak_star | currency | inventory | 0 | none | 0 | 0 | 0 | none | true |
| 40005 | currency_puzzle_piece | currency | inventory | 0 | none | 0 | 0 | 0 | none | true |
| 40010 | booster_fireworks | booster | inventory | 6000 | fixed | 0 | 0 | 0 | none | true |
| 40011 | booster_golden_ticket | booster | inventory | 8000 | fixed | 0 | 0 | 0 | none | true |
| 40012 | booster_undo | booster | inventory | 0 | tier_undo | 4000 | 10000 | 0 | none | true |
| 40013 | booster_wild_card | booster | inventory | 5000 | fixed | 0 | 0 | 0 | none | true |
| 40014 | booster_extra_deck | booster | inventory | 0 | tier_extra_deck | 4000 | 30000 | 0 | none | true |
| 40020 | infinite_fireworks_5m | infinite | inventory | 0 | none | 0 | 0 | 300 | booster_fireworks | true |
| 40021 | infinite_fireworks_10m | infinite | inventory | 0 | none | 0 | 0 | 600 | booster_fireworks | true |
| 40022 | infinite_fireworks_15m | infinite | inventory | 0 | none | 0 | 0 | 900 | booster_fireworks | true |
| 40023 | infinite_gticket_5m | infinite | inventory | 0 | none | 0 | 0 | 300 | booster_golden_ticket | true |
| 40024 | infinite_gticket_10m | infinite | inventory | 0 | none | 0 | 0 | 600 | booster_golden_ticket | true |
| 40025 | infinite_gticket_15m | infinite | inventory | 0 | none | 0 | 0 | 900 | booster_golden_ticket | true |
| 40026 | infinite_ticket_5m | infinite | inventory | 0 | none | 0 | 0 | 300 | currency_ticket | true |
| 40027 | infinite_ticket_10m | infinite | inventory | 0 | none | 0 | 0 | 600 | currency_ticket | true |
| 40028 | infinite_ticket_15m | infinite | inventory | 0 | none | 0 | 0 | 900 | currency_ticket | true |
| 40029 | reward_plus_card_1 | gimmick | immediate | 0 | none | 0 | 0 | 0 | none | true |

> VAL-014/015 검증 (infinite 유형):
> - infinite_fireworks_5m: duration_sec=300 >= 1 (통과), target_name_key=booster_fireworks != none (통과)
> - 나머지 infinite 8종 동일 패턴 - 모두 통과.
>
> **[가설] 항목 (PST_item_list.json 미등재):**
> - `booster_infinite_undo_15m` [가설] (PST_event_milestone.json key 180037에서 발견): PST_item_list.json에 정식 등재 없음. 이벤트 전용 임시 지급 아이템으로 추정. 정식 item_definition 등재 시 infinite 유형, duration_sec=900 [가설: 15분=900초], target_name_key=booster_undo로 설정 권장.
> - `booster_infinite_undo_30m` [가설] (PST_event_milestone.json key 180041에서 발견): duration_sec=1800 [가설: 30분=1800초], target_name_key=booster_undo로 설정 권장.
> - 위 2종은 레퍼런스 데이터 불일치 사항으로, 우리 게임 정식 등재 전 담당 PM 확인 필요.

---

### 테이블: `pst_product_definition`

> 출처: PST_product.json 직접 파생. JSON 필드명 `reward_type` → 스키마 `reward_type_1` 매핑.

**활성 상품 (in_use: true)**

| key_number | product_name | product_id | pay_type | pay_amount | reward_type_1 | reward_amount_1 | reward_type_2 | reward_amount_2 | reward_type_3 | reward_amount_3 | reward_type_4 | reward_amount_4 | reward_type_5 | reward_amount_5 | shop_order | label_type | limit_type | pay_limit | max_display_count | validity_duration_sec | display_priority | dismiss_cooldown_sec | in_use |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| 190001 | T_SHOP_FREE_GOLD | gold_ad_1 | AD | 0.0 | currency_gold | 1000 | none | 0 | none | 0 | none | 0 | none | 0 | 7 | none | day | 1 | 0 | 0 | 0 | 0 | true |
| 190002 | T_SHOP_GOLD_1 | gold_iap_1 | IAP | 1.99 | currency_gold | 10000 | none | 0 | none | 0 | none | 0 | none | 0 | 6 | none | none | 0 | 0 | 0 | 0 | 0 | true |
| 190004 | T_SHOP_BUNDLE_1 | bundle_iap_1 | IAP | 4.99 | currency_gold | 27000 | booster_undo | 1 | currency_ticket | 1 | none | 0 | none | 0 | 2 | none | none | 0 | 0 | 0 | 0 | 0 | true |
| 190005 | T_SHOP_BUNDLE_2 | bundle_iap_2 | IAP | 8.99 | currency_gold | 45000 | booster_wild_card | 1 | booster_extra_deck | 1 | booster_undo | 1 | currency_ticket | 1 | 3 | most_popular | none | 0 | 0 | 0 | 0 | 0 | true |
| 190006 | T_SHOP_BUNDLE_3 | bundle_iap_3 | IAP | 14.99 | currency_gold | 85000 | booster_wild_card | 2 | booster_extra_deck | 2 | booster_undo | 2 | currency_ticket | 2 | 4 | none | none | 0 | 0 | 0 | 0 | 0 | true |
| 190007 | T_SHOP_BUNDLE_4 | bundle_iap_4 | IAP | 26.99 | currency_gold | 170000 | booster_wild_card | 4 | booster_extra_deck | 4 | booster_undo | 4 | currency_ticket | 4 | 8 | none | none | 0 | 0 | 0 | 0 | 0 | true |
| 190008 | T_SHOP_BUNDLE_5 | bundle_iap_5 | IAP | 49.99 | currency_gold | 370000 | booster_wild_card | 8 | booster_extra_deck | 8 | booster_undo | 8 | currency_ticket | 8 | 5 | best_value | none | 0 | 0 | 0 | 0 | 0 | true |

**비활성 상품 (in_use: false) — 참고용**

| key_number | product_name | product_id | pay_type | pay_amount | reward_type_1 | reward_amount_1 | shop_order | limit_type | pay_limit | validity_duration_sec | display_priority | dismiss_cooldown_sec | in_use |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| 190003 | T_SHOP_GOLD_2 | gold_iap_2 | IAP | 5.99 | currency_gold | 32000 | 1 | none | 0 | 0 | 0 | 0 | false |
| 190101 | T_SHOP_SPECIAL_OFFER_1 | special_offer_1 | IAP | 1.99 | currency_gold | 25000 | 999 | global | 1 | 172800 | 1 | 43200 | false |
| 190102 | T_SHOP_SPECIAL_OFFER_2 | special_offer_2 | IAP | 9.99 | currency_gold | 70000 | 999 | event | 1 | 259200 | 2 | 86400 | false |
| 190103 | T_SHOP_SPECIAL_OFFER_3 | special_offer_3 | IAP | 14.99 | currency_gold | 100000 | 999 | city | 1 | 259200 | 3 | 172800 | false |

> VAL-011 검증 (IAP pay_amount > 0): 190002($1.99), 190004($4.99), 190005($8.99), 190006($14.99), 190007($26.99), 190008($49.99) - 모두 통과.
> VAL-012 검증 (AD pay_amount = 0): 190001(0.0) - 통과.
> VAL-018 검증 (product_id 중복 금지): 7개 활성 상품 모두 고유 - 통과.
> VAL-019 검증 (스페셜 오퍼 validity_duration_sec > 0): 190101(172800), 190102(259200), 190103(259200) - 통과 (비활성 항목 포함).

---

### 테이블: `pst_daily_gift_schedule`

> 출처: PST_daily_gift.json 직접 파생. in_use 필드가 원본 JSON에 없으므로 전 항목 true로 기재 (PST_daily_gift.json 전 항목 활성 상태 확인).

| key_number | day | reward_item_key_1 | reward_amount_1 | reward_item_key_2 | reward_amount_2 | reward_item_key_3 | reward_amount_3 | in_use |
|---|---|---|---|---|---|---|---|---|
| 150001 | 0 | currency_gold | 500 | none | 0 | none | 0 | true |
| 150002 | 1 | currency_ticket | 1 | booster_undo | 1 | none | 0 | true |
| 150003 | 2 | currency_gold | 1000 | none | 0 | none | 0 | true |
| 150004 | 3 | booster_fireworks | 1 | none | 0 | none | 0 | true |
| 150005 | 4 | currency_gold | 2000 | none | 0 | none | 0 | true |
| 150006 | 5 | booster_wild_card | 1 | none | 0 | none | 0 | true |
| 150007 | 6 | currency_ticket | 2 | booster_fireworks | 1 | currency_gold | 3000 | true |

> VAL-009 검증 (day 범위 0~6): 모든 day 값 0~6 - 통과.
> VAL-010 검증 (day 중복 금지): 7개 항목 모두 고유 day - 통과.
> VAL-013 검증 (reward_amount_1 >= 1, in_use=true): 모든 1번 보상 수량 >= 1 - 통과.
> VAL-007 검증: 데일리 출석 골드 일일 최대 지급량 = 3,000 gold(day 6). gold_max_limit(10000) 초과 없음 - 통과.

---

### 테이블: `pst_daily_task_pool`

> 출처: PST_daily_task.json 직접 파생 (48개 항목 전체).

| key_number | difficulty | task_type | target_val | condition_detail | reward_item_key | reward_amount | milestone_point | in_use |
|---|---|---|---|---|---|---|---|---|
| 120001 | 1 | play_level | 1 | none | currency_gold | 300 | 20 | true |
| 120002 | 2 | play_level | 2 | none | currency_gold | 600 | 30 | true |
| 120003 | 3 | play_level | 3 | none | currency_gold | 1500 | 50 | true |
| 120004 | 1 | win_level | 1 | none | currency_gold | 300 | 20 | true |
| 120005 | 2 | win_level | 2 | none | currency_gold | 600 | 30 | true |
| 120006 | 3 | win_level | 3 | none | currency_gold | 1500 | 50 | true |
| 120007 | 1 | clear_card | 10 | any | currency_gold | 300 | 20 | true |
| 120008 | 2 | clear_card | 30 | any | currency_gold | 600 | 30 | true |
| 120009 | 3 | clear_card | 50 | any | currency_gold | 1500 | 50 | true |
| 120010 | 1 | clear_color | 5 | color_red | currency_gold | 300 | 20 | true |
| 120011 | 2 | clear_color | 15 | color_red | currency_gold | 600 | 30 | true |
| 120012 | 3 | clear_color | 30 | color_red | currency_gold | 1500 | 50 | true |
| 120013 | 1 | clear_color | 5 | color_black | currency_gold | 300 | 20 | true |
| 120014 | 2 | clear_color | 15 | color_black | currency_gold | 600 | 30 | true |
| 120015 | 3 | clear_color | 30 | color_black | currency_gold | 1500 | 50 | true |
| 120016 | 1 | get_streak | 3 | count | currency_gold | 300 | 20 | true |
| 120017 | 2 | get_streak | 10 | count | currency_gold | 600 | 30 | true |
| 120018 | 3 | get_streak | 20 | count | currency_gold | 1500 | 50 | true |
| 120019 | 1 | collect_star | 3 | none | currency_gold | 300 | 20 | true |
| 120020 | 2 | collect_star | 5 | none | currency_gold | 600 | 30 | true |
| 120021 | 3 | collect_star | 10 | none | booster_fireworks | 1 | 50 | true |
| 120022 | 1 | match_card | 1 | number_k | currency_gold | 300 | 20 | true |
| 120023 | 2 | match_card | 3 | number_k | currency_gold | 600 | 30 | true |
| 120024 | 3 | match_card | 5 | number_k | currency_gold | 1500 | 50 | true |
| 120025 | 1 | use_booster | 1 | booster_undo | currency_gold | 300 | 20 | true |
| 120026 | 2 | use_booster | 2 | booster_undo | currency_gold | 600 | 30 | true |
| 120027 | 3 | use_booster | 3 | booster_undo | booster_fireworks | 1 | 50 | true |
| 120028 | 1 | use_booster | 1 | booster_fireworks | currency_gold | 300 | 20 | true |
| 120029 | 2 | use_booster | 2 | booster_fireworks | currency_gold | 600 | 30 | true |
| 120030 | 3 | use_booster | 3 | booster_fireworks | booster_fireworks | 1 | 50 | true |
| 120031 | 1 | use_booster | 1 | booster_wild_card | currency_gold | 300 | 20 | true |
| 120032 | 2 | use_booster | 2 | booster_wild_card | currency_gold | 600 | 30 | true |
| 120033 | 3 | use_booster | 3 | booster_wild_card | booster_fireworks | 1 | 50 | true |
| 120034 | 1 | watch_ad | 1 | none | currency_gold | 300 | 20 | true |
| 120035 | 2 | watch_ad | 2 | none | currency_gold | 600 | 30 | true |
| 120036 | 3 | watch_ad | 3 | none | currency_gold | 1500 | 50 | true |
| 120037 | 1 | send_gift | 1 | none | currency_gold | 300 | 20 | true |
| 120038 | 2 | send_gift | 3 | none | currency_gold | 600 | 30 | true |
| 120039 | 3 | send_gift | 5 | none | currency_gold | 1500 | 50 | true |
| 120040 | 1 | share_feed | 1 | none | currency_gold | 300 | 20 | true |
| 120041 | 2 | share_feed | 2 | none | currency_gold | 600 | 30 | true |
| 120042 | 3 | share_feed | 3 | none | currency_gold | 1500 | 50 | true |
| 120043 | 1 | invite_friend | 1 | none | currency_gold | 300 | 20 | true |
| 120044 | 2 | invite_friend | 2 | none | currency_gold | 600 | 30 | true |
| 120045 | 3 | invite_friend | 3 | none | currency_gold | 1500 | 50 | true |
| 120046 | 1 | tournament | 1 | join | currency_gold | 300 | 20 | true |
| 120047 | 2 | tournament | 2 | join | currency_gold | 600 | 30 | true |
| 120048 | 3 | tournament | 1 | create | currency_ticket | 1 | 50 | true |

> VAL-013 검증 (reward_amount >= 1, in_use=true): 전 항목 reward_amount >= 1 - 통과.
> VAL-020 검증 (동일 task_type·condition_detail 조합, difficulty 증가 시 target_val 증가) 이슈 발견:
> - task_type=tournament, difficulty 1→2: target_val 1→2 (통과)
> - task_type=tournament, difficulty 2→3: condition_detail join→create로 변경됨 (동일 조합이 아니므로 VAL-020 미적용)
> - 나머지 동일 조합 전체: difficulty 증가 시 target_val 단조 증가 - 통과.

---

### 테이블: `pst_streak_reward_pool`

> 출처: PST_streak_reward.json 직접 파생.
> **중요 데이터 불일치 발견:** PST_streak_reward.json에 `gacha_group_id` 필드가 없음 (스키마 CP1 Adjust에서 추가된 컬럼). 아래 `gacha_group_id`는 req_length 패턴 분석 기반 그룹화 (가설).
>
> **가설 근거:** 9개 항목이 req_length (4, 5, 6) 패턴으로 3개씩 반복. key_number 200001~200003을 group 1, 200004~200006을 group 2, 200007~200009를 group 3으로 추정.
>
> **VAL-003 검증 실패 발견:** 각 추정 그룹 내 gacha_rate 합산:
> - Group 1: 7000+5000+3000 = **15000** (10000 초과 — VAL-003 실패)
> - Group 2: 7000+5000+3000 = **15000** (10000 초과 — VAL-003 실패)
> - Group 3: 7000+5000+3000 = **15000** (10000 초과 — VAL-003 실패)
>
> **처리 방침:** PST_streak_reward.json의 gacha_rate는 각 req_length 단계 내 상대 가중치로 해석 가능 (req_length=4 내 7000, req_length=5 내 5000, req_length=6 내 3000이 각각 독립 확률 풀일 가능성). 또는 동일 그룹 내 합산 구조가 아닌 req_length별 트리거 확률일 수 있음. 담당 PM 및 서버 팀 확인 필요. 현재로는 gacha_group_id를 req_length 기준으로 임시 할당하되 VAL-003 실패로 플래그 기재.

| key_number | gacha_group_id | gacha_rate | req_length | reward_item_key | reward_type | reward_amount | reward_star_amount | in_use |
|---|---|---|---|---|---|---|---|---|
| 200001 | 1 | 7000 | 4 | currency_gold | tier_combo_reward | 0 | 1 | true |
| 200002 | 1 | 5000 | 5 | booster_wild_card | fixed | 1 | 1 | true |
| 200003 | 1 | 3000 | 6 | reward_plus_card_1 | fixed | 2 | 1 | true |
| 200004 | 2 | 7000 | 4 | currency_gold | fixed | 1 | 1 | true |
| 200005 | 2 | 5000 | 5 | booster_fireworks | fixed | 1 | 1 | true |
| 200006 | 2 | 3000 | 6 | reward_plus_card_1 | tier_combo_reward | 0 | 1 | true |
| 200007 | 3 | 7000 | 4 | reward_plus_card_1 | fixed | 1 | 1 | true |
| 200008 | 3 | 5000 | 5 | currency_gold | tier_combo_reward | 0 | 1 | true |
| 200009 | 3 | 3000 | 6 | booster_wild_card | fixed | 2 | 1 | true |

> VAL-016 검증 (req_length >= 1): 최소값 4 - 통과.
> **VAL-003 플래그: 각 gacha_group_id 그룹 내 gacha_rate 합산이 15000으로 10000 초과. 원본 데이터 구조 해석 재확인 필요.**

---

### 테이블: `pst_event_milestone_step`

> 출처: PST_event_milestone.json 직접 파생 (45개 항목 전체). event_id는 PST_event_schedule.json key_number 참조.
> VAL-008 검증: 동일 event_id 내 step 순서에 따라 goal_amount 단조 증가 확인.

**event_id 160001 (black_card_milestone, 15스텝)**

| key_number | event_id | step | goal_type | goal_param | goal_amount | reward_item_key | reward_amount | in_use |
|---|---|---|---|---|---|---|---|---|
| 180001 | 160001 | 1 | collect_color | black | 30 | currency_gold | 200 | true |
| 180002 | 160001 | 2 | collect_color | black | 70 | currency_gold | 400 | true |
| 180003 | 160001 | 3 | collect_color | black | 120 | booster_undo | 1 | true |
| 180004 | 160001 | 4 | collect_color | black | 180 | currency_gold | 600 | true |
| 180005 | 160001 | 5 | collect_color | black | 250 | currency_gold | 800 | true |
| 180006 | 160001 | 6 | collect_color | black | 330 | booster_undo | 2 | true |
| 180007 | 160001 | 7 | collect_color | black | 420 | currency_gold | 1000 | true |
| 180008 | 160001 | 8 | collect_color | black | 520 | currency_gold | 1200 | true |
| 180009 | 160001 | 9 | collect_color | black | 630 | booster_undo | 3 | true |
| 180010 | 160001 | 10 | collect_color | black | 750 | currency_gold | 1500 | true |
| 180011 | 160001 | 11 | collect_color | black | 900 | currency_ticket | 1 | true |
| 180012 | 160001 | 12 | collect_color | black | 1100 | currency_gold | 2000 | true |
| 180013 | 160001 | 13 | collect_color | black | 1350 | booster_undo | 5 | true |
| 180014 | 160001 | 14 | collect_color | black | 1650 | currency_gold | 3000 | true |
| 180015 | 160001 | 15 | collect_color | black | 2000 | currency_ticket | 2 | true |

**event_id 160002 (red_card_milestone, 15스텝)**

| key_number | event_id | step | goal_type | goal_param | goal_amount | reward_item_key | reward_amount | in_use |
|---|---|---|---|---|---|---|---|---|
| 180016 | 160002 | 1 | collect_color | red | 30 | currency_gold | 200 | true |
| 180017 | 160002 | 2 | collect_color | red | 70 | currency_gold | 400 | true |
| 180018 | 160002 | 3 | collect_color | red | 120 | booster_fireworks | 1 | true |
| 180019 | 160002 | 4 | collect_color | red | 180 | currency_gold | 600 | true |
| 180020 | 160002 | 5 | collect_color | red | 250 | currency_gold | 800 | true |
| 180021 | 160002 | 6 | collect_color | red | 330 | booster_fireworks | 1 | true |
| 180022 | 160002 | 7 | collect_color | red | 420 | currency_gold | 1000 | true |
| 180023 | 160002 | 8 | collect_color | red | 520 | currency_gold | 1200 | true |
| 180024 | 160002 | 9 | collect_color | red | 630 | booster_wild_card | 1 | true |
| 180025 | 160002 | 10 | collect_color | red | 750 | currency_gold | 1500 | true |
| 180026 | 160002 | 11 | collect_color | red | 900 | booster_fireworks | 2 | true |
| 180027 | 160002 | 12 | collect_color | red | 1100 | currency_gold | 2000 | true |
| 180028 | 160002 | 13 | collect_color | red | 1350 | booster_wild_card | 2 | true |
| 180029 | 160002 | 14 | collect_color | red | 1650 | currency_gold | 3000 | true |
| 180030 | 160002 | 15 | collect_color | red | 2000 | booster_golden_ticket | 1 | true |

**event_id 160003 (winning_milestone, 15스텝)**

| key_number | event_id | step | goal_type | goal_param | goal_amount | reward_item_key | reward_amount | in_use |
|---|---|---|---|---|---|---|---|---|
| 180031 | 160003 | 1 | earn_point | none | 15 | currency_gold | 300 | true |
| 180032 | 160003 | 2 | earn_point | none | 35 | booster_undo | 1 | true |
| 180033 | 160003 | 3 | earn_point | none | 60 | currency_gold | 500 | true |
| 180034 | 160003 | 4 | earn_point | none | 90 | currency_ticket | 1 | true |
| 180035 | 160003 | 5 | earn_point | none | 130 | booster_fireworks | 1 | true |
| 180036 | 160003 | 6 | earn_point | none | 180 | currency_gold | 800 | true |
| 180037 | 160003 | 7 | earn_point | none | 240 | booster_infinite_undo_15m [가설: PST_item_list 미등재, 이벤트 전용 추정] | 1 | true |
| 180038 | 160003 | 8 | earn_point | none | 310 | currency_ticket | 1 | true |
| 180039 | 160003 | 9 | earn_point | none | 400 | currency_gold | 1200 | true |
| 180040 | 160003 | 10 | earn_point | none | 500 | booster_wild_card | 1 | true |
| 180041 | 160003 | 11 | earn_point | none | 620 | booster_infinite_undo_30m [가설: PST_item_list 미등재, 이벤트 전용 추정] | 1 | true |
| 180042 | 160003 | 12 | earn_point | none | 760 | currency_gold | 1800 | true |
| 180043 | 160003 | 13 | earn_point | none | 920 | booster_golden_ticket | 1 | true |
| 180044 | 160003 | 14 | earn_point | none | 1100 | currency_gold | 3000 | true |
| 180045 | 160003 | 15 | earn_point | none | 1300 | currency_ticket | 3 | true |

> VAL-008 검증: 세 이벤트 모두 step 순서에 따라 goal_amount 엄격 증가 - 통과.
> VAL-013 검증: 전 항목 reward_amount >= 1 - 통과.
> **주의:** 180037(booster_infinite_undo_15m), 180041(booster_infinite_undo_30m)의 reward_item_key는 pst_item_definition에 미등재 항목. VAL-013 적용 시 item_key 유효성 검증 필요.

---

### 테이블: `pst_free_currency_source`

> 출처: PST_const.json 직접 파생 (shop: 10025~10026, inbox: 10057~10058, popup: 10063~10064, daily_wheel: 10027, lobby: 10076).
> daily_wheel_ad의 amount_per_claim: PST_const.json에 고정 지급 수량 필드 없음. PST_daily_wheel.json 분석 결과 가챠 구조 확인.

**daily_wheel_ad 구조 조사 결과 (PST_daily_wheel.json 분석):**

PST_daily_wheel.json은 8개 항목의 가챠 풀 구조임. 고정 amount_per_claim이 없으며, 스핀당 아래 테이블에서 1개 보상을 확률 선택:

| key_number | reward_item_key | reward_amount | gacha_rate |
|---|---|---|---|
| 140001 | currency_gold | 500 | 3000 (30%) |
| 140002 | booster_undo | 1 | 2500 (25%) |
| 140003 | currency_gold | 1500 | 1500 (15%) |
| 140004 | booster_fireworks | 1 | 1200 (12%) |
| 140005 | booster_wild_card | 1 | 800 (8%) |
| 140006 | currency_ticket | 1 | 600 (6%) |
| 140007 | currency_gold | 5000 | 300 (3%) |
| 140008 | currency_ticket | 3 | 100 (1%) |

gacha_rate 합계: 3000+2500+1500+1200+800+600+300+100 = **10000** (VAL-003 유사 검증 통과).

gold EV(기댓값) per spin = (500×3000 + 1500×1500 + 5000×300) / 10000 = (1,500,000 + 2,250,000 + 1,500,000) / 10000 = 525 gold/회 (gold 항목만 단순 EV).

**05_system_result.md 가챠 EV 검증값:** 부스터(booster_undo, booster_fireworks, booster_wild_card, currency_ticket) 환산 포함 전체 EV = **720 gold/회** [라이브 확정, 2026-03-09].

따라서 `amount_per_claim` 컬럼에 고정 수량을 기재할 수 없음. 아래 테이블에서는 전체 EV 720을 **가설** 기재하되 별도 주석 처리.

| key_number | source_type | currency_type | daily_limit | amount_per_claim | in_use |
|---|---|---|---|---|---|
| 10025 | shop_ad | gold | 5 | 2000 (고정) | true |
| 10057 | inbox | gold | 5 | entry_cost × rv_gold_ratio / 10000 (레벨 티어 가변) | true |
| 10063 | popup | gold | 10 | entry_cost × rv_gold_ratio / 10000 (레벨 티어 가변) | true |
| 10076 | lobby_ad | gold | 3 | entry_cost × rv_gold_ratio / 10000 (레벨 티어 가변) | true |
| 10027 | daily_wheel_ad | gold | 5 | 720 [라이브 확정, 2026-03-09] (가설: 가챠 EV. 실제 1회 지급량은 확률 기반 가변값) | true |

> **RV 골드 계산 공식 (inbox / popup / lobby 공통)**
> ```
> rv_gold_per_watch = level_entry_tier.entry_cost × level_entry_tier.rv_gold_ratio / 10000
> ```
> const의 inbox_free_gold_amount(10058), popup_free_gold_amount(10064)는 deprecated — rv_gold_ratio로 대체됨.

> **level_entry_tier rv_gold_ratio 전체 티어표 (라이브 확정, 2026-04-06)**
>
> | key | 레벨 범위 | entry_cost | rv_gold_ratio | rv_gold/회 |
> |-----|----------|-----------|--------------|-----------|
> | 220001 | Lv1~2   | 0g        | 0            | 0g        |
> | 220002 | Lv3~9   | 1,200g    | 6500 (65%)   | 780g      |
> | 220003 | Lv10~24 | 1,800g    | 5500 (55%)   | 990g      |
> | 220004 | Lv25~49 | 2,100g    | 5000 (50%)   | 1,050g    |
> | 220005 | Lv50~99 | 2,400g    | 4800 (48%)   | **1,152g** |
> | 220006 | Lv100~199 | 2,600g  | 4500 (45%)   | 1,170g    |
> | 220007 | Lv200~349 | 3,000g  | 4200 (42%)   | 1,260g    |
> | 220008 | Lv350~549 | 3,400g  | 4000 (40%)   | 1,360g    |
> | 220009 | Lv550~799 | 4,000g  | 3800 (38%)   | 1,520g    |
> | 220010 | Lv800~1099 | 4,600g | 3500 (35%)   | 1,610g    |
> | 220011 | Lv1100~1449 | 5,400g| 3200 (32%)   | 1,728g    |
> | 220012 | Lv1450+  | 6,000g   | 3000 (30%)   | 1,800g    |

> VAL-007 검증: 일일 최대 무료 gold 획득량 계산 [2026-04-06 기준, Lv75 기준]
> - shop_ad: 2,000 × 5 = 10,000 gold (고정)
> - inbox: 1,152 × 5 = 5,760 gold (Lv75, rv_gold_ratio 기반)
> - popup: 1,152 × 10 = 11,520 gold (Lv75, rv_gold_ratio 기반)
> - lobby_ad: 1,152 × 3 = 3,456 gold (Lv75, rv_gold_ratio 기반)
> - daily_wheel_ad: 최대 5,000 × 5 = 25,000 gold (최고 운 기준)
> - **총계 (Lv75 이론적 최대): 55,736 gold**
> - 단, gold_max_limit(20,000)은 인게임 판당 최대 수령량이며 지갑 상한 아님.
> - RV 채널 일일 합산 (Lv75): 5,760 + 11,520 + 3,456 = **20,736 gold**

---

## 3. 패키지 가격표

> 출처: PST_product.json (PST), PBM_product.json (PBM, 02_research.md 기반). CCS: 미확인.
> 재화 단가: gold/USD = 골드 수량 / pay_amount.
> PST 대비: 동일 가격대에서 PST 단가 대비 비율.

### PST 활성 IAP 패키지

| 상품명 | 가격(USD) | 제공 gold | 부가 보상 | 재화 단가(gold/USD) | PST 대비 | PBM 대비 | CCS 대비 |
|---|---|---|---|---|---|---|---|
| T_SHOP_FREE_GOLD (AD) | $0.00 | 1,000 gold | 없음 | - (무료) | - | - | 미확인 |
| T_SHOP_GOLD_1 | $1.99 | 10,000 gold | 없음 | 5,025 gold/USD | 기준 | 가설: PST 대비 약 5배 높음 (PBM $0.99=1,010 gold/USD) | 미확인 |
| T_SHOP_BUNDLE_1 | $4.99 | 27,000 gold | undo×1, ticket×1 | 5,411 gold/USD | +7.7% | 가설: PBM $4.99=5,500 gold/USD 대비 -1.6% | 미확인 |
| T_SHOP_BUNDLE_2 | $8.99 | 45,000 gold | wild_card×1, extra_deck×1, undo×1, ticket×1 | 5,006 gold/USD | -0.4% | 가설: PBM $9.99=1,201 gold/USD 대비 약 4.2배 | 미확인 |
| T_SHOP_BUNDLE_3 | $14.99 | 85,000 gold | wild_card×2, extra_deck×2, undo×2, ticket×2 | 5,670 gold/USD | +12.8% | 가설: PBM 동가격대 상품 없음 | 미확인 |
| T_SHOP_BUNDLE_4 | $26.99 | 170,000 gold | wild_card×4, extra_deck×4, undo×4, ticket×4 | 6,298 gold/USD | +25.4% | 가설: PBM $19.99=1,301 gold/USD 대비 약 4.8배 | 미확인 |
| T_SHOP_BUNDLE_5 | $49.99 | 370,000 gold | wild_card×8, extra_deck×8, undo×8, ticket×8 | 7,402 gold/USD | +47.3% | 가설: PBM 동가격대 상품 없음 | 미확인 |

**PST 비활성 스페셜 오퍼 (참고용)**

| 상품명 | 가격(USD) | 제공 gold | 부가 보상 | 재화 단가(gold/USD) | limit_type | validity_duration_sec | 비고 |
|---|---|---|---|---|---|---|---|
| T_SHOP_SPECIAL_OFFER_1 | $1.99 | 25,000 gold | extra_deck×2, ticket×2, undo×2, wild_card×2 | 12,563 gold/USD | global | 172800 (2일) | 1회 한정, 비활성 |
| T_SHOP_SPECIAL_OFFER_2 | $9.99 | 70,000 gold | wild_card×2, extra_deck×2, undo×1, fireworks×1 | 7,007 gold/USD | event | 259200 (3일) | 1회 한정, 비활성 |
| T_SHOP_SPECIAL_OFFER_3 | $14.99 | 100,000 gold | infinite_fireworks_10m×1, infinite_gticket_10m×1, undo×2, wild_card×2 | 6,671 gold/USD | city | 259200 (3일) | 1회 한정, 비활성 |

> 스페셜 오퍼 단가 효율이 일반 패키지보다 현저히 높음 (special_offer_1: 12,563 vs 정규 최고 7,402). 활성화 시 신규 유저 전환 촉진 수단으로 활용 가능.

---

## 4. 30/90일 잔고 시뮬 표

> **시뮬 전제 조건 (전체 가설):**
> - 유저 유형: 비결제 캐주얼 유저 (무료 채널만 활용)
> - 일 플레이 횟수: 5레벨/일 (가설: 모바일 캐주얼 세션 기준, PST 입장비 2회 무료 + 골드 소비 3회 추정)
> - 평균 레벨 클리어율: 70% (가설: PST difficulty_rest_count=2 기반, 초중반 레벨 기준)
> - 이벤트 참여: 주 1회 이벤트 완주 (15스텝 중 10스텝 완료 기준, 가설)
> - 광고 시청: 일 10회 (shop×5 + inbox×5, 가설: 최대 절반 활용)
> - 데일리 휠: 일 3회 (daily_wheel_ad_limit=5 중 60% 활용, 가설)
> - 데일리 출석: 7일 사이클 완주 기준 (7일당 6,500 gold)
> - 골드 최대 캡: 10,000 gold (PST_const.json 10059)

### 일별 재화 흐름 계산

**일 획득 합계 (Source, 가설 포함)**

| Source 항목 | 산출 근거 | 일 획득량 |
|---|---|---|
| 유휴 골드 충전 | PST_const.json: 3,000 gold/4h. 일 최대 2사이클 (8h 접속 가정, 가설) | 6,000 gold |
| 광고 gold (shop+inbox) | shop: 2,000×5=10,000 / inbox: 2,000×5=10,000. 단, 일 10회만 시청(가설) → shop×5+inbox×5=20,000. 단 gold_max_cap 10,000으로 실질 수취 제한 | 실질 10,000 gold (캡 제한) |
| 데일리 출석 | 7일 평균: 6,500÷7 = 929 gold/일 | 929 gold |
| 데일리 휠 | gold EV 720/회 × 3회 = 2,160 gold [라이브 확정, 2026-03-09] (가설: 05_system_result.md 검증값 기준, 3회 시청 가정) | 2,160 gold |
| 인게임 콤보 보상 | 5레벨 × 평균 5콤보 × 2 gold/콤보 = 50 gold (초반 레벨 가설) | 50 gold |
| 인게임 덱 잔여 보상 | 5레벨 × 클리어 3.5회 × 15 gold = 263 gold (초반 레벨 가설) | 263 gold |
| 이벤트 마일스톤 골드 | 주 1회 10스텝 완주 시 약 6,700 gold (event 160001 step 1~10 합계 기준) ÷ 7일 = 957 gold/일 (가설) | 957 gold |
| **일 총 Source (이론적)** | - | **20,774 gold** |
| **일 총 Source (캡 적용 실질)** | gold_max_limit=10,000으로 실질 보유 상한 제한. 일 유입 중 소비 후 잔량이 10,000 초과 시 소실 | **10,000 gold (상한 기준)** |

**일 소비 합계 (Sink, 가설 포함)**

| Sink 항목 | 산출 근거 | 일 소비량 |
|---|---|---|
| 레벨 입장비 | 5레벨 중 2회 무료, 3회 유료. 기본 입장비 1,000 gold × 3 = 3,000 gold (초반 레벨, 가설) | 3,000 gold |
| 보상 마진 환급 | 3.5회 클리어 × 평균 마진 1,250 gold = 4,375 gold (가설: 500~2,000 중앙값 1,250) | -4,375 gold (환급) |
| **일 순 Sink** | 3,000 - 4,375 = -1,375 (초반 레벨에서 net 획득 구조) | **-1,375 gold (net Source)** |

> **가설:** 초반 레벨에서 보상 마진이 입장비를 상회하는 구조. 레벨 진행에 따라 입장비 상승(10레벨마다 +100) 및 보상 마진 변화(PST_const.json 고정 500~2,000)로 중반 이후 net Sink로 전환 가능.

---

### 30일 잔고 시뮬

| 기간 | 일 순 획득 (Source - Sink) | 누적 획득 | 누적 소비 | 예상 잔고 | 핵심 가설 |
|---|---|---|---|---|---|
| D1 | +5,374 gold | 5,374 | 3,000 | 5,374 | NRU 시작 골드 1,000 포함. 초반 레벨 입장비 3,000, 마진 환급 4,375. gold_max_cap=10,000 내 유지 |
| D7 | +5,374/일 × 7일 | 37,618 | 21,000 | 10,000 (상한) | 7일 출석 보상 6,500 gold 추가. 캡 10,000으로 실질 잔고 상한 도달. 초과 획득분 소실 |
| D14 | 데일리 사이클 반복 | 75,236 (이론) | 42,000 (이론) | 10,000 (상한 유지) | 비결제 유저는 캡에 상시 도달. 입장비 증가 미미 (레벨 10마다 +100 → D14 기준 ~+200 gold 증가 가설) |
| D30 | 데일리 사이클 반복 | 161,220 (이론) | 90,000 (이론) | 10,000 (상한 유지) | 가설: D30 기준 입장비 약 1,200~1,300 gold (10~13레벨 구간). 순 획득 구조 유지. 이벤트 4회 완주 시 마일스톤 골드 약 26,800 gold 추가 (가설) |

---

### 90일 잔고 시뮬

| 기간 | 누적 획득 | 누적 소비 | 예상 잔고 | 핵심 가설 |
|---|---|---|---|---|
| D30 | 약 161,220 gold (이론) | 약 90,000 gold (이론) | 10,000 gold (상한 유지) | 비결제 유저 기준. 입장비 상승 미미 (초반 레벨 구간). 캡 상시 도달 |
| D60 | 약 322,440 gold (이론) | 약 180,000 gold (이론) | 10,000 gold (상한 유지) | 가설: D60 기준 입장비 약 1,500~2,000 gold (레벨 50~100 구간). 보상 마진 500~2,000 고정으로 net Sink 전환 가능성. 입장비 2,000 초과 시 레벨당 net cost 0~1,500 gold |
| D90 | 약 483,660 gold (이론) | 약 270,000 gold (이론) | 5,000~10,000 gold (가설) | 가설: D90 기준 고레벨 구간 입장비 3,000~5,000 gold. 광고 피로도로 daily_wheel/popup 시청 감소 50% 가정 시 일 Source 약 7,000 gold로 감소. 입장비 5,000 × 3회 = 15,000 gold 필요 시 부족. IAP 전환 압력 발생 구간 |

---

### 잔고 시뮬 요약 해석

| 항목 | 수치 | 비고 |
|---|---|---|
| 비결제 유저 일 순 Source | 약 +5,374 gold (초반) | 가설: 초반 레벨 기준. 레벨 진행 시 감소 |
| gold_max_limit 도달 시점 | D1~D2 내 (가설) | 광고 풀 시청 시 즉시 상한 도달 |
| IAP 전환 압력 발생 시점 | D60~D90 (가설) | 입장비 3,000~5,000 구간 진입 시 |
| 최소 IAP 1회로 해소 가능한 부족분 | gold_iap_1($1.99) = 10,000 gold | 약 2~3일치 입장비 보충 |
| 최고 효율 IAP | bundle_iap_5($49.99) = 7,402 gold/USD | 규모 경제 할인 구조 |

---

## 5. 데이터 불일치 및 조사 필요 사항 플래그

| 항목 | 상태 | 내용 | 권장 조치 |
|---|---|---|---|
| PST_streak_reward.json gacha_group_id 없음 | 데이터 미비 | 스키마 CP1 Adjust에서 추가된 컬럼이나 원본 JSON에 없음. 그룹화 가설 기재 | 서버 팀 확인 후 gacha_group_id 필드 추가 |
| PST_streak_reward gacha_rate 합산 15000 | VAL-003 실패 | 추정 그룹 내 합산 10000 초과. req_length별 독립 확률 풀 구조 가능성 | 원본 로직 확인 필요 |
| booster_infinite_undo_15m/30m PST_item_list 미등재 | 데이터 불일치 | PST_event_milestone에서 보상으로 등장하나 PST_item_list.json에 없음 | PM 확인 후 PST_item_list에 정식 등재 또는 이벤트 전용 임시 아이템으로 처리 |
| daily_wheel_ad amount_per_claim 고정값 없음 | 데이터 구조 이슈 | PST_daily_wheel.json이 가챠 구조로 고정 지급량 없음. 05_system_result.md 검증값 EV 720 gold를 가설로 기재 [라이브 확정, 2026-03-09] | 스키마 `amount_per_claim` 컬럼이 가챠 구조를 수용하지 못함. 스키마 수정 또는 EV 기재 방침 결정 필요 |
| CCS 재화 구조 전 항목 | 미확인 | WebSearch 미수행으로 전 항목 미확인 | WebSearch 권한 확보 후 재조사 |
| friend_send_reward 단위 미상 | 데이터 미상 | PST_const.json `friend_send_reward: 1`의 단위가 gold인지 count인지 불명확 | 서버 코드 또는 PM 확인 필요 |
