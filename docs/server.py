#!/usr/bin/env python3
"""
Sound List 로컬 서버
포트 8080에서 정적 파일 제공 + 선택 저장 API
"""
import json, os, shutil, subprocess, traceback
from http.server import HTTPServer, SimpleHTTPRequestHandler

SAVE_PATH = os.path.join(os.path.dirname(__file__), 'sound-selections.json')
ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))

def _resolve_src(name, theme):
    """테마+이름으로 소스 파일 경로 반환. 없으면 None."""
    rec = os.path.join(ROOT, 'audio_sets', 'rec')
    if theme == 'cc':
        p = os.path.join(ROOT, 'audio_sets', 'cc', f'{name}.wav')
    elif theme == 'sgh':
        p = os.path.join(ROOT, 'audio_sets', 'sgh', f'{name}.wav')
    elif theme == 'rec':
        p = os.path.join(rec, f'{name}.wav')
    elif theme == 'rec2':
        p = os.path.join(rec, f'{name}_2.wav')
    elif theme == 'rec3':
        p = os.path.join(rec, f'{name}_3.wav')
    elif theme == 'rec4':
        p = os.path.join(rec, f'{name}_4.wav')
    elif theme == 'rec5':
        p = os.path.join(rec, f'{name}_5.wav')
    elif theme == 'rec6':
        p = os.path.join(rec, f'{name}_6.wav')
    elif theme == 'tiki':
        tiki = os.path.join(ROOT, 'audio_sets', 'tiki')
        for ext in ('wav', 'ogg'):
            p = os.path.join(tiki, f'{name}.{ext}')
            if os.path.exists(p):
                return p
        return None
    elif theme.startswith('arch_'):
        return _resolve_archive(name, theme[5:])
    else:
        return None
    return p if os.path.exists(p) else None

def _resolve_archive(name, orig_theme):
    """아카이브 폴더에서 파일 경로 반환."""
    arch = os.path.join(ROOT, 'audio_sets', 'archive')
    if orig_theme in ('rec', 'rec2', 'rec3', 'rec4', 'rec5', 'rec6'):
        suffix = {'rec': '', 'rec2': '_2', 'rec3': '_3', 'rec4': '_4', 'rec5': '_5', 'rec6': '_6'}[orig_theme]
        p = os.path.join(arch, 'rec', f'{name}{suffix}.wav')
        return p if os.path.exists(p) else None
    for ext in ('wav', 'ogg'):
        p = os.path.join(arch, orig_theme, f'{name}.{ext}')
        if os.path.exists(p):
            return p
    return None

def _copy_to_slot(src, to_name, to_slot):
    """src 파일을 audio_sets/rec/ 의 to_slot 위치로 복사 (ogg→wav 변환 포함)."""
    rec = os.path.join(ROOT, 'audio_sets', 'rec')
    suffix = {'rec': '', 'rec2': '_2', 'rec3': '_3', 'rec4': '_4', 'rec5': '_5', 'rec6': '_6'}.get(to_slot, '')
    dest = os.path.join(rec, f'{to_name}{suffix}.wav')
    if src.lower().endswith('.wav'):
        shutil.copy2(src, dest)
    else:
        subprocess.run(['ffmpeg', '-y', '-i', src, dest], check=True, capture_output=True)
    return dest

def _scan_rec():
    rec_dir = os.path.join(ROOT, 'audio_sets', 'rec')
    result = {}
    if os.path.isdir(rec_dir):
        for fname in sorted(os.listdir(rec_dir)):
            if not fname.endswith('.wav'):
                continue
            base = fname[:-4]
            if base.endswith('_6'):
                result.setdefault(base[:-2], []).append('rec6')
            elif base.endswith('_5'):
                result.setdefault(base[:-2], []).append('rec5')
            elif base.endswith('_4'):
                result.setdefault(base[:-2], []).append('rec4')
            elif base.endswith('_3'):
                result.setdefault(base[:-2], []).append('rec3')
            elif base.endswith('_2'):
                result.setdefault(base[:-2], []).append('rec2')
            else:
                result.setdefault(base, []).append('rec')
    return result

def _scan_archive():
    arch = os.path.join(ROOT, 'audio_sets', 'archive')
    result = []
    if not os.path.isdir(arch):
        return result
    for sub in ('cc', 'sgh', 'tiki', 'rec'):
        sub_dir = os.path.join(arch, sub)
        if not os.path.isdir(sub_dir):
            continue
        for fname in sorted(os.listdir(sub_dir)):
            base, ext = os.path.splitext(fname)
            if ext.lower() not in ('.wav', '.ogg'):
                continue
            if sub == 'rec':
                if   base.endswith('_4'): theme, name = 'rec4', base[:-2]
                elif base.endswith('_3'): theme, name = 'rec3', base[:-2]
                elif base.endswith('_2'): theme, name = 'rec2', base[:-2]
                else:                     theme, name = 'rec',  base
            else:
                theme, name = sub, base
            result.append({'name': name, 'theme': theme})
    return result

class Handler(SimpleHTTPRequestHandler):

    def do_GET(self):
        try:
            if self.path == '/api/rec-files':
                self._json(200, _scan_rec())
            elif self.path == '/api/archived-files':
                self._json(200, _scan_archive())
            elif self.path.startswith('/api/before-sound/'):
                fname = self.path[len('/api/before-sound/'):]
                BEFORE_DIR = os.path.join(ROOT, 'audio_sets', 'before')
                fpath = os.path.join(BEFORE_DIR, fname)
                if os.path.exists(fpath):
                    ext = fname.rsplit('.', 1)[-1].lower()
                    ct = {'mp3': 'audio/mpeg', 'wav': 'audio/wav', 'ogg': 'audio/ogg'}.get(ext, 'application/octet-stream')
                    with open(fpath, 'rb') as f:
                        data = f.read()
                    self.send_response(200)
                    self.send_header('Content-Type', ct)
                    self.send_header('Content-Length', len(data))
                    self.send_header('Access-Control-Allow-Origin', '*')
                    self.send_header('Cache-Control', 'no-store')
                    self.end_headers()
                    self.wfile.write(data)
                else:
                    self._json(404, {'ok': False, 'error': f'파일 없음: {fname}'})
            elif self.path.startswith('/api/client-sound/'):
                fname = self.path[len('/api/client-sound/'):]
                CLIENT_SOUND = '/Users/estherpark/solitaire-tripeaks-client/assets/bundles/sound'
                fpath = os.path.join(CLIENT_SOUND, fname)
                if os.path.exists(fpath):
                    ext = fname.rsplit('.', 1)[-1].lower()
                    ct = {'mp3': 'audio/mpeg', 'wav': 'audio/wav', 'ogg': 'audio/ogg'}.get(ext, 'application/octet-stream')
                    with open(fpath, 'rb') as f:
                        data = f.read()
                    self.send_response(200)
                    self.send_header('Content-Type', ct)
                    self.send_header('Content-Length', len(data))
                    self.send_header('Access-Control-Allow-Origin', '*')
                    self.send_header('Cache-Control', 'no-store')
                    self.end_headers()
                    self.wfile.write(data)
                else:
                    self._json(404, {'ok': False, 'error': f'파일 없음: {fname}'})
            else:
                super().do_GET()
        except Exception:
            traceback.print_exc()
            try:
                self._json(500, {'ok': False, 'error': traceback.format_exc()})
            except Exception:
                pass

    def do_POST(self):
        try:
            length = int(self.headers.get('Content-Length', 0))
            body   = self.rfile.read(length)

            if self.path == '/api/save-selections':
                data = json.loads(body)
                with open(SAVE_PATH, 'w', encoding='utf-8') as f:
                    json.dump(data, f, ensure_ascii=False, indent=2)
                print(f'[saved] {len(data)}개')
                self._json(200, {'ok': True, 'saved': len(data)})

            elif self.path == '/api/save-deck-feedback':
                data = json.loads(body)
                deck_path = os.path.join(ROOT, 'solitaire-maps', 'deck_feedback.json')
                with open(deck_path, 'w', encoding='utf-8') as f:
                    json.dump(data, f, ensure_ascii=False, indent=2)
                count = data.get('count', len(data.get('items', [])))
                print(f'[deck-feedback] {count}개 → {deck_path}')
                self._json(200, {'ok': True, 'saved': count, 'path': deck_path})

            elif self.path == '/api/save-stack-actions':
                data = json.loads(body)
                actions_path = os.path.join(ROOT, 'solitaire-maps', 'stack_actions.json')
                with open(actions_path, 'w', encoding='utf-8') as f:
                    json.dump(data, f, ensure_ascii=False, indent=2)
                counts = {'remove': 0, 'replace': 0}
                for it in data.get('items', []):
                    a = it.get('action')
                    if a in counts: counts[a] += 1
                print(f'[stack-actions] remove={counts["remove"]} replace={counts["replace"]} → {actions_path}')
                self._json(200, {'ok': True, 'saved': len(data.get('items', [])), **counts, 'path': actions_path})

            elif self.path == '/api/apply-deck-suggestions':
                import glob as _glob, re as _re
                data = json.loads(body)
                items = data.get('items', [])
                def _obj_id(fn):
                    m = _re.search(r'obj_(-?\d+)_', fn)
                    return m.group(1) if m else None
                search_bases = [
                    os.path.join(ROOT, 'solitaire-maps', 'converted', 'test'),
                    os.path.join(ROOT, 'solitaire-maps', 'converted', 'schedule'),
                    os.path.join(ROOT, 'solitaire-maps', 'converted', 'level_data'),
                ]
                updated_files = 0
                per_stage = []
                for it in items:
                    if it.get('checked'): continue
                    fn = it.get('fn', '')
                    new_deck = int(it.get('new_deck', 0))
                    if not fn or not new_deck: continue
                    oid = _obj_id(fn)
                    if not oid: continue
                    hits = []
                    for base in search_bases:
                        for p in _glob.glob(os.path.join(base, '**', f'*{oid}*.json'), recursive=True):
                            parts = p.split(os.sep)
                            if '_excluded' in parts or 'temp_unchecked' in parts: continue
                            hits.append(p)
                    stage_upd = 0
                    for p in hits:
                        with open(p) as f: d = json.load(f)
                        changed = False
                        if d.get('randomCardCount') != new_deck:
                            d['randomCardCount'] = new_deck
                            changed = True
                        # cr<rc 제약만 보정 (cr는 시트 기준이 아니므로 최소개입)
                        cr = d.get('clearRandomCardCount', 0)
                        if cr >= new_deck:
                            d['clearRandomCardCount'] = max(1, new_deck - 1)
                            changed = True
                        if changed:
                            with open(p, 'w') as f: json.dump(d, f, indent=2, ensure_ascii=False)
                            stage_upd += 1; updated_files += 1
                    per_stage.append({'sid':it.get('sid'),'new_deck':new_deck,'files':stage_upd})
                print(f'[apply-deck] updated {updated_files} files across {len(per_stage)} stages (rc only)')
                self._json(200, {'ok': True, 'updated_files': updated_files, 'stages': per_stage})

            elif self.path == '/api/organize-unchecked-maps':
                import glob as _glob
                data = json.loads(body)
                items = data.get('items', [])
                temp_dir = os.path.join(ROOT, 'solitaire-maps', 'converted', 'schedule', 'week_00_launch', 'temp_unchecked')
                # Clear existing
                if os.path.isdir(temp_dir):
                    shutil.rmtree(temp_dir)
                os.makedirs(temp_dir, exist_ok=True)
                copied, missing = 0, []
                search_bases = [
                    os.path.join(ROOT, 'solitaire-maps', 'converted', 'test'),
                    os.path.join(ROOT, 'solitaire-maps', 'converted', 'schedule'),
                    os.path.join(ROOT, 'solitaire-maps', 'converted', 'level_data'),
                ]
                for it in items:
                    if it.get('checked'): continue
                    fn = it.get('fn')
                    if not fn: continue
                    src = None
                    for base in search_bases:
                        hits = _glob.glob(os.path.join(base, '**', fn), recursive=True)
                        hits = [h for h in hits if '_excluded' not in h.split(os.sep)]
                        if hits:
                            src = hits[0]; break
                    if src:
                        shutil.copy2(src, os.path.join(temp_dir, fn))
                        copied += 1
                    else:
                        missing.append(it.get('sid', fn))
                print(f'[organize-unchecked] {copied}개 → {temp_dir} (missing: {len(missing)})')
                self._json(200, {'ok': True, 'copied': copied, 'missing': missing, 'path': temp_dir})

            elif self.path == '/api/archive-sound':
                d = json.loads(body)
                name, theme = d['name'], d['theme']
                src = _resolve_src(name, theme)
                if not src:
                    self._json(404, {'ok': False, 'error': f'파일 없음: {name} ({theme})'})
                    return
                sub = 'rec' if theme.startswith('rec') else theme
                arch_dir = os.path.join(ROOT, 'audio_sets', 'archive', sub)
                os.makedirs(arch_dir, exist_ok=True)
                dest = os.path.join(arch_dir, os.path.basename(src))
                shutil.move(src, dest)
                print(f'[archive] {src} → {dest}')
                self._json(200, {'ok': True})

            elif self.path == '/api/restore-sound':
                d = json.loads(body)
                name, theme = d['name'], d['theme']
                src = _resolve_archive(name, theme)
                if not src:
                    self._json(404, {'ok': False, 'error': f'아카이브에 없음: {name} ({theme})'})
                    return
                if theme in ('rec', 'rec2', 'rec3', 'rec4'):
                    dest_dir = os.path.join(ROOT, 'audio_sets', 'rec')
                elif theme == 'tiki':
                    dest_dir = os.path.join(ROOT, 'audio_sets', 'tiki')
                else:
                    dest_dir = os.path.join(ROOT, 'audio_sets', theme)
                os.makedirs(dest_dir, exist_ok=True)
                dest = os.path.join(dest_dir, os.path.basename(src))
                shutil.move(src, dest)
                print(f'[restore] {src} → {dest}')
                self._json(200, {'ok': True})

            elif self.path == '/api/copy-sound':
                d = json.loads(body)
                from_name, from_theme = d['from_name'], d['from_theme']
                to_name,   to_slot    = d['to_name'],   d['to_slot']
                src = _resolve_src(from_name, from_theme)
                if src is None:
                    self._json(404, {'ok': False, 'error': f'소스 없음: {from_name} ({from_theme})'})
                    return
                dest = _copy_to_slot(src, to_name, to_slot)
                print(f'[copy] {src} → {dest}')
                self._json(200, {'ok': True, 'dest': dest})

            else:
                self._json(404, {'ok': False, 'error': f'unknown path: {self.path}'})

        except Exception:
            traceback.print_exc()
            try:
                self._json(500, {'ok': False, 'error': traceback.format_exc()})
            except Exception:
                pass

    def _json(self, code, obj):
        body = json.dumps(obj, ensure_ascii=False).encode()
        self.send_response(code)
        self.send_header('Content-Type', 'application/json; charset=utf-8')
        self.send_header('Content-Length', len(body))
        self.send_header('Access-Control-Allow-Origin', '*')
        self.end_headers()
        self.wfile.write(body)

    def end_headers(self):
        path = self.path.split('?')[0]
        if path.endswith(('.wav', '.ogg', '.mp3')):
            self.send_header('Cache-Control', 'no-store')
        super().end_headers()

    def log_message(self, fmt, *args):
        pass  # 조용한 로그

if __name__ == '__main__':
    os.chdir(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
    print(f'ROOT: {ROOT}')
    print('서버 시작: http://localhost:8080/docs/sound-list.html')
    HTTPServer(('', 8080), Handler).serve_forever()
