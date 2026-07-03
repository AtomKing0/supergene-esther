#!/usr/bin/env python3
"""
BigQuery monitoring: solitaire_city_journey KR 외 유저 감시
환경변수 GOOGLE_SERVICE_ACCOUNT_JSON (base64) 또는
GOOGLE_APPLICATION_CREDENTIALS (파일경로) 로 인증
"""
import os
import sys
import json
import base64
import tempfile

def get_credentials():
    b64 = os.environ.get("GOOGLE_SERVICE_ACCOUNT_JSON")
    if b64:
        try:
            json_str = base64.b64decode(b64).decode("utf-8")
            info = json.loads(json_str)
            from google.oauth2 import service_account
            return service_account.Credentials.from_service_account_info(
                info,
                scopes=["https://www.googleapis.com/auth/bigquery.readonly"],
            )
        except Exception as e:
            print(f"CRED_ERROR:GOOGLE_SERVICE_ACCOUNT_JSON 파싱 실패: {e}", file=sys.stderr)
            sys.exit(2)

    adc_path = os.environ.get("GOOGLE_APPLICATION_CREDENTIALS")
    if adc_path:
        try:
            from google.oauth2 import service_account
            return service_account.Credentials.from_service_account_file(
                adc_path,
                scopes=["https://www.googleapis.com/auth/bigquery.readonly"],
            )
        except Exception as e:
            print(f"CRED_ERROR:GOOGLE_APPLICATION_CREDENTIALS 파싱 실패: {e}", file=sys.stderr)
            sys.exit(2)

    print("CRED_ERROR:GCP 인증 없음 - GOOGLE_SERVICE_ACCOUNT_JSON 또는 GOOGLE_APPLICATION_CREDENTIALS 필요", file=sys.stderr)
    sys.exit(2)


def run():
    try:
        from google.cloud import bigquery
    except ImportError:
        print("IMPORT_ERROR:google-cloud-bigquery 미설치", file=sys.stderr)
        sys.exit(3)

    creds = get_credentials()

    query = """
SELECT country, player_id
FROM `game-log-359704.raw.solitaire_city_journey`
WHERE log_date = CURRENT_DATE('Asia/Seoul')
  AND is_dev IS DISTINCT FROM TRUE
  AND country != 'KR'
GROUP BY 1, 2
"""
    try:
        client = bigquery.Client(project="game-log-359704", credentials=creds)
        rows = list(client.query(query).result())
    except Exception as e:
        print(f"QUERY_ERROR:{e}", file=sys.stderr)
        sys.exit(4)

    if not rows:
        print("OK:0")
        sys.exit(0)

    print(f"FOUND:{len(rows)}")
    for row in rows:
        print(f"ROW:{row['country']}:{row['player_id']}")


if __name__ == "__main__":
    run()
