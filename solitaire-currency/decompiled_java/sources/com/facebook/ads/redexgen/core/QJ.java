package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class QJ {
    public int A00;
    public int A01;
    public int A02;
    public int A03;

    private final QJ A00(AbstractC1934Qg abstractC1934Qg, int i10) {
        View view = abstractC1934Qg.A0H;
        this.A01 = view.getLeft();
        this.A03 = view.getTop();
        this.A02 = view.getRight();
        this.A00 = view.getBottom();
        return this;
    }

    public final QJ A01(AbstractC1934Qg abstractC1934Qg) {
        return A00(abstractC1934Qg, 0);
    }
}
