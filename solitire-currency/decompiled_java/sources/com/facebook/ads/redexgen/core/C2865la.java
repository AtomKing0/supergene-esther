package com.facebook.ads.redexgen.core;

import android.os.Handler;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.la, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2865la implements AN {
    public final /* synthetic */ C0O A00;

    public C2865la(C0O c0o, AO ao) {
        this.A00 = c0o;
        ao.AIq(this, new Handler());
    }

    @Override // com.facebook.ads.redexgen.core.AN
    public final void ADL(AO ao, long j10, long j11) {
        if (this != this.A00.A00) {
            return;
        }
        this.A00.A27();
    }
}
