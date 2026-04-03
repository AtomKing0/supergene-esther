package ua;

import java.io.IOException;
import java.io.OutputStream;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: JvmOkio.kt */
/* JADX INFO: loaded from: classes5.dex */
final class o0 implements x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final OutputStream f34795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final a1 f34796b;

    public o0(@NotNull OutputStream out, @NotNull a1 timeout) {
        kotlin.jvm.internal.t.i(out, "out");
        kotlin.jvm.internal.t.i(timeout, "timeout");
        this.f34795a = out;
        this.f34796b = timeout;
    }

    @Override // ua.x0
    public void G(@NotNull c source, long j10) throws IOException {
        kotlin.jvm.internal.t.i(source, "source");
        f1.b(source.size(), 0L, j10);
        while (j10 > 0) {
            this.f34796b.f();
            u0 u0Var = source.f34738a;
            kotlin.jvm.internal.t.f(u0Var);
            int iMin = (int) Math.min(j10, u0Var.f34828c - u0Var.f34827b);
            this.f34795a.write(u0Var.f34826a, u0Var.f34827b, iMin);
            u0Var.f34827b += iMin;
            long j11 = iMin;
            j10 -= j11;
            source.L0(source.size() - j11);
            if (u0Var.f34827b == u0Var.f34828c) {
                source.f34738a = u0Var.b();
                v0.b(u0Var);
            }
        }
    }

    @Override // ua.x0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f34795a.close();
    }

    @Override // ua.x0, java.io.Flushable
    public void flush() throws IOException {
        this.f34795a.flush();
    }

    @Override // ua.x0
    @NotNull
    public a1 timeout() {
        return this.f34796b;
    }

    @NotNull
    public String toString() {
        return "sink(" + this.f34795a + ')';
    }
}
