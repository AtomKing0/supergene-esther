"""Google Drive에 로그 정의서 Google Sheet 생성 스크립트"""
import csv
import gspread
from google.oauth2.service_account import Credentials

CREDS_FILE = "pst-agent-187157cdb8b7.json"
CSV_FILE = "workspace/log_definition.csv"
SPREADSHEET_ID = "1-QxV4ToLnL32qiQkWxbISFd575BYwVKBcaBE4YwJBLo"
WORKSHEET_NAME = "Log Def"

SCOPES = [
    "https://www.googleapis.com/auth/spreadsheets",
    "https://www.googleapis.com/auth/drive",
]

creds = Credentials.from_service_account_file(CREDS_FILE, scopes=SCOPES)
gc = gspread.authorize(creds)

# 1) CSV 읽기
with open(CSV_FILE, "r", encoding="utf-8") as f:
    reader = csv.reader(f)
    rows = list(reader)

print(f"CSV 로드 완료: {len(rows)}행")

# 2) 기존 시트 열기
sh = gc.open_by_key(SPREADSHEET_ID)
print(f"시트 열기 완료: {sh.url}")

# 3) 데이터 입력 (Log Def 시트)
ws = sh.worksheet(WORKSHEET_NAME)
ws.update(rows, value_input_option="USER_ENTERED")
print(f"데이터 입력 완료: {len(rows)}행")

# 4) 헤더 서식 (볼드 + 배경색 + 고정)
header_format = {
    "backgroundColor": {"red": 0.2, "green": 0.2, "blue": 0.2},
    "textFormat": {"bold": True, "foregroundColor": {"red": 1, "green": 1, "blue": 1}},
    "horizontalAlignment": "CENTER",
}
ws.format("A1:F1", header_format)

# 섹션 헤더 (0xxx, 1xxx 등) 서식
section_format = {
    "backgroundColor": {"red": 0.93, "green": 0.93, "blue": 0.93},
    "textFormat": {"bold": True},
}

section_rows = []
for i, row in enumerate(rows):
    if len(row) >= 3 and row[0] == "" and row[1] == "" and row[2] and ("xxx" in row[2]):
        section_rows.append(i + 1)

for r in section_rows:
    ws.format(f"A{r}:F{r}", section_format)

# 헤더 행 고정
ws.freeze(rows=1)

# 열 너비 조정
requests = [
    {"updateDimensionProperties": {
        "range": {"sheetId": 0, "dimension": "COLUMNS", "startIndex": 0, "endIndex": 1},
        "properties": {"pixelSize": 60}, "fields": "pixelSize"}},
    {"updateDimensionProperties": {
        "range": {"sheetId": 0, "dimension": "COLUMNS", "startIndex": 1, "endIndex": 2},
        "properties": {"pixelSize": 60}, "fields": "pixelSize"}},
    {"updateDimensionProperties": {
        "range": {"sheetId": 0, "dimension": "COLUMNS", "startIndex": 2, "endIndex": 3},
        "properties": {"pixelSize": 320}, "fields": "pixelSize"}},
    {"updateDimensionProperties": {
        "range": {"sheetId": 0, "dimension": "COLUMNS", "startIndex": 3, "endIndex": 4},
        "properties": {"pixelSize": 400}, "fields": "pixelSize"}},
    {"updateDimensionProperties": {
        "range": {"sheetId": 0, "dimension": "COLUMNS", "startIndex": 4, "endIndex": 5},
        "properties": {"pixelSize": 300}, "fields": "pixelSize"}},
    {"updateDimensionProperties": {
        "range": {"sheetId": 0, "dimension": "COLUMNS", "startIndex": 5, "endIndex": 6},
        "properties": {"pixelSize": 500}, "fields": "pixelSize"}},
]
sh.batch_update({"requests": requests})

print(f"\n✅ 완료! Google Sheet URL: {sh.url}")
