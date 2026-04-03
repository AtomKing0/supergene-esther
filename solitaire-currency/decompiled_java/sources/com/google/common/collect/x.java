package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: compiled from: ImmutableEntry.java */
/* JADX INFO: loaded from: classes3.dex */
class x<K, V> extends e<K, V> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final K f10154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final V f10155b;

    x(K k10, V v10) {
        this.f10154a = k10;
        this.f10155b = v10;
    }

    @Override // com.google.common.collect.e, java.util.Map.Entry
    public final K getKey() {
        return this.f10154a;
    }

    @Override // com.google.common.collect.e, java.util.Map.Entry
    public final V getValue() {
        return this.f10155b;
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v10) {
        throw new UnsupportedOperationException();
    }
}
