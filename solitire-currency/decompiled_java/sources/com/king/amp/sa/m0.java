package com.king.amp.sa;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: AbmWebViewClient.java */
/* JADX INFO: loaded from: classes4.dex */
public class m0 extends WebViewClient {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set<String> f16816c = new HashSet(Arrays.asList("utm_source", "utm_medium", "utm_campaign", "utm_term", "utm_content", "fbclid", "gclid", "msclkid"));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<String> f16817d = new HashSet(Arrays.asList("e", "ac", "bq", "dz", "f", "gh", CmcdData.Factory.OBJECT_TYPE_INIT_SEGMENT, "t", "de", "d", "bo", "bd", "cs"));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Set<String> f16818e = new HashSet(Arrays.asList("doubleclick.net", "googleadservices.com", "moatads.com", "adnxs.com"));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Set<String> f16819f = new HashSet(Arrays.asList("analytics", "tracker", "pixel", "tracking", "beacon", "adsrvr", "adroll"));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Set<String> f16820g = new HashSet(Arrays.asList("pixel.gif", "beacon.gif", "tracking.js", "analytics.js", "collect"));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f16821a = "AbmWebViewClient";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private h1 f16822b;

    public m0(@NonNull h1 h1Var) {
        this.f16822b = h1Var;
    }

    private boolean a(WebResourceRequest webResourceRequest) {
        Uri url = webResourceRequest.getUrl();
        String string = url.toString();
        String host = url.getHost();
        String path = url.getPath();
        Set<String> queryParameterNames = url.getQueryParameterNames();
        Iterator<String> it = f16816c.iterator();
        while (it.hasNext()) {
            if (queryParameterNames.contains(it.next())) {
                return true;
            }
        }
        if (host != null) {
            Iterator<String> it2 = f16818e.iterator();
            while (it2.hasNext()) {
                if (host.contains(it2.next())) {
                    return true;
                }
            }
        }
        if (path != null) {
            Iterator<String> it3 = f16820g.iterator();
            while (it3.hasNext()) {
                if (path.endsWith(it3.next())) {
                    return true;
                }
            }
            Iterator<String> it4 = f16819f.iterator();
            while (it4.hasNext()) {
                if (path.endsWith(it4.next())) {
                    return true;
                }
            }
        }
        Iterator<String> it5 = f16817d.iterator();
        int i10 = 0;
        while (it5.hasNext()) {
            if (queryParameterNames.contains(it5.next())) {
                i10++;
            }
        }
        if (host != null) {
            Iterator<String> it6 = f16819f.iterator();
            while (true) {
                if (!it6.hasNext()) {
                    break;
                }
                if (host.contains(it6.next())) {
                    i10 += 2;
                    break;
                }
            }
        }
        if (path != null) {
            Iterator<String> it7 = f16820g.iterator();
            while (true) {
                if (!it7.hasNext()) {
                    break;
                }
                if (path.endsWith(it7.next())) {
                    i10 += 2;
                    break;
                }
            }
            Iterator<String> it8 = f16819f.iterator();
            while (true) {
                if (!it8.hasNext()) {
                    break;
                }
                if (path.endsWith(it8.next())) {
                    i10 += 3;
                    break;
                }
            }
        }
        if (string.length() > 200 && queryParameterNames.size() > 5) {
            i10++;
        }
        return i10 >= 4;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Log.d("AbmWebViewClient", "onPageFinished, URL = " + str);
        h1 h1Var = this.f16822b;
        if (h1Var != null) {
            h1Var.n(str);
        }
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Log.d("AbmWebViewClient", "onPageStarted, URL = " + str);
        h1 h1Var = this.f16822b;
        if (h1Var != null) {
            h1Var.l(str, bitmap);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i10, String str, String str2) {
        h1 h1Var = this.f16822b;
        if (h1Var != null) {
            h1Var.h(i10, str, str2);
        }
        super.onReceivedError(webView, i10, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        Log.e("AbmWebViewClient", "onReceivedHttpError, status code = " + webResourceResponse.getStatusCode() + ", " + webResourceResponse.getReasonPhrase() + ", request = " + webResourceRequest.getUrl());
        if (!a(webResourceRequest)) {
            h1 h1Var = this.f16822b;
            if (h1Var != null) {
                h1Var.j(webResourceRequest, webResourceResponse);
            }
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            return;
        }
        Log.i("AbmWebViewClient", "Tracking url Http error ignored: " + webResourceRequest.getUrl().toString());
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Log.e("AbmWebViewClient", "onReceivedSslError, URL = " + sslError.getUrl() + ", Error = " + sslError.getPrimaryError());
        h1 h1Var = this.f16822b;
        if (h1Var != null) {
            h1Var.i(sslErrorHandler, sslError);
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        Log.e("AbmWebViewClient", "WebView process crashed!");
        if (Build.VERSION.SDK_INT >= 26) {
            Log.e("AbmWebViewClient", "Did crash? " + renderProcessGoneDetail.didCrash() + ", priority = " + renderProcessGoneDetail.rendererPriorityAtExit());
        } else {
            Log.e("AbmWebViewClient", "Detail = " + renderProcessGoneDetail);
        }
        h1 h1Var = this.f16822b;
        if (h1Var != null) {
            h1Var.e(renderProcessGoneDetail);
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        h1 h1Var = this.f16822b;
        WebResourceResponse webResourceResponseG = h1Var == null ? null : h1Var.g(Uri.parse(str));
        return webResourceResponseG != null ? webResourceResponseG : super.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Uri uri = Uri.parse(webResourceRequest.getUrl().toString().toLowerCase(Locale.US));
        h1 h1Var = this.f16822b;
        boolean zBooleanValue = (h1Var == null ? null : Boolean.valueOf(h1Var.k(uri))).booleanValue();
        if (zBooleanValue) {
            Log.d("AbmWebViewClient", "Should override: " + webResourceRequest.getUrl());
        }
        if (zBooleanValue) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        Uri uri = Uri.parse(webResourceRequest.getUrl().toString().toLowerCase(Locale.US));
        h1 h1Var = this.f16822b;
        WebResourceResponse webResourceResponseG = h1Var == null ? null : h1Var.g(uri);
        return webResourceResponseG != null ? webResourceResponseG : super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        try {
            if (webResourceRequest.getUrl().getPath().endsWith("/favicon.ico")) {
                return;
            }
        } catch (NullPointerException e10) {
            Log.d("AbmWebViewClient", "NullPointerException when pass onReceiverError request : " + e10.toString());
        }
        Log.e("AbmWebViewClient", "onReceivedError, error = " + webResourceError.getErrorCode() + ", " + ((Object) webResourceError.getDescription()) + ", Request = " + webResourceRequest.getUrl());
        h1 h1Var = this.f16822b;
        if (h1Var != null) {
            h1Var.b(webResourceRequest, webResourceError);
        }
        super.onReceivedError(webView, webResourceRequest, webResourceError);
    }
}
