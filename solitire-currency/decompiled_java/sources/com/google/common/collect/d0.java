package com.google.common.collect;

import com.google.common.collect.a0;
import com.google.common.collect.b0;
import com.google.j2objc.annotations.RetainedWith;
import com.google.j2objc.annotations.Weak;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: compiled from: ImmutableSetMultimap.java */
/* JADX INFO: loaded from: classes3.dex */
public class d0<K, V> extends b0<K, V> implements a1<K, V> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final transient c0<V> f10048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @RetainedWith
    private transient c0<Map.Entry<K, V>> f10049h;

    /* JADX INFO: compiled from: ImmutableSetMultimap.java */
    public static final class a<K, V> extends b0.c<K, V> {
        public d0<K, V> a() {
            Collection collectionEntrySet = this.f10004a.entrySet();
            Comparator<? super K> comparator = this.f10005b;
            if (comparator != null) {
                collectionEntrySet = s0.b(comparator).e().c(collectionEntrySet);
            }
            return d0.y(collectionEntrySet, this.f10006c);
        }
    }

    /* JADX INFO: compiled from: ImmutableSetMultimap.java */
    private static final class b<K, V> extends c0<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Weak
        private final transient d0<K, V> f10050c;

        b(d0<K, V> d0Var) {
            this.f10050c = d0Var;
        }

        @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f10050c.c(entry.getKey(), entry.getValue());
        }

        @Override // com.google.common.collect.w
        boolean g() {
            return false;
        }

        @Override // com.google.common.collect.c0, com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* JADX INFO: renamed from: h */
        public i1<Map.Entry<K, V>> iterator() {
            return this.f10050c.i();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f10050c.size();
        }
    }

    d0(a0<K, c0<V>> a0Var, int i10, Comparator<? super V> comparator) {
        super(a0Var, i10);
        this.f10048g = w(comparator);
    }

    public static <K, V> d0<K, V> A() {
        return s.f10125i;
    }

    private static <V> c0<V> B(Comparator<? super V> comparator, Collection<? extends V> collection) {
        return comparator == null ? c0.m(collection) : e0.z(comparator, collection);
    }

    private static <V> c0<V> w(Comparator<? super V> comparator) {
        return comparator == null ? c0.q() : e0.D(comparator);
    }

    static <K, V> d0<K, V> y(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, Comparator<? super V> comparator) {
        if (collection.isEmpty()) {
            return A();
        }
        a0.a aVar = new a0.a(collection.size());
        int size = 0;
        for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : collection) {
            K key = entry.getKey();
            c0 c0VarB = B(comparator, entry.getValue());
            if (!c0VarB.isEmpty()) {
                aVar.f(key, c0VarB);
                size += c0VarB.size();
            }
        }
        return new d0<>(aVar.c(), size, comparator);
    }

    @Override // com.google.common.collect.b0
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public c0<Map.Entry<K, V>> a() {
        c0<Map.Entry<K, V>> c0Var = this.f10049h;
        if (c0Var != null) {
            return c0Var;
        }
        b bVar = new b(this);
        this.f10049h = bVar;
        return bVar;
    }

    @Override // com.google.common.collect.b0
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public c0<V> get(K k10) {
        return (c0) e5.i.a((c0) this.f9995e.get(k10), this.f10048g);
    }
}
