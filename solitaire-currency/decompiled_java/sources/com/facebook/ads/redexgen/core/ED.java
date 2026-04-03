package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class ED extends AbstractRunnableC2074Vt {
    public final /* synthetic */ int A00;
    public final /* synthetic */ int A01;
    public final /* synthetic */ E1 A02;
    public final /* synthetic */ EnumC2457eU A03;

    public ED(E1 e12, EnumC2457eU enumC2457eU, int i10, int i11) {
        this.A02 = e12;
        this.A03 = enumC2457eU;
        this.A00 = i10;
        this.A01 = i11;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC2074Vt
    public final void A07() {
        if (this.A03 == EnumC2457eU.A07) {
            this.A02.A0M(UZ.A0y);
            this.A02.A0B.A0F().A3b();
            this.A02.A0C.A02(E1.A0J);
            return;
        }
        if (this.A03 == EnumC2457eU.A03) {
            this.A02.A0M(UZ.A0t);
            this.A02.A04 = true;
            this.A02.A0C.A02(E1.A0H);
            this.A02.A0L(this.A00);
            return;
        }
        if (this.A03 == EnumC2457eU.A06) {
            this.A02.A0M(UZ.A0s);
            this.A02.A0B.A0F().A3T();
            this.A02.A04 = true;
            this.A02.A08.removeCallbacksAndMessages(null);
            this.A02.A0C.A02(new C13533d(this.A01, this.A01));
            this.A02.A0L(this.A01);
            return;
        }
        if (this.A03 == EnumC2457eU.A0A) {
            if (U7.A1u(this.A02.A0B)) {
                this.A02.A0B.A0B().AFs();
            }
            this.A02.A0M(UZ.A0w);
            this.A02.A0B.A0F().A3i();
            this.A02.A0C.A02(E1.A0I);
            this.A02.A08.removeCallbacksAndMessages(null);
            this.A02.A0I();
            return;
        }
        if (this.A03 == EnumC2457eU.A05) {
            this.A02.A0M(UZ.A0v);
            this.A02.A0B.A0F().A3X();
            C2009Te c2009Te = this.A02.A0C;
            final int i10 = this.A00;
            c2009Te.A02(new DY(i10) { // from class: com.facebook.ads.redexgen.X.3Y
            });
            this.A02.A08.removeCallbacksAndMessages(null);
            this.A02.A0L(this.A00);
            return;
        }
        if (this.A03 == EnumC2457eU.A04) {
            this.A02.A0M(UZ.A0u);
            this.A02.A0B.A0F().A3U();
            this.A02.A0C.A02(E1.A0L);
            this.A02.A08.removeCallbacksAndMessages(null);
            return;
        }
        if (this.A03 == EnumC2457eU.A09) {
            this.A02.A0M(UZ.A0s);
            this.A02.A0B.A0F().A3d();
            this.A02.A04 = true;
            this.A02.A08.removeCallbacksAndMessages(null);
            this.A02.A0C.A02(new C13533d(this.A00, this.A01));
            this.A02.A0L(this.A00);
        }
    }
}
