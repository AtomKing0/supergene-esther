package com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: AbstractIndexedListIterator.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class a<E> extends j1<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9974b;

    protected a(int i10, int i11) {
        e5.o.l(i11, i10);
        this.f9973a = i10;
        this.f9974b = i11;
    }

    protected abstract E a(int i10);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f9974b < this.f9973a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f9974b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f9974b;
        this.f9974b = i10 + 1;
        return a(i10);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f9974b;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f9974b - 1;
        this.f9974b = i10;
        return a(i10);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f9974b - 1;
    }
}
