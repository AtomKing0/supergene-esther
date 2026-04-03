package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.adunit.adapter.listener.NativeAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class t extends a<NativeAdListener> implements NativeAdSmashListener {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(@Nullable AbstractAdapter abstractAdapter, @Nullable NetworkSettings networkSettings, @NotNull UUID adUnitObjectId) {
        super(abstractAdapter, networkSettings, IronSource.AD_UNIT.NATIVE_AD, adUnitObjectId);
        kotlin.jvm.internal.t.i(adUnitObjectId, "adUnitObjectId");
    }

    @Override // com.ironsource.mediationsdk.a
    protected void a(@NotNull JSONObject config) {
        kotlin.jvm.internal.t.i(config, "config");
        this.f13276a.destroyNativeAd(config);
    }

    @Override // com.ironsource.mediationsdk.a
    @NotNull
    protected IronSource.AD_UNIT b() {
        return IronSource.AD_UNIT.NATIVE_AD;
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener
    public void onNativeAdClicked() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        NativeAdListener nativeAdListener = (NativeAdListener) this.f13277b.get();
        if (nativeAdListener != null) {
            nativeAdListener.onAdClicked();
        }
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener
    public void onNativeAdLoadFailed(@Nullable IronSourceError ironSourceError) {
        IronLog.ADAPTER_CALLBACK.verbose(a("error = " + ironSourceError));
        int errorCode = ironSourceError != null ? ironSourceError.getErrorCode() : 1000;
        String errorMessage = ironSourceError != null ? ironSourceError.getErrorMessage() : null;
        if (errorMessage == null) {
            errorMessage = "";
        }
        if (this.f13277b.get() != null) {
            AdapterErrorType adapterErrorType = a(ironSourceError) ? AdapterErrorType.ADAPTER_ERROR_TYPE_NO_FILL : AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL;
            NativeAdListener nativeAdListener = (NativeAdListener) this.f13277b.get();
            if (nativeAdListener != null) {
                nativeAdListener.onAdLoadFailed(adapterErrorType, errorCode, errorMessage);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener
    public void onNativeAdLoaded(@NotNull AdapterNativeAdData adapterNativeAdData, @NotNull AdapterNativeAdViewBinder nativeAdViewBinder) {
        kotlin.jvm.internal.t.i(adapterNativeAdData, "adapterNativeAdData");
        kotlin.jvm.internal.t.i(nativeAdViewBinder, "nativeAdViewBinder");
        IronLog.ADAPTER_CALLBACK.verbose(a());
        NativeAdListener nativeAdListener = (NativeAdListener) this.f13277b.get();
        if (nativeAdListener != null) {
            nativeAdListener.onAdLoadSuccess(adapterNativeAdData, nativeAdViewBinder);
        }
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener
    public void onNativeAdShown() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        NativeAdListener nativeAdListener = (NativeAdListener) this.f13277b.get();
        if (nativeAdListener != null) {
            nativeAdListener.onAdOpened();
        }
    }

    @Override // com.ironsource.mediationsdk.a
    protected void a(@NotNull JSONObject config, @NotNull JSONObject adUnitData, @NotNull AdData adData) {
        kotlin.jvm.internal.t.i(config, "config");
        kotlin.jvm.internal.t.i(adUnitData, "adUnitData");
        kotlin.jvm.internal.t.i(adData, "adData");
        Integer num = adData.getInt("instanceType");
        if (num == null || num.intValue() != 1) {
            this.f13276a.loadNativeAdForBidding(config, adUnitData, adData.getServerData(), this);
        } else {
            this.f13276a.loadNativeAd(config, adUnitData, this);
        }
    }

    private final boolean a(IronSourceError ironSourceError) {
        return ironSourceError != null && ironSourceError.getErrorCode() == 706;
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener
    public void onNativeAdInitSuccess() {
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener
    public void onNativeAdInitFailed(@Nullable IronSourceError ironSourceError) {
    }
}
