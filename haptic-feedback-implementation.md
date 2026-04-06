# 햅틱 피드백 구현 가이드

> 작성일: 2026-04-01
> 대상 프로젝트: `solitaire-tripeaks-client`
> 참고 소스: `block-blast-client/assets/script/common/Fbi.ts`

---

## 개요

트라이픽스 솔리테어 신작에 기기 진동(햅틱 피드백)을 추가합니다.
경쟁사 3개(CC, Solitaire Grand Harvest, Tiki Solitaire)를 APK 분석한 결과 **모두 게임플레이 햅틱 미구현** 상태로, 우리가 최초 적용하는 차별점입니다.

### 환경 조건
- **플랫폼**: Facebook 인앱 브라우저 (WebView) — iOS/Android 모두 `navigator.vibrate()` 동작
- **엔진**: Cocos Creator 2.4.10
- **API**: `navigator.vibrate()` + Facebook `performHapticFeedbackAsync()`

---

## 1단계: VibrationManager 이식

`block-blast-client/assets/script/common/Fbi.ts`의 진동 관련 코드를
`solitaire-tripeaks-client/assets/script/Base/BasePlatform.ts` 하단에 추가합니다.

### 1-1. 패턴 정의 추가

`BasePlatform.ts` 하단(클래스 바깥)에 아래 패턴 상수를 추가합니다.

```typescript
// ─── 햅틱 피드백 패턴 정의 ───────────────────────────────────────────────
const HapticPatterns = {
    // 우선순위 5 (가장 낮음)
    BUTTON_TOUCH:         { duration: 20,          intensity: 'light',  pattern: 'tap',        priority: 5 },

    // 우선순위 4
    CARD_MATCH:           { duration: 30,          intensity: 'light',  pattern: 'tap',        priority: 4 },

    // 우선순위 3
    DRAW_CARD:            { duration: 20,          intensity: 'light',  pattern: 'tap',        priority: 5 },
    INVALID_TAP:          { duration: 60,          intensity: 'medium', pattern: 'tap',        priority: 3 },
    COMBO:                { duration: [30, 20, 30],intensity: 'medium', pattern: 'staccato',   priority: 3, interval: 80 },
    UNDO_SUCCESS:         { duration: 40,          intensity: 'medium', pattern: 'pulse',      priority: 3 },
    BOOSTER_USE:          { duration: 40,          intensity: 'medium', pattern: 'pulse',      priority: 3 },

    // 우선순위 2
    RANK_UP:              { duration: [35, 55],    intensity: 'medium', pattern: 'double',     priority: 2 },
    RANK_DOWN:            { duration: [35, 55],    intensity: 'medium', pattern: 'double',     priority: 2 },

    // 우선순위 1 (가장 높음)
    STAGE_CLEAR:          { duration: 60,          intensity: 'strong', pattern: 'burst_3stage',priority: 1, interval: 10 },
    REWARD_ACQUISITION:   { duration: 20,          intensity: 'strong', pattern: 'burst',      priority: 1 },
};
```

### 1-2. VibrationManager 클래스 추가

동일하게 `BasePlatform.ts` 하단(클래스 바깥)에 추가합니다.

```typescript
class VibrationManager {
    private isExecuting: boolean = false;
    private currentPriority: number = 0;
    private currentTimeoutId: any = null;

    ExecutePattern(pattern: any): void {
        const patternPriority = pattern.priority || 5;

        if (this.isExecuting && patternPriority < this.currentPriority) {
            this.StopCurrentVibration();
        }
        if (this.isExecuting && patternPriority >= this.currentPriority) {
            return;
        }

        this.isExecuting = true;
        this.currentPriority = patternPriority;

        switch (pattern.pattern) {
            case 'tap':        this.ExecuteTap(pattern);        break;
            case 'pulse':      this.ExecutePulse(pattern);      break;
            case 'double':     this.ExecuteDouble(pattern);     break;
            case 'staccato':   this.ExecuteStaccato(pattern);   break;
            case 'burst':      this.ExecuteBurst(pattern);      break;
            case 'burst_3stage': this.ExecuteBurst3Stage(pattern); break;
            default:           this.ExecuteTap(pattern);        break;
        }
    }

    private StopCurrentVibration(): void {
        if (this.currentTimeoutId) {
            clearTimeout(this.currentTimeoutId);
            this.currentTimeoutId = null;
        }
        if (navigator.vibrate) {
            navigator.vibrate(0);
        }
        this.isExecuting = false;
        this.currentPriority = 0;
    }

    public IsExecuting(): boolean { return this.isExecuting; }
    public GetCurrentPriority(): number { return this.currentPriority; }

    private done(ms: number): void {
        this.currentTimeoutId = setTimeout(() => {
            this.isExecuting = false;
            this.currentPriority = 0;
            this.currentTimeoutId = null;
        }, ms + 50);
    }

    private ExecuteTap(p: any): void {
        if (navigator.vibrate) navigator.vibrate([p.duration]);
        this.done(p.duration);
    }

    private ExecutePulse(p: any): void {
        const durations = Array.isArray(p.duration) ? p.duration : [p.duration];
        const intervals: number[] = [];
        durations.forEach((d, i) => {
            intervals.push(d);
            if (i < durations.length - 1) intervals.push(p.interval || 80);
        });
        if (navigator.vibrate) navigator.vibrate(intervals);
        this.done(intervals.reduce((a, b) => a + b, 0));
    }

    private ExecuteDouble(p: any): void {
        const durations = Array.isArray(p.duration) ? p.duration : [p.duration, p.duration];
        const pattern = [durations[0], p.interval || 100, durations[1]];
        if (navigator.vibrate) navigator.vibrate(pattern);
        this.done(pattern.reduce((a, b) => a + b, 0));
    }

    private ExecuteStaccato(p: any): void {
        const durations = Array.isArray(p.duration) ? p.duration : [p.duration];
        const intervals: number[] = [];
        durations.forEach((d, i) => {
            intervals.push(d);
            if (i < durations.length - 1) intervals.push(p.interval || 60);
        });
        if (navigator.vibrate) navigator.vibrate(intervals);
        this.done(intervals.reduce((a, b) => a + b, 0));
    }

    private ExecuteBurst(p: any): void {
        const pattern = [p.duration, p.interval || 40, p.duration, p.interval || 40, p.duration * 2];
        if (navigator.vibrate) navigator.vibrate(pattern);
        this.done(pattern.reduce((a, b) => a + b, 0));
    }

    private ExecuteBurst3Stage(p: any): void {
        const iv = p.interval || 10;
        const pattern = [
            p.duration * 0.5, iv,
            p.duration * 0.75, iv,
            p.duration, iv,
            p.duration * 1.5
        ].map(Math.round);
        if (navigator.vibrate) navigator.vibrate(pattern);
        this.done(pattern.reduce((a, b) => a + b, 0));
    }
}
```

### 1-3. BasePlatform 클래스 안에 정적 메서드 추가

`BasePlatform` 클래스(또는 해당 플랫폼 추상 클래스) 안에 아래를 추가합니다.

```typescript
// ─── 햅틱 피드백 ───────────────────────────────────────────────────────────
private static _vibrationManager: VibrationManager = null;

private static get vibrationManager(): VibrationManager {
    if (!this._vibrationManager) {
        this._vibrationManager = new VibrationManager();
    }
    return this._vibrationManager;
}

private static isVibrationEnabled(): boolean {
    // OMG_VIBRATION_ON 설정값 읽기 (설정 없으면 기본 true)
    return CCstorage.getBoolean(OMG_VIBRATION_ON, true);
}

private static isNavigatorVibrateSupported(): boolean {
    return !!(navigator && navigator.vibrate);
}

private static VibrateWithPattern(patternKey: keyof typeof HapticPatterns): void {
    if (!this.isVibrationEnabled()) return;
    if (!this.isNavigatorVibrateSupported()) return;

    const pattern = HapticPatterns[patternKey];
    if (!pattern) return;

    this.vibrationManager.ExecutePattern(pattern);
}

// ─── 공개 햅틱 API ─────────────────────────────────────────────────────────
static VibrateCardMatch(): void         { this.VibrateWithPattern('CARD_MATCH'); }
static VibrateDrawCard(): void          { this.VibrateWithPattern('DRAW_CARD'); }
static VibrateInvalidTap(): void        { this.VibrateWithPattern('INVALID_TAP'); }
static VibrateCombo(count: number): void {
    // 콤보 2회 이상부터만 진동
    if (count >= 2) this.VibrateWithPattern('COMBO');
}
static VibrateStageClear(): void        { this.VibrateWithPattern('STAGE_CLEAR'); }
static VibrateBoosterUse(): void        { this.VibrateWithPattern('BOOSTER_USE'); }
static VibrateUndoSuccess(): void       { this.VibrateWithPattern('UNDO_SUCCESS'); }
static VibrateRewardAcquisition(): void { this.VibrateWithPattern('REWARD_ACQUISITION'); }
static VibrateRankUp(): void            { this.VibrateWithPattern('RANK_UP'); }
static VibrateRankDown(): void          { this.VibrateWithPattern('RANK_DOWN'); }
```

> **Import 추가 필요**: `BasePlatform.ts` 상단에 아래가 없다면 추가
> ```typescript
> import { CCstorage } from "../utils/CCstorage";
> import { OMG_VIBRATION_ON } from "../common/ConstValues";
> ```

---

## 2단계: 이벤트 연결

### 파일: `solitaire-tripeaks-client/assets/script/game/ingame/StageView.ts`

#### 2-1. 카드 매칭 성공 (line ~2233)

```typescript
// 기존 코드:
const cardView = this.currentStageModel.clickCard(card);
if (cardView) {
    // ... 기존 로직 ...

    // ✅ 추가: 카드 매칭 성공 햅틱
    BasePlatform.VibrateCardMatch();
```

#### 2-2. 카드 매칭 실패 (onClickCard 내 실패 분기)

`clickCard()` 가 null을 반환하는 경우(매칭 불가 탭)를 찾아 추가합니다.

```typescript
const cardView = this.currentStageModel.clickCard(card);
if (cardView) {
    // 매칭 성공 로직...
    BasePlatform.VibrateCardMatch();
} else {
    // ✅ 추가: 매칭 실패 햅틱 (기존에 shakeEffect 등이 있는 위치 근처)
    BasePlatform.VibrateInvalidTap();
}
```

#### 2-3. 드로우 카드 뽑기 (line ~3100, `onClickDrawCard`)

```typescript
public onClickDrawCard(): void {
    // ... 기존 로직 상단 ...

    // ✅ 추가: 드로우 카드 햅틱
    BasePlatform.VibrateDrawCard();
```

#### 2-4. 콤보/스트릭 변화 감지 (`onTurnComplete` 내부, line ~4226)

스트릭/콤보 카운트 변화 후 호출합니다.
`IngameStreak.ts` 또는 `onTurnComplete` 내 콤보 업데이트 시점에 추가합니다.

```typescript
// 콤보 카운트가 증가했을 때
const currentCombo = this.currentStageModel.getComboCount(); // 실제 getter 확인 필요
if (currentCombo > previousCombo) {
    // ✅ 추가
    BasePlatform.VibrateCombo(currentCombo);
}
```

#### 2-5. 스테이지 클리어 (`onFieldEmptySuccess` 콜백, line ~4334)

```typescript
const fireFieldEmptySuccess = (): void => {
    // ✅ 추가: 스테이지 클리어 햅틱
    BasePlatform.VibrateStageClear();

    if (this.onFieldEmptySuccess) {
        this.onFieldEmptySuccess(this.levelCompletionRewardStar, this.levelCompletionRewardGold);
    }
};
```

---

### 파일: `solitaire-tripeaks-client/assets/script/game/ViewGame.ts`

#### 2-6. Undo 사용 성공 (line ~278, `onClickUndo`)

```typescript
public async onClickUndo(...): Promise<void> {
    // ... 기존 로직 ...
    // undo 성공 처리 후:

    // ✅ 추가
    BasePlatform.VibrateUndoSuccess();
}
```

#### 2-7. Plus/Wild 부스터 사용 (line ~309, ~326)

```typescript
public onClickPlus(...): void {
    // ✅ 추가
    BasePlatform.VibrateBoosterUse();
    // ... 기존 로직 ...
}

public onClickWild(...): void {
    // ✅ 추가
    BasePlatform.VibrateBoosterUse();
    // ... 기존 로직 ...
}
```

---

## 3단계: 설정 UI 연결 (진동 ON/OFF)

`OMG_VIBRATION_ON` 키로 `CCstorage`에 저장된 값을 읽습니다.
설정 팝업에서 토글 버튼으로 `CCstorage.save(OMG_VIBRATION_ON, true/false)` 하면 자동 적용됩니다.

> `ConstValues.ts`에 `OMG_VIBRATION_ON` 상수가 없다면 추가:
> ```typescript
> export const OMG_VIBRATION_ON = 'omg_vibration_on';
> ```

---

## 패턴 요약표

| 이벤트 | 메서드 | 패턴 | 강도 | 우선순위 |
|--------|--------|------|------|---------|
| 카드 매칭 성공 | `VibrateCardMatch()` | tap 30ms | light | 4 |
| 드로우 카드 뽑기 | `VibrateDrawCard()` | tap 20ms | light | 5 |
| 매칭 실패 탭 | `VibrateInvalidTap()` | tap 60ms | medium | 3 |
| 콤보 (2회+) | `VibrateCombo(count)` | staccato | medium | 3 |
| 스테이지 클리어 | `VibrateStageClear()` | burst_3stage | strong | 1 |
| Undo 사용 | `VibrateUndoSuccess()` | pulse | medium | 3 |
| Plus/Wild 부스터 | `VibrateBoosterUse()` | pulse | medium | 3 |
| 보상 획득 | `VibrateRewardAcquisition()` | burst | strong | 1 |
| 랭크 업 | `VibrateRankUp()` | double | medium | 2 |
| 랭크 다운 | `VibrateRankDown()` | double | medium | 2 |

---

## 우선순위 규칙

숫자가 낮을수록 **높은 우선순위**입니다.
예: 스테이지 클리어(1) 실행 중에는 카드 매칭(4) 진동이 무시됩니다.

---

## 주의사항

- `navigator.vibrate()`는 **사용자 인터랙션 이후**에만 동작합니다 (브라우저 정책). 게임 시작 후 첫 터치 이후부터 정상 작동합니다.
- iOS Safari에서는 동작하지 않으나, **Facebook 인앱 브라우저에서는 동작** 확인됩니다.
- 진동 패턴 duration 값은 ms 단위입니다. 실기기 테스트 후 값 조정 가능합니다.
- `BasePlatform` import가 `StageView.ts`, `ViewGame.ts`에 없다면 상단에 추가해야 합니다.
