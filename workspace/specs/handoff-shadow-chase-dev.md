# 그림자 냥이 추격전 — 개발 처리 체크리스트 (핸드오프)

> 2026-07-27 · spec-027 확정분에서 개발 액션만 추출 · 상세 명세 = spec-027-shadow-chase.html

## 1. 발동·사이클 (서버/클라)

- [ ] 이벤트 기간 판정: `event_schedule` 160005 — 월 00:00 ~ 목 23:59 · 매주 반복 (in_use 킬스위치 기구현 활용)
- [ ] 발동 조건 평가(로비 복귀 시): **기간 내 AND 쿨다운 경과 AND 미진행 중** → 충족 시 발동 시퀀스 연출 자동 재생
- [ ] 발동 순번: **기존 로비 팝업 체인(runWinFlow) 마지막 순번**에 추가 — 보상 정산·출석 등 우선 팝업 소화 후
- [ ] 사이클당 1회: 발동 연출은 사이클 시작 시 1회만. 타이머 시작 = 연출 종료 시점
- [ ] 사이클 종료(성공/실패 무관) → `cooldown_sec`(43200) 재트리거 대기. cooldown_until 서버 저장
- [ ] 타이머 권위 = 서버 시간(wall-clock). 재접속 시 remaining 재계산·복원. 기간 종료를 넘겨도 진행 중 유저는 개인 타이머까지 완주 인정(`grace_after_window`)
- [ ] ★개발 확인 ④: 기간·쿨다운 판정 주체 — 서버 스케줄 push vs 클라 시각 판정(서버 시간 기준) 중 택

## 2. 연출·입력 (클라)

- [ ] 발동 시퀀스(발견→열쇠 강탈→도주→버튼 🐾마킹) 재생 중 **풀스크린 입력 잠금** — `ViewBase.setLocked()`/`lockPopupInput` 재활용
- [ ] 스킵 정책: 최초 1회 필수 시청 · 재노출(다음 사이클)부터 탭 스킵 허용
- [ ] 캐릭터 본체 미등장 — 🐾자국 스프라이트+Tween만 (도주=발자국 트레일+열쇠 아이콘 이동)
- [ ] 중간 앵커 연출 **없음** (제작 안 함)

## 3. 진행 중 상태 표시 (클라)

- [ ] 프리레벨 행잉 태그(보라·5번째 자리): 체스트+타이머+n/8 게이지(끝에 열쇠 골 마커)+그림자 냥이 실루엣(귀 끝+열쇠 든 발만)
- [ ] 플레이 버튼 🐾마킹(보라 오라+별빛 발자국) 상시 표시
- [ ] ★인게임 HUD·타이머 위젯 **없음** — 인게임 중 이벤트 표시 일절 없음. 타이머·n/8 인지는 매판 사이 프리레벨 행잉 태그에서만
- [ ] 로비 이벤트 아이콘·레드닷 **만들지 않음**
- [ ] 인포 팝업(신규 1종): 프리레벨 행잉 태그·결과 화면 행잉 상자에 **ⓘ 버튼** → 탭 시 이벤트 안내 팝업(서사·목표·체스트 보상 미리보기·남은 시간). 보상 수치는 event_shadow_chest 시트 연동(하드코딩 금지)

## 4. 성공 처리 — 8판째 결과 화면 (클라/서버)

- [ ] 별도 오픈 연출·팝업 없음 — **8판째 클리어 판의 결과 화면에 체스트 6슬롯 합산 표시**
- [ ] 연출: 행잉 태그 8/8 만충 글로우 → 체스트 팝+파티클이 보상 아이콘으로 → 태그 소멸·기여 항목 🐾뱃지 (spec ⑦ 3컷 참고)
- [ ] ★이 결과 화면에서 **"광고 보고 ×2 받기" 버튼 미노출** (이벤트 지급분 배수 혼란 방지)
- [ ] ★이 결과 화면에서 **홈 버튼 미노출** — [받기] 단일 버튼, 수령 후 자연 로비 복귀
- [ ] 지급: 서버 커밋(멱등 txn_id) — `/api/event/shadow-chase/claim-chest` 신규 (기존 /api/event/* 관례)

## 5. 실패 처리 (클라)

- [ ] 별도 연출·팝업 없음 — 행잉 태그·플레이 버튼 마킹 **비노출 전환**만
- [ ] 몰수 없음: 인게임 획득은 평소대로 유지. 체스트만 미지급

## 6. 데이터·코드 등록 (클라/서버)

- [ ] 신규 클래스: `PopupEventShadowChase`(PopupBase 문법 — 발동 연출 재생 + ⓘ 인포 팝업 겸용) · 🐾자국 스프라이트/Tween(GRAB·ESCAPE 연출용, 캐릭터 본체 미등장) · 기존 프리레벨 진행이벤트 행잉 태그 확장(체스트+타이머+n/8 게이지+실루엣). 인게임 HUD 위젯 신규 없음
- [ ] `ProtocolTypes.ts`: EventSchedule.type에 `shadow_chase` 추가 · `ShadowChaseInfo` 타입 신설(timer_start_ts·rounds_cleared·cooldown_until·cycle_result)
- [ ] 진행 저장: 서버 `TPlayer.event_infos`에 ShadowChaseInfo
- [ ] 신규 시트 탭 로드: `event_shadow_sprint`(5변수)·`event_shadow_chest`(Normal 6행) — 번들 JSON+balance-sheet 로더 등록
- [ ] unlock 50031(`content_event_shadow_chase`·level_clear·10) + tutorial_guide 230034(unlock_key=50031·진행 중 defer) — 클라 코드 등록 불필요(데이터 참조)
- [ ] string_code `T_SHADOW_CHASE_*` 8키 등록
- [ ] ★개발 확인 ①: goal_type=`complete_sprint_cycle` 서버 처리(2차 저니용 — v1 훅만)
- [ ] ★개발 확인 ②: milestone/sprint의 event_id=0(비귀속) 관례 수용 여부
- [ ] ★개발 확인 ③: tutorial_guide play_scene=`event_shadow_chase` 씬 명명

## 7. 로그 등록 (클라)

`BaseLogManager` LogType enum + `registLogEvent` 2줄씩 · payload string 직렬화:

| 코드 | 발화 시점 |
|---|---|
| 7101_SHADOW_CHASE_SLOT_OPEN | 발동 조건 충족(NOTIFY) |
| 7102_SHADOW_CHASE_ACTIVATE | 발동 연출 재생(사이클 시작) |
| 7103_SHADOW_CHASE_ROUND_CLEAR | 사이클 중 판 클리어(round_idx 1~8·elapsed_sec) |
| 7104 | (미사용 — 앵커 제거) |
| 7105_SHADOW_CHASE_CHEST_OPEN | 8판 완주·체스트 지급(txn_id) |
| 7106_SHADOW_CHASE_FAIL | 타이머 만료(rounds_cleared·reason) |
| 7107_SHADOW_CHASE_HAMMER_GRANT | 해머 지급(balance_after) |
| 7108_SHADOW_CHASE_DECO_GATE_UNLOCK | 해머로 데코 게이트 해제 |

## 8. QA 핵심 (발췌)

- [ ] 타이머 정확도(서버 remaining vs HUD 오차 ≤2s) · 시계 조작 무효
- [ ] 보상 멱등성: claim 2회 연속 → 1회만 지급
- [ ] 강종/재접속: 타이머·판수 정확 복원
- [ ] 8판 달성·타이머 동시 종료 경합 = 유저 유리(성공)
- [ ] Lv9 이하 이벤트 완전 비노출 / Lv10 클리어 시 인트로 1회
