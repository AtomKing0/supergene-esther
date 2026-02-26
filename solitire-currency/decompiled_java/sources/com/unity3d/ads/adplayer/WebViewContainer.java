package com.unity3d.ads.adplayer;

import android.view.InputEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;
import v8.k0;

/* JADX INFO: compiled from: WebViewContainer.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface WebViewContainer {
    @Nullable
    Object addJavascriptInterface(@NotNull WebViewBridge webViewBridge, @NotNull String str, @NotNull z8.d<? super k0> dVar);

    @Nullable
    Object destroy(@NotNull z8.d<? super k0> dVar);

    @Nullable
    Object evaluateJavascript(@NotNull String str, @NotNull z8.d<? super k0> dVar);

    @NotNull
    m0<InputEvent> getLastInputEvent();

    @Nullable
    Object loadUrl(@NotNull String str, @NotNull z8.d<? super k0> dVar);
}
