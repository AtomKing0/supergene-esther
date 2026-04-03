package com.king.vungle;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.Keep;
import com.king.amp.sa.AbmAdProviderAdapter;
import com.king.amp.sa.AbmAdProviderAdapterListener;
import com.king.amp.sa.AdProviderNameValuePairs;
import com.king.amp.sa.BidderTokenListener;
import com.vungle.ads.VungleAds;
import com.vungle.ads.b2;
import com.vungle.ads.c2;
import com.vungle.ads.l0;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class AbmAdProviderVungle implements AbmAdProviderAdapter {
    private Activity mActivity;
    private AbmAdProviderAdapterListener mListener;
    private String TAG = "AbmAdProviderVungle";
    private boolean mInitInProgress = false;
    private boolean mInitialized = false;

    class a implements l0 {
        a() {
        }

        @Override // com.vungle.ads.l0
        public void onError(b2 b2Var) {
            AbmAdProviderVungle.this.mInitInProgress = false;
            String str = "Liftoff Ads SDK init Failed:" + b2Var.getErrorMessage();
            Log.e(AbmAdProviderVungle.this.TAG, str);
            AbmAdProviderVungle.this.mListener.onSDKInitFailed(str);
        }

        @Override // com.vungle.ads.l0
        public void onSuccess() {
            AbmAdProviderVungle.this.mInitInProgress = false;
            AbmAdProviderVungle.this.mInitialized = true;
            Log.d(AbmAdProviderVungle.this.TAG, "Vungle SDK init onSuccess()");
            AbmAdProviderVungle.this.mListener.onSDKInitSucceeded();
        }
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public void collectBidderToken(BidderTokenListener bidderTokenListener) {
        String biddingToken = VungleAds.getBiddingToken(this.mActivity.getApplicationContext());
        if (biddingToken != null) {
            bidderTokenListener.onBidderTokenCollected(biddingToken);
        } else {
            bidderTokenListener.onBidderTokenCollectionFailed("Vungle returned a null bidder token");
        }
    }

    public void destroy() {
        this.mListener = null;
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public String getAdapterVersion() {
        try {
            return VungleAds.getSdkVersion() + ".0";
        } catch (Exception e10) {
            Log.e(this.TAG, "exception in getAdapterVersion ", e10);
            return "";
        }
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public String getProviderVersion() {
        try {
            return VungleAds.getSdkVersion();
        } catch (Exception e10) {
            Log.e(this.TAG, "exception in getProviderVersion ", e10);
            return "";
        }
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public void initSDK(AdProviderNameValuePairs adProviderNameValuePairs) {
        String str = (String) adProviderNameValuePairs.getValue("liftoff_game_id", "");
        String str2 = (String) adProviderNameValuePairs.getValue("liftoff_integration_version", "");
        if (str.isEmpty() || str2.isEmpty()) {
            this.mListener.onSDKInitialized(false, String.format("Skipping Liftoff Init: liftoff_game_id (%s) or liftoff_integration_version (%s) is empty", str, str2));
            return;
        }
        if (VungleAds.isInitialized()) {
            if (this.mInitialized) {
                Log.d(this.TAG, "Already initialized");
                return;
            }
            Log.d(this.TAG, "Vungle SDK init by Google onSuccess()");
            this.mInitialized = true;
            VungleAds.setIntegrationName(VungleAds.WrapperFramework.vunglehbs, str2);
            this.mListener.onSDKInitSucceeded();
            return;
        }
        if (this.mInitInProgress) {
            return;
        }
        this.mInitInProgress = true;
        Log.d(this.TAG, "init called with game id:" + str + " integration version:" + str2);
        VungleAds.setIntegrationName(VungleAds.WrapperFramework.vunglehbs, str2);
        VungleAds.init(this.mActivity.getApplicationContext(), str, new a());
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
        c2.setCCPAStatus(z10);
        c2.setGDPRStatus(z10, "1.0.0");
    }
}
