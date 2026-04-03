package io.sentry.android.core;

import android.content.Context;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AnrIntegrationFactory.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class m0 {
    @NotNull
    public static io.sentry.v1 a(@NotNull Context context, @NotNull w0 w0Var) {
        return w0Var.d() >= 30 ? new AnrV2Integration(context) : new AnrIntegration(context);
    }
}
