#!/usr/bin/env python3
"""
balance_sheet_diff.py
라이브 밸런스 시트를 매일 스냅샷으로 저장하고, 전날과 비교하여 변경 리스트를 생성합니다.

Usage:
    python3 balance_sheet_diff.py [--date YYYY-MM-DD] [--force-snapshot]

    --date        : 비교 기준 날짜 (기본: 오늘)
    --force-snapshot : 오늘 스냅샷이 이미 있어도 강제 재취득
"""

import argparse
import json
import os
import sys
from datetime import datetime, timedelta
from pathlib import Path

try:
    import gspread
    from google.oauth2.service_account import Credentials
except ImportError:
    print("[ERROR] gspread / google-auth 미설치. 아래 명령 실행:\n  pip install gspread google-auth --break-system-packages")
    sys.exit(1)

# ─────────────────────────────────────────────
# 설정
# ─────────────────────────────────────────────
SCRIPT_DIR    = Path(__file__).parent.resolve()
BASE_DIR      = SCRIPT_DIR.parent  # solitaire-currency/
CRED_FILE     = BASE_DIR / "pst-agent-187157cdb8b7.json"
LIVE_SHEET_ID = "1oLbpsJjiDz0pdljaGBQznrSZcXA7aypFyJihnQ8_iiM"

SNAPSHOT_DIR  = BASE_DIR / "snapshots"
REPORT_DIR    = BASE_DIR / "reports"
SNAPSHOT_DIR.mkdir(exist_ok=True)
REPORT_DIR.mkdir(exist_ok=True)

# ─────────────────────────────────────────────
# Google Sheet 연결
# ─────────────────────────────────────────────
def connect_sheet():
    creds = Credentials.from_service_account_file(
        str(CRED_FILE),
        scopes=[
            "https://www.googleapis.com/auth/spreadsheets.readonly",
            "https://www.googleapis.com/auth/drive.readonly",
        ]
    )
    gc = gspread.authorize(creds)
    return gc.open_by_key(LIVE_SHEET_ID)


# ─────────────────────────────────────────────
# 스냅샷 취득
# ─────────────────────────────────────────────
def take_snapshot(date_str: str) -> dict:
    """모든 탭의 데이터를 dict 형태로 취득"""
    print(f"[INFO] 라이브 시트 스냅샷 취득 중... ({date_str})")
    sh = connect_sheet()
    snapshot = {"date": date_str, "sheets": {}}

    for ws in sh.worksheets():
        title = ws.title
        try:
            rows = ws.get_all_values()
            snapshot["sheets"][title] = rows
            print(f"  ✓ {title}: {len(rows)}행")
        except Exception as e:
            print(f"  ✗ {title}: 읽기 실패 ({e})")
            snapshot["sheets"][title] = []

    return snapshot


def save_snapshot(snapshot: dict, date_str: str):
    path = SNAPSHOT_DIR / f"{date_str}.json"
    with open(path, "w", encoding="utf-8") as f:
        json.dump(snapshot, f, ensure_ascii=False, indent=2)
    print(f"[INFO] 스냅샷 저장: {path}")
    return path


def load_snapshot(date_str: str) -> dict | None:
    path = SNAPSHOT_DIR / f"{date_str}.json"
    if not path.exists():
        return None
    with open(path, "r", encoding="utf-8") as f:
        return json.load(f)


# ─────────────────────────────────────────────
# Diff 계산
# ─────────────────────────────────────────────
def rows_to_dict(rows: list[list]) -> dict:
    """첫 행을 헤더로, 첫 컬럼 값을 key로 변환"""
    if not rows or len(rows) < 2:
        return {}
    headers = rows[0]
    result = {}
    for row in rows[1:]:
        # 빈 행 스킵
        if not any(c.strip() for c in row):
            continue
        # 첫 열을 key로 (빈 경우 임시 키)
        key = row[0].strip() if row else "__empty__"
        padded = row + [""] * (len(headers) - len(row))
        result[key] = dict(zip(headers, padded))
    return result


def diff_sheet(sheet_name: str, old_rows: list, new_rows: list) -> dict:
    """단일 시트 diff 결과 반환"""
    old = rows_to_dict(old_rows)
    new = rows_to_dict(new_rows)

    old_keys = set(old.keys())
    new_keys = set(new.keys())

    added   = sorted(new_keys - old_keys)
    deleted = sorted(old_keys - new_keys)
    modified = []

    for key in sorted(old_keys & new_keys):
        old_row = old[key]
        new_row = new[key]
        changes = []
        all_cols = set(old_row) | set(new_row)
        for col in sorted(all_cols):
            ov = old_row.get(col, "")
            nv = new_row.get(col, "")
            if ov != nv:
                changes.append({"column": col, "before": ov, "after": nv})
        if changes:
            modified.append({"key": key, "changes": changes})

    return {
        "sheet": sheet_name,
        "added": added,
        "deleted": deleted,
        "modified": modified,
        "added_rows": {k: new[k] for k in added},
        "deleted_rows": {k: old[k] for k in deleted},
    }


def compute_diff(old_snap: dict, new_snap: dict) -> list[dict]:
    """전체 시트 diff 결과 리스트"""
    results = []
    old_sheets = old_snap.get("sheets", {})
    new_sheets = new_snap.get("sheets", {})

    all_sheet_names = sorted(set(old_sheets) | set(new_sheets))

    for name in all_sheet_names:
        old_rows = old_sheets.get(name, [])
        new_rows = new_sheets.get(name, [])

        if old_rows == new_rows:
            continue  # 변경 없음

        diff = diff_sheet(name, old_rows, new_rows)

        # 탭 자체 추가/삭제 표시
        if name not in old_sheets:
            diff["tab_status"] = "added"
        elif name not in new_sheets:
            diff["tab_status"] = "deleted"
        else:
            diff["tab_status"] = "modified"

        if diff["added"] or diff["deleted"] or diff["modified"] or diff.get("tab_status") in ("added", "deleted"):
            results.append(diff)

    return results


# ─────────────────────────────────────────────
# 리포트 생성
# ─────────────────────────────────────────────
def generate_md(old_date: str, new_date: str, diffs: list[dict]) -> str:
    lines = [
        f"# 밸런스 시트 변경 리스트",
        f"",
        f"- **비교 기간:** {old_date} → {new_date}",
        f"- **변경된 탭 수:** {len(diffs)}",
        f"- **생성 시각:** {datetime.now().strftime('%Y-%m-%d %H:%M:%S')}",
        f"",
    ]

    if not diffs:
        lines.append("## ✅ 변경 없음")
        lines.append("")
        lines.append(f"{old_date} 대비 변경 사항이 없습니다.")
        return "\n".join(lines)

    for d in diffs:
        tab_label = {
            "added": "🆕 신규 탭",
            "deleted": "🗑️ 삭제된 탭",
            "modified": "✏️ 변경됨",
        }.get(d.get("tab_status", "modified"), "✏️ 변경됨")

        lines.append(f"## [{tab_label}] `{d['sheet']}`")
        lines.append("")

        if d.get("tab_status") == "added":
            lines.append(f"- 신규 탭 추가 ({len(d.get('added', []))}행)")
        elif d.get("tab_status") == "deleted":
            lines.append(f"- 탭 삭제됨")
        else:
            total = len(d["added"]) + len(d["deleted"]) + len(d["modified"])
            lines.append(f"- 총 변경: {total}건  (추가 {len(d['added'])}, 삭제 {len(d['deleted'])}, 수정 {len(d['modified'])})")
            lines.append("")

            if d["added"]:
                lines.append("### 추가된 행")
                for key in d["added"]:
                    row = d.get("added_rows", {}).get(key, {})
                    lines.append(f"- **{key}**: {json.dumps(row, ensure_ascii=False)}")

            if d["deleted"]:
                lines.append("")
                lines.append("### 삭제된 행")
                for key in d["deleted"]:
                    row = d.get("deleted_rows", {}).get(key, {})
                    lines.append(f"- **{key}**: {json.dumps(row, ensure_ascii=False)}")

            if d["modified"]:
                lines.append("")
                lines.append("### 수정된 값")
                lines.append("")
                lines.append("| key | 컬럼 | 이전 값 | 변경 값 |")
                lines.append("|-----|------|---------|---------|")
                for m in d["modified"]:
                    for ch in m["changes"]:
                        key = m['key'].replace('|', '\\|')
                        col = ch['column'].replace('|', '\\|')
                        bef = str(ch['before']).replace('|', '\\|')
                        aft = str(ch['after']).replace('|', '\\|')
                        lines.append(f"| {key} | {col} | {bef} | {aft} |")

        lines.append("")

    return "\n".join(lines)


def generate_html(old_date: str, new_date: str, diffs: list[dict]) -> str:
    md_content = generate_md(old_date, new_date, diffs)

    # 간단한 summary
    total_added = sum(len(d["added"]) for d in diffs)
    total_deleted = sum(len(d["deleted"]) for d in diffs)
    total_modified = sum(len(d["modified"]) for d in diffs)
    total_tabs = len(diffs)

    rows_html = ""
    for d in diffs:
        tab_badge = {
            "added": '<span class="badge badge-green">신규</span>',
            "deleted": '<span class="badge badge-red">삭제</span>',
            "modified": '<span class="badge badge-blue">변경</span>',
        }.get(d.get("tab_status", "modified"), '<span class="badge badge-blue">변경</span>')

        detail_html = ""

        if d["added"]:
            detail_html += f'<div class="section-label">추가된 행 ({len(d["added"])})</div>'
            detail_html += '<table class="inner-table"><tr><th>key</th><th>데이터</th></tr>'
            for key in d["added"]:
                row = d.get("added_rows", {}).get(key, {})
                detail_html += f'<tr class="row-added"><td>{_esc(key)}</td><td>{_esc(json.dumps(row, ensure_ascii=False))}</td></tr>'
            detail_html += "</table>"

        if d["deleted"]:
            detail_html += f'<div class="section-label">삭제된 행 ({len(d["deleted"])})</div>'
            detail_html += '<table class="inner-table"><tr><th>key</th><th>데이터</th></tr>'
            for key in d["deleted"]:
                row = d.get("deleted_rows", {}).get(key, {})
                detail_html += f'<tr class="row-deleted"><td>{_esc(key)}</td><td>{_esc(json.dumps(row, ensure_ascii=False))}</td></tr>'
            detail_html += "</table>"

        if d["modified"]:
            detail_html += f'<div class="section-label">수정된 값 ({len(d["modified"])}건)</div>'
            detail_html += '<table class="inner-table"><tr><th>key</th><th>컬럼</th><th>이전</th><th>변경 후</th></tr>'
            for m in d["modified"]:
                for ch in m["changes"]:
                    detail_html += (
                        f'<tr class="row-modified">'
                        f'<td>{_esc(m["key"])}</td>'
                        f'<td>{_esc(ch["column"])}</td>'
                        f'<td class="val-before">{_esc(str(ch["before"]))}</td>'
                        f'<td class="val-after">{_esc(str(ch["after"]))}</td>'
                        f'</tr>'
                    )
            detail_html += "</table>"

        rows_html += f"""
        <div class="sheet-card">
            <div class="sheet-header">
                {tab_badge}
                <span class="sheet-name">{_esc(d["sheet"])}</span>
                <span class="sheet-summary">+{len(d["added"])} / -{len(d["deleted"])} / ~{len(d["modified"])}</span>
            </div>
            <div class="sheet-detail">{detail_html}</div>
        </div>"""

    no_change_html = '<div class="no-change">✅ 변경 사항이 없습니다.</div>' if not diffs else ""

    # MD 다운로드용 base64
    import base64
    md_b64 = base64.b64encode(md_content.encode("utf-8")).decode("ascii")
    md_filename = f"balance_diff_{new_date}.md"

    html = f"""<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>밸런스 시트 변경 리스트 {new_date}</title>
<style>
  :root {{
    --bg: #0f1117; --surface: #1c1e26; --surface2: #252830;
    --border: #2e3140; --text: #e2e4ef; --muted: #8b8fa8;
    --green: #4ade80; --red: #f87171; --blue: #60a5fa; --yellow: #fbbf24;
    --green-bg: #052e16; --red-bg: #2d0a0a; --blue-bg: #0c1a2e; --yellow-bg: #1a1000;
  }}
  * {{ box-sizing: border-box; margin: 0; padding: 0; }}
  body {{ background: var(--bg); color: var(--text); font-family: 'Segoe UI', system-ui, sans-serif; font-size: 14px; }}
  .container {{ max-width: 1100px; margin: 0 auto; padding: 32px 20px; }}
  h1 {{ font-size: 22px; font-weight: 700; margin-bottom: 4px; }}
  .subtitle {{ color: var(--muted); font-size: 13px; margin-bottom: 24px; }}
  .stat-row {{ display: flex; gap: 12px; margin-bottom: 28px; flex-wrap: wrap; }}
  .stat-card {{ background: var(--surface); border: 1px solid var(--border); border-radius: 10px; padding: 14px 20px; min-width: 120px; }}
  .stat-card .val {{ font-size: 26px; font-weight: 700; }}
  .stat-card .lbl {{ font-size: 11px; color: var(--muted); margin-top: 2px; }}
  .stat-card.green .val {{ color: var(--green); }}
  .stat-card.red .val {{ color: var(--red); }}
  .stat-card.blue .val {{ color: var(--blue); }}
  .stat-card.yellow .val {{ color: var(--yellow); }}
  .btn-dl {{ display: inline-flex; align-items: center; gap: 6px; background: var(--surface2);
    border: 1px solid var(--border); border-radius: 8px; padding: 8px 16px;
    color: var(--text); text-decoration: none; font-size: 13px; cursor: pointer; margin-bottom: 24px; }}
  .btn-dl:hover {{ border-color: var(--blue); color: var(--blue); }}
  .sheet-card {{ background: var(--surface); border: 1px solid var(--border); border-radius: 10px; margin-bottom: 16px; overflow: hidden; }}
  .sheet-header {{ display: flex; align-items: center; gap: 10px; padding: 14px 18px; background: var(--surface2); }}
  .sheet-name {{ font-weight: 600; font-size: 15px; flex: 1; }}
  .sheet-summary {{ font-size: 12px; color: var(--muted); }}
  .sheet-detail {{ padding: 16px 18px; }}
  .badge {{ font-size: 11px; font-weight: 700; padding: 2px 8px; border-radius: 99px; }}
  .badge-green {{ background: var(--green-bg); color: var(--green); }}
  .badge-red {{ background: var(--red-bg); color: var(--red); }}
  .badge-blue {{ background: var(--blue-bg); color: var(--blue); }}
  .section-label {{ font-size: 12px; font-weight: 600; color: var(--muted); margin: 12px 0 6px; text-transform: uppercase; letter-spacing: .05em; }}
  .inner-table {{ width: 100%; border-collapse: collapse; font-size: 12px; margin-bottom: 4px; }}
  .inner-table th {{ background: var(--surface2); color: var(--muted); padding: 6px 10px; text-align: left; font-weight: 600; border-bottom: 1px solid var(--border); }}
  .inner-table td {{ padding: 5px 10px; border-bottom: 1px solid var(--border); word-break: break-all; }}
  .row-added td {{ background: var(--green-bg); }}
  .row-deleted td {{ background: var(--red-bg); text-decoration: line-through; color: var(--muted); }}
  .row-modified td {{ }}
  .val-before {{ color: var(--red); }}
  .val-after {{ color: var(--green); font-weight: 600; }}
  .no-change {{ text-align: center; padding: 48px; color: var(--muted); font-size: 16px; }}
</style>
</head>
<body>
<div class="container">
  <h1>📊 밸런스 시트 변경 리스트</h1>
  <div class="subtitle">{old_date} → {new_date} &nbsp;·&nbsp; 생성: {datetime.now().strftime('%Y-%m-%d %H:%M:%S')}</div>

  <div class="stat-row">
    <div class="stat-card yellow"><div class="val">{total_tabs}</div><div class="lbl">변경된 탭</div></div>
    <div class="stat-card green"><div class="val">{total_added}</div><div class="lbl">추가된 행</div></div>
    <div class="stat-card red"><div class="val">{total_deleted}</div><div class="lbl">삭제된 행</div></div>
    <div class="stat-card blue"><div class="val">{total_modified}</div><div class="lbl">수정된 셀 그룹</div></div>
  </div>

  <a class="btn-dl" href="data:text/markdown;charset=utf-8;base64,{md_b64}" download="{md_filename}">
    ⬇ MD 리포트 다운로드
  </a>

  {rows_html}
  {no_change_html}
</div>
</body>
</html>"""
    return html


def _esc(text: str) -> str:
    return (text
            .replace("&", "&amp;")
            .replace("<", "&lt;")
            .replace(">", "&gt;")
            .replace('"', "&quot;"))


# ─────────────────────────────────────────────
# 메인
# ─────────────────────────────────────────────
def main():
    parser = argparse.ArgumentParser(description="밸런스 시트 일일 변경 감지")
    parser.add_argument("--date", default=datetime.today().strftime("%Y-%m-%d"), help="기준 날짜 (YYYY-MM-DD)")
    parser.add_argument("--force-snapshot", action="store_true", help="오늘 스냅샷 강제 재취득")
    args = parser.parse_args()

    today_str = args.date
    yesterday_str = (datetime.strptime(today_str, "%Y-%m-%d") - timedelta(days=1)).strftime("%Y-%m-%d")

    print(f"[INFO] 비교: {yesterday_str} → {today_str}")

    # 1. 오늘 스냅샷 취득 (없거나 강제 재취득)
    today_snap_path = SNAPSHOT_DIR / f"{today_str}.json"
    if not today_snap_path.exists() or args.force_snapshot:
        today_snap = take_snapshot(today_str)
        save_snapshot(today_snap, today_str)
    else:
        print(f"[INFO] 오늘 스냅샷 이미 존재: {today_snap_path}")
        today_snap = load_snapshot(today_str)

    # 2. 어제 스냅샷 로드
    yesterday_snap = load_snapshot(yesterday_str)
    if yesterday_snap is None:
        print(f"[WARN] 어제({yesterday_str}) 스냅샷 없음 — 최초 실행이거나 스냅샷이 누락됨")
        print(f"[INFO] 오늘 스냅샷만 저장하고 종료합니다. 내일부터 diff가 생성됩니다.")
        # 빈 diff로 리포트 생성
        diffs = []
    else:
        # 3. Diff 계산
        diffs = compute_diff(yesterday_snap, today_snap)
        print(f"[INFO] 변경된 탭: {len(diffs)}개")

    # 4. 리포트 생성
    md_content   = generate_md(yesterday_str, today_str, diffs)
    html_content = generate_html(yesterday_str, today_str, diffs)

    md_path   = REPORT_DIR / f"balance_diff_{today_str}.md"
    html_path = REPORT_DIR / f"balance_diff_{today_str}.html"

    with open(md_path, "w", encoding="utf-8") as f:
        f.write(md_content)
    with open(html_path, "w", encoding="utf-8") as f:
        f.write(html_content)

    print(f"[DONE] MD  리포트: {md_path}")
    print(f"[DONE] HTML 리포트: {html_path}")

    if diffs:
        total_changes = sum(len(d["added"]) + len(d["deleted"]) + len(d["modified"]) for d in diffs)
        print(f"[DONE] 총 변경 사항: {total_changes}건 (탭 {len(diffs)}개)")
    else:
        print("[DONE] 변경 사항 없음")


if __name__ == "__main__":
    main()
