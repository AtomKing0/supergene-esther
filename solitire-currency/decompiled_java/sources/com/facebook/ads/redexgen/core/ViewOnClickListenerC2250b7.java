package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.b7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC2250b7 implements View.OnClickListener {
    public final /* synthetic */ JU A00;

    public ViewOnClickListenerC2250b7(JU ju) {
        this.A00 = ju;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            if (!this.A00.A0Q) {
                this.A00.A0R = true;
                this.A00.A0f(((C7P) this.A00.A0h).A0M().toString());
                if (this.A00.A0H.A0n() >= 0) {
                    this.A00.A09.postDelayed(this.A00.A0o, this.A00.A0H.A0n());
                }
            }
            this.A00.A0i(this.A00.A0Q ? false : true);
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
