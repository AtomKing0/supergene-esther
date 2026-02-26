package com.braze.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.FragmentActivity;
import com.braze.BrazeInternal;
import com.braze.enums.Channel;
import com.braze.support.BrazeFileUtils;
import com.braze.support.BrazeLogger;
import com.braze.ui.actions.UriAction;
import com.braze.ui.support.ViewUtils;
import h9.a;
import kotlin.collections.d0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BrazeWebViewActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"SetJavaScriptEnabled"})
public class BrazeWebViewActivity extends FragmentActivity {
    @NotNull
    public WebChromeClient createWebChromeClient() {
        return new WebChromeClient() { // from class: com.braze.ui.BrazeWebViewActivity.createWebChromeClient.1
            @Override // android.webkit.WebChromeClient
            @NotNull
            public Bitmap getDefaultVideoPoster() {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
                t.h(bitmapCreateBitmap, "createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
                return bitmapCreateBitmap;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(@NotNull ConsoleMessage cm) {
                t.i(cm, "cm");
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new BrazeWebViewActivity$createWebChromeClient$1$onConsoleMessage$1(cm), 7, (Object) null);
                return true;
            }
        };
    }

    @NotNull
    public WebViewClient createWebViewClient() {
        return new WebViewClient() { // from class: com.braze.ui.BrazeWebViewActivity.createWebViewClient.1
            private final Boolean handleUrlOverride(Context context, String str) {
                try {
                    if (d0.b0(BrazeFileUtils.REMOTE_SCHEMES, Uri.parse(str).getScheme())) {
                        return null;
                    }
                    UriAction uriActionCreateUriActionFromUrlString = BrazeDeeplinkHandler.Companion.getInstance().createUriActionFromUrlString(str, BrazeWebViewActivity.this.getIntent().getExtras(), false, Channel.UNKNOWN);
                    if (uriActionCreateUriActionFromUrlString == null) {
                        return Boolean.FALSE;
                    }
                    uriActionCreateUriActionFromUrlString.execute(context);
                    BrazeWebViewActivity.this.finish();
                    return Boolean.TRUE;
                } catch (Exception e10) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (a) new BrazeWebViewActivity$createWebViewClient$1$handleUrlOverride$1(str), 4, (Object) null);
                    return null;
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(@NotNull WebView view, @NotNull RenderProcessGoneDetail detail) {
                t.i(view, "view");
                t.i(detail, "detail");
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (a) BrazeWebViewActivity$createWebViewClient$1$onRenderProcessGone$1.INSTANCE, 6, (Object) null);
                return true;
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(@NotNull WebView view, @NotNull WebResourceRequest request) {
                t.i(view, "view");
                t.i(request, "request");
                Context context = view.getContext();
                t.h(context, "view.context");
                String string = request.getUrl().toString();
                t.h(string, "request.url.toString()");
                Boolean boolHandleUrlOverride = handleUrlOverride(context, string);
                return boolHandleUrlOverride != null ? boolHandleUrlOverride.booleanValue() : super.shouldOverrideUrlLoading(view, request);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(@NotNull WebView view, @NotNull String url) {
                t.i(view, "view");
                t.i(url, "url");
                Context context = view.getContext();
                t.h(context, "view.context");
                Boolean boolHandleUrlOverride = handleUrlOverride(context, url);
                return boolHandleUrlOverride != null ? boolHandleUrlOverride.booleanValue() : super.shouldOverrideUrlLoading(view, url);
            }
        };
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        String string;
        super.onCreate(bundle);
        getWindow().setFlags(16777216, 16777216);
        if (BrazeInternal.INSTANCE.getConfigurationProvider(this).getShouldUseWindowFlagSecureInActivities()) {
            getWindow().setFlags(8192, 8192);
        }
        setContentView(R$layout.com_braze_webview_activity);
        WebView webView = (WebView) findViewById(R$id.com_braze_webview_activity_webview);
        webView.setLayerType(2, null);
        WebSettings settings = webView.getSettings();
        t.h(settings, "webView.settings");
        settings.setAllowFileAccess(false);
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDisplayZoomControls(false);
        settings.setDomStorageEnabled(true);
        Context applicationContext = getApplicationContext();
        t.h(applicationContext, "this.applicationContext");
        if (ViewUtils.isDeviceInNightMode(applicationContext)) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 33) {
                settings.setAlgorithmicDarkeningAllowed(true);
            } else if (i10 >= 29) {
                settings.setForceDark(2);
            }
        }
        webView.setWebChromeClient(createWebChromeClient());
        webView.setWebViewClient(createWebViewClient());
        Bundle extras = getIntent().getExtras();
        if (extras == null || (string = extras.getString("url")) == null) {
            return;
        }
        webView.loadUrl(string);
    }
}
