package com.facebook.ads.redexgen.core;

import java.util.Objects;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lD, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2843lD extends GQ {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2843lD(final C1679Gh c1679Gh, int i10, long j10, long j11) {
        super(new GL() { // from class: com.facebook.ads.redexgen.X.lF
            @Override // com.facebook.ads.redexgen.core.GL
            public final long AJf(long j12) {
                return c1679Gh.A07(j12);
            }
        }, new C2844lE(c1679Gh, i10), c1679Gh.A06(), 0L, c1679Gh.A09, j10, j11, c1679Gh.A05(), Math.max(6, c1679Gh.A06));
        Objects.requireNonNull(c1679Gh);
    }
}
