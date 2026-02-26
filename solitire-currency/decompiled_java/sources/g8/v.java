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
public class v implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f25918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Map<String, List<String>> f25919b;

    /* JADX INFO: compiled from: StringValues.kt */
    static final class a extends kotlin.jvm.internal.v implements h9.p<String, List<? extends String>, k0> {
        a() {
            super(2);
        }

        public final void a(@NotNull String name, @NotNull List<String> values) {
            kotlin.jvm.internal.t.i(name, "name");
            kotlin.jvm.internal.t.i(values, "values");
            v.this.d(name, values);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(String str, List<? extends String> list) {
            a(str, list);
            return k0.f35197a;
        }
    }

    public v(boolean z10, int i10) {
        this.f25918a = z10;
        this.f25919b = z10 ? k.a() : new LinkedHashMap<>(i10);
    }

    private final List<String> g(String str) {
        List<String> list = this.f25919b.get(str);
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        l(str);
        this.f25919b.put(str, arrayList);
        return arrayList;
    }

    @Override // g8.u
    @NotNull
    public Set<Map.Entry<String, List<String>>> a() {
        return j.a(this.f25919b.entrySet());
    }

    @Override // g8.u
    public final boolean b() {
        return this.f25918a;
    }

    @Override // g8.u
    @Nullable
    public List<String> c(@NotNull String name) {
        kotlin.jvm.internal.t.i(name, "name");
        return this.f25919b.get(name);
    }

    @Override // g8.u
    public void clear() {
        this.f25919b.clear();
    }

    @Override // g8.u
    public boolean contains(@NotNull String name) {
        kotlin.jvm.internal.t.i(name, "name");
        return this.f25919b.containsKey(name);
    }

    @Override // g8.u
    public void d(@NotNull String name, @NotNull Iterable<String> values) {
        kotlin.jvm.internal.t.i(name, "name");
        kotlin.jvm.internal.t.i(values, "values");
        List<String> listG = g(name);
        for (String str : values) {
            m(str);
            listG.add(str);
        }
    }

    @Override // g8.u
    public void e(@NotNull t stringValues) {
        kotlin.jvm.internal.t.i(stringValues, "stringValues");
        stringValues.d(new a());
    }

    @Override // g8.u
    public void f(@NotNull String name, @NotNull String value) {
        kotlin.jvm.internal.t.i(name, "name");
        kotlin.jvm.internal.t.i(value, "value");
        m(value);
        g(name).add(value);
    }

    @Nullable
    public String h(@NotNull String name) {
        kotlin.jvm.internal.t.i(name, "name");
        List<String> listC = c(name);
        if (listC != null) {
            return (String) d0.k0(listC);
        }
        return null;
    }

    @NotNull
    protected final Map<String, List<String>> i() {
        return this.f25919b;
    }

    @Override // g8.u
    public boolean isEmpty() {
        return this.f25919b.isEmpty();
    }

    public void j(@NotNull String name) {
        kotlin.jvm.internal.t.i(name, "name");
        this.f25919b.remove(name);
    }

    public void k(@NotNull String name, @NotNull String value) {
        kotlin.jvm.internal.t.i(name, "name");
        kotlin.jvm.internal.t.i(value, "value");
        m(value);
        List<String> listG = g(name);
        listG.clear();
        listG.add(value);
    }

    protected void l(@NotNull String name) {
        kotlin.jvm.internal.t.i(name, "name");
    }

    protected void m(@NotNull String value) {
        kotlin.jvm.internal.t.i(value, "value");
    }

    @Override // g8.u
    @NotNull
    public Set<String> names() {
        return this.f25919b.keySet();
    }
}
