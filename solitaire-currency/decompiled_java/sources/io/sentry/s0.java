package io.sentry;

import io.sentry.protocol.SentryId;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: IContinuousProfiler.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public interface s0 {
    void b(boolean z10);

    void c(@NotNull v3 v3Var, @NotNull w8 w8Var);

    void d();

    void e(@NotNull v3 v3Var);

    @NotNull
    SentryId f();

    boolean isRunning();
}
