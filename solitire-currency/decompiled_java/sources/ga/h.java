package ga;

import com.ironsource.nb;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Challenge.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f26079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Map<String, String> f26080b;

    public h(@NotNull String scheme, @NotNull Map<String, String> authParams) {
        String lowerCase;
        kotlin.jvm.internal.t.i(scheme, "scheme");
        kotlin.jvm.internal.t.i(authParams, "authParams");
        this.f26079a = scheme;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : authParams.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key == null) {
                lowerCase = null;
            } else {
                Locale US = Locale.US;
                kotlin.jvm.internal.t.h(US, "US");
                lowerCase = key.toLowerCase(US);
                kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            }
            linkedHashMap.put(lowerCase, value);
        }
        Map<String, String> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        kotlin.jvm.internal.t.h(mapUnmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.f26080b = mapUnmodifiableMap;
    }

    @NotNull
    public final Charset a() {
        String str = this.f26080b.get(nb.M);
        if (str != null) {
            try {
                Charset charsetForName = Charset.forName(str);
                kotlin.jvm.internal.t.h(charsetForName, "forName(charset)");
                return charsetForName;
            } catch (Exception unused) {
            }
        }
        Charset ISO_8859_1 = StandardCharsets.ISO_8859_1;
        kotlin.jvm.internal.t.h(ISO_8859_1, "ISO_8859_1");
        return ISO_8859_1;
    }

    @Nullable
    public final String b() {
        return this.f26080b.get("realm");
    }

    @NotNull
    public final String c() {
        return this.f26079a;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (kotlin.jvm.internal.t.d(hVar.f26079a, this.f26079a) && kotlin.jvm.internal.t.d(hVar.f26080b, this.f26080b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((899 + this.f26079a.hashCode()) * 31) + this.f26080b.hashCode();
    }

    @NotNull
    public String toString() {
        return this.f26079a + " authParams=" + this.f26080b;
    }
}
