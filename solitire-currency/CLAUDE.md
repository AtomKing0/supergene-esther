# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Repository Purpose

게임 경제/밸런스 설계 분석 워크스페이스. 레퍼런스 게임(PST: Puzzle Solitaire Tripeaks, PBM: Puzzle Block Match) 데이터를 분석하여 우리 게임의 재화 시스템·수치 스키마를 설계한다.

## Directory Structure

- **`reference/`** — 레퍼런스 게임 원본 데이터. `PST_` 접두사는 PST 게임, `PBM_` 접두사는 PBM 게임 데이터. JSON 상수 파일 및 스크린샷 포함.
- **`workspace/`** — 에이전트 분석 산출물. `01_` ~ `04_` 번호 접두사로 Phase 구분.
  - `01_*` : PM 스키마 검수 (CP1 체크포인트)
  - `02_*` : 경제 밸런스 에이전트 리서치·결과
  - `03_*` : 게임 밸런스 에이전트 리서치·결과
  - `04_*` : 스키마 틀 정의 및 검증 규칙
- **`scripts/`** — 분석 Python 스크립트
- **`decompiled_java/`** — 디컴파일된 게임 에셋 (Unity Addressable catalog 포함)

## Analysis Scripts

```bash
# Unity Addressable 카탈로그 키워드 검색
python3 scripts/catalog_search.py KEYWORD
python3 scripts/catalog_search.py --economy    # 경제 관련 에셋 분류
python3 scripts/catalog_search.py --offers     # IAP/오퍼 에셋
python3 scripts/catalog_search.py --events     # 라이브 이벤트 에셋
python3 scripts/catalog_search.py --boosters   # 부스터 에셋
python3 scripts/catalog_search.py --folders    # 최상위 폴더 목록

# 특정 테마 심층 분석
python3 scripts/deep_dive.py betup       # Betup 배율 구조
python3 scripts/deep_dive.py onfire      # OnFire 단계
python3 scripts/deep_dive.py shop        # 숍 가격대
python3 scripts/deep_dive.py currency    # 재화 전체
python3 scripts/deep_dive.py summary     # 핵심 지표 대시보드
```

카탈로그 경로: `decompiled_java/resources/assets/aa/catalog.json`

## Multi-Agent Workflow

`agent_draft`에 정의된 5개 에이전트 조직:

| 에이전트 | 역할 |
|---|---|
| **01 PM** | KPI 적합성 및 구조 변경 승인, CP1 스키마 검수 |
| **02 경제 밸런스** | 레퍼런스 재화 흐름 분석, Source/Sink 설계, 수치 테이블 생성 |
| **03 게임 밸런스** | 난이도 곡선 분석, DDA/확률 설계, 레벨별 수치 테이블 |
| **04 스키마 검증** | 컬럼 정의, 범위 제한, CSV 스키마 설계 |
| **05 시스템 명세** | 밸런스 로직 → 계산식·상태 전이표 변환 |

작업 순서: 레퍼런스 분석 → 구조 추출 → 우리 게임 설계 → 실제 투입 수치 생성

## Google Sheet 수정 규칙 (07 에이전트 작업 기준) ⚠️ 필수

시트 수정 시 반드시 아래 3가지 절차를 **모두** 수행해야 완료로 간주한다. 하나라도 누락 시 **재작업**.

| 절차 | 규칙 | 기술 방법 |
|---|---|---|
| **① 원본 백업** ⚠️ 필수 | 수정 전 값을 **본 시트 데이터 끝 열에서 최소 열 1개 비운 다음** `Parameter │ Original │ Updated` 3열 구조로 기록. 구조: `[데이터 영역] │ [빈 열 ≥1] │ Parameter │ Original │ Updated`. 백업 저장 확인 전 수정 진행 절대 금지. | `batchUpdate` — `userEnteredValue.numberValue` 또는 `stringValue` |
| **② 하이라이트** ⚠️ 필수 | **수정된 모든 셀**에 반드시 배경색 적용. 누락 시 재작업. 수치 증가: 연두색, 수치 감소: 노란색, 구조 변경: 하늘색. 신규 행 추가: 연두색. | Sheets API `batchUpdate` + `repeatCell.userEnteredFormat.backgroundColor` |
| **③ 숫자 포맷** ⚠️ 필수 | 숫자 값은 반드시 `numberValue`(int/float)로 저장. apostrophe(`'`) 접두 문자열 절대 금지. | `update_cell(row, col, int(value))` 또는 `userEnteredValue.numberValue` |

**하이라이트 색상 코드:**
- 연두색 (Light Green, 증가·추가): `{"red": 0.85, "green": 0.93, "blue": 0.83}`
- 노란색 (Yellow, 감소): `{"red": 1.0, "green": 0.95, "blue": 0.6}`
- 하늘색 (Light Blue, 구조 변경): `{"red": 0.68, "green": 0.85, "blue": 0.90}`

---

## string_code 시트 번역 입력 규칙 ⚠️ 필수

번역 텍스트를 string_code 시트에 입력할 때, **JSON 파싱 에러를 유발하는 특수문자를 반드시 치환**한다.

| 금지 문자 | 유니코드 | 치환 대상 | 비고 |
|---|---|---|---|
| `"` (straight double quote) | U+0022 | `«»` (guillemets) 또는 제거 | JSON 값 구분자와 충돌 → 파싱 에러 |
| `\xa0` (NO-BREAK SPACE) | U+00A0 | 일반 스페이스 (U+0020) | 프랑스어에서 다량 혼입됨 |
| `—` (em-dash) | U+2014 | `-` (hyphen) | |
| `–` (en-dash) | U+2013 | `-` (hyphen) | |
| `№` (numero sign) | U+2116 | `#` | 러시아어에서 사용 |
| `\` (backslash) | U+005C | 제거 또는 이스케이프 | JSON 이스케이프 문자 |
| 제어 문자 | U+0000~U+001F | 제거 | 탭·개행 제외 |
| Zero-width 문자 | U+200B~U+200F, U+FEFF | 제거 | 보이지 않는 문자 |

**입력 후 검증**: 번역 입력 완료 후 반드시 아래 검사를 실행하여 0건 확인:

```python
# 전체 언어 컬럼 특수문자 검사
for i, row in enumerate(all_data[2:], 3):
    for col_idx in range(1, 10):
        val = row[col_idx] if len(row) > col_idx else ''
        for ch in val:
            cp = ord(ch)
            if cp in (0x22, 0xA0, 0x2014, 0x2013, 0x2116) or (cp < 0x20 and ch not in '\n\r\t') or cp in (0x200B, 0x200C, 0x200D, 0x200E, 0x200F, 0xFEFF):
                print(f'Row {i} col {col_idx}: U+{cp:04X} in {repr(val)}')
```

**사고 이력 (2026-03-25)**: 러시아어 `"Отменить"` (U+0022), 프랑스어 NBSP 55건, em-dash 다국어 7건 → ru.json 빌드 에러 발생. 전수 스캔 후 일괄 치환으로 해결.

---

## Git 브랜치 전략

모든 작업은 토픽 브랜치에서 진행하고, 완료 후 main에 머지한다.

| 브랜치 접두사 | 작업 범위 | 머지 시점 |
|---|---|---|
| `maps/*` | `solitaire-maps/` 맵 데이터 변환·수정 | QA 완료 후 |
| `economy/*` | `solitire-currency/` 밸런스 분석·시뮬레이션 | PM 검수(CP) 통과 후 |
| `locale/*` | `string_code/`, localization JSON | 시트 동기화 완료 후 |
| `docs/*` | `docs/`, `workspace/` 문서·보고서 | 즉시 머지 가능 |

### 규칙

- **main 직접 커밋 금지** — 반드시 토픽 브랜치에서 작업 후 머지
- **머지 방식**: `git merge --no-ff` (머지 커밋 생성하여 히스토리 보존)
- **체리픽 금지** — SHA 중복·히스토리 꼬임 방지. 반드시 머지 사용
- **브랜치명 예시**: `economy/gold-inflation`, `maps/schedule-week01`, `locale/ru-fix`
- **복수 영역 동시 변경 시**: 주요 작업 기준으로 브랜치 선택 (예: 경제 분석 중 문서 생성 → `economy/*`)

---

## Not-To-Do List

### 데이터 & 수치 생성
- **레퍼런스 없는 수치 제시 금지** — 감각이나 경험치 기반 수치를 근거로 제시하지 말 것
- **추정치를 확정값으로 표현 금지** — 레퍼런스 기반 추정은 반드시 "가설"로 명시
- **존재하지 않는 레퍼런스 인용 금지** — 확인되지 않은 출처를 인용하지 말 것
- **확률 테이블 합계 미검증 출력 금지** — PST 기준 10000 합계, `gacha_group_id`별 GROUP BY 검증 없이 출력하지 말 것

### 데이터 소스
- **`reference/PST_*.json` 스냅샷을 라이브 데이터로 취급 금지** — 라이브 데이터는 Google Sheet을 우선 참조
- **Google Sheet 없이 로컬 JSON만으로 수치 확정 금지** — 스냅샷은 구버전일 수 있음
- **스냅샷과 라이브가 다를 수 있는 확정 사례 (2026-03-11 기준):**

| const_name | 스냅샷값 | 라이브 확정값 |
|---|---|---|
| `idle_gold_amount_increase` | 1,200 | **400** |
| `idle_gold_max_cap` | 8,000 | **10,000** |
| `inbox_free_gold_amount` | 2,000 | **800** |
| `popup_free_gold_amount` | 2,000 | **800** |
| `gold_max_limit` | 10,000 | **20,000** |

### 작업 순서
- **레퍼런스 분석 없이 우리 게임 설계 수치 바로 생성 금지** — 순서: 레퍼런스 분석 → 구조 추출 → 설계 → 수치
- **CP1 스키마 검수(01 PM) 없이 하위 Phase 산출물 확정 금지**

### 출력 형식
- **자유형 텍스트로만 수치 출력 금지** — 출력은 markdown table 또는 CSV 입력 가능 형태로

### Google Sheet 데이터 저장
- **apostrophe prefix 전면 금지** — 숫자(`'123`)뿐 아니라 boolean(`'False'`, `'TRUE'`)·문자열 모든 타입에 apostrophe 접두 저장 금지. 반드시 numberValue(int/float) 또는 boolValue(True/False) 타입으로 저장
- **행 삽입 전 기존 데이터 확인 필수** — 중간 행 삽입 시 `update()` 단순 덮어쓰기 금지. 삽입 전 해당 위치 기존 데이터 존재 여부 확인 후 `insertDimension`으로 빈 행 생성 뒤 값 기입

### 경제 시뮬레이션 & 재화 구조
- **방치골드를 패시브 수입으로 모델링 금지** — 방치골드는 능동 수령 전용. 수령 후 4h 카운트 시작, 스택 없음(1회분 상한). "리텐션 유도 장치"로 분류
- **`gold_max_limit`을 지갑 상한으로 해석 금지** — 판당 최대 수령 골드량(20,000g). 플레이어 지갑 상한은 무제한
- **`interval_type=fixed` 부스터에 `use_count_increase_rate` 적용 금지** — fireworks/golden_ticket/wild_card는 `entry_cost_ratio`로만 가격 결정. ucir/ucmr = 0 유지
- **경제 시뮬레이션 수치를 스냅샷 기반으로 재사용 금지** — 시뮬레이션 재실행 시 반드시 Google Sheet 라이브값 재확인 후 적용

### Dynamic Level (DDA) 설계
- **DDA는 사후 반응형(reactive) 설계 — 플레이어 유형 사전 분류 금지** — dynamic_level은 플레이어 실력을 사전에 판별하지 않는다. 오직 관찰된 결과(연승/연패/경과 판수)로만 반응. 플레이어 유형(Hardcore/Casual 등)을 미리 분류하여 분포 목표를 다르게 설정하는 설계는 현재 엔진 구조와 맞지 않음.
- **유형별 동일 분포(85/10/5) 수렴은 의도된 결과** — 전 유형 ±1%p 수렴은 제약이 아니라 단일 파라미터 세트로 모든 유형을 커버하는 설계의 결과. "Hardcore에게 더 많은 Hard"를 분포 목표로 설정하지 말 것. (근거: ①Hard의 절대 난이도는 유저마다 다름 ②Hardcore는 hard_cooldown 재순환 속도가 빨라 이미 Hard를 유효하게 더 경험 ③Hard 비율 과다 시 전 유형 피로도 누적)
- **유형별 차등 분포 요청 → long_normal_run 조건 검토** — 고승률 유저의 Normal 과다 노출 문제는 `long_normal_run` 조건(P2 오픈 이슈)으로 접근. 롤링 승률 기반 hard_guarantee 조기 발동 방식. 실 서비스 승률 데이터 수집 후 v2 설계 진행.
- **85/10/5 목표는 결과지 입력값이 아님** — 시뮬레이션 검증 시 이 비율을 목표 분포로 참조하되, 파라미터 조정의 입력으로 역산하지 말 것. 파라미터 → 시뮬레이션 → 분포 확인 순서를 유지.

### 메타 도시 설계
- **해머 패턴 급등 설계 금지** — 신규 도시 그룹 해머 합계가 이전 그룹 대비 ×1.33 초과 금지. 기존 그룹 간 증가율(G1~G6: ×1.11~×1.25) 범위 내에서 설계. 초과 시 PM 재승인 필수
- **reward_1_amount 패턴 동결 금지** — 신규 도시 그룹의 reward_1_amount는 이전 그룹 대비 증가율 패턴(예: G6→G7 ×1.12) 적용 필수. 이전 그룹과 동일값 설정 금지
- **deco name_key string_code 등록 금지** — 데코레이션 name_key(`deco_*`)는 string_code 시트에 등록하지 않는다. 기존 모든 도시 패턴 동일 (도시명 key만 등록)
- **unlock 시트 별도 작업 금지** — meta_city_list의 `prev_city_id` 컬럼으로 언락 체인 처리됨. 별도 unlock 시트 항목 추가 불필요

## PST Reference Data — Google Sheet (주 데이터 소스)

**Spreadsheet ID:** `1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk`
**URL:** https://docs.google.com/spreadsheets/d/1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk
**인증:** `pst-agent-187157cdb8b7.json` (서비스 계정: `pst-agent@pst-agent.iam.gserviceaccount.com`)

`reference/PST_*.json` 파일들은 이 시트의 스냅샷이다. **라이브 데이터는 시트를 우선 참조.**

| 시트명 (gid) | 내용 |
|---|---|
| `const` (375222820) | 핵심 상수 (key_number 10001~, 1% = 100 단위) |
| `item_list` (1074709862) | 아이템 정의 (40001~40029) |
| `product` (1626427544) | IAP/AD 상품 |
| `difficulty_tier` (854311719) | 난이도 구간 정의 |
| `dynamic_level` (1439840956) | 동적 레벨 파라미터 |
| `daily_wheel` (550232648) | 데일리 휠 가챠 풀 (key 140001~140008) |
| `daily_gift` (1558739348) | 7일 출석 보상 스케줄 |
| `streak_reward` (1504157865) | 스트릭 보상 가챠 풀 |
| `event_schedule` (587625663) | 이벤트 스케줄 |
| `event_milestone` (1807743099) | 이벤트 마일스톤 단계 |

### 시트 읽기 코드 (Python)

```python
import gspread
from google.oauth2.service_account import Credentials

creds = Credentials.from_service_account_file(
    "pst-agent-187157cdb8b7.json",
    scopes=["https://www.googleapis.com/auth/spreadsheets.readonly"]
)
gc = gspread.authorize(creds)
sh = gc.open_by_key("1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk")
ws = sh.worksheet("const")  # 시트명으로 접근
rows = ws.get_all_records()  # 헤더 기준 dict 리스트
```

## PST 기획서 — Google Slides (주 문서)

**제목:** Agent-cowork [PST] Solitaire Tripeaks (108슬라이드)
**Presentation ID:** `1bNN3do-j5yUxzMSLfX6BhR9L2cKs9SfItmpe2c-QFP0`
**URL:** https://docs.google.com/presentation/d/1bNN3do-j5yUxzMSLfX6BhR9L2cKs9SfItmpe2c-QFP0
**인증:** 동일 서비스 계정 (`pst-agent-187157cdb8b7.json`)

| 섹션 | 슬라이드 범위 | 주요 내용 |
|---|---|---|
| 개요 | 4~6 | 게임 개요 |
| 게임 플로우 | 7~9 | NRU/RU 플로우 |
| 기본 룰 | 10~14 | 카드 구성, 기본 룰 |
| 재화 | 15~16 | 재화 구성, 재화 흐름도 |
| 로비 UI | 21~39 | 로비 탭, 팝업, 상점, 출석 |
| 인게임 | 41~54 | 인게임 UI, 부스터, 기믹 |
| 시스템 | 65~76 | 참가비/베팅, 난이도 티어, DDA, 스트릭미터, 콜렉션, 이벤트 |
| 수익화 | 92~96 | IAP 스페셜 오퍼, IAA |
| 대시보드 | 97~99 | KPI 대시보드 |

### 슬라이드 읽기 코드 (Python)

```python
from googleapiclient.discovery import build
from google.oauth2.service_account import Credentials

creds = Credentials.from_service_account_file(
    "pst-agent-187157cdb8b7.json",
    scopes=["https://www.googleapis.com/auth/presentations.readonly"]
)
service = build("slides", "v1", credentials=creds)
pres = service.presentations().get(
    presentationId="1bNN3do-j5yUxzMSLfX6BhR9L2cKs9SfItmpe2c-QFP0"
).execute()
slides = pres["slides"]  # 슬라이드 리스트
```

## Other Reference Files

| 파일 | 내용 |
|---|---|
| `reference/PBM_const.json` | PBM 핵심 상수 |
| `reference/PBM_difficulty_tier.json` | PBM 난이도 구간 정의 |
| `workspace/04_schema_template.md` | PST 재화 시스템 12개 테이블 스키마 틀 (최종 Go 판정) |
