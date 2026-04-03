package io.sentry.cache.tape;

import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EmptyObjectQueue.java */
/* JADX INFO: loaded from: classes5.dex */
final class a<T> extends c<T> {

    /* JADX INFO: compiled from: EmptyObjectQueue.java */
    private static final class b<T> implements Iterator<T> {
        private b() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            throw new NoSuchElementException("No elements in EmptyIterator!");
        }
    }

    a() {
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        return new b();
    }

    @Override // io.sentry.cache.tape.c
    public int size() {
        return 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // io.sentry.cache.tape.c
    public void a(T t10) throws IOException {
    }

    @Override // io.sentry.cache.tape.c
    public void z(int i10) throws IOException {
    }
}
