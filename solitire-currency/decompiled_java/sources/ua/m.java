package ua;

import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ForwardingSource.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class m implements z0 {

    @NotNull
    private final z0 delegate;

    public m(@NotNull z0 delegate) {
        kotlin.jvm.internal.t.i(delegate, "delegate");
        this.delegate = delegate;
    }

    @NotNull
    /* JADX INFO: renamed from: -deprecated_delegate, reason: not valid java name */
    public final z0 m4221deprecated_delegate() {
        return this.delegate;
    }

    @Override // ua.z0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @NotNull
    public final z0 delegate() {
        return this.delegate;
    }

    @Override // ua.z0
    public long read(@NotNull c sink, long j10) throws IOException {
        kotlin.jvm.internal.t.i(sink, "sink");
        return this.delegate.read(sink, j10);
    }

    @Override // ua.z0
    @NotNull
    public a1 timeout() {
        return this.delegate.timeout();
    }

    @NotNull
    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
