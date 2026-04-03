package com.applovin.impl.adview;

import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.MotionEvent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.a2;
import com.applovin.impl.a7;
import com.applovin.impl.d7;
import com.applovin.impl.h4;
import com.applovin.impl.k0;
import com.applovin.impl.l4;
import com.applovin.impl.m7;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.y1;
import com.applovin.impl.z6;
import com.applovin.sdk.AppLovinAdSize;
import com.google.android.gms.measurement.AppMeasurement;
import io.sentry.protocol.TransactionInfo;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c extends h4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f4815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f4816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f4817c;

    public c(a aVar, com.applovin.impl.sdk.j jVar) {
        this.f4815a = jVar;
        this.f4816b = jVar.I();
        this.f4817c = aVar;
    }

    private void b() {
        this.f4817c.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:144:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected boolean a(android.webkit.WebView r12, java.lang.String r13) {
        /*
            Method dump skipped, instruction units count: 665
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.c.a(android.webkit.WebView, java.lang.String):boolean");
    }

    protected a c() {
        return this.f4817c;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
        if (com.applovin.impl.sdk.n.a()) {
            this.f4816b.d("AdWebView", "Loaded resource: " + str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (com.applovin.impl.sdk.n.a()) {
            this.f4816b.d("AdWebView", "Loaded URL: " + str);
        }
        this.f4817c.a(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        onReceivedError(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        com.applovin.impl.sdk.ad.b bVarG = this.f4817c.g();
        if (com.applovin.impl.sdk.n.a()) {
            this.f4816b.b("AdWebView", "Received HTTP error: " + webResourceResponse + "for url: " + webResourceRequest.getUrl() + " and ad: " + bVarG);
        }
        if (z6.a(webResourceRequest.getUrl().toString(), this.f4815a)) {
            this.f4815a.A().a("adWebViewReceivedHttpError", webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase());
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        com.applovin.impl.sdk.ad.b bVarG = this.f4817c.g();
        String str = "Received SSL error: " + sslError;
        if (com.applovin.impl.sdk.n.a()) {
            this.f4816b.b("AdWebView", str + " for ad: " + bVarG);
        }
    }

    @Override // com.applovin.impl.h4, android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.render_process_gone"), null);
        com.applovin.impl.sdk.n.h("AdWebView", "Render process gone for ad: " + this.f4817c.g() + ". Process did crash: " + renderProcessGoneDetail.didCrash());
        com.applovin.impl.sdk.ad.b bVarG = this.f4817c.g();
        if (bVarG != null) {
            Map mapB = a2.b(bVarG);
            CollectionUtils.putStringIfValid("top_main_method", "onRenderProcessGone", mapB);
            if (k0.g()) {
                mapB.put(TransactionInfo.JsonKeys.SOURCE, renderProcessGoneDetail.didCrash() ? AppMeasurement.CRASH_ORIGIN : "non_crash");
            }
            this.f4815a.A().d(y1.f7816x0, mapB);
        }
        if (((Boolean) this.f4815a.a(l4.f5668j5)).booleanValue()) {
            if (renderProcessGoneDetail.didCrash() && ((Boolean) this.f4815a.a(l4.f5716p5)).booleanValue()) {
                throw new RuntimeException("Render process crashed. This is likely caused by a crash in an AppLovin ad with ID: " + (bVarG != null ? String.valueOf(bVarG.getAdIdNumber()) : "null"));
            }
            if (webView != null && webView.equals(this.f4817c.f())) {
                this.f4817c.b();
                AppLovinAdSize appLovinAdSizeK = this.f4817c.k();
                if (z6.a(appLovinAdSizeK)) {
                    this.f4817c.a(appLovinAdSizeK);
                    this.f4817c.C();
                }
            }
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Uri url = webResourceRequest.getUrl();
        if (url != null) {
            return a(webView, url.toString());
        }
        if (!com.applovin.impl.sdk.n.a()) {
            return false;
        }
        this.f4816b.b("AdWebView", "No url found for request");
        return false;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i10, String str, String str2) {
        super.onReceivedError(webView, i10, str, str2);
        com.applovin.impl.sdk.ad.b bVarG = this.f4817c.g();
        String str3 = "Received error with error code: " + i10 + " with description \\'" + str + "\\' for URL: " + str2;
        if (com.applovin.impl.sdk.n.a()) {
            this.f4816b.b("AdWebView", str3 + " for ad: " + bVarG);
        }
        if (z6.a(str2, this.f4815a)) {
            this.f4815a.A().a("adWebViewReceivedError", str2, i10, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return a(webView, str);
    }

    private boolean a(boolean z10, com.applovin.impl.sdk.ad.b bVar, Uri uri) {
        if (z10) {
            return false;
        }
        boolean zZ0 = bVar.Z0();
        this.f4815a.A().d(y1.f7784h0, a(bVar, uri, zZ0));
        return zZ0;
    }

    private static Map a(com.applovin.impl.sdk.ad.b bVar, Uri uri, boolean z10) {
        Map mapB = a2.b(bVar);
        CollectionUtils.putStringIfValid("url", uri.toString(), mapB);
        CollectionUtils.putStringIfValid("is_blocked_auto_redirect", String.valueOf(z10), mapB);
        return mapB;
    }

    private void a() {
        this.f4817c.w();
    }

    private void a(MotionEvent motionEvent) {
        this.f4817c.a(motionEvent);
    }

    private void a(a7 a7Var, b bVar) {
        a(a7Var, bVar, (Bundle) null);
    }

    private void a(a7 a7Var, b bVar, Bundle bundle) {
        d7 d7VarF1 = a7Var.f1();
        if (d7VarF1 != null) {
            m7.a(d7VarF1.b(), this.f4817c.j());
            a(bVar, d7VarF1.c(), bundle);
        }
    }

    private void a(b bVar, Uri uri) {
        a(bVar, uri, (Bundle) null);
    }

    private void a(b bVar, Uri uri, Bundle bundle) {
        com.applovin.impl.sdk.ad.b currentAd = bVar.getCurrentAd();
        AppLovinAdView appLovinAdViewI = this.f4817c.i();
        if (appLovinAdViewI != null && currentAd != null) {
            if (currentAd instanceof a7) {
                ((a7) currentAd).getAdEventTracker().v();
            }
            this.f4817c.a(currentAd, appLovinAdViewI, uri, bVar.getAndClearLastClickEvent(), bundle);
        } else if (com.applovin.impl.sdk.n.a()) {
            this.f4816b.b("AdWebView", "Attempting to track click that is null or not an ApplovinAdView instance for clickedUri = " + uri);
        }
    }

    private void a(Uri uri) {
        String str;
        boolean booleanQueryParameter = uri.getBooleanQueryParameter("success", false);
        String queryParameter = uri.getQueryParameter("type");
        if (booleanQueryParameter) {
            str = "Tracked event: " + queryParameter;
        } else {
            str = "Failed to track event: " + queryParameter;
        }
        z6.a(str, com.applovin.impl.sdk.j.n());
    }
}
