import UnityPy
import json
import os

BUNDLE_PATH = "decompiled_resources/assets/aa/Android/levelsassetgroup_assets_levels_5a6ffb8d4dae6b85682f5d35a7e4c59f.bundle"

def analyze():
    env = UnityPy.load(BUNDLE_PATH)

    print(f"=== 번들 내 오브젝트 목록 ===")
    type_count = {}
    for obj in env.objects:
        t = str(obj.type)
        type_count[t] = type_count.get(t, 0) + 1

    for t, cnt in sorted(type_count.items(), key=lambda x: -x[1]):
        print(f"  {t}: {cnt}개")

    print("\n=== 오브젝트 상세 분석 ===")
    os.makedirs("level_data", exist_ok=True)

    for obj in env.objects:
        try:
            data = obj.read()
            name = getattr(data, 'name', f"obj_{obj.path_id}")

            # TextAsset (JSON/텍스트 레벨 데이터)
            if obj.type.name == "TextAsset":
                print(f"\n[TextAsset] {name}")
                script = data.script
                if isinstance(script, bytes):
                    try:
                        text = script.decode('utf-8')
                    except:
                        text = script.decode('latin-1')
                else:
                    text = str(script)

                print(text[:500])
                out_path = f"level_data/{name}.txt"
                with open(out_path, 'w', encoding='utf-8') as f:
                    f.write(text)
                print(f"  → 저장: {out_path}")

            # MonoBehaviour (게임 오브젝트 컴포넌트)
            elif obj.type.name == "MonoBehaviour":
                print(f"\n[MonoBehaviour] {name} (path_id={obj.path_id})")
                try:
                    tree = obj.read_typetree()
                    print(json.dumps(tree, indent=2, ensure_ascii=False)[:1000])
                    out_path = f"level_data/{name}_{obj.path_id}.json"
                    with open(out_path, 'w', encoding='utf-8') as f:
                        json.dump(tree, f, indent=2, ensure_ascii=False)
                    print(f"  → 저장: {out_path}")
                except Exception as e:
                    print(f"  typetree 파싱 실패: {e}")

            # GameObject
            elif obj.type.name == "GameObject":
                print(f"\n[GameObject] {name}")

        except Exception as e:
            print(f"  오브젝트 읽기 실패 (path_id={obj.path_id}): {e}")

if __name__ == "__main__":
    analyze()