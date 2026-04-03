"""CC Localization 시트의 Score/Suggested EN/CC KO → string_code 에이전트 시트 반영
워크플로우: 에이전트 시트 수정 + 하이라이트 → 사용자 확인 후 라이브 시트 동기화
"""
import re
import gspread
from google.oauth2.service_account import Credentials

CREDS_FILE = "pst-agent-187157cdb8b7.json"
AGENT_SHEET_ID  = "1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk"
SCOPES = ["https://www.googleapis.com/auth/spreadsheets"]

MIN_SCORE = 3  # 이 점수 이상인 행만 반영

# ── CC 용어 → 우리 게임 용어 KO 치환 테이블 ─────────────────────────────────
KO_SUBS = [
    # 브랜드
    (r"캔디 크러쉬 솔리테어", "솔리테어 트라이픽스"),
    (r"캔디 크러시 솔리테어", "솔리테어 트라이픽스"),
    (r"Candy Crush Solitaire", "솔리테어 트라이픽스"),
    # 카드 기믹
    (r"피쉬 카드", "와일드 카드"),
    (r"물고기 카드", "와일드 카드"),
    (r"필 카드", "러너 카드"),
    (r"껍질 카드", "러너 카드"),
    (r"컨베이어 업 카드", "러너 카드"),
    (r"컨베이어 카드", "러너 카드"),
    (r"리코리스", "아이스"),          # 유사 기믹 참고용
    (r"감초", "아이스"),
    # 경제
    (r"스톡파일", "덱"),
    (r"코인", "골드"),
    (r"동전", "골드"),
    # 기타
    (r"사탕", "카드"),               # 맥락 외 사탕 표현 → 카드 (필요시만)
]

# CLAUDE.md 특수문자 치환
SPECIAL_CHAR_SUBS = [
    ("\u201c", ""),   # left double quote → 제거
    ("\u201d", ""),   # right double quote → 제거
    ("\u0022", ""),   # straight double quote → 제거
    ("\u00a0", " "),  # NO-BREAK SPACE → 일반 스페이스
    ("\u2014", "-"),  # em-dash → hyphen
    ("\u2013", "-"),  # en-dash → hyphen
    ("\u2116", "#"),  # numero sign
    ("\u005c", ""),   # backslash → 제거
]

def clean(s):
    if not s:
        return s
    for old, new in SPECIAL_CHAR_SUBS:
        s = s.replace(old, new)
    # 제어 문자 제거 (탭·개행 제외)
    s = re.sub(r'[\x00-\x08\x0b\x0c\x0e-\x1f]', '', s)
    # zero-width 문자 제거
    s = re.sub(r'[\u200b-\u200f\ufeff]', '', s)
    return s.strip()

def adapt_ko(s):
    """CC KO 텍스트를 우리 게임 용어로 치환"""
    if not s:
        return s
    for pattern, repl in KO_SUBS:
        s = re.sub(pattern, repl, s, flags=re.IGNORECASE)
    return clean(s)

# ── 1) 에이전트 시트 연결 ──────────────────────────────────────────────────────
creds = Credentials.from_service_account_file(CREDS_FILE, scopes=SCOPES)
gc = gspread.authorize(creds)
sh = gc.open_by_key(AGENT_SHEET_ID)

# ── 2) CC Localization 시트 읽기 ───────────────────────────────────────────────
ws_cc = sh.worksheet("CC Localization")
cc_rows = ws_cc.get_all_values()
cc_header = cc_rows[0]

# 헤더 열 인덱스
def col(name):
    return cc_header.index(name) if name in cc_header else None

ci_cc_ko    = col("KO")         # D열
ci_our_key  = col("Our Key")    # E열
ci_score    = col("Score")      # I열
ci_sug_en   = col("Suggested EN")  # J열

print(f"CC Localization 헤더: {cc_header}")
print(f"열 인덱스 — KO:{ci_cc_ko}, Our Key:{ci_our_key}, Score:{ci_score}, Suggested EN:{ci_sug_en}")

# our_key → {score, suggested_en, cc_ko} 수집 (점수 가장 높은 것 우선)
key_data = {}  # T_KEY → {score, en, ko}
for row in cc_rows[1:]:
    if not row or len(row) <= max(filter(None, [ci_our_key, ci_score, ci_sug_en])):
        continue
    our_key = row[ci_our_key].strip() if ci_our_key is not None else ""
    if not our_key or not our_key.startswith("T_"):
        continue
    try:
        score = int(row[ci_score]) if ci_score is not None and row[ci_score].strip() else 0
    except ValueError:
        score = 0
    if score < MIN_SCORE:
        continue
    suggested_en = row[ci_sug_en].strip() if ci_sug_en is not None and len(row) > ci_sug_en else ""
    cc_ko = row[ci_cc_ko].strip() if ci_cc_ko is not None and len(row) > ci_cc_ko else ""

    # 이미 있으면 점수 높은 것 우선
    if our_key in key_data and key_data[our_key]["score"] >= score:
        continue
    if suggested_en:
        key_data[our_key] = {"score": score, "en": suggested_en, "ko": adapt_ko(cc_ko)}

print(f"\nSuggested EN 적용 대상: {len(key_data)}개 T_ 키")

# ── 3) string_code 시트 읽기 ───────────────────────────────────────────────────
ws_sc = sh.worksheet("string_code")
sc_rows = ws_sc.get_all_values()

# 헤더 행 찾기
header_row_idx = next(i for i, r in enumerate(sc_rows) if r and r[0] == "Key")
headers = sc_rows[header_row_idx]
en_col  = headers.index("en") if "en" in headers else 1
ko_col  = headers.index("kr") if "kr" in headers else None
sheet_id_sc = ws_sc._properties["sheetId"]

print(f"string_code 헤더행: {header_row_idx}, EN열: {en_col}, KO열: {ko_col}")

# Key → 행 인덱스 (0-based) 매핑
key_to_row_sc = {}
for i, row in enumerate(sc_rows[header_row_idx + 1:], header_row_idx + 1):
    if row and row[0].startswith("T_"):
        key_to_row_sc[row[0]] = i

# ── 4) 변경 사항 계산 ─────────────────────────────────────────────────────────
changes = []  # (row_idx, col_idx, old_val, new_val, kind)  kind: en|ko

for t_key, data in key_data.items():
    if t_key not in key_to_row_sc:
        continue
    ri = key_to_row_sc[t_key]
    row = sc_rows[ri]

    # EN
    cur_en = row[en_col] if len(row) > en_col else ""
    new_en = clean(data["en"])
    if new_en and new_en != cur_en:
        changes.append((ri, en_col, cur_en, new_en, "en"))

    # KO
    if ko_col is not None:
        cur_ko = row[ko_col] if len(row) > ko_col else ""
        new_ko = data["ko"]
        if new_ko and new_ko != cur_ko:
            changes.append((ri, ko_col, cur_ko, new_ko, "ko"))

print(f"\n변경 예정:")
print(f"  EN: {sum(1 for c in changes if c[4]=='en')}개")
print(f"  KO: {sum(1 for c in changes if c[4]=='ko')}개")
print()
for ri, ci, old, new, kind in changes:
    key = sc_rows[ri][0]
    print(f"  [{kind.upper()}] {key}")
    print(f"    이전: {old[:80]}")
    print(f"    이후: {new[:80]}")
    print()

# ── 5) 에이전트 시트 업데이트 ─────────────────────────────────────────────────
def col_letter(n):
    result = ""
    while n >= 0:
        result = chr(n % 26 + ord('A')) + result
        n = n // 26 - 1
    return result

cell_data = []
for ri, ci, old, new, kind in changes:
    cell_data.append({
        "range": f"{col_letter(ci)}{ri + 1}",
        "values": [[new]]
    })

CHUNK = 500
for i in range(0, len(cell_data), CHUNK):
    ws_sc.batch_update(cell_data[i:i+CHUNK], value_input_option="USER_ENTERED")

print(f"에이전트 시트 업데이트 완료: {len(changes)}개 셀")

# ── 6) 하이라이트 (연두색) ─────────────────────────────────────────────────────
light_green = {"red": 0.85, "green": 0.93, "blue": 0.83}
highlight_requests = []
for ri, ci, old, new, kind in changes:
    highlight_requests.append({"repeatCell": {
        "range": {
            "sheetId": sheet_id_sc,
            "startRowIndex": ri, "endRowIndex": ri + 1,
            "startColumnIndex": ci, "endColumnIndex": ci + 1,
        },
        "cell": {"userEnteredFormat": {"backgroundColor": light_green}},
        "fields": "userEnteredFormat.backgroundColor",
    }})

if highlight_requests:
    for i in range(0, len(highlight_requests), 100):
        sh.batch_update({"requests": highlight_requests[i:i+100]})

print(f"하이라이트 완료: {len(highlight_requests)}개 셀")
print(f"\n✅ 에이전트 시트 업데이트 완료!")
print(f"👉 시트 확인 후 '확인완료' 입력 시 라이브 시트 동기화를 진행합니다.")
print(f"https://docs.google.com/spreadsheets/d/{AGENT_SHEET_ID}#gid={sheet_id_sc}")
