package com.facebook.ads.redexgen.core;

import androidx.media3.extractor.ts.PsExtractor;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2822kg implements IL {
    public int A00;
    public int A01;
    public final int A02;
    public final int A03;
    public final C4J A04;

    public C2822kg(C2824ki c2824ki) {
        this.A04 = c2824ki.A00;
        this.A04.A0f(12);
        this.A02 = this.A04.A0L() & 255;
        this.A03 = this.A04.A0L();
    }

    @Override // com.facebook.ads.redexgen.core.IL
    public final int A82() {
        return -1;
    }

    @Override // com.facebook.ads.redexgen.core.IL
    public final int A8n() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.core.IL
    public final int AGi() {
        if (this.A02 == 8) {
            return this.A04.A0I();
        }
        if (this.A02 == 16) {
            return this.A04.A0M();
        }
        int i10 = this.A01;
        this.A01 = i10 + 1;
        if (i10 % 2 == 0) {
            this.A00 = this.A04.A0I();
            return (this.A00 & PsExtractor.VIDEO_STREAM_MASK) >> 4;
        }
        return this.A00 & 15;
    }
}
