package io.sentry;

import java.util.List;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ITransactionProfiler.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public interface q1 {
    void a(@NotNull p1 p1Var);

    @Nullable
    x3 b(@NotNull p1 p1Var, @Nullable List<r3> list, @NotNull SentryOptions sentryOptions);

    void close();

    boolean isRunning();

    void start();
}
