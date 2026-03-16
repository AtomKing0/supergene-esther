"""
맵 난이도 SCORE 시스템
세 지표를 가중합하여 0~100 점수를 산출하고 권장 난이도를 반환한다.

지표:
  - max_depth   : 필드 카드 중 최대 depth 값 (층수)
  - card_count  : 필드 카드 수
  - deck_ratio  : clearRandomCardCount / randomCardCount (높을수록 어려움)

가중치:
  - depth  0.20
  - cards  0.30
  - deck   0.50  ← 가장 강한 구분자

정규화 기준값 (실측 분포 기반):
  - depth : 1~15
  - cards : 10~40
  - deck  : 0.30~0.90
"""

import json
import os

# ── 가중치 ────────────────────────────────────────────────────
WEIGHTS = {
    'depth': 0.20,
    'cards': 0.30,
    'deck':  0.50,
}

# ── 정규화 범위 ────────────────────────────────────────────────
RANGES = {
    'depth': (1,    15),
    'cards': (10,   40),
    'deck':  (0.30, 0.90),
}

# ── 난이도 임계값 (score → 권장 난이도) ─────────────────────────
THRESHOLDS = [
    (0,  28,  'VeryEasy'),
    (28, 40,  'Easy'),
    (40, 56,  'Normal'),
    (56, 65,  'Hard'),
    (65, 100, 'VeryHard'),
]


def _norm(val, lo, hi):
    """0~100 으로 클리핑 정규화"""
    return max(0.0, min(1.0, (val - lo) / (hi - lo))) * 100


def compute_score(card_count: int, max_depth: int, deck_ratio: float) -> float:
    """
    Parameters
    ----------
    card_count : 필드 카드 수 (isDrawCard=False 인 카드만)
    max_depth  : 필드 카드의 최대 depth 값
    deck_ratio : clearRandomCardCount / randomCardCount

    Returns
    -------
    score : float 0~100  (높을수록 어려움)
    """
    d = _norm(max_depth,  *RANGES['depth'])
    c = _norm(card_count, *RANGES['cards'])
    r = _norm(deck_ratio, *RANGES['deck'])
    return round(WEIGHTS['depth'] * d + WEIGHTS['cards'] * c + WEIGHTS['deck'] * r, 2)


def suggest_difficulty(score: float) -> str:
    for lo, hi, label in THRESHOLDS:
        if lo <= score < hi:
            return label
    return 'VeryHard'


def score_file(path: str) -> dict:
    """JSON 파일 하나를 읽어 점수를 계산한다."""
    with open(path, encoding='utf-8') as f:
        data = json.load(f)

    field_cards = [c for c in json.loads(data['stage']['map']) if not c.get('isDrawCard')]
    card_count = len(field_cards)
    max_depth  = max((c['depth'] for c in field_cards), default=0)

    rc = data.get('randomCardCount', 0)
    cr = data.get('clearRandomCardCount', 0)
    deck_ratio = cr / rc if rc > 0 else 0.0

    score = compute_score(card_count, max_depth, deck_ratio)
    return {
        'file':       os.path.basename(path),
        'card_count': card_count,
        'max_depth':  max_depth,
        'deck_ratio': round(deck_ratio, 3),
        'score':      score,
        'suggested':  suggest_difficulty(score),
        'current':    os.path.basename(os.path.dirname(path)),
    }


# ── CLI ───────────────────────────────────────────────────────
if __name__ == '__main__':
    import sys, glob, statistics

    if len(sys.argv) > 1:
        # 특정 파일/폴더 지정
        targets = sys.argv[1:]
        results = []
        for t in targets:
            if os.path.isfile(t):
                results.append(score_file(t))
            elif os.path.isdir(t):
                for f in glob.glob(os.path.join(t, '*.json')):
                    results.append(score_file(f))
        for r in sorted(results, key=lambda x: x['score'], reverse=True):
            mismatch = ' ⚠' if r['suggested'] != r['current'] else ''
            print(f"{r['score']:5.1f}  {r['current']:8s}→{r['suggested']:8s}{mismatch}  {r['file']}")
    else:
        # 전체 통계 출력
        BASE = os.path.join(os.path.dirname(__file__),
                            'converted/level_data')
        DIFFS = ['VeryEasy', 'Easy', 'Normal', 'Hard', 'VeryHard']
        print(f"{'난이도':10s}  {'개수':>5s}  {'avg':>6s}  {'min':>5s}  {'max':>5s}  {'⚠불일치':>6s}")
        print('-' * 55)
        total_mismatch = 0
        for diff in DIFFS:
            scores, mismatches = [], 0
            for f in glob.glob(os.path.join(BASE, diff, '*.json')):
                r = score_file(f)
                scores.append(r['score'])
                if r['suggested'] != diff:
                    mismatches += 1
            if scores:
                print(f"{diff:10s}  {len(scores):>5d}  "
                      f"{statistics.mean(scores):>6.1f}  "
                      f"{min(scores):>5.1f}  "
                      f"{max(scores):>5.1f}  "
                      f"{mismatches:>6d}")
                total_mismatch += mismatches
        print('-' * 55)
        print(f"총 불일치: {total_mismatch}개")
