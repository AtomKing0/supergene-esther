package io.sentry.cache.tape;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ObjectQueue.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public abstract class c<T> implements Iterable<T>, Closeable {

    /* JADX INFO: compiled from: ObjectQueue.java */
    public interface a<T> {
        void a(T t10, OutputStream outputStream) throws IOException;

        @Nullable
        T b(byte[] bArr) throws IOException;
    }

    public static <T> c<T> n(d dVar, a<T> aVar) {
        return new b(dVar, aVar);
    }

    public static <T> c<T> q() {
        return new io.sentry.cache.tape.a();
    }

    public abstract void a(T t10) throws IOException;

    public void clear() throws IOException {
        z(size());
    }

    public List<T> i() throws IOException {
        return x(size());
    }

    public abstract int size();

    public List<T> x(int i10) throws IOException {
        int iMin = Math.min(i10, size());
        ArrayList arrayList = new ArrayList(iMin);
        Iterator<T> it = iterator();
        for (int i11 = 0; i11 < iMin; i11++) {
            arrayList.add(it.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public abstract void z(int i10) throws IOException;
}
