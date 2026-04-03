#!/bin/bash
# ============================================================
# Install_BalanceDiff_Agent.command
# Finder에서 더블클릭하면 Terminal이 열리며 자동 실행됩니다.
# ============================================================
cd "$(dirname "$0")/.."
bash scripts/install_launchagent.sh
echo ""
echo "Press any key to close..."
read -n 1
