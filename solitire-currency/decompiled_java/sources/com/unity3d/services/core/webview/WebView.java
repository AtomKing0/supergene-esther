package com.unity3d.services.core.webview;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import androidx.webkit.JavaScriptReplyProxy;
import androidx.webkit.ProxyConfig;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import com.unity3d.services.core.configuration.Experiments;
import com.unity3d.services.core.configuration.IExperiments;
import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.misc.ViewUtilities;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.webview.bridge.IInvocationCallbackInvoker;
import com.unity3d.services.core.webview.bridge.IWebViewBridge;
import com.unity3d.services.core.webview.bridge.SharedInstances;
import com.unity3d.services.core.webview.bridge.WebViewBridgeInterface;
import kotlin.collections.y0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import v8.l;
import v8.n;
import v8.p;

/* JADX INFO: compiled from: WebView.kt */
/* JADX INFO: loaded from: classes4.dex */
public class WebView extends android.webkit.WebView implements IServiceComponent {

    @NotNull
    private final l sdkMetricsSender$delegate;

    @NotNull
    private final WebViewBridgeInterface webViewBridgeInterface;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebView(@NotNull Context context) {
        this(context, false, null, null, null, 30, null);
        t.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void evaluateJavascript$lambda$1(WebView this$0, String script, ValueCallback valueCallback) {
        t.i(this$0, "this$0");
        t.i(script, "$script");
        super.evaluateJavascript(script, valueCallback);
    }

    private final SDKMetricsSender getSdkMetricsSender() {
        return (SDKMetricsSender) this.sdkMetricsSender$delegate.getValue();
    }

    @Override // android.webkit.WebView
    public void evaluateJavascript(@NotNull final String script, @Nullable final ValueCallback<String> valueCallback) {
        t.i(script, "script");
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.core.webview.c
            @Override // java.lang.Runnable
            public final void run() {
                WebView.evaluateJavascript$lambda$1(this.f24296a, script, valueCallback);
            }
        });
    }

    @Override // com.unity3d.services.core.di.IServiceComponent
    @NotNull
    public IServiceProvider getServiceProvider() {
        return IServiceComponent.DefaultImpls.getServiceProvider(this);
    }

    @Override // android.webkit.WebView
    public void loadUrl(@NotNull String url) {
        t.i(url, "url");
        DeviceLog.debug("Loading url: " + url);
        super.loadUrl(url);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebView(@NotNull Context context, boolean z10) {
        this(context, z10, null, null, null, 28, null);
        t.i(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebView(@NotNull Context context, boolean z10, @NotNull IWebViewBridge webViewBridge) {
        this(context, z10, webViewBridge, null, null, 24, null);
        t.i(context, "context");
        t.i(webViewBridge, "webViewBridge");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebView(@NotNull Context context, boolean z10, @NotNull IWebViewBridge webViewBridge, @NotNull IInvocationCallbackInvoker callbackInvoker) {
        this(context, z10, webViewBridge, callbackInvoker, null, 16, null);
        t.i(context, "context");
        t.i(webViewBridge, "webViewBridge");
        t.i(callbackInvoker, "callbackInvoker");
    }

    public /* synthetic */ WebView(Context context, boolean z10, IWebViewBridge iWebViewBridge, IInvocationCallbackInvoker iInvocationCallbackInvoker, IExperiments iExperiments, int i10, k kVar) {
        this(context, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? SharedInstances.INSTANCE.getWebViewBridge() : iWebViewBridge, (i10 & 8) != 0 ? SharedInstances.INSTANCE.getWebViewAppInvocationCallbackInvoker() : iInvocationCallbackInvoker, (i10 & 16) != 0 ? new Experiments() : iExperiments);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebView(@NotNull Context context, boolean z10, @NotNull IWebViewBridge webViewBridge, @NotNull IInvocationCallbackInvoker callbackInvoker, @NotNull IExperiments experiments) {
        super(context);
        t.i(context, "context");
        t.i(webViewBridge, "webViewBridge");
        t.i(callbackInvoker, "callbackInvoker");
        t.i(experiments, "experiments");
        this.sdkMetricsSender$delegate = n.b(p.f35203c, new WebView$special$$inlined$inject$default$1(this, ""));
        final WebViewBridgeInterface webViewBridgeInterface = new WebViewBridgeInterface(webViewBridge, callbackInvoker);
        this.webViewBridgeInterface = webViewBridgeInterface;
        WebSettings settings = getSettings();
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setAllowFileAccess(true);
        settings.setBlockNetworkImage(false);
        settings.setBlockNetworkLoads(false);
        settings.setBuiltInZoomControls(false);
        settings.setCacheMode(2);
        settings.setDatabaseEnabled(false);
        settings.setDisplayZoomControls(false);
        settings.setDomStorageEnabled(false);
        settings.setEnableSmoothTransition(false);
        settings.setGeolocationEnabled(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        settings.setJavaScriptEnabled(true);
        settings.setLightTouchEnabled(false);
        settings.setLoadWithOverviewMode(false);
        settings.setLoadsImagesAutomatically(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setMixedContentMode(1);
        settings.setNeedInitialFocus(true);
        settings.setPluginState(WebSettings.PluginState.OFF);
        settings.setRenderPriority(WebSettings.RenderPriority.NORMAL);
        settings.setSaveFormData(false);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(false);
        settings.setSupportZoom(false);
        settings.setUseWideViewPort(true);
        settings.setMediaPlaybackRequiresUserGesture(!z10);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setInitialScale(0);
        setBackgroundColor(0);
        ViewUtilities.setBackground(this, new ColorDrawable(0));
        setBackgroundResource(0);
        boolean zIsWebMessageEnabled = experiments.isWebMessageEnabled();
        if (zIsWebMessageEnabled) {
            getSdkMetricsSender().sendMetric(WebViewMetricKt.webMessageListenerEnabledMetric());
        } else {
            getSdkMetricsSender().sendMetric(WebViewMetricKt.webMessageListenerDisabledMetric());
        }
        boolean zIsFeatureSupported = WebViewFeature.isFeatureSupported(WebViewFeature.WEB_MESSAGE_LISTENER);
        if (zIsFeatureSupported) {
            getSdkMetricsSender().sendMetric(WebViewMetricKt.webMessageListenerSupportedMetric());
        } else {
            getSdkMetricsSender().sendMetric(WebViewMetricKt.webMessageListenerUnsupportedMetric());
        }
        if (zIsWebMessageEnabled && zIsFeatureSupported) {
            WebViewCompat.addWebMessageListener(this, "handleInvocation", y0.c(ProxyConfig.MATCH_ALL_SCHEMES), new WebViewCompat.WebMessageListener() { // from class: com.unity3d.services.core.webview.a
                @Override // androidx.webkit.WebViewCompat.WebMessageListener
                public final void onPostMessage(android.webkit.WebView webView, WebMessageCompat webMessageCompat, Uri uri, boolean z11, JavaScriptReplyProxy javaScriptReplyProxy) throws JSONException {
                    webViewBridgeInterface.onHandleInvocation(webView, webMessageCompat, uri, z11, javaScriptReplyProxy);
                }
            });
            WebViewCompat.addWebMessageListener(this, "handleCallback", y0.c(ProxyConfig.MATCH_ALL_SCHEMES), new WebViewCompat.WebMessageListener() { // from class: com.unity3d.services.core.webview.b
                @Override // androidx.webkit.WebViewCompat.WebMessageListener
                public final void onPostMessage(android.webkit.WebView webView, WebMessageCompat webMessageCompat, Uri uri, boolean z11, JavaScriptReplyProxy javaScriptReplyProxy) throws Exception {
                    webViewBridgeInterface.onHandleCallback(webView, webMessageCompat, uri, z11, javaScriptReplyProxy);
                }
            });
        } else {
            addJavascriptInterface(webViewBridgeInterface, "webviewbridge");
        }
    }
}
