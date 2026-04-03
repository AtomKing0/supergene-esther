package com.facebook.ads.redexgen.core;

import androidx.media3.exoplayer.ExoPlayer;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class FP implements InterfaceC2100Wv {
    public final /* synthetic */ C13673r A00;

    public FP(C13673r c13673r) {
        this.A00 = c13673r;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2100Wv
    public final void AEQ(String str) {
        this.A00.A0G.postDelayed(new RunnableC2341ca(this), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2100Wv
    public final void AER(String str) {
        this.A00.A0I(UZ.A0c);
    }
}
