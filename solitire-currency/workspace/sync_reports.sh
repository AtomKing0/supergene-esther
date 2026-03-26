#!/bin/bash
# workspace → reports 동기화 스크립트
# 원본(workspace/)에서 수정 후 이 스크립트를 실행하면 reports/에 반영됩니다.

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
SRC="$SCRIPT_DIR"
DEST="$SCRIPT_DIR/reports"

FILES=(
  "index.html"
  "07_tutorial_planning_doc.html"
  "09_gold_inflation_report.html"
  "10_dynamic_level_report.html"
  "11_city_decoration_reform.html"
  "balance_sheet_guide.html"
  "economy_report_final.html"
  "reward_system_report.html"
)

mkdir -p "$DEST"

copied=0
skipped=0
for f in "${FILES[@]}"; do
  if [ ! -f "$SRC/$f" ]; then
    echo "  SKIP  $f (not found)"
    ((skipped++))
    continue
  fi
  cp "$SRC/$f" "$DEST/$f"
  echo "  SYNC  $f"
  ((copied++))
done

echo ""
echo "Done: $copied synced, $skipped skipped → $DEST/"
