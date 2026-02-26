package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: RegularImmutableSortedSet.java */
/* JADX INFO: loaded from: classes3.dex */
final class x0<E> extends e0<E> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final x0<Comparable> f10156f = new x0<>(y.q(), s0.d());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final transient y<E> f10157e;

    x0(y<E> yVar, Comparator<? super E> comparator) {
        super(comparator);
        this.f10157e = yVar;
    }

    private int T(Object obj) throws ClassCastException {
        return Collections.binarySearch(this.f10157e, obj, U());
    }

    @Override // com.google.common.collect.e0
    e0<E> A() {
        Comparator comparatorReverseOrder = Collections.reverseOrder(this.f10052c);
        return isEmpty() ? e0.D(comparatorReverseOrder) : new x0(this.f10157e.w(), comparatorReverseOrder);
    }

    @Override // com.google.common.collect.e0, java.util.NavigableSet
    /* JADX INFO: renamed from: B */
    public i1<E> descendingIterator() {
        return this.f10157e.w().iterator();
    }

    @Override // com.google.common.collect.e0
    e0<E> G(E e10, boolean z10) {
        return Q(0, R(e10, z10));
    }

    @Override // com.google.common.collect.e0
    e0<E> J(E e10, boolean z10, E e11, boolean z11) {
        return N(e10, z10).G(e11, z11);
    }

    @Override // com.google.common.collect.e0
    e0<E> N(E e10, boolean z10) {
        return Q(S(e10, z10), size());
    }

    x0<E> Q(int i10, int i11) {
        return (i10 == 0 && i11 == size()) ? this : i10 < i11 ? new x0<>(this.f10157e.subList(i10, i11), this.f10052c) : e0.D(this.f10052c);
    }

    int R(E e10, boolean z10) {
        int iBinarySearch = Collections.binarySearch(this.f10157e, e5.o.j(e10), comparator());
        return iBinarySearch >= 0 ? z10 ? iBinarySearch + 1 : iBinarySearch : ~iBinarySearch;
    }

    int S(E e10, boolean z10) {
        int iBinarySearch = Collections.binarySearch(this.f10157e, e5.o.j(e10), comparator());
        return iBinarySearch >= 0 ? z10 ? iBinarySearch : iBinarySearch + 1 : ~iBinarySearch;
    }

    Comparator<Object> U() {
        return this.f10052c;
    }

    @Override // com.google.common.collect.c0, com.google.common.collect.w
    public y<E> a() {
        return this.f10157e;
    }

    @Override // com.google.common.collect.w
    int b(Object[] objArr, int i10) {
        return this.f10157e.b(objArr, i10);
    }

    @Override // com.google.common.collect.e0, java.util.NavigableSet
    public E ceiling(E e10) {
        int iS = S(e10, true);
        if (iS == size()) {
            return null;
        }
        return this.f10157e.get(iS);
    }

    @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return T(obj) >= 0;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof o0) {
            collection = ((o0) collection).elementSet();
        }
        if (!f1.b(comparator(), collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        i1<E> it = iterator();
        Iterator<?> it2 = collection.iterator();
        if (!it.hasNext()) {
            return false;
        }
        Object next = it2.next();
        E next2 = it.next();
        while (true) {
            try {
                int iO = O(next2, next);
                if (iO < 0) {
                    if (!it.hasNext()) {
                        return false;
                    }
                    next2 = it.next();
                } else if (iO == 0) {
                    if (!it2.hasNext()) {
                        return true;
                    }
                    next = it2.next();
                } else if (iO > 0) {
                    break;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // com.google.common.collect.w
    Object[] d() {
        return this.f10157e.d();
    }

    @Override // com.google.common.collect.w
    int e() {
        return this.f10157e.e();
    }

    @Override // com.google.common.collect.c0, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (!f1.b(this.f10052c, set)) {
            return containsAll(set);
        }
        Iterator<E> it = set.iterator();
        try {
            i1<E> it2 = iterator();
            while (it2.hasNext()) {
                E next = it2.next();
                E next2 = it.next();
                if (next2 == null || O(next, next2) != 0) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NoSuchElementException unused) {
            return false;
        }
    }

    @Override // com.google.common.collect.w
    int f() {
        return this.f10157e.f();
    }

    @Override // com.google.common.collect.e0, java.util.SortedSet
    public E first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.f10157e.get(0);
    }

    @Override // com.google.common.collect.e0, java.util.NavigableSet
    public E floor(E e10) {
        int iR = R(e10, true) - 1;
        if (iR == -1) {
            return null;
        }
        return this.f10157e.get(iR);
    }

    @Override // com.google.common.collect.w
    boolean g() {
        return this.f10157e.g();
    }

    @Override // com.google.common.collect.e0, com.google.common.collect.c0, com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: h */
    public i1<E> iterator() {
        return this.f10157e.iterator();
    }

    @Override // com.google.common.collect.e0, java.util.NavigableSet
    public E higher(E e10) {
        int iS = S(e10, false);
        if (iS == size()) {
            return null;
        }
        return this.f10157e.get(iS);
    }

    @Override // com.google.common.collect.e0, java.util.SortedSet
    public E last() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.f10157e.get(size() - 1);
    }

    @Override // com.google.common.collect.e0, java.util.NavigableSet
    public E lower(E e10) {
        int iR = R(e10, false) - 1;
        if (iR == -1) {
            return null;
        }
        return this.f10157e.get(iR);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f10157e.size();
    }
}
