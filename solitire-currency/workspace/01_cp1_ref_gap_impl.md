```yaml
---
agent: 01_pm
mode: cp1
scope: 레퍼런스 갭 분석(08_ref_gap_analysis.md) GAP-1~5 구현 검수
executed: 2026-03-16T23:30:00+09:00
status: complete
verdict: Go (Adjust 3건 수정 완료)
adjust_count: 0 (3건 해소)
source_gap_analysis: workspace/08_ref_gap_analysis.md
files_reviewed:
  - workspace/05_tutorial_system_spec.md (시스템 명세)
  - workspace/06_tutorial_ui_ux_spec.md (UI/UX 명세)
  - workspace/06_tutorial_ui_ux_spec.html (HTML 시각화)
  - Google Sheets unlock/tutorial_guide (라이브 데이터)
---
```

# CP1 검수: 레퍼런스 갭 구현 (GAP-1~5)

## 1. 검수 결과 총괄

| GAP | 항목 | unlock | guide | 05_spec | 06_spec | 06_html | 판정 |
|-----|------|--------|-------|---------|---------|---------|------|
| GAP-1 | 방치골드 수령 | ✅ reuse 50006 | ✅ 230027 | ✅ 9.9a-gap1 | ✅ 12.4 | ✅ flow+map | ⚠️ Adjust-1 |
| GAP-2 | 콜렉션 터치 | ✅ reuse 50010 | ✅ 230028 | ✅ 9.9a-gap2 | ✅ 12.5 | ✅ flow+map | ✅ Go |
| GAP-3 | 졸업 후 도시 | ✅ reuse 50001 | ✅ 230029 | ✅ 9.9a-gap3 | ✅ flow | ✅ flow+map | ⚠️ Adjust-2 |
| GAP-4 | 데일리 휠 | ✅ 50027 신규 | ✅ 230030 | ✅ 9.9a-gap4 | ✅ 12.6 | ✅ flow+map | ⚠️ Adjust-3 |
| GAP-5 | 키락 2단계 | ✅ reuse 50021 | ✅ 230031 | ✅ 9.9b-gap5 | ✅ flow | ✅ flow+map | ✅ Go |

## 2. 수정 필요 항목 (3건)

### Adjust-1: GAP-1 트리거 조건 명확화 — 높음

- **문제**: 05_spec 9.9a-gap1에서 트리거를 "Lv 4+ 로비 재진입 시 방치골드 미수령"으로 정의했으나, 방치골드 수령 후 다시 4h 경과한 경우 재트리거 여부가 모호
- **수정 방향**: "해금 후 **최초 1회**"를 코드 주석 및 조건에 명시. `tutorialState.shownGuides.includes("idle_gold_collect")` 체크로 1회 제한은 되어 있으나, 트리거 설명 표에 "**최초 1회 한정, 이후 수령은 자연 학습**" 문구 추가
- **대상 파일**: `05_tutorial_system_spec.md` (9.9a-gap1 표), `06_tutorial_ui_ux_spec.md` (12.4 표)

### Adjust-2: GAP-3 도시 꾸미기 재유도 — 06_spec 와이어프레임 누락 — 중간

- **문제**: 06_tutorial_ui_ux_spec.md에 GAP-3(졸업 후 도시 꾸미기)의 SCR-02확장 와이어프레임이 없음. 플로우 다이어그램에만 언급됨
- **수정 방향**: §12 또는 별도 §4.1 추가로 SCR-02 확장 와이어프레임 추가 (딤 없이 마스코트 Bubble만 표시하는 경량 가이드)
- **대상 파일**: `06_tutorial_ui_ux_spec.md`

### Adjust-3: GAP-4 Lv 9 해금 순서 충돌 확인 — 중간

- **문제**: Lv 9에서 베팅 x2 해금(기존 SCR-09)과 데일리 휠 해금(GAP-4 SCR-09)이 동시 발생. 해금 팝업 큐 순서가 정의되지 않음
- **수정 방향**: 05_spec 9.9a-gap4에 `UnlockSystem.enqueueSequential()` 호출 순서 명시: 베팅 x2 → 데일리 휠 → SCR-10h 터치 유도. 06_spec 플로우에도 순서 반영
- **대상 파일**: `05_tutorial_system_spec.md` (9.9a-gap4), `06_tutorial_ui_ux_spec.md` (플로우)

## 3. 정상 확인 항목

- ✅ Google Sheets 3대 규칙 준수 (백업·하이라이트·numberValue)
- ✅ unlock 시트 50027 신규 행 — 레벨순 정렬, show_lock_info 적절
- ✅ tutorial_guide 시트 230027~230031 — FK 참조 정확, content_id 일관
- ✅ string_code 매핑 5쌍(10개) 추가 — 네이밍 패턴 일관 (T_TUT_{FEATURE}_TITLE/_DESC)
- ✅ QA 체크리스트 GAP 항목 11개 추가 — 커버리지 충분
- ✅ HTML 시각화 — 총괄표, 플로우, 매핑표, 상황 트리거 모두 반영
- ✅ GAP-6 (해머 부스터) 보류 판정 유지 — 적절

## 4. CP1 판정

**Verdict: Adjust** (높음 1건 + 중간 2건)

3건 수정 후 Go 전환 가능. 구조적 문제 없음.
