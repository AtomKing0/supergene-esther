package oa;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.t;
import n9.o;
import oa.d;
import org.jetbrains.annotations.NotNull;
import ua.a1;
import ua.z0;

/* JADX INFO: compiled from: Http2Reader.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class h implements Closeable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f32244e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Logger f32245f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ua.e f32246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f32247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final b f32248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final d.a f32249d;

    /* JADX INFO: compiled from: Http2Reader.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final Logger a() {
            return h.f32245f;
        }

        public final int b(int i10, int i11, int i12) throws IOException {
            if ((i11 & 8) != 0) {
                i10--;
            }
            if (i12 <= i10) {
                return i10 - i12;
            }
            throw new IOException("PROTOCOL_ERROR padding " + i12 + " > remaining length " + i10);
        }
    }

    /* JADX INFO: compiled from: Http2Reader.kt */
    public interface c {
        void a(boolean z10, int i10, @NotNull ua.e eVar, int i11) throws IOException;

        void b(boolean z10, int i10, int i11, @NotNull List<oa.c> list);

        void c(int i10, @NotNull oa.b bVar, @NotNull ua.f fVar);

        void d(int i10, long j10);

        void e(int i10, int i11, @NotNull List<oa.c> list) throws IOException;

        void f(int i10, @NotNull oa.b bVar);

        void g();

        void h(boolean z10, @NotNull m mVar);

        void i(boolean z10, int i10, int i11);

        void j(int i10, int i11, int i12, boolean z10);
    }

    static {
        Logger logger = Logger.getLogger(e.class.getName());
        t.h(logger, "getLogger(Http2::class.java.name)");
        f32245f = logger;
    }

    public h(@NotNull ua.e source, boolean z10) {
        t.i(source, "source");
        this.f32246a = source;
        this.f32247b = z10;
        b bVar = new b(source);
        this.f32248c = bVar;
        this.f32249d = new d.a(bVar, 4096, 0, 4, null);
    }

    private final void B(c cVar, int i10, int i11, int i12) throws IOException {
        if (i10 != 8) {
            throw new IOException(t.r("TYPE_PING length != 8: ", Integer.valueOf(i10)));
        }
        if (i12 != 0) {
            throw new IOException("TYPE_PING streamId != 0");
        }
        cVar.i((i11 & 1) != 0, this.f32246a.readInt(), this.f32246a.readInt());
    }

    private final void J(c cVar, int i10) throws IOException {
        int i11 = this.f32246a.readInt();
        cVar.j(i10, i11 & Integer.MAX_VALUE, ha.d.d(this.f32246a.readByte(), 255) + 1, (Integer.MIN_VALUE & i11) != 0);
    }

    private final void L(c cVar, int i10, int i11, int i12) throws IOException {
        if (i10 == 5) {
            if (i12 == 0) {
                throw new IOException("TYPE_PRIORITY streamId == 0");
            }
            J(cVar, i12);
        } else {
            throw new IOException("TYPE_PRIORITY length: " + i10 + " != 5");
        }
    }

    private final void O(c cVar, int i10, int i11, int i12) throws IOException {
        if (i12 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        int iD = (i11 & 8) != 0 ? ha.d.d(this.f32246a.readByte(), 255) : 0;
        cVar.e(i12, this.f32246a.readInt() & Integer.MAX_VALUE, x(f32244e.b(i10 - 4, i11, iD), iD, i11, i12));
    }

    private final void R(c cVar, int i10, int i11, int i12) throws IOException {
        if (i10 != 4) {
            throw new IOException("TYPE_RST_STREAM length: " + i10 + " != 4");
        }
        if (i12 == 0) {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
        int i13 = this.f32246a.readInt();
        oa.b bVarA = oa.b.f32086b.a(i13);
        if (bVarA == null) {
            throw new IOException(t.r("TYPE_RST_STREAM unexpected error code: ", Integer.valueOf(i13)));
        }
        cVar.f(i12, bVarA);
    }

    private final void S(c cVar, int i10, int i11, int i12) throws IOException {
        int i13;
        if (i12 != 0) {
            throw new IOException("TYPE_SETTINGS streamId != 0");
        }
        if ((i11 & 1) != 0) {
            if (i10 != 0) {
                throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
            }
            cVar.g();
            return;
        }
        if (i10 % 6 != 0) {
            throw new IOException(t.r("TYPE_SETTINGS length % 6 != 0: ", Integer.valueOf(i10)));
        }
        m mVar = new m();
        n9.g gVarT = o.t(o.u(0, i10), 6);
        int iB = gVarT.b();
        int iE = gVarT.e();
        int iF = gVarT.f();
        if ((iF > 0 && iB <= iE) || (iF < 0 && iE <= iB)) {
            while (true) {
                int i14 = iB + iF;
                int iE2 = ha.d.e(this.f32246a.readShort(), 65535);
                i13 = this.f32246a.readInt();
                if (iE2 != 2) {
                    if (iE2 == 3) {
                        iE2 = 4;
                    } else if (iE2 != 4) {
                        if (iE2 == 5 && (i13 < 16384 || i13 > 16777215)) {
                            break;
                        }
                    } else {
                        if (i13 < 0) {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                        }
                        iE2 = 7;
                    }
                } else if (i13 != 0 && i13 != 1) {
                    throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                }
                mVar.h(iE2, i13);
                if (iB == iE) {
                    break;
                } else {
                    iB = i14;
                }
            }
            throw new IOException(t.r("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ", Integer.valueOf(i13)));
        }
        cVar.h(false, mVar);
    }

    private final void W(c cVar, int i10, int i11, int i12) throws IOException {
        if (i10 != 4) {
            throw new IOException(t.r("TYPE_WINDOW_UPDATE length !=4: ", Integer.valueOf(i10)));
        }
        long jF = ha.d.f(this.f32246a.readInt(), 2147483647L);
        if (jF == 0) {
            throw new IOException("windowSizeIncrement was 0");
        }
        cVar.d(i12, jF);
    }

    private final void n(c cVar, int i10, int i11, int i12) throws IOException {
        if (i12 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        }
        boolean z10 = (i11 & 1) != 0;
        if ((i11 & 32) != 0) {
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        int iD = (i11 & 8) != 0 ? ha.d.d(this.f32246a.readByte(), 255) : 0;
        cVar.a(z10, i12, this.f32246a, f32244e.b(i10, i11, iD));
        this.f32246a.skip(iD);
    }

    private final void q(c cVar, int i10, int i11, int i12) throws IOException {
        if (i10 < 8) {
            throw new IOException(t.r("TYPE_GOAWAY length < 8: ", Integer.valueOf(i10)));
        }
        if (i12 != 0) {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        int i13 = this.f32246a.readInt();
        int i14 = this.f32246a.readInt();
        int i15 = i10 - 8;
        oa.b bVarA = oa.b.f32086b.a(i14);
        if (bVarA == null) {
            throw new IOException(t.r("TYPE_GOAWAY unexpected error code: ", Integer.valueOf(i14)));
        }
        ua.f fVarF0 = ua.f.f34756e;
        if (i15 > 0) {
            fVarF0 = this.f32246a.f0(i15);
        }
        cVar.c(i13, bVarA, fVarF0);
    }

    private final List<oa.c> x(int i10, int i11, int i12, int i13) throws IOException {
        this.f32248c.n(i10);
        b bVar = this.f32248c;
        bVar.q(bVar.a());
        this.f32248c.x(i11);
        this.f32248c.i(i12);
        this.f32248c.z(i13);
        this.f32249d.k();
        return this.f32249d.e();
    }

    private final void z(c cVar, int i10, int i11, int i12) throws IOException {
        if (i12 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        boolean z10 = (i11 & 1) != 0;
        int iD = (i11 & 8) != 0 ? ha.d.d(this.f32246a.readByte(), 255) : 0;
        if ((i11 & 32) != 0) {
            J(cVar, i12);
            i10 -= 5;
        }
        cVar.b(z10, i12, -1, x(f32244e.b(i10, i11, iD), iD, i11, i12));
    }

    public final boolean c(boolean z10, @NotNull c handler) throws IOException {
        t.i(handler, "handler");
        try {
            this.f32246a.a0(9L);
            int iK = ha.d.K(this.f32246a);
            if (iK > 16384) {
                throw new IOException(t.r("FRAME_SIZE_ERROR: ", Integer.valueOf(iK)));
            }
            int iD = ha.d.d(this.f32246a.readByte(), 255);
            int iD2 = ha.d.d(this.f32246a.readByte(), 255);
            int i10 = this.f32246a.readInt() & Integer.MAX_VALUE;
            Logger logger = f32245f;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(e.f32134a.c(true, i10, iK, iD, iD2));
            }
            if (z10 && iD != 4) {
                throw new IOException(t.r("Expected a SETTINGS frame but was ", e.f32134a.b(iD)));
            }
            switch (iD) {
                case 0:
                    n(handler, iK, iD2, i10);
                    return true;
                case 1:
                    z(handler, iK, iD2, i10);
                    return true;
                case 2:
                    L(handler, iK, iD2, i10);
                    return true;
                case 3:
                    R(handler, iK, iD2, i10);
                    return true;
                case 4:
                    S(handler, iK, iD2, i10);
                    return true;
                case 5:
                    O(handler, iK, iD2, i10);
                    return true;
                case 6:
                    B(handler, iK, iD2, i10);
                    return true;
                case 7:
                    q(handler, iK, iD2, i10);
                    return true;
                case 8:
                    W(handler, iK, iD2, i10);
                    return true;
                default:
                    this.f32246a.skip(iK);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f32246a.close();
    }

    public final void i(@NotNull c handler) throws IOException {
        t.i(handler, "handler");
        if (this.f32247b) {
            if (!c(true, handler)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        ua.e eVar = this.f32246a;
        ua.f fVar = e.f32135b;
        ua.f fVarF0 = eVar.f0(fVar.B());
        Logger logger = f32245f;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(ha.d.t(t.r("<< CONNECTION ", fVarF0.k()), new Object[0]));
        }
        if (!t.d(fVar, fVarF0)) {
            throw new IOException(t.r("Expected a connection header but was ", fVarF0.G()));
        }
    }

    /* JADX INFO: compiled from: Http2Reader.kt */
    public static final class b implements z0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final ua.e f32250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f32251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f32252c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f32253d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f32254e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f32255f;

        public b(@NotNull ua.e source) {
            t.i(source, "source");
            this.f32250a = source;
        }

        private final void c() throws IOException {
            int i10 = this.f32253d;
            int iK = ha.d.K(this.f32250a);
            this.f32254e = iK;
            this.f32251b = iK;
            int iD = ha.d.d(this.f32250a.readByte(), 255);
            this.f32252c = ha.d.d(this.f32250a.readByte(), 255);
            a aVar = h.f32244e;
            if (aVar.a().isLoggable(Level.FINE)) {
                aVar.a().fine(e.f32134a.c(true, this.f32253d, this.f32251b, iD, this.f32252c));
            }
            int i11 = this.f32250a.readInt() & Integer.MAX_VALUE;
            this.f32253d = i11;
            if (iD == 9) {
                if (i11 != i10) {
                    throw new IOException("TYPE_CONTINUATION streamId changed");
                }
            } else {
                throw new IOException(iD + " != TYPE_CONTINUATION");
            }
        }

        public final int a() {
            return this.f32254e;
        }

        public final void i(int i10) {
            this.f32252c = i10;
        }

        public final void n(int i10) {
            this.f32254e = i10;
        }

        public final void q(int i10) {
            this.f32251b = i10;
        }

        @Override // ua.z0
        public long read(@NotNull ua.c sink, long j10) throws IOException {
            t.i(sink, "sink");
            while (true) {
                int i10 = this.f32254e;
                if (i10 != 0) {
                    long j11 = this.f32250a.read(sink, Math.min(j10, i10));
                    if (j11 == -1) {
                        return -1L;
                    }
                    this.f32254e -= (int) j11;
                    return j11;
                }
                this.f32250a.skip(this.f32255f);
                this.f32255f = 0;
                if ((this.f32252c & 4) != 0) {
                    return -1L;
                }
                c();
            }
        }

        @Override // ua.z0
        @NotNull
        public a1 timeout() {
            return this.f32250a.timeout();
        }

        public final void x(int i10) {
            this.f32255f = i10;
        }

        public final void z(int i10) {
            this.f32253d = i10;
        }

        @Override // ua.z0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }
    }
}
