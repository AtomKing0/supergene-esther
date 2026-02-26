package com.google.common.collect;

import com.google.common.collect.f;
import com.google.common.collect.k0;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class d<K, V> extends com.google.common.collect.f<K, V> implements Serializable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private transient Map<K, Collection<V>> f10016e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient int f10017f;

    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    class b extends d<K, V>.AbstractC0221d<Map.Entry<K, V>> {
        b(d dVar) {
            super();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.d.AbstractC0221d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> a(K k10, V v10) {
            return k0.e(k10, v10);
        }
    }

    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    private class c extends k0.g<K, Collection<V>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final transient Map<K, Collection<V>> f10018c;

        /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
        class a extends k0.d<K, Collection<V>> {
            a() {
            }

            @Override // com.google.common.collect.k0.d
            Map<K, Collection<V>> a() {
                return c.this;
            }

            @Override // com.google.common.collect.k0.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return com.google.common.collect.l.c(c.this.f10018c.entrySet(), obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return c.this.new b();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                d.this.y(entry.getKey());
                return true;
            }
        }

        /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
        class b implements Iterator<Map.Entry<K, Collection<V>>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Iterator<Map.Entry<K, Collection<V>>> f10021a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Collection<V> f10022b;

            b() {
                this.f10021a = c.this.f10018c.entrySet().iterator();
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, Collection<V>> next() {
                Map.Entry<K, Collection<V>> next = this.f10021a.next();
                this.f10022b = next.getValue();
                return c.this.f(next);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f10021a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                e5.o.p(this.f10022b != null, "no calls to next() since the last call to remove()");
                this.f10021a.remove();
                d.r(d.this, this.f10022b.size());
                this.f10022b.clear();
                this.f10022b = null;
            }
        }

        c(Map<K, Collection<V>> map) {
            this.f10018c = map;
        }

        @Override // com.google.common.collect.k0.g
        protected Set<Map.Entry<K, Collection<V>>> a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Collection<V> get(Object obj) {
            Collection<V> collection = (Collection) k0.l(this.f10018c, obj);
            if (collection == null) {
                return null;
            }
            return d.this.A(obj, collection);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.f10018c == d.this.f10016e) {
                d.this.clear();
            } else {
                h0.d(new b());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return k0.k(this.f10018c, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection<V> remove(Object obj) {
            Collection<V> collectionRemove = this.f10018c.remove(obj);
            if (collectionRemove == null) {
                return null;
            }
            Collection<V> collectionT = d.this.t();
            collectionT.addAll(collectionRemove);
            d.r(d.this, collectionRemove.size());
            collectionRemove.clear();
            return collectionT;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(Object obj) {
            return this == obj || this.f10018c.equals(obj);
        }

        Map.Entry<K, Collection<V>> f(Map.Entry<K, Collection<V>> entry) {
            K key = entry.getKey();
            return k0.e(key, d.this.A(key, entry.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.f10018c.hashCode();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return d.this.j();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f10018c.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.f10018c.toString();
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    private abstract class AbstractC0221d<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Iterator<Map.Entry<K, Collection<V>>> f10024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        K f10025b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Collection<V> f10026c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Iterator<V> f10027d = h0.i();

        AbstractC0221d() {
            this.f10024a = d.this.f10016e.entrySet().iterator();
        }

        abstract T a(K k10, V v10);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f10024a.hasNext() || this.f10027d.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f10027d.hasNext()) {
                Map.Entry<K, Collection<V>> next = this.f10024a.next();
                this.f10025b = next.getKey();
                Collection<V> value = next.getValue();
                this.f10026c = value;
                this.f10027d = value.iterator();
            }
            return a(q0.a(this.f10025b), this.f10027d.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f10027d.remove();
            Collection<V> collection = this.f10026c;
            Objects.requireNonNull(collection);
            if (collection.isEmpty()) {
                this.f10024a.remove();
            }
            d.p(d.this);
        }
    }

    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    private class e extends k0.e<K, Collection<V>> {

        /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
        class a implements Iterator<K> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Map.Entry<K, Collection<V>> f10030a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Iterator f10031b;

            a(Iterator it) {
                this.f10031b = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f10031b.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                Map.Entry<K, Collection<V>> entry = (Map.Entry) this.f10031b.next();
                this.f10030a = entry;
                return entry.getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                e5.o.p(this.f10030a != null, "no calls to next() since the last call to remove()");
                Collection<V> value = this.f10030a.getValue();
                this.f10031b.remove();
                d.r(d.this, value.size());
                value.clear();
                this.f10030a = null;
            }
        }

        e(Map<K, Collection<V>> map) {
            super(map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h0.d(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return a().keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return this == obj || a().keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return a().keySet().hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int size;
            Collection<V> collectionRemove = a().remove(obj);
            if (collectionRemove != null) {
                size = collectionRemove.size();
                collectionRemove.clear();
                d.r(d.this, size);
            } else {
                size = 0;
            }
            return size > 0;
        }
    }

    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    class f extends d<K, V>.i implements NavigableMap<K, Collection<V>> {
        f(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> ceilingEntry(K k10) {
            Map.Entry<K, Collection<V>> entryCeilingEntry = i().ceilingEntry(k10);
            if (entryCeilingEntry == null) {
                return null;
            }
            return f(entryCeilingEntry);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k10) {
            return i().ceilingKey(k10);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> descendingMap() {
            return new f(i().descendingMap());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry<K, Collection<V>> entryFirstEntry = i().firstEntry();
            if (entryFirstEntry == null) {
                return null;
            }
            return f(entryFirstEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> floorEntry(K k10) {
            Map.Entry<K, Collection<V>> entryFloorEntry = i().floorEntry(k10);
            if (entryFloorEntry == null) {
                return null;
            }
            return f(entryFloorEntry);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k10) {
            return i().floorKey(k10);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> higherEntry(K k10) {
            Map.Entry<K, Collection<V>> entryHigherEntry = i().higherEntry(k10);
            if (entryHigherEntry == null) {
                return null;
            }
            return f(entryHigherEntry);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k10) {
            return i().higherKey(k10);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.d.i
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public NavigableSet<K> g() {
            return new g(i());
        }

        @Override // com.google.common.collect.d.i, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> headMap(K k10) {
            return headMap(k10, false);
        }

        @Override // com.google.common.collect.d.i, com.google.common.collect.d.c, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableSet<K> keySet() {
            return (NavigableSet) super.keySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry<K, Collection<V>> entryLastEntry = i().lastEntry();
            if (entryLastEntry == null) {
                return null;
            }
            return f(entryLastEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lowerEntry(K k10) {
            Map.Entry<K, Collection<V>> entryLowerEntry = i().lowerEntry(k10);
            if (entryLowerEntry == null) {
                return null;
            }
            return f(entryLowerEntry);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k10) {
            return i().lowerKey(k10);
        }

        Map.Entry<K, Collection<V>> m(Iterator<Map.Entry<K, Collection<V>>> it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry<K, Collection<V>> next = it.next();
            Collection<V> collectionT = d.this.t();
            collectionT.addAll(next.getValue());
            it.remove();
            return k0.e(next.getKey(), d.this.z(collectionT));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.d.i
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> i() {
            return (NavigableMap) super.i();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return h();
        }

        @Override // com.google.common.collect.d.i, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> subMap(K k10, K k11) {
            return subMap(k10, true, k11, false);
        }

        @Override // com.google.common.collect.d.i, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> tailMap(K k10) {
            return tailMap(k10, true);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            return m(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollLastEntry() {
            return m(descendingMap().entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> headMap(K k10, boolean z10) {
            return new f(i().headMap(k10, z10));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> subMap(K k10, boolean z10, K k11, boolean z11) {
            return new f(i().subMap(k10, z10, k11, z11));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> tailMap(K k10, boolean z10) {
            return new f(i().tailMap(k10, z10));
        }
    }

    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    class g extends d<K, V>.j implements NavigableSet<K> {
        g(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k10) {
            return b().ceilingKey(k10);
        }

        @Override // com.google.common.collect.d.j, java.util.SortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public NavigableSet<K> headSet(K k10) {
            return headSet(k10, false);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return new g(b().descendingMap());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.d.j
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> b() {
            return (NavigableMap) super.b();
        }

        @Override // com.google.common.collect.d.j, java.util.SortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableSet<K> subSet(K k10, K k11) {
            return subSet(k10, true, k11, false);
        }

        @Override // java.util.NavigableSet
        public K floor(K k10) {
            return b().floorKey(k10);
        }

        @Override // com.google.common.collect.d.j, java.util.SortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public NavigableSet<K> tailSet(K k10) {
            return tailSet(k10, true);
        }

        @Override // java.util.NavigableSet
        public K higher(K k10) {
            return b().higherKey(k10);
        }

        @Override // java.util.NavigableSet
        public K lower(K k10) {
            return b().lowerKey(k10);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            return (K) h0.q(iterator());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) h0.q(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k10, boolean z10) {
            return new g(b().headMap(k10, z10));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k10, boolean z10, K k11, boolean z11) {
            return new g(b().subMap(k10, z10, k11, z11));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k10, boolean z10) {
            return new g(b().tailMap(k10, z10));
        }
    }

    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    private class h extends d<K, V>.l implements RandomAccess {
        h(d dVar, K k10, List<V> list, d<K, V>.k kVar) {
            super(k10, list, kVar);
        }
    }

    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    private class i extends d<K, V>.c implements SortedMap<K, Collection<V>> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        SortedSet<K> f10035e;

        i(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return i().comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return i().firstKey();
        }

        SortedSet<K> g() {
            return new j(i());
        }

        @Override // com.google.common.collect.d.c, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: h */
        public SortedSet<K> keySet() {
            SortedSet<K> sortedSet = this.f10035e;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet<K> sortedSetG = g();
            this.f10035e = sortedSetG;
            return sortedSetG;
        }

        public SortedMap<K, Collection<V>> headMap(K k10) {
            return new i(i().headMap(k10));
        }

        SortedMap<K, Collection<V>> i() {
            return (SortedMap) this.f10018c;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return i().lastKey();
        }

        public SortedMap<K, Collection<V>> subMap(K k10, K k11) {
            return new i(i().subMap(k10, k11));
        }

        public SortedMap<K, Collection<V>> tailMap(K k10) {
            return new i(i().tailMap(k10));
        }
    }

    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    private class j extends d<K, V>.e implements SortedSet<K> {
        j(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        SortedMap<K, Collection<V>> b() {
            return (SortedMap) super.a();
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return b().comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return b().firstKey();
        }

        public SortedSet<K> headSet(K k10) {
            return new j(b().headMap(k10));
        }

        @Override // java.util.SortedSet
        public K last() {
            return b().lastKey();
        }

        public SortedSet<K> subSet(K k10, K k11) {
            return new j(b().subMap(k10, k11));
        }

        public SortedSet<K> tailSet(K k10) {
            return new j(b().tailMap(k10));
        }
    }

    protected d(Map<K, Collection<V>> map) {
        e5.o.d(map.isEmpty());
        this.f10016e = map;
    }

    static /* synthetic */ int o(d dVar) {
        int i10 = dVar.f10017f;
        dVar.f10017f = i10 + 1;
        return i10;
    }

    static /* synthetic */ int p(d dVar) {
        int i10 = dVar.f10017f;
        dVar.f10017f = i10 - 1;
        return i10;
    }

    static /* synthetic */ int q(d dVar, int i10) {
        int i11 = dVar.f10017f + i10;
        dVar.f10017f = i11;
        return i11;
    }

    static /* synthetic */ int r(d dVar, int i10) {
        int i11 = dVar.f10017f - i10;
        dVar.f10017f = i11;
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Iterator<E> x(Collection<E> collection) {
        return collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Object obj) {
        Collection collection = (Collection) k0.m(this.f10016e, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.f10017f -= size;
        }
    }

    abstract Collection<V> A(K k10, Collection<V> collection);

    final List<V> B(K k10, List<V> list, d<K, V>.k kVar) {
        return list instanceof RandomAccess ? new h(this, k10, list, kVar) : new l(k10, list, kVar);
    }

    @Override // com.google.common.collect.f, com.google.common.collect.l0
    public Collection<Map.Entry<K, V>> a() {
        return super.a();
    }

    @Override // com.google.common.collect.l0
    public void clear() {
        Iterator<Collection<V>> it = this.f10016e.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.f10016e.clear();
        this.f10017f = 0;
    }

    @Override // com.google.common.collect.f
    Map<K, Collection<V>> e() {
        return new c(this.f10016e);
    }

    @Override // com.google.common.collect.f
    Collection<Map.Entry<K, V>> f() {
        return this instanceof a1 ? new f.b(this) : new f.a();
    }

    @Override // com.google.common.collect.f
    Set<K> g() {
        return new e(this.f10016e);
    }

    @Override // com.google.common.collect.l0
    public Collection<V> get(K k10) {
        Collection<V> collectionU = this.f10016e.get(k10);
        if (collectionU == null) {
            collectionU = u(k10);
        }
        return A(k10, collectionU);
    }

    @Override // com.google.common.collect.f
    Collection<V> h() {
        return new f.c();
    }

    @Override // com.google.common.collect.f
    Iterator<Map.Entry<K, V>> i() {
        return new b(this);
    }

    @Override // com.google.common.collect.f
    Iterator<V> l() {
        return new a(this);
    }

    @Override // com.google.common.collect.l0
    public boolean put(K k10, V v10) {
        Collection<V> collection = this.f10016e.get(k10);
        if (collection != null) {
            if (!collection.add(v10)) {
                return false;
            }
            this.f10017f++;
            return true;
        }
        Collection<V> collectionU = u(k10);
        if (!collectionU.add(v10)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.f10017f++;
        this.f10016e.put(k10, collectionU);
        return true;
    }

    @Override // com.google.common.collect.l0
    public int size() {
        return this.f10017f;
    }

    abstract Collection<V> t();

    Collection<V> u(K k10) {
        return t();
    }

    final Map<K, Collection<V>> v() {
        Map<K, Collection<V>> map = this.f10016e;
        return map instanceof NavigableMap ? new f((NavigableMap) this.f10016e) : map instanceof SortedMap ? new i((SortedMap) this.f10016e) : new c(this.f10016e);
    }

    @Override // com.google.common.collect.f, com.google.common.collect.l0
    public Collection<V> values() {
        return super.values();
    }

    final Set<K> w() {
        Map<K, Collection<V>> map = this.f10016e;
        return map instanceof NavigableMap ? new g((NavigableMap) this.f10016e) : map instanceof SortedMap ? new j((SortedMap) this.f10016e) : new e(this.f10016e);
    }

    abstract <E> Collection<E> z(Collection<E> collection);

    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    class k extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final K f10038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Collection<V> f10039b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final d<K, V>.k f10040c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Collection<V> f10041d;

        k(K k10, Collection<V> collection, d<K, V>.k kVar) {
            this.f10038a = k10;
            this.f10039b = collection;
            this.f10040c = kVar;
            this.f10041d = kVar == null ? null : kVar.d();
        }

        void a() {
            d<K, V>.k kVar = this.f10040c;
            if (kVar != null) {
                kVar.a();
            } else {
                d.this.f10016e.put(this.f10038a, this.f10039b);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(V v10) {
            f();
            boolean zIsEmpty = this.f10039b.isEmpty();
            boolean zAdd = this.f10039b.add(v10);
            if (zAdd) {
                d.o(d.this);
                if (zIsEmpty) {
                    a();
                }
            }
            return zAdd;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = this.f10039b.addAll(collection);
            if (zAddAll) {
                d.q(d.this, this.f10039b.size() - size);
                if (size == 0) {
                    a();
                }
            }
            return zAddAll;
        }

        d<K, V>.k b() {
            return this.f10040c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.f10039b.clear();
            d.r(d.this, size);
            g();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            f();
            return this.f10039b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            f();
            return this.f10039b.containsAll(collection);
        }

        Collection<V> d() {
            return this.f10039b;
        }

        K e() {
            return this.f10038a;
        }

        @Override // java.util.Collection
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            f();
            return this.f10039b.equals(obj);
        }

        void f() {
            Collection<V> collection;
            d<K, V>.k kVar = this.f10040c;
            if (kVar != null) {
                kVar.f();
                if (this.f10040c.d() != this.f10041d) {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (!this.f10039b.isEmpty() || (collection = (Collection) d.this.f10016e.get(this.f10038a)) == null) {
                    return;
                }
                this.f10039b = collection;
            }
        }

        void g() {
            d<K, V>.k kVar = this.f10040c;
            if (kVar != null) {
                kVar.g();
            } else if (this.f10039b.isEmpty()) {
                d.this.f10016e.remove(this.f10038a);
            }
        }

        @Override // java.util.Collection
        public int hashCode() {
            f();
            return this.f10039b.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            f();
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            f();
            boolean zRemove = this.f10039b.remove(obj);
            if (zRemove) {
                d.p(d.this);
                g();
            }
            return zRemove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zRemoveAll = this.f10039b.removeAll(collection);
            if (zRemoveAll) {
                d.q(d.this, this.f10039b.size() - size);
                g();
            }
            return zRemoveAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            e5.o.j(collection);
            int size = size();
            boolean zRetainAll = this.f10039b.retainAll(collection);
            if (zRetainAll) {
                d.q(d.this, this.f10039b.size() - size);
                g();
            }
            return zRetainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            f();
            return this.f10039b.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            f();
            return this.f10039b.toString();
        }

        /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
        class a implements Iterator<V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Iterator<V> f10043a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final Collection<V> f10044b;

            a() {
                Collection<V> collection = k.this.f10039b;
                this.f10044b = collection;
                this.f10043a = d.x(collection);
            }

            Iterator<V> a() {
                b();
                return this.f10043a;
            }

            void b() {
                k.this.f();
                if (k.this.f10039b != this.f10044b) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                b();
                return this.f10043a.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                b();
                return this.f10043a.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f10043a.remove();
                d.p(d.this);
                k.this.g();
            }

            a(Iterator<V> it) {
                this.f10044b = k.this.f10039b;
                this.f10043a = it;
            }
        }
    }

    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    class l extends d<K, V>.k implements List<V> {

        /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
        private class a extends d<K, V>.k.a implements ListIterator<V> {
            a() {
                super();
            }

            private ListIterator<V> c() {
                return (ListIterator) a();
            }

            @Override // java.util.ListIterator
            public void add(V v10) {
                boolean zIsEmpty = l.this.isEmpty();
                c().add(v10);
                d.o(d.this);
                if (zIsEmpty) {
                    l.this.a();
                }
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return c().hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return c().nextIndex();
            }

            @Override // java.util.ListIterator
            public V previous() {
                return c().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return c().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(V v10) {
                c().set(v10);
            }

            public a(int i10) {
                super(l.this.h().listIterator(i10));
            }
        }

        l(K k10, List<V> list, d<K, V>.k kVar) {
            super(k10, list, kVar);
        }

        @Override // java.util.List
        public void add(int i10, V v10) {
            f();
            boolean zIsEmpty = d().isEmpty();
            h().add(i10, v10);
            d.o(d.this);
            if (zIsEmpty) {
                a();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i10, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = h().addAll(i10, collection);
            if (zAddAll) {
                d.q(d.this, d().size() - size);
                if (size == 0) {
                    a();
                }
            }
            return zAddAll;
        }

        @Override // java.util.List
        public V get(int i10) {
            f();
            return h().get(i10);
        }

        List<V> h() {
            return (List) d();
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            f();
            return h().indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            f();
            return h().lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            f();
            return new a();
        }

        @Override // java.util.List
        public V remove(int i10) {
            f();
            V vRemove = h().remove(i10);
            d.p(d.this);
            g();
            return vRemove;
        }

        @Override // java.util.List
        public V set(int i10, V v10) {
            f();
            return h().set(i10, v10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public List<V> subList(int i10, int i11) {
            f();
            return d.this.B(e(), h().subList(i10, i11), b() == null ? this : b());
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int i10) {
            f();
            return new a(i10);
        }
    }

    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    class a extends d<K, V>.AbstractC0221d<V> {
        a(d dVar) {
            super();
        }

        @Override // com.google.common.collect.d.AbstractC0221d
        V a(K k10, V v10) {
            return v10;
        }
    }
}
