/**
 * Google Sheets > 확장 프로그램 > Apps Script에 붙여넣고 실행하세요.
 * Event 컬럼(C열)에서 이름 동일 + 번호 불일치 항목을 CSV 기준 번호로 수정합니다.
 */
function fixLogNumbers() {
  const sheet = SpreadsheetApp.getActiveSpreadsheet().getActiveSheet();
  const data = sheet.getDataRange().getValues();

  // [시트 현재값, CSV 기준 올바른 값]
  const replacements = [
    ["2251_GAMEPLAY_SETTING_LEAVE",              "2211_GAMEPLAY_SETTING_LEAVE"],
    ["2260_GAMEPLAY_END_SURE",                   "2220_GAMEPLAY_END_SURE"],
    ["2261_GAMEPLAY_END_SURE_NO",                "2221_GAMEPLAY_END_SURE_NO"],
    ["2262_GAMEPLAY_END_SURE_YES",               "2222_GAMEPLAY_END_SURE_YES"],
    ["5100_SHOP",                                "5000_SHOP"],
    ["5110_SHOP_PURCHASE_TRY",                   "5001_SHOP_PURCHASE_TRY"],
    ["5111_SHOP_PURCHASE_SUCCESS",               "5002_SHOP_PURCHASE_SUCCESS"],
    ["5112_SHOP_PURCHASE_FAIL",                  "5003_SHOP_PURCHASE_FAIL"],
    ["5120_BTN_SHOP_CLOSE",                      "5004_BTN_SHOP_CLOSE"],
    ["5150_DAILY_TASK",                          "5100_DAILY_TASK"],
    ["5151_DAILY_TASK_GO_TO",                    "5101_DAILY_TASK_GO_TO"],
    ["5152_DAILY_TASK_REWARD_CLAIM_TRY",         "5102_DAILY_TASK_REWARD_CLAIM_TRY"],
    ["5153_DAILY_TASK_REWARD_CLAIM_SUCCESS",      "5103_DAILY_TASK_REWARD_CLAIM_SUCCESS"],
    ["5154_DAILY_TASK_REWARD_CLAIM_FAIL",        "5104_DAILY_TASK_REWARD_CLAIM_FAIL"],
    ["5155_BTN_DAILY_TASK_CLOSE",                "5105_BTN_DAILY_TASK_CLOSE"],
    ["5500_LEADERBOARD",                         "5200_LEADERBOARD"],
    ["5510_BTN_LEADERBOARD_FRIENDS_TAB",         "5201_BTN_LEADERBOARD_FRIENDS_TAB"],
    ["5511_BTN_LEADERBOARD_WORLD_TAB",           "5202_BTN_LEADERBOARD_WORLD_TAB"],
    ["5512_BTN_LEADERBOARD_FRIENDS_WEEKLY_TAB",  "5203_BTN_LEADERBOARD_FRIENDS_WEEKLY_TAB"],
    ["5513_BTN_LEADERBOARD_FRIENDS_ALLTIME_TAB", "5204_BTN_LEADERBOARD_FRIENDS_ALLTIME_TAB"],
    ["5514_BTN_LEADERBOARD_WORLD_WEEKLY_TAB",    "5205_BTN_LEADERBOARD_WORLD_WEEKLY_TAB"],
    ["5515_BTN_LEADERBOARD_WORLD_ALLTIME_TAB",   "5206_BTN_LEADERBOARD_WORLD_ALLTIME_TAB"],
    ["5520_BTN_LEADERBOARD_FRIENDS_INVITE",      "5207_BTN_LEADERBOARD_FRIENDS_INVITE"],
    ["5200_LOBBY",                               "5700_LOBBY"],
  ];

  const replaceMap = {};
  for (const [oldVal, newVal] of replacements) {
    replaceMap[oldVal] = newVal;
  }

  let count = 0;
  const log = [];

  for (let r = 0; r < data.length; r++) {
    for (let c = 0; c < data[r].length; c++) {
      const cell = String(data[r][c]).trim();
      if (replaceMap[cell] !== undefined) {
        const newVal = replaceMap[cell];
        sheet.getRange(r + 1, c + 1).setValue(newVal);
        log.push(`행${r+1} 열${c+1}: "${cell}" → "${newVal}"`);
        count++;
      }
    }
  }

  const msg = count > 0
    ? `✅ ${count}개 셀 수정 완료:\n\n` + log.join("\n")
    : "⚠️ 수정할 항목을 찾지 못했습니다. Event 컬럼 값을 확인하세요.";

  SpreadsheetApp.getUi().alert(msg);
}
