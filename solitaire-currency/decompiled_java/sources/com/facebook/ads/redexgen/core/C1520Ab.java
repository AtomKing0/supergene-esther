package com.facebook.ads.redexgen.core;

import java.util.Collection;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ab, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1520Ab extends AbstractC3028oF<Object> {
    public final /* synthetic */ int A00;

    public C1520Ab(final int val$expectedKeys) {
        this.A00 = val$expectedKeys;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC3028oF
    public final <K, V> Map<K, Collection<V>> A04() {
        return AbstractC3045oY.A00(this.A00);
    }
}
