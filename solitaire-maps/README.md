# solitaire-maps

CC 게임의 맵 데이터를 우리 게임(solitaire-tripeaks-client) 포맷으로 변환하고, 서비스 업데이트 스케줄별로 분류한 프로젝트.

---

## 폴더 구조

```
solitaire-maps/
├── CC_DATA/
│   ├── level_data/          # CC 원본 일반 레벨 JSON (3,950개)
│   └── tutorial_data/       # CC 원본 튜토리얼 레벨 JSON (37개)
├── GH_DATA/                 # Solitaire Grand Harvest 참고 데이터
└── tutorial_data/
    ├── convert_cc_to_our.py # 변환 스크립트
    └── converted/
        ├── tutorial_data/   # 변환된 튜토리얼 (36개)
        ├── level_data/      # 변환된 일반 레벨 (난이도별 분류)
        └── schedule/        # 업데이트 스케줄별 맵 묶음
```

---

## 변환 결과 (level_data)

### 난이도별 변환 현황

| 난이도 | 전체 | 사용 가능 | 화면 초과 제외 |
|---|---|---|---|
| Tutorial | 36 | 36 | 0 |
| VeryEasy | 166 | 156 | 10 |
| Easy | 672 | 613 | 59 |
| Normal | 1,378 | 1,261 | 117 |
| Hard | 806 | 755 | 51 |
| VeryHard | 733 | 668 | 65 |
| Special | 159 | 119 | 40 |
| **합계** | **3,950** | **3,608** | **342** |

> **화면 초과 기준:** 카드 배치 총 너비 > 1,045px (화면 기준 950px × 1.1)
> 초과 맵은 `level_data/_excluded/` 폴더에 분리 보관

### 파일명 규칙

출력 파일명 앞에 CC Difficulty 값을 prefix로 표기:

```
Tutorial_obj_xxx.json
VeryEasy_obj_xxx.json
Easy_obj_xxx.json
Normal_obj_xxx.json
Hard_obj_xxx.json
VeryHard_obj_xxx.json
Special_obj_xxx.json
```

---

## 업데이트 스케줄 (schedule/)

Special·Tutorial은 스케줄에서 제외. 사용 대상: VeryEasy·Easy·Normal·Hard·VeryHard.

### 비율 정책 (100개 기준)

| 분류 | 난이도 | 비율 |
|---|---|---|
| 매우 어려움 | VeryHard | 6% |
| 어려움 | Hard | 12% |
| 쉬움·보통 | VeryEasy + Easy + Normal | 82% |

### 런칭 스펙 (week_00_launch) — 500개

| Hard | VeryHard | VeryEasy | Easy | Normal | 합계 |
|---|---|---|---|---|---|
| 60 | 30 | 31 | 123 | 256 | **500** |

### 주간 업데이트 (week_01 ~ week_38) — 50개씩

| Hard | VeryHard | VeryEasy | Easy | Normal | 합계 |
|---|---|---|---|---|---|
| 6 | 3 | 3 | 12 | 26 | **50** |

### 지속 가능 기간

| 구분 | 수량 |
|---|---|
| 런칭 | 1회 (500개) |
| 주간 업데이트 | 38주 (× 50개) |
| **총 서비스 기간** | **약 9.5개월** |
| **총 배포 맵 수** | **2,400개** |

> **bottleneck:** Normal 레벨이 38주 후 먼저 소진
> 미배정 잔여: VeryEasy 11개, Easy 34개, Normal 17개, Hard 467개, VeryHard 524개

---

## 변환 스크립트 실행

```bash
cd /Users/estherpark/solitaire-maps/tutorial_data
python3 convert_cc_to_our.py
```

- `converted/tutorial_data/` — 튜토리얼 36개
- `converted/level_data/{난이도}/` — 일반 레벨 난이도별 분류

---

## 게임 등록 방법

변환된 JSON을 `JSON.stringify`하여 `StageData.detail`에 저장 후 `stage-list.json`에 추가:

```json
{
  "stage_id": "고유ID",
  "detail": "{\"difficultys\":[...],\"stage\":{\"map\":\"...\"},\"clearRandomCardCount\":2,\"randomCardCount\":2}",
  "publish_at": 타임스탬프
}
```

CDN 배포: `npm run deploy`

MapEditor 로컬 테스트: 브라우저 콘솔에서 `window.drawMap(변환된JSON객체)` 호출
