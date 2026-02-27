# CLAUDE.md — Candy Solitaire 역공학 분석 프로젝트

## 프로젝트 개요

King/Activision Blizzard의 Candy Solitaire(`com.king.apps.candysolitaire`)
Android APK를 역공학하여 재화·보상·경제 시스템을 분석하는 프로젝트.

| 항목 | 내용 |
|------|------|
| 대상 앱 | com.king.apps.candysolitaire |
| 내부 코드명 | **Bonsai** (IAP 접두사) / **Nirvana** (C# 네임스페이스) |
| 엔진 | Unity IL2CPP (Android) |
| 분석 소스 | APK 디컴파일 Java + Unity Addressable 카탈로그 |

---

## 디렉토리 구조

```
solitire-currency/
├── CLAUDE.md                        ← 이 파일
├── decompiled_java/
│   ├── sources/                     ← jadx로 디컴파일된 Java 소스 (1,300+ 파일, 대부분 난독화)
│   │   ├── bo/app/                  ← 게임 앱 메인 패키지 (난독화 클래스)
│   │   ├── com/king/store/          ← King 공식 BillingManager (Google Play IAP)
│   │   └── com/king/google/billing/ ← Google Billing 연동 글루 코드
│   └── resources/
│       └── assets/aa/
│           └── catalog.json         ← ★ Unity Addressable 에셋 카탈로그 (핵심 분석 소스)
└── docs/
    └── 04-report/features/
        ├── candy-solitaire-currency-analysis.report.md   ← 분석 보고서 (Markdown)
        └── candy-solitaire-currency-analysis.html        ← 분석 보고서 (HTML 시각화)
```

---

## 분석 방법론 & 핵심 원칙

### 1. 주요 분석 소스는 catalog.json

Unity IL2CPP 게임 로직은 C# → 네이티브 컴파일되어 Java 소스에서 찾을 수 없다.
**실질적인 구조 분석은 `catalog.json`의 `m_InternalIds` 배열에서 수행한다.**

```python
# catalog.json 분석 기본 패턴
import json
with open('decompiled_java/resources/assets/aa/catalog.json') as f:
    data = json.load(f)
ids = data['m_InternalIds']
hits = [x for x in ids if 'KEYWORD' in str(x)]
```

### 2. 코드 출처 반드시 분리

바이너리에는 여러 King 게임 코드가 공유 SDK로 번들됨. **오인 금지.**

| 접두사 | 실제 게임 | 분석 포함 여부 |
|--------|----------|--------------|
| `King.Nirvana.*` / `Solitaire.*` / `Bonsai*` | **Candy Solitaire (본 게임)** | ✅ 포함 |
| `FARM_KING_*` | Farm Heroes Saga | ❌ 제외 |
| `DiamondDigger*` | Diamond Digger Saga | ❌ 제외 |
| `Muffin*` | 별도 King 음식트럭 게임 | ❌ 제외 |

### 3. 서버 설정값 vs 카탈로그 확정값 구분

| 구분 | 예시 | 신뢰도 |
|------|------|--------|
| **카탈로그 확정** | Betup x1/x2/x4/x8, OnFire Tier 0~3, PiggyBank 3단계 | ✅ 확정 |
| **필드명 재구성** | Coin 보상 계산식 구조 | ⚠️ 구조만 확정, 수치는 서버 |
| **서버 설정값** | CoinRewardTLB 실제 수치, EntryCost, StreakMultiplier 배율 | ❌ 실기기 필요 |

---

## 핵심 발견사항 (v4.0 확정)

### IAP 구조
- **직접 코인 구매 방식** — 보석→골드 변환 2단계 없음
- `BonsaiSoftCurrency` = Coins 직접 구매
- `BonsaiHardCurrency` = 건물·레시피 콘텐츠 잠금 해제 전용 (코인 변환 불가)

### 재화 종류
| 재화 | 코드 | 획득 | 소모 |
|------|------|------|------|
| Coins | `King.Nirvana.Simulation\|Coins` | 레벨 클리어, IAP 직구 | 입장료, 부스터 |
| Energy | `King.Nirvana.Simulation\|Energy` | 레벨 클리어 후 | 꾸미기 Task |
| StreakStar | `King.Nirvana.Simulation\|Stars` | 스트릭 달성 시 | 토너먼트 점수 |
| FreeEntry | `King.Nirvana.Simulation\|FreeEntry` | 이벤트/TLB/광고 | 입장료 대체 |

### Betup 배율 (카탈로그 확정)
- `Betup_x1_mat`, `Betup_x2_mat`, `Betup_x4_mat`, `Betup_x8_mat` — **x1/x2/x4/x8 4단계**

### OnFire 단계 (카탈로그 확정)
- `onfire_tier_0/1/2/3.png` (각 normal + open 2상태) — **Tier 0~3 4단계**
- `ui_OnFireWidgetStageSlot.prefab` — 슬롯당 1연승
- `vfxui_betup_x8_constant.prefab` — OnFire 폴더 위치 → Tier 3에서 x8 해제

### Coin 보상 계산 패턴 (필드 재구성)
```
Coins = BaseReward(TLB조회)
      × StreakMultiplierValue
      + (남은카드수 × PerCardFactor)
      + EpisodeFinishedCoinReward  (에피소드 완료 시)
      + BonusLevelCoins            (보너스 레벨 시)
      × BetupMultiplier            (x1/x2/x4/x8)
```

### 숍 실제 가격대 (카탈로그 확정)
`$1.99` / `$2.99` / `$3.99` / `$5.99` / `$14.99` / `$19.99` / `$24.99` / `$34.99` / `$49.99` / `$99.99`

---

## 보고서 업데이트 규칙

### 버전 관리
- 보고서는 `v1.0`부터 시작하며 수정마다 마이너 버전 증가
- 현재: **v4.0** (2026-02-27)
- 파일: `docs/04-report/features/candy-solitaire-currency-analysis.report.md`
- HTML: `docs/04-report/features/candy-solitaire-currency-analysis.html`

### 수정 시 주의사항
1. `.report.md`와 `.html` 양쪽 동시 업데이트
2. 수정 내역 테이블 상단에 추가 (이전 오류 → 수정 내용)
3. 카탈로그 확정 사항은 `✅ 카탈로그 근거:` 형식으로 출처 명시
4. 서버 설정값은 항상 `⚠️ 서버 설정값` 경고 표시 유지
5. HTML의 `<title>` 태그와 사이드바 버전 문자열도 함께 갱신

---

## 추가 분석이 필요할 때

### catalog.json에서 키워드 검색
```bash
python3 scripts/catalog_search.py KEYWORD
python3 scripts/catalog_search.py OnFire Betup Streak  # 여러 키워드
```

### Java 소스에서 클래스/메서드 검색
```bash
bash scripts/source_grep.sh "CoinReward\|BoosterCost\|EntryCost"
```

### Settings 에셋 전체 목록
```bash
python3 scripts/catalog_search.py --settings
```

### 보고서 버전 업데이트
```bash
bash scripts/bump_version.sh 4.1
```

---

## 미결 사항 (실기기 분석 필요)

실기기 + 네트워크 패킷 캡처로만 확인 가능한 서버 설정값들:

- `CoinRewardTLB` 실제 수치 테이블
- 레벨별 `EntryCost` 수치
- `StreakMultiplier` 실제 배율 범위
- `OnFire` 각 Tier 달성 조건 (연승 N회)
- `PiggyBank` 누적 한도 및 파괴 가격
- 부스터 Coins 가격 (`BoosterCostSetting`)
- Energy Task별 실제 소모량
