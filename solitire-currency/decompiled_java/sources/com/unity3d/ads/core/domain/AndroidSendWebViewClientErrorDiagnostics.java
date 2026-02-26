package com.unity3d.ads.core.domain;

import com.unity3d.ads.adplayer.model.WebViewClientError;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import java.util.List;
import java.util.Map;
import kotlin.collections.q0;
import kotlin.collections.r0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.y;

/* JADX INFO: compiled from: AndroidSendWebViewClientErrorDiagnostics.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidSendWebViewClientErrorDiagnostics implements SendWebViewClientErrorDiagnostics {

    @NotNull
    private final SendDiagnosticEvent sendDiagnosticEvent;

    public AndroidSendWebViewClientErrorDiagnostics(@NotNull SendDiagnosticEvent sendDiagnosticEvent) {
        t.i(sendDiagnosticEvent, "sendDiagnosticEvent");
        this.sendDiagnosticEvent = sendDiagnosticEvent;
    }

    @Override // com.unity3d.ads.core.domain.SendWebViewClientErrorDiagnostics
    public void invoke(@NotNull List<WebViewClientError> errors) {
        t.i(errors, "errors");
        for (WebViewClientError webViewClientError : errors) {
            String url = webViewClientError.getUrl();
            Map mapE = !(url == null || url.length() == 0) ? q0.e(y.a("webview_url", webViewClientError.getUrl())) : null;
            Map mapL = r0.l(y.a("reason", Integer.valueOf(webViewClientError.getReason().getCode())));
            if (webViewClientError.getStatusCode() != null) {
                mapL.put("webview_error_code", webViewClientError.getStatusCode());
            }
            SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "webview_error", null, mapE, mapL, null, 18, null);
        }
    }
}
