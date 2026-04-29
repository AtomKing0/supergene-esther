# CLAUDE.md — Solitaire City Journey (esther-1)

이 파일은 `solitaire-esther-1` 레포 전체에 대한 Claude Code 가이드입니다.

---

## 레포 구조

```
solitaire-esther-1/
├── assets/                  # 게임 에셋 리소스
│   ├── audio/               # 원본 오디오 라이브러리 (카테고리별, 468개)
│   ├── audio_selected/      # 게임 사용 확정 오디오 (75개 WAV)
│   └── images/              # 덱 이미지, 배경, 앱 아이콘
│
├── content/                 # 게임 텍스트/콘텐츠 데이터
│   ├── localization/        # 다국어 현지화 (20개 언어 txt, CustomTags.json)
│   └── push_messages/       # 푸시 알림 메시지 CSV + 생성 스크립트
│
├── marketing/               # 비즈니스/마케팅 문서
│   ├── SolitaireCityJourney_Pitch.pptx
│   └── AdPlacementID.csv    # Meta(Facebook) 광고 배치 ID 21개
│
├── docs/                    # 기획 문서
│   ├── tutorial_plan.html   # PST 튜토리얼 기획서
│   ├── icon_list.html       # 아이콘 목록
│   ├── references/          # 참고 자료 (freeplay report 등)
│   ├── TUTO_GIF/            # 튜토리얼 GIF/PNG 소재
│   ├── DEPLOY_tutorial_engineer.md
│   └── DEPLOY_tutorial_qa.md
│
├── solitaire-maps/          # 맵 데이터 서브프로젝트
│   └── → solitaire-maps/CLAUDE.md 참조
│
└── solitaire-currency/      # 경제/밸런스 설계 서브프로젝트
    └── → solitaire-currency/CLAUDE.md 참조
```

---

## 서브프로젝트 개요

### solitaire-maps/
CC(Candy Crush) 게임 맵 데이터를 우리 게임(solitaire-tripeaks-client) 포맷으로 변환·관리하는 프로젝트.

- **주요 데이터:** 3,950개 레벨 맵, 15주차 스케줄(1,200개)
- **변환 스크립트:** `solitaire-maps/tutorial_data/convert_cc_to_our.py`
- **에이전트:** `map-pm`, `map-fixer`, `map-checker`, `difficulty-judge`, `difficulty-tier-simulator`
- **상세 문서:** `solitaire-maps/CLAUDE.md`

### solitaire-currency/
레퍼런스 게임(PST, PBM) 데이터 분석 기반 재화 시스템·밸런스 설계 워크스페이스.

- **데이터 소스:** Google Sheets (PST 라이브 시트), `reference/PST_*.json` (스냅샷)
- **에이전트:** 11개 (01_pm ~ 10_code_review, orchestrator)
- **인증:** `solitaire-currency/pst-agent-187157cdb8b7.json` (GCP 서비스 계정)
- **상세 문서:** `solitaire-currency/CLAUDE.md`

---

## 에이전트 조직

### Root 레벨 에이전트 (`.claude/agents/`) — 맵 전용

| 에이전트 | 역할 |
|---|---|
| `map-pm` | 맵 작업 총괄 관리자. map-checker → map-fixer → 재검증 파이프라인 운영 |
| `map-checker` | 맵 JSON 유효성 검증 (depth, height, clearCount, symbol 등) |
| `map-fixer` | 맵 오류 수정 (depth 정규화, y-centering, clearRandomCardCount 등) |
| `difficulty-judge` | 맵 실제 난이도 수치 분석 (카드 수 + max_depth + 숨긴 카드 비율) |
| `difficulty-tier-simulator` | difficulty_tier score_min/max 경계값 시뮬레이션 검증 |
| `collision-checker` | 카드 OBB 충돌·크로스파일 블로킹 검증 (check_collision.py, SAT margin=2) |

### solitaire-currency 레벨 에이전트 (`solitaire-currency/.claude/agents/`) — 경제 전용

| 에이전트 | 역할 |
|---|---|
| `01_pm` | KPI 적합성 통제, CP1 스키마 검수 |
| `02_economic_balance` | 레퍼런스 재화 흐름 분석, Source/Sink 설계 |
| `03_game_balance` | 난이도 곡선 분석, DDA/확률 설계 |
| `04_schema_validation` | 컬럼 정의, 범위 제한, CSV 스키마 |
| `05_system_spec` | 밸런스 로직 → 계산식·상태 전이표 변환 |
| `06_simulation` | 재화 흐름 시뮬레이션 |
| `07_sheet_modifier` | 에이전트 시트 수정 전담 |
| `08_content_team` | 메타 도시·데코레이션 콘텐츠 기획 |
| `09_sheet_sync` | 에이전트 시트 → 라이브 시트 동기화 |
| `10_code_review` | 코딩 산출물 품질 검수 |
| `11_translation` | string_code 번역 전담 (신규 키 번역·일관성 검사·특수문자 검증 → 07 인계) |
| `orchestrator` | 멀티 에이전트 팀 런북 |

---

## 브랜치 전략

| 브랜치 접두사 | 작업 범위 | 머지 시점 |
|---|---|---|
| `maps/*` | `solitaire-maps/` 맵 데이터 변환·수정 | QA 완료 후 |
| `economy/*` | `solitaire-currency/` 밸런스 분석·시뮬레이션 | PM 검수(CP) 통과 후 |
| `locale/*` | `content/localization/` localization JSON | 시트 동기화 완료 후 |
| `docs/*` | `docs/`, `solitaire-currency/workspace/` 문서·보고서 | 즉시 머지 가능 |

**규칙:**
- main 직접 커밋 금지 — 토픽 브랜치 후 머지
- 머지 방식: `git merge --no-ff`
- cherry-pick 금지 (히스토리 꼬임 방지)

**Remote:**
- `origin` → `AtomKing0/solitaire-esther` (메인 레포)
- `supergene` → `AtomKing0/supergene-esther` (협력 팀 레포)

---

## 환경 설정

- 환경 변수: `.env` (`.gitignore`에 포함 — 커밋 금지)
- GCP 인증: `solitaire-currency/pst-agent-187157cdb8b7.json` (커밋 금지)

---

## NOT-TO-DO

- **`.env` 커밋 금지** — Meta 광고 ID, GCP 키 포함
- **main 직접 푸시 금지**
- **`solitaire-currency/.claude/CLAUDE.md` 재생성 금지** — 이 파일은 삭제된 상태가 올바름 (`solitaire-currency/CLAUDE.md`가 정식 문서)
- **`assets/audio/` 원본 커밋 금지** — 대용량, `.gitignore`에 포함
