package com.facebook.ads.redexgen.core;

import android.view.View;
import java.util.Iterator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC2196aF implements View.OnClickListener {
    public final /* synthetic */ C2199aI A00;

    public ViewOnClickListenerC2196aF(C2199aI c2199aI) {
        this.A00 = c2199aI;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A05.AE7();
            if (this.A00.A00 != null) {
                XP.A0J(this.A00.A00);
            }
            Iterator it = this.A00.A07.iterator();
            while (it.hasNext()) {
                XP.A0L((View) it.next(), 0);
            }
            XP.A0H(this.A00);
            if (this.A00.A06 == null) {
                return;
            }
            XP.A0L(this.A00.A06, 0);
            this.A00.A06.A0h(EnumC2403db.A02, 14);
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
