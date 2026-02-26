package com.ironsource;

import android.util.Log;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes4.dex */
public class pk {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f14349g = "pk";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.ironsource.lifecycle.b f14350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Runnable f14351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final nt f14352c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Timer f14354e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f14353d = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ij f14355f = new a();

    class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            pk.this.f14350a.b(pk.this.f14355f);
            pk.this.f14352c.b();
            pk.this.f14351b.run();
        }
    }

    public pk(Runnable runnable, com.ironsource.lifecycle.b bVar, nt ntVar) {
        this.f14351b = runnable;
        this.f14350a = bVar;
        this.f14352c = ntVar;
    }

    public void b() {
        c();
        this.f14350a.b(this.f14355f);
        this.f14352c.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j10) {
        synchronized (this.f14353d) {
            c();
            Timer timer = new Timer();
            this.f14354e = timer;
            timer.schedule(new b(), j10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        synchronized (this.f14353d) {
            Timer timer = this.f14354e;
            if (timer != null) {
                timer.cancel();
                this.f14354e = null;
            }
        }
    }

    public void a() {
        a(0L);
    }

    public void a(long j10) {
        if (j10 < 0) {
            Log.d(f14349g, "cannot start timer with delay < 0");
            return;
        }
        this.f14350a.a(this.f14355f);
        this.f14352c.a(j10);
        if (this.f14350a.e()) {
            this.f14352c.c(System.currentTimeMillis());
        } else {
            b(j10);
        }
    }

    class a implements ij {
        a() {
        }

        @Override // com.ironsource.ij
        public void b() {
            pk.this.f14352c.c(System.currentTimeMillis());
            pk.this.c();
        }

        @Override // com.ironsource.ij
        public void c() {
            pk.this.f14352c.b(System.currentTimeMillis());
            pk pkVar = pk.this;
            pkVar.b(pkVar.f14352c.a());
        }

        @Override // com.ironsource.ij
        public void a() {
        }

        @Override // com.ironsource.ij
        public void d() {
        }
    }
}
