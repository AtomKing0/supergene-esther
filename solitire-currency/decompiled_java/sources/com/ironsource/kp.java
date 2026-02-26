package com.ironsource;

import com.ironsource.g2;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class kp extends i7<mp> {
    public kp(List<NetworkSettings> list, pp ppVar, String str, boolean z10, lj ljVar, IronSourceSegment ironSourceSegment) {
        super(new ip(str, list, ppVar, z10), ljVar, ironSourceSegment);
    }

    @Override // com.ironsource.h7
    protected /* bridge */ /* synthetic */ k7 a(NetworkSettings networkSettings, BaseAdAdapter baseAdAdapter, int i10, String str, f5 f5Var) {
        return b(networkSettings, (BaseAdAdapter<?, AdapterAdRewardListener>) baseAdAdapter, i10, str, f5Var);
    }

    protected mp b(NetworkSettings networkSettings, BaseAdAdapter<?, AdapterAdRewardListener> baseAdAdapter, int i10, String str, f5 f5Var) {
        return new mp(this, new i1(IronSource.AD_UNIT.REWARDED_VIDEO, this.f12415o.p(), i10, this.f12407g, str, this.f12405e, this.f12406f, networkSettings, this.f12415o.o()), baseAdAdapter, f5Var, this);
    }

    @Override // com.ironsource.h7
    protected e2 g() {
        return new sp();
    }

    @Override // com.ironsource.h7
    protected String l() {
        return IronSourceConstants.REWARDED_VIDEO_EVENT_TYPE;
    }

    @Override // com.ironsource.h7
    protected String o() {
        return IronSourceConstants.OPW_RV_MANAGER_NAME;
    }

    @Override // com.ironsource.h7
    protected boolean q() {
        return this.f12415o.i().a() == g2.a.MANUAL;
    }

    @Override // com.ironsource.h7
    protected boolean t() {
        return this.f12415o.i().a() == g2.a.AUTOMATIC_LOAD_WHILE_SHOW;
    }

    @Override // com.ironsource.h7
    protected LoadWhileShowSupportState a(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface) {
        return ((AdapterSettingsInterface) adapterBaseInterface).getLoadWhileShowSupportedState(networkSettings);
    }

    @Override // com.ironsource.h7
    protected JSONObject b(NetworkSettings networkSettings) {
        return networkSettings.getRewardedVideoSettings();
    }

    @Override // com.ironsource.h7
    protected void a(IronSourceError ironSourceError) {
        g2.a aVarA = this.f12415o.i().a();
        if (aVarA == g2.a.AUTOMATIC_LOAD_AFTER_CLOSE || aVarA == g2.a.AUTOMATIC_LOAD_WHILE_SHOW) {
            this.f12420t.a(false, (AdInfo) null);
        } else {
            super.a(ironSourceError);
        }
    }
}
