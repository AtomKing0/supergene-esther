#!/usr/bin/env python3
"""
PBB Notification Service CSV Generator
Reads existing PBB notification CSVs, finds the last scheduled date,
and generates new CSVs extending from the next day to Dec 31 of the following year.

Usage:
    python3 generate_pbb_notifications.py

Output:
    PBB Notification Service_new.csv   (daily, skip Saturdays)
    PBB Notification Service Weekly_new.csv  (weekly, every Saturday)
"""

import csv
import os
import re
from datetime import date, timedelta

# ── Config ────────────────────────────────────────────────────────────────────
SCRIPT_DIR   = os.path.dirname(os.path.abspath(__file__))
DAILY_BASE   = os.path.join(SCRIPT_DIR, "PBB Notification Service.csv")
WEEKLY_BASE  = os.path.join(SCRIPT_DIR, "PBB Notification Service Weekly.csv")
DAILY_NEW    = os.path.join(SCRIPT_DIR, "PBB Notification Service_new.csv")
WEEKLY_NEW   = os.path.join(SCRIPT_DIR, "PBB Notification Service Weekly_new.csv")
MEDIA_URL    = "https://d26ml67612e64s.cloudfront.net/block_blast/image/TOURNAMENT_END_MSG.jpg"

# ── Helpers ───────────────────────────────────────────────────────────────────

def label_to_date(label: str) -> date:
    """Parse an 8-digit (YYYYMMDD) or 6-digit (YYMMDD) label to a date."""
    if len(label) == 8:
        return date(int(label[:4]), int(label[4:6]), int(label[6:]))
    elif len(label) == 6:
        return date(2000 + int(label[:2]), int(label[2:4]), int(label[4:]))
    raise ValueError(f"Unrecognized label format: {label}")


def date_to_daily_label(d: date) -> str:
    return d.strftime("%Y%m%d")


def date_to_weekly_label(d: date) -> str:
    return d.strftime("%y%m%d")


def read_csv_rows(path: str):
    """Return (header, list_of_dicts) from a CSV file."""
    with open(path, newline="", encoding="utf-8") as f:
        reader = csv.DictReader(f)
        rows = list(reader)
    return reader.fieldnames, rows  # fieldnames captured before list exhausted


def read_csv_rows_with_header(path: str):
    with open(path, newline="", encoding="utf-8") as f:
        content = f.read()
    lines = content.splitlines()
    reader = csv.DictReader(lines)
    rows = list(reader)
    return list(reader.fieldnames if reader.fieldnames else rows[0].keys()), rows


def find_last_date_from_files(*paths) -> date | None:
    """Scan one or more CSV files and return the maximum label date found."""
    dates = []
    for path in paths:
        if not os.path.exists(path):
            continue
        with open(path, newline="", encoding="utf-8") as f:
            reader = csv.DictReader(f)
            for row in reader:
                label = row.get("label", "").strip()
                if re.fullmatch(r"\d{6}|\d{8}", label):
                    try:
                        dates.append(label_to_date(label))
                    except ValueError:
                        pass
    return max(dates) if dates else None


def make_payload(label: str) -> str:
    return f'{{"social":"A2U_BETA","type":"{label}"}}'


def build_row(label: str, template: dict, fieldnames: list) -> dict:
    """
    Build a new CSV row for the given label using a template row.
    Preserves all multilingual title/body columns verbatim from the template.
    """
    row = {}
    for col in fieldnames:
        if col == "label":
            row[col] = label
        elif col == "media_url":
            row[col] = MEDIA_URL
        elif col == "payload":
            row[col] = make_payload(label)
        else:
            # All notification_title_* and notification_body_* columns
            row[col] = template.get(col, "")
    return row


def write_csv(path: str, fieldnames: list, rows: list):
    with open(path, "w", newline="", encoding="utf-8") as f:
        writer = csv.DictWriter(f, fieldnames=fieldnames, quoting=csv.QUOTE_MINIMAL)
        writer.writeheader()
        writer.writerows(rows)
    print(f"  Written: {path} ({len(rows)} rows)")


# ── Main ──────────────────────────────────────────────────────────────────────

def generate_daily(last_date: date, target_end: date):
    """Generate daily (non-Saturday) notifications from day after last_date to target_end."""
    print("\n[Daily]")
    fieldnames, templates = read_csv_rows_with_header(DAILY_BASE)

    # Strip header row if it leaked into templates
    templates = [r for r in templates if r.get("label", "").strip() != "label"]
    print(f"  Templates loaded: {len(templates)}")

    start = last_date + timedelta(days=1)
    print(f"  Generating from {start} to {target_end} (skipping Saturdays)")

    new_rows = []
    tmpl_idx = 0
    d = start
    while d <= target_end:
        if d.weekday() != 5:  # 5 = Saturday
            label = date_to_daily_label(d)
            tmpl  = templates[tmpl_idx % len(templates)]
            new_rows.append(build_row(label, tmpl, fieldnames))
            tmpl_idx += 1
        d += timedelta(days=1)

    print(f"  Rows to write: {len(new_rows)}")
    write_csv(DAILY_NEW, fieldnames, new_rows)
    return new_rows[-1]["label"] if new_rows else None


def generate_weekly(last_date: date, target_end: date):
    """Generate weekly (Saturday only) notifications from the first Saturday after last_date."""
    print("\n[Weekly]")
    fieldnames, templates = read_csv_rows_with_header(WEEKLY_BASE)
    templates = [r for r in templates if r.get("label", "").strip() != "label"]
    print(f"  Templates loaded: {len(templates)}")

    # Find first Saturday strictly after last_date
    start = last_date + timedelta(days=1)
    while start.weekday() != 5:
        start += timedelta(days=1)
    print(f"  Generating from {start} to {target_end} (Saturdays only)")

    new_rows = []
    tmpl_idx = 0
    d = start
    while d <= target_end:
        label = date_to_weekly_label(d)
        tmpl  = templates[tmpl_idx % len(templates)]
        new_rows.append(build_row(label, tmpl, fieldnames))
        tmpl_idx += 1
        d += timedelta(weeks=1)

    print(f"  Rows to write: {len(new_rows)}")
    write_csv(WEEKLY_NEW, fieldnames, new_rows)
    return new_rows[-1]["label"] if new_rows else None


def main():
    print("=" * 60)
    print("PBB Notification CSV Generator")
    print("=" * 60)

    # ── 1. Find last scheduled dates ─────────────────────────────
    print("\n[Finding last dates in existing files...]")
    daily_last  = find_last_date_from_files(DAILY_BASE, DAILY_NEW)
    weekly_last = find_last_date_from_files(WEEKLY_BASE, WEEKLY_NEW)
    print(f"  Daily  last date: {daily_last}")
    print(f"  Weekly last date: {weekly_last}")

    if daily_last is None:
        print("ERROR: Could not find any daily dates. Check that the base CSV exists.")
        return
    if weekly_last is None:
        print("ERROR: Could not find any weekly dates. Check that the base CSV exists.")
        return

    # ── 2. Determine target end date: Dec 31 of next year ────────
    # "Next year" relative to the LATER of the two last dates
    reference_year = max(daily_last.year, weekly_last.year)
    target_end = date(reference_year + 1, 12, 31)
    print(f"\n  Reference year : {reference_year}")
    print(f"  Target end date: {target_end}")

    # ── 3. Generate ───────────────────────────────────────────────
    daily_last_new  = generate_daily(daily_last, target_end)
    weekly_last_new = generate_weekly(weekly_last, target_end)

    # ── 4. Summary ────────────────────────────────────────────────
    print("\n" + "=" * 60)
    print("Done!")
    print(f"  Daily  new file: {DAILY_NEW}")
    print(f"  Weekly new file: {WEEKLY_NEW}")
    print(f"  Daily  last label in new file : {daily_last_new}")
    print(f"  Weekly last label in new file : {weekly_last_new}")
    print("=" * 60)
    print("\nNext steps:")
    print("  1. Upload both new CSV files to Facebook Instant Games Notification Service.")
    print("     (Drag & drop each file onto the upload zone in the Facebook dashboard.)")
    print("  2. Run the bulk schedule-date update via the GraphQL API (see scheduled task).")
    print("  3. Activation is handled by a separate scheduler.")


if __name__ == "__main__":
    main()
