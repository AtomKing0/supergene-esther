package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class ZC implements View.OnClickListener {
    public final /* synthetic */ ZH A00;

    public ZC(ZH zh) {
        this.A00 = zh;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A09.A0F().A9o();
            if (this.A00.A04 == null) {
                return;
            }
            this.A00.A04.ACl();
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
