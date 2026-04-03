package com.applovin.impl;

import com.amazon.device.ads.DTBAdSize;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DTBAdSize f7547b;

    private enum a {
        VIDEO,
        DISPLAY,
        INTERSTITIAL
    }

    public v(String str, JSONObject jSONObject, MaxAdFormat maxAdFormat) {
        this.f7546a = str;
        this.f7547b = a(JsonUtils.getInt(jSONObject, "type", a(maxAdFormat).ordinal()), maxAdFormat, str);
    }

    public DTBAdSize a() {
        return this.f7547b;
    }

    private a a(MaxAdFormat maxAdFormat) {
        return maxAdFormat.isAdViewAd() ? a.DISPLAY : a.INTERSTITIAL;
    }

    private DTBAdSize a(int i10, MaxAdFormat maxAdFormat, String str) {
        try {
            if (a.VIDEO.ordinal() == i10) {
                return new DTBAdSize.DTBVideo(Sdk$SDKError.b.WEBVIEW_ERROR_VALUE, 480, str);
            }
            if (a.DISPLAY.ordinal() == i10) {
                return new DTBAdSize(maxAdFormat.getSize().getWidth(), maxAdFormat.getSize().getHeight(), str);
            }
            if (a.INTERSTITIAL.ordinal() == i10) {
                return new DTBAdSize.DTBInterstitialAdSize(str);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
