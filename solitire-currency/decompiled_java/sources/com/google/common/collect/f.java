package com.google.common.collect;

import com.google.common.collect.n0;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: AbstractMultimap.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class f<K, V> implements l0<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient Collection<Map.Entry<K, V>> f10054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient Set<K> f10055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient Collection<V> f10056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private transient Map<K, Collection<V>> f10057d;

    /* JADX INFO: compiled from: AbstractMultimap.java */
    class a extends n0.b<K, V> {
        a() {
        }

        @Override // com.google.common.collect.n0.b
        l0<K, V> a() {
            return f.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return f.this.i();
        }
    }

    /* JADX INFO: compiled from: AbstractMultimap.java */
    class b extends f<K, V>.a implements Set<Map.Entry<K, V>> {
        b(f fVar) {
            super();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return c1.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return c1.d(this);
        }
    }

    /* JADX INFO: compiled from: AbstractMultimap.java */
    class c extends AbstractCollection<V> {
        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            f.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return f.this.d(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return f.this.l();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return f.this.size();
        }
    }

    f() {
    }

    @Override // com.google.common.collect.l0
    public Collection<Map.Entry<K, V>> a() {
        Collection<Map.Entry<K, V>> collection = this.f10054a;
        if (collection != null) {
            return collection;
        }
        Collection<Map.Entry<K, V>> collectionF = f();
        this.f10054a = collectionF;
        return collectionF;
    }

    @Override // com.google.common.collect.l0
    public Map<K, Collection<V>> b() {
        Map<K, Collection<V>> map = this.f10057d;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> mapE = e();
        this.f10057d = mapE;
        return mapE;
    }

    @Override // com.google.common.collect.l0
    public boolean c(Object obj, Object obj2) {
        Collection<V> collection = b().get(obj);
        return collection != null && collection.contains(obj2);
    }

    public boolean d(Object obj) {
        Iterator<Collection<V>> it = b().values().iterator();
        while (it.hasNext()) {
            if (it.next().contains(obj)) {
                return true;
            }
        }
        return false;
    }

    abstract Map<K, Collection<V>> e();

    public boolean equals(Object obj) {
        return n0.a(this, obj);
    }

    abstract Collection<Map.Entry<K, V>> f();

    abstract Set<K> g();

    abstract Collection<V> h();

    public int hashCode() {
        return b().hashCode();
    }

    abstract Iterator<Map.Entry<K, V>> i();

    @Override // com.google.common.collect.l0
    public boolean isEmpty() {
        return size() == 0;
    }

    public Set<K> j() {
        Set<K> set = this.f10055b;
        if (set != null) {
            return set;
        }
        Set<K> setG = g();
        this.f10055b = setG;
        return setG;
    }

    public boolean k(K k10, Iterable<? extends V> iterable) {
        e5.o.j(iterable);
        if (iterable instanceof Collection) {
            Collection<? extends V> collection = (Collection) iterable;
            return !collection.isEmpty() && get(k10).addAll(collection);
        }
        Iterator<? extends V> it = iterable.iterator();
        return it.hasNext() && h0.a(get(k10), it);
    }

    abstract Iterator<V> l();

    @Override // com.google.common.collect.l0
    public boolean remove(Object obj, Object obj2) {
        Collection<V> collection = b().get(obj);
        return collection != null && collection.remove(obj2);
    }

    public String toString() {
        return b().toString();
    }

    @Override // com.google.common.collect.l0
    public Collection<V> values() {
        Collection<V> collection = this.f10056c;
        if (collection != null) {
            return collection;
        }
        Collection<V> collectionH = h();
        this.f10056c = collectionH;
        return collectionH;
    }
}
