package com.facebook.ads.redexgen.core;

import com.google.common.collect.ParametricNullness;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Af, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1524Af<K, V> extends AbstractC3092pV<Map.Entry<K, V>, V> {
    public C1524Af(Iterator backingIterator) {
        super(backingIterator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC3092pV
    @ParametricNullness
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final V A01(Map.Entry<K, V> entry) {
        return entry.getValue();
    }
}
