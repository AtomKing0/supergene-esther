package com.facebook.ads.redexgen.core;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class TZ extends WebViewClient {
    public final /* synthetic */ CallableC2005Ta A00;

    public TZ(CallableC2005Ta callableC2005Ta) {
        this.A00 = callableC2005Ta;
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        AbstractC2161Ze.A0D(AbstractC2000Sv.A2j);
        return true;
    }
}
