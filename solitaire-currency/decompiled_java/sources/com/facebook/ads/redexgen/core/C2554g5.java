package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.g5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2554g5 implements InterfaceC1937Qj {
    public final /* synthetic */ QO A00;

    public C2554g5(QO qo) {
        this.A00 = qo;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1937Qj
    public final View A79(int i10) {
        return this.A00.A0v(i10);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1937Qj
    public final int A7B(View view) {
        return this.A00.A0l(view) + ((QP) view.getLayoutParams()).bottomMargin;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1937Qj
    public final int A7C(View view) {
        return this.A00.A0q(view) - ((QP) view.getLayoutParams()).topMargin;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1937Qj
    public final int A8Y() {
        return this.A00.A0Z() - this.A00.A0f();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1937Qj
    public final int A8Z() {
        return this.A00.A0i();
    }
}
