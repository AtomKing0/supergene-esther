package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC2114Xj implements View.OnClickListener {
    public final /* synthetic */ N9 A00;
    public final /* synthetic */ C2030Ua A01;
    public final /* synthetic */ C2115Xk A02;
    public final /* synthetic */ InterfaceC2118Xn A03;
    public final /* synthetic */ String A04;

    public ViewOnClickListenerC2114Xj(C2115Xk c2115Xk, C2030Ua c2030Ua, InterfaceC2118Xn interfaceC2118Xn, String str, N9 n92) {
        this.A02 = c2115Xk;
        this.A01 = c2030Ua;
        this.A03 = interfaceC2118Xn;
        this.A04 = str;
        this.A00 = n92;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            this.A01.A04(UZ.A0A, null);
            if (this.A02.A02.A0O(this.A02.A03.A02(), true)) {
                this.A03.AAf(this.A04, this.A00);
            } else if (!TextUtils.isEmpty(this.A00.A00())) {
                WN.A0O(new WN(), this.A02.A03, WQ.A00(this.A00.A00()), this.A04);
            }
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
