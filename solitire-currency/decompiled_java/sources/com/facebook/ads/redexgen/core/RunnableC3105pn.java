package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.pn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC3105pn implements Runnable {
    public final /* synthetic */ int A00;
    public final /* synthetic */ C3104pm A01;
    public final /* synthetic */ Exception A02;

    public RunnableC3105pn(C3104pm c3104pm, int i10, Exception exc) {
        this.A01 = c3104pm;
        this.A00 = i10;
        this.A02 = exc;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            try {
                if (this.A01.A01) {
                    if (!A8.A07 || !this.A01.A08()) {
                        this.A01.A05(this.A01.A05.AC6());
                        this.A01.A04.postDelayed(this.A01.A0A, this.A00);
                    } else {
                        this.A01.A0C();
                    }
                }
            } catch (Exception ex) {
                ex.initCause(this.A02);
                throw ex;
            }
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
