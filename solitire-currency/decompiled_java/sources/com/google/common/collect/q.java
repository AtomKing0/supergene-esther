package com.google.common.collect;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: CompoundOrdering.java */
/* JADX INFO: loaded from: classes3.dex */
final class q<T> extends s0<T> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Comparator<? super T>[] f10123a;

    q(Comparator<? super T> comparator, Comparator<? super T> comparator2) {
        this.f10123a = new Comparator[]{comparator, comparator2};
    }

    @Override // com.google.common.collect.s0, java.util.Comparator
    public int compare(T t10, T t11) {
        int i10 = 0;
        while (true) {
            Comparator<? super T>[] comparatorArr = this.f10123a;
            if (i10 >= comparatorArr.length) {
                return 0;
            }
            int iCompare = comparatorArr[i10].compare(t10, t11);
            if (iCompare != 0) {
                return iCompare;
            }
            i10++;
        }
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof q) {
            return Arrays.equals(this.f10123a, ((q) obj).f10123a);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f10123a);
    }

    public String toString() {
        return "Ordering.compound(" + Arrays.toString(this.f10123a) + ")";
    }
}
