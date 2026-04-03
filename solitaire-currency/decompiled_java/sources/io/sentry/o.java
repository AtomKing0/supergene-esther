package io.sentry;

import io.sentry.UncaughtExceptionHandlerIntegration;
import io.sentry.protocol.SentryException;
import io.sentry.protocol.SentryTransaction;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DeduplicateMultithreadedEventProcessor.java */
/* JADX INFO: loaded from: classes5.dex */
public final class o implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Map<String, Long> f28015a = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final SentryOptions f28016b;

    public o(@NotNull SentryOptions sentryOptions) {
        this.f28016b = sentryOptions;
    }

    @Override // io.sentry.g0
    @Nullable
    public r6 a(@NotNull r6 r6Var, @NotNull l0 l0Var) {
        SentryException sentryExceptionQ;
        String type;
        Long threadId;
        if (!io.sentry.util.m.h(l0Var, UncaughtExceptionHandlerIntegration.a.class) || (sentryExceptionQ = r6Var.q()) == null || (type = sentryExceptionQ.getType()) == null || (threadId = sentryExceptionQ.getThreadId()) == null) {
            return r6Var;
        }
        Long l10 = this.f28015a.get(type);
        if (l10 == null || l10.equals(threadId)) {
            this.f28015a.put(type, threadId);
            return r6Var;
        }
        this.f28016b.getLogger().c(SentryLevel.INFO, "Event %s has been dropped due to multi-threaded deduplication", r6Var.getEventId());
        io.sentry.util.m.r(l0Var, io.sentry.hints.h.MULTITHREADED_DEDUPLICATION);
        return null;
    }

    @Override // io.sentry.g0
    public /* synthetic */ SentryTransaction c(SentryTransaction sentryTransaction, l0 l0Var) {
        return f0.a(this, sentryTransaction, l0Var);
    }

    @Override // io.sentry.g0
    @Nullable
    public Long getOrder() {
        return 7000L;
    }
}
