#!/bin/bash
# source_grep.sh
# 디컴파일된 Java 소스에서 패턴을 검색합니다.
#
# 사용법:
#   bash scripts/source_grep.sh "CoinReward"
#   bash scripts/source_grep.sh "CoinReward\|EntryCost\|Betup"   # OR 패턴
#   bash scripts/source_grep.sh --files "Coin"        # 파일 경로만 출력
#   bash scripts/source_grep.sh --context "Streak" 3  # 매칭 라인 전후 3줄
#   bash scripts/source_grep.sh --king                # King 공식 패키지만 검색
#   bash scripts/source_grep.sh --economy             # 경제 관련 키워드 일괄 검색

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(dirname "$SCRIPT_DIR")"
SOURCES_DIR="$PROJECT_ROOT/decompiled_java/sources"

if [ ! -d "$SOURCES_DIR" ]; then
  echo "[ERROR] sources 디렉토리를 찾을 수 없습니다: $SOURCES_DIR"
  exit 1
fi

# 색상
RED='\033[0;31m'
YLW='\033[0;33m'
GRN='\033[0;32m'
NC='\033[0m'

echo -e "${GRN}[INFO]${NC} 소스 경로: $SOURCES_DIR"

# ── 모드 분기 ──────────────────────────────────────────────────

if [ "$1" = "--files" ] && [ -n "$2" ]; then
  # 파일 경로만 출력
  PATTERN="$2"
  echo -e "${YLW}[SEARCH-FILES]${NC} 패턴: $PATTERN"
  grep -rl "$PATTERN" "$SOURCES_DIR" --include="*.java" | sort
  echo ""

elif [ "$1" = "--context" ] && [ -n "$2" ]; then
  # 전후 N줄 컨텍스트
  PATTERN="$2"
  CONTEXT="${3:-3}"
  echo -e "${YLW}[SEARCH-CONTEXT]${NC} 패턴: $PATTERN (±${CONTEXT}줄)"
  grep -rn --include="*.java" -C "$CONTEXT" "$PATTERN" "$SOURCES_DIR" | head -200

elif [ "$1" = "--king" ] && [ -n "$2" ]; then
  # King 공식 패키지만 (com/king/ 디렉토리)
  PATTERN="$2"
  KING_DIR="$SOURCES_DIR/com/king"
  echo -e "${YLW}[SEARCH-KING]${NC} 패턴: $PATTERN (King 패키지)"
  grep -rn --include="*.java" "$PATTERN" "$KING_DIR" 2>/dev/null | head -100

elif [ "$1" = "--economy" ]; then
  # 경제 관련 키워드 일괄 검색
  echo -e "${YLW}[ECONOMY SCAN]${NC} 경제 관련 키워드 검색 중..."
  KEYWORDS=(
    "CoinReward" "EntryCost" "Betup" "OnFire"
    "StreakMultiplier" "BonsaiSoft" "BonsaiHard"
    "BoosterCost" "FreeEntry" "PiggyBank"
    "EpisodeFinished" "BonusLevel"
  )
  for kw in "${KEYWORDS[@]}"; do
    count=$(grep -rl "$kw" "$SOURCES_DIR" --include="*.java" 2>/dev/null | wc -l | tr -d ' ')
    if [ "$count" -gt 0 ]; then
      echo -e "  ${GRN}✔${NC} ${kw}: ${count}개 파일"
      grep -rl "$kw" "$SOURCES_DIR" --include="*.java" | head -3 | sed 's/^/      /'
    else
      echo -e "  ${RED}✘${NC} ${kw}: 없음"
    fi
  done

elif [ "$1" = "--antipattern" ]; then
  # 잘못 오인할 수 있는 타 게임 코드 확인
  echo -e "${YLW}[ANTIPATTERN CHECK]${NC} 타 게임 코드 포함 여부..."
  for kw in "FARM_KING" "DiamondDigger" "MuffinHamburger" "MuffinPizza" "MuffinIngredient"; do
    count=$(grep -rl "$kw" "$SOURCES_DIR" --include="*.java" 2>/dev/null | wc -l | tr -d ' ')
    echo -e "  ${RED}[타 게임]${NC} $kw: ${count}개 파일 (분석 제외)"
  done

else
  # 기본: 패턴 검색 + 매칭 라인 출력
  PATTERN="${1:-}"
  if [ -z "$PATTERN" ]; then
    echo "사용법:"
    echo "  bash scripts/source_grep.sh PATTERN"
    echo "  bash scripts/source_grep.sh --files PATTERN"
    echo "  bash scripts/source_grep.sh --context PATTERN [N줄]"
    echo "  bash scripts/source_grep.sh --king PATTERN"
    echo "  bash scripts/source_grep.sh --economy"
    echo "  bash scripts/source_grep.sh --antipattern"
    exit 0
  fi
  echo -e "${YLW}[SEARCH]${NC} 패턴: $PATTERN"
  grep -rn --include="*.java" "$PATTERN" "$SOURCES_DIR" | head -100
  TOTAL=$(grep -rl --include="*.java" "$PATTERN" "$SOURCES_DIR" | wc -l | tr -d ' ')
  echo ""
  echo -e "${GRN}[INFO]${NC} 총 ${TOTAL}개 파일에서 발견"
fi
