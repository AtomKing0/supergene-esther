package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class YC implements View.OnClickListener {
    public final /* synthetic */ C1803Lc A00;

    public YC(C1803Lc c1803Lc) {
        this.A00 = c1803Lc;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A0N.A04(UZ.A07, null);
            this.A00.A0Q.A4b(this.A00.A0R.A7o());
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
