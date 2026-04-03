package com.facebook.ads.redexgen.core;

import android.widget.RelativeLayout;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2073Vs extends RelativeLayout {
    public static final AtomicBoolean A00 = new AtomicBoolean();
    public static final AtomicReference<InterfaceC2064Vj> A01 = new AtomicReference<>();

    public static void A00(boolean z10, InterfaceC2064Vj interfaceC2064Vj) {
        A00.set(z10);
        A01.set(interfaceC2064Vj);
    }
}
