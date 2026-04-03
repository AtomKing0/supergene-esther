package com.vungle.ads.internal.executor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SDKExecutors.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d implements com.vungle.ads.internal.executor.a {

    @NotNull
    public static final a Companion = new a(null);
    private static final int IO_KEEP_ALIVE_TIME_SECONDS = 5;
    private static final int JOBS_KEEP_ALIVE_TIME_SECONDS = 1;
    private static final int SINGLE_CORE_POOL_SIZE = 1;
    private static final int VUNGLE_KEEP_ALIVE_TIME_SECONDS = 10;

    @NotNull
    private i API_EXECUTOR;

    @NotNull
    private i BACKGROUND_EXECUTOR;

    @NotNull
    private i DOWNLOADER_EXECUTOR;

    @NotNull
    private i IO_EXECUTOR;

    @NotNull
    private i JOB_EXECUTOR;

    @NotNull
    private i LOGGER_EXECUTOR;
    private final int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();

    @NotNull
    private i OFFLOAD_EXECUTOR;

    @NotNull
    private i UA_EXECUTOR;

    /* JADX INFO: compiled from: SDKExecutors.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    public d() {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.JOB_EXECUTOR = new i(1, 1, 1L, timeUnit, new LinkedBlockingQueue(), new c("vng_jr"));
        this.IO_EXECUTOR = new i(1, 1, 5L, timeUnit, new LinkedBlockingQueue(), new c("vng_io"));
        this.API_EXECUTOR = new i(1, 1, 10L, timeUnit, new LinkedBlockingQueue(), new c("vng_api"));
        this.LOGGER_EXECUTOR = new i(1, 1, 10L, timeUnit, new LinkedBlockingQueue(), new c("vng_logger"));
        this.BACKGROUND_EXECUTOR = new i(1, 1, 10L, timeUnit, new LinkedBlockingQueue(), new c("vng_background"));
        this.UA_EXECUTOR = new i(1, 1, 10L, timeUnit, new LinkedBlockingQueue(), new c("vng_ua"));
        this.DOWNLOADER_EXECUTOR = new i(4, 4, 1L, timeUnit, new PriorityBlockingQueue(), new c("vng_down"));
        this.OFFLOAD_EXECUTOR = new i(1, 1, 10L, timeUnit, new LinkedBlockingQueue(), new c("vng_ol"));
    }

    @Override // com.vungle.ads.internal.executor.a
    @NotNull
    public i getApiExecutor() {
        return this.API_EXECUTOR;
    }

    @Override // com.vungle.ads.internal.executor.a
    @NotNull
    public i getBackgroundExecutor() {
        return this.BACKGROUND_EXECUTOR;
    }

    @Override // com.vungle.ads.internal.executor.a
    @NotNull
    public i getDownloaderExecutor() {
        return this.DOWNLOADER_EXECUTOR;
    }

    @Override // com.vungle.ads.internal.executor.a
    @NotNull
    public i getIoExecutor() {
        return this.IO_EXECUTOR;
    }

    @Override // com.vungle.ads.internal.executor.a
    @NotNull
    public i getJobExecutor() {
        return this.JOB_EXECUTOR;
    }

    @Override // com.vungle.ads.internal.executor.a
    @NotNull
    public i getLoggerExecutor() {
        return this.LOGGER_EXECUTOR;
    }

    @Override // com.vungle.ads.internal.executor.a
    @NotNull
    public i getOffloadExecutor() {
        return this.OFFLOAD_EXECUTOR;
    }

    @Override // com.vungle.ads.internal.executor.a
    @NotNull
    public i getUaExecutor() {
        return this.UA_EXECUTOR;
    }
}
