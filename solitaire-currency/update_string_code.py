#!/usr/bin/env python3
"""
07_sheet_modifier protocol: Update T_PRE_LEVEL_LEADERBOARD in string_code tab.
- Text/structure change => sky blue highlight {"red": 0.68, "green": 0.85, "blue": 0.90}
- Backup original values before updating
"""

import json
from google.oauth2.service_account import Credentials
from googleapiclient.discovery import build

CREDENTIALS_FILE = "/Users/estherpark/esther_solitaire/solitaire-esther-1/solitaire-currency/pst-agent-187157cdb8b7.json"
SHEET_ID = "1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk"
TAB_NAME = "string_code"
TARGET_KEY = "T_PRE_LEVEL_LEADERBOARD"
SKY_BLUE = {"red": 0.68, "green": 0.85, "blue": 0.90}

NEW_VALUES = {
    "en": "No friends on this level yet!",
    "kr": "아직 이 레벨에 친구가 없어요!",
    "ar": "لا أصدقاء في هذا المستوى بعد!",
    "es": "¡Aún no hay amigos en este nivel!",
    "fr": "Pas encore d'amis sur ce niveau !",
    "id": "Belum ada teman di level ini!",
    "pt": "Nenhum amigo neste nível ainda!",
    "ru": "Друзей на этом уровне пока нет!",
    "th": "ยังไม่มีเพื่อนในด่านนี้!",
}

SCOPES = ["https://www.googleapis.com/auth/spreadsheets"]

def col_letter(idx):
    """Convert 0-based column index to A1 letter."""
    result = ""
    idx += 1
    while idx > 0:
        idx, rem = divmod(idx - 1, 26)
        result = chr(65 + rem) + result
    return result

def main():
    creds = Credentials.from_service_account_file(CREDENTIALS_FILE, scopes=SCOPES)
    service = build("sheets", "v4", credentials=creds)
    sheets = service.spreadsheets()

    # 1. Read entire sheet to find header row and target row
    result = sheets.values().get(
        spreadsheetId=SHEET_ID,
        range=f"{TAB_NAME}",
    ).execute()
    all_rows = result.get("values", [])

    if not all_rows:
        raise ValueError("Sheet is empty!")

    # Find header row (row with language codes)
    # Look for a row that contains 'en', 'kr', etc.
    header_row_idx = None
    headers = []
    for i, row in enumerate(all_rows):
        if "en" in row and "kr" in row:
            header_row_idx = i
            headers = row
            break

    if header_row_idx is None:
        raise ValueError("Could not find header row with language columns!")

    print(f"Header row found at sheet row {header_row_idx + 1}: {headers[:15]}...")

    # Find target key row
    target_row_idx = None
    for i, row in enumerate(all_rows):
        if row and row[0] == TARGET_KEY:
            target_row_idx = i
            break

    if target_row_idx is None:
        raise ValueError(f"Key '{TARGET_KEY}' not found in column A!")

    print(f"Target key '{TARGET_KEY}' found at sheet row {target_row_idx + 1}")

    # Map language -> column index
    lang_col_map = {}
    for lang in NEW_VALUES:
        if lang in headers:
            lang_col_map[lang] = headers.index(lang)
        else:
            print(f"WARNING: language '{lang}' not found in headers, skipping.")

    print(f"Language column mapping: { {k: col_letter(v) for k, v in lang_col_map.items()} }")

    # 2. Read original values for backup
    target_row = all_rows[target_row_idx] if target_row_idx < len(all_rows) else []
    original_values = {}
    for lang, col_idx in lang_col_map.items():
        orig = target_row[col_idx] if col_idx < len(target_row) else ""
        original_values[lang] = orig

    print(f"\nOriginal values:")
    for lang, val in original_values.items():
        print(f"  {lang}: {repr(val)}")

    # 3. Find backup area: find rightmost used column, then skip 1 blank column
    max_col = max(len(r) for r in all_rows if r)
    backup_start_col = max_col + 1  # 0-based; +1 gap means skip 1 blank col

    print(f"\nBackup area starts at column {col_letter(backup_start_col)} (0-based idx {backup_start_col})")

    # Build backup headers in the header row and backup values in the target row
    # Layout: [Key, Lang, Original, Updated] repeated per language
    # Simpler: one block per language side by side: key | lang | original | updated
    # Actually: write a single block with header labels and values
    # Format: backup_col+0 = "Key", +1 = "Lang", +2 = "Original", +3 = "Updated"
    # Then for each language: a row in the header area identifying what's there,
    # and the target row gets the values.
    # Since we can only write at one row per batch, let's do a compact format:
    # In header row: "BACKUP_KEY" | lang1 | lang2 | ...
    # In target row: TARGET_KEY  | orig1 | orig2 | ...  (Parameter block)
    # Then another set for Updated values.

    # Simpler layout matching common protocol:
    # backup_start_col: "Parameter" header, then lang columns
    # Row header_row_idx: ["Parameter", lang1, lang2, ...]
    # Row target_row_idx: [TARGET_KEY, orig1, orig2, ...]  (Original block)
    # Then gap col, then "Updated" block

    langs_ordered = list(lang_col_map.keys())

    # Backup section 1: Parameter / Original
    backup_header_values = ["Parameter"] + langs_ordered
    backup_orig_values = [TARGET_KEY] + [original_values[l] for l in langs_ordered]

    # Backup section 2: Updated (after another gap of 1)
    updated_start_col = backup_start_col + len(backup_header_values) + 1
    backup_updated_header = ["Updated"] + langs_ordered
    backup_updated_values = [TARGET_KEY] + [NEW_VALUES[l] for l in langs_ordered]

    # 4. Write backup header row
    def range_for_row(row_idx, start_col, num_cols):
        end_col = start_col + num_cols - 1
        row_num = row_idx + 1  # 1-based
        return f"{TAB_NAME}!{col_letter(start_col)}{row_num}:{col_letter(end_col)}{row_num}"

    # Write Original backup
    r1 = range_for_row(header_row_idx, backup_start_col, len(backup_header_values))
    r2 = range_for_row(target_row_idx, backup_start_col, len(backup_orig_values))
    # Write Updated backup
    r3 = range_for_row(header_row_idx, updated_start_col, len(backup_updated_header))
    r4 = range_for_row(target_row_idx, updated_start_col, len(backup_updated_values))

    print(f"\nWriting backup to ranges: {r1}, {r2}, {r3}, {r4}")

    sheets.values().batchUpdate(
        spreadsheetId=SHEET_ID,
        body={
            "valueInputOption": "RAW",
            "data": [
                {"range": r1, "values": [backup_header_values]},
                {"range": r2, "values": [backup_orig_values]},
                {"range": r3, "values": [backup_updated_header]},
                {"range": r4, "values": [backup_updated_values]},
            ]
        }
    ).execute()
    print("Backup written.")

    # 5. Update the actual language columns with new values
    update_data = []
    for lang, col_idx in lang_col_map.items():
        row_num = target_row_idx + 1  # 1-based
        cell_range = f"{TAB_NAME}!{col_letter(col_idx)}{row_num}"
        update_data.append({"range": cell_range, "values": [[NEW_VALUES[lang]]]})

    sheets.values().batchUpdate(
        spreadsheetId=SHEET_ID,
        body={
            "valueInputOption": "RAW",
            "data": update_data
        }
    ).execute()
    print("Language columns updated.")

    # 6. Apply sky blue highlight to updated cells
    # Get sheet metadata to find sheetId for TAB_NAME
    meta = sheets.get(spreadsheetId=SHEET_ID).execute()
    sheet_id = None
    for s in meta["sheets"]:
        if s["properties"]["title"] == TAB_NAME:
            sheet_id = s["properties"]["sheetId"]
            break

    if sheet_id is None:
        raise ValueError(f"Sheet tab '{TAB_NAME}' not found!")

    print(f"Sheet ID for '{TAB_NAME}': {sheet_id}")

    # Build format requests for each updated cell
    format_requests = []
    for lang, col_idx in lang_col_map.items():
        format_requests.append({
            "repeatCell": {
                "range": {
                    "sheetId": sheet_id,
                    "startRowIndex": target_row_idx,
                    "endRowIndex": target_row_idx + 1,
                    "startColumnIndex": col_idx,
                    "endColumnIndex": col_idx + 1,
                },
                "cell": {
                    "userEnteredFormat": {
                        "backgroundColor": SKY_BLUE
                    }
                },
                "fields": "userEnteredFormat.backgroundColor"
            }
        })

    sheets.batchUpdate(
        spreadsheetId=SHEET_ID,
        body={"requests": format_requests}
    ).execute()
    print("Sky blue highlight applied.")

    print(f"\n=== DONE ===")
    print(f"Row updated: {target_row_idx + 1} (1-based sheet row)")
    print(f"Key: {TARGET_KEY}")
    print(f"Languages updated: {', '.join(langs_ordered)}")
    print(f"Backup written at columns {col_letter(backup_start_col)} (Original) and {col_letter(updated_start_col)} (Updated)")

if __name__ == "__main__":
    main()
