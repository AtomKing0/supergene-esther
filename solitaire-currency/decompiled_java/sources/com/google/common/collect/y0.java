package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: compiled from: ReverseNaturalOrdering.java */
/* JADX INFO: loaded from: classes3.dex */
final class y0 extends s0<Comparable<?>> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final y0 f10164a = new y0();

    private y0() {
    }

    @Override // com.google.common.collect.s0
    public <S extends Comparable<?>> s0<S> g() {
        return s0.d();
    }

    @Override // com.google.common.collect.s0, java.util.Comparator
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable<?> comparable, Comparable<?> comparable2) {
        e5.o.j(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }
}
