package io.sentry;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IConnectionStatusProvider.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public interface r0 {

    /* JADX INFO: compiled from: IConnectionStatusProvider.java */
    public enum a {
        UNKNOWN,
        CONNECTED,
        DISCONNECTED,
        NO_PERMISSION
    }

    /* JADX INFO: compiled from: IConnectionStatusProvider.java */
    public interface b {
        void a(@NotNull a aVar);
    }

    @NotNull
    a a();

    boolean b(@NotNull b bVar);

    void c(@NotNull b bVar);

    @Nullable
    String getConnectionType();
}
