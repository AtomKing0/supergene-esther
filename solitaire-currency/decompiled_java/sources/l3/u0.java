package l3;

import java.io.IOException;
import k2.p1;

/* JADX INFO: compiled from: SampleStream.java */
/* JADX INFO: loaded from: classes2.dex */
public interface u0 {
    int a(p1 p1Var, n2.g gVar, int i10);

    boolean isReady();

    void maybeThrowError() throws IOException;

    int skipData(long j10);
}
