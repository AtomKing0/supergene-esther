package s7;

import g8.r;
import h9.l;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v7.g;
import v8.k0;
import y7.m;
import y7.n;

/* JADX INFO: compiled from: HttpClientConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b<T extends g> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f33619g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Map<g8.a<?>, l<s7.a, k0>> f33613a = new LinkedHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Map<g8.a<?>, l<Object, k0>> f33614b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final Map<String, l<s7.a, k0>> f33615c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private l<? super T, k0> f33616d = a.f33621g;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f33617e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f33618f = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f33620h = r.f25911a.b();

    /* JADX INFO: compiled from: HttpClientConfig.kt */
    static final class a extends v implements l<T, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f33621g = new a();

        a() {
            super(1);
        }

        public final void a(@NotNull T t10) {
            t.i(t10, "$this$null");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Object obj) {
            a((g) obj);
            return k0.f35197a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: s7.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HttpClientConfig.kt */
    public static final class C0673b extends v implements l {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final C0673b f33622g = new C0673b();

        C0673b() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m4220invoke(@NotNull Object obj) {
            t.i(obj, "$this$null");
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m4220invoke(obj);
            return k0.f35197a;
        }
    }

    /* JADX WARN: Unknown type variable: TBuilder in type: h9.l<TBuilder, v8.k0> */
    /* JADX INFO: compiled from: HttpClientConfig.kt */
    static final class c extends v implements l<Object, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ l<Object, k0> f33623g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ l<TBuilder, k0> f33624h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unknown type variable: TBuilder in type: h9.l<? super TBuilder, v8.k0> */
        c(l<Object, k0> lVar, l<? super TBuilder, k0> lVar2) {
            super(1);
            this.f33623g = lVar;
            this.f33624h = lVar2;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Object obj) {
            invoke2(obj);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Object obj) {
            t.i(obj, "$this$null");
            l<Object, k0> lVar = this.f33623g;
            if (lVar != null) {
                lVar.invoke(obj);
            }
            this.f33624h.invoke(obj);
        }
    }

    /* JADX WARN: Unknown type variable: TBuilder in type: y7.m<TBuilder, TPlugin> */
    /* JADX WARN: Unknown type variable: TPlugin in type: y7.m<TBuilder, TPlugin> */
    /* JADX INFO: compiled from: HttpClientConfig.kt */
    static final class d extends v implements l<s7.a, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ m<TBuilder, TPlugin> f33625g;

        /* JADX INFO: compiled from: HttpClientConfig.kt */
        static final class a extends v implements h9.a<g8.b> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final a f33626g = new a();

            a() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final g8.b invoke() {
                return g8.d.a(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unknown type variable: TBuilder in type: y7.m<? extends TBuilder, TPlugin> */
        /* JADX WARN: Unknown type variable: TPlugin in type: y7.m<? extends TBuilder, TPlugin> */
        d(m<? extends TBuilder, TPlugin> mVar) {
            super(1);
            this.f33625g = mVar;
        }

        public final void a(@NotNull s7.a scope) {
            t.i(scope, "scope");
            g8.b bVar = (g8.b) scope.getAttributes().g(n.a(), a.f33626g);
            Object obj = ((b) scope.i()).f33614b.get(this.f33625g.getKey());
            t.f(obj);
            Object objB = this.f33625g.b((l) obj);
            this.f33625g.a(objB, scope);
            bVar.c(this.f33625g.getKey(), objB);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(s7.a aVar) {
            a(aVar);
            return k0.f35197a;
        }
    }

    public static /* synthetic */ void j(b bVar, m mVar, l lVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            lVar = C0673b.f33622g;
        }
        bVar.i(mVar, lVar);
    }

    public final boolean b() {
        return this.f33620h;
    }

    @NotNull
    public final l<T, k0> c() {
        return this.f33616d;
    }

    public final boolean d() {
        return this.f33619g;
    }

    public final boolean e() {
        return this.f33617e;
    }

    public final boolean f() {
        return this.f33618f;
    }

    public final void g(@NotNull String key, @NotNull l<? super s7.a, k0> block) {
        t.i(key, "key");
        t.i(block, "block");
        this.f33615c.put(key, block);
    }

    public final void h(@NotNull s7.a client) {
        t.i(client, "client");
        Iterator<T> it = this.f33613a.values().iterator();
        while (it.hasNext()) {
            ((l) it.next()).invoke(client);
        }
        Iterator<T> it2 = this.f33615c.values().iterator();
        while (it2.hasNext()) {
            ((l) it2.next()).invoke(client);
        }
    }

    public final <TBuilder, TPlugin> void i(@NotNull m<? extends TBuilder, TPlugin> plugin, @NotNull l<? super TBuilder, k0> configure) {
        t.i(plugin, "plugin");
        t.i(configure, "configure");
        this.f33614b.put(plugin.getKey(), new c(this.f33614b.get(plugin.getKey()), configure));
        if (this.f33613a.containsKey(plugin.getKey())) {
            return;
        }
        this.f33613a.put(plugin.getKey(), new d(plugin));
    }

    public final void k(@NotNull b<? extends T> other) {
        t.i(other, "other");
        this.f33617e = other.f33617e;
        this.f33618f = other.f33618f;
        this.f33619g = other.f33619g;
        this.f33613a.putAll(other.f33613a);
        this.f33614b.putAll(other.f33614b);
        this.f33615c.putAll(other.f33615c);
    }
}
