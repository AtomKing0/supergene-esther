package com.google.android.gms.internal.ads;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcei extends WebChromeClient {
    private final zzcej zza;

    public zzcei(zzcej zzcejVar) {
        this.zza = zzcejVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Context zzb(WebView webView) {
        if (!(webView instanceof zzcej)) {
            return webView.getContext();
        }
        zzcej zzcejVar = (zzcej) webView;
        Activity activityZzi = zzcejVar.zzi();
        return activityZzi != null ? activityZzi : zzcejVar.getContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebChromeClient
    public final void onCloseWindow(WebView webView) {
        if (!(webView instanceof zzcej)) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = ((zzcej) webView).zzL();
        if (zzmVarZzL == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Tried to close an AdWebView not associated with an overlay.");
        } else {
            zzmVarZzL.zzb();
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String str = "JS: " + consoleMessage.message() + " (" + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber() + ")";
        if (str.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        int i10 = zzceh.zza[consoleMessage.messageLevel().ordinal()];
        if (i10 == 1) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg(str);
        } else if (i10 == 2) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj(str);
        } else if (i10 == 3 || i10 == 4 || i10 != 5) {
            com.google.android.gms.ads.internal.util.client.zzm.zzi(str);
        } else {
            com.google.android.gms.ads.internal.util.client.zzm.zze(str);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView webView, boolean z10, boolean z11, Message message) {
        WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        if (this.zza.zzH() != null) {
            webView2.setWebViewClient(this.zza.zzH());
        }
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onExceededDatabaseQuota(String str, String str2, long j10, long j11, long j12, WebStorage.QuotaUpdater quotaUpdater) {
        long j13 = 5242880 - j12;
        if (j13 <= 0) {
            quotaUpdater.updateQuota(j10);
            return;
        }
        if (j10 == 0) {
            if (j11 > j13 || j11 > 1048576) {
                j11 = 0;
            }
        } else if (j11 == 0) {
            j11 = Math.min(j10 + Math.min(131072L, j13), 1048576L);
        } else {
            if (j11 <= Math.min(1048576 - j10, j13)) {
                j10 += j11;
            }
            j11 = j10;
        }
        quotaUpdater.updateQuota(j11);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    @Override // android.webkit.WebChromeClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onGeolocationPermissionsShowPrompt(java.lang.String r4, android.webkit.GeolocationPermissions.Callback r5) {
        /*
            r3 = this;
            if (r5 == 0) goto L2c
            com.google.android.gms.internal.ads.zzcej r0 = r3.zza
            com.google.android.gms.ads.internal.zzu.zzp()
            android.content.Context r0 = r0.getContext()
            java.lang.String r1 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r0 = com.google.android.gms.ads.internal.util.zzt.zzA(r0, r1)
            r1 = 1
            if (r0 != 0) goto L28
            com.google.android.gms.internal.ads.zzcej r0 = r3.zza
            com.google.android.gms.ads.internal.zzu.zzp()
            android.content.Context r0 = r0.getContext()
            java.lang.String r2 = "android.permission.ACCESS_COARSE_LOCATION"
            boolean r0 = com.google.android.gms.ads.internal.util.zzt.zzA(r0, r2)
            if (r0 == 0) goto L26
            goto L28
        L26:
            r0 = 0
            goto L29
        L28:
            r0 = r1
        L29:
            r5.invoke(r4, r0, r1)
        L2c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcei.onGeolocationPermissionsShowPrompt(java.lang.String, android.webkit.GeolocationPermissions$Callback):void");
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = this.zza.zzL();
        if (zzmVarZzL == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Could not get ad overlay when hiding custom view.");
        } else {
            zzmVarZzL.zzg();
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "alert", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "onBeforeUnload", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "confirm", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return zza(zzb(webView), "prompt", str, str2, str3, null, jsPromptResult, true);
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public final void onShowCustomView(View view, int i10, WebChromeClient.CustomViewCallback customViewCallback) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = this.zza.zzL();
        if (zzmVarZzL == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
        } else {
            zzmVarZzL.zzC(view, customViewCallback);
            zzmVarZzL.zzA(i10);
        }
    }

    protected final boolean zza(Context context, String str, String str2, String str3, String str4, JsResult jsResult, JsPromptResult jsPromptResult, boolean z10) {
        zzcej zzcejVar;
        com.google.android.gms.ads.internal.zzb zzbVarZzd;
        try {
            zzcejVar = this.zza;
        } catch (WindowManager.BadTokenException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("Fail to display Dialog.", e10);
        }
        if (zzcejVar != null && zzcejVar.zzN() != null && this.zza.zzN().zzd() != null && (zzbVarZzd = this.zza.zzN().zzd()) != null && !zzbVarZzd.zzc()) {
            zzbVarZzd.zzb("window." + str + "('" + str3 + "')");
            return false;
        }
        com.google.android.gms.ads.internal.zzu.zzp();
        AlertDialog.Builder builderZzK = com.google.android.gms.ads.internal.util.zzt.zzK(context);
        builderZzK.setTitle(str2);
        if (z10) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            TextView textView = new TextView(context);
            textView.setText(str3);
            EditText editText = new EditText(context);
            editText.setText(str4);
            linearLayout.addView(textView);
            linearLayout.addView(editText);
            builderZzK.setView(linearLayout).setPositiveButton(R.string.ok, new zzceg(jsPromptResult, editText)).setNegativeButton(R.string.cancel, new zzcef(jsPromptResult)).setOnCancelListener(new zzcee(jsPromptResult)).create().show();
        } else {
            builderZzK.setMessage(str3).setPositiveButton(R.string.ok, new zzced(jsResult)).setNegativeButton(R.string.cancel, new zzcec(jsResult)).setOnCancelListener(new zzceb(jsResult)).create().show();
        }
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, -1, customViewCallback);
    }
}
