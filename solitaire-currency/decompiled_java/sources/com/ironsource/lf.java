package com.ironsource;

import android.webkit.JavascriptInterface;

/* JADX INFO: loaded from: classes4.dex */
public class lf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private of f13021a;

    lf(of ofVar) {
        this.f13021a = ofVar;
    }

    @JavascriptInterface
    public void receiveMessageFromExternal(String str) {
        this.f13021a.handleMessageFromAd(str);
    }
}
