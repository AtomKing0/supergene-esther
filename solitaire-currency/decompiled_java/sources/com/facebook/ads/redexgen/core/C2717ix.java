package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ix, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2717ix implements InterfaceC13984w {
    public static String[] A08 = {"FmqEYLEjOBovlIuvu7xTusZ6GIuR3pge", "QeU0DUuOAkxor0HSqOzEAO6P6r4bp110", "WNDsEfwHyCZVTn6rYNycLV5FNYvDeUGR", "", "9kl6sBOZXnbWpCxdvxnR8wYz13jzyZGc", "QdIGCZBZzwjOBdbigrYBFiKU6cV", "ZYM92CzuhlmQLmzBChoRToTytAMTrYW0", "W1yocJmlBB3ILJesLtmFt5l7ilHzoTT3"};
    public int A00;
    public int A01;
    public InterfaceC13954t A02;
    public InterfaceC13984w A04;
    public InterfaceC1814Ln A05;
    public boolean A07;
    public InterfaceC13984w A03 = new C2995nh();
    public InterfaceC1823Lw A06 = InterfaceC1823Lw.A00;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.InterfaceC13984w
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final C7S A5A() {
        return A01(this.A04 != null ? this.A04.A5A() : null, this.A00, this.A01);
    }

    private C7S A01(InterfaceC2999nl interfaceC2999nl, int i10, int i11) {
        C2718iy c2718iyA59;
        InterfaceC1814Ln interfaceC1814Ln = (InterfaceC1814Ln) C3M.A01(this.A05);
        if (this.A07 || interfaceC2999nl == null) {
            c2718iyA59 = null;
        } else if (this.A02 != null) {
            InterfaceC13954t interfaceC13954t = this.A02;
            String[] strArr = A08;
            if (strArr[6].charAt(29) == strArr[7].charAt(29)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[0] = "BsDku37cs2h0edzjFuAGMntAOCTwp5qB";
            strArr2[1] = "0s0KxP1bBIf3QxkhX8XEl0TpXhOFUtvY";
            c2718iyA59 = interfaceC13954t.A59();
        } else {
            c2718iyA59 = new C2719iz().A00(interfaceC1814Ln).A59();
        }
        return new C7S(interfaceC1814Ln, interfaceC2999nl, this.A03.A5A(), c2718iyA59, this.A06, i10, null, i11, null);
    }

    public final AnonymousClass31 A02() {
        return null;
    }

    public final C2717ix A03(int i10) {
        this.A00 = i10;
        return this;
    }

    public final C2717ix A04(InterfaceC13984w interfaceC13984w) {
        this.A03 = interfaceC13984w;
        return this;
    }

    public final C2717ix A05(InterfaceC13984w interfaceC13984w) {
        this.A04 = interfaceC13984w;
        return this;
    }

    public final C2717ix A06(InterfaceC1814Ln interfaceC1814Ln) {
        this.A05 = interfaceC1814Ln;
        return this;
    }

    public final C7S A07() {
        return A01(this.A04 != null ? this.A04.A5A() : null, this.A00 | 1, -1000);
    }
}
