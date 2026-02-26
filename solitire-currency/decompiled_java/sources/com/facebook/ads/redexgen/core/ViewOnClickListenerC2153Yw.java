package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC2153Yw implements View.OnClickListener {
    public final /* synthetic */ LS A00;

    public ViewOnClickListenerC2153Yw(LS ls) {
        this.A00 = ls;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A0B.A9U();
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
