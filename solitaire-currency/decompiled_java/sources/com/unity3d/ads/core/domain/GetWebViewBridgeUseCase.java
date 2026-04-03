package com.unity3d.ads.core.domain;

import com.unity3d.ads.adplayer.AndroidWebViewContainer;
import com.unity3d.ads.adplayer.WebViewBridge;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GetWebViewBridgeUseCase.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface GetWebViewBridgeUseCase {
    @NotNull
    WebViewBridge invoke(@NotNull AndroidWebViewContainer androidWebViewContainer, @NotNull o0 o0Var);
}
