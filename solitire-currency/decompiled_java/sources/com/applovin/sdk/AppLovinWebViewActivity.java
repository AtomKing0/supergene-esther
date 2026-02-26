package com.applovin.sdk;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.applovin.impl.h4;
import com.applovin.impl.l4;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.z6;
import com.google.ads.mediation.applovin.AppLovinMediationAdapter;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class AppLovinWebViewActivity extends Activity {
    public static final String EVENT_DISMISSED_VIA_BACK_BUTTON = "dismissed_via_back_button";
    public static final String INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON = "immersive_mode_on";
    public static final String INTENT_EXTRA_KEY_LOAD_URL = "load_url";
    public static final String INTENT_EXTRA_KEY_SDK_KEY = "sdk_key";
    public static final String URI_PATH_WEBVIEW_EVENT = "webview_event";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f8054a = new AtomicBoolean();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WebView f8056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private EventListener f8057d;

    public interface EventListener {
        void onReceivedEvent(String str);
    }

    class a extends h4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f8058a;

        a(j jVar) {
            this.f8058a = jVar;
        }

        @Override // com.applovin.impl.h4, android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (AppLovinWebViewActivity.this.f8056c == webView) {
                AppLovinWebViewActivity.this.f8056c.destroy();
                AppLovinWebViewActivity.this.f8056c = null;
                AppLovinWebViewActivity appLovinWebViewActivity = AppLovinWebViewActivity.this;
                final j jVar = this.f8058a;
                appLovinWebViewActivity.runOnUiThread(new Runnable() { // from class: com.applovin.sdk.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f8060a.a(jVar);
                    }
                });
            }
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            String host = uri.getHost();
            String path = uri.getPath();
            this.f8058a.I();
            if (n.a()) {
                this.f8058a.I().a("AppLovinWebViewActivity", "Handling url load: " + str);
            }
            if (!"applovin".equalsIgnoreCase(scheme) || !AppLovinMediationAdapter.APPLOVIN_SDK_ERROR_DOMAIN.equalsIgnoreCase(host) || AppLovinWebViewActivity.this.f8057d == null) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            if (!path.endsWith(AppLovinWebViewActivity.URI_PATH_WEBVIEW_EVENT)) {
                return true;
            }
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            String str2 = queryParameterNames.isEmpty() ? "" : (String) queryParameterNames.toArray()[0];
            if (!StringUtils.isValidString(str2)) {
                this.f8058a.I();
                if (!n.a()) {
                    return true;
                }
                this.f8058a.I().b("AppLovinWebViewActivity", "Failed to parse WebView event parameter");
                return true;
            }
            String queryParameter = uri.getQueryParameter(str2);
            this.f8058a.I();
            if (n.a()) {
                this.f8058a.I().a("AppLovinWebViewActivity", "Parsed WebView event parameter name: " + str2 + " and value: " + queryParameter);
            }
            AppLovinWebViewActivity.this.f8057d.onReceivedEvent(queryParameter);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(j jVar) {
            if (!((Boolean) jVar.a(l4.f5676k5)).booleanValue() || !AppLovinWebViewActivity.this.f8054a.compareAndSet(false, true)) {
                AppLovinWebViewActivity.this.finish();
                return;
            }
            AppLovinWebViewActivity.this.a(jVar);
            if (StringUtils.isValidString(AppLovinWebViewActivity.this.f8055b)) {
                AppLovinWebViewActivity.this.f8056c.loadUrl(AppLovinWebViewActivity.this.f8055b);
            }
        }
    }

    public void loadUrl(String str, EventListener eventListener) {
        this.f8057d = eventListener;
        this.f8055b = str;
        this.f8054a.set(false);
        WebView webView = this.f8056c;
        if (webView != null) {
            webView.loadUrl(str);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        EventListener eventListener = this.f8057d;
        if (eventListener != null) {
            eventListener.onReceivedEvent(EVENT_DISMISSED_VIA_BACK_BUTTON);
        }
        super.onBackPressed();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (TextUtils.isEmpty(getIntent().getStringExtra(INTENT_EXTRA_KEY_SDK_KEY))) {
            n.h("AppLovinWebViewActivity", "No SDK key specified");
            finish();
            return;
        }
        a(AppLovinSdk.getInstance(getApplicationContext()).a());
        if (getIntent().getBooleanExtra(INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON, false)) {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        }
        String stringExtra = getIntent().getStringExtra(INTENT_EXTRA_KEY_LOAD_URL);
        if (StringUtils.isValidString(stringExtra)) {
            this.f8055b = stringExtra;
        }
        if (StringUtils.isValidString(this.f8055b)) {
            this.f8056c.loadUrl(this.f8055b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar) {
        WebView webViewB = z6.b(this, "WebView Activity");
        this.f8056c = webViewB;
        if (webViewB == null) {
            finish();
            return;
        }
        setContentView(webViewB);
        WebSettings settings = this.f8056c.getSettings();
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptEnabled(true);
        this.f8056c.setVerticalScrollBarEnabled(true);
        this.f8056c.setHorizontalScrollBarEnabled(true);
        this.f8056c.setScrollBarStyle(33554432);
        this.f8056c.setWebViewClient(new a(jVar));
    }
}
