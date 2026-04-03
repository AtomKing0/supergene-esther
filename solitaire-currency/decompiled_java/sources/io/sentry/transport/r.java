package io.sentry.transport;

import io.sentry.l0;
import io.sentry.p5;
import java.io.Closeable;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ITransport.java */
/* JADX INFO: loaded from: classes5.dex */
public interface r extends Closeable {
    void b(boolean z10) throws IOException;

    boolean d();

    @Nullable
    b0 e();

    void f(long j10);

    void v(@NotNull p5 p5Var, @NotNull l0 l0Var) throws IOException;

    void z0(@NotNull p5 p5Var) throws IOException;
}
