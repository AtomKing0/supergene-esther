package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: compiled from: TransformedIterator.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class g1<F, T> implements Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Iterator<? extends F> f10061a;

    g1(Iterator<? extends F> it) {
        this.f10061a = (Iterator) e5.o.j(it);
    }

    abstract T a(F f10);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f10061a.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return a(this.f10061a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f10061a.remove();
    }
}
