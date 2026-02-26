package com.google.common.collect;

import java.util.Comparator;
import java.util.Map;

/* JADX INFO: compiled from: Ordering.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s0<T> implements Comparator<T> {
    protected s0() {
    }

    public static <T> s0<T> b(Comparator<T> comparator) {
        return comparator instanceof s0 ? (s0) comparator : new o(comparator);
    }

    public static <C extends Comparable> s0<C> d() {
        return p0.f10122a;
    }

    public <U extends T> s0<U> a(Comparator<? super U> comparator) {
        return new q(this, (Comparator) e5.o.j(comparator));
    }

    public <E extends T> y<E> c(Iterable<E> iterable) {
        return y.x(this, iterable);
    }

    @Override // java.util.Comparator
    public abstract int compare(T t10, T t11);

    <T2 extends T> s0<Map.Entry<T2, ?>> e() {
        return (s0<Map.Entry<T2, ?>>) f(k0.f());
    }

    public <F> s0<F> f(e5.g<F, ? extends T> gVar) {
        return new j(gVar, this);
    }

    public <S extends T> s0<S> g() {
        return new z0(this);
    }
}
