package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: compiled from: ReverseOrdering.java */
/* JADX INFO: loaded from: classes3.dex */
final class z0<T> extends s0<T> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final s0<? super T> f10165a;

    z0(s0<? super T> s0Var) {
        this.f10165a = (s0) e5.o.j(s0Var);
    }

    @Override // com.google.common.collect.s0, java.util.Comparator
    public int compare(T t10, T t11) {
        return this.f10165a.compare(t11, t10);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof z0) {
            return this.f10165a.equals(((z0) obj).f10165a);
        }
        return false;
    }

    @Override // com.google.common.collect.s0
    public <S extends T> s0<S> g() {
        return this.f10165a;
    }

    public int hashCode() {
        return -this.f10165a.hashCode();
    }

    public String toString() {
        return this.f10165a + ".reverse()";
    }
}
