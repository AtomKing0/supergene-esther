(function () {
  const filename = location.pathname.split('/').pop();
  const match = filename.match(/^(spec-\d+)/);
  if (!match) return;
  const specId  = match[1];
  const logKey  = specId + '-log';
  const noteKey = specId + '-completion-note';

  const STATUS_LABEL = {
    planned: '🟣 진행 예정',
    wip:     '🔵 진행중',
    open:    '🟡 검토중',
    hold:    '⚫ 보류',
    done:    '🟢 완료',
    archive: '🗄 아카이브',
  };

  // Seed initial creation entry if log is empty
  var createdMeta = document.querySelector('meta[name="spec-created"]');
  var createdDate = createdMeta ? createdMeta.getAttribute('content') : null;
  if (createdDate) {
    var existing = localStorage.getItem(logKey);
    if (!existing || existing === '[]') {
      var seed = JSON.stringify([{ date: createdDate, from: null, to: null, note: '기획서 생성' }]);
      localStorage.setItem(logKey, seed);
    }
  }

  function getLogs() {
    try { return JSON.parse(localStorage.getItem(logKey) || '[]'); } catch (e) { return []; }
  }

  function getNote() {
    return localStorage.getItem(noteKey) || '';
  }

  function saveNote(val) {
    localStorage.setItem(noteKey, val);
  }

  function escH(s) {
    return (s || '').replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;');
  }

  function render() {
    const logs = getLogs();
    const note = getNote();

    const rows = logs.length
      ? logs.map(function (e) {
          var desc;
          if (e.note) {
            desc = '<strong>' + escH(e.note) + '</strong>';
          } else {
            var fromLabel = e.from ? (STATUS_LABEL[e.from] || e.from) : '—';
            var toLabel   = STATUS_LABEL[e.to] || e.to;
            desc = escH(fromLabel) + ' → <strong>' + escH(toLabel) + '</strong>';
          }
          return '<li class="cl-row">'
            + '<span class="cl-date">' + escH(e.date) + '</span>'
            + '<span class="cl-desc">' + desc + '</span>'
            + '</li>';
        }).join('')
      : '<li class="cl-empty">상태 변경 이력이 없습니다.</li>';

    container.innerHTML =
      '<div class="cl-card" id="changelog">'
      +   '<div class="cl-title">변경 이력</div>'
      +   '<ul class="cl-list">' + rows + '</ul>'
      + '</div>'
      + '<div class="cl-card" id="completion-note">'
      +   '<div class="cl-title">완료 메모</div>'
      +   '<textarea class="cl-textarea" placeholder="완료 후 회고, 결과, 후속 조치 등을 메모하세요...">' + escH(note) + '</textarea>'
      + '</div>';

    container.querySelector('.cl-textarea').addEventListener('input', function () {
      saveNote(this.value);
    });
  }

  // Styles
  var style = document.createElement('style');
  style.textContent = [
    '.cl-card{background:var(--surface);border:1px solid var(--border);border-radius:var(--radius-lg,12px);padding:24px;margin-bottom:20px}',
    '.cl-title{font-size:12px;font-weight:700;text-transform:uppercase;letter-spacing:.07em;color:var(--text-dim);margin-bottom:14px}',
    '.cl-list{list-style:none;padding:0;margin:0}',
    '.cl-row{display:grid;grid-template-columns:160px 1fr;gap:12px;padding:10px 0;border-bottom:1px solid var(--border);font-size:13px}',
    '.cl-row:last-child{border-bottom:none}',
    '.cl-date{color:var(--text-dim);font-variant-numeric:tabular-nums;white-space:nowrap}',
    '.cl-desc{color:var(--text2)}',
    '.cl-desc strong{color:var(--text)}',
    '.cl-empty{color:var(--text-dim);font-size:13px;padding:8px 0}',
    '.cl-textarea{width:100%;min-height:100px;background:var(--surface2);border:1px solid var(--border);border-radius:8px;padding:12px;color:var(--text);font-size:14px;line-height:1.6;resize:vertical;font-family:inherit}',
    '.cl-textarea:focus{outline:none;border-color:var(--accent)}',
  ].join('');
  document.head.appendChild(style);

  // Sidenav links
  var nav = document.querySelector('.sidenav');
  if (nav) {
    var a1 = document.createElement('a');
    a1.className = 'nav-item';
    a1.href = '#changelog';
    a1.innerHTML = '<span class="nav-num">📋</span>변경 이력';
    nav.appendChild(a1);

    var a2 = document.createElement('a');
    a2.className = 'nav-item';
    a2.href = '#completion-note';
    a2.innerHTML = '<span class="nav-num">📝</span>완료 메모';
    nav.appendChild(a2);
  }

  // Mount container at end of main
  var main = document.querySelector('main.main') || document.querySelector('main');
  if (!main) return;
  var container = document.createElement('div');
  main.appendChild(container);

  render();
})();
