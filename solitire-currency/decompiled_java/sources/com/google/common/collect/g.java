package com.google.common.collect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: ArrayListMultimap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g<K, V> extends h<K, V> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    transient int f10060g;

    private g() {
        this(12, 3);
    }

    public static <K, V> g<K, V> C() {
        return new g<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.d
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public List<V> t() {
        return new ArrayList(this.f10060g);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.f, com.google.common.collect.l0
    public /* bridge */ /* synthetic */ Collection a() {
        return super.a();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.f, com.google.common.collect.l0
    public /* bridge */ /* synthetic */ Map b() {
        return super.b();
    }

    @Override // com.google.common.collect.f, com.google.common.collect.l0
    public /* bridge */ /* synthetic */ boolean c(Object obj, Object obj2) {
        return super.c(obj, obj2);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.l0
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean d(Object obj) {
        return super.d(obj);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.c, com.google.common.collect.d, com.google.common.collect.l0
    public /* bridge */ /* synthetic */ List get(Object obj) {
        return super.get(obj);
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.f, com.google.common.collect.l0
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ Set j() {
        return super.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean k(Object obj, Iterable iterable) {
        return super.k(obj, iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.c, com.google.common.collect.d, com.google.common.collect.l0
    public /* bridge */ /* synthetic */ boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    @Override // com.google.common.collect.f, com.google.common.collect.l0
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.l0
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.d, com.google.common.collect.f, com.google.common.collect.l0
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    private g(int i10, int i11) {
        super(t0.c(i10));
        k.b(i11, "expectedValuesPerKey");
        this.f10060g = i11;
    }
}
