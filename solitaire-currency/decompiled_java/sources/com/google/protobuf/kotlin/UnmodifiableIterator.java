package com.google.protobuf.kotlin;

import i9.a;
import java.util.Iterator;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: UnmodifiableCollections.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UnmodifiableIterator<E> implements Iterator<E>, a {
    private final /* synthetic */ Iterator<E> $$delegate_0;

    /* JADX WARN: Multi-variable type inference failed */
    public UnmodifiableIterator(@NotNull Iterator<? extends E> delegate) {
        t.i(delegate, "delegate");
        this.$$delegate_0 = delegate;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.$$delegate_0.hasNext();
    }

    @Override // java.util.Iterator
    public E next() {
        return this.$$delegate_0.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
