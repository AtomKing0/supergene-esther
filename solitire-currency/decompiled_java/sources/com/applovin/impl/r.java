package com.applovin.impl;

import android.content.Intent;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import io.sentry.protocol.TransactionInfo;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class r extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f6726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f6727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.applovin.impl.adview.a f6728c;

    public r(com.applovin.impl.adview.a aVar, com.applovin.impl.sdk.j jVar) {
        this.f6726a = jVar;
        this.f6727b = jVar.I();
        this.f6728c = aVar;
    }

    private void a(String str, ConsoleMessage consoleMessage) {
        String str2;
        com.applovin.impl.sdk.ad.b bVarG = this.f6728c.g();
        if (bVarG != null) {
            String str3 = consoleMessage.messageLevel() + ": " + consoleMessage.sourceId() + ": " + consoleMessage.lineNumber();
            if (str == null) {
                str2 = "AdWebView";
            } else {
                str2 = "AdWebView:" + str;
            }
            Map mapB = a2.b(bVarG);
            mapB.putAll(a2.a(bVarG));
            mapB.put(TransactionInfo.JsonKeys.SOURCE, str2);
            mapB.put("top_main_method", str3);
            mapB.put("error_message", consoleMessage.message());
            this.f6726a.A().d(y1.f7812v0, mapB);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String str = consoleMessage.messageLevel() + ": " + consoleMessage.sourceId() + ": " + consoleMessage.lineNumber() + ": " + consoleMessage.message();
        if (com.applovin.impl.sdk.n.a()) {
            this.f6727b.a("AdWebView", str);
        }
        if (consoleMessage.messageLevel() != ConsoleMessage.MessageLevel.ERROR) {
            return true;
        }
        String strMessage = consoleMessage.message();
        if (strMessage.contains("al_onPoststitialShow")) {
            AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.al_onPoststitialShow_evaluation_error"), null);
            a("onPoststitialShowEvaluationError", consoleMessage);
        } else if (strMessage.contains("SyntaxError")) {
            a(null, consoleMessage);
        }
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (!com.applovin.impl.sdk.n.a()) {
            return true;
        }
        this.f6727b.k("AdWebView", "Alert attempted: " + str2);
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        if (!com.applovin.impl.sdk.n.a()) {
            return true;
        }
        this.f6727b.k("AdWebView", "JS onBeforeUnload attempted: " + str2);
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        if (!com.applovin.impl.sdk.n.a()) {
            return true;
        }
        this.f6727b.k("AdWebView", "JS confirm attempted: " + str2);
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i10) {
        com.applovin.impl.adview.a aVar;
        if (i10 != 100 || (aVar = this.f6728c) == null) {
            return;
        }
        aVar.c(webView);
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String str, int i10, String str2) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f6727b.k("AdWebView", "console.log[" + i10 + "] :" + str);
        }
    }
}
