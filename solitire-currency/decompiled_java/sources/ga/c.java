package ga;

import androidx.webkit.ProxyConfig;
import com.ironsource.nb;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import ga.b0;
import ga.d0;
import ga.u;
import ja.d;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import kotlin.jvm.internal.s0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qa.j;
import ua.f;
import ua.k0;
import ua.x0;
import ua.z0;

/* JADX INFO: compiled from: Cache.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c implements Closeable, Flushable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public static final b f25958g = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ja.d f25959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f25960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f25961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f25962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f25963e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f25964f;

    /* JADX INFO: compiled from: Cache.kt */
    private static final class a extends e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final d.C0599d f25965a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private final String f25966b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private final String f25967c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        private final ua.e f25968d;

        /* JADX INFO: renamed from: ga.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Cache.kt */
        public static final class C0562a extends ua.m {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ z0 f25969a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f25970b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0562a(z0 z0Var, a aVar) {
                super(z0Var);
                this.f25969a = z0Var;
                this.f25970b = aVar;
            }

            @Override // ua.m, ua.z0, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                this.f25970b.a().close();
                super.close();
            }
        }

        public a(@NotNull d.C0599d snapshot, @Nullable String str, @Nullable String str2) {
            kotlin.jvm.internal.t.i(snapshot, "snapshot");
            this.f25965a = snapshot;
            this.f25966b = str;
            this.f25967c = str2;
            this.f25968d = k0.d(new C0562a(snapshot.c(1), this));
        }

        @NotNull
        public final d.C0599d a() {
            return this.f25965a;
        }

        @Override // ga.e0
        public long contentLength() {
            String str = this.f25967c;
            if (str == null) {
                return -1L;
            }
            return ha.d.V(str, -1L);
        }

        @Override // ga.e0
        @Nullable
        public x contentType() {
            String str = this.f25966b;
            if (str == null) {
                return null;
            }
            return x.f26237e.b(str);
        }

        @Override // ga.e0
        @NotNull
        public ua.e source() {
            return this.f25968d;
        }
    }

    /* JADX INFO: compiled from: Cache.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        private final Set<String> d(u uVar) {
            int size = uVar.size();
            TreeSet treeSet = null;
            int i10 = 0;
            while (i10 < size) {
                int i11 = i10 + 1;
                if (p9.q.x("Vary", uVar.e(i10), true)) {
                    String strI = uVar.i(i10);
                    if (treeSet == null) {
                        treeSet = new TreeSet(p9.q.y(s0.f29840a));
                    }
                    Iterator it = p9.r.B0(strI, new char[]{','}, false, 0, 6, null).iterator();
                    while (it.hasNext()) {
                        treeSet.add(p9.r.b1((String) it.next()).toString());
                    }
                }
                i10 = i11;
            }
            return treeSet == null ? kotlin.collections.z0.e() : treeSet;
        }

        private final u e(u uVar, u uVar2) {
            Set<String> setD = d(uVar2);
            if (setD.isEmpty()) {
                return ha.d.f26509b;
            }
            u.a aVar = new u.a();
            int size = uVar.size();
            int i10 = 0;
            while (i10 < size) {
                int i11 = i10 + 1;
                String strE = uVar.e(i10);
                if (setD.contains(strE)) {
                    aVar.a(strE, uVar.i(i10));
                }
                i10 = i11;
            }
            return aVar.f();
        }

        public final boolean a(@NotNull d0 d0Var) {
            kotlin.jvm.internal.t.i(d0Var, "<this>");
            return d(d0Var.L()).contains(ProxyConfig.MATCH_ALL_SCHEMES);
        }

        @NotNull
        public final String b(@NotNull v url) {
            kotlin.jvm.internal.t.i(url, "url");
            return ua.f.f34755d.d(url.toString()).t().k();
        }

        public final int c(@NotNull ua.e source) throws IOException {
            kotlin.jvm.internal.t.i(source, "source");
            try {
                long jP0 = source.p0();
                String strN = source.N();
                if (jP0 >= 0 && jP0 <= 2147483647L) {
                    if (!(strN.length() > 0)) {
                        return (int) jP0;
                    }
                }
                throw new IOException("expected an int but was \"" + jP0 + strN + '\"');
            } catch (NumberFormatException e10) {
                throw new IOException(e10.getMessage());
            }
        }

        @NotNull
        public final u f(@NotNull d0 d0Var) {
            kotlin.jvm.internal.t.i(d0Var, "<this>");
            d0 d0VarS = d0Var.S();
            kotlin.jvm.internal.t.f(d0VarS);
            return e(d0VarS.I0().e(), d0Var.L());
        }

        public final boolean g(@NotNull d0 cachedResponse, @NotNull u cachedRequest, @NotNull b0 newRequest) {
            kotlin.jvm.internal.t.i(cachedResponse, "cachedResponse");
            kotlin.jvm.internal.t.i(cachedRequest, "cachedRequest");
            kotlin.jvm.internal.t.i(newRequest, "newRequest");
            Set<String> setD = d(cachedResponse.L());
            if ((setD instanceof Collection) && setD.isEmpty()) {
                return true;
            }
            for (String str : setD) {
                if (!kotlin.jvm.internal.t.d(cachedRequest.j(str), newRequest.f(str))) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: Cache.kt */
    private final class d implements ja.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final d.b f25984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final x0 f25985b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final x0 f25986c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f25987d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ c f25988e;

        /* JADX INFO: compiled from: Cache.kt */
        public static final class a extends ua.l {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ c f25989b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ d f25990c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(c cVar, d dVar, x0 x0Var) {
                super(x0Var);
                this.f25989b = cVar;
                this.f25990c = dVar;
            }

            @Override // ua.l, ua.x0, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                c cVar = this.f25989b;
                d dVar = this.f25990c;
                synchronized (cVar) {
                    if (dVar.d()) {
                        return;
                    }
                    dVar.e(true);
                    cVar.B(cVar.n() + 1);
                    super.close();
                    this.f25990c.f25984a.b();
                }
            }
        }

        public d(@NotNull c this$0, d.b editor) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            kotlin.jvm.internal.t.i(editor, "editor");
            this.f25988e = this$0;
            this.f25984a = editor;
            x0 x0VarF = editor.f(1);
            this.f25985b = x0VarF;
            this.f25986c = new a(this$0, this, x0VarF);
        }

        @Override // ja.b
        public void a() {
            c cVar = this.f25988e;
            synchronized (cVar) {
                if (d()) {
                    return;
                }
                e(true);
                cVar.z(cVar.i() + 1);
                ha.d.m(this.f25985b);
                try {
                    this.f25984a.a();
                } catch (IOException unused) {
                }
            }
        }

        @Override // ja.b
        @NotNull
        public x0 b() {
            return this.f25986c;
        }

        public final boolean d() {
            return this.f25987d;
        }

        public final void e(boolean z10) {
            this.f25987d = z10;
        }
    }

    public c(@NotNull File directory, long j10, @NotNull pa.a fileSystem) {
        kotlin.jvm.internal.t.i(directory, "directory");
        kotlin.jvm.internal.t.i(fileSystem, "fileSystem");
        this.f25959a = new ja.d(fileSystem, directory, 201105, 2, j10, ka.e.f29730i);
    }

    private final void a(d.b bVar) {
        if (bVar == null) {
            return;
        }
        try {
            bVar.a();
        } catch (IOException unused) {
        }
    }

    public final void B(int i10) {
        this.f25960b = i10;
    }

    public final synchronized void J() {
        this.f25963e++;
    }

    public final synchronized void L(@NotNull ja.c cacheStrategy) {
        kotlin.jvm.internal.t.i(cacheStrategy, "cacheStrategy");
        this.f25964f++;
        if (cacheStrategy.b() != null) {
            this.f25962d++;
        } else if (cacheStrategy.a() != null) {
            this.f25963e++;
        }
    }

    public final void O(@NotNull d0 cached, @NotNull d0 network) {
        d.b bVarA;
        kotlin.jvm.internal.t.i(cached, "cached");
        kotlin.jvm.internal.t.i(network, "network");
        C0563c c0563c = new C0563c(network);
        e0 e0VarA = cached.a();
        if (e0VarA == null) {
            throw new NullPointerException("null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
        }
        try {
            bVarA = ((a) e0VarA).a().a();
            if (bVarA == null) {
                return;
            }
            try {
                c0563c.f(bVarA);
                bVarA.b();
            } catch (IOException unused) {
                a(bVarA);
            }
        } catch (IOException unused2) {
            bVarA = null;
        }
    }

    @Nullable
    public final d0 c(@NotNull b0 request) {
        kotlin.jvm.internal.t.i(request, "request");
        try {
            d.C0599d c0599dW = this.f25959a.W(f25958g.b(request.k()));
            if (c0599dW == null) {
                return null;
            }
            try {
                C0563c c0563c = new C0563c(c0599dW.c(0));
                d0 d0VarD = c0563c.d(c0599dW);
                if (c0563c.b(request, d0VarD)) {
                    return d0VarD;
                }
                e0 e0VarA = d0VarD.a();
                if (e0VarA != null) {
                    ha.d.m(e0VarA);
                }
                return null;
            } catch (IOException unused) {
                ha.d.m(c0599dW);
                return null;
            }
        } catch (IOException unused2) {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f25959a.close();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.f25959a.flush();
    }

    public final int i() {
        return this.f25961c;
    }

    public final int n() {
        return this.f25960b;
    }

    @Nullable
    public final ja.b q(@NotNull d0 response) {
        d.b bVarS;
        kotlin.jvm.internal.t.i(response, "response");
        String strH = response.I0().h();
        if (ma.f.f31482a.a(response.I0().h())) {
            try {
                x(response.I0());
            } catch (IOException unused) {
            }
            return null;
        }
        if (!kotlin.jvm.internal.t.d(strH, "GET")) {
            return null;
        }
        b bVar = f25958g;
        if (bVar.a(response)) {
            return null;
        }
        C0563c c0563c = new C0563c(response);
        try {
            bVarS = ja.d.S(this.f25959a, bVar.b(response.I0().k()), 0L, 2, null);
            if (bVarS == null) {
                return null;
            }
            try {
                c0563c.f(bVarS);
                return new d(this, bVarS);
            } catch (IOException unused2) {
                a(bVarS);
                return null;
            }
        } catch (IOException unused3) {
            bVarS = null;
        }
    }

    public final void x(@NotNull b0 request) throws IOException {
        kotlin.jvm.internal.t.i(request, "request");
        this.f25959a.R0(f25958g.b(request.k()));
    }

    public final void z(int i10) {
        this.f25961c = i10;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(@NotNull File directory, long j10) {
        this(directory, j10, pa.a.f32982b);
        kotlin.jvm.internal.t.i(directory, "directory");
    }

    /* JADX INFO: renamed from: ga.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Cache.kt */
    private static final class C0563c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @NotNull
        public static final a f25971k = new a(null);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @NotNull
        private static final String f25972l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @NotNull
        private static final String f25973m;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final v f25974a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final u f25975b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final String f25976c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        private final a0 f25977d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f25978e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @NotNull
        private final String f25979f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @NotNull
        private final u f25980g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        private final t f25981h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final long f25982i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final long f25983j;

        /* JADX INFO: renamed from: ga.c$c$a */
        /* JADX INFO: compiled from: Cache.kt */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
                this();
            }
        }

        static {
            j.a aVar = qa.j.f33228a;
            f25972l = kotlin.jvm.internal.t.r(aVar.g().g(), "-Sent-Millis");
            f25973m = kotlin.jvm.internal.t.r(aVar.g().g(), "-Received-Millis");
        }

        public C0563c(@NotNull z0 rawSource) throws IOException {
            kotlin.jvm.internal.t.i(rawSource, "rawSource");
            try {
                ua.e eVarD = k0.d(rawSource);
                String strN = eVarD.N();
                v vVarF = v.f26216k.f(strN);
                if (vVarF == null) {
                    IOException iOException = new IOException(kotlin.jvm.internal.t.r("Cache corruption for ", strN));
                    qa.j.f33228a.g().k("cache corruption", 5, iOException);
                    throw iOException;
                }
                this.f25974a = vVarF;
                this.f25976c = eVarD.N();
                u.a aVar = new u.a();
                int iC = c.f25958g.c(eVarD);
                int i10 = 0;
                while (i10 < iC) {
                    i10++;
                    aVar.c(eVarD.N());
                }
                this.f25975b = aVar.f();
                ma.k kVarA = ma.k.f31498d.a(eVarD.N());
                this.f25977d = kVarA.f31499a;
                this.f25978e = kVarA.f31500b;
                this.f25979f = kVarA.f31501c;
                u.a aVar2 = new u.a();
                int iC2 = c.f25958g.c(eVarD);
                int i11 = 0;
                while (i11 < iC2) {
                    i11++;
                    aVar2.c(eVarD.N());
                }
                String str = f25972l;
                String strG = aVar2.g(str);
                String str2 = f25973m;
                String strG2 = aVar2.g(str2);
                aVar2.i(str);
                aVar2.i(str2);
                long j10 = 0;
                this.f25982i = strG == null ? 0L : Long.parseLong(strG);
                if (strG2 != null) {
                    j10 = Long.parseLong(strG2);
                }
                this.f25983j = j10;
                this.f25980g = aVar2.f();
                if (a()) {
                    String strN2 = eVarD.N();
                    if (strN2.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + strN2 + '\"');
                    }
                    this.f25981h = t.f26205e.a(!eVarD.m0() ? g0.f26071b.a(eVarD.N()) : g0.SSL_3_0, i.f26083b.b(eVarD.N()), c(eVarD), c(eVarD));
                } else {
                    this.f25981h = null;
                }
                v8.k0 k0Var = v8.k0.f35197a;
                f9.c.a(rawSource, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    f9.c.a(rawSource, th);
                    throw th2;
                }
            }
        }

        private final boolean a() {
            return kotlin.jvm.internal.t.d(this.f25974a.r(), "https");
        }

        private final List<Certificate> c(ua.e eVar) throws IOException {
            int iC = c.f25958g.c(eVar);
            if (iC == -1) {
                return kotlin.collections.v.l();
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance(AndroidStaticDeviceInfoDataSource.CERTIFICATE_TYPE_X509);
                ArrayList arrayList = new ArrayList(iC);
                int i10 = 0;
                while (i10 < iC) {
                    i10++;
                    String strN = eVar.N();
                    ua.c cVar = new ua.c();
                    ua.f fVarA = ua.f.f34755d.a(strN);
                    kotlin.jvm.internal.t.f(fVarA);
                    cVar.I(fVarA);
                    arrayList.add(certificateFactory.generateCertificate(cVar.F0()));
                }
                return arrayList;
            } catch (CertificateException e10) {
                throw new IOException(e10.getMessage());
            }
        }

        private final void e(ua.d dVar, List<? extends Certificate> list) throws IOException {
            try {
                dVar.b0(list.size()).writeByte(10);
                Iterator<? extends Certificate> it = list.iterator();
                while (it.hasNext()) {
                    byte[] bytes = it.next().getEncoded();
                    f.a aVar = ua.f.f34755d;
                    kotlin.jvm.internal.t.h(bytes, "bytes");
                    dVar.E(f.a.g(aVar, bytes, 0, 0, 3, null).a()).writeByte(10);
                }
            } catch (CertificateEncodingException e10) {
                throw new IOException(e10.getMessage());
            }
        }

        public final boolean b(@NotNull b0 request, @NotNull d0 response) {
            kotlin.jvm.internal.t.i(request, "request");
            kotlin.jvm.internal.t.i(response, "response");
            return kotlin.jvm.internal.t.d(this.f25974a, request.k()) && kotlin.jvm.internal.t.d(this.f25976c, request.h()) && c.f25958g.g(response, this.f25975b, request);
        }

        @NotNull
        public final d0 d(@NotNull d.C0599d snapshot) {
            kotlin.jvm.internal.t.i(snapshot, "snapshot");
            String strA = this.f25980g.a(nb.K);
            String strA2 = this.f25980g.a("Content-Length");
            return new d0.a().s(new b0.a().r(this.f25974a).i(this.f25976c, null).h(this.f25975b).b()).q(this.f25977d).g(this.f25978e).n(this.f25979f).l(this.f25980g).b(new a(snapshot, strA, strA2)).j(this.f25981h).t(this.f25982i).r(this.f25983j).c();
        }

        public final void f(@NotNull d.b editor) throws IOException {
            kotlin.jvm.internal.t.i(editor, "editor");
            ua.d dVarC = k0.c(editor.f(0));
            try {
                dVarC.E(this.f25974a.toString()).writeByte(10);
                dVarC.E(this.f25976c).writeByte(10);
                dVarC.b0(this.f25975b.size()).writeByte(10);
                int size = this.f25975b.size();
                int i10 = 0;
                while (i10 < size) {
                    int i11 = i10 + 1;
                    dVarC.E(this.f25975b.e(i10)).E(": ").E(this.f25975b.i(i10)).writeByte(10);
                    i10 = i11;
                }
                dVarC.E(new ma.k(this.f25977d, this.f25978e, this.f25979f).toString()).writeByte(10);
                dVarC.b0(this.f25980g.size() + 2).writeByte(10);
                int size2 = this.f25980g.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    dVarC.E(this.f25980g.e(i12)).E(": ").E(this.f25980g.i(i12)).writeByte(10);
                }
                dVarC.E(f25972l).E(": ").b0(this.f25982i).writeByte(10);
                dVarC.E(f25973m).E(": ").b0(this.f25983j).writeByte(10);
                if (a()) {
                    dVarC.writeByte(10);
                    t tVar = this.f25981h;
                    kotlin.jvm.internal.t.f(tVar);
                    dVarC.E(tVar.a().c()).writeByte(10);
                    e(dVarC, this.f25981h.d());
                    e(dVarC, this.f25981h.c());
                    dVarC.E(this.f25981h.e().c()).writeByte(10);
                }
                v8.k0 k0Var = v8.k0.f35197a;
                f9.c.a(dVarC, null);
            } finally {
            }
        }

        public C0563c(@NotNull d0 response) {
            kotlin.jvm.internal.t.i(response, "response");
            this.f25974a = response.I0().k();
            this.f25975b = c.f25958g.f(response);
            this.f25976c = response.I0().h();
            this.f25977d = response.i0();
            this.f25978e = response.q();
            this.f25979f = response.R();
            this.f25980g = response.L();
            this.f25981h = response.z();
            this.f25982i = response.J0();
            this.f25983j = response.G0();
        }
    }
}
