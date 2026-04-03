"""CC 원본 로컬라이제이션 비교 시트 생성 — string_code 시트 옆에 추가"""
import gspread
from google.oauth2.service_account import Credentials
from collections import defaultdict

CREDS_FILE = "pst-agent-187157cdb8b7.json"
SPREADSHEET_ID = "1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk"
SHEET_NAME = "CC Localization"
AFTER_SHEET = "string_code"

EN_FILE = "/Users/estherpark/esther_solitaire/solitaire-esther-1/string_code/cc_localization/Language_en.txt"
KO_FILE = "/Users/estherpark/esther_solitaire/solitaire-esther-1/string_code/cc_localization/Language_ko.txt"

SCOPES = ["https://www.googleapis.com/auth/spreadsheets"]

# ── 1) 파싱 ──────────────────────────────────────────────────────────────────
def parse_lang(path):
    data = {}
    with open(path, encoding="utf-8") as f:
        for line in f:
            line = line.strip()
            if not line or "=" not in line:
                continue
            key, _, value = line.partition(" = ")
            data[key.strip()] = value.strip()
    return data

en = parse_lang(EN_FILE)
ko = parse_lang(KO_FILE)

# ── 2) 카테고리별 정렬 ────────────────────────────────────────────────────────
categories = defaultdict(list)
for key in sorted(en.keys()):
    top = key.split(".")[0]
    categories[top].append(key)

# 카테고리 순서: 주요 카테고리 먼저, 나머지 알파벳순
PRIORITY = ["General", "Gameplay", "Tutorials", "Meta", "Postcards",
            "LocalNotifications", "Marketing", "Chests", "NativeSharing"]
ordered_cats = PRIORITY + sorted(c for c in categories if c not in PRIORITY)

# ── 3) 행 생성 ────────────────────────────────────────────────────────────────
rows = [["Category", "Key", "EN", "KO"]]
for cat in ordered_cats:
    if cat not in categories:
        continue
    # 섹션 헤더
    rows.append([f"[{cat}]  ({len(categories[cat])}개)", "", "", ""])
    for key in categories[cat]:
        rows.append([cat, key, en.get(key, ""), ko.get(key, "")])
    rows.append(["", "", "", ""])  # 빈 줄 구분

print(f"총 {len(rows)}행 준비 완료 ({len(en)}개 키)")

# ── 4) Google Sheets 연결 ─────────────────────────────────────────────────────
creds = Credentials.from_service_account_file(CREDS_FILE, scopes=SCOPES)
gc = gspread.authorize(creds)
sh = gc.open_by_key(SPREADSHEET_ID)

# string_code 시트 위치 찾기
worksheets = sh.worksheets()
after_idx = next((i for i, ws in enumerate(worksheets) if ws.title == AFTER_SHEET), None)

# 기존 시트 있으면 삭제
existing = next((ws for ws in worksheets if ws.title == SHEET_NAME), None)
if existing:
    sh.del_worksheet(existing)
    print(f"기존 '{SHEET_NAME}' 시트 삭제")
    worksheets = sh.worksheets()
    after_idx = next((i for i, ws in enumerate(worksheets) if ws.title == AFTER_SHEET), None)

# string_code 바로 다음 위치에 삽입
insert_idx = (after_idx + 1) if after_idx is not None else len(worksheets)
ws = sh.add_worksheet(title=SHEET_NAME, rows=len(rows) + 10, cols=4, index=insert_idx)
print(f"'{SHEET_NAME}' 시트 생성 (index={insert_idx})")

# ── 5) 데이터 입력 ────────────────────────────────────────────────────────────
ws.update(rows, value_input_option="USER_ENTERED")
print(f"데이터 입력 완료: {len(rows)}행")

# ── 6) 서식 적용 ─────────────────────────────────────────────────────────────
sheet_id = ws._properties["sheetId"]

requests = []

# 헤더 행 서식 (Row 1)
requests.append({"repeatCell": {
    "range": {"sheetId": sheet_id, "startRowIndex": 0, "endRowIndex": 1},
    "cell": {"userEnteredFormat": {
        "backgroundColor": {"red": 0.2, "green": 0.2, "blue": 0.2},
        "textFormat": {"bold": True, "foregroundColor": {"red": 1, "green": 1, "blue": 1}},
        "horizontalAlignment": "CENTER",
    }},
    "fields": "userEnteredFormat(backgroundColor,textFormat,horizontalAlignment)",
}})

# 섹션 헤더 행 서식 ([Category] 행)
for i, row in enumerate(rows):
    if row[0].startswith("[") and row[0].endswith(")"):
        requests.append({"repeatCell": {
            "range": {"sheetId": sheet_id, "startRowIndex": i, "endRowIndex": i + 1},
            "cell": {"userEnteredFormat": {
                "backgroundColor": {"red": 0.93, "green": 0.93, "blue": 0.93},
                "textFormat": {"bold": True},
            }},
            "fields": "userEnteredFormat(backgroundColor,textFormat)",
        }})

# 열 너비
col_widths = [120, 320, 320, 320]
for col_idx, px in enumerate(col_widths):
    requests.append({"updateDimensionProperties": {
        "range": {"sheetId": sheet_id, "dimension": "COLUMNS",
                  "startIndex": col_idx, "endIndex": col_idx + 1},
        "properties": {"pixelSize": px},
        "fields": "pixelSize",
    }})

# 헤더 고정
requests.append({"updateSheetProperties": {
    "properties": {"sheetId": sheet_id, "gridProperties": {"frozenRowCount": 1}},
    "fields": "gridProperties.frozenRowCount",
}})

sh.batch_update({"requests": requests})
print("서식 적용 완료")
print(f"\n✅ 완료! https://docs.google.com/spreadsheets/d/{SPREADSHEET_ID}")
