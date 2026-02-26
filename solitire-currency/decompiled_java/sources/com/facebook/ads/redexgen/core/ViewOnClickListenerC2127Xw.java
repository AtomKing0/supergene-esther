package com.facebook.ads.redexgen.core;

import android.view.View;
import com.facebook.ads.internal.view.FullScreenAdToolbar;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC2127Xw implements View.OnClickListener {
    public final /* synthetic */ FullScreenAdToolbar A00;

    public ViewOnClickListenerC2127Xw(FullScreenAdToolbar fullScreenAdToolbar) {
        this.A00 = fullScreenAdToolbar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            if (this.A00.A02 != null && this.A00.A09.A06()) {
                this.A00.A02.ACC(this.A00);
            }
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
