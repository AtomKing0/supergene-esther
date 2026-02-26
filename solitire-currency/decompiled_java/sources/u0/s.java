package u0;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: Jobs.java */
/* JADX INFO: loaded from: classes2.dex */
final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<r0.f, l<?>> f34409a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<r0.f, l<?>> f34410b = new HashMap();

    s() {
    }

    private Map<r0.f, l<?>> b(boolean z10) {
        return z10 ? this.f34410b : this.f34409a;
    }

    l<?> a(r0.f fVar, boolean z10) {
        return b(z10).get(fVar);
    }

    void c(r0.f fVar, l<?> lVar) {
        b(lVar.p()).put(fVar, lVar);
    }

    void d(r0.f fVar, l<?> lVar) {
        Map<r0.f, l<?>> mapB = b(lVar.p());
        if (lVar.equals(mapB.get(fVar))) {
            mapB.remove(fVar);
        }
    }
}
