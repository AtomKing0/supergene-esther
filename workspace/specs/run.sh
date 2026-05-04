#!/bin/bash
set -e

SPECS_DIR="$(cd "$(dirname "$0")" && pwd)"
cd "$SPECS_DIR"

# 의존성 설치 (최초 1회)
if ! python3 -c "import fastapi, uvicorn" 2>/dev/null; then
  echo "📦 패키지 설치 중..."
  pip3 install -r requirements.txt -q
fi

PORT=${1:-8080}
echo "🚀 http://localhost:$PORT 에서 실행 중..."
python3 server.py "$PORT"
