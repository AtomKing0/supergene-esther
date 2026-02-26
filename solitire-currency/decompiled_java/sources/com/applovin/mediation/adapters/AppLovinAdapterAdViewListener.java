package com.applovin.mediation.adapters;

import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.impl.g2;
import com.applovin.impl.sdk.AppLovinError;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: loaded from: classes2.dex */
public class AppLovinAdapterAdViewListener implements g2, AppLovinAdDisplayListener, AppLovinAdClickListener, AppLovinAdViewEventListener {
    private final MaxAdFormat adFormat;
    private final MaxAdViewAdapterListener listener;
    private final AppLovinMediationAdapter parentAdapter;

    public AppLovinAdapterAdViewListener(AppLovinMediationAdapter appLovinMediationAdapter, MaxAdFormat maxAdFormat, MaxAdViewAdapterListener maxAdViewAdapterListener) {
        this.parentAdapter = appLovinMediationAdapter;
        this.adFormat = maxAdFormat;
        this.listener = maxAdViewAdapterListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$adReceived$0(AppLovinAd appLovinAd) {
        this.parentAdapter.loadedAdView = new AppLovinAdView(this.parentAdapter.getWrappingSdk(), appLovinAd.getSize(), this.parentAdapter.getApplicationContext());
        this.parentAdapter.loadedAdView.setAdDisplayListener(this);
        this.parentAdapter.loadedAdView.setAdClickListener(this);
        this.parentAdapter.loadedAdView.setAdViewEventListener(this);
        this.listener.onAdViewAdLoaded(this.parentAdapter.loadedAdView, AppLovinMediationAdapter.getExtraInfo(appLovinAd, false));
        this.parentAdapter.loadedAdView.renderAd(appLovinAd);
    }

    @Override // com.applovin.sdk.AppLovinAdClickListener
    public void adClicked(AppLovinAd appLovinAd) {
        this.parentAdapter.log(this.adFormat.getLabel() + " ad clicked");
        this.listener.onAdViewAdClicked(AppLovinMediationAdapter.getExtraInfo(appLovinAd));
    }

    @Override // com.applovin.adview.AppLovinAdViewEventListener
    public void adClosedFullscreen(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        this.parentAdapter.log(this.adFormat.getLabel() + " ad collapsed");
        this.listener.onAdViewAdCollapsed();
    }

    @Override // com.applovin.sdk.AppLovinAdDisplayListener
    public void adDisplayed(AppLovinAd appLovinAd) {
        this.parentAdapter.log(this.adFormat.getLabel() + " ad shown");
        this.listener.onAdViewAdDisplayed(AppLovinMediationAdapter.getExtraInfo(appLovinAd, false));
    }

    @Override // com.applovin.adview.AppLovinAdViewEventListener
    public void adFailedToDisplay(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AppLovinAdViewDisplayErrorCode appLovinAdViewDisplayErrorCode) {
        this.parentAdapter.log(this.adFormat.getLabel() + " failed to display with error code: " + appLovinAdViewDisplayErrorCode);
        this.listener.onAdViewAdDisplayFailed(MaxAdapterError.UNSPECIFIED);
    }

    @Override // com.applovin.sdk.AppLovinAdDisplayListener
    public void adHidden(AppLovinAd appLovinAd) {
        this.parentAdapter.log(this.adFormat.getLabel() + " ad hidden");
        this.listener.onAdViewAdHidden(AppLovinMediationAdapter.getExtraInfo(appLovinAd));
    }

    @Override // com.applovin.adview.AppLovinAdViewEventListener
    public void adLeftApplication(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        this.parentAdapter.log(this.adFormat.getLabel() + " ad left application");
    }

    @Override // com.applovin.adview.AppLovinAdViewEventListener
    public void adOpenedFullscreen(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        this.parentAdapter.log(this.adFormat.getLabel() + " ad expanded");
        this.listener.onAdViewAdExpanded();
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void adReceived(final AppLovinAd appLovinAd) {
        this.parentAdapter.log(this.adFormat.getLabel() + " ad loaded");
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.mediation.adapters.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f7944a.lambda$adReceived$0(appLovinAd);
            }
        });
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void failedToReceiveAd(int i10) {
        failedToReceiveAdV2(new AppLovinError(i10, ""));
    }

    @Override // com.applovin.impl.g2
    public void failedToReceiveAdV2(AppLovinError appLovinError) {
        MaxAdapterError maxError = AppLovinMediationAdapter.toMaxError(appLovinError);
        this.parentAdapter.log(this.adFormat.getLabel() + " ad failed to load with error: " + maxError);
        this.listener.onAdViewAdLoadFailed(maxError);
    }
}
