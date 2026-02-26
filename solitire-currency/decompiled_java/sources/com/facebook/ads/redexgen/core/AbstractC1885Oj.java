package com.facebook.ads.redexgen.core;

import android.view.MotionEvent;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Oj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1885Oj {
    public static boolean A00(MotionEvent motionEvent, int i10) {
        return (motionEvent.getSource() & i10) == i10;
    }
}
