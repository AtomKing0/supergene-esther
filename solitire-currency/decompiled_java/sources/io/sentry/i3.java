package io.sentry;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: NoOpTransportFactory.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class i3 implements r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final i3 f27888a = new i3();

    private i3() {
    }

    public static i3 b() {
        return f27888a;
    }

    @Override // io.sentry.r1
    @NotNull
    public io.sentry.transport.r a(@NotNull SentryOptions sentryOptions, @NotNull c4 c4Var) {
        return io.sentry.transport.u.a();
    }
}
