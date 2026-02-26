package kotlin.collections;

import com.ironsource.nb;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AbstractMap.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class d<K, V> implements Map<K, V>, i9.a {

    @NotNull
    public static final a Companion = new a(null);

    @Nullable
    private volatile Set<? extends K> _keys;

    @Nullable
    private volatile Collection<? extends V> _values;

    /* JADX INFO: compiled from: AbstractMap.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: AbstractMap.kt */
    public static final class b extends i<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d<K, V> f29767a;

        /* JADX INFO: compiled from: AbstractMap.kt */
        public static final class a implements Iterator<K>, i9.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Iterator<Map.Entry<K, V>> f29768a;

            /* JADX WARN: Multi-variable type inference failed */
            a(Iterator<? extends Map.Entry<? extends K, ? extends V>> it) {
                this.f29768a = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f29768a.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                return this.f29768a.next().getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        b(d<K, ? extends V> dVar) {
            this.f29767a = dVar;
        }

        @Override // kotlin.collections.a, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return this.f29767a.containsKey(obj);
        }

        @Override // kotlin.collections.a
        public int getSize() {
            return this.f29767a.size();
        }

        @Override // kotlin.collections.i, kotlin.collections.a, java.util.Collection, java.lang.Iterable, java.util.List
        @NotNull
        public Iterator<K> iterator() {
            return new a(this.f29767a.entrySet().iterator());
        }
    }

    /* JADX INFO: compiled from: AbstractMap.kt */
    static final class c extends kotlin.jvm.internal.v implements h9.l<Map.Entry<? extends K, ? extends V>, CharSequence> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d<K, V> f29769g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(d<K, ? extends V> dVar) {
            super(1);
            this.f29769g = dVar;
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(@NotNull Map.Entry<? extends K, ? extends V> it) {
            kotlin.jvm.internal.t.i(it, "it");
            return this.f29769g.toString((Map.Entry) it);
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbstractMap.kt */
    public static final class C0604d extends kotlin.collections.a<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d<K, V> f29770a;

        /* JADX INFO: renamed from: kotlin.collections.d$d$a */
        /* JADX INFO: compiled from: AbstractMap.kt */
        public static final class a implements Iterator<V>, i9.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Iterator<Map.Entry<K, V>> f29771a;

            /* JADX WARN: Multi-variable type inference failed */
            a(Iterator<? extends Map.Entry<? extends K, ? extends V>> it) {
                this.f29771a = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f29771a.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                return this.f29771a.next().getValue();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        C0604d(d<K, ? extends V> dVar) {
            this.f29770a = dVar;
        }

        @Override // kotlin.collections.a, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return this.f29770a.containsValue(obj);
        }

        @Override // kotlin.collections.a
        public int getSize() {
            return this.f29770a.size();
        }

        @Override // kotlin.collections.a, java.util.Collection, java.lang.Iterable, java.util.List
        @NotNull
        public Iterator<V> iterator() {
            return new a(this.f29770a.entrySet().iterator());
        }
    }

    protected d() {
    }

    private final Map.Entry<K, V> implFindEntry(K k10) {
        Object next;
        Iterator<T> it = entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (kotlin.jvm.internal.t.d(((Map.Entry) next).getKey(), k10)) {
                break;
            }
        }
        return (Map.Entry) next;
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean containsEntry$kotlin_stdlib(@Nullable Map.Entry<?, ?> entry) {
        if (entry == null) {
            return false;
        }
        Object key = entry.getKey();
        Object value = entry.getValue();
        kotlin.jvm.internal.t.g(this, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
        V v10 = get(key);
        if (!kotlin.jvm.internal.t.d(value, v10)) {
            return false;
        }
        if (v10 != null) {
            return true;
        }
        kotlin.jvm.internal.t.g(this, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.containsKey, *>");
        return containsKey(key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return implFindEntry(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        Set<Map.Entry<K, V>> setEntrySet = entrySet();
        if ((setEntrySet instanceof Collection) && setEntrySet.isEmpty()) {
            return false;
        }
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.t.d(((Map.Entry) it.next()).getValue(), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        Set<Map.Entry<K, V>> setEntrySet = map.entrySet();
        if ((setEntrySet instanceof Collection) && setEntrySet.isEmpty()) {
            return true;
        }
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            if (!containsEntry$kotlin_stdlib((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Nullable
    public V get(Object obj) {
        Map.Entry<K, V> entryImplFindEntry = implFindEntry(obj);
        if (entryImplFindEntry != null) {
            return entryImplFindEntry.getValue();
        }
        return null;
    }

    public abstract Set getEntries();

    @NotNull
    public Set<K> getKeys() {
        if (this._keys == null) {
            this._keys = new b(this);
        }
        Set<? extends K> set = this._keys;
        kotlin.jvm.internal.t.f(set);
        return set;
    }

    public int getSize() {
        return entrySet().size();
    }

    @NotNull
    public Collection<V> getValues() {
        if (this._values == null) {
            this._values = new C0604d(this);
        }
        Collection<? extends V> collection = this._values;
        kotlin.jvm.internal.t.f(collection);
        return collection;
    }

    @Override // java.util.Map
    public int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @Override // java.util.Map, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    public V put(K k10, V v10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    public V remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @NotNull
    public String toString() {
        return d0.r0(entrySet(), ", ", "{", "}", 0, null, new c(this), 24, null);
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String toString(Map.Entry<? extends K, ? extends V> entry) {
        return toString(entry.getKey()) + nb.T + toString(entry.getValue());
    }

    private final String toString(Object obj) {
        return obj == this ? "(this Map)" : String.valueOf(obj);
    }
}
