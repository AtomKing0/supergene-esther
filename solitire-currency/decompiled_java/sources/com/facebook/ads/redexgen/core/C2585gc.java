package com.facebook.ads.redexgen.core;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.gc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2585gc<K, V> extends OY<K, V> {
    public final /* synthetic */ C2584gb A00;

    public C2585gc(C2584gb c2584gb) {
        this.A00 = c2584gb;
    }

    @Override // com.facebook.ads.redexgen.core.OY
    public final int A04() {
        return ((C1878Ob) this.A00).A00;
    }

    @Override // com.facebook.ads.redexgen.core.OY
    public final int A05(Object obj) {
        return this.A00.A08(obj);
    }

    @Override // com.facebook.ads.redexgen.core.OY
    public final int A06(Object obj) {
        return this.A00.A07(obj);
    }

    @Override // com.facebook.ads.redexgen.core.OY
    public final Map<K, V> A07() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.OY
    public final Object A0B(int i10, int i11) {
        return this.A00.A02[(i10 << 1) + i11];
    }

    @Override // com.facebook.ads.redexgen.core.OY
    public final V A0C(int i10, V value) {
        return this.A00.A0C(i10, value);
    }

    @Override // com.facebook.ads.redexgen.core.OY
    public final void A0D() {
        this.A00.clear();
    }

    @Override // com.facebook.ads.redexgen.core.OY
    public final void A0E(int i10) {
        this.A00.A0A(i10);
    }

    @Override // com.facebook.ads.redexgen.core.OY
    public final void A0F(K key, V value) {
        this.A00.put(key, value);
    }
}
