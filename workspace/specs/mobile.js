/* ── 모바일 공통 JS ── */
(function () {
  'use strict';

  /* ── 1. 스펙 상세 페이지: sidenav 햄버거 토글 ── */
  function initSidenav() {
    var sidenav = document.querySelector('.sidenav');
    if (!sidenav) return;

    var btn = document.createElement('button');
    btn.className = 'nav-toggle';
    btn.setAttribute('aria-label', '메뉴 열기');
    btn.innerHTML = '&#9776;';
    document.body.appendChild(btn);

    var overlay = document.createElement('div');
    overlay.className = 'nav-overlay';
    document.body.appendChild(overlay);

    function open() {
      sidenav.classList.add('nav-open');
      overlay.classList.add('nav-open');
      btn.innerHTML = '&#10005;';
    }
    function close() {
      sidenav.classList.remove('nav-open');
      overlay.classList.remove('nav-open');
      btn.innerHTML = '&#9776;';
    }

    btn.addEventListener('click', function () {
      sidenav.classList.contains('nav-open') ? close() : open();
    });
    overlay.addEventListener('click', close);

    sidenav.querySelectorAll('a').forEach(function (a) {
      a.addEventListener('click', function () {
        if (window.innerWidth <= 768) close();
      });
    });
  }

  /* ── 2. 상단 컨트롤 바: 글자 크기 슬라이더 + 테마 토글 ── */
  var ZOOMS = ['0.85', '1', '1.15'];

  function applyZoom(idx) {
    document.documentElement.style.zoom = ZOOMS[idx];
  }

  function initTopControls() {
    var savedIdx = parseInt(localStorage.getItem('mob-font-idx') || '1', 10);
    applyZoom(savedIdx);

    var bar = document.createElement('div');
    bar.className = 'top-controls';

    /* 슬라이더 섹션 */
    var sliderWrap = document.createElement('div');
    sliderWrap.className = 'top-ctrl-slider';

    var labelSm = document.createElement('span');
    labelSm.className = 'top-ctrl-label sm';
    labelSm.textContent = 'A';

    var slider = document.createElement('input');
    slider.type      = 'range';
    slider.className = 'top-ctrl-range';
    slider.min       = '0';
    slider.max       = '2';
    slider.step      = '1';
    slider.value     = String(savedIdx);

    var labelLg = document.createElement('span');
    labelLg.className = 'top-ctrl-label lg';
    labelLg.textContent = 'A';

    slider.addEventListener('input', function () {
      var idx = parseInt(slider.value, 10);
      applyZoom(idx);
      localStorage.setItem('mob-font-idx', String(idx));
    });

    sliderWrap.appendChild(labelSm);
    sliderWrap.appendChild(slider);
    sliderWrap.appendChild(labelLg);

    /* 구분선 */
    var divider = document.createElement('div');
    divider.className = 'top-ctrl-divider';

    /* 테마 토글: 기존 버튼을 바 안으로 이동 */
    var themeBtn = document.querySelector('.theme-toggle');
    if (!themeBtn) {
      /* fallback: theme-init보다 늦게 실행된 경우 없을 수 있음 — 직접 생성 */
      themeBtn = document.createElement('button');
      themeBtn.className = 'theme-toggle';
      var isLight = document.documentElement.getAttribute('data-theme') === 'light';
      themeBtn.textContent = isLight ? '☀️' : '🌙';
      themeBtn.addEventListener('click', function () {
        var light = document.documentElement.getAttribute('data-theme') === 'light';
        document.documentElement[light ? 'removeAttribute' : 'setAttribute']('data-theme', 'light');
        themeBtn.textContent = light ? '🌙' : '☀️';
        localStorage.setItem('spec-theme', light ? 'dark' : 'light');
      });
    }

    bar.appendChild(sliderWrap);
    bar.appendChild(divider);
    bar.appendChild(themeBtn);
    document.body.appendChild(bar);
    document.body.classList.add('has-top-controls');
  }

  /* ── 3. 인덱스 페이지: 핸들 기반 터치 드래그 앤 드롭 ── */
  function initTouchDnD() {
    var list = document.getElementById('specList');
    if (!list) return;

    var srcId        = null;
    var ghostEl      = null;
    var offsetX      = 0, offsetY = 0;
    var lastTargetId = null;
    var active       = false;

    function cardAt(x, y) {
      if (ghostEl) ghostEl.style.display = 'none';
      var els = document.elementsFromPoint(x, y);
      if (ghostEl) ghostEl.style.display = '';
      for (var i = 0; i < els.length; i++) {
        var c = els[i].closest ? els[i].closest('.spec-card') : null;
        if (c && c.dataset.id && c.dataset.id !== srcId) return c;
      }
      return null;
    }

    function createGhost(card, touchX, touchY) {
      var rect = card.getBoundingClientRect();
      offsetX = touchX - rect.left;
      offsetY = touchY - rect.top;
      ghostEl = card.cloneNode(true);
      ghostEl.style.cssText = [
        'position:fixed',
        'width:' + rect.width + 'px',
        'opacity:0.7',
        'pointer-events:none',
        'z-index:9999',
        'left:' + (touchX - offsetX) + 'px',
        'top:' + (touchY - offsetY) + 'px',
        'transform:scale(1.03)',
        'box-shadow:0 8px 32px rgba(0,0,0,0.5)',
      ].join(';');
      document.body.appendChild(ghostEl);
    }

    function onHandleTouchStart(e) {
      // 모달/오버레이가 열려 있으면 DnD 무시
      var overlay = document.querySelector('.sheet-overlay.open, #claudeOverlay.open');
      if (overlay) return;
      e.preventDefault();
      e.stopPropagation();
      var card = e.currentTarget.closest('.spec-card');
      if (!card || !card.dataset.id) return;
      srcId        = card.dataset.id;
      active       = false;
      lastTargetId = null;
      var t = e.touches[0];
      createGhost(card, t.clientX, t.clientY);
      card.classList.add('dragging');
    }

    function onTouchMove(e) {
      if (!srcId) return;
      e.preventDefault();
      active = true;
      var t = e.touches[0];
      ghostEl.style.left = (t.clientX - offsetX) + 'px';
      ghostEl.style.top  = (t.clientY - offsetY) + 'px';
      var over   = cardAt(t.clientX, t.clientY);
      var overId = over ? over.dataset.id : null;
      if (overId !== lastTargetId) {
        list.querySelectorAll('.spec-card').forEach(function (c) { c.classList.remove('drag-over'); });
        if (over) over.classList.add('drag-over');
        lastTargetId = overId;
      }
    }

    function onTouchEnd(e) {
      if (!srcId) return;
      var targetId = null;
      if (active) {
        var t = (e.changedTouches || [])[0];
        if (t) {
          var over = cardAt(t.clientX, t.clientY);
          targetId = over ? over.dataset.id : null;
        }
      }
      if (ghostEl) { ghostEl.remove(); ghostEl = null; }
      list.querySelectorAll('.spec-card').forEach(function (c) {
        c.classList.remove('dragging', 'drag-over');
      });
      if (targetId && targetId !== srcId &&
          typeof getAllItems === 'function' &&
          typeof saveOrder  === 'function' &&
          typeof render     === 'function') {
        var allItems = getAllItems();
        var order    = typeof getOrder === 'function' ? getOrder() : [];
        var ids;
        if (order.length) {
          var map = {};
          allItems.forEach(function (i) { map[i.id] = i; });
          var sorted = order.map(function (id) { return map[id]; }).filter(Boolean);
          var rest   = allItems.filter(function (i) { return order.indexOf(i.id) === -1; });
          ids = sorted.concat(rest).map(function (i) { return i.id; });
        } else {
          ids = allItems.map(function (i) { return i.id; });
        }
        var si = ids.indexOf(srcId);
        var ti = ids.indexOf(targetId);
        if (si !== -1 && ti !== -1) {
          ids.splice(si, 1);
          ids.splice(ti, 0, srcId);
          saveOrder(ids);
          render();
        }
      }
      srcId = null; lastTargetId = null; active = false;
    }

    document.addEventListener('touchmove',   onTouchMove,  { passive: false });
    document.addEventListener('touchend',    onTouchEnd);
    document.addEventListener('touchcancel', onTouchEnd);

    function bindHandles() {
      list.querySelectorAll('.drag-handle').forEach(function (h) {
        h.removeEventListener('touchstart', onHandleTouchStart);
        h.addEventListener('touchstart', onHandleTouchStart, { passive: false });
      });
    }

    new MutationObserver(bindHandles).observe(list, { childList: true, subtree: true });
    bindHandles();
  }

  /* ── 4. 스펙 상세 페이지: 인라인 채팅 FAB ── */
  function initSpecChat() {
    if (!document.querySelector('.sidenav')) return; // 스펙 페이지만
    if (document.getElementById('specList'))  return; // 인덱스 제외

    // FAB
    var fab = document.createElement('button');
    fab.className = 'claude-fab';
    fab.style.cssText = 'position:fixed;bottom:24px;right:24px;z-index:450;width:50px;height:50px;border-radius:50%;border:none;background:var(--accent,#a78bfa);color:#fff;font-size:22px;cursor:pointer;display:flex;align-items:center;justify-content:center;box-shadow:0 4px 16px rgba(0,0,0,0.4)';
    fab.title = 'Claude에게 수정 요청';
    fab.innerHTML = '✨';
    document.body.appendChild(fab);

    // 모달 CSS 주입
    var style = document.createElement('style');
    style.textContent = [
      '#specChatOverlay{position:fixed;inset:0;z-index:800;display:none;align-items:flex-end;justify-content:center;background:rgba(0,0,0,0.5)}',
      '#specChatOverlay.open{display:flex}',
      '#specChatModal{width:100%;max-width:700px;max-height:70vh;background:var(--surface,#1a1d27);border-radius:16px 16px 0 0;display:flex;flex-direction:column;overflow:hidden}',
      '#specChatHeader{display:flex;align-items:center;justify-content:space-between;padding:12px 16px;border-bottom:1px solid var(--border,#2e3347);flex-shrink:0}',
      '#specChatHistory{flex:1;overflow-y:auto;padding:12px 16px;display:flex;flex-direction:column;gap:10px}',
      '.sc-msg{max-width:85%;display:flex;flex-direction:column}',
      '.sc-msg.user{align-self:flex-end;align-items:flex-end}',
      '.sc-msg.ai{align-self:flex-start}',
      '.sc-bubble{padding:9px 13px;border-radius:14px;font-size:13px;line-height:1.6;white-space:pre-wrap;word-break:break-word}',
      '.sc-msg.user .sc-bubble{background:var(--accent,#a78bfa);color:#fff;border-bottom-right-radius:3px}',
      '.sc-msg.ai .sc-bubble{background:var(--surface2,#222636);border:1px solid var(--border,#2e3347);color:var(--text,#e2e8f0);border-bottom-left-radius:3px}',
      '#specChatInput{display:flex;gap:8px;padding:10px 12px;border-top:1px solid var(--border,#2e3347);flex-shrink:0}',
      '#specChatInput textarea{flex:1;min-height:38px;max-height:100px;background:var(--surface2,#222636);border:1px solid var(--border,#2e3347);border-radius:10px;color:var(--text,#e2e8f0);font-size:13px;padding:7px 10px;resize:none;font-family:inherit;outline:none;line-height:1.5}',
      '#specChatInput button{width:38px;height:38px;border-radius:50%;border:none;background:var(--accent,#a78bfa);color:#fff;font-size:16px;cursor:pointer;flex-shrink:0;display:flex;align-items:center;justify-content:center}',
      '#specChatInput button:disabled{opacity:0.45;cursor:not-allowed}',
    ].join('');
    document.head.appendChild(style);

    // 모달 HTML
    var overlay = document.createElement('div');
    overlay.id = 'specChatOverlay';
    overlay.innerHTML = [
      '<div id="specChatModal" onclick="event.stopPropagation()">',
      '  <div id="specChatHeader">',
      '    <span style="font-weight:700;font-size:14px">✨ 수정 요청</span>',
      '    <span style="font-size:11px;color:var(--text-dim,#64748b)">⚡ content-spec-writer</span>',
      '    <button onclick="document.getElementById(\'specChatOverlay\').classList.remove(\'open\')" style="background:none;border:none;color:var(--text-dim,#64748b);font-size:18px;cursor:pointer;padding:0 4px">✕</button>',
      '  </div>',
      '  <div id="specChatHistory"></div>',
      '  <div id="specChatInput">',
      '    <textarea id="specChatTa" placeholder="수정 요청을 입력하세요… (Cmd+Enter)" rows="1"',
      '      oninput="this.style.height=\'auto\';this.style.height=Math.min(this.scrollHeight,100)+\'px\'"',
      '      onkeydown="if(event.key===\'Enter\'&&(event.metaKey||event.ctrlKey)){event.preventDefault();specChatSend()}"></textarea>',
      '    <button id="specChatBtn" onclick="specChatSend()">↑</button>',
      '  </div>',
      '</div>',
    ].join('');
    document.body.appendChild(overlay);

    fab.addEventListener('click', function () {
      overlay.classList.toggle('open');
      if (overlay.classList.contains('open')) {
        setTimeout(function () { document.getElementById('specChatTa').focus(); }, 120);
      }
    });
    overlay.addEventListener('click', function (e) {
      if (e.target === overlay) overlay.classList.remove('open');
    });

    var _scHistory = [];

    function mdToHtml(t) {
      return t.replace(/&/g,'&amp;').replace(/</g,'&lt;').replace(/>/g,'&gt;')
               .replace(/\*\*(.+?)\*\*/g,'<b>$1</b>')
               .replace(/`([^`]+)`/g,'<code style="background:rgba(255,255,255,0.08);border-radius:3px;padding:1px 4px;font-family:monospace">$1</code>')
               .replace(/\n/g,'<br>');
    }

    function scAppend(role, text) {
      var h = document.getElementById('specChatHistory');
      var wrap = document.createElement('div');
      wrap.className = 'sc-msg ' + role;
      var bub = document.createElement('div');
      bub.className = 'sc-bubble';
      if (role === 'ai') bub.innerHTML = mdToHtml(text); else bub.textContent = text;
      wrap.appendChild(bub);
      h.appendChild(wrap);
      h.scrollTop = h.scrollHeight;
      return bub;
    }

    window.specChatSend = function () {
      var ta  = document.getElementById('specChatTa');
      var btn = document.getElementById('specChatBtn');
      var userText = ta.value.trim();
      if (!userText || btn.disabled) return;

      // 현재 spec 파일명을 컨텍스트로 포함
      var specFile = window.location.pathname.split('/').pop();
      var prompt = '[대상 spec 파일: ' + specFile + ']\n';
      if (_scHistory.length) {
        prompt += '[이전 대화]\n' + _scHistory.map(function(m) {
          return (m.role === 'user' ? '사용자: ' : 'Claude: ') + m.text;
        }).join('\n\n') + '\n\n';
      }
      prompt += '[수정 요청]\n' + userText;

      _scHistory.push({ role: 'user', text: userText });
      scAppend('user', userText);
      ta.value = ''; ta.style.height = 'auto';
      btn.disabled = true;

      // 타이핑 인디케이터
      var typingWrap = document.createElement('div');
      typingWrap.className = 'sc-msg ai';
      typingWrap.id = 'scTyping';
      typingWrap.innerHTML = '<div class="sc-bubble" style="opacity:0.5">...</div>';
      document.getElementById('specChatHistory').appendChild(typingWrap);

      fetch('/api/claude', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ prompt: prompt, agent: 'content-spec-writer' }),
      }).then(function (res) {
        var t = document.getElementById('scTyping');
        if (t) t.remove();
        if (!res.ok) { scAppend('ai', '⚠️ 서버 오류'); btn.disabled = false; return; }
        var bubble = scAppend('ai', '');
        var full = '';

        function onDone() {
          _scHistory.push({ role: 'ai', text: full });
          btn.disabled = false;
          if (full.indexOf('수정') !== -1 || full.indexOf('완료') !== -1 || full.indexOf('저장') !== -1) {
            var reloadBtn = document.createElement('button');
            reloadBtn.textContent = '🔄 페이지 새로고침';
            reloadBtn.style.cssText = 'margin-top:8px;padding:6px 12px;border-radius:8px;border:1px solid var(--accent,#a78bfa);background:transparent;color:var(--accent,#a78bfa);cursor:pointer;font-size:12px';
            reloadBtn.onclick = function () { location.reload(); };
            bubble.parentElement.appendChild(reloadBtn);
          }
        }

        if (res.body && res.body.getReader) {
          // 스트리밍 (Chrome/최신 Safari)
          var reader = res.body.getReader();
          var decoder = new TextDecoder();
          function read() {
            reader.read().then(function (r) {
              if (r.done) { onDone(); return; }
              full += decoder.decode(r.value, { stream: true });
              bubble.innerHTML = mdToHtml(full);
              document.getElementById('specChatHistory').scrollTop = 9999;
              read();
            }).catch(function(e) { scAppend('ai', '⚠️ ' + e.message); btn.disabled = false; });
          }
          read();
        } else {
          // 폴백: 전체 응답 대기 (iOS Safari 구버전)
          res.text().then(function (text) {
            full = text;
            bubble.innerHTML = mdToHtml(full);
            onDone();
          }).catch(function(e) { scAppend('ai', '⚠️ ' + e.message); btn.disabled = false; });
        }
      }).catch(function (err) {
        var t = document.getElementById('scTyping');
        if (t) t.remove();
        scAppend('ai', '⚠️ ' + err.message);
        btn.disabled = false;
      });
    };
  }

  /* ── 스펙 상태 위젯 ── */
  function initStatusWidget() {
    var m = window.location.pathname.match(/\/(spec-\d+)/);
    if (!m) return;
    var specId = m[1];

    var STATUSES = [
      { val:'open',    label:'🔵 검토중'   },
      { val:'planned', label:'🟣 진행예정' },
      { val:'wip',     label:'🟡 진행중'   },
      { val:'done',    label:'✅ 완료'     },
      { val:'hold',    label:'⏸ 보류'     },
      { val:'archive', label:'🗄️ 아카이브' },
    ];

    function getOv() { try { return JSON.parse(localStorage.getItem('spec-ov') || '{}'); } catch(e) { return {}; } }
    function curStatus() { var o = getOv(); return (o[specId] && o[specId].status) || 'open'; }

    // <select> 드롭다운
    var sel = document.createElement('select');
    sel.className = 'sw-select sw-' + curStatus();
    STATUSES.forEach(function(s) {
      var opt = document.createElement('option');
      opt.value = s.val;
      opt.textContent = s.label;
      if (s.val === curStatus()) opt.selected = true;
      sel.appendChild(opt);
    });

    sel.addEventListener('change', function() {
      var ov = getOv();
      var from = (ov[specId] && ov[specId].status) || 'open';
      var val = sel.value;
      if (!ov[specId]) ov[specId] = {};
      ov[specId].status = val;
      localStorage.setItem('spec-ov', JSON.stringify(ov));
      sel.className = 'sw-select sw-' + val;
      var r = ov[specId];
      fetch('/api/sb/spec_overrides', {
        method:'POST', headers:{'Content-Type':'application/json'},
        body: JSON.stringify({ spec_id:specId, tags:r.tags||[], priority:r.priority||'mid',
          status:val, due_date:r.dueDate||null, related_to:r.relatedTo||[],
          updated_at: new Date().toISOString() }),
      }).catch(function(){});
      if (from !== val) {
        fetch('/api/sb/spec_status_log', {
          method:'POST', headers:{'Content-Type':'application/json'},
          body: JSON.stringify({ spec_id:specId, from_status:from, to_status:val }),
        }).catch(function(){});
      }
    });

    var row = document.createElement('div');
    row.className = 'sw-row';
    row.appendChild(sel);

    // h1 바로 아래 삽입
    var h1 = document.querySelector('.main h1, main h1, h1');
    if (h1 && h1.parentNode) {
      h1.parentNode.insertBefore(row, h1.nextSibling);
    }
  }

  /* ── 초기화 ── */
  function init() {
    initSidenav();
    initTopControls();
    initStatusWidget();
    initTouchDnD();
    initSpecChat();
  }

  if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', init);
  } else {
    init();
  }
})();
