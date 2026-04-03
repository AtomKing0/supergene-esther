package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC2146Yp implements View.OnClickListener {
    public final /* synthetic */ C2138Yh A00;
    public final /* synthetic */ LU A01;

    public ViewOnClickListenerC2146Yp(LU lu, C2138Yh c2138Yh) {
        this.A01 = lu;
        this.A00 = c2138Yh;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A01();
            this.A01.A0B.AAh();
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
