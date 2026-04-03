package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.RewardedVideoAdListener;

/* JADX INFO: loaded from: classes4.dex */
public class mp extends j7<n2> implements RewardedVideoAdListener {
    public mp(ko koVar, i1 i1Var, BaseAdAdapter<?, AdapterAdRewardListener> baseAdAdapter, f5 f5Var, n2 n2Var) {
        super(koVar, i1Var, baseAdAdapter, new v2(i1Var.g(), i1Var.g().getRewardedVideoSettings(), IronSource.AD_UNIT.REWARDED_VIDEO), f5Var, n2Var);
    }
}
