package com.unity3d.ads.core.domain;

import com.unity3d.ads.adplayer.AndroidWebViewContainer;
import com.unity3d.ads.adplayer.CommonWebViewBridge;
import com.unity3d.ads.adplayer.WebViewBridge;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GetCommonWebViewBridgeUseCase.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GetCommonWebViewBridgeUseCase implements GetWebViewBridgeUseCase {

    @NotNull
    private final k0 dispatcher;

    /* JADX WARN: Multi-variable type inference failed */
    public GetCommonWebViewBridgeUseCase() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.unity3d.ads.core.domain.GetWebViewBridgeUseCase
    @NotNull
    public WebViewBridge invoke(@NotNull AndroidWebViewContainer webViewContainer, @NotNull o0 adPlayerScope) {
        t.i(webViewContainer, "webViewContainer");
        t.i(adPlayerScope, "adPlayerScope");
        return new CommonWebViewBridge(this.dispatcher, webViewContainer, adPlayerScope);
    }

    public GetCommonWebViewBridgeUseCase(@NotNull k0 dispatcher) {
        t.i(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
    }

    public /* synthetic */ GetCommonWebViewBridgeUseCase(k0 k0Var, int i10, k kVar) {
        this((i10 & 1) != 0 ? e1.a() : k0Var);
    }
}
