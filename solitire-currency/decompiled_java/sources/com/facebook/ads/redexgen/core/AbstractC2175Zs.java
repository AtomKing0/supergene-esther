package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2175Zs {
    public static void A00(View view, boolean z10, View.OnClickListener onClickListener) {
        if (!z10) {
            view.setOnClickListener(onClickListener);
        } else {
            if (!z10) {
                return;
            }
            ViewOnClickListenerC2174Zr viewOnClickListenerC2174Zr = new ViewOnClickListenerC2174Zr(onClickListener);
            view.setOnClickListener(viewOnClickListenerC2174Zr);
            view.setOnTouchListener(new ViewOnTouchListenerC2173Zq(viewOnClickListenerC2174Zr));
        }
    }
}
