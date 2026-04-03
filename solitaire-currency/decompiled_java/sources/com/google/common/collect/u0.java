package com.google.common.collect;

import java.util.Objects;

/* JADX INFO: compiled from: RegularImmutableList.java */
/* JADX INFO: loaded from: classes3.dex */
class u0<E> extends y<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final y<Object> f10126e = new u0(new Object[0], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final transient Object[] f10127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final transient int f10128d;

    u0(Object[] objArr, int i10) {
        this.f10127c = objArr;
        this.f10128d = i10;
    }

    @Override // com.google.common.collect.y, com.google.common.collect.w
    int b(Object[] objArr, int i10) {
        System.arraycopy(this.f10127c, 0, objArr, i10, this.f10128d);
        return i10 + this.f10128d;
    }

    @Override // com.google.common.collect.w
    Object[] d() {
        return this.f10127c;
    }

    @Override // com.google.common.collect.w
    int e() {
        return this.f10128d;
    }

    @Override // com.google.common.collect.w
    int f() {
        return 0;
    }

    @Override // com.google.common.collect.w
    boolean g() {
        return false;
    }

    @Override // java.util.List
    public E get(int i10) {
        e5.o.h(i10, this.f10128d);
        E e10 = (E) this.f10127c[i10];
        Objects.requireNonNull(e10);
        return e10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f10128d;
    }
}
