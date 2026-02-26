package com.google.common.collect;

import com.ironsource.v8;
import java.util.Map;

/* JADX INFO: compiled from: AbstractMapEntry.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class e<K, V> implements Map.Entry<K, V> {
    e() {
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return e5.k.a(getKey(), entry.getKey()) && e5.k.a(getValue(), entry.getValue());
    }

    @Override // java.util.Map.Entry
    public abstract K getKey();

    @Override // java.util.Map.Entry
    public abstract V getValue();

    @Override // java.util.Map.Entry
    public int hashCode() {
        K key = getKey();
        V value = getValue();
        return (key == null ? 0 : key.hashCode()) ^ (value != null ? value.hashCode() : 0);
    }

    public String toString() {
        return getKey() + v8.i.f15833b + getValue();
    }
}
