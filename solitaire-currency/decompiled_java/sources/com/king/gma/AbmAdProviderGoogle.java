package com.king.gma;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.applovin.mediation.AppLovinUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.ads.mediation.ironsource.IronSourceMediationAdapter;
import com.google.ads.mediation.unity.f;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.king.amp.sa.AbmAdProviderAdapter;
import com.king.amp.sa.AbmAdProviderAdapterListener;
import com.king.amp.sa.AdProviderNameValuePairs;
import com.king.amp.sa.BidderTokenListener;
import com.king.applovin.AbmAdProviderAppLovin;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class AbmAdProviderGoogle implements AbmAdProviderAdapter {
    public static Map<String, String> mediationAdapterMetadataInfo = com.king.gma.b.a(new Map.Entry[]{com.king.gma.a.a("com.google.ads.mediation.unity.UnityAdapter", "zoneId"), com.king.gma.a.a("com.google.ads.mediation.ironsource.IronSourceRewardedAdapter", "instanceId"), com.king.gma.a.a("com.vungle.mediation.VungleAdapter", "placementID"), com.king.gma.a.a("com.applovin.mediation.ApplovinAdapter", AppLovinUtils.ServerParameterKeys.ZONE_ID)});
    private Activity mActivity;
    private boolean mBiddingEnabled;
    private boolean mHybridEnabled;
    private AbmAdProviderAdapterListener mListener;
    private String TAG = "AbmAdProviderGoogle";
    private e mProviderState = e.IDLE;
    private int mMaxBidTokens = 0;
    private ExecutorService mExecutor = Executors.newSingleThreadExecutor();
    private boolean isInitialized = false;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f17059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f17060b;

        /* JADX INFO: renamed from: com.king.gma.AbmAdProviderGoogle$a$a, reason: collision with other inner class name */
        class C0279a implements OnInitializationCompleteListener {
            C0279a() {
            }

            @Override // com.google.android.gms.ads.initialization.OnInitializationCompleteListener
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
                boolean z10;
                Log.d(AbmAdProviderGoogle.this.TAG, "onInitializationComplete");
                loop0: while (true) {
                    z10 = false;
                    for (Map.Entry<String, AdapterStatus> entry : initializationStatus.getAdapterStatusMap().entrySet()) {
                        Log.i(AbmAdProviderGoogle.this.TAG, "Adapter status, " + entry.getKey() + " : " + entry.getValue().getDescription() + " : " + entry.getValue().getInitializationState());
                        if ("com.google.android.gms.ads.MobileAds".compareToIgnoreCase(entry.getKey()) == 0) {
                            if (entry.getValue().getLatency() > 0) {
                                z10 = true;
                            }
                        }
                    }
                }
                Log.d(AbmAdProviderGoogle.this.TAG, "GMA Init total time: " + (System.currentTimeMillis() - a.this.f17060b) + " ms");
                if (z10) {
                    AbmAdProviderGoogle.this.onAdmobInitializeSuccess();
                } else {
                    AbmAdProviderGoogle.this.onAdmobInitializeFailed("AdMob not initialized");
                }
            }
        }

        a(String str, long j10) {
            this.f17059a = str;
            this.f17060b = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(this.f17059a) && this.f17059a.trim().length() > 0) {
                List<String> listAsList = Arrays.asList(this.f17059a.split("\\s*,\\s*"));
                Log.d(AbmAdProviderGoogle.this.TAG, "set test devices with ids :" + listAsList);
                MobileAds.setRequestConfiguration(new RequestConfiguration.Builder().setTestDeviceIds(listAsList).build());
            }
            MobileAds.initialize(AbmAdProviderGoogle.this.mActivity.getApplicationContext(), new C0279a());
        }
    }

    class b extends QueryInfoGenerationCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f17063a;

        b(int i10) {
            this.f17063a = i10;
        }

        @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
        public void onFailure(String str) {
            AbmAdProviderGoogle.this.prepareBidderTokens(this.f17063a - 1);
        }

        @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
        public void onSuccess(QueryInfo queryInfo) {
            AbmAdProviderGoogle.this.prepareBidderTokens(this.f17063a - 1);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdRequest f17065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f17066b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ QueryInfoGenerationCallback f17067c;

        class a extends QueryInfoGenerationCallback {
            a() {
            }

            @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
            public void onFailure(String str) {
                Log.e(AbmAdProviderGoogle.this.TAG, "QueryInfo.generate failed,  " + str);
                QueryInfoGenerationCallback queryInfoGenerationCallback = c.this.f17067c;
                if (queryInfoGenerationCallback != null) {
                    queryInfoGenerationCallback.onFailure(str);
                }
            }

            @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
            public void onSuccess(QueryInfo queryInfo) {
                String query = queryInfo.getQuery();
                Log.d(AbmAdProviderGoogle.this.TAG, "Got token with length " + query.length() + ", reset flag. And it took " + (System.currentTimeMillis() - c.this.f17066b) + " ms.");
                QueryInfoGenerationCallback queryInfoGenerationCallback = c.this.f17067c;
                if (queryInfoGenerationCallback != null) {
                    queryInfoGenerationCallback.onSuccess(queryInfo);
                }
            }
        }

        c(AdRequest adRequest, long j10, QueryInfoGenerationCallback queryInfoGenerationCallback) {
            this.f17065a = adRequest;
            this.f17066b = j10;
            this.f17067c = queryInfoGenerationCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            QueryInfo.generate(AbmAdProviderGoogle.this.mActivity.getApplicationContext(), AdFormat.REWARDED, this.f17065a, new a());
        }
    }

    class d extends QueryInfoGenerationCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BidderTokenListener f17070a;

        d(BidderTokenListener bidderTokenListener) {
            this.f17070a = bidderTokenListener;
        }

        @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
        public void onFailure(@NonNull String str) {
            this.f17070a.onBidderTokenCollectionFailed(str);
        }

        @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
        public void onSuccess(@NonNull QueryInfo queryInfo) {
            this.f17070a.onBidderTokenCollected(queryInfo.getQuery());
        }
    }

    private enum e {
        IDLE,
        INITIALIZING,
        READY
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdmobInitializeFailed(String str) {
        this.mListener.logBreadcrumb(this.TAG, "Internal GMA completion handler, admob: Initialize failed: " + str);
        this.mProviderState = e.READY;
        this.mListener.onSDKInitialized(false, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdmobInitializeSuccess() {
        this.mListener.logBreadcrumb(this.TAG, "Internal GMA completion handler, admob: Initialize success");
        this.mProviderState = e.READY;
        this.mListener.onSDKInitialized(true, null);
        if (this.mBiddingEnabled) {
            Log.d(this.TAG, "Preparing Bidder Tokens");
            prepareBidderTokens(this.mMaxBidTokens);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepareBidderTokens(int i10) {
        if (!this.mBiddingEnabled) {
            Log.d(this.TAG, "prepareBidderTokens: gbid is disabled");
            return;
        }
        if (i10 <= 0) {
            Log.d(this.TAG, "Finished processing bidder tokens");
            return;
        }
        Log.d(this.TAG, "Tokens count: " + i10);
        if (isInitialized()) {
            fetchBidderToken(new b(i10));
            return;
        }
        Log.w(this.TAG, "Not initialized: " + this.mProviderState);
    }

    private boolean shouldInitMediatedProvider(String str, String str2, String str3) {
        return str.contains(str2) && !str.contains(str3);
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public void collectBidderToken(BidderTokenListener bidderTokenListener) {
        fetchBidderToken(new d(bidderTokenListener));
    }

    public void destroy() {
        this.mProviderState = e.IDLE;
        this.mListener = null;
        this.mExecutor.shutdown();
        try {
            this.mExecutor.awaitTermination(5L, TimeUnit.SECONDS);
        } catch (InterruptedException e10) {
            Log.e(this.TAG, "Wait was interrupted", e10);
            Thread.currentThread().interrupt();
        }
    }

    void fetchBidderToken(@Nullable QueryInfoGenerationCallback queryInfoGenerationCallback) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Bundle bundle = new Bundle();
        bundle.putString("query_info_type", "requester_type_2");
        bundle.putBoolean("is_hybrid_setup", this.mHybridEnabled);
        this.mExecutor.submit(new c(new AdRequest.Builder().setRequestAgent("gbid_for_inhouse").addNetworkExtrasBundle(AdMobAdapter.class, bundle).build(), jCurrentTimeMillis, queryInfoGenerationCallback));
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public String getAdapterVersion() {
        return "0.1.21.0.0.1";
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public String getProviderVersion() {
        return MobileAds.getVersion().toString();
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public void initSDK(AdProviderNameValuePairs adProviderNameValuePairs) {
        Log.d(this.TAG, "init called ( " + adProviderNameValuePairs.toString() + ")");
        String string = adProviderNameValuePairs.getValue("enabled_feature_flags", "").toString();
        if (!shouldInitMediatedProvider(string, "enableUnityAds:", "enableUnityBidding:")) {
            try {
                f.class.getMethod("disable", new Class[0]).invoke(f.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), new Object[0]);
            } catch (Exception e10) {
                Log.w(this.TAG, "trying to disable Unity adapter without patched mediation adapter: " + e10.getMessage());
            }
        }
        if (!shouldInitMediatedProvider(string, "enableVungleSDK:", "enableLiftoffBidding:")) {
            try {
                int i10 = com.google.ads.mediation.vungle.c.f8407f;
                com.google.ads.mediation.vungle.c.class.getMethod("disable", new Class[0]).invoke(com.google.ads.mediation.vungle.c.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), new Object[0]);
            } catch (Exception e11) {
                Log.w(this.TAG, "trying to disable Vungle adapter without patched mediation adapter: " + e11.getMessage());
            }
        }
        if (!shouldInitMediatedProvider(string, "enableIronSource:", "enableIronSourceBidding:")) {
            try {
                AtomicBoolean atomicBoolean = IronSourceMediationAdapter.firstLoadDone;
                IronSourceMediationAdapter.class.getMethod("disableInitialization", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception e12) {
                Log.w(this.TAG, "trying to disable IronSource adapter without patched mediation adapter: " + e12.getMessage());
            }
        }
        if (shouldInitMediatedProvider(string, "enableAppLovin:", "enableAppLovinBidding:")) {
            try {
                AbmAdProviderAppLovin.class.getMethod("setLatencyFix", AdProviderNameValuePairs.class).invoke(null, adProviderNameValuePairs);
            } catch (Exception e13) {
                Log.w(this.TAG, "trying to set latency fix on the AppLovin adapter without a specific method: " + e13.getMessage());
            }
        } else {
            try {
                int i11 = com.google.ads.mediation.applovin.d.f8263e;
                com.google.ads.mediation.applovin.d.class.getMethod("disable", new Class[0]).invoke(com.google.ads.mediation.applovin.d.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), new Object[0]);
            } catch (Exception e14) {
                Log.w(this.TAG, "trying to disable AppLovin adapter without patched mediation adapter: " + e14.getMessage());
            }
        }
        this.mHybridEnabled = adProviderNameValuePairs.getValue("google_hybrid_enabled", com.ironsource.mediationsdk.metadata.a.f13688g).equals(com.ironsource.mediationsdk.metadata.a.f13688g);
        String str = (String) adProviderNameValuePairs.getValue("google_testing_identifiers", "");
        String str2 = (String) adProviderNameValuePairs.getValue("config_key_google_test_device_id", "");
        if (TextUtils.isEmpty(str)) {
            str = str2;
        } else if (!TextUtils.isEmpty(str2)) {
            str = str + "," + str2;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str + ",B3EEABB8EE11C2BE770B684D95219ECB";
        }
        this.mBiddingEnabled = adProviderNameValuePairs.getValue("google_bidding_enabled", com.ironsource.mediationsdk.metadata.a.f13688g).equals(com.ironsource.mediationsdk.metadata.a.f13688g);
        if (this.mProviderState != e.IDLE) {
            Log.d(this.TAG, "Initializing or ready: " + this.mProviderState);
            return;
        }
        this.mProviderState = e.INITIALIZING;
        this.mExecutor.submit(new a(str, System.currentTimeMillis()));
        if (this.mBiddingEnabled) {
            return;
        }
        onAdmobInitializeSuccess();
    }

    public boolean isInitialized() {
        return this.mProviderState == e.READY;
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
        Activity activity = this.mActivity;
        if (activity != null) {
            SharedPreferences.Editor editorEdit = activity.getPreferences(0).edit();
            if (z10) {
                editorEdit.remove("gad_rdp");
            }
            editorEdit.putBoolean("abm_gma_ads_personalized", z10);
            editorEdit.apply();
        }
    }
}
