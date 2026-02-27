# Candy Solitaire 재화 & 보상 시스템 분석 보고서

> **상태**: 완료 (v4.0 - 4차 수정판)
>
> **프로젝트**: Candy Solitaire 역공학 분석
> **대상 게임**: com.king.apps.candysolitaire (King/Activision Blizzard)
> **내부 코드명**: Bonsai (IAP) / Nirvana (네임스페이스)
> **작성자**: 분석팀
> **최종 수정**: 2026-02-27

---

## ⚠️ v4.0 수정 내역

| 항목 | 이전 분석 (오류/누락) | v4.0 수정 |
|------|----------------|-----------|
| IAP 구조 | HardCurrency → 2차 재화 (보석→골드 변환) 오류 기재 | **직접 코인 구매 방식. 1차/2차 재화 변환 없음** |
| HardCurrency 역할 | 프리미엄 화폐 (범용) | **건물·레시피 콘텐츠 잠금 해제 전용 (게임 내 변환 불가)** |
| 재화 종류 | 5종 (HardCurrency를 주요 재화로 기재) | **Coins, Energy, StreakStar, FreeEntry + 이벤트 토큰** |
| StreakStar | 미기재 | **스트릭 달성 시 획득하는 Stars — 토너먼트 점수로 활용** |
| Betup 배율 | "서버 설정값" 로만 기재 | **카탈로그 확정: x1 / x2 / x4 / x8 (4단계)** |
| OnFire 구조 | 개요만 기재 | **4단계(Tier 0~3) + 미터 채움 방식 확정** |
| PiggyBank | 미기재 | **3단계(piggybank_01/02/03) 저금통 시스템 신규 추가** |
| 부스터 종류 | 5종 (Shovel 등 오류) | **실제 부스터 전체 목록 확정** |
| 숍 가격대 | 바이너리 상수만 기재 | **카탈로그에서 실제 사용 가격대 확인** |

---

## 1. 분석 환경 및 대상

| 항목 | 내용 |
|------|------|
| 분석 파일 | `global-metadata.dat` (17MB Unity IL2CPP 메타데이터) + APK 디컴파일 Java |
| 엔진 | Unity IL2CPP (Android APK) |
| 코드 네임스페이스 | `King.Nirvana.*`, `Solitaire.*` |
| IAP 접두사 | `Bonsai*` |
| 분석 방법 | `strings` 패턴 분석 + Java 디컴파일 + Unity Addressable 카탈로그 분석 |
| 실제 수치 | 서버 설정값 → **바이너리 추출 불가** (설계 구조 + 카탈로그 확정값 혼합) |

---

## 2. 코드 출처 분리 ★중요

| 접두사 / 네임스페이스 | 실제 귀속 게임 | 내용 |
|----------------------|--------------|------|
| `King.Nirvana.*` / `Solitaire.*` | **Candy Solitaire** (본 게임) | 게임 로직, 경제, 이벤트 전체 |
| `Bonsai*` | **Candy Solitaire** (본 게임) | IAP 제품 ID 접두사 |
| `FARM_KING_*` | **Farm Heroes Saga** | King 공유 SDK 피처 플래그 (본 게임 무관) |
| `DiamondDigger*` | **Diamond Digger Saga** | 다이아몬드 오인 원인 (본 게임 무관) |
| `Muffin*` | **별도 King 음식트럭 게임** | 본 게임 무관 |

---

## 3. 재화 시스템 전체 구조 ★v4.0 전면 수정

### 3.1 IAP 구매 방식 — 직접 코인 구매 (1차/2차 변환 없음)

> **핵심 수정**: 이 게임은 "보석(Gem) 구매 → 골드 변환"의 2단계 구조가 **없다**.
> IAP로 **코인(골드)을 직접 구매**하는 단일 구조이다.
> `BonsaiHardCurrency`는 건물·레시피 **콘텐츠 잠금 해제 전용**으로,
> 일반 게임 화폐로서 유통되거나 코인으로 변환되지 않는다.

```
[IAP 결제]
    │
    ├─→ BonsaiSoftCurrency → Coins (골드) 직접 지급  ← 주요 IAP 경로
    │
    └─→ BonsaiHardCurrency → 건물/레시피 잠금 해제 전용 (코인 변환 X)
```

### 3.2 재화 종류 (확정)

| 재화 | 코드 | 역할 | 획득 | 소모 |
|------|------|------|------|------|
| **Coins (골드)** | `King.Nirvana.Simulation\|Coins` | 주요 게임 화폐 | 레벨 클리어, IAP 직구, 이벤트, 일일 보상, PiggyBank | 레벨 입장료, 부스터 구매, Betup 추가 배팅 |
| **Energy (⚡번개)** | `King.Nirvana.Simulation\|Energy` | 꾸미기 진행 재화 | 레벨 클리어 후 획득 | 꾸미기 Task 완료 |
| **StreakStar (별)** | `King.Nirvana.Simulation\|Stars` | 토너먼트·에피소드 점수 | **레벨 클리어 시 스트릭 달성량에 따라 획득** | 토너먼트(Cup)/에피소드 레이스 랭킹 |
| **FreeEntry (무료 입장권)** | `King.Nirvana.Simulation\|FreeEntry` | 코인 절약 티켓 | 이벤트, TLB 보상, 광고 시청 | 레벨 입장료 대체 (Coins 소모 없이 입장) |
| **이벤트 토큰 (다종)** | 이벤트별 코드 | 이벤트 전용 재화 | 레벨 클리어 시 이벤트 토큰 드롭 | 해당 이벤트 마일스톤 진행 |

### 3.3 이벤트 토큰 종류

| 토큰 | 이벤트 | 메모 |
|------|--------|------|
| BubbleGum | BubbleGum Team Event | 팀 합산 |
| DiceRoll 토큰 | DiceRoll Event | 주사위 굴리기 소모 |
| HiLoHustle 토큰 | HiLoHustle | 카드 예측 게임 |
| TowerOfFortune 티켓 | TowerOfFortune | 탑 오르기 |
| 여행 포인트 | GlobeTrotting | 목적지 마일스톤 |
| 우정 포인트 | FriendOMeter | 시즌 기반 |
| Season Pass 포인트 | SeasonPass | 무료/유료 트랙 |

---

## 4. StreakStar — 레벨 내 스트릭 연동 Stars 획득

### 4.1 StreakStar 획득 구조

```
[레벨 플레이 중]
      │
      ▼ 카드 연속 플레이 (스트릭 체인)
StreakMeter 상승
      │
      ├─ StreakOpportunityStart → 스트릭 기회 활성화 (UI 표시)
      ├─ StreakOpportunityLoop  → 스트릭 유지 중 루프 애니메이션
      └─ StreakMeter 충족 시
            │
            ▼ StreakReward 트리거
      [StreakStar(Stars) 획득]
            │
            ▼ StarBurstEffect 재생
      Stars 잔액에 가산
            │
            ▼
[토너먼트 / 에피소드 레이스 점수로 활용]
```

### 4.2 StreakStar 관련 UI 컴포넌트 (카탈로그 확정)

| 컴포넌트 | 역할 |
|----------|------|
| `pre_streakMeter.controller` | 스트릭 미터 애니메이션 컨트롤러 |
| `StreakIdle.anim` | 스트릭 기본 대기 상태 |
| `StreakOpportunityStart.anim` | 스트릭 기회 시작 |
| `StreakOpportunityLoop.anim` | 스트릭 유지 루프 |
| `StreakReward.anim` | 스트릭 보상 획득 연출 |
| `StreakRewardNameGeneric.anim` | 스트릭 보상 이름 표시 |
| `StarBurstEffect.prefab` | Stars 획득 파티클 VFX |
| `StreaksBurstEffect.prefab` | 스트릭 체인 달성 파티클 VFX |
| `ui_StreakMeterInfo.prefab` | 스트릭 미터 정보 팝업 |
| `StreakSettings.asset` | 스트릭 설정 (서버 설정) |

### 4.3 StreakStar 소비 구조

| 소비처 | 상세 |
|--------|------|
| Cup (컵 토너먼트) | 스테이지별 Stars 순위로 승급/탈락 결정 |
| EpisodeChase | 에피소드 완료 Stars 기반 상대방과 레이스 |
| EpisodeRace | 티어 기반 토너먼트 |
| StarTournament | 전용 Star 토너먼트 (`StarTournamentSettings.asset`, `StarTournamentBotDataSettings.asset`) |

---

## 5. Energy(⚡) — 꾸미기 진행 재화

### 5.1 Energy 흐름

```
[레벨 클리어]
      │
      ▼ rewardEnergy / energyEarned
[Energy 획득]
      │
      ▼ AnimateEnergySpend
[꾸미기 화면 (MetaScene)]
      │
   ┌──┴──────────────────────────────┐
   │  RegularTask  taskEnergyCost = N │
   │  FinalTask    finalTaskCost  = M │
   └─────────────────────────────────┘
      │
      ▼ TaskCompletedEvent
[꾸미기 요소 완성]
      │
      ▼ AreaCompletedEvent
[구역 완료 → 다음 Area 잠금 해제]
```

### 5.2 Area 구조

```
MetaScene
  └─ Area 1
       ├─ RegularTask × N  (각기 다른 energyCost)
       └─ FinalTask × 1    (finalTaskCost, 더 높은 비용)
            └─ AreaCompleted → Area 2 해제
  └─ Area 2 ...
```

### 5.3 Energy IAP (BonsaiEnergy)

| IAP ID | 내용 |
|--------|------|
| `BonsaiOneEnergy` | Energy 1개 |
| `BonsaiRefillEnergy` | 전체 충전 |
| `BonsaiUnlimitedEnergyUsingMinutes` | 시간 제한 무제한 (분) |
| `BonsaiUnlimitedEnergyUsingHours` | 시간 제한 무제한 (시간) |
| `BonsaiMercadoUnlimitedEnergy` | Mercado 플랫폼용 |

---

## 6. Coins 흐름 전체 맵

```
┌─────────────────────────────────────────────────────────────────┐
│                         COINS 수입                              │
├─────────────────────────────────────────────────────────────────┤
│  레벨 클리어        → 기본 Coin 보상 (CoinRewardTLB 조회)         │
│  스트릭 달성        → × StreakMultiplierValue 배율 적용            │
│  Betup 선택         → × x2 / x4 / x8 추가 배율 적용              │
│  OnFire 상태        → 해당 Betup 배율 적용 + 보상 패키지           │
│  에피소드 완료      → EpisodeFinishedCoinReward 추가               │
│  보너스 레벨 클리어 → BonusLevelCoins 추가                        │
│  IAP 직구           → BonsaiSoftCurrency 패키지 ($1.99 ~ $99.99)  │
│  PiggyBank 파괴     → 저금통 축적 Coins 전부 지급                  │
│  이벤트 보상        → CoinsCollectionTarget (마일스톤별)            │
│  일일 로그인        → DailyLoginBonus Coins                        │
│  광고 시청          → RewardedAd → Coins                          │
└─────────────────────────────────────────────────────────────────┘
                              ↓
┌─────────────────────────────────────────────────────────────────┐
│                         COINS 지출                              │
├─────────────────────────────────────────────────────────────────┤
│  레벨 입장료        → EntryCost (레벨별 서버 설정)                 │
│  Betup 추가 배팅    → 기본 입장료 × 배율 차이만큼 추가 소모         │
│  부스터 구매        → BoosterCostSetting (종류별 Coins 차감)        │
│  PiggyBank 투자     → 플레이 중 자동 누적 저장 (명시적 소모 X)      │
└─────────────────────────────────────────────────────────────────┘
```

---

## 7. 레벨 보상 계산 구조 (Coin Reward Formula)

### 7.1 CoinReward TLB (3단계 룩업 테이블)

게임은 레벨별 코인 보상을 **3구간 테이블 조회**로 관리한다.

```
레벨 완료
  │
  ▼ CoinRewardsModule
CandySolitaireCoinRewardTLB
  ├─ CoinRewardTLB1  (초반 레벨 구간 → 낮은 기준 보상)
  ├─ CoinRewardTLB2  (중반 레벨 구간 → 중간 보상)
  └─ CoinRewardTLB3  (후반 레벨 구간 → 높은 보상)
       │
       ▼
기본 Coin 보상 (BaseReward)
```

### 7.2 레벨 클리어 시 Coin 계산 패턴 (필드 기반 재구성)

```
최종_Coin_보상 =
    BaseReward (CoinRewardTLB 조회값)
  × StreakMultiplierValue               (스트릭 배율, 연승에 따라 상승)
  + (남은 일반카드 × LevelWonRewardPerRegularStockPileCardFactor)
  + (남은 와일드카드 × LevelWonRewardPerWildCardInStockPileFactor)
  + (남은 부스터카드 × LevelWonRewardPerBoosterCardInStockPileFactor)
  + EpisodeFinishedCoinReward           (에피소드 마지막 레벨일 때만)
  + BonusLevelCoins                     (보너스 레벨일 때만)
```

> **계산 특이점**: 레벨 종료 시 남은 덱(StockPile) 카드 수를 Coin으로 환산하는 구조.
> 즉 "빠른 클리어 = 더 많은 남은 카드 = 더 많은 Coins" 인센티브 설계.

### 7.3 Betup 배율 적용 시

```
Betup_최종_보상 =
    최종_Coin_보상 × BetupMultiplier

BetupMultiplier ∈ { x1, x2, x4, x8 }  ← 카탈로그 확정
```

### 7.4 보상 TLB 전체 그룹

| TLB 그룹 | 역할 |
|----------|------|
| `CoinRewardTLB1/2/3` | 레벨 구간별 기본 Coin 보상 테이블 |
| `ColorBombTLBGroup` | 컬러밤 보상 테이블 |
| `FreeEntryTLBGroup` | 무료 입장권 지급 테이블 (`tlb_freeentry.png` 확인) |
| `Plus2TLBGroup` | +2 카드 드로우 관련 테이블 |
| `UfoTLBGroup` | UFO 카드 관련 테이블 |

### 7.5 보상 곡선 추정 패턴

```
Coin 보상
    ▲
    │
    │  [OnFire x8]         ████████████
    │  [OnFire x4]    ████████
    │  [OnFire x2] ███████
    │  [기본 x1]  ██
    │             │
    │  ──────────────────────────────── 레벨
    │  L1        L50      L200    L500+
    │
    │   TLB1          TLB2          TLB3
    │  (초반)         (중반)         (후반)
    │   낮은 기준     중간 기준      높은 기준
    │
    │  [남은 카드 보너스 — 레벨 내 변수]
    │  클리어 속도에 따라 ±추가 보정
```

---

## 8. OnFire + Betup 시스템 (실제 구조 확정)

### 8.1 OnFire 4단계 구조 (카탈로그 확정)

```
연속 레벨 클리어 (WinStreak)
      │
      ▼ OnFire 미터 누적
┌─────────────────────────────────────────────────────┐
│ Tier 0  │  Tier 1  │  Tier 2  │  Tier 3 (Max)       │
│ onfire_ │ onfire_  │ onfire_  │ onfire_tier_3        │
│ tier_0  │ tier_1   │ tier_2   │ + vfxui_betup_x8     │
└─────────────────────────────────────────────────────┘
      │
      각 Tier: normal 상태 / open 상태 (미터 슬롯 완료 시 open)
```

- **미터 슬롯**: `ui_OnFireWidgetStageSlot.prefab` — 각 연승 레벨이 하나의 슬롯을 채움
- **OnFire 위젯**: `ui_OnFireWidget.prefab` + `OnFire_meter.png` (게임 HUD 상시 표시)
- **캔디 백**: `ui_OnFireCandyBag.prefab` — OnFire 보상 패키지 (Betup 외 추가 보상)
- **최대 OnFire (Tier 3)**: `vfxui_betup_x8_constant.prefab` — x8 Betup 상태 지속 VFX

### 8.2 Betup(배팅) 선택 구조

```
OnFire 달성 시 → Betup 제안 팝업 등장
      │
      ├─ [건너뛰기(x1)] → 기본 입장료, 기본 보상
      │
      ├─ [x2 선택] → 입장료 ×2, 보상 ×2
      │       └─ betup_background_2.png / betup_coins_2.png
      │
      ├─ [x4 선택] → 입장료 ×4, 보상 ×4
      │       └─ betup_background_4.png / betup_coins_4.png / betup_arrow_4.png
      │
      └─ [x8 선택] → 입장료 ×8, 보상 ×8  ← OnFire Tier 3에서 해제
              └─ betup_background_8.png / betup_coins_8.png / betup_arrow_8.png
                 + vfxui_betup_x8_constant.prefab

[클리어 시] BetupCompletedEvent → 배율 적용 보상 지급
[실패 시]   BetupDestroyedEvent → 배팅 소멸
```

> **Betup 경제적 의미**: 동일 난이도 레벨에서 최대 8배 코인 획득/소모 가능.
> 리스크-리워드 설계로 고숙련 플레이어의 코인 순환 속도를 대폭 상승시킴.

### 8.3 OnFire ~ Betup ~ StreakMultiplier 연동 패턴

```
일반 플레이:
  Coins = BaseReward × StreakMultiplier(1.0)

OnFire Tier 1 달성 + Betup x2 선택 후 클리어:
  Coins = BaseReward × StreakMultiplier(1.x) × 2

OnFire Tier 3 달성 + Betup x8 선택 후 클리어:
  Coins = BaseReward × StreakMultiplier(최대) × 8
       → 이론상 최고 배율 구간
```

---

## 9. PiggyBank 시스템 ★v4.0 신규

### 9.1 PiggyBank 구조 (카탈로그 확정)

```
[레벨 플레이 중 / 클리어 시]
      │ 자동 누적 (piggybank_token.png)
      ▼
PiggyBank (저금통)
  ├─ 단계 1 (piggybank_01.png + piggy_idle1.anim)  ← 채워지는 중
  ├─ 단계 2 (piggybank_02.png + piggy_transform_1to2.anim) ← 중간
  └─ 단계 3 (piggybank_03.png + piggy_transform_2to3.anim) ← 만석 (gold bg)
               │
               ▼ PiggyBankPopup 등장 (IAP 유도)
      [ui_PiggyBankPopup.prefab]
               │
               ├─ [무료 파괴 (광고?)] → piggy_destroy.anim → 저금 Coins 지급
               └─ [IAP 구매로 파괴]   → piggy_explode_2/3.anim → Coins 지급
```

- **배경 티어**: `piggybak_default_bg.png` / `piggybank_jade_bg.png` / `piggybank_gold_bg.png`
  → 단계별 시각적 등급 구분 (default → jade → gold)
- **업그레이드 팝업**: `ui_PiggyBankPopupUpgrade.prefab` — 더 큰 저금통 업그레이드 제안

### 9.2 PiggyBank 경제적 역할

- 플레이 중 자연스럽게 Coins를 별도 계정에 적립 (Player 잔액 외 별도 관리)
- 파괴 시 적립된 Coins를 한 번에 회수 → **IAP 구매 트리거 설계**
- 무료 파괴 vs IAP 파괴 2가지 옵션으로 수익화 레버 역할

---

## 10. 부스터 시스템 전체 목록 (v4.0 갱신)

### 10.1 실제 게임 내 부스터 종류 (카탈로그 확정)

| 부스터 | 에셋명 | 유형 |
|--------|--------|------|
| 컬러밤 | `tex_card_booster_colorbomb.png` | 카드형 특수 |
| UFO | `tex_card_booster_UFO.png` / `icon_booster_ufo_enabled.png` | 카드형 특수 |
| LollipopHammer | `icon_booster_lollipop_enabled.png` | 해머형 (카드 1장 제거) |
| Bomb | `icon_booster_bomb_enabled.png` | 폭발형 |
| Stripes | `icon_booster_stripes_enabled.png` | 줄무늬형 |
| StickyHand | `pre_stickyhand.prefab` | 카드 잡기형 |
| +1 카드 | `tex_card_booster_plus1.png` | 드로우 부스터 |
| +2 카드 | `tex_card_booster_plus2.png` / `booster_plus2_intro.playable` | 드로우 부스터 |
| +3 카드 | `tex_card_booster_plus3.png` | 드로우 부스터 |
| +5 카드 | `tex_card_booster_plus5.png` | 드로우 부스터 |
| Wildcard | `tex_card_booster_wildcard.png` | 만능 카드 |
| Undo | `generic_offer_booster_undo.png` | 실행 취소 |
| FreeTicket | `generic_offer_booster_freeticket.png` | FreeEntry 동의어 |
| EGP | `generic_offer_booster_egp.png` | Extra Good Play (추정) |
| CardPack | `generic_offer_booster_cardpack_01/02/03.png` | 카드 팩 (3등급) |
| 광고 시청형 | `tex_card_booster_plus1_ads.png` 외 | +1~+5, 광고 무료 버전 |

> **광고 시청 부스터**: +1, +2, +3, +5에 `_ads` 버전이 별도 존재.
> 유료 즉시 구매 vs 광고 시청 후 무료 획득 2트랙.

### 10.2 부스터 IAP ID (Bonsai)

| IAP ID | 부스터 |
|--------|--------|
| `BonsaiBoosterShovel` | 해머/Lollipop (삽 역할) |
| `BonsaiBoosterShuffle` | 셔플 |
| `BonsaiBoosterSwap` | 스왑 |
| `BonsaiBoosterColorChange` | 색상 변경 |
| `BonsaiBoosterColourDestroy` | 색상 파괴 |
| `BonsaiPreLevelBooster` | 레벨 전 부스터 (범용) |

---

## 11. 숍 & IAP 구조 (v4.0 갱신)

### 11.1 코인 직접 구매 팩 (확정 가격대)

카탈로그에서 확인된 실제 사용 가격대:

| 가격 | 이미지 에셋 | 분류 |
|------|------------|------|
| $1.99 | `shop_bundle_1.99.png` / `shop_bestValueBundle_1.99.png` | 소형 코인 팩 / 베스트밸류 |
| $2.99 | `shop_boosterPack_2.99.png` | 부스터 팩 |
| $3.99 | `shop_boosterPack_3.99.png` | 부스터 팩 (대형) |
| $5.99 | `shop_bundle_5.99.png` | 코인 팩 |
| $14.99 | `shop_bundle_14.99.png` | 코인 팩 (대형) |
| $19.99 | `shop_bundle_19.99.png` | 코인 팩 |
| $24.99 | `shop_bundle_24.99.png` | 코인 팩 |
| $34.99 | `shop_bundle_34.99.png` | 코인 팩 |
| $49.99 | `shop_bundle_49.99.png` | 코인 팩 (초대형) |
| $99.99 | `shop_bundle_99.99.png` | 코인 팩 (최대) |

> 코인 팩 직접 구매 9단계 + 부스터 팩 2단계 = **11개 가격 레이어**

### 11.2 특별 오퍼 시스템 전체 목록

| 오퍼 | 트리거 조건 | 내용 |
|------|-----------|------|
| **1Plus12Offer** | 조건 달성 시 팝업 | 1구매 + 4/6/9/12 무료 보너스 (4가지 변형) |
| **BazaarOffer** | 서버 설정 | 시장 스타일 복수 아이템 제안 |
| **BuyThemAllOffer** | 서버 설정 | 번들 전체 구매 |
| **HardLevelOffer** | 연속 실패 시 | 어려운 레벨 전용 부스터 오퍼 |
| **SMLOffer** | 서버 설정 | Small/Medium/Large 3단계 선택 |
| **GenericOffer1/2/3** | A/B 테스트 | 범용 오퍼 3종 |
| **ConversionPack** | 메인 화면 상시 | 고정 가격 코인+부스터 혼합 팩 (위젯 표시) |
| **CascadingOffer** | 순차 제안 | 소→중→대 오퍼 순서 제안 |

### 11.3 건물·레시피 잠금 해제 (HardCurrency 전용)

| IAP ID | 내용 |
|--------|------|
| `BonsaiFarmHouseUnlock` ~ `BonsaiWindmillUnlock` | 건물 8종 잠금 해제 |
| `BonsaiBuildingUnlock` | 범용 건물 |
| `BonsaiUnlockRecipeGroup1` ~ `BonsaiUnlockRecipeGroup15` | 레시피 그룹 15개 |
| `BonsaiRecipeUnlock` | 범용 레시피 |

> HardCurrency(`BonsaiHardCurrency`)는 이 콘텐츠 잠금 해제에만 쓰이며,
> Coins 획득·소모 루프와 완전히 분리된 별개 경로.

### 11.4 IAP → Coins 환산율 특이점

| 분류 | 구조 |
|------|------|
| 코인 팩 | 가격 상승 시 코인 단가 하락 (Volume discount) |
| 베스트밸류 | $1.99 에서 최고 단가 효율 표시 (마케팅 라벨) |
| 1Plus12 | 1+N 구조로 추가 보너스 강조 (N = 4/6/9/12) |
| ConversionPack | 코인+부스터 혼합 고정 팩 (메인 화면 상시 노출) |

---

## 12. 라이브 이벤트 시스템 요약

### 12.1 이벤트 재화 흐름 패턴 분류

| 패턴 | 이벤트 | 구조 |
|------|--------|------|
| **토큰 수집 → 마일스톤** | BubbleGum, DiceRoll, GlobeTrotting, TowerOfFortune | 레벨 클리어 시 토큰 드롭 → 임계값 달성 시 보상 |
| **Stars 소비 → 랭킹** | EpisodeChase, EpisodeRace, Cup, StarTournament | StreakStar 소비하여 순위 달성 → 랭킹 보상 |
| **팀 협력** | BubbleGum Team Event, TugOfCards | 개인+팀 합산 집계 |
| **컬렉션 완성** | StickerCollection, AlbumsCollection, CardBack | 조각 수집 → 세트 완성 → 보상 |
| **예측·도전** | HiLoHustle, DiggingEvent | 고위험-고보상 미니게임 |
| **기간 누적** | SeasonPass, DailyLoginCalendar, FriendOMeter | 기간 내 꾸준한 플레이로 티어 달성 |

### 12.2 이벤트 보상 타입

| 보상 | 설명 |
|------|------|
| `CoinsCollectionTarget` | Coins 직접 보상 |
| `BoosterCollectionTarget` | 부스터 보상 |
| `FreeEntryTLBGroup` | FreeEntry 보상 (TLB 조회) |
| `ChestReward` | 랜덤 상자 (Coins + 부스터 혼합) |
| `RankReward` | 순위별 보상 |
| `SeasonPassPointsCollectionTarget` | 시즌패스 포인트 |

---

## 13. CrownCards — 추가 수집 시스템

카탈로그에서 확인된 별도 수집 시스템:

```
[레벨 클리어]
      │
      ▼ CrownCard 드롭
CrownPack (팩)
  ├─ CrownPack2 / CrownPack3 / CrownPack4  (등급 구분)
  └─ 개봉 → 개별 CrownCard 획득
      │
      ▼ 앨범 수집 (ac_crowncard_album.controller)
[CrownCard 세트 완성] → AlbumsCollection 보상 (Coins + 특수 보상)
```

- `PreLevelPopup_CrownCardTeaser.anim` — 레벨 진입 전 CrownCard 예고 표시
- `ui_NotificationCrownCards.prefab` — 레벨 클리어 후 CrownCard 알림

---

## 14. 애널리틱스 & 광고

### 14.1 광고 재화 연동

| 광고 유형 | 보상 |
|----------|------|
| 보상형 광고 (Rewarded Video) | +카드 부스터 (ads 버전) / FreeEntry |
| 삽입형 광고 (Interstitial) | 보상 없음 (레벨 간 삽입) |

> 광고 네트워크: Google GMA, IronSource, Vungle/Liftoff, Unity Ads, Moloco, Meta FAN

### 14.2 주요 Analytics 이벤트

| API | 추적 내용 |
|-----|----------|
| `postDiceRollCompleted` | 주사위 굴리기 완료 |
| `postEpisodeChaseCompleted` | 에피소드 체이스 |
| `postEpisodeRaceCompleted` | 에피소드 레이스 |
| `postPlayerPurchasesSeasonPass` | 시즌 패스 구매 |
| `postTeamEventMilestoneNews` | 팀 이벤트 마일스톤 |

---

## 15. 미결 사항 (실기기 분석 필요)

| 항목 | 이유 | 필요 방법 |
|------|------|----------|
| CoinRewardTLB 실제 수치 | 서버 설정값 | 네트워크 패킷 분석 |
| 레벨별 입장료 수치 | 서버 동적 설정 | 패킷 캡처 |
| StreakMultiplier 실제 배율 범위 | 서버 설정값 | 연승 실측 테스트 |
| OnFire 각 Tier 달성 조건 (연승 N회) | 서버 설정 | `OnFireSettings.asset` (CDN 번들) |
| PiggyBank 누적 한도 및 파괴 조건 | `PiggyBankSettings.asset` | CDN 번들 다운로드 |
| 부스터 Coins 가격 | `BoosterCostSetting` 서버값 | 실기기 상점 캡처 |
| Energy Task별 실제 소모량 | 서버 설정 | 실기기 꾸미기 진행 측정 |
| 1Plus12 무료 보너스 트리거 조건 | 서버/AB테스트 | 실기기 A/B 비교 |

---

## 16. 분석 체크리스트

| 항목 | 상태 | 비고 |
|------|------|------|
| IAP 구조 (직접 구매 방식) | ✔ 완료 | 1차/2차 변환 없음 확정 |
| 재화 유형 확정 | ✔ 완료 | Coins, Energy, StreakStar, FreeEntry + 이벤트 토큰 |
| Betup 배율 확정 | ✔ 완료 | x1/x2/x4/x8 (카탈로그 확정) |
| OnFire 4단계 구조 | ✔ 완료 | Tier 0~3 + 미터 슬롯 방식 |
| Coin 보상 계산 패턴 | ✔ 완료 | 필드 기반 재구성 (실제 수치는 서버) |
| PiggyBank 시스템 | ✔ 완료 | 3단계 저금통 신규 확인 |
| 부스터 전체 목록 | ✔ 완료 | 카탈로그 기준 16종 확인 |
| 숍 가격대 | ✔ 완료 | $1.99 ~ $99.99 (11단계) |
| CrownCards 시스템 | ✔ 완료 | 별도 수집 시스템 확인 |
| 라이브 이벤트 (20종+) | ✔ 완료 | 메커니즘별 패턴 분류 |
| 실제 수치 (서버값 전반) | ⚠ 미완 | 실기기 + 네트워크 캡처 필요 |

---

*v4.0 - 2026-02-27 | IAP 구조 수정(직접 코인 구매), StreakStar 재화 추가, Betup x1/x2/x4/x8 확정, OnFire 4단계 확정, PiggyBank 신규, 부스터 전체 목록 갱신, 숍 가격대 실데이터 추가*
