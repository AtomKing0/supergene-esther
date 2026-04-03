package com.unity3d.services.core.webview.bridge;

import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.webkit.JavaScriptReplyProxy;
import androidx.webkit.WebMessageCompat;
import com.unity3d.ads.core.extensions.JSONArrayExtensionsKt;
import com.unity3d.services.core.log.DeviceLog;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p9.q;

/* JADX INFO: compiled from: WebViewBridgeInterface.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class WebViewBridgeInterface {

    @NotNull
    private final IInvocationCallbackInvoker webViewAppInvocationCallbackInvoker;

    @NotNull
    private final IWebViewBridge webViewBridge;

    /* JADX WARN: Multi-variable type inference failed */
    public WebViewBridgeInterface() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @JavascriptInterface
    public final void handleCallback(@NotNull String callbackId, @NotNull String callbackStatus, @NotNull String rawParameters) throws Exception {
        t.i(callbackId, "callbackId");
        t.i(callbackStatus, "callbackStatus");
        t.i(rawParameters, "rawParameters");
        DeviceLog.debug("handleCallback " + callbackId + ' ' + callbackStatus + ' ' + rawParameters);
        this.webViewBridge.handleCallback(callbackId, callbackStatus, JSONArrayExtensionsKt.toTypedArray(new JSONArray(rawParameters)));
    }

    @JavascriptInterface
    public final void handleInvocation(@NotNull String data) throws JSONException {
        t.i(data, "data");
        DeviceLog.debug("handleInvocation " + data);
        JSONArray jSONArray = new JSONArray(data);
        Invocation invocation = new Invocation(this.webViewAppInvocationCallbackInvoker, this.webViewBridge);
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            Object obj = jSONArray.get(i10);
            t.g(obj, "null cannot be cast to non-null type org.json.JSONArray");
            JSONArray jSONArray2 = (JSONArray) obj;
            Object obj2 = jSONArray2.get(0);
            t.g(obj2, "null cannot be cast to non-null type kotlin.String");
            Object obj3 = jSONArray2.get(1);
            t.g(obj3, "null cannot be cast to non-null type kotlin.String");
            Object obj4 = jSONArray2.get(2);
            t.g(obj4, "null cannot be cast to non-null type org.json.JSONArray");
            Object obj5 = jSONArray2.get(3);
            t.g(obj5, "null cannot be cast to non-null type kotlin.String");
            invocation.addInvocation((String) obj2, (String) obj3, JSONArrayExtensionsKt.toTypedArray((JSONArray) obj4), new WebViewCallback((String) obj5, invocation.getId()));
            invocation.nextInvocation();
        }
        invocation.sendInvocationCallback();
    }

    public final void onHandleCallback(@NotNull WebView view, @NotNull WebMessageCompat message, @NotNull Uri sourceOrigin, boolean z10, @NotNull JavaScriptReplyProxy replyProxy) throws Exception {
        t.i(view, "view");
        t.i(message, "message");
        t.i(sourceOrigin, "sourceOrigin");
        t.i(replyProxy, "replyProxy");
        String data = message.getData();
        if (z10) {
            if (data == null || q.z(data)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(data);
            String callbackId = jSONObject.getString("id");
            String callbackStatus = jSONObject.getString("status");
            String rawParameters = jSONObject.getString("parameters");
            t.h(callbackId, "callbackId");
            t.h(callbackStatus, "callbackStatus");
            t.h(rawParameters, "rawParameters");
            handleCallback(callbackId, callbackStatus, rawParameters);
        }
    }

    public final void onHandleInvocation(@NotNull WebView view, @NotNull WebMessageCompat message, @NotNull Uri sourceOrigin, boolean z10, @NotNull JavaScriptReplyProxy replyProxy) throws JSONException {
        t.i(view, "view");
        t.i(message, "message");
        t.i(sourceOrigin, "sourceOrigin");
        t.i(replyProxy, "replyProxy");
        String data = message.getData();
        if (z10) {
            if (data == null || q.z(data)) {
                return;
            }
            handleInvocation(data);
        }
    }

    public WebViewBridgeInterface(@NotNull IWebViewBridge webViewBridge, @NotNull IInvocationCallbackInvoker webViewAppInvocationCallbackInvoker) {
        t.i(webViewBridge, "webViewBridge");
        t.i(webViewAppInvocationCallbackInvoker, "webViewAppInvocationCallbackInvoker");
        this.webViewBridge = webViewBridge;
        this.webViewAppInvocationCallbackInvoker = webViewAppInvocationCallbackInvoker;
    }

    public /* synthetic */ WebViewBridgeInterface(IWebViewBridge iWebViewBridge, IInvocationCallbackInvoker iInvocationCallbackInvoker, int i10, k kVar) {
        this((i10 & 1) != 0 ? SharedInstances.INSTANCE.getWebViewBridge() : iWebViewBridge, (i10 & 2) != 0 ? SharedInstances.INSTANCE.getWebViewAppInvocationCallbackInvoker() : iInvocationCallbackInvoker);
    }
}
