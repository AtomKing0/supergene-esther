package io.sentry;

import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ISentryExecutorService.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public interface j1 {
    void a(long j10);

    @NotNull
    Future<?> b(@NotNull Runnable runnable, long j10) throws RejectedExecutionException;

    boolean isClosed();

    @NotNull
    Future<?> submit(@NotNull Runnable runnable) throws RejectedExecutionException;
}
