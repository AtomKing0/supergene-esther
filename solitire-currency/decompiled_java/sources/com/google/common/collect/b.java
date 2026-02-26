package com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: AbstractIterator.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b<T> extends i1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private EnumC0219b f9987a = EnumC0219b.NOT_READY;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private T f9988b;

    /* JADX INFO: compiled from: AbstractIterator.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9989a;

        static {
            int[] iArr = new int[EnumC0219b.values().length];
            f9989a = iArr;
            try {
                iArr[EnumC0219b.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9989a[EnumC0219b.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbstractIterator.java */
    private enum EnumC0219b {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    protected b() {
    }

    private boolean c() {
        this.f9987a = EnumC0219b.FAILED;
        this.f9988b = a();
        if (this.f9987a == EnumC0219b.DONE) {
            return false;
        }
        this.f9987a = EnumC0219b.READY;
        return true;
    }

    protected abstract T a();

    protected final T b() {
        this.f9987a = EnumC0219b.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        e5.o.o(this.f9987a != EnumC0219b.FAILED);
        int i10 = a.f9989a[this.f9987a.ordinal()];
        if (i10 == 1) {
            return false;
        }
        if (i10 != 2) {
            return c();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f9987a = EnumC0219b.NOT_READY;
        T t10 = (T) q0.a(this.f9988b);
        this.f9988b = null;
        return t10;
    }
}
