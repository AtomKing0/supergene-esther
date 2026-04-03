package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bH, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC2260bH implements View.OnClickListener {
    public final /* synthetic */ JR A00;

    public ViewOnClickListenerC2260bH(JR jr) {
        this.A00 = jr;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            if (this.A00.A07 != null) {
                this.A00.A07.AJF();
            }
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
