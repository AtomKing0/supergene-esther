package la;

import com.ironsource.nb;
import ga.b0;
import ga.c0;
import ga.d0;
import ga.e0;
import ga.r;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ua.k0;
import ua.l;
import ua.m;
import ua.x0;
import ua.z0;

/* JADX INFO: compiled from: Exchange.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final e f30986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final r f30987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final d f30988c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final ma.d f30989d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f30990e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final f f30991f;

    /* JADX INFO: compiled from: Exchange.kt */
    private final class a extends l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f30992b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f30993c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f30994d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f30995e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f30996f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull c this$0, x0 delegate, long j10) {
            super(delegate);
            t.i(this$0, "this$0");
            t.i(delegate, "delegate");
            this.f30996f = this$0;
            this.f30992b = j10;
        }

        private final <E extends IOException> E a(E e10) {
            if (this.f30993c) {
                return e10;
            }
            this.f30993c = true;
            return (E) this.f30996f.a(this.f30994d, false, true, e10);
        }

        @Override // ua.l, ua.x0
        public void G(@NotNull ua.c source, long j10) throws IOException {
            t.i(source, "source");
            if (!(!this.f30995e)) {
                throw new IllegalStateException("closed".toString());
            }
            long j11 = this.f30992b;
            if (j11 == -1 || this.f30994d + j10 <= j11) {
                try {
                    super.G(source, j10);
                    this.f30994d += j10;
                    return;
                } catch (IOException e10) {
                    throw a(e10);
                }
            }
            throw new ProtocolException("expected " + this.f30992b + " bytes but received " + (this.f30994d + j10));
        }

        @Override // ua.l, ua.x0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f30995e) {
                return;
            }
            this.f30995e = true;
            long j10 = this.f30992b;
            if (j10 != -1 && this.f30994d != j10) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                a(null);
            } catch (IOException e10) {
                throw a(e10);
            }
        }

        @Override // ua.l, ua.x0, java.io.Flushable
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e10) {
                throw a(e10);
            }
        }
    }

    /* JADX INFO: compiled from: Exchange.kt */
    public final class b extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f30997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f30998b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f30999c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f31000d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f31001e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f31002f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull c this$0, z0 delegate, long j10) {
            super(delegate);
            t.i(this$0, "this$0");
            t.i(delegate, "delegate");
            this.f31002f = this$0;
            this.f30997a = j10;
            this.f30999c = true;
            if (j10 == 0) {
                a(null);
            }
        }

        public final <E extends IOException> E a(E e10) {
            if (this.f31000d) {
                return e10;
            }
            this.f31000d = true;
            if (e10 == null && this.f30999c) {
                this.f30999c = false;
                this.f31002f.i().w(this.f31002f.g());
            }
            return (E) this.f31002f.a(this.f30998b, true, false, e10);
        }

        @Override // ua.m, ua.z0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f31001e) {
                return;
            }
            this.f31001e = true;
            try {
                super.close();
                a(null);
            } catch (IOException e10) {
                throw a(e10);
            }
        }

        @Override // ua.m, ua.z0
        public long read(@NotNull ua.c sink, long j10) throws IOException {
            t.i(sink, "sink");
            if (!(!this.f31001e)) {
                throw new IllegalStateException("closed".toString());
            }
            try {
                long j11 = delegate().read(sink, j10);
                if (this.f30999c) {
                    this.f30999c = false;
                    this.f31002f.i().w(this.f31002f.g());
                }
                if (j11 == -1) {
                    a(null);
                    return -1L;
                }
                long j12 = this.f30998b + j11;
                long j13 = this.f30997a;
                if (j13 != -1 && j12 > j13) {
                    throw new ProtocolException("expected " + this.f30997a + " bytes but received " + j12);
                }
                this.f30998b = j12;
                if (j12 == j13) {
                    a(null);
                }
                return j11;
            } catch (IOException e10) {
                throw a(e10);
            }
        }
    }

    public c(@NotNull e call, @NotNull r eventListener, @NotNull d finder, @NotNull ma.d codec) {
        t.i(call, "call");
        t.i(eventListener, "eventListener");
        t.i(finder, "finder");
        t.i(codec, "codec");
        this.f30986a = call;
        this.f30987b = eventListener;
        this.f30988c = finder;
        this.f30989d = codec;
        this.f30991f = codec.b();
    }

    private final void s(IOException iOException) {
        this.f30988c.h(iOException);
        this.f30989d.b().G(this.f30986a, iOException);
    }

    public final <E extends IOException> E a(long j10, boolean z10, boolean z11, E e10) {
        if (e10 != null) {
            s(e10);
        }
        if (z11) {
            if (e10 != null) {
                this.f30987b.s(this.f30986a, e10);
            } else {
                this.f30987b.q(this.f30986a, j10);
            }
        }
        if (z10) {
            if (e10 != null) {
                this.f30987b.x(this.f30986a, e10);
            } else {
                this.f30987b.v(this.f30986a, j10);
            }
        }
        return (E) this.f30986a.t(this, z11, z10, e10);
    }

    public final void b() {
        this.f30989d.cancel();
    }

    @NotNull
    public final x0 c(@NotNull b0 request, boolean z10) throws IOException {
        t.i(request, "request");
        this.f30990e = z10;
        c0 c0VarA = request.a();
        t.f(c0VarA);
        long jContentLength = c0VarA.contentLength();
        this.f30987b.r(this.f30986a);
        return new a(this, this.f30989d.e(request, jContentLength), jContentLength);
    }

    public final void d() {
        this.f30989d.cancel();
        this.f30986a.t(this, true, true, null);
    }

    public final void e() throws IOException {
        try {
            this.f30989d.a();
        } catch (IOException e10) {
            this.f30987b.s(this.f30986a, e10);
            s(e10);
            throw e10;
        }
    }

    public final void f() throws IOException {
        try {
            this.f30989d.g();
        } catch (IOException e10) {
            this.f30987b.s(this.f30986a, e10);
            s(e10);
            throw e10;
        }
    }

    @NotNull
    public final e g() {
        return this.f30986a;
    }

    @NotNull
    public final f h() {
        return this.f30991f;
    }

    @NotNull
    public final r i() {
        return this.f30987b;
    }

    @NotNull
    public final d j() {
        return this.f30988c;
    }

    public final boolean k() {
        return !t.d(this.f30988c.d().l().i(), this.f30991f.z().a().l().i());
    }

    public final boolean l() {
        return this.f30990e;
    }

    public final void m() {
        this.f30989d.b().y();
    }

    public final void n() {
        this.f30986a.t(this, true, false, null);
    }

    @NotNull
    public final e0 o(@NotNull d0 response) throws IOException {
        t.i(response, "response");
        try {
            String strJ = d0.J(response, nb.K, null, 2, null);
            long jC = this.f30989d.c(response);
            return new ma.h(strJ, jC, k0.d(new b(this, this.f30989d.h(response), jC)));
        } catch (IOException e10) {
            this.f30987b.x(this.f30986a, e10);
            s(e10);
            throw e10;
        }
    }

    @Nullable
    public final d0.a p(boolean z10) throws IOException {
        try {
            d0.a aVarF = this.f30989d.f(z10);
            if (aVarF != null) {
                aVarF.m(this);
            }
            return aVarF;
        } catch (IOException e10) {
            this.f30987b.x(this.f30986a, e10);
            s(e10);
            throw e10;
        }
    }

    public final void q(@NotNull d0 response) {
        t.i(response, "response");
        this.f30987b.y(this.f30986a, response);
    }

    public final void r() {
        this.f30987b.z(this.f30986a);
    }

    public final void t(@NotNull b0 request) throws IOException {
        t.i(request, "request");
        try {
            this.f30987b.u(this.f30986a);
            this.f30989d.d(request);
            this.f30987b.t(this.f30986a, request);
        } catch (IOException e10) {
            this.f30987b.s(this.f30986a, e10);
            s(e10);
            throw e10;
        }
    }
}
