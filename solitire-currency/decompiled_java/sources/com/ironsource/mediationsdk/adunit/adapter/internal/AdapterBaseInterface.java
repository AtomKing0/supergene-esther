package com.ironsource.mediationsdk.adunit.adapter.internal;

import android.content.Context;
import com.ironsource.mediationsdk.adunit.adapter.listener.NetworkInitializationListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface AdapterBaseInterface {
    @NotNull
    String getAdapterVersion();

    @Nullable
    String getNetworkSDKVersion();

    void init(@NotNull AdData adData, @NotNull Context context, @Nullable NetworkInitializationListener networkInitializationListener);
}
