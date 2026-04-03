package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.webkit.WebViewAssetLoader;
import androidx.webkit.WebViewClientCompat;
import com.moloco.sdk.internal.MolocoLogger;
import com.unity3d.services.UnityAdsConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;
import s9.o0;
import s9.y;

/* JADX INFO: loaded from: classes4.dex */
public final class w extends WebViewClientCompat {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public static final a f19654g = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final o f19655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final WebViewAssetLoader f19656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final y<Boolean> f19657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final m0<Boolean> f19658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final y<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> f19659e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final m0<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> f19660f;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final Uri a(WebResourceRequest webResourceRequest) {
            String string;
            Uri url = webResourceRequest.getUrl();
            if (url == null || (string = url.toString()) == null) {
                string = "";
            }
            Uri uri = Uri.parse(p9.q.E(string, com.vungle.ads.internal.l.AD_MRAID_JS_FILE_NAME, "com.moloco.sdk.xenoss.sdkdevkit.mraid.js", true));
            kotlin.jvm.internal.t.h(uri, "parse(\n            (requ…e\n            )\n        )");
            return uri;
        }

        public a() {
        }
    }

    public w(@NotNull Context context, @NotNull o mraidJsCommandsSource) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(mraidJsCommandsSource, "mraidJsCommandsSource");
        this.f19655a = mraidJsCommandsSource;
        WebViewAssetLoader webViewAssetLoaderBuild = new WebViewAssetLoader.Builder().addPathHandler(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH, new WebViewAssetLoader.AssetsPathHandler(context.getApplicationContext())).build();
        kotlin.jvm.internal.t.h(webViewAssetLoaderBuild, "Builder()\n        .addPa…ontext))\n        .build()");
        this.f19656b = webViewAssetLoaderBuild;
        y<Boolean> yVarA = o0.a(Boolean.FALSE);
        this.f19657c = yVarA;
        this.f19658d = yVarA;
        y<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> yVarA2 = o0.a(null);
        this.f19659e = yVarA2;
        this.f19660f = s9.j.c(yVarA2);
    }

    @NotNull
    public final m0<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> c() {
        return this.f19660f;
    }

    @NotNull
    public final m0<Boolean> e() {
        return this.f19658d;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
        super.onPageFinished(webView, str);
        this.f19657c.setValue(Boolean.TRUE);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(@Nullable WebView webView, @Nullable String str, @Nullable Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.f19657c.setValue(Boolean.FALSE);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(@Nullable WebView webView, int i10, @Nullable String str, @Nullable String str2) {
        super.onReceivedError(webView, i10, str, str2);
        this.f19659e.setValue(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d.MRAID_WEBVIEW_CLIENT_UNRECOVERABLE_ERROR);
        MolocoLogger.error$default(MolocoLogger.INSTANCE, "MraidWebViewClient", "onReceivedError " + str, null, false, 12, null);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(@Nullable WebView webView, @Nullable RenderProcessGoneDetail renderProcessGoneDetail) {
        this.f19659e.setValue(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d.MRAID_WEBVIEW_CLIENT_RENDER_PROCESS_GONE_ERROR);
        MolocoLogger.error$default(MolocoLogger.INSTANCE, "MraidWebViewClient", "onRenderProcessGone", null, false, 12, null);
        return true;
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    public WebResourceResponse shouldInterceptRequest(@Nullable WebView webView, @NotNull WebResourceRequest request) {
        kotlin.jvm.internal.t.i(request, "request");
        return this.f19656b.shouldInterceptRequest(f19654g.a(request));
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(@Nullable WebView webView, @Nullable String str) {
        if (str == null) {
            return false;
        }
        return this.f19655a.a(str);
    }
}
