package ua;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Sink.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface x0 extends Closeable, Flushable {
    void G(@NotNull c cVar, long j10) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    void flush() throws IOException;

    @NotNull
    a1 timeout();
}
