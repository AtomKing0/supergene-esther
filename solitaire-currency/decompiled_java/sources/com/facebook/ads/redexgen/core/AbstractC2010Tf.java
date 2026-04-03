package com.facebook.ads.redexgen.core;

import com.facebook.ads.redexgen.core.C2008Td;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2010Tf<T extends C2008Td> {
    public abstract Class<T> A01();

    public abstract void A03(T t10);

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Tf != com.facebook.ads.internal.events.EventSubscriber<T extends com.facebook.ads.redexgen.X.Td> */
    public final boolean A00(T event) {
        return true;
    }
}
