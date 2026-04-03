package l3;

import java.io.IOException;
import k2.f3;
import l3.v0;

/* JADX INFO: compiled from: MediaPeriod.java */
/* JADX INFO: loaded from: classes2.dex */
public interface x extends v0 {

    /* JADX INFO: compiled from: MediaPeriod.java */
    public interface a extends v0.a<x> {
        void d(x xVar);
    }

    @Override // l3.v0
    boolean a(long j10);

    void b(a aVar, long j10);

    void discardBuffer(long j10, boolean z10);

    long g(x3.s[] sVarArr, boolean[] zArr, u0[] u0VarArr, boolean[] zArr2, long j10);

    @Override // l3.v0
    long getBufferedPositionUs();

    @Override // l3.v0
    long getNextLoadPositionUs();

    e1 getTrackGroups();

    long i(long j10, f3 f3Var);

    @Override // l3.v0
    boolean isLoading();

    void maybeThrowPrepareError() throws IOException;

    long readDiscontinuity();

    @Override // l3.v0
    void reevaluateBuffer(long j10);

    long seekToUs(long j10);
}
