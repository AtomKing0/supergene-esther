#!/bin/bash
# ============================================================
# run_balance_diff.sh
# 로컬 macOS에서 매일 자동 실행되는 밸런스 시트 diff 스크립트
# LaunchAgent 또는 직접 실행용
# ============================================================

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
PROJECT_DIR="$(dirname "$SCRIPT_DIR")"
LOG_FILE="$PROJECT_DIR/reports/run_balance_diff.log"

# 로그 디렉토리 보장
mkdir -p "$PROJECT_DIR/reports"
mkdir -p "$PROJECT_DIR/snapshots"

echo "======================================" >> "$LOG_FILE"
echo "실행 시각: $(date '+%Y-%m-%d %H:%M:%S')" >> "$LOG_FILE"
echo "작업 디렉토리: $PROJECT_DIR" >> "$LOG_FILE"

# 주말(토=6, 일=0) 스킵
DOW=$(date '+%u')  # 1=월 ... 6=토, 7=일
if [ "$DOW" -eq 6 ] || [ "$DOW" -eq 7 ]; then
    echo "[SKIP] 주말 — 스냅샷 생략 ($(date '+%A'))" >> "$LOG_FILE"
    echo "======================================" >> "$LOG_FILE"
    exit 0
fi

# Python 경로 탐색 (macOS 로컬 환경)
PYTHON=""
for candidate in /usr/local/bin/python3 /opt/homebrew/bin/python3 /usr/bin/python3 python3; do
    if command -v "$candidate" &>/dev/null; then
        PYTHON="$candidate"
        break
    fi
done

if [ -z "$PYTHON" ]; then
    echo "[ERROR] python3 를 찾을 수 없습니다." >> "$LOG_FILE"
    exit 1
fi

echo "Python 경로: $PYTHON" >> "$LOG_FILE"

# gspread / google-auth 자동 설치 (없는 경우)
$PYTHON -c "import gspread" 2>/dev/null || {
    echo "[INFO] gspread 미설치 → pip install 시도" >> "$LOG_FILE"
    $PYTHON -m pip install gspread google-auth --quiet 2>> "$LOG_FILE"
}

# 스크립트 실행
cd "$PROJECT_DIR"
$PYTHON scripts/balance_sheet_diff.py >> "$LOG_FILE" 2>&1
EXIT_CODE=$?

if [ $EXIT_CODE -eq 0 ]; then
    echo "[SUCCESS] balance_sheet_diff.py 완료" >> "$LOG_FILE"
else
    echo "[FAIL] balance_sheet_diff.py 종료코드: $EXIT_CODE" >> "$LOG_FILE"
fi

echo "======================================" >> "$LOG_FILE"
exit $EXIT_CODE
