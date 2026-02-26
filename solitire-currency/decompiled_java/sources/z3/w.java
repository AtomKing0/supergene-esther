package z3;

import androidx.media3.common.C;
import java.io.FileNotFoundException;
import java.io.IOException;
import k2.j2;
import z3.f0;
import z3.g0;

/* JADX INFO: compiled from: DefaultLoadErrorHandlingPolicy.java */
/* JADX INFO: loaded from: classes2.dex */
public class w implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f37557a;

    public w() {
        this(-1);
    }

    @Override // z3.f0
    public long a(f0.a aVar) {
        IOException iOException = aVar.f37392c;
        return ((iOException instanceof j2) || (iOException instanceof FileNotFoundException) || (iOException instanceof y) || (iOException instanceof g0.h) || l.a(iOException)) ? C.TIME_UNSET : Math.min((aVar.f37393d - 1) * 1000, 5000);
    }

    @Override // z3.f0
    public int getMinimumLoadableRetryCount(int i10) {
        int i11 = this.f37557a;
        return i11 == -1 ? i10 == 7 ? 6 : 3 : i11;
    }

    @Override // z3.f0
    public /* synthetic */ void onLoadTaskConcluded(long j10) {
        e0.a(this, j10);
    }

    public w(int i10) {
        this.f37557a = i10;
    }
}
