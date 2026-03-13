---
agent: 01_pm
mode: cp2
scope: PST 경제·게임 밸런스 검수
executed: 2026-03-09T20:00:00+09:00
status: complete
verdict: Adjust
adjust_targets: [02_economic_balance, 03_game_balance]
---

# 01 PM 에이전트 — CHECKPOINT-2 밸런스 검수 보고서

---

## 검수 데이터 소스 상태 확인

| 파일 | 상태 | 비고 |
|---|---|---|
| `workspace/02_economic_result.md` | complete | 검수 대상 (경제 밸런스) |
| `workspace/03_balance_result.md` | complete | 검수 대상 (게임 밸런스) |
| `workspace/04_schema_validation.md` | complete, overall=FAIL | 스키마 검증 결과 참조 |
| `workspace/06_simulation_result.md` | complete | idle_increase=400 라이브 확정값 반영 |
| `workspace/08_booster_analysis.md` | complete | 부스터 가격 구조 분석 |
| `workspace/05_system_result.md` | complete | 시스템 명세 참조 |

`status: error` 파일 없음. 전 파일 가용 데이터로 검수 진행.

---

## 1. KPI 적합성 중간 체크

> 기준값 근거: PST_const.json (레퍼런스 스냅샷), 시뮬레이션 v2 라이브 확정값.
> 직접 측정값 없는 항목은 "가설" 표기.

| KPI 항목 | 기준값(레퍼런스) | 02 제안값 | 03 제안값 | 판정 | 비고 |
|---|---|---|---|---|---|
| D1 리텐션 — NRU 초기 골드 지급 | PST: nru_start_gold=1,000g | 1,000g (PST 직접 채택) | 해당 없음 | PASS | 02가 PST 원본 수치 그대로 적용 |
| D1 리텐션 — Tutorial 난이도 보호 | PST: tier_id=1, help_card_rate=8000 (Lv1-8 강제) | 해당 없음 | help_card_rate=8000, pity=3 (가설: 승률 70~80%) | PASS | 03 가설 근거 레퍼런스 파라미터 명시. Tutorial→Normal 전환 구간(Lv9-10) 완충 설계 확인 |
| D1 리텐션 — 초반 이탈 유발 구간 여부 | PST: Lv1-2 entry_cost=0 (무료), Lv3~부터 1,000g | 02는 entry_cost 구간 테이블 제시 없음. 시스템5 확인: Lv1-2=0g, Lv3-9=1,000g | 03은 DDA 룰 구조 기반 난이도 설계. Lv1-8 Tutorial 강제 보호 | WARN | **02_economic_result.md에 level_entry_tier 전체 테이블 미포함.** Lv3-9 입장비 1,000g 설정이 NRU 1,000g 지급 후 즉시 소진 가능 구조. 05_system_result.md level_entry_tier에서 확인됨. 레퍼런스 PST 원본과 일치하나 D1 이탈 리스크 존재 (WARN) |
| D7 리텐션 — 7일 출석 보상 | PST: 7일 누적 6,500g + 부스터 4개 + ticket 3개 | 동일 적용 (pst_daily_gift_schedule) | 해당 없음 | PASS | PST 원본 수치 직접 채택. VAL-009/010 PASS 확인 |
| D7 리텐션 — 재방문 동기 구조 | PST: 데일리 휠 5회/일, 이벤트 주 3회 운영 | 데일리 휠 5회/일, 이벤트 3종 스케줄 채택 | 이벤트 스케줄 4종 운영, 요일별 중복 설계 | PASS | 이벤트 중복 운영(화/수: black+winning, 목: red+winning) 유저 참여 동기 강화 의도 확인. 가설 표기 포함 |
| ARPDAU — 통화 수급·소비 구조 | PST 레퍼런스 기준: 비부스터 유저 골드 축적 구조 (인플레 경향) | 비부스터 전 유형 일 순공급 +10,928g~+29,551g (시뮬v2) | 해당 없음 | WARN | 골드 인플레이션 구조 지속 확인. idle_increase=400 적용 후에도 비부스터 평균 유저 +17,542g/일. IAP 전환 압력은 D60-90 구간 (가설). 수익화 흐름과 직접 충돌은 없으나 골드 가치 희석으로 인한 ARPDAU 장기 영향 주의 |
| ARPDAU — IAP 패키지 구조 | PST: $1.99~$49.99, 5종 번들 | $1.99~$49.99 7종 활성 상품 (PST 동일) | 해당 없음 | PASS | 가격 구조 PST 원본 유지. 스페셜 오퍼 비활성(4종) 확인 |
| 스키마 준수 | — | WARN×6, FAIL×2 | PASS (pst_event_schedule) | FAIL | 04_schema_validation.md 전체 판정 FAIL. FAIL 2건 수정 필수 |
| 밸런스 정합성 | — | — | — | WARN | 섹션 2에서 상세 검토 |
| 가설 표기 | — | 가설 항목에 표기 있음 (일부 행 누락) | 가설 항목 전반 표기 있음 | WARN | 04_schema_validation.md #8: pst_event_milestone_step 행 180037/180041 가설 표기 누락 확인 |

---

## 2. 경제·게임 밸런스 정합성 검토

| 확인 항목 | 경제 밸런스 (02) 수치 | 게임 밸런스 (03) 수치 | 충돌 여부 | 조정 방향 |
|---|---|---|---|---|
| 일일 패시브 골드 공급 (Lv75) | 시뮬v2: 26,024g/일 (idle 12,600 + popup 8,000 + inbox 4,000 + 데일리휠 1,200 + 출석 224) | 03 문서에 골드 공급 수치 미기재 | 충돌 없음 (범위 비교 불가) | 03 문서는 재화 수치 비담당이나, 승률 가설(Normal 55~65%)이 게임 순소모(-112g/게임)와 연동되는 구조. 수치 충돌 없음 확인 |
| 레벨 입장비 — 02 기준 | 02: base 1,000g, 10레벨마다 +100, 상한 5,000g (PST_const.json 10007~10011) | 03: 레벨별 DDA 티어 전환 조건에서 입장비 수치 직접 언급 없음 | 충돌 없음 | 05_system_result.md level_entry_tier 테이블로 교차 확인. Lv50-99=2,000g 확정 |
| 레벨 입장비 — 05 실제 테이블 | 05: Lv3-9=1,000g, 10-24=1,500g, 25-49=1,800g, 50-99=2,000g … 1450+=5,000g | 해당 없음 | **02와 05 간 충돌 발견**: 02는 PST_const.json 기반 "기본 1,000g + 10레벨마다 +100 + 상한 5,000g" 단순 선형 구조를 기재. 05는 level_entry_tier 시트(라이브)에서 비선형 구간 테이블을 확인. 두 구조가 다름 | **02 수정 필요**: pst_entry_cost_config 테이블이 PST_const.json 스냅샷 기반 단순 선형 구조를 기재했으나, 라이브 시트 level_entry_tier는 구간별 비선형 입장비 테이블. 02의 pst_entry_cost_config를 level_entry_tier 구간 테이블로 교체 필요 |
| 보상 마진 — 02 기준 | 02: reward_margin_min=500g, reward_margin_max=2,000g (PST_const.json 10012~10013) | 03: 해당 수치 미언급 | 충돌 없음 | 05 시스템명세에서 덱 보너스 20g/카드(Lv75), 스트릭 미터 80g 확인. 02 reward_margin 구조와 별개 구조로 병존 가능 |
| 콤보 보상 — 02 vs 05 | 02: ingame_combo_reward_base=2g (const 10047, 스냅샷 기준) | 05: combo_reward_base=3g (Lv50-99, 라이브 level_entry_tier 기준) | **충돌**: 02가 PST_const.json 스냅샷 base=2g를 기재. 05의 라이브 시트에서 Lv50-99 구간 combo_reward_base=3g 확인 | **02 수정 필요**: pst_ingame_reward_config에서 combo base=2g(const 기반)와 라이브 level_entry_tier base=3g(Lv50+) 간 불일치. 02가 스냅샷 기반 단일 값으로 기재한 것이 원인. 레벨 구간별 테이블 참조 명시 또는 주석 추가 필요 |
| 데일리 휠 gold EV — 02 vs 05 | 02: EV=525g/회 (PST_daily_wheel.json gacha 분석) | 05: EV=720g/회 (daily_wheel 라이브 시트 분석 — 800g×30% + 2,000g×15% + 6,000g×3%) | **충돌**: 02가 500/1,500/5,000 기준 EV 525g, 05가 800/2,000/6,000 기준 EV 720g. 골드 금액 단위 자체가 다름. 02는 PST_daily_wheel.json 스냅샷, 05는 라이브 시트 | **02 수정 필요**: pst_free_currency_source의 daily_wheel_ad amount_per_claim을 라이브 시트 기준 EV 720g(가설)으로 수정. 스냅샷-라이브 괴리 근거 명시 필요 |
| 광고 보상 금액 — 02 vs 05 | 02: inbox=2,000g/회, popup=2,000g/회 (PST_const.json 스냅샷) | 05: inbox=800g/회, popup=800g/회 (라이브 시트 PM 승인값) | **충돌**: 02가 스냅샷 2,000g 기재. 05가 라이브 확정값 800g 기재. 일 공급량이 02 기준 최대 65,000g vs 05 기준 15,600g으로 2.5배 이상 차이 | **02 수정 필요**: pst_free_currency_source 및 pst_currency_config의 inbox/popup free_gold_amount를 라이브 확정값 800g으로 수정. "가설: PM 승인" 표기 필요 |
| idle_gold_max_cap — 02 vs 05 | 02: idle_gold_max_cap=8,000g (PST_const.json key 10006 스냅샷) | 05: idle_gold_max_cap=10,000g (simulation v2 기준) | **충돌**: 02가 스냅샷값 8,000g 기재. 05가 라이브 기준 10,000g 기재 | **02 수정 필요**: pst_currency_config key 10006 값을 10,000g으로 수정. "가설: 라이브 시트 확정" 표기 필요. 다만 05에서도 "simulation v2 기준"으로 명시하여 원본 시트 재확인 권고 |
| DDA — Normal 티어 fail_streak 복귀 | 해당 없음 (02는 DDA 미담당) | 03: fail_streak=2연패 즉시 Normal 복귀 (dynamic_level 30003). 예상 체류 비율 Normal 50~60% (가설) | 충돌 없음 | DDA 구조가 입장비/골드 소모 패턴과 간접 연동. Normal 티어(help_card=50%)에서 클리어율 가설 55~65%가 시뮬v2 85% 가정과 상이. 단, 시뮬v2는 Lv75 대표값, 03은 티어별 가설이므로 직접 충돌은 아님 |
| 이벤트 스케줄 — 03 담당 | 02: 이벤트 마일스톤 스텝 45개 전체 기재 (event_id 160001~160003) | 03: pst_event_schedule 4종 스케줄 기재 (key 160001~160004) | 충돌 없음 | 02가 event_milestone, 03이 event_schedule 분리 담당. 두 테이블의 event_id 참조 일치(160001~160003 공통). clear_ranking(160004)은 milestone 연동 없음 확인 |
| 메타 sink 규모 | 02: 02_research.md에서 직접 다루지 않음. 08_booster_analysis에서 총 283,600g 확인 | 03: 해당 없음 | 충돌 없음 | 시뮬v2 기준 메타 sink 60일(해머 gate). 골드 기여도 10.9일치(1.3%). 구조적 인플레이션 원인으로 진단됨 |

---

## 3. 스키마 검증 결과 반영

`04_schema_validation.md` 전체 판정: **FAIL**

수정이 필요한 FAIL/WARN 항목:

| # | 심각도 | 에이전트 | 테이블 | 문제 | CP2 조치 방향 |
|---|---|---|---|---|---|
| 1 | FAIL | 02 | `pst_streak_reward_pool` | gacha_group_id 가설 할당 + 각 그룹 gacha_rate 합산 15,000 (VAL-003 실패) | 서버 팀 원본 로직 확인 후 재기재. 확인 전까지 "가설" 표기 유지 필수. 합산 기준이 req_length별 독립 확률인 경우 VAL-003 적용 범위 재정의 필요 |
| 2 | FAIL | 02 | `pst_item_definition` | booster_infinite_undo_15m/30m 미등재 (pst_event_milestone_step 180037/180041 참조) | pst_item_definition에 두 아이템 등재 또는 별도 이벤트 전용 아이템 테이블 처리. PM 확인 후 결정 |
| 3 | WARN | 02 | `pst_free_currency_source` | daily_wheel_ad amount_per_claim=525(가설 EV). 실제 가챠 구조와 스키마 타입 불일치 | 라이브 시트 EV 720g으로 수정 + 스키마 컬럼 처리 방침 결정 (EV 기재 허용 또는 가챠 참조 컬럼 추가) |
| 4 | WARN | 02 | `pst_product_definition` | 비활성 상품(190003, 190101~190103) 행에 label_type, max_display_count 컬럼 누락 | 비활성 행에 해당 컬럼 추가 기재 (none/0 기재 또는 원본 확인) |
| 5 | WARN | 02 | `pst_currency_config` | key 10015 friend_send_reward 단위 미상 (unit=count 임시 기재) | 서버 코드 또는 PM 확인 후 단위 확정 |
| 6 | WARN | 복수 | 복수 테이블 | 교차 테이블 key_number 중복 (VAL-001 교차) | 스키마 방침 확정: PST_const.json 원본 key 재사용 허용 여부 결정 후 명시 |
| 7 | WARN | 02 | `pst_streak_reward_pool` | gacha_group_id 전체 값 가설 (원본 미존재) | 항목 #1과 연계하여 서버 팀 확인 후 정식 할당 |
| 8 | WARN | 02 | `pst_event_milestone_step` | 행 180037/180041 reward_item_key에 가설 표기 누락 | 해당 두 행에 "(가설: PST_item_list.json 미등재 아이템)" 표기 추가 |

---

## 4. 추가 CP2 발견 사항 — 스냅샷/라이브 괴리 (WARN)

04_schema_validation.md에 미포함된 사항으로, 본 CP2 교차 검토에서 신규 발견.

| # | 에이전트 | 항목 | 스냅샷 값 (PST_const.json) | 라이브 확정값 (시트/시뮬v2) | 판정 | 조치 |
|---|---|---|---|---|---|---|
| A | 02 | `idle_gold_amount_increase` (key 10005) | 1,200g | **400g** (라이브 시트 PM 승인 확정) | FAIL | **02 수정 필수**: pst_currency_config key 10005 값을 400g으로 수정. "가설" 표기 포함 |
| B | 02 | `idle_gold_max_cap` (key 10006) | 8,000g | 10,000g (시뮬v2 기준) | WARN | 02 수정 권고: 10,000g으로 수정. 원본 시트 재확인 후 확정 |
| C | 02 | `inbox_free_gold_amount` (key 10058) | 2,000g | **800g** (라이브 시트 PM 승인 확정) | FAIL | **02 수정 필수**: pst_currency_config key 10058 및 pst_free_currency_source inbox 행 800g으로 수정 |
| D | 02 | `popup_free_gold_amount` (key 10064) | 2,000g | **800g** (라이브 시트 PM 승인 확정) | FAIL | **02 수정 필수**: pst_currency_config key 10064 및 pst_free_currency_source popup 행 800g으로 수정 |
| E | 02 | `daily_wheel_ad` 골드 금액 | EV 525g (스냅샷 500/1,500/5,000g 기반) | EV 720g (라이브 800/2,000/6,000g 기반) | WARN | 02 수정 권고: EV 525g → 720g(가설)으로 수정. 라이브 가챠 풀 금액 단위 변경 근거 명시 |
| F | 02 | `pst_entry_cost_config` 구조 | PST_const.json 기반 선형 구조 (기본 1,000 + 10레벨마다 +100) | 라이브 level_entry_tier 비선형 구간 테이블 (Lv3-9=1,000g, 10-24=1,500g 등 12개 구간) | WARN | 02 수정 권고: pst_entry_cost_config를 구간별 테이블로 확장하거나 "가설: 라이브 시트와 구조 상이" 주석 추가 |

---

## 5. KPI 연동 리스크 평가

| KPI | 리스크 | 근거 | 심각도 |
|---|---|---|---|
| D1 리텐션 | NRU 1,000g 지급 후 Lv3 첫 유료 입장(1,000g) 즉시 소진 가능. Tutorial Lv1-2는 무료이나 Lv3 진입 시 잔고 0 도달 위험 | level_entry_tier Lv1-2=0g, Lv3-9=1,000g. nru_start_gold=1,000g | WARN |
| D7 리텐션 | 7일 출석 6,500g + 이벤트 보상 구조로 재방문 동기 충분. DDA Tutorial 보호(Lv1-8) 이탈 방지 설계 적절 | PST_daily_gift.json, dynamic_level 30001 | PASS |
| ARPDAU | 비부스터 유저 골드 과잉 공급 구조(+17,542g/일 평균)로 골드 가치 희석. 부스터 집중 유저만 디플레(-29,058g/일). IAP 전환 압력 D60-90 (가설). 경제 건강도 B등급 | simulation v2 Table C, Section G | WARN |
| 장기 리텐션 | 메타 60일 완주 후 골드 sink 소멸. 콜렉션 미활성(is_album/deck_collection_open=0). 60일 이후 이탈 트리거 잠재적 | simulation v2 Section E-4, PST_const.json 10061/10062 | WARN |

---

## 6. 수정 필요 에이전트별 항목

| 에이전트 | 테이블명/항목 | 문제 | 수정 방향 |
|---|---|---|---|
| **02** | `pst_currency_config` key 10005 | idle_gold_amount_increase=1,200g (스냅샷) vs 라이브 확정 400g | 400g으로 수정. "가설: 라이브 시트 PM 승인" 표기 |
| **02** | `pst_currency_config` key 10058 | inbox_free_gold_amount=2,000g (스냅샷) vs 라이브 확정 800g | 800g으로 수정. "가설: 라이브 시트 PM 승인" 표기 |
| **02** | `pst_currency_config` key 10064 | popup_free_gold_amount=2,000g (스냅샷) vs 라이브 확정 800g | 800g으로 수정. "가설: 라이브 시트 PM 승인" 표기 |
| **02** | `pst_free_currency_source` inbox/popup 행 | amount_per_claim=2,000g (스냅샷 기준) | 800g으로 수정 |
| **02** | `pst_free_currency_source` daily_wheel_ad 행 | amount_per_claim EV=525g (스냅샷 가챠 금액 기준) | EV 720g (가설)으로 수정. 라이브 가챠 금액 변경 근거 명시 |
| **02** | `pst_streak_reward_pool` | gacha_group_id 가설 할당 + gacha_rate 합산 15,000 (VAL-003 FAIL) | 서버 팀 확인 후 재기재. 확인 전 현행 유지하되 FAIL 플래그 명시 |
| **02** | `pst_item_definition` | booster_infinite_undo_15m/30m 미등재 (참조 무결성 FAIL) | PM 확인 후 정식 등재 또는 이벤트 전용 별도 처리 |
| **02** | `pst_event_milestone_step` 행 180037/180041 | reward_item_key 가설 표기 누락 | "(가설: PST_item_list.json 미등재 아이템)" 표기 추가 |
| **02** | `pst_product_definition` 비활성 상품 행 | label_type, max_display_count 컬럼 누락 | 비활성 행에 해당 컬럼 추가 (none/0 또는 원본 확인 후 기재) |
| **02** | `pst_currency_config` key 10015 | friend_send_reward unit 미상 (count 임시 기재) | PM/서버 확인 후 확정 |
| **02** | `pst_entry_cost_config` | PST_const.json 기반 선형 구조 vs 라이브 level_entry_tier 비선형 구간 테이블 구조 불일치 | 구간 테이블로 확장하거나 불일치 근거 주석 추가 |
| **03** | `pst_event_schedule` (담당 테이블) | VAL-003 등 확률 검증 대상 아님. PASS 판정 유지 | 수정 불필요. 단, 160004 clear_ranking end_day=0 (주간 경계 운영 여부) 구현 확인 권고 |
| **03** | 난이도 곡선·승률 가설 표 | 스키마 외 테이블이나 가설 표기 완결성 PASS. 기믹 spawn_rate 실데이터 없음 | 수정 불필요. 출시 후 실측 데이터 확보 시 가설 수치 교체 필요 |

---

## 7. CP2 판정

**판정: Adjust**

| 판정 근거 | 내용 |
|---|---|
| **수정 필수 항목 (FAIL)** | 4건: ①idle_increase 스냅샷/라이브 괴리 ②inbox/popup gold amount 스냅샷/라이브 괴리 ③pst_streak_reward_pool VAL-003 FAIL ④pst_item_definition 참조 무결성 FAIL |
| **수정 권고 항목 (WARN)** | 8건: entry_cost 구조 불일치, daily_wheel EV 괴리, idle_max_cap 괴리, 비활성 상품 컬럼 누락, friend_send_reward 단위 미상, key_number 교차 중복 방침 미결, gacha_group_id 가설, 가설 표기 2행 누락 |
| **Go 전환 조건** | FAIL 4건 수정 완료 후 재제출. WARN 항목은 서버 팀·PM 확인 의존 항목 포함으로 출시 전 단계적 해소 허용 |
| **Stop 아닌 이유** | 구조적 밸런스 문제(골드 인플레이션)는 시뮬v2에서 이미 진단·개선안(idle_increase=400 라이브 반영, 부스터 누진 채택) 확인됨. 수치 오류는 스냅샷-라이브 괴리로 데이터 교체 수준이며 설계 구조 자체 재설계 불필요 |

### Adjust 대상 에이전트

| 에이전트 | 수정 항목 수 (FAIL) | 수정 항목 수 (WARN) | 우선순위 |
|---|---|---|---|
| **02_economic_balance** | 4 | 7 | 높음 — 라이브 확정값 반영 및 스키마 FAIL 2건 해소 필수 |
| **03_game_balance** | 0 | 0 (구현 확인 권고 1건) | 낮음 — 수정 불필요. 출시 후 실측 데이터 교체만 예정 |

---

*문서 종료. CP2 완료 (2026-03-09T20:00:00+09:00)*
