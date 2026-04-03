package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC2150Yt implements View.OnClickListener {
    public final /* synthetic */ C2152Yv A00;

    public ViewOnClickListenerC2150Yt(C2152Yv c2152Yv) {
        this.A00 = c2152Yv;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A02.A9U();
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
