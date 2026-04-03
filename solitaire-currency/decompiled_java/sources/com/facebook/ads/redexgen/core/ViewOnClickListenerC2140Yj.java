package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC2140Yj implements View.OnClickListener {
    public final /* synthetic */ LV A00;

    public ViewOnClickListenerC2140Yj(LV lv) {
        this.A00 = lv;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A0B.AEC(O4.A04);
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
