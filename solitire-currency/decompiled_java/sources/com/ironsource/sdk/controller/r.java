package com.ironsource.sdk.controller;

import android.webkit.JavascriptInterface;

/* JADX INFO: loaded from: classes4.dex */
class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private s f15124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f15125b = false;

    r(s sVar) {
        this.f15124a = sVar;
    }

    @JavascriptInterface
    public String getTokenForMessaging() {
        if (this.f15125b) {
            return "";
        }
        this.f15125b = true;
        return this.f15124a.b();
    }
}
