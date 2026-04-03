package com.google.common.collect;

/* JADX INFO: compiled from: CollectPreconditions.java */
/* JADX INFO: loaded from: classes3.dex */
final class k {
    static void a(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        }
        if (obj2 != null) {
            return;
        }
        throw new NullPointerException("null value in entry: " + obj + "=null");
    }

    static int b(int i10, String str) {
        if (i10 >= 0) {
            return i10;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i10);
    }

    static void c(boolean z10) {
        e5.o.p(z10, "no calls to next() since the last call to remove()");
    }
}
