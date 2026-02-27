#!/usr/bin/env python3
"""
deep_dive.py
특정 테마에 대해 catalog.json에서 심층 분석을 수행합니다.
이전 세션에서 진행한 분석 패턴을 재현 가능한 스크립트로 정리.

사용법:
  python3 scripts/deep_dive.py betup        # Betup 배율 상세 분석
  python3 scripts/deep_dive.py onfire       # OnFire 단계 분석
  python3 scripts/deep_dive.py piggybank    # PiggyBank 구조 분석
  python3 scripts/deep_dive.py shop         # 숍 가격대 분석
  python3 scripts/deep_dive.py currency     # 재화 관련 에셋 전체
  python3 scripts/deep_dive.py iap          # IAP 관련 에셋
  python3 scripts/deep_dive.py summary      # 핵심 지표 요약 (대시보드)
"""

import json
import sys
import re
from pathlib import Path

SCRIPT_DIR = Path(__file__).parent
PROJECT_ROOT = SCRIPT_DIR.parent
CATALOG_PATH = PROJECT_ROOT / "decompiled_java/resources/assets/aa/catalog.json"


def load_ids():
    with open(CATALOG_PATH, encoding="utf-8") as f:
        data = json.load(f)
    return data.get("m_InternalIds", [])


def section(title, items, limit=None):
    count = len(items)
    display = items[:limit] if limit else items
    print(f"\n{'─'*60}")
    print(f"  {title}  ({count}개)")
    print(f"{'─'*60}")
    for item in display:
        print(f"  {item}")
    if limit and count > limit:
        print(f"  ··· 외 {count - limit}개")


# ── 분석 함수들 ────────────────────────────────────────────────

def analyze_betup(ids):
    """Betup 배율 구조 심층 분석"""
    print("\n🎰 BETUP 배율 분석")

    # 배율 추출
    multipliers = set()
    for item in ids:
        m = re.search(r'[Bb]etup[_\-]?x?(\d+)', str(item))
        if m:
            multipliers.add(int(m.group(1)))

    print(f"\n  확정 배율: {sorted(multipliers)}")
    print(f"  → x1 / x2 / x4 / x8  4단계 구조")

    for mult in sorted(multipliers):
        assets = [x for x in ids if f'etup' in x and (f'_{mult}' in x or f'x{mult}' in x.lower())]
        section(f"Betup ×{mult} 에셋", assets)


def analyze_onfire(ids):
    """OnFire 단계 구조 심층 분석"""
    print("\n🔥 OnFire 단계 분석")

    tiers = {}
    for item in ids:
        m = re.search(r'[Oo]n[Ff]ire.*tier[_\-]?(\d)', str(item))
        if m:
            t = int(m.group(1))
            tiers.setdefault(t, []).append(item)

    for t in sorted(tiers):
        section(f"OnFire Tier {t}", tiers[t])

    # 상태 분석 (normal vs open)
    normal = [x for x in ids if 'onfire' in x.lower() and 'normal' in x.lower()]
    open_  = [x for x in ids if 'onfire' in x.lower() and 'open'   in x.lower()]
    print(f"\n  normal 상태 에셋: {len(normal)}개")
    print(f"  open   상태 에셋: {len(open_)}개")
    print(f"  → 각 Tier당 2상태 (미충족/충족) 구조")

    # Betup x8과의 연결
    x8_in_onfire = [x for x in ids if 'OnFire' in x and 'x8' in x.lower()]
    if x8_in_onfire:
        print(f"\n  OnFire 폴더 내 x8 에셋:")
        for a in x8_in_onfire:
            print(f"    {a}")
        print(f"  → Tier 3 달성 시 Betup x8 해제 구조 확정")


def analyze_piggybank(ids):
    """PiggyBank 단계 구조 심층 분석"""
    print("\n🐷 PiggyBank 구조 분석")

    piggy = [x for x in ids if 'piggy' in x.lower() or 'Piggy' in x]

    # 단계 분류
    stage_map = {}
    for item in piggy:
        for s in ['01', '02', '03', '1', '2', '3']:
            if s in item:
                stage_map.setdefault(s, []).append(item)
                break

    # 상태 분류
    for label, kws in [("기본(default)", ["default"]), ("jade", ["jade"]), ("gold", ["gold"])]:
        hits = [x for x in piggy if any(k in x.lower() for k in kws)]
        if hits:
            print(f"\n  [{label}]")
            for h in hits:
                print(f"    {h}")

    section("PiggyBank 전체 에셋", piggy)


def analyze_shop(ids):
    """숍 가격대 심층 분석"""
    print("\n🛒 숍 가격대 분석")

    prices = re.findall(r'\$?(\d+\.\d{2})', ' '.join(ids))
    price_counter = {}
    for p in prices:
        price_counter[p] = price_counter.get(p, 0) + 1

    print(f"\n  발견된 가격대:")
    for price, count in sorted(price_counter.items(), key=lambda x: float(x[0])):
        bar = "█" * min(count, 20)
        print(f"    ${price:>6}  {bar} ({count}개 에셋)")

    # 가격 별 에셋
    for price in sorted(price_counter.keys(), key=float):
        hits = [x for x in ids if price in x]
        section(f"${price} 관련 에셋", hits)


def analyze_currency(ids):
    """재화 관련 에셋 전체"""
    print("\n💰 재화 에셋 분류")
    cats = {
        "Coins":      ["Coin", "coin", "Gold", "gold"],
        "Energy":     ["Energy", "energy"],
        "StreakStar":  ["Streak", "streak", "Star"],
        "FreeEntry":  ["FreeEntry", "freeentry", "FreeTicket"],
        "PiggyBank":  ["Piggy", "piggy"],
    }
    for label, kws in cats.items():
        hits = [x for x in ids if any(k in x for k in kws)]
        section(label, hits, limit=15)


def analyze_iap(ids):
    """IAP 관련 에셋"""
    print("\n💳 IAP / 오퍼 관련 에셋")

    cats = {
        "코인 팩":    ["SoftCurrency", "softcurrency"],
        "HardCurrency": ["HardCurrency", "hardcurrency"],
        "Energy IAP": ["OneEnergy", "RefillEnergy", "UnlimitedEnergy"],
        "부스터 IAP": ["PreLevelBooster", "BoosterShovel", "BoosterShuffle"],
        "건물 잠금 해제": ["FarmHouseUnlock", "BeehiveUnlock", "ChickenCoop",
                        "CornField", "CowPasture", "HerbPatch", "WellUnlock",
                        "WindmillUnlock", "BuildingUnlock"],
        "레시피 잠금 해제": ["RecipeGroup", "RecipeUnlock"],
        "특별 오퍼": ["1Plus12", "Bazaar", "BuyThemAll", "HardLevel", "SML",
                    "GenericOffer", "ConversionPack", "Cascading"],
    }
    for label, kws in cats.items():
        hits = [x for x in ids if any(k in x for k in kws)]
        section(label, hits, limit=12)


def analyze_summary(ids):
    """핵심 지표 요약 대시보드"""
    print("\n" + "═"*60)
    print("  📊 Candy Solitaire 경제 시스템 분석 요약 대시보드")
    print("═"*60)

    metrics = [
        ("전체 에셋",     len(ids),                                          "개"),
        ("Settings 파일", len([x for x in ids if 'Settings.asset' in x]),   "개"),
        ("이벤트 에셋",   len([x for x in ids if 'Event' in x or 'event' in x]), "개"),
        ("Offer 에셋",    len([x for x in ids if 'Offer' in x or 'offer' in x]), "개"),
        ("OnFire 에셋",   len([x for x in ids if 'OnFire' in x]),            "개"),
        ("Betup 에셋",    len([x for x in ids if 'Betup' in x or 'betup' in x]), "개"),
        ("PiggyBank 에셋",len([x for x in ids if 'Piggy' in x or 'piggy' in x]), "개"),
    ]

    for label, val, unit in metrics:
        print(f"  {label:<20}: {val:>5} {unit}")

    print("\n  ── 확정 발견사항 ──────────────────────────────────")

    # Betup 배율 확인
    mults = set(int(m.group(1)) for x in ids for m in [re.search(r'[Bb]etup[_\-]?x?(\d+)', x)] if m)
    print(f"  Betup 배율    : ×{sorted(mults)} → 4단계 확정" if mults else "  Betup 배율    : 확인 불가")

    # OnFire 단계 확인
    tiers = set(int(m.group(1)) for x in ids for m in [re.search(r'onfire.*tier[_\-]?(\d)', x.lower())] if m)
    print(f"  OnFire 단계   : Tier {sorted(tiers)} → {len(tiers)}단계" if tiers else "  OnFire 단계   : 확인 불가")

    # PiggyBank 단계
    pg_imgs = [x for x in ids if re.search(r'piggybank_0?[123]\.png', x.lower())]
    print(f"  PiggyBank 단계: {len(pg_imgs)}단계 확인 ({', '.join(pg_imgs[:3])})")

    # 가격대
    prices = sorted(set(re.findall(r'(\d+\.\d{2})', ' '.join(ids))), key=float)
    print(f"  숍 가격대     : {len(prices)}단계 — ${prices[0]} ~ ${prices[-1]}" if prices else "  숍 가격대     : 확인 불가")

    print("\n  ── 미결 사항 (실기기 필요) ────────────────────────")
    pending = [
        "CoinRewardTLB 실제 수치",
        "레벨별 EntryCost",
        "StreakMultiplier 배율 범위",
        "OnFire Tier 달성 연승 수",
        "PiggyBank 누적 한도",
        "부스터 Coins 가격",
    ]
    for p in pending:
        print(f"  ⚠️  {p}")

    print("\n" + "═"*60)


# ── 메인 ────────────────────────────────────────────────────────

MODES = {
    "betup":     analyze_betup,
    "onfire":    analyze_onfire,
    "piggybank": analyze_piggybank,
    "shop":      analyze_shop,
    "currency":  analyze_currency,
    "iap":       analyze_iap,
    "summary":   analyze_summary,
}


def main():
    if not CATALOG_PATH.exists():
        print(f"[ERROR] catalog.json 없음: {CATALOG_PATH}")
        sys.exit(1)

    ids = load_ids()
    arg = sys.argv[1].lower() if len(sys.argv) > 1 else "summary"

    if arg in ("-h", "--help"):
        print(__doc__)
        return

    fn = MODES.get(arg)
    if fn:
        fn(ids)
    else:
        print(f"[ERROR] 알 수 없는 모드: {arg}")
        print(f"사용 가능한 모드: {', '.join(MODES.keys())}")
        sys.exit(1)


if __name__ == "__main__":
    main()
