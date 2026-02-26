package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AbstractListMultimap.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class c<K, V> extends d<K, V> implements i0<K, V> {
    protected c(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // com.google.common.collect.d
    Collection<V> A(K k10, Collection<V> collection) {
        return B(k10, (List) collection, null);
    }

    @Override // com.google.common.collect.f, com.google.common.collect.l0
    public Map<K, Collection<V>> b() {
        return super.b();
    }

    @Override // com.google.common.collect.f
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.l0
    public boolean put(K k10, V v10) {
        return super.put(k10, v10);
    }

    @Override // com.google.common.collect.d
    <E> Collection<E> z(Collection<E> collection) {
        return Collections.unmodifiableList((List) collection);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.l0
    public List<V> get(K k10) {
        return (List) super.get((Object) k10);
    }
}
