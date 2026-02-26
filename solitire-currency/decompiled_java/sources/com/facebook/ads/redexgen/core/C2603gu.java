package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.gu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2603gu implements InterfaceC1865Nn {
    public final /* synthetic */ C2604gv A00;
    public final /* synthetic */ C2602gt A01;

    public C2603gu(C2602gt c2602gt, C2604gv c2604gv) {
        this.A01 = c2602gt;
        this.A00 = c2604gv;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1865Nn
    public final InterfaceC1864Nm A5K(InterfaceC1852Na interfaceC1852Na, AbstractC2621hD abstractC2621hD, HandlerC1859Nh handlerC1859Nh) {
        return new C2601gs(this.A00.A05(), this.A00, interfaceC1852Na, abstractC2621hD, handlerC1859Nh);
    }
}
