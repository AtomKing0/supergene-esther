package io.sentry;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SendFireAndForgetEnvelopeSender.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class y4 implements x4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final u4 f28511a;

    public y4(@NotNull u4 u4Var) {
        this.f28511a = (u4) io.sentry.util.w.c(u4Var, "SendFireAndForgetDirPath is required");
    }

    @Override // io.sentry.x4
    @Nullable
    public t4 a(@NotNull f1 f1Var, @NotNull SentryOptions sentryOptions) {
        io.sentry.util.w.c(f1Var, "Scopes are required");
        io.sentry.util.w.c(sentryOptions, "SentryOptions is required");
        String strA = this.f28511a.a();
        if (strA != null && b(strA, sentryOptions.getLogger())) {
            return c(new e0(f1Var, sentryOptions.getSerializer(), sentryOptions.getLogger(), sentryOptions.getFlushTimeoutMillis(), sentryOptions.getMaxQueueSize()), strA, sentryOptions.getLogger());
        }
        sentryOptions.getLogger().c(SentryLevel.ERROR, "No cache dir path is defined in options.", new Object[0]);
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
