import json
import random
from dataclasses import dataclass
from pathlib import Path

import gspread
from google.oauth2.service_account import Credentials


SPREADSHEET_ID = "1oLbpsJjiDz0pdljaGBQznrSZcXA7aypFyJihnQ8_iiM"
CREDS_PATH = "solitaire-currency/pst-agent-187157cdb8b7.json"
OUT_PATH = Path("workspace/live_currency_simulation_result.json")


def to_num(value):
    if value in ("", None):
        return 0
    text = str(value).replace(",", "").strip()
    try:
        return int(text)
    except ValueError:
        try:
            return float(text)
        except ValueError:
            return value


def load_sheet():
    creds = Credentials.from_service_account_file(
        CREDS_PATH,
        scopes=["https://www.googleapis.com/auth/spreadsheets.readonly"],
    )
    gc = gspread.authorize(creds)
    sh = gc.open_by_key(SPREADSHEET_ID)

    def recs(name):
        values = sh.worksheet(name).get_all_values()
        headers = values[1]
        rows = []
        for raw in values[2:]:
            row = {}
            for index, header in enumerate(headers):
                if header:
                    row[header] = raw[index] if index < len(raw) else ""
            rows.append(row)
        return rows

    return sh.title, recs


@dataclass(frozen=True)
class Segment:
    name: str
    level: int
    plays_per_day: int
    win_rate: float
    idle_claims_per_day: int
    rv_claim_rate: float
    shop_ad_claims_per_day: int
    wheel_spins_per_day: int
    undo_uses_per_loss: float
    extra_deck_uses_per_loss: float
    fixed_boosters_per_day: float
    meta_spend_gold_per_day: int
    share_gold_per_day: int


SEGMENTS = [
    Segment("극소극 Lv5", 5, 2, 0.75, 1, 0.10, 0, 0, 0.0, 0.0, 0.0, 0, 0),
    Segment("소극 Lv15", 15, 5, 0.65, 2, 0.25, 1, 1, 0.10, 0.05, 0.0, 0, 0),
    Segment("보통 Lv75", 75, 15, 0.60, 3, 0.50, 2, 3, 0.25, 0.10, 0.25, 300, 25),
    Segment("활발 Lv75", 75, 25, 0.58, 4, 0.70, 3, 5, 0.35, 0.15, 0.50, 600, 50),
    Segment("헌신 Lv200", 200, 35, 0.56, 5, 0.80, 3, 5, 0.45, 0.20, 0.80, 900, 50),
    Segment("하드코어 Lv300", 300, 50, 0.55, 6, 0.90, 3, 5, 0.60, 0.25, 1.20, 1200, 50),
]


def tier_for(level, tiers):
    for tier in tiers:
        if tier["level_min"] <= level <= tier["level_max"]:
            return tier
    return tiers[-1]


def idle_amount(level, const):
    base = const["idle_gold_charge_amount"]
    interval = const["idle_gold_interval"]
    increase = const["idle_gold_amount_increase"]
    cap = const["idle_gold_max_cap"]
    return min(base + (level // interval) * increase, cap)


def weighted_spin(wheel):
    pick = random.randint(1, 10000)
    acc = 0
    for item, amount, rate in wheel:
        acc += rate
        if pick <= acc:
            return item, amount
    return wheel[-1][0], wheel[-1][1]


def simulate_segment(segment, const, tiers, item, wheel, gift, days=30, runs=500):
    tier = tier_for(segment.level, tiers)
    entry = tier["entry_cost"]
    rv_gold = round(entry * tier["rv_gold_ratio"] / 10000)
    idle = idle_amount(segment.level, const)
    shop_ad_gold = const["shop_ad_gold"]

    undo_base = round(entry * tier["undo_ratio"] / 10000)
    extra_base = round(entry * tier["extra_deck_ratio"] / 10000)
    fixed_costs = [
        round(entry * item["booster_fireworks"]["entry_cost_ratio"] / 10000),
        round(entry * item["booster_golden_ticket"]["entry_cost_ratio"] / 10000),
        round(entry * item["booster_wild_card"]["entry_cost_ratio"] / 10000),
    ]
    avg_fixed_cost = sum(fixed_costs) / len(fixed_costs)

    inbox_limit = const["inbox_free_gold_limit"]
    popup_limit = const["popup_free_gold_limit"]
    lobby_limit = const["lobby_free_gold_limit"]
    rv_limit_total = inbox_limit + popup_limit + lobby_limit

    daily_rows = []
    final_balances = []
    source_sums = []
    sink_sums = []

    for run in range(runs):
        random.seed(1000 + run)
        balance = const["nru_start_gold"]
        total_source = const["nru_start_gold"]
        total_sink = 0

        for day in range(days):
            source = 0
            sink = 0

            idle_source = idle * segment.idle_claims_per_day
            rv_source = rv_gold * round(rv_limit_total * segment.rv_claim_rate)
            shop_source = shop_ad_gold * min(segment.shop_ad_claims_per_day, const["shop_ad_limit"])
            share_source = segment.share_gold_per_day

            wheel_source = 0
            for _ in range(min(segment.wheel_spins_per_day, const["daily_wheel_ad_limit"])):
                reward_item, amount = weighted_spin(wheel)
                if reward_item == "currency_gold":
                    wheel_source += amount

            gift_source = 0
            for reward_item, amount in gift[day % 7]:
                if reward_item == "currency_gold":
                    gift_source += amount

            source += idle_source + rv_source + shop_source + wheel_source + gift_source + share_source

            losses = segment.plays_per_day * (1 - segment.win_rate)
            entry_sink = entry * segment.plays_per_day
            undo_sink = undo_base * losses * segment.undo_uses_per_loss
            extra_sink = extra_base * losses * segment.extra_deck_uses_per_loss
            fixed_sink = avg_fixed_cost * segment.fixed_boosters_per_day
            meta_sink = segment.meta_spend_gold_per_day
            sink += entry_sink + undo_sink + extra_sink + fixed_sink + meta_sink

            balance += source - sink
            total_source += source
            total_sink += sink

            if run == 0:
                daily_rows.append(
                    {
                        "day": day + 1,
                        "source": round(source),
                        "sink": round(sink),
                        "net": round(source - sink),
                        "balance": round(balance),
                    }
                )

        final_balances.append(balance)
        source_sums.append(total_source)
        sink_sums.append(total_sink)

    final_balances.sort()
    return {
        "segment": segment.name,
        "level": segment.level,
        "entry_cost": entry,
        "rv_gold_per_claim": rv_gold,
        "idle_gold_per_claim": idle,
        "assumptions": {
            "plays_per_day": segment.plays_per_day,
            "win_rate": segment.win_rate,
            "idle_claims_per_day": segment.idle_claims_per_day,
            "rv_claim_rate": segment.rv_claim_rate,
            "shop_ad_claims_per_day": segment.shop_ad_claims_per_day,
            "wheel_spins_per_day": segment.wheel_spins_per_day,
            "undo_uses_per_loss": segment.undo_uses_per_loss,
            "extra_deck_uses_per_loss": segment.extra_deck_uses_per_loss,
            "fixed_boosters_per_day": segment.fixed_boosters_per_day,
            "meta_spend_gold_per_day": segment.meta_spend_gold_per_day,
            "share_gold_per_day": segment.share_gold_per_day,
        },
        "d30": {
            "avg_source": round(sum(source_sums) / runs),
            "avg_sink": round(sum(sink_sums) / runs),
            "avg_net": round((sum(source_sums) - sum(sink_sums)) / runs),
            "avg_balance": round(sum(final_balances) / runs),
            "p10_balance": round(final_balances[int(runs * 0.10)]),
            "p50_balance": round(final_balances[int(runs * 0.50)]),
            "p90_balance": round(final_balances[int(runs * 0.90)]),
        },
        "sample_daily": daily_rows,
    }


def main():
    sheet_title, recs = load_sheet()

    const_rows = recs("const")
    const = {
        row["const_name"]: to_num(row["const_value"])
        for row in const_rows
        if row.get("const_name")
    }
    product_rows = recs("product")
    shop_ad = next(row for row in product_rows if row.get("product_id") == "gold_ad_1")
    const["shop_ad_gold"] = to_num(shop_ad["reward_amount"])
    const["shop_ad_limit"] = to_num(shop_ad["pay_limit"])

    tiers = []
    for row in recs("level_entry_tier"):
        if row.get("key_number"):
            tiers.append(
                {
                    "level_min": to_num(row["level_min"]),
                    "level_max": to_num(row["level_max"]),
                    "entry_cost": to_num(row["entry_cost"]),
                    "undo_ratio": to_num(row["undo_ratio"]),
                    "extra_deck_ratio": to_num(row["extra_deck_ratio"]),
                    "rv_gold_ratio": to_num(row["rv_gold_ratio"]),
                }
            )

    item = {}
    for row in recs("item_list"):
        name = row.get("name_key")
        if name:
            item[name] = {
                "entry_cost_ratio": to_num(row.get("entry_cost_ratio")),
                "interval_type": row.get("interval_type"),
                "use_count_increase_rate": to_num(row.get("use_count_increase_rate")),
                "use_count_max_ratio": to_num(row.get("use_count_max_ratio")),
            }

    wheel = []
    for row in recs("daily_wheel"):
        if row.get("key_number"):
            wheel.append((row["reward_item_key"], to_num(row["reward_amount"]), to_num(row["gacha_rate"])))

    gift = {}
    for row in recs("daily_gift"):
        if row.get("key_number"):
            day = to_num(row["day"])
            rewards = []
            for index in ("1", "2", "3"):
                reward_item = row.get(f"reward_item_key_{index}")
                amount = to_num(row.get(f"reward_amount_{index}"))
                if reward_item and reward_item != "none" and amount:
                    rewards.append((reward_item, amount))
            gift[day] = rewards

    meta_rows = [row for row in recs("meta_decoration_list") if row.get("key_number")]
    meta_gold_total = sum(
        to_num(row.get(f"cost_gold_var{index}"))
        for row in meta_rows
        for index in range(1, 6)
    )
    meta_hammer_total = sum(
        to_num(row.get(f"cost_hammer{index}"))
        for row in meta_rows
        for index in range(1, 6)
    )

    results = [
        simulate_segment(segment, const, tiers, item, wheel, gift)
        for segment in SEGMENTS
    ]

    output = {
        "source": {
            "spreadsheet": sheet_title,
            "spreadsheet_id": SPREADSHEET_ID,
            "read_date": "2026-04-23",
            "sheets_used": [
                "const",
                "level_entry_tier",
                "item_list",
                "daily_wheel",
                "daily_gift",
                "product",
                "meta_decoration_list",
            ],
        },
        "live_sheet_facts": {
            "nru_start_gold": const["nru_start_gold"],
            "idle_gold_formula": "min(1000 + floor(level / 20) * 300, 6000)",
            "daily_wheel_gold_ev_per_spin": sum(
                amount * rate for reward_item, amount, rate in wheel if reward_item == "currency_gold"
            )
            / 10000,
            "daily_wheel_limit": const["daily_wheel_ad_limit"],
            "shop_ad_gold": const["shop_ad_gold"],
            "shop_ad_limit": const["shop_ad_limit"],
            "meta_gold_total": meta_gold_total,
            "meta_hammer_total": meta_hammer_total,
            "collection_flags": {
                "is_album_collection_open": const.get("is_album_collection_open"),
                "is_deck_collection_open": const.get("is_deck_collection_open"),
            },
        },
        "model_notes": [
            "시트에는 유저 행동량이 없으므로 세그먼트별 플레이 횟수, 승률, RV 소진율, 부스터 사용률은 모델 입력값으로 둔다.",
            "인게임 클리어 보상 EV는 별도 카드 플레이 로그/공식이 필요해 이번 순환 모델에서는 제외했다.",
            "부스터 인벤토리 지급은 골드 환산하지 않고, 실제 골드 지갑 변동만 계산했다.",
        ],
        "segments": results,
    }
    OUT_PATH.write_text(json.dumps(output, ensure_ascii=False, indent=2), encoding="utf-8")

    print("WROTE", OUT_PATH)
    print("segment,level,entry,rv_claim,idle_claim,d30_source,d30_sink,d30_net,d30_avg_balance,p10,p50,p90")
    for row in results:
        d30 = row["d30"]
        print(
            ",".join(
                [
                    row["segment"],
                    str(row["level"]),
                    str(row["entry_cost"]),
                    str(row["rv_gold_per_claim"]),
                    str(row["idle_gold_per_claim"]),
                    str(d30["avg_source"]),
                    str(d30["avg_sink"]),
                    str(d30["avg_net"]),
                    str(d30["avg_balance"]),
                    str(d30["p10_balance"]),
                    str(d30["p50_balance"]),
                    str(d30["p90_balance"]),
                ]
            )
        )


if __name__ == "__main__":
    main()
