# 맵 데이터 기반 렌더링 & 플레이 로직

## 1. 렌더링

```json
{
  "position": {"x": 120, "y": -20},  // 화면 픽셀 좌표 (y-up)
  "angle": 15.0,                      // 회전각 (degrees)
  "depth": 2,                         // 레이어 순서
  "isFaceUp": false                   // 앞면/뒷면
}
```

- **좌표계**: Cocos Creator 2D, 중앙=원점, y 위쪽 양수
- **depth 낮을수록 아래** (depth=0이 바닥층) → 높은 depth가 위에 그려짐
- **isFaceUp=false** → 뒷면(회색) 렌더링, true → 카드 앞면 표시
- 카드 크기는 항상 100×150px, angle로 OBB 회전 적용

---

## 2. 블로킹 판정 (플레이 로직 핵심)

게임 시작 시 **depth+1 카드가 depth 카드를 OBB 충돌로 막는지** 계산:

```
카드 A (depth=1) 가 카드 B (depth=0) 를 막는다
= A와 B의 OBB가 2px 초과로 겹침
```

- B의 blockers = {A} → B는 접근 불가 (facedown)
- A 제거 → B의 blockers = {} → B 즉시 faceup (접근 가능)

**같은 depth 카드끼리 OBB 겹치면** → 아래에 있다고 판단된 카드가 facedown 처리 (착시 문제의 원인)

### OBB 충돌 판정 기준

- 알고리즘: SAT (Separating Axis Theorem)
- 카드 크기: 100×150 px
- 겹침 마진: `OBB_OVERLAP_MARGIN = 2px` (2px 이하 겹침은 충돌 아님)
- 두 카드의 4개 분리축 모두에서 겹침량 > 2px → 충돌(블로킹) 판정

---

## 3. 플레이 흐름

```
게임 시작
  ↓
blockers=0 인 카드만 faceup (선택 가능)
  ↓
플레이어가 카드 선택 (드로우덱 top과 ±1 숫자 매칭)
  ↓
카드 제거 → 그 카드가 블로킹하던 하위 카드들 중
            이제 blockers=0 이 된 카드들 자동 faceup
  ↓
clearRandomCardCount 장을 드로우덱에서 소모하기 전에
모든 필드 카드 제거 → 클리어
```

### 관련 필드

| 필드 | 설명 |
|---|---|
| `randomCardCount` | 게임 시작 시 드로우덱 총 카드 수 (= CC StockPileCount) |
| `clearRandomCardCount` | 클리어에 필요한 최소 드로우 수 (작을수록 쉬움) |
| `isDrawCard: true` | 드로우덱 카드 — 블로킹 판정에서 제외 |

---

## 4. 난이도 조절 포인트

| 요소 | 쉬움 | 어려움 |
|---|---|---|
| `clearRandomCardCount` | 낮음 (덱 적게 써도 됨) | 높음 |
| `open_ratio` (초기 접근 가능 카드 비율) | 높음 (처음부터 선택지 많음) | 낮음 |
| `max_depth` | 낮음 | 높음 (더 많은 카드가 잠김) |
| 같은 위치 스택 | 없음 | 있으면 심리적 압박 |

### clearRandomCardCount 비율 (난이도별)

| 난이도 | 비율 | 예시 (deck=15) |
|---|---|---|
| VeryEasy | 35% | clear=5 |
| Easy | 50% | clear=8 |
| Normal | 65% | clear=10 |
| Hard | 75% | clear=11 |
| VeryHard | 85% | clear=13 |

---

## 5. difficultys 배열

```json
"difficultys": [true, true, false]
//              노말  어려움  아주어려움
```

플레이어가 선택한 난이도에 따라 `clearRandomCardCount`가 다르게 적용됨.  
`false`인 모드는 해당 맵에서 선택 불가.

| 난이도 폴더 | difficultys |
|---|---|
| VeryEasy | `[true, false, false]` |
| Easy | `[true, true, false]` |
| Normal | `[true, true, true]` |
| Hard | `[false, true, true]` |
| VeryHard | `[false, false, true]` |

---

## 6. 알려진 품질 이슈

### 같은 depth 착시 (facedown 버그)
- 원인: 같은 depth 카드끼리 OBB 겹침 → 한 카드가 의도치 않게 facedown
- 조치: `fix_all()` 스크립트로 겹침 해소 (push margin 적용)

### 같은 위치 스택
- 원인: 카드 여러 장이 정확히 같은 (x,y)에 다른 depth로 쌓임
- 증상: 플레이어 눈에 1장처럼 보이나 실제론 여러 장 → 심리적 난이도 상승
- 조치: 스택 쌍 6개 이상 맵은 스케줄에서 제거

### open_ratio 이슈
- 원인: 초기 접근 가능 카드 비율이 20% 미만인 맵 → 실제 체감 난이도 높음
- 조치: 분류된 difficulty_tier보다 한 단계 높은 tier로 재배치 또는 스케줄 제외
