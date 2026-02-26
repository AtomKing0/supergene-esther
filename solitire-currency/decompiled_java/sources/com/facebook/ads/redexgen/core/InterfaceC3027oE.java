package com.facebook.ads.redexgen.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import com.google.common.collect.ParametricNullness;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.oE, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@DoNotMock("Use ImmutableMultimap, HashMultimap, or another implementation")
@ElementTypesAreNonnullByDefault
public interface InterfaceC3027oE<K, V> {
    Map<K, Collection<V>> A49();

    boolean AGU(@ParametricNullness K key, @ParametricNullness V value);

    void clear();

    int size();

    Collection<V> values();
}
