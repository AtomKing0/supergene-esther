"""
09 sheet_sync ⑦ + ⑧ 마무리 — 라이브 하이라이트 제거 + JSON 동기화

작업:
  1. ⑦ 라이브 시트 G4:G14 배경색 흰색 초기화
  2. ⑧ workspace/balance_sheet/level_entry_tier.json 의 streak_meter_gold 값 갱신
"""

import gspread
import json
from pathlib import Path
from google.oauth2.service_account import Credentials

CREDS = "pst-agent-187157cdb8b7.json"
DST_ID = "1oLbpsJjiDz0pdljaGBQznrSZcXA7aypFyJihnQ8_iiM"
SCOPES = ["https://www.googleapis.com/auth/spreadsheets"]

JSON_PATH = Path("/Users/estherpark/esther_solitaire/solitaire-esther-1/workspace/balance_sheet/level_entry_tier.json")

A1_VALUES = {
    220002: 60, 220003: 90, 220004: 105, 220005: 120, 220006: 130,
    220007: 150, 220008: 170, 220009: 200, 220010: 230, 220011: 270, 220012: 300,
}

SMG_COL = 7
KEY_COL = 1
DATA_START_ROW = 3
WHITE = {"red": 1.0, "green": 1.0, "blue": 1.0}


def main():
    # ── ⑦ 라이브 하이라이트 제거 ──
    gc = gspread.authorize(Credentials.from_service_account_file(CREDS, scopes=SCOPES))
    dst_sh = gc.open_by_key(DST_ID)
    dst_ws = dst_sh.worksheet("level_entry_tier")
    dst_ws_id = dst_ws.id

    rows = dst_ws.get_all_values()
    keymap = {}
    for i, row in enumerate(rows, start=1):
        if i < DATA_START_ROW or not row or not row[KEY_COL - 1].strip():
            continue
        try:
            keymap[int(row[KEY_COL - 1])] = i
        except ValueError:
            continue

    clear_requests = []
    for k in A1_VALUES:
        r = keymap[k]
        clear_requests.append({
            "repeatCell": {
                "range": {
                    "sheetId": dst_ws_id,
                    "startRowIndex": r - 1, "endRowIndex": r,
                    "startColumnIndex": SMG_COL - 1, "endColumnIndex": SMG_COL,
                },
                "cell": {"userEnteredFormat": {"backgroundColor": WHITE}},
                "fields": "userEnteredFormat.backgroundColor",
            }
        })
    print("[STEP ⑦] 라이브 시트 G4:G14 하이라이트 제거 중...")
    dst_sh.batch_update({"requests": clear_requests})
    print("[OK] 라이브 하이라이트 제거 완료")

    # ── ⑧ JSON 동기화 ──
    print(f"\n[STEP ⑧] {JSON_PATH} 갱신 중...")
    data = json.loads(JSON_PATH.read_text())
    changed = []
    for entry in data:
        k = entry["key_number"]
        if k in A1_VALUES:
            old = entry["streak_meter_gold"]
            entry["streak_meter_gold"] = A1_VALUES[k]
            changed.append((k, old, A1_VALUES[k]))

    # 한 줄 형식 유지 (기존 파일 형식과 동일)
    JSON_PATH.write_text(json.dumps(data, ensure_ascii=False, separators=(",", ":")))
    print(f"[OK] JSON 갱신 완료 — {len(changed)}개 entry 변경")
    for k, old, new in changed:
        print(f"  key {k}: {old} → {new}")

    # 검증: 재읽기
    data_after = json.loads(JSON_PATH.read_text())
    for entry in data_after:
        k = entry["key_number"]
        if k in A1_VALUES and entry["streak_meter_gold"] != A1_VALUES[k]:
            raise SystemExit(f"[FATAL] JSON 검증 실패: key {k}")
    print("[OK] JSON 검증 통과")

    print("\n" + "=" * 70)
    print("✅ 09 ⑦ + ⑧ 마무리 완료")
    print("=" * 70)


if __name__ == "__main__":
    main()
