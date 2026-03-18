```yaml
---
agent: 05_system_spec + 01_pm
mode: tutorial_system
scope: 튜토리얼 전체 시스템 (NRU 진입 ~ Lv 24 해금 완료)
executed: 2026-03-17T15:00:00+09:00
status: complete (v7 시트 재키잉 반영)
verdict: cp1_adjusted
references:
  - workspace/07_tutorial_planning_doc.html (v4)
  - workspace/07_tutorial_dev_handoff.md
  - Google Sheets: unlock, tutorial_guide (1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk)
---
```

# PST 튜토리얼 시스템 명세 (개발자용)

> **목적**: 개발자가 구현 가능한 수준의 상세 기술 명세
> **대상 독자**: 클라이언트 개발자, 서버 개발자, QA
> **최종 수정**: 2026-03-18 (v7 시트 재키잉 — 229xxx→230xxx, content_lobby_play 230003 추가, Lv1~3 강제 클리어, trigger_type 5종)
> **참조 설계**: `workspace/07_tutorial_planning_doc.html`, `workspace/07_tutorial_dev_handoff.md`

---

## 목차

1. [시스템 아키텍처](#1-시스템-아키텍처)
2. [데이터 구조](#2-데이터-구조)
3. [상태 머신](#3-상태-머신)
4. [Phase 0: 즉시 진입 (Lv 1)](#4-phase-0-즉시-진입-lv-1)
5. [Phase 1: 로비·덱 뒤집기 (Lv 2)](#5-phase-1-로비덱-뒤집기-lv-2)
6. [Phase 2: 핵심 시스템 (Lv 3~4)](#6-phase-2-핵심-시스템-lv-34)
7. [Phase 3: 스트릭·컬렉션·와일드 (Lv 5~7)](#7-phase-3-스트릭컬렉션와일드-lv-57)
8. [Phase 4: 부스터·클리어 (Lv 8)](#8-phase-4-부스터클리어-lv-8)
9. [Phase 5~6: 점진적 해금 (Lv 9~24)](#9-phase-56-점진적-해금-lv-924)
10. [인게임 가이드 시스템](#10-인게임-가이드-시스템)
11. [해금 팝업 시스템](#11-해금-팝업-시스템)
12. [NRU 제한 규칙](#12-nru-제한-규칙)
13. [Analytics 이벤트](#13-analytics-이벤트)
14. [에지 케이스](#14-에지-케이스)
15. [QA 체크리스트](#15-qa-체크리스트)

---

## 1. 시스템 아키텍처

### 1.1 모듈 구성

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
```

### 1.2 의존 시트 데이터

| 시트 | 용도 | 참조 방식 |
|------|------|-----------|
| `unlock` | 해금 조건 (26행) | content_id로 조회 |
| `tutorial_guide` | 가이드 설정 + 맵 배정 통합 (28행) | key/unlock_key로 조회 |
| `const` | NRU 골드, 보상 상수 | key_number로 조회 |
| `difficulty_tier` | Tutorial 티어 파라미터 | tier_id=1 |
| `dynamic_level` | Lv 1~8 Tutorial 배정 | condition_type=user_level_range |
| `string_code` | 가이드·팝업 텍스트 | string_key로 조회 |
| `item_list` | 부스터 정보 | key_number로 조회 |

> **변경사항 (v4)**: `tutorial_schedule` 시트 **삭제됨**. 맵 배정·무료 부스터 정보가 `tutorial_guide` 시트로 통합 (is_dedicated_map, tutorial_map_id 컬럼).

### 1.3 데이터 흐름

```
[앱 실행]
  │
  ├─ isNRU? ──Yes──→ TutorialManager.startPhase0()
  │                      │
  │                      ├─ MapAssigner.getMap(userLevel=1)
  │                      │    → tutorial_guide에서 is_dedicated_map=TRUE인 맵 조회
  │                      │
  │                      ├─ GuideSystem.activate(PHASE_0)
  │                      │    → 인게임 가이드 스텝 시퀀스 로드
  │                      │
  │                      └─ 즉시 InGameScene 진입 (로비 스킵)
  │
  ├─ userLevel <= 8? ──→ Tutorial 티어 맵 제공 (dynamic_level 30001)
  │                      │
  │                      ├─ 해금 조건 체크 (unlock 시트)
  │                      │    → show_tutorial=True이면 UnlockPopup 큐잉
  │                      │
  │                      └─ tutorial_guide 가이드 실행
  │
  └─ userLevel >= 9 ──→ Normal/DDA 전환 (튜토리얼 클리어)
                         │
                         └─ 해금 팝업만 계속 (Lv 9~24, show_tutorial 기반)
```

---

## 2. 데이터 구조

### 2.1 TutorialStateStore (클라이언트 로컬 저장)

```typescript
interface TutorialState {
    // Phase 진행 상태
    currentPhase: TutorialPhase;        // PHASE_0 ~ PHASE_6 | COMPLETED
    completedPhases: TutorialPhase[];   // 완료된 Phase 목록

    // 인게임 가이드 상태
    guideStepsCompleted: {
        [phaseId: string]: string[];    // e.g. { "PHASE_0": ["S1-1", "S1-2", ...] }
    };

    // 해금 팝업 상태
    shownUnlockPopups: string[];        // e.g. ["content_idle_gold", "content_betting_2"]

    // 무료 부스터 상태
    freeBoostersUsed: string[];
    freeBoostersGranted: string[];      // 지급됨 (사용 여부 무관)

    // 기믹 가이드 상태
    shownGimmickGuides: GimmickType[];  // e.g. ["runner_card", "lock_key", "rope_card"]

    // NRU 상태
    isNRU: boolean;
    firstSessionPlayCount: number;
    lobbyVisited: boolean;

    // 타임스탬프
    tutorialStartedAt: number;          // Unix ms
    tutorialCompletedAt: number;        // Unix ms
}

// 저장 용량 제한 (Facebook setDataAsync 1MB 한도)
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

### 2.2 저장 방식

| 플랫폼 | 저장소 | 키 |
|--------|--------|-----|
| Facebook Instant Games | `FBInstant.player.setDataAsync()` | `FBDataKey.TUTORIAL_STATE` |
| Standalone | `PlayerPrefs` / `LocalStorage` | `pst_tutorial_state` |

**저장 시점**: Phase 전환 시, 가이드 스텝 완료 시, 해금 팝업 표시 시, 무료 부스터 지급 시

---

## 3. 상태 머신

### 3.1 전체 플로우

```
                        ┌──────────┐
                        │ APP_INIT │
                        └────┬─────┘
                             │
                       ┌─────┴─────┐
                       │  isNRU?   │
                       └─────┬─────┘
                        Yes  │  No
                    ┌────────┤────────────────────────┐
              ┌─────┴─────┐                     ┌────┴────┐
              │ PHASE_0   │                     │ NORMAL  │
              │ (Lv 1)    │                     │ FLOW    │
              └─────┬─────┘                     └─────────┘
                    │ Lv 1 클리어
              ┌─────┴─────┐
              │ PHASE_1   │
              │ (Lv 2)    │
              └─────┬─────┘
                    │ Lv 2 클리어
              ┌─────┴─────┐
              │ PHASE_2   │
              │ (Lv 3~4)  │
              └─────┬─────┘
                    │ Lv 4 클리어
              ┌─────┴─────┐
              │ PHASE_3   │
              │ (Lv 5~7)  │
              └─────┬─────┘
                    │ Lv 7 클리어
              ┌─────┴─────┐
              │ PHASE_4   │ ── Tutorial 티어 클리어
              │ (Lv 8)    │
              └─────┬─────┘
                    │ Lv 8 클리어
              ┌─────┴─────┐
              │ PHASE_5   │ ── Normal/DDA 전환
              │ (Lv 9~14) │
              └─────┬─────┘
                    │ Lv 14 클리어
              ┌─────┴─────┐
              │ PHASE_6   │ ── 해금 팝업만 (가이드 없음)
              │ (Lv 15~24)│
              └─────┬─────┘
                    │ Lv 24 도달
              ┌─────┴──────┐
              │ COMPLETED  │
              └────────────┘
```

### 3.2 Phase 전환 조건

```typescript
function checkPhaseTransition(userLevel: number, currentPhase: TutorialPhase): TutorialPhase {
    switch (currentPhase) {
        case TutorialPhase.PHASE_0:
            return userLevel >= 2 ? TutorialPhase.PHASE_1 : currentPhase;
        case TutorialPhase.PHASE_1:
            return userLevel >= 3 ? TutorialPhase.PHASE_2 : currentPhase;
        case TutorialPhase.PHASE_2:
            return userLevel >= 5 ? TutorialPhase.PHASE_3 : currentPhase;
        case TutorialPhase.PHASE_3:
            return userLevel >= 8 ? TutorialPhase.PHASE_4 : currentPhase;
        case TutorialPhase.PHASE_4:
            return userLevel >= 9 ? TutorialPhase.PHASE_5 : currentPhase;
        case TutorialPhase.PHASE_5:
            return userLevel >= 15 ? TutorialPhase.PHASE_6 : currentPhase;
        case TutorialPhase.PHASE_6:
            return userLevel >= 25 ? TutorialPhase.COMPLETED : currentPhase;
        default:
            return currentPhase;
    }
}
```

> **의도적 하드코딩**: Phase 전환 레벨 임계값(2,3,5,8,9,15,25)은 tutorial_guide(Lv 1~8 전용맵)와 unlock(Lv 9+)의 두 시스템에 걸쳐있어 단일 시트 컬럼으로 표현 불가. 변경 시 클라이언트 패치 필수.

### 3.3 인게임 가이드 상태 머신 (Phase 0~1)

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

> **v4 변경**: S1-3 드로우 덱이 Lv 1에서 Lv 2(S2-1)로 이동. Lv 1에서는 매칭 불가 상황이 help_card_rate 80%로 거의 발생하지 않음.

---

## 4. Phase 0: 즉시 진입 (Lv 1)

### 4.1 진입 조건

```typescript
function onAppStart(): void {
    const isNRU = !TutorialStateStore.exists();

    if (isNRU) {
        PlayerData.addGold(2000);  // const 10001: nru_start_gold
        TutorialManager.startPhase0();
        SceneManager.loadInGame(mapId: "Tutorial_0351");  // tutorial_guide 전용맵
        GuideSystem.activate(TutorialPhase.PHASE_0);
    }
}
```

### 4.2 Lv 1~2 입력 제한 (v4 추가)

> **정해진 카드만 터치 가능.** 가이드가 지정한 카드 외 입력 차단.

```typescript
function onCardTapped(card: Card): void {
    if (isInputRestricted && !allowedCards.includes(card)) {
        // 오류 피드백
        Feedback.shake(card, duration: 300);  // 카드 흔들기 0.3초
        const correctCard = allowedCards[0];
        correctCard.blink(count: 3, interval: 500);  // 올바른 카드 깜빡임 힌트
        return;  // 입력 무시
    }
    // 정상 처리
    processCardMatch(card);
}
```

- **적용 구간**: Lv 1~3 전체 (Lv 1~2: 전 구간, Lv 3: 강제 클리어 스테이지)
- **해제 조건**: 가이드 완료 후 자유 플레이 모드 전환
- **피드백**: 카드 흔들기(0.3초) + 올바른 카드 깜빡임(0.5초 on/off × 3회)

### 4.3 인게임 가이드 스텝 상세

#### S1-1: 게임 화면 구성 소개

| 항목 | 값 |
|------|-----|
| **트리거** | InGameScene.onLoad() 완료 후 0.5초 |
| **딤 영역** | 전체 화면 (alpha 0.7 검정) |
| **하이라이트 대상** | 필드 카드 영역 → 드로우 덱 → 오픈 카드 (순차 0.8초 간격) |
| **유저 인터랙션** | 화면 아무 곳 탭 → 다음 스텝 |
| **스킵** | 불가 |

#### S1-2: 카드 매칭 규칙 (±1)

| 항목 | 값 |
|------|-----|
| **트리거** | S1-1 완료 직후 |
| **하이라이트 대상** | 현재 오픈 카드 ±1 값의 매칭 가능 카드 전체 |
| **화살표** | 오픈 카드 → 매칭 가능 카드 방향 (PULSE 애니메이션) |
| **오류 처리** | 매칭 불가 카드 탭 → Feedback (카드 흔들기 0.3초) + 올바른 카드 깜빡임 3회 |
| **타임아웃** | 5초 무행동 → 매칭 가능 카드 중 1개 자동 깜빡임 |
| **반복** | 최소 3회 매칭 성공 시 S1-2 해제 → S1-3 자유 플레이 |

#### S1-3: 자유 플레이

| 항목 | 값 |
|------|-----|
| **트리거** | S1-2에서 3회 매칭 성공 후 |
| **가이드** | 모든 가이드 해제, **입력 제한 해제** |
| **타임아웃 힌트** | 유지: 5초 무행동 → 매칭 가능 카드 깜빡임 |
| **help_card_rate** | 80% (difficulty_tier 20001) |
| **pity_trigger** | 3회 |

#### S1-4: 클리어 연출

| 항목 | 값 |
|------|-----|
| **보상 표시** | 골드 1,000G + α + 해머 획득 |
| **연출** | NRU 전용 강화 클리어 이펙트 |
| **다음 행동** | 결과 화면 확인 → Phase 1 (로비) 진입 |

### 4.4 Phase 0 실패 처리

| 시나리오 | 처리 |
|----------|------|
| 덱 소진 + 매칭 불가 | **자동 5장 추가 드로우** (NRU 전용, 1회/판, 무료). help_card_rate 80% + pity 3회로 Lv 1 실패율 0% 목표. |
| 앱 종료 후 재진입 | TutorialStateStore에서 현재 Phase 복원. 동일 맵 재시작 |
| 네트워크 끊김 | 로컬 플레이 유지. 결과 전송은 재연결 시 |

---


### 4.5 Lv 1 클리어 후 로비 게임 시작 버튼 강제 (v7 추가)

> **230003 content_lobby_play** (focus_bubble, lobby, level_clear=1) — Lv 1 클리어 후 로비 도달 시 게임 시작 버튼 강제.

```typescript
function onLevel1Cleared_LobbyReturn(): void {
    // 230003: focus_bubble, lobby, level_clear, trigger_value=1
    // 게임 시작 버튼 포커스. 반드시 터치.
    GuideSystem.showFocusBubble({
        target: playButton,
        stringKey: "T_TUT_LOBBY_PLAY",
        onComplete: () => markGuideShown("content_lobby_play")
    });
}
```

- **guide_type**: focus_bubble (강제, 딤+하이라이트)
- **play_scene**: lobby
- **trigger_type**: level_clear
- **trigger_value**: 1

---

## 5. Phase 1: 로비·덱 뒤집기 (Lv 2)

### 5.1 Lv 2 인게임 가이드

> **230002 content_deck_draw** (floating, tutorial_level=2) — Lv 2 인게임 시작 시 덱 뒤집기 안내.

#### S2-1: 드로우 덱 사용 (v4: Lv 1에서 이동)

| 항목 | 값 |
|------|-----|
| **트리거** | 이동 가능한 카드가 없을 때 |
| **딤 영역** | 전체 (드로우 덱만 밝게) |
| **하이라이트** | 드로우 덱 |
| **입력 제한** | 덱 외 터치 시 → 드로우 덱 깜빡임. 다른 카드 터치 거부. |
| **완료** | 드로우 덱 탭 → 카드 뽑기 → 자유 플레이(S2-2) |

#### S2-2: 자유 플레이 + 클리어

가이드 해제, 입력 제한 해제. 클리어 후 로비 진입.

### 5.2 Lv 2 클리어 후 해금 (v4 변경)

> `content_pre_level_popup`(50004)이 **Lv 2 클리어 후** 해금 (이전: Lv 3).

```typescript
function onLevel2Cleared(): void {
    // 프리레벨 팝업 해금 (Lv 2 클리어 후)
    // 230005: focus_bubble, pre_level, level_clear, trigger_value=2
    UnlockSystem.enqueue([
        { key: 50004, contentId: "content_pre_level_popup", showTutorial: true }
    ]);
    // 프리레벨 팝업에서 참가비·보상·부스터 UI 요소 안내. 반드시 터치.
}
```

---

## 6. Phase 2: 핵심 시스템 (Lv 3~4)

> **Lv 3부터 실제 입장료(골드) 차감 시작.** Lv 1~2는 입장료 없이 플레이.

### 6.1 Lv 3 해금 — 상점

```typescript
function onLevel3Cleared_LobbyReturn(): void {
    // 230004: focus_bubble, lobby, level_clear, trigger_value=3
    // 상점 아이콘 포커스. 반드시 터치.
    GuideSystem.showFocusBubble({
        target: shopIcon,
        stringKey: "T_TUT_SHOP",
        onComplete: () => markUnlockShown("content_shop")
    });
}
```

> **v4 변경**: `content_betting_1`(50009)은 **Lv 1 기본 해금** (show_tutorial=FALSE). 별도 튜토리얼 없음.

### 6.2 Lv 4 해금 — 방치골드·출석체크·플러스카드

#### 로비 순차 강제 플로우 (v4 추가)

> Lv 3 클리어 → 로비 복귀 → 3단계 모두 focus_bubble 강제, 순차 진행.

```typescript
async function onLevel3Cleared_LobbySequence(): Promise<void> {
    // ① 방치골드 해금 팝업 (230006, focus_bubble)
    await GuideSystem.showFocusBubble({
        target: idleGoldArea,
        stringKey: "T_TUT_IDLE_GOLD"
    });

    // ② 방치골드 수령 버튼 강제 터치 (230008, focus_bubble)
    await GuideSystem.showFocusBubble({
        target: idleGoldCollectButton,
        stringKey: "T_TUT_IDLE_GOLD_COLLECT",
        onComplete: () => IdleGoldManager.collect()
    });

    // ③ 출석체크 아이콘 강제 터치 (230009, focus_bubble)
    await GuideSystem.showFocusBubble({
        target: dailyCheckIcon,
        stringKey: "T_TUT_DAILY_CHECK"
    });
}
```

#### 인게임 — 플러스카드

```typescript
// 230007: focus_bubble, ingame, first_appear, trigger_value=4
function onPlusCardFirstAppear(plusCard: Card): void {
    // ±1 매칭 규칙 안내. focus_bubble 강제. 반드시 해당 카드 터치하여 매칭.
    GuideSystem.showGimmickGuide(plusCard, "T_TUT_PLUS_CARD");
}
```

---

## 7. Phase 3: 스트릭·컬렉션·와일드 (Lv 5~7)

### 7.1 Lv 5 — 스트릭·리더보드

```typescript
// 230010: focus_bubble, ingame, first_appear, trigger_value=5
// 인게임 2연속 매칭 시 스트릭 미터 안내
function onStreakFirstTriggered(): void {
    GuideSystem.showGimmickGuide(streakMeter, "T_TUT_STREAK");
}

// 230011: focus_bubble, lobby, level_clear, trigger_value=5
// 클리어 후 로비에서 리더보드 아이콘 터치 유도
```

### 7.2 Lv 6 — 콜렉션

```typescript
// 230012: focus_bubble, lobby, level_clear, trigger_value=6
// 콜렉션 해금 + 아이콘 focus_bubble 터치 유도
// 퍼즐 피스: x1=1장, x2=3장, x4=5장
```

### 7.3 Lv 7 — 와일드 카드 FREE×3

> **v5 변경**: 와일드 카드를 언두/파이어웍스와 동일 패턴으로 변경 — 인게임 floating 가이드 + FREE×3 무료 지급.

```typescript
// 230013: floating, ingame, first_appear, trigger_value=7
// 비강제 (is_forced=FALSE), 탭 스킵 가능. FREE×3 무료 지급.
// is_dedicated_map=TRUE, tutorial_map_id=TUTO_0007
async function executeWildCardTutorial_Lv7(): Promise<void> {
    // floating 말풍선 (딤 없음, 스킵 가능)
    FloatingBubble.show({
        target: wildCardSlot,
        stringKey: "T_TUT_WILD_CARD",
        dismissOnTap: true  // 비강제
    });
    FreeTag.show(wildCardSlot, text: "FREE ×3");
    grantFreeBooster("booster_wild_card", count: 3);
}
```

> 와일드 카드가 전용 위치에서 출현하여 모든 카드와 매칭 가능.

---

## 8. Phase 4: 부스터·클리어 (Lv 8)

### 8.1 파이어웍스 — FREE×3

```typescript
// 230014: focus_bubble, pre_level, level_clear, trigger_value=8
// 클리어 후 프리레벨 팝업에서 해금. 앞줄 카드 전체 제거. FREE×3.
async function executeFireworksTutorial(): Promise<void> {
    FreeTag.show(fireworksSlot, text: "FREE ×3");
    await GuideSystem.showFocusBubble({
        target: fireworksSlot,
        stringKey: "T_TUT_FIREWORKS",
        withinPopup: true
    });
    grantFreeBooster("booster_fireworks", count: 3);
}
```

### 8.2 언두 가이드 — floating, FREE×3 (v4 정정)

> **Lv 3부터 UI에 보이기만** (show_tutorial=FALSE). **Lv 8에서 FREE×3 무료 지급**.

```typescript
// 230015: floating, ingame, first_appear, trigger_value=8
// 비강제 (is_forced=FALSE), 탭 스킵 가능
async function executeUndoTutorial_Lv8(): Promise<void> {
    // floating 말풍선 (딤 없음, 스킵 가능)
    FloatingBubble.show({
        target: undoButton,
        stringKey: "T_TUT_UNDO",
        dismissOnTap: true  // 비강제
    });
    FreeTag.show(undoButton, text: "FREE ×3");
    grantFreeBooster("booster_undo", count: 3);
}
```

### 8.3 엑스트라 덱 — 상황 기반, FREE×3

```typescript
// 230016: floating, ingame, condition, trigger_value=deck_exhausted
// is_forced=FALSE (비강제, 딤 없이 캐릭터+말풍선, 탭 스킵 가능). 레벨 무관. 덱 모두 소진 + 매칭 불가 첫 발생 시.
function onDeckExhausted_NoMatches(): void {
    if (tutorialState.shownUnlockPopups.includes("booster_extra_deck")) return;
    GuideSystem.showFloating({
        target: extraDeckButton,
        stringKey: "T_TUT_EXTRA_DECK",
        dismissOnTap: true  // is_forced=FALSE, 딤 없음
    });
    FreeTag.show(extraDeckButton, text: "FREE ×3");
    grantFreeBooster("booster_extra_deck", count: 3);
}
```

### 8.4 도시 꾸미기 강제 (v4 정정)

> 진행 중인 도시의 망치가 충족되면 꾸미기를 **강제**하고 다음 시티로 전환. 망치 충족 시마다 반복 발동.

```typescript
// 230017: focus_bubble, lobby, level_clear, trigger_value=8 (최초)
// 230026: focus_bubble, lobby, condition, trigger_value=hammer_ready (반복, is_repeatable=TRUE)
function onHammerReady(zoneId: string): void {
    GuideSystem.showFocusBubble({
        target: cityDecoArea,
        stringKey: "T_TUT_CITY_DECO",
        onComplete: () => SceneManager.pushCityDeco(focusZone: zoneId)
    });
}
```

### 8.5 Tutorial 클리어 → Normal 전환

| 항목 | Lv 8 (Tutorial) | Lv 9 (Normal) | 변화 |
|------|-----------------|---------------|------|
| difficulty_tier | Tutorial (tier_id=1) | Normal (tier_id=2) | 티어 전환 |
| help_card_rate | 8000 (80%) | 5000 (50%) | **-30%p** |
| pity_trigger | 3회 | 5회 | +2회 |
| streak_sustain | 5회 | 4회 | -1회 |
| 맵 풀 | tutorial_guide 전용맵 | 일반 schedule | 맵 전환 |
| DDA | 비활성 | Lv 11부터 활성 | — |

> **Lv 9~10 완충 구간**: Normal 고정(dynamic_level 30002). DDA 없이 Normal만 제공하여 전환 충격 완화.

---

## 9. Phase 5~6: 점진적 해금 (Lv 9~24)

### 9.1 Lv 9: 베팅 x2 + 데일리 휠 (순차)

```typescript
async function onLevel9Cleared_LobbyReturn(): Promise<void> {
    // 230018: 베팅 x2 해금 팝업
    await UnlockSystem.showPopup({ key: 50016, contentId: "content_betting_2" });

    // 230019: 데일리 휠 해금 팝업 → 아이콘 터치 유도
    await UnlockSystem.showPopup({ key: 50017, contentId: "content_daily_wheel" });
    await GuideSystem.showFocusBubble({
        target: dailyWheelIcon,
        stringKey: "T_TUT_DAILY_WHEEL"
    });
}
```

### 9.2 Lv 11: IAP + DDA

- `content_iap_popup`(50018): show_tutorial=FALSE. IAP 팝업 노출 시작. 닫기 가능.
- DDA 시스템 활성화.

### 9.3 Lv 12: 이벤트 강제 터치

```typescript
// 이벤트 3종(50019~50021) 동시 해금 (show_tutorial=FALSE, 자동 노출)
// 230020: content_event_forced — 미참여 이벤트 아이콘 강제 터치 유도 (세션당 1회)
async function onLevel12Cleared_LobbyReturn(): Promise<void> {
    UnlockSystem.markUnlocked([50019, 50020, 50021]);
    const activeEvent = EventManager.getFirstActiveEvent();
    if (activeEvent) {
        await GuideSystem.showFocusBubble({
            target: activeEvent.lobbyIcon,
            stringKey: "T_TUT_EVENT_FORCED"
        });
    }
}
```

### 9.4 나머지 해금

| Lv | content_id | guide_key | 가이드 | 비고 |
|----|-----------|-----------|--------|------|
| 14 | gimmick_runner_card | 230021 | focus_bubble, ingame, first_appear | 러너 카드 기믹 |
| 17 | content_betting_4 | 230022 | focus_bubble, lobby, level_clear | 베팅 x4 해금 |
| 19 | gimmick_lock_key | 230023 | focus_bubble, ingame, first_appear | 자물쇠+열쇠 기믹 |
| 22 | gimmick_rope_card | 230024 | focus_bubble, ingame, first_appear | 얼음카드 기믹 |
| 24 | booster_golden_ticket | 230025 | focus_bubble, lobby, level_clear | 골든 티켓 FREE×3 |

### 9.5 상시 반복 가이드

| key | content_id | trigger | value | 설명 |
|-----|-----------|---------|-------|------|
| 230026 | content_city_deco | condition | hammer_ready | 도시 꾸미기 강제 (is_repeatable=TRUE) |
| 230027 | gimmick_lock_key_tip | touch | lock_card | 키락 카드 터치 시 floating 말풍선 (비강제, 반복) |
| 230028 | gimmick_rope_card_tip | touch | rope_card | 얼음카드 터치 시 floating 말풍선 (비강제, 반복) |

### 9.6 기믹 첫 등장 인게임 가이드

러너카드(Lv 14), 자물쇠(Lv 19), 얼음카드(Lv 22), 플러스카드(Lv 4)는 **첫 등장 맵에서 인게임 가이드**:

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

---

## 10. 인게임 가이드 시스템

### 10.1 가이드 컴포넌트 (5종)

| 컴포넌트 | 용도 | 상세 |
|---------|------|------|
| **Focus Bubble** | 새 메카닉/시스템 설명 + 행동 유도 | 딤 배경 + 대상 강조 + 말풍선. 강제(is_forced=TRUE). 22건. |
| **Floating** | 보조 안내, 터치 팁 | 반투명 말풍선/화살표. 비강제(is_forced=FALSE). 6건 (230001, 230002, 230013, 230015, 230027, 230028). |
| **Highlight** | 특정 행동 유도 (탭 대상) | 딤 배경 + 대상 UI 강조. alpha 0.4~0.7. |
| **Arrow** | 매칭 가능 카드, 드로우덱 유도 | 탭 유도 애니메이션 화살표. PULSE / BOUNCE. |
| **Feedback** | 오류 시 즉각 안내 | 잘못된 행동 시 흔들기(0.3초) + 올바른 카드 깜빡임 3회. |

### 10.2 trigger_type 정의 (5종)

| trigger_type | 정의 | play_scene | trigger_value | 건수 |
|-------------|------|------------|---------------|------|
| `level_clear` | 해당 레벨 클리어 후 로비/프리레벨 복귀 시 | lobby, pre_level | 레벨 번호 (int) | 15 |
| `first_appear` | 인게임에서 해당 기믹/콘텐츠 첫 등장 시 | ingame | 레벨 번호 (int) | 7 |
| `condition` | 특정 상황 조건 충족 시 (레벨 무관) | ingame, lobby | 조건 키워드 | 2 |
| `tutorial_level` | 튜토리얼 레벨 진입 시 자동 (Lv 1~2) | ingame | 레벨 번호 (int) | 2 |
| `touch` | 특정 카드 터치 시 말풍선 (반복 가능) | ingame | 대상 키워드 | 2 |

---

## 11. 해금 팝업 시스템

### 11.1 팝업 표시 조건

```typescript
function shouldShowUnlockPopup(contentId: string, userLevel: number): boolean {
    const unlockEntry = UnlockSheet.get(contentId);
    if (!unlockEntry) return false;
    if (unlockEntry.show_tutorial === false) return false;
    if (tutorialState.shownUnlockPopups.includes(contentId)) return false;

    switch (unlockEntry.condition_type) {
        case "level":
            return userLevel >= unlockEntry.condition_val;
        case "deck_exhausted":
            return isDeckExhausted && getMatchableCards().length === 0;
        default:
            return false;
    }
}
```

### 11.2 무료 부스터 지급 로직

```typescript
function grantFreeBooster(contentId: string, count: number = 3): void {
    if (tutorialState.freeBoostersGranted.includes(contentId)) return;
    tutorialState.freeBoostersGranted.push(contentId);

    switch (contentId) {
        case "booster_undo":
            InGameBooster.setFreeUse("undo", count);  // Lv 8
            break;
        case "booster_extra_deck":
            InGameBooster.setFreeUse("extra_deck", count);  // 상황 기반
            break;
        case "booster_wild_card":
            InGameBooster.setFreeUse("wild_card", count);  // Lv 7
            break;
        case "booster_fireworks":
            PreLevelBooster.setFreeUse("fireworks", count);  // Lv 8
            break;
        case "booster_golden_ticket":
            PreLevelBooster.setFreeUse("golden_ticket", count);  // Lv 24
            break;
    }
    saveTutorialState();
}
```

> 무료 부스터 수량: 모두 **3개**. UI에 "FREE ×3" 표기 필수.

---

## 12. NRU 제한 규칙

| 규칙 | 적용 구간 | 설명 |
|------|----------|------|
| 입력 제한 | Lv 1~3 | 정해진 카드만 터치 가능. 오류→흔들기+깜빡임. |
| 로비 스킵 | Lv 1 | NRU 첫 진입 시 로비 건너뛰고 바로 인게임. |
| 입장료 면제 | Lv 1~3 | 입장료(골드) 차감 없이 플레이. Lv 3부터 입장료 시작. |
| 자동 드로우 구제 | Lv 1 | 덱 소진+매칭 불가 시 자동 5장 추가 (1회/판, 무료). |
| Tutorial 티어 | Lv 1~8 | help_card_rate 80%, pity_trigger 3회. |

---

## 13. Analytics 이벤트

```typescript
// Phase 전환 시
Analytics.track("tutorial_phase_change", {
    from: previousPhase,
    to: currentPhase,
    userLevel: PlayerData.getLevel(),
    timeInPhase: Date.now() - phaseStartTime
});

// Tutorial 클리어 시 (Lv 8 → Lv 9)
Analytics.track("tutorial_graduated", {
    totalTime: Date.now() - tutorialState.tutorialStartedAt,
    totalPlays: 8,
    goldBalance: PlayerData.getGold(),
    hammerBalance: PlayerData.getHammer()
});

// 가이드 스텝 완료 시
Analytics.track("tutorial_step_completed", {
    phase: currentPhase,
    stepId: stepId,
    duration: stepDuration
});

// 무료 부스터 사용 시
Analytics.track("tutorial_free_booster_used", {
    boosterId: contentId,
    remainingFree: remainingCount,
    userLevel: PlayerData.getLevel()
});
```

---

## 14. 에지 케이스

| 시나리오 | 처리 |
|----------|------|
| 앱 종료 후 재진입 | TutorialStateStore에서 현재 Phase·스텝 복원 |
| 네트워크 끊김 | 로컬 플레이 유지. 결과 전송은 재연결 시 |
| 튜토리얼 맵 파일 없음 | fallback 맵 사용 + 에러 로그 |
| free_booster FK 오류 | 무료 부스터 미지급 + 경고 로그 |
| Facebook setDataAsync 실패 | 로컬 캐시 유지, 다음 세션 재시도 |
| 같은 가이드 중복 표시 시도 | shownUnlockPopups/shownGimmickGuides로 1회 제한 |

---

## 15. QA 체크리스트

### Phase 0 (Lv 1)

- [ ] NRU 첫 진입 시 로비 스킵 → 바로 인게임
- [ ] S1-1 순차 하이라이트 (필드→드로우→오픈) 0.8초 간격
- [ ] S1-2 매칭 불가 카드 탭 → 흔들기 0.3초 + 올바른 카드 깜빡임 3회
- [ ] S1-2 5초 무행동 → 힌트 깜빡임
- [ ] S1-2 3회 매칭 후 자유 플레이 전환
- [ ] 클리어 시 골드 1,000G + α 표시
- [ ] 입장료 0 확인 (Lv 1~2)

### Phase 1 (Lv 2)

- [ ] S2-1 이동 불가 시 드로우 덱 하이라이트
- [ ] S2-1 드로우 덱 외 터치 → 피드백 (터치 거부)
- [ ] Lv 2 클리어 후 프리레벨 팝업 해금 (50004, val=2)
- [ ] 프리레벨 팝업에서 참가비·보상·부스터 UI 안내

### Phase 2 (Lv 3~4)

- [ ] Lv 3부터 입장료 차감 시작
- [ ] Lv 3 상점 아이콘 focus_bubble
- [ ] Lv 4 방치골드→수령→출석체크 순차 강제 플로우 (3단계)
- [ ] Lv 4 플러스카드 인게임 첫 등장 시 가이드

### Phase 3 (Lv 5~7)

- [ ] Lv 5 스트릭 미터 2연속 매칭 시 가이드
- [ ] Lv 5 리더보드 아이콘 터치 유도
- [ ] Lv 6 콜렉션 해금 + 터치 유도
- [ ] Lv 7 와일드 카드 인게임 floating 가이드 (탭 스킵 가능)
- [ ] Lv 7 와일드 카드 FREE×3 무료 지급

### Phase 4 (Lv 8)

- [ ] 파이어웍스 FREE×3 프리레벨 팝업
- [ ] 언두 floating 가이드 (비강제, 탭 스킵)
- [ ] 언두 FREE×3 지급
- [ ] 엑스트라 덱 상황 기반 (덱 소진+매칭 불가)
- [ ] 도시 꾸미기 강제 (망치 충족 시)

### Phase 5~6 (Lv 9~24)

- [ ] Lv 9 베팅x2 → 데일리 휠 순차 해금
- [ ] Lv 11 IAP 팝업 노출 시작
- [ ] Lv 12 이벤트 강제 터치
- [ ] Lv 14 러너 카드 인게임 가이드
- [ ] Lv 17 베팅x4 해금
- [ ] Lv 19 자물쇠+열쇠 인게임 가이드
- [ ] Lv 22 얼음카드 인게임 가이드
- [ ] Lv 24 골든 티켓 FREE×3

### 공통

- [ ] 모든 focus_bubble 가이드에서 터치 완료 필수
- [ ] 모든 floating 가이드에서 탭 스킵 가능
- [ ] 도시 꾸미기 강제 반복 발동 (is_repeatable=TRUE)
- [ ] 키락/얼음카드 터치 시 floating 말풍선 반복
- [ ] Tutorial → Normal 전환 시 help_card_rate 80%→50%
- [ ] Lv 9~10 DDA 비활성 (Normal 고정)
