package com.king.adprovider.sa;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.Keep;
import com.king.amp.sa.AbmAdProviderRewardAd;
import com.king.amp.sa.AdProviderNameValuePairs;
import com.king.amp.sa.Logging;
import com.king.amp.sa.p;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class AdProviderModuleAndroid implements p {
    private final String LOG_TAG;
    private long mAdProviderAddress;
    private AbmAdProviderRewardAd mImpl;
    private boolean mPlayCompleted = false;
    private String mProviderClassName;

    public AdProviderModuleAndroid(String str, String str2, Activity activity) {
        this.LOG_TAG = "ads_provider_" + str;
        this.mProviderClassName = str2;
        try {
            AbmAdProviderRewardAd abmAdProviderRewardAd = (AbmAdProviderRewardAd) AbmAdProviderRewardAd.class.cast(Class.forName(str2).getConstructor(new Class[0]).newInstance(new Object[0]));
            this.mImpl = abmAdProviderRewardAd;
            abmAdProviderRewardAd.setLogTag(str);
            this.mImpl.setActivity(activity);
            this.mImpl.setListener(this);
        } catch (Exception e10) {
            Log.d(this.LOG_TAG, "AdProviderModuleAndroid: the provider adapter is not available : " + e10);
        }
    }

    public static native void logBreadcrumbx(String str, String str2);

    public static native void onAdLoaded(long j10, AdProviderNameValuePairs adProviderNameValuePairs);

    public static native void onAdMetaReceived(long j10, AdProviderNameValuePairs adProviderNameValuePairs);

    public static native void onClosed(long j10, boolean z10);

    public static native void onEndCardInfoClicked(long j10);

    public static native void onError(long j10, int i10, String str);

    public static native void onLoadFailed(long j10, int i10, String str);

    public static native void onPaidEvent(long j10, String str, String str2, int i10);

    public static native void onPlayCompleted(long j10);

    public static native void onShowFailed(long j10, int i10, String str);

    public boolean IsMetadataRequired() {
        return this.mImpl.getProperty("isMetadataRequired") == "YES";
    }

    public boolean IsPaidEventRequired() {
        return this.mImpl.getProperty("isPaidEventRequired") == "YES";
    }

    public void load(long j10, String[] strArr, String[] strArr2) {
        this.mAdProviderAddress = j10;
        int i10 = 0;
        if (this.mImpl == null) {
            onError(j10, 0, this.mProviderClassName + " is not instantiated, please check if it's included.");
            return;
        }
        AdProviderNameValuePairs adProviderNameValuePairs = new AdProviderNameValuePairs();
        while (true) {
            int i11 = i10 + 1;
            if (i11 >= strArr.length) {
                adProviderNameValuePairs.add("targetingKeyValues", strArr2);
                this.mImpl.load(adProviderNameValuePairs);
                return;
            } else {
                if (!strArr[i11].isEmpty()) {
                    adProviderNameValuePairs.add(strArr[i10], strArr[i11]);
                }
                i10 += 2;
            }
        }
    }

    @Override // com.king.amp.sa.p
    public void logBreadcrumb(String str, String str2) {
        Logging.logBreadcrumb(str, str2);
    }

    @Override // com.king.amp.sa.p
    public void onAdLoaded(AdProviderNameValuePairs adProviderNameValuePairs) {
        Log.d(this.LOG_TAG, "AdProviderModuleAndroid: onAdLoaded : " + adProviderNameValuePairs.toString());
        synchronized (this) {
            onAdLoaded(this.mAdProviderAddress, adProviderNameValuePairs);
        }
    }

    @Override // com.king.amp.sa.p
    public void onAdMetaReceived(AdProviderNameValuePairs adProviderNameValuePairs) {
        Log.d(this.LOG_TAG, "AdProviderModuleAndroid: onAdMetaReceived : " + adProviderNameValuePairs.toString());
        synchronized (this) {
            onAdMetaReceived(this.mAdProviderAddress, adProviderNameValuePairs);
        }
    }

    @Override // com.king.amp.sa.p
    public void onClosed(boolean z10) {
        Log.d(this.LOG_TAG, "AdProviderModuleAndroid: onClosed : " + z10);
        synchronized (this) {
            onClosed(this.mAdProviderAddress, z10);
        }
    }

    @Override // com.king.amp.sa.p
    public void onEndCardInfoClicked() {
        Log.d(this.LOG_TAG, "AdProviderModuleAndroid: EndCardInfoClicked : ");
        synchronized (this) {
            onEndCardInfoClicked(this.mAdProviderAddress);
        }
    }

    public void onError(int i10, String str) {
        Log.d(this.LOG_TAG, "AdProviderModuleAndroid: onError : " + str);
        synchronized (this) {
            onError(this.mAdProviderAddress, i10, str);
        }
    }

    @Override // com.king.amp.sa.p
    public void onLoadFailed(int i10, String str) {
        Log.d(this.LOG_TAG, "AdProviderModuleAndroid: onLoadFailed : " + str);
        synchronized (this) {
            onLoadFailed(this.mAdProviderAddress, i10, str);
        }
    }

    @Override // com.king.amp.sa.p
    public void onPaidEvent(String str, String str2, int i10) {
        Log.d(this.LOG_TAG, "AdProviderModuleAndroid: onPaidEvent : ");
        synchronized (this) {
            onPaidEvent(this.mAdProviderAddress, str, str2, i10);
        }
    }

    @Override // com.king.amp.sa.p
    public void onPlayCompleted() {
        Log.d(this.LOG_TAG, "AdProviderModuleAndroid: onPlayCompleted : ");
        synchronized (this) {
            onPlayCompleted(this.mAdProviderAddress);
        }
    }

    @Override // com.king.amp.sa.p
    public void onShowFailed(int i10, String str) {
        Log.d(this.LOG_TAG, "AdProviderModuleAndroid: onShowFailed : " + str);
        synchronized (this) {
            onShowFailed(this.mAdProviderAddress, i10, str);
        }
    }

    public void resetPointerToAdProviderAddress() {
        synchronized (this) {
            Logging.logBreadcrumb(this.LOG_TAG, "reset address");
            this.mAdProviderAddress = 0L;
            this.mImpl = null;
        }
    }

    public void show() {
        Log.d(this.LOG_TAG, "AdProviderModuleAndroid: show ad ");
        AbmAdProviderRewardAd abmAdProviderRewardAd = this.mImpl;
        if (abmAdProviderRewardAd != null) {
            abmAdProviderRewardAd.show();
            return;
        }
        onError(this.mAdProviderAddress, 0, this.mProviderClassName + " is not instantiated, please check if it's included.");
    }
}
