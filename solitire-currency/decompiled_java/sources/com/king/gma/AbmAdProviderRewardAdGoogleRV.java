package com.king.gma;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.AdapterResponseInfo;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.ironsource.c3;
import com.king.amp.sa.AbmAdProviderRewardAd;
import com.king.amp.sa.AdProviderNameValuePairs;
import com.king.amp.sa.n0;
import com.king.amp.sa.p;
import com.king.amp.sa.t1;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class AbmAdProviderRewardAdGoogleRV implements AbmAdProviderRewardAd, OnAdMetadataChangedListener, OnUserEarnedRewardListener {
    private String LOG_TAG;
    private Activity mActivity;
    private boolean mImmersiveMode;
    private p mListener;

    @NonNull
    private final AtomicReference<AdProviderNameValuePairs> mMetadata = new AtomicReference<>(new AdProviderNameValuePairs());

    @NonNull
    private final AtomicReference<RewardedAd> mRewardedAd = new AtomicReference<>();

    @NonNull
    private final AtomicBoolean mPlayCompleted = new AtomicBoolean(false);

    class a extends n0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Runnable f17087c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Runnable runnable) {
            super(str);
            this.f17087c = runnable;
        }

        @Override // com.king.amp.sa.n0
        public void b() {
            this.f17087c.run();
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f17089a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bundle f17090b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17091c;

        b(String str, Bundle bundle, String str2) {
            this.f17089a = str;
            this.f17090b = bundle;
            this.f17091c = str2;
        }

        /* JADX WARN: Can't wrap try/catch for region: R(9:10|(2:64|11)|(4:12|(1:14)(1:61)|42|43)|16|20|57|21|42|43) */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0128, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0129, code lost:
        
            android.util.Log.e(r10.f17092d.LOG_TAG, "Unable to close input." + r0.getMessage());
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 481
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.king.gma.AbmAdProviderRewardAdGoogleRV.b.run():void");
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f17093a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdRequest f17094b;

        class a extends RewardedAdLoadCallback {

            /* JADX INFO: renamed from: com.king.gma.AbmAdProviderRewardAdGoogleRV$c$a$a, reason: collision with other inner class name */
            class C0282a implements OnPaidEventListener {
                C0282a() {
                }

                @Override // com.google.android.gms.ads.OnPaidEventListener
                public void onPaidEvent(@NonNull AdValue adValue) {
                    AbmAdProviderRewardAdGoogleRV.this.mListener.onPaidEvent(new BigDecimal(adValue.getValueMicros()).movePointLeft(3).toPlainString(), adValue.getCurrencyCode(), adValue.getPrecisionType());
                }
            }

            a() {
            }

            @Override // com.google.android.gms.ads.AdLoadCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                rewardedAd.setImmersiveMode(AbmAdProviderRewardAdGoogleRV.this.mImmersiveMode);
                AbmAdProviderRewardAdGoogleRV.this.mRewardedAd.set(rewardedAd);
                rewardedAd.setOnPaidEventListener(new C0282a());
                Log.d(AbmAdProviderRewardAdGoogleRV.this.LOG_TAG, "AdProviderGMAAndroid:onRewardedAdLoaded");
                AbmAdProviderRewardAdGoogleRV.this.onRewardedVideoAdLoaded();
            }

            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                AbmAdProviderRewardAdGoogleRV.this.mRewardedAd.set(null);
                Log.e(AbmAdProviderRewardAdGoogleRV.this.LOG_TAG, "AdProviderGMAAndroid:onRewardedAdFailedToLoad | " + loadAdError.getMessage() + " | " + loadAdError.getCode());
                AbmAdProviderRewardAdGoogleRV.this.onRewardedVideoAdFailedToLoad(loadAdError);
            }
        }

        c(String str, AdRequest adRequest) {
            this.f17093a = str;
            this.f17094b = adRequest;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AbmAdProviderRewardAdGoogleRV.this.mActivity == null) {
                Log.w(AbmAdProviderRewardAdGoogleRV.this.LOG_TAG, "Unable to load rewarded Ad, activity is null");
                AbmAdProviderRewardAdGoogleRV.this.onRewardedVideoAdFailedToLoad(new AdError(c3.a.b.f11495d, "Ad Failed to Load, activity is null", "LoadAd"));
                return;
            }
            AbmAdProviderRewardAdGoogleRV.this.mListener.logBreadcrumb("External", "GMA RV - loadAd");
            Log.d(AbmAdProviderRewardAdGoogleRV.this.LOG_TAG, "Unit: " + this.f17093a + ", test device? " + this.f17094b.isTestDevice(AbmAdProviderRewardAdGoogleRV.this.mActivity.getApplicationContext()) + ", content url: " + this.f17094b.getContentUrl());
            RewardedAd.load(AbmAdProviderRewardAdGoogleRV.this.mActivity, this.f17093a, this.f17094b, new a());
        }
    }

    class d implements Runnable {

        class a extends FullScreenContentCallback {
            a() {
            }

            @Override // com.google.android.gms.ads.FullScreenContentCallback
            public void onAdDismissedFullScreenContent() {
                AbmAdProviderRewardAdGoogleRV.this.mRewardedAd.set(null);
                Log.d(AbmAdProviderRewardAdGoogleRV.this.LOG_TAG, "AdProviderGMAAndroid:onRewardedAdClosed");
                AbmAdProviderRewardAdGoogleRV.this.onRewardedVideoAdClosed();
            }

            @Override // com.google.android.gms.ads.FullScreenContentCallback
            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                Log.d(AbmAdProviderRewardAdGoogleRV.this.LOG_TAG, "AdProviderGMAAndroid:onRewardedAdFailedToShow");
                AbmAdProviderRewardAdGoogleRV.this.onRewardedVideoAdFailedToShow(adError);
            }

            @Override // com.google.android.gms.ads.FullScreenContentCallback
            public void onAdShowedFullScreenContent() {
                Log.d(AbmAdProviderRewardAdGoogleRV.this.LOG_TAG, "AdProviderGMAAndroid:onRewardedAdOpened");
            }
        }

        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardedAd rewardedAd = (RewardedAd) AbmAdProviderRewardAdGoogleRV.this.mRewardedAd.get();
            if (rewardedAd == null) {
                Log.e(AbmAdProviderRewardAdGoogleRV.this.LOG_TAG, "Unable to show, rewarded ad is null");
                AbmAdProviderRewardAdGoogleRV.this.onRewardedVideoAdFailedToShow(new AdError(c3.a.b.f11495d, "Ad Failed to Show, rewarded ad is null", "ShowAd"));
            } else {
                rewardedAd.setFullScreenContentCallback(new a());
                AbmAdProviderRewardAdGoogleRV.this.mListener.logBreadcrumb("Internal", "GMA RV - show");
                rewardedAd.show(AbmAdProviderRewardAdGoogleRV.this.mActivity, AbmAdProviderRewardAdGoogleRV.this);
            }
        }
    }

    private void addResponseInfo(ResponseInfo responseInfo, AdProviderNameValuePairs adProviderNameValuePairs) {
        Bundle credentials;
        String responseId = responseInfo.getResponseId();
        if (responseId != null) {
            adProviderNameValuePairs.add("adResponseId", responseId);
        }
        String mediationAdapterClassName = responseInfo.getMediationAdapterClassName();
        if (mediationAdapterClassName == null) {
            return;
        }
        adProviderNameValuePairs.add("adNetworkClassName", mediationAdapterClassName);
        AdapterResponseInfo loadedAdapterResponseInfo = responseInfo.getLoadedAdapterResponseInfo();
        if (loadedAdapterResponseInfo != null && (credentials = loadedAdapterResponseInfo.getCredentials()) != null) {
            String string = credentials.getString("campaign_type");
            String string2 = credentials.getString("campaign_id");
            if (string != null) {
                adProviderNameValuePairs.add("campaign_type", string);
            }
            if (string2 != null) {
                adProviderNameValuePairs.add("campaign_id", string2);
            }
        }
        for (Map.Entry<String, String> entry : AbmAdProviderGoogle.mediationAdapterMetadataInfo.entrySet()) {
            if (isMediationAdapter(responseInfo, entry.getKey()).booleanValue()) {
                getMediationAdapterResponse(adProviderNameValuePairs, responseInfo.getAdapterResponses(), entry.getValue());
            }
        }
    }

    private void getMediationAdapterResponse(AdProviderNameValuePairs adProviderNameValuePairs, List<AdapterResponseInfo> list, String str) {
        String string;
        if (list == null) {
            return;
        }
        Iterator<AdapterResponseInfo> it = list.iterator();
        while (it.hasNext()) {
            Bundle credentials = it.next().getCredentials();
            if (credentials != null && (string = credentials.getString(str)) != null && string.length() > 0) {
                adProviderNameValuePairs.add("adMediationPlacement", string);
            }
        }
    }

    private Boolean isMediationAdapter(ResponseInfo responseInfo, String str) {
        return Boolean.valueOf(str.equals(responseInfo.getMediationAdapterClassName()));
    }

    private void onMetadataReceived() {
        this.mListener.logBreadcrumb(this.LOG_TAG, "onMetadataReceived");
        try {
            AdProviderNameValuePairs adProviderNameValuePairs = this.mMetadata.get();
            if (adProviderNameValuePairs.isEmpty().booleanValue()) {
                RewardedAd rewardedAd = this.mRewardedAd.get();
                if (rewardedAd == null) {
                    Log.e(this.LOG_TAG, "Failed to update metadata, reward ad is not set");
                    return;
                }
                t1.f(rewardedAd.getAdMetadata(), adProviderNameValuePairs);
                ResponseInfo responseInfo = rewardedAd.getResponseInfo();
                if (responseInfo != null) {
                    addResponseInfo(responseInfo, adProviderNameValuePairs);
                }
                this.mMetadata.set(adProviderNameValuePairs);
                this.mListener.logBreadcrumb("Internal", "GMA RV - onAdMetaReceived");
                this.mListener.onAdMetaReceived(this.mMetadata.get());
            }
        } catch (Throwable unused) {
            Log.e(this.LOG_TAG, "error in onMetadataReceived");
            this.mRewardedAd.set(null);
            this.mListener.logBreadcrumb("Internal", "GMA RV - onLoadFailed error receiving metadata");
            this.mListener.onLoadFailed(9999, "error receiving metadata");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRewardedVideoAdClosed() {
        try {
            this.mListener.logBreadcrumb("Internal", "GMA RV - onClosed");
            this.mListener.onClosed(this.mPlayCompleted.get());
        } catch (Throwable th) {
            this.mListener.logBreadcrumb(this.LOG_TAG, "video ad closed failed: " + th.getMessage());
        }
        this.mRewardedAd.set(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRewardedVideoAdFailedToLoad(@NonNull AdError adError) {
        try {
            String message = adError.getMessage();
            this.mListener.logBreadcrumb("Internal", "GMA RV - load onLoadFailed: " + message);
            this.mListener.onLoadFailed(adError.getCode(), message);
        } catch (Throwable th) {
            this.mListener.logBreadcrumb(this.LOG_TAG, "failed to load failed: " + th.getMessage());
        }
        this.mRewardedAd.set(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRewardedVideoAdFailedToShow(@NonNull AdError adError) {
        try {
            this.mListener.logBreadcrumb("Internal", "GMA RV - show onShowFailed: " + adError.getMessage());
            this.mListener.onShowFailed(adError.getCode(), adError.getMessage());
        } catch (Throwable th) {
            this.mListener.logBreadcrumb(this.LOG_TAG, "failed to show failed: " + th.getMessage());
        }
        this.mRewardedAd.set(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRewardedVideoAdLoaded() {
        this.mListener.logBreadcrumb(this.LOG_TAG, "onRewardedVideoAdLoaded");
        try {
            RewardedAd rewardedAd = this.mRewardedAd.get();
            rewardedAd.setOnAdMetadataChangedListener(this);
            AdProviderNameValuePairs adProviderNameValuePairs = new AdProviderNameValuePairs();
            ResponseInfo responseInfo = rewardedAd.getResponseInfo();
            if (responseInfo != null) {
                Log.d("Internal", "GMA RV - onAdLoaded - " + responseInfo.getResponseId() + " - " + responseInfo.getMediationAdapterClassName());
                this.mListener.logBreadcrumb("Internal", "GMA RV - onAdLoaded - " + responseInfo.getResponseId() + " - " + responseInfo.getMediationAdapterClassName());
                addResponseInfo(responseInfo, adProviderNameValuePairs);
            }
            this.mListener.onAdLoaded(adProviderNameValuePairs);
        } catch (Throwable th) {
            Log.e(this.LOG_TAG, "error in onRewardedVideoAdLoaded, " + th.getMessage());
            this.mListener.logBreadcrumb("Internal", "GMA RV - onLoadFailed");
            this.mRewardedAd.set(null);
            this.mListener.onLoadFailed(8888, "error loading video");
        }
    }

    private void onRewardedVideoCompleted() {
        this.mPlayCompleted.set(true);
        try {
            this.mListener.logBreadcrumb("Internal", "GMA RV - onPlayCompleted");
            this.mListener.onPlayCompleted();
        } catch (Throwable th) {
            this.mListener.logBreadcrumb(this.LOG_TAG, "play completed failed: " + th.getMessage());
        }
    }

    public void destroy() {
        this.mRewardedAd.set(null);
        this.mListener = null;
    }

    public double getDuration() {
        Object value = this.mMetadata.get().getValue("adDuration");
        if (value == null) {
            return 0.0d;
        }
        return ((Double) value).doubleValue();
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public String getProperty(String str) {
        return (str.equals("isMetadataRequired") || str.equals("isPaidEventRequired")) ? "YES" : "";
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public void load(AdProviderNameValuePairs adProviderNameValuePairs) {
        synchronized (this) {
            this.mPlayCompleted.set(false);
        }
        this.mMetadata.get().clear();
        this.mRewardedAd.set(null);
        Bundle bundle = new Bundle();
        String str = (String) adProviderNameValuePairs.getValue("adUnitId", "");
        String str2 = (String) adProviderNameValuePairs.getValue("admob_request_id", "");
        boolean zEquals = ((String) adProviderNameValuePairs.getValue("admob_is_hybrid", com.ironsource.mediationsdk.metadata.a.f13688g)).equals(com.ironsource.mediationsdk.metadata.a.f13688g);
        String str3 = (String) adProviderNameValuePairs.getValue("admob_bid_url", "");
        String str4 = (String) adProviderNameValuePairs.getValue("gmaFtCreativeType", "");
        String[] strArr = (String[]) adProviderNameValuePairs.getValue("targetingKeyValues");
        this.mImmersiveMode = ((String) adProviderNameValuePairs.getValue("admob_immersive_mode", "false")).equalsIgnoreCase(com.ironsource.mediationsdk.metadata.a.f13688g);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString("placement_req_id", str2);
            bundle.putBoolean("is_hybrid_setup", zEquals);
        }
        if (!TextUtils.isEmpty(str3)) {
            loadGAD(str, str3, bundle);
            return;
        }
        Activity activity = this.mActivity;
        if (activity == null || !activity.getPreferences(0).getBoolean("abm_gma_ads_personalized", false)) {
            bundle.putString("npa", "1");
        }
        if (!str4.isEmpty()) {
            bundle.putString("ft_ctype", str4);
            bundle.putString("is_test_request", com.ironsource.mediationsdk.metadata.a.f13688g);
        }
        loadGAM(str, strArr, bundle);
    }

    public void loadGAD(String str, String str2, @NonNull Bundle bundle) {
        new Thread(new b(str2, bundle, str), str).start();
    }

    public void loadGAM(String str, String[] strArr, @NonNull Bundle bundle) {
        this.mListener.logBreadcrumb(this.LOG_TAG, "GMA RV - Setup Request");
        AdManagerAdRequest.Builder builder = new AdManagerAdRequest.Builder();
        if (!bundle.isEmpty()) {
            builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        }
        if (strArr.length > 0) {
            this.mListener.logBreadcrumb(this.LOG_TAG, "add custom targeting");
            int i10 = 0;
            while (true) {
                int i11 = i10 + 1;
                if (i11 >= strArr.length) {
                    break;
                }
                if (strArr[i11].length() <= 0 || strArr[i11].charAt(0) != '|') {
                    builder.addCustomTargeting(strArr[i10], strArr[i11]);
                } else {
                    builder.addCustomTargeting(strArr[i10], Arrays.asList(strArr[i11].substring(1).split("\\|")));
                }
                i10 += 2;
            }
        }
        loadRewardedAd(str, builder.build());
    }

    public void loadRewardedAd(@NonNull String str, @NonNull AdRequest adRequest) {
        if (this.mActivity == null) {
            onRewardedVideoAdFailedToLoad(new AdError(c3.a.b.f11495d, "Ad Failed to Load, activity is invalid", "LoadAd"));
            Log.w(this.LOG_TAG, "Unable to load rewarded Ad, activity is invalid");
            return;
        }
        runOnMainThread(str + "_load", new c(str, adRequest));
    }

    @Override // com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener
    public void onAdMetadataChanged() {
        Log.d(this.LOG_TAG, "AdProviderGMAAndroid:onAdMetadataChanged");
        onMetadataReceived();
    }

    @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
    public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
        Log.d(this.LOG_TAG, "AbmAdProviderRewardAdGoogleRV:onUserEarnedReward");
        onRewardedVideoCompleted();
    }

    public void runOnMainThread(@NonNull String str, Runnable runnable) {
        new a(str, runnable).a();
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public void setListener(p pVar) {
        this.mListener = pVar;
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public void setLogTag(String str) {
        this.LOG_TAG = "ads_provider_" + str;
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public void show() {
        if (this.mRewardedAd.get() == null) {
            Log.e(this.LOG_TAG, "Unable to show, rewarded ad is invalid");
            onRewardedVideoAdFailedToShow(new AdError(c3.a.b.f11495d, "Ad Failed to Show, rewarded ad is invalid", "ShowAd"));
            return;
        }
        runOnMainThread(this.mRewardedAd.get().getAdUnitId() + "_show", new d());
    }
}
