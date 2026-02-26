package com.facebook.ads.redexgen.core;

import android.database.DataSetObserver;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class PE extends DataSetObserver {
    public final /* synthetic */ PH A00;

    public PE(PH ph) {
        this.A00 = ph;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        this.A00.A0e();
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        this.A00.A0e();
    }
}
