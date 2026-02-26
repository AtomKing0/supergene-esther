package s3;

import a4.o0;
import java.util.Collections;
import java.util.List;
import n3.i;

/* JADX INFO: compiled from: SsaSubtitle.java */
/* JADX INFO: loaded from: classes2.dex */
final class d implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<List<n3.b>> f33531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Long> f33532b;

    public d(List<List<n3.b>> list, List<Long> list2) {
        this.f33531a = list;
        this.f33532b = list2;
    }

    @Override // n3.i
    public List<n3.b> getCues(long j10) {
        int iG = o0.g(this.f33532b, Long.valueOf(j10), true, false);
        return iG == -1 ? Collections.emptyList() : this.f33531a.get(iG);
    }

    @Override // n3.i
    public long getEventTime(int i10) {
        a4.a.a(i10 >= 0);
        a4.a.a(i10 < this.f33532b.size());
        return this.f33532b.get(i10).longValue();
    }

    @Override // n3.i
    public int getEventTimeCount() {
        return this.f33532b.size();
    }

    @Override // n3.i
    public int getNextEventTimeIndex(long j10) {
        int iD = o0.d(this.f33532b, Long.valueOf(j10), false, false);
        if (iD < this.f33532b.size()) {
            return iD;
        }
        return -1;
    }
}
