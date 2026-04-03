package com.facebook.ads.redexgen.core;

import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1863Nl {

    @Nullable
    public static HandlerC1862Nk A00;
    public static final AtomicBoolean A01 = new AtomicBoolean();

    public static HandlerC1862Nk A00(C2361cu c2361cu) {
        if (A00 == null) {
            A00 = new HandlerC1862Nk(c2361cu);
        }
        return A00;
    }

    public static void A01(C2361cu c2361cu) {
        if (UA.A0F(c2361cu)) {
            A03(c2361cu);
        }
    }

    public static void A02(C2361cu c2361cu) {
        if (UA.A0E(c2361cu)) {
            A03(c2361cu);
        }
    }

    public static void A03(C2361cu c2361cu) {
        if (A01.compareAndSet(false, true)) {
            XJ.A01.execute(new C2597go(c2361cu));
        }
    }
}
