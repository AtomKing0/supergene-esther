package e8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: UrlDecodedParametersBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class q0 implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final a0 f25349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f25350b;

    public q0(@NotNull a0 encodedParametersBuilder) {
        kotlin.jvm.internal.t.i(encodedParametersBuilder, "encodedParametersBuilder");
        this.f25349a = encodedParametersBuilder;
        this.f25350b = encodedParametersBuilder.b();
    }

    @Override // g8.u
    @NotNull
    public Set<Map.Entry<String, List<String>>> a() {
        return r0.d(this.f25349a).a();
    }

    @Override // g8.u
    public boolean b() {
        return this.f25350b;
    }

    @Override // e8.a0
    @NotNull
    public z build() {
        return r0.d(this.f25349a);
    }

    @Override // g8.u
    @Nullable
    public List<String> c(@NotNull String name) {
        kotlin.jvm.internal.t.i(name, "name");
        ArrayList arrayList = null;
        List<String> listC = this.f25349a.c(b.m(name, false, 1, null));
        if (listC != null) {
            List<String> list = listC;
            arrayList = new ArrayList(kotlin.collections.w.v(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(b.k((String) it.next(), 0, 0, true, null, 11, null));
            }
        }
        return arrayList;
    }

    @Override // g8.u
    public void clear() {
        this.f25349a.clear();
    }

    @Override // g8.u
    public boolean contains(@NotNull String name) {
        kotlin.jvm.internal.t.i(name, "name");
        return this.f25349a.contains(b.m(name, false, 1, null));
    }

    @Override // g8.u
    public void d(@NotNull String name, @NotNull Iterable<String> values) {
        kotlin.jvm.internal.t.i(name, "name");
        kotlin.jvm.internal.t.i(values, "values");
        a0 a0Var = this.f25349a;
        String strM = b.m(name, false, 1, null);
        ArrayList arrayList = new ArrayList(kotlin.collections.w.v(values, 10));
        Iterator<String> it = values.iterator();
        while (it.hasNext()) {
            arrayList.add(b.n(it.next()));
        }
        a0Var.d(strM, arrayList);
    }

    @Override // g8.u
    public void e(@NotNull g8.t stringValues) {
        kotlin.jvm.internal.t.i(stringValues, "stringValues");
        r0.c(this.f25349a, stringValues);
    }

    @Override // g8.u
    public void f(@NotNull String name, @NotNull String value) {
        kotlin.jvm.internal.t.i(name, "name");
        kotlin.jvm.internal.t.i(value, "value");
        this.f25349a.f(b.m(name, false, 1, null), b.n(value));
    }

    @Override // g8.u
    public boolean isEmpty() {
        return this.f25349a.isEmpty();
    }

    @Override // g8.u
    @NotNull
    public Set<String> names() {
        Set<String> setNames = this.f25349a.names();
        ArrayList arrayList = new ArrayList(kotlin.collections.w.v(setNames, 10));
        Iterator<T> it = setNames.iterator();
        while (it.hasNext()) {
            arrayList.add(b.k((String) it.next(), 0, 0, false, null, 15, null));
        }
        return kotlin.collections.d0.T0(arrayList);
    }
}
