# Localization Audit Report

> 기획문서 + en.json + 코드 + 프리팹 실제 검증 기반 로컬라이즈 누락 분석
> 작성일: 2026-03-25
> 검증 방법: Localization 컴포넌트 UUID(`e303fgJ2/tIZ4mJuoaekBDS`) 기반 프리팹 스캔, getString/getFormatString 코드 추출, en.json 키 대조

---

## 1. 코드/프리팹에서 사용하지만 en.json에 없는 키 (긴급)

> 유저에게 **키 이름 그대로 또는 빈 문자열**이 노출될 수 있어 즉시 수정 필요

### 1-1. 코드에서 getString()/getFormatString() 호출하지만 en.json 미등록

| 키 | 사용 위치 | 설명 |
|---|---|---|
| `T_DAILY_GIFT` | PopupDailyGiftItem.ts:258 | 데일리 기프트 보상 타이틀 |
| `T_ERROR_PAYMENT_NOT_AVAILABLE` | PopupSpecialOffer.ts:310 | 결제 불가 에러 (fallback 영문 있음) |
| `T_ERROR_PRODUCT_NOT_FOUND` | PopupSpecialOffer.ts:322 | 상품 미발견 에러 (fallback 영문 있음) |
| `T_ERROR_PURCHASE_FAILED` | PopupSpecialOffer.ts:432 | 구매 실패 에러 (fallback 영문 있음) |
| `T_FAILED_TO_LOAD_AD` | PopupChargeGold.ts:65 | 광고 로드 실패 토스트 |
| `T_GOLD_INSUFFICIENT` | IngameItemButtonView.ts:400 | 골드 부족 알림 토스트 |
| `T_INBOX` | PopupMail.ts:295 | 우편함 타이틀 (en.json에는 `T_INBOX_TITLE`이 존재 — 키 불일치 의심) |
| `T_INBOX_FRIENDS_GIFT_DESC` | PopupMailScrollItem.ts:112 | 우편함 친구 선물 설명 |
| `T_UNLOCK_AT` | PopupCollectionAlbumItem.ts:57, PopupCollectionDeckItem.ts:56 | 컬렉션 해금 조건 (getFormatString) |

### 1-2. 프리팹 Localization 컴포넌트 key에 설정되어 있지만 en.json 미등록

| 키 | 프리팹 | 설명 |
|---|---|---|
| `T_SETTING_TITLE` | PopupSetting.prefab | 설정 팝업 타이틀 (en.json에는 `T_SETTING`만 존재 — 키 불일치) |
| `T_PURCHASE_FAIL` | PopupPurchaseToast.prefab, ShopItem.ts:337 | 구매 실패 토스트 (프리팹+코드 모두 사용) |

---

## 2. 코드에서 하드코딩된 유저 노출 영문 문자열

> `getString()` fallback으로 영문이 직접 들어가 있어, 키 미등록 시 영문만 노출

| 파일 | 라인 | 하드코딩 문자열 | 사용 키 |
|---|---|---|---|
| PopupSpecialOffer.ts | 310 | `"Payment not available"` | `T_ERROR_PAYMENT_NOT_AVAILABLE` |
| PopupSpecialOffer.ts | 322 | `"Product not found"` | `T_ERROR_PRODUCT_NOT_FOUND` |
| PopupSpecialOffer.ts | 432 | `"Purchase failed"` | `T_ERROR_PURCHASE_FAILED` |

---

## 3. 프리팹 Localization 컴포넌트 검증 결과

> UUID `e303fgJ2/tIZ4mJuoaekBDS`로 실제 프리팹 내 Localization 컴포넌트 존재 여부를 검증했습니다.

### 3-1. Localization 컴포넌트 적용 완료 (17개 프리팹 — 문제 없음)

| 프리팹 | 적용된 키 |
|---|---|
| PopupQuitLevel.prefab | T_QUIT_LEVEL_TITLE, T_QUIT_LEVEL_DESC, T_BACK, T_QUIT |
| PopupCompleteLevel.prefab | T_COMPLETE_LEVEL_TITLE, T_REWARD_MULTIPLIER, T_COLLECT, T_COLLECT_DOUBLE |
| PopupSettingInGame.prefab | T_SETTING_INGAME_TITLE, T_QUIT, T_RESUME |
| PopupChargeGold.prefab | T_CHARGE_GOLD_TITLE, T_CHARGE_GOLD_DESC_1, T_CHARGE_GOLD_DESC_2 |
| PopupLeaderBoard.prefab | T_LEADERBOARD_TITLE, T_LEADERBOARD_WEEKLY, T_LEADERBOARD_ALLTIME, T_GLOBAL, T_FRIENDS |
| PopupTournament.prefab | T_TOURNAMENT_POPUP_TITLE, T_JOIN_TOURNAMENT, T_CREATE_TOURNAMENT |
| PopupSetting.prefab | T_SETTING_TITLE*, T_PRIVACY_POLICY, T_USERID, T_CLIENT_VER |
| PopupSwitchContext.prefab | T_P2P_TITLE, T_P2P_DESC, T_FRIENDS_TOURNAMENT_TITLE, T_FRIENDS_TOURNAMENT_DESC, T_TOURNAMENT_TITLE, T_TOURNAMENT_DESC |
| PopupGameEntry.prefab | T_BEST_PLAYER, T_INVITE, T_SELECT_BOOSTER, T_REWARD_MULTIPLIER |
| PopupMail.prefab | T_INBOX_INVITE_DESC |
| PopupError.prefab | T_ERROR_POPUP_TITLE, T_OK |
| PopupPrivacyPolicy.prefab | T_PRIVACY_POLICY |
| PopupPurchaseToast.prefab | T_PURCHASE_FAIL* |
| PopupDefault.prefab | (키 없음 — 동적 설정) |
| PopupToastItemPackage.prefab | (키 없음 — 동적 설정) |
| ViewGame.prefab | T_STREAK_INFO, T_END_LEVEL |
| InboxItem.prefab | T_INBOX_AD_FREE_COIN_DESC |

> `*` 표시: en.json에 해당 키 미등록 (섹션 1-2 참조)

### 3-2. Localization 컴포넌트 없지만 코드에서 처리됨 (문제 없음)

| 프리팹 | 코드 처리 내용 |
|---|---|
| PopupNeedHammer.prefab | PopupNeedHammer.ts에서 T_HAMMER_INFO_TITLE, T_HAMMER_INFO_DESC_1, T_HAMMER_INFO_DESC_2, T_LEVEL 적용 |
| PopupRewardClaim.prefab | PopupRewardClaim.ts에서 T_TAP_TO_CLAIM 적용 |
| PopupEventCardMilestone.prefab | PopupEventCardMilestone.ts에서 T_EVENT_BLK/RED_CARD_TITLE, DESC, T_LEVEL 적용 |
| PopupEventClearRanking.prefab | PopupEventClearRanking.ts에서 T_EVENT_RANK_TITLE, T_EVENT_RANK_DESC_1, T_LEVEL 적용 |
| PopupEventWinningMilestone.prefab | PopupEventWinningMilestone.ts에서 T_EVENT_STAMP_TITLE, T_EVENT_STAMP_DESC_1, T_LEVEL 적용 |
| PopupTutorial.prefab | PopupTutorial.ts에서 guide.string_code_key 동적 적용 (T_TUT_* 키) |
| PopupDailyGift.prefab | PopupDailyGift.ts에서 T_TODAY_GIFT_TITLE 적용, PopupDailyGiftItem.ts에서 T_DAILY_GIFT* 적용 |
| PopupDailyTask.prefab | PopupDailyTask.ts에서 T_MILESTONE_COMPLETE 적용, PopupDailyTaskItem.ts에서 task description 동적 적용 |

> `*` T_DAILY_GIFT는 en.json 미등록 (섹션 1-1 참조)

### 3-3. Localization 컴포넌트 없고 코드에서도 미처리 — 수정 필요

| 프리팹 | 하드코딩 텍스트 | en.json에 키 존재 여부 |
|---|---|---|
| **PopupShop.prefab** | "Shop", "Most Popular", "Best Value", "Free" | T_SHOP_TITLE, T_MOST_POPULAR, T_BEST_VALUE, T_FREE 모두 **존재** — 코드 미연결 |
| **PopupMetaCityList.prefab** | "City Journey" | T_CITY_LIST_TITLE **존재** — 코드 미연결 |
| **PopupDecoShare.prefab** | "Share", "+500", "New York Completed!" | T_SHARE **존재** — 코드 미연결 |
| **PopupSettingLanguage.prefab** | "Select Language" | T_LANGUAGE **존재** — 코드 미연결 |
| **PopupSpecialOffer.prefab** | "Starter Pack", "Mega Value Pack", "City Builder Pack" | en.json **미등록** |
| **ViewLobby.prefab** | "Collect", "Coins Bonus is ready!", "Complete all mission for rewards!", "Upgrade", "View", "All cities", "Max Level" | T_COLLECT_INFO, T_UPGRADE, T_VIEW, T_MAX_LEVEL 등 부분적 존재 — 일부 미연결 |

### 3-4. 부분 처리 — Localization 컴포넌트가 일부 Label에만 적용

| 프리팹 | 적용된 키 | 미적용 하드코딩 텍스트 |
|---|---|---|
| PopupMail.prefab | T_INBOX_INVITE_DESC (1개) | "Inbox"(→T_INBOX_TITLE), "Claim All"(→T_CLAIM_ALL) 미적용 |
| PopupGameEntry.prefab | T_BEST_PLAYER, T_INVITE 등 (6개) | "Level"(→T_LEVEL), "Play"(→T_PLAY) 등 미적용 가능 |
| PopupDailyGift.prefab | 없음 | "Tap to Close"(→T_TAP_TO_CLOSE 존재) 미적용 |
| PopupDailyTask.prefab | 없음 | "Daily Task"(→T_DAILY_TASKS_TITLE 존재), "Calim"(오타, →T_CLAIM), "Change"(→T_CHANGE 존재) 미적용 |

### 3-5. 서브 프리팹 — 하드코딩 텍스트 (부모에서 동적 처리 가능)

| 프리팹 | 하드코딩 텍스트 | 비고 |
|---|---|---|
| DailyTaskItem.prefab | "Calim"(오타), "Change", "Task description 2 Lines" | 코드에서 동적 설정, "Calim"은 T_CLAIM으로 교체 필요 |
| MetaCityListItem.prefab | "1.NEW YORK", "Complete all mission for rewards!", "View" | 코드에서 동적 처리됨 |
| CardMilestoneItem.prefab | 숫자만 | 동적 처리됨 |
| ClearRankingItem.prefab | "User Name", 숫자 | 동적 처리됨 |
| LeaderboardItem.prefab | "User Name", 숫자 | 동적 처리됨 |
| RewardUIItem.prefab | 숫자만 | 동적 처리됨 |

---

## 4. 기획서에 명시되어 있으나 en.json 미등록 (참고)

> 기획문서 `[PST] Solitaire Tripeaks (1).pdf` 기준. 향후 기능 구현 시 추가 필요.

### 4-1. 공유 지면 관련

| string_code | 설명 |
|---|---|
| `T_HIDDEN_CITY_SHARE_TITLE` | 시티 히든 스팟 공유 |
| `T_LEVEL_MILESTONE_SHARE_TITLE` | 레벨 마일스톤 피드 공유 |
| `T_EVENT_MILESTONE_REWARD_SHARE_TITLE` | 마일스톤 이벤트 보상 수령 피드 공유 |

### 4-2. IAP 스페셜 오퍼 관련

| string_code | 설명 |
|---|---|
| `T_SPACIAL_OFFER_1_TITLE` | Starter Pack |
| `T_SPACIAL_OFFER_2_TITLE` | Mega Value Pack |
| `T_SPACIAL_OFFER_3_TITLE` | City Builder Pack |

### 4-3. 봇/P2P 메세지 관련 (총 61개)

| string_code | 설명 |
|---|---|
| `T_BOT_BUTTON_PLAY` | 봇 메세지 버튼 |
| `T_BOT_DAILY_MSG_1` ~ `T_BOT_DAILY_MSG_20` | 매일 알림 봇 메세지 (20개) |
| `T_BOT_NEW_MAP_MSG_1` ~ `T_BOT_NEW_MAP_MSG_20` | 신규 스테이지 봇 메세지 (20개) |
| `T_BOT_FRIEND_JOINED_MSG_1` ~  `T_BOT_FRIEND_JOINED_MSG_20` | 친구 가입 완료 봇 메세지 (20개) |

---