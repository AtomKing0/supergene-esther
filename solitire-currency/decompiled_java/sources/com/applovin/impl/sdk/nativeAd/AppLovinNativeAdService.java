package com.applovin.impl.sdk.nativeAd;

import android.text.TextUtils;
import com.applovin.impl.i;
import com.applovin.impl.l2;
import com.applovin.impl.l5;
import com.applovin.impl.n0;
import com.applovin.impl.r5;
import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.u5;
import com.applovin.impl.w4;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AppLovinNativeAdService {
    private static final String TAG = "AppLovinNativeAdService";
    private final n logger;
    private final com.applovin.impl.sdk.j sdk;

    public AppLovinNativeAdService(com.applovin.impl.sdk.j jVar) {
        this.sdk = jVar;
        this.logger = jVar.I();
    }

    public void loadNextAdForAdToken(String str, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        String strTrim = str != null ? str.trim() : null;
        if (TextUtils.isEmpty(strTrim)) {
            n.h(TAG, "Empty ad token");
            l2.b(appLovinNativeAdLoadListener, new AppLovinError(-8, "Empty ad token"));
            return;
        }
        com.applovin.impl.i iVar = new com.applovin.impl.i(strTrim, this.sdk);
        if (iVar.c() == i.a.REGULAR) {
            if (n.a()) {
                this.logger.a(TAG, "Loading next ad for token: " + iVar);
            }
            this.sdk.j0().a((w4) new l5(iVar, appLovinNativeAdLoadListener, this.sdk), r5.b.CORE);
            return;
        }
        if (iVar.c() != i.a.AD_RESPONSE_JSON) {
            AppLovinError appLovinError = new AppLovinError(-8, "Invalid token type");
            n.h(TAG, "Invalid token type");
            l2.b(appLovinNativeAdLoadListener, appLovinError);
            return;
        }
        JSONObject jSONObjectA = iVar.a();
        if (jSONObjectA == null) {
            String str2 = "Unable to retrieve ad response JSON from token: " + iVar.b();
            AppLovinError appLovinError2 = new AppLovinError(-8, str2);
            n.h(TAG, str2);
            l2.b(appLovinNativeAdLoadListener, appLovinError2);
            return;
        }
        n0.c(jSONObjectA, this.sdk);
        n0.b(jSONObjectA, this.sdk);
        n0.a(jSONObjectA, this.sdk);
        if (JsonUtils.getJSONArray(jSONObjectA, "ads", new JSONArray()).length() > 0) {
            if (n.a()) {
                this.logger.a(TAG, "Rendering ad for token: " + iVar);
            }
            this.sdk.j0().a((w4) new u5(jSONObjectA, appLovinNativeAdLoadListener, this.sdk), r5.b.CORE);
            return;
        }
        if (n.a()) {
            this.logger.b(TAG, "No ad returned from the server for token: " + iVar);
        }
        l2.b(appLovinNativeAdLoadListener, AppLovinError.NO_FILL);
    }
}
