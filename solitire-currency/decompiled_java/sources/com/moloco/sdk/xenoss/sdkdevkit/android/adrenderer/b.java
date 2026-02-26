package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;

/* JADX INFO: loaded from: classes4.dex */
public interface b {

    public interface a {
        void a();

        void a(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVar);

        void b(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a aVar);
    }

    void g(long j10, @Nullable a aVar);

    @NotNull
    m0<Boolean> isLoaded();
}
