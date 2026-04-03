package ua;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GzipSource.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class p implements z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte f34797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final t0 f34798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final Inflater f34799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final q f34800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final CRC32 f34801e;

    public p(@NotNull z0 source) {
        kotlin.jvm.internal.t.i(source, "source");
        t0 t0Var = new t0(source);
        this.f34798b = t0Var;
        Inflater inflater = new Inflater(true);
        this.f34799c = inflater;
        this.f34800d = new q((e) t0Var, inflater);
        this.f34801e = new CRC32();
    }

    private final void a(String str, int i10, int i11) throws IOException {
        if (i11 == i10) {
            return;
        }
        String str2 = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i11), Integer.valueOf(i10)}, 3));
        kotlin.jvm.internal.t.h(str2, "format(this, *args)");
        throw new IOException(str2);
    }

    private final void c() throws IOException {
        this.f34798b.a0(10L);
        byte bL = this.f34798b.f34822b.L(3L);
        boolean z10 = ((bL >> 1) & 1) == 1;
        if (z10) {
            n(this.f34798b.f34822b, 0L, 10L);
        }
        a("ID1ID2", 8075, this.f34798b.readShort());
        this.f34798b.skip(8L);
        if (((bL >> 2) & 1) == 1) {
            this.f34798b.a0(2L);
            if (z10) {
                n(this.f34798b.f34822b, 0L, 2L);
            }
            long jT = this.f34798b.f34822b.T();
            this.f34798b.a0(jT);
            if (z10) {
                n(this.f34798b.f34822b, 0L, jT);
            }
            this.f34798b.skip(jT);
        }
        if (((bL >> 3) & 1) == 1) {
            long jA = this.f34798b.a((byte) 0);
            if (jA == -1) {
                throw new EOFException();
            }
            if (z10) {
                n(this.f34798b.f34822b, 0L, jA + 1);
            }
            this.f34798b.skip(jA + 1);
        }
        if (((bL >> 4) & 1) == 1) {
            long jA2 = this.f34798b.a((byte) 0);
            if (jA2 == -1) {
                throw new EOFException();
            }
            if (z10) {
                n(this.f34798b.f34822b, 0L, jA2 + 1);
            }
            this.f34798b.skip(jA2 + 1);
        }
        if (z10) {
            a("FHCRC", this.f34798b.T(), (short) this.f34801e.getValue());
            this.f34801e.reset();
        }
    }

    private final void i() throws IOException {
        a("CRC", this.f34798b.y0(), (int) this.f34801e.getValue());
        a("ISIZE", this.f34798b.y0(), (int) this.f34799c.getBytesWritten());
    }

    private final void n(c cVar, long j10, long j11) {
        u0 u0Var = cVar.f34738a;
        kotlin.jvm.internal.t.f(u0Var);
        while (true) {
            int i10 = u0Var.f34828c;
            int i11 = u0Var.f34827b;
            if (j10 < i10 - i11) {
                break;
            }
            j10 -= (long) (i10 - i11);
            u0Var = u0Var.f34831f;
            kotlin.jvm.internal.t.f(u0Var);
        }
        while (j11 > 0) {
            int i12 = (int) (((long) u0Var.f34827b) + j10);
            int iMin = (int) Math.min(u0Var.f34828c - i12, j11);
            this.f34801e.update(u0Var.f34826a, i12, iMin);
            j11 -= (long) iMin;
            u0Var = u0Var.f34831f;
            kotlin.jvm.internal.t.f(u0Var);
            j10 = 0;
        }
    }

    @Override // ua.z0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f34800d.close();
    }

    @Override // ua.z0
    public long read(@NotNull c sink, long j10) throws IOException {
        kotlin.jvm.internal.t.i(sink, "sink");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        }
        if (j10 == 0) {
            return 0L;
        }
        if (this.f34797a == 0) {
            c();
            this.f34797a = (byte) 1;
        }
        if (this.f34797a == 1) {
            long size = sink.size();
            long j11 = this.f34800d.read(sink, j10);
            if (j11 != -1) {
                n(sink, size, j11);
                return j11;
            }
            this.f34797a = (byte) 2;
        }
        if (this.f34797a == 2) {
            i();
            this.f34797a = (byte) 3;
            if (!this.f34798b.m0()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // ua.z0
    @NotNull
    public a1 timeout() {
        return this.f34798b.timeout();
    }
}
