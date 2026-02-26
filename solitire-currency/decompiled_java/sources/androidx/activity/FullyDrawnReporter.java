package androidx.activity;

import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import io.sentry.protocol.SentryStackFrame;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: FullyDrawnReporter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FullyDrawnReporter {

    @NotNull
    private final Executor executor;

    @NotNull
    private final Object lock;

    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    @NotNull
    private final List<h9.a<k0>> onReportCallbacks;

    @NotNull
    private final h9.a<k0> reportFullyDrawn;

    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private boolean reportPosted;

    @NotNull
    private final Runnable reportRunnable;

    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private boolean reportedFullyDrawn;

    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private int reporterCount;

    public FullyDrawnReporter(@NotNull Executor executor, @NotNull h9.a<k0> reportFullyDrawn) {
        t.i(executor, "executor");
        t.i(reportFullyDrawn, "reportFullyDrawn");
        this.executor = executor;
        this.reportFullyDrawn = reportFullyDrawn;
        this.lock = new Object();
        this.onReportCallbacks = new ArrayList();
        this.reportRunnable = new Runnable() { // from class: androidx.activity.l
            @Override // java.lang.Runnable
            public final void run() {
                FullyDrawnReporter.reportRunnable$lambda$2(this.f701a);
            }
        };
    }

    private final void postWhenReportersAreDone() {
        if (this.reportPosted || this.reporterCount != 0) {
            return;
        }
        this.reportPosted = true;
        this.executor.execute(this.reportRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportRunnable$lambda$2(FullyDrawnReporter this$0) {
        t.i(this$0, "this$0");
        synchronized (this$0.lock) {
            this$0.reportPosted = false;
            if (this$0.reporterCount == 0 && !this$0.reportedFullyDrawn) {
                this$0.reportFullyDrawn.invoke();
                this$0.fullyDrawnReported();
            }
            k0 k0Var = k0.f35197a;
        }
    }

    public final void addOnReportDrawnListener(@NotNull h9.a<k0> callback) {
        boolean z10;
        t.i(callback, "callback");
        synchronized (this.lock) {
            if (this.reportedFullyDrawn) {
                z10 = true;
            } else {
                this.onReportCallbacks.add(callback);
                z10 = false;
            }
        }
        if (z10) {
            callback.invoke();
        }
    }

    public final void addReporter() {
        synchronized (this.lock) {
            if (!this.reportedFullyDrawn) {
                this.reporterCount++;
            }
            k0 k0Var = k0.f35197a;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void fullyDrawnReported() {
        synchronized (this.lock) {
            this.reportedFullyDrawn = true;
            Iterator<T> it = this.onReportCallbacks.iterator();
            while (it.hasNext()) {
                ((h9.a) it.next()).invoke();
            }
            this.onReportCallbacks.clear();
            k0 k0Var = k0.f35197a;
        }
    }

    public final boolean isFullyDrawnReported() {
        boolean z10;
        synchronized (this.lock) {
            z10 = this.reportedFullyDrawn;
        }
        return z10;
    }

    public final void removeOnReportDrawnListener(@NotNull h9.a<k0> callback) {
        t.i(callback, "callback");
        synchronized (this.lock) {
            this.onReportCallbacks.remove(callback);
            k0 k0Var = k0.f35197a;
        }
    }

    public final void removeReporter() {
        int i10;
        synchronized (this.lock) {
            if (!this.reportedFullyDrawn && (i10 = this.reporterCount) > 0) {
                this.reporterCount = i10 - 1;
                postWhenReportersAreDone();
            }
            k0 k0Var = k0.f35197a;
        }
    }
}
