package com.iab.omid.library.ironsrc.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.ironsrc.adsession.ErrorType;
import com.ironsource.v8;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static g f10825a = new g();

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebView f10826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f10827b;

        a(g gVar, WebView webView, String str) {
            this.f10826a = webView;
            this.f10827b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10826a.loadUrl(this.f10827b);
        }
    }

    private g() {
    }

    public static final g a() {
        return f10825a;
    }

    public void b(WebView webView) {
        a(webView, "publishImpressionEvent", new Object[0]);
    }

    public void c(WebView webView) {
        a(webView, "publishLoadedEvent", new Object[0]);
    }

    public void a(WebView webView) {
        a(webView, "finishSession", new Object[0]);
    }

    public void b(WebView webView, String str) {
        a(webView, "setState", str);
    }

    public void c(WebView webView, @NonNull JSONObject jSONObject) {
        a(webView, "setLastActivity", jSONObject);
    }

    public void a(WebView webView, float f10) {
        a(webView, "setDeviceVolume", Float.valueOf(f10));
    }

    public void b(WebView webView, @NonNull JSONObject jSONObject) {
        a(webView, "publishLoadedEvent", jSONObject);
    }

    public boolean c(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return false;
        }
        webView.loadUrl("javascript: " + str);
        return true;
    }

    public void a(WebView webView, ErrorType errorType, String str) {
        a(webView, "error", errorType.toString(), str);
    }

    public void a(WebView webView, String str) {
        a(webView, "setNativeViewHierarchy", str);
    }

    public void a(WebView webView, String str, String str2) {
        if (str == null || TextUtils.isEmpty(str2)) {
            return;
        }
        c(webView, "(function() {this.omidVerificationProperties = this.omidVerificationProperties || {};Object.defineProperty(this.omidVerificationProperties, 'injectionId', {get: function() {var currentScript = document && document.currentScript;return currentScript && currentScript.getAttribute('data-injection-id');}, configurable: true});var script = document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");script.setAttribute(\"data-injection-id\",\"%INJECTION_ID%\");document.body.appendChild(script);})();".replace("%SCRIPT_SRC%", str).replace("%INJECTION_ID%", str2));
    }

    public void a(WebView webView, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            a(webView, "publishMediaEvent", str, jSONObject);
        } else {
            a(webView, "publishMediaEvent", str);
        }
    }

    public void a(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        a(webView, "startSession", str, jSONObject, jSONObject2, jSONObject3);
    }

    @VisibleForTesting
    void a(WebView webView, String str, Object... objArr) {
        if (webView == null) {
            com.iab.omid.library.ironsrc.utils.d.a("The WebView is null for " + str);
            return;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("javascript: if(window.omidBridge!==undefined){omidBridge.");
        sb.append(str);
        sb.append("(");
        a(sb, objArr);
        sb.append(")}");
        a(webView, sb);
    }

    @VisibleForTesting
    void a(WebView webView, StringBuilder sb) {
        String string = sb.toString();
        Handler handler = webView.getHandler();
        if (handler == null || Looper.myLooper() == handler.getLooper()) {
            webView.loadUrl(string);
        } else {
            handler.post(new a(this, webView, string));
        }
    }

    public void a(WebView webView, JSONObject jSONObject) {
        a(webView, v8.a.f15678e, jSONObject);
    }

    @VisibleForTesting
    void a(StringBuilder sb, Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return;
        }
        for (Object obj : objArr) {
            if (obj == null) {
                sb.append('\"');
            } else {
                if (obj instanceof String) {
                    String string = obj.toString();
                    if (string.startsWith("{")) {
                        sb.append(string);
                    } else {
                        sb.append('\"');
                        sb.append(string);
                    }
                } else {
                    sb.append(obj);
                }
                sb.append(",");
            }
            sb.append('\"');
            sb.append(",");
        }
        sb.setLength(sb.length() - 1);
    }
}
