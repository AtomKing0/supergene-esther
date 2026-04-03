package com.google.common.collect;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: Multimaps.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n0 {

    /* JADX INFO: compiled from: Multimaps.java */
    private static class a<K, V> extends c<K, V> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        transient e5.u<? extends List<V>> f10116g;

        a(Map<K, Collection<V>> map, e5.u<? extends List<V>> uVar) {
            super(map);
            this.f10116g = (e5.u) e5.o.j(uVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.d
        /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
        public List<V> t() {
            return this.f10116g.get();
        }

        @Override // com.google.common.collect.d, com.google.common.collect.f
        Map<K, Collection<V>> e() {
            return v();
        }

        @Override // com.google.common.collect.d, com.google.common.collect.f
        Set<K> g() {
            return w();
        }
    }

    /* JADX INFO: compiled from: Multimaps.java */
    static abstract class b<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        b() {
        }

        abstract l0<K, V> a();

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a().c(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a().remove(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    static boolean a(l0<?, ?> l0Var, Object obj) {
        if (obj == l0Var) {
            return true;
        }
        if (obj instanceof l0) {
            return l0Var.b().equals(((l0) obj).b());
        }
        return false;
    }

    public static <K, V> i0<K, V> b(Map<K, Collection<V>> map, e5.u<? extends List<V>> uVar) {
        return new a(map, uVar);
    }
}
