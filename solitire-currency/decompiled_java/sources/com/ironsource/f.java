package com.ironsource;

import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes4.dex */
public abstract class f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f12006a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Timer f12007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected long f12008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected T f12009d;

    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            f.this.b();
        }
    }

    public f() {
    }

    protected void a(T t10) {
        if (a() || t10 == null) {
            return;
        }
        this.f12009d = t10;
        c();
        synchronized (this.f12006a) {
            Timer timer = new Timer();
            this.f12007b = timer;
            timer.schedule(new a(), this.f12008c);
        }
    }

    protected abstract void b();

    protected void c() {
        synchronized (this.f12006a) {
            Timer timer = this.f12007b;
            if (timer != null) {
                timer.cancel();
                this.f12007b = null;
            }
        }
    }

    public void d() {
        this.f12009d = null;
    }

    public f(long j10) {
        this.f12008c = j10;
    }

    protected boolean a() {
        return this.f12008c <= 0;
    }
}
