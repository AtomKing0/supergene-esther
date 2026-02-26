package com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: CompactHashMap.java */
/* JADX INFO: loaded from: classes3.dex */
class m<K, V> extends AbstractMap<K, V> implements Serializable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Object f10088j = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient Object f10089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    transient int[] f10090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    transient Object[] f10091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    transient Object[] f10092d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private transient int f10093e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient int f10094f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient Set<K> f10095g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private transient Set<Map.Entry<K, V>> f10096h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private transient Collection<V> f10097i;

    /* JADX INFO: compiled from: CompactHashMap.java */
    class a extends m<K, V>.e<K> {
        a() {
            super(m.this, null);
        }

        @Override // com.google.common.collect.m.e
        K b(int i10) {
            return (K) m.this.I(i10);
        }
    }

    /* JADX INFO: compiled from: CompactHashMap.java */
    class b extends m<K, V>.e<Map.Entry<K, V>> {
        b() {
            super(m.this, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.m.e
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> b(int i10) {
            return new g(i10);
        }
    }

    /* JADX INFO: compiled from: CompactHashMap.java */
    class c extends m<K, V>.e<V> {
        c() {
            super(m.this, null);
        }

        @Override // com.google.common.collect.m.e
        V b(int i10) {
            return (V) m.this.Y(i10);
        }
    }

    /* JADX INFO: compiled from: CompactHashMap.java */
    class d extends AbstractSet<Map.Entry<K, V>> {
        d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            m.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map<K, V> mapY = m.this.y();
            if (mapY != null) {
                return mapY.entrySet().contains(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iF = m.this.F(entry.getKey());
            return iF != -1 && e5.k.a(m.this.Y(iF), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return m.this.A();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map<K, V> mapY = m.this.y();
            if (mapY != null) {
                return mapY.entrySet().remove(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (m.this.L()) {
                return false;
            }
            int iD = m.this.D();
            int iF = n.f(entry.getKey(), entry.getValue(), iD, m.this.P(), m.this.N(), m.this.O(), m.this.Q());
            if (iF == -1) {
                return false;
            }
            m.this.K(iF, iD);
            m.f(m.this);
            m.this.E();
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return m.this.size();
        }
    }

    /* JADX INFO: compiled from: CompactHashMap.java */
    class f extends AbstractSet<K> {
        f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            m.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return m.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return m.this.J();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map<K, V> mapY = m.this.y();
            return mapY != null ? mapY.keySet().remove(obj) : m.this.M(obj) != m.f10088j;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return m.this.size();
        }
    }

    /* JADX INFO: compiled from: CompactHashMap.java */
    final class g extends com.google.common.collect.e<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final K f10107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f10108b;

        g(int i10) {
            this.f10107a = (K) m.this.I(i10);
            this.f10108b = i10;
        }

        private void a() {
            int i10 = this.f10108b;
            if (i10 == -1 || i10 >= m.this.size() || !e5.k.a(this.f10107a, m.this.I(this.f10108b))) {
                this.f10108b = m.this.F(this.f10107a);
            }
        }

        @Override // com.google.common.collect.e, java.util.Map.Entry
        public K getKey() {
            return this.f10107a;
        }

        @Override // com.google.common.collect.e, java.util.Map.Entry
        public V getValue() {
            Map<K, V> mapY = m.this.y();
            if (mapY != null) {
                return (V) q0.a(mapY.get(this.f10107a));
            }
            a();
            int i10 = this.f10108b;
            return i10 == -1 ? (V) q0.b() : (V) m.this.Y(i10);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            Map<K, V> mapY = m.this.y();
            if (mapY != null) {
                return (V) q0.a(mapY.put(this.f10107a, v10));
            }
            a();
            int i10 = this.f10108b;
            if (i10 == -1) {
                m.this.put(this.f10107a, v10);
                return (V) q0.b();
            }
            V v11 = (V) m.this.Y(i10);
            m.this.X(this.f10108b, v10);
            return v11;
        }
    }

    /* JADX INFO: compiled from: CompactHashMap.java */
    class h extends AbstractCollection<V> {
        h() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            m.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return m.this.Z();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return m.this.size();
        }
    }

    m() {
        G(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int D() {
        return (1 << (this.f10093e & 31)) - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int F(Object obj) {
        if (L()) {
            return -1;
        }
        int iC = v.c(obj);
        int iD = D();
        int iH = n.h(P(), iC & iD);
        if (iH == 0) {
            return -1;
        }
        int iB = n.b(iC, iD);
        do {
            int i10 = iH - 1;
            int iZ = z(i10);
            if (n.b(iZ, iD) == iB && e5.k.a(obj, I(i10))) {
                return i10;
            }
            iH = n.c(iZ, iD);
        } while (iH != 0);
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public K I(int i10) {
        return (K) O()[i10];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object M(Object obj) {
        if (L()) {
            return f10088j;
        }
        int iD = D();
        int iF = n.f(obj, null, iD, P(), N(), O(), null);
        if (iF == -1) {
            return f10088j;
        }
        V vY = Y(iF);
        K(iF, iD);
        this.f10094f--;
        E();
        return vY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] N() {
        int[] iArr = this.f10090b;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] O() {
        Object[] objArr = this.f10091c;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object P() {
        Object obj = this.f10089a;
        Objects.requireNonNull(obj);
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] Q() {
        Object[] objArr = this.f10092d;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    private void S(int i10) {
        int iMin;
        int length = N().length;
        if (i10 <= length || (iMin = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        R(iMin);
    }

    private int T(int i10, int i11, int i12, int i13) {
        Object objA = n.a(i11);
        int i14 = i11 - 1;
        if (i13 != 0) {
            n.i(objA, i12 & i14, i13 + 1);
        }
        Object objP = P();
        int[] iArrN = N();
        for (int i15 = 0; i15 <= i10; i15++) {
            int iH = n.h(objP, i15);
            while (iH != 0) {
                int i16 = iH - 1;
                int i17 = iArrN[i16];
                int iB = n.b(i17, i10) | i15;
                int i18 = iB & i14;
                int iH2 = n.h(objA, i18);
                n.i(objA, i18, iH);
                iArrN[i16] = n.d(iB, iH2, i14);
                iH = n.c(i17, i10);
            }
        }
        this.f10089a = objA;
        V(i14);
        return i14;
    }

    private void U(int i10, int i11) {
        N()[i10] = i11;
    }

    private void V(int i10) {
        this.f10093e = n.d(this.f10093e, 32 - Integer.numberOfLeadingZeros(i10), 31);
    }

    private void W(int i10, K k10) {
        O()[i10] = k10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(int i10, V v10) {
        Q()[i10] = v10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V Y(int i10) {
        return (V) Q()[i10];
    }

    static /* synthetic */ int f(m mVar) {
        int i10 = mVar.f10094f;
        mVar.f10094f = i10 - 1;
        return i10;
    }

    public static <K, V> m<K, V> s() {
        return new m<>();
    }

    public static <K, V> m<K, V> x(int i10) {
        return new m<>(i10);
    }

    private int z(int i10) {
        return N()[i10];
    }

    Iterator<Map.Entry<K, V>> A() {
        Map<K, V> mapY = y();
        return mapY != null ? mapY.entrySet().iterator() : new b();
    }

    int B() {
        return isEmpty() ? -1 : 0;
    }

    int C(int i10) {
        int i11 = i10 + 1;
        if (i11 < this.f10094f) {
            return i11;
        }
        return -1;
    }

    void E() {
        this.f10093e += 32;
    }

    void G(int i10) {
        e5.o.e(i10 >= 0, "Expected size must be >= 0");
        this.f10093e = g5.e.f(i10, 1, 1073741823);
    }

    void H(int i10, K k10, V v10, int i11, int i12) {
        U(i10, n.d(i11, 0, i12));
        W(i10, k10);
        X(i10, v10);
    }

    Iterator<K> J() {
        Map<K, V> mapY = y();
        return mapY != null ? mapY.keySet().iterator() : new a();
    }

    void K(int i10, int i11) {
        Object objP = P();
        int[] iArrN = N();
        Object[] objArrO = O();
        Object[] objArrQ = Q();
        int size = size() - 1;
        if (i10 >= size) {
            objArrO[i10] = null;
            objArrQ[i10] = null;
            iArrN[i10] = 0;
            return;
        }
        Object obj = objArrO[size];
        objArrO[i10] = obj;
        objArrQ[i10] = objArrQ[size];
        objArrO[size] = null;
        objArrQ[size] = null;
        iArrN[i10] = iArrN[size];
        iArrN[size] = 0;
        int iC = v.c(obj) & i11;
        int iH = n.h(objP, iC);
        int i12 = size + 1;
        if (iH == i12) {
            n.i(objP, iC, i10 + 1);
            return;
        }
        while (true) {
            int i13 = iH - 1;
            int i14 = iArrN[i13];
            int iC2 = n.c(i14, i11);
            if (iC2 == i12) {
                iArrN[i13] = n.d(i14, i10 + 1, i11);
                return;
            }
            iH = iC2;
        }
    }

    boolean L() {
        return this.f10089a == null;
    }

    void R(int i10) {
        this.f10090b = Arrays.copyOf(N(), i10);
        this.f10091c = Arrays.copyOf(O(), i10);
        this.f10092d = Arrays.copyOf(Q(), i10);
    }

    Iterator<V> Z() {
        Map<K, V> mapY = y();
        return mapY != null ? mapY.values().iterator() : new c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (L()) {
            return;
        }
        E();
        Map<K, V> mapY = y();
        if (mapY != null) {
            this.f10093e = g5.e.f(size(), 3, 1073741823);
            mapY.clear();
            this.f10089a = null;
            this.f10094f = 0;
            return;
        }
        Arrays.fill(O(), 0, this.f10094f, (Object) null);
        Arrays.fill(Q(), 0, this.f10094f, (Object) null);
        n.g(P());
        Arrays.fill(N(), 0, this.f10094f, 0);
        this.f10094f = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Map<K, V> mapY = y();
        return mapY != null ? mapY.containsKey(obj) : F(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        Map<K, V> mapY = y();
        if (mapY != null) {
            return mapY.containsValue(obj);
        }
        for (int i10 = 0; i10 < this.f10094f; i10++) {
            if (e5.k.a(obj, Y(i10))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f10096h;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> setT = t();
        this.f10096h = setT;
        return setT;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Map<K, V> mapY = y();
        if (mapY != null) {
            return mapY.get(obj);
        }
        int iF = F(obj);
        if (iF == -1) {
            return null;
        }
        o(iF);
        return Y(iF);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f10095g;
        if (set != null) {
            return set;
        }
        Set<K> setV = v();
        this.f10095g = setV;
        return setV;
    }

    int p(int i10, int i11) {
        return i10 - 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k10, V v10) {
        int iT;
        int i10;
        if (L()) {
            q();
        }
        Map<K, V> mapY = y();
        if (mapY != null) {
            return mapY.put(k10, v10);
        }
        int[] iArrN = N();
        Object[] objArrO = O();
        Object[] objArrQ = Q();
        int i11 = this.f10094f;
        int i12 = i11 + 1;
        int iC = v.c(k10);
        int iD = D();
        int i13 = iC & iD;
        int iH = n.h(P(), i13);
        if (iH != 0) {
            int iB = n.b(iC, iD);
            int i14 = 0;
            while (true) {
                int i15 = iH - 1;
                int i16 = iArrN[i15];
                if (n.b(i16, iD) == iB && e5.k.a(k10, objArrO[i15])) {
                    V v11 = (V) objArrQ[i15];
                    objArrQ[i15] = v10;
                    o(i15);
                    return v11;
                }
                int iC2 = n.c(i16, iD);
                i14++;
                if (iC2 != 0) {
                    iH = iC2;
                } else {
                    if (i14 >= 9) {
                        return r().put(k10, v10);
                    }
                    if (i12 > iD) {
                        iT = T(iD, n.e(iD), iC, i11);
                    } else {
                        iArrN[i15] = n.d(i16, i12, iD);
                    }
                }
            }
            i10 = iD;
        } else if (i12 > iD) {
            iT = T(iD, n.e(iD), iC, i11);
            i10 = iT;
        } else {
            n.i(P(), i13, i12);
            i10 = iD;
        }
        S(i12);
        H(i11, k10, v10, iC, i10);
        this.f10094f = i12;
        E();
        return null;
    }

    int q() {
        e5.o.p(L(), "Arrays already allocated");
        int i10 = this.f10093e;
        int iJ = n.j(i10);
        this.f10089a = n.a(iJ);
        V(iJ - 1);
        this.f10090b = new int[i10];
        this.f10091c = new Object[i10];
        this.f10092d = new Object[i10];
        return i10;
    }

    Map<K, V> r() {
        Map<K, V> mapU = u(D() + 1);
        int iB = B();
        while (iB >= 0) {
            mapU.put(I(iB), Y(iB));
            iB = C(iB);
        }
        this.f10089a = mapU;
        this.f10090b = null;
        this.f10091c = null;
        this.f10092d = null;
        E();
        return mapU;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Map<K, V> mapY = y();
        if (mapY != null) {
            return mapY.remove(obj);
        }
        V v10 = (V) M(obj);
        if (v10 == f10088j) {
            return null;
        }
        return v10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Map<K, V> mapY = y();
        return mapY != null ? mapY.size() : this.f10094f;
    }

    Set<Map.Entry<K, V>> t() {
        return new d();
    }

    Map<K, V> u(int i10) {
        return new LinkedHashMap(i10, 1.0f);
    }

    Set<K> v() {
        return new f();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.f10097i;
        if (collection != null) {
            return collection;
        }
        Collection<V> collectionW = w();
        this.f10097i = collectionW;
        return collectionW;
    }

    Collection<V> w() {
        return new h();
    }

    Map<K, V> y() {
        Object obj = this.f10089a;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    m(int i10) {
        G(i10);
    }

    /* JADX INFO: compiled from: CompactHashMap.java */
    private abstract class e<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f10103b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f10104c;

        private e() {
            this.f10102a = m.this.f10093e;
            this.f10103b = m.this.B();
            this.f10104c = -1;
        }

        private void a() {
            if (m.this.f10093e != this.f10102a) {
                throw new ConcurrentModificationException();
            }
        }

        abstract T b(int i10);

        void c() {
            this.f10102a += 32;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f10103b >= 0;
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i10 = this.f10103b;
            this.f10104c = i10;
            T tB = b(i10);
            this.f10103b = m.this.C(this.f10103b);
            return tB;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            k.c(this.f10104c >= 0);
            c();
            m mVar = m.this;
            mVar.remove(mVar.I(this.f10104c));
            this.f10103b = m.this.p(this.f10103b, this.f10104c);
            this.f10104c = -1;
        }

        /* synthetic */ e(m mVar, a aVar) {
            this();
        }
    }

    void o(int i10) {
    }
}
