package o3;

import java.util.Collections;
import java.util.List;
import n3.i;

/* JADX INFO: compiled from: CeaSubtitle.java */
/* JADX INFO: loaded from: classes2.dex */
final class f implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<n3.b> f32036a;

    public f(List<n3.b> list) {
        this.f32036a = list;
    }

    @Override // n3.i
    public List<n3.b> getCues(long j10) {
        return j10 >= 0 ? this.f32036a : Collections.emptyList();
    }

    @Override // n3.i
    public long getEventTime(int i10) {
        a4.a.a(i10 == 0);
        return 0L;
    }

    @Override // n3.i
    public int getEventTimeCount() {
        return 1;
    }

    @Override // n3.i
    public int getNextEventTimeIndex(long j10) {
        return j10 < 0 ? 0 : -1;
    }
}
