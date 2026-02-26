package com.unity3d.services.store.core;

import com.unity3d.scar.adapter.common.m;
import com.unity3d.services.ads.gmascar.handlers.WebViewErrorHandler;
import com.unity3d.services.store.StoreError;
import com.unity3d.services.store.StoreEvent;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;

/* JADX INFO: compiled from: WebViewStoreExceptionHandler.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class WebViewStoreExceptionHandler implements StoreExceptionHandler {

    @NotNull
    private final WebViewErrorHandler _webViewErrorHandler;

    public WebViewStoreExceptionHandler(@NotNull WebViewErrorHandler _webViewErrorHandler) {
        t.i(_webViewErrorHandler, "_webViewErrorHandler");
        this._webViewErrorHandler = _webViewErrorHandler;
    }

    private final StoreError getStoreError(Exception exc) {
        return exc instanceof NoSuchMethodException ? StoreError.NO_SUCH_METHOD : exc instanceof IllegalAccessException ? StoreError.ILLEGAL_ACCESS : exc instanceof JSONException ? StoreError.JSON_ERROR : exc instanceof InvocationTargetException ? StoreError.INVOCATION_TARGET : exc instanceof ClassNotFoundException ? StoreError.CLASS_NOT_FOUND : StoreError.UNKNOWN_ERROR;
    }

    private final void sendErrorToWebView(StoreEvent storeEvent, StoreError storeError, int i10, Exception exc) {
        this._webViewErrorHandler.handleError((m) new StoreWebViewError(storeEvent, exc.getMessage(), Integer.valueOf(i10), storeError, exc.getMessage()));
    }

    @Override // com.unity3d.services.store.core.StoreExceptionHandler
    public void handleStoreException(@NotNull StoreEvent storeEvent, int i10, @NotNull Exception exception) {
        t.i(storeEvent, "storeEvent");
        t.i(exception, "exception");
        sendErrorToWebView(storeEvent, getStoreError(exception), i10, exception);
    }
}
