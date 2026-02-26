package com.facebook.ads.redexgen.core;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class W0 {
    public static final AtomicReference<InterfaceC2080Vz> A00 = new AtomicReference<>(null);

    public static InterfaceC2080Vz A00() {
        InterfaceC2080Vz errorLogger = A00.get();
        if (errorLogger == null) {
            return new PR();
        }
        return errorLogger;
    }

    public static void A01(InterfaceC2080Vz interfaceC2080Vz) {
        A00.set(interfaceC2080Vz);
    }
}
