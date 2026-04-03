package com.facebook.ads.redexgen.core;

import java.io.Serializable;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class NF implements Serializable {
    public static final long serialVersionUID = 42;
    public final String A00;
    public final String A01;
    public final String A02;
    public final String A03;

    public NF(NE ne) {
        this.A02 = ne.A02;
        this.A03 = ne.A03;
        this.A01 = ne.A01;
        this.A00 = ne.A00;
    }

    public final String A00() {
        return this.A00;
    }

    public final String A01() {
        return this.A01;
    }

    public final String A02() {
        return this.A02;
    }
}
