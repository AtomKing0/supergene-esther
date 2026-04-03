package com.unity3d.services.core.webview.bridge;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IWebViewBridge.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface IWebViewBridge {
    void handleCallback(@Nullable String str, @Nullable String str2, @Nullable Object[] objArr) throws Exception;

    void handleInvocation(@Nullable String str, @Nullable String str2, @Nullable Object[] objArr, @Nullable WebViewCallback webViewCallback) throws Exception;
}
