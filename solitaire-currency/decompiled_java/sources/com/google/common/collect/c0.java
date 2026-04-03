package com.google.common.collect;

import com.google.common.collect.w;
import com.google.j2objc.annotations.RetainedWith;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: ImmutableSet.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c0<E> extends w<E> implements Set<E> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @RetainedWith
    private transient y<E> f10009b;

    /* JADX INFO: compiled from: ImmutableSet.java */
    public static class a<E> extends w.a<E> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object[] f10010d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f10011e;

        public a() {
            super(4);
        }

        private void k(E e10) {
            Objects.requireNonNull(this.f10010d);
            int length = this.f10010d.length - 1;
            int iHashCode = e10.hashCode();
            int iB = v.b(iHashCode);
            while (true) {
                int i10 = iB & length;
                Object[] objArr = this.f10010d;
                Object obj = objArr[i10];
                if (obj == null) {
                    objArr[i10] = e10;
                    this.f10011e += iHashCode;
                    super.d(e10);
                    return;
                } else if (obj.equals(e10)) {
                    return;
                } else {
                    iB = i10 + 1;
                }
            }
        }

        @Override // com.google.common.collect.w.b
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public a<E> a(E e10) {
            e5.o.j(e10);
            if (this.f10010d != null && c0.k(this.f10145b) <= this.f10010d.length) {
                k(e10);
                return this;
            }
            this.f10010d = null;
            super.d(e10);
            return this;
        }

        public a<E> i(E... eArr) {
            if (this.f10010d != null) {
                for (E e10 : eArr) {
                    a(e10);
                }
            } else {
                super.e(eArr);
            }
            return this;
        }

        public a<E> j(Iterable<? extends E> iterable) {
            e5.o.j(iterable);
            if (this.f10010d != null) {
                Iterator<? extends E> it = iterable.iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
            } else {
                super.b(iterable);
            }
            return this;
        }

        public c0<E> l() {
            c0<E> c0VarL;
            int i10 = this.f10145b;
            if (i10 == 0) {
                return c0.q();
            }
            if (i10 == 1) {
                Object obj = this.f10144a[0];
                Objects.requireNonNull(obj);
                return c0.r(obj);
            }
            if (this.f10010d == null || c0.k(i10) != this.f10010d.length) {
                c0VarL = c0.l(this.f10145b, this.f10144a);
                this.f10145b = c0VarL.size();
            } else {
                Object[] objArrCopyOf = c0.w(this.f10145b, this.f10144a.length) ? Arrays.copyOf(this.f10144a, this.f10145b) : this.f10144a;
                c0VarL = new w0<>(objArrCopyOf, this.f10011e, this.f10010d, r5.length - 1, this.f10145b);
            }
            this.f10146c = true;
            this.f10010d = null;
            return c0VarL;
        }
    }

    c0() {
    }

    static int k(int i10) {
        int iMax = Math.max(i10, 2);
        if (iMax >= 751619276) {
            e5.o.e(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (((double) iHighestOneBit) * 0.7d < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> c0<E> l(int i10, Object... objArr) {
        if (i10 == 0) {
            return q();
        }
        if (i10 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return r(obj);
        }
        int iK = k(i10);
        Object[] objArr2 = new Object[iK];
        int i11 = iK - 1;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < i10; i14++) {
            Object objA = r0.a(objArr[i14], i14);
            int iHashCode = objA.hashCode();
            int iB = v.b(iHashCode);
            while (true) {
                int i15 = iB & i11;
                Object obj2 = objArr2[i15];
                if (obj2 == null) {
                    objArr[i13] = objA;
                    objArr2[i15] = objA;
                    i12 += iHashCode;
                    i13++;
                    break;
                }
                if (obj2.equals(objA)) {
                    break;
                }
                iB++;
            }
        }
        Arrays.fill(objArr, i13, i10, (Object) null);
        if (i13 == 1) {
            Object obj3 = objArr[0];
            Objects.requireNonNull(obj3);
            return new d1(obj3);
        }
        if (k(i13) < iK / 2) {
            return l(i13, objArr);
        }
        if (w(i13, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i13);
        }
        return new w0(objArr, i12, objArr2, i11, i13);
    }

    public static <E> c0<E> m(Collection<? extends E> collection) {
        if ((collection instanceof c0) && !(collection instanceof SortedSet)) {
            c0<E> c0Var = (c0) collection;
            if (!c0Var.g()) {
                return c0Var;
            }
        }
        Object[] array = collection.toArray();
        return l(array.length, array);
    }

    public static <E> c0<E> n(E[] eArr) {
        int length = eArr.length;
        return length != 0 ? length != 1 ? l(eArr.length, (Object[]) eArr.clone()) : r(eArr[0]) : q();
    }

    public static <E> c0<E> q() {
        return w0.f10148i;
    }

    public static <E> c0<E> r(E e10) {
        return new d1(e10);
    }

    public static <E> c0<E> s(E e10, E e11) {
        return l(2, e10, e11);
    }

    public static <E> c0<E> t(E e10, E e11, E e12) {
        return l(3, e10, e11, e12);
    }

    public static <E> c0<E> u(E e10, E e11, E e12, E e13, E e14) {
        return l(5, e10, e11, e12, e13, e14);
    }

    @SafeVarargs
    public static <E> c0<E> v(E e10, E e11, E e12, E e13, E e14, E e15, E... eArr) {
        e5.o.e(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e10;
        objArr[1] = e11;
        objArr[2] = e12;
        objArr[3] = e13;
        objArr[4] = e14;
        objArr[5] = e15;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return l(length, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean w(int i10, int i11) {
        return i10 < (i11 >> 1) + (i11 >> 2);
    }

    @Override // com.google.common.collect.w
    public y<E> a() {
        y<E> yVar = this.f10009b;
        if (yVar != null) {
            return yVar;
        }
        y<E> yVarO = o();
        this.f10009b = yVarO;
        return yVarO;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof c0) && p() && ((c0) obj).p() && hashCode() != obj.hashCode()) {
            return false;
        }
        return c1.a(this, obj);
    }

    @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public abstract i1<E> iterator();

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return c1.d(this);
    }

    y<E> o() {
        return y.i(toArray());
    }

    boolean p() {
        return false;
    }
}
