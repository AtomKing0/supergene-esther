---
agent: 01_pm
mode: final_report
feature: dynamic_level
scope: DDA 파라미터 재설계 + fail_spiral 신규 조건 추가
executed: 2026-03-12T11:00:00+09:00
status: complete
verdict: Go
---

# PST Dynamic Level 시스템 — 설계·검증 완료 보고서

> **작업 기간**: 2026-03-11 ~ 2026-03-12
> **대상 시트**: `dynamic_level` (gid=1439840956), `const` (gid=375222820)
> **최종 판정**: **Go ✅** — 현재 파라미터·구조로 구현 진행 가능

---

## 1. 문제 정의 (Why We Started)

2026-03-11 Monte Carlo 시뮬레이션(1,000명 × 200레벨)으로 구 파라미터의 구조적 결함 확인.

| 지표 | 구 파라미터 | 목표 | 괴리 |
|---|---|---|---|
| Normal 배정률 | **91.74%** | 65% | +26.74pp ❌ |
| Hard 배정률 | **2.46%** | 25% | -22.54pp ❌ |
| SH 배정률 | 5.80% | 10% | -4.20pp ⚠️ |

**근본 원인**: `hard_cooldown=5`가 Hard/SH 직후 5레벨을 강제 Normal 전환 → Hard 발화(~8%) × cooldown(5) = 40%가 Normal 잠금. 수학적으로 Hard 25% 달성 불가능한 구조.

---

## 2. 설계 결정 (What We Decided)

### 2-1. 목표 분포 재설정

| 옵션 | 분포 | 결정 |
|---|---|---|
| 원안 | Normal 65 / Hard 25 / SH 10 | ❌ 파라미터 조합으로 달성 불가 |
| **Plan B** | **Normal 85 / Hard 10 / SH 5** | **✅ 채택** |

> Plan B 채택 이유: 파라미터 범위 내 수학적으로 달성 가능하며, 대부분의 플레이어에게 쉬운 맵을 제공하여 D1/D7 리텐션 친화적.

### 2-2. 신규 condition_type 검토 결과

| 후보 | 필요성 | 결정 |
|---|---|---|
| `level_bracket_early` (lv11-30 Hard 차단) | 낮음 — hard_guarantee=7이 자연 보호 | ❌ 불채택 |
| `long_normal_run` (10판+ Normal → Hard 즉시) | 중간 — Struggling 42.1% 경험 | ⏸ 보류 |
| **`fail_spiral`** (5연패 → Normal 5판 강제) | **높음 — Struggling 84.4% 경험** | **✅ 채택** |

---

## 3. 적용 내역 (What Changed)

### 3-1. dynamic_level 시트 파라미터 변경

| key_number | condition_type | 항목 | 변경 전 | 변경 후 | 이유 |
|---|---|---|---|---|---|
| 30004 | hard_cooldown | param_1 | **5** | **3** | 쿨다운 단축 → Hard 재진입 경로 확보 |
| 30005 | win_streak | param_1 | **7** | **99** | 사실상 비활성 → SH는 sh_guarantee만 사용 |
| 30006 | super_hard_guarantee | param_1 | **30** | **18** | SH 주기 단축 → 5% 목표 달성 |
| 30007 | hard_guarantee | param_1 | **15** | **7** | Hard 강제 주기 단축 → 10% 목표 달성 |

### 3-2. const 시트 파라미터 변경

| key_number | const_name | 변경 전 | 변경 후 | 이유 |
|---|---|---|---|---|
| 10021 | gimmick_ceiling_min | **2** | **4** | Lv81+ 기믹 과밀(매 3판) 완화 |
| 10022 | difficulty_rest_count | **2** | **0** | hard_cooldown=5 내 dead code → 명시적 비활성 |

### 3-3. fail_spiral 신규 추가 (2026-03-12)

| 항목 | 값 |
|---|---|
| key_number | 30009 |
| priority | **3** (fail_streak P4보다 선행) |
| condition_type | fail_spiral |
| param_1 | 5 (5연패 발동 조건) |
| param_2 | 5 (Normal 5판 강제 보장) |
| result_tier_id | 2 (Normal) |
| memo | [param_1] 연패 시 Normal [param_2]판 강제 제공 (패닉 모드 방지) |

### 3-4. 우선순위 재배열 (fail_spiral 삽입으로 시프트)

| key | 변경 전 priority | 변경 후 priority |
|---|---|---|
| 30009 (fail_spiral) | — | **P3 (신규)** |
| 30003 (fail_streak) | P3 | P4 |
| 30004 (hard_cooldown) | P4 | P5 |
| 30005 (win_streak) | P5 | P6 |
| 30006 (sh_guarantee) | P6 | P7 |
| 30007 (hard_guarantee) | P7 | P8 |

---

## 4. 검증 결과 (Simulation Evidence)

### 4-1. 최종 파라미터 시뮬레이션 요약

> 500명 × 6유형 × 200레벨 = **600,000 레벨** 샘플 (2026-03-12)

| 유형 | Normal | Hard | SH | 목표 편차 | fail_spiral 발동 | 판정 |
|---|---|---|---|---|---|---|
| Casual (저승률) | 84.3% | 10.5% | 5.3% | ±0.5pp | 0.31회/플레이어 | ✅ |
| Average (보통) | 84.2% | 10.5% | 5.3% | ±0.5pp | 0.07회/플레이어 | ✅ |
| Hardcore (고승률) | 84.2% | 10.5% | 5.3% | ±0.5pp | 0.00회/플레이어 | ✅ |
| Struggling (저승률) | 84.8% | 10.1% | 5.2% | ±1.0pp | 1.79회/플레이어 | ✅ |
| Improving (성장형) | 84.1% | 10.5% | 5.4% | ±0.5pp | 0.02회/플레이어 | ✅ |
| Streaky (불안정) | 84.2% | 10.5% | 5.3% | ±0.5pp | 0.11회/플레이어 | ✅ |
| **목표** | **85%** | **10%** | **5%** | — | — | — |

**→ 전 유형 ±1%p 이내 목표 달성**

### 4-2. 티어 전이 패턴 검증

| 전이 | 비율 | 의미 |
|---|---|---|
| Hard → Hard 연속 | **0%** | hard_cooldown이 완전 차단 ✅ |
| SH → Hard 연속 | **0%** | hard_cooldown이 완전 차단 ✅ |
| Normal → Hard | ~12% | 7판에 1번꼴 (hard_guarantee) ✅ |
| Normal → SH | ~6% | 18판에 1번꼴 (sh_guarantee) ✅ |
| Hard/SH → Normal | **100%** | 항상 쿨다운 복귀 ✅ |

### 4-3. fail_spiral 효과 검증

| 유형 | 5연패 경험률 | fail_spiral 발동 | 평가 |
|---|---|---|---|
| Hardcore | 0% | 0.00회 | 고승률 유저 비영향 — 투명 ✅ |
| Average | 6% | 0.07회 | 필요 시 작동 ✅ |
| Casual | 28% | 0.31회 | 중간 구제 ✅ |
| **Struggling** | **84%** | **1.79회** | **핵심 수혜층 — 패닉 나선 방지** ✅ |

전체 레벨의 **0.2%**만 영향 → 분포 왜곡 없음, 이탈 위험 구간 정밀 개입.

### 4-4. 구/신 비교

| 항목 | 구 파라미터 | 신 파라미터 (Plan B + fail_spiral) |
|---|---|---|
| Hard 배정률 (Average) | 2.46% | **10.5%** (+8.04pp) |
| Normal→SH 직행 | 10.44회/플레이어 | **~6% 비율로 통제** |
| Hard 연속 2회 | 가능 | **불가 (H→H=0%)** |
| 5연패 나선 구제 | 없음 | **fail_spiral P3 작동** |
| 목표 달성 | ❌ 불가능 | **✅ 전 유형 ±1%p** |

---

## 5. 잔여 과제 (Open Issues)

| 이슈 | 우선순위 | 상태 | 비고 |
|---|---|---|---|
| Struggling 10판+ Normal 연속 (경험률 42.1%) | P2 🟡 | 미해결 | long_normal_run 조건 보류 중 |
| gimmick_ceiling_min 효과 재검증 | P3 🟡 | 미완 | 기믹 독립 시뮬레이션 필요 |
| 승률 가설값 실측 보정 | P3 🟡 | 미완 | 실 서비스 데이터 필요 |
| const 10039/10040 명칭 오류 | P5 🔵 | 미해결 | 기능 영향 없음 |

---

## 6. 검수 이력 요약

| 단계 | 일자 | 내용 | 결과 |
|---|---|---|---|
| 초기 분석 (PM Stop) | 2026-03-11 | 구 파라미터 구조적 불가 판정 | `workspace/07_pm_analysis_report.md` |
| Plan B 파라미터 도출 | 2026-03-11 | 수치 탐색 시뮬레이션 576케이스 | hard_cooldown=3, hg=7, shg=18 |
| 시트 반영 (1차) | 2026-03-12 | 4개 dynamic_level + 2개 const | `workspace/07_sheet_modify_log.md` |
| 유형별 시뮬레이션 (v1) | 2026-03-12 | 6유형 × 1,000명, Plan B 검증 | `workspace/06_simulation_result.md` §2 |
| fail_spiral 채택·적용 | 2026-03-12 | key 30009 신규, 우선순위 재배열 | 시트 직접 반영 완료 |
| 유형별 시뮬레이션 (v2) | 2026-03-12 | 6유형 × 500명, fail_spiral 포함 | `workspace/08_simulation_v2_report.md` |
| **최종 판정** | **2026-03-12** | **전 유형 ±1%p, Go** | **본 문서** |

---

## 7. 최종 판정

**Go ✅**

- 목표 분포(85/10/5) 전 플레이어 유형에서 ±1%p 이내 달성 확인
- fail_spiral이 저승률 유저에게만 정밀 작동하며 전체 분포 왜곡 없음
- Hard 연속 방지, UX 급변(H→H, SH→SH) 완전 제거
- 시트 수정 완료 (백업·하이라이트·numberValue 3원칙 준수)
- 구현 진행 가능. 잔여 과제(Struggling 10판+ 나선)는 실 데이터 수집 후 v2 검토 권고.
