package com.unity3d.ads.adplayer;

import com.unity3d.ads.adplayer.model.WebViewEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.c0;
import v8.k0;

/* JADX INFO: compiled from: WebViewBridge.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface WebViewBridge {
    @NotNull
    c0<Invocation> getOnInvocation();

    void handleCallback(@NotNull String str, @NotNull String str2, @NotNull String str3);

    void handleInvocation(@NotNull String str);

    @Nullable
    Object request(@NotNull String str, @NotNull String str2, @NotNull Object[] objArr, @NotNull z8.d<? super Object[]> dVar);

    @Nullable
    Object sendEvent(@NotNull WebViewEvent webViewEvent, @NotNull z8.d<? super k0> dVar);
}
