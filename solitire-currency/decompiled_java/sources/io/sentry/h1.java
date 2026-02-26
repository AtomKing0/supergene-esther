package io.sentry;

import io.sentry.protocol.Message;
import io.sentry.protocol.SentryId;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ISentryClient.java */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class h1 {
    @NotNull
    public static SentryId a(i1 i1Var, @NotNull r6 r6Var, @Nullable c1 c1Var) {
        return i1Var.o(r6Var, c1Var, null);
    }

    @NotNull
    public static SentryId b(i1 i1Var, @NotNull String str, @NotNull SentryLevel sentryLevel, @Nullable c1 c1Var) {
        r6 r6Var = new r6();
        Message message = new Message();
        message.setFormatted(str);
        r6Var.w(message);
        r6Var.v(sentryLevel);
        return i1Var.c(r6Var, c1Var);
    }

    @ApiStatus.Internal
    public static boolean c(i1 i1Var) {
        return true;
    }
}
