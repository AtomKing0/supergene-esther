package q3;

import java.util.List;
import n3.i;

/* JADX INFO: compiled from: PgsSubtitle.java */
/* JADX INFO: loaded from: classes2.dex */
final class b implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<n3.b> f33163a;

    public b(List<n3.b> list) {
        this.f33163a = list;
    }

    @Override // n3.i
    public List<n3.b> getCues(long j10) {
        return this.f33163a;
    }

    @Override // n3.i
    public long getEventTime(int i10) {
        return 0L;
    }

    @Override // n3.i
    public int getEventTimeCount() {
        return 1;
    }

    @Override // n3.i
    public int getNextEventTimeIndex(long j10) {
        return -1;
    }
}
