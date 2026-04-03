package o1;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

/* JADX INFO: compiled from: CachedHashCodeArrayMap.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b<K, V> extends ArrayMap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f31790a;

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public void clear() {
        this.f31790a = 0;
        super.clear();
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public int hashCode() {
        if (this.f31790a == 0) {
            this.f31790a = super.hashCode();
        }
        return this.f31790a;
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public V put(K k10, V v10) {
        this.f31790a = 0;
        return (V) super.put(k10, v10);
    }

    @Override // androidx.collection.SimpleArrayMap
    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this.f31790a = 0;
        super.putAll(simpleArrayMap);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V removeAt(int i10) {
        this.f31790a = 0;
        return (V) super.removeAt(i10);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V setValueAt(int i10, V v10) {
        this.f31790a = 0;
        return (V) super.setValueAt(i10, v10);
    }
}
