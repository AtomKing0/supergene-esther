package com.google.common.collect;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: ComparatorOrdering.java */
/* JADX INFO: loaded from: classes3.dex */
final class o<T> extends s0<T> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Comparator<T> f10117a;

    o(Comparator<T> comparator) {
        this.f10117a = (Comparator) e5.o.j(comparator);
    }

    @Override // com.google.common.collect.s0, java.util.Comparator
    public int compare(T t10, T t11) {
        return this.f10117a.compare(t10, t11);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            return this.f10117a.equals(((o) obj).f10117a);
        }
        return false;
    }

    public int hashCode() {
        return this.f10117a.hashCode();
    }

    public String toString() {
        return this.f10117a.toString();
    }
}
