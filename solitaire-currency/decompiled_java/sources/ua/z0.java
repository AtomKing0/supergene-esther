package ua;

import java.io.Closeable;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Source.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface z0 extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    long read(@NotNull c cVar, long j10) throws IOException;

    @NotNull
    a1 timeout();
}
