package com.google.common.collect;

/* JADX INFO: compiled from: ImmutableListMultimap.java */
/* JADX INFO: loaded from: classes3.dex */
public class z<K, V> extends b0<K, V> implements i0<K, V> {
    z(a0<K, y<V>> a0Var, int i10) {
        super(a0Var, i10);
    }

    public static <K, V> z<K, V> x() {
        return r.f10124g;
    }

    @Override // com.google.common.collect.b0
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public y<V> get(K k10) {
        y<V> yVar = (y) this.f9995e.get(k10);
        return yVar == null ? y.q() : yVar;
    }
}
