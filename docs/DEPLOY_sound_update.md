# 사운드 업데이트 노트 — 클라이언트 작업 가이드

> 작성일: 2026-04-08
> 기준 파일: `ResourcePreloader.ts`

---

## 1. 신규 사운드 — play() 호출 추가 필요

### 1-1. play() 호출 추가

| 키 이름 | 호출 시점 |
|---|---|
| `FX_META_DECO_PLACE` | 메타 데코 오브젝트 배치 완료 시 |
| `FX_UI_SCREENSHOT` | 스크린샷 촬영 버튼 tap 시 |
| `FX_REWARD_SMALL_BOX_OPEN` | 작은 보상 상자 오픈 연출 시 |
| `FX_REWARD_BIG_BOX_OPEN` | 큰 보상 상자 오픈 연출 시 |
| `FX_ITEM_HIT` | 골드 외 재화(이벤트 토큰 등) 착지 시 |
| `FX_EVENT_REWARD_CLAIMED` | 이벤트 보상 수령 연출 완료 시 |

> **`FX_ITEM_HIT`** — `FX_COIN_HIT_01~03`(골드 착지)과 별개. 비-골드 재화 공통 착지음.
> **`FX_EVENT_REWARD_CLAIMED`** — 이벤트 보상 팝업에서 수령 완료 시. `FX_REWARD_BIG_BOX_OPEN`과는 별개.

### 1-2. 프리로드 추가 (`ResourcePreloader.ts`)

| 키 이름 | 추가 위치 |
|---|---|
| `FX_META_DECO_PLACE` | `preloadForLobby()` |
| `FX_UI_SCREENSHOT` | `preloadCommon()` |
| `FX_REWARD_SMALL_BOX_OPEN` | `preloadForIngame()` |
| `FX_REWARD_BIG_BOX_OPEN` | `preloadForIngame()` |
| `FX_EVENT_REWARD_CLAIMED` | `preloadForIngame()` |

> `FX_ITEM_HIT`는 `preloadForIngame()`에 이미 포함되어 있음.

---

## 2. 삭제된 사운드 — 참조 제거 필요

### 2-1. play() 호출 제거

| 키 이름 | 사유 |
|---|---|
| `FX_UI_POPUP_IN` | 번들에서 파일 삭제됨 |
| `FX_UI_POPUP_OUT` | 번들에서 파일 삭제됨 |
| `FX_EVENT_LEADERBOARD_IN` | 번들에서 파일 삭제됨 |

### 2-2. 프리로드 제거 (`ResourcePreloader.ts`)

**`preloadCommon()`에서 제거:**
```
FX_UI_POPUP_IN
FX_UI_POPUP_OUT
FX_COIN_FLY_01 / _02 / _03    ← 파일 미사용
```

**`preloadForIngame()`에서 제거:**
```
FX_CARD_PLAYED_02 / _03              ← 파일 미사용 (_01만 사용)
FX_GIMMICK_GATE_CLOSE                ← Gate 기믹 미사용
FX_GIMMICK_GATE_OPEN                 ← Gate 기믹 미사용
FX_GIMMICK_GATE_REMOVE               ← Gate 기믹 미사용
FX_BOOSTER_FIREWORKS_APPEAR_01 / _03 ← 파일 미사용 (_02만 사용)
FX_BOOSTER_FIREWORKS_EXPLODE_02 / _03← 파일 미사용 (_01만 사용)
FX_BOOSTER_GOLDEN_TICKET_TAP_02 / _03← 파일 미사용 (_01만 사용)
FX_COIN_FLY_01 / _02 / _03           ← 파일 미사용
FX_STREAK_BAR_DETRACTS               ← 파일 미사용
FX_EVENT_LEADERBOARD_IN              ← 번들에서 파일 삭제됨
```
