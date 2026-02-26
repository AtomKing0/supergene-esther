package ua;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GzipSink.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class o implements x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final s0 f34790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Deflater f34791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final g f34792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f34793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final CRC32 f34794e;

    public o(@NotNull x0 sink) {
        kotlin.jvm.internal.t.i(sink, "sink");
        s0 s0Var = new s0(sink);
        this.f34790a = s0Var;
        Deflater deflater = new Deflater(-1, true);
        this.f34791b = deflater;
        this.f34792c = new g(s0Var, deflater);
        this.f34794e = new CRC32();
        c cVar = s0Var.f34819b;
        cVar.writeShort(8075);
        cVar.writeByte(8);
        cVar.writeByte(0);
        cVar.writeInt(0);
        cVar.writeByte(0);
        cVar.writeByte(0);
    }

    private final void a(c cVar, long j10) {
        u0 u0Var = cVar.f34738a;
        kotlin.jvm.internal.t.f(u0Var);
        while (j10 > 0) {
            int iMin = (int) Math.min(j10, u0Var.f34828c - u0Var.f34827b);
            this.f34794e.update(u0Var.f34826a, u0Var.f34827b, iMin);
            j10 -= (long) iMin;
            u0Var = u0Var.f34831f;
            kotlin.jvm.internal.t.f(u0Var);
        }
    }

    private final void c() {
        this.f34790a.a((int) this.f34794e.getValue());
        this.f34790a.a((int) this.f34791b.getBytesRead());
    }

    @Override // ua.x0
    public void G(@NotNull c source, long j10) throws IOException {
        kotlin.jvm.internal.t.i(source, "source");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        }
        if (j10 == 0) {
            return;
        }
        a(source, j10);
        this.f34792c.G(source, j10);
    }

    @Override // ua.x0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f34793d) {
            return;
        }
        try {
            this.f34792c.c();
            c();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f34791b.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            this.f34790a.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f34793d = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // ua.x0, java.io.Flushable
    public void flush() throws IOException {
        this.f34792c.flush();
    }

    @Override // ua.x0
    @NotNull
    public a1 timeout() {
        return this.f34790a.timeout();
    }
}
