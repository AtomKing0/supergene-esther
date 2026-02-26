package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.extractor.mkv.MatroskaExtractor;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2830kp implements I8 {
    public final /* synthetic */ MatroskaExtractor A00;

    public C2830kp(MatroskaExtractor matroskaExtractor) {
        this.A00 = matroskaExtractor;
    }

    @Override // com.facebook.ads.redexgen.core.I8
    public final void A4a(int i10, int i11, InterfaceC2853lN interfaceC2853lN) throws IOException {
        this.A00.A0U(i10, i11, interfaceC2853lN);
    }

    @Override // com.facebook.ads.redexgen.core.I8
    public final void A6F(int i10) throws C13322i {
        this.A00.A0S(i10);
    }

    @Override // com.facebook.ads.redexgen.core.I8
    public final void A6S(int i10, double d10) throws C13322i {
        this.A00.A0T(i10, d10);
    }

    @Override // com.facebook.ads.redexgen.core.I8
    public final int A7m(int i10) {
        return this.A00.A0R(i10);
    }

    @Override // com.facebook.ads.redexgen.core.I8
    public final void AA9(int i10, long j10) throws C13322i {
        this.A00.A0V(i10, j10);
    }

    @Override // com.facebook.ads.redexgen.core.I8
    public final boolean AAN(int i10) {
        return this.A00.A0Y(i10);
    }

    @Override // com.facebook.ads.redexgen.core.I8
    public final void AJO(int i10, long j10, long j11) throws C13322i {
        this.A00.A0W(i10, j10, j11);
    }

    @Override // com.facebook.ads.redexgen.core.I8
    public final void AJZ(int i10, String str) throws C13322i {
        this.A00.A0X(i10, str);
    }
}
