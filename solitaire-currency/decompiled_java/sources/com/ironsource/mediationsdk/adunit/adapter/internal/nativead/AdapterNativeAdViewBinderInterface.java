package com.ironsource.mediationsdk.adunit.adapter.internal.nativead;

import android.view.View;
import android.view.ViewGroup;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdViewBinderInterface;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface AdapterNativeAdViewBinderInterface extends NativeAdViewBinderInterface {
    @Nullable
    ViewGroup getNetworkNativeAdView();

    void setNativeAdView(@Nullable View view);
}
