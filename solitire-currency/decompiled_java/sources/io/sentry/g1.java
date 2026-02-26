package io.sentry;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IScopesStorage.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public interface g1 {
    void a();

    @NotNull
    k1 b(@Nullable f1 f1Var);

    void close();

    @Nullable
    f1 get();
}
