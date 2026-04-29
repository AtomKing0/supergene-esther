"""
07 sheet_modifier 실행 — streak_meter_gold A1안 적용 (① 단계)

대상 시트: 에이전트 시트 / level_entry_tier
변경 컬럼: streak_meter_gold (col G, 7)
변경 행: row 4~14 (key_number 220002~220012, 11행)

작업 순서 (CLAUDE.md / 07 agent 프로토콜):
  1. 원본 백업 → col J·K·L (Parameter│Original│Updated). col H 끝 → col I 빈 → J 시작
  2. streak_meter_gold 셀에 A1 값 적용 (numberValue, int)
  3. 수정된 11셀에 연두색 하이라이트 (수치 증가)

⚠️ 라이브 시트 (1oLbpsJjiDz0pdljaGBQznrSZcXA7aypFyJihnQ8_iiM)는 건드리지 않는다.
"""

import gspread
from google.oauth2.service_account import Credentials

CREDS = "pst-agent-187157cdb8b7.json"
AGENT_SHEET_ID = "1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk"
SCOPES = ["https://www.googleapis.com/auth/spreadsheets"]

# A1안 신규 값 (key_number → new streak_meter_gold)
A1_VALUES = {
    220002: 60,    # Lv 3-9
    220003: 90,    # Lv 10-24
    220004: 105,   # Lv 25-49
    220005: 120,   # Lv 50-99
    220006: 130,   # Lv 100-199
    220007: 150,   # Lv 200-349
    220008: 170,   # Lv 350-549
    220009: 200,   # Lv 550-799
    220010: 230,   # Lv 800-1099
    220011: 270,   # Lv 1100-1449
    220012: 300,   # Lv 1450+
}

# 시트 좌표 (1-indexed). probe로 확인.
SMG_COL = 7      # G
KEY_COL = 1      # A
LMIN_COL = 2     # B
LMAX_COL = 3     # C
DATA_START_ROW = 3   # row 3 = 220001 (변경 없음), row 4~14 = 220002~220012
BACKUP_PARAM_COL = 10   # J (col H가 마지막 사용 → I 비우고 J부터)
BACKUP_ORIG_COL = 11    # K
BACKUP_UPD_COL = 12     # L
BACKUP_HEADER_ROW = 2   # 데이터 헤더 위치와 동일 행에 라벨

GREEN = {"red": 0.85, "green": 0.93, "blue": 0.83}


def main():
    gc = gspread.authorize(Credentials.from_service_account_file(CREDS, scopes=SCOPES))
    sh = gc.open_by_key(AGENT_SHEET_ID)
    ws = sh.worksheet("level_entry_tier")
    ws_id = ws.id

    # 현재 값 읽기 (검증용)
    rows = ws.get_all_values()
    print(f"[INFO] 시트 행 수: {len(rows)}")

    # key_number → row index 매핑 (1-indexed)
    key_to_row = {}
    for i, row in enumerate(rows, start=1):
        if i < DATA_START_ROW:
            continue
        if not row or not row[KEY_COL - 1].strip():
            continue
        try:
            k = int(row[KEY_COL - 1])
        except ValueError:
            continue
        key_to_row[k] = i

    # 변경 대상 모두 시트에 있는지 확인
    missing = [k for k in A1_VALUES if k not in key_to_row]
    if missing:
        raise SystemExit(f"[FATAL] 변경 대상 key가 시트에 없음: {missing}")

    # 원본 값 수집 (백업용)
    backup = []   # [(key, level_min, level_max, original_smg, new_smg)]
    for key, new_val in A1_VALUES.items():
        r = key_to_row[key]
        row = rows[r - 1]
        orig = int(row[SMG_COL - 1])
        lmin = row[LMIN_COL - 1]
        lmax = row[LMAX_COL - 1]
        backup.append((key, lmin, lmax, orig, new_val))
        print(f"[PLAN] row={r:>2} key={key} (Lv {lmin}-{lmax}): {orig} → {new_val}")

    # ── ① 백업 영역 작성 (J·K·L) ──
    backup_requests = []

    # 헤더 (row 2): Parameter / Original / Updated
    backup_requests.append({
        "updateCells": {
            "range": {
                "sheetId": ws_id,
                "startRowIndex": BACKUP_HEADER_ROW - 1,
                "endRowIndex": BACKUP_HEADER_ROW,
                "startColumnIndex": BACKUP_PARAM_COL - 1,
                "endColumnIndex": BACKUP_UPD_COL,
            },
            "rows": [{"values": [
                {"userEnteredValue": {"stringValue": "Parameter"},
                 "userEnteredFormat": {"textFormat": {"bold": True}}},
                {"userEnteredValue": {"stringValue": "Original"},
                 "userEnteredFormat": {"textFormat": {"bold": True}}},
                {"userEnteredValue": {"stringValue": "Updated"},
                 "userEnteredFormat": {"textFormat": {"bold": True}}},
            ]}],
            "fields": "userEnteredValue,userEnteredFormat.textFormat.bold",
        }
    })

    # 데이터 행 (row 3부터 11개)
    for i, (key, lmin, lmax, orig, new_val) in enumerate(backup):
        r = BACKUP_HEADER_ROW + 1 + i  # row 3, 4, 5, ...
        param_label = f"streak_meter_gold (Lv {lmin}-{lmax}, key {key})"
        backup_requests.append({
            "updateCells": {
                "range": {
                    "sheetId": ws_id,
                    "startRowIndex": r - 1,
                    "endRowIndex": r,
                    "startColumnIndex": BACKUP_PARAM_COL - 1,
                    "endColumnIndex": BACKUP_UPD_COL,
                },
                "rows": [{"values": [
                    {"userEnteredValue": {"stringValue": param_label}},
                    {"userEnteredValue": {"numberValue": orig}},
                    {"userEnteredValue": {"numberValue": new_val}},
                ]}],
                "fields": "userEnteredValue",
            }
        })

    print(f"\n[STEP 1] 백업 영역 {len(backup_requests)}개 셀 그룹 작성 중 (J:L, 헤더 row {BACKUP_HEADER_ROW} + 데이터 11행)...")
    sh.batch_update({"requests": backup_requests})
    print(f"[OK] 백업 완료 (J{BACKUP_HEADER_ROW}:L{BACKUP_HEADER_ROW + len(backup)})")

    # 백업 검증 (재읽기)
    rows_after = ws.get_all_values()
    for i, (key, lmin, lmax, orig, new_val) in enumerate(backup):
        r = BACKUP_HEADER_ROW + 1 + i
        row_after = rows_after[r - 1]
        if int(row_after[BACKUP_ORIG_COL - 1]) != orig:
            raise SystemExit(f"[FATAL] 백업 검증 실패: row {r} Original 미저장")
    print("[OK] 백업 검증 통과 (Original 11셀 모두 numberValue 저장됨)")

    # ── ② streak_meter_gold 값 수정 + ③ 연두색 하이라이트 ──
    update_requests = []
    for key, new_val in A1_VALUES.items():
        r = key_to_row[key]
        update_requests.append({
            "updateCells": {
                "range": {
                    "sheetId": ws_id,
                    "startRowIndex": r - 1,
                    "endRowIndex": r,
                    "startColumnIndex": SMG_COL - 1,
                    "endColumnIndex": SMG_COL,
                },
                "rows": [{"values": [
                    {"userEnteredValue": {"numberValue": new_val},
                     "userEnteredFormat": {"backgroundColor": GREEN}}
                ]}],
                "fields": "userEnteredValue,userEnteredFormat.backgroundColor",
            }
        })

    print(f"\n[STEP 2+3] streak_meter_gold 11셀 값 변경 + 연두색 하이라이트 적용 중...")
    sh.batch_update({"requests": update_requests})
    print(f"[OK] 11셀 수정 완료 (G4:G14, numberValue + 연두색)")

    # 최종 검증
    rows_final = ws.get_all_values()
    for key, new_val in A1_VALUES.items():
        r = key_to_row[key]
        actual = int(rows_final[r - 1][SMG_COL - 1])
        if actual != new_val:
            raise SystemExit(f"[FATAL] 값 검증 실패: row {r} key {key} expected {new_val} got {actual}")
    print("[OK] 최종 검증 통과 (11셀 모두 A1 값으로 저장됨, numberValue 정수형)")

    print("\n" + "=" * 70)
    print("✅ ① 에이전트 시트 수정 완료")
    print("=" * 70)
    print("\n시트 링크:")
    print(f"  https://docs.google.com/spreadsheets/d/{AGENT_SHEET_ID}/edit#gid={ws_id}")
    print("\n다음 단계:")
    print("  ③ 사용자가 시트 검토 후 '확인 완료' 응답")
    print("  → 그 다음 ④ 09_sheet_sync 에이전트로 라이브 시트 동기화 진행")


if __name__ == "__main__":
    main()
