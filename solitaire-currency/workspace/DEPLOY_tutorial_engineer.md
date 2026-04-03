# PST 튜토리얼 시스템 — 엔지니어 배포 문서

> **v7** | 2026-03-18
> **데이터 소스**: Google Sheets `1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk` (unlock, tutorial_guide)

---

## 1. 시스템 개요

| 항목 | 값 |
|------|-----|
| 아키텍처 | 2-시트 (unlock 26행 + tutorial_guide 28행) |
| Phase 수 | 7개 (Phase 0~6) + COMPLETED |
| guide_type | 2종: focus_bubble(21건, 강제) / floating(7건, 비강제) |
| trigger_type | 5종: level_clear(15건), first_appear(7건), condition(2건), tutorial_level(2건), touch(2건) |
| Tutorial 티어 구간 | Lv 1~8 (help_card_rate 80%, pity_trigger 3회) |
| Normal 전환 | Lv 9~ |
| 전용맵 (is_dedicated_map) | 9건 |
| 강제 클리어 스테이지 | Lv 1~3 (정해진 카드만 터치, 무조건 클리어) |

---

## 2. 모듈 아키텍처

```
┌─────────────────────────────────────────────────────────┐
│                    TutorialManager                       │
│  (싱글턴, 전체 튜토리얼 상태 관리)                        │
├─────────────────────────────────────────────────────────┤
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐   │
│  │ GuideSystem  │  │ UnlockSystem │  │ MapAssigner  │   │
│  │ (인게임 가이드)│  │ (해금 팝업)   │  │ (맵 배정)    │   │
│  └──────┬───────┘  └──────┬───────┘  └──────┬───────┘   │
│  ┌──────┴───────┐  ┌──────┴───────┐  ┌──────┴───────┐   │
│  │ GuideUI      │  │ UnlockPopup  │  │ tutorial_    │   │
│  │ Components   │  │ Factory      │  │ guide 시트   │   │
│  │ (5종)        │  │              │  │ (맵 배정 통합)│   │
│  └──────────────┘  └──────────────┘  └──────────────┘   │
│  ┌──────────────────────────────────────────────────┐    │
│  │              TutorialStateStore                   │    │
│  │  (로컬 저장: 완료 Phase, 표시된 가이드, 무료 부스터)  │    │
│  └──────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────┘

의존 시트: unlock(26행) / tutorial_guide(28행) / const / difficulty_tier / dynamic_level / string_code / item_list
```

### 데이터 흐름

```
[앱 실행]
  ├─ isNRU? ──Yes──→ TutorialManager.startPhase0()
  │                   ├─ MapAssigner.getMap(userLevel=1) → tutorial_guide 전용맵
  │                   ├─ GuideSystem.activate(PHASE_0)
  │                   └─ 즉시 InGameScene 진입 (로비 스킵)
  ├─ userLevel <= 8? ──→ Tutorial 티어 맵 제공 (dynamic_level 30001)
  │                      ├─ 해금 조건 체크 (unlock) → show_tutorial=True이면 UnlockPopup 큐잉
  │                      └─ tutorial_guide 가이드 실행
  └─ userLevel >= 9 ──→ Normal/DDA 전환 → 해금 팝업만 (Lv 9~24)
```

---

## 3. 데이터 구조

### 3.1 TutorialStateStore (클라이언트 로컬 저장)

```typescript
interface TutorialState {
    currentPhase: TutorialPhase;        // PHASE_0 ~ PHASE_6 | COMPLETED
    completedPhases: TutorialPhase[];
    guideStepsCompleted: {
        [phaseId: string]: string[];    // e.g. { "PHASE_0": ["S1-1", "S1-2", ...] }
    };
    shownUnlockPopups: string[];        // content_id 목록
    freeBoostersUsed: string[];
    freeBoostersGranted: string[];      // 지급됨 (사용 여부 무관)
    shownGimmickGuides: GimmickType[];  // "runner_card", "lock_key", "rope_card"
    isNRU: boolean;
    firstSessionPlayCount: number;
    lobbyVisited: boolean;
    tutorialStartedAt: number;          // Unix ms
    tutorialCompletedAt: number;        // Unix ms
}

// 저장 용량 (Facebook setDataAsync 1MB 한도)
// completedPhases: ≤ 8개 | shownUnlockPopups: ≤ 26개
// freeBoostersGranted: ≤ 5개 | shownGimmickGuides: ≤ 3개

enum TutorialPhase {
    PHASE_0 = "phase_0",   // Lv 1: 카드 매칭 기본
    PHASE_1 = "phase_1",   // Lv 2: 로비·덱 뒤집기·프리레벨
    PHASE_2 = "phase_2",   // Lv 3~4: 상점·방치골드·플러스카드·출석체크
    PHASE_3 = "phase_3",   // Lv 5~7: 스트릭·컬렉션·와일드
    PHASE_4 = "phase_4",   // Lv 8: 파이어웍스·언두·엑스트라덱·도시꾸미기
    PHASE_5 = "phase_5",   // Lv 9~14: Normal 전환·DDA·이벤트
    PHASE_6 = "phase_6",   // Lv 15~24: 심화 콘텐츠·기믹
    COMPLETED = "completed"
}
```

### 3.2 저장 방식

| 플랫폼 | 저장소 | 키 |
|--------|--------|-----|
| Facebook Instant Games | `FBInstant.player.setDataAsync()` | `FBDataKey.TUTORIAL_STATE` |
| Standalone | `PlayerPrefs` / `LocalStorage` | `pst_tutorial_state` |

**저장 시점**: Phase 전환 시, 가이드 스텝 완료 시, 해금 팝업 표시 시, 무료 부스터 지급 시

---

## 4. 상태 머신

### 4.1 Phase 전환 조건

```typescript
function checkPhaseTransition(userLevel: number, currentPhase: TutorialPhase): TutorialPhase {
    switch (currentPhase) {
        case TutorialPhase.PHASE_0: return userLevel >= 2 ? TutorialPhase.PHASE_1 : currentPhase;
        case TutorialPhase.PHASE_1: return userLevel >= 3 ? TutorialPhase.PHASE_2 : currentPhase;
        case TutorialPhase.PHASE_2: return userLevel >= 5 ? TutorialPhase.PHASE_3 : currentPhase;
        case TutorialPhase.PHASE_3: return userLevel >= 8 ? TutorialPhase.PHASE_4 : currentPhase;
        case TutorialPhase.PHASE_4: return userLevel >= 9 ? TutorialPhase.PHASE_5 : currentPhase;
        case TutorialPhase.PHASE_5: return userLevel >= 15 ? TutorialPhase.PHASE_6 : currentPhase;
        case TutorialPhase.PHASE_6: return userLevel >= 25 ? TutorialPhase.COMPLETED : currentPhase;
        default: return currentPhase;
    }
}
```

> **의도적 하드코딩**: Phase 전환 레벨 임계값(2,3,5,8,9,15,25)은 tutorial_guide(Lv 1~8 전용맵)와 unlock(Lv 9+)의 두 시스템에 걸쳐있어 단일 시트 컬럼으로 표현 불가. 변경 시 클라이언트 패치 필수.

### 4.2 전체 플로우

```
APP_INIT → isNRU?
  Yes → PHASE_0(Lv1) → PHASE_1(Lv2) → PHASE_2(Lv3~4) → PHASE_3(Lv5~7) → PHASE_4(Lv8)
         → PHASE_5(Lv9~14, Normal/DDA) → PHASE_6(Lv15~24, 해금팝업만) → COMPLETED
  No  → NORMAL FLOW
```

### 4.3 인게임 가이드 상태 머신 (Phase 0~1)

```
                                          === Lv 1 ===
┌─────────┐   매칭 가능 카드    ┌──────────┐   탭 성공    ┌──────────┐
│ S1-1    │──하이라이트 표시──→│ S1-2     │────────────→│ S1-2     │
│ 화면소개 │                    │ 매칭 유도 │             │ 반복     │
└─────────┘                    └──────────┘             └────┬─────┘
                                                            │ 3회 매칭 성공
                                                       ┌────┴─────┐
                                                       │ S1-3     │
                                                       │ 자유     │
                                                       │ 플레이   │
                                                       └────┬─────┘
                                                            │ 클리어
                                                       ┌────┴─────┐
                                                       │ S1-4     │
                                                       │ 클리어   │
                                                       │ 연출     │
                                                       └──────────┘

                                          === Lv 2 ===
                               ┌──────────┐             ┌──────────┐
                               │ S2-1     │────────────→│ S2-2     │
                               │ 드로우   │   드로우 탭  │ 자유     │
                               │ 덱 유도  │   성공       │ 플레이   │
                               └──────────┘             └──────────┘
                               (이동 불가 시 발동)
```

---

## 5. unlock 시트 (26행)

> "언제, 어떤 조건으로 콘텐츠가 열리는가"

| key | content_id | condition_type | val | pre_unlock_visibility | show_tutorial | 비고 |
|-----|-----------|----------------|-----|----------------------|---------------|------|
| 50001 | content_city_deco | level | 1 | FALSE | TRUE | 도시 꾸미기 |
| 50002 | content_tournament | level | 1 | FALSE | FALSE | 토너먼트 |
| 50009 | content_betting_1 | level | **1** | FALSE | **FALSE** | 베팅x1 기본 해금 |
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
- `content_betting_1`(50009): Lv 1 기본 해금, show_tutorial=FALSE
- `content_pre_level_popup`(50004): Lv **2** 클리어 후 해금
- `booster_extra_deck`(50015): condition_type=`deck_exhausted`, 레벨 무관
- 이벤트 3종(50019~50021): show_tutorial=FALSE, `content_event_forced`(230020)가 강제 터치 담당

---

## 6. tutorial_guide 시트 (28행)

> "해금된 콘텐츠를 어떻게 가르치는가"

| key | content_id | guide_type | play_scene | trigger_type | trigger_value | is_forced | is_repeatable |
|-----|-----------|------------|------------|-------------|---------------|-----------|---------------|
| 230001 | content_ingame_intro | floating | ingame | tutorial_level | 1 | N | N |
| 230002 | content_deck_draw | floating | ingame | tutorial_level | 2 | N | N |
| 230003 | content_lobby_play | focus_bubble | lobby | level_clear | 1 | Y | N |
| 230004 | content_shop | focus_bubble | lobby | level_clear | 3 | Y | N |
| 230005 | content_pre_level_popup | focus_bubble | pre_level | level_clear | 2 | Y | N |
| 230006 | content_idle_gold | focus_bubble | lobby | level_clear | 4 | Y | N |
| 230007 | gimmick_plus_card | focus_bubble | ingame | first_appear | 4 | Y | N |
| 230008 | content_idle_gold_collect | focus_bubble | lobby | level_clear | 4 | Y | N |
| 230009 | content_daily_check | focus_bubble | lobby | level_clear | 4 | Y | N |
| 230010 | content_streak | focus_bubble | ingame | first_appear | 5 | Y | N |
| 230011 | content_leaderboard | focus_bubble | lobby | level_clear | 5 | Y | N |
| 230012 | content_collection | focus_bubble | lobby | level_clear | 6 | Y | N |
| 230013 | booster_wild_card | floating | ingame | first_appear | 7 | N | N |
| 230014 | booster_fireworks | focus_bubble | pre_level | level_clear | 8 | Y | N |
| 230015 | booster_undo | floating | ingame | first_appear | 8 | N | N |
| 230016 | booster_extra_deck | floating | ingame | condition | deck_exhausted | N | N |
| 230017 | content_city_deco_grad | focus_bubble | lobby | level_clear | 8 | Y | N |
| 230018 | content_betting_2 | focus_bubble | lobby | level_clear | 9 | Y | N |
| 230019 | content_daily_wheel | focus_bubble | lobby | level_clear | 9 | Y | N |
| 230020 | content_event_forced | focus_bubble | lobby | level_clear | 12 | Y | N |
| 230021 | gimmick_runner_card | focus_bubble | ingame | first_appear | 14 | Y | N |
| 230022 | content_betting_4 | focus_bubble | lobby | level_clear | 17 | Y | N |
| 230023 | gimmick_lock_key | focus_bubble | ingame | first_appear | 19 | Y | N |
| 230024 | gimmick_rope_card | focus_bubble | ingame | first_appear | 22 | Y | N |
| 230025 | booster_golden_ticket | focus_bubble | lobby | level_clear | 24 | Y | N |
| 230026 | content_city_deco | focus_bubble | lobby | condition | hammer_ready | Y | Y |
| 230027 | gimmick_lock_key_tip | floating | ingame | touch | lock_card | N | Y |
| 230028 | gimmick_rope_card_tip | floating | ingame | touch | rope_card | N | Y |

**삭제 항목** (시트에서 제거됨):
- (old 230017) content_iap_popup
- (old 230023) gimmick_lock_key_adv

---

## 7. trigger_type 정의 (5종)

| trigger_type | 정의 | play_scene | trigger_value | 건수 |
|-------------|------|------------|---------------|------|
| `level_clear` | 해당 레벨 클리어 후 로비/프리레벨 복귀 시 발동 | lobby, pre_level | 레벨 번호 (int) | **15건** |
| `first_appear` | 인게임에서 해당 기믹/콘텐츠 첫 등장 시 발동 | ingame | 레벨 번호 (int) | **7건** |
| `condition` | 특정 상황 조건 충족 시 발동 (레벨 무관) | ingame, lobby | 조건 키워드 | **2건** |
| `tutorial_level` | 튜토리얼 레벨 진입 시 자동 발동 (Lv 1~2) | ingame | 레벨 번호 (int) | **2건** |
| `touch` | 특정 카드/오브젝트 터치 시 말풍선 표시 (반복 가능) | ingame | 대상 키워드 | **2건** |

---

## 8. guide_type 규칙

| guide_type | is_forced | 동작 | 건수 | 스킵 |
|-----------|-----------|------|------|------|
| `focus_bubble` | TRUE | **딤+하이라이트** 배경 + 대상 강조 + 캐릭터+말풍선. **반드시 터치 완료해야 진행** | **21건** | 불가 |
| `floating` | FALSE | **딤 없이** 캐릭터+말풍선. 화면 탭으로 스킵 가능 | **7건** | 가능 |

Floating 키 목록: `230001, 230002, 230013, 230015, 230016, 230027, 230028`

---

## 9. Phase별 구현 상세

### Phase 0 (Lv 1) — 즉시 인게임 진입

```typescript
function onAppStart(): void {
    const isNRU = !TutorialStateStore.exists();
    if (isNRU) {
        PlayerData.addGold(2000);  // const 10001: nru_start_gold
        TutorialManager.startPhase0();
        SceneManager.loadInGame(mapId: "Tutorial_0351");
        GuideSystem.activate(TutorialPhase.PHASE_0);
    }
}
```

**Lv 1~3 입력 제한** (강제 클리어 스테이지):
```typescript
function onCardTapped(card: Card): void {
    if (isInputRestricted && !allowedCards.includes(card)) {
        Feedback.shake(card, duration: 300);
        const correctCard = allowedCards[0];
        correctCard.blink(count: 3, interval: 500);
        return;
    }
    processCardMatch(card);
}
```

**인게임 가이드 스텝:**

| 스텝 | 내용 | 트리거 | 완료 조건 |
|------|------|--------|-----------|
| S1-1 | 게임 화면 구성 소개 | onLoad() 후 0.5초 | 화면 탭 |
| S1-2 | 카드 매칭 (±1) | S1-1 완료 | 3회 매칭 성공 |
| S1-3 | 자유 플레이 | S1-2 완료 | 클리어 |
| S1-4 | 클리어 연출 | 필드 카드 전체 제거 | Collect 탭 |

**실패 방지**: 덱 소진+매칭 불가 시 자동 5장 추가 드로우 (NRU 전용, 1회/판, 무료)

### Lv 1 클리어 → 로비 게임 시작 버튼 강제

```typescript
// 230003: focus_bubble, lobby, level_clear, trigger_value=1
function onLevel1Cleared_LobbyReturn(): void {
    GuideSystem.showFocusBubble({
        target: playButton,
        stringKey: "T_TUT_LOBBY_PLAY",
        onComplete: () => markGuideShown("content_lobby_play")
    });
}
```

### Phase 1 (Lv 2) — 덱 뒤집기

| 스텝 | 내용 | 트리거 | 완료 조건 |
|------|------|--------|-----------|
| S2-1 | 드로우 덱 사용 | 이동 가능 카드 없을 때 | 드로우 덱 탭 |
| S2-2 | 자유 플레이 + 클리어 | S2-1 완료 | 클리어 |

Lv 2 클리어 후: `content_pre_level_popup`(230005) 프리레벨 팝업 해금

### Phase 2 (Lv 3~4) — 상점·방치골드·출석체크·플러스카드

**Lv 3부터 입장료(골드) 차감 시작. Lv 3도 강제 클리어 스테이지.**

Lv 3 클리어 → 로비: 상점 아이콘 focus_bubble (230004)

Lv 4 클리어 → 로비 순차 강제 플로우:
```typescript
async function onLevel4Cleared_LobbySequence(): Promise<void> {
    await GuideSystem.showFocusBubble({ target: idleGoldArea });        // 230006
    await GuideSystem.showFocusBubble({ target: idleGoldCollectBtn });  // 230008
    await GuideSystem.showFocusBubble({ target: dailyCheckIcon });      // 230009
}
```

Lv 4 인게임: 플러스카드 첫 등장 시 가이드 (230007)

### Phase 3 (Lv 5~7) — 스트릭·컬렉션·와일드

- Lv 5: 스트릭 미터 인게임 가이드(230010) + 리더보드 로비 터치 유도(230011)
- Lv 6: 콜렉션 해금 + 터치 유도(230012)
- Lv 7: 와일드 카드 floating 가이드(230013, 비강제) + FREE×3. 전용맵 TUTO_0007.

```typescript
// 230013: floating, ingame, first_appear, trigger_value=7
async function executeWildCardTutorial_Lv7(): Promise<void> {
    FloatingBubble.show({
        target: wildCardSlot,
        stringKey: "T_TUT_WILD_CARD",
        dismissOnTap: true
    });
    FreeTag.show(wildCardSlot, text: "FREE ×3");
    grantFreeBooster("booster_wild_card", count: 3);
}
```

### Phase 4 (Lv 8) — Tutorial 클리어

- 파이어웍스 프리레벨 해금(230014) + FREE×3
- 언두 floating 가이드(230015, 비강제) + FREE×3
- 엑스트라 덱 상황 기반(230016, 비강제) + FREE×3
- 도시 꾸미기 강제(230017)

```typescript
// 230016: floating, ingame, condition, trigger_value=deck_exhausted
function onDeckExhausted_NoMatches(): void {
    if (tutorialState.shownUnlockPopups.includes("booster_extra_deck")) return;
    GuideSystem.showFloating({
        target: extraDeckButton,
        stringKey: "T_TUT_EXTRA_DECK",
        dismissOnTap: true
    });
    FreeTag.show(extraDeckButton, text: "FREE ×3");
    grantFreeBooster("booster_extra_deck", count: 3);
}
```

### Phase 5~6 (Lv 9~24) — 점진적 해금

| Lv | content_id | guide_key | 비고 |
|----|-----------|-----------|------|
| 9 | content_betting_2 | 230018 | 베팅 x2 해금 |
| 9 | content_daily_wheel | 230019 | 데일리 휠 터치 유도 (순차) |
| 12 | content_event_forced | 230020 | 이벤트 강제 터치 |
| 14 | gimmick_runner_card | 230021 | 러너 카드 기믹 |
| 17 | content_betting_4 | 230022 | 베팅 x4 해금 |
| 19 | gimmick_lock_key | 230023 | 자물쇠+열쇠 기믹 |
| 22 | gimmick_rope_card | 230024 | 얼음카드 기믹 |
| 24 | booster_golden_ticket | 230025 | 골든 티켓 FREE×3 |

```typescript
async function onLevel9Cleared_LobbyReturn(): Promise<void> {
    await UnlockSystem.showPopup({ key: 50016, contentId: "content_betting_2" });
    await UnlockSystem.showPopup({ key: 50017, contentId: "content_daily_wheel" });
    await GuideSystem.showFocusBubble({
        target: dailyWheelIcon,
        stringKey: "T_TUT_DAILY_WHEEL"
    });
}
```

**상시 반복:**
- 230026 content_city_deco: hammer_ready 시 도시 꾸미기 강제 (is_repeatable=TRUE)
- 230027 gimmick_lock_key_tip: 키락 카드 터치 시 floating (반복)
- 230028 gimmick_rope_card_tip: 얼음카드 터치 시 floating (반복)

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

> **Lv 9~10 완충 구간**: Normal 고정(dynamic_level 30002). DDA 없이 Normal만 제공하여 전환 충격 완화.

---

## 11. 무료 부스터 지급 로직

```typescript
function grantFreeBooster(contentId: string, count: number = 3): void {
    if (tutorialState.freeBoostersGranted.includes(contentId)) return;
    tutorialState.freeBoostersGranted.push(contentId);
    switch (contentId) {
        case "booster_undo":           InGameBooster.setFreeUse("undo", count);           break; // Lv 8
        case "booster_extra_deck":     InGameBooster.setFreeUse("extra_deck", count);     break; // 상황 기반
        case "booster_wild_card":      InGameBooster.setFreeUse("wild_card", count);      break; // Lv 7
        case "booster_fireworks":      PreLevelBooster.setFreeUse("fireworks", count);    break; // Lv 8
        case "booster_golden_ticket":  PreLevelBooster.setFreeUse("golden_ticket", count); break; // Lv 24
    }
    saveTutorialState();
}
```

> 무료 부스터 수량: 모두 **3개**. UI에 "FREE ×3" 표기 필수.

---

## 12. 해금 팝업 시스템

```typescript
function shouldShowUnlockPopup(contentId: string, userLevel: number): boolean {
    const unlockEntry = UnlockSheet.get(contentId);
    if (!unlockEntry) return false;
    if (unlockEntry.show_tutorial === false) return false;
    if (tutorialState.shownUnlockPopups.includes(contentId)) return false;
    switch (unlockEntry.condition_type) {
        case "level":          return userLevel >= unlockEntry.condition_val;
        case "deck_exhausted": return isDeckExhausted && getMatchableCards().length === 0;
        default:               return false;
    }
}
```

---

## 13. 기믹 첫 등장 인게임 가이드

```typescript
function onGimmickFirstAppear(gimmickType: GimmickType): void {
    if (tutorialState.shownGimmickGuides.includes(gimmickType)) return;
    InGameManager.pauseInput();
    const gimmickCard = FieldCardManager.getFirstGimmickCard(gimmickType);
    GuideSystem.showFocusBubble({
        target: gimmickCard,
        stringKey: getGimmickStringKey(gimmickType),
        onComplete: () => {
            InGameManager.resumeInput();
            tutorialState.shownGimmickGuides.push(gimmickType);
            saveTutorialState();
        }
    });
}
```

| 기믹 | 해금 Lv | guide_key | string_code |
|------|---------|-----------|-------------|
| 플러스카드 | 4 | 230007 | T_TUT_PLUS_CARD |
| 러너카드 | 14 | 230021 | T_TUT_RUNNER_CARD |
| 자물쇠+열쇠 | 19 | 230023 | T_TUT_LOCK_KEY |
| 얼음카드 | 22 | 230024 | T_TUT_ROPE_CARD |

---

## 14. UI 컴포넌트 (5종)

| 컴포넌트 | 용도 | 상세 |
|---------|------|------|
| **Focus Bubble** | 새 메카닉/시스템 설명 + 행동 유도 | 딤 배경(alpha 0.3~0.4) + 대상 강조 + 말풍선 + 마스코트 아이콘(48×48px). 강제(is_forced=TRUE). 21건. |
| **Floating** | 보조 안내, 터치 팁 | 딤 없이 반투명 말풍선/화살표. 비강제. 7건. |
| **Highlight** | 특정 행동 유도 | 딤 배경 + mask로 대상만 투명. |
| **Arrow** | 매칭 가능 카드, 드로우덱 유도 | 손가락+화살표 48×48px, #FFD700. PULSE(0.8초) / BOUNCE(0.6초). |
| **Feedback** | 오류 시 즉각 안내 | SHAKE(좌우 ±5px, 3회, 0.3초) + BLINK(alpha 0→1→0, 3회, 0.5초). |

**DimOverlay**: alpha 0.3(일반) / 0.4(로비) / 없음(Phase 0 S1-1)
**FreeTag**: `FREE ×3` 텍스트, 대상 부스터 버튼 상단, 초록 배지(#4CAF50)
**Mascot**: 원형 48×48px, Bubble 좌상단, WARNING 스타일은 NONE

**타임아웃 힌트** (Lv 1~8): 5초 무행동 → 매칭 가능 카드 Blink ×3 / 매칭 불가 시 드로우 덱 Blink. Lv 9+ 비활성.

---

## 15. NRU 제한 규칙

| 규칙 | 적용 구간 | 설명 |
|------|----------|------|
| 입력 제한 | Lv 1~3 | 정해진 카드만 터치 가능. 오류→흔들기+깜빡임 |
| 로비 스킵 | Lv 1 | NRU 첫 진입 시 로비 건너뛰고 바로 인게임 |
| 입장료 면제 | Lv 1~3 | 입장료(골드) 차감 없이 플레이. Lv 3부터 입장료 시작 |
| 자동 드로우 구제 | Lv 1 | 덱 소진+매칭 불가 시 자동 5장 추가 (1회/판, 무료) |
| Tutorial 티어 | Lv 1~8 | help_card_rate 80%, pity_trigger 3회 |

---

## 16. Analytics 이벤트

```typescript
// Phase 전환 시
Analytics.track("tutorial_phase_change", {
    from: previousPhase, to: currentPhase,
    userLevel: PlayerData.getLevel(), timeInPhase: Date.now() - phaseStartTime
});

// Tutorial 클리어 시 (Lv 8 → Lv 9)
Analytics.track("tutorial_graduated", {
    totalTime: Date.now() - tutorialState.tutorialStartedAt,
    totalPlays: 8, goldBalance: PlayerData.getGold(), hammerBalance: PlayerData.getHammer()
});

// 가이드 스텝 완료 시
Analytics.track("tutorial_step_completed", { phase: currentPhase, stepId, duration: stepDuration });

// 무료 부스터 사용 시
Analytics.track("tutorial_free_booster_used", {
    boosterId: contentId, remainingFree: remainingCount, userLevel: PlayerData.getLevel()
});
```

---

## 17. 에지 케이스

| 시나리오 | 처리 |
|----------|------|
| 앱 종료 후 재진입 | TutorialStateStore에서 현재 Phase·스텝 복원 |
| 네트워크 끊김 | 로컬 플레이 유지. 결과 전송은 재연결 시 |
| 튜토리얼 맵 파일 없음 | fallback 맵 사용 + 에러 로그 |
| free_booster FK 오류 | 무료 부스터 미지급 + 경고 로그 |
| Facebook setDataAsync 실패 | 로컬 캐시 유지, 다음 세션 재시도 |
| 같은 가이드 중복 표시 | shownUnlockPopups/shownGimmickGuides로 1회 제한 |
| 동시 해금 (예: Lv 4 방치골드+출석체크) | 순차 처리 (큐), 동시 팝업 안 됨 |

---

## 18. 화면 전환 플로우

```
[NRU 앱 시작]
    │
    ▼ Lv 1 (로비 스킵 → 인게임 즉시)
┌──────────────────────────┐
│ Phase 0: 카드 매칭 기본   │  S1-1 → S1-2 → S1-3 → S1-4(클리어)
│ 입력 제한 ON, 입장료 0    │
└──────────┬───────────────┘
           │ 클리어 → 로비 도달
           ▼
┌──────────────────────────┐
│ 230003: 게임시작 버튼 강제 │  focus_bubble, 반드시 터치
└──────────┬───────────────┘
           │ Lv 2 플레이
           ▼
┌──────────────────────────┐
│ Phase 1: 덱 뒤집기       │  S2-1 → S2-2(클리어)
│ 입력 제한 ON, 입장료 0    │
└──────────┬───────────────┘
           │ 클리어 → 프리레벨 팝업 해금(230005)
           ▼
┌──────────────────────────┐
│ Phase 2: Lv 3~4          │  상점, 방치골드, 출석체크, 플러스카드
│ Lv 3: 입장료 시작         │  Lv 3도 강제 클리어 스테이지
└──────────┬───────────────┘
           ▼
┌──────────────────────────┐
│ Phase 3: Lv 5~7          │  스트릭, 리더보드, 콜렉션, 와일드 FREE×3
└──────────┬───────────────┘
           ▼
┌──────────────────────────┐
│ Phase 4: Lv 8            │  파이어웍스/언두/엑스트라덱 FREE×3, 도시꾸미기
│ ★ Tutorial 클리어         │
└──────────┬───────────────┘
           ▼ Lv 9~: Normal/DDA 전환
┌──────────────────────────┐
│ Phase 5~6: Lv 9~24       │  베팅, 데일리휠, 이벤트, 기믹, 골든티켓
│ 해금 팝업만               │
└──────────┬───────────────┘
           ▼ Lv 25: COMPLETED
```
