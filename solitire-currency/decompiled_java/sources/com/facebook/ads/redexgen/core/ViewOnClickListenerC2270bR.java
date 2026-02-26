package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bR, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC2270bR implements View.OnClickListener {
    public final /* synthetic */ C1741Is A00;

    public ViewOnClickListenerC2270bR(C1741Is c1741Is) {
        this.A00 = c1741Is;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        Uri uriA0M;
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            if (this.A00.A0X != null && (uriA0M = ((C7P) this.A00.A0X).A0M()) != null) {
                if (!this.A00.A0D) {
                    this.A00.A0E = true;
                    this.A00.A0j(uriA0M.toString());
                    if (this.A00.A0c.A0E() != null) {
                        this.A00.A0c.A0E().ABr();
                    }
                    if (this.A00.A0Y.A0n() >= 0) {
                        this.A00.A0S.postDelayed(this.A00.A0d, this.A00.A0Y.A0n());
                    }
                }
                this.A00.A0n(this.A00.A0D ? false : true);
            }
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
