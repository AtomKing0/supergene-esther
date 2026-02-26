package j;

import java.util.List;
import kotlin.collections.d0;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import m.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p.i;
import p.m;
import v.n;
import v8.s;
import v8.y;

/* JADX INFO: compiled from: ComponentRegistry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final List<q.b> f28536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<s<s.d<? extends Object, ? extends Object>, Class<? extends Object>>> f28537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final List<s<r.b<? extends Object>, Class<? extends Object>>> f28538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final List<s<i.a<? extends Object>, Class<? extends Object>>> f28539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final List<i.a> f28540e;

    /* JADX INFO: compiled from: ComponentRegistry.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final List<q.b> f28541a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final List<s<s.d<? extends Object, ?>, Class<? extends Object>>> f28542b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final List<s<r.b<? extends Object>, Class<? extends Object>>> f28543c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        private final List<s<i.a<? extends Object>, Class<? extends Object>>> f28544d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        private final List<i.a> f28545e;

        public a(@NotNull b bVar) {
            this.f28541a = d0.R0(bVar.c());
            this.f28542b = d0.R0(bVar.e());
            this.f28543c = d0.R0(bVar.d());
            this.f28544d = d0.R0(bVar.b());
            this.f28545e = d0.R0(bVar.a());
        }

        @NotNull
        public final a a(@NotNull i.a aVar) {
            this.f28545e.add(aVar);
            return this;
        }

        @NotNull
        public final <T> a b(@NotNull i.a<T> aVar, @NotNull Class<T> cls) {
            this.f28544d.add(y.a(aVar, cls));
            return this;
        }

        @NotNull
        public final <T> a c(@NotNull r.b<T> bVar, @NotNull Class<T> cls) {
            this.f28543c.add(y.a(bVar, cls));
            return this;
        }

        @NotNull
        public final <T> a d(@NotNull s.d<T, ?> dVar, @NotNull Class<T> cls) {
            this.f28542b.add(y.a(dVar, cls));
            return this;
        }

        @NotNull
        public final b e() {
            return new b(a0.c.a(this.f28541a), a0.c.a(this.f28542b), a0.c.a(this.f28543c), a0.c.a(this.f28544d), a0.c.a(this.f28545e), null);
        }

        @NotNull
        public final List<i.a> f() {
            return this.f28545e;
        }

        @NotNull
        public final List<s<i.a<? extends Object>, Class<? extends Object>>> g() {
            return this.f28544d;
        }
    }

    public /* synthetic */ b(List list, List list2, List list3, List list4, List list5, k kVar) {
        this(list, list2, list3, list4, list5);
    }

    @NotNull
    public final List<i.a> a() {
        return this.f28540e;
    }

    @NotNull
    public final List<s<i.a<? extends Object>, Class<? extends Object>>> b() {
        return this.f28539d;
    }

    @NotNull
    public final List<q.b> c() {
        return this.f28536a;
    }

    @NotNull
    public final List<s<r.b<? extends Object>, Class<? extends Object>>> d() {
        return this.f28538c;
    }

    @NotNull
    public final List<s<s.d<? extends Object, ? extends Object>, Class<? extends Object>>> e() {
        return this.f28537b;
    }

    @Nullable
    public final String f(@NotNull Object obj, @NotNull n nVar) {
        List<s<r.b<? extends Object>, Class<? extends Object>>> list = this.f28538c;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            s<r.b<? extends Object>, Class<? extends Object>> sVar = list.get(i10);
            r.b<? extends Object> bVarA = sVar.a();
            if (sVar.b().isAssignableFrom(obj.getClass())) {
                t.g(bVarA, "null cannot be cast to non-null type coil.key.Keyer<kotlin.Any>");
                String strA = bVarA.a(obj, nVar);
                if (strA != null) {
                    return strA;
                }
            }
        }
        return null;
    }

    @NotNull
    public final Object g(@NotNull Object obj, @NotNull n nVar) {
        List<s<s.d<? extends Object, ? extends Object>, Class<? extends Object>>> list = this.f28537b;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            s<s.d<? extends Object, ? extends Object>, Class<? extends Object>> sVar = list.get(i10);
            s.d<? extends Object, ? extends Object> dVarA = sVar.a();
            if (sVar.b().isAssignableFrom(obj.getClass())) {
                t.g(dVarA, "null cannot be cast to non-null type coil.map.Mapper<kotlin.Any, *>");
                Object objA = dVarA.a(obj, nVar);
                if (objA != null) {
                    obj = objA;
                }
            }
        }
        return obj;
    }

    @NotNull
    public final a h() {
        return new a(this);
    }

    @Nullable
    public final s<m.i, Integer> i(@NotNull m mVar, @NotNull n nVar, @NotNull e eVar, int i10) {
        int size = this.f28540e.size();
        while (i10 < size) {
            m.i iVarA = this.f28540e.get(i10).a(mVar, nVar, eVar);
            if (iVarA != null) {
                return y.a(iVarA, Integer.valueOf(i10));
            }
            i10++;
        }
        return null;
    }

    @Nullable
    public final s<p.i, Integer> j(@NotNull Object obj, @NotNull n nVar, @NotNull e eVar, int i10) {
        int size = this.f28539d.size();
        while (i10 < size) {
            s<i.a<? extends Object>, Class<? extends Object>> sVar = this.f28539d.get(i10);
            i.a<? extends Object> aVarA = sVar.a();
            if (sVar.b().isAssignableFrom(obj.getClass())) {
                t.g(aVarA, "null cannot be cast to non-null type coil.fetch.Fetcher.Factory<kotlin.Any>");
                p.i iVarA = aVarA.a(obj, nVar, eVar);
                if (iVarA != null) {
                    return y.a(iVarA, Integer.valueOf(i10));
                }
            }
            i10++;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private b(List<? extends q.b> list, List<? extends s<? extends s.d<? extends Object, ? extends Object>, ? extends Class<? extends Object>>> list2, List<? extends s<? extends r.b<? extends Object>, ? extends Class<? extends Object>>> list3, List<? extends s<? extends i.a<? extends Object>, ? extends Class<? extends Object>>> list4, List<? extends i.a> list5) {
        this.f28536a = list;
        this.f28537b = list2;
        this.f28538c = list3;
        this.f28539d = list4;
        this.f28540e = list5;
    }

    public b() {
        this(v.l(), v.l(), v.l(), v.l(), v.l());
    }
}
