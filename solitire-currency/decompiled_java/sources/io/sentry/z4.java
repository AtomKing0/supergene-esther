package io.sentry;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SendFireAndForgetOutboxSender.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class z4 implements x4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final u4 f28529a;

    public z4(@NotNull u4 u4Var) {
        this.f28529a = (u4) io.sentry.util.w.c(u4Var, "SendFireAndForgetDirPath is required");
    }

    @Override // io.sentry.x4
    @Nullable
    public t4 a(@NotNull f1 f1Var, @NotNull SentryOptions sentryOptions) {
        io.sentry.util.w.c(f1Var, "Scopes are required");
        io.sentry.util.w.c(sentryOptions, "SentryOptions is required");
        String strA = this.f28529a.a();
        if (strA != null && b(strA, sentryOptions.getLogger())) {
            return c(new q3(f1Var, sentryOptions.getEnvelopeReader(), sentryOptions.getSerializer(), sentryOptions.getLogger(), sentryOptions.getFlushTimeoutMillis(), sentryOptions.getMaxQueueSize()), strA, sentryOptions.getLogger());
        }
        sentryOptions.getLogger().c(SentryLevel.ERROR, "No outbox dir path is defined in options.", new Object[0]);
        return null;
    }

    @Override // io.sentry.x4
    public /* synthetic */ boolean b(String str, w0 w0Var) {
        return w4.a(this, str, w0Var);
    }

    public /* synthetic */ t4 c(w wVar, String str, w0 w0Var) {
        return w4.b(this, wVar, str, w0Var);
    }
}
