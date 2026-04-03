package ab;

import java.io.IOException;

/* JADX INFO: compiled from: Call.java */
/* JADX INFO: loaded from: classes5.dex */
public interface b<T> extends Cloneable {
    ga.b0 a();

    void cancel();

    b<T> clone();

    y<T> execute() throws IOException;

    void i0(d<T> dVar);

    boolean isCanceled();
}
