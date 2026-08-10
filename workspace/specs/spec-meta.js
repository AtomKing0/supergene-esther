/* ============================================================================
   spec-meta.js — 스펙 메타데이터 SSOT
   index.html과 모든 spec-*.html이 이 파일 하나를 공유함.

   여기서만 정의하는 것:
     · 스펙 목록(SPECS) — 제목·파일·기본 태그/우선순위/상태
     · 태그·우선순위·상태 어휘와 표시 순서 (드롭다운 노출 순서 = 정의 순서)
     · Supabase 동기화 (인덱스·스펙 페이지가 같은 행을 읽고 씀)
     · 스펙 페이지용 배지 + 드롭다운 마운트

   ★ 상태를 추가/변경하려면 STATUS_INFO만 고치면 전 페이지에 동시 반영됨.
   ============================================================================ */
(function (global) {
'use strict';

/* ── 스펙 목록 (기본값) ────────────────────────────────────────────────── */
const SPECS = [
  {
    id: 'spec-001', file: 'spec-001-daily-task-alert.html',
    title: '[메타-알림] 데일리 태스크 달성 플로팅 알럿',
    tags: ['feature'], priority: 'mid', status: 'open', date: '2026. 4. 2.', dueDate: null, relatedTo: [],
  },
  {
    id: 'spec-002', file: 'spec-002-share-surfaces.html',
    title: '[소셜-공유] 공유 지면 3종 설계',
    tags: ['content'], priority: 'mid', status: 'open', date: '2026. 4. 2.', dueDate: null, relatedTo: [],
  },
  {
    id: 'spec-003', file: 'spec-003-rv-milestone.html',
    title: '[수익화-광고] RV 누적 마일스톤 보상',
    tags: ['monetize'], priority: 'mid', status: 'open', date: '2026. 4. 2.', dueDate: null, relatedTo: [],
  },
  {
    id: 'spec-004', file: 'spec-004-explorer-rush.html',
    title: '[콘텐츠-이벤트] Explorer Rush',
    tags: ['content'], priority: 'mid', status: 'open', date: '2026. 4. 3.', dueDate: null, relatedTo: [],
  },
  {
    id: 'spec-005', file: 'spec-005-streak-blaze.html',
    title: '[콘텐츠-이벤트] Streak Blaze',
    tags: ['content'], priority: 'mid', status: 'open', date: '2026. 4. 3.', dueDate: null, relatedTo: [],
  },
  {
    id: 'spec-006', file: 'spec-006-friend-o-meter.html',
    title: '[소셜-친구] Friend-O-Meter',
    tags: ['social'], priority: 'mid', status: 'open', date: '2026. 4. 3.', dueDate: null, relatedTo: [],
  },
  {
    id: 'spec-007', file: 'spec-007-season-pass.html',
    title: '[리텐션-패스] 루나 시즌 패스 — ⏸ 보류 (수익화 블록 · 8월 셋째~넷째주 재검토)',
    tags: ['feature', 'monetize'], priority: 'high', status: 'open', date: '2026. 7. 28.', dueDate: null, relatedTo: ['spec-028'],
  },
  {
    id: 'spec-008', file: 'spec-008-share-reward-launch.html',
    title: '[운영-후처리] share_reward_in_use 런칭 후 ON',
    tags: ['etc'], priority: 'high', status: 'done', date: '2026. 4. 6.', dueDate: null, relatedTo: [],
  },
  {
    id: 'spec-009', file: 'spec-009-pre-level-popup-ab.html',
    title: '[AB-플로우] 프리레벨 팝업 제거 A/B',
    tags: ['ux'], priority: 'mid', status: 'done', date: '2026. 4. 6.', dueDate: null, relatedTo: ['spec-009b'],
  },
  {
    id: 'spec-009b', file: 'spec-009b-continuous-play-ab.html',
    title: '[AB-플로우] 연속 플레이 N판 A/B (009 사전 검증)',
    tags: ['ux'], priority: 'high', status: 'open', date: '2026. 5. 11.', dueDate: null, relatedTo: ['spec-009'],
  },
  {
    id: 'spec-010', file: 'spec-010-deco-auto-trigger-ab.html',
    title: '[AB-메타] 꾸미기 자동 진입 A/B',
    tags: ['ux'], priority: 'mid', status: 'done', date: '2026. 4. 6.', dueDate: null, relatedTo: [],
  },
  {
    id: 'spec-011', file: 'spec-011-peak-rankers-info-button.html',
    title: 'Peak Rankers — 자세히 보기 버튼',
    tags: ['ux'], priority: 'mid', status: 'open', date: '2026. 4. 10.', dueDate: null, relatedTo: [],
  },
  {
    id: 'spec-012', file: 'spec-012-help-rate-ratio.html',
    title: '[밸런스-DDA] 레벨 구간별 Help Rate 배율 시스템',
    tags: ['balance'], priority: 'low', status: 'hold', date: '2026. 4. 13.', dueDate: null, relatedTo: [],
  },
  {
    id: 'spec-013', file: 'spec-013-daily-gift-30day.html',
    title: '[리텐션] 데일리 기프트 30일 확장 — 마일스톤 앵커 시스템',
    tags: ['feature'], priority: 'mid', status: 'open', date: '2026. 4. 13.', dueDate: null, relatedTo: [],
  },
  {
    id: 'spec-014', file: 'spec-014-daily-task-token-count.html',
    title: '[UX] 데일리 태스크 토큰 누적 획득량 표시',
    tags: ['ux'], priority: 'low', status: 'planned', date: '2026. 4. 14.', dueDate: null, relatedTo: [],
  },
  {
    id: 'spec-015', file: 'spec-015-collection-unlock-update.html',
    title: '[운영] 콜렉션 UNLOCK 시트 VALUE 수정 — 출시 후 첫 업데이트 필수',
    tags: ['bug'], priority: 'high', status: 'done', date: '2026. 4. 21.', dueDate: null, relatedTo: [],
  },
  {
    id: 'spec-016', file: 'spec-016-lobby-reward-flow-ab.html',
    title: '[AB-플로우] 로비 보상 연출 중 팝업 차단 개선 — 강제팝업 vs 레드닷',
    tags: ['ux'], priority: 'mid', status: 'open', date: '2026. 4. 22.', dueDate: null, relatedTo: [],
  },
  {
    id: 'spec-017', file: 'spec-017-simple-test-feature.html',
    title: '[테스트-기능] 간단 테스트 기능',
    tags: ['test'], priority: 'low', status: 'archive', date: '2026. 5. 4.', dueDate: null, relatedTo: [],
  },
  {
    id: 'spec-018', file: 'spec-018-city-race-champion-bundle.html',
    title: '[쇼핑-IAP] City Race Champion Bundle — 초급자 저가형',
    tags: ['monetize', 'iap'], priority: 'high', status: 'archive', date: '2026. 5. 4.', dueDate: null, relatedTo: [],
  },
  {
    id: 'spec-019', file: 'spec-019-city-race-sprint-pack.html',
    title: '[수익화-IAP] City Race Sprint Pack — $1.99 랭킹전 번들',
    tags: ['monetize', 'iap'], priority: 'high', status: 'open', date: '2026. 5. 4.', dueDate: null, relatedTo: ['spec-018'],
  },
  {
    id: 'spec-020', file: 'spec-020-special-offer-3-luna-card.html',
    title: '[UX-수익화] 스페셜 오퍼 3 — 루나 카드 해금 안내',
    tags: ['ux', 'monetize'], priority: 'mid', status: 'archive', date: '2026. 5. 4.', dueDate: null, relatedTo: [],
  },
  {
    id: 'spec-021', file: 'spec-021-peak-cup.html',
    title: '[콘텐츠-이벤트] Peak Cup — 100인 데일리 경쟁전',
    tags: ['content', 'feature'], priority: 'high', status: 'open', date: '2026. 5. 4.', dueDate: null, relatedTo: ['spec-022'],
  },
  {
    id: 'spec-022', file: 'spec-022-coop-tournament.html',
    title: '[소셜-협력] FB 협력 토너먼트 — 친구와 함께 목표 달성',
    tags: ['social', 'feature'], priority: 'mid', status: 'open', date: '2026. 5. 21.', dueDate: null, relatedTo: ['spec-021'],
  },
  {
    id: 'spec-023', file: 'spec-023-city-deck-easter-eggs.html',
    title: '[콘텐츠-수집] 시티 꾸미기 덱 이스터에그',
    tags: ['content'], priority: 'mid', status: 'archive', date: '2026. 5. 28.', dueDate: null, relatedTo: ['spec-020'],
  },
  {
    id: 'spec-023b', file: 'spec-023-city-easter-egg-decks.html',
    title: '[콘텐츠-수집] 시티 꾸미기 덱 이스터에그 — 구판',
    tags: ['content'], priority: 'low', status: 'archive', date: '2026. 5. 28.', dueDate: null, relatedTo: ['spec-023'],
  },
  {
    id: 'spec-024', file: 'spec-024-summer-beach-renovation.html',
    title: '[콘텐츠-이벤트] 여름 해변 꾸미기',
    tags: ['content', 'feature'], priority: 'high', status: 'open', date: '2026. 5. 28.', dueDate: null, relatedTo: [],
  },
  {
    id: 'spec-025', file: 'spec-025-friend-piggy-bank.html',
    title: '[소셜-이벤트] 친구 저금통 이벤트 (3일 협동)',
    tags: ['social', 'feature'], priority: 'mid', status: 'open', date: '2026. 5. 29.', dueDate: null, relatedTo: ['spec-006'],
  },
  {
    id: 'spec-026', file: 'spec-026-album-milestone-reward-flow.html',
    title: '[UX-플로우] 앨범 마일스톤 보상 플로우 수정',
    tags: ['ux'], priority: 'mid', status: 'done', date: '2026. 6. 4.', dueDate: null, relatedTo: ['spec-015', 'spec-016'],
  },
  {
    id: 'spec-027', file: 'spec-027-shadow-chase.html',
    title: '[콘텐츠-이벤트] 그림자 냥이 추격전',
    tags: ['content', 'feature'], priority: 'high', status: 'wip', date: '2026. 7. 24.', dueDate: null, relatedTo: ['spec-020'],
  },
  {
    id: 'spec-028', file: 'spec-028-event-boost-pack.html',
    title: '[수익화-오퍼] 이벤트 부스트 팩 (주말 이벤트 연동) — 준비 완료 · SPEC-027 관측 종료(8/12) 후 배포',
    tags: ['monetize'], priority: 'high', status: 'open', date: '2026. 7. 26.', dueDate: null, relatedTo: ['spec-007', 'spec-027'],
  },
  {
    id: 'spec-029', file: 'spec-029-level-default-tier-ramp.html',
    monitorGroup: 'sol-difficulty',
    title: '[밸런스-난이도] 레벨 기반 기본 난이도 승급',
    tags: ['balance'], priority: 'high', status: 'done', date: '2026. 7. 28.', dueDate: null, relatedTo: ['spec-012'],
  },
  {
    id: 'spec-030', file: 'spec-030-context-switch-expansion.html',
    monitorGroup: 'sol-ctx-switch',
    title: '[소셜-바이럴] 컨텍스트 전환 노출 확대 A/B',
    tags: ['social', 'feature'], priority: 'high', status: 'monitor', date: '2026. 7. 29.', dueDate: null, relatedTo: [],
  },
  {
    id: 'spec-031', file: 'spec-031-sh-rescue-activation.html',
    monitorGroup: 'sol-difficulty',
    title: '[밸런스-난이도] Super Hard 구제장치 활성화',
    tags: ['balance'], priority: 'mid', status: 'done', date: '2026. 7. 29.', dueDate: null, relatedTo: ['spec-029'],
  },
  {
    id: 'spec-032', file: 'spec-032-daily-first-play-free.html',
    title: '[경제-온보딩] 하루 첫 판 무료 입장',
    tags: ['feature', 'balance'], priority: 'high', status: 'open', date: '2026. 7. 29.', dueDate: null, relatedTo: [],
  },
  {
    id: 'spec-033', file: 'spec-033-deck-counter.html',
    title: '[UX-인게임] 덱 잔여 수량 표시',
    tags: ['ux'], priority: 'high', status: 'planned', date: '2026. 7. 30.', dueDate: null, relatedTo: [],
  },
  {
    id: 'spec-034', file: 'spec-034-ingame-booster-sale.html',
    title: '[수익화-부스터] 파이어웍스 인게임 아이템 확장',
    tags: ['monetize'], priority: 'mid', status: 'planned', date: '2026. 7. 30.', dueDate: null, relatedTo: ['spec-032'],
  },
  {
    id: 'spec-035', file: 'spec-035-interstitial-frequency.html',
    monitorGroup: 'sol-it-freq',
    title: '[수익화-광고] 전면 광고 빈도 곡선',
    tags: ['monetize', 'balance'], priority: 'high', status: 'done', date: '2026. 8. 4.', dueDate: null, relatedTo: ['spec-036'],
  },
  {
    id: 'spec-037', file: 'spec-037-leaderboard-play-button.html',
    title: '[소셜-바이럴] 리더보드 친구 플레이 버튼',
    tags: ['social', 'feature'], priority: 'high', status: 'planned', date: '2026. 8. 7.', dueDate: null, relatedTo: ['spec-030', 'spec-002'],
  },
  {
    id: 'spec-036', file: 'spec-036-retry-flow.html',
    title: '[UX-플로우] 실패 후 재도전 흐름 단축',
    tags: ['ux'], priority: 'high', status: 'open', date: '2026. 8. 5.', dueDate: null, relatedTo: ['spec-009b', 'spec-035'],
  },
];

/* ── 어휘 ──────────────────────────────────────────────────────────────
   cls  = 인덱스 카드 배지 클래스
   hcls = 스펙 페이지 히어로 배지 클래스 (두 곳의 CSS 팔레트가 다름)      */
const TAG_INFO = {
  review:   { label: '🔍 리뷰',   cls: 'badge-review',   hcls: 'badge-blue'   },
  feature:  { label: '✨ 기능',   cls: 'badge-feature',  hcls: 'badge-green'  },
  balance:  { label: '⚖️ 밸런스', cls: 'badge-balance',  hcls: 'badge-gold'   },
  bug:      { label: '🐛 버그',   cls: 'badge-bug',      hcls: 'badge-red'    },
  ux:       { label: '🎨 UX/UI',  cls: 'badge-ux',       hcls: 'badge-purple' },
  content:  { label: '📦 콘텐츠', cls: 'badge-content',  hcls: 'badge-yellow' },
  monetize: { label: '💰 수익화', cls: 'badge-monetize', hcls: 'badge-teal'   },
  social:   { label: '👥 소셜',   cls: 'badge-social',   hcls: 'badge-pink'   },
  etc:      { label: '📌 기타',   cls: 'badge-etc',      hcls: 'badge-blue'   },
};

const PRI_INFO = {
  high: { label: '🔴 높음', cls: 'pri-high', hcls: 'badge-red'    },
  mid:  { label: '🟡 보통', cls: 'pri-mid',  hcls: 'badge-yellow' },
  low:  { label: '⚪ 낮음', cls: 'pri-low',  hcls: 'badge-blue'   },
};

/* 정의 순서 = 드롭다운 노출 순서. 진행 흐름(예정→검토→진행→보류→완료→보관) */
/* ── 관측 그룹 — 여러 스펙이 하나의 리포트를 공유할 때 ──────────────── */
const MONITOR_GROUPS = {
  'sol-difficulty': {
    label: '솔 난이도 튜닝 — 결론 확정',
    since: '2026-08-01',
    url:   '../../32_sol_diff_watch.html',
    specs: ['spec-029', 'spec-031'],
  },
  'sol-ctx-switch': {
    label: '컨텍스트 전환 확대 A/B — 결론 확정',
    since: '2026-08-03',
    url:   '../../34_sol_ctx_switch_watch.html',
    specs: ['spec-030'],
  },
  'sol-it-freq': {
    label: '전면 광고 빈도 곡선 — A 통합 결론 확정',
    since: '2026-08-06',
    url:   '../../37_sol_it_watch.html',
    specs: ['spec-035'],
  },
};

const STATUS_INFO = {
  planned: { label: '🟣 진행 예정', cls: 'status-planned', hcls: 'badge-purple' },
  open:    { label: '🔵 검토중',    cls: 'status-open',    hcls: 'badge-blue'   },
  wip:     { label: '🟡 진행중',    cls: 'status-wip',     hcls: 'badge-yellow' },
  monitor: { label: '📈 모니터링중', cls: 'status-monitor', hcls: 'badge-green'  },
  hold:    { label: '⏸ 보류',      cls: 'status-hold',    hcls: 'badge-blue'   },
  done:    { label: '✅ 완료',      cls: 'status-done',    hcls: 'badge-green'  },
  archive: { label: '🗄️ 아카이브', cls: 'status-hold',    hcls: 'badge-blue'   },
};

const PRI_ORDER = { high: 3, mid: 2, low: 1 };
const DEFAULTS  = { tags: [], priority: 'mid', status: 'open' };

/* 드롭다운 항목은 위 정의에서 파생 — 순서가 어긋날 여지를 없앰 */
const opts = o => Object.keys(o).map(v => ({ val: v, label: o[v].label }));
const DD_OPTIONS = { tags: opts(TAG_INFO), priority: opts(PRI_INFO), status: opts(STATUS_INFO) };
const DD_LABEL   = { tags: '태그', priority: '우선순위', status: '상태', related: '관련 기획서' };

/* ── Supabase ─────────────────────────────────────────────────────────── */
const SB_URL  = 'https://hfiukhidqwhntdpmippt.supabase.co';
const SB_ANON = 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImhmaXVraGlkcXdobnRkcG1pcHB0Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NzQ4MTMyNzMsImV4cCI6MjA5MDM4OTI3M30.cLuCTE9IK6Mp_kVsRY3AFQ_wvE4X6YGkHvziz_6-sfs';
let _sb = null;
try { _sb = global.supabase ? global.supabase.createClient(SB_URL, SB_ANON) : null; }
catch (e) { console.warn('[spec-meta] Supabase init 실패:', e); }

function getEditKey() {
  let k = localStorage.getItem('spec-edit-key');
  if (!k) {
    k = (global.prompt('편집 암호를 입력하세요 (변경 저장에 필요):') || '').trim();
    if (k) localStorage.setItem('spec-edit-key', k);
  }
  return k;
}
function _err(error, where) {
  if (!error) return;
  console.warn('[spec-meta] ' + where + ':', error.message);
  if (/unauthorized/i.test(error.message || '')) {
    localStorage.removeItem('spec-edit-key');
    alert('편집 암호가 올바르지 않아 변경이 저장되지 않았습니다. 다시 시도하면 암호를 재입력합니다.');
  } else {
    alert('저장 실패(' + where + '): ' + (error.message || '알 수 없는 오류'));
  }
}

/* 로컬 미러 — Supabase 로드 전/오프라인 fallback. 인덱스와 같은 키를 씀 */
function readLocal() { try { return JSON.parse(localStorage.getItem('spec-ov') || '{}'); } catch (e) { return {}; } }
function writeLocal(ov) { try { localStorage.setItem('spec-ov', JSON.stringify(ov)); } catch (e) {} }

function rowToOv(r) {
  return { tags: r.tags || [], priority: r.priority, status: r.status,
           dueDate: r.due_date || null, relatedTo: r.related_to || [] };
}

/* 전체 오버라이드 로드 (인덱스·스펙 페이지 공용) */
async function loadOverrides() {
  if (!_sb) return readLocal();
  const { data, error } = await _sb.from('spec_overrides').select('*');
  if (error || !data) return readLocal();
  const ov = {};
  for (const r of data) ov[r.spec_id] = rowToOv(r);
  writeLocal(ov);
  return ov;
}

/* 해당 스펙의 현재 유효값 = 기본값 + 오버라이드 */
function effective(specId, ov) {
  const base = SPECS.find(s => s.id === specId) || {};
  const o    = (ov || readLocal())[specId] || {};
  return {
    tags:      o.tags      || base.tags      || DEFAULTS.tags,
    priority:  o.priority  || base.priority  || DEFAULTS.priority,
    status:    o.status    || base.status    || DEFAULTS.status,
    dueDate:   o.dueDate !== undefined ? o.dueDate : (base.dueDate || null),
    relatedTo: o.relatedTo || base.relatedTo || [],
  };
}

/* 한 필드만 저장 — 나머지 필드는 현재 유효값으로 보존해서 통째 upsert.
   (RPC가 행 전체를 쓰므로 병합 없이 보내면 다른 필드가 날아감) */
async function setField(specId, field, value) {
  const ovAll = _sb ? await loadOverrides() : readLocal();
  const cur   = effective(specId, ovAll);
  const from  = cur.status;
  const next  = Object.assign({}, cur, { [field]: value });

  ovAll[specId] = next; writeLocal(ovAll);          // 즉시 로컬 반영(낙관적)

  if (_sb) {
    const key = getEditKey();
    const { error } = await _sb.rpc('spec_ov_upsert', {
      p_key: key, p_spec_id: specId, p_tags: next.tags, p_priority: next.priority,
      p_status: next.status, p_due_date: next.dueDate, p_related_to: next.relatedTo,
    });
    if (error) { _err(error, 'spec_overrides'); return false; }
    if (field === 'status' && from !== value) {
      const { error: e2 } = await _sb.rpc('spec_log_insert',
        { p_key: key, p_spec_id: specId, p_from: from, p_to: value });
      if (e2) console.warn('[spec-meta] 상태 로그 실패:', e2.message);
    }
  }
  return true;
}

/* ── 스펙 페이지용 배지 + 드롭다운 ───────────────────────────────────── */
const DD_CSS = '.sm-dd{position:fixed;z-index:900;background:var(--surface,#1e1e28);border:1px solid var(--border,#333);border-radius:10px;box-shadow:0 8px 28px rgba(0,0,0,.4);padding:5px;min-width:158px;display:none}'
  + '.sm-dd.open{display:block}'
  + '.sm-dd-lbl{font-size:.65rem;font-weight:700;text-transform:uppercase;letter-spacing:.08em;color:var(--text-dim,#8a90a0);padding:5px 10px 3px;display:block}'
  + '.sm-dd-itm{display:flex;align-items:center;gap:6px;padding:7px 10px;border-radius:7px;font-size:.8rem;cursor:pointer;color:var(--text,#e8e8ef);white-space:nowrap;transition:background .1s}'
  + '.sm-dd-itm:hover{background:var(--surface2,#2a2a36)}'
  + '.sm-dd-itm.active{color:var(--accent,#8b7cf6);font-weight:700;background:var(--purple-bg,rgba(139,124,246,.14))}'
  + '.sm-dd-chk{width:12px;display:inline-block}';

function mountBadges(specId) {
  if (!specId) return;
  /* 구버전 인라인 로직이 DOMContentLoaded에 배지를 다시 그리는 페이지가 있어,
     항상 그보다 뒤에 실행되도록 한 틱 미룸 (마지막에 그린 쪽이 이김) */
  if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', () => setTimeout(() => _mount(specId), 0));
    return;
  }
  setTimeout(() => _mount(specId), 0);
}

function _mount(specId) {
  if (document.getElementById('sm-dd')) return;   // 중복 마운트 방지
  const eyebrow = document.querySelector('.hero-eyebrow')
               || (document.querySelector('.spec-id-badge') || {}).parentElement
               || (document.querySelector('.spec-badge') || {}).parentElement;
  if (!eyebrow) { console.warn('[spec-meta] 배지를 붙일 영역을 찾지 못함:', specId); return; }

  if (!document.getElementById('sm-dd-css')) {
    const st = document.createElement('style'); st.id = 'sm-dd-css'; st.textContent = DD_CSS;
    document.head.appendChild(st);
  }
  const legacy = document.getElementById('metaBadgeDropdown');   // 구버전 드롭다운 제거
  if (legacy) legacy.remove();

  const dd = document.createElement('div');
  dd.className = 'sm-dd'; dd.id = 'sm-dd';
  document.body.appendChild(dd);

  /* 배지 3종 확보 — 없으면 생성, 있으면 리스너 제거 후 재사용 */
  const FIELDS = [['tag', 'hero-tag'], ['priority', 'hero-priority'], ['status', 'hero-status']];
  const els = {};
  for (const [field, id] of FIELDS) {
    let el = document.getElementById(id);
    if (el) { const c = el.cloneNode(false); el.replaceWith(c); el = c; }   // 옛 핸들러 제거
    else {
      el = document.createElement('span'); el.id = id; el.className = 'badge';
      const anchor = eyebrow.querySelector('.spec-id-badge, .spec-badge');
      if (anchor && anchor.nextSibling) eyebrow.insertBefore(el, anchor.nextSibling);
      else eyebrow.appendChild(el);
    }
    el.style.cursor = 'pointer';
    els[field] = el;
  }

  let ovCache = readLocal();
  let openField = null;

  function paint() {
    const v = effective(specId, ovCache);
    const t = TAG_INFO[(v.tags && v.tags[0]) || 'etc'] || TAG_INFO.etc;
    const p = PRI_INFO[v.priority] || PRI_INFO.mid;
    const s = STATUS_INFO[v.status] || STATUS_INFO.open;
    els.tag.className      = 'badge ' + t.hcls; els.tag.textContent      = t.label;
    els.priority.className = 'badge ' + p.hcls; els.priority.textContent = p.label;
    els.status.className   = 'badge ' + s.hcls; els.status.textContent   = s.label;
    els.tag.title = '태그 변경'; els.priority.title = '우선순위 변경'; els.status.title = '상태 변경';
  }

  function open(e, field) {
    e.stopPropagation();
    const v    = effective(specId, ovCache);
    const cur  = field === 'tag' ? (v.tags || []) : v[field];
    const list = DD_OPTIONS[field === 'tag' ? 'tags' : field];
    dd.innerHTML = '<span class="sm-dd-lbl">' + DD_LABEL[field === 'tag' ? 'tags' : field] + '</span>'
      + list.map(o => {
          const on  = Array.isArray(cur) ? cur.indexOf(o.val) >= 0 : cur === o.val;
          const chk = field === 'tag' ? '<span class="sm-dd-chk">' + (on ? '✓' : '') + '</span>' : '';
          return '<div class="sm-dd-itm' + (on ? ' active' : '') + '" data-val="' + o.val + '">' + chk + o.label + '</div>';
        }).join('');
    const r = e.currentTarget.getBoundingClientRect();
    dd.style.left = Math.min(r.left, global.innerWidth - 172) + 'px';
    dd.style.top  = (r.bottom + 5) + 'px';
    dd.classList.add('open');
    openField = field;
  }
  function close() { dd.classList.remove('open'); openField = null; }

  for (const [field] of FIELDS) els[field].addEventListener('click', e => open(e, field));

  dd.addEventListener('click', async e => {
    e.stopPropagation();
    const item = e.target.closest('.sm-dd-itm');
    if (!item || !openField) return;
    const val = item.dataset.val, f = openField;
    close();
    if (f === 'tag') {
      const v = effective(specId, ovCache);
      const tags = (v.tags || []).slice();
      const i = tags.indexOf(val);
      if (i >= 0) tags.splice(i, 1); else tags.push(val);
      await setField(specId, 'tags', tags);
    } else {
      await setField(specId, f, val);
    }
    ovCache = readLocal();
    paint();
  });
  document.addEventListener('click', close);

  paint();
  loadOverrides().then(ov => { ovCache = ov; paint(); });   // DB 값으로 확정
}

global.SPEC_META = {
  SPECS, TAG_INFO, PRI_INFO, STATUS_INFO, MONITOR_GROUPS, PRI_ORDER, DD_OPTIONS, DD_LABEL, DEFAULTS,
  loadOverrides, effective, setField, mountBadges, getEditKey,
  sb: () => _sb,
};
})(window);
