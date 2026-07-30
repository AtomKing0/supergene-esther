/* ============================================================================
   spec-handoff.js — ④ 섹션(개발 핸드오프 · 엣지케이스 · QA)을 파일로 내려받기

   내용을 따로 들고 있지 않고 **화면의 표를 그대로 읽어서** 생성함.
   기획서를 고치면 받아지는 파일도 같이 바뀜 — 원본과 어긋날 수 없음.

   산출물
     · handoff-<spec-id>-dev.md  = 선행 조건 + A(핸드오프) + B(엣지케이스)
     · handoff-<spec-id>-qa.md   = C(QA 체크리스트)
     · handoff-<spec-id>-qa.csv  = C를 표 도구용 CSV로 (그룹·케이스·절차·기대결과·결과·비고)
   ============================================================================ */
(function (global) {
'use strict';

function specId() {
  const b = document.querySelector('.spec-id-badge, .spec-badge');
  if (b) return b.textContent.trim().toLowerCase().replace(/\s+/g, '-');
  const m = (location.pathname.match(/spec-\d+[a-z]?/) || [])[0];
  return m || 'spec';
}
function specTitle() {
  const h = document.querySelector('.hero h1') || document.querySelector('h1');
  if (!h) return document.title || '';
  // h1이 <br><span>영문 부제</span> 구조라 그냥 textContent를 쓰면 국·영문이 붙어버림
  const c = h.cloneNode(true);
  c.querySelectorAll('br').forEach(e => e.replaceWith(document.createTextNode(' — ')));
  return c.textContent.replace(/\s+/g, ' ').replace(/\s*—\s*$/, '').trim();
}
function today() {
  const d = new Date();
  const p = n => String(n).padStart(2, '0');
  return d.getFullYear() + '-' + p(d.getMonth() + 1) + '-' + p(d.getDate());
}

/* 셀 → 순수 텍스트. <code>는 백틱으로 살려서 개발자가 식별자를 구분할 수 있게 함 */
function cellText(td) {
  const c = td.cloneNode(true);
  c.querySelectorAll('code').forEach(e => { e.replaceWith(document.createTextNode('`' + e.textContent.trim() + '`')); });
  c.querySelectorAll('br').forEach(e => e.replaceWith(document.createTextNode(' ')));
  return c.textContent.replace(/\s+/g, ' ').trim();
}
function tableToMd(tbl) {
  const head = [...tbl.querySelectorAll('thead th')].map(cellText);
  const rows = [...tbl.querySelectorAll('tbody tr')].map(tr => [...tr.children].map(cellText));
  if (!head.length) return '';
  const esc = s => s.replace(/\|/g, '\\|');
  return ['| ' + head.map(esc).join(' | ') + ' |',
          '|' + head.map(() => '---').join('|') + '|',
          ...rows.map(r => '| ' + r.map(esc).join(' | ') + ' |')].join('\n');
}

/* ④ 섹션을 제목 단위로 쪼갬 — h3/h4를 만나면 블록이 바뀜 */
function walkSection() {
  const s4 = document.getElementById('s4');
  if (!s4) return null;
  const out = { blockers: null, handoff: null, edge: null, qa: [], notes: [] };
  let curQa = null;
  let mode = null;
  for (const el of s4.children) {
    const tag = el.tagName;
    if (tag === 'H3') {
      const t = el.textContent.trim();
      mode = /선행 조건/.test(t) ? 'blockers'
           : /^A\./.test(t)      ? 'handoff'
           : /^B\./.test(t)      ? 'edge'
           : /^C\./.test(t)      ? 'qa' : null;
      curQa = null;
      continue;
    }
    if (tag === 'H4' && mode === 'qa') { curQa = { name: el.textContent.trim(), md: '' }; out.qa.push(curQa); continue; }
    if (tag === 'TABLE') {
      const md = tableToMd(el);
      if (mode === 'blockers') out.blockers = md;
      else if (mode === 'handoff') out.handoff = md;
      else if (mode === 'edge') out.edge = md;
      else if (mode === 'qa' && curQa) curQa.md = md;
      continue;
    }
    if (tag === 'P' && (mode === 'handoff' || mode === 'qa')) {
      const t = el.textContent.replace(/\s+/g, ' ').trim();
      if (t) out.notes.push(t);
    }
  }
  return out;
}

function download(name, text, mime) {
  const blob = new Blob([text], { type: (mime || 'text/plain') + ';charset=utf-8' });
  const a = document.createElement('a');
  a.href = URL.createObjectURL(blob);
  a.download = name;
  document.body.appendChild(a); a.click(); a.remove();
  setTimeout(() => URL.revokeObjectURL(a.href), 1000);
}

function buildDevMd(d) {
  const id = specId().toUpperCase();
  const L = ['# ' + id + ' — 개발 핸드오프 (' + specTitle() + ')', '',
             '> 생성일 ' + today() + ' · 원본 = `' + location.pathname.split('/').pop() + '` ④ 섹션',
             '> 이 문서는 기획서에서 자동 추출됨. 내용이 어긋나면 **기획서가 원본**임.', '', '---', ''];
  if (d.blockers) L.push('## 0. 선행 조건 — 착수 전 반드시 해소', '', d.blockers, '');
  if (d.handoff)  L.push('## 1. 확정 구현 항목', '',
                         '기획 확정본 기준. 이 표의 값이 구현의 단일 기준이며, 본문과 어긋나면 이 표가 우선함.', '',
                         d.handoff, '');
  if (d.edge)     L.push('## 2. 엣지케이스 처리', '', d.edge, '');
  if (d.notes.length) L.push('---', '', ...d.notes.map(n => '> ' + n), '');
  return L.join('\n');
}
function buildQaMd(d) {
  const id = specId().toUpperCase();
  const L = ['# ' + id + ' — QA 체크리스트 (' + specTitle() + ')', '',
             '> 생성일 ' + today() + ' · 원본 = `' + location.pathname.split('/').pop() + '` ④ 섹션',
             '> 엣지케이스 처리 기준은 개발 핸드오프 문서 참조.', '', '---', ''];
  d.qa.forEach((g, i) => { L.push('## ' + (i + 1) + '. ' + g.name.replace(/^C-\d+\.\s*/, ''), '', g.md, ''); });
  return L.join('\n');
}
function buildQaCsv(d) {
  const q = s => '"' + String(s).replace(/"/g, '""') + '"';
  const rows = [['그룹', '케이스', '절차', '기대 결과', '결과(Pass/Fail)', '비고']];
  // md를 다시 파싱하지 않고 DOM을 재사용해 행 생성
  const s4 = document.getElementById('s4');
  let mode = null, cur = null;
  for (const el of s4.children) {
    if (el.tagName === 'H3') { mode = /^C\./.test(el.textContent.trim()) ? 'qa' : null; cur = null; continue; }
    if (el.tagName === 'H4' && mode === 'qa') { cur = el.textContent.trim().replace(/^C-\d+\.\s*/, ''); continue; }
    if (el.tagName === 'TABLE' && mode === 'qa' && cur) {
      [...el.querySelectorAll('tbody tr')].forEach(tr => {
        const c = [...tr.children].map(cellText);
        rows.push([cur, c[0] || '', c[1] || '', c[2] || '', '', '']);
      });
    }
  }
  return '﻿' + rows.map(r => r.map(q).join(',')).join('\r\n');   // BOM = 엑셀 한글 깨짐 방지
}

function run(kind) {
  const d = walkSection();
  if (!d) { alert('④ 섹션을 찾지 못했습니다.'); return; }
  const id = specId();
  if (kind === 'dev')      download('handoff-' + id + '-dev.md', buildDevMd(d), 'text/markdown');
  else if (kind === 'qa')  download('handoff-' + id + '-qa.md',  buildQaMd(d),  'text/markdown');
  else if (kind === 'csv') download('handoff-' + id + '-qa.csv', buildQaCsv(d), 'text/csv');
}

const CSS = '.dl-bar{display:flex;gap:8px;flex-wrap:wrap;margin:14px 0 18px}'
  + '.dl-bar button{font-family:inherit;font-size:0.8rem;font-weight:700;cursor:pointer;'
  + 'background:var(--surface2,#242430);color:var(--text,#e8e8ef);border:1px solid var(--border,#333);'
  + 'border-radius:8px;padding:7px 13px;display:inline-flex;align-items:center;gap:6px;transition:all .15s}'
  + '.dl-bar button:hover{border-color:var(--accent,#a78bfa);color:var(--accent,#a78bfa)}'
  + '.dl-bar .dl-hint{font-size:0.72rem;color:var(--text-dim,#8a90a0);align-self:center;margin-left:2px}';

function mount() {
  const s4 = document.getElementById('s4');
  if (!s4 || document.querySelector('.dl-bar')) return;
  const st = document.createElement('style'); st.textContent = CSS; document.head.appendChild(st);
  const bar = document.createElement('div');
  bar.className = 'dl-bar';
  bar.innerHTML =
      '<button type="button" data-dl="dev">⬇ 개발 핸드오프 (.md)</button>'
    + '<button type="button" data-dl="qa">⬇ QA 체크리스트 (.md)</button>'
    + '<button type="button" data-dl="csv">⬇ QA 체크리스트 (.csv)</button>'
    + '<span class="dl-hint">화면 내용을 그대로 내려받음 — 기획서를 고치면 파일도 같이 바뀜</span>';
  bar.addEventListener('click', e => {
    const b = e.target.closest('button[data-dl]');
    if (b) run(b.dataset.dl);
  });
  const header = s4.querySelector('.section-header');
  if (header && header.nextSibling) s4.insertBefore(bar, header.nextSibling);
  else s4.insertBefore(bar, s4.firstChild);
}

if (document.readyState === 'loading') document.addEventListener('DOMContentLoaded', mount);
else mount();

global.SPEC_HANDOFF = { run, buildDevMd, buildQaMd, buildQaCsv, walkSection };
})(window);
