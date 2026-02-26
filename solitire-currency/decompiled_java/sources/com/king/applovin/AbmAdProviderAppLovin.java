package com.king.applovin;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.Keep;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.AppLovinSdk;
import com.google.ads.mediation.applovin.AppLovinMediationAdapter;
import com.king.amp.sa.AbmAdProviderAdapter;
import com.king.amp.sa.AbmAdProviderAdapterListener;
import com.king.amp.sa.AdProviderNameValuePairs;
import com.king.amp.sa.BidderTokenListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class AbmAdProviderAppLovin implements AbmAdProviderAdapter {
    private String TAG;
    private boolean isInitialized = false;
    private Activity mActivity;
    private AbmAdProviderAdapterListener mListener;

    public static void setLatencyFix(AdProviderNameValuePairs adProviderNameValuePairs) {
        try {
            if (adProviderNameValuePairs.getValue("enabled_feature_flags", "").toString().contains("enableAppLovinLatencyFix")) {
                Method method = AppLovinMediationAdapter.class.getMethod("enableLatencyFix", new Class[0]);
                if (method == null) {
                    throw new NoSuchMethodException("AppLovinMediationAdapter.enableLatencyFix(): no such method.");
                }
                method.invoke(null, new Object[0]);
                return;
            }
            Method method2 = AppLovinMediationAdapter.class.getMethod("disableLatencyFix", new Class[0]);
            if (method2 == null) {
                throw new NoSuchMethodException("AppLovinMediationAdapter.disableLatencyFix(): no such method.");
            }
            method2.invoke(null, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException e10) {
            Log.w("AppLovinSDK", "Trying to enable/disable AppLovin latency fix without patched mediation adapter: " + e10.getMessage());
        }
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public void collectBidderToken(BidderTokenListener bidderTokenListener) {
        bidderTokenListener.onBidderTokenCollectionFailed("We are not bidding via AppLovin, this is a bug to reach here.");
    }

    public void destroy() {
        this.mListener = null;
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public String getAdapterVersion() {
        return getProviderVersion() + ".0.0";
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public String getProviderVersion() {
        return AppLovinSdk.VERSION;
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public void initSDK(AdProviderNameValuePairs adProviderNameValuePairs) {
        if (this.isInitialized) {
            Log.d(this.TAG, "Already initialized");
            return;
        }
        Log.i(this.TAG, "Initializing AppLovin");
        setLatencyFix(adProviderNameValuePairs);
        this.isInitialized = true;
        this.mListener.onSDKInitSucceeded();
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public void setListener(AbmAdProviderAdapterListener abmAdProviderAdapterListener) {
        this.mListener = abmAdProviderAdapterListener;
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public void setLogTag(String str) {
        this.TAG = str;
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public void updateConsent(boolean z10) {
        AppLovinPrivacySettings.setHasUserConsent(z10, this.mActivity.getApplicationContext());
        AppLovinPrivacySettings.setDoNotSell(!z10, this.mActivity.getApplicationContext());
    }
}
