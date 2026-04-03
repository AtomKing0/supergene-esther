---
agent: scientist
scope: dynamic_level 시뮬레이션
executed: 2026-03-11T10:16:01Z
simulation: monte_carlo
players: 1000
levels: 200
analysis_range: lv 11-200 (lv 1-10 제외)
---

# PST Dynamic Level 시스템 Monte Carlo 시뮬레이션 결과

## 승률 가설 (Hypothesis)

> **[가설]** 아래 tier별 승률은 `pity_trigger_count`, `help_card_rate`, `sustain` 파라미터를 기반으로 합리적 추정한 값이며 실측값이 아님.

| Tier | 이름 | 가정 승률 | 근거 |
|---|---|---|---|
| 1 | Tutorial | 98% | help_rate=8000 (80%), pity=3 |
| 2 | Normal | 80% | help_rate=5000 (50%), pity=5 |
| 3 | Hard | 55% | help_rate=2000 (20%), pity=8 |
| 4 | Super Hard | 35% | help_rate=0, pity=99 (사실상 없음) |

---

## 1. Steady-State Tier 분포

[OBJECTIVE] dynamic_level 규칙 하에서 실제 tier 배정 분포가 목표치(N 65% / H 25% / SH 10%)와 정합하는지 검증

[DATA] 플레이어 1,000명 × 200레벨, 분석 대상: lv 11-200 (190,000 레벨 샘플)

[FINDING] 시뮬레이션 분포가 목표치와 **심각하게 불일치**함. Normal이 목표 대비 +26.74%p 과다, Hard가 -22.54%p 결핍.
[STAT:n] n = 190,000 레벨 (1,000 players × 190 levels)
[STAT:ci] Normal 95% CI: [91.70%, 91.77%]  |  Hard 95% CI: [2.43%, 2.49%]  |  SuperHard 95% CI: [5.75%, 5.86%]

| Tier | 이름 | 시뮬레이션 | 목표 | 괴리 |
|---|---|---|---|---|
| 2 | Normal | **91.74%** | 65.0% | **+26.74%p** |
| 3 | Hard | **2.46%** | 25.0% | **-22.54%p** |
| 4 | Super Hard | **5.80%** | 10.0% | **-4.20%p** |

### 레벨 구간별 분포

| 구간 | Normal% | Hard% | SuperHard% | 지배 규칙 |
|---|---|---|---|---|
| Lv11-20 | 88.3% | 3.7% | 8.0% | hard_cooldown |
| Lv21-40 | 92.2% | 2.2% | 5.6% | default |
| Lv41-60 | 91.8% | 2.5% | 5.8% | default |
| Lv61-80 | 91.8% | 2.4% | 5.8% | default |
| Lv81-100 | 91.9% | 2.5% | 5.6% | default |
| Lv101-120 | 91.9% | 2.4% | 5.7% | default |
| Lv121-140 | 92.0% | 2.4% | 5.6% | default |
| Lv141-160 | 91.8% | 2.4% | 5.8% | default |
| Lv161-180 | 91.9% | 2.5% | 5.6% | default |
| Lv181-200 | 92.0% | 2.3% | 5.7% | default |

> **구조적 원인**: `hard_cooldown=5` 규칙이 Hard/SuperHard 이후 5레벨을 강제 Normal로 전환함. lv 11-200 기준 38.44%의 레벨이 hard_cooldown에 의해 Normal로 배정됨. Hard/SuperHard 합산 비율 ~8.3%에 cooldown 5레벨을 곱하면 41.5%가 cooldown Normal이 됨 → 구조적으로 Hard/SuperHard 비율 상승 불가.

---

## 2. 규칙별 발동 빈도

[FINDING] `hard_cooldown`과 `default` 합산 86.9%로 Normal 구간을 독점적으로 지배. Hard/SuperHard 진입 경로인 `hard_guarantee`(2.46%), `win_streak`(4.78%)는 소수.
[STAT:n] n = 190,000 (lv 11-200)

| 규칙 (우선순위) | 결과 Tier | 발동 횟수 | 비율 | 플레이어 평균 |
|---|---|---|---|---|
| fail_streak (P3) | Normal | 9,172 | 4.83% | 9.17회 |
| hard_cooldown (P4) | Normal | 73,039 | **38.44%** | 73.04회 |
| win_streak (P5) | Super Hard | 9,081 | 4.78% | 9.08회 |
| super_hard_guarantee (P6) | Super Hard | 1,947 | 1.02% | 1.95회 |
| hard_guarantee (P7) | Hard | 4,675 | **2.46%** | 4.67회 |
| default (P8) | Normal | 92,086 | **48.47%** | 92.09회 |
| rest_guarantee_override | Normal | 0 | 0.00% | 0.00회 |

### 규칙 발동 플레이어 비율

| 규칙 | 발동한 플레이어 | 플레이어당 평균 횟수 |
|---|---|---|
| win_streak → SuperHard | **100.0%** | 9.08회 |
| hard_guarantee → Hard | **100.0%** | 4.67회 |
| super_hard_guarantee | 91.3% | 1.95회 |
| fail_streak 보호 | 100.0% | 9.17회 |
| hard_cooldown | 100.0% | 73.04회 |

---

## 3. Win Streak 7 조건 분석

[FINDING] 모든 플레이어가 lv 11-200 사이에 win_streak SuperHard를 경험함. 평균 9.08회/플레이어.
[STAT:n] n = 9,081 events / 1,000 players
[STAT:effect_size] 전환 후 5레벨 hard_cooldown → 즉각 완충. SuperHard 직후 fail_streak DDA 발동률: 2.1%

- **최초 발생**: 최소 Lv 11 (win streak 필요 레벨이 Lv 11 이상)
- **중앙값 레벨**: Lv 101  |  p10: Lv 22  |  p90: Lv 181
- **연속 SuperHard 반복 확률**: (35%)^7 ≈ 0.06% (사실상 없음)
- **충격 완화 경로**: win_streak 이후 5레벨 hard_cooldown 강제 → Normal 회복 보장

---

## 4. Hard Guarantee 15판 발동 빈도

[FINDING] hard_guarantee는 100%의 플레이어에서 발동하나 평균 4.67회/190레벨로 저빈도. 전체의 2.46%만 이 규칙으로 Hard 진입.
[STAT:n] n = 4,675 triggers / 1,000 players
[STAT:effect_size] Hard 전체 레벨의 100%가 hard_guarantee에서 발생 (win_streak은 SuperHard로 바이패스)

> 해석: Hard 진입 경로가 hard_guarantee 1개뿐. `win_streak`은 SuperHard를 직접 트리거하므로 Hard(Tier 3)만을 위한 win_streak 경로가 없음. Hard가 목표 25%에 크게 못 미치는 직접 원인.

---

## 5. Gimmick Max Interval 천장 감소 스케줄

[FINDING] 천장이 Lv 81에서 최솟값 2에 도달하여, 이후 모든 레벨에서 2판 연속 Normal마다 기믹 강제 발동.
[STAT:n] 계산식: ceiling = max(10 - floor((level-1)/10), 2)

| 레벨 | 실효 천장 | 의미 |
|---|---|---|
| Lv 1 | 10 | 10판 연속 Normal이면 기믹 강제 |
| Lv 50 | 6 | 6판 연속 Normal이면 기믹 강제 |
| **Lv 81** | **2** | **최솟값 도달 (이후 동결)** |
| Lv 100 | 2 | 2판 연속 Normal이면 기믹 강제 |
| Lv 150 | 2 | 2판 연속 Normal이면 기믹 강제 |
| Lv 200 | 2 | 2판 연속 Normal이면 기믹 강제 |

> **위험 신호**: Lv 81 이후 기믹이 사실상 격판(every other level) 강제 배정됨. Normal 91.74%에 ceiling=2 적용 시 기믹 빈도는 비정상적으로 높아질 수 있음 (gimmick 자체 시뮬레이션 별도 필요).

---

## 6. Rest Guarantee vs Hard Cooldown 중복 분석

[FINDING] `rest_guarantee=2`가 `hard_cooldown=5` 내에 완전히 흡수되어 독립적 효과 0회.
[STAT:n] rest_guarantee_override 발동: 0 / 190,000

- Hard/SuperHard 배정 직후: `hard_cooldown_remaining=5`, `rest_remaining=2` 동시 설정
- rest_remaining은 2레벨 후 소진; hard_cooldown은 5레벨 지속
- rest_guarantee가 독립 작동하려면 `hard_cooldown_remaining=0`이면서 `rest_remaining>0` 상태 필요 → 수학적으로 불가 (2 < 5)
- **결론**: `rest_guarantee` 파라미터는 현재 파라미터 값(2 < 5) 하에서 dead code. 의도한 기능이라면 `rest_guarantee > hard_cooldown` 조건이 필요.

---

## 7. 맵 풀 소진 위험

[FINDING] lv 200 기준 Normal 맵 소진 위험은 낮으나(14.9%), Hard 맵 효율이 극히 낮아 풀 대비 소모율이 비대칭적임.
[STAT:n] 분석 기준: lv 11-200, 190레벨

| Tier | 맵 풀 크기 | 플레이어당 평균 소비 | p95 소비 | p95 소진율 |
|---|---|---|---|---|
| Normal (VE+E+N) | 1,179 | 174.3 맵 | 176.0 맵 | **14.9%** |
| Hard (H) | 388 | 4.7 맵 | 6.0 맵 | **1.5%** |
| Super Hard (VH) | 402 | 11.0 맵 | 14.0 맵 | **3.5%** |

> Normal 맵은 1인 플레이어 기준 190레벨에서 풀의 14.9%만 소비하므로 순환 없이도 충분함. 그러나 Hard/SuperHard 소비 극소화로 해당 맵 풀은 사실상 과잉 공급 상태.

---

## 8. 위험 구간 식별

[FINDING] 5레벨 이상 동일 tier 연속 구간이 플레이어당 평균 **15.69회** 발생하며, 모두 Normal tier 장기 체류임.
[STAT:n] 15,686 risk zone instances / 1,000 players

| 위험 유형 | 발생 횟수 | 플레이어당 평균 | 해당 Tier |
|---|---|---|---|
| 연속 5+ Normal | 15,686 | 15.69회 | Normal (Tier 2) |
| 연속 5+ Hard | 0 | 0.00회 | - |
| 연속 5+ SuperHard | 0 | 0.00회 | - |

| 급변 유형 | 발생 횟수 | 플레이어당 평균 | 비고 |
|---|---|---|---|
| Normal → Super Hard (스킵) | 10,435 | 10.44회 | win_streak 발동 |
| Super Hard → Normal (스킵) | 10,968 | 10.97회 | hard_cooldown 발동 |

> **핵심 UX 위험**: Normal에서 Super Hard로 Hard를 건너뛰는 급변이 10.44회/플레이어. 체감 난이도 점프가 반복되어 플레이어 이탈 유발 가능.

---

## 종합 진단 및 권고

### [LIMITATION]
1. 승률(Tutorial 98% / Normal 80% / Hard 55% / SuperHard 35%)은 가설값. 실측 데이터 없음.
2. 기믹 스케줄(gimmick_interval 추적) 독립 시뮬레이션 미포함. 천장=2 이후의 실제 기믹 빈도 별도 검증 필요.
3. 플레이어 간 맵 공유(다인 서버 환경) 미고려. 맵 소진 분석은 단일 플레이어 기준.
4. `score_min`/`score_max` 기반 동적 난이도 조정(실제 맵 점수 반영) 미시뮬레이션. 규칙만 시뮬레이션.

### 우선순위 권고

| 우선순위 | 이슈 | 원인 | 권고 |
|---|---|---|---|
| P1 🔴 | Hard 비율 2.46% (목표 25%) | hard_cooldown 5판이 Hard 재진입 억제 | `hard_guarantee` 임계를 15→8로 단축 검토, 또는 hard_cooldown을 Hard tier만 3판으로 분리 |
| P2 🔴 | Normal→SuperHard 급변 10.44회/플레이어 | Hard를 거치지 않는 win_streak 경로 | Hard(Tier 3) 경유 win_streak 단계 신설 검토 |
| P3 🟡 | Gimmick ceiling=2 (Lv 81 이후) | 천장 감소 폭 과다 | `ceiling_min` 3~4로 상향, `ceiling_decrease_interval` 15로 완화 |
| P4 🟡 | rest_guarantee dead code | rest(2) < hard_cooldown(5) | rest_guarantee 삭제 또는 5 초과 값으로 설정 |
| P5 🟢 | Hard/SuperHard 맵 풀 과잉 | 실제 소비율 낮음 | 현행 유지 가능, 대신 Normal 풀 다양성 검토 |

---

*Figure: `/Users/estherpark/esther_solitaire/solitaire-esther-1/solitire-currency/.omc/scientist/figures/dynamic_level_simulation.png`*

---

## [2026-03-12] 플레이어 유형별 시뮬레이션 (안 B 파라미터)

```
시뮬레이션 설정
  파라미터 안 B: hard_cooldown=3, hard_guarantee=7, sh_guarantee=18,
                win_streak_sh=99 (비활성화), fail_streak_protect=2
  플레이어 수:   유형당 1,000명
  분석 범위:     lv 11 이후 (lv 1-10 제외)
  총 샘플:       1,100,000 레벨 (6개 유형 합산)
```

[OBJECTIVE] 안 B 파라미터 하에서 6개 플레이어 유형별 tier 노출 분포, 규칙 발동 패턴, 단조로움 지표, Hard/SH 첫 등장 레벨, condition_type 신규 후보 필요성 수치 계산

[DATA] 6개 유형 × 1,000명 × 100~300레벨. Casual 90,000 / Average 190,000 / Hardcore 290,000 / Struggling 140,000 / Returning 140,000 / Streaker 190,000 레벨 샘플 (lv11+). 총 1,040,000 분석 레벨.

---

### 1. 유형별 Tier 분포 (lv 11 이후)

[FINDING] 안 B 파라미터는 모든 플레이어 유형에서 목표 분포(Normal 85% / Hard 10% / SH 5%)에 최대 ±1.03pp 수준으로 근접. 구 파라미터(hard_cooldown=5)에서 Normal 91.74% / Hard 2.46%였던 것과 비교하면 구조적 개선 확인.

[STAT:n] 총 n = 1,040,000 레벨 (6개 유형 합산, lv11 이후)
[STAT:ci] 각 유형별 95% CI는 아래 표 참조 (±0.2pp 이내)

| 유형 | Normal% | Hard% | SH% | 목표편차 N | 목표편차 H | 목표편차 SH |
|---|---|---|---|---|---|---|
| Casual | **86.03%** | 9.53% | 4.44% | +1.03pp | -0.47pp | -0.56pp |
| Average | 85.36% | 9.90% | 4.74% | +0.36pp | -0.10pp | -0.26pp |
| Hardcore | 85.18% | **9.99%** | 4.83% | +0.18pp | -0.01pp | -0.17pp |
| Struggling | **86.03%** | 9.22% | 4.75% | +1.03pp | -0.78pp | -0.25pp |
| Returning | 85.63% | 9.40% | 4.97% | +0.63pp | -0.60pp | -0.03pp |
| Streaker | 85.60% | 9.66% | 4.74% | +0.60pp | -0.34pp | -0.26pp |
| **목표** | **85.00%** | **10.00%** | **5.00%** | — | — | — |

**95% CI 대표값 (Average 기준, n=190,000):**

| Tier | 시뮬레이션 | 95% CI |
|---|---|---|
| Normal | 85.36% | [85.20%, 85.52%] |
| Hard | 9.90% | [9.77%, 10.04%] |
| SH | 4.74% | [4.64%, 4.83%] |

> 해석: 모든 유형에서 Normal이 목표 대비 최대 +1.03pp 초과. Hard는 최소 -0.78pp(Struggling) 결핍. Hardcore가 목표에 가장 근접(Hard -0.01pp). 구 파라미터(hard_cooldown=5, hard_guarantee=15) 대비 Hard 비율이 2.46% → ~9.5~10.0%로 대폭 개선됨.

*Figure: `.omc/scientist/figures/setB_tier_distribution.png`*

---

### 2. 규칙 발동 패턴

[FINDING] fail_streak_protect가 Struggling 유형에서 전체 레벨의 23.57%를 점유하는 지배적 규칙. Casual도 15.25%로 높음. Hardcore는 1.75%에 불과해 규칙 설계가 실력 차이를 정확히 반영.

[STAT:n] n = 1,040,000 레벨 (lv11 이후 합산)
[STAT:effect_size] Struggling fail_streak 발동률 23.57% vs Hardcore 1.75% → 13.5배 차이

| 유형 | fail_streak | hard_cooldown | hard_guarantee | sh_guarantee | default |
|---|---|---|---|---|---|
| Casual | **15.25%** | 33.32% | 9.53% | 4.44% | 37.46% |
| Average | 5.66% | 39.88% | 9.90% | 4.74% | 39.82% |
| Hardcore | 1.75% | 42.81% | 9.99% | 4.83% | 40.62% |
| Struggling | **23.57%** | 30.88% | 9.22% | 4.75% | 31.57% |
| Returning | 11.88% | 36.84% | 9.40% | 4.97% | 36.91% |
| Streaker | 9.77% | 38.57% | 9.66% | 4.74% | 37.26% |

**fail_streak_protect 발동 상세:**

| 유형 | 발동 플레이어 | 1인당 평균 발동 | 의미 |
|---|---|---|---|
| Casual | 1,000/1,000명 (100%) | 13.7회 | 모든 Casual이 2연패 보호 경험 |
| Average | 1,000/1,000명 (100%) | 10.8회 | |
| Hardcore | 996/1,000명 (99.6%) | 5.1회 | 거의 발동 없음 |
| **Struggling** | 1,000/1,000명 (100%) | **33.0회** | 핵심 보호 장치로 작동 |
| Returning | 1,000/1,000명 (100%) | 16.6회 | 초반 50% 승률 구간 집중 |
| Streaker | 1,000/1,000명 (100%) | 18.6회 | 냉각 사이클 구간 집중 |

> 해석: `fail_streak_protect=2`는 저숙련 유형(Struggling, Returning, Casual)에서 핵심 안전망으로 작동. Struggling의 경우 레벨 약 1/4이 이 규칙에 의존하며, 이를 제거 시 해당 유형의 경험이 급격히 악화될 것으로 예상.

*Figure: `.omc/scientist/figures/setB_rule_firing.png`*

---

### 3. 연속 동일 Tier 구간 (단조로움 지표)

[FINDING] 10판 이상 연속 Normal 구간은 Struggling에서 1인당 0.54회 발생하며 경험 플레이어 비율 42.1%. Hardcore는 사실상 미발생(0.2%). 안 B의 hard_guarantee=7이 최장 연속 Normal을 중앙값 7~9판으로 억제.

[STAT:n] n = 1,040,000 레벨 (lv11 이후)
[STAT:effect_size] Struggling 10판+ 경험률 42.1% vs Hardcore 0.2% → 210배 차이

| 유형 | 5판+ 구간 (1인당) | 10판+ 구간 (1인당) | 최장 연속 Normal (중앙값) | 최장 p95 | 10판+ 경험% |
|---|---|---|---|---|---|
| Casual | 9.10회 | 0.089회 | 8판 | 10판 | **8.5%** |
| Average | 19.05회 | 0.028회 | 8판 | 9판 | 2.8% |
| Hardcore | 29.01회 | 0.002회 | 7판 | 8판 | 0.2% |
| **Struggling** | 13.76회 | **0.540회** | 9판 | 13판 | **42.1%** |
| Returning | 13.90회 | 0.142회 | 8판 | 10판 | 13.4% |
| Streaker | 18.91회 | 0.220회 | 9판 | 11판 | 20.0% |

> 해석: 5판+ 구간이 가장 많은 유형은 Hardcore(29.01회/인). 역설적으로 Hardcore는 hard_cooldown 이후 빠르게 다음 Hard/SH 트리거(hard_guarantee=7)가 걸리기 전 Normal 연속이 더 자주 발생하지만 10판을 초과하지 않음. 단조로움 위험(10판+)은 Struggling과 Streaker에 집중.

---

### 4. Hard/SH 첫 등장 레벨 분포

[FINDING] 모든 유형에서 Hard 첫 등장이 lv 18 (±0.5), SH 첫 등장이 lv 22~23으로 수렴. hard_guarantee=7 + lv11 시작으로 lv 17~18에 Hard가 수학적으로 강제됨.

[STAT:n] 각 유형 1,000명 전수 분석
[STAT:ci] Hard 첫 등장률 100% (전 유형). SH 첫 등장률 100% (전 유형).

**[ Hard 첫 등장 레벨 ]**

| 유형 | 등장률 | 평균 lv | p25 | p75 | 비고 |
|---|---|---|---|---|---|
| Casual | 100% | 18.2 | 18 | 18 | |
| Average | 100% | 18.0 | 18 | 18 | |
| Hardcore | 100% | 18.0 | 18 | 18 | |
| Struggling | 100% | 18.3 | 18 | 18 | fail_streak 발동으로 소폭 지연 |
| Returning | 100% | 18.5 | 18 | 19 | lv11-17 승률 50% → hard_guarantee 7판 채우기 지연 |
| Streaker | 100% | 18.3 | 18 | 18 | |

**[ SH 첫 등장 레벨 ]**

| 유형 | 등장률 | 평균 lv | p25 | p75 | 비고 |
|---|---|---|---|---|---|
| Casual | 100% | 22.4 | 22 | 23 | |
| Average | 100% | 22.1 | 22 | 22 | |
| Hardcore | 100% | 22.0 | 22 | 22 | |
| Struggling | 100% | 22.8 | 22 | 23 | |
| Returning | 100% | 23.1 | 22 | 23 | |
| Streaker | 100% | 22.4 | 22 | 23 | |

> 해석: Hard는 lv 11 + hard_guarantee(7) = lv 18이 수학적 하한. SH는 Hard 첫 등장 lv18 이후 hard_cooldown(3) 소진 + sh_guarantee 18판 누적 = lv 22~23이 하한. 유형별 차이는 최대 1.1레벨로 미미. Returning이 초반 낮은 승률로 인해 소폭 지연.

---

### 5. condition_type 후보 필요성 수치

[FINDING] 3개 후보 중 `fail_spiral`(C)이 Struggling/Returning/Streaker 유형에서 현실적 필요성이 가장 높음. `level_bracket_early`(A)는 Hard가 이미 lv18에만 등장하므로 필요성이 낮음. `long_normal_run`(B)은 Struggling에서만 실질 위험.

[STAT:n] 각 유형 1,000명 × 해당 레벨 범위 전수

**후보 A: `level_bracket_early` (lv 11-30 Hard 완전 차단)**

| 유형 | lv11-30 Hard 배정 비율 | Hard 등장 lv 평균 | 필요성 판단 |
|---|---|---|---|
| Casual | 8.30% (1,661판/90,000) | lv 18.2 | 낮음 — Hard가 이미 lv18에 집중 |
| Average | 9.50% (1,901판) | lv 18.0 | 낮음 |
| Hardcore | 9.89% (1,978판) | lv 18.0 | 낮음 |
| Struggling | 7.67% (1,534판) | lv 18.3 | 낮음 |
| Returning | 7.22% (1,443판) | lv 18.5 | **중간** — 초반 적응 중 Hard 등장이 영향 가능 |
| Streaker | 8.62% (1,725판) | lv 18.3 | 낮음 |

> 판단: Hard가 lv18에 수렴하므로 lv11-30 Hard 차단은 사실상 lv11-17 보호 효과. 현재 해당 구간 Hard 비율은 ~0% (hard_guarantee=7 달성 전). **필요성 낮음 — 현재 구조로 자연 보호됨.**

**후보 B: `long_normal_run` (10판 연속 Normal → Hard 즉시)**

| 유형 | 10판+ 구간 (1인당) | 10판+ 경험 플레이어% | 필요성 판단 |
|---|---|---|---|
| Casual | 0.089회/인 | 8.5% | 낮음 |
| Average | 0.028회/인 | 2.8% | 낮음 |
| Hardcore | 0.002회/인 | 0.2% | 불필요 |
| **Struggling** | **0.540회/인** | **42.1%** | **높음** — 10판+ Normal이 빈발 |
| Returning | 0.142회/인 | 13.4% | 중간 |
| Streaker | 0.220회/인 | 20.0% | 중간 |

> 판단: hard_guarantee=7 설정에도 불구하고 fail_streak_protect가 hard_guarantee 카운터를 리셋하면서 Normal 연속이 10판 이상 늘어날 수 있음. Struggling에서 42%가 경험. **Struggling 보호 목적으로 중간 필요성. 단독 적용 시 Struggling 전용 조건으로 검토 가능.**

**후보 C: `fail_spiral` (5연패 → SH 완전 차단 + Normal 5판)**

| 유형 | 5연패 구간 (1인당) | 5연패 경험 플레이어% | 필요성 판단 |
|---|---|---|---|
| Casual | 0.39회/인 | 32.1% | **중간** |
| Average | 0.07회/인 | 7.0% | 낮음 |
| Hardcore | 0.00회/인 | 0.3% | 불필요 |
| **Struggling** | **1.75회/인** | **84.4%** | **매우 높음** |
| Returning | 0.61회/인 | 48.9% | **높음** |
| Streaker | 0.53회/인 | 41.8% | **높음** |

> 판단: Struggling의 84.4%가 5연패를 경험하고 1인당 평균 1.75회 발생. 현재 `fail_streak_protect=2`가 2연패 보호를 제공하지만 5연패 자체를 방지하지는 않음 (fail_streak=2 → Normal 배정 후 다시 Hard/SH에 패배 가능). **`fail_spiral` 후보 중 필요성 최고 — Struggling/Returning 타겟 적용 권고.**

*Figure: `.omc/scientist/figures/setB_condition_type_candidates.png`*

---

### 종합 요약 (안 B 평가)

[FINDING] 안 B는 구 파라미터 대비 Hard 비율을 2.46% → ~9.5~10.0%로 회복시키며 목표 달성. 유형별 tier 분포 편차 최대 ±1.03pp로 수용 범위 내. 핵심 미결 과제는 Struggling의 5연패 나선(경험률 84.4%)과 10판+ Normal 연속(경험률 42.1%).

[STAT:effect_size] 안 B Hard 비율 평균 9.62% vs 안 A(구) 2.46% → +7.16pp 개선
[STAT:n] n = 1,040,000 레벨 샘플

| 항목 | 안 A (구, hard_cooldown=5) | 안 B (현행, hard_cooldown=3) | 개선 여부 |
|---|---|---|---|
| Hard 비율 (Average) | 2.46% | **9.90%** | +7.44pp 개선 |
| 목표 편차 Hard (Average) | -22.54pp | **-0.10pp** | 대폭 개선 |
| Struggling 10판+ 경험률 | — | 42.1% | 잔여 과제 |
| Struggling 5연패 경험률 | — | 84.4% | 잔여 과제 |

**condition_type 후보 우선순위:**

| 우선순위 | 후보 | 영향 유형 | 현재 빈도 | 권고 |
|---|---|---|---|---|
| P1 | `fail_spiral` (5연패 → Normal 5판 강제) | Struggling(84.4%), Returning(48.9%), Streaker(41.8%) | 1.75회/인 (Struggling) | 채택 검토 |
| P2 | `long_normal_run` (10판+ → Hard 즉시) | Struggling(42.1%), Streaker(20.0%) | 0.54회/인 (Struggling) | 조건부 검토 |
| P3 | `level_bracket_early` (lv11-30 Hard 차단) | Returning(소폭) | 자연 보호됨 | 불필요 |

[LIMITATION]
1. 승률(Normal 65~90% / Hard 25~70% / SH 10~50%)은 플레이어 유형별 가설값. 실측 데이터로 보정 필요.
2. Returning 유저의 승률 전환(lv30 기준 50→75%)은 단순 계단 함수로 모델링. 실제 복귀 유저는 더 완만한 적응 곡선 가능.
3. Streaker 유저의 사인 곡선 변동(20레벨 주기)은 임의 설정. 실제 핫/콜드 패턴 데이터 없음.
4. win_streak_sh=99로 완전 비활성화된 win_streak 경로가 SH 분포에 미치는 영향 미검증.
5. 맵 풀 소진, 기믹 스케줄, 멀티플레이어 환경 미고려.

---

*Figures:*
- *`.omc/scientist/figures/setB_tier_distribution.png`*
- *`.omc/scientist/figures/setB_rule_firing.png`*
- *`.omc/scientist/figures/setB_condition_type_candidates.png`*
