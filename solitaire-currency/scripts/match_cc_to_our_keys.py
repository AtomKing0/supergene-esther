"""CC 로컬라이제이션 ↔ 우리 게임 string_code 매칭 — CC Localization 시트에 Our Key 열 추가"""
import re
import gspread
from google.oauth2.service_account import Credentials

CREDS_FILE = "pst-agent-187157cdb8b7.json"
SPREADSHEET_ID = "1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk"
CC_SHEET = "CC Localization"
OUR_SHEET = "string_code"

SCOPES = ["https://www.googleapis.com/auth/spreadsheets"]

# ── 1) 우리 게임 string_code 읽기 ─────────────────────────────────────────────
creds = Credentials.from_service_account_file(CREDS_FILE, scopes=SCOPES)
gc = gspread.authorize(creds)
sh = gc.open_by_key(SPREADSHEET_ID)

ws_our = sh.worksheet(OUR_SHEET)
our_rows = ws_our.get_all_values()
header_row = next(i for i, r in enumerate(our_rows) if r and r[0] == 'Key')
headers = our_rows[header_row]
ko_idx = headers.index('kr') if 'kr' in headers else None

our_keys = {}  # key → {en, ko}
for row in our_rows[header_row + 1:]:
    if not row or not row[0] or not row[0].startswith("T_"):
        continue
    k = row[0]
    en = row[1] if len(row) > 1 else ""
    ko = row[ko_idx] if ko_idx and len(row) > ko_idx else ""
    our_keys[k] = {"en": en, "ko": ko}

print(f"우리 게임 키: {len(our_keys)}개")

# ── 2) 값 기반 매칭 인덱스 구축 ────────────────────────────────────────────────
def normalize(s):
    """소문자, 특수문자 제거, 공백 정규화"""
    s = s.lower().strip()
    s = re.sub(r'\{[^}]+\}', '{var}', s)   # {0}, {clientVersion} 등 통일
    s = re.sub(r'[^\w\s{]', '', s)
    return re.sub(r'\s+', ' ', s).strip()

# 값 → 우리 키 인덱스 (exact match)
en_val_index = {}
for k, v in our_keys.items():
    nv = normalize(v["en"])
    if nv:
        en_val_index.setdefault(nv, []).append(k)

# ── 3) 수동 핵심 매핑 (높은 확신도 케이스) ────────────────────────────────────
MANUAL_MAP = {
    # General.Settings
    "General.Settings.Title": "T_SETTING_TITLE",
    "General.Settings.Music": None,
    "General.Settings.SoundFX": None,
    "General.Settings.ClientVersion": "T_CLIENT_VER",
    # General.Menu
    "General.Menu.Settings": "T_SETTING_TITLE",
    "General.Menu.EndGame": "T_END_LEVEL",
    "General.Menu.Close": "T_QUIT",
    # General.PrelevelPopup / PreLevelPopup
    "General.PreLevelPopup.Play": "T_PLAY",
    "General.PrelevelPopup.Play": "T_PLAY",
    "General.PrelevelPopup.Boosters": "T_SELECT_BOOSTER",
    # General.VictoryPopup
    "General.VictoryPopup.Title": "T_COMPLETE_LEVEL_TITLE",
    "General.VictoryPopup.Rewards": "T_COMPLETE_LEVEL_REWARD",
    # General.RestartPopup
    "General.RestartPopup.Title": "T_QUIT_LEVEL_TITLE",
    "General.RestartPopup.Desc": "T_QUIT_LEVEL_DESC",
    "General.RestartPopup.Quit": "T_QUIT",
    "General.RestartPopup.Resume": "T_RESUME",
    # General.EndlevelPopup
    "General.EndlevelPopup.Continue": "T_PLAY",
    # General.ToastNotification
    "General.ToastNotification.NoInternet": "T_ERROR_NO_RESTART",
    # General.Coins → gold
    "General.Coins.NotEnough": "T_GOLD_INSUFFICIENT",
    # General.Ads
    "General.Ads.FailedToLoad": "T_FAILED_TO_LOAD_AD",
    # General.TermsOfService
    "General.TermsOfService.Link2Text": "T_PRIVACY_POLICY",
    "General.TermsOfService.Button": "T_OK",
    # General.Boosters
    "General.Boosters.Title": "T_SELECT_BOOSTER",
    # General.Splashscreen
    "General.Splashscreen.Text01": "T_TUT_INGAME_INTRO",
    # General.MainScreen
    "General.MainScreen.Play": "T_PLAY",
    "General.MainScreen.Shop": "T_SHOP_TITLE",
    "General.MainScreen.Settings": "T_SETTING_TITLE",
    "General.MainScreen.Leaderboard": "T_LEADERBOARD_TITLE",
    # General.ForcedGameUpdate
    # General.Time
    # Gameplay
    "Gameplay.NotEnoughCoins.Title": "T_GOLD_INSUFFICIENT",
    "Gameplay.NotEnoughSweets.Close": "T_QUIT",
    # Tutorials
    "Tutorials.Gameplay.DrawDeck": "T_TUT_DECK_DRAW",
    "Tutorials.Gameplay.WildCard": "T_TUT_WILD_CARD",
    "Tutorials.Gameplay.Undo": "T_TUT_UNDO",
    # Meta
    "Meta.Shop.Title": "T_SHOP_TITLE",
    "Meta.PlayerProfile.Title": "T_LEADERBOARD_TITLE",
    "Meta.DailyLoginCalendar.Title": "T_DAILY_GIFTS_TITLE",
    "Meta.DailyLoginStreak.Title": "T_DAILY_GIFTS_TITLE",
    "Meta.Tournament.Title": "T_TOURNAMENT_POPUP_TITLE",
    "Meta.EpisodeRace.Title": "T_EVENT_RANK_TITLE",
    "Meta.Quests.Title": "T_DAILY_TASKS_TITLE",
    "Meta.PiggyBank.Title": "T_SHOP_TITLE",
}

# ── 4) 자동 매칭 함수 ─────────────────────────────────────────────────────────
def auto_match(cc_key, cc_en):
    """값 기반 자동 매칭. 결과: (our_key, match_type)"""
    # 수동 매핑 우선
    if cc_key in MANUAL_MAP:
        ok = MANUAL_MAP[cc_key]
        return (ok, "수동") if ok else (None, None)

    nv = normalize(cc_en)
    if not nv or len(nv) < 3:
        return None, None

    # 완전 일치
    if nv in en_val_index:
        matches = en_val_index[nv]
        return matches[0], "값일치"

    # 부분일치 — 양쪽 값 모두 8자 이상, 단어 단위로 포함 여부 확인
    if len(nv) >= 8:
        nv_words = set(nv.split())
        candidates = []
        for k, v in our_keys.items():
            ov = normalize(v["en"])
            if len(ov) < 8:
                continue  # 너무 짧은 우리 키 제외 (st, nd, rd 등 오탐 방지)
            ov_words = set(ov.split())
            # 양방향 단어 포함 (짧은 쪽이 긴 쪽에 완전히 포함)
            if nv_words <= ov_words or ov_words <= nv_words:
                overlap = len(nv_words & ov_words)
                total = max(len(nv_words), len(ov_words))
                if overlap / total >= 0.75:  # 75% 이상 단어 일치
                    candidates.append((k, v))
        if len(candidates) == 1:
            return candidates[0][0], "부분일치"

    return None, None

# ── 5) CC Localization 시트 읽기 + 매칭 ────────────────────────────────────────
ws_cc = sh.worksheet(CC_SHEET)
cc_rows = ws_cc.get_all_values()

print(f"CC 시트: {len(cc_rows)}행")
print(f"현재 헤더: {cc_rows[0]}")

# 기존 헤더에서 Our Key 열 위치 감지 (이미 있으면 덮어쓰기)
NEW_COLS = ["Our Key", "Our EN", "Our KO", "Match"]
header = cc_rows[0]
if "Our Key" in header:
    current_cols = header.index("Our Key")
    print(f"기존 Our Key 열 발견 (col {current_cols}) — 덮어쓰기 모드")
else:
    current_cols = len([c for c in header if c])  # 비어있지 않은 열 수
    print(f"새 열 추가 모드 (col {current_cols}~)")

# ── 6) 배치 업데이트 데이터 생성 ──────────────────────────────────────────────
updates = []  # (row_idx, col_idx, value) 0-based

# 헤더 행
for ci, col_name in enumerate(NEW_COLS):
    updates.append((0, current_cols + ci, col_name))

# 기존 데이터 전체 초기화 (덮어쓰기 모드)
for ri in range(1, len(cc_rows)):
    for ci in range(len(NEW_COLS)):
        updates.append((ri, current_cols + ci, ""))

match_count = 0
for ri, row in enumerate(cc_rows[1:], 1):
    if not row or len(row) < 2:
        continue
    cc_key = row[1].strip()  # B열 = Key
    cc_en = row[2].strip() if len(row) > 2 else ""  # C열 = EN
    if not cc_key or cc_key.startswith("["):  # 섹션 헤더 행 스킵
        continue

    our_key, match_type = auto_match(cc_key, cc_en)
    if our_key and our_key in our_keys:
        updates.append((ri, current_cols + 0, our_key))
        updates.append((ri, current_cols + 1, our_keys[our_key]["en"]))
        updates.append((ri, current_cols + 2, our_keys[our_key]["ko"]))
        updates.append((ri, current_cols + 3, match_type))
        match_count += 1

print(f"매칭 완료: {match_count}개 / {len([r for r in cc_rows[1:] if r and len(r) > 1 and r[1] and not r[1].startswith('[')])}개 CC 키")

# ── 7) 시트 열 확장 후 업데이트 ────────────────────────────────────────────────
# 열 수 부족 시 먼저 확장
needed_cols = current_cols + len(NEW_COLS)
sheet_id = ws_cc._properties["sheetId"]
sh.batch_update({"requests": [{
    "updateSheetProperties": {
        "properties": {
            "sheetId": sheet_id,
            "gridProperties": {"columnCount": needed_cols}
        },
        "fields": "gridProperties.columnCount"
    }
}]})
print(f"열 확장: {current_cols} → {needed_cols}열")

# ── 시트 업데이트 (배치) ────────────────────────────────────────────────────
def col_letter(n):
    result = ""
    while n >= 0:
        result = chr(n % 26 + ord('A')) + result
        n = n // 26 - 1
    return result

# cell range별로 묶어서 batch update
cell_data = []
for ri, ci, val in updates:
    cell_data.append({
        "range": f"{col_letter(ci)}{ri + 1}",
        "values": [[val]]
    })

# 청크 단위로 전송 (500개씩)
CHUNK = 500
for i in range(0, len(cell_data), CHUNK):
    ws_cc.batch_update(cell_data[i:i + CHUNK], value_input_option="USER_ENTERED")
    print(f"  업데이트 {i + len(cell_data[i:i + CHUNK])}/{len(cell_data)}")

# ── 8) 새 열 헤더 서식 ────────────────────────────────────────────────────────
requests = [
    {"repeatCell": {
        "range": {
            "sheetId": sheet_id,
            "startRowIndex": 0, "endRowIndex": 1,
            "startColumnIndex": current_cols, "endColumnIndex": current_cols + 4
        },
        "cell": {"userEnteredFormat": {
            "backgroundColor": {"red": 0.18, "green": 0.47, "blue": 0.71},
            "textFormat": {"bold": True, "foregroundColor": {"red": 1, "green": 1, "blue": 1}},
            "horizontalAlignment": "CENTER",
        }},
        "fields": "userEnteredFormat(backgroundColor,textFormat,horizontalAlignment)",
    }},
]
# Our Key 열 너비
for ci, px in enumerate([200, 280, 280, 70]):
    requests.append({"updateDimensionProperties": {
        "range": {"sheetId": sheet_id, "dimension": "COLUMNS",
                  "startIndex": current_cols + ci, "endIndex": current_cols + ci + 1},
        "properties": {"pixelSize": px},
        "fields": "pixelSize",
    }})

sh.batch_update({"requests": requests})
print(f"\n✅ 완료! 매칭 {match_count}개 추가")
print(f"https://docs.google.com/spreadsheets/d/{SPREADSHEET_ID}")
