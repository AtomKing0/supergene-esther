package com.ironsource;

import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.ads.nativead.internal.InternalNativeAdListener;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class rl extends e2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final InternalNativeAdListener f14705a;

    public rl(@NotNull InternalNativeAdListener mNativeAdListener) {
        kotlin.jvm.internal.t.i(mNativeAdListener, "mNativeAdListener");
        this.f14705a = mNativeAdListener;
    }

    @Override // com.ironsource.e2
    public void a(@NotNull AdapterNativeAdData adapterNativeAdData, @NotNull AdapterNativeAdViewBinder nativeAdViewBinder, @Nullable AdInfo adInfo) {
        kotlin.jvm.internal.t.i(adapterNativeAdData, "adapterNativeAdData");
        kotlin.jvm.internal.t.i(nativeAdViewBinder, "nativeAdViewBinder");
        this.f14705a.onNativeAdLoaded(adInfo, adapterNativeAdData, nativeAdViewBinder);
    }

    @Override // com.ironsource.e2
    public void d(@Nullable AdInfo adInfo) {
        this.f14705a.onNativeAdImpression(adInfo);
    }

    @Override // com.ironsource.e2
    public void a(@Nullable IronSourceError ironSourceError) {
        this.f14705a.onNativeAdLoadFailed(ironSourceError);
    }

    @Override // com.ironsource.e2
    public void a(@NotNull Placement placement, @Nullable AdInfo adInfo) {
        kotlin.jvm.internal.t.i(placement, "placement");
        this.f14705a.onNativeAdClicked(adInfo);
    }
}
