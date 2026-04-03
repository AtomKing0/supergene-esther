package io.sentry.hints;

import io.sentry.protocol.SentryId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DiskFlushNotification.java */
/* JADX INFO: loaded from: classes5.dex */
public interface f {
    boolean b(@Nullable SentryId sentryId);

    void c(@NotNull SentryId sentryId);

    void d();
}
