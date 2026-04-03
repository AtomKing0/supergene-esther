# 솔리테어 트라이픽스 — 사운드 구현 가이드

> 개발자가 AI에게 전달하는 사운드 구현 전체 명세서.
> 이 문서 하나로 사운드 시스템을 처음부터 완성할 수 있도록 작성.

---

## 1. GameSound 시스템

### 1-1. 핵심 동작 원리

`GameSound.ts`는 `cc.audioEngine`을 직접 호출하지 않고 **update 루프에서 1프레임 지연 재생**한다.
이유: Cocos 2.4에서 동일 프레임에 여러 사운드를 동시 play 호출하면 누락되는 버그 존재.

```typescript
// play() 호출 → 큐에 적재 → 다음 update()에서 실제 audioEngine.playEffect() 호출
GameSound.play('FX_UI_BTN_TAP', this.node);
```

### 1-2. 주요 API

```typescript
// 일반 효과음 (1회 재생)
GameSound.play(clipName: string, node: cc.Node): void

// 루프 음악 (BGM / 앰비언트)
cc.audioEngine.playMusic(audioClip: cc.AudioClip, loop: boolean): number

// 루프 정지
cc.audioEngine.stopMusic(): void

// 볼륨 (0.0 ~ 1.0)
cc.audioEngine.setEffectsVolume(volume: number): void
cc.audioEngine.setMusicVolume(volume: number): void
```

### 1-3. clipName 규칙

`GameSound.play()` 의 첫 번째 인자는 **파일명에서 `.wav` 확장자를 뺀 문자열**.

```typescript
// assets/audio_selected/FX_CARD_TAPPED_01.wav → clipName: 'FX_CARD_TAPPED_01'
GameSound.play('FX_CARD_TAPPED_01', this.node);
```

---

## 2. 전체 사운드 파일 목록

> 파일 위치: `assets/audio_selected/` — 총 74개, 모두 -2 semitone 피치 다운 전처리 완료.

### 2-1. 카드 (CARD)

| 파일명 | 길이 | 비고 |
|--------|------|------|
| `FX_CARD_TAPPED_01.wav` | 0.369s | 랜덤 3종 |
| `FX_CARD_TAPPED_02.wav` | 0.321s | |
| `FX_CARD_TAPPED_03.wav` | 0.331s | |
| `FX_CARD_PLAYED_01.wav` | 0.557s | 랜덤 3종 |
| `FX_CARD_PLAYED_02.wav` | 0.524s | |
| `FX_CARD_PLAYED_03.wav` | 0.666s | |
| `FX_CARD_MISSED.wav` | 0.684s | 매칭 실패 |
| `FX_CARD_DRAWN_01.wav` | 0.397s | 랜덤 3종 |
| `FX_CARD_DRAWN_02.wav` | 0.403s | |
| `FX_CARD_DRAWN_03.wav` | 0.349s | |
| `FX_CARD_REVEALED.wav` | 0.527s | 카드 뒤집기 |
| `FX_CARD_DEAL_LOOP.wav` | 2.189s | 스테이지 시작 카드 배치 루프 |
| `FX_CARD_DEAL_END.wav` | 0.377s | 카드 배치 완료 |
| `FX_CARD_FLY_OUT.wav` | 1.575s | 게임오버 카드 날아가기 |
| `FX_CARD_LAST_PLAYED.wav` | 1.669s | 마지막 카드 매치 (클라이맥스 임팩트) |
| `FX_CARD_WILD_TRIGGERED.wav` | 4.455s | WildCard 전체 라이프사이클 |
| `FX_CARD_PLUS_CARDS.wav` | 1.259s | PlusCard 기믹 + 엑스트라덱 부스터 겸용 |

### 2-2. 스트릭 (STREAK)

| 파일명 | 길이 | 비고 |
|--------|------|------|
| `FX_STREAK_SLOT_FILLED.wav` | 0.171s | |
| `FX_STREAK_SLOT_REMOVED.wav` | 0.045s | |
| `FX_STREAK_BAR_EXTENDS.wav` | 0.209s | |
| `FX_STREAK_BAR_DETRACTS.wav` | 0.101s | |
| `FX_STREAK_COMPLETED.wav` | 3.145s | |
| `FX_STREAK_MULTIPLIER_IN.wav` | 0.824s | |
| `FX_STREAK_MULTIPLIER_OUT.wav` | 0.282s | |

### 2-3. 부스터 (BOOSTER)

| 파일명 | 길이 | 비고 |
|--------|------|------|
| `FX_BOOSTER_FIREWORKS_APPEAR_01.wav` | 1.095s | 랜덤 3종 |
| `FX_BOOSTER_FIREWORKS_APPEAR_02.wav` | 0.979s | |
| `FX_BOOSTER_FIREWORKS_APPEAR_03.wav` | 1.017s | |
| `FX_BOOSTER_FIREWORKS_EXPLODE_01.wav` | 1.141s | 랜덤 3종 |
| `FX_BOOSTER_FIREWORKS_EXPLODE_02.wav` | 1.171s | |
| `FX_BOOSTER_FIREWORKS_EXPLODE_03.wav` | 1.078s | |
| `FX_BOOSTER_GOLDEN_TICKET_ACTIVATED.wav` | 1.662s | |
| `FX_BOOSTER_GOLDEN_TICKET_TAP_01.wav` | 0.894s | 랜덤 3종 |
| `FX_BOOSTER_GOLDEN_TICKET_TAP_02.wav` | 0.737s | |
| `FX_BOOSTER_GOLDEN_TICKET_TAP_03.wav` | 0.914s | |

### 2-4. 기믹 카드 (GIMMICK)

| 파일명 | 길이 | 비고 |
|--------|------|------|
| `FX_GIMMICK_RUNNER_MOVE.wav` | 0.177s | RunnerCard 숫자 변경마다 |
| `FX_GIMMICK_KEY_ACTIVATE.wav` | 3.264s | KeyCard 활성화. 최초 1회만 재생 |
| `FX_GIMMICK_GATE_OPEN.wav` | 0.270s | LockCard 게이트 열림 |
| `FX_GIMMICK_GATE_CLOSE.wav` | 0.340s | 게이트 닫힘 |
| `FX_GIMMICK_GATE_REMOVE.wav` | 0.607s | 게이트 소멸 |
| `FX_GIMMICK_ROPE_REMOVED.wav` | 1.103s | RopeCard 해제 |

### 2-5. 보상 (REWARD)

| 파일명 | 길이 | 비고 |
|--------|------|------|
| `FX_REWARD_CLEAR.wav` | 3.671s | 스테이지 클리어 원샷 |
| `FX_REWARD_CONFETTI_LOOP.wav` | 12.043s | 클리어 화면 루프 |
| `FX_REWARD_BOX_FLIES_IN.wav` | 0.667s | |
| `FX_REWARD_BOX_OPEN.wav` | 2.731s | |
| `FX_REWARD_ITEM_FLIES.wav` | 0.752s | |
| `FX_REWARD_STAR_BURST.wav` | 0.439s | |
| `FX_REWARD_DAILY_CLAIMED.wav` | 1.813s | |
| `FX_REWARD_WHEEL_TICK_01.wav` | 0.035s | 랜덤 3종 |
| `FX_REWARD_WHEEL_TICK_02.wav` | 0.035s | |
| `FX_REWARD_WHEEL_TICK_03.wav` | 0.041s | |
| `FX_REWARD_GAUGE_FILL.wav` | 0.724s | 경험치/보상 게이지 한 칸마다 |

### 2-6. 코인 (COIN)

| 파일명 | 길이 | 비고 |
|--------|------|------|
| `FX_COIN_SPENT.wav` | 1.202s | 코인 차감 |
| `FX_COIN_FLY_01.wav` | 0.331s | 랜덤 3종. 날아오기 시작 시 |
| `FX_COIN_FLY_02.wav` | 0.335s | |
| `FX_COIN_FLY_03.wav` | 0.320s | |
| `FX_COIN_HIT_01.wav` | 0.399s | 랜덤 3종. tween 완료(목적지 도착) 시 |
| `FX_COIN_HIT_02.wav` | 0.400s | |
| `FX_COIN_HIT_03.wav` | 0.399s | |
| `FX_COIN_BURST.wav` | 1.325s | 코인 버스트 애니메이션 완료 시 |

### 2-7. UI

| 파일명 | 길이 | 비고 |
|--------|------|------|
| `FX_UI_BTN_TAP.wav` | 0.073s | 기본 버튼 탭 |
| `FX_UI_BTN_RELEASE.wav` | 0.049s | 기본 버튼 릴리즈 |
| `FX_UI_BTN_WOOD_TAP.wav` | 0.031s | 인게임 테마 버튼 |
| `FX_UI_BTN_WOOD_RELEASE.wav` | 0.031s | |
| `FX_UI_POPUP_IN.wav` | 0.117s | |
| `FX_UI_POPUP_OUT.wav` | 0.117s | |
| `FX_UI_NOTIFICATION.wav` | 1.112s | |
| `FX_UI_TOOLTIP_IN.wav` | 0.300s | |
| `FX_UI_LOGO.wav` | 3.145s | 앱 로딩. 1회만 |
| `FX_UI_ITEM_TAP.wav` | 0.031s | |
| `FX_UI_LOCKED_TAP.wav` | 0.236s | 잠긴 콘텐츠 탭 |

### 2-8. 환경 / 이벤트

| 파일명 | 길이 | 비고 |
|--------|------|------|
| `FX_ENVIRONMENT_AMBIENT.wav` | 9.710s | 인게임 루프 앰비언트 |
| `FX_EVENT_LEADERBOARD_IN.wav` | 0.592s | |
| `FX_EVENT_LEADERBOARD_CHANGE.wav` | 1.176s | |
| `FX_EVENT_GOLDEN_SHIMMER.wav` | 3.675s | 골든티켓 황금 이펙트 |

---

## 3. 트리거 분류

| 타입 | 설명 | 재생 API |
|------|------|---------|
| **A. 즉시 재생** | 클릭/콜백 진입 즉시 호출 | `GameSound.play()` |
| **B. 애니메이션 동기화** | tween `.call()` 또는 `animation.once('finished')` 내부에서 호출 | `GameSound.play()` |
| **C. 루프/앰비언트** | 씬 진입 시 시작, 씬 종료 시 정지 | `cc.audioEngine.playMusic()` |

---

## 4. 이벤트별 구현 명세

### A. 즉시 재생 이벤트

| 파일명 | 트리거 위치 | 메모 |
|--------|------------|------|
| `FX_CARD_TAPPED_01~03` | `onClickCard()` 진입 직후 | 매칭 성공 여부 판정 **이전**. 랜덤 1~3 |
| `FX_CARD_MISSED` | `clickCard()` 반환값 null 시 | 매칭 실패 직후 |
| `FX_STREAK_SLOT_FILLED` | 스트릭 슬롯이 채워지는 순간 | |
| `FX_STREAK_SLOT_REMOVED` | 스트릭 슬롯 제거 순간 | |
| `FX_STREAK_BAR_EXTENDS` | 스트릭 바 증가 시점 | |
| `FX_STREAK_BAR_DETRACTS` | 스트릭 바 감소 시점 | |
| `FX_COIN_SPENT` | 코인 차감 콜백 직후 | |
| `FX_COIN_FLY_01~03` | 코인 리필 tween 시작 직전 | 랜덤 1~3. tween 완료 시 HIT 재생 (→ B 섹션) |
| `FX_UI_BTN_TAP` | 모든 버튼 `onTouchStart` | `ClickSound` 컴포넌트로 자동 처리 권장 |
| `FX_UI_BTN_RELEASE` | 버튼 `onTouchEnd` | |
| `FX_UI_BTN_WOOD_TAP` | 인게임 테마 버튼 탭 | 인게임 전용. 로비는 BTN_TAP 사용 |
| `FX_UI_BTN_WOOD_RELEASE` | 인게임 테마 버튼 릴리즈 | |
| `FX_UI_ITEM_TAP` | 아이템 탭 | |
| `FX_UI_LOCKED_TAP` | 잠긴 콘텐츠 탭 | |
| `FX_UI_POPUP_IN` | 팝업 `onShowStart()` | |
| `FX_UI_POPUP_OUT` | 팝업 `onHideStart()` | |
| `FX_UI_NOTIFICATION` | 알림 표시 시점 | |
| `FX_UI_TOOLTIP_IN` | 툴팁 등장 | |

---

### B. 애니메이션 동기화 이벤트

> **반드시** tween `.call()` 또는 `animation.once('finished')` 내부에서 호출한다.
> 애니메이션 시작 직전에 호출하는 경우는 해당 항목에 명시.

#### B-1. 카드 기본

| 파일명 | 트리거 위치 | 세부 구현 |
|--------|------------|---------|
| `FX_CARD_PLAYED_01~03` | `CardView.playCardSelectArcTween()` tween 완료 `.call()` | 랜덤 1~3. 단, 마지막 카드이면 `FX_CARD_LAST_PLAYED` 사용 |
| `FX_CARD_LAST_PLAYED` | 위와 동일 위치 | `stageModel.remainingCards === 0` 일 때만. 1.669s 임팩트 음 |
| `FX_CARD_REVEALED` | `CardView.flipDrawCard()` — flip 애니메이션 `finished` | `animation.once('finished', ...)` |
| `FX_CARD_DRAWN_01~03` | 드로우 덱 탭 → 카드 이동 tween **시작 직전** | 랜덤 1~3 |
| `FX_CARD_DEAL_LOOP` | 스테이지 시작 카드 배치 애니메이션 시작과 함께 | 배치 루프 중 1회만 |
| `FX_CARD_DEAL_END` | 카드 배치 완료 콜백 | 배치 루프 종료 시점 |
| `FX_CARD_FLY_OUT` | 게임오버 카드 날아가기 애니메이션 **시작 시** | |

#### B-2. 스트릭

| 파일명 | 트리거 위치 | 세부 구현 |
|--------|------------|---------|
| `FX_STREAK_COMPLETED` | 스트릭 완성 연출 애니메이션 시작 시 | 3.145s — 연출과 함께 재생 |
| `FX_STREAK_MULTIPLIER_IN` | 멀티플라이어 등장 애니메이션 시작 시 | |
| `FX_STREAK_MULTIPLIER_OUT` | 멀티플라이어 사라짐 애니메이션 시작 시 | |

#### B-3. WildCard

| 파일명 | 트리거 위치 | 세부 구현 |
|--------|------------|---------|
| `FX_CARD_WILD_TRIGGERED` | `StageView.createWildCard()` → `wild_card_in.anim` 시작 시 | **4.455s 단일 파일이 전체 라이프사이클 커버**: wild_card_in(0.367s) + wild_idle(3.333s) + wild_use(1.533s) ≈ 5.2s. 추가 트리거 없이 이 1개만 재생 |

#### B-4. PlusCard 기믹 / 엑스트라덱 부스터

| 파일명 | 트리거 위치 | 세부 구현 |
|--------|------------|---------|
| `FX_CARD_PLUS_CARDS` | ① `booster_extra_deck` 사용 → 카드가 필드에 착지하는 시점<br>② `PlusCardView.playPlusCardEffect()` → `plus_1/2/3.anim` 시작 시 | 두 이벤트에 동일 파일 사용 |

#### B-5. Fireworks (GrandFireworksCard / booster_fireworks)

| 파일명 | 트리거 위치 | 세부 구현 |
|--------|------------|---------|
| `FX_BOOSTER_FIREWORKS_APPEAR_01~03` | `GrandFireworksCardView.playShowFirework()` — `show_firework` 애니메이션(0.667s) 시작 시 | 랜덤 1~3 |
| `FX_BOOSTER_FIREWORKS_EXPLODE_01~03` | `GrandFireworksCardView.playWasteFirework()` — `scheduleOnce(0.2s)` 이펙트 스폰 시점 | 랜덤 1~3. **0.2s 딜레이 후 재생** |

#### B-6. GoldenTicketCard / booster_golden_ticket

| 파일명 | 트리거 위치 | 세부 구현 |
|--------|------------|---------|
| `FX_BOOSTER_GOLDEN_TICKET_ACTIVATED` | `GoldenTicketCardView.cardSelect()` → arc tween 시작 시 | 1.662s |
| `FX_BOOSTER_GOLDEN_TICKET_TAP_01~03` | 골든티켓 카드 탭 시점 | 랜덤 1~3 |

#### B-7. 기믹 카드 (RunnerCard / KeyLockCard / RopeCard)

| 파일명 | 트리거 위치 | 세부 구현 |
|--------|------------|---------|
| `FX_GIMMICK_RUNNER_MOVE` | `RunnerCardView.triggerTurnComplete()` — `runner_number_up/down.anim` 시작 시 | 매 숫자 변경마다 재생 |
| `FX_GIMMICK_KEY_ACTIVATE` | `KeyLockCardView.playActivateIdle()` — `key_activate_idle.anim` 시작 시 | **⚠ 루프 애니메이션 주의**: 최초 1회만 재생. `isPlayingActivateIdle` 플래그로 가드 필수 |
| `FX_GIMMICK_GATE_OPEN` | 게이트 열림 애니메이션 시작 시 | |
| `FX_GIMMICK_GATE_CLOSE` | 게이트 닫힘 애니메이션 시작 시 | |
| `FX_GIMMICK_GATE_REMOVE` | `key_card_delet.anim` (~0.9s) 시작 시 | KeyLockCard 소멸 연출 |
| `FX_GIMMICK_ROPE_REMOVED` | `RopeCardView.playRemovedByFirework()` — `ice_card.anim` 시작 시 | 이펙트 스폰과 동시 |

#### B-8. 보상 / 결과화면

| 파일명 | 트리거 위치 | 세부 구현 |
|--------|------------|---------|
| `FX_REWARD_CLEAR` | 결과화면 `onShowStart()` | **`FX_REWARD_CONFETTI_LOOP`와 동시 시작**. 원샷 |
| `FX_REWARD_GAUGE_FILL` | 결과화면 보상 게이지 한 칸 채워질 때마다 | |
| `FX_REWARD_BOX_FLIES_IN` | 선물상자 날아오기 tween 시작 시 | |
| `FX_REWARD_BOX_OPEN` | 상자 열기 애니메이션 시작 시 | 2.731s |
| `FX_REWARD_ITEM_FLIES` | 아이템 날아가기 tween 시작 시 | |
| `FX_REWARD_STAR_BURST` | 스타 버스트 애니메이션 `finished` | |
| `FX_COIN_BURST` | 코인 버스트 애니메이션 `finished` | |
| `FX_REWARD_DAILY_CLAIMED` | 데일리 보상 획득 연출 시작 시 | |
| `FX_REWARD_WHEEL_TICK_01~03` | 룰렛 핀이 칸을 넘을 때마다 | 랜덤 1~3. 35ms 극단파 |
| `FX_EVENT_LEADERBOARD_IN` | 리더보드 UI 등장 애니메이션 시작 시 | |
| `FX_EVENT_LEADERBOARD_CHANGE` | 순위 변동 애니메이션 시작 시 | |
| `FX_EVENT_GOLDEN_SHIMMER` | 골든 shimmer 이펙트 재생 시작 시 | 3.675s |
| `FX_COIN_HIT_01~03` | 코인 날아오기 tween 완료 — 목적지 도착 시 | tween `.call()` 내부. 랜덤 1~3 |

---

### C. 루프 / 앰비언트

> `cc.audioEngine.playMusic(clip, true)` 사용. 씬 전환 시 반드시 `stopMusic()` 호출.

| 파일명 | 트리거 위치 | 세부 구현 |
|--------|------------|---------|
| `FX_ENVIRONMENT_AMBIENT` | 인게임 씬 진입 시 | 루프. 씬 종료(게임오버/클리어) 시 stop |
| `FX_REWARD_CONFETTI_LOOP` | 스테이지 클리어 결과화면 진입 시 | 루프. `FX_REWARD_CLEAR`와 동시 시작 |
| `FX_UI_LOGO` | 앱 로딩 화면 | 1회 재생 (`loop: false`) |

---

## 5. 카드 타입 / 부스터 → 사운드 매핑 참조

### CardSpecialType enum

```typescript
enum CardSpecialType {
    None              = 0,
    PlusCard          = 1,  // FX_CARD_PLUS_CARDS
    KeyLockCard       = 2,  // FX_GIMMICK_KEY_ACTIVATE, FX_GIMMICK_GATE_*
    WildCard          = 5,  // FX_CARD_WILD_TRIGGERED
    RopeCard          = 6,  // FX_GIMMICK_ROPE_REMOVED
    GrandFireworksCard= 7,  // FX_BOOSTER_FIREWORKS_APPEAR/EXPLODE
    GoldenTicketCard  = 8,  // FX_BOOSTER_GOLDEN_TICKET_ACTIVATED/TAP
    RunnerCard        = 9,  // FX_GIMMICK_RUNNER_MOVE
}
```

### ItemNameKey (부스터)

| ItemNameKey | 사운드 |
|------------|--------|
| `booster_fireworks` | `FX_BOOSTER_FIREWORKS_APPEAR_01~03` (등장) + `FX_BOOSTER_FIREWORKS_EXPLODE_01~03` (폭발) |
| `booster_golden_ticket` | `FX_BOOSTER_GOLDEN_TICKET_ACTIVATED` (활성화) + `FX_BOOSTER_GOLDEN_TICKET_TAP_01~03` (탭) |
| `booster_wild_card` | `FX_CARD_WILD_TRIGGERED` |
| `booster_extra_deck` | `FX_CARD_PLUS_CARDS` (카드 착지 시점) |
| `booster_undo` | `FX_UI_BTN_TAP` (버튼) + `FX_CARD_DRAWN_01~03` 중 1개 (카드 이동) 조합 |

---

## 6. 랜덤 재생 그룹

동일 이벤트에 변형 파일이 여러 개 있는 경우 아래 패턴으로 랜덤 선택한다.

```typescript
// 카드 탭
const idx = Math.floor(Math.random() * 3) + 1;
GameSound.play(`FX_CARD_TAPPED_0${idx}`, this.node);

// 카드 매칭 성공
const idx = Math.floor(Math.random() * 3) + 1;
GameSound.play(`FX_CARD_PLAYED_0${idx}`, this.node);

// 드로우 카드
const idx = Math.floor(Math.random() * 3) + 1;
GameSound.play(`FX_CARD_DRAWN_0${idx}`, this.node);

// Fireworks 등장
const idx = Math.floor(Math.random() * 3) + 1;
GameSound.play(`FX_BOOSTER_FIREWORKS_APPEAR_0${idx}`, this.node);

// Fireworks 폭발
const idx = Math.floor(Math.random() * 3) + 1;
GameSound.play(`FX_BOOSTER_FIREWORKS_EXPLODE_0${idx}`, this.node);

// 골든티켓 탭
const idx = Math.floor(Math.random() * 3) + 1;
GameSound.play(`FX_BOOSTER_GOLDEN_TICKET_TAP_0${idx}`, this.node);

// 코인 날아오기
const idx = Math.floor(Math.random() * 3) + 1;
GameSound.play(`FX_COIN_FLY_0${idx}`, this.node);

// 코인 착지
const idx = Math.floor(Math.random() * 3) + 1;
GameSound.play(`FX_COIN_HIT_0${idx}`, this.node);

// 룰렛 핀
const idx = Math.floor(Math.random() * 3) + 1;
GameSound.play(`FX_REWARD_WHEEL_TICK_0${idx}`, this.node);
```

---

## 7. 주요 구현 패턴 코드

### 7-1. A — 즉시 재생 (버튼 탭)

```typescript
onTouchStart() {
    GameSound.play('FX_UI_BTN_TAP', this.node);
    // ... 나머지 로직
}
```

### 7-2. B — tween 완료 콜백 (카드 매칭)

```typescript
cc.tween(cardNode)
    .to(0.466, { position: targetPos, scale: 0 })
    .call(() => {
        const isLastCard = this.stageModel.remainingCards === 0;
        if (isLastCard) {
            GameSound.play('FX_CARD_LAST_PLAYED', this.node);
        } else {
            const idx = Math.floor(Math.random() * 3) + 1;
            GameSound.play(`FX_CARD_PLAYED_0${idx}`, this.node);
        }
    })
    .start();
```

### 7-3. B — animation finished 콜백

```typescript
// 카드 뒤집기 완료 후 사운드
this.animation.once('finished', () => {
    GameSound.play('FX_CARD_REVEALED', this.node);
});
this.animation.play('flip');
```

### 7-4. B — scheduleOnce 딜레이 (Fireworks 폭발)

```typescript
// 이펙트 스폰 0.2s 후 폭발음 재생
this.scheduleOnce(() => {
    const idx = Math.floor(Math.random() * 3) + 1;
    GameSound.play(`FX_BOOSTER_FIREWORKS_EXPLODE_0${idx}`, this.node);
}, 0.2);
```

### 7-5. B — 코인 fly → hit 세트 패턴

```typescript
// 코인이 날아가기 시작할 때 FLY 재생, 도착 시 HIT 재생
const flyIdx = Math.floor(Math.random() * 3) + 1;
GameSound.play(`FX_COIN_FLY_0${flyIdx}`, this.node);

cc.tween(coinNode)
    .to(duration, { position: targetPos })
    .call(() => {
        const hitIdx = Math.floor(Math.random() * 3) + 1;
        GameSound.play(`FX_COIN_HIT_0${hitIdx}`, this.node);
    })
    .start();
```

### 7-6. B — KeyCard 루프 가드

```typescript
// key_activate_idle은 루프 애니메이션 → 사운드 최초 1회만
private isPlayingActivateIdle: boolean = false;

playActivateIdle() {
    if (!this.isPlayingActivateIdle) {
        this.isPlayingActivateIdle = true;
        GameSound.play('FX_GIMMICK_KEY_ACTIVATE', this.node);
    }
    this.animation.play('key_activate_idle');
}
```

### 7-7. C — 루프 앰비언트 시작/정지

```typescript
onLoad() {
    cc.audioEngine.playMusic(this.ambientClip, true);
}

onGameEnd() {
    cc.audioEngine.stopMusic();
}
```

### 7-8. C — 스테이지 클리어 화면 (원샷 + 루프 동시)

```typescript
onShowStart() {
    GameSound.play('FX_REWARD_CLEAR', this.node);           // 원샷 3.671s
    cc.audioEngine.playMusic(this.confettiLoopClip, true);  // 루프
}

onHideStart() {
    cc.audioEngine.stopMusic();
}
```

### 7-9. B — WildCard (단일 파일로 전체 라이프사이클)

```typescript
// wild_card_in 시작 시 단 1회만 재생 — idle/use 동안 사운드가 자연스럽게 이어짐
createWildCard() {
    GameSound.play('FX_CARD_WILD_TRIGGERED', this.node); // 4.455s
    this.animation.play('wild_card_in');
    // wild_card_in(0.367s) → wild_idle(3.333s, loop) → wild_use(1.533s)
    // 추가 GameSound.play 호출 불필요
}
```

---

## 8. 주의사항 및 알려진 이슈

### 8-1. GameSound 1프레임 지연

`GameSound.play()` 는 호출 프레임에 바로 재생되지 않는다 (update 큐 방식).
극단적으로 짧은 음원(35ms 룰렛 핀 등)은 체감상 차이가 없으나, 매우 정밀한 타이밍이 필요하면 `cc.audioEngine.playEffect()` 직접 호출 검토.

### 8-2. KeyCard 루프 애니메이션 이중 재생 방지

`key_activate_idle` 은 조건 충족 전까지 매 턴 재생되는 루프 애니메이션.
사운드는 최초 1회만 재생해야 하므로 **반드시 플래그 가드** 사용 (→ 7-6 패턴 참조).

### 8-3. Fireworks 폭발 0.2s 딜레이 이유

`playWasteFirework()` 내부의 `scheduleOnce(callback, 0.2)` 로 이펙트가 스폰되므로,
사운드도 동일한 0.2s 딜레이 후 재생해야 이펙트와 싱크가 맞는다.

### 8-4. 스테이지 클리어 원샷 vs 루프 동시 재생

`FX_REWARD_CLEAR` (3.671s) 는 `GameSound.play()` 로,
`FX_REWARD_CONFETTI_LOOP` 는 `cc.audioEngine.playMusic()` 으로 동시에 시작.
두 채널(effectAudio / musicAudio)이 다르므로 서로 간섭 없음.

### 8-5. BGM 미포함

BGM은 이 파일 목록에 없다. 별도 삽입 예정.

### 8-6. Spin_Pin_02 재추출 이력

`FX_REWARD_WHEEL_TICK_02.wav` 는 ffprobe duration N/A 이슈가 있었으나 재추출 완료.
현재 `audio_selected/` 에 있는 파일은 정상 (35ms).
