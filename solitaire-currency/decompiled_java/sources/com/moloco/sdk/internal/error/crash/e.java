package com.moloco.sdk.internal.error.crash;

import com.moloco.sdk.internal.MolocoLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final List<com.moloco.sdk.internal.error.crash.filters.a> f17635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.error.api.a f17636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final String f17637c;

    /* JADX WARN: Multi-variable type inference failed */
    public e(@NotNull List<? extends com.moloco.sdk.internal.error.crash.filters.a> exceptionFilters, @NotNull com.moloco.sdk.internal.error.api.a errorReporter) {
        t.i(exceptionFilters, "exceptionFilters");
        t.i(errorReporter, "errorReporter");
        this.f17635a = exceptionFilters;
        this.f17636b = errorReporter;
        this.f17637c = "CrashHandlerService";
    }

    @Override // com.moloco.sdk.internal.error.crash.d
    public void a(@NotNull Throwable crash) {
        t.i(crash, "crash");
        if (!b(crash)) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, this.f17637c, "App Crashed", null, false, 12, null);
        } else {
            com.moloco.sdk.acm.a.f17293a.t(new com.moloco.sdk.acm.c(com.moloco.sdk.internal.client_metrics_data.a.CrashDetected.c()));
            this.f17636b.a(crash);
        }
    }

    public final boolean b(Throwable th) {
        Iterator<com.moloco.sdk.internal.error.crash.filters.a> it = this.f17635a.iterator();
        while (it.hasNext()) {
            if (it.next().a(th)) {
                return true;
            }
        }
        return false;
    }
}
