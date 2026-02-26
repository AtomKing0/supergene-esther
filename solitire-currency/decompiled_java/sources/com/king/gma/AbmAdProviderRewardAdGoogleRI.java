package com.king.gma;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdError;
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
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
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

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class AbmAdProviderRewardAdGoogleRI implements AbmAdProviderRewardAd, OnAdMetadataChangedListener, OnUserEarnedRewardListener {
    private String LOG_TAG;
    private Activity mActivity;
    private boolean mImmersiveMode;
    private p mListener;
    private RewardedInterstitialAd mRIAd;
    private boolean mPlayerEarnedReward = false;
    private AdProviderNameValuePairs mMetadata = new AdProviderNameValuePairs();

    class a extends n0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Runnable f17076c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Runnable runnable) {
            super(str);
            this.f17076c = runnable;
        }

        @Override // com.king.amp.sa.n0
        public void b() {
            this.f17076c.run();
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbmAdProviderRewardAdGoogleRI f17078a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdProviderNameValuePairs f17079b;

        class a implements Runnable {

            /* JADX INFO: renamed from: com.king.gma.AbmAdProviderRewardAdGoogleRI$b$a$a, reason: collision with other inner class name */
            class C0280a extends RewardedInterstitialAdLoadCallback {

                /* JADX INFO: renamed from: com.king.gma.AbmAdProviderRewardAdGoogleRI$b$a$a$a, reason: collision with other inner class name */
                class C0281a implements OnPaidEventListener {
                    C0281a() {
                    }

                    @Override // com.google.android.gms.ads.OnPaidEventListener
                    public void onPaidEvent(AdValue adValue) {
                        b.this.f17078a.onPaidEvent(new BigDecimal(adValue.getValueMicros()).movePointLeft(3).toPlainString(), adValue.getCurrencyCode(), adValue.getPrecisionType());
                    }
                }

                C0280a() {
                }

                @Override // com.google.android.gms.ads.AdLoadCallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onAdLoaded(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
                    rewardedInterstitialAd.setOnPaidEventListener(new C0281a());
                    AbmAdProviderRewardAdGoogleRI.this.mRIAd = rewardedInterstitialAd;
                    if (AbmAdProviderRewardAdGoogleRI.this.mRIAd != null) {
                        AbmAdProviderRewardAdGoogleRI.this.mRIAd.setImmersiveMode(AbmAdProviderRewardAdGoogleRI.this.mImmersiveMode);
                    }
                    Log.d(AbmAdProviderRewardAdGoogleRI.this.LOG_TAG, "AbmAdProviderRewardAdGoogleRI:onAdLoaded");
                    b.this.f17078a.onRewardedInterstitialAdLoaded();
                }

                @Override // com.google.android.gms.ads.AdLoadCallback
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    AbmAdProviderRewardAdGoogleRI.this.mRIAd = null;
                    Log.d(AbmAdProviderRewardAdGoogleRI.this.LOG_TAG, "AbmAdProviderRewardAdGoogleRI:onRewardedAdFailedToLoad | " + loadAdError.getMessage() + " | " + loadAdError.getCode());
                    b.this.f17078a.onRewardedInterstitialAdFailedToLoad(loadAdError);
                }
            }

            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AbmAdProviderRewardAdGoogleRI.this.mListener.logBreadcrumb(AbmAdProviderRewardAdGoogleRI.this.LOG_TAG, "GMA RI - Setup Request");
                AdManagerAdRequest.Builder builder = new AdManagerAdRequest.Builder();
                Bundle bundle = new Bundle();
                if (AbmAdProviderRewardAdGoogleRI.this.mActivity == null || !AbmAdProviderRewardAdGoogleRI.this.mActivity.getPreferences(0).getBoolean("abm_gma_ads_personalized", false)) {
                    bundle.putString("npa", "1");
                }
                String str = (String) b.this.f17079b.getValue("gmaFtCreativeType", "");
                if (!str.isEmpty()) {
                    bundle.putString("ft_ctype", str);
                    bundle.putString("is_test_request", com.ironsource.mediationsdk.metadata.a.f13688g);
                }
                if (!bundle.isEmpty()) {
                    builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
                }
                Object value = b.this.f17079b.getValue("targetingKeyValues");
                if (value != null) {
                    String[] strArr = (String[]) value;
                    AbmAdProviderRewardAdGoogleRI.this.mListener.logBreadcrumb("google", "add custom targeting ");
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
                AdManagerAdRequest adManagerAdRequestBuild = builder.build();
                if (AbmAdProviderRewardAdGoogleRI.this.mActivity == null) {
                    Log.d(AbmAdProviderRewardAdGoogleRI.this.LOG_TAG, "Ad Failed to Load, Activity is null");
                    b.this.f17078a.onRewardedInterstitialAdFailedToLoad(new LoadAdError(c3.a.b.f11495d, "Ad Failed to Load, Activity is null", "LoadAd", null, null));
                } else {
                    AbmAdProviderRewardAdGoogleRI.this.mListener.logBreadcrumb("External", "GMA RI - loadAd");
                    RewardedInterstitialAd.load((Context) AbmAdProviderRewardAdGoogleRI.this.mActivity, (String) b.this.f17079b.getValue("adUnitId"), adManagerAdRequestBuild, (RewardedInterstitialAdLoadCallback) new C0280a());
                }
            }
        }

        b(AbmAdProviderRewardAdGoogleRI abmAdProviderRewardAdGoogleRI, AdProviderNameValuePairs adProviderNameValuePairs) {
            this.f17078a = abmAdProviderRewardAdGoogleRI;
            this.f17079b = adProviderNameValuePairs;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17078a.run(new a());
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbmAdProviderRewardAdGoogleRI f17084a;

        class a extends FullScreenContentCallback {
            a() {
            }

            @Override // com.google.android.gms.ads.FullScreenContentCallback
            public void onAdDismissedFullScreenContent() {
                Log.i(AbmAdProviderRewardAdGoogleRI.this.LOG_TAG, "onAdDismissedFullScreenContent");
                AbmAdProviderRewardAdGoogleRI.this.mListener.logBreadcrumb(AbmAdProviderRewardAdGoogleRI.this.LOG_TAG, "GMA RI - onAdDismissedFullScreenContent");
                c.this.f17084a.onRewardedInterstitialAdClosed();
            }

            @Override // com.google.android.gms.ads.FullScreenContentCallback
            public void onAdFailedToShowFullScreenContent(AdError adError) {
                Log.e(AbmAdProviderRewardAdGoogleRI.this.LOG_TAG, "onAdFailedToShowFullScreenContent");
                AbmAdProviderRewardAdGoogleRI.this.mListener.logBreadcrumb(AbmAdProviderRewardAdGoogleRI.this.LOG_TAG, "GMA RI - onAdFailedToShowFullScreenContent");
                c.this.f17084a.onRewardedInterstitialAdFailedToShow(adError);
            }

            @Override // com.google.android.gms.ads.FullScreenContentCallback
            public void onAdShowedFullScreenContent() {
                Log.i(AbmAdProviderRewardAdGoogleRI.this.LOG_TAG, "onAdShowedFullScreenContent");
                AbmAdProviderRewardAdGoogleRI.this.mListener.logBreadcrumb(AbmAdProviderRewardAdGoogleRI.this.LOG_TAG, "GMA RI - onAdShowedFullScreenContent");
            }
        }

        c(AbmAdProviderRewardAdGoogleRI abmAdProviderRewardAdGoogleRI) {
            this.f17084a = abmAdProviderRewardAdGoogleRI;
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.i(AbmAdProviderRewardAdGoogleRI.this.LOG_TAG, "will show interstitial ads");
            try {
                AbmAdProviderRewardAdGoogleRI.this.mListener.logBreadcrumb("External", "GMA RI - show");
                AbmAdProviderRewardAdGoogleRI.this.mRIAd.setFullScreenContentCallback(new a());
                AbmAdProviderRewardAdGoogleRI.this.mRIAd.show(AbmAdProviderRewardAdGoogleRI.this.mActivity, this.f17084a);
            } catch (Throwable th) {
                Log.w(AbmAdProviderRewardAdGoogleRI.this.LOG_TAG, "failed to show interstitial ads: " + th.getMessage());
                AbmAdProviderRewardAdGoogleRI.this.mListener.logBreadcrumb(AbmAdProviderRewardAdGoogleRI.this.LOG_TAG, "GMA RI - show failed");
                this.f17084a.onRewardedInterstitialAdFailedToShow(new AdError(c3.a.b.f11495d, th.getMessage(), "ShowAd"));
            }
        }
    }

    private void addResponseInfo(ResponseInfo responseInfo, AdProviderNameValuePairs adProviderNameValuePairs) {
        String responseId = responseInfo.getResponseId();
        if (responseId != null) {
            adProviderNameValuePairs.add("adResponseId", responseId);
        }
        String mediationAdapterClassName = responseInfo.getMediationAdapterClassName();
        if (mediationAdapterClassName == null) {
            return;
        }
        adProviderNameValuePairs.add("adNetworkClassName", mediationAdapterClassName);
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
            synchronized (this) {
                if (this.mMetadata.isEmpty().booleanValue()) {
                    t1.f(this.mRIAd.getAdMetadata(), this.mMetadata);
                    ResponseInfo responseInfo = this.mRIAd.getResponseInfo();
                    if (responseInfo != null) {
                        addResponseInfo(responseInfo, this.mMetadata);
                    }
                    this.mListener.logBreadcrumb("Internal", "GMA RV - onAdMetaReceived");
                    this.mListener.onAdMetaReceived(this.mMetadata);
                }
            }
        } catch (Throwable th) {
            Log.e(this.LOG_TAG, "error in onMetadataReceived" + th.getMessage());
            this.mListener.logBreadcrumb("Internal", "GMA RV - onLoadFailed" + th.getMessage());
            this.mListener.onLoadFailed(9999, "error receiving metadata" + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPaidEvent(String str, String str2, int i10) {
        this.mListener.onPaidEvent(str, str2, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRewardedInterstitialAdClosed() {
        try {
            synchronized (this) {
                this.mListener.logBreadcrumb("Internal", "GMA RI - onClosed");
                this.mListener.onClosed(this.mPlayerEarnedReward);
                this.mPlayerEarnedReward = false;
            }
        } catch (Throwable th) {
            this.mListener.logBreadcrumb(this.LOG_TAG, "failed when closing interstitial ad session: " + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRewardedInterstitialAdFailedToLoad(@NonNull LoadAdError loadAdError) {
        try {
            synchronized (this) {
                String message = loadAdError.getMessage();
                this.mListener.logBreadcrumb("Internal", "GMA RI - onLoadFailed: " + message);
                this.mListener.onLoadFailed(loadAdError.getCode(), message);
            }
        } catch (Throwable th) {
            this.mListener.logBreadcrumb(this.LOG_TAG, "failed to load failed: " + th.getMessage());
        }
        this.mRIAd = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRewardedInterstitialAdFailedToShow(@NonNull AdError adError) {
        try {
            synchronized (this) {
                this.mListener.logBreadcrumb("Internal", "GMA RI - onShowFailed: " + adError.getMessage());
                this.mListener.onShowFailed(adError.getCode(), adError.getMessage());
            }
        } catch (Throwable th) {
            this.mListener.logBreadcrumb(this.LOG_TAG, "failed to show failed: " + th.getMessage());
        }
        this.mRIAd = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRewardedInterstitialAdLoaded() {
        this.mListener.logBreadcrumb(this.LOG_TAG, "onRewardedInterstitialAdLoaded");
        try {
            synchronized (this) {
                this.mRIAd.setOnAdMetadataChangedListener(this);
                ResponseInfo responseInfo = this.mRIAd.getResponseInfo();
                AdProviderNameValuePairs adProviderNameValuePairs = new AdProviderNameValuePairs();
                if (responseInfo != null) {
                    Log.d("Internal", "GMA RV - onAdLoaded - " + responseInfo.getResponseId() + " - " + responseInfo.getMediationAdapterClassName());
                    this.mListener.logBreadcrumb("Internal", "GMA RV - onAdLoaded - " + responseInfo.getResponseId() + " - " + responseInfo.getMediationAdapterClassName());
                    addResponseInfo(responseInfo, adProviderNameValuePairs);
                }
                this.mListener.onAdLoaded(adProviderNameValuePairs);
            }
        } catch (Throwable th) {
            Log.e(this.LOG_TAG, "error in onRewardedInterstitialAdLoaded " + th.getMessage());
            this.mListener.logBreadcrumb("Internal", "GMA RI - onLoadFailed " + th.getMessage());
            this.mListener.onLoadFailed(8888, "error loading video");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void run(Runnable runnable) {
        new a(this.LOG_TAG, runnable).a();
    }

    public void destroy() {
        this.mListener = null;
    }

    public double getDuration() {
        synchronized (this) {
            Object value = this.mMetadata.getValue("adDuration");
            if (value == null) {
                return 0.0d;
            }
            return ((Double) value).doubleValue();
        }
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public String getProperty(String str) {
        return (str.equals("isMetadataRequired") || str.equals("isPaidEventRequired")) ? "YES" : "";
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public void load(AdProviderNameValuePairs adProviderNameValuePairs) {
        synchronized (this) {
            this.mPlayerEarnedReward = false;
        }
        this.mMetadata = new AdProviderNameValuePairs();
        this.mRIAd = null;
        this.mImmersiveMode = ((String) adProviderNameValuePairs.getValue("admob_immersive_mode", "false")).equalsIgnoreCase(com.ironsource.mediationsdk.metadata.a.f13688g);
        new Thread(new b(this, adProviderNameValuePairs)).start();
    }

    @Override // com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener
    public void onAdMetadataChanged() {
        Log.d(this.LOG_TAG, "AbmAdProviderRewardAdGoogleRI:onAdMetadataChanged");
        onMetadataReceived();
    }

    @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
    public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
        this.mListener.logBreadcrumb("Internal", "GMA RI - show, reward earned");
        try {
            synchronized (this) {
                this.mPlayerEarnedReward = true;
                this.mListener.logBreadcrumb("Internal", "GMA RI - onPlayCompleted");
                this.mListener.onPlayCompleted();
            }
        } catch (Throwable th) {
            this.mListener.logBreadcrumb(this.LOG_TAG, "GMA RI - onPlayCompleted failed" + th.getMessage());
        }
        this.mRIAd = null;
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
        run(new c(this));
    }
}
