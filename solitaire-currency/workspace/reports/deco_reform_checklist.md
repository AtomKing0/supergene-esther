# 도시 꾸미기 개편 — 개발/QA 실무 가이드
# 도시 꾸미기 개편 — 개발/QA 실무 가이드

> **버전**: v3.0 | **날짜**: 2026-03-23
> **관련 문서**: `11_city_decoration_reform.html` (밸런스+UI명세), `07_tutorial_planning_doc.html` (튜토리얼), `12_deco_reform_dev_guide.html` (Before/After)

---

## 1. 개편 배경 요약

**현행 문제**: 해머가 가득 차면 코어 게임(카드 플레이)을 **차단**하고 강제로 도시 꾸미기로 전환. 유저 자율성 침해 → 이탈 원인.

**개편 방향**: 강제 차단 제거 + 소프트 넛지(말풍선/글로우) + 해머 소실 FOMO로 자발적 꾸미기 유도.

---

## 2. 시트 변경 상세

### 2-1. `meta_decoration_list` 시트 (80행) ✅ 반영 완료

**맥락**: 도시 데코 업그레이드 비용 테이블. 각 도시(16개) × 데코(5개) = 80행.
각 데코는 Stage 1~5까지 업그레이드 가능하며, `cost_hammer_var1~5`(해머)와 `cost_gold_var1~5`(골드)로 비용 정의.

| 항목 | 현행 (BEFORE) | 변경 (AFTER) |
|------|-------------|-------------|
| `cost_gold_var2` (S2 골드) | 도시별 상이 (예: G1=0, G2=50, G3=100...) | **전 도시 0** (S2까지 해머만으로 완성 가능) |
| `cost_gold_var3~5` (S3+ 골드) | 기존값 | **유지** (프리미엄 업그레이드는 골드 필요) |
| `cost_hammer_var1~3` (해머) | 균등 배분 (예: 3/3/3) | **점진 배분 2:3:4** (예: 9해머 → 2/3/4) |

**개발 확인**: 클라이언트에서 `cost_gold_var2` 읽어 업그레이드 비용 표시하는 부분 → 값이 0이면 골드 UI 숨김 처리 필요.

### 2-2. `const` 시트 (+2행) ✅ 반영 완료

**맥락**: 게임 전역 상수 테이블. `key_number` 10001번부터 순번.

| key_number | const_name | 값 | 용도 |
|---|---|---|---|
| 10067 | `hammer_full_stop_reward` | **1** (true) | 해머 가득 시 게임 클리어해도 해머 보상 미지급. 클리어 보상 로직에서 이 상수 체크 필요. |
| 10068 | `hammer_overflow_policy` | **0** (소실) | 0=초과 해머 소실, 1=다음 도시 이월. 현재 소실 정책. |

**개발 확인**: 게임 클리어 보상 지급 함수에서 `hammer_full_stop_reward==1`이면 해머 항목 스킵. `hammer_overflow_policy==0`이면 cap 초과분 버림.

### 2-3. `tutorial_guide` 시트 ⬜ 미반영 (서버 작업 필요)

**맥락**: 튜토리얼/가이드 시퀀스 테이블. 각 행이 하나의 가이드 스텝.

#### 230017 — 유지 (변경 없음)

| 컬럼 | 값 | 설명 |
|------|-----|------|
| key_number | 230017 | |
| content_key | content_city_deco_grad | |
| guide_type | **focus** | 딤+하이라이트+캐릭터+말풍선 |
| play_scene | lobby | |
| trigger_type | **level_clear** | Lv 8 클리어 후 1회 발동 |
| trigger_value | 8 | |
| is_forced | **Y** | 반드시 터치 완료해야 진행 |
| 설명 | 도시 꾸미기 첫 진입 강제 안내 | **이것은 "첫 안내"이므로 강제 맞음. 변경 없음.** |

#### 230026 — 삭제

| 컬럼 | 현행 값 | 조치 |
|------|---------|------|
| key_number | 230026 | **행 전체 삭제** |
| content_key | content_city_deco | |
| guide_type | focus | |
| play_scene | lobby | |
| trigger_type | **condition** | hammer_ready 조건 — 해머 가득 시마다 반복 발동 |
| trigger_value | hammer_ready | |
| is_forced | Y | 강제 전환 |
| 설명 | 도시 꾸미기 강제 (반복) | **이것이 "반복 강제 전환"의 원인. 삭제 대상.** |

**서버 작업**: 230026 행 삭제 후 서버 데이터 리로드. 230017은 건드리지 않음.

---

## 3. 클라이언트 UI 변경 상세

### 3-1. 게임 클리어 결과 화면 (해머 FULL 상태)

**현행**: 클리어 시 보상 행에 해머 아이콘 + 수량 표시. 하단 "받기" + "x2 받기(광고)" 버튼.

**변경**:
- 해머 보상 아이콘: `🔨 +1` → **"FULL" 회색 텍스트 + 취소선** (해머 외 보상은 정상 표시)
- 해머 아이콘 옆 말풍선: "해머가 가득 찼어요! 도시 꾸미기에서 써보세요"
- "x2 받기" 광고 버튼 → **"도시 꾸미기 >>"** CTA 버튼으로 교체
- 해머 FULL 아닌 경우: 기존과 완전 동일 (x1 표시, "x2 받기" 광고 버튼)

**판단 기준**: `현재 해머 >= 해머 최대치` (해당 도시 데코의 남은 해머 합계)

### 3-2. 로비 — 도시 버튼 넛지 (해머 FULL 상태)

**현행**: 도시 버튼(예: "뉴욕 3/15")은 항상 동일한 정적 상태.

**변경** (해머 FULL 감지 시):
- 도시 버튼 위 **말풍선**: "해머가 가득 찼어요! 꾸미기에서 써보세요" → 3초 후 페이드아웃
- 도시 버튼 **글로우(glow) + 바운스 애니메이션**: FULL 해소 전까지 지속
- 도시 버튼 **레드닷**: FULL 해소 전까지 지속
- 말풍선은 **세션당 1회**만 표시 (같은 세션 재진입 시 미표시, 글로우+레드닷만 유지)
- FULL 해소(해머 사용) 시 글로우/레드닷 **즉시 제거**

**구현 위치**: tutorial_guide 시트가 아닌 **클라이언트 로직**으로 구현. 이유: hammer_ready 조건은 세션마다 반복 체크해야 하므로 튜토리얼 시스템(1회성)보다 상시 UI 로직이 적합.

### 3-3. 레벨 진입 화면 (해머 FULL 상태)

**현행**: 보상 미리보기 영역에 해머 아이콘 + 예상 수량 표시. Play 버튼 활성.

**변경**:
- 보상 미리보기 해머: **"FULL" 회색 텍스트** (수량 대신)
- 해머 옆 말풍선: "해머가 가득 찼어요! 꾸미기에서 사용해보세요"
- Play 버튼: **활성 유지** (게임 진입 차단 없음)
- 해머 FULL 아닌 경우: 기존과 완전 동일

### 3-4. 삭제할 기존 로직

**현행 동작 (제거 대상)**:
1. 해머 가득 감지 → 게임 플레이 **차단** (Play 버튼 비활성 또는 강제 전환)
2. 로비에서 강제로 도시 꾸미기 화면으로 전환 (230026 trigger)
3. 꾸미기 완료 전까지 게임 복귀 불가

→ **위 1~3 모두 삭제**. 해머 가득이어도 게임 플레이 자유.

### 3-5. 유지할 기존 로직

- 해머 아이콘 탭 → "NEED HAMMERS?" 팝업 → Play 버튼: **현행 유지**
- 첫 꾸미기 안내 (230017, Lv 8 클리어 후 1회 강제): **현행 유지**
- 도시 완성 보상, 도시 전환 로직: **현행 유지**

---

## 4. 개발 체크리스트

### 클라이언트

- [ ] **[삭제]** 해머 가득 시 게임플레이 차단 로직 제거
- [ ] **[삭제]** 해머 가득 시 강제 꾸미기 전환 로직 제거 (230026 기반)
- [ ] **[유지]** 첫 꾸미기 강제 안내 (230017) — 변경 없음
- [ ] **[신규]** 해머 FULL → 도시 버튼 말풍선 (세션당 1회, 3초 페이드아웃)
- [ ] **[신규]** 해머 FULL → 도시 버튼 글로우+바운스 (FULL 해소 전까지)
- [ ] **[신규]** 해머 FULL → 도시 버튼 레드닷 (FULL 해소 전까지)
- [ ] **[신규]** 게임 클리어: 해머 FULL 시 "FULL" 회색+취소선 + 말풍선
- [ ] **[신규]** 게임 클리어: 해머 FULL 시 "x2 받기" → "도시 꾸미기 >>" CTA
- [ ] **[신규]** 레벨 진입: 해머 FULL 시 보상 "FULL" 회색 + 말풍선
- [ ] **[수정]** `hammer_full_stop_reward=1` → 해머 보상 미지급
- [ ] **[수정]** `hammer_overflow_policy=0` → 초과 해머 소실
- [ ] **[확인]** 해머 아이콘 탭 → "NEED HAMMERS?" 팝업 기존 플로우 유지

### 서버/데이터

- [ ] **[확인]** `meta_decoration_list` 80행 변경 서버 반영
- [ ] **[확인]** `const` 신규 상수 2개 서버 반영 (10067, 10068)
- [ ] **[작업]** `tutorial_guide` 시트 230026 행 삭제 + 서버 리로드

---

## 5. QA 시나리오

### 핵심 시나리오

| # | 시나리오 | 현행 동작 (BEFORE) | 기대 결과 (AFTER) | Pass |
|---|---------|-------------------|-------------------|------|
| 1 | 해머 가득 + 게임 플레이 시도 | 차단됨, 강제 꾸미기 전환 | **차단 없이 정상 플레이** | ☐ |
| 2 | 해머 가득 + 로비 진입 | 강제 꾸미기 전환 (230026) | **도시 버튼 말풍선(3초)+글로우+레드닷** | ☐ |
| 3 | 해머 가득 + 같은 세션 로비 재진입 | 또 강제 전환 | **말풍선 미표시, 글로우+레드닷만 유지** | ☐ |
| 4 | 해머 가득 + 해머 아이콘 탭 | "NEED HAMMERS?" 팝업 | **동일 (변경 없음)** | ☐ |
| 5 | 해머 FULL + 게임 클리어 | 해머 보상 정상 지급 | **"FULL" 회색, 말풍선, "도시 꾸미기>>" CTA, 해머 외 보상 정상** | ☐ |
| 6 | 해머 FULL 아님 + 게임 클리어 | 정상 | **동일 (x1, "x2 받기" 광고)** | ☐ |
| 7 | 해머 FULL + 레벨 진입 | 보상 미리보기 정상 | **"FULL" 회색, 말풍선, Play 활성** | ☐ |
| 8 | 꾸미기로 FULL 해소 | - | **글로우/레드닷 즉시 제거, 다음 클리어 해머 정상 수령** | ☐ |
| 9 | S2 데코 업그레이드 | 골드 필요 | **골드 0 (해머만)** | ☐ |
| 10 | S3 데코 업그레이드 | 골드 필요 | **골드 정상 부과 (변경 없음)** | ☐ |
| 11 | 첫 꾸미기 안내 (Lv 8 클리어 후) | 강제 focus_bubble | **동일 (230017 유지, 변경 없음)** | ☐ |
| 12 | 해머 가득 후 반복 강제 (230026) | 강제 꾸미기 전환 | **발동 안 됨 (230026 삭제됨)** | ☐ |

### 회귀 테스트

- [ ] 해머 미보유 상태 게임 플레이 정상
- [ ] 도시 완성 보상 정상 수령
- [ ] 도시 간 전환 (prev_city_id 체인) 정상
- [ ] 해머 아이콘 탭 → "NEED HAMMERS?" 팝업 정상
- [ ] 부스터 구매/사용 정상 (누진 가격)
- [ ] 방치골드 수령 정상
- [ ] 기타 튜토리얼 가이드 (230001~230025, 230027~230028) 정상 작동

---

## 6. 시트 변경 요약

| 시트 | 변경 내용 | 행 수 | 상태 |
|------|----------|------|------|
| `meta_decoration_list` | S2 골드→0, 해머 점진 2:3:4 | 80행 | ✅ 반영 |
| `const` | hammer_full_stop_reward=1, hammer_overflow_policy=0 | +2행 | ✅ 반영 |
| `tutorial_guide` | 230026 행 삭제 (230017 유지) | -1행 | ⬜ 미반영 |
`;
  var blob = new Blob([md], {type: 'text/markdown'});
  var a = document.createElement('a');
  a.href = URL.createObjectURL(blob);
  a.download = 'deco_reform_checklist.md';
  a.click();
  URL.revokeObjectURL(a.href);
}
</script>

<!-- FOOTER -->
<div class="footer">
  <p><strong>도시 꾸미기 개편 명세서 v3.0</strong> | 2026-03-23 | S3 골드만 유지 + 말풍선 넛지 + 해머 점진 배분(2:3:4)</p>
  <p>출처: <code>01_forced_city_ux_review.md</code> (PM Adjust 판정) | 데이터: <code>PST_meta_decoration_list.json</code>, <code>PST_meta_city_list.json</code></p>
  <p>시트: <code>meta_decoration_list</code> (gid:680706612), <code>meta_city_list</code> (gid:701245569), <code>const</code> (gid:375222820)</p>
  <p style="color:var(--text2);font-size:0.8rem">v3.0: B-1 Before/After 이미지 비교로 전면 교체 + MD 다운로드. v2.6: Before/After 목업 이미지 추가. v2.5: B-1 해머 아이콘 기존 플로우 유지, FULL 넛지를 도시 버튼에 집중. v2.4: 라이브 시트 기준 재시뮬레이션 (umax 전도시=3, 해머 1,386→1,568, 골드 709K→426K). 시트 반영 완료 (meta_decoration_list 80행 + const 2행)</p>
</div>


<script src="https://cdn.jsdelivr.net/npm/mermaid@11/dist/mermaid.min.js"></script>
<script>
  mermaid.initialize({
    startOnLoad: true,
    theme: 'dark',
    themeVariables: {
      primaryColor: '#222635',
      primaryTextColor: '#e0e0e0',
      primaryBorderColor: '#4f7cff',
      lineColor: '#4f7cff',
      secondaryColor: '#1a1d27',
      tertiaryColor: '#2a2d3a',
      fontFamily: 'Pretendard, system-ui, sans-serif',
      fontSize: '14px',
      nodeBorder: '#4f7cff',
      clusterBkg: '#1a1d27',
      clusterBorder: '#333',
      edgeLabelBackground: '#1a1d27'
    },
    flowchart: { curve: 'basis', padding: 15 }
  });
</script>

</body>
</html>