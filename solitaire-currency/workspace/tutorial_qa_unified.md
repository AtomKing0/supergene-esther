# PST 튜토리얼 시스템 — QA 통합 문서

> **목적**: QA 팀이 튜토리얼 시스템을 검증하기 위한 통합 테스트 명세
> **최종 수정**: 2026-03-18 (v7 시트 재키잉 반영)
> **데이터 소스**: Google Sheets `1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk` (unlock, tutorial_guide)

---

## 1. 시스템 요약

| 항목 | 값 |
|------|-----|
| 전체 구조 | 2-시트: unlock(26행) + tutorial_guide(28행) |
| Phase 수 | 7개 (Phase 0~6) |
| guide_type | focus_bubble(22건, 강제) / floating(7건, 비강제) |
| trigger_type | 5종: level_clear(15), first_appear(7), condition(2), tutorial_level(2), touch(2) |
| 강제 클리어 스테이지 | **Lv 1~3** (정해진 카드만 터치, 무조건 클리어) |
| Tutorial 티어 | Lv 1~8 (help_card_rate 80%, pity 3회) |
| Normal 전환 | Lv 9~ (help_card_rate 50%, pity 5회) |

---

## 2. 전체 테스트 플로우

```
[NRU 앱 시작]
    │
    ▼ Lv 1 (로비 스킵 → 인게임 즉시)
┌──────────────────────────┐
│ Phase 0: 카드 매칭 기본   │  S1-1 → S1-2 → S1-3 → S1-4(클리어)
│ 입력 제한 ON, 입장료 0    │
└──────────┬───────────────┘
           │ 클리어 → 로비 도달
           ▼
┌──────────────────────────┐
│ 230003: 게임시작 버튼 강제 │  focus_bubble, 반드시 터치
└──────────┬───────────────┘
           │ Lv 2 플레이
           ▼
┌──────────────────────────┐
│ Phase 1: 덱 뒤집기       │  S2-1 → S2-2(클리어)
│ 입력 제한 ON, 입장료 0    │
└──────────┬───────────────┘
           │ 클리어 → 프리레벨 팝업 해금(230005)
           ▼
┌──────────────────────────┐
│ Phase 2: Lv 3~4          │  상점, 방치골드, 출석체크, 플러스카드
│ Lv 3: 입장료 시작         │  Lv 3도 강제 클리어 스테이지
└──────────┬───────────────┘
           ▼
┌──────────────────────────┐
│ Phase 3: Lv 5~7          │  스트릭, 리더보드, 콜렉션, 와일드 FREE×3
└──────────┬───────────────┘
           ▼
┌──────────────────────────┐
│ Phase 4: Lv 8            │  파이어웍스/언두/엑스트라덱 FREE×3, 도시꾸미기
│ ★ Tutorial 클리어         │
└──────────┬───────────────┘
           ▼ Lv 9~: Normal/DDA 전환
┌──────────────────────────┐
│ Phase 5~6: Lv 9~24       │  베팅, 데일리휠, 이벤트, 기믹, 골든티켓
│ 해금 팝업만               │
└──────────┬───────────────┘
           ▼ Lv 25: COMPLETED
```

---

## 3. Phase별 QA 체크리스트

### Phase 0 (Lv 1)

- [ ] NRU 첫 진입 시 로비 스킵 → 바로 인게임
- [ ] NRU 시작 골드 2,000G 지급 확인
- [ ] S1-1 순차 하이라이트 (필드→드로우→오픈) 0.8초 간격
- [ ] S1-2 **매칭 불가 카드 탭 → 카드 흔들기 0.3초 + 올바른 카드 깜빡임 3회**
- [ ] S1-2 5초 무행동 → 매칭 가능 카드 힌트 깜빡임
- [ ] S1-2 3회 매칭 후 자유 플레이 전환
- [ ] 클리어 시 골드 1,000G + α 표시
- [ ] **입장료 0 확인 (Lv 1~3)**
- [ ] 덱 소진+매칭 불가 시 **자동 5장 추가 드로우** 발동 (1회 한정)
- [ ] **Lv 1 클리어 후 로비 → 게임 시작 버튼 focus_bubble 강제 (230003)**

### Phase 1 (Lv 2)

- [ ] S2-1 이동 불가 시 드로우 덱 하이라이트
- [ ] S2-1 드로우 덱 외 터치 → 피드백 (터치 거부)
- [ ] **입력 제한 ON** (Lv 1~3 동일)
- [ ] Lv 2 클리어 후 **프리레벨 팝업 해금 (230005, val=2)**
- [ ] 프리레벨 팝업에서 참가비·보상·부스터 UI 안내

### Phase 2 (Lv 3~4)

- [ ] **Lv 3부터 입장료 차감 시작** (이전 레벨과 비교 확인)
- [ ] **Lv 3도 강제 클리어 스테이지** (입력 제한 ON, 무조건 클리어)
- [ ] Lv 3 상점 아이콘 focus_bubble (230004)
- [ ] Lv 4 **방치골드→수령→출석체크 순차 강제 플로우** (3단계 모두 완료 필수)
  - [ ] 230006 방치골드 해금
  - [ ] 230008 방치골드 수령 터치 유도
  - [ ] 230009 출석체크 터치 유도
- [ ] Lv 4 인게임: 플러스카드 첫 등장 시 가이드 (230007)

### Phase 3 (Lv 5~7)

- [ ] Lv 5 스트릭 미터 2연속 매칭 시 가이드 (230010)
- [ ] Lv 5 리더보드 아이콘 터치 유도 (230011)
- [ ] Lv 6 콜렉션 해금 + 터치 유도 (230012)
- [ ] Lv 7 와일드 카드 인게임 **floating** 가이드 (**탭 스킵 가능**, 230013)
- [ ] Lv 7 와일드 카드 **FREE×3 무료 지급** 확인
- [ ] Lv 7 전용맵 TUTO_0007 사용 확인

### Phase 4 (Lv 8)

- [ ] 파이어웍스 프리레벨 focus_bubble + **FREE×3** (230014)
- [ ] 언두 **floating** 가이드 (**비강제, 탭 스킵**, 230015)
- [ ] 언두 **FREE×3** 지급 확인
- [ ] 엑스트라 덱 **상황 기반** (덱 소진+매칭 불가) **floating** (230016)
- [ ] 엑스트라 덱 **FREE×3** 지급 확인
- [ ] 도시 꾸미기 강제 (230017, 망치 충족 시)

### Tutorial → Normal 전환 (Lv 8 → Lv 9)

- [ ] **help_card_rate 80% → 50%** 전환 확인
- [ ] **pity_trigger 3회 → 5회** 전환 확인
- [ ] **맵 풀 전환** (tutorial_guide 전용맵 → schedule)
- [ ] Lv 9~10 Normal 고정 (DDA 비활성)
- [ ] Lv 11~ DDA 활성화

### Phase 5~6 (Lv 9~24)

- [ ] Lv 9 베팅x2(230018) → 데일리 휠(230019) **순차** 해금 (순서 고정)
- [ ] Lv 11 IAP 팝업 노출 시작 (닫기 가능)
- [ ] Lv 12 이벤트 강제 터치 유도 (230020)
- [ ] Lv 14 러너 카드 인게임 focus_bubble (230021)
- [ ] Lv 17 베팅x4 해금 (230022)
- [ ] Lv 19 자물쇠+열쇠 인게임 focus_bubble (230023)
- [ ] Lv 22 얼음카드 인게임 focus_bubble (230024)
- [ ] Lv 24 골든 티켓 **FREE×3** (230025)

### 상시 반복 가이드

- [ ] 도시 꾸미기 강제 **매 구역 반복** (230026, is_repeatable=TRUE)
- [ ] 키락 카드 터치 시 floating 말풍선 **반복** (230027)
- [ ] 얼음카드 터치 시 floating 말풍선 **반복** (230028)

### 공통 검증

- [ ] 모든 focus_bubble 가이드에서 **터치 완료 필수** (닫기/스킵 불가)
- [ ] 모든 floating 가이드에서 **탭 스킵 가능**
- [ ] 동일 가이드 **중복 표시 없음** (1회 제한)
- [ ] 앱 종료 후 재진입 → 현재 Phase·스텝 복원
- [ ] 무료 부스터 UI에 "FREE ×3" 표기
- [ ] 무료 부스터 소진 후 유료 전환 정상

---

## 4. UI 컴포넌트 검증 사양

### 4.1 Focus Bubble (강제, 22건)

| 항목 | 기대값 |
|------|--------|
| 딤 배경 | alpha 0.3~0.4 (Phase 0 S1-1만 딤 없음) |
| 대상 강조 | 하이라이트 mask |
| 말풍선 | 흰색 라운드 사각형 + 꼬리 (target 방향) |
| 마스코트 아이콘 | 원형 48×48px, Bubble 좌상단 |
| 터치 | 대상 외 영역 터치 차단 |

### 4.2 Floating (비강제, 7건)

| 항목 | 기대값 |
|------|--------|
| 딤 배경 | **없음** |
| 말풍선 | 반투명, 캐릭터+말풍선 |
| 스킵 | 화면 아무 곳 탭 → 즉시 닫힘 |

### 4.3 Feedback (오류)

| 타입 | 동작 |
|------|------|
| SHAKE | 좌우 ±5px, 3회, 0.3초 |
| BLINK | alpha 0→1→0, 3회, 0.5초 간격 |

### 4.4 FreeTag

| 항목 | 기대값 |
|------|--------|
| 텍스트 | `FREE ×3` |
| 위치 | 대상 부스터 버튼 상단 |
| 적용 대상 | 언두(Lv 8), 와일드(Lv 7), 엑스트라 덱(상황), 파이어웍스(Lv 8), 골든 티켓(Lv 24) |

### 4.5 타임아웃 힌트 (Lv 1~8)

| 항목 | 기대값 |
|------|--------|
| 타이머 | 5,000ms 무행동 |
| 힌트 | 매칭 가능 카드 1개 Blink ×3 |
| 매칭 불가 시 | 드로우 덱 Blink |
| 리셋 | 유저 행동 시 0으로 |
| Lv 9+ | **비활성** |

---

## 5. tutorial_guide 시트 전체 (28행)

| key | content_id | guide_type | play_scene | trigger_type | trigger_value | is_forced | is_repeatable |
|-----|-----------|------------|------------|-------------|---------------|-----------|---------------|
| 230001 | content_ingame_intro | floating | ingame | tutorial_level | 1 | N | N |
| 230002 | content_deck_draw | floating | ingame | tutorial_level | 2 | N | N |
| 230003 | content_lobby_play | focus_bubble | lobby | level_clear | 1 | Y | N |
| 230004 | content_shop | focus_bubble | lobby | level_clear | 3 | Y | N |
| 230005 | content_pre_level_popup | focus_bubble | pre_level | level_clear | 2 | Y | N |
| 230006 | content_idle_gold | focus_bubble | lobby | level_clear | 4 | Y | N |
| 230007 | gimmick_plus_card | focus_bubble | ingame | first_appear | 4 | Y | N |
| 230008 | content_idle_gold_collect | focus_bubble | lobby | level_clear | 4 | Y | N |
| 230009 | content_daily_check | focus_bubble | lobby | level_clear | 4 | Y | N |
| 230010 | content_streak | focus_bubble | ingame | first_appear | 5 | Y | N |
| 230011 | content_leaderboard | focus_bubble | lobby | level_clear | 5 | Y | N |
| 230012 | content_collection | focus_bubble | lobby | level_clear | 6 | Y | N |
| 230013 | booster_wild_card | floating | ingame | first_appear | 7 | N | N |
| 230014 | booster_fireworks | focus_bubble | pre_level | level_clear | 8 | Y | N |
| 230015 | booster_undo | floating | ingame | first_appear | 8 | N | N |
| 230016 | booster_extra_deck | floating | ingame | condition | deck_exhausted | N | N |
| 230017 | content_city_deco_grad | focus_bubble | lobby | level_clear | 8 | Y | N |
| 230018 | content_betting_2 | focus_bubble | lobby | level_clear | 9 | Y | N |
| 230019 | content_daily_wheel | focus_bubble | lobby | level_clear | 9 | Y | N |
| 230020 | content_event_forced | focus_bubble | lobby | level_clear | 12 | Y | N |
| 230021 | gimmick_runner_card | focus_bubble | ingame | first_appear | 14 | Y | N |
| 230022 | content_betting_4 | focus_bubble | lobby | level_clear | 17 | Y | N |
| 230023 | gimmick_lock_key | focus_bubble | ingame | first_appear | 19 | Y | N |
| 230024 | gimmick_rope_card | focus_bubble | ingame | first_appear | 22 | Y | N |
| 230025 | booster_golden_ticket | focus_bubble | lobby | level_clear | 24 | Y | N |
| 230026 | content_city_deco | focus_bubble | lobby | condition | hammer_ready | Y | Y |
| 230027 | gimmick_lock_key_tip | floating | ingame | touch | lock_card | N | Y |
| 230028 | gimmick_rope_card_tip | floating | ingame | touch | rope_card | N | Y |

---

## 6. unlock 시트 전체 (26행)

| key | content_id | condition_type | val | pre_unlock_visibility | show_tutorial |
|-----|-----------|----------------|-----|----------------------|---------------|
| 50001 | content_city_deco | level | 1 | FALSE | TRUE |
| 50002 | content_tournament | level | 1 | FALSE | FALSE |
| 50009 | content_betting_1 | level | 1 | FALSE | FALSE |
| 50003 | content_shop | level | 3 | TRUE | TRUE |
| 50004 | content_pre_level_popup | level | 2 | FALSE | TRUE |
| 50005 | content_idle_gold | level | 4 | TRUE | TRUE |
| 50006 | gimmick_plus_card | level | 4 | FALSE | TRUE |
| 50007 | content_daily_check | level | 4 | TRUE | TRUE |
| 50008 | content_streak | level | 5 | FALSE | TRUE |
| 50010 | content_streak_star | level | 5 | TRUE | TRUE |
| 50011 | content_leaderboard | level | 5 | TRUE | TRUE |
| 50012 | content_collection | level | 6 | TRUE | TRUE |
| 50013 | booster_wild_card | level | 7 | TRUE | TRUE |
| 50014 | booster_fireworks | level | 8 | TRUE | TRUE |
| 50015 | booster_extra_deck | deck_exhausted | 0 | FALSE | TRUE |
| 50016 | content_betting_2 | level | 9 | FALSE | TRUE |
| 50017 | content_daily_wheel | level | 9 | TRUE | TRUE |
| 50018 | content_iap_popup | level | 11 | FALSE | FALSE |
| 50019 | content_event_color | level | 12 | TRUE | FALSE |
| 50020 | content_event_stamp | level | 12 | TRUE | FALSE |
| 50021 | content_event_race | level | 12 | TRUE | FALSE |
| 50022 | gimmick_runner_card | level | 14 | FALSE | TRUE |
| 50023 | content_betting_4 | level | 17 | FALSE | TRUE |
| 50024 | gimmick_lock_key | level | 19 | FALSE | TRUE |
| 50025 | gimmick_rope_card | level | 22 | FALSE | TRUE |
| 50026 | booster_golden_ticket | level | 24 | TRUE | TRUE |

---

## 7. 레벨별 해금 타임라인

| Lv | 해금 콘텐츠 | guide_key | guide_type | 확인 포인트 |
|----|-----------|-----------|------------|------------|
| 1 | 카드 매칭 기본 (인게임) | 230001 | floating | 딤 없이, 비강제 |
| 1 | 덱 뒤집기 안내 (인게임) | 230002 | floating | 이동불가 시 발동 |
| 1 | **로비 게임 시작 버튼 강제** | **230003** | **focus_bubble** | **Lv 1 클리어 후 로비** |
| 2 | 프리레벨 팝업 | 230005 | focus_bubble | Lv 2 클리어 후 |
| 3 | 상점 아이콘 | 230004 | focus_bubble | 로비 터치 유도 |
| 4 | 방치골드 | 230006 | focus_bubble | 해금 팝업 |
| 4 | 플러스카드 | 230007 | focus_bubble | 인게임 첫 등장 |
| 4 | 방치골드 수령 | 230008 | focus_bubble | 로비 터치 유도 |
| 4 | 출석체크 | 230009 | focus_bubble | 로비 터치 유도 |
| 5 | 스트릭 | 230010 | focus_bubble | 2연속 매칭 시 |
| 5 | 리더보드 | 230011 | focus_bubble | 로비 터치 유도 |
| 6 | 콜렉션 | 230012 | focus_bubble | 로비 터치 유도 |
| 7 | 와일드 카드 | 230013 | **floating** | FREE×3, 비강제 |
| 8 | 파이어웍스 | 230014 | focus_bubble | FREE×3, pre_level |
| 8 | 언두 | 230015 | **floating** | FREE×3, 비강제 |
| 8 | 도시 꾸미기 강제 | 230017 | focus_bubble | 망치 충족 시 |
| 9 | 베팅 x2 | 230018 | focus_bubble | — |
| 9 | 데일리 휠 | 230019 | focus_bubble | 순차 (베팅 후) |
| 12 | 이벤트 강제 터치 | 230020 | focus_bubble | 세션당 1회 |
| 14 | 러너 카드 | 230021 | focus_bubble | 인게임 첫 등장 |
| 17 | 베팅 x4 | 230022 | focus_bubble | — |
| 19 | 자물쇠+열쇠 | 230023 | focus_bubble | 인게임 첫 등장 |
| 22 | 얼음카드 | 230024 | focus_bubble | 인게임 첫 등장 |
| 24 | 골든 티켓 | 230025 | focus_bubble | FREE×3 |
| — | 엑스트라 덱 | 230016 | **floating** | 상황기반, FREE×3 |
| — | 도시 꾸미기 반복 | 230026 | focus_bubble | 매 구역 반복 |
| — | 키락 팁 | 230027 | **floating** | 터치 시 반복 |
| — | 얼음카드 팁 | 230028 | **floating** | 터치 시 반복 |

---

## 8. NRU 제한 규칙 (특수 동작)

| 규칙 | 적용 구간 | 검증 방법 |
|------|----------|-----------|
| 입력 제한 (강제 클리어) | **Lv 1~3** | 매칭 불가 카드 탭 → 흔들기+깜빡임 확인. 무조건 클리어 가능 |
| 로비 스킵 | Lv 1 | NRU 첫 실행 → 인게임 직행 (로비 UI 미표시) |
| 입장료 면제 | Lv 1~3 | 골드 잔액 변동 없이 플레이 |
| 자동 드로우 구제 | Lv 1 | 덱 소진+매칭 불가 → 5장 자동 추가 (1회/판) |
| Tutorial 티어 | Lv 1~8 | help_card_rate 80% → 쉬운 카드 배치 확인 |

---

## 9. 에지 케이스 테스트

| 시나리오 | 기대 동작 | 확인 |
|----------|----------|------|
| Phase 0 중간 앱 종료 → 재진입 | 현재 Phase·스텝에서 복원 (동일 맵 재시작) | [ ] |
| 네트워크 끊김 중 클리어 | 로컬 플레이 유지, 재연결 시 결과 전송 | [ ] |
| 이미 본 가이드 재트리거 시도 | 중복 표시 없음 (shownUnlockPopups 체크) | [ ] |
| 무료 부스터 3개 모두 소진 후 | 유료 가격으로 자동 전환 | [ ] |
| Lv 9 이후 기존 유저 (NRU 아님) | 튜토리얼 시스템 비활성 (Normal flow) | [ ] |
| Facebook setDataAsync 실패 | 로컬 캐시 유지, 다음 세션 재시도 | [ ] |
| 튜토리얼 맵 파일 누락 | fallback 맵 사용 + 에러 로그 출력 | [ ] |
| 동시 해금 (예: Lv 4 방치골드+출석체크) | 순차 처리 (큐), 동시 팝업 안 됨 | [ ] |
| Lv 3 강제 클리어 중 매칭 불가 | 드로우 덱으로 유도 (S1-3 패턴) | [ ] |

---

## 10. 무료 부스터 지급 검증

| 부스터 | 해금 시점 | guide_key | 지급 수량 | UI 표기 |
|--------|----------|-----------|----------|---------|
| 와일드 카드 | Lv 7 인게임 | 230013 | 3개 | FREE ×3 |
| 파이어웍스 | Lv 8 pre_level | 230014 | 3개 | FREE ×3 |
| 언두 | Lv 8 인게임 | 230015 | 3개 | FREE ×3 |
| 엑스트라 덱 | 덱소진+매칭불가 | 230016 | 3개 | FREE ×3 |
| 골든 티켓 | Lv 24 | 230025 | 3개 | FREE ×3 |

**검증 포인트**: 지급 후 잔여 수량 UI 반영, 소진 후 유료 전환, 중복 지급 방지
