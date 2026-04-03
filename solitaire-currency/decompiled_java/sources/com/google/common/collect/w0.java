package com.google.common.collect;

/* JADX INFO: compiled from: RegularImmutableSet.java */
/* JADX INFO: loaded from: classes3.dex */
final class w0<E> extends c0<E> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Object[] f10147h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final w0<Object> f10148i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final transient Object[] f10149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final transient int f10150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final transient Object[] f10151e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final transient int f10152f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final transient int f10153g;

    static {
        Object[] objArr = new Object[0];
        f10147h = objArr;
        f10148i = new w0<>(objArr, 0, objArr, 0, 0);
    }

    w0(Object[] objArr, int i10, Object[] objArr2, int i11, int i12) {
        this.f10149c = objArr;
        this.f10150d = i10;
        this.f10151e = objArr2;
        this.f10152f = i11;
        this.f10153g = i12;
    }

    @Override // com.google.common.collect.w
    int b(Object[] objArr, int i10) {
        System.arraycopy(this.f10149c, 0, objArr, i10, this.f10153g);
        return i10 + this.f10153g;
    }

    @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        Object[] objArr = this.f10151e;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int iC = v.c(obj);
        while (true) {
            int i10 = iC & this.f10152f;
            Object obj2 = objArr[i10];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            iC = i10 + 1;
        }
    }

    @Override // com.google.common.collect.w
    Object[] d() {
        return this.f10149c;
    }

    @Override // com.google.common.collect.w
    int e() {
        return this.f10153g;
    }

    @Override // com.google.common.collect.w
    int f() {
        return 0;
    }

    @Override // com.google.common.collect.w
    boolean g() {
        return false;
    }

    @Override // com.google.common.collect.c0, com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: h */
    public i1<E> iterator() {
        return a().iterator();
    }

    @Override // com.google.common.collect.c0, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f10150d;
    }

    @Override // com.google.common.collect.c0
    y<E> o() {
        return y.j(this.f10149c, this.f10153g);
    }

    @Override // com.google.common.collect.c0
    boolean p() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f10153g;
    }
}
