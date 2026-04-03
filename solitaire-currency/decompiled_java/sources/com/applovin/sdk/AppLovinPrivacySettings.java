package com.applovin.sdk;

import android.content.Context;
import androidx.annotation.Nullable;
import com.applovin.impl.l0;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;

/* JADX INFO: loaded from: classes2.dex */
public class AppLovinPrivacySettings {
    @Nullable
    public static Boolean getAdditionalConsentStatus(int i10) {
        j jVar = j.f7084v0;
        if (jVar != null) {
            return jVar.k0().a(i10);
        }
        n.h("AppLovinPrivacySettings", "AppLovinPrivacySettings.getAdditionalConsentStatus(...) called when AppLovin MAX SDK is not initialized yet");
        return null;
    }

    @Nullable
    public static Boolean getPurposeConsentStatus(int i10) {
        j jVar = j.f7084v0;
        if (jVar != null) {
            return jVar.k0().b(i10);
        }
        n.h("AppLovinPrivacySettings", "AppLovinPrivacySettings.getPurposeConsentStatus(...) called when AppLovin MAX SDK is not initialized yet");
        return null;
    }

    @Nullable
    public static Boolean getSpecialFeatureOptInStatus(int i10) {
        j jVar = j.f7084v0;
        if (jVar != null) {
            return jVar.k0().c(i10);
        }
        n.h("AppLovinPrivacySettings", "AppLovinPrivacySettings.getSpecialFeatureOptInStatus(...) called when AppLovin MAX SDK is not initialized yet");
        return null;
    }

    @Nullable
    public static Boolean getTcfVendorConsentStatus(int i10) {
        j jVar = j.f7084v0;
        if (jVar != null) {
            return jVar.k0().d(i10);
        }
        n.h("AppLovinPrivacySettings", "AppLovinPrivacySettings.getTcfVendorConsentStatus(...) called when AppLovin MAX SDK is not initialized yet");
        return null;
    }

    public static boolean hasUserConsent() {
        return hasUserConsent(j.n());
    }

    public static boolean isDoNotSell() {
        return isDoNotSell(j.n());
    }

    public static boolean isDoNotSellSet() {
        return isDoNotSellSet(j.n());
    }

    public static boolean isUserConsentSet() {
        return isUserConsentSet(j.n());
    }

    public static void setDoNotSell(boolean z10) {
        setDoNotSell(z10, j.n());
    }

    public static void setHasUserConsent(boolean z10) {
        setHasUserConsent(z10, j.n());
    }

    @Deprecated
    public static boolean hasUserConsent(Context context) {
        Boolean boolB = l0.b().b(context);
        if (boolB != null) {
            return boolB.booleanValue();
        }
        return false;
    }

    @Deprecated
    public static boolean isDoNotSell(Context context) {
        Boolean boolB = l0.a().b(context);
        if (boolB != null) {
            return boolB.booleanValue();
        }
        return false;
    }

    @Deprecated
    public static boolean isDoNotSellSet(Context context) {
        return l0.a().b(context) != null;
    }

    @Deprecated
    public static boolean isUserConsentSet(Context context) {
        return l0.b().b(context) != null;
    }

    @Deprecated
    public static void setDoNotSell(boolean z10, Context context) {
        n.g("AppLovinPrivacySettings", "setDoNotSell()");
        if (l0.a(z10, context)) {
            AppLovinSdk.getInstance(context).reinitialize(null, Boolean.valueOf(z10));
        }
    }

    @Deprecated
    public static void setHasUserConsent(boolean z10, Context context) {
        n.g("AppLovinPrivacySettings", "setHasUserConsent()");
        if (l0.b(z10, context)) {
            AppLovinSdk.getInstance(context).reinitialize(Boolean.valueOf(z10), null);
        }
    }
}
