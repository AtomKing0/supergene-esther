package com.facebook.ads.redexgen.core;

import androidx.media3.datasource.cache.CacheDataSink;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2719iz implements InterfaceC13954t {
    public InterfaceC1814Ln A02;
    public long A01 = 5242880;
    public int A00 = CacheDataSink.DEFAULT_BUFFER_SIZE;

    public final C2719iz A00(InterfaceC1814Ln interfaceC1814Ln) {
        this.A02 = interfaceC1814Ln;
        return this;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13954t
    public final C2718iy A59() {
        return new C2718iy((InterfaceC1814Ln) C3M.A01(this.A02), this.A01, this.A00);
    }
}
