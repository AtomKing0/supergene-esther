package com.facebook.ads.redexgen.core;

import com.google.common.primitives.ElementTypesAreNonnullByDefault;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.q7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractC3120q7 {
    public static int A00(long value) {
        return (int) ((value >>> 32) ^ value);
    }

    public static int A01(long a10, long b10) {
        if (a10 < b10) {
            return -1;
        }
        return a10 > b10 ? 1 : 0;
    }
}
