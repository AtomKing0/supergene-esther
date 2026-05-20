# PST Funnel Dashboard 업데이트 가이드

**파일 위치:** `supergene-esther/17_pst_funnel_dashboard.html`  
**배포 URL:** https://atomking0.github.io/supergene-esther/17_pst_funnel_dashboard.html

---

## 필요한 BQ 데이터 소스

| 파일 | 내용 | 용도 |
|------|------|------|
| File 1 (전체 퍼널) | `client_version`, `event_name`, `nru_count` 등 | HISTORY 배열 (전체유저) |
| File 2 (오가닉 퍼널) | `client_version`, `event_name`, `nru_count` 등, organic segment 필터됨 | DATA_ORGANIC_VER 배열 |
| File 3 (오가닉 NRU) | `client_version`, `date`, `nru_count` | 오가닉 모수 확인용 |
| File 4 (로딩 시간) | `client_version`, `avg_load_complete_time_ms`, `median_load_complete_time_ms` | 로딩 패널 |

> **파싱 주의:** Google Drive API로 받은 CSV는 `\_` (마크다운 이스케이프)가 포함될 수 있음.  
> 파싱 전 `.replace('\\_', '_')` 처리 필수.

---

## 업데이트 항목별 작업 순서

### 1. HISTORY 배열 (전체유저)

`const HISTORY = [...]` 배열에 새 버전 항목 추가.

**퍼널 이벤트 → 지표 매핑:**

| 지표 | BQ 이벤트명 |
|------|-------------|
| `players` | `INTRO_LOGIN` (없으면 `1000_LOGIN_COMPLETE`) |
| `start` | `2000_GAME_START` / players × 100 |
| `touch` | `2200_FIRST_TOUCH` / players × 100 |
| `finish` | `2400_FIRST_ROUND_FINISH` / players × 100 |
| `rounds` | `(sum of round finish events)` / players |
| `rvPerRound` | RV impression count / total rounds played |

**버전 기간에 여러 날짜가 포함되면 weighted average 적용:**
```
touch_rate = sum(touch_count per date) / sum(players per date) × 100
```

**항목 속성:**
- `base: true` — 기준 버전 (v136)
- `minor: true` — 마이너 버그픽스
- `noise: true` — 유입 구조 변경으로 노이즈 있음 (v170 이후)
- `latest: true` — 최신 버전 1개만

---

### 2. DATA_ORGANIC_VER 배열 (오가닉)

`const DATA_ORGANIC_VER = [...]` 배열에 새 버전 항목 추가.

- File 2에서 organic segment 행만 추출
- `n` = File 3의 해당 버전 NRU 수 (오가닉 모수)
- File 2에 `INTRO_LOGIN` 없으면 `1000_LOGIN_COMPLETE` 사용
- 날짜 범위가 기존 버전과 겹치면 scale factor 적용:
  ```
  scale = File3_NRU(해당날짜) / File2_login(해당날짜)
  ```
- `post: true` — 스마트발송 이후 버전
- `latest: true` — 최신 1개

---

### 3. 로딩 패널

`#panel-load` 블록 업데이트. **중앙값(`median_load_complete_time_ms`) 사용.**

**표시 기준:** 빌드노트에 로딩 관련 작업이 명시된 버전만 표시  
(참고 시트: https://docs.google.com/spreadsheets/d/1fFIDUT0Hu5qgAcP1EiNtLX0S1j3nWgXgM4Xo4VuECbE)

**바 너비 계산:**
```
width% = (버전 중앙값 ms / v136 중앙값 ms) × 100
```

**색상 기준:**
- 빨강: v136 기준 (100%)
- 초록 (`#2CB87A`): 기준 대비 개선
- 주황 (`#E8832A`): 기준보다 나빠진 경우

**개선율:**
```
delta = (v136_median - 버전_median) / v136_median × 100  →  "-XX.X%"
```

---

### 4. index.html 날짜/버전 정보

`index.html` 내 PST 항목 업데이트:
- 마지막 업데이트 날짜
- 최신 버전 및 모수 (예: `PST v180 · n=61`)

---

## 배포

```bash
cd /Users/estherpark/supergene-esther

git add 17_pst_funnel_dashboard.html index.html
git commit -m "feat: PST dashboard update vXXX (YYYY-MM-DD)"
git push origin main
```

GitHub Pages 반영까지 1~3분 소요. 캐시 문제 시 강력 새로고침(`Cmd+Shift+R`).

---

## 자주 발생하는 이슈

| 상황 | 원인 | 해결 |
|------|------|------|
| CSV 파싱 오류 | `\_` 마크다운 이스케이프 | `.replace('\\_', '_')` 전처리 |
| 오가닉 모수 불일치 | File 2 login ≠ File 3 NRU | File 3 기준으로 scale factor 적용 |
| 로딩 avg/median 차이 큼 | 아웃라이어 영향 | 중앙값 사용 (현재 적용 중) |
| GitHub Pages 미반영 | 캐시 | 1~3분 대기 후 강력 새로고침 |

---

## 모니터링 기준

- 신규 버전은 **n ≥ 200명** 달성 후 수치 확정
- 오가닉은 **n ≥ 100명** 기준
- 로딩 목표: v146 수준 (중앙값 ~2,858ms) 유지
