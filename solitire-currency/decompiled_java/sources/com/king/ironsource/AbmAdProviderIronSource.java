package com.king.ironsource;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.king.amp.sa.AbmAdProviderAdapter;
import com.king.amp.sa.AbmAdProviderAdapterListener;
import com.king.amp.sa.AdProviderNameValuePairs;
import com.king.amp.sa.BidderTokenListener;
import com.unity3d.ironsourceads.InitListener;
import com.unity3d.ironsourceads.InitRequest;
import com.unity3d.ironsourceads.IronSourceAds;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class AbmAdProviderIronSource implements AbmAdProviderAdapter {
    private static final String CONFIG_KEY_APP_KEY = "ironsource_app_key";
    private String TAG;
    private boolean isInitialized = false;
    private Activity mActivity;
    private AbmAdProviderAdapterListener mListener;

    class a implements InitListener {
        a() {
        }

        @Override // com.unity3d.ironsourceads.InitListener
        public void onInitFailed(IronSourceError ironSourceError) {
            AbmAdProviderIronSource.this.mListener.onSDKInitFailed(ironSourceError.getErrorMessage());
        }

        @Override // com.unity3d.ironsourceads.InitListener
        public void onInitSuccess() {
            AbmAdProviderIronSource.this.isInitialized = true;
            AbmAdProviderIronSource.this.mListener.onSDKInitSucceeded();
        }
    }

    private void registerActivityLifecycleHooks() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.mActivity.registerActivityLifecycleCallbacks(new b());
        }
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public void collectBidderToken(BidderTokenListener bidderTokenListener) {
        String iSDemandOnlyBiddingData = IronSource.getISDemandOnlyBiddingData(this.mActivity);
        if (iSDemandOnlyBiddingData != null) {
            bidderTokenListener.onBidderTokenCollected(iSDemandOnlyBiddingData);
        } else {
            bidderTokenListener.onBidderTokenCollectionFailed("IronSource returned a null bidder token");
        }
    }

    public void destroy() {
        this.mListener = null;
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public String getAdapterVersion() {
        return "0.1.7.2.3.1.1";
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public String getProviderVersion() {
        try {
            return IronSourceUtils.getSDKVersion();
        } catch (Exception e10) {
            Log.e(this.TAG, "exception in getVersion ", e10);
            return "";
        }
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapter
    public void initSDK(AdProviderNameValuePairs adProviderNameValuePairs) {
        try {
            String str = (String) adProviderNameValuePairs.getValue(CONFIG_KEY_APP_KEY, "");
            if (str != null && !str.isEmpty()) {
                registerActivityLifecycleHooks();
                IronSourceAds.init(this.mActivity, new InitRequest.Builder(str).withLegacyAdFormats(new ArrayList(Arrays.asList(IronSourceAds.AdFormat.REWARDED))).build(), new a());
                return;
            }
            Log.e(this.TAG, "initSDK: appKey is null or empty");
            this.mListener.onSDKInitFailed("appKey is null or empty");
        } catch (Exception e10) {
            Log.e(this.TAG, "initSDK: exception occurred initializing IronSource: " + e10.toString());
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
        if (z10) {
            IronSource.setMetaData(com.ironsource.mediationsdk.metadata.a.f13682a, "false");
            IronSource.setConsent(true);
        } else {
            IronSource.setMetaData(com.ironsource.mediationsdk.metadata.a.f13682a, com.ironsource.mediationsdk.metadata.a.f13688g);
            IronSource.setConsent(false);
        }
    }

    class b implements Application.ActivityLifecycleCallbacks {
        b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
            IronSource.onPause(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
            IronSource.onResume(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        }
    }
}
