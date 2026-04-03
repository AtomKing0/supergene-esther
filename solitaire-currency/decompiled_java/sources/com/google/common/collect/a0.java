package com.google.common.collect;

import com.google.common.collect.w;
import com.google.j2objc.annotations.RetainedWith;
import com.ironsource.v8;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;

/* JADX INFO: compiled from: ImmutableMap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a0<K, V> implements Map<K, V>, Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final Map.Entry<?, ?>[] f9975d = new Map.Entry[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @RetainedWith
    private transient c0<Map.Entry<K, V>> f9976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @RetainedWith
    private transient c0<K> f9977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @RetainedWith
    private transient w<V> f9978c;

    /* JADX INFO: compiled from: ImmutableMap.java */
    public static class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Comparator<? super V> f9979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object[] f9980b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f9981c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f9982d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        C0218a f9983e;

        /* JADX INFO: renamed from: com.google.common.collect.a0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ImmutableMap.java */
        static final class C0218a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Object f9984a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Object f9985b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final Object f9986c;

            C0218a(Object obj, Object obj2, Object obj3) {
                this.f9984a = obj;
                this.f9985b = obj2;
                this.f9986c = obj3;
            }

            IllegalArgumentException a() {
                return new IllegalArgumentException("Multiple entries with same key: " + this.f9984a + v8.i.f15833b + this.f9985b + " and " + this.f9984a + v8.i.f15833b + this.f9986c);
            }
        }

        public a() {
            this(4);
        }

        private a0<K, V> b(boolean z10) {
            Object[] objArrE;
            C0218a c0218a;
            C0218a c0218a2;
            if (z10 && (c0218a2 = this.f9983e) != null) {
                throw c0218a2.a();
            }
            int length = this.f9981c;
            if (this.f9979a == null) {
                objArrE = this.f9980b;
            } else {
                if (this.f9982d) {
                    this.f9980b = Arrays.copyOf(this.f9980b, length * 2);
                }
                objArrE = this.f9980b;
                if (!z10) {
                    objArrE = e(objArrE, this.f9981c);
                    if (objArrE.length < this.f9980b.length) {
                        length = objArrE.length >>> 1;
                    }
                }
                i(objArrE, length, this.f9979a);
            }
            this.f9982d = true;
            v0 v0VarO = v0.o(length, objArrE, this);
            if (!z10 || (c0218a = this.f9983e) == null) {
                return v0VarO;
            }
            throw c0218a.a();
        }

        private void d(int i10) {
            int i11 = i10 * 2;
            Object[] objArr = this.f9980b;
            if (i11 > objArr.length) {
                this.f9980b = Arrays.copyOf(objArr, w.b.c(objArr.length, i11));
                this.f9982d = false;
            }
        }

        private Object[] e(Object[] objArr, int i10) {
            HashSet hashSet = new HashSet();
            BitSet bitSet = new BitSet();
            for (int i11 = i10 - 1; i11 >= 0; i11--) {
                Object obj = objArr[i11 * 2];
                Objects.requireNonNull(obj);
                if (!hashSet.add(obj)) {
                    bitSet.set(i11);
                }
            }
            if (bitSet.isEmpty()) {
                return objArr;
            }
            Object[] objArr2 = new Object[(i10 - bitSet.cardinality()) * 2];
            int i12 = 0;
            int i13 = 0;
            while (i12 < i10 * 2) {
                if (bitSet.get(i12 >>> 1)) {
                    i12 += 2;
                } else {
                    int i14 = i13 + 1;
                    int i15 = i12 + 1;
                    Object obj2 = objArr[i12];
                    Objects.requireNonNull(obj2);
                    objArr2[i13] = obj2;
                    i13 = i14 + 1;
                    i12 = i15 + 1;
                    Object obj3 = objArr[i15];
                    Objects.requireNonNull(obj3);
                    objArr2[i14] = obj3;
                }
            }
            return objArr2;
        }

        static <V> void i(Object[] objArr, int i10, Comparator<? super V> comparator) {
            Map.Entry[] entryArr = new Map.Entry[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                int i12 = i11 * 2;
                Object obj = objArr[i12];
                Objects.requireNonNull(obj);
                Object obj2 = objArr[i12 + 1];
                Objects.requireNonNull(obj2);
                entryArr[i11] = new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
            Arrays.sort(entryArr, 0, i10, s0.b(comparator).f(k0.o()));
            for (int i13 = 0; i13 < i10; i13++) {
                int i14 = i13 * 2;
                objArr[i14] = entryArr[i13].getKey();
                objArr[i14 + 1] = entryArr[i13].getValue();
            }
        }

        public a0<K, V> a() {
            return c();
        }

        public a0<K, V> c() {
            return b(true);
        }

        public a<K, V> f(K k10, V v10) {
            d(this.f9981c + 1);
            k.a(k10, v10);
            Object[] objArr = this.f9980b;
            int i10 = this.f9981c;
            objArr[i10 * 2] = k10;
            objArr[(i10 * 2) + 1] = v10;
            this.f9981c = i10 + 1;
            return this;
        }

        public a<K, V> g(Map.Entry<? extends K, ? extends V> entry) {
            return f(entry.getKey(), entry.getValue());
        }

        public a<K, V> h(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                d(this.f9981c + ((Collection) iterable).size());
            }
            Iterator<? extends Map.Entry<? extends K, ? extends V>> it = iterable.iterator();
            while (it.hasNext()) {
                g(it.next());
            }
            return this;
        }

        a(int i10) {
            this.f9980b = new Object[i10 * 2];
            this.f9981c = 0;
            this.f9982d = false;
        }
    }

    a0() {
    }

    public static <K, V> a<K, V> a() {
        return new a<>();
    }

    public static <K, V> a0<K, V> b(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        a aVar = new a(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        aVar.h(iterable);
        return aVar.a();
    }

    public static <K, V> a0<K, V> c(Map<? extends K, ? extends V> map) {
        if ((map instanceof a0) && !(map instanceof SortedMap)) {
            a0<K, V> a0Var = (a0) map;
            if (!a0Var.i()) {
                return a0Var;
            }
        }
        return b(map.entrySet());
    }

    public static <K, V> a0<K, V> k() {
        return (a0<K, V>) v0.f10129h;
    }

    public static <K, V> a0<K, V> l(K k10, V v10) {
        k.a(k10, v10);
        return v0.n(1, new Object[]{k10, v10});
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    abstract c0<Map.Entry<K, V>> e();

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return k0.d(this, obj);
    }

    abstract c0<K> f();

    abstract w<V> g();

    @Override // java.util.Map
    public abstract V get(Object obj);

    @Override // java.util.Map
    public final V getOrDefault(Object obj, V v10) {
        V v11 = get(obj);
        return v11 != null ? v11 : v10;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public c0<Map.Entry<K, V>> entrySet() {
        c0<Map.Entry<K, V>> c0Var = this.f9976a;
        if (c0Var != null) {
            return c0Var;
        }
        c0<Map.Entry<K, V>> c0VarE = e();
        this.f9976a = c0VarE;
        return c0VarE;
    }

    @Override // java.util.Map
    public int hashCode() {
        return c1.d(entrySet());
    }

    abstract boolean i();

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public c0<K> keySet() {
        c0<K> c0Var = this.f9977b;
        if (c0Var != null) {
            return c0Var;
        }
        c0<K> c0VarF = f();
        this.f9977b = c0VarF;
        return c0VarF;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public w<V> values() {
        w<V> wVar = this.f9978c;
        if (wVar != null) {
            return wVar;
        }
        w<V> wVarG = g();
        this.f9978c = wVarG;
        return wVarG;
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K k10, V v10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return k0.n(this);
    }
}
