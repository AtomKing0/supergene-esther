#!/usr/bin/env python3
"""
BigQuery monitoring: solitaire_city_journey KR 외 유저 감시
환경변수 GOOGLE_SERVICE_ACCOUNT_JSON (base64) 로 인증
service_account / authorized_user 양쪽 타입 모두 지원
"""
import os
import sys
import json
import base64

def get_credentials():
    b64 = os.environ.get("GOOGLE_SERVICE_ACCOUNT_JSON")
    if not b64:
        print("CRED_ERROR:GCP 인증 없음 - 환경변수 GOOGLE_SERVICE_ACCOUNT_JSON(base64) 필요", file=sys.stderr)
        sys.exit(2)

    try:
        json_str = base64.b64decode(b64).decode("utf-8")
        info = json.loads(json_str)
    except Exception as e:
        print(f"CRED_ERROR:base64/JSON 파싱 실패: {e}", file=sys.stderr)
        sys.exit(2)

    cred_type = info.get("type")

    try:
        if cred_type == "authorized_user":
            from google.oauth2.credentials import Credentials
            from google.auth.transport.requests import Request
            creds = Credentials(
                token=None,
                refresh_token=info["refresh_token"],
                token_uri="https://oauth2.googleapis.com/token",
                client_id=info["client_id"],
                client_secret=info["client_secret"],
            )
            creds.refresh(Request())
            return creds
        elif cred_type == "service_account":
            from google.oauth2 import service_account
            return service_account.Credentials.from_service_account_info(
                info,
                scopes=["https://www.googleapis.com/auth/bigquery.readonly"],
            )
        else:
            print(f"CRED_ERROR:지원하지 않는 credentials type: {cred_type}", file=sys.stderr)
            sys.exit(2)
    except Exception as e:
        print(f"CRED_ERROR:인증 초기화 실패: {e}", file=sys.stderr)
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
