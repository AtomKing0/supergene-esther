package s7;

import a8.f;
import a8.h;
import h9.l;
import h9.q;
import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.f2;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v7.g;
import v8.k0;
import v8.u;
import y7.k;
import y7.n;
import y7.o;
import y7.s;
import y7.x;

/* JADX INFO: compiled from: HttpClient.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements o0, Closeable {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f33587n = AtomicIntegerFieldUpdater.newUpdater(a.class, "closed");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final v7.b f33588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final s7.b<? extends g> f33589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f33590c;

    @NotNull
    private volatile /* synthetic */ int closed;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final a0 f33591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final z8.g f33592e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final f f33593f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final b8.f f33594g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final h f33595h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private final b8.b f33596i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private final g8.b f33597j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private final g f33598k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private final d8.b f33599l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    private final s7.b<g> f33600m;

    /* JADX INFO: renamed from: s7.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HttpClient.kt */
    static final class C0672a extends v implements l<Throwable, k0> {
        C0672a() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
            invoke2(th);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Throwable th) {
            if (th != null) {
                p0.e(a.this.n(), null, 1, null);
            }
        }
    }

    /* JADX INFO: compiled from: HttpClient.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.HttpClient$2", f = "HttpClient.kt", l = {144, 146}, m = "invokeSuspend")
    static final class b extends kotlin.coroutines.jvm.internal.l implements q<l8.e<Object, a8.c>, Object, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f33602j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private /* synthetic */ Object f33603k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f33604l;

        b(z8.d<? super b> dVar) {
            super(3, dVar);
        }

        @Override // h9.q
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@NotNull l8.e<Object, a8.c> eVar, @NotNull Object obj, @Nullable z8.d<? super k0> dVar) {
            b bVar = a.this.new b(dVar);
            bVar.f33603k = eVar;
            bVar.f33604l = obj;
            return bVar.invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object obj2;
            l8.e eVar;
            Object objE = a9.d.e();
            int i10 = this.f33602j;
            if (i10 == 0) {
                u.b(obj);
                l8.e eVar2 = (l8.e) this.f33603k;
                obj2 = this.f33604l;
                if (!(obj2 instanceof t7.b)) {
                    throw new IllegalStateException(("Error: HttpClientCall expected, but found " + obj2 + '(' + kotlin.jvm.internal.o0.b(obj2.getClass()) + ").").toString());
                }
                b8.b bVarX = a.this.x();
                k0 k0Var = k0.f35197a;
                b8.c cVarF = ((t7.b) obj2).f();
                this.f33603k = eVar2;
                this.f33604l = obj2;
                this.f33602j = 1;
                Object objD = bVarX.d(k0Var, cVarF, this);
                if (objD == objE) {
                    return objE;
                }
                eVar = eVar2;
                obj = objD;
            } else {
                if (i10 != 1) {
                    if (i10 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                    return k0.f35197a;
                }
                obj2 = this.f33604l;
                eVar = (l8.e) this.f33603k;
                u.b(obj);
            }
            ((t7.b) obj2).k((b8.c) obj);
            this.f33603k = null;
            this.f33604l = null;
            this.f33602j = 2;
            if (eVar.e(obj2, this) == objE) {
                return objE;
            }
            return k0.f35197a;
        }
    }

    /* JADX INFO: compiled from: HttpClient.kt */
    static final class c extends v implements l<a, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f33606g = new c();

        c() {
            super(1);
        }

        public final void a(@NotNull a install) {
            t.i(install, "$this$install");
            y7.g.b(install);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(a aVar) {
            a(aVar);
            return k0.f35197a;
        }
    }

    /* JADX INFO: compiled from: HttpClient.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.HttpClient$4", f = "HttpClient.kt", l = {177}, m = "invokeSuspend")
    static final class d extends kotlin.coroutines.jvm.internal.l implements q<l8.e<b8.d, t7.b>, b8.d, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f33607j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private /* synthetic */ Object f33608k;

        d(z8.d<? super d> dVar) {
            super(3, dVar);
        }

        @Override // h9.q
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@NotNull l8.e<b8.d, t7.b> eVar, @NotNull b8.d dVar, @Nullable z8.d<? super k0> dVar2) {
            d dVar3 = a.this.new d(dVar2);
            dVar3.f33608k = eVar;
            return dVar3.invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            l8.e eVar;
            Throwable th;
            Object objE = a9.d.e();
            int i10 = this.f33607j;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eVar = (l8.e) this.f33608k;
                try {
                    u.b(obj);
                    return k0.f35197a;
                } catch (Throwable th2) {
                    th = th2;
                    a.this.q().a(c8.b.d(), new c8.f(((t7.b) eVar.c()).f(), th));
                    throw th;
                }
            }
            u.b(obj);
            l8.e eVar2 = (l8.e) this.f33608k;
            try {
                this.f33608k = eVar2;
                this.f33607j = 1;
                if (eVar2.d(this) == objE) {
                    return objE;
                }
                return k0.f35197a;
            } catch (Throwable th3) {
                eVar = eVar2;
                th = th3;
                a.this.q().a(c8.b.d(), new c8.f(((t7.b) eVar.c()).f(), th));
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: HttpClient.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.HttpClient", f = "HttpClient.kt", l = {191}, m = "execute$ktor_client_core")
    static final class e extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        /* synthetic */ Object f33610j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f33612l;

        e(z8.d<? super e> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f33610j = obj;
            this.f33612l |= Integer.MIN_VALUE;
            return a.this.c(null, this);
        }
    }

    public a(@NotNull v7.b engine, @NotNull s7.b<? extends g> userConfig) {
        t.i(engine, "engine");
        t.i(userConfig, "userConfig");
        this.f33588a = engine;
        this.f33589b = userConfig;
        this.closed = 0;
        a0 a0VarA = f2.a((b2) engine.getCoroutineContext().get(b2.O7));
        this.f33591d = a0VarA;
        this.f33592e = engine.getCoroutineContext().plus(a0VarA);
        this.f33593f = new f(userConfig.b());
        b8.f fVar = new b8.f(userConfig.b());
        this.f33594g = fVar;
        h hVar = new h(userConfig.b());
        this.f33595h = hVar;
        this.f33596i = new b8.b(userConfig.b());
        this.f33597j = g8.d.a(true);
        this.f33598k = engine.r();
        this.f33599l = new d8.b();
        s7.b<g> bVar = new s7.b<>();
        this.f33600m = bVar;
        if (this.f33590c) {
            a0VarA.J(new C0672a());
        }
        engine.c0(this);
        hVar.l(h.f368h.b(), new b(null));
        s7.b.j(bVar, s.f36796a, null, 2, null);
        s7.b.j(bVar, y7.a.f36641a, null, 2, null);
        if (userConfig.f()) {
            bVar.g("DefaultTransformers", c.f33606g);
        }
        s7.b.j(bVar, x.f36861c, null, 2, null);
        s7.b.j(bVar, k.f36711d, null, 2, null);
        if (userConfig.e()) {
            s7.b.j(bVar, y7.q.f36769c, null, 2, null);
        }
        bVar.k(userConfig);
        if (userConfig.f()) {
            s7.b.j(bVar, o.f36751d, null, 2, null);
        }
        y7.f.c(bVar);
        bVar.h(this);
        fVar.l(b8.f.f2253h.b(), new d(null));
    }

    @NotNull
    public final b8.f B() {
        return this.f33594g;
    }

    @NotNull
    public final h J() {
        return this.f33595h;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(@org.jetbrains.annotations.NotNull a8.c r5, @org.jetbrains.annotations.NotNull z8.d<? super t7.b> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof s7.a.e
            if (r0 == 0) goto L13
            r0 = r6
            s7.a$e r0 = (s7.a.e) r0
            int r1 = r0.f33612l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f33612l = r1
            goto L18
        L13:
            s7.a$e r0 = new s7.a$e
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f33610j
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f33612l
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            v8.u.b(r6)
            goto L4c
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            v8.u.b(r6)
            d8.b r6 = r4.f33599l
            d8.a r2 = c8.b.a()
            r6.a(r2, r5)
            a8.f r6 = r4.f33593f
            java.lang.Object r2 = r5.d()
            r0.f33612l = r3
            java.lang.Object r6 = r6.d(r5, r2, r0)
            if (r6 != r1) goto L4c
            return r1
        L4c:
            java.lang.String r5 = "null cannot be cast to non-null type io.ktor.client.call.HttpClientCall"
            kotlin.jvm.internal.t.g(r6, r5)
            t7.b r6 = (t7.b) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: s7.a.c(a8.c, z8.d):java.lang.Object");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (f33587n.compareAndSet(this, 0, 1)) {
            g8.b bVar = (g8.b) this.f33597j.a(n.a());
            Iterator<T> it = bVar.f().iterator();
            while (it.hasNext()) {
                g8.a aVar = (g8.a) it.next();
                t.g(aVar, "null cannot be cast to non-null type io.ktor.util.AttributeKey<kotlin.Any>");
                Object objA = bVar.a(aVar);
                if (objA instanceof Closeable) {
                    ((Closeable) objA).close();
                }
            }
            this.f33591d.complete();
            if (this.f33590c) {
                this.f33588a.close();
            }
        }
    }

    @NotNull
    public final g8.b getAttributes() {
        return this.f33597j;
    }

    @Override // kotlinx.coroutines.o0
    @NotNull
    public z8.g getCoroutineContext() {
        return this.f33592e;
    }

    @NotNull
    public final s7.b<g> i() {
        return this.f33600m;
    }

    @NotNull
    public final v7.b n() {
        return this.f33588a;
    }

    @NotNull
    public final d8.b q() {
        return this.f33599l;
    }

    @NotNull
    public String toString() {
        return "HttpClient[" + this.f33588a + ']';
    }

    @NotNull
    public final b8.b x() {
        return this.f33596i;
    }

    @NotNull
    public final f z() {
        return this.f33593f;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@NotNull v7.b engine, @NotNull s7.b<? extends g> userConfig, boolean z10) {
        this(engine, userConfig);
        t.i(engine, "engine");
        t.i(userConfig, "userConfig");
        this.f33590c = z10;
    }
}
