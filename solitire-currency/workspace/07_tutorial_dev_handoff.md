# PST 튜토리얼 개발자 핸드오프 문서

> **목적**: 클라이언트 개발자가 바로 구현 착수할 수 있는 데이터 기반 명세
> **최종 수정**: 2026-03-18 (v7 시트 재키잉 — 229xxx→230xxx, content_lobby_play 230003 추가, Lv1~3 강제 클리어)
> **데이터 소스**: Google Sheets `1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk` (unlock, tutorial_guide 시트)

---

## 1. 시스템 개요

| 항목 | 값 |
|------|-----|
| 아키텍처 | 2-시트 (unlock + tutorial_guide) |
| unlock 항목 | 26행 |
| tutorial_guide 가이드 | 28행 |
| Phase 수 | 7개 (Phase 0~6) |
| 전용맵 (is_dedicated_map) | 9건 |
| trigger_type | 5종 |
| guide_type | 2종 (focus_bubble / floating) |
| Tutorial 티어 구간 | Lv 1~8 (help_card_rate 80%, pity_trigger 3회) |
| Normal 전환 | Lv 9~ |

---

## 2. unlock 시트 (26행)

> "언제, 어떤 조건으로 콘텐츠가 열리는가"

| key | content_id | condition_type | val | pre_unlock_visibility | show_tutorial | 비고 |
|-----|-----------|----------------|-----|----------------------|---------------|------|
| 50001 | content_city_deco | level | 1 | FALSE | TRUE | 도시 꾸미기 |
| 50002 | content_tournament | level | 1 | FALSE | FALSE | 토너먼트 |
| 50009 | content_betting_1 | level | **1** | FALSE | **FALSE** | 베팅x1 기본 해금 (Lv1부터) |
| 50003 | content_shop | level | 3 | TRUE | TRUE | 상점 |
| 50004 | content_pre_level_popup | level | **2** | FALSE | TRUE | 프리레벨 팝업 (Lv2 클리어 후) |
| 50005 | content_idle_gold | level | 4 | TRUE | TRUE | 방치골드 |
| 50006 | gimmick_plus_card | level | 4 | FALSE | TRUE | 플러스카드 |
| 50007 | content_daily_check | level | 4 | TRUE | TRUE | 출석체크 |
| 50008 | content_streak | level | 5 | FALSE | TRUE | 스트릭 |
| 50010 | content_streak_star | level | 5 | TRUE | TRUE | 스트릭 스타 |
| 50011 | content_leaderboard | level | 5 | TRUE | TRUE | 리더보드 |
| 50012 | content_collection | level | 6 | TRUE | TRUE | 콜렉션 |
| 50013 | booster_wild_card | level | 7 | TRUE | TRUE | 와일드 카드 |
| 50014 | booster_fireworks | level | 8 | TRUE | TRUE | 파이어웍스 |
| 50015 | booster_extra_deck | **deck_exhausted** | 0 | FALSE | TRUE | 엑스트라 덱 (상황기반) |
| 50016 | content_betting_2 | level | 9 | FALSE | TRUE | 베팅 x2 |
| 50017 | content_daily_wheel | level | 9 | TRUE | TRUE | 데일리 휠 |
| 50018 | content_iap_popup | level | 11 | FALSE | **FALSE** | IAP 팝업 |
| 50019 | content_event_color | level | 12 | TRUE | FALSE | 이벤트 컬러밤 |
| 50020 | content_event_stamp | level | 12 | TRUE | FALSE | 이벤트 스탬프 |
| 50021 | content_event_race | level | 12 | TRUE | FALSE | 이벤트 레이스 |
| 50022 | gimmick_runner_card | level | 14 | FALSE | TRUE | 러너 카드 |
| 50023 | content_betting_4 | level | 17 | FALSE | TRUE | 베팅 x4 |
| 50024 | gimmick_lock_key | level | 19 | FALSE | TRUE | 자물쇠+열쇠 |
| 50025 | gimmick_rope_card | level | 22 | FALSE | TRUE | 얼음카드 |
| 50026 | booster_golden_ticket | level | 24 | TRUE | TRUE | 골든 티켓 |

**주의사항**:
- `content_betting_1`(50009): Lv 1 기본 해금, show_tutorial=FALSE (별도 튜토리얼 없음)
- `content_pre_level_popup`(50004): Lv **2** 클리어 후 해금
- `booster_extra_deck`(50015): condition_type=`deck_exhausted`, 레벨 무관
- 이벤트 3종(50019~50021): show_tutorial=FALSE, `content_event_forced`(tutorial_guide 230020)가 강제 터치 담당

---

## 3. tutorial_guide 시트 (28행)

> "해금된 콘텐츠를 어떻게 가르치는가"

| key | content_id | guide_type | play_scene | trigger_type | trigger_value | is_forced | is_repeatable | 설명 |
|-----|-----------|------------|------------|-------------|---------------|-----------|---------------|------|
| 230001 | content_ingame_intro | **floating** | ingame | **tutorial_level** | 1 | N | N | Lv1 카드 매칭 기본 안내. 정해진 카드에 포커스, 다른 카드 터치 거부 |
| 230002 | content_deck_draw | **floating** | ingame | **tutorial_level** | 2 | N | N | Lv2 이동 불가 시 덱 뒤집기 안내. 덱에 포커스, 다른 카드 터치 거부 |
| 230003 | content_lobby_play | **focus_bubble** | lobby | **level_clear** | 1 | Y | N | Lv1 클리어 후 로비 게임 시작 버튼 강제 |
| 230004 | content_shop | focus_bubble | lobby | level_clear | 3 | Y | N | 상점 아이콘 해금 안내 |
| 230005 | content_pre_level_popup | focus_bubble | pre_level | level_clear | **2** | Y | N | 프리레벨 팝업 UI 안내 (Lv2 클리어 후) |
| 230006 | content_idle_gold | focus_bubble | lobby | level_clear | 4 | Y | N | 방치골드 해금+수령 강제 |
| 230007 | gimmick_plus_card | focus_bubble | ingame | first_appear | 4 | Y | N | 플러스카드 ±1 매칭 규칙 |
| 230008 | content_idle_gold_collect | focus_bubble | lobby | level_clear | 4 | Y | N | 방치골드 수령 터치 유도 |
| 230009 | content_daily_check | focus_bubble | lobby | level_clear | 4 | Y | N | 출석체크 아이콘 터치 유도 |
| 230010 | content_streak | focus_bubble | ingame | first_appear | 5 | Y | N | 스트릭 미터 안내 |
| 230011 | content_leaderboard | focus_bubble | lobby | level_clear | 5 | Y | N | 리더보드 터치 유도 |
| 230012 | content_collection | focus_bubble | lobby | level_clear | 6 | Y | N | 콜렉션 해금 + 터치 유도 |
| 230013 | booster_wild_card | **floating** | **ingame** | **first_appear** | 7 | **N** | N | 와일드 카드 FREE×3 (탭 스킵) |
| 230014 | booster_fireworks | focus_bubble | pre_level | level_clear | 8 | Y | N | 파이어웍스 FREE×3 |
| 230015 | booster_undo | **floating** | ingame | first_appear | 8 | **N** | N | 언두 가이드 (비강제, 탭 스킵) |
| 230016 | booster_extra_deck | **floating** | ingame | **condition** | deck_exhausted | **N** | N | 엑스트라 덱 FREE×3 (비강제, 탭 스킵) |
| 230017 | content_city_deco_grad | focus_bubble | lobby | level_clear | 8 | Y | N | 도시 꾸미기 강제 |
| 230018 | content_betting_2 | focus_bubble | lobby | level_clear | 9 | Y | N | 베팅 x2 해금 |
| 230019 | content_daily_wheel | focus_bubble | lobby | level_clear | 9 | Y | N | 데일리 휠 터치 유도 |
| 230020 | content_event_forced | focus_bubble | lobby | level_clear | 12 | Y | N | 이벤트 강제 터치 유도 |
| 230021 | gimmick_runner_card | focus_bubble | ingame | first_appear | 14 | Y | N | 러너 카드 기믹 |
| 230022 | content_betting_4 | focus_bubble | lobby | level_clear | 17 | Y | N | 베팅 x4 해금 |
| 230023 | gimmick_lock_key | focus_bubble | ingame | first_appear | 19 | Y | N | 자물쇠+열쇠 기믹 |
| 230024 | gimmick_rope_card | focus_bubble | ingame | first_appear | 22 | Y | N | 얼음카드 기믹 |
| 230025 | booster_golden_ticket | focus_bubble | lobby | level_clear | 24 | Y | N | 골든 티켓 해금 FREE×3 |
| 230026 | content_city_deco | focus_bubble | lobby | **condition** | hammer_ready | Y | **Y** | 도시 꾸미기 강제 (반복) |
| 230027 | gimmick_lock_key_tip | **floating** | ingame | **touch** | lock_card | **N** | **Y** | 키락 카드 터치 말풍선 (반복) |
| 230028 | gimmick_rope_card_tip | **floating** | ingame | **touch** | rope_card | **N** | **Y** | 얼음카드 터치 말풍선 (반복) |

**삭제 항목** (시트에서 제거됨):
- (old 230017) content_iap_popup
- (old 230023) gimmick_lock_key_adv

---

## 4. trigger_type 정의 (5종)

| trigger_type | 정의 | play_scene | trigger_value | 건수 |
|-------------|------|------------|---------------|------|
| `level_clear` | 해당 레벨 클리어 후 로비/프리레벨 복귀 시 발동 | lobby, pre_level | 레벨 번호 (int) | **15건** |
| `first_appear` | 인게임에서 해당 기믹/콘텐츠 첫 등장 시 발동 | ingame | 레벨 번호 (int) | **7건** |
| `condition` | 특정 상황 조건 충족 시 발동 (레벨 무관) | ingame, lobby | 조건 키워드 (deck_exhausted, hammer_ready) | **2건** |
| `tutorial_level` | 튜토리얼 레벨 진입 시 자동 발동 (Lv 1~2) | ingame | 레벨 번호 (int) | **2건** |
| `touch` | 특정 카드/오브젝트 터치 시 말풍선 표시 (반복 가능) | ingame | 대상 키워드 (lock_card, rope_card) | **2건** |

---

## 5. guide_type 규칙

| guide_type | is_forced | 동작 | 건수 | 스킵 |
|-----------|-----------|------|------|------|
| `focus_bubble` | TRUE | **딤+하이라이트** 배경 + 대상 강조 + 캐릭터+말풍선. **반드시 터치 완료해야 진행** | 21건 | 불가 |
| `floating` | FALSE | **딤 없이** 캐릭터+말풍선. 화면 탭으로 스킵 가능 | 7건 | 가능 |

---

## 6. Phase 진행 흐름

| Phase | 레벨 | 학습 목표 | 가이드 방식 |
|-------|------|----------|------------|
| **Phase 0** | Lv 1 | 카드 매칭 (±1), 드로우덱, 클리어 | 풀 가이드 (floating 말풍선) |
| **Phase 1** | Lv 2 | 덱 뒤집기, 프리레벨 팝업 | floating 말풍선 + focus_bubble |
| **Phase 2** | Lv 3~4 | 상점, 방치골드, 플러스카드, 출석체크 | focus_bubble (강제) + 인게임 가이드 |
| **Phase 3** | Lv 5~7 | 스트릭, 리더보드, 콜렉션, 와일드 FREE×3 | 해금 팝업 + floating 가이드 |
| **Phase 4** | Lv 8 | 파이어웍스 FREE×3, 언두 FREE×3(floating), 엑스트라덱(상황기반), 도시꾸미기 강제 | 해금 팝업 + floating 가이드 |
| **Phase 5** | Lv 9~14 | DDA 시작, 베팅x2, 데일리휠, 이벤트 강제 터치, 러너카드 | 해금 팝업 + 강제 터치 유도 |
| **Phase 6** | Lv 15~24 | 베팅x4, 자물쇠+열쇠, 얼음카드, 골든티켓 FREE×3 | 해금 팝업만 (자율 플레이) |

### Phase 전환 임계값 (하드코딩)

```
PHASE_0 → PHASE_1: userLevel >= 2
PHASE_1 → PHASE_2: userLevel >= 3
PHASE_2 → PHASE_3: userLevel >= 5
PHASE_3 → PHASE_4: userLevel >= 8
PHASE_4 → PHASE_5: userLevel >= 9
PHASE_5 → PHASE_6: userLevel >= 15
PHASE_6 → COMPLETED: userLevel >= 25
```

> **의도적 하드코딩**: tutorial_guide(Lv 1~8 전용맵)와 unlock(Lv 9+) 두 시스템에 걸쳐 있어 단일 시트 컬럼으로 표현 불가. 변경 시 클라이언트 패치 필수.

---

## 7. 레벨별 해금·가이드 상세

### Lv 1 (Phase 0) — 즉시 인게임 진입

- NRU는 로비 스킵, 바로 인게임 진입
- NRU 시작 골드: 2,000G (const 10001)
- **입력 제한**: Lv 1~3 정해진 카드만 터치 가능. 다른 카드 터치 시 **카드 흔들기(0.3초) + 올바른 카드 깜빡임 힌트 연출 재생**. 가이드 완료 후 해제.

**인게임 가이드 스텝:**

| 스텝 | 내용 | 트리거 | 상세 |
|------|------|--------|------|
| S1-1 | 게임 화면 구성 소개 | InGameScene.onLoad() 후 0.5초 | 딤+순차 하이라이트 (필드→드로우→오픈, 0.8초 간격). 화면 탭 진행. 스킵 불가. |
| S1-2 | 카드 매칭 규칙 (±1) | S1-1 완료 직후 | 매칭 가능 카드 하이라이트+화살표. 최소 3회 성공 필요. 5초 무행동→힌트 깜빡임. 오류→흔들기+깜빡임3회. |
| S1-3 | 자유 플레이 | S1-2 3회 매칭 성공 후 | 가이드 해제. 5초 무행동 힌트만 유지. |
| S1-4 | 클리어 연출 | 모든 필드 카드 제거 | 골드 1,000G + α + 해머 획득. Phase 1 (로비) 진입. |

**실패 방지**: 덱 소진+매칭 불가 시 자동 5장 추가 드로우 (NRU 전용, 1회/판, 무료). help_card_rate 80% + pity 3회로 Lv 1 실패율 0% 목표.


### Lv 1 클리어 → 로비 (Phase 0~1)

- `content_lobby_play`(230003): Lv 1 클리어 후 로비 도달 시 **게임 시작(플레이) 버튼 강제 터치**. focus_bubble. 반드시 터치.

### Lv 2 (Phase 1) — 로비·덱 뒤집기

- **입력 제한**: Lv 1~3과 동일 (정해진 카드만 터치 가능, 오류→흔들기+힌트)

**인게임 가이드 스텝:**

| 스텝 | 내용 | 트리거 | 상세 |
|------|------|--------|------|
| S2-1 | 드로우 덱 사용 | **이동 불가** 시 | 이동 가능 카드 없을 때 덱에 포커스. 다른 카드 터치 거부. 드로우 후 매칭 복귀. |
| S2-2 | 자유 플레이 + 클리어 | S2-1 완료 후 | 가이드 해제. 클리어 후 로비 진입. |

**Lv 2 클리어 후 해금:**
- `content_pre_level_popup`(50004): 프리레벨 팝업에서 참가비·보상·부스터 UI 안내. focus_bubble 강제 터치.

### Lv 3 (Phase 2) — 상점

- **Lv 3부터 실제 입장료(골드) 차감 시작.** Lv 1~2는 입장료 없이 플레이.
- `content_shop`(50003): 클리어 후 로비 도달 시 상점 아이콘 focus_bubble 포커스. 반드시 터치.

### Lv 4 (Phase 2) — 방치골드·출석체크·플러스카드

**로비 순차 강제 플로우** (3단계 모두 focus_bubble):
1. `content_idle_gold`(230006): 방치골드 해금 팝업
2. `content_idle_gold_collect`(230008): 방치골드 수령 버튼 강제 터치
3. `content_daily_check`(230009): 출석체크 아이콘 강제 터치

**인게임:**
- `gimmick_plus_card`(230007): 인게임에서 플러스카드 첫 등장 시 ±1 매칭 규칙 안내. focus_bubble 강제.

### Lv 5 (Phase 3) — 스트릭·리더보드

- `content_streak`(230010): 인게임 2연속 매칭 시 스트릭 미터 안내. focus_bubble.
- `content_streak_star`(50010): 해금 (pre_unlock_visibility=TRUE).
- `content_leaderboard`(230011): 클리어 후 로비에서 리더보드 아이콘 focus_bubble 터치 유도.

### Lv 6 (Phase 3) — 콜렉션

- `content_collection`(230012): 클리어 후 로비에서 콜렉션 해금 + 아이콘 focus_bubble 터치 유도.
- 퍼즐 피스: x1=1장, x2=3장, x4=5장.

### Lv 7 (Phase 3) — 와일드 카드

- `booster_wild_card`(230013): 인게임 첫 등장 시 **floating** 말풍선 (비강제, 탭 스킵 가능). 와일드 카드가 전용 위치에서 출현하여 모든 카드와 매칭 가능. **FREE×3 무료 지급**. 전용맵 **TUTO_0007**.

### Lv 8 (Phase 4) — Tutorial 클리어

- `booster_fireworks`(230014): 클리어 후 프리레벨 팝업에서 해금. 앞줄 카드 전체 제거. **FREE×3**.
- `booster_undo`(230015): 인게임 첫 등장 시 **floating** 말풍선 (비강제, 탭 스킵 가능). Lv 3부터 UI에 보이기만 하며, **Lv 8에서 FREE×3 무료 지급**.
- `booster_extra_deck`(230016): **floating**, trigger_type=condition, trigger_value=deck_exhausted. 레벨 무관, 덱 모두 소진+매칭 불가 첫 발생 시 자동. **비강제(딤 없이, 탭 스킵 가능)**. **FREE×3**.
- `content_city_deco_grad`(230017): 도시 꾸미기 강제. 망치 충족 시 강제 꾸미기 + 시티 전환. focus_bubble.

### Lv 9 (Phase 5) — Normal/DDA 전환

- `content_betting_2`(230018): 베팅 x2 해금 팝업.
- `content_daily_wheel`(230019): 데일리 휠 해금 팝업 → 아이콘 터치 유도 (순차).

### Lv 11 — IAP·DDA

- `content_iap_popup`(50018): IAP 팝업 노출 시작 (show_tutorial=FALSE, 닫기 가능).
- DDA 시스템 활성화.

### Lv 12 — 이벤트

- 이벤트 3종(50019~50021) 동시 해금. 개별 팝업은 자동 노출.
- `content_event_forced`(230020): 미참여 이벤트 아이콘 강제 터치 유도 (세션당 1회). focus_bubble.

### Lv 14 — 러너 카드

- `gimmick_runner_card`(230021): 인게임 첫 등장 시 기믹 매칭 규칙 안내. focus_bubble.

### Lv 17 — 베팅 x4

- `content_betting_4`(230022): 클리어 후 해금 팝업. focus_bubble.

### Lv 19 — 자물쇠+열쇠

- `gimmick_lock_key`(230023): 인게임 첫 등장 시 기믹 매칭 규칙 안내. focus_bubble.

### Lv 22 — 얼음카드

- `gimmick_rope_card`(230024): 인게임 첫 등장 시 얼음 깨기 후 카드 획득 규칙 안내. focus_bubble.

### Lv 24 — 골든 티켓

- `booster_golden_ticket`(230025): 클리어 후 해금 팝업. **FREE×3** 무료 지급. 랜덤 카드 1장 오픈. focus_bubble.

### 상시 (반복)

- `content_city_deco`(230026): trigger_type=condition, trigger_value=hammer_ready. 구역 필요 망치 충족 시마다 강제 발동. **is_repeatable=TRUE**.
- `gimmick_lock_key_tip`(230027): trigger_type=touch, trigger_value=lock_card. 키락 카드 터치 시 floating 말풍선 상시 노출. 비강제, 반복.
- `gimmick_rope_card_tip`(230028): trigger_type=touch, trigger_value=rope_card. 얼음카드 터치 시 floating 말풍선 상시 노출. 비강제, 반복.

---

## 8. 가이드 컴포넌트 (5종)

| 컴포넌트 | 용도 | 상세 |
|---------|------|------|
| **Focus Bubble** | 새 메카닉/시스템 설명 + 행동 유도 | 딤 배경 + 대상 강조 + 말풍선. 21건 (강제 20건 + 비강제 1건). |
| **Floating** | 보조 안내, 터치 팁 | 반투명 말풍선/화살표. 비강제(is_forced=FALSE). 6건. |
| **Highlight** | 특정 행동 유도 (탭 대상) | 딤 배경 + 대상 UI 강조. alpha 0.4~0.7. |
| **Arrow** | 매칭 가능 카드, 드로우덱 | 탭 유도 애니메이션 화살표. PULSE / BOUNCE 타입. |
| **Feedback** | 오류 시 즉각 안내 | 잘못된 행동 시 흔들기(0.3초) + 올바른 카드 깜빡임 3회. |

---

## 9. 상태 머신

```
APP_INIT
  │
  ├─ isNRU? ─Yes─→ PHASE_0 (Lv 1) ─→ PHASE_1 (Lv 2)
  │                                        │
  │                                   Lv2 클리어
  │                                        │
  │                 PHASE_2 (Lv 3~4) ←─────┘ ─→ PHASE_3 (Lv 5~7)
  │                                                    │
  │                                               Lv7 클리어
  │                                                    │
  │                 PHASE_4 (Lv 8) ←───────────────────┘
  │                     │
  │                Lv8 클리어 ── Tutorial 티어 클리어!
  │                     │
  │                 PHASE_5 (Lv 9~14) ── Normal/DDA 전환
  │                     │
  │                Lv14 클리어
  │                     │
  │                 PHASE_6 (Lv 15~24) ── 해금 팝업만
  │                     │
  │                Lv24 도달
  │                     │
  └─ isNRU? ─No─→  COMPLETED ←──┘
```

---

## 10. Tutorial → Normal 전환 (Lv 8 → Lv 9)

| 항목 | Lv 8 (Tutorial) | Lv 9 (Normal) | 변화 |
|------|----------------|---------------|------|
| difficulty_tier | Tutorial (tier_id=1) | Normal (tier_id=2) | 티어 전환 |
| help_card_rate | 8000 (80%) | 5000 (50%) | **-30%p** |
| pity_trigger | 3회 | 5회 | +2회 |
| streak_sustain | 5회 | 4회 | -1회 |
| 맵 풀 | tutorial_guide 전용맵 | 일반 schedule | 맵 전환 |
| DDA | 비활성 | Lv 11부터 활성 | — |

> **Lv 9~10 완충 구간**: Normal 고정(dynamic_level 30002). DDA 없이 Normal만 제공하여 Tutorial → Normal 전환 충격 완화.

---

## 11. 모듈 구성

```
TutorialManager (싱글턴, 전체 튜토리얼 상태 관리)
├── GuideSystem        인게임 가이드 (딤+하이라이트+버블+화살표)
│   └── GuideUI Components (5종: Bubble, Highlight, Arrow, Feedback, FocusBubble)
├── UnlockSystem       해금 팝업 (focus_bubble 단일 유형)
│   └── UnlockPopup Factory
├── MapAssigner        맵 배정 (tutorial_guide.is_dedicated_map 참조)
│   └── tutorial_map_id (8건)
└── TutorialStateStore 로컬 저장 (FB setDataAsync / LocalStorage)
    ├── completedPhases[]     ≤ 8개
    ├── shownUnlockPopups[]   ≤ 26개
    ├── freeBoostersGranted[] ≤ 3개
    └── shownGimmickGuides[] ≤ 3개

의존 시트: unlock (26행) / tutorial_guide (28행) / const / difficulty_tier / string_code
```

---

## 12. 클라이언트 상태 저장

```typescript
interface TutorialState {
    currentPhase: TutorialPhase;        // PHASE_0 ~ PHASE_6 | COMPLETED
    completedPhases: TutorialPhase[];
    guideStepsCompleted: { [phaseId: string]: string[] };
    shownUnlockPopups: string[];        // content_id 목록
    freeBoostersUsed: string[];
    freeBoostersGranted: string[];
    shownGimmickGuides: string[];       // "runner_card", "lock_key", "rope_card"
    isNRU: boolean;
    firstSessionPlayCount: number;
    lobbyVisited: boolean;
    tutorialStartedAt: number;          // Unix ms
    tutorialCompletedAt: number;        // Unix ms
}
```

**저장소**: Facebook `FBInstant.player.setDataAsync()` → key: `TUTORIAL_STATE`
**저장 시점**: Phase 전환, 가이드 스텝 완료, 해금 팝업 표시, 무료 부스터 지급 시

---

## 13. 설계 원칙 요약

| 원칙 | 설명 |
|------|------|
| 즉시 플레이 | NRU는 로비 스킵, 바로 인게임 진입 |
| 비간섭 가이드 | 올바른 행동 시 가이드 미노출. 5초 무행동 시에만 힌트 |
| 기본 메카닉 숙달 우선 | Lv 1~8 Tutorial 티어로 기본기 숙달 |
| 단계적 복잡도 | 2레벨 이내 간격 해금, 26개 항목을 Lv 3~24에 분산 |
| FK 참조 원칙 | tutorial_guide.unlock_key → unlock.key_number. 전 행 FK 참조 필수 |
| 수식 연결 | content_id = unlock VLOOKUP, string_code_kr = string_code!ko VLOOKUP |
