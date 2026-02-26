package u3;

import a4.o0;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import n3.i;

/* JADX INFO: compiled from: TtmlSubtitle.java */
/* JADX INFO: loaded from: classes2.dex */
final class h implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f34586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f34587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, g> f34588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, e> f34589d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<String, String> f34590e;

    public h(d dVar, Map<String, g> map, Map<String, e> map2, Map<String, String> map3) {
        this.f34586a = dVar;
        this.f34589d = map2;
        this.f34590e = map3;
        this.f34588c = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.f34587b = dVar.j();
    }

    @Override // n3.i
    public List<n3.b> getCues(long j10) {
        return this.f34586a.h(j10, this.f34588c, this.f34589d, this.f34590e);
    }

    @Override // n3.i
    public long getEventTime(int i10) {
        return this.f34587b[i10];
    }

    @Override // n3.i
    public int getEventTimeCount() {
        return this.f34587b.length;
    }

    @Override // n3.i
    public int getNextEventTimeIndex(long j10) {
        int iE = o0.e(this.f34587b, j10, false, false);
        if (iE < this.f34587b.length) {
            return iE;
        }
        return -1;
    }
}
