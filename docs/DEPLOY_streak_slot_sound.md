# 사운드 구현 가이드 — FX_STREAK_SLOT_FILLED 도레미파솔라 순서 재생

> 작성일: 2026-04-16

---

## 개요

스트릭 미터의 슬롯이 하나씩 채워질 때마다 도→레→미→파→솔→라 순서로 음계가 올라가는 효과음을 재생합니다.
스트릭이 깨지면(슬롯 초기화) 다음 채워짐부터 다시 `_01`(도)부터 시작합니다.

---

## 사운드 파일

번들 경로: `assets/bundles/sound/`

| 파일명 | 음계 | 재생 시점 |
|---|---|---|
| `FX_STREAK_SLOT_FILLED_01.wav` | 도 | 1번째 슬롯 채워짐 |
| `FX_STREAK_SLOT_FILLED_02.wav` | 레 | 2번째 슬롯 채워짐 |
| `FX_STREAK_SLOT_FILLED_03.wav` | 미 | 3번째 슬롯 채워짐 |
| `FX_STREAK_SLOT_FILLED_04.wav` | 파 | 4번째 슬롯 채워짐 |
| `FX_STREAK_SLOT_FILLED_05.wav` | 솔 | 5번째 슬롯 채워짐 |
| `FX_STREAK_SLOT_FILLED_06.wav` | 라 | 6번째 이상 슬롯 채워짐 (상한) |

> 슬롯이 6개를 초과하더라도 `_06`(라)에서 멈춥니다. (index는 0~5로 clamp)

---

## 구현 방법

### 1. 상태 변수 추가

스트릭 관련 클래스(예: `IngameStreak.ts`)에 현재 음계 인덱스를 추적하는 변수를 추가합니다.

```typescript
private _streakSoundIndex: number = 0;
```

---

### 2. 슬롯 채워질 때 — 순서대로 재생

기존 `FX_STREAK_SLOT_FILLED` play() 호출 위치(예: `IngameStreak.ts:418`)를 아래로 교체합니다.

```typescript
// 기존
SoundManager.play('FX_STREAK_SLOT_FILLED');

// 변경 후
const idx = Math.min(this._streakSoundIndex, 5); // 최대 _06
const key = `FX_STREAK_SLOT_FILLED_${String(idx + 1).padStart(2, '0')}`;
SoundManager.play(key);
this._streakSoundIndex++;
```

---

### 3. 스트릭 깨질 때 — 인덱스 리셋

슬롯이 초기화되는 시점(예: `IngameStreak.ts:360` `FX_STREAK_SLOT_REMOVED` 또는 스트릭 실패 처리 지점)에 인덱스를 리셋합니다.

```typescript
this._streakSoundIndex = 0;
```

---

### 4. 프리로드 추가 (`ResourcePreloader.ts`)

`preloadForIngame()` 에 6개 키를 추가합니다.

```typescript
'FX_STREAK_SLOT_FILLED_01',
'FX_STREAK_SLOT_FILLED_02',
'FX_STREAK_SLOT_FILLED_03',
'FX_STREAK_SLOT_FILLED_04',
'FX_STREAK_SLOT_FILLED_05',
'FX_STREAK_SLOT_FILLED_06',
```

> 기존 `FX_STREAK_SLOT_FILLED` 프리로드는 제거해도 됩니다. (파일 미사용)

---

## 동작 요약

```
슬롯 1 채워짐 → _01(도) 재생, index=1
슬롯 2 채워짐 → _02(레) 재생, index=2
슬롯 3 채워짐 → _03(미) 재생, index=3
...
스트릭 깨짐   → index=0 리셋
슬롯 1 채워짐 → _01(도) 재생 (다시 시작)
```
