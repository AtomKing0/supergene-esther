#!/usr/bin/env python3
"""
catalog_search.py
Unity Addressable 카탈로그(catalog.json)에서 키워드로 에셋을 검색합니다.

사용법:
  python3 scripts/catalog_search.py KEYWORD
  python3 scripts/catalog_search.py OnFire Betup Streak     # 여러 키워드 (OR 검색)
  python3 scripts/catalog_search.py --settings              # Settings.asset 전체 목록
  python3 scripts/catalog_search.py --economy               # 경제 관련 에셋 분류 출력
  python3 scripts/catalog_search.py --offers                # 오퍼/IAP 관련 에셋
  python3 scripts/catalog_search.py --events                # 라이브 이벤트 에셋
  python3 scripts/catalog_search.py --boosters              # 부스터 관련 에셋
  python3 scripts/catalog_search.py --folders               # 최상위 AddressableResources 폴더 목록
"""

import json
import sys
import os
from pathlib import Path

# 경로 설정
SCRIPT_DIR = Path(__file__).parent
PROJECT_ROOT = SCRIPT_DIR.parent
CATALOG_PATH = PROJECT_ROOT / "decompiled_java/resources/assets/aa/catalog.json"


def load_catalog():
    with open(CATALOG_PATH, encoding="utf-8") as f:
        data = json.load(f)
    return data.get("m_InternalIds", [])


def search(ids, keywords, case_sensitive=False):
    """키워드 OR 검색. 결과 정렬 반환."""
    results = []
    for item in ids:
        s = str(item)
        target = s if case_sensitive else s.lower()
        if any((k if case_sensitive else k.lower()) in target for k in keywords):
            results.append(s)
    return sorted(results)


def print_section(title, items, limit=None):
    count = len(items)
    display = items[:limit] if limit else items
    print(f"\n=== {title} ({count}개) ===")
    for item in display:
        print(f"  {item}")
    if limit and count > limit:
        print(f"  ... 외 {count - limit}개")


def mode_settings(ids):
    """Settings.asset 파일 전체 목록"""
    hits = [x for x in ids if "Settings.asset" in x]
    print_section("Settings.asset 전체 목록", sorted(hits))


def mode_economy(ids):
    """경제 시스템 관련 에셋 분류"""
    categories = {
        "Betup": ["Betup", "betup"],
        "OnFire": ["OnFire", "onfire"],
        "PiggyBank": ["Piggy", "piggy"],
        "StreakStar": ["Streak", "streak", "StarBurst"],
        "Coins & Currency": ["Coin", "coin", "Currency"],
        "FreeEntry": ["FreeEntry", "freeentry"],
        "TLB(보상 테이블)": ["TLB", "tlb"],
        "EntryCost": ["EntryCost", "entrycost"],
    }
    for label, kws in categories.items():
        hits = search(ids, kws)
        print_section(label, hits, limit=20)


def mode_offers(ids):
    """오퍼 & IAP 관련 에셋"""
    kws = ["Offer", "offer", "Bundle", "bundle", "Pack", "pack", "Shop", "shop",
           "Bonsai", "Purchase", "ConversionPack", "Cascading"]
    hits = search(ids, kws)
    # 폴더 단위로 그룹핑
    folders = {}
    for item in hits:
        parts = item.split("/")
        folder = parts[2] if len(parts) > 2 else "기타"
        folders.setdefault(folder, []).append(item)
    for folder, items in sorted(folders.items()):
        print_section(f"[Offer] {folder}", items, limit=10)


def mode_events(ids):
    """라이브 이벤트 에셋 분류"""
    events = {
        "BubbleGum": ["Bubblegum", "BubbleGum"],
        "CatchTheTroll": ["CatchTheTroll", "catchthetroll"],
        "DiceRoll": ["DiceRoll", "diceroll"],
        "DiggingEvent": ["Digging", "digging"],
        "EpisodeChase": ["EpisodeChase"],
        "EpisodeRace": ["EpisodeRace"],
        "GlobeTrotting": ["GlobeTrotting", "globetrotting"],
        "StickerCollection": ["Sticker", "sticker"],
        "PostcardEvent": ["Postcard", "postcard"],
        "SeasonPass": ["SeasonPass", "seasonpass"],
        "Cup/Tournament": ["Cup", "Tournament", "tournament"],
        "TowerOfFortune": ["TowerOfFortune"],
        "TugOfCards": ["TugOf"],
        "HiLoHustle": ["HiLo", "HiLoHustle"],
        "FriendOMeter": ["FriendO", "FriendOMeter"],
        "AlbumsCollection": ["Albums", "album"],
        "CardBack": ["CardBack"],
        "WinStreak/OnFire": ["WinStreak", "OnFire"],
    }
    for label, kws in events.items():
        hits = search(ids, kws)
        if hits:
            print_section(f"[이벤트] {label}", hits, limit=8)


def mode_boosters(ids):
    """부스터 관련 에셋"""
    kws = ["Booster", "booster", "Colorbomb", "Lollipop", "Stickyhand", "UFO", "ufo",
           "plus1", "plus2", "plus3", "plus4", "plus5", "wildcard", "WildCard"]
    hits = search(ids, kws)
    print_section("부스터 에셋 전체", hits)


def mode_folders(ids):
    """AddressableResources 하위 최상위 폴더 목록"""
    folders = set()
    for item in ids:
        if "AddressableResources/" in item:
            rest = item.split("AddressableResources/", 1)[1]
            folder = rest.split("/")[0]
            folders.add(folder)
    print_section("AddressableResources 최상위 폴더", sorted(folders))


def mode_keyword(ids, keywords):
    """키워드 OR 검색"""
    hits = search(ids, keywords)
    label = " | ".join(keywords)
    print_section(f"검색: {label}", hits)
    print(f"\n총 {len(hits)}개 항목 발견.")


def main():
    if not CATALOG_PATH.exists():
        print(f"[ERROR] catalog.json을 찾을 수 없습니다: {CATALOG_PATH}")
        sys.exit(1)

    ids = load_catalog()
    print(f"[INFO] catalog.json 로드 완료 — 전체 {len(ids)}개 항목")

    args = sys.argv[1:]

    if not args or args[0] in ("-h", "--help"):
        print(__doc__)
        return

    if args[0] == "--settings":
        mode_settings(ids)
    elif args[0] == "--economy":
        mode_economy(ids)
    elif args[0] == "--offers":
        mode_offers(ids)
    elif args[0] == "--events":
        mode_events(ids)
    elif args[0] == "--boosters":
        mode_boosters(ids)
    elif args[0] == "--folders":
        mode_folders(ids)
    else:
        mode_keyword(ids, args)


if __name__ == "__main__":
    main()
