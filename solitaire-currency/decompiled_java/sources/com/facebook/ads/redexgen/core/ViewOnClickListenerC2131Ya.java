package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ya, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC2131Ya implements View.OnClickListener {
    public final /* synthetic */ C2133Yc A00;

    public ViewOnClickListenerC2131Ya(C2133Yc c2133Yc) {
        this.A00 = c2133Yc;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A04.AAg();
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
