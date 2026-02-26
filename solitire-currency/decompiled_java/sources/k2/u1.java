package k2;

/* JADX INFO: compiled from: LoadControl.java */
/* JADX INFO: loaded from: classes2.dex */
public interface u1 {
    void a(a3[] a3VarArr, l3.e1 e1Var, x3.s[] sVarArr);

    z3.b getAllocator();

    long getBackBufferDurationUs();

    void onPrepared();

    void onReleased();

    void onStopped();

    boolean retainBackBufferFromKeyframe();

    boolean shouldContinueLoading(long j10, long j11, float f10);

    boolean shouldStartPlayback(long j10, float f10, boolean z10, long j11);
}
