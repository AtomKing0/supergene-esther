package com.google.android.gms.internal.consent_sdk;

import android.webkit.WebView;
import androidx.annotation.GuardedBy;

/* JADX INFO: compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcs {

    @GuardedBy("WebViewUtil.class")
    private static Boolean zza;

    private zzcs() {
    }

    public static void zza(WebView webView, String str) {
        boolean zBooleanValue;
        synchronized (zzcs.class) {
            if (zza == null) {
                try {
                    webView.evaluateJavascript("(function(){})()", null);
                    zza = Boolean.TRUE;
                } catch (IllegalStateException unused) {
                    zza = Boolean.FALSE;
                }
                zBooleanValue = zza.booleanValue();
            } else {
                zBooleanValue = zza.booleanValue();
            }
        }
        if (zBooleanValue) {
            webView.evaluateJavascript(str, null);
        } else {
            webView.loadUrl("javascript:".concat(str));
        }
    }
}
