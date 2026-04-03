package io.sentry;

import io.sentry.protocol.SentryTransaction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DuplicateEventDetectionEventProcessor.java */
/* JADX INFO: loaded from: classes5.dex */
public final class z implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Map<Throwable, Object> f28520a = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final SentryOptions f28521b;

    public z(@NotNull SentryOptions sentryOptions) {
        this.f28521b = (SentryOptions) io.sentry.util.w.c(sentryOptions, "options are required");
    }

    @NotNull
    private static List<Throwable> b(@NotNull Throwable th) {
        ArrayList arrayList = new ArrayList();
        while (th.getCause() != null) {
            arrayList.add(th.getCause());
            th = th.getCause();
        }
        return arrayList;
    }

    private static <T> boolean d(@NotNull Map<T, Object> map, @NotNull List<T> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (map.containsKey(it.next())) {
                return true;
            }
        }
        return false;
    }

    @Override // io.sentry.g0
    @Nullable
    public r6 a(@NotNull r6 r6Var, @NotNull l0 l0Var) {
        if (this.f28521b.isEnableDeduplication()) {
            Throwable throwable = r6Var.getThrowable();
            if (throwable != null) {
                if (this.f28520a.containsKey(throwable) || d(this.f28520a, b(throwable))) {
                    this.f28521b.getLogger().c(SentryLevel.DEBUG, "Duplicate Exception detected. Event %s will be discarded.", r6Var.getEventId());
                    return null;
                }
                this.f28520a.put(throwable, null);
            }
        } else {
            this.f28521b.getLogger().c(SentryLevel.DEBUG, "Event deduplication is disabled.", new Object[0]);
        }
        return r6Var;
    }

    @Override // io.sentry.g0
    public /* synthetic */ SentryTransaction c(SentryTransaction sentryTransaction, l0 l0Var) {
        return f0.a(this, sentryTransaction, l0Var);
    }

    @Override // io.sentry.g0
    @Nullable
    public Long getOrder() {
        return 1000L;
    }
}
