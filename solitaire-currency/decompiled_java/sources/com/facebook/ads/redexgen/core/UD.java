package com.facebook.ads.redexgen.core;

import com.facebook.ads.NativeAd;
import com.facebook.ads.internal.api.MediaViewVideoRendererApi;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class UD implements InterfaceC2042Um {
    public final /* synthetic */ MediaViewVideoRendererApi A00;
    public final /* synthetic */ TD A01;

    public UD(TD td, MediaViewVideoRendererApi mediaViewVideoRendererApi) {
        this.A01 = td;
        this.A00 = mediaViewVideoRendererApi;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2042Um
    public final void AIk() {
        this.A00.setVolume(1.0f);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2042Um
    public final void AIp(NativeAd nativeAd) {
        this.A01.A0I(C1930Qc.A0L(nativeAd.getInternalNativeAd()), new C2007Tc(C1930Qc.A0L(nativeAd.getInternalNativeAd())));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2042Um
    public final void AJn() {
        this.A01.A0D();
    }
}
