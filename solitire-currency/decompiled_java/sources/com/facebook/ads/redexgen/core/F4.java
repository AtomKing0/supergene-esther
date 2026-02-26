package com.facebook.ads.redexgen.core;

import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class F4 extends QC<C1641Ev> {
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public AbstractC2117Xm A04;
    public InterfaceC2118Xn A05;
    public String A06;
    public List<C2354cn> A07;
    public boolean A08;
    public final SparseBooleanArray A09 = new SparseBooleanArray();
    public final AbstractC2662hy A0A;
    public final SF A0B;
    public final C2387dL A0C;
    public final US A0D;
    public final XH A0E;
    public final FH A0F;
    public final C2460eX A0G;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 18 out of bounds for length 18
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public F4(C2387dL c2387dL, List<C2354cn> list, AbstractC2662hy abstractC2662hy, US us, SF sf, C2460eX c2460eX, XH xh, InterfaceC2118Xn interfaceC2118Xn, String str, int i10, int i11, int i12, int i13, FH fh, AbstractC2117Xm abstractC2117Xm) {
        this.A0C = c2387dL;
        this.A0D = us;
        this.A0B = sf;
        this.A0G = c2460eX;
        this.A0E = xh;
        this.A05 = interfaceC2118Xn;
        this.A0A = abstractC2662hy;
        this.A07 = list;
        this.A00 = i10;
        this.A03 = i13;
        this.A06 = str;
        this.A01 = i12;
        this.A02 = i11;
        this.A0F = fh;
        this.A04 = abstractC2117Xm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.QC
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final C1641Ev A0F(ViewGroup viewGroup, int i10) {
        return new C1641Ev(AbstractC2284bf.A00(new C2224ah(this.A0C, this.A0D, this.A05, this.A0A, null, this.A0G, this.A0E).A0R(this.A04).A0W(), this.A03, this.A06, this.A0F), this.A09, this.A0G, this.A00, this.A01, this.A02, this.A07.size(), this.A0C, this.A0A.A21());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.QC
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final void A0K(C1641Ev c1641Ev, int i10) {
        c1641Ev.A0q(this.A07.get(i10), this.A0D, this.A0B, this.A0E, this.A06);
        if (!this.A08 && i10 == 0) {
            c1641Ev.AIV();
            this.A08 = true;
        }
    }

    @Override // com.facebook.ads.redexgen.core.QC
    public final int A0B() {
        return this.A07.size();
    }
}
