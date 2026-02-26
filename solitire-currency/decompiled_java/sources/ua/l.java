package ua;

import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ForwardingSink.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class l implements x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final x0 f34784a;

    public l(@NotNull x0 delegate) {
        kotlin.jvm.internal.t.i(delegate, "delegate");
        this.f34784a = delegate;
    }

    @Override // ua.x0
    public void G(@NotNull c source, long j10) throws IOException {
        kotlin.jvm.internal.t.i(source, "source");
        this.f34784a.G(source, j10);
    }

    @Override // ua.x0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f34784a.close();
    }

    @Override // ua.x0, java.io.Flushable
    public void flush() throws IOException {
        this.f34784a.flush();
    }

    @Override // ua.x0
    @NotNull
    public a1 timeout() {
        return this.f34784a.timeout();
    }

    @NotNull
    public String toString() {
        return getClass().getSimpleName() + '(' + this.f34784a + ')';
    }
}
