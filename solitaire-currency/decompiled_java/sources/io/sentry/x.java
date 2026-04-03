package io.sentry;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DisabledQueue.java */
/* JADX INFO: loaded from: classes5.dex */
final class x<E> extends AbstractCollection<E> implements Queue<E>, Serializable {

    /* JADX INFO: compiled from: DisabledQueue.java */
    class a implements Iterator<E> {
        a() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(@NotNull E e10) {
        return false;
    }

    @Override // java.util.Queue
    @Nullable
    public E element() {
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<E> iterator() {
        return new a();
    }

    @Override // java.util.Queue
    public boolean offer(@NotNull E e10) {
        return false;
    }

    @Override // java.util.Queue
    @Nullable
    public E peek() {
        return null;
    }

    @Override // java.util.Queue
    @Nullable
    public E poll() {
        return null;
    }

    @Override // java.util.Queue
    @NotNull
    public E remove() {
        throw new NoSuchElementException("queue is disabled");
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
    }
}
