# Localization Action Plan — 2026-03-25

> 기획서 v1.7 + en.json (262 keys) + 코드/프리팹 실제 검증 기반
> 각 섹션의 "AI 프롬프트"를 개발 AI에 그대로 전달하면 됩니다.

---

## P0-A. en.json 누락 키 11개 추가

런타임에 키 이름 또는 빈 문자열이 유저에게 노출되는 상태입니다.

| # | 키 | 사용 위치 | 영문 값 (제안) | 비고 |
|---|---|---|---|---|
| 1 | `T_SETTING_TITLE` | PopupSetting.prefab | Settings | en.json엔 `T_SETTING`만 존재 |
| 2 | `T_INBOX` | PopupMail.ts | Inbox | en.json엔 `T_INBOX_TITLE`만 존재 |
| 3 | `T_PURCHASE_FAIL` | PopupPurchaseToast.prefab, ShopItem.ts | Purchase failed | |
| 4 | `T_DAILY_GIFT` | PopupDailyGiftItem.ts | Daily Gift | |
| 5 | `T_GOLD_INSUFFICIENT` | IngameItemButtonView.ts | Not enough gold | |
| 6 | `T_UNLOCK_AT` | PopupCollectionAlbumItem.ts, PopupCollectionDeckItem.ts | Unlocks at Level {0} | getFormatString |
| 7 | `T_FAILED_TO_LOAD_AD` | PopupChargeGold.ts | Failed to load ad | |
| 8 | `T_ERROR_PAYMENT_NOT_AVAILABLE` | PopupSpecialOffer.ts | Payment not available | |
| 9 | `T_ERROR_PRODUCT_NOT_FOUND` | PopupSpecialOffer.ts | Product not found | |
| 10 | `T_ERROR_PURCHASE_FAILED` | PopupSpecialOffer.ts | Purchase failed | |
| 11 | `T_INBOX_FRIENDS_GIFT_DESC` | PopupMailScrollItem.ts | (기획서 문구 확인 필요) | |

> **기획 작업**: 시트 string_code에 11개 키 + 영문 값 추가 → 번역 진행 (ar, es, fr, id, kr, pt, ru, th)

### AI 프롬프트 — 누락 키 JSON 추가

```
assets/bundles/localization/ 폴더의 모든 언어 JSON 파일(en.json, ar.json, es.json, fr.json, id.json, kr.json, pt.json, ru.json, th.json)에 아래 키를 추가해줘.

우선 en.json에 영문 값을 추가하고, 나머지 언어 파일에는 동일한 영문 값을 placeholder로 넣어줘 (추후 번역팀이 교체).

추가할 키-값:
- "T_SETTING_TITLE": "Settings"
- "T_INBOX": "Inbox"
- "T_PURCHASE_FAIL": "Purchase failed"
- "T_DAILY_GIFT": "Daily Gift"
- "T_GOLD_INSUFFICIENT": "Not enough gold"
- "T_UNLOCK_AT": "Unlocks at Level {0}"
- "T_FAILED_TO_LOAD_AD": "Failed to load ad"
- "T_ERROR_PAYMENT_NOT_AVAILABLE": "Payment not available"
- "T_ERROR_PRODUCT_NOT_FOUND": "Product not found"
- "T_ERROR_PURCHASE_FAILED": "Purchase failed"
- "T_INBOX_FRIENDS_GIFT_DESC": "A gift from your friend!"

기존 키의 알파벳 순서에 맞춰 삽입해줘.
```

---

## P0-B. 키 오타 / 키명 수정

### 1) 하이픈 오타

| 현재 | 수정 | 위치 |
|---|---|---|
| `T_COMPLETE-_LEVEL_REWARD` | `T_COMPLETE_LEVEL_REWARD` | en.json + 전체 언어 JSON |

### 2) SPACIAL → SPECIAL (기획서 수정 완료, 코드 반영 필요)

기획서에서 `T_SPACIAL_OFFER_*` → `T_SPECIAL_OFFER_*`로 수정 완료됨. 코드/JSON 측 반영 필요.

### 3) 프리팹 키 통일 (코드 기준 유지, 프리팹 수정)

| 프리팹 | 현재 프리팹 key | 코드에서 사용하는 key | 수정 방향 |
|---|---|---|---|
| PopupSetting.prefab | `T_SETTING` | `T_SETTING_TITLE` | 프리팹 key를 `T_SETTING_TITLE`로 변경 |
| PopupMail.prefab | (해당 없음) | `T_INBOX` | 코드 기준 `T_INBOX`로 통일, JSON에 키 추가 |

### AI 프롬프트 — 오타/키명 수정

```
localization 키 수정 작업을 해줘.

1) 전체 언어 JSON 파일(en.json, ar.json, es.json, fr.json, id.json, kr.json, pt.json, ru.json, th.json)에서:
   - "T_COMPLETE-_LEVEL_REWARD" 키를 "T_COMPLETE_LEVEL_REWARD"로 rename해줘 (하이픈 제거). 값은 그대로 유지.

2) 코드와 JSON 전체에서:
   - "T_SPACIAL_OFFER" 가 포함된 모든 키/문자열을 "T_SPECIAL_OFFER"로 변경해줘 (SPACIAL → SPECIAL 오타 수정).
   - 대상: JSON 파일의 키, 코드의 getString()/getFormatString() 호출 인자, 프리팹의 Localization 컴포넌트 key 필드

3) PopupSetting.prefab의 Localization 컴포넌트:
   - key 필드를 "T_SETTING"에서 "T_SETTING_TITLE"로 변경해줘. 코드(PopupSetting.ts)에서 T_SETTING_TITLE을 사용 중이므로 프리팹을 코드에 맞춤.
```

---

## P1-C. 프리팹 하드코딩 텍스트 → Localization 키 연결

en.json에 키가 이미 존재하지만 프리팹에서 Localization 컴포넌트로 연결되지 않아, 다국어 전환 시 영문 고정 노출됨.

### C-1. Localization 컴포넌트 완전 미적용

| 프리팹 | 하드코딩 텍스트 | 연결할 키 |
|---|---|---|
| PopupShop.prefab | "Shop", "Most Popular", "Best Value", "Free" | `T_SHOP_TITLE`, `T_MOST_POPULAR`, `T_BEST_VALUE`, `T_FREE` |
| PopupMetaCityList.prefab | "City Journey" | `T_CITY_LIST_TITLE` |
| PopupDecoShare.prefab | "Share" | `T_SHARE` |
| PopupSettingLanguage.prefab | "Select Language" | `T_LANGUAGE` |
| PopupSpecialOffer.prefab | "Starter Pack", "Mega Value Pack", "City Builder Pack" | `T_SPECIAL_OFFER_1` ~ `3` (신규 키 추가 필요) |

### C-2. 부분 적용 (일부 Label만 적용)

| 프리팹 | 미적용 텍스트 | 연결할 키 |
|---|---|---|
| PopupMail.prefab | "Inbox", "Claim All" | `T_INBOX_TITLE`, `T_CLAIM_ALL` |
| PopupGameEntry.prefab | "Level", "Play" | `T_LEVEL`, `T_PLAY` |
| PopupDailyGift.prefab | "Tap to Close" | `T_TAP_TO_CLOSE` |
| PopupDailyTask.prefab | "Daily Task", **"Calim"(오타)**, "Change" | `T_DAILY_TASKS_TITLE`, `T_CLAIM`, `T_CHANGE` |

### C-3. ViewLobby 하드코딩 정리

| 하드코딩 텍스트 | 연결할 키 |
|---|---|
| "Collect", "Coins Bonus is ready!" | `T_COLLECT_INFO` 등 |
| "Upgrade", "View", "All cities", "Max Level" | `T_UPGRADE`, `T_VIEW`, `T_ALL_CITY_TITLE`, `T_MAX_LEVEL` |

### AI 프롬프트 — 프리팹 하드코딩 → Localization 연결

```
아래 프리팹들에서 하드코딩된 텍스트를 Localization 컴포넌트로 교체해줘.
각 Label 노드에 Localization 컴포넌트를 추가하고 key 필드에 해당 키를 설정하면 됨.
기존 getString()/getFormatString() 패턴과 동일하게 처리.

## 완전 미적용 프리팹 (Localization 컴포넌트 추가)

1. PopupShop.prefab
   - "Shop" → key: T_SHOP_TITLE
   - "Most Popular" → key: T_MOST_POPULAR
   - "Best Value" → key: T_BEST_VALUE
   - "Free" → key: T_FREE

2. PopupMetaCityList.prefab
   - "City Journey" → key: T_CITY_LIST_TITLE

3. PopupDecoShare.prefab
   - "Share" → key: T_SHARE

4. PopupSettingLanguage.prefab
   - "Select Language" → key: T_LANGUAGE

5. PopupSpecialOffer.prefab
   - "Starter Pack" → key: T_SPECIAL_OFFER_1
   - "Mega Value Pack" → key: T_SPECIAL_OFFER_2
   - "City Builder Pack" → key: T_SPECIAL_OFFER_3
   (이 3개 키는 en.json에 신규 추가 필요)

## 부분 적용 프리팹 (누락된 Label에 Localization 추가)

6. PopupMail.prefab
   - "Inbox" → key: T_INBOX_TITLE
   - "Claim All" → key: T_CLAIM_ALL

7. PopupGameEntry.prefab
   - "Level" → key: T_LEVEL
   - "Play" → key: T_PLAY

8. PopupDailyGift.prefab
   - "Tap to Close" → key: T_TAP_TO_CLOSE

9. PopupDailyTask.prefab + DailyTaskItem.prefab
   - "Daily Task" → key: T_DAILY_TASKS_TITLE
   - "Calim" (오타) → key: T_CLAIM
   - "Change" → key: T_CHANGE

## ViewLobby

10. ViewLobby.prefab
    - "Collect" → key: T_COLLECT 또는 T_COLLECT_INFO (기존 키 확인)
    - "Coins Bonus is ready!" → 기존 키 확인 필요
    - "Upgrade" → key: T_UPGRADE
    - "View" → key: T_VIEW
    - "All cities" → key: T_ALL_CITY_TITLE
    - "Max Level" → key: T_MAX_LEVEL
```

---

## P2. 미구현 키 (~90개) — 기능 개발 시 추가

| 카테고리 | 수량 | 키 예시 | 추가 시점 |
|---|---|---|---|
| 로비 UI / 팝업 | 5개 | `T_ALL_CITY_TITLE`, `T_DECO_TITLE`, `T_POLICY_POPUP_TITLE` | 해당 UI 개발 시 |
| IAP 스페셜 오퍼 | 6개 | `T_SHOP_SPECIAL_OFFER_1~3`, `T_SPECIAL_OFFER_1~3_TITLE` | 스페셜 오퍼 구현 시 |
| 소셜 공유 | 3개 | `T_HIDDEN_CITY_SHARE_TITLE`, `T_LEVEL_MILESTONE_SHARE_TITLE` | 소셜 피처 개발 시 |
| 봇 메세지 | ~61개 | `T_BOT_DAILY_MSG_1~20`, `T_BOT_NEW_MAP_MSG_1~20` 등 | 봇 시스템 개발 시 |

> P2는 당장 작업 불필요. 기능 구현 시 시트에 키 추가 → 번역 → JSON 반영 순서로 처리.

---

## 실행 순서 요약

| 순서 | 작업 | 담당 |
|---|---|---|
| 1 | 시트 string_code에 누락 키 11개 추가 + 번역 진행 | 기획 |
| 2 | 번역 완료 후 전체 언어 JSON 반영 (P0-A 프롬프트) | 개발 |
| 3 | 오타/키명 수정 — JSON + 코드 + 프리팹 (P0-B 프롬프트) | 개발 |
| 4 | 프리팹 하드코딩 → Localization 연결 (P1-C 프롬프트) | 개발 |
| 5 | 전체 언어 전환 테스트 | QA |
