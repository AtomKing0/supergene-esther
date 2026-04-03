package io.sentry.android.core;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import io.sentry.SentryLevel;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.TestOnly;

/* JADX INFO: compiled from: ANRWatchDog.java */
/* JADX INFO: loaded from: classes5.dex */
final class c extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f27126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f27127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final u1 f27128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final io.sentry.transport.p f27129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f27130e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f27131f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final io.sentry.w0 f27132g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile long f27133h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f27134i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private final Context f27135j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Runnable f27136k;

    /* JADX INFO: compiled from: ANRWatchDog.java */
    public interface a {
        void a(@NotNull ApplicationNotResponding applicationNotResponding);
    }

    c(long j10, boolean z10, @NotNull a aVar, @NotNull io.sentry.w0 w0Var, @NotNull Context context) {
        this(new io.sentry.transport.p() { // from class: io.sentry.android.core.a
            @Override // io.sentry.transport.p
            public final long a() {
                return SystemClock.uptimeMillis();
            }
        }, j10, 500L, z10, aVar, w0Var, new u1(), context);
    }

    private boolean c() {
        List<ActivityManager.ProcessErrorStateInfo> processesInErrorState;
        ActivityManager activityManager = (ActivityManager) this.f27135j.getSystemService("activity");
        if (activityManager == null) {
            return true;
        }
        try {
            processesInErrorState = activityManager.getProcessesInErrorState();
        } catch (Throwable th) {
            this.f27132g.b(SentryLevel.ERROR, "Error getting ActivityManager#getProcessesInErrorState.", th);
            processesInErrorState = null;
        }
        if (processesInErrorState == null) {
            return false;
        }
        Iterator<ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
        while (it.hasNext()) {
            if (it.next().condition == 2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(io.sentry.transport.p pVar) {
        this.f27133h = pVar.a();
        this.f27134i.set(false);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f27136k.run();
        while (!isInterrupted()) {
            this.f27128c.b(this.f27136k);
            try {
                Thread.sleep(this.f27130e);
                if (this.f27129d.a() - this.f27133h > this.f27131f) {
                    if (!this.f27126a && (Debug.isDebuggerConnected() || Debug.waitingForDebugger())) {
                        this.f27132g.c(SentryLevel.DEBUG, "An ANR was detected but ignored because the debugger is connected.", new Object[0]);
                        this.f27134i.set(true);
                    } else if (c() && this.f27134i.compareAndSet(false, true)) {
                        this.f27127b.a(new ApplicationNotResponding("Application Not Responding for at least " + this.f27131f + " ms.", this.f27128c.a()));
                    }
                }
            } catch (InterruptedException e10) {
                try {
                    Thread.currentThread().interrupt();
                    this.f27132g.c(SentryLevel.WARNING, "Interrupted: %s", e10.getMessage());
                    return;
                } catch (SecurityException unused) {
                    this.f27132g.c(SentryLevel.WARNING, "Failed to interrupt due to SecurityException: %s", e10.getMessage());
                    return;
                }
            }
        }
    }

    @TestOnly
    c(@NotNull final io.sentry.transport.p pVar, long j10, long j11, boolean z10, @NotNull a aVar, @NotNull io.sentry.w0 w0Var, @NotNull u1 u1Var, @NotNull Context context) {
        super("|ANR-WatchDog|");
        this.f27133h = 0L;
        this.f27134i = new AtomicBoolean(false);
        this.f27129d = pVar;
        this.f27131f = j10;
        this.f27130e = j11;
        this.f27126a = z10;
        this.f27127b = aVar;
        this.f27132g = w0Var;
        this.f27128c = u1Var;
        this.f27135j = context;
        this.f27136k = new Runnable() { // from class: io.sentry.android.core.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f27121a.e(pVar);
            }
        };
        if (j10 < this.f27130e * 2) {
            throw new IllegalArgumentException(String.format("ANRWatchDog: timeoutIntervalMillis has to be at least %d ms", Long.valueOf(this.f27130e * 2)));
        }
    }
}
