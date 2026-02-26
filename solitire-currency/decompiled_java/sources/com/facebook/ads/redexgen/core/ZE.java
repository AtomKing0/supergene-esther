package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class ZE implements View.OnClickListener {
    public final /* synthetic */ ZH A00;

    public ZE(ZH zh) {
        this.A00 = zh;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            if (!this.A00.A08.canGoForward()) {
                return;
            }
            this.A00.A08.goForward();
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
