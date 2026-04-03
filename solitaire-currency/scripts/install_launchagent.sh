#!/bin/bash
# ============================================================
# install_launchagent.sh
# macOS LaunchAgent 설치 스크립트
# 이 파일을 "Terminal에서 열기"로 실행하거나, 아래 명령으로 직접 실행하세요:
#   bash /path/to/solitaire-currency/scripts/install_launchagent.sh
# ============================================================

set -e

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
PROJECT_DIR="$(dirname "$SCRIPT_DIR")"
RUNNER="$SCRIPT_DIR/run_balance_diff.sh"
PLIST_TEMPLATE="$SCRIPT_DIR/com.supergene.balance-diff.plist"
PLIST_DEST="$HOME/Library/LaunchAgents/com.supergene.balance-diff.plist"
LOG_OUT="$PROJECT_DIR/reports/launchagent_stdout.log"
LOG_ERR="$PROJECT_DIR/reports/launchagent_stderr.log"

echo ""
echo "================================================"
echo "  밸런스 시트 diff — LaunchAgent 설치"
echo "  프로젝트: $PROJECT_DIR"
echo "================================================"
echo ""

# 1) 실행 권한 부여
chmod +x "$RUNNER"
echo "[1/4] run_balance_diff.sh 실행 권한 설정 ✓"

# 2) plist에 실제 경로 치환하여 LaunchAgents에 복사
sed \
    -e "s|SCRIPT_PATH_PLACEHOLDER|$RUNNER|g" \
    -e "s|LOG_PATH_PLACEHOLDER|$LOG_OUT|g" \
    -e "s|ERR_PATH_PLACEHOLDER|$LOG_ERR|g" \
    "$PLIST_TEMPLATE" > "$PLIST_DEST"
echo "[2/4] plist 설치: $PLIST_DEST ✓"

# 3) 기존 job 언로드 (에러 무시)
launchctl unload "$PLIST_DEST" 2>/dev/null || true

# 4) LaunchAgent 로드
launchctl load "$PLIST_DEST"
echo "[3/4] LaunchAgent 로드 ✓"

# 5) 지금 즉시 한 번 실행 (첫 스냅샷 취득)
echo "[4/4] 첫 번째 스냅샷 즉시 실행 중..."
echo ""
bash "$RUNNER"
echo ""

echo "================================================"
echo "  설치 완료!"
echo "  매일 오전 9시에 자동 실행됩니다."
echo ""
echo "  로그:    $PROJECT_DIR/reports/run_balance_diff.log"
echo "  스냅샷:  $PROJECT_DIR/snapshots/"
echo "  리포트:  $PROJECT_DIR/reports/"
echo "================================================"
echo ""
