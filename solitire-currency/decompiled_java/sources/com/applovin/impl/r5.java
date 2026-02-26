package com.applovin.impl;

import androidx.media3.exoplayer.ExoPlayer;
import io.sentry.protocol.Request;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class r5 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final ExecutorService f6729o = Executors.newFixedThreadPool(4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f6730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f6731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f6732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f6733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f6734e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f6735f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f6736g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f6737h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f6738i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map f6739j = new HashMap();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f6740k = new ArrayList(5);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Object f6741l = new Object();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f6742m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f6743n;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6744a;

        static {
            int[] iArr = new int[b.values().length];
            f6744a = iArr;
            try {
                iArr[b.CORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6744a[b.CACHING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6744a[b.MEDIATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6744a[b.TIMEOUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum b {
        CORE,
        CACHING,
        MEDIATION,
        TIMEOUT,
        OTHER
    }

    private class c implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6751a;

        class a implements Thread.UncaughtExceptionHandler {
            a() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                com.applovin.impl.sdk.n unused = r5.this.f6731b;
                if (com.applovin.impl.sdk.n.a()) {
                    r5.this.f6731b.a("TaskManager", "Caught unhandled exception", th);
                }
            }
        }

        c(String str) {
            this.f6751a = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "AppLovinSdk:" + this.f6751a);
            thread.setDaemon(true);
            thread.setPriority(((Integer) r5.this.f6730a.a(l4.O)).intValue());
            thread.setUncaughtExceptionHandler(new a());
            return thread;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.applovin.impl.sdk.j f6754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f6755b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.applovin.impl.sdk.n f6756c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final w4 f6757d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final b f6758e;

        public d(com.applovin.impl.sdk.j jVar, w4 w4Var, b bVar) {
            this.f6754a = jVar;
            this.f6756c = jVar.I();
            this.f6755b = w4Var.c();
            this.f6757d = w4Var;
            this.f6758e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                k0.a();
                if (!this.f6754a.x0() || this.f6757d.d()) {
                    ScheduledFuture scheduledFutureB = this.f6757d.b(Thread.currentThread(), ((Long) this.f6754a.a(l4.f5764w)).longValue());
                    this.f6757d.run();
                    if (scheduledFutureB != null) {
                        scheduledFutureB.cancel(false);
                    }
                } else {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f6756c.d(this.f6755b, "Task re-scheduled...");
                    }
                    this.f6754a.j0().a(this.f6757d, this.f6758e, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                }
                if (com.applovin.impl.sdk.n.a()) {
                    this.f6756c.d(this.f6755b, this.f6758e + " queue finished task " + this.f6757d.c());
                }
            } catch (Throwable th) {
                try {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f6756c.a(this.f6755b, "Task failed execution", th);
                    }
                    this.f6757d.a(th);
                } finally {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f6756c.d(this.f6755b, this.f6758e + " queue finished task " + this.f6757d.c());
                    }
                }
            }
        }
    }

    public r5(com.applovin.impl.sdk.j jVar) {
        this.f6730a = jVar;
        this.f6731b = jVar.I();
        this.f6743n = ((Boolean) jVar.a(l4.R)).booleanValue();
        this.f6732c = a("auxiliary_operations", ((Integer) jVar.a(l4.M)).intValue());
        this.f6733d = a("shared_thread_pool", ((Integer) jVar.a(l4.L)).intValue());
        this.f6734e = a("core", ((Integer) jVar.a(l4.S)).intValue());
        this.f6736g = a("caching", ((Integer) jVar.a(l4.T)).intValue());
        this.f6737h = a("mediation", ((Integer) jVar.a(l4.U)).intValue());
        this.f6735f = a("timeout", ((Integer) jVar.a(l4.V)).intValue());
        this.f6738i = a(Request.JsonKeys.OTHER, ((Integer) jVar.a(l4.W)).intValue());
    }

    public Executor c() {
        return this.f6743n ? this.f6734e : this.f6733d;
    }

    public boolean d() {
        return this.f6742m;
    }

    public void e() {
        synchronized (this.f6741l) {
            this.f6742m = true;
            for (d dVar : this.f6740k) {
                a(dVar.f6757d, dVar.f6758e);
            }
            this.f6740k.clear();
        }
    }

    public void f() {
        synchronized (this.f6741l) {
            this.f6742m = false;
        }
    }

    public void a(w4 w4Var, b bVar) {
        a(w4Var, bVar, 0L);
    }

    public void a(w4 w4Var, b bVar, long j10) {
        a(w4Var, bVar, j10, false);
    }

    public ScheduledFuture b(w4 w4Var, b bVar, long j10) {
        if (this.f6743n) {
            return a(new d(this.f6730a, w4Var, bVar)).schedule(w4Var, j10, TimeUnit.MILLISECONDS);
        }
        return this.f6732c.schedule(w4Var, j10, TimeUnit.MILLISECONDS);
    }

    public void a(w4 w4Var, b bVar, long j10, boolean z10) {
        if (w4Var == null) {
            throw new IllegalArgumentException("No task specified");
        }
        if (j10 >= 0) {
            d dVar = new d(this.f6730a, w4Var, bVar);
            if (!b(dVar)) {
                a(dVar, j10, z10);
                return;
            } else {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f6731b.d(w4Var.c(), "Task execution delayed until after init");
                    return;
                }
                return;
            }
        }
        throw new IllegalArgumentException("Invalid delay (millis) specified: " + j10);
    }

    public ExecutorService b() {
        return this.f6743n ? this.f6736g : f6729o;
    }

    private boolean b(d dVar) {
        if (dVar.f6757d.d()) {
            return false;
        }
        synchronized (this.f6741l) {
            if (this.f6742m) {
                return false;
            }
            this.f6740k.add(dVar);
            return true;
        }
    }

    public void a(Runnable runnable, b bVar) {
        if (this.f6743n) {
            com.applovin.impl.sdk.j jVar = this.f6730a;
            d dVar = new d(jVar, new f6(jVar, "auxiliaryOperation", runnable), bVar);
            a(dVar).submit(dVar);
            return;
        }
        this.f6732c.submit(runnable);
    }

    public ExecutorService a() {
        return this.f6743n ? this.f6738i : this.f6732c;
    }

    public void a(w4 w4Var) {
        if (w4Var != null) {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f6743n ? this.f6734e : this.f6733d;
            try {
                if (z6.h()) {
                    scheduledThreadPoolExecutor.submit(new d(this.f6730a, w4Var, b.CORE));
                    return;
                }
                ScheduledFuture scheduledFutureB = w4Var.b(Thread.currentThread(), ((Long) this.f6730a.a(l4.f5764w)).longValue());
                w4Var.run();
                if (scheduledFutureB != null) {
                    scheduledFutureB.cancel(false);
                    return;
                }
                return;
            } catch (Throwable th) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f6731b.a(w4Var.c(), "Task failed execution", th);
                }
                w4Var.a(th);
                return;
            }
        }
        throw new IllegalArgumentException("No task specified");
    }

    public void a(w4 w4Var, a3 a3Var) {
        String strB = a3Var.b();
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutorA = (ScheduledThreadPoolExecutor) this.f6739j.get(strB);
        if (scheduledThreadPoolExecutorA == null) {
            scheduledThreadPoolExecutorA = a(strB, 1);
            this.f6739j.put(strB, scheduledThreadPoolExecutorA);
        }
        scheduledThreadPoolExecutorA.submit(new d(this.f6730a, w4Var, b.MEDIATION));
    }

    private void a(final d dVar, long j10, boolean z10) {
        final ScheduledThreadPoolExecutor scheduledThreadPoolExecutorA = this.f6743n ? a(dVar) : this.f6733d;
        if (j10 <= 0) {
            scheduledThreadPoolExecutorA.submit(dVar);
        } else if (z10) {
            c0.a(j10, this.f6730a, new Runnable() { // from class: com.applovin.impl.bd
                @Override // java.lang.Runnable
                public final void run() {
                    scheduledThreadPoolExecutorA.execute(dVar);
                }
            });
        } else {
            scheduledThreadPoolExecutorA.schedule(dVar, j10, TimeUnit.MILLISECONDS);
        }
    }

    private ScheduledThreadPoolExecutor a(d dVar) {
        int i10 = a.f6744a[dVar.f6758e.ordinal()];
        if (i10 == 1) {
            return this.f6734e;
        }
        if (i10 == 2) {
            return this.f6736g;
        }
        if (i10 == 3) {
            return this.f6737h;
        }
        if (i10 != 4) {
            return this.f6738i;
        }
        return this.f6735f;
    }

    private ScheduledThreadPoolExecutor a(String str, int i10) {
        return new ScheduledThreadPoolExecutor(i10, new c(str));
    }
}
