package ua;

import java.io.IOException;
import java.io.InputStream;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: JvmOkio.kt */
/* JADX INFO: loaded from: classes5.dex */
class r implements z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final InputStream f34809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final a1 f34810b;

    public r(@NotNull InputStream input, @NotNull a1 timeout) {
        kotlin.jvm.internal.t.i(input, "input");
        kotlin.jvm.internal.t.i(timeout, "timeout");
        this.f34809a = input;
        this.f34810b = timeout;
    }

    @Override // ua.z0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f34809a.close();
    }

    @Override // ua.z0
    public long read(@NotNull c sink, long j10) throws IOException {
        kotlin.jvm.internal.t.i(sink, "sink");
        if (j10 == 0) {
            return 0L;
        }
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        }
        try {
            this.f34810b.f();
            u0 u0VarO0 = sink.O0(1);
            int i10 = this.f34809a.read(u0VarO0.f34826a, u0VarO0.f34828c, (int) Math.min(j10, 8192 - u0VarO0.f34828c));
            if (i10 != -1) {
                u0VarO0.f34828c += i10;
                long j11 = i10;
                sink.L0(sink.size() + j11);
                return j11;
            }
            if (u0VarO0.f34827b != u0VarO0.f34828c) {
                return -1L;
            }
            sink.f34738a = u0VarO0.b();
            v0.b(u0VarO0);
            return -1L;
        } catch (AssertionError e10) {
            if (k0.e(e10)) {
                throw new IOException(e10);
            }
            throw e10;
        }
    }

    @Override // ua.z0
    @NotNull
    public a1 timeout() {
        return this.f34810b;
    }

    @NotNull
    public String toString() {
        return "source(" + this.f34809a + ')';
    }
}
