package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class YR implements View.OnClickListener {
    public final /* synthetic */ LZ A00;

    public YR(LZ lz) {
        this.A00 = lz;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A07.ADH();
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
