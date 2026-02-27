#!/bin/bash
# bump_version.sh
# 분석 보고서(.md, .html)의 버전 번호와 날짜를 일괄 업데이트합니다.
#
# 사용법:
#   bash scripts/bump_version.sh 4.1          # v4.1로 업데이트 (날짜는 오늘)
#   bash scripts/bump_version.sh 4.1 2026-03-01  # 버전 + 날짜 지정

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(dirname "$SCRIPT_DIR")"
REPORT_DIR="$PROJECT_ROOT/docs/04-report/features"
MD_FILE="$REPORT_DIR/candy-solitaire-currency-analysis.report.md"
HTML_FILE="$REPORT_DIR/candy-solitaire-currency-analysis.html"

NEW_VERSION="${1:-}"
NEW_DATE="${2:-$(date +%Y-%m-%d)}"

if [ -z "$NEW_VERSION" ]; then
  echo "사용법: bash scripts/bump_version.sh VERSION [DATE]"
  echo "  예시: bash scripts/bump_version.sh 4.1"
  echo "  예시: bash scripts/bump_version.sh 4.1 2026-03-15"
  exit 1
fi

# 현재 버전 확인
CURRENT=$(grep -o 'v[0-9]\+\.[0-9]\+' "$MD_FILE" | head -1)
echo "[INFO] 현재 버전: $CURRENT → 새 버전: v$NEW_VERSION"
echo "[INFO] 날짜: $NEW_DATE"

# Markdown 업데이트
if [ -f "$MD_FILE" ]; then
  # 상태 라인 버전 업데이트
  sed -i '' "s/완료 (v[0-9]\+\.[0-9]\+ - [0-9]\+차 수정판)/완료 (v$NEW_VERSION)/g" "$MD_FILE"
  # 날짜 업데이트
  sed -i '' "s/\*\*최종 수정\*\*: [0-9-]*/\*\*최종 수정\*\*: $NEW_DATE/g" "$MD_FILE"
  # 하단 버전 표기 업데이트
  sed -i '' "s/*v[0-9]\+\.[0-9]\+ - [0-9-]*/\*v$NEW_VERSION - $NEW_DATE/g" "$MD_FILE"
  echo "[✔] Markdown 업데이트 완료: $MD_FILE"
else
  echo "[WARN] Markdown 파일 없음: $MD_FILE"
fi

# HTML 업데이트
if [ -f "$HTML_FILE" ]; then
  # <title> 버전
  sed -i '' "s/분석 v[0-9]\+\.[0-9]\+/분석 v$NEW_VERSION/g" "$HTML_FILE"
  # 사이드바 버전
  sed -i '' "s/분석 보고서 v[0-9]\+\.[0-9]\+/분석 보고서 v$NEW_VERSION/g" "$HTML_FILE"
  # badge 날짜
  sed -i '' "s/<span class=\"badge badge-ok\">[0-9-]*<\/span>/<span class=\"badge badge-ok\">$NEW_DATE<\/span>/g" "$HTML_FILE"
  echo "[✔] HTML 업데이트 완료: $HTML_FILE"
else
  echo "[WARN] HTML 파일 없음: $HTML_FILE"
fi

echo ""
echo "버전 업데이트 완료: v$NEW_VERSION ($NEW_DATE)"
echo "→ 수정 내역 테이블을 보고서 상단에 직접 추가해 주세요."
