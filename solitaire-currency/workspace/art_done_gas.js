/**
 * art_done_gas.js — Google Apps Script Web App
 *
 * 배포 방법:
 * 1. 라이브 시트 열기: https://docs.google.com/spreadsheets/d/1oLbpsJjiDz0pdljaGBQznrSZcXA7aypFyJihnQ8_iiM
 * 2. 확장 프로그램 > Apps Script
 * 3. 이 코드 전체 붙여넣기 (기존 코드 덮어쓰기)
 * 4. 저장 후 [배포] > [새 배포] 클릭
 *    - 유형: 웹 앱
 *    - 다음 사용자로 실행: 나
 *    - 액세스 권한: 모든 사용자 (Anyone)
 * 5. [배포] 클릭 → 웹 앱 URL 복사
 * 6. 12_art_production_schedule.html 상단 ART_STATUS_URL 에 붙여넣기
 */

const SPREADSHEET_ID = '1oLbpsJjiDz0pdljaGBQznrSZcXA7aypFyJihnQ8_iiM';
const TAB_NAME = 'art_done_status';

function doGet(e) {
  const action = (e.parameter && e.parameter.action) || 'read';
  let result;

  if (action === 'toggle') {
    const cityId = e.parameter.cityId;
    result = toggleStatus(cityId);
  } else {
    result = readStatus();
  }

  return ContentService
    .createTextOutput(JSON.stringify(result))
    .setMimeType(ContentService.MimeType.JSON);
}

function readStatus() {
  const ws = getOrCreateTab();
  const values = ws.getDataRange().getValues();
  const result = {};
  for (let i = 1; i < values.length; i++) {
    const cityId = String(values[i][0]).trim();
    const doneAt = values[i][1] ? String(values[i][1]).trim() : null;
    if (cityId) result[cityId] = doneAt || null;
  }
  return result;
}

function toggleStatus(cityId) {
  const ws = getOrCreateTab();
  const data = ws.getDataRange().getValues();

  for (let i = 1; i < data.length; i++) {
    if (String(data[i][0]).trim() === cityId) {
      if (data[i][1]) {
        // 이미 완료 → 취소
        ws.getRange(i + 1, 2).setValue('');
      } else {
        // 미완료 → 완료 처리
        const ts = Utilities.formatDate(new Date(), 'Asia/Seoul', 'yyyy-MM-dd HH:mm');
        ws.getRange(i + 1, 2).setValue(ts);
      }
      return readStatus();
    }
  }

  // 해당 city_id 행 없음 → 새로 추가 (완료)
  const ts = Utilities.formatDate(new Date(), 'Asia/Seoul', 'yyyy-MM-dd HH:mm');
  ws.appendRow([cityId, ts]);
  return readStatus();
}

function getOrCreateTab() {
  const ss = SpreadsheetApp.openById(SPREADSHEET_ID);
  let ws = ss.getSheetByName(TAB_NAME);
  if (!ws) {
    ws = ss.insertSheet(TAB_NAME);
    ws.appendRow(['city_id', 'done_at']);
    ws.setFrozenRows(1);
    ws.getRange('A1:B1').setFontWeight('bold');
  }
  return ws;
}
