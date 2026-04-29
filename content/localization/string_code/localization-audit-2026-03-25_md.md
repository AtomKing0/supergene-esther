# Localization Audit Report

**Date:** 2026-03-25
**Source:** 기획서 `[PST] Solitaire Tripeaks-1.pdf` (v1.7)
**Target:** `assets/bundles/localization/en.json` (262 keys)

> 타 게임(코지타일, 퍼즐블록마스터) 프리팹은 분석에서 제외됨.

---

## 1. en.json에 누락된 키 — 코드/프리팹에서 사용 중 (즉시 수정 필요)

실제 런타임에 `Localization.getString()` 또는 프리팹 Localization 컴포넌트에서 참조하지만,
어떤 언어 JSON에도 존재하지 않는 키.

| # | 키 | 사용 위치 | 용도 |
|---|---|---|---|
| 1 | `T_SETTING_TITLE` | `PopupSetting.prefab` | 설정 팝업 타이틀 |
| 2 | `T_INBOX` | `PopupMail.ts` | 우편함 타이틀 |
| 3 | `T_PURCHASE_FAIL` | `ShopItem.ts`, `PopupPurchaseToast.prefab` | IAP 결제 실패 |
| 4 | `T_DAILY_GIFT` | `PopupDailyGiftItem.ts` | 일일 선물 타이틀 |
| 5 | `T_GOLD_INSUFFICIENT` | `IngameItemButtonView.ts` | 골드 부족 에러 |
| 6 | `T_UNLOCK_AT` | `PopupCollectionAlbumItem.ts`, `PopupCollectionDeckItem.ts` | 해금 조건 (`{0}` = 레벨) |
| 7 | `T_FAILED_TO_LOAD_AD` | `PopupChargeGold.ts` | 광고 로드 실패 |
| 8 | `T_ERROR_PAYMENT_NOT_AVAILABLE` | `PopupSpecialOffer.ts` | 결제 불가 에러 |
| 9 | `T_ERROR_PRODUCT_NOT_FOUND` | `PopupSpecialOffer.ts` | 상품 미발견 에러 |
| 10 | `T_ERROR_PURCHASE_FAILED` | `PopupSpecialOffer.ts` | 결제 실패 에러 |
| 11 | `T_INBOX_FRIENDS_GIFT_DESC` | `PopupMailScrollItem.ts` | 친구 선물 설명 |

> 코드에서 fallback 문자열(`|| "Purchase failed"` 등)이 있는 경우도 있으나,
> 다국어 지원을 위해 모든 언어 JSON에 추가 필요.

---

## 2. en.json 키 오타 (수정 필요)

| 현재 키 | 올바른 키 | 현재 값 | 비고 |
|---|---|---|---|
| `T_COMPLETE-_LEVEL_REWARD` | `T_COMPLETE_LEVEL_REWARD` | "Rewards:" | 하이픈(`-`) 오타. 코드/프리팹에서 미사용 |

---

## 3. 기획서에 있지만 en.json에 없는 키 — 미구현 기능

코드/프리팹 어디에서도 아직 사용되지 않는 키. 해당 기능 구현 시 추가 필요.

### 3-1. 로비 UI / 팝업

| 키 | 기획서 섹션 | 용도 |
|---|---|---|
| `T_ALL_CITY_TITLE` | 05 - 로비 UI (p.22-26) | 모든 구역 리스트 팝업 타이틀 |
| `T_BUILD_ALREADY_COMPLETED` | 05 - 로비 UI (p.22-26) | 건물 이미 완성됨 텍스트 |
| `T_DAILY_GIFTS_TITLE` | 06 - 로비 팝업 (p.28-40) | 출석 보상 서브 타이틀 |
| `T_DECO_TITLE` | 16 - 부록 (p.104-108) | 꾸미기 팝업 타이틀 |
| `T_POLICY_POPUP_TITLE` | 08 - 기타 팝업 (p.56-59) | 정책 팝업 타이틀 |

### 3-2. 수익화 (IAP 스페셜 오퍼)

| 키 | 기획서 섹션 | 용도 |
|---|---|---|
| `T_SHOP_SPECIAL_OFFER_1` | 14 - 수익화 (p.93-96) | Starter Pack 상품명 |
| `T_SHOP_SPECIAL_OFFER_2` | 14 - 수익화 (p.93-96) | Mega Value Pack 상품명 |
| `T_SHOP_SPECIAL_OFFER_3` | 14 - 수익화 (p.93-96) | City Builder Pack 상품명 |
| `T_SPACIAL_OFFER_1_TITLE` | 14 - 수익화 (p.93-96) | 스페셜 오퍼 팝업 타이틀 1 |
| `T_SPACIAL_OFFER_2_TITLE` | 14 - 수익화 (p.93-96) | 스페셜 오퍼 팝업 타이틀 2 |
| `T_SPACIAL_OFFER_3_TITLE` | 14 - 수익화 (p.93-96) | 스페셜 오퍼 팝업 타이틀 3 |

### 3-3. 소셜 공유

| 키 | 기획서 섹션 | 용도 |
|---|---|---|
| `T_HIDDEN_CITY_SHARE_TITLE` | 13 - 소셜 (p.85-91) | 시티 히든 스팟 공유 타이틀 |
| `T_LEVEL_MILESTONE_SHARE_TITLE` | 13 - 소셜 (p.85-91) | 레벨 마일스톤 공유 타이틀 |
| `T_EVENT_MILESTONE_REWARD_SHARE_TITLE` | 13 - 소셜 (p.85-91) | 이벤트 마일스톤 보상 공유 타이틀 |

### 3-4. 봇 메세지

| 키 | 기획서 섹션 | 용도 |
|---|---|---|
| `T_BOT_BUTTON_PLAY` | 13 - 소셜 (p.85-91) | 봇 메세지 플레이 버튼 |
| `T_BOT_DAILY_MSG_1` ~ `20` | 13 - 소셜 (p.85-91) | 일일 봇 메세지 (20개) |
| `T_BOT_NEW_MAP_MSG_1` ~ `20` | 13 - 소셜 (p.85-91) | 신규 맵 봇 메세지 (20개) |
| `T_BOT_FRIEND_JOINED_MSG_1` ~ `20` | 13 - 소셜 (p.85-91) | 친구 가입 봇 메세지 (20개) |

---

## 4. 프리팹 Localization 컴포넌트 현황

프리팹에서 `Localization` 컴포넌트의 `key` 필드로 사용 중인 키 목록 (총 41개 고유 키, 15개 프리팹).

| 프리팹 | 키 | 누락 |
|---|---|---|
| `PopupError.prefab` | T_ERROR_POPUP_TITLE, T_OK | - |
| `PopupPrivacyPolicy.prefab` | T_PRIVACY_POLICY | - |
| `PopupSetting.prefab` | T_SETTING_TITLE, T_PRIVACY_POLICY, T_USERID, T_CLIENT_VER | **T_SETTING_TITLE** |
| `InboxItem.prefab` | T_INBOX_AD_FREE_COIN_DESC | - |
| `ViewGame.prefab` | T_STREAK_INFO, T_END_LEVEL | - |
| `PopupPurchaseToast.prefab` | T_PURCHASE_FAIL | **T_PURCHASE_FAIL** |
| `PopupLeaderBoard.prefab` | T_LEADERBOARD_TITLE, T_LEADERBOARD_WEEKLY, T_LEADERBOARD_ALLTIME, T_GLOBAL, T_FRIENDS | - |
| `PopupChargeGold.prefab` | T_CHARGE_GOLD_TITLE, T_CHARGE_GOLD_DESC_1, T_CHARGE_GOLD_DESC_2 | - |
| `PopupGameEntry.prefab` | T_BEST_PLAYER, T_INVITE, T_SELECT_BOOSTER, T_REWARD_MULTIPLIER | - |
| `PopupMail.prefab` | T_INBOX_INVITE_DESC | - |
| `PopupCompleteLevel.prefab` | T_COMPLETE_LEVEL_TITLE, T_REWARD_MULTIPLIER, T_COLLECT, T_COLLECT_DOUBLE | - |
| `PopupQuitLevel.prefab` | T_QUIT_LEVEL_TITLE, T_QUIT, T_BACK, T_QUIT_LEVEL_DESC | - |
| `PopupSwitchContext.prefab` | T_P2P_TITLE, T_P2P_DESC, T_FRIENDS_TOURNAMENT_TITLE, T_FRIENDS_TOURNAMENT_DESC, T_TOURNAMENT_TITLE, T_TOURNAMENT_DESC | - |
| `PopupTournament.prefab` | T_TOURNAMENT_POPUP_TITLE, T_JOIN_TOURNAMENT, T_CREATE_TOURNAMENT | - |
| `PopupSettingInGame.prefab` | T_SETTING_INGAME_TITLE, T_QUIT, T_RESUME | - |

> **누락** = en.json에 키가 존재하지 않음

---

## 5. 요약

| 구분 | 수량 |
|---|---|
| en.json 전체 키 | 262개 |
| 프리팹 Localization 사용 키 | 41개 (15개 프리팹) |
| TS 코드 정적 사용 키 | 44개 |
| 전체 사용 키 (합산, 중복 제거) | 80개 |
| **en.json 누락 (실사용 중)** | **11개** |
| **en.json 오타** | **1개** |
| 기획서 미구현 키 | ~30개 (봇 메세지 범위 포함 시 ~90개) |

### 우선순위

1. **P0** — 11개 누락 키를 en.json + 전체 언어 JSON(ar, es, fr, id, kr, pt, ru, th)에 추가
2. **P1** — 오타 키 `T_COMPLETE-_LEVEL_REWARD` → `T_COMPLETE_LEVEL_REWARD` 수정
3. **P2** — 기획서 미구현 키는 해당 기능 구현 시 추가
