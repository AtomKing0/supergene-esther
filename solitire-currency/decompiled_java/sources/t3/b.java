package t3;

import a4.o0;
import java.util.Collections;
import java.util.List;
import n3.i;

/* JADX INFO: compiled from: SubripSubtitle.java */
/* JADX INFO: loaded from: classes2.dex */
final class b implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n3.b[] f34068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f34069b;

    public b(n3.b[] bVarArr, long[] jArr) {
        this.f34068a = bVarArr;
        this.f34069b = jArr;
    }

    @Override // n3.i
    public List<n3.b> getCues(long j10) {
        n3.b bVar;
        int i10 = o0.i(this.f34069b, j10, true, false);
        return (i10 == -1 || (bVar = this.f34068a[i10]) == n3.b.f31621r) ? Collections.emptyList() : Collections.singletonList(bVar);
    }

    @Override // n3.i
    public long getEventTime(int i10) {
        a4.a.a(i10 >= 0);
        a4.a.a(i10 < this.f34069b.length);
        return this.f34069b[i10];
    }

    @Override // n3.i
    public int getEventTimeCount() {
        return this.f34069b.length;
    }

    @Override // n3.i
    public int getNextEventTimeIndex(long j10) {
        int iE = o0.e(this.f34069b, j10, false, false);
        if (iE < this.f34069b.length) {
            return iE;
        }
        return -1;
    }
}
