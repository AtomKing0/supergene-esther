package com.facebook.ads.redexgen.core;

import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class LE extends QC<FD> {
    public int A00;
    public int A01;
    public int A02;
    public InterfaceC2118Xn A03;
    public C2460eX A04;
    public String A05;
    public List<C2354cn> A06;
    public final SparseBooleanArray A07 = new SparseBooleanArray();
    public final AbstractC2662hy A08;
    public final SF A09;
    public final C2387dL A0A;
    public final US A0B;
    public final C1930Qc A0C;
    public final XH A0D;
    public final C14205s A0E;
    public final C1590Cw A0F;

    public LE(C2387dL c2387dL, List<C2354cn> list, AbstractC2662hy abstractC2662hy, US us, C1930Qc c1930Qc, InterfaceC2118Xn interfaceC2118Xn, String str, C14205s c14205s, C1590Cw c1590Cw) {
        this.A0A = c2387dL;
        this.A0B = us;
        this.A0C = c1930Qc;
        this.A09 = c1930Qc.A11();
        this.A04 = c1930Qc.A1B();
        this.A0D = c1930Qc.A1A();
        this.A03 = interfaceC2118Xn;
        this.A08 = abstractC2662hy;
        this.A06 = list;
        this.A05 = str;
        this.A0E = c14205s;
        this.A0F = c1590Cw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.QC
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final FD A0F(ViewGroup viewGroup, int i10) {
        return new FD(AbstractC2188a6.A00(new C2224ah(this.A0A, this.A0B, this.A03, this.A08, null, this.A04, this.A0D).A0T(this.A0F).A0O(this.A0C).A0W(), this.A0C, this.A05, this.A0E), this.A07, this.A04, this.A06.size(), this.A0A, this.A08.A21());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.QC
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final void A0K(FD fd, int i10) {
        C2354cn c2354cn = this.A06.get(i10);
        fd.A0q(this.A04);
        fd.A0p(c2354cn, this.A0B, this.A09, this.A0D, this.A05, this.A00, this.A02, this.A01);
    }

    @Override // com.facebook.ads.redexgen.core.QC
    public final int A0B() {
        return this.A06.size();
    }

    public final void A0O(int i10, int i11, int i12) {
        boolean needsUpdate = i10 != this.A00;
        this.A00 = i10;
        this.A02 = i11;
        this.A01 = i12;
        if (needsUpdate) {
            A0G();
        }
    }

    public final void A0P(C2460eX c2460eX) {
        this.A04 = c2460eX;
    }
}
