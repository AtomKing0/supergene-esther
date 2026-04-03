package com.applovin.impl;

import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes2.dex */
public class t6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f7453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Timer f7454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f7455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f7456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f7457e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f7458f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Runnable f7459g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f7460h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f7461i = new Object();

    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                t6.this.f7459g.run();
                synchronized (t6.this.f7461i) {
                    if (t6.this.f7458f) {
                        t6.this.f7455c = System.currentTimeMillis();
                        t6 t6Var = t6.this;
                        t6Var.f7456d = t6Var.f7457e;
                    } else {
                        t6.this.f7454b = null;
                    }
                }
            } catch (Throwable th) {
                try {
                    if (t6.this.f7453a != null) {
                        t6.this.f7453a.I();
                        if (com.applovin.impl.sdk.n.a()) {
                            t6.this.f7453a.I().a("Timer", "Encountered error while executing timed task", th);
                        }
                        t6.this.f7453a.A().a("Timer", "executingTimedTask", th);
                    }
                    synchronized (t6.this.f7461i) {
                        if (t6.this.f7458f) {
                            t6.this.f7455c = System.currentTimeMillis();
                            t6 t6Var2 = t6.this;
                            t6Var2.f7456d = t6Var2.f7457e;
                        } else {
                            t6.this.f7454b = null;
                        }
                    }
                } catch (Throwable th2) {
                    synchronized (t6.this.f7461i) {
                        if (t6.this.f7458f) {
                            t6.this.f7455c = System.currentTimeMillis();
                            t6 t6Var3 = t6.this;
                            t6Var3.f7456d = t6Var3.f7457e;
                        } else {
                            t6.this.f7454b = null;
                        }
                        throw th2;
                    }
                }
            }
        }
    }

    private t6(com.applovin.impl.sdk.j jVar, Runnable runnable) {
        this.f7453a = jVar;
        this.f7459g = runnable;
    }

    public long c() {
        if (this.f7454b == null) {
            return this.f7456d - this.f7460h;
        }
        return this.f7456d - (System.currentTimeMillis() - this.f7455c);
    }

    public void d() {
        synchronized (this.f7461i) {
            Timer timer = this.f7454b;
            if (timer != null) {
                try {
                    timer.cancel();
                    this.f7460h = Math.max(1L, System.currentTimeMillis() - this.f7455c);
                } catch (Throwable th) {
                    try {
                        com.applovin.impl.sdk.j jVar = this.f7453a;
                        if (jVar != null) {
                            jVar.I();
                            if (com.applovin.impl.sdk.n.a()) {
                                this.f7453a.I();
                                if (com.applovin.impl.sdk.n.a()) {
                                    this.f7453a.I().a("Timer", "Encountered error while pausing timer", th);
                                }
                            }
                        }
                        this.f7454b = null;
                    } finally {
                        this.f7454b = null;
                    }
                }
            }
        }
    }

    public void e() {
        synchronized (this.f7461i) {
            long j10 = this.f7460h;
            if (j10 > 0) {
                try {
                    long j11 = this.f7456d - j10;
                    this.f7456d = j11;
                    if (j11 < 0) {
                        this.f7456d = 0L;
                    }
                    this.f7454b = new Timer();
                    a(b(), this.f7456d, this.f7458f, this.f7457e);
                    this.f7455c = System.currentTimeMillis();
                } catch (Throwable th) {
                    try {
                        com.applovin.impl.sdk.j jVar = this.f7453a;
                        if (jVar != null) {
                            jVar.I();
                            if (com.applovin.impl.sdk.n.a()) {
                                this.f7453a.I();
                                if (com.applovin.impl.sdk.n.a()) {
                                    this.f7453a.I().a("Timer", "Encountered error while resuming timer", th);
                                }
                            }
                        }
                        this.f7460h = 0L;
                    } finally {
                        this.f7460h = 0L;
                    }
                }
            }
        }
    }

    private TimerTask b() {
        return new a();
    }

    public static t6 a(long j10, com.applovin.impl.sdk.j jVar, Runnable runnable) {
        return a(j10, false, jVar, runnable);
    }

    public static t6 a(long j10, boolean z10, com.applovin.impl.sdk.j jVar, Runnable runnable) {
        if (j10 < 0) {
            throw new IllegalArgumentException("Cannot create a scheduled timer. Invalid fire time passed in: " + j10 + ".");
        }
        if (runnable != null) {
            t6 t6Var = new t6(jVar, runnable);
            t6Var.f7455c = System.currentTimeMillis();
            t6Var.f7456d = j10;
            t6Var.f7458f = z10;
            t6Var.f7457e = j10;
            try {
                t6Var.f7454b = new Timer();
                t6Var.a(t6Var.b(), j10, z10, t6Var.f7457e);
            } catch (OutOfMemoryError e10) {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().a("Timer", "Failed to create timer due to OOM error", e10);
                }
            }
            return t6Var;
        }
        throw new IllegalArgumentException("Cannot create a scheduled timer. Runnable is null.");
    }

    public void a() {
        synchronized (this.f7461i) {
            Timer timer = this.f7454b;
            if (timer != null) {
                try {
                    timer.cancel();
                    this.f7454b = null;
                } catch (Throwable th) {
                    try {
                        com.applovin.impl.sdk.j jVar = this.f7453a;
                        if (jVar != null) {
                            jVar.I();
                            if (com.applovin.impl.sdk.n.a()) {
                                this.f7453a.I();
                                if (com.applovin.impl.sdk.n.a()) {
                                    this.f7453a.I().a("Timer", "Encountered error while cancelling timer", th);
                                }
                            }
                        }
                        this.f7454b = null;
                    } catch (Throwable th2) {
                        this.f7454b = null;
                        this.f7460h = 0L;
                        throw th2;
                    }
                }
                this.f7460h = 0L;
            }
        }
    }

    private void a(TimerTask timerTask, long j10, boolean z10, long j11) {
        if (z10) {
            this.f7454b.schedule(timerTask, j10, j11);
        } else {
            this.f7454b.schedule(timerTask, j10);
        }
    }
}
