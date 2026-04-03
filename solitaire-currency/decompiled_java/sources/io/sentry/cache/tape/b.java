package io.sentry.cache.tape;

import io.sentry.cache.tape.c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FileObjectQueue.java */
/* JADX INFO: loaded from: classes5.dex */
final class b<T> extends c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f27684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f27685b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final c.a<T> f27686c;

    /* JADX INFO: compiled from: FileObjectQueue.java */
    private static final class a extends ByteArrayOutputStream {
        a() {
        }

        byte[] a() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    /* JADX INFO: renamed from: io.sentry.cache.tape.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FileObjectQueue.java */
    private final class C0583b implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Iterator<byte[]> f27687a;

        C0583b(Iterator<byte[]> it) {
            this.f27687a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f27687a.hasNext();
        }

        @Override // java.util.Iterator
        @Nullable
        public T next() {
            try {
                return b.this.f27686c.b(this.f27687a.next());
            } catch (IOException e10) {
                throw ((Error) d.x(e10));
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f27687a.remove();
        }
    }

    b(d dVar, c.a<T> aVar) {
        this.f27684a = dVar;
        this.f27686c = aVar;
    }

    @Override // io.sentry.cache.tape.c
    public void a(T t10) throws IOException {
        this.f27685b.reset();
        this.f27686c.a(t10, this.f27685b);
        this.f27684a.n(this.f27685b.a(), 0, this.f27685b.size());
    }

    @Override // io.sentry.cache.tape.c
    public void clear() throws IOException {
        this.f27684a.clear();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f27684a.close();
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new C0583b(this.f27684a.iterator());
    }

    @Override // io.sentry.cache.tape.c
    public int size() {
        return this.f27684a.size();
    }

    public String toString() {
        return "FileObjectQueue{queueFile=" + this.f27684a + '}';
    }

    @Override // io.sentry.cache.tape.c
    public void z(int i10) throws IOException {
        this.f27684a.G0(i10);
    }
}
