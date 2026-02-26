package com.ironsource;

import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class il {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private AdapterNativeAdViewBinder f12644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private AdapterNativeAdData f12645b;

    @Nullable
    public final AdapterNativeAdData a() {
        return this.f12645b;
    }

    @Nullable
    public final AdapterNativeAdViewBinder b() {
        return this.f12644a;
    }

    public final void a(@Nullable AdapterNativeAdData adapterNativeAdData) {
        this.f12645b = adapterNativeAdData;
    }

    public final void a(@Nullable AdapterNativeAdViewBinder adapterNativeAdViewBinder) {
        this.f12644a = adapterNativeAdViewBinder;
    }
}
