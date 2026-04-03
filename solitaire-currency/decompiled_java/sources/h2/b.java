package h2;

import androidx.annotation.WorkerThread;

/* JADX INFO: compiled from: SynchronizationGuard.java */
/* JADX INFO: loaded from: classes2.dex */
@WorkerThread
public interface b {

    /* JADX INFO: compiled from: SynchronizationGuard.java */
    public interface a<T> {
        T execute();
    }

    <T> T i(a<T> aVar);
}
