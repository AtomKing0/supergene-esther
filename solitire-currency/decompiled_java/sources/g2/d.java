package g2;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.Closeable;

/* JADX INFO: compiled from: EventStore.java */
/* JADX INFO: loaded from: classes2.dex */
@WorkerThread
public interface d extends Closeable {
    long D(y1.o oVar);

    void H0(y1.o oVar, long j10);

    Iterable<k> Q(y1.o oVar);

    void Y(Iterable<k> iterable);

    @Nullable
    k Z(y1.o oVar, y1.i iVar);

    int l();

    void m(Iterable<k> iterable);

    boolean t0(y1.o oVar);

    Iterable<y1.o> u();
}
