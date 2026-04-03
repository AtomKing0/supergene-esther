package com.google.common.collect;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.NavigableSet;

/* JADX INFO: compiled from: ImmutableSortedSet.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e0<E> extends f0<E> implements NavigableSet<E>, e1<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final transient Comparator<? super E> f10052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    transient e0<E> f10053d;

    e0(Comparator<? super E> comparator) {
        this.f10052c = comparator;
    }

    static <E> x0<E> D(Comparator<? super E> comparator) {
        return s0.d().equals(comparator) ? (x0<E>) x0.f10156f : new x0<>(y.q(), comparator);
    }

    static int P(Comparator<?> comparator, Object obj, Object obj2) {
        return comparator.compare(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <E> e0<E> x(Comparator<? super E> comparator, int i10, E... eArr) {
        if (i10 == 0) {
            return D(comparator);
        }
        r0.c(eArr, i10);
        Arrays.sort(eArr, 0, i10, comparator);
        int i11 = 1;
        for (int i12 = 1; i12 < i10; i12++) {
            a0.c cVar = (Object) eArr[i12];
            if (comparator.compare(cVar, (Object) eArr[i11 - 1]) != 0) {
                eArr[i11] = cVar;
                i11++;
            }
        }
        Arrays.fill(eArr, i11, i10, (Object) null);
        if (i11 < eArr.length / 2) {
            eArr = (E[]) Arrays.copyOf(eArr, i11);
        }
        return new x0(y.j(eArr, i11), comparator);
    }

    public static <E> e0<E> y(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        e5.o.j(comparator);
        if (f1.b(comparator, iterable) && (iterable instanceof e0)) {
            e0<E> e0Var = (e0) iterable;
            if (!e0Var.g()) {
                return e0Var;
            }
        }
        Object[] objArrK = g0.k(iterable);
        return x(comparator, objArrK.length, objArrK);
    }

    public static <E> e0<E> z(Comparator<? super E> comparator, Collection<? extends E> collection) {
        return y(comparator, collection);
    }

    abstract e0<E> A();

    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public abstract i1<E> descendingIterator();

    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public e0<E> descendingSet() {
        e0<E> e0Var = this.f10053d;
        if (e0Var != null) {
            return e0Var;
        }
        e0<E> e0VarA = A();
        this.f10053d = e0VarA;
        e0VarA.f10053d = this;
        return e0VarA;
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public e0<E> headSet(E e10) {
        return headSet(e10, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public e0<E> headSet(E e10, boolean z10) {
        return G(e5.o.j(e10), z10);
    }

    abstract e0<E> G(E e10, boolean z10);

    @Override // java.util.NavigableSet, java.util.SortedSet
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public e0<E> subSet(E e10, E e11) {
        return subSet(e10, true, e11, false);
    }

    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public e0<E> subSet(E e10, boolean z10, E e11, boolean z11) {
        e5.o.j(e10);
        e5.o.j(e11);
        e5.o.d(this.f10052c.compare(e10, e11) <= 0);
        return J(e10, z10, e11, z11);
    }

    abstract e0<E> J(E e10, boolean z10, E e11, boolean z11);

    @Override // java.util.NavigableSet, java.util.SortedSet
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public e0<E> tailSet(E e10) {
        return tailSet(e10, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public e0<E> tailSet(E e10, boolean z10) {
        return N(e5.o.j(e10), z10);
    }

    abstract e0<E> N(E e10, boolean z10);

    int O(Object obj, Object obj2) {
        return P(this.f10052c, obj, obj2);
    }

    @Override // java.util.NavigableSet
    public E ceiling(E e10) {
        return (E) g0.c(tailSet(e10, true), null);
    }

    @Override // java.util.SortedSet, com.google.common.collect.e1
    public Comparator<? super E> comparator() {
        return this.f10052c;
    }

    @Override // java.util.SortedSet
    public E first() {
        return iterator().next();
    }

    @Override // java.util.NavigableSet
    public E floor(E e10) {
        return (E) h0.n(headSet(e10, true).descendingIterator(), null);
    }

    @Override // com.google.common.collect.c0, com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: h */
    public abstract i1<E> iterator();

    @Override // java.util.NavigableSet
    public E higher(E e10) {
        return (E) g0.c(tailSet(e10, false), null);
    }

    @Override // java.util.SortedSet
    public E last() {
        return descendingIterator().next();
    }

    @Override // java.util.NavigableSet
    public E lower(E e10) {
        return (E) h0.n(headSet(e10, false).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }
}
