package com.vungle.ads.internal.ui;

import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.webkit.ProxyConfig;
import com.ironsource.v8;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import com.vungle.ads.internal.model.j;
import com.vungle.ads.internal.ui.view.d;
import com.vungle.ads.internal.util.p;
import com.vungle.ads.o;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;

/* JADX INFO: compiled from: VungleWebClient.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f extends WebViewClient implements com.vungle.ads.internal.ui.view.d {

    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    private static final String TAG = "VungleWebClient";

    @NotNull
    private final com.vungle.ads.internal.model.b advertisement;
    private boolean collectConsent;

    @Nullable
    private d.b errorHandler;

    @Nullable
    private String gdprAccept;

    @Nullable
    private String gdprBody;

    @Nullable
    private String gdprDeny;

    @Nullable
    private String gdprTitle;

    @Nullable
    private Boolean isViewable;

    @Nullable
    private WebView loadedWebView;

    @Nullable
    private d.a mraidDelegate;

    @NotNull
    private final ExecutorService offloadExecutor;

    @NotNull
    private final j placement;

    @Nullable
    private final com.vungle.ads.internal.platform.d platform;
    private boolean ready;

    @Nullable
    private final com.vungle.ads.internal.signals.b signalManager;

    @Nullable
    private com.vungle.ads.internal.omsdk.f webViewObserver;

    /* JADX INFO: compiled from: VungleWebClient.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: VungleWebClient.kt */
    @RequiresApi(29)
    public static final class b extends WebViewRenderProcessClient {

        @Nullable
        private d.b errorHandler;

        public b(@Nullable d.b bVar) {
            this.errorHandler = bVar;
        }

        @Nullable
        public final d.b getErrorHandler() {
            return this.errorHandler;
        }

        @Override // android.webkit.WebViewRenderProcessClient
        public void onRenderProcessResponsive(@NotNull WebView webView, @Nullable WebViewRenderProcess webViewRenderProcess) {
            t.i(webView, "webView");
        }

        @Override // android.webkit.WebViewRenderProcessClient
        public void onRenderProcessUnresponsive(@NotNull WebView webView, @Nullable WebViewRenderProcess webViewRenderProcess) {
            t.i(webView, "webView");
            p.a aVar = p.Companion;
            StringBuilder sb = new StringBuilder();
            sb.append("onRenderProcessUnresponsive(Title = ");
            sb.append(webView.getTitle());
            sb.append(", URL = ");
            sb.append(webView.getOriginalUrl());
            sb.append(", (webViewRenderProcess != null) = ");
            sb.append(webViewRenderProcess != null);
            aVar.w(f.TAG, sb.toString());
            d.b bVar = this.errorHandler;
            if (bVar != null) {
                bVar.onRenderProcessUnresponsive(webView, webViewRenderProcess);
            }
        }

        public final void setErrorHandler(@Nullable d.b bVar) {
            this.errorHandler = bVar;
        }
    }

    public /* synthetic */ f(com.vungle.ads.internal.model.b bVar, j jVar, ExecutorService executorService, com.vungle.ads.internal.signals.b bVar2, com.vungle.ads.internal.platform.d dVar, int i10, k kVar) {
        this(bVar, jVar, executorService, (i10 & 8) != 0 ? null : bVar2, (i10 & 16) != 0 ? null : dVar);
    }

    private final void handleWebViewError(String str, String str2, boolean z10) {
        String str3 = str2 + ' ' + str;
        d.b bVar = this.errorHandler;
        if (bVar != null) {
            bVar.onReceivedError(str3, z10);
        }
    }

    private final boolean isCriticalAsset(String str) {
        if (str.length() > 0) {
            return this.advertisement.isCriticalAsset(str);
        }
        return false;
    }

    private final void runJavascriptOnWebView(WebView webView, String str) {
        boolean z10 = false;
        if (webView != null) {
            try {
                if (!webView.isAttachedToWindow()) {
                    z10 = true;
                }
            } catch (Throwable th) {
                o.INSTANCE.logError$vungle_ads_release(313, "Evaluate js failed " + th.getLocalizedMessage(), this.placement.getReferenceId(), this.advertisement.getCreativeId(), this.advertisement.eventId());
                return;
            }
        }
        if (z10) {
            return;
        }
        p.Companion.w(TAG, "mraid Injecting JS " + str);
        if (webView != null) {
            webView.evaluateJavascript(str, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: shouldOverrideUrlLoading$lambda-4$lambda-3$lambda-2, reason: not valid java name */
    public static final void m4111shouldOverrideUrlLoading$lambda4$lambda3$lambda2(d.a it, String command, JsonObject args, Handler handler, final f this$0, final WebView webView) {
        t.i(it, "$it");
        t.i(command, "$command");
        t.i(args, "$args");
        t.i(handler, "$handler");
        t.i(this$0, "this$0");
        if (it.processCommand(command, args)) {
            handler.post(new Runnable() { // from class: com.vungle.ads.internal.ui.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.m4112shouldOverrideUrlLoading$lambda4$lambda3$lambda2$lambda1(this.f24392a, webView);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: shouldOverrideUrlLoading$lambda-4$lambda-3$lambda-2$lambda-1, reason: not valid java name */
    public static final void m4112shouldOverrideUrlLoading$lambda4$lambda3$lambda2$lambda1(f this$0, WebView webView) {
        t.i(this$0, "this$0");
        this$0.runJavascriptOnWebView(webView, "window.vungle.mraidBridge.notifyCommandComplete()");
    }

    public final boolean getCollectConsent$vungle_ads_release() {
        return this.collectConsent;
    }

    @Nullable
    public final d.b getErrorHandler$vungle_ads_release() {
        return this.errorHandler;
    }

    @Nullable
    public final String getGdprAccept$vungle_ads_release() {
        return this.gdprAccept;
    }

    @Nullable
    public final String getGdprBody$vungle_ads_release() {
        return this.gdprBody;
    }

    @Nullable
    public final String getGdprDeny$vungle_ads_release() {
        return this.gdprDeny;
    }

    @Nullable
    public final String getGdprTitle$vungle_ads_release() {
        return this.gdprTitle;
    }

    @Nullable
    public final WebView getLoadedWebView$vungle_ads_release() {
        return this.loadedWebView;
    }

    @Nullable
    public final d.a getMraidDelegate$vungle_ads_release() {
        return this.mraidDelegate;
    }

    public final boolean getReady$vungle_ads_release() {
        return this.ready;
    }

    @Nullable
    public final com.vungle.ads.internal.omsdk.f getWebViewObserver$vungle_ads_release() {
        return this.webViewObserver;
    }

    @Nullable
    public final Boolean isViewable$vungle_ads_release() {
        return this.isViewable;
    }

    public final void notifyDiskAvailableSize(long j10) {
        WebView webView = this.loadedWebView;
        if (webView != null) {
            runJavascriptOnWebView(webView, "window.vungle.mraidBridgeExt.notifyAvailableDiskSpace(" + j10 + ')');
        }
    }

    @Override // com.vungle.ads.internal.ui.view.d
    public void notifyPropertiesChange(boolean z10) {
        WebView webView = this.loadedWebView;
        if (webView != null) {
            r rVar = new r();
            r rVar2 = new r();
            kotlinx.serialization.json.g.b(rVar2, "width", Integer.valueOf(webView.getWidth()));
            kotlinx.serialization.json.g.b(rVar2, "height", Integer.valueOf(webView.getHeight()));
            JsonObject jsonObjectA = rVar2.a();
            r rVar3 = new r();
            kotlinx.serialization.json.g.b(rVar3, ViewHierarchyNode.JsonKeys.X, 0);
            kotlinx.serialization.json.g.b(rVar3, ViewHierarchyNode.JsonKeys.Y, 0);
            kotlinx.serialization.json.g.b(rVar3, "width", Integer.valueOf(webView.getWidth()));
            kotlinx.serialization.json.g.b(rVar3, "height", Integer.valueOf(webView.getHeight()));
            JsonObject jsonObjectA2 = rVar3.a();
            r rVar4 = new r();
            Boolean bool = Boolean.FALSE;
            kotlinx.serialization.json.g.a(rVar4, "sms", bool);
            kotlinx.serialization.json.g.a(rVar4, "tel", bool);
            kotlinx.serialization.json.g.a(rVar4, "calendar", bool);
            kotlinx.serialization.json.g.a(rVar4, "storePicture", bool);
            kotlinx.serialization.json.g.a(rVar4, "inlineVideo", bool);
            JsonObject jsonObjectA3 = rVar4.a();
            rVar.b("maxSize", jsonObjectA);
            rVar.b("screenSize", jsonObjectA);
            rVar.b("defaultPosition", jsonObjectA2);
            rVar.b("currentPosition", jsonObjectA2);
            rVar.b("supports", jsonObjectA3);
            kotlinx.serialization.json.g.c(rVar, "placementType", this.advertisement.templateType());
            Boolean bool2 = this.isViewable;
            if (bool2 != null) {
                kotlinx.serialization.json.g.a(rVar, v8.h.f15807o, Boolean.valueOf(bool2.booleanValue()));
            }
            kotlinx.serialization.json.g.c(rVar, "os", "android");
            kotlinx.serialization.json.g.c(rVar, "osVersion", String.valueOf(Build.VERSION.SDK_INT));
            kotlinx.serialization.json.g.a(rVar, "incentivized", Boolean.valueOf(this.placement.isRewardedVideo()));
            kotlinx.serialization.json.g.c(rVar, "version", "1.0");
            com.vungle.ads.internal.platform.d dVar = this.platform;
            if (dVar != null) {
                kotlinx.serialization.json.g.a(rVar, "isSilent", Boolean.valueOf(dVar.isSilentModeEnabled()));
            }
            if (this.collectConsent) {
                kotlinx.serialization.json.g.a(rVar, "consentRequired", Boolean.TRUE);
                kotlinx.serialization.json.g.c(rVar, "consentTitleText", this.gdprTitle);
                kotlinx.serialization.json.g.c(rVar, "consentBodyText", this.gdprBody);
                kotlinx.serialization.json.g.c(rVar, "consentAcceptButtonText", this.gdprAccept);
                kotlinx.serialization.json.g.c(rVar, "consentDenyButtonText", this.gdprDeny);
            } else {
                kotlinx.serialization.json.g.a(rVar, "consentRequired", bool);
            }
            if (!com.vungle.ads.internal.k.INSTANCE.signalsDisabled()) {
                com.vungle.ads.internal.signals.b bVar = this.signalManager;
                String uuid = bVar != null ? bVar.getUuid() : null;
                if (!(uuid == null || uuid.length() == 0)) {
                    com.vungle.ads.internal.signals.b bVar2 = this.signalManager;
                    kotlinx.serialization.json.g.c(rVar, JsonStorageKeyNames.SESSION_ID_KEY, bVar2 != null ? bVar2.getUuid() : null);
                }
            }
            kotlinx.serialization.json.g.c(rVar, "sdkVersion", "7.4.2");
            runJavascriptOnWebView(webView, "window.vungle.mraidBridge.notifyPropertiesChange(" + rVar.a() + ',' + z10 + ')');
        }
    }

    public final void notifySilentModeChange(boolean z10) {
        WebView webView = this.loadedWebView;
        if (webView != null) {
            r rVar = new r();
            kotlinx.serialization.json.g.a(rVar, "isSilent", Boolean.valueOf(z10));
            runJavascriptOnWebView(webView, "window.vungle.mraidBridge.notifyPropertiesChange(" + rVar.a() + ')');
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
        super.onPageFinished(webView, str);
        if (webView == null) {
            return;
        }
        this.loadedWebView = webView;
        webView.setVisibility(0);
        notifyPropertiesChange(true);
        if (Build.VERSION.SDK_INT >= 29) {
            webView.setWebViewRenderProcessClient(new b(this.errorHandler));
        }
        com.vungle.ads.internal.omsdk.f fVar = this.webViewObserver;
        if (fVar != null) {
            fVar.onPageFinished(webView);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(@Nullable WebView webView, int i10, @NotNull String description, @NotNull String failingUrl) {
        t.i(description, "description");
        t.i(failingUrl, "failingUrl");
        super.onReceivedError(webView, i10, description, failingUrl);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(@Nullable WebView webView, @Nullable WebResourceRequest webResourceRequest, @Nullable WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        String strValueOf = String.valueOf(webResourceResponse != null ? Integer.valueOf(webResourceResponse.getStatusCode()) : null);
        String strValueOf2 = String.valueOf(webResourceRequest != null ? webResourceRequest.getUrl() : null);
        boolean z10 = webResourceRequest != null && webResourceRequest.isForMainFrame();
        p.Companion.e(TAG, "Http Error desc " + strValueOf + ' ' + z10 + " for URL " + strValueOf2);
        handleWebViewError(strValueOf, strValueOf2, isCriticalAsset(strValueOf2) && z10);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(@Nullable WebView webView, @Nullable RenderProcessGoneDetail renderProcessGoneDetail) {
        this.loadedWebView = null;
        if (Build.VERSION.SDK_INT < 26) {
            p.a aVar = p.Companion;
            StringBuilder sb = new StringBuilder();
            sb.append("onRenderProcessGone url: ");
            sb.append(webView != null ? webView.getUrl() : null);
            aVar.w(TAG, sb.toString());
            return true;
        }
        p.a aVar2 = p.Companion;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onRenderProcessGone url: ");
        sb2.append(webView != null ? webView.getUrl() : null);
        sb2.append(", did crash: ");
        sb2.append(renderProcessGoneDetail != null ? Boolean.valueOf(renderProcessGoneDetail.didCrash()) : null);
        aVar2.w(TAG, sb2.toString());
        d.b bVar = this.errorHandler;
        if (bVar != null) {
            return bVar.onWebRenderingProcessGone(webView, renderProcessGoneDetail != null ? Boolean.valueOf(renderProcessGoneDetail.didCrash()) : null);
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    @Override // com.vungle.ads.internal.ui.view.d
    public void setAdVisibility(boolean z10) {
        this.isViewable = Boolean.valueOf(z10);
        notifyPropertiesChange(false);
    }

    public final void setCollectConsent$vungle_ads_release(boolean z10) {
        this.collectConsent = z10;
    }

    @Override // com.vungle.ads.internal.ui.view.d
    public void setConsentStatus(boolean z10, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.collectConsent = z10;
        this.gdprTitle = str;
        this.gdprBody = str2;
        this.gdprAccept = str3;
        this.gdprDeny = str4;
    }

    @Override // com.vungle.ads.internal.ui.view.d
    public void setErrorHandler(@NotNull d.b errorHandler) {
        t.i(errorHandler, "errorHandler");
        this.errorHandler = errorHandler;
    }

    public final void setErrorHandler$vungle_ads_release(@Nullable d.b bVar) {
        this.errorHandler = bVar;
    }

    public final void setGdprAccept$vungle_ads_release(@Nullable String str) {
        this.gdprAccept = str;
    }

    public final void setGdprBody$vungle_ads_release(@Nullable String str) {
        this.gdprBody = str;
    }

    public final void setGdprDeny$vungle_ads_release(@Nullable String str) {
        this.gdprDeny = str;
    }

    public final void setGdprTitle$vungle_ads_release(@Nullable String str) {
        this.gdprTitle = str;
    }

    public final void setLoadedWebView$vungle_ads_release(@Nullable WebView webView) {
        this.loadedWebView = webView;
    }

    @Override // com.vungle.ads.internal.ui.view.d
    public void setMraidDelegate(@Nullable d.a aVar) {
        this.mraidDelegate = aVar;
    }

    public final void setMraidDelegate$vungle_ads_release(@Nullable d.a aVar) {
        this.mraidDelegate = aVar;
    }

    public final void setReady$vungle_ads_release(boolean z10) {
        this.ready = z10;
    }

    public final void setViewable$vungle_ads_release(@Nullable Boolean bool) {
        this.isViewable = bool;
    }

    @Override // com.vungle.ads.internal.ui.view.d
    public void setWebViewObserver(@Nullable com.vungle.ads.internal.omsdk.f fVar) {
        this.webViewObserver = fVar;
    }

    public final void setWebViewObserver$vungle_ads_release(@Nullable com.vungle.ads.internal.omsdk.f fVar) {
        this.webViewObserver = fVar;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(@Nullable final WebView webView, @Nullable String str) {
        p.a aVar = p.Companion;
        aVar.d(TAG, "MRAID Command " + str);
        if (str == null || str.length() == 0) {
            aVar.e(TAG, "Invalid URL ");
            return false;
        }
        Uri uri = Uri.parse(str);
        if (uri == null || uri.getScheme() == null) {
            return false;
        }
        String scheme = uri.getScheme();
        if (t.d(scheme, "mraid")) {
            final String host = uri.getHost();
            if (host != null) {
                if (!t.d("propertiesChangeCompleted", host)) {
                    final d.a aVar2 = this.mraidDelegate;
                    if (aVar2 != null) {
                        r rVar = new r();
                        for (String param : uri.getQueryParameterNames()) {
                            t.h(param, "param");
                            kotlinx.serialization.json.g.c(rVar, param, uri.getQueryParameter(param));
                        }
                        final JsonObject jsonObjectA = rVar.a();
                        final Handler handler = new Handler(Looper.getMainLooper());
                        this.offloadExecutor.submit(new Runnable() { // from class: com.vungle.ads.internal.ui.e
                            @Override // java.lang.Runnable
                            public final void run() {
                                f.m4111shouldOverrideUrlLoading$lambda4$lambda3$lambda2(aVar2, host, jsonObjectA, handler, this, webView);
                            }
                        });
                    }
                } else if (!this.ready) {
                    runJavascriptOnWebView(webView, "window.vungle.mraidBridge.notifyReadyEvent(" + this.advertisement.createMRAIDArgs() + ')');
                    this.ready = true;
                }
                return true;
            }
        } else if (q.x(ProxyConfig.MATCH_HTTP, scheme, true) || q.x("https", scheme, true)) {
            aVar.d(TAG, "Open URL" + str);
            d.a aVar3 = this.mraidDelegate;
            if (aVar3 != null) {
                r rVar2 = new r();
                kotlinx.serialization.json.g.c(rVar2, "url", str);
                aVar3.processCommand("openNonMraid", rVar2.a());
            }
            return true;
        }
        return false;
    }

    public f(@NotNull com.vungle.ads.internal.model.b advertisement, @NotNull j placement, @NotNull ExecutorService offloadExecutor, @Nullable com.vungle.ads.internal.signals.b bVar, @Nullable com.vungle.ads.internal.platform.d dVar) {
        t.i(advertisement, "advertisement");
        t.i(placement, "placement");
        t.i(offloadExecutor, "offloadExecutor");
        this.advertisement = advertisement;
        this.placement = placement;
        this.offloadExecutor = offloadExecutor;
        this.signalManager = bVar;
        this.platform = dVar;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(@Nullable WebView webView, @Nullable WebResourceRequest webResourceRequest, @Nullable WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        String strValueOf = String.valueOf(webResourceError != null ? webResourceError.getDescription() : null);
        String strValueOf2 = String.valueOf(webResourceRequest != null ? webResourceRequest.getUrl() : null);
        boolean z10 = webResourceRequest != null && webResourceRequest.isForMainFrame();
        p.Companion.e(TAG, "Error desc " + strValueOf + ' ' + z10 + " for URL " + strValueOf2);
        handleWebViewError(strValueOf, strValueOf2, isCriticalAsset(strValueOf2) && z10);
    }

    @VisibleForTesting
    public static /* synthetic */ void getCollectConsent$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getErrorHandler$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getGdprAccept$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getGdprBody$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getGdprDeny$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getGdprTitle$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getLoadedWebView$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getMraidDelegate$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getReady$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getWebViewObserver$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void isViewable$vungle_ads_release$annotations() {
    }
}
