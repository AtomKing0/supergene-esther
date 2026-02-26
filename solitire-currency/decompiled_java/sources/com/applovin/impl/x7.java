package com.applovin.impl;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class x7 extends h4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f7748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f7749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WebView f7750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set f7752e = Collections.synchronizedSet(new HashSet());

    class a extends WebViewClient {
        a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            com.applovin.impl.sdk.n unused = x7.this.f7749b;
            if (com.applovin.impl.sdk.n.a()) {
                x7.this.f7749b.a("WebTrackerManager", "Successfully initialized web view for postbacks");
            }
            x7.this.f7751d = true;
        }
    }

    public x7(com.applovin.impl.sdk.j jVar) {
        this.f7748a = jVar;
        this.f7749b = jVar.I();
    }

    @Override // com.applovin.impl.h4, android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (webView == this.f7750c) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.pe
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6583a.a();
                }
            });
        } else {
            b(webView);
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        WebView webViewA = a("<script>window.al_firePostback = function(url) {\n    setTimeout(function() {\n        var img = new Image();\n        img.src = url;\n    }, 100);\n}\n</script>", true);
        this.f7750c = webViewA;
        if (webViewA == null && com.applovin.impl.sdk.n.a()) {
            this.f7749b.b("WebTrackerManager", "Failed to preload postback web view");
        }
    }

    private boolean d() {
        return ((Boolean) this.f7748a.a(l4.D2)).booleanValue();
    }

    public void c() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.re
            @Override // java.lang.Runnable
            public final void run() {
                this.f6783a.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str) {
        final WebView webViewA = a(str);
        if (webViewA == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7749b.b("WebTrackerManager", "Failed to fire tracker since web view could not be created");
            }
        } else {
            this.f7752e.add(webViewA);
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.oe
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6489a.b(webViewA);
                }
            }, ((Integer) this.f7748a.a(l4.f5781y2)).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(com.applovin.impl.sdk.network.e eVar, AppLovinPostbackListener appLovinPostbackListener) {
        String strAppendQueryParameters = StringUtils.appendQueryParameters(eVar.f(), eVar.i(), ((Boolean) this.f7748a.a(l4.V2)).booleanValue());
        if (this.f7750c == null) {
            WebView webViewA = a("<script>window.al_firePostback = function(url) {\n    setTimeout(function() {\n        var img = new Image();\n        img.src = url;\n    }, 100);\n}\n</script>", true);
            this.f7750c = webViewA;
            if (webViewA == null) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f7749b.b("WebTrackerManager", "Failed to fire postback since web view could not be created");
                }
                appLovinPostbackListener.onPostbackFailure(strAppendQueryParameters, -1);
                return;
            }
        }
        if (d() && !this.f7751d) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7749b.b("WebTrackerManager", "Failed to fire postback since web view was not initialized in time");
            }
            HashMap<String, String> mapHashMap = CollectionUtils.hashMap("top_main_method", "firePostback");
            mapHashMap.put("url", strAppendQueryParameters);
            this.f7748a.A().d(y1.f7816x0, mapHashMap);
            appLovinPostbackListener.onPostbackFailure(strAppendQueryParameters, -1);
            return;
        }
        a8.a(this.f7750c, "al_firePostback('" + strAppendQueryParameters + "')");
        appLovinPostbackListener.onPostbackSuccess(strAppendQueryParameters);
    }

    public void a(final com.applovin.impl.sdk.network.e eVar, final AppLovinPostbackListener appLovinPostbackListener) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.ne
            @Override // java.lang.Runnable
            public final void run() {
                this.f6435a.b(eVar, appLovinPostbackListener);
            }
        });
    }

    private WebView a(String str) {
        return a(str, false);
    }

    private WebView a(String str, boolean z10) {
        z6.b();
        WebView webViewB = z6.b(com.applovin.impl.sdk.j.n(), "web tracker");
        if (webViewB == null) {
            return null;
        }
        webViewB.getSettings().setJavaScriptEnabled(true);
        webViewB.setWebViewClient(this);
        if (z10 && d()) {
            webViewB.setWebViewClient(new a());
        }
        webViewB.loadData("<html><head><link rel=\"icon\" href=\"data:,\">" + str + "</head><body></body></html>", "text/html", "UTF-8");
        return webViewB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(final WebView webView) {
        if (webView == null || !this.f7752e.remove(webView)) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.qe
            @Override // java.lang.Runnable
            public final void run() {
                webView.destroy();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        this.f7750c.destroy();
        this.f7750c = null;
    }

    public void b(final String str) {
        if (!AppLovinSdkUtils.isValidString(str)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7749b.b("WebTrackerManager", "Failed to fire tracker due to empty script string");
            }
        } else {
            if (!str.startsWith("<script")) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f7749b.b("WebTrackerManager", "Failed to fire tracker due to improperly formatted script tag");
                    return;
                }
                return;
            }
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.me
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5906a.c(str);
                }
            });
        }
    }
}
