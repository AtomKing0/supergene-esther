package w8;

import com.ironsource.nb;
import i9.e;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.l0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import n9.i;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MapBuilder.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d<K, V> implements Map<K, V>, Serializable, i9.e {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    public static final a f35477m = new a(null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    private static final d f35478n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private K[] f35479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private V[] f35480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private int[] f35481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private int[] f35482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f35483e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f35484f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f35485g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f35486h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private w8.f<K> f35487i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private g<V> f35488j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private w8.e<K, V> f35489k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f35490l;

    /* JADX INFO: compiled from: MapBuilder.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int c(int i10) {
            return Integer.highestOneBit(o.e(i10, 1) * 3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int d(int i10) {
            return Integer.numberOfLeadingZeros(i10) + 1;
        }

        @NotNull
        public final d e() {
            return d.f35478n;
        }
    }

    /* JADX INFO: compiled from: MapBuilder.kt */
    public static final class b<K, V> extends C0720d<K, V> implements Iterator<Map.Entry<K, V>>, i9.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull d<K, V> map) {
            super(map);
            t.i(map, "map");
        }

        @Override // java.util.Iterator
        @NotNull
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public c<K, V> next() {
            if (a() >= ((d) c()).f35484f) {
                throw new NoSuchElementException();
            }
            int iA = a();
            f(iA + 1);
            g(iA);
            c<K, V> cVar = new c<>(c(), b());
            e();
            return cVar;
        }

        public final void i(@NotNull StringBuilder sb) {
            t.i(sb, "sb");
            if (a() >= ((d) c()).f35484f) {
                throw new NoSuchElementException();
            }
            int iA = a();
            f(iA + 1);
            g(iA);
            Object obj = ((d) c()).f35479a[b()];
            if (t.d(obj, c())) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append(nb.T);
            Object[] objArr = ((d) c()).f35480b;
            t.f(objArr);
            Object obj2 = objArr[b()];
            if (t.d(obj2, c())) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            e();
        }

        public final int j() {
            if (a() >= ((d) c()).f35484f) {
                throw new NoSuchElementException();
            }
            int iA = a();
            f(iA + 1);
            g(iA);
            Object obj = ((d) c()).f35479a[b()];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = ((d) c()).f35480b;
            t.f(objArr);
            Object obj2 = objArr[b()];
            int iHashCode2 = iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
            e();
            return iHashCode2;
        }
    }

    /* JADX INFO: compiled from: MapBuilder.kt */
    public static final class c<K, V> implements Map.Entry<K, V>, e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final d<K, V> f35491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f35492b;

        public c(@NotNull d<K, V> map, int i10) {
            t.i(map, "map");
            this.f35491a = map;
            this.f35492b = i10;
        }

        @Override // java.util.Map.Entry
        public boolean equals(@Nullable Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (t.d(entry.getKey(), getKey()) && t.d(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) ((d) this.f35491a).f35479a[this.f35492b];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] objArr = ((d) this.f35491a).f35480b;
            t.f(objArr);
            return (V) objArr[this.f35492b];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K key = getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            V value = getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            this.f35491a.l();
            Object[] objArrJ = this.f35491a.j();
            int i10 = this.f35492b;
            V v11 = (V) objArrJ[i10];
            objArrJ[i10] = v10;
            return v11;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append(nb.T);
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: w8.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MapBuilder.kt */
    public static class C0720d<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final d<K, V> f35493a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f35494b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f35495c;

        public C0720d(@NotNull d<K, V> map) {
            t.i(map, "map");
            this.f35493a = map;
            this.f35495c = -1;
            e();
        }

        public final int a() {
            return this.f35494b;
        }

        public final int b() {
            return this.f35495c;
        }

        @NotNull
        public final d<K, V> c() {
            return this.f35493a;
        }

        public final void e() {
            while (this.f35494b < ((d) this.f35493a).f35484f) {
                int[] iArr = ((d) this.f35493a).f35481c;
                int i10 = this.f35494b;
                if (iArr[i10] >= 0) {
                    return;
                } else {
                    this.f35494b = i10 + 1;
                }
            }
        }

        public final void f(int i10) {
            this.f35494b = i10;
        }

        public final void g(int i10) {
            this.f35495c = i10;
        }

        public final boolean hasNext() {
            return this.f35494b < ((d) this.f35493a).f35484f;
        }

        public final void remove() {
            if (!(this.f35495c != -1)) {
                throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
            }
            this.f35493a.l();
            this.f35493a.K(this.f35495c);
            this.f35495c = -1;
        }
    }

    /* JADX INFO: compiled from: MapBuilder.kt */
    public static final class e<K, V> extends C0720d<K, V> implements Iterator<K>, i9.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@NotNull d<K, V> map) {
            super(map);
            t.i(map, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            if (a() >= ((d) c()).f35484f) {
                throw new NoSuchElementException();
            }
            int iA = a();
            f(iA + 1);
            g(iA);
            K k10 = (K) ((d) c()).f35479a[b()];
            e();
            return k10;
        }
    }

    /* JADX INFO: compiled from: MapBuilder.kt */
    public static final class f<K, V> extends C0720d<K, V> implements Iterator<V>, i9.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(@NotNull d<K, V> map) {
            super(map);
            t.i(map, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            if (a() >= ((d) c()).f35484f) {
                throw new NoSuchElementException();
            }
            int iA = a();
            f(iA + 1);
            g(iA);
            Object[] objArr = ((d) c()).f35480b;
            t.f(objArr);
            V v10 = (V) objArr[b()];
            e();
            return v10;
        }
    }

    static {
        d dVar = new d(0);
        dVar.f35490l = true;
        f35478n = dVar;
    }

    private d(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i10, int i11) {
        this.f35479a = kArr;
        this.f35480b = vArr;
        this.f35481c = iArr;
        this.f35482d = iArr2;
        this.f35483e = i10;
        this.f35484f = i11;
        this.f35485g = f35477m.d(x());
    }

    private final int B(K k10) {
        return ((k10 != null ? k10.hashCode() : 0) * (-1640531527)) >>> this.f35485g;
    }

    private final boolean D(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        boolean z10 = false;
        if (collection.isEmpty()) {
            return false;
        }
        r(collection.size());
        Iterator<? extends Map.Entry<? extends K, ? extends V>> it = collection.iterator();
        while (it.hasNext()) {
            if (E(it.next())) {
                z10 = true;
            }
        }
        return z10;
    }

    private final boolean E(Map.Entry<? extends K, ? extends V> entry) {
        int i10 = i(entry.getKey());
        V[] vArrJ = j();
        if (i10 >= 0) {
            vArrJ[i10] = entry.getValue();
            return true;
        }
        int i11 = (-i10) - 1;
        if (t.d(entry.getValue(), vArrJ[i11])) {
            return false;
        }
        vArrJ[i11] = entry.getValue();
        return true;
    }

    private final boolean F(int i10) {
        int iB = B(this.f35479a[i10]);
        int i11 = this.f35483e;
        while (true) {
            int[] iArr = this.f35482d;
            if (iArr[iB] == 0) {
                iArr[iB] = i10 + 1;
                this.f35481c[i10] = iB;
                return true;
            }
            i11--;
            if (i11 < 0) {
                return false;
            }
            iB = iB == 0 ? x() - 1 : iB - 1;
        }
    }

    private final void G(int i10) {
        if (this.f35484f > size()) {
            m();
        }
        int i11 = 0;
        if (i10 != x()) {
            this.f35482d = new int[i10];
            this.f35485g = f35477m.d(i10);
        } else {
            kotlin.collections.o.r(this.f35482d, 0, 0, x());
        }
        while (i11 < this.f35484f) {
            int i12 = i11 + 1;
            if (!F(i11)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i11 = i12;
        }
    }

    private final void I(int i10) {
        int iJ = o.j(this.f35483e * 2, x() / 2);
        int i11 = 0;
        int i12 = i10;
        do {
            i10 = i10 == 0 ? x() - 1 : i10 - 1;
            i11++;
            if (i11 > this.f35483e) {
                this.f35482d[i12] = 0;
                return;
            }
            int[] iArr = this.f35482d;
            int i13 = iArr[i10];
            if (i13 == 0) {
                iArr[i12] = 0;
                return;
            }
            if (i13 < 0) {
                iArr[i12] = -1;
            } else {
                int i14 = i13 - 1;
                if (((B(this.f35479a[i14]) - i10) & (x() - 1)) >= i11) {
                    this.f35482d[i12] = i13;
                    this.f35481c[i14] = i12;
                }
                iJ--;
            }
            i12 = i10;
            i11 = 0;
            iJ--;
        } while (iJ >= 0);
        this.f35482d[i12] = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(int i10) {
        w8.c.f(this.f35479a, i10);
        I(this.f35481c[i10]);
        this.f35481c[i10] = -1;
        this.f35486h = size() - 1;
    }

    private final boolean M(int i10) {
        int iV = v();
        int i11 = this.f35484f;
        int i12 = iV - i11;
        int size = i11 - size();
        return i12 < i10 && i12 + size >= i10 && size >= v() / 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V[] j() {
        V[] vArr = this.f35480b;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) w8.c.d(v());
        this.f35480b = vArr2;
        return vArr2;
    }

    private final void m() {
        int i10;
        V[] vArr = this.f35480b;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            i10 = this.f35484f;
            if (i11 >= i10) {
                break;
            }
            if (this.f35481c[i11] >= 0) {
                K[] kArr = this.f35479a;
                kArr[i12] = kArr[i11];
                if (vArr != null) {
                    vArr[i12] = vArr[i11];
                }
                i12++;
            }
            i11++;
        }
        w8.c.g(this.f35479a, i12, i10);
        if (vArr != null) {
            w8.c.g(vArr, i12, this.f35484f);
        }
        this.f35484f = i12;
    }

    private final boolean p(Map<?, ?> map) {
        return size() == map.size() && n(map.entrySet());
    }

    private final void q(int i10) {
        if (i10 < 0) {
            throw new OutOfMemoryError();
        }
        if (i10 > v()) {
            int iV = (v() * 3) / 2;
            if (i10 <= iV) {
                i10 = iV;
            }
            this.f35479a = (K[]) w8.c.e(this.f35479a, i10);
            V[] vArr = this.f35480b;
            this.f35480b = vArr != null ? (V[]) w8.c.e(vArr, i10) : null;
            int[] iArrCopyOf = Arrays.copyOf(this.f35481c, i10);
            t.h(iArrCopyOf, "copyOf(this, newSize)");
            this.f35481c = iArrCopyOf;
            int iC = f35477m.c(i10);
            if (iC > x()) {
                G(iC);
            }
        }
    }

    private final void r(int i10) {
        if (M(i10)) {
            G(x());
        } else {
            q(this.f35484f + i10);
        }
    }

    private final int t(K k10) {
        int iB = B(k10);
        int i10 = this.f35483e;
        while (true) {
            int i11 = this.f35482d[iB];
            if (i11 == 0) {
                return -1;
            }
            if (i11 > 0) {
                int i12 = i11 - 1;
                if (t.d(this.f35479a[i12], k10)) {
                    return i12;
                }
            }
            i10--;
            if (i10 < 0) {
                return -1;
            }
            iB = iB == 0 ? x() - 1 : iB - 1;
        }
    }

    private final int u(V v10) {
        int i10 = this.f35484f;
        while (true) {
            i10--;
            if (i10 < 0) {
                return -1;
            }
            if (this.f35481c[i10] >= 0) {
                V[] vArr = this.f35480b;
                t.f(vArr);
                if (t.d(vArr[i10], v10)) {
                    return i10;
                }
            }
        }
    }

    private final int x() {
        return this.f35482d.length;
    }

    @NotNull
    public Collection<V> A() {
        g<V> gVar = this.f35488j;
        if (gVar != null) {
            return gVar;
        }
        g<V> gVar2 = new g<>(this);
        this.f35488j = gVar2;
        return gVar2;
    }

    @NotNull
    public final e<K, V> C() {
        return new e<>(this);
    }

    public final boolean H(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        t.i(entry, "entry");
        l();
        int iT = t(entry.getKey());
        if (iT < 0) {
            return false;
        }
        V[] vArr = this.f35480b;
        t.f(vArr);
        if (!t.d(vArr[iT], entry.getValue())) {
            return false;
        }
        K(iT);
        return true;
    }

    public final int J(K k10) {
        l();
        int iT = t(k10);
        if (iT < 0) {
            return -1;
        }
        K(iT);
        return iT;
    }

    public final boolean L(V v10) {
        l();
        int iU = u(v10);
        if (iU < 0) {
            return false;
        }
        K(iU);
        return true;
    }

    @NotNull
    public final f<K, V> N() {
        return new f<>(this);
    }

    @Override // java.util.Map
    public void clear() {
        l();
        l0 it = new i(0, this.f35484f - 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            int[] iArr = this.f35481c;
            int i10 = iArr[iNextInt];
            if (i10 >= 0) {
                this.f35482d[i10] = 0;
                iArr[iNextInt] = -1;
            }
        }
        w8.c.g(this.f35479a, 0, this.f35484f);
        V[] vArr = this.f35480b;
        if (vArr != null) {
            w8.c.g(vArr, 0, this.f35484f);
        }
        this.f35486h = 0;
        this.f35484f = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return t(obj) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return u(obj) >= 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return w();
    }

    @Override // java.util.Map
    public boolean equals(@Nullable Object obj) {
        return obj == this || ((obj instanceof Map) && p((Map) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Nullable
    public V get(Object obj) {
        int iT = t(obj);
        if (iT < 0) {
            return null;
        }
        V[] vArr = this.f35480b;
        t.f(vArr);
        return vArr[iT];
    }

    @Override // java.util.Map
    public int hashCode() {
        b<K, V> bVarS = s();
        int iJ = 0;
        while (bVarS.hasNext()) {
            iJ += bVarS.j();
        }
        return iJ;
    }

    public final int i(K k10) {
        l();
        while (true) {
            int iB = B(k10);
            int iJ = o.j(this.f35483e * 2, x() / 2);
            int i10 = 0;
            while (true) {
                int i11 = this.f35482d[iB];
                if (i11 <= 0) {
                    if (this.f35484f < v()) {
                        int i12 = this.f35484f;
                        int i13 = i12 + 1;
                        this.f35484f = i13;
                        this.f35479a[i12] = k10;
                        this.f35481c[i12] = iB;
                        this.f35482d[iB] = i13;
                        this.f35486h = size() + 1;
                        if (i10 > this.f35483e) {
                            this.f35483e = i10;
                        }
                        return i12;
                    }
                    r(1);
                } else {
                    if (t.d(this.f35479a[i11 - 1], k10)) {
                        return -i11;
                    }
                    i10++;
                    if (i10 > iJ) {
                        G(x() * 2);
                        break;
                    }
                    iB = iB == 0 ? x() - 1 : iB - 1;
                }
            }
        }
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @NotNull
    public final Map<K, V> k() {
        l();
        this.f35490l = true;
        if (size() > 0) {
            return this;
        }
        d dVar = f35478n;
        t.g(dVar, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return dVar;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return y();
    }

    public final void l() {
        if (this.f35490l) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean n(@NotNull Collection<?> m10) {
        t.i(m10, "m");
        for (Object obj : m10) {
            if (obj != null) {
                try {
                    if (!o((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean o(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        t.i(entry, "entry");
        int iT = t(entry.getKey());
        if (iT < 0) {
            return false;
        }
        V[] vArr = this.f35480b;
        t.f(vArr);
        return t.d(vArr[iT], entry.getValue());
    }

    @Override // java.util.Map
    @Nullable
    public V put(K k10, V v10) {
        l();
        int i10 = i(k10);
        V[] vArrJ = j();
        if (i10 >= 0) {
            vArrJ[i10] = v10;
            return null;
        }
        int i11 = (-i10) - 1;
        V v11 = vArrJ[i11];
        vArrJ[i11] = v10;
        return v11;
    }

    @Override // java.util.Map
    public void putAll(@NotNull Map<? extends K, ? extends V> from) {
        t.i(from, "from");
        l();
        D(from.entrySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Nullable
    public V remove(Object obj) {
        int iJ = J(obj);
        if (iJ < 0) {
            return null;
        }
        V[] vArr = this.f35480b;
        t.f(vArr);
        V v10 = vArr[iJ];
        w8.c.f(vArr, iJ);
        return v10;
    }

    @NotNull
    public final b<K, V> s() {
        return new b<>(this);
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return z();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        b<K, V> bVarS = s();
        int i10 = 0;
        while (bVarS.hasNext()) {
            if (i10 > 0) {
                sb.append(", ");
            }
            bVarS.i(sb);
            i10++;
        }
        sb.append("}");
        String string = sb.toString();
        t.h(string, "sb.toString()");
        return string;
    }

    public final int v() {
        return this.f35479a.length;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return A();
    }

    @NotNull
    public Set<Map.Entry<K, V>> w() {
        w8.e<K, V> eVar = this.f35489k;
        if (eVar != null) {
            return eVar;
        }
        w8.e<K, V> eVar2 = new w8.e<>(this);
        this.f35489k = eVar2;
        return eVar2;
    }

    @NotNull
    public Set<K> y() {
        w8.f<K> fVar = this.f35487i;
        if (fVar != null) {
            return fVar;
        }
        w8.f<K> fVar2 = new w8.f<>(this);
        this.f35487i = fVar2;
        return fVar2;
    }

    public int z() {
        return this.f35486h;
    }

    public d() {
        this(8);
    }

    public d(int i10) {
        this(w8.c.d(i10), null, new int[i10], new int[f35477m.c(i10)], 2, 0);
    }
}
