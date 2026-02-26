package com.google.common.collect;

/* JADX INFO: compiled from: SingletonImmutableSet.java */
/* JADX INFO: loaded from: classes3.dex */
final class d1<E> extends c0<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final transient E f10051c;

    d1(E e10) {
        this.f10051c = (E) e5.o.j(e10);
    }

    @Override // com.google.common.collect.c0, com.google.common.collect.w
    public y<E> a() {
        return y.r(this.f10051c);
    }

    @Override // com.google.common.collect.w
    int b(Object[] objArr, int i10) {
        objArr[i10] = this.f10051c;
        return i10 + 1;
    }

    @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f10051c.equals(obj);
    }

    @Override // com.google.common.collect.w
    boolean g() {
        return false;
    }

    @Override // com.google.common.collect.c0, com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: h */
    public i1<E> iterator() {
        return h0.t(this.f10051c);
    }

    @Override // com.google.common.collect.c0, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f10051c.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return '[' + this.f10051c.toString() + ']';
    }
}
