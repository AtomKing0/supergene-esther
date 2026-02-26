package io.sentry.transport;

import io.sentry.l0;
import io.sentry.p5;
import java.io.IOException;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NoOpTransport.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class u implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final u f28297a = new u();

    private u() {
    }

    @NotNull
    public static u a() {
        return f28297a;
    }

    @Override // io.sentry.transport.r
    public /* synthetic */ boolean d() {
        return q.a(this);
    }

    @Override // io.sentry.transport.r
    @Nullable
    public b0 e() {
        return null;
    }

    @Override // io.sentry.transport.r
    public /* synthetic */ void z0(p5 p5Var) throws IOException {
        q.b(this, p5Var);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // io.sentry.transport.r
    public void b(boolean z10) throws IOException {
    }

    @Override // io.sentry.transport.r
    public void f(long j10) {
    }

    @Override // io.sentry.transport.r
    public void v(@NotNull p5 p5Var, @NotNull l0 l0Var) throws IOException {
    }
}
