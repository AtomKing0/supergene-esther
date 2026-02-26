package com.vungle.ads.internal.network;

import java.io.IOException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Call.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface a<T> {
    void cancel();

    void enqueue(@NotNull b<T> bVar);

    @Nullable
    d<T> execute() throws IOException;

    boolean isCanceled();
}
