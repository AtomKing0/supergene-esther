package com.applovin.mediation.adapters;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinIncentivizedInterstitial;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.adview.AppLovinAppOpenAd;
import com.applovin.impl.g2;
import com.applovin.impl.g3;
import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.ad.c;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAd;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdImpl;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxSignalProvider;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinBidTokenCollectionListener;
import com.applovin.sdk.AppLovinSdk;

/* JADX INFO: loaded from: classes2.dex */
public class AppLovinMediationAdapter extends MediationAdapterBase implements MaxSignalProvider, MaxInterstitialAdapter, MaxRewardedAdapter, MaxAdViewAdapter {
    protected AppLovinAdView loadedAdView;
    protected AppLovinAd loadedAppOpenAd;
    protected AppLovinAd loadedInterstitialAd;
    protected AppLovinNativeAd loadedNativeAd;
    protected AppLovinAd loadedRewardedAd;

    public AppLovinMediationAdapter(AppLovinSdk appLovinSdk) {
        super(appLovinSdk);
    }

    private static Bundle getArrayParameters(AppLovinAd appLovinAd) {
        AppLovinAdImpl appLovinAdImpl = appLovinAd instanceof c ? (AppLovinAdImpl) ((c) appLovinAd).c() : (AppLovinAdImpl) appLovinAd;
        Bundle bundle = new Bundle();
        if (appLovinAdImpl == null) {
            return bundle;
        }
        BundleUtils.putString(ArrayService.KEY_AD_TOKEN, appLovinAdImpl.getDirectDownloadToken(), bundle);
        bundle.putAll(appLovinAdImpl.getDirectDownloadParameters());
        return bundle;
    }

    protected static Bundle getExtraInfo(AppLovinAd appLovinAd) {
        return getExtraInfo(appLovinAd, true);
    }

    private void loadFullscreenAd(String str, MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Object obj) {
        if (StringUtils.isValidString(maxAdapterResponseParameters.getBidResponse())) {
            log("Loading bidding " + maxAdFormat.getLabel() + " ad...");
            getWrappingSdk().getAdService().loadNextAdForAdToken(maxAdapterResponseParameters.getBidResponse(), (g2) obj);
            return;
        }
        if (!StringUtils.isValidString(maxAdapterResponseParameters.getThirdPartyAdPlacementId())) {
            log("Loading mediated " + maxAdFormat.getLabel() + " ad...");
            getWrappingSdk().getAdService().loadNextAdForZoneId(str, (g2) obj);
            return;
        }
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Loading mediated " + maxAdFormat.getLabel() + " ad: " + thirdPartyAdPlacementId + "...");
        getWrappingSdk().getAdService().loadNextAdForZoneId(thirdPartyAdPlacementId, (g2) obj);
    }

    protected static MaxAdapterError toMaxError(AppLovinError appLovinError) {
        MaxAdapterError maxAdapterError = appLovinError.getCode() == -1009 ? MaxAdapterError.NO_CONNECTION : appLovinError.getCode() == 204 ? MaxAdapterError.NO_FILL : appLovinError.getCode() == -1 ? MaxAdapterError.INTERNAL_ERROR : appLovinError.getCode() >= 500 ? MaxAdapterError.SERVER_ERROR : MaxAdapterError.UNSPECIFIED;
        return new MaxAdapterError(maxAdapterError.getCode(), maxAdapterError.getErrorMessage(), appLovinError.getCode(), appLovinError.getMessage());
    }

    @Override // com.applovin.mediation.adapter.MaxSignalProvider
    public void collectSignal(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, Activity activity, final MaxSignalCollectionListener maxSignalCollectionListener) {
        log("Collecting signal...");
        if (((Boolean) getWrappingSdk().a().a(g3.f5250w7)).booleanValue()) {
            getWrappingSdk().getAdService().collectBidToken(new AppLovinBidTokenCollectionListener() { // from class: com.applovin.mediation.adapters.AppLovinMediationAdapter.1
                @Override // com.applovin.sdk.AppLovinBidTokenCollectionListener
                public void onBidTokenCollected(String str) {
                    AppLovinMediationAdapter.this.log("Signal collection successful");
                    maxSignalCollectionListener.onSignalCollected(str);
                }

                @Override // com.applovin.sdk.AppLovinBidTokenCollectionListener
                public void onBidTokenCollectionFailed(String str) {
                    AppLovinMediationAdapter.this.log("Signal collection failed with error: " + str);
                    maxSignalCollectionListener.onSignalCollectionFailed(str);
                }
            });
        } else {
            maxSignalCollectionListener.onSignalCollected(getWrappingSdk().getAdService().getBidToken());
        }
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getAdapterVersion() {
        return getSdkVersion();
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getSdkVersion() {
        return AppLovinSdk.VERSION;
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, MaxAdapter.OnCompletionListener onCompletionListener) {
        onCompletionListener.onCompletion(MaxAdapter.InitializationStatus.DOES_NOT_APPLY, null);
    }

    @Override // com.applovin.mediation.adapter.MaxAdViewAdapter
    public void loadAdViewAd(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Activity activity, MaxAdViewAdapterListener maxAdViewAdapterListener) {
        AppLovinAdapterAdViewListener appLovinAdapterAdViewListener = new AppLovinAdapterAdViewListener(this, maxAdFormat, maxAdViewAdapterListener);
        if (StringUtils.isValidString(maxAdapterResponseParameters.getBidResponse())) {
            log("Loading bidding " + maxAdFormat.getLabel() + " ad...");
            getWrappingSdk().getAdService().loadNextAdForAdToken(maxAdapterResponseParameters.getBidResponse(), appLovinAdapterAdViewListener);
            return;
        }
        if (StringUtils.isValidString(maxAdapterResponseParameters.getThirdPartyAdPlacementId())) {
            String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
            log("Loading mediated " + maxAdFormat.getLabel() + " ad: " + thirdPartyAdPlacementId + "...");
            getWrappingSdk().getAdService().loadNextAdForZoneId(thirdPartyAdPlacementId, appLovinAdapterAdViewListener);
            return;
        }
        AppLovinAdSize appLovinAdSize = maxAdFormat == MaxAdFormat.BANNER ? AppLovinAdSize.BANNER : maxAdFormat == MaxAdFormat.MREC ? AppLovinAdSize.MREC : maxAdFormat == MaxAdFormat.LEADER ? AppLovinAdSize.LEADER : null;
        if (appLovinAdSize == null) {
            log("Failed to load ad for format: " + maxAdFormat);
            maxAdViewAdapterListener.onAdViewAdLoadFailed(MaxAdapterError.INTERNAL_ERROR);
            return;
        }
        log("Loading regular " + maxAdFormat.getLabel() + " ad...");
        getWrappingSdk().getAdService().loadNextAd(appLovinAdSize, appLovinAdapterAdViewListener);
    }

    @Override // com.applovin.mediation.adapters.MediationAdapterBase, com.applovin.mediation.adapter.MaxAppOpenAdapter
    public void loadAppOpenAd(@NonNull MaxAdapterResponseParameters maxAdapterResponseParameters, @Nullable Activity activity, @NonNull MaxAppOpenAdapterListener maxAppOpenAdapterListener) {
        loadFullscreenAd("inter_appopen", maxAdapterResponseParameters, MaxAdFormat.APP_OPEN, new AppLovinAdapterAppOpenListener(this, maxAppOpenAdapterListener));
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void loadInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        loadFullscreenAd("inter_regular", maxAdapterResponseParameters, MaxAdFormat.INTERSTITIAL, new AppLovinAdapterInterstitialListener(this, maxInterstitialAdapterListener));
    }

    @Override // com.applovin.mediation.adapters.MediationAdapterBase, com.applovin.mediation.adapter.MaxNativeAdAdapter
    public void loadNativeAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxNativeAdAdapterListener maxNativeAdAdapterListener) {
        if (TextUtils.isEmpty(maxAdapterResponseParameters.getBidResponse())) {
            maxNativeAdAdapterListener.onNativeAdLoadFailed(MaxAdapterError.INVALID_CONFIGURATION);
        } else {
            d("Loading bidding native ad...");
            getWrappingSdk().a().U().loadNextAdForAdToken(maxAdapterResponseParameters.getBidResponse(), new AppLovinAdapterNativeListener(maxAdapterResponseParameters, this, maxNativeAdAdapterListener));
        }
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void loadRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        loadFullscreenAd("inter_videoa", maxAdapterResponseParameters, MaxAdFormat.REWARDED, new AppLovinAdapterRewardedListener(this, maxRewardedAdapterListener));
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void onDestroy() {
        this.loadedInterstitialAd = null;
        this.loadedAppOpenAd = null;
        this.loadedRewardedAd = null;
        AppLovinAdView appLovinAdView = this.loadedAdView;
        if (appLovinAdView != null) {
            appLovinAdView.destroy();
            this.loadedAdView = null;
        }
        AppLovinNativeAd appLovinNativeAd = this.loadedNativeAd;
        if (appLovinNativeAd instanceof AppLovinNativeAdImpl) {
            ((AppLovinNativeAdImpl) appLovinNativeAd).destroy();
            this.loadedNativeAd = null;
        }
    }

    @Override // com.applovin.mediation.adapters.MediationAdapterBase, com.applovin.mediation.adapter.MaxAppOpenAdapter
    public void showAppOpenAd(@NonNull MaxAdapterResponseParameters maxAdapterResponseParameters, @Nullable Activity activity, @NonNull MaxAppOpenAdapterListener maxAppOpenAdapterListener) {
        log("Showing app open ad: " + maxAdapterResponseParameters.getThirdPartyAdPlacementId() + "...");
        AppLovinAppOpenAd appLovinAppOpenAd = new AppLovinAppOpenAd();
        AppLovinAdapterAppOpenListener appLovinAdapterAppOpenListener = new AppLovinAdapterAppOpenListener(this, maxAppOpenAdapterListener);
        appLovinAppOpenAd.setAdDisplayListener(appLovinAdapterAppOpenListener);
        appLovinAppOpenAd.setAdClickListener(appLovinAdapterAppOpenListener);
        appLovinAppOpenAd.show(this.loadedAppOpenAd);
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void showInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        log("Showing interstitial: " + maxAdapterResponseParameters.getThirdPartyAdPlacementId() + "...");
        AppLovinInterstitialAdDialog appLovinInterstitialAdDialogCreate = AppLovinInterstitialAd.create();
        AppLovinAdapterInterstitialListener appLovinAdapterInterstitialListener = new AppLovinAdapterInterstitialListener(this, maxInterstitialAdapterListener);
        appLovinInterstitialAdDialogCreate.setAdDisplayListener(appLovinAdapterInterstitialListener);
        appLovinInterstitialAdDialogCreate.setAdClickListener(appLovinAdapterInterstitialListener);
        appLovinInterstitialAdDialogCreate.showAndRender(this.loadedInterstitialAd);
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void showRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        log("Showing rewarded ad: " + maxAdapterResponseParameters.getThirdPartyAdPlacementId() + "...");
        configureReward(maxAdapterResponseParameters);
        AppLovinIncentivizedInterstitial appLovinIncentivizedInterstitial = new AppLovinIncentivizedInterstitial();
        AppLovinAdapterRewardedListener appLovinAdapterRewardedListener = new AppLovinAdapterRewardedListener(this, maxRewardedAdapterListener);
        appLovinIncentivizedInterstitial.show(this.loadedRewardedAd, activity, appLovinAdapterRewardedListener, appLovinAdapterRewardedListener, appLovinAdapterRewardedListener, appLovinAdapterRewardedListener);
    }

    protected static Bundle getExtraInfo(AppLovinAd appLovinAd, boolean z10) {
        Bundle bundle = new Bundle();
        if (appLovinAd instanceof AppLovinAdImpl) {
            if (z10) {
                bundle.putBundle("ad_values", ((AppLovinAdImpl) appLovinAd).getMAXAdValues());
            }
            bundle.putBundle("array_parameters", getArrayParameters(appLovinAd));
        }
        return bundle;
    }

    @Override // com.applovin.mediation.adapters.MediationAdapterBase, com.applovin.mediation.adapter.MaxRewardedAdViewAdapter
    public void showRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        log("Showing rewarded ad view: " + maxAdapterResponseParameters.getThirdPartyAdPlacementId() + "...");
        configureReward(maxAdapterResponseParameters);
        AppLovinIncentivizedInterstitial appLovinIncentivizedInterstitial = new AppLovinIncentivizedInterstitial();
        AppLovinAdapterRewardedListener appLovinAdapterRewardedListener = new AppLovinAdapterRewardedListener(this, maxRewardedAdapterListener);
        appLovinIncentivizedInterstitial.show(this.loadedRewardedAd, viewGroup, lifecycle, activity, appLovinAdapterRewardedListener, appLovinAdapterRewardedListener, appLovinAdapterRewardedListener, appLovinAdapterRewardedListener);
    }

    @Override // com.applovin.mediation.adapters.MediationAdapterBase, com.applovin.mediation.adapter.MaxInterstitialAdViewAdapter
    public void showInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        log("Showing interstitial ad view: " + maxAdapterResponseParameters.getThirdPartyAdPlacementId() + "...");
        AppLovinInterstitialAdDialog appLovinInterstitialAdDialogCreate = AppLovinInterstitialAd.create();
        AppLovinAdapterInterstitialListener appLovinAdapterInterstitialListener = new AppLovinAdapterInterstitialListener(this, maxInterstitialAdapterListener);
        appLovinInterstitialAdDialogCreate.setAdDisplayListener(appLovinAdapterInterstitialListener);
        appLovinInterstitialAdDialogCreate.setAdClickListener(appLovinAdapterInterstitialListener);
        appLovinInterstitialAdDialogCreate.showAndRender(this.loadedInterstitialAd, viewGroup, lifecycle);
    }
}
