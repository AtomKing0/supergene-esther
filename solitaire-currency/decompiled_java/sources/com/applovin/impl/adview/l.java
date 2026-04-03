package com.applovin.impl.adview;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.applovin.impl.y7;

/* JADX INFO: loaded from: classes2.dex */
public class l extends com.applovin.impl.f0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f4852c;

    public l(String str, com.applovin.impl.sdk.ad.b bVar, y7 y7Var, Context context) {
        super(context);
        this.f4852c = str;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptEnabled(true);
        if (bVar.M0()) {
            applySettings(bVar);
        } else {
            settings.setAllowFileAccess(true);
            if (bVar.I0()) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
        }
        setWebViewClient(y7Var);
        setWebChromeClient(new WebChromeClient());
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setScrollBarStyle(33554432);
    }

    public void a(String str) {
        loadDataWithBaseURL(this.f4852c, str, "text/html", null, "");
    }
}
