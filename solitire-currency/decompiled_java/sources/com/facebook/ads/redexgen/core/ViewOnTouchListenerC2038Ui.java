package com.facebook.ads.redexgen.core;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ui, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnTouchListenerC2038Ui implements View.OnTouchListener {
    public final /* synthetic */ TD A00;
    public final /* synthetic */ boolean A01;

    public ViewOnTouchListenerC2038Ui(TD td, boolean z10) {
        this.A00 = td;
        this.A01 = z10;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.A01) {
            return false;
        }
        return true;
    }
}
