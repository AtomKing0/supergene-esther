package ua;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InflaterSource.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class q implements z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final e f34802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Inflater f34803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f34804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f34805d;

    public q(@NotNull e source, @NotNull Inflater inflater) {
        kotlin.jvm.internal.t.i(source, "source");
        kotlin.jvm.internal.t.i(inflater, "inflater");
        this.f34802a = source;
        this.f34803b = inflater;
    }

    private final void i() throws IOException {
        int i10 = this.f34804c;
        if (i10 == 0) {
            return;
        }
        int remaining = i10 - this.f34803b.getRemaining();
        this.f34804c -= remaining;
        this.f34802a.skip(remaining);
    }

    public final long a(@NotNull c sink, long j10) throws IOException {
        kotlin.jvm.internal.t.i(sink, "sink");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        }
        if (!(!this.f34805d)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j10 == 0) {
            return 0L;
        }
        try {
            u0 u0VarO0 = sink.O0(1);
            int iMin = (int) Math.min(j10, 8192 - u0VarO0.f34828c);
            c();
            int iInflate = this.f34803b.inflate(u0VarO0.f34826a, u0VarO0.f34828c, iMin);
            i();
            if (iInflate > 0) {
                u0VarO0.f34828c += iInflate;
                long j11 = iInflate;
                sink.L0(sink.size() + j11);
                return j11;
            }
            if (u0VarO0.f34827b == u0VarO0.f34828c) {
                sink.f34738a = u0VarO0.b();
                v0.b(u0VarO0);
            }
            return 0L;
        } catch (DataFormatException e10) {
            throw new IOException(e10);
        }
    }

    public final boolean c() throws IOException {
        if (!this.f34803b.needsInput()) {
            return false;
        }
        if (this.f34802a.m0()) {
            return true;
        }
        u0 u0Var = this.f34802a.g().f34738a;
        kotlin.jvm.internal.t.f(u0Var);
        int i10 = u0Var.f34828c;
        int i11 = u0Var.f34827b;
        int i12 = i10 - i11;
        this.f34804c = i12;
        this.f34803b.setInput(u0Var.f34826a, i11, i12);
        return false;
    }

    @Override // ua.z0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f34805d) {
            return;
        }
        this.f34803b.end();
        this.f34805d = true;
        this.f34802a.close();
    }

    @Override // ua.z0
    public long read(@NotNull c sink, long j10) throws IOException {
        kotlin.jvm.internal.t.i(sink, "sink");
        do {
            long jA = a(sink, j10);
            if (jA > 0) {
                return jA;
            }
            if (this.f34803b.finished() || this.f34803b.needsDictionary()) {
                return -1L;
            }
        } while (!this.f34802a.m0());
        throw new EOFException("source exhausted prematurely");
    }

    @Override // ua.z0
    @NotNull
    public a1 timeout() {
        return this.f34802a.timeout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public q(@NotNull z0 source, @NotNull Inflater inflater) {
        this(k0.d(source), inflater);
        kotlin.jvm.internal.t.i(source, "source");
        kotlin.jvm.internal.t.i(inflater, "inflater");
    }
}
