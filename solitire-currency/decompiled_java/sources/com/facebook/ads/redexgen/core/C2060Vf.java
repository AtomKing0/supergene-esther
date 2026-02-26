package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2060Vf implements ViewpointAction<UE, UJ> {
    public VN A00;

    public C2060Vf(VN vn) {
        this.A00 = vn;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.pu != com.instagram.common.viewpoint.core.ViewpointData<com.facebook.ads.internal.impressionsecondchannel.model.Impression, com.facebook.ads.internal.impressionsecondchannel.state.ImpressionState> */
    @Override // com.facebook.ads.redexgen.core.ViewpointAction
    public final void A6J(C3111pu<UE, UJ> c3111pu, InterfaceC3102pk interfaceC3102pk) {
        switch (interfaceC3102pk.A9M(c3111pu)) {
            case A02:
            case A04:
                this.A00.A02(c3111pu, interfaceC3102pk);
                break;
        }
    }
}
