package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class ZJ implements View.OnClickListener {
    public final /* synthetic */ ZO A00;

    public ZJ(ZO zo) {
        this.A00 = zo;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A0A.A0F().A9o();
            if (this.A00.A05 == null) {
                return;
            }
            this.A00.A05.ACl();
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
