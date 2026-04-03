package com.facebook.ads.redexgen.core;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.eN, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnTouchListenerC2450eN implements View.OnTouchListener {
    public final /* synthetic */ CM A00;

    public ViewOnTouchListenerC2450eN(CM cm) {
        this.A00 = cm;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.A00.A09 != null && motionEvent.getAction() == 1) {
            if (this.A00.A09.isShowing()) {
                this.A00.A09.hide();
            } else {
                this.A00.A09.show();
            }
        }
        return true;
    }
}
