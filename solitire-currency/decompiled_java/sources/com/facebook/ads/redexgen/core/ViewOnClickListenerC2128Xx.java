package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC2128Xx implements View.OnClickListener {
    public final /* synthetic */ C1869Nr A00;

    public ViewOnClickListenerC2128Xx(C1869Nr c1869Nr) {
        this.A00 = c1869Nr;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            if (this.A00.A01 != null && this.A00.A02.A02()) {
                this.A00.A01.ACC(this.A00);
            }
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
