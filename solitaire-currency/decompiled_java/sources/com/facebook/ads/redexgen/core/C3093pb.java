package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.pb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C3093pb {
    public static C3093pb A03 = null;
    public final ViewpointQeConfig A00;
    public final ViewpointRegistry A01;
    public final C3104pm A02;

    public C3093pb(ViewpointQeConfig viewpointQeConfig, AbstractC3109ps abstractC3109ps, C3104pm c3104pm, ViewpointRegistry viewpointRegistry) {
        this.A00 = viewpointQeConfig;
        this.A01 = viewpointRegistry;
        this.A02 = c3104pm;
        abstractC3109ps.A03(new A4(c3104pm));
    }

    public static C3093pb A00(ViewpointQeConfig viewpointQeConfig, AbstractC3109ps abstractC3109ps, InterfaceC3114px interfaceC3114px, A6 a62) {
        C3093pb localsTestInstance = A03;
        if (localsTestInstance != null) {
            return localsTestInstance;
        }
        ViewpointRegistry viewpointRegistry = new ViewpointRegistry(viewpointQeConfig);
        return new C3093pb(viewpointQeConfig, abstractC3109ps, new C3104pm(viewpointQeConfig, interfaceC3114px, C1550Bg.A00, a62, viewpointRegistry, new Handler(Looper.getMainLooper())), viewpointRegistry);
    }

    public final void A01(InterfaceC3108pr interfaceC3108pr) {
        this.A02.A0E(interfaceC3108pr);
    }

    public final void A02(InterfaceC3106pp interfaceC3106pp) {
        this.A02.A0F(interfaceC3106pp);
    }

    public final void A03(DspViewableNode dspViewableNode) {
        A04(dspViewableNode, null);
    }

    public final void A04(DspViewableNode dspViewableNode, C3115q0 c3115q0) {
        if (this.A00.A00 && c3115q0 != null) {
            this.A01.A06(dspViewableNode, c3115q0);
        } else {
            this.A01.A05(dspViewableNode);
        }
    }

    public final void A05(DspViewableNode dspViewableNode, C3115q0 c3115q0, C3111pu c3111pu) {
        if (this.A00.A00 && c3115q0 != null) {
            this.A01.A07(dspViewableNode, c3115q0, c3111pu);
        } else {
            this.A01.A08(dspViewableNode, c3111pu);
        }
    }

    public final void A06(DspViewableNode dspViewableNode, C3111pu c3111pu) {
        A05(dspViewableNode, null, c3111pu);
    }
}
