package io.sentry;

import io.sentry.protocol.SentryId;
import io.sentry.protocol.TransactionNameSource;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ITransaction.java */
/* JADX INFO: loaded from: classes5.dex */
public interface p1 extends n1 {
    @ApiStatus.Internal
    void b(@NotNull q8 q8Var, boolean z10, @Nullable l0 l0Var);

    @ApiStatus.Internal
    void c(@NotNull String str, @NotNull TransactionNameSource transactionNameSource);

    @NotNull
    SentryId getEventId();

    @NotNull
    String getName();

    @Nullable
    n1 o();

    void q();
}
