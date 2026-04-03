# PST 튜토리얼 플로우 설계

> **작성일**: 2026-03-13
> **레퍼런스**: Candy Crush Solitaire (King, 2025-02-06 글로벌 출시)
> **기획서 연동**: 슬라이드 80~83 (현재 미완성, 3/23 구현 착수 예정)
> **상태**: 설계안 — PM 검토 필요

---

## 1. 설계 원칙

### 1.1 CCS 레퍼런스에서 차용한 원칙

| # | 원칙 | CCS 근거 | PST 적용 |
|---|------|----------|----------|
| P1 | **즉시 플레이** | ToS 후 바로 Lv 1 진입, 로비 스킵 | NRU 첫 진입 시 즉시 튜토리얼 맵 시작 |
| P2 | **비간섭 가이드** | 올바른 행동 시 중단 없음, 틀리면 즉각 피드백 | 핸드 가이드는 대기/오류 시에만 개입 |
| P3 | **기본 메카닉 숙달 우선** | Lv 22까지 장애물 없이 카드 매칭만 | Lv 1~8 Tutorial 티어에서 기본만 학습 |
| P4 | **단계적 복잡도 도입** | 메타 피처를 Lv 4~75까지 점진 해금 | unlock 시트 20개 항목 순차 해금 유지 |
| P5 | **보상으로 학습 강화** | 레벨 클리어마다 코인+에너지 즉시 지급 | 튜토리얼 중 골드+해머 즉시 지급 확인 |

### 1.2 PST 고유 설계 원칙

| # | 원칙 | 근거 |
|---|------|------|
| G1 | **베팅 시스템 = 핵심 차별점** | CCS의 Hold Slot에 해당. Lv 3에서 x1 해금 시 별도 가이드 필수 |
| G2 | **해머 = 메타 루프 연결고리** | 레벨 클리어 → 해머 획득 → 도시 꾸미기. CCS의 Energy → Postcard와 동일 구조 |
| G3 | **8판 이내 코어 루프 완결** | CCS는 Lv 1~3에서 코어 완결. PST는 Lv 1~2 코어 매칭 + Lv 3~5 베팅·부스터·스트릭까지 5판 내 코어 루프 완결 목표 |
| G4 | **기믹 도입은 Lv 10부터** | CCS Lv 22 대비 빠르나, Tutorial 티어(Lv 8) 이후 Normal 전환(Lv 9~10) 후 기믹 시작. 충분한 숙달 시간 확보 |

---

## 2. 튜토리얼 Phase 구조

### Phase 0: 즉시 진입 (Lv 1)

**목표**: 카드 매칭 기본 규칙 학습. 첫 판 성공 경험.

```
[앱 실행] → [ToS/알림] → [즉시 Lv 1 맵 진입 (로비 스킵)]
```

| 스텝 | 학습 내용 | 가이드 방식 | 보상 |
|------|-----------|-------------|------|
| S1-1 | 게임 화면 구성 소개 | 딤 배경 + 버블 설명 (필드, 드로우덱, 오픈 카드 위치) | — |
| S1-2 | 카드 매칭 규칙 (±1) | 매칭 가능 카드 하이라이트 + 탭 유도 화살표 | — |
| S1-3 | 드로우덱 사용 | 매칭 가능 카드 없을 때 드로우덱 하이라이트 + 탭 유도 | — |
| S1-4 | 모든 카드 제거 | 자유 플레이 (가이드 해제) | — |
| S1-5 | 클리어 연출 + 결과 화면 | 골드 획득 강조 + "잘했어요!" 피드백 | 골드 1,000g + 해머 1개 |

**맵 요건**: Tutorial_0001 (필드 13장, 드로우 1장) — 매우 쉬움
**Tutorial 티어 혜택**: help_card_rate 80%, pity_trigger 3회

### Phase 1: 로비 학습 + 방치 골드 (Lv 2)

**목표**: 로비 UI 인지, 도시 꾸미기 첫 경험, 방치 골드 인지

```
[Lv 1 클리어] → [로비 최초 진입] → [도시 꾸미기 유도] → [Lv 2 진입]
```

| 스텝 | 학습 내용 | 가이드 방식 | 보상 |
|------|-----------|-------------|------|
| S2-1 | 로비 화면 구성 | 딤 배경 + 주요 버튼 순차 하이라이트 (도시, 플레이, 태스크) | — |
| S2-2 | 도시 꾸미기 첫 경험 | 해머 아이콘 하이라이트 → 건물 업그레이드 유도 | 건물 1단계 완성 |
| S2-3 | 다시 플레이 유도 | "더 많은 해머를 모아보세요" + 플레이 버튼 하이라이트 | — |
| S2-4 | Lv 2 플레이 | 가이드 없이 자유 플레이 (help_card 80% 유지) | 골드 1,000g + 해머 1개 |
| S2-5 | 방치 골드 안내 | 로비 복귀 시 방치 골드 팝업 안내 (unlock Lv 2, show_tutorial=True) | — |

**맵 요건**: Tutorial_0002 (필드 10장, 드로우 7장) — 쉬움

### Phase 2: 베팅 시스템 + 부스터 도입 (Lv 3~4)

**목표**: 참가비 시스템 이해, 언두 부스터 학습, pre-레벨 팝업 인지

```
[Lv 2 클리어] → [Lv 3 pre-레벨 팝업 최초 노출] → [베팅 x1 선택] → [인게임]
```

| 스텝 | 학습 내용 | 가이드 방식 | 보상 |
|------|-----------|-------------|------|
| S3-1 | pre-레벨 팝업 | 딤 배경 + 팝업 구성요소 하이라이트 (난이도 표시, 베팅 선택, 부스터 슬롯) | — |
| S3-2 | 베팅 x1 설명 | 버블: "참가비를 걸고 플레이! 클리어하면 더 많은 보상!" + x1 버튼 하이라이트 | — |
| S3-3 | 상점 해금 안내 | 로비 상점 아이콘 하이라이트 (unlock Lv 3, show_tutorial=False → 자연 노출) | — |
| S3-4 | 언두 부스터 해금 | 인게임에서 실수 발생 시(또는 3턴 경과 후) 언두 버튼 하이라이트 + 버블 설명 | — |
| S3-5 | Lv 4 자유 플레이 | 가이드 최소화, 베팅 선택만 확인 | 골드 + 해머 |

**핵심**: 베팅 시스템은 PST의 킬러 피처. CCS의 Hold Slot(Lv 11)과 달리 Lv 3에서 조기 도입하되, x1(리스크 최소) 부터 시작.

### Phase 3: 스트릭 + 프리레벨 부스터 (Lv 5~7)

**목표**: 스트릭 콤보 보상 루프 학습, 그랜드 파이어웍스 첫 경험

```
[Lv 5 진입] → [스트릭 미터 최초 노출] → [인게임 스트릭 달성] → [보상 획득]
```

| 스텝 | 학습 내용 | 가이드 방식 | 보상 |
|------|-----------|-------------|------|
| S5-1 | 스트릭 미터 소개 | 인게임 첫 2연속 매칭 시 스트릭 게이지 하이라이트 + 버블: "연속으로 카드를 제거하면 보상!" | — |
| S5-2 | 스트릭 보상 획득 | 스트릭 완료 시 보상 연출 강조 | 스트릭 보상 (골드/와일드/플러스) |
| S5-3 | 스트릭 스타 설명 | 로비 복귀 시 스트릭 스타 표시 + 버블: "스트릭 스타로 랭킹 경쟁!" | — |
| S5-4 | 그랜드 파이어웍스 해금 | Lv 5 pre-레벨 팝업에서 부스터 슬롯 하이라이트 + 파이어웍스 설명 | 무료 파이어웍스 1회 |
| S5-5 | 파이어웍스 체험 | Lv 5에서 무료 체험 (장착 후 앞열 카드 전체 제거 연출) | — |

**핵심**: 스트릭 = 인게임 보상 루프의 핵심. CCS의 스트릭 미터와 동일 역할. 무료 부스터 1회로 "맛보기" 제공.

### Phase 4: 컬렉션 + 골든 티켓 (Lv 8)

**목표**: 컬렉션 앨범 시스템 인지, 골든 티켓 부스터 첫 경험, Tutorial 티어 졸업

```
[Lv 8 클리어] → [컬렉션 앨범 해금 팝업] → [퍼즐 피스 획득 확인] → [Tutorial 졸업]
```

| 스텝 | 학습 내용 | 가이드 방식 | 보상 |
|------|-----------|-------------|------|
| S8-1 | 컬렉션 앨범 해금 | 해금 팝업: "게임을 클리어하면 퍼즐 피스를 모을 수 있어요!" + 앨범 미리보기 | — |
| S8-2 | 퍼즐 피스 드롭 설명 | 버블: "베팅 배수가 높을수록 더 많은 피스!" (x1=1장, x2=3장, x4=5장) | — |
| S8-3 | 골든 티켓 해금 | pre-레벨 팝업에서 골든 티켓 슬롯 하이라이트 + 설명 | 무료 골든 티켓 1회 |
| S8-4 | 골든 티켓 체험 | Lv 8에서 무료 체험 (와일드 카드 3장 배치 확인) | — |
| S8-5 | Tutorial 티어 졸업 | 결과 화면에서 "이제 본격적인 도전이 시작됩니다!" 메시지 | — |

**핵심**: Lv 8 이후 dynamic_level이 Normal(Lv 9~10)로 전환. help_card_rate 80% → 50% 하락. 골든 티켓 체험으로 "어려워질 때 부스터가 도움된다" 인지.

### Phase 5: Normal 전환 + 전략 확장 (Lv 9~14)

**목표**: Normal 난이도 적응, 고급 시스템 점진적 해금

| 레벨 | 해금 콘텐츠 | 가이드 방식 |
|------|-------------|-------------|
| Lv 9~10 | Normal 고정 (DDA 없음) | 난이도 상승 알림 없음 (자연스러운 전환) |
| Lv 10 | 베팅 x2 + 와일드 카드 + 플러스카드 기믹 | 각 해금 팝업 (show_tutorial=True) |
| Lv 11+ | DDA 시스템 활성화 | 안내 없음 (백그라운드 작동) |
| Lv 12 | 이벤트 2종 (컬러 수집, 스탬프 투어) | 해금 팝업 + 이벤트 탭 하이라이트 |

**핵심**: Lv 10에서 3개 해금이 동시에 발생하므로 **순차 팝업** 처리 필요. 팝업 순서: 기믹(플러스카드) → 부스터(와일드) → 베팅(x2)

### Phase 6: 심화 콘텐츠 (Lv 15~35)

| 레벨 | 해금 콘텐츠 | 가이드 방식 |
|------|-------------|-------------|
| Lv 15 | 엑스트라 덱 + 러너 카드 | 각 해금 팝업 |
| Lv 20 | 베팅 x4 + 랭킹 레이스 | 해금 팝업 + 랭킹 탭 하이라이트 |
| Lv 25 | 밧줄 카드 | 첫 등장 맵에서 인게임 가이드 |
| Lv 35 | 자물쇠 & 열쇠 | 첫 등장 맵에서 인게임 가이드 |

---

## 3. CCS vs PST 튜토리얼 비교표

| 항목 | CCS | PST (설계안) | 비고 |
|------|-----|-------------|------|
| 코어 튜토리얼 | Lv 1~3 (3판) | Lv 1~2 (2판) | PST는 규칙이 더 단순 (Hold Slot 없음) |
| 첫 메타 해금 | Lv 4 (Idle Earning) | Lv 2 (방치 골드) | PST가 1판 빠름 |
| 킬러 피처 소개 | Lv 11 (Hold Slot) | Lv 3 (베팅 x1) | PST 조기 도입 (리스크 최소화된 x1부터) |
| 첫 부스터 | Lv 11+ [추정] | Lv 3 (언두) | PST가 훨씬 빠름 |
| 첫 프리레벨 부스터 | 불명확 | Lv 5 (파이어웍스) | 무료 체험 1회 제공 |
| 콤보/스트릭 | Lv 1~ (내장) | Lv 5 (해금) | CCS는 기본, PST는 해금형 |
| 수집 시스템 | Lv 28 (앨범) | Lv 8 (컬렉션) | PST가 20판 빠름 |
| 첫 기믹/장애물 | Lv 22 | Lv 10 (플러스카드) | PST가 12판 빠르나, 플러스카드는 방해형 아닌 보조형 |
| 첫 방해형 기믹 | Lv 22 (Chocolate) | Lv 15 (러너) 또는 Lv 25 (밧줄) | PST도 방해형 기믹은 충분히 늦게 도입 |
| 보너스 레벨 | Lv 9~ (실패불가) | — | PST에는 해당 기능 없음 |
| Tutorial 티어 종료 | Lv 11 [추정] | Lv 8 (→ Normal 전환) | 유사 |
| 전체 해금 완료 | Lv 75 | Lv 35 | PST가 콘텐츠 규모 작으나 집약적 |

---

## 4. 인게임 가이드 UI 명세

### 4.1 가이드 컴포넌트

CCS 참조하여 PST에 필요한 가이드 UI 컴포넌트 4종:

| 컴포넌트 | 설명 | 사용 시점 |
|----------|------|-----------|
| **Bubble (버블)** | 말풍선 텍스트. 캐릭터 없이 화면 하단 또는 대상 근처에 표시 | 새 메카닉/시스템 설명 |
| **Highlight (하이라이트)** | 딤 배경(반투명 검정) + 대상 UI 요소 강조 | 특정 행동 유도 (탭 대상 지정) |
| **Arrow (화살표)** | 탭 유도 애니메이션 화살표 | 매칭 가능 카드, 드로우덱 탭 유도 |
| **Feedback (피드백)** | 잘못된 행동 시 대상 흔들기 + 올바른 카드 깜빡임 | 오류 발생 시 즉각 안내 |

### 4.2 가이드 동작 규칙

| 규칙 | 설명 |
|------|------|
| **비간섭 원칙** | 플레이어가 올바르게 행동하면 가이드 미노출. 대기 3초 또는 오류 시에만 개입 |
| **단계적 해제** | Phase 0 (Lv 1): 풀 가이드 → Phase 1 (Lv 2): 로비 가이드만 → Phase 2+ (Lv 3+): 해금 팝업만 |
| **스킵 불가** | 튜토리얼 Phase 0~1 (Lv 1~2)은 스킵 불가. Phase 2+ 해금 팝업은 닫기 버튼 허용 |
| **타임아웃 가이드** | 인게임에서 5초 이상 행동 없으면 매칭 가능 카드 하이라이트 (Lv 1~8 Tutorial 티어에서만) |

---

## 5. 해금 팝업 UI 명세

### 5.1 팝업 구조 (공통)

```
┌─────────────────────────────────┐
│  [아이콘]  해금 타이틀           │
│                                 │
│  ┌───────────────────────────┐  │
│  │  기능 설명 이미지/GIF     │  │
│  └───────────────────────────┘  │
│                                 │
│  설명 텍스트 (1~2줄)            │
│                                 │
│  [확인 버튼]                    │
└─────────────────────────────────┘
```

### 5.2 해금별 팝업 내용

| 해금 | string_code (제안) | 타이틀 | 설명 텍스트 | 아이콘 |
|------|-------------------|--------|-------------|--------|
| 방치 골드 (Lv 2) | `T_TUT_IDLE_GOLD_TITLE` / `T_TUT_IDLE_GOLD_DESC` | 방치 보상 | "시간이 지나면 골드를 받을 수 있어요! 자주 접속해서 수령하세요." | 골드 아이콘 |
| pre-레벨 팝업 (Lv 3) | — | — | 인라인 가이드 (별도 팝업 없음, pre-레벨 화면에서 직접 가이드) | — |
| 베팅 x1 (Lv 3) | `T_TUT_BETTING_TITLE` / `T_TUT_BETTING_DESC` | 베팅 시스템 | "골드를 걸고 도전! 클리어하면 더 큰 보상을 받아요." | 베팅 아이콘 |
| 언두 (Lv 3) | `T_TUT_UNDO_TITLE` / `T_TUT_UNDO_DESC` | 되돌리기 | "실수했다면 되돌리기! 이전 행동을 취소할 수 있어요." | 언두 아이콘 |
| 스트릭 (Lv 5) | `T_TUT_STREAK_TITLE` / `T_TUT_STREAK_DESC` | 연속 콤보 | "카드를 연속으로 제거하면 특별 보상! 덱을 사용하면 초기화됩니다." | 스트릭 아이콘 |
| 파이어웍스 (Lv 5) | `T_TUT_FIREWORKS_TITLE` / `T_TUT_FIREWORKS_DESC` | 그랜드 파이어웍스 | "시작할 때 앞줄 카드를 모두 제거! 무료로 한 번 체험해 보세요." | 파이어웍스 아이콘 |
| 컬렉션 (Lv 8) | `T_TUT_COLLECTION_TITLE` / `T_TUT_COLLECTION_DESC` | 컬렉션 앨범 | "게임을 클리어하면 퍼즐 피스를 모을 수 있어요! 앨범을 완성해 보세요." | 앨범 아이콘 |
| 골든 티켓 (Lv 8) | `T_TUT_GOLDEN_TITLE` / `T_TUT_GOLDEN_DESC` | 골든 티켓 | "와일드 카드 3장이 게임판에! 어떤 카드와도 매칭됩니다." | 골든 티켓 아이콘 |
| 베팅 x2 (Lv 10) | `T_TUT_BETTING2_TITLE` / `T_TUT_BETTING2_DESC` | 베팅 x2 해금 | "2배 베팅 해금! 더 높은 위험, 더 큰 보상. 퍼즐 피스도 3배!" | 베팅 x2 아이콘 |
| 와일드 카드 (Lv 10) | `T_TUT_WILD_TITLE` / `T_TUT_WILD_DESC` | 와일드 카드 | "어떤 카드와도 매칭되는 만능 카드! 어려울 때 사용하세요." | 와일드 아이콘 |
| 플러스 카드 (Lv 10) | `T_TUT_PLUS_TITLE` / `T_TUT_PLUS_DESC` | 플러스 카드 | "터치하면 덱에 카드가 추가됩니다! 새로운 기믹을 만나보세요." | 플러스 아이콘 |
| 이벤트-컬러 (Lv 12) | `T_TUT_EVENT_COLOR_TITLE` / `T_TUT_EVENT_COLOR_DESC` | 컬러 수집 이벤트 | "특별 이벤트 시작! 게임 중 컬러 아이템을 모아 보상을 받으세요." | 이벤트 아이콘 |
| 이벤트-스탬프 (Lv 12) | `T_TUT_EVENT_STAMP_TITLE` / `T_TUT_EVENT_STAMP_DESC` | 스탬프 투어 | "스탬프를 모아 여행을 완성하세요! 마일스톤 보상이 기다립니다." | 스탬프 아이콘 |
| 엑스트라 덱 (Lv 15) | `T_TUT_EXTRA_DECK_TITLE` / `T_TUT_EXTRA_DECK_DESC` | 엑스트라 덱 | "덱이 비었어도 포기하지 마세요! 추가 카드를 보충할 수 있어요." | 엑스트라 덱 아이콘 |
| 러너 카드 (Lv 15) | `T_TUT_RUNNER_TITLE` / `T_TUT_RUNNER_DESC` | 러너 카드 | "매 턴 숫자가 변하는 카드! 타이밍을 잘 맞춰 제거하세요." | 러너 아이콘 |
| 베팅 x4 (Lv 20) | `T_TUT_BETTING4_TITLE` / `T_TUT_BETTING4_DESC` | 베팅 x4 해금 | "최대 베팅 해금! 4배 참가비에 4배 보상. 퍼즐 피스 5배!" | 베팅 x4 아이콘 |
| 랭킹 레이스 (Lv 20) | `T_TUT_RACE_TITLE` / `T_TUT_RACE_DESC` | 랭킹 레이스 | "다른 플레이어와 경쟁! 스트릭 스타를 모아 순위를 올리세요." | 레이스 아이콘 |
| 밧줄 카드 (Lv 25) | `T_TUT_ROPE_TITLE` / `T_TUT_ROPE_DESC` | 밧줄 카드 | "밧줄로 묶인 카드! 여러 번 매칭해서 풀어주세요." | 밧줄 아이콘 |
| 자물쇠 & 열쇠 (Lv 35) | `T_TUT_LOCK_TITLE` / `T_TUT_LOCK_DESC` | 자물쇠 & 열쇠 | "같은 색 열쇠로 자물쇠를 열어요! 열쇠 카드를 먼저 찾으세요." | 자물쇠 아이콘 |

---

## 6. 튜토리얼 보상 설계

### 6.1 튜토리얼 구간 보상 (Lv 1~8)

| 레벨 | 기본 보상 | 추가 보상 (해금) | 누적 골드 | 비고 |
|------|-----------|-----------------|-----------|------|
| 시작 | — | NRU 시작 골드 2,000g | 2,000g | const: nru_start_gold |
| Lv 1 | 골드 1,000g + 해머 1개 | — | 3,000g | const: level_1_base_reward |
| Lv 2 | 골드 1,000g + 해머 1개 | 방치 골드 안내 | 4,000g | const: level_2_base_reward |
| Lv 3 | 표준 보상 + 해머 1개 | 베팅 x1 시작 (참가비 발생) | ~4,500g | 참가비 차감 시작 |
| Lv 4 | 표준 보상 + 해머 1개 | — | ~5,000g | |
| Lv 5 | 표준 보상 + 해머 1개 | 무료 파이어웍스 1회 | ~5,500g | 부스터 체험 |
| Lv 6 | 표준 보상 + 해머 1개 | — | ~6,000g | |
| Lv 7 | 표준 보상 + 해머 1개 | — | ~6,500g | |
| Lv 8 | 표준 보상 + 해머 1개 | 무료 골든 티켓 1회 | ~7,000g | 부스터 체험 + Tutorial 졸업 |

### 6.2 무료 부스터 체험 정책

| 부스터 | 무료 제공 시점 | 목적 |
|--------|--------------|------|
| 그랜드 파이어웍스 | Lv 5 (해금 직후) | 프리레벨 부스터 체험 → 유료 사용 유도 |
| 골든 티켓 x3 | Lv 8 (해금 직후) | 프리레벨 부스터 체험 → 유료 사용 유도 |
| 언두 | Lv 3 (해금, 첫 1회 무료) | 인게임 부스터 체험 → 유료 사용 유도 |

**CCS 참조**: CCS도 Free Entrance Booster(실패 후 5분 무료 재도전) 등으로 부스터 맛보기를 제공하여 첫 구매 허들을 낮춤.

---

## 7. 튜토리얼 맵 배정 (Lv 1~8)

### 7.1 맵 배정 원칙

dynamic_level 시트에서 Lv 1~8은 Tutorial 티어(tier_id=1) 맵을 순차 제공한다.
36개 튜토리얼 맵 중 **8개를 선택하여 Lv 1~8에 순차 매핑**해야 한다.

### 7.2 제안 배정표

난이도 점진 상승 기준으로 필드카드 수 오름차순 배정:

| 플레이 레벨 | 배정 맵 | 필드카드 | 드로우카드 | 총카드 | 선정 근거 |
|------------|---------|---------|-----------|--------|-----------|
| Lv 1 | Tutorial_0351 | 6 | 3 | 9 | 최소 구성, 첫 판 확실한 성공 |
| Lv 2 | Tutorial_0701 | 6 | 6 | 12 | 드로우 사용 학습 |
| Lv 3 | Tutorial_0036 | 6 | 5 | 11 | 베팅 첫 경험 (쉬운 맵) |
| Lv 4 | Tutorial_0002 | 10 | 7 | 17 | 카드 수 증가, 자유도 상승 |
| Lv 5 | Tutorial_0026 | 10 | 3 | 13 | 스트릭 연습 (적은 드로우 → 연속 매칭 유도) |
| Lv 6 | Tutorial_0001 | 13 | 1 | 14 | 중급 맵 |
| Lv 7 | Tutorial_0005 | 14 | 5 | 19 | 본격 크기 맵 |
| Lv 8 | Tutorial_0008 | 14 | 7 | 21 | Tutorial 졸업 맵 |

**원칙**: 필드카드 6장 → 6장 → 6장 → 10장 → 10장 → 13장 → 14장 → 14장 (점진 상승)

### 7.3 잔여 맵 (28개) 활용

Lv 1~8에 배정되지 않은 28개 튜토리얼 맵은:
- **현재 Tutorial 티어가 Lv 1~8만 대상**이므로, 잔여 맵은 Schedule 풀에 편입하거나 별도 활용 검토 필요
- 가설: 원본 레퍼런스 게임(GSN Tripeaks)에서는 더 많은 튜토리얼 레벨이 있었을 수 있음

---

## 8. string_code 추가 항목 (시트 입력용)

### 8.1 인게임 튜토리얼 텍스트 (Lv 1~2)

| key_number | string_key | ko | en |
|------------|-----------|-----|-----|
| 신규 | `T_TUT_MATCH_TITLE` | 카드 매칭 | Card Matching |
| 신규 | `T_TUT_MATCH_DESC` | 현재 카드보다 1 높거나 낮은 카드를 터치하세요! | Tap a card that is 1 higher or lower! |
| 신규 | `T_TUT_DRAW_TITLE` | 드로우 덱 | Draw Deck |
| 신규 | `T_TUT_DRAW_DESC` | 맞는 카드가 없으면 덱에서 새 카드를 뽑으세요! | No matching cards? Draw a new one! |
| 신규 | `T_TUT_CLEAR_TITLE` | 스테이지 클리어! | Stage Clear! |
| 신규 | `T_TUT_CLEAR_DESC` | 잘했어요! 골드와 해머를 획득했습니다. | Great job! You earned Gold and Hammers. |

### 8.2 로비 튜토리얼 텍스트 (Lv 2)

| key_number | string_key | ko | en |
|------------|-----------|-----|-----|
| 신규 | `T_TUT_LOBBY_CITY` | 해머로 도시를 꾸며보세요! | Decorate the city with Hammers! |
| 신규 | `T_TUT_LOBBY_PLAY` | 더 많은 해머를 모아보세요! | Collect more Hammers! |

### 8.3 해금 팝업 텍스트 (20개 해금 항목)

상기 섹션 5.2의 표에 정의된 `T_TUT_*_TITLE` / `T_TUT_*_DESC` 쌍.
총 36개 string_key (18개 TITLE + 18개 DESC).

---

## 9. Google Sheet 입력 데이터

### 9.1 string_code 시트 추가 행 (44개)

```csv
key_number,string_key,ko,en
[auto],T_TUT_MATCH_TITLE,카드 매칭,Card Matching
[auto],T_TUT_MATCH_DESC,현재 카드보다 1 높거나 낮은 카드를 터치하세요!,Tap a card that is 1 higher or lower!
[auto],T_TUT_DRAW_TITLE,드로우 덱,Draw Deck
[auto],T_TUT_DRAW_DESC,맞는 카드가 없으면 덱에서 새 카드를 뽑으세요!,No matching cards? Draw a new one!
[auto],T_TUT_CLEAR_TITLE,스테이지 클리어!,Stage Clear!
[auto],T_TUT_CLEAR_DESC,잘했어요! 골드와 해머를 획득했습니다.,Great job! You earned Gold and Hammers.
[auto],T_TUT_LOBBY_CITY,해머로 도시를 꾸며보세요!,Decorate the city with Hammers!
[auto],T_TUT_LOBBY_PLAY,더 많은 해머를 모아보세요!,Collect more Hammers!
[auto],T_TUT_IDLE_GOLD_TITLE,방치 보상,Idle Reward
[auto],T_TUT_IDLE_GOLD_DESC,시간이 지나면 골드를 받을 수 있어요! 자주 접속해서 수령하세요.,Earn Gold over time! Log in often to collect.
[auto],T_TUT_BETTING_TITLE,베팅 시스템,Betting System
[auto],T_TUT_BETTING_DESC,골드를 걸고 도전! 클리어하면 더 큰 보상을 받아요.,Bet Gold and play! Clear for bigger rewards.
[auto],T_TUT_UNDO_TITLE,되돌리기,Undo
[auto],T_TUT_UNDO_DESC,실수했다면 되돌리기! 이전 행동을 취소할 수 있어요.,Made a mistake? Undo your last move!
[auto],T_TUT_STREAK_TITLE,연속 콤보,Streak Combo
[auto],T_TUT_STREAK_DESC,카드를 연속으로 제거하면 특별 보상! 덱을 사용하면 초기화됩니다.,Clear cards in a row for special rewards! Resets on draw.
[auto],T_TUT_FIREWORKS_TITLE,그랜드 파이어웍스,Grand Fireworks
[auto],T_TUT_FIREWORKS_DESC,시작할 때 앞줄 카드를 모두 제거! 무료로 한 번 체험해 보세요.,Clears all front cards at start! Try it free once.
[auto],T_TUT_COLLECTION_TITLE,컬렉션 앨범,Collection Album
[auto],T_TUT_COLLECTION_DESC,게임을 클리어하면 퍼즐 피스를 모을 수 있어요! 앨범을 완성해 보세요.,Collect puzzle pieces by clearing levels! Complete the album.
[auto],T_TUT_GOLDEN_TITLE,골든 티켓,Golden Ticket
[auto],T_TUT_GOLDEN_DESC,와일드 카드 3장이 게임판에! 어떤 카드와도 매칭됩니다.,3 Wild Cards on the board! Matches any card.
[auto],T_TUT_BETTING2_TITLE,베팅 x2 해금,Betting x2 Unlocked
[auto],T_TUT_BETTING2_DESC,2배 베팅 해금! 더 높은 위험 더 큰 보상. 퍼즐 피스도 3배!,x2 Betting unlocked! Higher risk bigger reward. 3x puzzle pieces!
[auto],T_TUT_WILD_TITLE,와일드 카드,Wild Card
[auto],T_TUT_WILD_DESC,어떤 카드와도 매칭되는 만능 카드! 어려울 때 사용하세요.,Matches any card! Use it when you are stuck.
[auto],T_TUT_PLUS_TITLE,플러스 카드,Plus Card
[auto],T_TUT_PLUS_DESC,터치하면 덱에 카드가 추가됩니다! 새로운 기믹을 만나보세요.,Touch to add cards to your deck! Meet the new gimmick.
[auto],T_TUT_EVENT_COLOR_TITLE,컬러 수집 이벤트,Color Collection Event
[auto],T_TUT_EVENT_COLOR_DESC,특별 이벤트 시작! 게임 중 컬러 아이템을 모아 보상을 받으세요.,Special event! Collect color items during play for rewards.
[auto],T_TUT_EVENT_STAMP_TITLE,스탬프 투어,Stamp Tour
[auto],T_TUT_EVENT_STAMP_DESC,스탬프를 모아 여행을 완성하세요! 마일스톤 보상이 기다립니다.,Collect stamps to complete your tour! Milestone rewards await.
[auto],T_TUT_EXTRA_DECK_TITLE,엑스트라 덱,Extra Deck
[auto],T_TUT_EXTRA_DECK_DESC,덱이 비었어도 포기하지 마세요! 추가 카드를 보충할 수 있어요.,Out of cards? Don't give up! Refill your deck.
[auto],T_TUT_RUNNER_TITLE,러너 카드,Runner Card
[auto],T_TUT_RUNNER_DESC,매 턴 숫자가 변하는 카드! 타이밍을 잘 맞춰 제거하세요.,A card that changes every turn! Time your match carefully.
[auto],T_TUT_BETTING4_TITLE,베팅 x4 해금,Betting x4 Unlocked
[auto],T_TUT_BETTING4_DESC,최대 베팅 해금! 4배 참가비에 4배 보상. 퍼즐 피스 5배!,Max bet unlocked! 4x entry for 4x rewards. 5x puzzle pieces!
[auto],T_TUT_RACE_TITLE,랭킹 레이스,Ranking Race
[auto],T_TUT_RACE_DESC,다른 플레이어와 경쟁! 스트릭 스타를 모아 순위를 올리세요.,Compete with others! Collect Streak Stars to rank up.
[auto],T_TUT_ROPE_TITLE,밧줄 카드,Rope Card
[auto],T_TUT_ROPE_DESC,밧줄로 묶인 카드! 여러 번 매칭해서 풀어주세요.,A card tied with rope! Match multiple times to free it.
[auto],T_TUT_LOCK_TITLE,자물쇠 & 열쇠,Lock & Key
[auto],T_TUT_LOCK_DESC,같은 색 열쇠로 자물쇠를 열어요! 열쇠 카드를 먼저 찾으세요.,Open locks with matching keys! Find the key card first.
```

### 9.2 tutorial_schedule 신규 시트 (제안)

튜토리얼 맵과 레벨의 매핑을 관리하는 신규 시트 제안:

```csv
key,user_level,map_id,tutorial_phase,required_features,free_booster
60001,1,Tutorial_0351,phase_0,,
60002,2,Tutorial_0701,phase_1,,
60003,3,Tutorial_0036,phase_2,betting_x1,booster_undo
60004,4,Tutorial_0002,phase_2,,
60005,5,Tutorial_0026,phase_3,streak,booster_fireworks
60006,6,Tutorial_0001,phase_3,,
60007,7,Tutorial_0005,phase_3,,
60008,8,Tutorial_0008,phase_4,collection,booster_golden_ticket
```

---

## 10. 리스크 및 오픈 이슈

| # | 이슈 | 영향 | 제안 |
|---|------|------|------|
| R1 | 튜토리얼 맵 8개 배정이 최종 확정되지 않음 | Lv 1~8 플레이 경험 | 맵 에디터/QA에서 선정 맵의 플레이 난이도 실측 필요 |
| R2 | Lv 10에서 3개 해금 동시 발생 | UX 과부하 | 순차 팝업 + 각 팝업 간 1판 간격 삽입 검토 |
| R3 | 무료 부스터 체험이 경제 시뮬레이션에 반영 안 됨 | 초반 골드 밸런스 | 파이어웍스(Lv 5) + 골든 티켓(Lv 8) + 언두(Lv 3) 무료 1회씩 = 경제 영향 미미 (가설) |
| R4 | 잔여 28개 튜토리얼 맵 활용 방안 미정 | 맵 리소스 활용 | Schedule 풀 편입 or 보너스 레벨(CCS 참조) 검토 |
| R5 | Tutorial 졸업(Lv 8→9) 시 help_card_rate 급락 (80%→50%) | 이탈 리스크 | Lv 9~10 Normal 고정 구간이 완충 역할 (DDA 미적용). 추가 완충 불필요 (가설) |
| R6 | 해금 팝업 44개 string_code key_number 자동 채번 필요 | 시트 입력 | 기존 string_code 최대 key_number 확인 후 순차 채번 |

---

## 부록: 참고 문서

| 문서 | 위치 |
|------|------|
| CCS 튜토리얼 분석 | `workspace/candy_crush_solitaire_tutorial_analysis.md` |
| PST 튜토리얼 구조 분석 | `workspace/pst_tutorial_analysis.md` |
| PST 기획서 | Google Slides (슬라이드 80~83) |
| unlock 시트 | Google Sheet gid=1177964140 |
| dynamic_level 시트 | Google Sheet gid=1439840956 |
| difficulty_tier 시트 | Google Sheet gid=854311719 |
| const 시트 | Google Sheet gid=375222820 |
