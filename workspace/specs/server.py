import asyncio
import os
import re
import subprocess
import sys
import time
from pathlib import Path
from typing import Any

import httpx
from dotenv import load_dotenv
from contextlib import asynccontextmanager
from fastapi import FastAPI, HTTPException, Request
from fastapi.responses import Response, StreamingResponse
from fastapi.staticfiles import StaticFiles
from starlette.middleware.base import BaseHTTPMiddleware
from pydantic import BaseModel

BASE_DIR = Path(__file__).parent
AGENTS_DIR = BASE_DIR.parent.parent / ".claude" / "agents"

SPREADSHEET_ID = "1oLbpsJjiDz0pdljaGBQznrSZcXA7aypFyJihnQ8_iiM"
SHEETS_KEY_FILE = BASE_DIR.parent.parent / "solitaire-currency" / "pst-agent-187157cdb8b7.json"
SHEETS_SCOPES = ["https://www.googleapis.com/auth/spreadsheets.readonly"]
SHEETS_TABS = ["const", "item_list", "product", "daily_task", "streak_reward", "meta_city_list", "daily_wheel"]
SHEETS_CACHE_TTL = 600  # 10분
_sheets_cache: dict = {"text": "", "ts": 0.0}

load_dotenv(BASE_DIR / ".env")

SB_URL = os.environ.get("SB_URL", "https://hfiukhidqwhntdpmippt.supabase.co")
SB_SERVICE_KEY = os.environ.get("SB_SERVICE_KEY", "")

@asynccontextmanager
async def lifespan(application: FastAPI):
    asyncio.create_task(_get_sheets_context())
    yield


app = FastAPI(lifespan=lifespan)


# ── 모바일 CSS/JS 자동 주입 미들웨어 ──────────────────────────

MOBILE_CSS = '<link rel="stylesheet" href="/mobile.css">'
MOBILE_JS  = '<script src="/mobile.js"></script>'

class MobileInjectMiddleware(BaseHTTPMiddleware):
    async def dispatch(self, request: Request, call_next):
        response = await call_next(request)
        ct = response.headers.get("content-type", "")
        if "text/html" not in ct:
            return response
        # StaticFiles returns a streaming response; read body
        body = b""
        async for chunk in response.body_iterator:
            body += chunk
        if not body:
            return response  # 304 등 body 없는 응답은 그대로 통과
        html = body.decode("utf-8", errors="replace")
        if MOBILE_CSS not in html:
            html = html.replace("</head>", f"{MOBILE_CSS}\n</head>", 1)
        if MOBILE_JS not in html:
            html = html.replace("</body>", f"{MOBILE_JS}\n</body>", 1)
        headers = {k: v for k, v in response.headers.items()
                   if k.lower() not in ("content-length", "cache-control",
                                        "etag", "last-modified")}
        headers["cache-control"] = "no-store"
        return Response(
            content=html,
            status_code=response.status_code,
            headers=headers,
            media_type="text/html; charset=utf-8",
        )

app.add_middleware(MobileInjectMiddleware)


def sb_headers() -> dict:
    if not SB_SERVICE_KEY:
        raise HTTPException(status_code=500, detail="SB_SERVICE_KEY 미설정")
    return {
        "apikey": SB_SERVICE_KEY,
        "Authorization": f"Bearer {SB_SERVICE_KEY}",
        "Content-Type": "application/json",
        "Prefer": "resolution=merge-duplicates,return=representation",
    }


# ── Supabase 프록시 ──────────────────────────────────────────

@app.get("/api/sb/{table}")
async def sb_select(table: str, request: Request):
    """서비스 키로 테이블 조회."""
    qs = str(request.url.query)
    url = f"{SB_URL}/rest/v1/{table}" + (f"?{qs}" if qs else "")
    async with httpx.AsyncClient() as client:
        res = await client.get(url, headers=sb_headers())
    return res.json()


@app.post("/api/sb/{table}")
async def sb_upsert(table: str, request: Request):
    """서비스 키로 upsert."""
    body = await request.json()
    url = f"{SB_URL}/rest/v1/{table}"
    async with httpx.AsyncClient() as client:
        res = await client.post(url, json=body, headers=sb_headers())
    if res.status_code >= 400:
        raise HTTPException(status_code=res.status_code, detail=res.text)
    return res.json()


@app.delete("/api/sb/{table}")
async def sb_delete(table: str, request: Request):
    """서비스 키로 삭제."""
    qs = str(request.url.query)
    url = f"{SB_URL}/rest/v1/{table}" + (f"?{qs}" if qs else "")
    async with httpx.AsyncClient() as client:
        res = await client.delete(url, headers=sb_headers())
    if res.status_code >= 400:
        raise HTTPException(status_code=res.status_code, detail=res.text)
    return {"ok": True}


# ── 에이전트 ─────────────────────────────────────────────────

def load_agent_system_prompt(agent_name: str) -> str:
    agent_file = AGENTS_DIR / f"{agent_name}.md"
    if not agent_file.exists():
        raise FileNotFoundError(f"에이전트 파일 없음: {agent_file}")
    content = agent_file.read_text(encoding="utf-8")
    content = re.sub(r"^---\n.*?\n---\n", "", content, flags=re.DOTALL)
    return content.strip()


@app.get("/api/agents")
async def list_agents():
    if not AGENTS_DIR.exists():
        return {"agents": []}
    return {"agents": [f.stem for f in sorted(AGENTS_DIR.glob("*.md"))]}


# ── Google Sheets 컨텍스트 ────────────────────────────────────

def _fetch_sheets_blocking() -> str:
    """동기 Sheets fetch — 반드시 thread pool 안에서 호출."""
    try:
        from google.oauth2.service_account import Credentials
        from googleapiclient.discovery import build as gbuild
        creds = Credentials.from_service_account_file(str(SHEETS_KEY_FILE), scopes=SHEETS_SCOPES)
        service = gbuild("sheets", "v4", credentials=creds, cache_discovery=False)
        sheets_api = service.spreadsheets()
        parts = []
        for tab in SHEETS_TABS:
            try:
                result = sheets_api.values().get(
                    spreadsheetId=SPREADSHEET_ID,
                    range=f"{tab}!A1:Z200",
                ).execute()
                rows = result.get("values", [])
                if not rows:
                    continue
                lines = ["\t".join(r) for r in rows]
                parts.append(f"=== 라이브 시트 탭: {tab} ({len(lines)}행) ===\n" + "\n".join(lines))
            except Exception as e:
                parts.append(f"=== 라이브 시트 탭: {tab} — 로드 실패: {e} ===")
        return "\n\n".join(parts)
    except Exception as e:
        return f"[Google Sheets 전체 로드 실패: {e}]"


async def _get_sheets_context() -> str:
    """캐시된 Sheets 컨텍스트 반환. TTL 초과 시 비동기로 갱신."""
    now = time.time()
    if now - _sheets_cache["ts"] < SHEETS_CACHE_TTL and _sheets_cache["text"]:
        return _sheets_cache["text"]
    text = await asyncio.to_thread(_fetch_sheets_blocking)
    _sheets_cache["text"] = text
    _sheets_cache["ts"] = time.time()
    return text


# ── 프로젝트 컨텍스트 빌더 ────────────────────────────────────

def _build_spec_context(root: Path, sheets_text: str = "") -> str:
    parts = []

    # 1. 프로젝트 CLAUDE.md (최대 6000자)
    claude_md = root / "CLAUDE.md"
    if claude_md.exists():
        parts.append("=== 프로젝트 컨텍스트 (CLAUDE.md) ===\n" +
                     claude_md.read_text(encoding="utf-8")[:6000])

    # 2. solitaire-currency CLAUDE.md (경제/밸런스 컨텍스트)
    currency_md = root / "solitaire-currency" / "CLAUDE.md"
    if currency_md.exists():
        parts.append("=== 경제 시스템 컨텍스트 (solitaire-currency/CLAUDE.md) ===\n" +
                     currency_md.read_text(encoding="utf-8")[:4000])

    # 3. 현재 spec 목록 (id, title, status, date)
    specs_dir = root / "workspace" / "specs"
    spec_files = sorted(specs_dir.glob("spec-*.html"))
    if spec_files:
        lines = []
        for f in spec_files:
            # title 추출
            try:
                text = f.read_text(encoding="utf-8")
                import re as _re
                m = _re.search(r"<title>([^<]+)</title>", text)
                title = m.group(1).strip() if m else f.stem
            except Exception:
                title = f.stem
            lines.append(f"  - {f.name}: {title}")
        parts.append("=== 기존 spec 목록 ===\n" + "\n".join(lines))

    # 4. 최신 spec 2개 본문 (구조 참고, 각 최대 8000자)
    for f in spec_files[-2:]:
        try:
            content = f.read_text(encoding="utf-8")[:8000]
            parts.append(f"=== 참고 spec: {f.name} ===\n" + content)
        except Exception:
            pass

    # 5. 라이브 Google Sheets 데이터
    if sheets_text:
        parts.append("=== PST 라이브 기획 시트 (Google Sheets) ===\n" + sheets_text)

    return "\n\n".join(parts)


# ── Claude CLI ───────────────────────────────────────────────

class ClaudeRequest(BaseModel):
    prompt: str
    agent: str | None = None


@app.post("/api/claude")
async def run_claude(req: ClaudeRequest):
    prompt = req.prompt.strip()
    if not prompt:
        raise HTTPException(status_code=400, detail="프롬프트를 입력해주세요")

    env = {k: v for k, v in os.environ.items() if k != "ANTHROPIC_API_KEY"}
    cmd = ["claude", "-p", "--model", "sonnet",
           "--allowedTools", "Bash,Read,Write,Edit,Glob,Grep"]

    if req.agent:
        try:
            cmd += ["--system-prompt", load_agent_system_prompt(req.agent)]
        except FileNotFoundError as e:
            raise HTTPException(status_code=404, detail=str(e))

    # content-spec-writer: 프로젝트 컨텍스트를 프롬프트 앞에 자동 주입
    if req.agent == "content-spec-writer":
        sheets = await _get_sheets_context()
        prompt = _build_spec_context(BASE_DIR.parent.parent, sheets) + "\n\n" + prompt

    cmd.append(prompt)
    cwd = str(BASE_DIR.parent.parent)

    async def stream_output():
        proc = await asyncio.create_subprocess_exec(
            *cmd,
            stdout=asyncio.subprocess.PIPE,
            stderr=asyncio.subprocess.PIPE,
            stdin=asyncio.subprocess.DEVNULL,
            env=env,
            cwd=cwd,
        )
        async for chunk in proc.stdout:
            yield chunk.decode("utf-8", errors="replace")
        await proc.wait()
        if proc.returncode != 0:
            err = (await proc.stderr.read()).decode("utf-8", errors="replace")
            if err:
                yield f"\n\n⚠️ {err.strip()}"

    return StreamingResponse(stream_output(), media_type="text/plain; charset=utf-8")


# Static files — must be mounted last
app.mount("/", StaticFiles(directory=str(BASE_DIR), html=True), name="static")


if __name__ == "__main__":
    import uvicorn
    port = int(sys.argv[1]) if len(sys.argv) > 1 else 8080
    print(f"서버 시작: http://localhost:{port}")
    uvicorn.run("server:app", host="0.0.0.0", port=port, reload=False)
