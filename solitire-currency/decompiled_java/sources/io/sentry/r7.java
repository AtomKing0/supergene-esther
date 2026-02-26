package io.sentry;

import androidx.media3.exoplayer.ExoPlayer;
import io.sentry.protocol.SentryRuntime;
import io.sentry.protocol.SentryTransaction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SentryRuntimeEventProcessor.java */
/* JADX INFO: loaded from: classes5.dex */
final class r7 implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final String f28154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f28155b;

    public r7(@Nullable String str, @Nullable String str2) {
        this.f28154a = str;
        this.f28155b = str2;
    }

    @NotNull
    private <T extends i5> T b(@NotNull T t10) {
        if (t10.getContexts().getRuntime() == null) {
            t10.getContexts().setRuntime(new SentryRuntime());
        }
        SentryRuntime runtime = t10.getContexts().getRuntime();
        if (runtime != null && runtime.getName() == null && runtime.getVersion() == null) {
            runtime.setName(this.f28155b);
            runtime.setVersion(this.f28154a);
        }
        return t10;
    }

    @Override // io.sentry.g0
    @NotNull
    public r6 a(@NotNull r6 r6Var, @Nullable l0 l0Var) {
        return (r6) b(r6Var);
    }

    @Override // io.sentry.g0
    @NotNull
    public SentryTransaction c(@NotNull SentryTransaction sentryTransaction, @Nullable l0 l0Var) {
        return (SentryTransaction) b(sentryTransaction);
    }

    @Override // io.sentry.g0
    @Nullable
    public Long getOrder() {
        return Long.valueOf(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    public r7() {
        this(System.getProperty("java.version"), System.getProperty("java.vendor"));
    }
}
