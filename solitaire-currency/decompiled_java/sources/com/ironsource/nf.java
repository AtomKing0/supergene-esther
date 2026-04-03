package com.ironsource;

import android.annotation.TargetApi;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ironsource.hg;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.Logger;

/* JADX INFO: loaded from: classes4.dex */
public class nf extends WebViewClient {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f14129b = "nf";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final hg.a f14130a;

    public nf(hg.a aVar) {
        this.f14130a = aVar;
    }

    private String a(String str, String str2) {
        return "ISNAdViewWebClient | External Adunit failed to load." + str + " Status code: " + str2;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i10, String str, String str2) {
        try {
            this.f14130a.a(a("onReceivedError", String.valueOf(i10)));
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
        super.onReceivedError(webView, i10, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        try {
            this.f14130a.a(a("onReceivedHttpError", String.valueOf(webResourceResponse.getStatusCode())));
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(26)
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        try {
            Logger.e(f14129b, "Chromium process crashed - detail.didCrash():" + renderProcessGoneDetail.didCrash());
            this.f14130a.b(renderProcessGoneDetail.didCrash() ? "Render process was observed to crash" : "Render process was killed by the system");
            return true;
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            return true;
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        try {
            this.f14130a.a(a("onReceivedErrorM", String.valueOf(webResourceError.getErrorCode())));
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
        super.onReceivedError(webView, webResourceRequest, webResourceError);
    }
}
