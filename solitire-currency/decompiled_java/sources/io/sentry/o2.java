package io.sentry;

import io.sentry.r0;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NoOpConnectionStatusProvider.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class o2 implements r0 {
    @Override // io.sentry.r0
    @NotNull
    public r0.a a() {
        return r0.a.UNKNOWN;
    }

    @Override // io.sentry.r0
    public boolean b(@NotNull r0.b bVar) {
        return false;
    }

    @Override // io.sentry.r0
    @Nullable
    public String getConnectionType() {
        return null;
    }

    @Override // io.sentry.r0
    public void c(@NotNull r0.b bVar) {
    }
}
