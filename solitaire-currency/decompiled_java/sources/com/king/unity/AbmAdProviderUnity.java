package com.king.unity;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.Keep;
import com.king.amp.sa.AbmAdProviderAdapter;
import com.king.amp.sa.AbmAdProviderAdapterListener;
import com.king.amp.sa.AdProviderNameValuePairs;
import com.king.amp.sa.BidderTokenListener;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.IUnityAdsTokenListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.metadata.MetaData;
import org.json.JSONException;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class AbmAdProviderUnity implements AbmAdProviderAdapter, IUnityAdsInitializationListener {
    private Activity mActivity;
    private AbmAdProviderAdapterListener mListener;
    private int mMaxTokenNum;
    private String TAG = "AbmAdProviderUnity";
    private boolean mInitStarted = false;
    private boolean mTestModeEnabled = false;
    private boolean isInitialized = false;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BidderTokenListener f17168a;

        /* JADX INFO: renamed from: com.king.unity.AbmAdProviderUnity$a$a, reason: collision with other inner class name */
        class C0283a implements IUnityAdsTokenListener {
            C0283a() {
            }

            @Override // com.unity3d.ads.IUnityAdsTokenListener
            public void onUnityAdsTokenReady(String str) {
                if (str != null) {
                    a.this.f17168a.onBidderTokenCollected(str);
                } else {
                    a.this.f17168a.onBidderTokenCollectionFailed("Unity returned a null bidder token");
                }
            }
        }

        a(BidderTokenListener bidderTokenListener) {
            this.f17168a = bidderTokenListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            UnityAds.getToken(new C0283a());
        }
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public void collectBidderToken(BidderTokenListener bidderTokenListener) {
        new Thread(new a(bidderTokenListener)).start();
    }

    public void destroy() {
        this.mListener = null;
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public String getAdapterVersion() {
        return "0.1.4.0.1.1";
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public String getProviderVersion() {
        try {
            return UnityAds.getVersion();
        } catch (Exception e10) {
            Log.e(this.TAG, "exception in getVersion ", e10);
            return "";
        }
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public void initSDK(AdProviderNameValuePairs adProviderNameValuePairs) {
        Log.i(this.TAG, "start print config:");
        for (int numEntries = adProviderNameValuePairs.getNumEntries() - 1; numEntries >= 0; numEntries += -1) {
            String keyAtIndex = adProviderNameValuePairs.getKeyAtIndex(numEntries);
            Object value = adProviderNameValuePairs.getValue(keyAtIndex);
            Log.e(this.TAG, keyAtIndex + " " + value.toString());
        }
        if (this.isInitialized) {
            Log.d(this.TAG, "Already initialized");
            return;
        }
        String str = (String) adProviderNameValuePairs.getValue("unityGameId", "");
        String str2 = (String) adProviderNameValuePairs.getValue("unity_max_token_num", "10");
        String str3 = (String) adProviderNameValuePairs.getValue("test_mode", "false");
        this.mMaxTokenNum = Integer.parseInt(str2);
        this.mTestModeEnabled = str3.equals(com.ironsource.mediationsdk.metadata.a.f13688g);
        UnityAds.initialize(this.mActivity.getApplicationContext(), str, this.mTestModeEnabled, this);
        this.mInitStarted = true;
    }

    @Override // com.unity3d.ads.IUnityAdsInitializationListener
    public void onInitializationComplete() {
        Log.d(this.TAG, "Unity Ads SDK onInitializationComplete");
        this.mListener.onSDKInitSucceeded();
    }

    @Override // com.unity3d.ads.IUnityAdsInitializationListener
    public void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str) {
        Log.e(this.TAG, "Unity Ads SDK onInitializationFailed:" + str);
        this.mListener.onSDKInitFailed(str);
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
    public void updateConsent(boolean z10) throws JSONException {
        MetaData metaData = new MetaData(this.mActivity.getApplicationContext());
        if (z10) {
            Boolean bool = Boolean.TRUE;
            metaData.set("privacy.consent", bool);
            metaData.set("gdpr.consent", bool);
        } else {
            Boolean bool2 = Boolean.FALSE;
            metaData.set("privacy.consent", bool2);
            metaData.set("gdpr.consent", bool2);
        }
        metaData.commit();
    }
}
