package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: compiled from: UnmodifiableIterator.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i1<E> implements Iterator<E> {
    protected i1() {
    }

    @Override // java.util.Iterator
    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
