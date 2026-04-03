package ga;

import ga.u;
import java.io.Closeable;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Response.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d0 implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final b0 f26023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final a0 f26024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final String f26025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f26026d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final t f26027e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final u f26028f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private final e0 f26029g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private final d0 f26030h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private final d0 f26031i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private final d0 f26032j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f26033k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f26034l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private final la.c f26035m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private d f26036n;

    public d0(@NotNull b0 request, @NotNull a0 protocol, @NotNull String message, int i10, @Nullable t tVar, @NotNull u headers, @Nullable e0 e0Var, @Nullable d0 d0Var, @Nullable d0 d0Var2, @Nullable d0 d0Var3, long j10, long j11, @Nullable la.c cVar) {
        kotlin.jvm.internal.t.i(request, "request");
        kotlin.jvm.internal.t.i(protocol, "protocol");
        kotlin.jvm.internal.t.i(message, "message");
        kotlin.jvm.internal.t.i(headers, "headers");
        this.f26023a = request;
        this.f26024b = protocol;
        this.f26025c = message;
        this.f26026d = i10;
        this.f26027e = tVar;
        this.f26028f = headers;
        this.f26029g = e0Var;
        this.f26030h = d0Var;
        this.f26031i = d0Var2;
        this.f26032j = d0Var3;
        this.f26033k = j10;
        this.f26034l = j11;
        this.f26035m = cVar;
    }

    public static /* synthetic */ String J(d0 d0Var, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        return d0Var.B(str, str2);
    }

    @Nullable
    public final String B(@NotNull String name, @Nullable String str) {
        kotlin.jvm.internal.t.i(name, "name");
        String strA = this.f26028f.a(name);
        return strA == null ? str : strA;
    }

    public final long G0() {
        return this.f26034l;
    }

    @NotNull
    public final b0 I0() {
        return this.f26023a;
    }

    public final long J0() {
        return this.f26033k;
    }

    @NotNull
    public final u L() {
        return this.f26028f;
    }

    public final boolean O() {
        int i10 = this.f26026d;
        return 200 <= i10 && i10 < 300;
    }

    @NotNull
    public final String R() {
        return this.f26025c;
    }

    @Nullable
    public final d0 S() {
        return this.f26030h;
    }

    @NotNull
    public final a W() {
        return new a(this);
    }

    @Nullable
    public final e0 a() {
        return this.f26029g;
    }

    @NotNull
    public final d c() {
        d dVar = this.f26036n;
        if (dVar != null) {
            return dVar;
        }
        d dVarB = d.f25999n.b(this.f26028f);
        this.f26036n = dVarB;
        return dVarB;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        e0 e0Var = this.f26029g;
        if (e0Var == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
        }
        e0Var.close();
    }

    @Nullable
    public final d0 h0() {
        return this.f26032j;
    }

    @Nullable
    public final d0 i() {
        return this.f26031i;
    }

    @NotNull
    public final a0 i0() {
        return this.f26024b;
    }

    @NotNull
    public final List<h> n() {
        String str;
        u uVar = this.f26028f;
        int i10 = this.f26026d;
        if (i10 == 401) {
            str = "WWW-Authenticate";
        } else {
            if (i10 != 407) {
                return kotlin.collections.v.l();
            }
            str = "Proxy-Authenticate";
        }
        return ma.e.a(uVar, str);
    }

    public final int q() {
        return this.f26026d;
    }

    @NotNull
    public String toString() {
        return "Response{protocol=" + this.f26024b + ", code=" + this.f26026d + ", message=" + this.f26025c + ", url=" + this.f26023a.k() + '}';
    }

    @Nullable
    public final la.c x() {
        return this.f26035m;
    }

    @Nullable
    public final t z() {
        return this.f26027e;
    }

    /* JADX INFO: compiled from: Response.kt */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private b0 f26037a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private a0 f26038b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f26039c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private String f26040d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        private t f26041e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @NotNull
        private u.a f26042f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        private e0 f26043g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        private d0 f26044h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        private d0 f26045i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Nullable
        private d0 f26046j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f26047k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f26048l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @Nullable
        private la.c f26049m;

        public a() {
            this.f26039c = -1;
            this.f26042f = new u.a();
        }

        private final void e(d0 d0Var) {
            if (d0Var == null) {
                return;
            }
            if (!(d0Var.a() == null)) {
                throw new IllegalArgumentException("priorResponse.body != null".toString());
            }
        }

        private final void f(String str, d0 d0Var) {
            if (d0Var == null) {
                return;
            }
            if (!(d0Var.a() == null)) {
                throw new IllegalArgumentException(kotlin.jvm.internal.t.r(str, ".body != null").toString());
            }
            if (!(d0Var.S() == null)) {
                throw new IllegalArgumentException(kotlin.jvm.internal.t.r(str, ".networkResponse != null").toString());
            }
            if (!(d0Var.i() == null)) {
                throw new IllegalArgumentException(kotlin.jvm.internal.t.r(str, ".cacheResponse != null").toString());
            }
            if (!(d0Var.h0() == null)) {
                throw new IllegalArgumentException(kotlin.jvm.internal.t.r(str, ".priorResponse != null").toString());
            }
        }

        public final void A(@Nullable d0 d0Var) {
            this.f26044h = d0Var;
        }

        public final void B(@Nullable d0 d0Var) {
            this.f26046j = d0Var;
        }

        public final void C(@Nullable a0 a0Var) {
            this.f26038b = a0Var;
        }

        public final void D(long j10) {
            this.f26048l = j10;
        }

        public final void E(@Nullable b0 b0Var) {
            this.f26037a = b0Var;
        }

        public final void F(long j10) {
            this.f26047k = j10;
        }

        @NotNull
        public a a(@NotNull String name, @NotNull String value) {
            kotlin.jvm.internal.t.i(name, "name");
            kotlin.jvm.internal.t.i(value, "value");
            i().a(name, value);
            return this;
        }

        @NotNull
        public a b(@Nullable e0 e0Var) {
            u(e0Var);
            return this;
        }

        @NotNull
        public d0 c() {
            int i10 = this.f26039c;
            if (!(i10 >= 0)) {
                throw new IllegalStateException(kotlin.jvm.internal.t.r("code < 0: ", Integer.valueOf(h())).toString());
            }
            b0 b0Var = this.f26037a;
            if (b0Var == null) {
                throw new IllegalStateException("request == null".toString());
            }
            a0 a0Var = this.f26038b;
            if (a0Var == null) {
                throw new IllegalStateException("protocol == null".toString());
            }
            String str = this.f26040d;
            if (str != null) {
                return new d0(b0Var, a0Var, str, i10, this.f26041e, this.f26042f.f(), this.f26043g, this.f26044h, this.f26045i, this.f26046j, this.f26047k, this.f26048l, this.f26049m);
            }
            throw new IllegalStateException("message == null".toString());
        }

        @NotNull
        public a d(@Nullable d0 d0Var) {
            f("cacheResponse", d0Var);
            v(d0Var);
            return this;
        }

        @NotNull
        public a g(int i10) {
            w(i10);
            return this;
        }

        public final int h() {
            return this.f26039c;
        }

        @NotNull
        public final u.a i() {
            return this.f26042f;
        }

        @NotNull
        public a j(@Nullable t tVar) {
            x(tVar);
            return this;
        }

        @NotNull
        public a k(@NotNull String name, @NotNull String value) {
            kotlin.jvm.internal.t.i(name, "name");
            kotlin.jvm.internal.t.i(value, "value");
            i().j(name, value);
            return this;
        }

        @NotNull
        public a l(@NotNull u headers) {
            kotlin.jvm.internal.t.i(headers, "headers");
            y(headers.f());
            return this;
        }

        public final void m(@NotNull la.c deferredTrailers) {
            kotlin.jvm.internal.t.i(deferredTrailers, "deferredTrailers");
            this.f26049m = deferredTrailers;
        }

        @NotNull
        public a n(@NotNull String message) {
            kotlin.jvm.internal.t.i(message, "message");
            z(message);
            return this;
        }

        @NotNull
        public a o(@Nullable d0 d0Var) {
            f("networkResponse", d0Var);
            A(d0Var);
            return this;
        }

        @NotNull
        public a p(@Nullable d0 d0Var) {
            e(d0Var);
            B(d0Var);
            return this;
        }

        @NotNull
        public a q(@NotNull a0 protocol) {
            kotlin.jvm.internal.t.i(protocol, "protocol");
            C(protocol);
            return this;
        }

        @NotNull
        public a r(long j10) {
            D(j10);
            return this;
        }

        @NotNull
        public a s(@NotNull b0 request) {
            kotlin.jvm.internal.t.i(request, "request");
            E(request);
            return this;
        }

        @NotNull
        public a t(long j10) {
            F(j10);
            return this;
        }

        public final void u(@Nullable e0 e0Var) {
            this.f26043g = e0Var;
        }

        public final void v(@Nullable d0 d0Var) {
            this.f26045i = d0Var;
        }

        public final void w(int i10) {
            this.f26039c = i10;
        }

        public final void x(@Nullable t tVar) {
            this.f26041e = tVar;
        }

        public final void y(@NotNull u.a aVar) {
            kotlin.jvm.internal.t.i(aVar, "<set-?>");
            this.f26042f = aVar;
        }

        public final void z(@Nullable String str) {
            this.f26040d = str;
        }

        public a(@NotNull d0 response) {
            kotlin.jvm.internal.t.i(response, "response");
            this.f26039c = -1;
            this.f26037a = response.I0();
            this.f26038b = response.i0();
            this.f26039c = response.q();
            this.f26040d = response.R();
            this.f26041e = response.z();
            this.f26042f = response.L().f();
            this.f26043g = response.a();
            this.f26044h = response.S();
            this.f26045i = response.i();
            this.f26046j = response.h0();
            this.f26047k = response.J0();
            this.f26048l = response.G0();
            this.f26049m = response.x();
        }
    }
}
