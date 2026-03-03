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
    │   └── schedule/                 # 주차별 튜토리얼 스케줄 (39개 week 폴더)
    │       ├── week_00_launch/       # 출시 주차 (60개 파일)
    │       ├── week_01/ ~ week_37/   # 이후 주차
    │       └── week_bf_launch/       # 출시 전 주차 (구 week_38, 50개 파일)
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

**CC_DATA/level_data 전체 높이 분포 (3,950개 기준):**
- 평균 높이: 15.85
- 분포 피크: 15~17 범위 (전체의 약 45%)
- 범위: 0.0 ~ 22.63

**높이 기준 맵 운영 정책:**
- `높이 < 19`: 스케줄에 사용 가능
- `높이 >= 19`: 너무 길어서 스케줄에서 제외 → 대체 맵으로 교체

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
| `clearRandomCardCount` | `number` | 클리어 시 드로우덱에서 가져와야 하는 카드 수 |
| `randomCardCount` | `number` | 드로우덱에 배치하는 총 카드 수 |

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
cd /Users/estherpark/solitaire-maps/tutorial_data
python3 convert_cc_to_our.py
```

출력:
- `converted/tutorial_data/` — 36개 파일
- `converted/level_data/` — 3,950개 파일

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

### 스케줄 폴더 구조
- `converted/schedule/week_XX/` — 주차별 맵 목록 (각 60개 파일)
- **파일명 형식:** `{Difficulty}_obj_{ID}_{ID}.json`
- **week 명칭:** `week_00_launch`(출시), `week_01`~`week_37`, `week_bf_launch`(출시 전, 구 week_38)

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
   - 1순위: `converted/level_data/{Difficulty}/` (스케줄 미포함, 높이 < 19)
   - 2순위: `converted/level_data/_excluded/{Difficulty}/` (Normal 등 풀 부족 시)
5. 대체 맵 복사 (같은 난이도, 높이 < 19, 스케줄 미포함)

**교체 결과 (2026-03-03 기준):** 72개 교체 완료, 스케줄 최대 높이 18.99, 평균 15.68

### `_excluded/` 폴더
`converted/level_data/_excluded/{Difficulty}/` — 기본 풀에서 제외했으나 비상 대체용으로 보관.
Normal 난이도 대체 풀이 부족할 때 여기서 보충 (111개 이상 보유).
