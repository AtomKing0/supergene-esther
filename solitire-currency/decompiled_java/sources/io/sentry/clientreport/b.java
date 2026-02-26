package io.sentry.clientreport;

import io.sentry.m;
import io.sentry.util.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AtomicClientReportStorage.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
final class b implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final r<Map<d, AtomicLong>> f27720a = new r<>(new r.a() { // from class: io.sentry.clientreport.a
        @Override // io.sentry.util.r.a
        public final Object a() {
            return b.d();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map d() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (f fVar : f.values()) {
            for (m mVar : m.values()) {
                concurrentHashMap.put(new d(fVar.getReason(), mVar.getCategory()), new AtomicLong(0L));
            }
        }
        return Collections.unmodifiableMap(concurrentHashMap);
    }

    @Override // io.sentry.clientreport.i
    public void a(d dVar, Long l10) {
        AtomicLong atomicLong = this.f27720a.a().get(dVar);
        if (atomicLong != null) {
            atomicLong.addAndGet(l10.longValue());
        }
    }

    @Override // io.sentry.clientreport.i
    public List<g> b() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<d, AtomicLong> entry : this.f27720a.a().entrySet()) {
            Long lValueOf = Long.valueOf(entry.getValue().getAndSet(0L));
            if (lValueOf.longValue() > 0) {
                arrayList.add(new g(entry.getKey().b(), entry.getKey().a(), lValueOf));
            }
        }
        return arrayList;
    }
}
