package com.facebook.ads.redexgen.core;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Op, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1891Op extends AbstractRunnableC2074Vt {
    public final /* synthetic */ DialogInterface A00;
    public final /* synthetic */ DialogInterfaceOnClickListenerC2107Xc A01;

    public C1891Op(DialogInterfaceOnClickListenerC2107Xc dialogInterfaceOnClickListenerC2107Xc, DialogInterface dialogInterface) {
        this.A01 = dialogInterfaceOnClickListenerC2107Xc;
        this.A00 = dialogInterface;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC2074Vt
    public final void A07() {
        if (this.A01.A01.A02 != null) {
            this.A01.A01.A02.AGD(VZ.A03(this.A01.A01.A00), new C2480er().A05(this.A01.A01.A02(this.A01.A00.getText().toString())).A08());
        }
        this.A00.cancel();
    }
}
