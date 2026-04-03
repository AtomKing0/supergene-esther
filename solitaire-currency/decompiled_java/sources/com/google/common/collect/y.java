package com.google.common.collect;

import com.google.common.collect.w;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: ImmutableList.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class y<E> extends w<E> implements List<E>, RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final j1<Object> f10158b = new b(u0.f10126e, 0);

    /* JADX INFO: compiled from: ImmutableList.java */
    public static final class a<E> extends w.a<E> {
        public a() {
            this(4);
        }

        @Override // com.google.common.collect.w.b
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public a<E> a(E e10) {
            super.d(e10);
            return this;
        }

        public a<E> i(E... eArr) {
            super.e(eArr);
            return this;
        }

        public a<E> j(Iterable<? extends E> iterable) {
            super.b(iterable);
            return this;
        }

        public y<E> k() {
            this.f10146c = true;
            return y.j(this.f10144a, this.f10145b);
        }

        a(int i10) {
            super(i10);
        }
    }

    /* JADX INFO: compiled from: ImmutableList.java */
    static class b<E> extends com.google.common.collect.a<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final y<E> f10159c;

        b(y<E> yVar, int i10) {
            super(yVar.size(), i10);
            this.f10159c = yVar;
        }

        @Override // com.google.common.collect.a
        protected E a(int i10) {
            return this.f10159c.get(i10);
        }
    }

    /* JADX INFO: compiled from: ImmutableList.java */
    private static class c<E> extends y<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final transient y<E> f10160c;

        c(y<E> yVar) {
            this.f10160c = yVar;
        }

        private int A(int i10) {
            return (size() - 1) - i10;
        }

        private int B(int i10) {
            return size() - i10;
        }

        @Override // com.google.common.collect.y, com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.f10160c.contains(obj);
        }

        @Override // com.google.common.collect.w
        boolean g() {
            return this.f10160c.g();
        }

        @Override // java.util.List
        public E get(int i10) {
            e5.o.h(i10, size());
            return this.f10160c.get(A(i10));
        }

        @Override // com.google.common.collect.y, java.util.List
        public int indexOf(Object obj) {
            int iLastIndexOf = this.f10160c.lastIndexOf(obj);
            if (iLastIndexOf >= 0) {
                return A(iLastIndexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.y, com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.y, java.util.List
        public int lastIndexOf(Object obj) {
            int iIndexOf = this.f10160c.indexOf(obj);
            if (iIndexOf >= 0) {
                return A(iIndexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.y, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f10160c.size();
        }

        @Override // com.google.common.collect.y
        public y<E> w() {
            return this.f10160c;
        }

        @Override // com.google.common.collect.y, java.util.List
        /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
        public y<E> subList(int i10, int i11) {
            e5.o.n(i10, i11, size());
            return this.f10160c.subList(B(i11), B(i10)).w();
        }

        @Override // com.google.common.collect.y, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i10) {
            return super.listIterator(i10);
        }
    }

    /* JADX INFO: compiled from: ImmutableList.java */
    class d extends y<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final transient int f10161c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final transient int f10162d;

        d(int i10, int i11) {
            this.f10161c = i10;
            this.f10162d = i11;
        }

        @Override // com.google.common.collect.w
        Object[] d() {
            return y.this.d();
        }

        @Override // com.google.common.collect.w
        int e() {
            return y.this.f() + this.f10161c + this.f10162d;
        }

        @Override // com.google.common.collect.w
        int f() {
            return y.this.f() + this.f10161c;
        }

        @Override // com.google.common.collect.w
        boolean g() {
            return true;
        }

        @Override // java.util.List
        public E get(int i10) {
            e5.o.h(i10, this.f10162d);
            return y.this.get(i10 + this.f10161c);
        }

        @Override // com.google.common.collect.y, com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.y, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f10162d;
        }

        @Override // com.google.common.collect.y, java.util.List
        /* JADX INFO: renamed from: y */
        public y<E> subList(int i10, int i11) {
            e5.o.n(i10, i11, this.f10162d);
            y yVar = y.this;
            int i12 = this.f10161c;
            return yVar.subList(i10 + i12, i11 + i12);
        }

        @Override // com.google.common.collect.y, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i10) {
            return super.listIterator(i10);
        }
    }

    y() {
    }

    static <E> y<E> i(Object[] objArr) {
        return j(objArr, objArr.length);
    }

    static <E> y<E> j(Object[] objArr, int i10) {
        return i10 == 0 ? q() : new u0(objArr, i10);
    }

    public static <E> a<E> k() {
        return new a<>();
    }

    private static <E> y<E> l(Object... objArr) {
        return i(r0.b(objArr));
    }

    public static <E> y<E> m(Collection<? extends E> collection) {
        if (!(collection instanceof w)) {
            return l(collection.toArray());
        }
        y<E> yVarA = ((w) collection).a();
        return yVarA.g() ? i(yVarA.toArray()) : yVarA;
    }

    public static <E> y<E> n(E[] eArr) {
        return eArr.length == 0 ? q() : l((Object[]) eArr.clone());
    }

    public static <E> y<E> q() {
        return (y<E>) u0.f10126e;
    }

    public static <E> y<E> r(E e10) {
        return l(e10);
    }

    public static <E> y<E> s(E e10, E e11) {
        return l(e10, e11);
    }

    public static <E> y<E> t(E e10, E e11, E e12) {
        return l(e10, e11, e12);
    }

    public static <E> y<E> u(E e10, E e11, E e12, E e13, E e14) {
        return l(e10, e11, e12, e13, e14);
    }

    public static <E> y<E> v(E e10, E e11, E e12, E e13, E e14, E e15, E e16) {
        return l(e10, e11, e12, e13, e14, e15, e16);
    }

    public static <E> y<E> x(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        e5.o.j(comparator);
        Object[] objArrK = g0.k(iterable);
        r0.b(objArrK);
        Arrays.sort(objArrK, comparator);
        return i(objArrK);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i10, E e10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i10, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.w
    int b(Object[] objArr, int i10) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            objArr[i10 + i11] = get(i11);
        }
        return i10 + size;
    }

    @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return j0.c(this, obj);
    }

    @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: h */
    public i1<E> iterator() {
        return listIterator();
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i10 = 1;
        for (int i11 = 0; i11 < size; i11++) {
            i10 = ~(~((i10 * 31) + get(i11).hashCode()));
        }
        return i10;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return j0.d(this, obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return j0.f(this, obj);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public j1<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public j1<E> listIterator(int i10) {
        e5.o.l(i10, size());
        return isEmpty() ? (j1<E>) f10158b : new b(this, i10);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i10, E e10) {
        throw new UnsupportedOperationException();
    }

    public y<E> w() {
        return size() <= 1 ? this : new c(this);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: y */
    public y<E> subList(int i10, int i11) {
        e5.o.n(i10, i11, size());
        int i12 = i11 - i10;
        return i12 == size() ? this : i12 == 0 ? q() : z(i10, i11);
    }

    y<E> z(int i10, int i11) {
        return new d(i10, i11 - i10);
    }

    @Override // com.google.common.collect.w
    @Deprecated
    public final y<E> a() {
        return this;
    }
}
