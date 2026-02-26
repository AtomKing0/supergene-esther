package com.ironsource.mediationsdk.adunit.adapter.internal;

import android.app.Activity;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface AdapterBannerInterface<Listener extends AdapterAdListener> {
    void destroyAd(@NotNull AdData adData);

    void loadAd(@NotNull AdData adData, @NotNull Activity activity, @NotNull ISBannerSize iSBannerSize, @NotNull Listener listener);
}
