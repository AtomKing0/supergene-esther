package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bE, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC2257bE implements View.OnClickListener {
    public final /* synthetic */ JR A00;

    public ViewOnClickListenerC2257bE(JR jr) {
        this.A00 = jr;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            if (this.A00.A03 == null || this.A00.A03.getVisibility() != 8) {
                this.A00.A0O();
                this.A00.A0A.removeCallbacks(this.A00.A0U);
                this.A00.A0S(8);
            } else {
                this.A00.A0S(0);
                this.A00.A0A.postDelayed(this.A00.A0U, 1500L);
            }
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
