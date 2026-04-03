package g8;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.d0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: StringValues.kt */
/* JADX INFO: loaded from: classes.dex */
public class w implements t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f25921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final Map<String, List<String>> f25922d;

    public w(boolean z10, @NotNull Map<String, ? extends List<String>> values) {
        kotlin.jvm.internal.t.i(values, "values");
        this.f25921c = z10;
        Map mapA = z10 ? k.a() : new LinkedHashMap();
        for (Map.Entry<String, ? extends List<String>> entry : values.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            int size = value.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i10 = 0; i10 < size; i10++) {
                arrayList.add(value.get(i10));
            }
            mapA.put(key, arrayList);
        }
        this.f25922d = mapA;
    }

    private final List<String> e(String str) {
        return this.f25922d.get(str);
    }

    @Override // g8.t
    @NotNull
    public Set<Map.Entry<String, List<String>>> a() {
        return j.a(this.f25922d.entrySet());
    }

    @Override // g8.t
    public final boolean b() {
        return this.f25921c;
    }

    @Override // g8.t
    @Nullable
    public List<String> c(@NotNull String name) {
        kotlin.jvm.internal.t.i(name, "name");
        return e(name);
    }

    @Override // g8.t
    public void d(@NotNull h9.p<? super String, ? super List<String>, k0> body) {
        kotlin.jvm.internal.t.i(body, "body");
        for (Map.Entry<String, List<String>> entry : this.f25922d.entrySet()) {
            body.mo4invoke(entry.getKey(), entry.getValue());
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        if (this.f25921c != tVar.b()) {
            return false;
        }
        return x.d(a(), tVar.a());
    }

    @Override // g8.t
    @Nullable
    public String get(@NotNull String name) {
        kotlin.jvm.internal.t.i(name, "name");
        List<String> listE = e(name);
        if (listE != null) {
            return (String) d0.k0(listE);
        }
        return null;
    }

    public int hashCode() {
        return x.e(a(), androidx.compose.foundation.e.a(this.f25921c) * 31);
    }

    @Override // g8.t
    public boolean isEmpty() {
        return this.f25922d.isEmpty();
    }

    @Override // g8.t
    @NotNull
    public Set<String> names() {
        return j.a(this.f25922d.keySet());
    }
}
