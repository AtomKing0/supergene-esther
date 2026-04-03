package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class Y6 implements View.OnClickListener {
    public final /* synthetic */ Y9 A00;

    public Y6(Y9 y92) {
        this.A00 = y92;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A0D();
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
