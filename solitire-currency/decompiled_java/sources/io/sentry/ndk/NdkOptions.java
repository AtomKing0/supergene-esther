package io.sentry.ndk;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class NdkOptions {

    @Nullable
    private final String dist;

    @NotNull
    private final String dsn;

    @Nullable
    private final String environment;
    private final boolean isDebug;
    private final int maxBreadcrumbs;

    @NotNull
    private final String outboxPath;

    @Nullable
    private final String release;

    @Nullable
    private final String sdkName;
    private b ndkHandlerStrategy = b.SENTRY_HANDLER_STRATEGY_DEFAULT;
    private float tracesSampleRate = 0.0f;

    public NdkOptions(@NotNull String str, boolean z10, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, int i10, @Nullable String str6) {
        this.dsn = str;
        this.isDebug = z10;
        this.outboxPath = str2;
        this.release = str3;
        this.environment = str4;
        this.dist = str5;
        this.maxBreadcrumbs = i10;
        this.sdkName = str6;
    }

    @Nullable
    public String getDist() {
        return this.dist;
    }

    @NotNull
    public String getDsn() {
        return this.dsn;
    }

    @Nullable
    public String getEnvironment() {
        return this.environment;
    }

    public int getMaxBreadcrumbs() {
        return this.maxBreadcrumbs;
    }

    public int getNdkHandlerStrategy() {
        return this.ndkHandlerStrategy.getValue();
    }

    @NotNull
    public String getOutboxPath() {
        return this.outboxPath;
    }

    @Nullable
    public String getRelease() {
        return this.release;
    }

    @Nullable
    public String getSdkName() {
        return this.sdkName;
    }

    public float getTracesSampleRate() {
        return this.tracesSampleRate;
    }

    public boolean isDebug() {
        return this.isDebug;
    }

    public void setNdkHandlerStrategy(@NotNull b bVar) {
        this.ndkHandlerStrategy = bVar;
    }

    public void setTracesSampleRate(float f10) {
        this.tracesSampleRate = f10;
    }
}
