package com.ironsource;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface dn extends an {
    void onInterstitialAdRewarded(String str, int i10);

    void onInterstitialClick();

    void onInterstitialClose();

    void onInterstitialEventNotificationReceived(String str, JSONObject jSONObject);

    void onInterstitialInitFailed(String str);

    void onInterstitialInitSuccess();

    void onInterstitialLoadFailed(String str);

    void onInterstitialLoadSuccess(mi miVar);

    void onInterstitialOpen();

    void onInterstitialShowFailed(String str);

    void onInterstitialShowSuccess();
}
