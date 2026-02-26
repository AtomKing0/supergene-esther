package com.ironsource.mediationsdk;

import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.listener.BannerAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class j extends a<BannerAdListener> implements BannerSmashListener {
    public j(AbstractAdapter abstractAdapter, NetworkSettings networkSettings) {
        super(abstractAdapter, networkSettings, IronSource.AD_UNIT.BANNER, null);
    }

    @Override // com.ironsource.mediationsdk.a
    protected void a(JSONObject jSONObject) {
        this.f13276a.destroyBanner(jSONObject);
    }

    @Override // com.ironsource.mediationsdk.a
    protected IronSource.AD_UNIT b() {
        return IronSource.AD_UNIT.BANNER;
    }

    @Override // com.ironsource.mediationsdk.a
    public void c(@NotNull JSONObject jSONObject) {
        this.f13276a.onBannerViewBound(jSONObject);
    }

    @Override // com.ironsource.mediationsdk.a
    public void d(@NotNull JSONObject jSONObject) {
        this.f13276a.onBannerViewWillBind(jSONObject);
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdClicked() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.f13277b.get() != null) {
            ((BannerAdListener) this.f13277b.get()).onAdClicked();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLeftApplication() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.f13277b.get() != null) {
            ((BannerAdListener) this.f13277b.get()).onAdLeftApplication();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLoadFailed(IronSourceError ironSourceError) {
        IronLog.ADAPTER_CALLBACK.verbose(a("error = " + ironSourceError));
        if (this.f13277b.get() != null) {
            ((BannerAdListener) this.f13277b.get()).onAdLoadFailed(a(ironSourceError) ? AdapterErrorType.ADAPTER_ERROR_TYPE_NO_FILL : AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLoaded(View view, FrameLayout.LayoutParams layoutParams) {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.f13277b.get() != null) {
            ((BannerAdListener) this.f13277b.get()).onAdLoadSuccess(view, layoutParams);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdScreenDismissed() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.f13277b.get() != null) {
            ((BannerAdListener) this.f13277b.get()).onAdScreenDismissed();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdScreenPresented() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.f13277b.get() != null) {
            ((BannerAdListener) this.f13277b.get()).onAdScreenPresented();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdShown() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.f13277b.get() != null) {
            ((BannerAdListener) this.f13277b.get()).onAdOpened();
        }
    }

    @Override // com.ironsource.mediationsdk.a
    protected void a(JSONObject jSONObject, JSONObject jSONObject2, AdData adData) {
        Integer num = adData.getInt("instanceType");
        IronSourceBannerLayout ironSourceBannerLayout = (IronSourceBannerLayout) adData.getAdUnitData().get("bannerLayout");
        if (num == null || num.intValue() != 1) {
            this.f13276a.loadBannerForBidding(jSONObject, jSONObject2, adData.getServerData(), ironSourceBannerLayout, this);
        } else {
            this.f13276a.loadBanner(jSONObject, jSONObject2, ironSourceBannerLayout, this);
        }
    }

    protected boolean a(IronSourceError ironSourceError) {
        return ironSourceError.getErrorCode() == 606;
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerInitSuccess() {
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerInitFailed(IronSourceError ironSourceError) {
    }
}
