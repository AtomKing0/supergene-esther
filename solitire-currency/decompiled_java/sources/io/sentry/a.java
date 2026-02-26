package io.sentry;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AsyncHttpTransportFactory.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class a implements r1 {
    @Override // io.sentry.r1
    @NotNull
    public io.sentry.transport.r a(@NotNull SentryOptions sentryOptions, @NotNull c4 c4Var) {
        io.sentry.util.w.c(sentryOptions, "options is required");
        io.sentry.util.w.c(c4Var, "requestDetails is required");
        return new io.sentry.transport.e(sentryOptions, new io.sentry.transport.b0(sentryOptions), sentryOptions.getTransportGate(), c4Var);
    }
}
