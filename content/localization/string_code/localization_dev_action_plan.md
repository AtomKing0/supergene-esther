# Localization 개발 작업 지시서

> **작성일**: 2026-03-25
> **시트 완료**: 누락 키 14개 추가·번역, 하이픈 오타 수정, SPACIAL→SPECIAL 시트 치환 완료

---

## 작업 목록

| # | 우선순위 | 작업 | 범위 |
|---|---|---|---|
| 1 | **P0** | `SPACIAL` → `SPECIAL` 전체 치환 | 코드(.ts) + 프리팹(.prefab) + JSON |
| 2 | **P1** | 프리팹 하드코딩 텍스트 → Localization 컴포넌트 연결 | 프리팹 10개 |

---

## 1. [P0] SPACIAL → SPECIAL 전체 치환

기획서·시트에서 `T_SPACIAL_OFFER` → `T_SPECIAL_OFFER`로 수정 완료됨. 코드/JSON/프리팹에 잔존하는 `SPACIAL`을 모두 `SPECIAL`로 치환한다.

```bash
# 1) 검색 — 잔존 확인
grep -r "SPACIAL" assets/bundles/localization --include="*.json"
grep -r "SPACIAL" assets/script --include="*.ts"
grep -r "SPACIAL" assets --include="*.prefab"

# 2) 발견되는 모든 SPACIAL → SPECIAL 치환
# JSON 키명, getString() 인자, 프리팹 Localization key 필드 모두 포함
```

### 검증

```bash
# 0건이어야 함
grep -r "SPACIAL" assets --include="*.json" --include="*.ts" --include="*.prefab"
```

---

## 2. [P1] 프리팹 하드코딩 텍스트 → Localization 컴포넌트 연결

하드코딩 영문이 다국어 전환 시 고정 노출되는 프리팹들. 각 Label 노드에 Localization 컴포넌트를 추가하고 key를 설정한다.

### 2-1. Localization 컴포넌트 미적용 — 신규 추가

**PopupShop.prefab**

| 하드코딩 텍스트 | 연결할 키 |
|---|---|
| "Shop" | `T_SHOP_TITLE` |
| "Most Popular" | `T_MOST_POPULAR` |
| "Best Value" | `T_BEST_VALUE` |
| "Free" | `T_FREE` |

**PopupMetaCityList.prefab**

| 하드코딩 텍스트 | 연결할 키 |
|---|---|
| "City Journey" | `T_CITY_LIST_TITLE` |

**PopupDecoShare.prefab**

| 하드코딩 텍스트 | 연결할 키 |
|---|---|
| "Share" | `T_SHARE` |

**PopupSettingLanguage.prefab**

| 하드코딩 텍스트 | 연결할 키 |
|---|---|
| "Select Language" | `T_LANGUAGE` |

**PopupSpecialOffer.prefab**

| 하드코딩 텍스트 | 연결할 키 |
|---|---|
| "Starter Pack" | `T_SPECIAL_OFFER_1_TITLE` |
| "Mega Value Pack" | `T_SPECIAL_OFFER_2_TITLE` |
| "City Builder Pack" | `T_SPECIAL_OFFER_3_TITLE` |

### 2-2. Localization 부분 적용 — 누락 Label 추가

**PopupMail.prefab**

| 하드코딩 텍스트 | 연결할 키 |
|---|---|
| "Inbox" | `T_INBOX_TITLE` |
| "Claim All" | `T_CLAIM_ALL` |

**PopupGameEntry.prefab**

| 하드코딩 텍스트 | 연결할 키 |
|---|---|
| "Level" | `T_LEVEL` |
| "Play" | `T_PLAY` |

**PopupDailyGift.prefab**

| 하드코딩 텍스트 | 연결할 키 |
|---|---|
| "Tap to Close" | `T_TAP_TO_CLOSE` |

**PopupDailyTask.prefab + DailyTaskItem.prefab**

| 하드코딩 텍스트 | 연결할 키 | 비고 |
|---|---|---|
| "Daily Task" | `T_DAILY_TASKS_TITLE` | |
| **"Calim"** | `T_CLAIM` | **오타. "Calim" 제거 → Localization 연결** |
| "Change" | `T_CHANGE` | |

### 2-3. ViewLobby.prefab

| 하드코딩 텍스트 | 연결할 키 |
|---|---|
| "Collect" | `T_COLLECT` |
| "Coins Bonus is ready!" | `T_COLLECT_INFO` |
| "Upgrade" | `T_UPGRADE` |
| "View" | `T_VIEW` |
| "All cities" | `T_ALL_CITY_TITLE` |
| "Max Level" | `T_MAX_LEVEL` |

### 적용 방법

1. Label 노드 선택 → `Add Component` → `Localization` 스크립트 추가
2. `key` 필드에 위 표의 키 입력
3. Label `string` 값은 빈 문자열로 설정 (런타임에 Localization이 덮어씀)

---

## 작업 완료 후 검증

```bash
# "Calim" 오타 잔존 확인 (0건이어야 함)
grep -r "Calim" assets --include="*.prefab" --include="*.ts"
```
