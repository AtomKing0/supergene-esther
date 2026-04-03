package com.facebook.ads.redexgen.core;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnTouchListenerC2173Zq implements View.OnTouchListener {
    public final /* synthetic */ ViewOnClickListenerC2174Zr A00;

    public ViewOnTouchListenerC2173Zq(ViewOnClickListenerC2174Zr viewOnClickListenerC2174Zr) {
        this.A00 = viewOnClickListenerC2174Zr;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.A00.A00(motionEvent.getX(), motionEvent.getY());
            return false;
        }
        return false;
    }
}
