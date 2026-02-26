package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class YU implements InterfaceC2064Vj {
    @Override // com.facebook.ads.redexgen.core.InterfaceC2064Vj
    public final void AHp(Throwable th, Object obj) {
        if (obj instanceof SM) {
            C2387dL adContext = ((SM) obj).A6e();
            if (adContext != null) {
                adContext.A0Q(th);
                return;
            }
            return;
        }
        if (!(obj instanceof View)) {
            return;
        }
        Context context = ((View) obj).getContext();
        if (!(context instanceof C2387dL)) {
            return;
        }
        ((C2387dL) context).A0Q(th);
    }
}
