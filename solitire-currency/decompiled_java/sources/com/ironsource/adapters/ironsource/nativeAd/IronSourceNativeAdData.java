package com.ironsource.adapters.ironsource.nativeAd;

import com.ironsource.dg;
import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class IronSourceNativeAdData extends AdapterNativeAdData {

    @Nullable
    private final String advertiser;

    @Nullable
    private final String body;

    @Nullable
    private final String callToAction;

    @Nullable
    private final NativeAdDataInterface.Image icon;

    @Nullable
    private final String title;

    public IronSourceNativeAdData(@NotNull dg nativeAdData) {
        t.i(nativeAdData, "nativeAdData");
        this.title = nativeAdData.n();
        this.advertiser = nativeAdData.h();
        this.body = nativeAdData.i();
        this.callToAction = nativeAdData.j();
        this.icon = new NativeAdDataInterface.Image(nativeAdData.k(), null);
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    @Nullable
    public String getAdvertiser() {
        return this.advertiser;
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    @Nullable
    public String getBody() {
        return this.body;
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    @Nullable
    public String getCallToAction() {
        return this.callToAction;
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    @Nullable
    public NativeAdDataInterface.Image getIcon() {
        return this.icon;
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    @Nullable
    public String getTitle() {
        return this.title;
    }
}
