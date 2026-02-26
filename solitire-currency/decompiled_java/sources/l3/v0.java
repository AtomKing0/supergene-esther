package l3;

/* JADX INFO: compiled from: SequenceableLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public interface v0 {

    /* JADX INFO: compiled from: SequenceableLoader.java */
    public interface a<T extends v0> {
        void c(T t10);
    }

    boolean a(long j10);

    long getBufferedPositionUs();

    long getNextLoadPositionUs();

    boolean isLoading();

    void reevaluateBuffer(long j10);
}
