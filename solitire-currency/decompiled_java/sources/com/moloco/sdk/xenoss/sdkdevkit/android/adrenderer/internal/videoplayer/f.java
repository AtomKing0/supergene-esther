package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer;

import android.view.View;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public interface f extends i {
    @Nullable
    View F();

    @Nullable
    Object a(@NotNull z8.d<? super k0> dVar);

    void a(@Nullable String str);

    void a(boolean z10);

    @NotNull
    m0<l> e();

    @NotNull
    m0<b> isPlaying();

    @NotNull
    m0<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i> o();

    void pause();

    void play();

    void seekTo(long j10);
}
