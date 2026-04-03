package com.google.android.gms.internal.ads;

import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfnb extends WebViewClient {
    final /* synthetic */ zzfnd zza;

    zzfnb(zzfnd zzfndVar) {
        this.zza = zzfndVar;
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        Log.w("NativeBridge", "WebView renderer gone: " + renderProcessGoneDetail.toString() + "for WebView: " + String.valueOf(webView));
        if (this.zza.zza() == webView) {
            Log.w("NativeBridge", "Deallocating the Native bridge as it is unusable. No further events will be generated for this session.");
            this.zza.zzm(null);
        }
        webView.destroy();
        return true;
    }
}
