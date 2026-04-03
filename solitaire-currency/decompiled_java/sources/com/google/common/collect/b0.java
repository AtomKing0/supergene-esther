package com.google.common.collect;

import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: ImmutableMultimap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b0<K, V> extends i<K, V> implements Serializable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final transient a0<K, ? extends w<V>> f9995e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final transient int f9996f;

    /* JADX INFO: compiled from: ImmutableMultimap.java */
    class a extends i1<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Iterator<? extends Map.Entry<K, ? extends w<V>>> f9997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        K f9998b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Iterator<V> f9999c = h0.g();

        a() {
            this.f9997a = b0.this.f9995e.entrySet().iterator();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (!this.f9999c.hasNext()) {
                Map.Entry<K, ? extends w<V>> next = this.f9997a.next();
                this.f9998b = next.getKey();
                this.f9999c = next.getValue().iterator();
            }
            K k10 = this.f9998b;
            Objects.requireNonNull(k10);
            return k0.e(k10, this.f9999c.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9999c.hasNext() || this.f9997a.hasNext();
        }
    }

    /* JADX INFO: compiled from: ImmutableMultimap.java */
    class b extends i1<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Iterator<? extends w<V>> f10001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Iterator<V> f10002b = h0.g();

        b() {
            this.f10001a = b0.this.f9995e.values().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f10002b.hasNext() || this.f10001a.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            if (!this.f10002b.hasNext()) {
                this.f10002b = this.f10001a.next().iterator();
            }
            return this.f10002b.next();
        }
    }

    /* JADX INFO: compiled from: ImmutableMultimap.java */
    public static class c<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map<K, Collection<V>> f10004a = t0.d();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Comparator<? super K> f10005b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Comparator<? super V> f10006c;
    }

    /* JADX INFO: compiled from: ImmutableMultimap.java */
    private static class d<K, V> extends w<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Weak
        final b0<K, V> f10007b;

        d(b0<K, V> b0Var) {
            this.f10007b = b0Var;
        }

        @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f10007b.c(entry.getKey(), entry.getValue());
        }

        @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* JADX INFO: renamed from: h */
        public i1<Map.Entry<K, V>> iterator() {
            return this.f10007b.i();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f10007b.size();
        }
    }

    /* JADX INFO: compiled from: ImmutableMultimap.java */
    private static final class e<K, V> extends w<V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Weak
        private final transient b0<K, V> f10008b;

        e(b0<K, V> b0Var) {
            this.f10008b = b0Var;
        }

        @Override // com.google.common.collect.w
        int b(Object[] objArr, int i10) {
            i1<? extends w<V>> it = this.f10008b.f9995e.values().iterator();
            while (it.hasNext()) {
                i10 = it.next().b(objArr, i10);
            }
            return i10;
        }

        @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.f10008b.d(obj);
        }

        @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* JADX INFO: renamed from: h */
        public i1<V> iterator() {
            return this.f10008b.l();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f10008b.size();
        }
    }

    b0(a0<K, ? extends w<V>> a0Var, int i10) {
        this.f9995e = a0Var;
        this.f9996f = i10;
    }

    @Override // com.google.common.collect.f, com.google.common.collect.l0
    public /* bridge */ /* synthetic */ boolean c(Object obj, Object obj2) {
        return super.c(obj, obj2);
    }

    @Override // com.google.common.collect.l0
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.f
    public boolean d(Object obj) {
        return obj != null && super.d(obj);
    }

    @Override // com.google.common.collect.f
    Map<K, Collection<V>> e() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.f
    Set<K> g() {
        throw new AssertionError("unreachable");
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.f, com.google.common.collect.l0
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.f, com.google.common.collect.l0
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public a0<K, Collection<V>> b() {
        return this.f9995e;
    }

    public boolean n(Object obj) {
        return this.f9995e.containsKey(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.f
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public w<Map.Entry<K, V>> f() {
        return new d(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.f
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public w<V> h() {
        return new e(this);
    }

    @Override // com.google.common.collect.l0
    @Deprecated
    public final boolean put(K k10, V v10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.f, com.google.common.collect.l0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public w<Map.Entry<K, V>> a() {
        return (w) super.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.f
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public i1<Map.Entry<K, V>> i() {
        return new a();
    }

    @Override // com.google.common.collect.f, com.google.common.collect.l0
    @Deprecated
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.l0
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public abstract w<V> get(K k10);

    @Override // com.google.common.collect.l0
    public int size() {
        return this.f9996f;
    }

    public c0<K> t() {
        return this.f9995e.keySet();
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.f
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public i1<V> l() {
        return new b();
    }

    @Override // com.google.common.collect.f, com.google.common.collect.l0
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public w<V> values() {
        return (w) super.values();
    }
}
