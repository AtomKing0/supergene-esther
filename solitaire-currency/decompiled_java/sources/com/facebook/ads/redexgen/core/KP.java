package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class KP {
    public static String[] A0G = {"4S0ZR9", "9atY4pLS3", "JCkQ", "0FGnuhRUJbXFjAeocMQA4", "Bc2FjzyWuEwoYoDKosvue", "DSb6itpNp95G1DjaOdl5F45O", "d2IfSwPvc8yd2jGVLBTV47FBT3G8Pl4J", "SXUDcryZ"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public C1687Gp A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public boolean A0D;
    public boolean A0E;
    public boolean A0F;

    public KP() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A00(KP kp) {
        if (!this.A0F) {
            return false;
        }
        if (!kp.A0F) {
            return true;
        }
        C1687Gp c1687Gp = (C1687Gp) C3M.A02(this.A09);
        C1687Gp spsData = kp.A09;
        C1687Gp otherSpsData = (C1687Gp) C3M.A02(spsData);
        if (this.A03 == kp.A03 && this.A07 == kp.A07 && this.A0C == kp.A0C && ((!this.A0B || !kp.A0B || this.A0A == kp.A0A) && ((this.A05 == kp.A05 || (this.A05 != 0 && kp.A05 != 0)) && ((c1687Gp.A07 != 0 || otherSpsData.A07 != 0 || (this.A06 == kp.A06 && this.A02 == kp.A02)) && ((c1687Gp.A07 != 1 || otherSpsData.A07 != 1 || (this.A00 == kp.A00 && this.A01 == kp.A01)) && this.A0E == kp.A0E))))) {
            boolean z10 = this.A0E;
            if (A0G[6].charAt(8) == '9') {
                throw new RuntimeException();
            }
            A0G[6] = "vYoSPXEMP2H1rloX7Zmdh99svIQCcR37";
            if (!z10 || this.A04 == kp.A04) {
                return false;
            }
        }
        return true;
    }

    public final void A02() {
        this.A0D = false;
        this.A0F = false;
    }

    public final void A03(int i10) {
        this.A08 = i10;
        this.A0D = true;
    }

    public final void A04(C1687Gp c1687Gp, int i10, int i11, int i12, int i13, boolean z10, boolean z11, boolean z12, boolean z13, int i14, int i15, int i16, int i17, int i18) {
        this.A09 = c1687Gp;
        this.A05 = i10;
        this.A08 = i11;
        this.A03 = i12;
        this.A07 = i13;
        this.A0C = z10;
        this.A0B = z11;
        this.A0A = z12;
        this.A0E = z13;
        this.A04 = i14;
        this.A06 = i15;
        this.A02 = i16;
        this.A00 = i17;
        this.A01 = i18;
        this.A0F = true;
        this.A0D = true;
    }

    public final boolean A05() {
        return this.A0D && (this.A08 == 7 || this.A08 == 2);
    }
}
