# solitaire-maps

CC 게임의 맵 데이터를 우리 게임(solitaire-tripeaks-client) 포맷으로 변환하는 프로젝트.

---

## 폴더 구조

```
solitaire-maps/
├── CC_DATA/
│   ├── level_data/       # CC 게임 일반 레벨 JSON (3,950개) — 3D Unity 포맷
│   └── tutorial_data/    # CC 게임 튜토리얼 레벨 JSON (37개)
├── GH_DATA/              # Solitaire Grand Harvest Unity AssetBundle (참고용)
└── tutorial_data/        # 작업 디렉토리
    ├── convert_cc_to_our.py          # CC → Our 포맷 변환 스크립트
    ├── converted/
    │   ├── tutorial_data/            # 변환 결과 (36개)
    │   ├── level_data/               # 변환 결과 (3,950개)
    │   │   ├── VeryEasy/             # 난이도별 분류 폴더
    │   │   ├── Easy/
    │   │   ├── Normal/
    │   │   ├── Hard/
    │   │   ├── VeryHard/
    │   │   ├── Special/
    │   │   ├── Tutorial/
    │   │   └── _excluded/            # 교체 풀에서 제외된 맵 (VeryEasy~VeryHard)
    │   └── schedule/                 # 주차별 튜토리얼 스케줄 (15개 week 폴더, 1,200개 파일)
    │       ├── week_00_launch/       # 출시 주차 (500개 파일, 5개 서브폴더)
    │       │   ├── chunk_1/          # 100개 파일 (QA 완료)
    │       │   ├── chunk_2/          # 100개 파일
    │       │   ├── chunk_3/          # 100개 파일
    │       │   ├── chunk_4/          # 100개 파일
    │       │   └── chunk_5/          # 100개 파일
    │       ├── week_01/ ~ week_13/   # 이후 주차 (각 50개 파일)
    │       └── week_bf_launch/       # 출시 전 주차 (50개 파일)
    └── GH_map1_levels/               # GH Map1 추출 레벨 (186개)
```

---

## CC 데이터 포맷

**파일 위치:** `CC_DATA/level_data/obj_{id}_{id}.json`, `CC_DATA/tutorial_data/{ordinal}_{id}.json`

### 주요 필드

| CC 필드 | 설명 |
|---|---|
| `Difficulty` | 0=Tutorial, 1=VeryEasy, 2=Easy, 3=Normal, 4=Hard, 5=VeryHard, 6=Special |
| `Tableau[]` | 필드 카드 배열 |
| `Tableau[].Position` | 3D 좌표 `{x, y, z}` — **x=가로축, z=세로축(높이), y≈상수(레이어)** |
| `Tableau[].Rotation` | 카드 회전각 (degrees) |
| `Tableau[].Layer` | 레이어 깊이 (0=맨 아래) |
| `Tableau[].Definition.suit` | 문양 (0=없음/랜덤, 1~4=일반, 9·10=특수덱) |
| `Tableau[].Definition.rank` | 숫자 (0=랜덤, 1~13) |
| `Tableau[].Definition.type` | 카드 타입 (0=일반, 2=특수 등) |
| `Tableau[].Definition.forceFaceUp` | 앞면 강제 표시 (0/1) |
| `StockPileCount` | 드로우덱 총 카드 수 |
| `StockPileRiggedCards[]` | 드로우덱에 사전 지정된 카드 `{Rank, Suit}` |

### CC suit 특이사항
- `suit=0`: 문양 미지정 (랜덤)
- `suit=9, 10`: CC 전용 특수 덱 → 우리 게임에서 사용 불가

### 맵 높이(height) 측정
CC_DATA 파일에서 맵의 세로 길이 = `max(Tableau[].Position.z) - min(Tableau[].Position.z)`

**CC_DATA/level_data 전체 높이 분포 (3,950개 기준, 센터링 적용 후):**
- 평균 높이: 15.68
- 분포 피크: 15~17 범위 (전체의 약 45%)
- 최대: 18.99 (높이 >= 19 맵은 스케줄에서 제거됨)

**높이 기준 맵 운영 정책:**
- `높이 < 19`: 스케줄에 사용 가능
- `높이 >= 19`: 너무 길어서 스케줄에서 제외 → 대체 맵으로 교체

### 수직 센터링 (2026-03-03 적용)
모든 맵 데이터의 수직 위치를 y=0 (또는 z=0) 기준으로 중앙 정렬:

| 파일 형식 | 대상 축 | 적용 방법 | 대상 파일 |
|---|---|---|---|
| CC_DATA (3D Unity) | z축 | `(min_z+max_z)/2`를 각 카드 z에서 차감 | CC_DATA/level_data/ 3,950개 |
| Our 포맷 (2D pixel) | y축 | `round((min_y+max_y)/2)`를 각 카드 y에서 차감 | converted/schedule/ 2,391개 |
| Our 포맷 (2D pixel) | y축 | 동일 | converted/level_data/ 3,933개 |

센터링 후 schedule 최대 center 오차: ±0.5px (카드 간격 35px 대비 무시 가능)

---

## 우리 게임 포맷 (SaveData)

**게임 위치:** `solitaire-tripeaks-client` (Cocos Creator 2.4)
**스테이지 로드:** `StageSelector.loadMaps()` → CloudFront CDN `stage-list.json`
**카드 크기:** `StageModel.CARD_SIZE = {width: 100, height: 150}` px

### 최상위 구조

```json
{
  "difficultys": [true, false, false],
  "stage": {
    "map": "[...카드 배열 JSON 문자열...]"
  },
  "clearRandomCardCount": 2,
  "randomCardCount": 2
}
```

| 필드 | 타입 | 설명 |
|---|---|---|
| `difficultys` | `boolean[3]` | 난이도별 플레이 가능 여부 — **[노말, 어려움, 아주어려움]** |
| `stage.map` | `string` | 카드 배열을 JSON.stringify한 문자열 |
| `clearRandomCardCount` | `number` | 이 스테이지를 클리어하기 위해 드로우덱에서 필요한 카드 수 (작을수록 쉬움) |
| `randomCardCount` | `number` | 게임 시작 시 드로우덱에 주어지는 총 카드 수 = CC_DATA `StockPileCount` |

**⚠️ randomCardCount ≠ clearRandomCardCount** — 두 값이 같으면 모든 덱 카드를 소진해야 클리어 가능(최고 난이도)으로 잘못 설정된 것.

**설정 규칙 (2026-03-03 확정):**
- `randomCardCount` = CC_DATA 파일의 `StockPileCount` 값 그대로 사용
- `clearRandomCardCount` = `randomCardCount` × 난이도별 비율 (반올림, 최소 1)

| 난이도 | 비율 | 예시 (deck=15) |
|---|---|---|
| Tutorial (0) | 35% | clear=5 |
| VeryEasy (1) | 35% | clear=5 |
| Easy (2) | 50% | clear=8 |
| Normal (3) | 65% | clear=10 |
| Hard (4) | 75% | clear=11 |
| VeryHard (5) | 85% | clear=13 |
| Special (6) | 65% | clear=10 |

### 카드 1개 구조 (CardItemData)

```json
{
  "type": 0,
  "symbol": 2,
  "specialType": 0,
  "value": 7,
  "position": {"x": 120, "y": -20},
  "isFaceUp": false,
  "angle": 0,
  "delay": 0,
  "random": false,
  "depth": 0,
  "isDrawCard": false,
  "removeCount": 1,
  "linkedCard": null
}
```

| 필드 | 설명 |
|---|---|
| `type` | CardType (항상 0=일반) |
| `symbol` | 문양 — **1~4만 유효** (0은 random=true 전용 플레이스홀더) |
| `specialType` | CardSpecialType (항상 0=없음) |
| `value` | 카드 숫자 1~13 (0이면 random=true) |
| `position` | 화면 좌표 (px) |
| `isFaceUp` | 앞면 표시 여부 |
| `angle` | 회전각 (degrees) |
| `random` | `true`이면 게임이 런타임에 랜덤 카드로 채움 |
| `depth` | 레이어 깊이 |
| `isDrawCard` | `true`이면 드로우덱 카드 |
| `removeCount` | 제거에 필요한 클릭 수 (기본 1) |
| `linkedCard` | LinkedCard 타입 전용 연결 참조 |

---

## 변환 규칙 (CC → Our)

### 좌표 변환
```
our_x = round(cc_x * 15.0)
our_y = round(cc_z * 16 + (-170))
```
- `SCALE_X = 15.0` — 카드폭 100px 기준, 7unit 간격(96px)이 105px로 확보되도록 조정
- CC의 x축 → our x축 (가로)
- CC의 z축 → our y축 (세로, z 증가 = y 증가)

### Difficulty → difficultys 매핑

| CC Difficulty | our difficultys | 비고 |
|---|---|---|
| 0 Tutorial | `[true, false, false]` | 노말만 |
| 1 VeryEasy | `[true, false, false]` | 노말만 |
| 2 Easy | `[true, true, false]` | 노말+어려움 |
| 3 Normal | `[true, true, true]` | 전체 |
| 4 Hard | `[false, true, true]` | 어려움+아주어려움 |
| 5 VeryHard | `[false, false, true]` | 아주어려움만 |
| 6 Special | `[false, true, true]` | 어려움+아주어려움 |

### symbol (suit) 처리 규칙
- `suit=0` AND `rank=0` → `random=true`, symbol=0 유지 (런타임 랜덤)
- `suit=0` AND `rank≠0` → symbol을 **1~4 랜덤 배정**
- `suit=9, 10` (CC 특수덱) → symbol을 **1~4 랜덤 배정**
- `suit=1~4` → 그대로 사용

### 드로우 카드 (StockPileRiggedCards) 처리
- `Suit=0, Rank=0` → `isDrawCard=true, random=true`
- `Suit` 범위 밖 (0, 9, 10) → 1~4 랜덤 배정 후 `isDrawCard=true, random=false`
- 유효한 Suit(1~4) → 그대로 `isDrawCard=true, random=false`

### isFaceUp 처리
- **tutorial_data**: CC `forceFaceUp` 값 그대로 반영
- **level_data**: 항상 `false` (강제)

### type / specialType
- 항상 `0` (CC 타입 무시)

---

## 변환 스크립트 실행

```bash
cd /Users/estherpark/esther_solitaire/solitaire-esther-1/solitaire-maps/tutorial_data
python3 convert_cc_to_our.py
```

출력:
- `converted/tutorial_data/` — 36개 파일
- `converted/level_data/` — 3,950개 파일

### depth 규칙 (2026-03-04 수정)
CC `Layer` 값을 depth로 그대로 사용. 연속 정수(0,1,2,...)로만 압축.

- CC 디자이너가 지정한 레이어 구조 완전 보존
- y-position 기반 재배열 없음 (레이어 구조가 무너질 수 있어 금지)
- depth 값은 0, 1, 2, ... 연속 정수로 압축 (빈 번호 압축만 허용)

`convert_level()` 내부의 `normalize_depths()` 에서 자동 적용됨.

---

## 전체 재변환 절차

CC_DATA 수정 후 converted/ 전체를 최신 상태로 재생성하는 순서:

```bash
cd /Users/estherpark/esther_solitaire/solitaire-esther-1/solitaire-maps/tutorial_data

# 1. tutorial_data + level_data 재변환 (convert_cc_to_our.py)
python3 convert_cc_to_our.py

# 2. _excluded 재변환 (CC_DATA → converted/level_data/_excluded/)
python3 -c "
import json, os, glob
from convert_cc_to_our import convert_level, DIFFICULTY_PREFIX

cc_dir = '../CC_DATA/level_data'
excluded_dir = 'converted/level_data/_excluded'

for diff in os.listdir(excluded_dir):
    diff_path = os.path.join(excluded_dir, diff)
    if not os.path.isdir(diff_path): continue
    for fname in os.listdir(diff_path):
        if not fname.endswith('.json'): continue
        cc_path = os.path.join(cc_dir, fname.split('_', 1)[1])
        if not os.path.exists(cc_path): continue
        with open(cc_path, encoding='utf-8') as f:
            cc_data = json.load(f)
        our_data = convert_level(cc_data, force_face_down=True)
        with open(os.path.join(diff_path, fname), 'w', encoding='utf-8') as f:
            json.dump(our_data, f, indent=2, ensure_ascii=False)
print('_excluded 재변환 완료')
"

# 3. schedule 업데이트 (level_data 재변환본으로 덮어쓰기)
python3 -c "
import os, shutil

base = 'converted'
schedule_dir = os.path.join(base, 'schedule')
level_dir = os.path.join(base, 'level_data')

updated = 0
for week in os.listdir(schedule_dir):
    week_path = os.path.join(schedule_dir, week)
    if not os.path.isdir(week_path): continue
    for fname in os.listdir(week_path):
        if not fname.endswith('.json'): continue
        difficulty = fname.split('_')[0]
        level_file = os.path.join(level_dir, difficulty, fname)
        if os.path.exists(level_file):
            shutil.copy2(level_file, os.path.join(week_path, fname))
            updated += 1
print(f'schedule 업데이트: {updated}개')
"
```

**주의:** schedule 파일 중 `_excluded/`에서 가져온 교체 맵은 step 3에서 덮어쓰이지 않음 (level_data에 없으므로). 해당 파일은 step 2에서 `_excluded` 재변환 시 이미 최신화됨.

---

## 우리 게임에 스테이지 등록 방법

1. 변환된 JSON 파일 내용을 `JSON.stringify`하여 `StageData.detail` 필드에 저장
2. `stage-list.json` 배열에 항목 추가:
   ```json
   {
     "stage_id": "고유ID",
     "detail": "{\"difficultys\":[...],\"stage\":{\"map\":\"...\"},\"clearRandomCardCount\":2,\"randomCardCount\":2}",
     "publish_at": 타임스탬프
   }
   ```
3. CDN 업로드 (`npm run deploy`)

또는 MapEditor에서 직접 테스트:
- 게임 브라우저 콘솔에서 `window.drawMap(변환된JSON객체)` 호출

---

## 스케줄 관리

### 스케줄 폴더 구조 (2026-03-11 확정)

**전체:** 15개 폴더, 1,200개 맵

| 폴더 | 맵 수 | 비고 |
|---|---|---|
| `week_00_launch/chunk_1~5` | 100개씩 (총 500) | 출시 주차, chunk_1은 QA 완료 |
| `week_bf_launch` | 50개 | 출시 전 주차 |
| `week_01` ~ `week_13` | 50개씩 (총 650) | 이후 주차 |
| `week_14` ~ `week_37` | (삭제됨) | 맵 풀 부족으로 폐기 |

**난이도 배분 비율:** VE+E 65% / N 25% / H-Low 10% (VeryHard 사용 안 함)

**Hard 2단계 분류 (score_difficulty.py 기준):**
- **Hard-Low** (스케줄 사용): score ≤ 67.0 (중앙값) — 189개
- **Hard-High** (스케줄 미사용): score > 67.0 — 189개
- score 공식: `depth×0.20 + cards×0.30 + deck_ratio×0.50` (0~100)

**파일명 형식:** `{Difficulty}_obj_{ID}_{ID}.json`
- **week 명칭:** `week_00_launch`(출시), `week_01`~`week_13`, `week_bf_launch`(출시 전)

### 스케줄 파일과 CC_DATA 파일 연결
스케줄 파일은 우리 게임 포맷(2D 픽셀 좌표)이고, 높이 정보는 CC_DATA에 있음.
높이를 구하려면 파일명에서 `{Difficulty}` 접두사를 제거해 `obj_{ID}_{ID}.json`으로 CC_DATA 파일을 조회.

```python
# 스케줄 파일 → CC_DATA 파일 연결 패턴
schedule_name = "Easy_obj_-123_-123.json"
cc_name = schedule_name.split("_", 1)[1]  # "obj_-123_-123.json"
cc_path = f"CC_DATA/level_data/{cc_name}"
```

### 높이 기준 맵 교체 절차
높이 >= 19인 맵을 스케줄에서 제거하고 대체 맵으로 교체:
1. CC_DATA/level_data/ 전체 z-range 캐시 생성
2. 스케줄에 있는 파일명 세트 구축 (중복 방지용)
3. 높이 >= 19인 맵 식별 (스케줄 파일명 → CC_DATA 조회)
4. 난이도별 대체 풀 구성:
   - `converted/level_data/{Difficulty}/` (스케줄 미포함, 높이 < 19) — **active 풀만 사용**
   - `_excluded/`는 사용 금지
5. 대체 맵 복사 (같은 난이도, 높이 < 19, 스케줄 미포함)

**교체 결과 (2026-03-03 기준):** 72개 교체 완료, 스케줄 최대 높이 18.99, 평균 15.68

### `_excluded/` 폴더
`converted/level_data/_excluded/{Difficulty}/` — 품질 기준 미달 또는 운영 정책으로 제외된 맵 보관 전용.
**schedule 배치 금지.** active 풀 교체 시에도 사용하지 않는다.

---

## 필드 카드 수 분포 (2026-03-05 기준, level_data 3,823개)

| 구간 | 개수 | 비율 |
|---|---|---|
| ~15장 | 38 | 1.0% |
| 16~20장 | 664 | 17.4% |
| 21~25장 | 506 | 13.2% |
| 26~30장 | 1,944 | 50.9% |
| 31~35장 | 541 | 14.2% |
| 36~39장 | 130 | 3.4% |

| 난이도 | 맵수 | 평균 | 중앙값 |
|---|---|---|---|
| VeryEasy | 166 | 24.7 | 24 |
| Easy | 671 | 26.0 | 27 |
| Normal | 1,377 | 27.6 | 29 |
| Hard | 805 | 27.7 | 29 |
| VeryHard | 732 | 26.9 | 29 |
| Special | 36 | 36.5 | 37 |
| Tutorial | 36 | 11.5 | 11 |

**운영 정책:** 필드 카드 40장 이상 맵은 `_excluded/`로 분류 (Special 포함 127개 이동, 2026-03-05)

---

## 데이터 현황 및 알려진 이슈 (2026-03-05 기준)

### 전체 파일 통계

| 위치 | 파일 수 | 상태 |
|---|---|---|
| `converted/level_data/` (active) | VE=411, E=381, N=387, H=378, VH 포함 ~3,914개 | 정상 |
| `converted/level_data/_excluded/` | ~1,822개 | **실질 소진** — 정상 패턴 맵 14개만 존재 (모두 active 복원 완료) |
| `converted/schedule/` | 1,200개 (15폴더) | 2026-03-11 재구성 완료 |
| `converted/tutorial_data/` | 36개 | 정상 |

### 2026-03-05 수정 완료 이슈

**필드 카드 40장 이상 맵 제외 (commit: 7eef566d)**
- 127개를 `level_data/` → `level_data/_excluded/`로 이동 (Easy 1, Hard 1, Normal 1, Special 123, VeryHard 1)
- 해당 맵을 참조하던 스케줄 44개 교체 완료

**같은 depth·컬럼 카드 경계 겹침 수정 (commit: 15e7ab9a)**
- 같은 depth, 같은 x컬럼 내 비회전 카드가 y 간격 < 150px(카드 높이)인 맵 66개
- 수정 방법: `scale_factor = 155 / min_gap`으로 맵 전체 y 좌표 비례 스케일링 후 y-centering 재적용
- 스케줄 42개 동기화

### 잔존 알려진 이슈

**P0: SCALE_X 블로킹 버그 → 수정 완료 (2026-03-05)**
- 원인: `SCALE_X=15` → 7 CC units × 15 = 105px > 카드폭 100px → 블로킹 미감지
- 수정: x좌표 `round(x × 13.75/15)` 일괄 패치 (6,384개 파일)
- 결과: 7 CC units → 96.25px, overlapX=3.75 > 2 → 블로킹 복구. 46개 맵 203개 블로킹 쌍 복원
- **주의: SCALE_X < 14 이어야 함** (14×7=98, overlapX=2, 2>2 FALSE → 블로킹 미감지)

**P1: Tutorial y-centering 실패 2개**
- 파일: `converted/level_data/Tutorial/` 내 2개 파일
- 원인: 초기 변환 시 `SCALE_Z_OFFSET ≈ -35.5` 사용 (현재 -170과 다름)
- 조치: 우선순위 낮음 — Tutorial 파일은 스케줄에 배치되지 않음

### depth 규칙 변경 이력

| 날짜 | 변경 내용 |
|---|---|
| 2026-03-03 | y-position 기반 depth 재계산 로직 도입 |
| 2026-03-04 | **y-position 기반 depth 폐지** — CC Layer 값 직접 사용으로 복원 (commit: fc2b2826) |

**이유:** y-position 기반 재배열이 CC 디자이너 의도(카드 앞/뒤 관계)를 무너뜨리는 것 확인.

---

## ⛔ NOT-TO-DO LIST

### 난이도 분류

- **CC 원본 `Difficulty` 값으로 맵 난이도를 분류하지 말 것**
  CC Difficulty는 참고용이며, 실제 난이도는 아래 스코어 공식으로 산정한다.
  ```
  score = 필드카드수 × 10 + max_depth × 20 + 숨긴카드수 × 15
  ```
  가중치 출처: PST 밸런스시트 CONST 탭 key 10038~10040.

- **카드 수 단일 지표로 난이도를 분류하지 말 것**
  카드 수가 같아도 depth와 숨긴 카드 비율이 다르면 난이도가 크게 달라진다.
  반드시 세 지표(카드수, max_depth, 숨긴카드수) 모두 반영해야 한다.

- **기믹 카드(rope, lock, runner 등)를 난이도 스코어에 포함하지 말 것**
  기믹 가중치(PST 밸런스시트 GIMMICK_WEIGHT 탭)는 맵 플레이 점수 계산용이며,
  맵 선별·난이도 배정 스코어에는 포함하지 않는다.

- **`difficultys` 배열을 수동으로 임의 설정하지 말 것**
  배열은 난이도 폴더명에 따라 아래 규칙으로 자동 결정된다:

  | 난이도 | difficultys |
  |--------|-------------|
  | VeryEasy | `[true, false, false]` |
  | Easy | `[true, true, false]` |
  | Normal | `[true, true, true]` |
  | Hard | `[false, true, true]` |
  | VeryHard | `[false, false, true]` |

### Special 맵

- **Special 맵을 레벨 풀이나 스케줄에 포함하지 말 것**
  Special 맵은 카드 수가 많고(평균 43장) 일반 난이도 구간과 맞지 않는다.
  위치: `_excluded/Special/` — 보관 전용, 스케줄 배치 금지.

- **Special 맵을 난이도 재산정 대상에 포함하지 말 것**
  스코어 계산 및 폴더 재배치 스크립트 실행 시 Special과 Tutorial은 항상 제외한다.

### 품질 문제 맵 제외

- **수치 지표 하나만으로 문제 맵을 판별하지 말 것**
  width, density, max_depth 등 단일 지표는 정상 맵과 범위가 겹쳐 신뢰도가 낮다.
  반드시 아래 세 가지 복합 기준을 함께 사용한다.

- **아래 패턴에 해당하는 맵은 `_excluded`로 이동할 것 (2026-03-09 확정)**

  | 패턴 | 기준 | 설명 |
  |------|------|------|
  | 고립 카드 | `max_nn > 1.5` (카드 크기 정규화) | 가장 가까운 이웃 카드까지 거리가 카드폭 1.5배 초과 |
  | 코너터치 블로킹 다량 | `tiny_bp ≥ 5` AND `tiny_ratio ≥ 25%` | 겹침 면적 < 카드면적 5%인 블로킹 쌍이 5개 이상 |
  | 흩어진 맵+과도한 depth | `rot_ratio > 40%` AND `float_ratio > 30%` AND `max_depth ≥ 8` | 회전 카드 많고 하위 depth를 블로킹하지 않는 카드 비율 높음 |

  - `max_nn`: 각 카드에서 가장 가까운 카드까지의 거리 (x는 CARD_W=100, y는 CARD_H=150으로 정규화)
  - `tiny_bp`: AABB 겹침 면적 < `CARD_AREA × 0.05` 인 인접-depth 블로킹 쌍 수
  - `float_ratio`: depth > 0 이면서 하위 depth 카드를 하나도 블로킹하지 않는 카드 비율
  - `rot_ratio`: `angle % 360 ∉ {0°, 360°}` 인 카드 비율

- **card_map_issue_list.md에 명시된 맵을 active 풀에 두지 말 것**
  수동 검수로 문제가 확인된 맵 목록이며, 발견 즉시 `_excluded`로 이동해야 한다.

### 스케줄 파일

- **난이도 변경 시 level_data만 이동하고 schedule을 방치하지 말 것**
  `schedule/` 내 파일명에도 난이도 접두사가 포함되므로 반드시 함께 갱신해야 한다.
  파일명 형식: `{Difficulty}_obj_{ID}_{ID}.json`

- **`clearRandomCardCount`를 난이도 변경 후 재계산하지 않고 두지 말 것**
  난이도가 바뀌면 비율도 달라지므로 `max(1, round(randomCardCount × ratio))`를 재적용해야 한다.

- **schedule 교체 후 참조 맵이 유효한지 검증하지 않고 두지 말 것**
  level_data에서 맵을 제외하면 schedule에서 해당 파일명이 고아(orphan)가 된다.
  제외 후에는 반드시 active 풀(`level_data/{Difficulty}/`)에서만 대체 맵으로 교체한다.
  `week_00_launch/chunk_1~5=100개씩, 나머지 week=50개` 기준으로 파일 수를 검증한다.
  **week_bf_launch 포함 전체 week 확인 필수** — 특정 week가 누락되기 쉬움.

- **`_excluded/` 맵을 schedule에 사용하지 말 것**
  `_excluded/`는 품질 기준 미달 또는 운영 정책 제외 맵 보관 전용이다.
  active 풀이 소진된 경우에도 `_excluded/` 사용 불가 — 해당 week의 맵 수를 줄이는 것이 올바른 처리다.

- **`_excluded/` 풀은 2026-03-11 기준 실질 소진 상태임을 인지할 것**
  1,822개 중 정상 패턴(rot_ratio ≤ 15%, col_gap ≥ 96px, height ≤ 400px, 10 ≤ n ≤ 45) 통과 맵 14개 — 모두 active로 복원 완료.
  나머지 98.7%는 scattered 맵(min_gap ≤ 50px, 회전 카드 다량) — 사용 불가.

- **간격 조정 수정으로 복원된 맵은 active 풀에 사용 가능**
  x-column 간격이 96~99px인 borderline 맵은 _excluded에서 꺼내 간격 수정 후 active 풀 복원이 허용된다.
  수정 방법: x 컬럼 중심을 평균에서 `target_gap(105px) / current_min_gap` 비율로 확장, 카드 x좌표 재매핑.
  **최소 인터컬럼 간격 기준: 100px 이상 (안전 목표 105px)**
