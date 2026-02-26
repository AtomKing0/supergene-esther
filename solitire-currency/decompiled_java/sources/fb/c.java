package fb;

import android.content.res.TypedArray;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import v8.k0;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c {
    @NotNull
    public static final /* synthetic */ Map<String, Object> a(@NotNull InputStream inputStream) {
        Object objValueOf;
        t.j(inputStream, "inputStream");
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
                throw new a();
            }
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String key = jsonReader.nextName();
                JsonToken jsonTokenPeek = jsonReader.peek();
                if (jsonTokenPeek != null) {
                    int i10 = b.f25777a[jsonTokenPeek.ordinal()];
                    if (i10 == 1) {
                        objValueOf = Double.valueOf(jsonReader.nextDouble());
                    } else if (i10 == 2) {
                        objValueOf = Boolean.valueOf(jsonReader.nextBoolean());
                    } else if (i10 == 3) {
                        objValueOf = jsonReader.nextString();
                    }
                    t.e(objValueOf, "when (it.peek()) {\n     …Exception()\n            }");
                    t.e(key, "key");
                    linkedHashMap.put(key, objValueOf);
                }
                throw new a();
            }
            jsonReader.endObject();
            if (jsonReader.peek() != JsonToken.END_DOCUMENT) {
                throw new a();
            }
            k0 k0Var = k0.f35197a;
            f9.c.a(jsonReader, null);
            return linkedHashMap;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                f9.c.a(jsonReader, th);
                throw th2;
            }
        }
    }

    @NotNull
    public static final /* synthetic */ String b(@NotNull TypedArray getStringOrEmpty, int i10) {
        t.j(getStringOrEmpty, "$this$getStringOrEmpty");
        String string = getStringOrEmpty.getString(i10);
        if (string == null) {
            string = "";
        }
        t.e(string, "getString(idRes) ?: EMPTY");
        return string;
    }

    @Nullable
    public static final /* synthetic */ JSONObject c(@NotNull Map<String, ? extends Object> map) {
        t.j(map, "map");
        if (!map.isEmpty()) {
            return new JSONObject(map);
        }
        return null;
    }
}
