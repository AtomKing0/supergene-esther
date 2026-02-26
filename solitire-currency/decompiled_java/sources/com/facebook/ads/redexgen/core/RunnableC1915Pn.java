package com.facebook.ads.redexgen.core;

import java.util.ArrayList;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1915Pn implements Runnable {
    public final /* synthetic */ C14376j A00;
    public final /* synthetic */ ArrayList A01;

    public RunnableC1915Pn(C14376j c14376j, ArrayList arrayList) {
        this.A00 = c14376j;
        this.A01 = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (C1924Pw c1924Pw : this.A01) {
            this.A00.A0e(c1924Pw.A04, c1924Pw.A00, c1924Pw.A01, c1924Pw.A02, c1924Pw.A03);
        }
        this.A01.clear();
        this.A00.A05.remove(this.A01);
    }
}
