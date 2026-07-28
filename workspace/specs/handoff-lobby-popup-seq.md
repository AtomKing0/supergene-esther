# 로비 팝업 시퀀서 핸드오프 (Lobby Popup Sequencer)

> 2026-07-28 개정 · 소스: CCS_Events 시트 `LOBBY_POPUP_SEQ` 탭 · 대상: 클라/서버 개발
>
> **7-28 변경** — §3을 spec-027 현행안으로 정합(구안 잔재 제거: 밧줄 레드닷·유저 탭 발동·12:00/19:00 슬롯 → **자동 발동·팝업 체인 마지막 순번**). **세션 상한 소진 시 이월 규칙** 추가. 실패 토스트는 **미채택으로 확정**되어 삭제.
> 목적: 로비 진입/판 복귀 시 팝업(보상정산·데일리·이벤트·오퍼)이 몰릴 때 노출 순서·빈도·억제를 규칙화. **콜드스타트 마찰 최소가 최우선.**

## 0. AS-IS (클라 실측)

- 팝업 우선순위 큐/매니저 **없음**. 로비 복귀 팝업 = `SessionFlowManager.runPostGameFlow()`의 하드코딩 await 체인(코드 순서=우선순위·세션 상한 없음).
- 현재 체인(runWinFlow L562~606): ⓪보상 획득 애니(`ViewLobby.playPendingRewardClaim` L1119~) → ①마일스톤 보상(563) → ②도시 완성 보상(572) → ③로그인 프롬프트(585/588) → ④특별 오퍼(592) → ⑤강제 꾸미기(597·게이트 off 추정) → ⑥출석 데일리(600) → ⑦로비 튜토 가이드(602·이벤트 팝업 포함 `showFirstActiveEventPopup` 409) → ⑧망치 준비 가이드(605)
- 핵심 파일: 부트→로비=`BaseIntro.ts`(moveToNext L914~1097·DailyGift L1050) / 오케스트레이션=`ViewLobby.onShowEnd`(L998~1117·lockButton=true 동안 체인) / 체인=`SessionFlowManager.runWinFlow`·`runFailFlow` / 언락=`Unlock.isUnlockedByContentId`
- **현황 이슈 4**: (1)큐·상한 없음→팝업 피로 (2)오퍼(④)가 데일리(⑥)보다 먼저=우선순위 역전 (3)데일리 기프트 2곳 트리거(BaseIntro L1050+showAttendanceIfNeeded) 중복 (4)event_popup_mode 미구현→전부 force

## 1. 우선순위 티어

| 티어 | 분류 | 포함 | 규칙 |
|---|---|---|---|
| P0 | 시스템 강제 | 강제 업데이트·점검·약관·계정/밴 | 즉시·독점·캡 없음, 하위 전부 차단 |
| P1 | 콘텐츠 언락 온보딩 | 언락 인트로(show_tutorial=true) | content_id당 1회·레벨 게이트(unlock.json) |
| P2 | 보상 정산 | 시즌 정산·idle골드·복귀보상·**이벤트 체스트 결과** | 반드시 전달(지급 완료까지)·순차 |
| P3 | 데일리 앵커 | 데일리 캘린더·기프트·태스크 리셋 | 1일 1회·세션 상한 대상 |
| P4 | 이벤트 시작·마일스톤 | 이벤트 창 오픈·마일스톤 | event_popup_mode(force/reddot)·**콜드스타트=reddot** |
| P5 | 수익화 오퍼 | SML·HardLevel·FOMO | IAP 미연동이라 대부분 in_use=false·NRU 억제 |
| P6 | 저마찰 윈백 | rate-us(D3+)·what's-new·크로스 | 최하위·빈도캡 강함·NRU 억제 |

## 2. 큐 모델·억제

- P0 즉시 독점 / P1·P2 필수 전달(상한 무관) / **P3~P6 = 로비 진입당 임의 모달 상한**(`session_discretionary_cap`: NRU 1·일반 1~2). 동일 티어 FIFO. 초과분은 레드닷/뱃지 강등(소멸 아님·다음 진입 재평가).
- **예외 — `shadow_activate`**: 레드닷 강등이 불가능한 팝업(연출 재생 = 타이머 시작). 상한 초과 시 **보류 후 다음 진입 이월**로 처리(§3 참조).
- 억제: 보상 연출 중=큐 보존(연출 후 flush) / 로딩 중=완료 후 평가 / 모달 열림=닫힐 때까지 defer / 인게임=P0만 예외 / 판 복귀(SPEC-016)=연출 종료 후 우선순위 flush.

## 3. 이벤트 연동 (그림자 냥이 추격전 노출 시기 ★ · spec-027 현행안)

> ★**구안 폐기 주의** — 이전 판의 "밧줄 아이콘 레드닷 → 유저가 탭하면 발동", "월~목 12:00/19:00 슬롯"은 **현행안이 아님**. 현행안은 **기간(월~목) 내 · 쿨다운 경과 · 미진행이면 로비 복귀 시 자동 발동**이며, 발동 연출이 **팝업 체인 마지막 순번**에 얹힘. 슬롯 시각 개념 없음(유저별 쿨다운 사이클).

| 시점 | 노출 | 티어·모드 |
|---|---|---|
| 레벨10 클리어 직후 로비 | 언락 인트로 1회 (unlock 50031 · tutorial_guide 미등록 — 별도 튜토 없음) | **P1 force** (content당 1회) |
| 기간 내·쿨다운 경과·미진행 상태로 로비 복귀 | **발동 시퀀스 연출 자동 재생 + 타이머 시작** (발견→강탈→도주→버튼 마킹·입력 잠금·강제 시청 6초 이내) | **P4 force · 체인 최후미** (`shadow_activate`·사이클당 1회) |
| 진행 중 | 프리레벨 행잉 태그 + 플레이 버튼 🐾마킹 (**모달 아님** — 팝업 체인 미점유) | 비모달 상시 표시 |
| 완주(열쇠 획득) | 결과 화면은 **열쇠 획득 표시만**(지급 없음·화면 무변경) | 팝업 체인 무관 |
| 열쇠 보유 상태로 로비 복귀 | **체스트 오픈 팝업** — 열쇠 꽂힘 → 오픈 → 보상 6슬롯 → [받기] · **미수령 시 재노출 · 2개 이상은 순차** | **P2 force** (`shadow_chest_result`·never) — **발동 연출(P4)보다 상위** |
| 타이머 만료(실패) | **노출 없음** — 행잉 태그·플레이 버튼 마킹 비노출 전환만 | 팝업 체인 무관(큐 진입 없음) |
| 동시 엣지: 언락 인트로 + 발동 조건 | P1 언락 인트로 먼저 → **발동 연출은 다음 로비 복귀로 이월** (같은 진입 2모달 금지) | — |
| ★**세션 상한 소진** | **발동 연출을 잘라내지 말고 다음 로비 복귀로 이월** | **이월 필수 — 아래 참조** |

### ★ 발동 연출 이월 규칙 (필수)

발동 연출은 체인 **마지막** 순번이라 앞 팝업(⓪~⑧)이 세션 상한을 소진하면 큐에서 잘릴 수 있음. 그런데 **연출 재생 = 타이머 시작**이므로, 잘리면 `5441`가 발화되지 않고 **사이클이 통째로 유실**됨.

- 상한 초과 시 **소멸·레드닷 강등이 아니라 보류(pending)** — 다음 로비 복귀에서 재평가
- 보류 중 `cooldown_sec` 타이머 **미시작** · `5440` **재발화 없음**(참여율 분모 중복 계상 방지)
- 이벤트 기간을 벗어나면 보류분 폐기
- `5440.deferred(bool)` / `5441.deferred_count`로 이월 발생량 계측

- 타 이벤트 공통 원칙: 강제 팝업은 P1(언락 1회)·P2(정산)만, 나머지 전부 레드닷 유도. **본 이벤트의 발동 연출은 예외** — 레드닷으로 강등하면 이벤트가 성립하지 않으므로(자동 발동이 설계 전제) 강등 대신 **이월**로 처리.

## 4. NRU(콜드스타트) 규칙

- NRU 정의: 레벨<10 or 설치 D<3 (AND/OR는 오픈이슈)
- P5 전면 비노출 · P6 rate-us=D3+·크로스=D1+ · 세션 상한 NRU=1(P3/P4만) · 언락 인트로 후 즉시 게임 복귀

## 5. 밸런스시트 스키마 — 신규 `lobby_popup` 탭 (PST_lobby_popup.json)

컬럼: `key_number, popup_id, priority_tier(P0~P6), trigger_condition, once_per(session/day/content/never), cooldown_sec, popup_mode(force/reddot/queue), nru_suppress(bool), in_use` + 전역 `session_discretionary_cap`

| popup_id | tier | once_per | mode | nru_suppress | 비고 |
|---|---|---|---|---|---|
| force_update | P0 | never | force | false | 시스템 |
| content_unlock_intro | P1 | content | force | false | show_tutorial 연동 |
| season_settle | P2 | never | force | false | 시즌 정산 |
| idle_gold_ready | P2 | session | force | false | 오프라인 골드 |
| shadow_chest_result | P2 | never | force | false | **그림자 냥이 추격전 — 로비 체스트 오픈(열쇠 사용·미수령분 순차)** |
| daily_login | P3 | day | queue | false | 데일리 |
| event_milestone | P4 | session | reddot | false | SPEC-016·콜드스타트 reddot |
| shadow_activate | P4 | cycle | force | false | **그림자 냥이 추격전 발동 연출** — 체인 최후미·레드닷 강등 불가·**상한 초과 시 이월** |
| offer_sml | P5 | day | queue | true | IAP 후 |
| rate_us | P6 | never | queue | true | D3+ |

## 6. BQ 로깅

`popup_shown(popup_id·tier·mode·lobby_entry_seq)` / `popup_suppressed(reason: anim/loading/modal/cap/nru)` / `popup_click(action)` / `reddot_shown·reddot_click(source)` / `lobby_entry(popups_shown_count·reddots_count)`
퍼널: lobby_entry→popup_shown→popup_click. **팝업 피로 지표 = AVG(popups_shown per lobby_entry), 콜드스타트 목표 ≤1.** KPI: reddot vs force 세션당 게임수(SPEC-016 가설)·강제팝업의 첫판 진입 지연.

## 7. 엣지케이스

- 언락+이벤트 시작 동시 → P1 먼저·P4 레드닷 강등
- 시즌 정산+데일리 동시 → P2 순차 → P3 상한 내 1개
- P0 인터럽트 → 큐 보존·완료 후 재평가
- 연출 중 강종 → 큐 미소멸(pending)·재진입 재flush
- 상한 강등분 → 레드닷 유지·다음 진입 재평가·아이콘 탭 시 표시
- **`shadow_activate` 상한 초과 → 강등 불가이므로 보류(pending)·다음 로비 복귀 이월·쿨다운 미시작**
- 오프라인 → P0/P2(로컬 판정분)만·서버 의존 팝업은 온라인 복귀 후

## 8. TO-BE 마이그레이션 (기존 코드 위에 얹기)

1. `PopupRequest` 인터페이스(popup_id·tier·mode·once_per·condition·onShow) — 기존 `ViewCreator.showX()` 래핑(호출부 유지)
2. `PopupManager` 큐 신설 — runWinFlow await 체인을 enqueue 등록으로 치환
3. 우선순위 재배치 — **현행 역전 교정**: P3 데일리 > P4 이벤트 > P5 오퍼
4. `event_popup_mode` 플래그 — P4 이벤트 reddot 강등 옵션
5. 세션 상한 — P3~P6 진입당 NRU 1
6. lockButton 블로킹 유지 — 큐가 순차 관리(SPEC-016 정합)
7. 데일리 중복 트리거 2곳 → PopupManager 단일화

## 9. 오픈이슈

1) cap 값(NRU 1 고정 vs 일반 1~2 A/B) 2) event_milestone force vs reddot A/B(세션당 게임수) 3) NRU 정의(레벨 vs D일 vs AND) 4) idle_gold 강제 vs 큐 5) 레드닷 강등분 만료 정책 6) **`shadow_activate` 이월 보류분의 최대 보류 횟수** — 무제한 이월 시 앞 팝업이 항상 많은 헤비 유저가 이벤트를 못 보는 경우가 가능. 이월 N회 초과 시 상한을 무시하고 강제 재생할지 결정 필요

## 10. MVP

P0~P4 큐 + cap(NRU 1) + 억제 3규칙(연출/로딩/모달) + event_popup_mode reddot 기본 + `lobby_popup` 시트 튜닝. Later: P5(IAP 후)·P6 세분화·레드닷 만료·피로 자동조절.
