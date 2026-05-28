/* ── 플로팅 메모장 (공유 모듈) ─────────────────────────────────────
 * 각 페이지에 <script src="memo.js"></script> 한 줄로 삽입.
 * localStorage 키: memo-{파일명} (확장자 제외)
 * 위치: 좌측 하단 고정 (bottom:24px, left:16px) — 모든 페이지 동일
 */
(function () {
  /* ── CSS 주입 ── */
  const css = `
.memo-widget {
  position: fixed;
  bottom: 24px;
  left: 16px;
  z-index: 500;
  width: 272px;
  background: var(--surface);
  border: 1px solid var(--border);
  border-radius: 14px;
  box-shadow: 0 8px 32px rgba(0,0,0,0.3);
  transition: box-shadow 0.2s;
}
.memo-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 10px 14px;
  cursor: pointer;
  border-radius: 14px 14px 0 0;
  user-select: none;
  transition: background 0.15s;
}
.memo-header:hover { background: var(--surface2); }
.memo-widget.collapsed .memo-header { border-radius: 14px; }
.memo-label {
  font-size: 0.8rem;
  font-weight: 700;
  color: var(--text);
  display: flex;
  align-items: center;
  gap: 6px;
}
.memo-toggle-btn {
  background: none;
  border: none;
  color: var(--text2);
  font-size: 1rem;
  cursor: pointer;
  padding: 0;
  line-height: 1;
}
.memo-body { padding: 0 10px 10px; }
.memo-widget.collapsed .memo-body { display: none; }
.memo-area {
  width: 100%;
  height: 150px;
  background: var(--surface2);
  border: 1px solid var(--border);
  border-radius: 8px;
  padding: 10px 12px;
  color: var(--text);
  font-size: 0.8rem;
  resize: none;
  line-height: 1.65;
  font-family: inherit;
  transition: border-color 0.15s;
}
.memo-area:focus { outline: none; border-color: var(--accent); }
[data-theme="light"] .memo-widget { box-shadow: 0 4px 20px rgba(0,0,0,0.12); }
`;
  const styleEl = document.createElement('style');
  styleEl.textContent = css;
  document.head.appendChild(styleEl);

  /* ── HTML 생성 ── */
  const widget = document.createElement('div');
  widget.className = 'memo-widget collapsed';
  widget.id = 'memoWidget';
  widget.innerHTML = `
    <div class="memo-header" id="memoHeader">
      <span class="memo-label">📝 메모</span>
      <button class="memo-toggle-btn" id="memoToggleBtn">＋</button>
    </div>
    <div class="memo-body">
      <textarea class="memo-area" id="memoArea" placeholder="수정사항, 피드백, 아이디어를 메모하세요…"></textarea>
    </div>`;
  document.body.appendChild(widget);

  /* ── 로직 ── */
  const page = location.pathname.split('/').pop().replace('.html', '') || 'index';
  const KEY  = 'memo-' + page;
  const area = widget.querySelector('#memoArea');
  const btn  = widget.querySelector('#memoToggleBtn');

  area.value = localStorage.getItem(KEY) || '';
  if (localStorage.getItem(KEY + '-open') === '1') {
    widget.classList.remove('collapsed');
    btn.textContent = '－';
  }
  area.addEventListener('input', () => localStorage.setItem(KEY, area.value));
  widget.querySelector('#memoHeader').addEventListener('click', function () {
    const col = widget.classList.toggle('collapsed');
    localStorage.setItem(KEY + '-open', col ? '0' : '1');
    btn.textContent = col ? '＋' : '－';
  });
})();
