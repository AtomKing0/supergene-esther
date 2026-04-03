package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.a3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC2186a3 implements View.OnClickListener {
    public final /* synthetic */ KG A00;

    public ViewOnClickListenerC2186a3(KG kg) {
        this.A00 = kg;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A02();
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
