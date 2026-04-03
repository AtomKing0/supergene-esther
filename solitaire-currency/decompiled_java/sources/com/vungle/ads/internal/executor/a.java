package com.vungle.ads.internal.executor;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface a {
    @NotNull
    i getApiExecutor();

    @NotNull
    i getBackgroundExecutor();

    @NotNull
    i getDownloaderExecutor();

    @NotNull
    i getIoExecutor();

    @NotNull
    i getJobExecutor();

    @NotNull
    i getLoggerExecutor();

    @NotNull
    i getOffloadExecutor();

    @NotNull
    i getUaExecutor();
}
