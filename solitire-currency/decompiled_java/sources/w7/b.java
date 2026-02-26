package w7;

import a8.g;
import h9.l;
import h9.p;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Set;
import kotlin.collections.y0;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import y7.y;

/* JADX INFO: compiled from: AndroidClientEngine.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends v7.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final d f35436e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final Set<v7.e<?>> f35437f;

    /* JADX INFO: compiled from: AndroidClientEngine.kt */
    @f(c = "io.ktor.client.engine.android.AndroidClientEngine", f = "AndroidClientEngine.kt", l = {35, 79, 82}, m = "execute")
    static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f35438j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f35439k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Object f35440l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Object f35441m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        /* synthetic */ Object f35442n;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        int f35444p;

        a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f35442n = obj;
            this.f35444p |= Integer.MIN_VALUE;
            return b.this.B0(null, this);
        }
    }

    /* JADX INFO: renamed from: w7.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AndroidClientEngine.kt */
    static final class C0718b extends v implements l<HttpURLConnection, g> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ z8.g f35445g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ a8.d f35446h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ j8.b f35447i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0718b(z8.g gVar, a8.d dVar, j8.b bVar) {
            super(1);
            this.f35445g = gVar;
            this.f35446h = dVar;
            this.f35447i = bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0071  */
        @Override // h9.l
        @org.jetbrains.annotations.NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final a8.g invoke(@org.jetbrains.annotations.NotNull java.net.HttpURLConnection r11) throws java.io.IOException {
            /*
                r10 = this;
                java.lang.String r0 = "current"
                kotlin.jvm.internal.t.i(r11, r0)
                int r0 = r11.getResponseCode()
                java.lang.String r1 = r11.getResponseMessage()
                if (r1 == 0) goto L15
                e8.v r2 = new e8.v
                r2.<init>(r0, r1)
                goto L1b
            L15:
                e8.v$a r1 = e8.v.f25372c
                e8.v r2 = r1.a(r0)
            L1b:
                r4 = r2
                z8.g r0 = r10.f35445g
                a8.d r1 = r10.f35446h
                io.ktor.utils.io.g r8 = w7.e.a(r11, r0, r1)
                java.util.Map r11 = r11.getHeaderFields()
                java.lang.String r0 = "current.headerFields"
                kotlin.jvm.internal.t.h(r11, r0)
                java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
                int r1 = r11.size()
                int r1 = kotlin.collections.o0.d(r1)
                r0.<init>(r1)
                java.util.Set r11 = r11.entrySet()
                java.lang.Iterable r11 = (java.lang.Iterable) r11
                java.util.Iterator r11 = r11.iterator()
            L44:
                boolean r1 = r11.hasNext()
                if (r1 == 0) goto L7b
                java.lang.Object r1 = r11.next()
                java.util.Map$Entry r1 = (java.util.Map.Entry) r1
                java.lang.Object r2 = r1.getKey()
                java.lang.String r2 = (java.lang.String) r2
                if (r2 == 0) goto L71
                java.lang.String r3 = "key"
                kotlin.jvm.internal.t.h(r2, r3)
                java.util.Locale r3 = java.util.Locale.getDefault()
                java.lang.String r5 = "getDefault()"
                kotlin.jvm.internal.t.h(r3, r5)
                java.lang.String r2 = r2.toLowerCase(r3)
                java.lang.String r3 = "this as java.lang.String).toLowerCase(locale)"
                kotlin.jvm.internal.t.h(r2, r3)
                if (r2 != 0) goto L73
            L71:
                java.lang.String r2 = ""
            L73:
                java.lang.Object r1 = r1.getValue()
                r0.put(r2, r1)
                goto L44
            L7b:
                java.util.LinkedHashMap r11 = new java.util.LinkedHashMap
                r11.<init>()
                java.util.Set r0 = r0.entrySet()
                java.util.Iterator r0 = r0.iterator()
            L88:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto Lae
                java.lang.Object r1 = r0.next()
                java.util.Map$Entry r1 = (java.util.Map.Entry) r1
                java.lang.Object r2 = r1.getKey()
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                boolean r2 = p9.h.z(r2)
                r2 = r2 ^ 1
                if (r2 == 0) goto L88
                java.lang.Object r2 = r1.getKey()
                java.lang.Object r1 = r1.getValue()
                r11.put(r2, r1)
                goto L88
            Lae:
                e8.u$a r0 = e8.u.f25361d
                e8.u r7 = r0.a()
                e8.m r6 = new e8.m
                r6.<init>(r11)
                a8.g r11 = new a8.g
                j8.b r5 = r10.f35447i
                z8.g r9 = r10.f35445g
                r3 = r11
                r3.<init>(r4, r5, r6, r7, r8, r9)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: w7.b.C0718b.invoke(java.net.HttpURLConnection):a8.g");
        }
    }

    /* JADX INFO: compiled from: AndroidClientEngine.kt */
    static final class c extends v implements p<String, String, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ HttpURLConnection f35448g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(HttpURLConnection httpURLConnection) {
            super(2);
            this.f35448g = httpURLConnection;
        }

        public final void a(@NotNull String key, @NotNull String value) {
            t.i(key, "key");
            t.i(value, "value");
            this.f35448g.addRequestProperty(key, value);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(String str, String str2) {
            a(str, str2);
            return k0.f35197a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull d config) {
        super("ktor-android");
        t.i(config, "config");
        this.f35436e = config;
        this.f35437f = y0.c(y.f36881d);
    }

    private final HttpURLConnection q(String str) throws IOException {
        URL url = new URL(str);
        Proxy proxyA = r().a();
        URLConnection uRLConnectionOpenConnection = proxyA != null ? url.openConnection(proxyA) : null;
        if (uRLConnectionOpenConnection == null) {
            uRLConnectionOpenConnection = url.openConnection();
            t.h(uRLConnectionOpenConnection, "url.openConnection()");
        }
        return (HttpURLConnection) uRLConnectionOpenConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0195 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0196 A[PHI: r1
      0x0196: PHI (r1v11 java.lang.Object) = (r1v9 java.lang.Object), (r1v1 java.lang.Object) binds: [B:51:0x0193, B:13:0x0030] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // v7.b
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object B0(@org.jetbrains.annotations.NotNull a8.d r19, @org.jetbrains.annotations.NotNull z8.d<? super a8.g> r20) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 407
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w7.b.B0(a8.d, z8.d):java.lang.Object");
    }

    @Override // v7.b
    @NotNull
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public d r() {
        return this.f35436e;
    }

    @Override // v7.c, v7.b
    @NotNull
    public Set<v7.e<?>> n0() {
        return this.f35437f;
    }
}
