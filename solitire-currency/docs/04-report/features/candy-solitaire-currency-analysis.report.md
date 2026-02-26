# Candy Solitaire 재화 & 보상 시스템 분석 보고서

> **상태**: 완료 (v3.0 - 3차 수정판)
>
> **프로젝트**: Candy Solitaire 역공학 분석
> **대상 게임**: com.king.apps.candysolitaire (King/Activision Blizzard)
> **내부 코드명**: Bonsai (IAP) / Nirvana (네임스페이스)
> **작성자**: 분석팀
> **최종 수정**: 2026-02-26

---

## ⚠️ v3.0 수정 내역

| 항목 | 이전 분석 (오류) | v3.0 수정 |
|------|----------------|-----------|
| Energy 역할 | 레벨 플레이 소모 (생명력) | **레벨 클리어 후 획득 → 꾸미기 Task 소모** |
| 농장 건물 콘텐츠 | 본 게임의 메타게임 | FARM_KING_* = Farm Heroes SDK / Muffin* = 별도 King 게임 |
| 라이브 이벤트 | 20종 목록만 제공 | 각 이벤트별 메커니즘 상세 분석 추가 |
| 입장료 시스템 | 미분석 | EntryCost + Betup + OnFire 시스템 구조 추가 |
| 보상 곡선 | 미분석 | CoinRewardTLB + StreakMultiplier 구조 추가 |

---

## 1. 분석 환경 및 대상

| 항목 | 내용 |
|------|------|
| 분석 파일 | `global-metadata.dat` (17MB Unity IL2CPP 메타데이터) |
| 엔진 | Unity IL2CPP (Android APK) |
| 코드 네임스페이스 | `King.Nirvana.*`, `Solitaire.*` |
| IAP 접두사 | `Bonsai*` |
| 분석 방법 | `strings` 명령어 + 패턴 분석 |
| 실제 수치 | 서버 설정값 → **바이너리 추출 불가** (설계 구조만 확인 가능) |

---

## 2. 코드 출처 분리 ★중요

바이너리에는 여러 King 게임의 코드가 공유 SDK로 함께 번들되어 있습니다.

| 접두사 / 네임스페이스 | 실제 귀속 게임 | 내용 |
|----------------------|--------------|------|
| `King.Nirvana.*` / `Solitaire.*` | **Candy Solitaire** (본 게임) | 게임 로직, 경제, 이벤트 전체 |
| `Bonsai*` | **Candy Solitaire** (본 게임) | IAP 제품 ID 접두사 |
| `FARM_KING_*` | **Farm Heroes Saga** | King 공유 SDK 피처 플래그 (본 게임 무관) |
| `DiamondDigger*` | **Diamond Digger Saga** | 다이아몬드 오인 원인 (본 게임 무관) |
| `Muffin*` | **별도 King 음식트럭 게임** | MuffinHamburgerTruck, MuffinPizzaTruck, MuffinIngredient*, MuffinRecipe* 등 — 본 게임 무관 |

> **결론**: 이전 보고서에서 언급한 농장 건물(FarmHouseUnlock 등) IAP 제품은 **Candy Solitaire의 실제 IAP ID**이며,
> `FARM_KING_*` 피처 플래그는 Farm Heroes SDK 코드로 본 게임과 무관.
> `Muffin*` 접두사의 TaskCost/Recipe/Ingredient 전체는 별도 King 게임 코드.

---

## 3. 재화 시스템 (5종)

### 3.1 재화 유형 전체

| 재화 | 코드 | 역할 | 획득 | 소모 |
|------|------|------|------|------|
| **Coins** (소프트) | `King.Nirvana.Simulation\|Coins` | 주요 게임 화폐 | 레벨 클리어, 이벤트, 일일 보상 | 레벨 입장료, 부스터 구매 |
| **Energy** (⚡번개) | `King.Nirvana.Simulation\|Energy` | 꾸미기 진행 재화 | **레벨 클리어 후 획득** | **꾸미기 Task 완료** |
| **HardCurrency** (프리미엄) | `NirvanaAppHardCurrencyBreakdownApi` | 프리미엄 화폐 | IAP 구매, 이벤트 보상 | 건물/레시피 잠금 해제 |
| **Stars** (별) | `King.Nirvana.Simulation\|Stars` | 토너먼트 진행 재화 | 레벨 클리어 시 획득 | 토너먼트/컵 랭킹 |
| **FreeEntry** (무료 입장권) | `King.Nirvana.Simulation\|FreeEntry` | 무료 플레이 티켓 | 이벤트, 광고 시청 | 레벨 입장료 대체 |

---

## 4. Energy(⚡) = 꾸미기 진행 재화 ★핵심 수정

### 4.1 Energy 흐름

```
[레벨 클리어]
      │
      ▼ rewardEnergy / energyEarned
[Energy 획득]
      │
      ▼ AnimateEnergySpend
[꾸미기 화면]
      │
   ┌──┴──────────────────────────────┐
   │  RegularTask (일반 꾸미기 요소)  │
   │  taskEnergyCost = N             │
   └─────────────────────────────────┘
   ┌──┴──────────────────────────────┐
   │  FinalTask (최종 꾸미기 요소)   │
   │  finalTaskCost = M              │
   └─────────────────────────────────┘
      │
      ▼ TaskCompletedEvent
[해당 꾸미기 요소 1개 완성]
      │
      ▼ AreaCompletedEvent
[해당 구역 완료 → 다음 구역 잠금 해제]
```

### 4.2 Task 시스템 구조

| 클래스 | 설명 |
|--------|------|
| `RegularTaskDefinition` | 일반 꾸미기 Task (Energy 소모) |
| `FinalTaskDefinition` | 구역 최종 Task (더 높은 Energy 소모) |
| `TaskDefinition` | 공통 기반 클래스 |
| `TaskNode` | 씬 내 Task 위치 노드 |
| `TaskListItem` | Task 목록 UI 항목 |
| `TaskPopUp` | Task 완료 팝업 |
| `MetaTasksPopupController` | Task 팝업 컨트롤러 |

### 4.3 Energy 소모 규칙

- **각 꾸미기 요소마다 Energy 소모량 상이** (`taskEnergyCost` 필드로 개별 지정)
- `RegularTask` vs `FinalTask` 2가지 유형 존재
- FinalTask가 더 높은 Energy 비용 (`finalTaskCost`)
- Energy 부족 시: `OutOfEnergyPopupController` 팝업 표시
- Energy는 IAP로 충전 가능: `BonsaiOneEnergy`, `BonsaiRefillEnergy`, `BonsaiUnlimitedEnergyUsingHours/Minutes`

### 4.4 AreaProgression 구조

```
MetaScene (꾸미기 전체 화면)
  └─ Area 1
       ├─ RegularTask × N  (각기 다른 energyCost)
       └─ FinalTask × 1    (더 높은 finalTaskCost)
            └─ AreaCompletedEvent → Area 2 잠금 해제
  └─ Area 2
       ├─ RegularTask × N
       └─ FinalTask × 1
  └─ ...
```

> **실제 에너지 수치**: 서버 설정 파일에 저장 → 바이너리에서 추출 불가

---

## 5. HardCurrency 소모 구조

HardCurrency는 꾸미기 Task와 **별개**로 메타게임 진행을 잠금 해제합니다.

### 5.1 건물 잠금 해제 IAP (Bonsai 접두사)

| IAP 제품 ID | 내용 |
|------------|------|
| `BonsaiFarmHouseUnlock` | 건물 1 잠금 해제 |
| `BonsaiBeehiveUnlock` | 건물 2 잠금 해제 |
| `BonsaiChickenCoopUnlock` | 건물 3 잠금 해제 |
| `BonsaiCornFieldUnlock` | 건물 4 잠금 해제 |
| `BonsaiCowPastureUnlock` | 건물 5 잠금 해제 |
| `BonsaiHerbPatchUnlock` | 건물 6 잠금 해제 |
| `BonsaiWellUnlock` | 건물 7 잠금 해제 |
| `BonsaiWindmillUnlock` | 건물 8 잠금 해제 |
| `BonsaiBuildingUnlock` | 범용 건물 잠금 해제 |

> ⚠️ IAP 제품 ID는 내부 명칭. 실제 게임 내 비주얼 테마와 이름이 다를 수 있음.

### 5.2 레시피 그룹 잠금 해제 IAP

| IAP 제품 ID | 내용 |
|------------|------|
| `BonsaiUnlockRecipeGroup1` ~ `BonsaiUnlockRecipeGroup15` | 레시피 그룹 15개 순차 잠금 해제 |

### 5.3 HardCurrency 잔액 추적

```
NirvanaAppHardCurrencyBreakdownApi.getBalance
  ├─ freeHardCurrency   (이벤트/보상으로 획득)
  └─ paidHardCurrency   (IAP로 구매)
```

---

## 6. 라이브 이벤트 시스템 상세

Candy Solitaire에는 확인된 **15개 이상**의 라이브 이벤트가 존재합니다.

### 6.1 이벤트 목록 및 메커니즘

#### 1) BubbleGum Team Event (버블검 팀 이벤트)
| 항목 | 내용 |
|------|------|
| 수집 대상 | BubbleGum (버블검) — 레벨 클리어 시 획득 |
| 진행 방식 | **팀 협력** 이벤트 (팀원과 합산) |
| 진행 구조 | 마일스톤 누적 + 리더보드 랭킹 |
| 보상 유형 | `BubblegumEventMilestoneRewards`, `BubblegumEventRankRewards` |
| 분석 데이터 | `num_gums_player` (개인), `num_gums_team` (팀) 추적 |
| 이벤트 종료 | `BubblegumEventWinPopup`, `BubblegumEventWinProgressionData` |

#### 2) CatchTheTroll (트롤 잡기)
| 항목 | 내용 |
|------|------|
| 수집 대상 | 트롤 (레벨 플레이 중 발견) |
| 진행 방식 | 단계(Tier)별 트롤 사냥 |
| 진행 구조 | `CatchTheTrollTierSettings` — 멀티 티어 |
| 보상 유형 | `CatchTheTrollChest` — 상자 보상 |
| 특징 | Hunt 활성화/비활성화 상태 관리 (`CatchTheTrollHuntState`) |

#### 3) DiceRoll Event (주사위 굴리기)
| 항목 | 내용 |
|------|------|
| 수집 대상 | DiceRoll 토큰 (레벨 클리어 시 획득) |
| 진행 방식 | 보드게임 스타일 — 주사위 굴려 보드 이동 |
| 진행 구조 | `DiceRollProgressBar`, `DiceRollBoardController`, `DiceRollPawnController` |
| 보상 유형 | `DiceRollGiftBoxController` — 위치별 선물 상자 |
| 특징 | 자동 굴리기(`DiceRoll-AutoRoll`) 지원 |

#### 4) DiggingEvent (발굴 이벤트)
| 항목 | 내용 |
|------|------|
| 수집 대상 | 숨겨진 캔디 발굴 |
| 진행 방식 | 그리드에서 숨겨진 캔디 위치 발굴 |
| 진행 구조 | `HiddenCandyPosition` (좌표), `Coordinates` |
| 보상 유형 | `DiggingEventReward` |
| 특징 | `DiggingEventCandyBoxController` — 캔디박스 컨트롤러 |

#### 5) EpisodeChase (에피소드 체이스)
| 항목 | 내용 |
|------|------|
| 수집 대상 | Stars (레벨 클리어 시 획득) |
| 진행 방식 | 에피소드 완료 레이스 (상대방과 경쟁) |
| 진행 구조 | 단계별 페이즈 (`EpisodeChaseMainPhase`, `EpisodeChaseLockedPhase`) |
| 보상 유형 | 승리 시 `EpisodeChaseWinPopup` |
| 특징 | 봇 상대 지원 (`EpisodeChaseBotSettings`) |

#### 6) EpisodeRace (에피소드 레이스)
| 항목 | 내용 |
|------|------|
| 수집 대상 | Stars (레벨 클리어 시 획득) |
| 진행 방식 | 티어 기반 레이스 토너먼트 |
| 진행 구조 | `EpisodeRaceTier`, `EpisodeRaceTierChecklist`, `EpisodeRaceTierButton` |
| 보상 유형 | 티어별 보상 (`EpisodeRaceWinPopup`) |
| 특징 | 체크리스트 형태의 목표 관리 |

#### 7) GlobeTrotting (세계 여행)
| 항목 | 내용 |
|------|------|
| 수집 대상 | 여행 포인트 (레벨 클리어 시 획득) |
| 진행 방식 | 목적지별 마일스톤 달성 |
| 진행 구조 | `GlobeTrottingMilestone`, `GlobeTrottingMilestoneCheckpoint`, `GlobeTrottingGoal` |
| 보상 유형 | `GlobeTrottingMilestoneReward` |
| 분석 데이터 | `"event_name":"globe_trotting","level": {0}` 추적 |

#### 8) StickerCollection (스티커 컬렉션)
| 항목 | 내용 |
|------|------|
| 수집 대상 | Sticker (스티커) 조각 |
| 진행 방식 | 스티커 팩 → 스티커 세트 완성 |
| 진행 구조 | `StickerSet`, `StickerPack`, `StickerPackDrop`, `StickerReference` |
| 보상 유형 | 세트 완성 보상, `Capstone` (최종 보상) |
| 특징 | `TokenExchange` (토큰 교환), `TokenChest` |

#### 9) PostcardEvent (엽서 이벤트)
| 항목 | 내용 |
|------|------|
| 수집 대상 | 엽서 조각 |
| 진행 방식 | 단계별 엽서 완성 (`PostcardStep`) |
| 진행 구조 | `PostcardStep`, `PostcardCompleted`, `PostcardReminder` |
| 보상 유형 | 엽서 완성 시 보상 (`General.PostcardCompletedRewardsPopup`) |

#### 10) Quests (퀘스트)
| 항목 | 내용 |
|------|------|
| 수집 대상 | 퀘스트 목표 (레벨 플레이, 카드 수집 등) |
| 진행 방식 | 사이클 기반 퀘스트 (`IQuestCycle`) |
| 진행 구조 | `QuestMilestoneSettings`, `QuestCycleData` |
| 보상 유형 | `QuestMilestoneCompletedEvent` — 마일스톤별 보상 |
| 특징 | `ICollectionTask` — 수집형 퀘스트 지원 |

#### 11) SeasonPass (시즌 패스)
| 항목 | 내용 |
|------|------|
| 수집 대상 | SeasonPass 포인트 |
| 진행 방식 | 시즌 기간 내 티어별 진행 |
| 진행 구조 | `SeasonPassTier`, `SeasonPassMainPhase`, `SeasonPassBonusBank` |
| 보상 유형 | 티어별 보상 (`SeasonPassTierSettings`) |
| 특징 | 무료 티어 + 유료 패스 2트랙, `SeasonPassPointsCollectionTarget` |

#### 12) Cup / TriPeaksTournament (컵 토너먼트)
| 항목 | 내용 |
|------|------|
| 수집 대상 | Stars (토너먼트 점수) |
| 진행 방식 | 스테이지 기반 토너먼트 (승급/탈락) |
| 진행 구조 | `CupStage`, `CupSchedule`, `CupParticipants` |
| 보상 유형 | 스테이지 순위별 보상 (`CupStageRankSpan`) |
| 특징 | TriPeaksTournament 전용 API (`NirvanaTripeaksApi`) |

#### 13) DailyLoginCalendar (일일 로그인)
| 항목 | 내용 |
|------|------|
| 수집 대상 | 매일 로그인 |
| 진행 방식 | 달력 기반 사이클 (`DailyLoginCalendarCycleData`) |
| 보상 유형 | 날짜별 보상 (`DailyLoginBonus`, `DailyLoginStreak`) |
| 특징 | 연속 로그인 스트릭 추적 |

#### 14) TowerOfFortune (행운의 탑)
| 항목 | 내용 |
|------|------|
| 수집 대상 | 티켓 (`TowerOfFortuneTicketsProduct`) |
| 진행 방식 | 탑 층 오르기 → 상자 선택 |
| 진행 구조 | 3개 상자 레벨 + 잭팟 |
| 보상 유형 | `TowerOfFortuneChest1/2/3Product`, `TowerOfFortuneJackpotProductDefault` |

#### 15) TugOfCards (카드 줄다리기)
| 항목 | 내용 |
|------|------|
| 수집 대상 | 카드 점수 |
| 진행 방식 | PvP 스타일 대결 (팀 vs 팀 또는 1:1) |
| 진행 구조 | `TugOfWarFactory`, `TugOfWarLeaderboard`, `TugOfWarVersusItem` |
| 보상 유형 | 승리 시 상자 보상 (`TugOfWarChestUISettings`) |
| 특징 | 매치메이킹 지원 (`TugOfWarMatchmakingPopup`), 봇 상대 지원 |

#### 16) HiLoHustle (하이/로우 허슬)
| 항목 | 내용 |
|------|------|
| 수집 대상 | HiLoHustle 토큰 |
| 진행 방식 | 하이/로우 카드 예측 게임 |
| 진행 구조 | `HiLoHustleCardView`, `HiLoHustleSceneRoot`, `HiLoHustleMilestoneView` |
| 보상 유형 | 마일스톤 보상 |

#### 17) FriendOMeter (우정 미터)
| 항목 | 내용 |
|------|------|
| 수집 대상 | 우정 포인트 |
| 진행 방식 | 시즌 기반 친구와 함께 진행 (`FriendshipSeason`) |
| 진행 구조 | `FriendOMeterStage`, `FriendOMeterMilestone` |
| 보상 유형 | 스테이지 완료 보상 |

#### 18) AlbumsCollection (앨범 컬렉션)
| 항목 | 내용 |
|------|------|
| 수집 대상 | 앨범 카드/스티커 |
| 진행 방식 | 앨범 완성 수집 |
| 보상 유형 | `AlbumsCollectionTarget` — 컬렉션 목표 보상 |
| 특징 | Care Bears 테마 앨범 확인 (`Albums.CareBears2/4/5`) |

#### 19) CardBack 컬렉션
| 항목 | 내용 |
|------|------|
| 수집 대상 | CardBack 조각 (레벨 보상으로 드롭) |
| 진행 방식 | 조각 수집 → CardBack 완성 |
| 진행 구조 | 3카테고리: Classic / Regular / Seasonal |
| 보상 유형 | 완성된 CardBack 스킨 장착 |
| 특징 | `CardBackRewardProvider`, `CardBackProgressBar` |

#### 20) WinStreak / OnFire (연승 이벤트)
| 항목 | 내용 |
|------|------|
| 수집 대상 | 연속 레벨 클리어 |
| 진행 방식 | 연승 시 OnFire 상태 활성화 |
| 보상 유형 | StreakMultiplier (코인 보상 배율 증가) |
| 특징 | `StreakMultiplierChangedEvent`, `CoreUIStreakMultiplierView` |

### 6.2 이벤트 보상 타입 분류

| 보상 타입 | 설명 | 관련 이벤트 |
|-----------|------|------------|
| `CoinsCollectionTarget` | Coins 마일스톤 보상 | 대부분 이벤트 |
| `BoosterCollectionTarget` | 부스터 보상 | 이벤트 마일스톤 |
| `StickerCollectionTarget` | 스티커 보상 | StickerCollection |
| `ChestReward` (`SerializableChestReward`) | 상자 보상 | TugOfCards, TowerOfFortune 등 |
| `SeasonPassPointsCollectionTarget` | 시즌패스 포인트 | SeasonPass |
| `RankReward` (`SerializableRankReward`) | 순위 보상 | BubbleGum, Cup |
| `EpisodeFinishedCoinReward` | 에피소드 완료 Coins 보상 | EpisodeChase, EpisodeRace |

---

## 7. 입장료(EntryCost) 및 부스터 가격 구조

### 7.1 입장료 시스템 구조

```
레벨 선택
  │
  ▼
EntryCostController
  │
  ├─ 기본 입장료: Coins 소모 (레벨별 상이)
  │    └─ UpdateEntryCost 이벤트로 서버에서 동적 갱신
  │
  └─ 입장료 없음: FreeEntry 티켓 사용 가능
```

| 클래스/파일 | 역할 |
|------------|------|
| `EntryCostController` | 입장료 팝업 컨트롤러 |
| `UpdateEntryCost` | 서버에서 입장료 업데이트 이벤트 |
| `BetupLevelWinController` | Betup(배팅) 레벨 승리 처리 |
| `BetupSettings` | Betup 시스템 설정 |
| `OnFireSettings` | OnFire(연승) 시스템 설정 |

### 7.2 Betup (배팅 상승) 시스템

Betup은 레벨 진입 시 더 많은 Coins를 걸어 **고위험-고보상**을 선택하는 시스템입니다.

```
일반 레벨 진입
  │
  ▼ (연승 / OnFire 조건 달성 시)
Betup 활성화 팝업
  │
  ├─ [기본 입장료로 진행] → 일반 보상
  └─ [높은 입장료 선택]  → 배율 적용 보상
         │
         ▼ BetupActivatedEvent
    레벨 클리어 시 BetupCompletedEvent
         │
         ▼
    높아진 Coin 보상 지급
```

| 이벤트 | 발생 시점 |
|--------|----------|
| `BetupActivatedEvent` | 배팅 상승 팝업 수락 시 |
| `BetupCompletedEvent` | 해당 레벨 클리어 시 |
| `BetupDestroyedEvent` | 배팅 포기 또는 실패 시 |

### 7.3 OnFire (연승 불꽃) 시스템

```
연속 레벨 클리어 (WinStreak)
  │
  ▼
OnFire 상태 활성화
  │
  ├─ StreakMultiplier 코인 보상 배율 증가
  │    └─ StreakMultiplierChangedEvent
  │    └─ TableauStreakMultiplierIncrement
  │
  └─ Betup 활성화 조건 충족
```

### 7.4 부스터 가격 구조

```
BoosterCostSetting (설정 파일)
  │
  ▼
BoosterCostCalculator (계산기)
  │
  ▼
BoosterCostView (UI 표시)
  │
  └─ LoadBoosterCostProducts → IAP 제품 로딩
```

| 부스터 IAP ID | 유형 |
|--------------|------|
| `BonsaiBoosterShovel` | 삽 (카드 1장 제거) |
| `BonsaiBoosterShuffle` | 셔플 (덱 재배열) |
| `BonsaiBoosterSwap` | 스왑 (카드 교환) |
| `BonsaiBoosterColorChange` | 색상 변경 |
| `BonsaiBoosterColourDestroy` | 색상 파괴 |

> 부스터 가격은 `BoosterCostSetting`에 정의되어 있으나 **실제 Coins 수치는 서버 설정값**으로 바이너리에서 미추출.

---

## 8. 레벨 보상 곡선 (Coin Reward Curve)

### 8.1 CoinReward TLB (Look-Up Table) 구조

게임은 레벨별 코인 보상을 **3단계 테이블 조회** 방식으로 관리합니다.

```
레벨 완료
  │
  ▼ CoinRewardsModule
CandySolitaireCoinRewardTLB  (전체 그룹)
  ├─ CoinRewardTLB1  (초반 레벨 그룹 — 낮은 보상)
  ├─ CoinRewardTLB2  (중반 레벨 그룹 — 중간 보상)
  └─ CoinRewardTLB3  (후반 레벨 그룹 — 높은 보상)
       │
       ▼ StreakMultiplier 적용
기본 Coin 보상 × StreakMultiplierValue
       │
       ▼ (에피소드 완료 시)
EpisodeFinishedCoinReward 추가
       │
       ▼ (보너스 레벨 시)
BonusLevelCoins 추가
```

### 8.2 Coin 보상 계산 관련 필드

| 필드명 | 역할 |
|--------|------|
| `levelWonCoinsRewardFactorHigh` | 승리 시 높은 배율 인자 |
| `levelWonCoinsRewardFactorLow` | 승리 시 낮은 배율 인자 |
| `LevelWonRewardPerRegularStockPileCardFactor` | 남은 일반 카드 수당 보상 인자 |
| `LevelWonRewardPerWildCardInStockPileFactor` | 와일드카드 수당 보상 인자 |
| `LevelWonRewardPerBoosterCardInStockPileFactor` | 부스터카드 수당 보상 인자 |
| `StreakMultiplierValue` | 연승 배율값 |
| `EpisodeFinishedCoinReward` | 에피소드 완료 추가 보상 |
| `BonusLevelCoins` | 보너스 레벨 코인 보상 |

### 8.3 추가 TLB 그룹 (이벤트/부스터 관련)

| TLB 그룹 | 추정 역할 |
|----------|----------|
| `ColorBombTLBGroup` | 컬러밤 보상 테이블 |
| `FreeEntryTLBGroup` | 무료 입장권 지급 테이블 |
| `Plus2TLBGroup` | +2 무브 관련 테이블 |
| `UfoTLBGroup` | UFO 카드 관련 테이블 |

### 8.4 레벨 보상 곡선 구조 (추정)

```
Coin 보상
    ▲
    │                               ·····
    │                          ·····
    │                    ·····
    │               ████
    │          ████
    │     ████
    ├─────────────────────────────────────→ 레벨
    1    50   100   200   300   400   500+

    ████ = TLB1 (초반) → 낮은 기준 보상
    ···· = TLB2/3 적용 → 점진적 증가

    [OnFire 연승 시]
    기본 보상 × StreakMultiplierValue (1.5x ~ 3x 추정)
```

> **⚠️ 실제 수치**: 서버 설정으로 관리되며 바이너리 분석으로는 추출 불가.
> 실제 값 확인을 위해서는 **실기기 플레이 + 네트워크 캡처** 또는 **서버 응답 분석** 필요.

---

## 9. IAP 제품 전체 목록 (Bonsai 접두사)

### 9.1 소프트 재화 (Coins)
| IAP ID | 구분 |
|--------|------|
| `BonsaiSoftCurrency` | 범용 |
| `BonsaiSoftCurrencyPackageXS` | XS 팩 |
| `BonsaiSoftCurrencyPackageS` | S 팩 |
| `BonsaiSoftCurrencyPackageM` | M 팩 |
| `BonsaiSoftCurrencyPackageL` | L 팩 |
| `BonsaiSoftCurrencyPackageXL` | XL 팩 |

### 9.2 하드 재화 (HardCurrency)
| IAP ID | 구분 |
|--------|------|
| `BonsaiHardCurrency` | 범용 |
| `BonsaiHardCurrencyPackageXS` | XS 팩 |
| `BonsaiHardCurrencyPackageS` | S 팩 |
| `BonsaiHardCurrencyPackageM` | M 팩 |
| `BonsaiHardCurrencyPackageL` | L 팩 |
| `BonsaiHardCurrencyPackageXL` | XL 팩 |
| `BonsaiMercadoHardCurrency` | Mercado 플랫폼용 |

### 9.3 Energy (⚡번개)
| IAP ID | 구분 |
|--------|------|
| `BonsaiOneEnergy` | Energy 1개 |
| `BonsaiRefillEnergy` | 전체 충전 |
| `BonsaiUnlimitedEnergyUsingMinutes` | 무제한 (분 단위) |
| `BonsaiUnlimitedEnergyUsingHours` | 무제한 (시간 단위) |
| `BonsaiMercadoUnlimitedEnergy` | Mercado 플랫폼용 |

### 9.4 부스터
| IAP ID | 구분 |
|--------|------|
| `BonsaiBoosterShovel` | 삽 부스터 |
| `BonsaiBoosterShuffle` | 셔플 부스터 |
| `BonsaiBoosterSwap` | 스왑 부스터 |
| `BonsaiBoosterColorChange` | 색상 변경 부스터 |
| `BonsaiBoosterColourDestroy` | 색상 파괴 부스터 |
| `BonsaiPreLevelBooster` | 레벨 전 부스터 (범용) |

### 9.5 건물/레시피 잠금 해제
| IAP ID | 구분 |
|--------|------|
| `BonsaiFarmHouseUnlock` ~ `BonsaiWindmillUnlock` | 건물 8종 잠금 해제 |
| `BonsaiBuildingUnlock` | 범용 건물 잠금 해제 |
| `BonsaiUnlockRecipeGroup1` ~ `BonsaiUnlockRecipeGroup15` | 레시피 그룹 15개 |
| `BonsaiRecipeUnlock` | 범용 레시피 잠금 해제 |

### 9.6 기타
| IAP ID | 구분 |
|--------|------|
| `BonsaiUpgradeToken` | 업그레이드 토큰 |
| `BonsaiFame` | 명성 |
| `BonsaiSeed` | 씨앗 |
| `BonsaiMercadoDummy` | Mercado 더미 제품 |
| `BonsaiBuildingUnlock` | 건물 일반 잠금 해제 |

---

## 10. 가격 티어 (확인된 USD 상수)

바이너리에서 확인된 하드코딩 USD 가격 티어:

`$0.99` / `$1.99` / `$2.99` / `$3.99` / `$4.99` / `$5.99` / `$7.99` / `$9.99` / `$14.99` / `$19.99` / `$24.99` / `$34.99` / `$49.99` / `$74.99` / `$99.99`

**(15단계)**

---

## 11. 애널리틱스 & 광고 플랫폼

### 11.1 광고 네트워크
| 플랫폼 | 유형 |
|--------|------|
| Google GMA | 디스플레이/보상형 광고 |
| IronSource | 미디에이션 |
| Vungle/Liftoff | 보상형 동영상 |
| Unity Ads | 보상형 동영상 |
| Moloco | 프로그래매틱 |
| Meta FAN | 소셜 광고 |

### 11.2 주요 추적 API (이벤트별)
| API 엔드포인트 | 추적 내용 |
|--------------|----------|
| `postDiceRollCompleted` | 주사위 굴리기 완료 |
| `postDiggingCompleted` | 발굴 완료 |
| `postEpisodeChaseCompleted` | 에피소드 체이스 완료 |
| `postEpisodeRaceCompleted` | 에피소드 레이스 완료 |
| `postGlobeTrottingCompleted` | 세계 여행 완료 |
| `postPostcardCompleted` | 엽서 완료 |
| `postQuestCompleted` | 퀘스트 완료 |
| `postStickerCollectionCompleted` | 스티커 컬렉션 완료 |
| `postStickerCollectionSetCompleted` | 스티커 세트 완료 |
| `postCardBackUnlocked` | 카드 백 잠금 해제 |
| `postPlayerPurchasesSeasonPass` | 시즌 패스 구매 |
| `postTeamEventMilestoneNews` | 팀 이벤트 마일스톤 |

---

## 12. 미결 사항 (추가 조사 필요)

| 항목 | 이유 | 필요 방법 |
|------|------|----------|
| Energy 실제 수치 (task별) | 서버 설정값 | 실기기 + 네트워크 캡처 |
| Coins 레벨별 입장료 | 서버 동적 설정 | 네트워크 패킷 분석 |
| 부스터 Coins 가격 | 서버 동적 설정 | 네트워크 패킷 분석 |
| StreakMultiplier 실제 배율 | 서버 설정값 | 실기기 연승 테스트 |
| CoinRewardTLB 실제 테이블 | 서버 설정값 | 네트워크 패킷 분석 |
| Betup 배팅 비율/보상 비율 | 서버 설정값 | 실기기 Betup 테스트 |
| 이벤트 수집량 기준치 | 서버 설정값 | 실기기 이벤트 참여 |
| HardCurrency 건물별 가격 | 서버 설정값 | 실기기 상점 화면 캡처 |

---

## 13. 분석 체크리스트

| 항목 | 상태 | 비고 |
|------|------|------|
| 재화 유형 확정 | ✔ 완료 | 5종 |
| Energy 역할 규명 | ✔ 완료 | 꾸미기 재화 (v3.0 수정) |
| 코드 출처 분리 | ✔ 완료 | FARM_KING / Muffin / Bonsai 분리 |
| 라이브 이벤트 목록 | ✔ 완료 | 20종 이상 |
| 라이브 이벤트 메커니즘 | ✔ 완료 | 각 이벤트 수집/보상 구조 |
| 입장료 시스템 구조 | ✔ 완료 | Betup + EntryCost |
| 보상 곡선 구조 | ✔ 완료 | TLB + StreakMultiplier |
| IAP 전체 목록 | ✔ 완료 | 38개 이상 |
| 실제 수치 (서버값) | ⚠ 미완 | 실기기 분석 필요 |
| 부스터 가격 수치 | ⚠ 미완 | 실기기 분석 필요 |

---

*v3.0 - 2026-02-26 | Energy 역할 수정, 코드 출처 분리, 라이브 이벤트 상세 추가, 입장료/보상 곡선 구조 추가*
