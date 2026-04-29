#!/usr/bin/env python3
"""
apply-selections.py
───────────────────
docs/sound-selections.json 읽어서 선택된 테마 파일을
게임 클라이언트 sound 번들에 복사합니다.

_01~_03 그룹 처리:
  - 그룹 내 어느 항목이든 선택되면 전체 그룹에 동일 테마 적용
  - 선택 테마에 해당 _02/_03 파일이 없으면 _01 파일로 대체 복사
  - TIKI .ogg 파일은 .wav로 변환 후 복사 (ffmpeg 필요)

사용법:
  python3 docs/apply-selections.py [--dry-run]
"""

import json, os, shutil, subprocess, sys
from pathlib import Path

ROOT         = Path(__file__).parent.parent
SEL_JSON     = ROOT / 'docs' / 'sound-selections.json'
CC_DIR       = ROOT / 'audio_sets' / 'cc'
SGH_DIR      = ROOT / 'audio_sets' / 'sgh'
TIKI_DIR     = ROOT / 'audio_sets' / 'tiki'
REC_DIR      = ROOT / 'audio_sets' / 'rec'
SELECTED_DIR = ROOT / 'audio_sets' / 'selected'
CLIENT       = Path('/Users/estherpark/solitaire-tripeaks-client/assets/bundles/sound')

DRY_RUN = '--dry-run' in sys.argv

# _01~_03 그룹 정의
GROUPS = [
    ['FX_CARD_DRAWN_01',  'FX_CARD_DRAWN_02',  'FX_CARD_DRAWN_03'],
    ['FX_CARD_PLAYED_01', 'FX_CARD_PLAYED_02', 'FX_CARD_PLAYED_03'],
    ['FX_CARD_TAPPED_01', 'FX_CARD_TAPPED_02', 'FX_CARD_TAPPED_03'],
    ['FX_BOOSTER_FIREWORKS_APPEAR_01',  'FX_BOOSTER_FIREWORKS_APPEAR_02',  'FX_BOOSTER_FIREWORKS_APPEAR_03'],
    ['FX_BOOSTER_FIREWORKS_EXPLODE_01', 'FX_BOOSTER_FIREWORKS_EXPLODE_02', 'FX_BOOSTER_FIREWORKS_EXPLODE_03'],
    ['FX_BOOSTER_GOLDEN_TICKET_TAP_01', 'FX_BOOSTER_GOLDEN_TICKET_TAP_02', 'FX_BOOSTER_GOLDEN_TICKET_TAP_03'],
    ['FX_COIN_FLY_01',  'FX_COIN_FLY_02',  'FX_COIN_FLY_03'],
    ['FX_COIN_HIT_01',  'FX_COIN_HIT_02',  'FX_COIN_HIT_03'],
    ['FX_REWARD_WHEEL_TICK_01', 'FX_REWARD_WHEEL_TICK_02', 'FX_REWARD_WHEEL_TICK_03'],
]
GROUP_MAP = {}  # name → group list
for g in GROUPS:
    for n in g:
        GROUP_MAP[n] = g

TIKI_EXTS = {
    'BGM_INGAME':'ogg','FX_BOOSTER_FIREWORKS_APPEAR_01':'ogg','FX_BOOSTER_FIREWORKS_EXPLODE_01':'ogg',
    'FX_BOOSTER_FIREWORKS_EXPLODE_02':'wav','FX_BOOSTER_FIREWORKS_EXPLODE_03':'ogg',
    'FX_BOOSTER_GOLDEN_TICKET_ACTIVATED':'ogg','FX_BOOSTER_GOLDEN_TICKET_TAP_01':'ogg',
    'FX_CARD_DEAL_END':'ogg','FX_CARD_DEAL_LOOP':'ogg','FX_CARD_DRAWN_01':'ogg',
    'FX_CARD_FLY_OUT':'ogg','FX_CARD_LAST_PLAYED':'ogg','FX_CARD_MISSED':'ogg',
    'FX_CARD_PLAYED_01':'wav','FX_CARD_PLUS_CARDS':'wav','FX_CARD_REVEALED':'ogg',
    'FX_CARD_TAPPED_01':'ogg','FX_CARD_WILD_TRIGGERED':'ogg','FX_COIN_BURST':'wav',
    'FX_COIN_FLY_01':'wav','FX_COIN_HIT_01':'wav','FX_COIN_HIT_02':'ogg',
    'FX_COIN_MOVE':'ogg','FX_COIN_SPENT':'ogg','FX_EVENT_GOLDEN_SHIMMER':'ogg',
    'FX_EVENT_LEADERBOARD_CHANGE':'ogg','FX_EVENT_LEADERBOARD_IN':'wav',
    'FX_GIMMICK_GATE_CLOSE':'ogg','FX_GIMMICK_GATE_OPEN':'ogg','FX_GIMMICK_GATE_REMOVE':'ogg',
    'FX_GIMMICK_KEY_ACTIVATE':'wav','FX_GIMMICK_ROPE_REMOVED':'ogg','FX_GIMMICK_RUNNER_MOVE':'wav',
    'FX_REWARD_BOX_FLIES_IN':'wav','FX_REWARD_BOX_OPEN':'ogg','FX_REWARD_CLEAR':'ogg',
    'FX_REWARD_CONFETTI_LOOP':'ogg','FX_REWARD_DAILY_CLAIMED':'ogg','FX_REWARD_GAUGE_FILL':'ogg',
    'FX_REWARD_ITEM_FLIES':'ogg','FX_REWARD_STAR_BURST':'ogg',
    'FX_REWARD_WHEEL_TICK_01':'wav','FX_REWARD_WHEEL_TICK_02':'wav','FX_REWARD_WHEEL_TICK_03':'ogg',
    'FX_SLIDE':'ogg','FX_SPIN_REWARD':'ogg','FX_STREAK_BAR_DETRACTS':'ogg',
    'FX_STREAK_BAR_EXTENDS':'ogg','FX_STREAK_COMPLETED':'ogg','FX_STREAK_MULTIPLIER_IN':'ogg',
    'FX_STREAK_MULTIPLIER_OUT':'ogg','FX_STREAK_SLOT_FILLED':'ogg','FX_STREAK_SLOT_REMOVED':'ogg',
    'FX_UI_BTN_RELEASE':'ogg','FX_UI_BTN_TAP':'wav','FX_UI_BTN_WOOD_RELEASE':'wav',
    'FX_UI_BTN_WOOD_TAP':'wav','FX_UI_ITEM_TAP':'ogg','FX_UI_LOCKED_TAP':'ogg',
    'FX_UI_LOGO':'ogg','FX_UI_NOTIFICATION':'ogg','FX_UI_POPUP_IN':'ogg',
    'FX_UI_POPUP_OUT':'ogg','FX_UI_TOOLTIP_IN':'ogg',
    'FX_META_DECO_PLACE':'wav','FX_UI_SCREENSHOT':'wav','FX_DAILY_TASK_SWAP':'ogg',
    'FX_REWARD_SMALL_BOX_OPEN':'wav','FX_REWARD_BIG_BOX_OPEN':'wav',
    'FX_ITEM_HIT':'wav','FX_EVENT_REWARD_CLAIMED':'wav',
}


def find_source(name, theme):
    """테마 폴더에서 파일 찾기. 없으면 None."""
    if theme == 'cc':
        p = CC_DIR / f'{name}.wav'
        return p if p.exists() else None
    if theme == 'sgh':
        p = SGH_DIR / f'{name}.wav'
        return p if p.exists() else None
    if theme == 'tiki':
        ext = TIKI_EXTS.get(name)
        if not ext:
            return None
        p = TIKI_DIR / f'{name}.{ext}'
        return p if p.exists() else None
    if theme == 'rec':
        p = REC_DIR / f'{name}.wav'
        return p if p.exists() else None
    if theme == 'rec2':
        p = REC_DIR / f'{name}_2.wav'
        return p if p.exists() else None
    if theme == 'rec3':
        p = REC_DIR / f'{name}_3.wav'
        return p if p.exists() else None
    if theme == 'rec4':
        p = REC_DIR / f'{name}_4.wav'
        return p if p.exists() else None
    return None


def to_wav(src: Path, dest: Path, extra: Path = None):
    """ffmpeg로 ogg→wav 변환. 이미 wav면 그냥 복사. extra 경로에도 동시 저장."""
    if src.suffix.lower() == '.wav':
        if not DRY_RUN:
            shutil.copy2(src, dest)
            if extra:
                shutil.copy2(src, extra)
        print(f'  copy  {src.name} → {dest.name}')
    else:
        print(f'  conv  {src.name} → {dest.name}  (ogg→wav)')
        if not DRY_RUN:
            subprocess.run(['ffmpeg', '-y', '-i', str(src), str(dest)], check=True, capture_output=True)
            if extra:
                shutil.copy2(dest, extra)


def apply_sound(name, theme, source_override=None):
    """클라이언트 + selected 폴더에 파일 적용."""
    src = source_override or find_source(name, theme)
    if src is None:
        print(f'  [SKIP] {name} — {theme} 파일 없음')
        return False
    dest = CLIENT / f'{name}.wav'
    extra = SELECTED_DIR / f'{name}.wav'
    to_wav(src, dest, extra=extra)
    return True


def remove_sound(name):
    """클라이언트에서 파일 삭제 (.meta는 유지)."""
    dest = CLIENT / f'{name}.wav'
    if dest.exists():
        print(f'  del   {name}.wav')
        if not DRY_RUN:
            dest.unlink()
        return True
    return False


def compress_client():
    """클라이언트 번들 전체 압축: BGM stereo 22050Hz 85vol / SFX mono 22050Hz."""
    print('\n─── 압축 (22050Hz) ───')
    for f in sorted(CLIENT.glob('*.wav')):
        name = f.stem
        tmp = Path(f'/tmp/{name}_cmp.wav')
        is_bgm = name.startswith('BGM_')
        if is_bgm:
            cmd = ['ffmpeg', '-y', '-i', str(f), '-ar', '22050', '-ac', '2',
                   '-af', 'volume=0.85', str(tmp)]
        else:
            cmd = ['ffmpeg', '-y', '-i', str(f), '-ar', '22050', '-ac', '1', str(tmp)]
        subprocess.run(cmd, check=True, capture_output=True)
        tmp.replace(f)
        print(f'  {"BGM" if is_bgm else "SFX"}  {f.name}')
    size = sum(f.stat().st_size for f in CLIENT.glob('*.wav'))
    print(f'  총 용량: {size / 1024 / 1024:.1f} MB')


def main():
    if not SEL_JSON.exists():
        print('❌ sound-selections.json 없음. 브라우저에서 먼저 저장하세요.')
        sys.exit(1)

    with open(SEL_JSON, encoding='utf-8') as f:
        data = json.load(f)

    if DRY_RUN:
        print('=== DRY RUN (실제 파일 변경 없음) ===\n')
    else:
        SELECTED_DIR.mkdir(parents=True, exist_ok=True)
        print(f'selected 폴더: {SELECTED_DIR}\n')

    sel_map   = {row['name']: row.get('selected') for row in data}
    done      = set()
    ok        = 0
    skipped   = 0
    removed   = []   # 미선택 → 클라이언트 파일 삭제

    # ── 1. 선택된 항목 적용 ──────────────────────────────────
    print('─── 테마 적용 ───')
    for name, theme in sel_map.items():
        if not theme or name in done:
            continue
        print(f'\n[적용] {name}  →  {theme.upper()}')
        r = apply_sound(name, theme)
        if r: ok += 1
        else: skipped += 1
        done.add(name)

    # ── 2. 미선택 항목 → 파일 삭제 ──────────────────────────
    print('\n─── 미선택 항목 삭제 ───')
    for name, theme in sel_map.items():
        if theme or name in done:
            continue
        r = remove_sound(name)
        if r:
            removed.append({'name': name, 'reason': '선택 없음'})
        done.add(name)

    # ── 3. 결과 출력 ─────────────────────────────────────────
    print(f'\n{"=== 완료 ===" if not DRY_RUN else "=== DRY RUN 완료 ==="}')
    print(f'  적용: {ok}개  /  삭제: {len(removed)}개  /  스킵: {skipped}개')

    # ── 4. 개발자 리포트 ──────────────────────────────────────
    dev_items = []
    if removed:
        print(f'\n🗑️  [개발자] 클라이언트에서 제거된 파일 ({len(removed)}개):')
        for r in removed:
            print(f'  {r["name"]}')
            dev_items.append({'type': 'removed', **r})

    if dev_items and not DRY_RUN:
        report_path = ROOT / 'docs' / 'developer-notes.json'
        with open(report_path, 'w', encoding='utf-8') as f:
            json.dump(dev_items, f, ensure_ascii=False, indent=2)
        print(f'\n  → {report_path} 저장 완료 (개발자에게 전달)')

    # ── 5. 압축 ───────────────────────────────────────────────
    if not DRY_RUN:
        compress_client()


if __name__ == '__main__':
    main()
