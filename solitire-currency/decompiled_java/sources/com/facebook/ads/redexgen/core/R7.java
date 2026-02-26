package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class R7 implements View.OnLongClickListener {
    public final /* synthetic */ C2540fq A00;
    public final /* synthetic */ C2169Zm A01;

    public R7(C2540fq c2540fq, C2169Zm c2169Zm) {
        this.A00 = c2540fq;
        this.A01 = c2169Zm;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        if (this.A00.A00 != null) {
            this.A01.setBounds(0, 0, this.A00.A00.getWidth(), this.A00.A00.getHeight());
            this.A01.A0D(!this.A01.A0E());
        }
        return true;
    }
}
