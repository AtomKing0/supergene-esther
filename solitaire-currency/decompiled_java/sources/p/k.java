package p;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import androidx.annotation.VisibleForTesting;
import androidx.webkit.ProxyConfig;
import androidx.webkit.internal.AssetHelper;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import ga.b0;
import ga.d;
import ga.d0;
import ga.e;
import ga.e0;
import ga.x;
import java.io.IOException;
import java.util.Map;
import kotlin.jvm.internal.t;
import m.p;
import m.q;
import n.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p.i;
import p9.r;
import ua.k0;
import v.n;

/* JADX INFO: compiled from: HttpUriFetcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class k implements i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f32349f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private static final ga.d f32350g = new d.a().d().e().a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private static final ga.d f32351h = new d.a().d().f().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f32352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final n f32353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final v8.l<e.a> f32354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final v8.l<n.a> f32355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f32356e;

    /* JADX INFO: compiled from: HttpUriFetcher.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: HttpUriFetcher.kt */
    public static final class b implements i.a<Uri> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final v8.l<e.a> f32357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final v8.l<n.a> f32358b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f32359c;

        /* JADX WARN: Multi-variable type inference failed */
        public b(@NotNull v8.l<? extends e.a> lVar, @NotNull v8.l<? extends n.a> lVar2, boolean z10) {
            this.f32357a = lVar;
            this.f32358b = lVar2;
            this.f32359c = z10;
        }

        private final boolean c(Uri uri) {
            return t.d(uri.getScheme(), ProxyConfig.MATCH_HTTP) || t.d(uri.getScheme(), "https");
        }

        @Override // p.i.a
        @Nullable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public i a(@NotNull Uri uri, @NotNull n nVar, @NotNull j.e eVar) {
            if (c(uri)) {
                return new k(uri.toString(), nVar, this.f32357a, this.f32358b, this.f32359c);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: HttpUriFetcher.kt */
    @kotlin.coroutines.jvm.internal.f(c = "coil.fetch.HttpUriFetcher", f = "HttpUriFetcher.kt", l = {Sdk$SDKError.b.STALE_CACHED_RESPONSE_VALUE}, m = "executeNetworkRequest")
    static final class c extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        /* synthetic */ Object f32360j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f32362l;

        c(z8.d<? super c> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f32360j = obj;
            this.f32362l |= Integer.MIN_VALUE;
            return k.this.c(null, this);
        }
    }

    /* JADX INFO: compiled from: HttpUriFetcher.kt */
    @kotlin.coroutines.jvm.internal.f(c = "coil.fetch.HttpUriFetcher", f = "HttpUriFetcher.kt", l = {76, 105}, m = "fetch")
    static final class d extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f32363j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f32364k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Object f32365l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        /* synthetic */ Object f32366m;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        int f32368o;

        d(z8.d<? super d> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f32366m = obj;
            this.f32368o |= Integer.MIN_VALUE;
            return k.this.a(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(@NotNull String str, @NotNull n nVar, @NotNull v8.l<? extends e.a> lVar, @NotNull v8.l<? extends n.a> lVar2, boolean z10) {
        this.f32352a = str;
        this.f32353b = nVar;
        this.f32354c = lVar;
        this.f32355d = lVar2;
        this.f32356e = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(ga.b0 r5, z8.d<? super ga.d0> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof p.k.c
            if (r0 == 0) goto L13
            r0 = r6
            p.k$c r0 = (p.k.c) r0
            int r1 = r0.f32362l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f32362l = r1
            goto L18
        L13:
            p.k$c r0 = new p.k$c
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f32360j
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f32362l
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            v8.u.b(r6)
            goto L72
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            v8.u.b(r6)
            boolean r6 = a0.j.r()
            if (r6 == 0) goto L5d
            v.n r6 = r4.f32353b
            v.b r6 = r6.k()
            boolean r6 = r6.c()
            if (r6 != 0) goto L57
            v8.l<ga.e$a> r6 = r4.f32354c
            java.lang.Object r6 = r6.getValue()
            ga.e$a r6 = (ga.e.a) r6
            ga.e r5 = r6.b(r5)
            ga.d0 r5 = r5.execute()
            goto L75
        L57:
            android.os.NetworkOnMainThreadException r5 = new android.os.NetworkOnMainThreadException
            r5.<init>()
            throw r5
        L5d:
            v8.l<ga.e$a> r6 = r4.f32354c
            java.lang.Object r6 = r6.getValue()
            ga.e$a r6 = (ga.e.a) r6
            ga.e r5 = r6.b(r5)
            r0.f32362l = r3
            java.lang.Object r6 = a0.b.a(r5, r0)
            if (r6 != r1) goto L72
            return r1
        L72:
            r5 = r6
            ga.d0 r5 = (ga.d0) r5
        L75:
            boolean r6 = r5.O()
            if (r6 != 0) goto L92
            int r6 = r5.q()
            r0 = 304(0x130, float:4.26E-43)
            if (r6 == r0) goto L92
            ga.e0 r6 = r5.a()
            if (r6 == 0) goto L8c
            a0.j.d(r6)
        L8c:
            u.d r6 = new u.d
            r6.<init>(r5)
            throw r6
        L92:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p.k.c(ga.b0, z8.d):java.lang.Object");
    }

    private final String d() {
        String strH = this.f32353b.h();
        return strH == null ? this.f32352a : strH;
    }

    private final ua.j e() {
        n.a value = this.f32355d.getValue();
        t.f(value);
        return value.getFileSystem();
    }

    private final boolean g(b0 b0Var, d0 d0Var) {
        return this.f32353b.i().d() && (!this.f32356e || u.b.f34205c.b(b0Var, d0Var));
    }

    private final b0 h() {
        b0.a aVarH = new b0.a().s(this.f32352a).h(this.f32353b.j());
        for (Map.Entry<Class<?>, Object> entry : this.f32353b.o().a().entrySet()) {
            Class<?> key = entry.getKey();
            t.g(key, "null cannot be cast to non-null type java.lang.Class<kotlin.Any>");
            aVarH.q(key, entry.getValue());
        }
        boolean zC = this.f32353b.i().c();
        boolean zC2 = this.f32353b.k().c();
        if (!zC2 && zC) {
            aVarH.c(ga.d.f26001p);
        } else if (!zC2 || zC) {
            if (!zC2 && !zC) {
                aVarH.c(f32351h);
            }
        } else if (this.f32353b.i().d()) {
            aVarH.c(ga.d.f26000o);
        } else {
            aVarH.c(f32350g);
        }
        return aVarH.b();
    }

    private final a.c i() {
        n.a value;
        if (!this.f32353b.i().c() || (value = this.f32355d.getValue()) == null) {
            return null;
        }
        return value.get(d());
    }

    private final e0 j(d0 d0Var) {
        e0 e0VarA = d0Var.a();
        if (e0VarA != null) {
            return e0VarA;
        }
        throw new IllegalStateException("response body == null".toString());
    }

    private final u.a k(a.c cVar) throws Throwable {
        u.a aVar;
        try {
            ua.e eVarD = k0.d(e().q(cVar.getMetadata()));
            try {
                aVar = new u.a(eVarD);
                th = null;
            } catch (Throwable th) {
                th = th;
                aVar = null;
            }
            if (eVarD != null) {
                try {
                    eVarD.close();
                } catch (Throwable th2) {
                    if (th == null) {
                        th = th2;
                    } else {
                        v8.f.a(th, th2);
                    }
                }
            }
            if (th != null) {
                throw th;
            }
            t.f(aVar);
            return aVar;
        } catch (IOException unused) {
            return null;
        }
    }

    private final m.f l(d0 d0Var) {
        return d0Var.S() != null ? m.f.NETWORK : m.f.DISK;
    }

    private final p m(e0 e0Var) {
        return q.a(e0Var.source(), this.f32353b.g());
    }

    private final p n(a.c cVar) {
        return q.c(cVar.getData(), e(), d(), cVar);
    }

    private final a.c o(a.c cVar, b0 b0Var, d0 d0Var, u.a aVar) {
        a.b bVarA;
        v8.k0 k0Var;
        Long lValueOf;
        v8.k0 k0Var2;
        Throwable th = null;
        if (!g(b0Var, d0Var)) {
            if (cVar != null) {
                a0.j.d(cVar);
            }
            return null;
        }
        if (cVar != null) {
            bVarA = cVar.u0();
        } else {
            n.a value = this.f32355d.getValue();
            bVarA = value != null ? value.a(d()) : null;
        }
        try {
            if (bVarA == null) {
                return null;
            }
            try {
                if (d0Var.q() != 304 || aVar == null) {
                    ua.d dVarC = k0.c(e().p(bVarA.getMetadata(), false));
                    try {
                        new u.a(d0Var).g(dVarC);
                        k0Var = v8.k0.f35197a;
                        th = null;
                    } catch (Throwable th2) {
                        th = th2;
                        k0Var = null;
                    }
                    if (dVarC != null) {
                        try {
                            dVarC.close();
                        } catch (Throwable th3) {
                            if (th == null) {
                                th = th3;
                            } else {
                                v8.f.a(th, th3);
                            }
                        }
                    }
                    if (th != null) {
                        throw th;
                    }
                    t.f(k0Var);
                    ua.d dVarC2 = k0.c(e().p(bVarA.getData(), false));
                    try {
                        e0 e0VarA = d0Var.a();
                        t.f(e0VarA);
                        lValueOf = Long.valueOf(e0VarA.source().V(dVarC2));
                    } catch (Throwable th4) {
                        th = th4;
                        lValueOf = null;
                    }
                    if (dVarC2 != null) {
                        try {
                            dVarC2.close();
                        } catch (Throwable th5) {
                            if (th == null) {
                                th = th5;
                            } else {
                                v8.f.a(th, th5);
                            }
                        }
                    }
                    if (th != null) {
                        throw th;
                    }
                    t.f(lValueOf);
                } else {
                    d0 d0VarC = d0Var.W().l(u.b.f34205c.a(aVar.d(), d0Var.L())).c();
                    ua.d dVarC3 = k0.c(e().p(bVarA.getMetadata(), false));
                    try {
                        new u.a(d0VarC).g(dVarC3);
                        k0Var2 = v8.k0.f35197a;
                    } catch (Throwable th6) {
                        th = th6;
                        k0Var2 = null;
                    }
                    if (dVarC3 != null) {
                        try {
                            dVarC3.close();
                        } catch (Throwable th7) {
                            if (th == null) {
                                th = th7;
                            } else {
                                v8.f.a(th, th7);
                            }
                        }
                    }
                    if (th != null) {
                        throw th;
                    }
                    t.f(k0Var2);
                }
                return bVarA.b();
            } catch (Exception e10) {
                a0.j.a(bVarA);
                throw e10;
            }
        } finally {
            a0.j.d(d0Var);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0127 A[Catch: Exception -> 0x019a, TryCatch #2 {Exception -> 0x019a, blocks: (B:68:0x017e, B:52:0x0119, B:54:0x0127, B:56:0x0135, B:57:0x0139, B:59:0x0143, B:61:0x014b, B:63:0x0163), top: B:85:0x0119 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0143 A[Catch: Exception -> 0x019a, TryCatch #2 {Exception -> 0x019a, blocks: (B:68:0x017e, B:52:0x0119, B:54:0x0127, B:56:0x0135, B:57:0x0139, B:59:0x0143, B:61:0x014b, B:63:0x0163), top: B:85:0x0119 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // p.i
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(@org.jetbrains.annotations.NotNull z8.d<? super p.h> r13) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 429
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p.k.a(z8.d):java.lang.Object");
    }

    @VisibleForTesting
    @Nullable
    public final String f(@NotNull String str, @Nullable x xVar) {
        String strJ;
        String string = xVar != null ? xVar.toString() : null;
        if ((string == null || p9.q.K(string, AssetHelper.DEFAULT_MIME_TYPE, false, 2, null)) && (strJ = a0.j.j(MimeTypeMap.getSingleton(), str)) != null) {
            return strJ;
        }
        if (string != null) {
            return r.U0(string, ';', null, 2, null);
        }
        return null;
    }
}
