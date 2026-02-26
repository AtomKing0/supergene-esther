package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(21)
public final class zzcfs extends zzcfr {
    public zzcfs(zzcej zzcejVar, zzbav zzbavVar, boolean z10, @Nullable zzeds zzedsVar) {
        super(zzcejVar, zzbavVar, z10, zzedsVar);
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            return null;
        }
        return zzS(webView, webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders());
    }
}
