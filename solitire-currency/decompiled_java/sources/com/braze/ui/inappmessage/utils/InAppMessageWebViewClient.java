package com.braze.ui.inappmessage.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.VisibleForTesting;
import androidx.webkit.WebViewAssetLoader;
import androidx.webkit.WebViewClientCompat;
import com.braze.BrazeInternal;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.BrazeFileUtils;
import com.braze.support.BrazeLogger;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.listeners.IInAppMessageWebViewClientListener;
import com.braze.ui.inappmessage.listeners.IWebViewClientStateListener;
import com.braze.ui.support.UriUtils;
import com.unity3d.services.UnityAdsConstants;
import h9.a;
import h9.p;
import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n2;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: InAppMessageWebViewClient.kt */
/* JADX INFO: loaded from: classes2.dex */
public class InAppMessageWebViewClient extends WebViewClientCompat {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final WebViewAssetLoader assetLoader;

    @NotNull
    private final Context context;

    @NotNull
    private final AtomicBoolean hasCalledPageFinishedOnListener;
    private boolean hasPageFinishedLoading;

    @NotNull
    private final IInAppMessage inAppMessage;

    @Nullable
    private final IInAppMessageWebViewClientListener inAppMessageWebViewClientListener;

    @Nullable
    private b2 markPageFinishedJob;
    private final int maxOnPageFinishedWaitTimeMs;

    @Nullable
    private IWebViewClientStateListener webViewClientStateListener;

    /* JADX INFO: compiled from: InAppMessageWebViewClient.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @VisibleForTesting
        @NotNull
        public final Bundle getBundleFromUrl(@NotNull String url) {
            t.i(url, "url");
            Bundle bundle = new Bundle();
            if (q.z(url)) {
                return bundle;
            }
            Uri uri = Uri.parse(url);
            t.h(uri, "uri");
            for (Map.Entry<String, String> entry : UriUtils.getQueryParameters(uri).entrySet()) {
                bundle.putString(entry.getKey(), entry.getValue());
            }
            return bundle;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.InAppMessageWebViewClient$handleUrlOverride$1, reason: invalid class name */
    /* JADX INFO: compiled from: InAppMessageWebViewClient.kt */
    static final class AnonymousClass1 extends v implements a<String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "InAppMessageWebViewClient was given null IInAppMessageWebViewClientListener listener. Returning true.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.InAppMessageWebViewClient$handleUrlOverride$2, reason: invalid class name */
    /* JADX INFO: compiled from: InAppMessageWebViewClient.kt */
    static final class AnonymousClass2 extends v implements a<String> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "InAppMessageWebViewClient.shouldOverrideUrlLoading was given blank url. Returning true.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.InAppMessageWebViewClient$handleUrlOverride$3, reason: invalid class name */
    /* JADX INFO: compiled from: InAppMessageWebViewClient.kt */
    static final class AnonymousClass3 extends v implements a<String> {
        final /* synthetic */ Uri $uri;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Uri uri) {
            super(0);
            this.$uri = uri;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Uri authority was null. Uri: " + this.$uri;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.InAppMessageWebViewClient$handleUrlOverride$4, reason: invalid class name */
    /* JADX INFO: compiled from: InAppMessageWebViewClient.kt */
    static final class AnonymousClass4 extends v implements a<String> {
        final /* synthetic */ Uri $uri;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Uri uri) {
            super(0);
            this.$uri = uri;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Uri scheme was null or not an appboy url. Uri: " + this.$uri;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.InAppMessageWebViewClient$onRenderProcessGone$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageWebViewClient.kt */
    static final class C12611 extends v implements a<String> {
        public static final C12611 INSTANCE = new C12611();

        C12611() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "The webview rendering process crashed, returning true";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.InAppMessageWebViewClient$setWebViewClientStateListener$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageWebViewClient.kt */
    @f(c = "com.braze.ui.inappmessage.utils.InAppMessageWebViewClient$setWebViewClientStateListener$1", f = "InAppMessageWebViewClient.kt", l = {151}, m = "invokeSuspend")
    static final class C12621 extends l implements h9.l<d<? super k0>, Object> {
        int label;

        /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.InAppMessageWebViewClient$setWebViewClientStateListener$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: InAppMessageWebViewClient.kt */
        @f(c = "com.braze.ui.inappmessage.utils.InAppMessageWebViewClient$setWebViewClientStateListener$1$1", f = "InAppMessageWebViewClient.kt", l = {}, m = "invokeSuspend")
        static final class C01871 extends l implements p<o0, d<? super k0>, Object> {
            int label;
            final /* synthetic */ InAppMessageWebViewClient this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01871(InAppMessageWebViewClient inAppMessageWebViewClient, d<? super C01871> dVar) {
                super(2, dVar);
                this.this$0 = inAppMessageWebViewClient;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                return new C01871(this.this$0, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a9.d.e();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
                this.this$0.markPageFinished();
                return k0.f35197a;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
                return ((C01871) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }
        }

        C12621(d<? super C12621> dVar) {
            super(1, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@NotNull d<?> dVar) {
            return InAppMessageWebViewClient.this.new C12621(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                n2 n2VarC = e1.c();
                C01871 c01871 = new C01871(InAppMessageWebViewClient.this, null);
                this.label = 1;
                if (i.g(n2VarC, c01871, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }

        @Override // h9.l
        @Nullable
        public final Object invoke(@Nullable d<? super k0> dVar) {
            return ((C12621) create(dVar)).invokeSuspend(k0.f35197a);
        }
    }

    public /* synthetic */ InAppMessageWebViewClient(Context context, IInAppMessage iInAppMessage, IInAppMessageWebViewClientListener iInAppMessageWebViewClientListener, String str, int i10, k kVar) {
        this(context, iInAppMessage, iInAppMessageWebViewClientListener, (i10 & 8) != 0 ? null : str);
    }

    private final void appendBridgeJavascript(WebView webView) {
        try {
            AssetManager assets = this.context.getAssets();
            t.h(assets, "context.assets");
            webView.loadUrl("javascript:" + BrazeFileUtils.getAssetFileStringContents(assets, "braze-html-in-app-message-bridge.js"));
        } catch (Exception e10) {
            BrazeInAppMessageManager.Companion.getInstance().hideCurrentlyDisplayingInAppMessage(false);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (a) InAppMessageWebViewClient$appendBridgeJavascript$javascriptString$1.INSTANCE, 4, (Object) null);
        }
    }

    private final boolean handleUrlOverride(String str) {
        if (this.inAppMessageWebViewClientListener == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (a) AnonymousClass1.INSTANCE, 6, (Object) null);
            return true;
        }
        if (q.z(str)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (a) AnonymousClass2.INSTANCE, 6, (Object) null);
            return true;
        }
        Uri uri = Uri.parse(str);
        Bundle bundleFromUrl = Companion.getBundleFromUrl(str);
        if (uri.getScheme() == null || !t.d(uri.getScheme(), "appboy")) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new AnonymousClass4(uri), 7, (Object) null);
            this.inAppMessageWebViewClientListener.onOtherUrlAction(this.inAppMessage, str, bundleFromUrl);
            return true;
        }
        String authority = uri.getAuthority();
        if (authority != null) {
            int iHashCode = authority.hashCode();
            if (iHashCode != -1801488983) {
                if (iHashCode != 3138974) {
                    if (iHashCode == 94756344 && authority.equals("close")) {
                        this.inAppMessageWebViewClientListener.onCloseAction(this.inAppMessage, str, bundleFromUrl);
                    }
                } else if (authority.equals("feed")) {
                    this.inAppMessageWebViewClientListener.onNewsfeedAction(this.inAppMessage, str, bundleFromUrl);
                }
            } else if (authority.equals("customEvent")) {
                this.inAppMessageWebViewClientListener.onCustomEventAction(this.inAppMessage, str, bundleFromUrl);
            }
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new AnonymousClass3(uri), 7, (Object) null);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void markPageFinished() {
        IWebViewClientStateListener iWebViewClientStateListener = this.webViewClientStateListener;
        if (iWebViewClientStateListener == null || !this.hasCalledPageFinishedOnListener.compareAndSet(false, true)) {
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) InAppMessageWebViewClient$markPageFinished$1$1.INSTANCE, 6, (Object) null);
        iWebViewClientStateListener.onPageFinished();
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(@NotNull WebView view, @NotNull String url) {
        t.i(view, "view");
        t.i(url, "url");
        appendBridgeJavascript(view);
        IWebViewClientStateListener iWebViewClientStateListener = this.webViewClientStateListener;
        if (iWebViewClientStateListener != null && this.hasCalledPageFinishedOnListener.compareAndSet(false, true)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) InAppMessageWebViewClient$onPageFinished$1$1.INSTANCE, 6, (Object) null);
            iWebViewClientStateListener.onPageFinished();
        }
        this.hasPageFinishedLoading = true;
        b2 b2Var = this.markPageFinishedJob;
        if (b2Var != null) {
            b2.a.a(b2Var, null, 1, null);
        }
        this.markPageFinishedJob = null;
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(@NotNull WebView view, @NotNull RenderProcessGoneDetail detail) {
        t.i(view, "view");
        t.i(detail, "detail");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (a) C12611.INSTANCE, 6, (Object) null);
        return true;
    }

    public final void setWebViewClientStateListener(@Nullable IWebViewClientStateListener iWebViewClientStateListener) {
        if (iWebViewClientStateListener != null && this.hasPageFinishedLoading && this.hasCalledPageFinishedOnListener.compareAndSet(false, true)) {
            iWebViewClientStateListener.onPageFinished();
        } else {
            this.markPageFinishedJob = BrazeCoroutineScope.launchDelayed$default(BrazeCoroutineScope.INSTANCE, Integer.valueOf(this.maxOnPageFinishedWaitTimeMs), null, new C12621(null), 2, null);
        }
        this.webViewClientStateListener = iWebViewClientStateListener;
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    public WebResourceResponse shouldInterceptRequest(@Nullable WebView webView, @Nullable WebResourceRequest webResourceRequest) {
        if (webResourceRequest != null) {
            return this.assetLoader.shouldInterceptRequest(webResourceRequest.getUrl());
        }
        return null;
    }

    @Override // androidx.webkit.WebViewClientCompat, android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public boolean shouldOverrideUrlLoading(@NotNull WebView view, @NotNull WebResourceRequest request) {
        t.i(view, "view");
        t.i(request, "request");
        String string = request.getUrl().toString();
        t.h(string, "request.url.toString()");
        return handleUrlOverride(string);
    }

    public InAppMessageWebViewClient(@NotNull Context context, @NotNull IInAppMessage inAppMessage, @Nullable IInAppMessageWebViewClientListener iInAppMessageWebViewClientListener, @Nullable String str) {
        WebViewAssetLoader webViewAssetLoaderBuild;
        t.i(context, "context");
        t.i(inAppMessage, "inAppMessage");
        this.context = context;
        this.inAppMessage = inAppMessage;
        this.inAppMessageWebViewClientListener = iInAppMessageWebViewClientListener;
        this.hasCalledPageFinishedOnListener = new AtomicBoolean(false);
        this.maxOnPageFinishedWaitTimeMs = BrazeInternal.INSTANCE.getConfigurationProvider(context).getInAppMessageWebViewClientOnPageFinishedMaxWaitMs();
        if (str != null) {
            webViewAssetLoaderBuild = new WebViewAssetLoader.Builder().setDomain("iamcache.braze").addPathHandler(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH, new WebViewAssetLoader.InternalStoragePathHandler(context, new File(str))).build();
        } else {
            webViewAssetLoaderBuild = new WebViewAssetLoader.Builder().setDomain("iamcache.braze").addPathHandler("/ab_triggers/", new WebViewAssetLoader.InternalStoragePathHandler(context, new File(context.getCacheDir(), "ab_triggers"))).build();
        }
        t.h(webViewAssetLoaderBuild, "if (assetDirectoryUrl !=…       .build()\n        }");
        this.assetLoader = webViewAssetLoaderBuild;
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    public WebResourceResponse shouldInterceptRequest(@Nullable WebView webView, @Nullable String str) {
        return this.assetLoader.shouldInterceptRequest(Uri.parse(str));
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(@NotNull WebView view, @NotNull String url) {
        t.i(view, "view");
        t.i(url, "url");
        return handleUrlOverride(url);
    }
}
