package com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: ImmutableCollection.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class w<E> extends AbstractCollection<E> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object[] f10143a = new Object[0];

    /* JADX INFO: compiled from: ImmutableCollection.java */
    static abstract class a<E> extends b<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object[] f10144a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f10145b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f10146c;

        a(int i10) {
            k.b(i10, "initialCapacity");
            this.f10144a = new Object[i10];
            this.f10145b = 0;
        }

        private void g(int i10) {
            Object[] objArr = this.f10144a;
            if (objArr.length < i10) {
                this.f10144a = Arrays.copyOf(objArr, b.c(objArr.length, i10));
                this.f10146c = false;
            } else if (this.f10146c) {
                this.f10144a = (Object[]) objArr.clone();
                this.f10146c = false;
            }
        }

        @Override // com.google.common.collect.w.b
        public b<E> b(Iterable<? extends E> iterable) {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                g(this.f10145b + collection.size());
                if (collection instanceof w) {
                    this.f10145b = ((w) collection).b(this.f10144a, this.f10145b);
                    return this;
                }
            }
            super.b(iterable);
            return this;
        }

        public a<E> d(E e10) {
            e5.o.j(e10);
            g(this.f10145b + 1);
            Object[] objArr = this.f10144a;
            int i10 = this.f10145b;
            this.f10145b = i10 + 1;
            objArr[i10] = e10;
            return this;
        }

        public b<E> e(E... eArr) {
            f(eArr, eArr.length);
            return this;
        }

        final void f(Object[] objArr, int i10) {
            r0.c(objArr, i10);
            g(this.f10145b + i10);
            System.arraycopy(objArr, 0, this.f10144a, this.f10145b, i10);
            this.f10145b += i10;
        }
    }

    /* JADX INFO: compiled from: ImmutableCollection.java */
    public static abstract class b<E> {
        b() {
        }

        static int c(int i10, int i11) {
            if (i11 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int iHighestOneBit = i10 + (i10 >> 1) + 1;
            if (iHighestOneBit < i11) {
                iHighestOneBit = Integer.highestOneBit(i11 - 1) << 1;
            }
            if (iHighestOneBit < 0) {
                return Integer.MAX_VALUE;
            }
            return iHighestOneBit;
        }

        public abstract b<E> a(E e10);

        public b<E> b(Iterable<? extends E> iterable) {
            Iterator<? extends E> it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }
    }

    w() {
    }

    public y<E> a() {
        return isEmpty() ? y.q() : y.i(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    int b(Object[] objArr, int i10) {
        i1<E> it = iterator();
        while (it.hasNext()) {
            objArr[i10] = it.next();
            i10++;
        }
        return i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean contains(Object obj);

    Object[] d() {
        return null;
    }

    int e() {
        throw new UnsupportedOperationException();
    }

    int f() {
        throw new UnsupportedOperationException();
    }

    abstract boolean g();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: h */
    public abstract i1<E> iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(f10143a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        e5.o.j(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] objArrD = d();
            if (objArrD != null) {
                return (T[]) t0.a(objArrD, f(), e(), tArr);
            }
            tArr = (T[]) r0.d(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        b(tArr, 0);
        return tArr;
    }
}
