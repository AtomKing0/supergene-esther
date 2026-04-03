package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class VX {
    public final TE A00;
    public final VW A01;
    public final String A02;

    public VX(VW vw) {
        this(vw, null, null);
    }

    public VX(VW vw, TE te, String str) {
        this.A01 = vw;
        this.A00 = te;
        this.A02 = str;
    }

    public TE A00() {
        return this.A00;
    }

    public final VW A01() {
        return this.A01;
    }

    public final String A02() {
        return this.A02;
    }
}
