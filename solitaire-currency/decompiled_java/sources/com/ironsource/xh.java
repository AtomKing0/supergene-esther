package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class xh extends f7<bi, AdapterAdInteractionListener> {
    xh(me meVar, le leVar, List<NetworkSettings> list, hi hiVar, String str, lj ljVar, IronSourceSegment ironSourceSegment) {
        super(meVar, leVar, new yh(str, list, hiVar), ljVar, ironSourceSegment);
    }

    @Override // com.ironsource.h7
    protected /* bridge */ /* synthetic */ k7 a(NetworkSettings networkSettings, BaseAdAdapter baseAdAdapter, int i10, String str, f5 f5Var) {
        return b(networkSettings, (BaseAdAdapter<?, AdapterAdInteractionListener>) baseAdAdapter, i10, str, f5Var);
    }

    protected bi b(NetworkSettings networkSettings, BaseAdAdapter<?, AdapterAdInteractionListener> baseAdAdapter, int i10, String str, f5 f5Var) {
        return new bi(this, new i1(IronSource.AD_UNIT.INTERSTITIAL, this.f12415o.p(), i10, this.f12407g, str, this.f12405e, this.f12406f, networkSettings, this.f12415o.o()), baseAdAdapter, f5Var, this);
    }

    @Override // com.ironsource.h7
    protected e2 g() {
        return new li();
    }

    @Override // com.ironsource.h7
    protected String l() {
        return IronSourceConstants.INTERSTITIAL_EVENT_TYPE;
    }

    @Override // com.ironsource.h7
    protected String o() {
        return IronSourceConstants.OPW_IS_MANAGER_NAME;
    }

    public xh(List<NetworkSettings> list, hi hiVar, String str, lj ljVar, IronSourceSegment ironSourceSegment) {
        super(new yh(str, list, hiVar), ljVar, ironSourceSegment);
    }

    @Override // com.ironsource.h7
    protected JSONObject b(NetworkSettings networkSettings) {
        return networkSettings.getInterstitialSettings();
    }
}
