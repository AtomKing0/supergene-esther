package com.ironsource.mediationsdk.adunit.adapter.internal;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.c;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseAdAdapter<NetworkAdapter extends AdapterBaseInterface, Listener> {

    @NotNull
    private final IronSource.AD_UNIT mAdUnit;

    @Nullable
    protected final UUID mAdUnitObjectId;

    @NotNull
    protected final NetworkSettings mNetworkSettings;

    public BaseAdAdapter(@NotNull IronSource.AD_UNIT ad_unit, @NotNull NetworkSettings networkSettings) {
        this(ad_unit, networkSettings, null);
    }

    @Nullable
    public NetworkAdapter getNetworkAdapter() {
        NetworkAdapter networkadapter = (NetworkAdapter) c.b().b(this.mNetworkSettings, this.mAdUnit, this.mAdUnitObjectId);
        if (networkadapter != null) {
            return networkadapter;
        }
        return null;
    }

    @NotNull
    protected NetworkSettings getNetworkSettings() {
        return this.mNetworkSettings;
    }

    public BaseAdAdapter(@NotNull IronSource.AD_UNIT ad_unit, @NotNull NetworkSettings networkSettings, @NotNull UUID uuid) {
        this.mAdUnit = ad_unit;
        this.mNetworkSettings = networkSettings;
        this.mAdUnitObjectId = uuid;
    }

    public void releaseMemory() {
    }
}
