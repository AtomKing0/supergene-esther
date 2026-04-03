package com.google.common.collect;

import com.google.common.collect.a0;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: RegularImmutableMap.java */
/* JADX INFO: loaded from: classes3.dex */
final class v0<K, V> extends a0<K, V> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final a0<Object, Object> f10129h = new v0(null, new Object[0], 0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final transient Object f10130e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final transient Object[] f10131f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final transient int f10132g;

    /* JADX INFO: compiled from: RegularImmutableMap.java */
    static class a<K, V> extends c0<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final transient a0<K, V> f10133c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final transient Object[] f10134d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final transient int f10135e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final transient int f10136f;

        /* JADX INFO: renamed from: com.google.common.collect.v0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: RegularImmutableMap.java */
        class C0223a extends y<Map.Entry<K, V>> {
            C0223a() {
            }

            @Override // java.util.List
            /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> get(int i10) {
                e5.o.h(i10, a.this.f10136f);
                int i11 = i10 * 2;
                Object obj = a.this.f10134d[a.this.f10135e + i11];
                Objects.requireNonNull(obj);
                Object obj2 = a.this.f10134d[i11 + (a.this.f10135e ^ 1)];
                Objects.requireNonNull(obj2);
                return new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }

            @Override // com.google.common.collect.w
            public boolean g() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return a.this.f10136f;
            }
        }

        a(a0<K, V> a0Var, Object[] objArr, int i10, int i11) {
            this.f10133c = a0Var;
            this.f10134d = objArr;
            this.f10135e = i10;
            this.f10136f = i11;
        }

        @Override // com.google.common.collect.w
        int b(Object[] objArr, int i10) {
            return a().b(objArr, i10);
        }

        @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.f10133c.get(key));
        }

        @Override // com.google.common.collect.w
        boolean g() {
            return true;
        }

        @Override // com.google.common.collect.c0, com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* JADX INFO: renamed from: h */
        public i1<Map.Entry<K, V>> iterator() {
            return a().iterator();
        }

        @Override // com.google.common.collect.c0
        y<Map.Entry<K, V>> o() {
            return new C0223a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f10136f;
        }
    }

    /* JADX INFO: compiled from: RegularImmutableMap.java */
    static final class b<K> extends c0<K> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final transient a0<K, ?> f10138c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final transient y<K> f10139d;

        b(a0<K, ?> a0Var, y<K> yVar) {
            this.f10138c = a0Var;
            this.f10139d = yVar;
        }

        @Override // com.google.common.collect.c0, com.google.common.collect.w
        public y<K> a() {
            return this.f10139d;
        }

        @Override // com.google.common.collect.w
        int b(Object[] objArr, int i10) {
            return a().b(objArr, i10);
        }

        @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.f10138c.get(obj) != null;
        }

        @Override // com.google.common.collect.w
        boolean g() {
            return true;
        }

        @Override // com.google.common.collect.c0, com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* JADX INFO: renamed from: h */
        public i1<K> iterator() {
            return a().iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f10138c.size();
        }
    }

    /* JADX INFO: compiled from: RegularImmutableMap.java */
    static final class c extends y<Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final transient Object[] f10140c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final transient int f10141d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final transient int f10142e;

        c(Object[] objArr, int i10, int i11) {
            this.f10140c = objArr;
            this.f10141d = i10;
            this.f10142e = i11;
        }

        @Override // com.google.common.collect.w
        boolean g() {
            return true;
        }

        @Override // java.util.List
        public Object get(int i10) {
            e5.o.h(i10, this.f10142e);
            Object obj = this.f10140c[(i10 * 2) + this.f10141d];
            Objects.requireNonNull(obj);
            return obj;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f10142e;
        }
    }

    private v0(Object obj, Object[] objArr, int i10) {
        this.f10130e = obj;
        this.f10131f = objArr;
        this.f10132g = i10;
    }

    static <K, V> v0<K, V> n(int i10, Object[] objArr) {
        return o(i10, objArr, null);
    }

    static <K, V> v0<K, V> o(int i10, Object[] objArr, a0.a<K, V> aVar) {
        if (i10 == 0) {
            return (v0) f10129h;
        }
        if (i10 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[1];
            Objects.requireNonNull(obj2);
            k.a(obj, obj2);
            return new v0<>(null, objArr, 1);
        }
        e5.o.l(i10, objArr.length >> 1);
        Object objP = p(objArr, i10, c0.k(i10), 0);
        if (objP instanceof Object[]) {
            Object[] objArr2 = (Object[]) objP;
            a0.a.C0218a c0218a = (a0.a.C0218a) objArr2[2];
            if (aVar == null) {
                throw c0218a.a();
            }
            aVar.f9983e = c0218a;
            Object obj3 = objArr2[0];
            int iIntValue = ((Integer) objArr2[1]).intValue();
            objArr = Arrays.copyOf(objArr, iIntValue * 2);
            objP = obj3;
            i10 = iIntValue;
        }
        return new v0<>(objP, objArr, i10);
    }

    private static Object p(Object[] objArr, int i10, int i11, int i12) {
        a0.a.C0218a c0218a = null;
        if (i10 == 1) {
            Object obj = objArr[i12];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[i12 ^ 1];
            Objects.requireNonNull(obj2);
            k.a(obj, obj2);
            return null;
        }
        int i13 = i11 - 1;
        int i14 = -1;
        if (i11 <= 128) {
            byte[] bArr = new byte[i11];
            Arrays.fill(bArr, (byte) -1);
            int i15 = 0;
            for (int i16 = 0; i16 < i10; i16++) {
                int i17 = (i16 * 2) + i12;
                int i18 = (i15 * 2) + i12;
                Object obj3 = objArr[i17];
                Objects.requireNonNull(obj3);
                Object obj4 = objArr[i17 ^ 1];
                Objects.requireNonNull(obj4);
                k.a(obj3, obj4);
                int iB = v.b(obj3.hashCode());
                while (true) {
                    int i19 = iB & i13;
                    int i20 = bArr[i19] & 255;
                    if (i20 == 255) {
                        bArr[i19] = (byte) i18;
                        if (i15 < i16) {
                            objArr[i18] = obj3;
                            objArr[i18 ^ 1] = obj4;
                        }
                        i15++;
                    } else {
                        if (obj3.equals(objArr[i20])) {
                            int i21 = i20 ^ 1;
                            Object obj5 = objArr[i21];
                            Objects.requireNonNull(obj5);
                            c0218a = new a0.a.C0218a(obj3, obj4, obj5);
                            objArr[i21] = obj4;
                            break;
                        }
                        iB = i19 + 1;
                    }
                }
            }
            return i15 == i10 ? bArr : new Object[]{bArr, Integer.valueOf(i15), c0218a};
        }
        if (i11 <= 32768) {
            short[] sArr = new short[i11];
            Arrays.fill(sArr, (short) -1);
            int i22 = 0;
            for (int i23 = 0; i23 < i10; i23++) {
                int i24 = (i23 * 2) + i12;
                int i25 = (i22 * 2) + i12;
                Object obj6 = objArr[i24];
                Objects.requireNonNull(obj6);
                Object obj7 = objArr[i24 ^ 1];
                Objects.requireNonNull(obj7);
                k.a(obj6, obj7);
                int iB2 = v.b(obj6.hashCode());
                while (true) {
                    int i26 = iB2 & i13;
                    int i27 = sArr[i26] & 65535;
                    if (i27 == 65535) {
                        sArr[i26] = (short) i25;
                        if (i22 < i23) {
                            objArr[i25] = obj6;
                            objArr[i25 ^ 1] = obj7;
                        }
                        i22++;
                    } else {
                        if (obj6.equals(objArr[i27])) {
                            int i28 = i27 ^ 1;
                            Object obj8 = objArr[i28];
                            Objects.requireNonNull(obj8);
                            c0218a = new a0.a.C0218a(obj6, obj7, obj8);
                            objArr[i28] = obj7;
                            break;
                        }
                        iB2 = i26 + 1;
                    }
                }
            }
            return i22 == i10 ? sArr : new Object[]{sArr, Integer.valueOf(i22), c0218a};
        }
        int[] iArr = new int[i11];
        Arrays.fill(iArr, -1);
        int i29 = 0;
        int i30 = 0;
        while (i29 < i10) {
            int i31 = (i29 * 2) + i12;
            int i32 = (i30 * 2) + i12;
            Object obj9 = objArr[i31];
            Objects.requireNonNull(obj9);
            Object obj10 = objArr[i31 ^ 1];
            Objects.requireNonNull(obj10);
            k.a(obj9, obj10);
            int iB3 = v.b(obj9.hashCode());
            while (true) {
                int i33 = iB3 & i13;
                int i34 = iArr[i33];
                if (i34 == i14) {
                    iArr[i33] = i32;
                    if (i30 < i29) {
                        objArr[i32] = obj9;
                        objArr[i32 ^ 1] = obj10;
                    }
                    i30++;
                } else {
                    if (obj9.equals(objArr[i34])) {
                        int i35 = i34 ^ 1;
                        Object obj11 = objArr[i35];
                        Objects.requireNonNull(obj11);
                        c0218a = new a0.a.C0218a(obj9, obj10, obj11);
                        objArr[i35] = obj10;
                        break;
                    }
                    iB3 = i33 + 1;
                    i14 = -1;
                }
            }
            i29++;
            i14 = -1;
        }
        return i30 == i10 ? iArr : new Object[]{iArr, Integer.valueOf(i30), c0218a};
    }

    static Object q(Object obj, Object[] objArr, int i10, int i11, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i10 == 1) {
            Object obj3 = objArr[i11];
            Objects.requireNonNull(obj3);
            if (!obj3.equals(obj2)) {
                return null;
            }
            Object obj4 = objArr[i11 ^ 1];
            Objects.requireNonNull(obj4);
            return obj4;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length - 1;
            int iB = v.b(obj2.hashCode());
            while (true) {
                int i12 = iB & length;
                int i13 = bArr[i12] & 255;
                if (i13 == 255) {
                    return null;
                }
                if (obj2.equals(objArr[i13])) {
                    return objArr[i13 ^ 1];
                }
                iB = i12 + 1;
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length2 = sArr.length - 1;
            int iB2 = v.b(obj2.hashCode());
            while (true) {
                int i14 = iB2 & length2;
                int i15 = sArr[i14] & 65535;
                if (i15 == 65535) {
                    return null;
                }
                if (obj2.equals(objArr[i15])) {
                    return objArr[i15 ^ 1];
                }
                iB2 = i14 + 1;
            }
        } else {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length - 1;
            int iB3 = v.b(obj2.hashCode());
            while (true) {
                int i16 = iB3 & length3;
                int i17 = iArr[i16];
                if (i17 == -1) {
                    return null;
                }
                if (obj2.equals(objArr[i17])) {
                    return objArr[i17 ^ 1];
                }
                iB3 = i16 + 1;
            }
        }
    }

    @Override // com.google.common.collect.a0
    c0<Map.Entry<K, V>> e() {
        return new a(this, this.f10131f, 0, this.f10132g);
    }

    @Override // com.google.common.collect.a0
    c0<K> f() {
        return new b(this, new c(this.f10131f, 0, this.f10132g));
    }

    @Override // com.google.common.collect.a0
    w<V> g() {
        return new c(this.f10131f, 1, this.f10132g);
    }

    @Override // com.google.common.collect.a0, java.util.Map
    public V get(Object obj) {
        V v10 = (V) q(this.f10130e, this.f10131f, this.f10132g, 0, obj);
        if (v10 == null) {
            return null;
        }
        return v10;
    }

    @Override // com.google.common.collect.a0
    boolean i() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f10132g;
    }
}
