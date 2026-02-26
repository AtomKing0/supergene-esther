package p3;

import java.util.List;
import n3.i;

/* JADX INFO: compiled from: DvbSubtitle.java */
/* JADX INFO: loaded from: classes2.dex */
final class c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<n3.b> f32612a;

    public c(List<n3.b> list) {
        this.f32612a = list;
    }

    @Override // n3.i
    public List<n3.b> getCues(long j10) {
        return this.f32612a;
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
