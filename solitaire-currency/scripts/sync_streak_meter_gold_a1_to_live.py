"""
09 sheet_sync 실행 — streak_meter_gold A1안 라이브 동기화 (④⑤ + 07 ⑦ 단계)

작업 순서:
  1. 07 ⑦: 에이전트 시트 G4:G14 하이라이트 제거 (사용자 ③ 확인 완료됨)
  2. ④: 에이전트 시트 → 라이브 시트 streak_meter_gold 11셀 동기화
  3. ⑤: 라이브 시트 G4:G14 연두색 하이라이트 적용

⚠️ 백업 컬럼(J·K·L)은 라이브로 복사하지 않음 (07 에이전트 내부 기록 보존)
⚠️ 동기화 범위는 streak_meter_gold 컬럼(G)만으로 한정
"""

import gspread
from google.oauth2.service_account import Credentials

CREDS = "pst-agent-187157cdb8b7.json"
SRC_ID = "1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk"  # 에이전트
DST_ID = "1oLbpsJjiDz0pdljaGBQznrSZcXA7aypFyJihnQ8_iiM"  # 라이브
SCOPES = ["https://www.googleapis.com/auth/spreadsheets"]

A1_VALUES = {
    220002: 60, 220003: 90, 220004: 105, 220005: 120, 220006: 130,
    220007: 150, 220008: 170, 220009: 200, 220010: 230, 220011: 270, 220012: 300,
}

SMG_COL = 7      # G
KEY_COL = 1      # A
DATA_START_ROW = 3

GREEN = {"red": 0.85, "green": 0.93, "blue": 0.83}
WHITE = {"red": 1.0, "green": 1.0, "blue": 1.0}


def get_ws(sh):
    return sh.worksheet("level_entry_tier")


def find_key_rows(ws):
    """key_number → row index (1-indexed) 매핑."""
    rows = ws.get_all_values()
    out = {}
    for i, row in enumerate(rows, start=1):
        if i < DATA_START_ROW or not row or not row[KEY_COL - 1].strip():
            continue
        try:
            out[int(row[KEY_COL - 1])] = i
        except ValueError:
            continue
    return rows, out


def main():
    gc = gspread.authorize(Credentials.from_service_account_file(CREDS, scopes=SCOPES))
    src_sh = gc.open_by_key(SRC_ID)
    dst_sh = gc.open_by_key(DST_ID)

    src_ws = get_ws(src_sh)
    dst_ws = get_ws(dst_sh)

    # ── 0. 라이브 시트 구조 검증 (SRC와 같은 layout 가정) ──
    src_rows, src_keymap = find_key_rows(src_ws)
    dst_rows, dst_keymap = find_key_rows(dst_ws)

    print(f"[INFO] SRC level_entry_tier: {len(src_rows)} rows, {len(src_keymap)} keys")
    print(f"[INFO] DST level_entry_tier: {len(dst_rows)} rows, {len(dst_keymap)} keys")

    missing_in_dst = [k for k in A1_VALUES if k not in dst_keymap]
    if missing_in_dst:
        raise SystemExit(f"[FATAL] 라이브 시트에 없는 key: {missing_in_dst}")

    # SRC와 DST의 row 매핑이 다를 수 있으므로 key별 row를 따로 사용
    # 행 layout 일치 확인 (220001~220012의 row 위치가 같은가)
    layout_match = all(src_keymap.get(k) == dst_keymap.get(k) for k in src_keymap)
    print(f"[INFO] SRC ↔ DST row layout 일치: {layout_match}")

    # SRC에서 적용된 streak_meter_gold 값 재확인 (실제 라이브로 복사할 값)
    src_smg_values = {}
    for k, r in src_keymap.items():
        if k in A1_VALUES:
            try:
                src_smg_values[k] = int(src_rows[r - 1][SMG_COL - 1])
            except ValueError:
                raise SystemExit(f"[FATAL] SRC row {r} key {k} streak_meter_gold 비정수")

    # SRC가 A1_VALUES와 일치해야 함 (07 단계 검증)
    mismatch = [(k, A1_VALUES[k], src_smg_values.get(k)) for k in A1_VALUES if src_smg_values.get(k) != A1_VALUES[k]]
    if mismatch:
        raise SystemExit(f"[FATAL] SRC streak_meter_gold가 A1과 불일치: {mismatch}")
    print(f"[OK] SRC 값 검증 통과 (A1 11개 일치)")

    # 현재 DST 값 (변경 전)
    dst_smg_before = {}
    for k, r in dst_keymap.items():
        if k in A1_VALUES:
            try:
                dst_smg_before[k] = int(dst_rows[r - 1][SMG_COL - 1])
            except ValueError:
                dst_smg_before[k] = None

    # ── 1. 07 ⑦: SRC 하이라이트 제거 (G4:G14 배경 흰색) ──
    src_ws_id = src_ws.id
    src_clear_requests = []
    for k in A1_VALUES:
        r = src_keymap[k]
        src_clear_requests.append({
            "repeatCell": {
                "range": {
                    "sheetId": src_ws_id,
                    "startRowIndex": r - 1, "endRowIndex": r,
                    "startColumnIndex": SMG_COL - 1, "endColumnIndex": SMG_COL,
                },
                "cell": {"userEnteredFormat": {"backgroundColor": WHITE}},
                "fields": "userEnteredFormat.backgroundColor",
            }
        })
    print("\n[STEP 07-⑦] 에이전트 시트 G4:G14 하이라이트 제거 중...")
    src_sh.batch_update({"requests": src_clear_requests})
    print("[OK] 에이전트 시트 하이라이트 제거 완료")

    # ── 2. ④: 라이브 시트 streak_meter_gold 동기화 + ⑤ 하이라이트 ──
    dst_ws_id = dst_ws.id
    dst_requests = []
    print("\n[STEP ④⑤] 라이브 시트 streak_meter_gold 11셀 동기화 + 연두색 하이라이트 적용 중...")
    for k, new_val in A1_VALUES.items():
        r = dst_keymap[k]
        before = dst_smg_before.get(k)
        print(f"  row={r:>2} key={k}: {before} → {new_val}")
        dst_requests.append({
            "updateCells": {
                "range": {
                    "sheetId": dst_ws_id,
                    "startRowIndex": r - 1, "endRowIndex": r,
                    "startColumnIndex": SMG_COL - 1, "endColumnIndex": SMG_COL,
                },
                "rows": [{"values": [
                    {"userEnteredValue": {"numberValue": new_val},
                     "userEnteredFormat": {"backgroundColor": GREEN}}
                ]}],
                "fields": "userEnteredValue,userEnteredFormat.backgroundColor",
            }
        })
    dst_sh.batch_update({"requests": dst_requests})
    print("[OK] 라이브 시트 11셀 동기화 + 하이라이트 완료")

    # 최종 검증
    dst_rows_after = dst_ws.get_all_values()
    for k, new_val in A1_VALUES.items():
        r = dst_keymap[k]
        actual = int(dst_rows_after[r - 1][SMG_COL - 1])
        if actual != new_val:
            raise SystemExit(f"[FATAL] DST 검증 실패: row {r} key {k} expected {new_val} got {actual}")
    print("[OK] 라이브 시트 최종 검증 통과 (11셀 모두 A1 값으로 저장됨)")

    print("\n" + "=" * 70)
    print("✅ 07 ⑦ + 09 ④⑤ 완료")
    print("=" * 70)
    print("\n라이브 시트 링크:")
    print(f"  https://docs.google.com/spreadsheets/d/{DST_ID}/edit#gid={dst_ws_id}")
    print("\n다음 단계:")
    print("  ⑥ 사용자가 라이브 시트 검토 후 '확인 완료' 응답")
    print("  → ⑦ 라이브 시트 하이라이트 제거")
    print("  → ⑧ workspace/balance_sheet/level_entry_tier.json 동기화")


if __name__ == "__main__":
    main()
