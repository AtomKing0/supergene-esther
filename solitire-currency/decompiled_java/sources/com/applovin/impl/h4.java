package com.applovin.impl;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.google.android.gms.measurement.AppMeasurement;
import io.sentry.protocol.TransactionInfo;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class h4 extends WebViewClient {
    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        HashMap<String, String> mapHashMap = CollectionUtils.hashMap("top_main_method", "onRenderProcessGone");
        if (k0.g()) {
            mapHashMap.put(TransactionInfo.JsonKeys.SOURCE, renderProcessGoneDetail.didCrash() ? AppMeasurement.CRASH_ORIGIN : "non_crash");
            mapHashMap.put("details", "renderer_priority_at_exit=" + renderProcessGoneDetail.rendererPriorityAtExit());
        }
        com.applovin.impl.sdk.j jVar = com.applovin.impl.sdk.j.f7084v0;
        if (jVar != null) {
            com.applovin.impl.sdk.j.f7084v0.A().a(y1.f7816x0, mapHashMap, ((Long) jVar.a(l4.f5618d3)).longValue());
        }
        com.applovin.impl.sdk.n.g("RenderProcessGoneHandlingWebViewClient", "onRenderProcessGone() handled");
        return true;
    }
}
