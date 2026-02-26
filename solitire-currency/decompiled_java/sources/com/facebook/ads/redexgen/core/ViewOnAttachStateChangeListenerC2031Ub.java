package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ub, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnAttachStateChangeListenerC2031Ub implements View.OnAttachStateChangeListener {
    public final /* synthetic */ UZ A00;
    public final /* synthetic */ C2030Ua A01;

    public ViewOnAttachStateChangeListenerC2031Ub(C2030Ua c2030Ua, UZ uz) {
        this.A01 = c2030Ua;
        this.A00 = uz;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.A01.A04(this.A00, null);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
