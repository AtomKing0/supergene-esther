package com.vungle.ads.internal.network;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Callback.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface b<T> {
    void onFailure(@Nullable a<T> aVar, @Nullable Throwable th);

    void onResponse(@Nullable a<T> aVar, @Nullable d<T> dVar);
}
