package io.sentry;

import io.sentry.protocol.Feedback;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ISentryClient.java */
/* JADX INFO: loaded from: classes5.dex */
public interface i1 {
    @ApiStatus.Internal
    @NotNull
    SentryId a(@NotNull SentryTransaction sentryTransaction, @Nullable v8 v8Var, @Nullable c1 c1Var, @Nullable l0 l0Var, @Nullable x3 x3Var);

    void b(boolean z10);

    @NotNull
    SentryId c(@NotNull r6 r6Var, @Nullable c1 c1Var);

    @ApiStatus.Internal
    boolean d();

    @ApiStatus.Internal
    @Nullable
    io.sentry.transport.b0 e();

    void f(long j10);

    void g(@NotNull e8 e8Var, @Nullable l0 l0Var);

    @NotNull
    SentryId h(@NotNull Feedback feedback, @Nullable l0 l0Var, @NotNull c1 c1Var);

    @Nullable
    SentryId i(@NotNull p5 p5Var, @Nullable l0 l0Var);

    boolean isEnabled();

    void j(@NotNull c9 c9Var);

    @ApiStatus.Internal
    void k(@NotNull f7 f7Var);

    @ApiStatus.Experimental
    @NotNull
    SentryId l(@NotNull f fVar, @Nullable c1 c1Var, @Nullable l0 l0Var);

    @NotNull
    SentryId m(@NotNull String str, @NotNull SentryLevel sentryLevel, @Nullable c1 c1Var);

    @ApiStatus.Internal
    @NotNull
    SentryId n(@NotNull t3 t3Var, @Nullable c1 c1Var);

    @NotNull
    SentryId o(@NotNull r6 r6Var, @Nullable c1 c1Var, @Nullable l0 l0Var);
}
