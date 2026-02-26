package oa;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.t;
import oa.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Http2Writer.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class j implements Closeable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public static final a f32284g = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Logger f32285h = Logger.getLogger(e.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ua.d f32286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f32287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final ua.c f32288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f32289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f32290e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final d.b f32291f;

    /* JADX INFO: compiled from: Http2Writer.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public j(@NotNull ua.d sink, boolean z10) {
        t.i(sink, "sink");
        this.f32286a = sink;
        this.f32287b = z10;
        ua.c cVar = new ua.c();
        this.f32288c = cVar;
        this.f32289d = 16384;
        this.f32291f = new d.b(0, false, cVar, 3, null);
    }

    private final void W(int i10, long j10) throws IOException {
        while (j10 > 0) {
            long jMin = Math.min(this.f32289d, j10);
            j10 -= jMin;
            q(i10, (int) jMin, 9, j10 == 0 ? 4 : 0);
            this.f32286a.G(this.f32288c, jMin);
        }
    }

    public final int B() {
        return this.f32289d;
    }

    public final synchronized void J(boolean z10, int i10, int i11) throws IOException {
        if (this.f32290e) {
            throw new IOException("closed");
        }
        q(0, 8, 6, z10 ? 1 : 0);
        this.f32286a.writeInt(i10);
        this.f32286a.writeInt(i11);
        this.f32286a.flush();
    }

    public final synchronized void L(int i10, int i11, @NotNull List<c> requestHeaders) throws IOException {
        t.i(requestHeaders, "requestHeaders");
        if (this.f32290e) {
            throw new IOException("closed");
        }
        this.f32291f.g(requestHeaders);
        long size = this.f32288c.size();
        int iMin = (int) Math.min(((long) this.f32289d) - 4, size);
        long j10 = iMin;
        q(i10, iMin + 4, 5, size == j10 ? 4 : 0);
        this.f32286a.writeInt(i11 & Integer.MAX_VALUE);
        this.f32286a.G(this.f32288c, j10);
        if (size > j10) {
            W(i10, size - j10);
        }
    }

    public final synchronized void O(int i10, @NotNull b errorCode) throws IOException {
        t.i(errorCode, "errorCode");
        if (this.f32290e) {
            throw new IOException("closed");
        }
        if (!(errorCode.c() != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        q(i10, 4, 3, 0);
        this.f32286a.writeInt(errorCode.c());
        this.f32286a.flush();
    }

    public final synchronized void R(@NotNull m settings) throws IOException {
        t.i(settings, "settings");
        if (this.f32290e) {
            throw new IOException("closed");
        }
        int i10 = 0;
        q(0, settings.i() * 6, 4, 0);
        while (i10 < 10) {
            int i11 = i10 + 1;
            if (settings.f(i10)) {
                this.f32286a.writeShort(i10 != 4 ? i10 != 7 ? i10 : 4 : 3);
                this.f32286a.writeInt(settings.a(i10));
            }
            i10 = i11;
        }
        this.f32286a.flush();
    }

    public final synchronized void S(int i10, long j10) throws IOException {
        if (this.f32290e) {
            throw new IOException("closed");
        }
        if (!(j10 != 0 && j10 <= 2147483647L)) {
            throw new IllegalArgumentException(t.r("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: ", Long.valueOf(j10)).toString());
        }
        q(i10, 4, 8, 0);
        this.f32286a.writeInt((int) j10);
        this.f32286a.flush();
    }

    public final synchronized void a(@NotNull m peerSettings) throws IOException {
        t.i(peerSettings, "peerSettings");
        if (this.f32290e) {
            throw new IOException("closed");
        }
        this.f32289d = peerSettings.e(this.f32289d);
        if (peerSettings.b() != -1) {
            this.f32291f.e(peerSettings.b());
        }
        q(0, 0, 4, 1);
        this.f32286a.flush();
    }

    public final synchronized void c() throws IOException {
        if (this.f32290e) {
            throw new IOException("closed");
        }
        if (this.f32287b) {
            Logger logger = f32285h;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(ha.d.t(t.r(">> CONNECTION ", e.f32135b.k()), new Object[0]));
            }
            this.f32286a.I(e.f32135b);
            this.f32286a.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f32290e = true;
        this.f32286a.close();
    }

    public final synchronized void flush() throws IOException {
        if (this.f32290e) {
            throw new IOException("closed");
        }
        this.f32286a.flush();
    }

    public final synchronized void i(boolean z10, int i10, @Nullable ua.c cVar, int i11) throws IOException {
        if (this.f32290e) {
            throw new IOException("closed");
        }
        n(i10, z10 ? 1 : 0, cVar, i11);
    }

    public final void n(int i10, int i11, @Nullable ua.c cVar, int i12) throws IOException {
        q(i10, i12, 0, i11);
        if (i12 > 0) {
            ua.d dVar = this.f32286a;
            t.f(cVar);
            dVar.G(cVar, i12);
        }
    }

    public final void q(int i10, int i11, int i12, int i13) throws IOException {
        Logger logger = f32285h;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(e.f32134a.c(false, i10, i11, i12, i13));
        }
        if (!(i11 <= this.f32289d)) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.f32289d + ": " + i11).toString());
        }
        if (!((Integer.MIN_VALUE & i10) == 0)) {
            throw new IllegalArgumentException(t.r("reserved bit set: ", Integer.valueOf(i10)).toString());
        }
        ha.d.a0(this.f32286a, i11);
        this.f32286a.writeByte(i12 & 255);
        this.f32286a.writeByte(i13 & 255);
        this.f32286a.writeInt(i10 & Integer.MAX_VALUE);
    }

    public final synchronized void x(int i10, @NotNull b errorCode, @NotNull byte[] debugData) throws IOException {
        t.i(errorCode, "errorCode");
        t.i(debugData, "debugData");
        if (this.f32290e) {
            throw new IOException("closed");
        }
        if (!(errorCode.c() != -1)) {
            throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
        }
        q(0, debugData.length + 8, 7, 0);
        this.f32286a.writeInt(i10);
        this.f32286a.writeInt(errorCode.c());
        if (!(debugData.length == 0)) {
            this.f32286a.write(debugData);
        }
        this.f32286a.flush();
    }

    public final synchronized void z(boolean z10, int i10, @NotNull List<c> headerBlock) throws IOException {
        t.i(headerBlock, "headerBlock");
        if (this.f32290e) {
            throw new IOException("closed");
        }
        this.f32291f.g(headerBlock);
        long size = this.f32288c.size();
        long jMin = Math.min(this.f32289d, size);
        int i11 = size == jMin ? 4 : 0;
        if (z10) {
            i11 |= 1;
        }
        q(i10, (int) jMin, 1, i11);
        this.f32286a.G(this.f32288c, jMin);
        if (size > jMin) {
            W(i10, size - jMin);
        }
    }
}
