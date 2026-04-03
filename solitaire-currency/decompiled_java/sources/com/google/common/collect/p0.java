package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: compiled from: NaturalOrdering.java */
/* JADX INFO: loaded from: classes3.dex */
final class p0 extends s0<Comparable<?>> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final p0 f10122a = new p0();

    private p0() {
    }

    @Override // com.google.common.collect.s0
    public <S extends Comparable<?>> s0<S> g() {
        return y0.f10164a;
    }

    @Override // com.google.common.collect.s0, java.util.Comparator
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable<?> comparable, Comparable<?> comparable2) {
        e5.o.j(comparable);
        e5.o.j(comparable2);
        return comparable.compareTo(comparable2);
    }

    public String toString() {
        return "Ordering.natural()";
    }
}
