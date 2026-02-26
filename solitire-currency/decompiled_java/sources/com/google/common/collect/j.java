package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: compiled from: ByFunctionOrdering.java */
/* JADX INFO: loaded from: classes3.dex */
final class j<F, T> extends s0<F> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final e5.g<F, ? extends T> f10071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final s0<T> f10072b;

    j(e5.g<F, ? extends T> gVar, s0<T> s0Var) {
        this.f10071a = (e5.g) e5.o.j(gVar);
        this.f10072b = (s0) e5.o.j(s0Var);
    }

    @Override // com.google.common.collect.s0, java.util.Comparator
    public int compare(F f10, F f11) {
        return this.f10072b.compare(this.f10071a.apply(f10), this.f10071a.apply(f11));
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f10071a.equals(jVar.f10071a) && this.f10072b.equals(jVar.f10072b);
    }

    public int hashCode() {
        return e5.k.b(this.f10071a, this.f10072b);
    }

    public String toString() {
        return this.f10072b + ".onResultOf(" + this.f10071a + ")";
    }
}
