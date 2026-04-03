---
agent: 01_pm
mode: analysis_report
scope: dynamic_level + gimmick_weight + difficulty_tier + map_score 상관관계 분석 및 시뮬레이션 검증
executed: 2026-03-11T10:25:00+09:00
status: complete
verdict: Stop
adjust_targets: [dynamic_level, const_10016-10022, difficulty_tier]
---

# PST Dynamic Level 시스템 — PM 분석 보고서

## 분석 범위

| 시트/데이터 | 내용 |
|---|---|
| `const` (10016-10022) | 기믹 스케줄링 파라미터 |
| `const` (10038-10040) | 맵 스코어 가중치 |
| `difficulty_tier` | 티어별 점수 구간 및 게임 파라미터 |
| `gimmick_weight` | 기믹별 맵 점수 가중치 |
| `dynamic_level` | 난이도 배정 상태머신 (8개 규칙) |
| Monte Carlo 시뮬레이션 | 플레이어 1,000명 × 200레벨 |

---

## 1. 맵 스코어 공식 (라이브 확정)

```
Map Score = (총 카드 수 × 10)
          + (뒤집혀진 카드 수 × 20)   ← const: map_score_weight_max_depth
          + (최대 깊이 × 15)           ← const: map_score_weight_face_down_card
          + Σ(gimmick_weight × count)
```

> ⚠️ **명명 오류**: const 10039/10040의 `const_name`과 설명이 역전되어 있음. 공식 적용은 user 제공 formula 기준이 정확 (값 자체는 동일: 20, 15).

### 1-1. 티어 분류 가능 범위 (gimmick=0 기준)

| Tier | score_min | score_max | 해당 맵 예시 |
|---|---|---|---|
| Normal | 0 | 780 | 28장/10장 FD/depth3 = 525, 32장/14장/depth4 = 660 |
| Hard | 781 | 860 | 38장/18장 FD/depth5 = **815** ✓ |
| Super Hard | 861 | 910 | 40장/20장/depth5 = **875** ✓ |
| **Over-spec** | **>910** | — | 42장/22장/depth6 = **950** ❌ 미분류 |

**→ 티어 범위는 베이스 스코어만으로 달성 가능. 기믹은 경계 맵의 tier 이동 수단.**

### 1-2. 기믹 보정 효과 (베이스 755 Normal 경계 기준)

| 기믹 조합 | 보정 | 최종 점수 | 결과 tier |
|---|---|---|---|
| rope×1 | +30 | 785 | **Hard** |
| runner×1 | +40 | 795 | **Hard** |
| lock×1 | +20 | 775 | Normal (미달) |
| plus×1 | -10 | 745 | Normal |
| runner×3 | +120 | 875 | **SuperHard** |
| rope×2+runner×1 (38장 기준) | +110 | 925 | **Over-spec** ❌ |

---

## 2. Dynamic Level 시뮬레이션 결과

> 출처: `workspace/06_simulation_result.md` (Monte Carlo, n=190,000)

### 2-1. Steady-State Tier 분포 — **심각한 불일치**

| Tier | 시뮬레이션 | 목표 | 괴리 | 판정 |
|---|---|---|---|---|
| Normal | **91.74%** | 65.0% | **+26.74%p** | ❌ FAIL |
| Hard | **2.46%** | 25.0% | **-22.54%p** | ❌ FAIL |
| Super Hard | **5.80%** | 10.0% | **-4.20%p** | ⚠️ WARN |

95% CI: Normal [91.70%, 91.77%] / Hard [2.43%, 2.49%] — 오차 범위 무관, 구조적 문제

### 2-2. 규칙별 발동 빈도 (lv 11-200)

| 규칙 | Tier | 비율 | 플레이어당 평균 |
|---|---|---|---|
| hard_cooldown (P4) | Normal 강제 | **38.44%** | 73.0회 |
| default (P8) | Normal | 48.47% | 92.1회 |
| win_streak (P5) | Super Hard | 4.78% | 9.1회 |
| fail_streak (P3) | Normal | 4.83% | 9.2회 |
| hard_guarantee (P7) | Hard | 2.46% | 4.7회 |
| super_hard_guarantee (P6) | Super Hard | 1.02% | 2.0회 |
| **rest_guarantee_override** | Normal | **0.00%** | **0회 — Dead code** |

---

## 3. 이슈 목록 및 위험 등급

### [ISSUE-01] Hard 배정률 구조적 불가 🔴 P1

- **현상**: Hard 2.46% (목표 25%)
- **근본 원인**: `hard_cooldown=5`가 Hard/SuperHard 이후 5레벨 강제 Normal 전환. Hard 8.26% 발화 시마다 5레벨 Normal 잠금 → 정상 순환 불가능
- **수학적 증명**: Hard 25% 달성을 위한 hard_guarantee 임계값 = `(1/(0.25+0.25×5)) ≈ 2.7판` → 현재 15판은 수학적으로 불가

**권고**: `hard_cooldown` = 5 → **2판으로 축소** (SuperHard만 5 유지 검토), 또는 `hard_guarantee` = 15 → **5~7판으로 대폭 단축**

---

### [ISSUE-02] Normal→SuperHard 급변 UX 위험 🔴 P2

- **현상**: Hard를 경유하지 않고 Normal→SuperHard 직행이 **10.44회/플레이어** (100% 플레이어 경험)
- **원인**: `win_streak=7` 조건이 Normal 연승에서 직접 SuperHard 발화. Hard 단계 없음
- **UX 위험**: 체감 난이도 급등 → D1/D7 이탈 유발 가능

**권고**: win_streak 단계 분리 — `win_streak ≥ 5 → Hard`, `win_streak ≥ 9 → Super Hard`

---

### [ISSUE-03] rest_guarantee Dead Code 🟡 P3

- **현상**: `difficulty_rest_count=2` (CONST 10022) 발동 0회/190,000레벨
- **원인**: `hard_cooldown=5` 내에서 2판이 완전 흡수됨. hard_cooldown 우선순위(P4)가 rest_guarantee 오버라이드보다 선행
- **영향**: 설계 의도(Hard/Gimmick 후 쿨다운) 달성은 hard_cooldown이 담당 중이므로 기능 중복

**권고**: `difficulty_rest_count` 항목 삭제 또는 `hard_cooldown > difficulty_rest_count` 관계 명문화

---

### [ISSUE-04] Gimmick Ceiling 조기 수렴 🟡 P3

- **현상**: `level_gimmick_interval_max=10`, 10레벨마다 -1 감소, 하한 2 → **Lv 81에서 ceiling=2 도달**
  - Lv 81 이후: 2판 Normal 배치 후 기믹 강제 발화 반복
  - Lv 200 기준 유효 기믹 밀도: ~33% (3판 중 1판)
- **위험**: 고레벨에서 기믹 피로도 누적, 맵 다양성 저하

**Gimmick Ceiling 스케줄:**

| 레벨 구간 | Ceiling | 기믹 주기 (최소-최대) |
|---|---|---|
| Lv 1-10 | 10 | 3~10판 |
| Lv 11-20 | 9 | 3~9판 |
| Lv 21-30 | 8 | 3~8판 |
| Lv 31-40 | 7 | 3~7판 |
| … | … | … |
| Lv 81+ | **2** | 3~2판 → **사실상 매 3판** |

**권고**: `level_gimmick_interval_max_cap` = 2 → **4~5로 상향**

---

### [ISSUE-05] Over-spec 맵 분류 미정의 🟡 P4

- **현상**: 42장 이상 고복잡도 맵(score > 910) — difficulty_tier 범위 초과, 미분류
- **예시**: 42장/22장FD/depth6 = 950점 → SuperHard 상한(910) 초과
- **위험**: 이런 맵은 tier 배정 시스템에서 어떤 tier로 처리되는지 미정의

**권고**: `difficulty_tier` SuperHard `score_max` 확장(910→999) 또는 Ultra Hard tier 신설 여부 결정

---

### [ISSUE-06] const_name 명명 오류 (사소) 🔵 P5

- `10039 map_score_weight_max_depth` 설명: "카드가 겹쳐진 최대 깊이" → 실제 공식에선 **뒤집혀진 카드 수**에 곱함
- `10040 map_score_weight_face_down_card` 설명: "뒤집혀진 카드 개수" → 실제 공식에선 **최대 깊이**에 곱함
- **영향**: 기능 오류 없음. 가독성 혼란만 발생

**권고**: const_name 스왑 수정 (기능 변경 없음)

---

## 4. 검수 이력 (이슈 추적)

| 이슈 ID | 내용 | 이번 검수 | 상태 |
|---|---|---|---|
| ISSUE-01 | Hard 배정률 2.46% (목표 25%) | 신규 발견 | 🔴 미해결 |
| ISSUE-02 | Normal→SuperHard 급변 10.4회 | 신규 발견 | 🔴 미해결 |
| ISSUE-03 | rest_guarantee dead code | 신규 발견 | 🟡 미해결 |
| ISSUE-04 | Gimmick ceiling Lv81 수렴 | 신규 발견 | 🟡 미해결 |
| ISSUE-05 | Over-spec 맵 분류 미정의 | 신규 발견 | 🟡 미해결 |
| ISSUE-06 | const_name 명명 오류 | 신규 발견 | 🔵 낮은 우선순위 |

---

## 5. 최종 판정

| 판정 | 의미 |
|---|---|
| **Stop** | 구조적 문제로 전면 재설계 필요 |

### 판정 이유

`dynamic_level` 규칙 체계가 목표 분포(Normal 65% / Hard 25% / SuperHard 10%)를 달성할 수 없는 **수학적으로 불가능한 구조**임이 시뮬레이션으로 확인됨.

- Hard 2.46%는 `hard_cooldown=5`와 `hard_guarantee=15`의 조합이 만드는 구조적 결과
- 파라미터 미세 조정으로는 해결 불가능 — **규칙 구조 자체를 재설계해야 함**
- Normal→SuperHard 직행 UX 위험은 플레이어 100%가 경험하는 반복 충격

### 재설계 방향 제안 (PM 권고)

```
[안 A] hard_cooldown 분리 적용
  - Hard 클리어 후 cooldown: 2판
  - SuperHard 클리어 후 cooldown: 5판
  - hard_guarantee: 15 → 7판

[안 B] win_streak 단계화
  - win_streak ≥ 5 → Hard
  - win_streak ≥ 9 → Super Hard (Hard 경유 필수화)

[안 C] hard_rate 직접 제어
  - dynamic_level에 random_hard_rate 파라미터 추가
  - 목표: Hard 25%, SuperHard 10%를 확률로 직접 설정
```

재설계 후 Monte Carlo 재시뮬레이션으로 목표 분포 ±5%p 이내 달성 확인 필수.

---

## 6. 시뮬레이션 한계 (Limitation)

| 한계 | 내용 |
|---|---|
| 승률 가설 | Tutorial 98% / Normal 80% / Hard 55% / SH 35% — 실측 미포함 **[가설]** |
| Gimmick 독립성 | 기믹 레벨과 난이도 tier 상호작용 시뮬레이션 미포함 |
| 플레이어 이탈 | D1/D7 이탈로 인한 level 분포 변화 미반영 |
| 맵 다양성 | 동일 tier 내 맵 pool 소진 리스크 미계산 |
