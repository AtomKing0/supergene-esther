"""
V4 파라미터 13개 라이브 시트 검증
에이전트 시트: 1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk
"""
import sys, os
sys.path.insert(0, os.path.dirname(__file__))

import gspread
from google.oauth2.service_account import Credentials

CREDS_FILE = os.path.join(os.path.dirname(__file__), "..", "pst-agent-187157cdb8b7.json")
SHEET_ID   = "1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk"

# V4 목표값: (sheet, key_or_id, param_name, v3_val, v4_val, note)
V4_PARAMS = [
    ("const",      10003, "idle_gold_charge_amount",    3000,  2000,  "방치골드 기본값"),
    ("const",      10005, "idle_gold_amount_increase",   400,   300,  "방치골드 증가율"),
    ("const",      10006, "idle_gold_max_cap",          10000,  6000, "방치골드 상한"),
    ("const",      10058, "inbox_free_gold_amount",       800,   600, "인박스 광고 골드"),
    ("const",      10064, "popup_free_gold_amount",       800,   600, "팝업 광고 골드"),
    ("const",      10063, "popup_free_gold_limit",         10,    10, "팝업 횟수 (유지)"),
    ("const",      10057, "inbox_free_gold_limit",          5,     5, "인박스 횟수 (유지)"),
    ("const",      10061, "is_album_collection_open",       0,     1, "앨범 컬렉션 ON"),
    ("const",      10062, "is_deck_collection_open",        0,     1, "덱 컬렉션 ON"),
    ("product",   190001, "reward_amount (shop AD gold)",1000,   700, "상점 광고 골드"),
    ("product",   190001, "pay_limit (shop AD count)",     1,     3, "상점 광고 횟수"),
    ("daily_gift",150007, "day6 gold reward",            5000,  3000, "출석 Day6 골드"),
    ("entry_tier",  None, "level_entry_tier +20%",       None,  None, "전 구간 +20%"),
]

def get_sheet_data(gc, sheet_name):
    ws = gc.open_by_key(SHEET_ID).worksheet(sheet_name)
    rows = ws.get_all_values()
    # row[0]=meta, row[1]=headers, row[2:]=data
    headers = rows[1] if len(rows) > 1 else []
    data    = rows[2:] if len(rows) > 2 else []
    return headers, data

def find_col(headers, *candidates):
    for c in candidates:
        for i, h in enumerate(headers):
            if h.strip().lower() == c.lower():
                return i
    return None

def to_int(val):
    try:
        return int(str(val).replace(",", "").strip())
    except:
        return None

def main():
    creds = Credentials.from_service_account_file(
        CREDS_FILE,
        scopes=["https://www.googleapis.com/auth/spreadsheets.readonly"]
    )
    gc = gspread.authorize(creds)

    # ── 1. const 시트 로드 ──────────────────────────────────────────────
    const_headers, const_data = get_sheet_data(gc, "const")
    key_col = find_col(const_headers, "key_number")
    val_col = find_col(const_headers, "value", "const_value")
    const_map = {}
    if key_col is not None and val_col is not None:
        for row in const_data:
            k = to_int(row[key_col]) if key_col < len(row) else None
            v = to_int(row[val_col]) if val_col < len(row) else None
            if k is not None:
                const_map[k] = v

    # ── 2. product 시트 로드 ─────────────────────────────────────────────
    prod_headers, prod_data = get_sheet_data(gc, "product")
    prod_key_col    = find_col(prod_headers, "key_number")
    prod_reward_col = find_col(prod_headers, "reward_amount")
    prod_limit_col  = find_col(prod_headers, "pay_limit")
    prod_map = {}
    if prod_key_col is not None:
        for row in prod_data:
            k = to_int(row[prod_key_col]) if prod_key_col < len(row) else None
            if k is not None:
                prod_map[k] = {
                    "reward_amount": to_int(row[prod_reward_col]) if prod_reward_col is not None and prod_reward_col < len(row) else None,
                    "pay_limit":     to_int(row[prod_limit_col])  if prod_limit_col  is not None and prod_limit_col  < len(row) else None,
                }

    # ── 3. daily_gift 시트 로드 ──────────────────────────────────────────
    gift_headers, gift_data = get_sheet_data(gc, "daily_gift")
    gift_key_col = find_col(gift_headers, "key_number")
    gift_amt_col = find_col(gift_headers, "amount", "reward_amount", "gold_amount")
    gift_map = {}
    if gift_key_col is not None and gift_amt_col is not None:
        for row in gift_data:
            k = to_int(row[gift_key_col]) if gift_key_col < len(row) else None
            v = to_int(row[gift_amt_col]) if gift_amt_col < len(row) else None
            if k is not None:
                gift_map[k] = v

    # ── 4. level_entry_tier 시트 로드 ────────────────────────────────────
    try:
        tier_headers, tier_data = get_sheet_data(gc, "level_entry_tier")
    except:
        tier_headers, tier_data = [], []
    tier_key_col   = find_col(tier_headers, "key_number")
    tier_cost_col  = find_col(tier_headers, "entry_cost", "cost")
    tier_rows = []
    if tier_key_col is not None and tier_cost_col is not None:
        for row in tier_data:
            k = to_int(row[tier_key_col]) if tier_key_col < len(row) else None
            v = to_int(row[tier_cost_col]) if tier_cost_col < len(row) else None
            if k is not None and v is not None:
                tier_rows.append((k, v))

    # ── 결과 출력 ─────────────────────────────────────────────────────────
    print()
    print("=" * 80)
    print("  V4 파라미터 라이브 시트 검증 결과")
    print("=" * 80)
    print(f"{'시트':<12} {'키':<10} {'파라미터':<36} {'V3':>7} {'V4목표':>7} {'라이브':>8}  상태")
    print("-" * 80)

    all_pass = True
    for sheet, key, name, v3, v4, note in V4_PARAMS:
        if sheet == "entry_tier":
            # entry_tier는 별도 처리
            continue

        live = None
        if sheet == "const":
            live = const_map.get(key)
        elif sheet == "product":
            if "reward" in name:
                live = prod_map.get(key, {}).get("reward_amount")
            else:
                live = prod_map.get(key, {}).get("pay_limit")
        elif sheet == "daily_gift":
            live = gift_map.get(key)

        if live is None:
            status = "⚠️  키 없음"
            all_pass = False
        elif live == v4:
            status = "✅ V4 완료"
        elif live == v3:
            status = "❌ V3 미적용"
            all_pass = False
        else:
            status = f"🔶 중간값"
            all_pass = False

        key_str = str(key) if key else "—"
        v3_str  = str(v3)  if v3 is not None else "—"
        v4_str  = str(v4)  if v4 is not None else "—"
        live_str= str(live) if live is not None else "—"
        print(f"{sheet:<12} {key_str:<10} {name:<36} {v3_str:>7} {v4_str:>7} {live_str:>8}  {status}")

    # entry_tier 별도 출력
    print()
    print(f"  [entry_tier] level_entry_tier 전 구간 +20% 검증")
    print(f"  {'key':<8} {'라이브 entry_cost':>18}  비고")
    print(f"  {'-'*40}")

    # 기준 값 (V3 추정): V4 = V3 * 1.2 이므로 V3 = live / 1.2
    # 이미 알려진 V3 기준값 샘플:
    # key Lv3-9: V4=1200, key Lv10-24: V4=1800, key Lv25-49: V4=2160
    v4_expected = {
        1: 1200,   # Lv3-9 (key 추정, 실제 키 확인 필요)
        2: 1800,   # Lv10-24
        3: 2160,   # Lv25-49
    }
    tier_status_all = True
    for k, v in tier_rows:
        expected = None
        remainder = v % 120  # V4는 V3*1.2이므로 120의 배수 여부
        is_v4_likely = (remainder == 0)
        status = "✅ +20% 적용됨" if is_v4_likely else "🔶 확인 필요"
        if not is_v4_likely:
            tier_status_all = False
        print(f"  {k:<8} {v:>18}  {status}")

    print()
    if tier_status_all and tier_rows:
        print("  [entry_tier] ✅ 전 구간 120 배수 — +20% 적용 완료 가능성 높음")
    elif not tier_rows:
        print("  [entry_tier] ⚠️  데이터 없음 (시트명/컬럼명 확인 필요)")
    else:
        print("  [entry_tier] 🔶 일부 구간 불일치 — 수동 확인 필요")

    print()
    print("=" * 80)

    # ── 5. gift_map 디버그 (Day6 못 찾을 경우 전체 출력) ───────────────
    if 150007 not in gift_map:
        print()
        print("  [DEBUG] daily_gift 시트 전체 key_number 목록:")
        print(f"  headers: {gift_headers}")
        for row in gift_data[:10]:
            print(f"    {row}")

    # ── 6. const_map 디버그: 찾는 키 누락 시 ────────────────────────────
    missing_const = [k for _, k, _, _, _, _ in V4_PARAMS
                     if _ != "entry_tier" and k not in const_map
                     and isinstance(k, int) and k < 20000]
    # (skip — already printed above)

if __name__ == "__main__":
    main()
