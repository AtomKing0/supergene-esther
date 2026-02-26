package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC2197aG implements View.OnClickListener {
    public final /* synthetic */ C2199aI A00;

    public ViewOnClickListenerC2197aG(C2199aI c2199aI) {
        this.A00 = c2199aI;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A05();
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
