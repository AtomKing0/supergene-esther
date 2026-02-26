package com.facebook.ads.redexgen.core;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.da, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2402da extends ContentObserver {
    public final C1596Dc A00;

    public C2402da(Handler handler, C1596Dc c1596Dc) {
        super(handler);
        this.A00 = c1596Dc;
    }

    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        return false;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z10) {
        this.A00.A0f();
    }
}
