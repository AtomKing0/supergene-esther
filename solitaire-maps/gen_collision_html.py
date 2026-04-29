"""
schedule_collision_review.html 재생성 스크립트
Cross-depth push 대폭 강화: (ov + 10) / 2 → 10px 실제 gap 확보
Same-depth push: ov / 2 → 완전 분리 (0px 잔류 겹침)
"""
import json, math, os, copy, re
from collections import defaultdict

CARD_W = 100
CARD_H = 150
OBB_OVERLAP_MARGIN = 2      # 게임 OBB 충돌 판정 마진
CROSS_THRESHOLD = 5.0        # cross-depth 감지 최대 overlap (px)
SAME_GAP_TARGET = 0          # same-depth: 0px 잔류 (완전 분리)
CROSS_GAP = 5                # cross-depth: 5px 명확한 gap
MAX_ITER = 300

SCHEDULE_BASE = os.path.join(os.path.dirname(__file__), "converted", "schedule", "week_00_launch")
CSV_PATH = "/Users/estherpark/esther_solitaire/solitaire-esther-1/workspace/archive/solitaire-tripeaks-stages-2026-04-15 (1).csv"

# ── OBB 유틸 ─────────────────────────────────────────────────────────────
def get_vertices(cx, cy, w, h, angle_deg):
    rad = math.radians(angle_deg)
    cos_a, sin_a = math.cos(rad), math.sin(rad)
    hw, hh = w / 2, h / 2
    return [(cx + lx*cos_a - ly*sin_a, cy + lx*sin_a + ly*cos_a)
            for lx, ly in [(-hw,-hh),(hw,-hh),(hw,hh),(-hw,hh)]]

def project(verts, axis):
    dots = [v[0]*axis[0] + v[1]*axis[1] for v in verts]
    return min(dots), max(dots)

def get_overlap(r1, r2):
    return min(r1[1], r2[1]) - max(r1[0], r2[0])

def sep_vec(c1, c2, thr=None):
    """OBB SAT: 충돌 시 (분리축, 최소겹침) 반환. 비충돌 시 (None, 0)"""
    v1 = get_vertices(c1["x"], c1["y"], CARD_W, CARD_H, c1["angle"])
    v2 = get_vertices(c2["x"], c2["y"], CARD_W, CARD_H, c2["angle"])
    axes = []
    for angle in (c1["angle"], c2["angle"]):
        rad = math.radians(angle)
        cos_a, sin_a = math.cos(rad), math.sin(rad)
        axes += [(cos_a, sin_a), (-sin_a, cos_a)]

    min_ov = float('inf')
    min_ax = None
    for ax in axes:
        ov = get_overlap(project(v1, ax), project(v2, ax))
        if ov <= OBB_OVERLAP_MARGIN:
            return None, 0
        if ov < min_ov:
            min_ov = ov
            min_ax = ax

    # thr: cross-depth용 — 마진 초과지만 thr 이하인 것만
    if thr is not None and min_ov > thr:
        return None, 0

    # 분리 방향 결정
    dx = c2["x"] - c1["x"]
    dy = c2["y"] - c1["y"]
    dot = dx * min_ax[0] + dy * min_ax[1]
    if dot < 0:
        min_ax = (-min_ax[0], -min_ax[1])
    return min_ax, min_ov

# ── fix_all ───────────────────────────────────────────────────────────────
def fix_all(cards):
    fixed = copy.deepcopy(cards)
    fi = [i for i, c in enumerate(fixed) if not c.get('isDrawCard')]
    bd = defaultdict(list)
    for i in fi:
        bd[fixed[i]['depth']].append(i)
    pos = {i: [float(fixed[i]['position']['x']), float(fixed[i]['position']['y'])] for i in fi}

    for _ in range(MAX_ITER):
        af = False

        # 1) same-depth: 완전 분리 (SAME_GAP_TARGET = 0)
        for d, g in bd.items():
            for a in range(len(g)):
                for b in range(a+1, len(g)):
                    i, j = g[a], g[b]
                    c1 = {'x': pos[i][0], 'y': pos[i][1], 'angle': fixed[i].get('angle', 0)}
                    c2 = {'x': pos[j][0], 'y': pos[j][1], 'angle': fixed[j].get('angle', 0)}
                    ax, ov = sep_vec(c1, c2)
                    if ax:
                        # ov → 0px (OBB_OVERLAP_MARGIN 이하로 충분히)
                        p = (ov - OBB_OVERLAP_MARGIN + 2.0) / 2
                        pos[i][0] -= ax[0] * p; pos[i][1] -= ax[1] * p
                        pos[j][0] += ax[0] * p; pos[j][1] += ax[1] * p
                        af = True

        # 2) cross-depth: CROSS_GAP만큼 실제 gap 확보
        for a in range(len(fi)):
            for b in range(a+1, len(fi)):
                i, j = fi[a], fi[b]
                if fixed[i]['depth'] == fixed[j]['depth']:
                    continue
                c1 = {'x': pos[i][0], 'y': pos[i][1], 'angle': fixed[i].get('angle', 0)}
                c2 = {'x': pos[j][0], 'y': pos[j][1], 'angle': fixed[j].get('angle', 0)}
                ax, ov = sep_vec(c1, c2, thr=CROSS_THRESHOLD)
                if ax:
                    # ov → -(CROSS_GAP)px : CROSS_GAP px 실제 gap
                    p = (ov + CROSS_GAP) / 2
                    pos[i][0] -= ax[0] * p; pos[i][1] -= ax[1] * p
                    pos[j][0] += ax[0] * p; pos[j][1] += ax[1] * p
                    af = True

        if not af:
            break

    for i in fi:
        fixed[i]['position']['x'] = round(pos[i][0])
        fixed[i]['position']['y'] = round(pos[i][1])
    return fixed

# ── 충돌 감지 (raw) ───────────────────────────────────────────────────────
def detect_issues(cards):
    fi = [i for i, c in enumerate(cards) if not c.get('isDrawCard')]
    bd = defaultdict(list)
    for i in fi:
        bd[cards[i]['depth']].append(i)

    same_cols = []
    for d, g in bd.items():
        for a in range(len(g)):
            for b in range(a+1, len(g)):
                i, j = g[a], g[b]
                c1 = {'x': cards[i]['position']['x'], 'y': cards[i]['position']['y'], 'angle': cards[i].get('angle', 0)}
                c2 = {'x': cards[j]['position']['x'], 'y': cards[j]['position']['y'], 'angle': cards[j].get('angle', 0)}
                ax, ov = sep_vec(c1, c2)
                if ax:
                    same_cols.append((i, j, d, ov))

    cross_cols = []
    for a in range(len(fi)):
        for b in range(a+1, len(fi)):
            i, j = fi[a], fi[b]
            if cards[i]['depth'] == cards[j]['depth']:
                continue
            c1 = {'x': cards[i]['position']['x'], 'y': cards[i]['position']['y'], 'angle': cards[i].get('angle', 0)}
            c2 = {'x': cards[j]['position']['x'], 'y': cards[j]['position']['y'], 'angle': cards[j].get('angle', 0)}
            ax, ov = sep_vec(c1, c2, thr=CROSS_THRESHOLD)
            if ax:
                cross_cols.append((i, j, cards[i]['depth'], cards[j]['depth'], ov))

    return same_cols, cross_cols

# ── CC ID CSV 로드 ────────────────────────────────────────────────────────
def load_cc_id_map():
    """CSV: stage_id=CC_XXXX, original_json_file_name=파일명 → map_id 추출"""
    cc_map = {}
    try:
        import csv, re
        with open(CSV_PATH, encoding='utf-8-sig') as f:
            reader = csv.DictReader(f)
            for row in reader:
                cc_name = str(row.get('stage_id', '')).strip()
                fname = str(row.get('original_json_file_name', '')).strip()
                m = re.search(r'obj_(-?\d+)_', fname)
                if cc_name and m:
                    cc_map[m.group(1)] = cc_name
    except Exception as e:
        print(f"CSV 로드 오류: {e}")
    return cc_map

def load_cc_id_map_from_html():
    """기존 HTML에서 CC_ID_MAP 파싱"""
    html_path = os.path.join(os.path.dirname(__file__), "schedule_collision_review.html")
    try:
        with open(html_path, encoding='utf-8') as f:
            content = f.read()
        m = re.search(r'const CC_ID_MAP=(\{[^;]+\});', content)
        if m:
            return json.loads(m.group(1))
    except:
        pass
    return {}

# ── 메인 ─────────────────────────────────────────────────────────────────
def main():
    # CC ID 맵 로드 (CSV 우선, 기존 HTML 폴백)
    cc_id_map = load_cc_id_map()
    if not cc_id_map:
        cc_id_map = load_cc_id_map_from_html()
        print(f"HTML에서 CC_ID_MAP 로드: {len(cc_id_map)}개")
    else:
        print(f"CSV에서 CC_ID_MAP 로드: {len(cc_id_map)}개")

    DIFF_COLOR = {
        'VeryEasy': '#607d8b', 'Easy': '#8bc34a', 'Normal': '#ff9800',
        'Hard': '#f44336', 'VeryHard': '#9c27b0',
    }

    chunks_data = {}  # chunk_name → list of map entries
    map_ids_seen = set()

    LEVEL_BASE = os.path.join(os.path.dirname(__file__), "converted", "level_data")

    # level_data 전체 map_id → path 인덱스
    ld_index = {}
    for d in os.listdir(LEVEL_BASE):
        dp = os.path.join(LEVEL_BASE, d)
        if not os.path.isdir(dp): continue
        for fn in os.listdir(dp):
            mm = re.search(r'obj_(-?\d+)_', fn)
            if mm:
                ld_index[mm.group(1)] = os.path.join(dp, fn)
    print(f"level_data 인덱스: {len(ld_index)}개")

    # chunk_4 중 level_data 없는 맵 하드코딩
    CHUNK4_KNOWN = {
        '-2397008531233033957': (False, True),
        '-4085239007266526198': (False, True),
        '-4367956446511700689': (False, True),
        '2614617043532549192':  (False, True),
        '4825420391306583281':  (True,  True),
        '4967511773866997684':  (False, True),
        '5817092195126959395':  (True,  True),
        '7629362497685869891':  (True,  True),
        '8414211997008221011':  (True,  False),
        '-2584308845143270527': (False, True),
        '-440283477310521795':  (False, True),
        '-4930359017288338014': (False, True),
        '-5831820742631492957': (False, True),
        '-7292222822313839875': (False, True),
        '5692771625035672355':  (False, True),
    }

    for chunk in sorted(os.listdir(SCHEDULE_BASE)):
        chunk_path = os.path.join(SCHEDULE_BASE, chunk)
        if not os.path.isdir(chunk_path):
            continue

        entries = []
        for fname in sorted(os.listdir(chunk_path)):
            if not fname.endswith('.json'):
                continue

            fpath = os.path.join(chunk_path, fname)

            m = re.search(r'obj_(-?\d+)_', fname)
            if not m:
                continue
            map_id = m.group(1)

            if map_id in map_ids_seen:
                continue

            diff = fname.split('_')[0]

            # level_data 원본으로 충돌 감지
            ldpath = ld_index.get(map_id)
            if ldpath:
                try:
                    with open(ldpath, encoding='utf-8') as f:
                        orig_cards = json.loads(json.load(f)['stage']['map'])
                    same_cols, cross_cols = detect_issues(orig_cards)
                    has_same = len(same_cols) > 0
                    has_cross = len(cross_cols) > 0
                except Exception as e:
                    print(f"level_data 오류: {fname}: {e}")
                    continue
                if not has_same and not has_cross:
                    continue
            elif map_id in CHUNK4_KNOWN:
                # chunk_4 level_data 없음 → 하드코딩
                has_same, has_cross = CHUNK4_KNOWN[map_id]
                same_cols, cross_cols = [], []
            else:
                continue  # 이슈 없음

            map_ids_seen.add(map_id)

            # JSON copy = 현재 수정된 파일 내용
            try:
                with open(fpath, encoding='utf-8') as f:
                    data = json.load(f)
            except Exception as e:
                print(f"오류: {fname}: {e}")
                continue

            # col-detail (원본 기준)
            details = []
            for (i, j, d, ov) in same_cols:
                details.append(f"same d={d}: card[{i}]↔[{j}] {ov:.1f}px")
            for (i, j, d1, d2, ov) in cross_cols:
                details.append(f"cross d={d1}↔{d2}: card[{i}]↔[{j}] {ov:.1f}px")

            entries.append({
                'map_id': map_id,
                'fname': fname,
                'diff': diff,
                'has_same': has_same,
                'has_cross': has_cross,
                'col_detail': ' | '.join(details[:3]) + (' ...' if len(details) > 3 else ''),
                'fixed_json': json.dumps(data, indent=2, ensure_ascii=False),  # 이미 수정된 파일
                'cc_name': cc_id_map.get(map_id, ''),
            })

        if entries:
            chunks_data[chunk] = entries

    total = sum(len(v) for v in chunks_data.values())
    print(f"\n총 {total}개 맵 (", end='')
    for chunk, entries in chunks_data.items():
        print(f"{chunk}:{len(entries)}", end=' ')
    print(")")

    # ── HTML 생성 ──────────────────────────────────────────────────────────
    # JSON_DATA 딕트 빌드
    json_data_items = []
    cc_id_items = []
    for chunk, entries in chunks_data.items():
        for e in entries:
            json_data_items.append(f'"{e["map_id"]}": {json.dumps(e["fixed_json"])}')
            if e['cc_name']:
                cc_id_items.append(f'"{e["map_id"]}": "{e["cc_name"]}"')

    json_data_js = 'const JSON_DATA={' + ',\n'.join(json_data_items) + '};'
    cc_id_js = 'const CC_ID_MAP={' + ','.join(cc_id_items) + '};'

    # 맵 아이템 HTML
    map_html_parts = []
    for chunk, entries in sorted(chunks_data.items()):
        chunk_id = chunk
        count = len(entries)
        items_html = []
        for e in entries:
            mid = e['map_id']
            diff = e['diff']
            color = DIFF_COLOR.get(diff, '#888')
            tags = ''
            if e['has_same']:
                tags += '<span class="tag same">same-depth</span>'
            if e['has_cross']:
                tags += '<span class="tag cross">corner-touch</span>'
            cc_btn = f'<button class="btn-cc" onclick="copyCc(\'{mid}\')">{e["cc_name"]}</button>' if e['cc_name'] else ''
            only_cross = '(cross-depth only)' if e['has_cross'] and not e['has_same'] else e['col_detail']
            items_html.append(f'''        <div class="map-item" id="item-{mid}">
          <label class="checkbox-wrap"><input type="checkbox" onchange="onCheck(this,'{mid}')"><span class="checkmark"></span></label>
          <div class="map-body">
            <div class="map-top">
              <span class="badge" style="background:{color}">{diff}</span>{tags}
              <span class="map-id" onclick="copyId('{mid}')">{mid}</span>
              {cc_btn}
              <button class="btn-json" onclick="copyJson('{mid}')">JSON copy</button>
            </div>
            <div class="col-detail">{only_cross}</div>
          </div>
        </div>''')

        map_html_parts.append(f'''    <div class="week-section">
      <div class="week-header" onclick="toggleWeek(this)">
        <span class="week-title">week_00_launch / {chunk}</span>
        <span class="week-count">{count}개</span>
        <span class="week-progress" id="prog-{chunk_id}">0/{count}</span>
        <span class="toggle-icon">▼</span>
      </div>
      <div class="week-body">
''' + '\n'.join(items_html) + '\n      </div>\n    </div>')

    map_html = '\n'.join(map_html_parts)

    # 진행 카운터용 chunk별 카운트 JS
    chunk_counts_js = '{' + ','.join(f'"{k}":{len(v)}' for k,v in chunks_data.items()) + '}'

    html = f"""<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8"><meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>week_00_launch Collision Review ({total}개)</title>
<style>
  *{{box-sizing:border-box;margin:0;padding:0}}
  body{{font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',sans-serif;background:#0f0f13;color:#e0e0e0;min-height:100vh}}
  header{{background:#1a1a24;border-bottom:1px solid #2a2a3a;padding:16px 24px;position:sticky;top:0;z-index:100;display:flex;align-items:center;gap:12px;flex-wrap:wrap}}
  header h1{{font-size:18px;font-weight:700;color:#fff}}
  .total-badge{{background:#f44336;color:#fff;border-radius:12px;padding:2px 10px;font-size:13px;font-weight:700}}
  .note{{font-size:12px;color:#7ec87e;background:#1e2e1e;border:1px solid #3a553a;border-radius:6px;padding:4px 10px}}
  .global-prog{{margin-left:auto;font-size:13px;color:#888}}
  .global-prog strong{{color:#4caf50;font-size:15px}}
  .container{{max-width:920px;margin:0 auto;padding:20px 16px 60px}}
  .week-section{{background:#1a1a24;border-radius:10px;margin-bottom:12px;overflow:hidden;border:1px solid #2a2a3a}}
  .week-header{{display:flex;align-items:center;gap:10px;padding:12px 16px;cursor:pointer;user-select:none;transition:background .15s}}
  .week-header:hover{{background:#22222e}}
  .week-title{{font-weight:700;font-size:15px;color:#ccc;flex:1}}
  .week-count{{background:#2a2a3a;border-radius:10px;padding:2px 8px;font-size:12px;color:#888}}
  .week-progress{{font-size:12px;color:#4caf50;min-width:48px;text-align:right}}
  .toggle-icon{{color:#555;font-size:11px;transition:transform .2s}}
  .week-header.collapsed .toggle-icon{{transform:rotate(-90deg)}}
  .week-body{{border-top:1px solid #2a2a3a}}
  .week-body.hidden{{display:none}}
  .map-item{{display:flex;align-items:flex-start;gap:10px;padding:10px 16px;border-bottom:1px solid #1e1e2a;transition:background .15s}}
  .map-item:last-child{{border-bottom:none}}
  .map-item:hover{{background:#1e1e2c}}
  .map-item.done{{opacity:.4}}
  .map-item.done .map-id{{text-decoration:line-through;color:#555}}
  .checkbox-wrap{{position:relative;flex-shrink:0;margin-top:3px}}
  .checkbox-wrap input{{position:absolute;opacity:0;width:0;height:0}}
  .checkmark{{display:block;width:18px;height:18px;border:2px solid #444;border-radius:4px;cursor:pointer;transition:background .15s,border-color .15s}}
  .checkbox-wrap input:checked~.checkmark{{background:#4caf50;border-color:#4caf50}}
  .checkmark::after{{content:'';display:none;position:absolute;left:5px;top:2px;width:5px;height:9px;border:solid #fff;border-width:0 2px 2px 0;transform:rotate(45deg)}}
  .checkbox-wrap input:checked~.checkmark::after{{display:block}}
  .map-body{{flex:1;min-width:0}}
  .map-top{{display:flex;align-items:center;gap:6px;flex-wrap:wrap}}
  .badge{{border-radius:4px;padding:1px 7px;font-size:11px;font-weight:700;color:#fff;flex-shrink:0}}
  .tag{{border-radius:4px;padding:1px 6px;font-size:10px;font-weight:600;flex-shrink:0}}
  .tag.same{{background:#2a2a4a;color:#8888ff}}
  .tag.cross{{background:#2a1a1a;color:#ff8888}}
  .map-id{{font-size:14px;font-weight:700;color:#7ec8ff;font-family:monospace;cursor:pointer;letter-spacing:-.5px;padding:2px 5px;border-radius:4px;transition:background .15s}}
  .map-id:hover{{background:#1e3a55}}
  .btn-cc{{background:#1e2e1e;border:1px solid #3a553a;color:#7ec87e;padding:2px 9px;border-radius:5px;font-size:12px;font-weight:700;cursor:pointer;flex-shrink:0}}
  .btn-cc:hover{{background:#253525;color:#aeffae}}
  .btn-json{{margin-left:auto;background:#23233a;border:1px solid #3a3a55;color:#a0a0c0;padding:2px 10px;border-radius:5px;font-size:12px;cursor:pointer;flex-shrink:0}}
  .btn-json:hover{{background:#2e2e50;color:#fff}}
  .col-detail{{font-size:11px;color:#555;margin-top:4px;white-space:nowrap;overflow:hidden;text-overflow:ellipsis}}
  #toast{{position:fixed;bottom:32px;left:50%;transform:translateX(-50%) translateY(20px);background:#23233a;border:1px solid #4caf50;color:#4caf50;padding:9px 20px;border-radius:8px;font-size:13px;font-weight:600;opacity:0;pointer-events:none;transition:opacity .2s,transform .2s;z-index:9999}}
  #toast.show{{opacity:1;transform:translateX(-50%) translateY(0)}}
</style>
</head>
<body>
<header>
  <h1>week_00_launch Collision Review</h1>
  <span class="total-badge">{total}개</span>
  <span class="note">JSON copy = 충돌 수정 버전 (cross-depth +10px gap) &nbsp;|&nbsp; <span style="color:#8888ff">■</span> same-depth &nbsp;<span style="color:#ff8888">■</span> corner-touch</span>
  <span class="global-prog">완료: <strong id="done-count">0</strong> / {total}</span>
</header>
<div class="container">
{map_html}
</div>
<div id="toast"></div>
<script>
{cc_id_js}
{json_data_js}

const CHUNK_COUNTS={chunk_counts_js};
const KEY='col_review_v2';
let state=JSON.parse(localStorage.getItem(KEY)||'{{}}');

function onCheck(el,mid){{
  const item=document.getElementById('item-'+mid);
  if(el.checked){{state[mid]=1;item.classList.add('done');}}
  else{{delete state[mid];item.classList.remove('done');}}
  localStorage.setItem(KEY,JSON.stringify(state));
  updateProgress();
}}
function updateProgress(){{
  let total=0,done=0;
  document.querySelectorAll('.week-section').forEach(sec=>{{
    const prog=sec.querySelector('.week-progress');
    const chunkId=prog.id.replace('prog-','');
    const items=sec.querySelectorAll('.map-item');
    let d=0;
    items.forEach(it=>{{const mid=it.id.replace('item-','');if(state[mid])d++;}});
    prog.textContent=d+'/'+items.length;
    total+=items.length;done+=d;
  }});
  document.getElementById('done-count').textContent=done;
}}
function toggleWeek(hdr){{
  hdr.classList.toggle('collapsed');
  hdr.nextElementSibling.classList.toggle('hidden');
}}
function copyId(mid){{
  navigator.clipboard.writeText(mid).then(()=>toast('Map ID 복사: '+mid));
}}
function copyCc(mid){{
  const cc=CC_ID_MAP[mid]||mid;
  navigator.clipboard.writeText(cc).then(()=>toast('CC ID 복사: '+cc));
}}
function copyJson(mid){{
  const txt=JSON_DATA[mid]||'';
  navigator.clipboard.writeText(txt).then(()=>{{
    toast('JSON 복사 완료 (수정 버전)');
    // 자동 체크
    const item=document.getElementById('item-'+mid);
    const cb=item&&item.querySelector('input[type=checkbox]');
    if(cb&&!cb.checked){{cb.checked=true;onCheck(cb,mid);}}
  }});
}}
function toast(msg){{
  const t=document.getElementById('toast');
  t.textContent=msg;t.classList.add('show');
  setTimeout(()=>t.classList.remove('show'),2000);
}}

// 초기화
window.addEventListener('DOMContentLoaded',()=>{{
  Object.keys(state).forEach(mid=>{{
    const item=document.getElementById('item-'+mid);
    if(item){{
      item.classList.add('done');
      const cb=item.querySelector('input[type=checkbox]');
      if(cb)cb.checked=true;
    }}
  }});
  updateProgress();
}});
</script>
</body>
</html>"""

    out_path = os.path.join(os.path.dirname(__file__), "schedule_collision_review.html")
    with open(out_path, 'w', encoding='utf-8') as f:
        f.write(html)
    print(f"\nHTML 저장: {out_path}")
    return total

if __name__ == '__main__':
    main()
