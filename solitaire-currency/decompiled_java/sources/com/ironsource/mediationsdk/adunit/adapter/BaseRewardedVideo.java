package com.ironsource.mediationsdk.adunit.adapter;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.BaseAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdInteractionAdapter;
import com.ironsource.mediationsdk.adunit.adapter.listener.RewardedVideoAdListener;
import com.ironsource.mediationsdk.model.NetworkSettings;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseRewardedVideo<NetworkAdapter extends BaseAdapter> extends BaseAdInteractionAdapter<NetworkAdapter, RewardedVideoAdListener> {
    public BaseRewardedVideo(@NotNull NetworkSettings networkSettings) {
        super(IronSource.AD_UNIT.REWARDED_VIDEO, networkSettings);
    }
}
