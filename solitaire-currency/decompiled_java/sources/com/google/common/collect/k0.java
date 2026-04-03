package com.google.common.collect;

import com.google.common.collect.c1;
import com.google.j2objc.annotations.Weak;
import com.ironsource.nb;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: Maps.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k0 {

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: compiled from: Maps.java */
    class a<K, V> extends g1<Map.Entry<K, V>, K> {
        a(Iterator it) {
            super(it);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.g1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public K a(Map.Entry<K, V> entry) {
            return entry.getKey();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: compiled from: Maps.java */
    class b<K, V> extends g1<Map.Entry<K, V>, V> {
        b(Iterator it) {
            super(it);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.g1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public V a(Map.Entry<K, V> entry) {
            return entry.getValue();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: Maps.java */
    private static abstract class c implements e5.g<Map.Entry<?, ?>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f10079a = new a("KEY", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f10080b = new b("VALUE", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ c[] f10081c = a();

        /* JADX INFO: compiled from: Maps.java */
        enum a extends c {
            a(String str, int i10) {
                super(str, i10, null);
            }

            @Override // e5.g
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        }

        /* JADX INFO: compiled from: Maps.java */
        enum b extends c {
            b(String str, int i10) {
                super(str, i10, null);
            }

            @Override // e5.g
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        }

        private c(String str, int i10) {
        }

        private static /* synthetic */ c[] a() {
            return new c[]{f10079a, f10080b};
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) f10081c.clone();
        }

        /* synthetic */ c(String str, int i10, a aVar) {
            this(str, i10);
        }
    }

    /* JADX INFO: compiled from: Maps.java */
    static abstract class d<K, V> extends c1.d<Map.Entry<K, V>> {
        d() {
        }

        abstract Map<K, V> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public abstract boolean contains(Object obj);

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // com.google.common.collect.c1.d, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) e5.o.j(collection));
            } catch (UnsupportedOperationException unused) {
                return c1.j(this, collection.iterator());
            }
        }

        @Override // com.google.common.collect.c1.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) e5.o.j(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetG = c1.g(collection.size());
                for (Object obj : collection) {
                    if (contains(obj) && (obj instanceof Map.Entry)) {
                        hashSetG.add(((Map.Entry) obj).getKey());
                    }
                }
                return a().keySet().retainAll(hashSetG);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().size();
        }
    }

    /* JADX INFO: compiled from: Maps.java */
    static class e<K, V> extends c1.d<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Weak
        final Map<K, V> f10082a;

        e(Map<K, V> map) {
            this.f10082a = (Map) e5.o.j(map);
        }

        Map<K, V> a() {
            return this.f10082a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return a().containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().size();
        }
    }

    /* JADX INFO: compiled from: Maps.java */
    static class f<K, V> extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Weak
        final Map<K, V> f10083a;

        f(Map<K, V> map) {
            this.f10083a = (Map) e5.o.j(map);
        }

        final Map<K, V> a() {
            return this.f10083a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return a().containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return k0.p(a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry<K, V> entry : a().entrySet()) {
                    if (e5.k.a(obj, entry.getValue())) {
                        a().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) e5.o.j(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetF = c1.f();
                for (Map.Entry<K, V> entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSetF.add(entry.getKey());
                    }
                }
                return a().keySet().removeAll(hashSetF);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) e5.o.j(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetF = c1.f();
                for (Map.Entry<K, V> entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSetF.add(entry.getKey());
                    }
                }
                return a().keySet().retainAll(hashSetF);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    /* JADX INFO: compiled from: Maps.java */
    static abstract class g<K, V> extends AbstractMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private transient Set<Map.Entry<K, V>> f10084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private transient Collection<V> f10085b;

        g() {
        }

        abstract Set<Map.Entry<K, V>> a();

        Collection<V> b() {
            return new f(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f10084a;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> setA = a();
            this.f10084a = setA;
            return setA;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            Collection<V> collection = this.f10085b;
            if (collection != null) {
                return collection;
            }
            Collection<V> collectionB = b();
            this.f10085b = collectionB;
            return collectionB;
        }
    }

    static int a(int i10) {
        if (i10 < 3) {
            k.b(i10, "expectedSize");
            return i10 + 1;
        }
        if (i10 < 1073741824) {
            return (int) Math.ceil(((double) i10) / 0.75d);
        }
        return Integer.MAX_VALUE;
    }

    static boolean b(Map<?, ?> map, Object obj) {
        return h0.e(g(map.entrySet().iterator()), obj);
    }

    static boolean c(Map<?, ?> map, Object obj) {
        return h0.e(p(map.entrySet().iterator()), obj);
    }

    static boolean d(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static <K, V> Map.Entry<K, V> e(K k10, V v10) {
        return new x(k10, v10);
    }

    static <K> e5.g<Map.Entry<K, ?>, K> f() {
        return c.f10079a;
    }

    static <K, V> Iterator<K> g(Iterator<Map.Entry<K, V>> it) {
        return new a(it);
    }

    public static <K, V> HashMap<K, V> h(int i10) {
        return new HashMap<>(a(i10));
    }

    public static <K, V> IdentityHashMap<K, V> i() {
        return new IdentityHashMap<>();
    }

    static <K, V> void j(Map<K, V> map, Map<? extends K, ? extends V> map2) {
        for (Map.Entry<? extends K, ? extends V> entry : map2.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
    }

    static boolean k(Map<?, ?> map, Object obj) {
        e5.o.j(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    static <V> V l(Map<?, V> map, Object obj) {
        e5.o.j(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    static <V> V m(Map<?, V> map, Object obj) {
        e5.o.j(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    static String n(Map<?, ?> map) {
        StringBuilder sbB = l.b(map.size());
        sbB.append('{');
        boolean z10 = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!z10) {
                sbB.append(", ");
            }
            sbB.append(entry.getKey());
            sbB.append(nb.T);
            sbB.append(entry.getValue());
            z10 = false;
        }
        sbB.append('}');
        return sbB.toString();
    }

    static <V> e5.g<Map.Entry<?, V>, V> o() {
        return c.f10080b;
    }

    static <K, V> Iterator<V> p(Iterator<Map.Entry<K, V>> it) {
        return new b(it);
    }
}
