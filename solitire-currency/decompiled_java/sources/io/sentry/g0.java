package io.sentry;

import io.sentry.protocol.SentryTransaction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EventProcessor.java */
/* JADX INFO: loaded from: classes5.dex */
public interface g0 {
    @Nullable
    r6 a(@NotNull r6 r6Var, @NotNull l0 l0Var);

    @Nullable
    SentryTransaction c(@NotNull SentryTransaction sentryTransaction, @NotNull l0 l0Var);

    @Nullable
    Long getOrder();
}
