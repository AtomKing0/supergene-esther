package ua;

import java.io.EOFException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Okio.kt */
/* JADX INFO: loaded from: classes5.dex */
final class b implements x0 {
    @Override // ua.x0
    public void G(@NotNull c source, long j10) throws EOFException {
        kotlin.jvm.internal.t.i(source, "source");
        source.skip(j10);
    }

    @Override // ua.x0
    @NotNull
    public a1 timeout() {
        return a1.f34734e;
    }

    @Override // ua.x0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // ua.x0, java.io.Flushable
    public void flush() {
    }
}
