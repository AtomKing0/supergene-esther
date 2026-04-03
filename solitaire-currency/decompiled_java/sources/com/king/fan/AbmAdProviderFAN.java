package com.king.fan;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.Keep;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.BidderTokenProvider;
import com.facebook.ads.internal.settings.AdSdkVersion;
import com.king.amp.sa.AbmAdProviderAdapter;
import com.king.amp.sa.AbmAdProviderAdapterListener;
import com.king.amp.sa.AdProviderNameValuePairs;
import com.king.amp.sa.BidderTokenListener;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class AbmAdProviderFAN implements AbmAdProviderAdapter {
    static boolean isInitializing = false;
    private static String mBidderToken;
    private String TAG;
    private boolean isInitialized = false;
    private Activity mActivity;
    private AbmAdProviderAdapterListener mListener;

    class a implements Runnable {

        /* JADX INFO: renamed from: com.king.fan.AbmAdProviderFAN$a$a, reason: collision with other inner class name */
        class C0278a implements AudienceNetworkAds.InitListener {
            C0278a() {
            }

            @Override // com.facebook.ads.AudienceNetworkAds.InitListener
            public void onInitialized(AudienceNetworkAds.InitResult initResult) {
                Log.d(AbmAdProviderFAN.this.TAG, "onInitialized");
                AbmAdProviderFAN.isInitializing = false;
                AbmAdProviderFAN.this.isInitialized = initResult.isSuccess();
                AbmAdProviderFAN.this.mListener.onSDKInitialized(initResult.isSuccess(), initResult.isSuccess() ? "" : initResult.getMessage());
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (AudienceNetworkAds.isInitialized(AbmAdProviderFAN.this.mActivity.getApplicationContext())) {
                    Log.d(AbmAdProviderFAN.this.TAG, "onInitialized");
                    AbmAdProviderFAN.isInitializing = false;
                    AbmAdProviderFAN.this.mListener.onSDKInitSucceeded();
                } else {
                    Log.d(AbmAdProviderFAN.this.TAG, "AudienceNetworkInitializeHelper: Initialize() called");
                    AudienceNetworkAds.buildInitSettings(AbmAdProviderFAN.this.mActivity.getApplicationContext()).withInitListener(new C0278a()).initialize();
                    try {
                        AbmAdProviderFAN.mBidderToken = BidderTokenProvider.getBidderToken(AbmAdProviderFAN.this.mActivity.getApplicationContext());
                    } catch (Exception e10) {
                        Log.w(AbmAdProviderFAN.this.TAG, "Unable to get bidder token from FAN: " + e10.toString());
                    }
                }
            } catch (Exception e11) {
                Log.e(AbmAdProviderFAN.this.TAG, "Exception in AudienceNetworkAds.initialize ", e11);
                AbmAdProviderFAN.isInitializing = false;
                AbmAdProviderFAN.this.mListener.onSDKInitFailed(e11.toString());
            }
        }
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public void collectBidderToken(BidderTokenListener bidderTokenListener) {
        String str = mBidderToken;
        if (str != null) {
            bidderTokenListener.onBidderTokenCollected(str);
        } else {
            bidderTokenListener.onBidderTokenCollectionFailed("FAN returned a null bidder token");
        }
    }

    public void destroy() {
        this.mListener = null;
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public String getAdapterVersion() {
        return "0.1.6.8.0.1";
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public String getProviderVersion() {
        return AdSdkVersion.BUILD;
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public void initSDK(AdProviderNameValuePairs adProviderNameValuePairs) {
        String str = (String) adProviderNameValuePairs.getValue("appKey", "");
        Log.d(this.TAG, "init called with appKey:" + str);
        if (this.isInitialized) {
            Log.d(this.TAG, "Already initialized");
        } else if (isInitializing) {
            Log.d(this.TAG, "initializing...");
        } else {
            isInitializing = true;
            new Thread(new a()).start();
        }
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
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("LDU is set as ");
        sb.append(!z10);
        Log.d(str, sb.toString());
        if (z10) {
            AdSettings.setDataProcessingOptions(new String[0]);
        } else {
            AdSettings.setDataProcessingOptions(new String[]{"LDU"}, 0, 0);
        }
    }
}
