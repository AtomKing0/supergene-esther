package com.ironsource;

import com.ironsource.j7;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.Placement;

/* JADX INFO: loaded from: classes4.dex */
public abstract class i7<Smash extends j7<?>> extends f7<Smash, AdapterAdRewardListener> implements n2 {
    public i7(q0 q0Var, lj ljVar, IronSourceSegment ironSourceSegment) {
        super(q0Var, ljVar, ironSourceSegment);
    }

    @Override // com.ironsource.n2
    public void a(j7<?> j7Var, Placement placement) {
        IronLog.INTERNAL.verbose(b(j7Var.k()));
        this.f12420t.b(placement, j7Var.f());
    }
}
