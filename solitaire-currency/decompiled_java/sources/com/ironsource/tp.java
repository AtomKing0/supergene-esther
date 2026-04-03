package com.ironsource;

import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes4.dex */
public class tp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h5 f15454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private up f15455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Timer f15456c = null;

    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            tp.this.f15455b.a();
        }
    }

    class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            tp.this.f15455b.a();
        }
    }

    public tp(h5 h5Var, up upVar) {
        this.f15454a = h5Var;
        this.f15455b = upVar;
    }

    private void d() {
        Timer timer = this.f15456c;
        if (timer != null) {
            timer.cancel();
            this.f15456c = null;
        }
    }

    public void b() {
        synchronized (this) {
            d();
        }
        this.f15455b.a();
    }

    public synchronized void c() {
        d();
        Timer timer = new Timer();
        this.f15456c = timer;
        timer.schedule(new a(), this.f15454a.j());
    }

    public synchronized void a() {
        d();
        Timer timer = new Timer();
        this.f15456c = timer;
        timer.schedule(new b(), this.f15454a.b());
    }
}
