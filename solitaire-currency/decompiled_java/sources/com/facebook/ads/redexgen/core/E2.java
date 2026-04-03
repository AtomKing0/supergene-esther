package com.facebook.ads.redexgen.core;

import android.media.Spatializer;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class E2 implements Spatializer.OnSpatializerStateChangedListener {
    public final /* synthetic */ E3 A00;
    public final /* synthetic */ AnonymousClass92 A01;

    public E2(E3 e32, AnonymousClass92 anonymousClass92) {
        this.A00 = e32;
        this.A01 = anonymousClass92;
    }

    @Override // android.media.Spatializer.OnSpatializerStateChangedListener
    public final void onSpatializerAvailableChanged(Spatializer spatializer, boolean z10) {
        this.A01.A0L();
    }

    @Override // android.media.Spatializer.OnSpatializerStateChangedListener
    public final void onSpatializerEnabledChanged(Spatializer spatializer, boolean z10) {
        this.A01.A0L();
    }
}
