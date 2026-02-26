package com.king.moloco;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.Keep;
import com.king.amp.sa.AbmAdProviderAdapter;
import com.king.amp.sa.AbmAdProviderAdapterListener;
import com.king.amp.sa.AdProviderNameValuePairs;
import com.king.amp.sa.BidderTokenListener;
import com.moloco.sdk.BuildConfig;
import com.moloco.sdk.publisher.Initialization;
import com.moloco.sdk.publisher.MediationInfo;
import com.moloco.sdk.publisher.Moloco;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.MolocoBidTokenListener;
import com.moloco.sdk.publisher.MolocoInitStatus;
import com.moloco.sdk.publisher.MolocoInitializationListener;
import com.moloco.sdk.publisher.init.MolocoInitParams;
import com.moloco.sdk.publisher.privacy.MolocoPrivacy;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class AbmAdProviderMoloco implements AbmAdProviderAdapter {
    private static final String CONFIG_KEY_APP_KEY = "moloco_app_key";
    private String TAG;
    private Activity mActivity;
    private boolean mIsInitialized;
    private AbmAdProviderAdapterListener mListener;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$collectBidderToken$1(BidderTokenListener bidderTokenListener, String str, MolocoAdError.ErrorType errorType) {
        if (str != null) {
            Log.d(this.TAG, "Moloco SDK got bid token successfully");
            bidderTokenListener.onBidderTokenCollected(str);
            return;
        }
        Log.e(this.TAG, "Moloco SDK bid collect token failure: " + errorType.getDescription());
        bidderTokenListener.onBidderTokenCollectionFailed(errorType.getDescription());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSDK$0(MolocoInitStatus molocoInitStatus) {
        if (molocoInitStatus.getInitialization() == Initialization.SUCCESS) {
            Log.d(this.TAG, "Moloco SDK initialized");
            this.mIsInitialized = true;
            this.mListener.onSDKInitSucceeded();
        } else {
            Log.e(this.TAG, "Moloco SDK initialization failed: " + molocoInitStatus.getDescription());
            this.mListener.onSDKInitFailed(molocoInitStatus.getDescription());
        }
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public void collectBidderToken(final BidderTokenListener bidderTokenListener) {
        Moloco.getBidToken(this.mActivity, new MolocoBidTokenListener() { // from class: n6.a
            @Override // com.moloco.sdk.publisher.MolocoBidTokenListener
            public final void onBidTokenResult(String str, MolocoAdError.ErrorType errorType) {
                this.f31699a.lambda$collectBidderToken$1(bidderTokenListener, str, errorType);
            }
        });
    }

    public void destroy() {
        this.mListener = null;
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public String getAdapterVersion() {
        return String.format("%s.0", getProviderVersion());
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public String getProviderVersion() {
        return BuildConfig.SDK_VERSION_NAME;
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public void initSDK(AdProviderNameValuePairs adProviderNameValuePairs) {
        try {
            String str = (String) adProviderNameValuePairs.getValue(CONFIG_KEY_APP_KEY, "");
            if (str != null && !str.isEmpty()) {
                Moloco.initialize(new MolocoInitParams(this.mActivity, str, new MediationInfo("None")), new MolocoInitializationListener() { // from class: n6.b
                    @Override // com.moloco.sdk.publisher.MolocoInitializationListener
                    public final void onMolocoInitializationStatus(MolocoInitStatus molocoInitStatus) {
                        this.f31701a.lambda$initSDK$0(molocoInitStatus);
                    }
                });
                return;
            }
            Log.e(this.TAG, "initSDK: appKey is null or empty");
            this.mListener.onSDKInitFailed("appKey is null or empty");
        } catch (Exception e10) {
            Log.e(this.TAG, "initSDK: exception occurred initializing Moloco: " + e10.toString());
            this.mListener.onSDKInitFailed(e10.toString());
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
        MolocoPrivacy.setPrivacy(new MolocoPrivacy.PrivacySettings(Boolean.valueOf(z10), null, Boolean.valueOf(!r4.booleanValue())));
    }
}
