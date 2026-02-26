package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class EL {
    public static String[] A05 = {"LpJTwMN2G", "VgMO4aUKUhad1vQS8qeWccWG6TZwybQB", "ACcLkDhyx", "Vz4L8Yk2qa8xi00BpA99exXw347yn2OW", "M93qmyVYUpuFuHp", "Ixo", "WCFkueysi57ip8GEP7BFiSRGMX4T5ofH", "LFY6A3GYQmBEHARGrOHSwwc2jPi1aXj0"};
    public final int A00;
    public final C3019o6 A01;
    public final Object A02;
    public final C7G[] A03;
    public final InterfaceC2874lj[] A04;

    public EL(C7G[] c7gArr, InterfaceC2874lj[] interfaceC2874ljArr, C3019o6 c3019o6, Object obj) {
        this.A03 = c7gArr;
        this.A04 = (InterfaceC2874lj[]) interfaceC2874ljArr.clone();
        this.A01 = c3019o6;
        this.A02 = obj;
        this.A00 = c7gArr.length;
    }

    public final boolean A00(int i10) {
        return this.A03[i10] != null;
    }

    public final boolean A01(EL el, int i10) {
        if (el == null) {
            return false;
        }
        C7G[] c7gArr = this.A03;
        if (A05[5].length() == 3) {
            A05[1] = "2a41zxf8OUQisEdMYeAN8aC4JNcLEgEy";
            if (!AbstractC13764a.A1E(c7gArr[i10], el.A03[i10])) {
                return false;
            }
            InterfaceC2874lj interfaceC2874lj = this.A04[i10];
            InterfaceC2874lj interfaceC2874lj2 = el.A04[i10];
            String[] strArr = A05;
            if (strArr[2].length() == strArr[0].length()) {
                A05[4] = "ShAZgc6gkhlm9OR";
                return AbstractC13764a.A1E(interfaceC2874lj, interfaceC2874lj2);
            }
        }
        throw new RuntimeException();
    }
}
