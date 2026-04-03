package com.ironsource;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes4.dex */
public class qk implements ij {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Timer f14532b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f14535e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Runnable f14536f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f14531a = "INTERNAL";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14533c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Long f14534d = null;

    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            qk.this.f14536f.run();
        }
    }

    public qk(long j10, Runnable runnable, boolean z10) {
        this.f14535e = j10;
        this.f14536f = runnable;
        if (z10) {
            g();
        }
    }

    private synchronized void f() {
        Timer timer = this.f14532b;
        if (timer != null) {
            timer.cancel();
            this.f14532b = null;
        }
    }

    private synchronized void h() {
        if (this.f14532b == null) {
            Timer timer = new Timer();
            this.f14532b = timer;
            timer.schedule(new a(), this.f14535e);
            Calendar.getInstance().setTimeInMillis(this.f14534d.longValue());
        }
    }

    @Override // com.ironsource.ij
    public void b() {
        if (this.f14532b != null) {
            f();
        }
    }

    @Override // com.ironsource.ij
    public void c() {
        Long l10;
        if (this.f14532b == null && (l10 = this.f14534d) != null) {
            long jLongValue = l10.longValue() - System.currentTimeMillis();
            this.f14535e = jLongValue;
            if (jLongValue > 0) {
                h();
            } else {
                e();
                this.f14536f.run();
            }
        }
    }

    public void e() {
        f();
        this.f14533c = false;
        this.f14534d = null;
        com.ironsource.lifecycle.b.d().b(this);
    }

    public void g() {
        if (this.f14533c) {
            return;
        }
        this.f14533c = true;
        com.ironsource.lifecycle.b.d().a(this);
        this.f14534d = Long.valueOf(System.currentTimeMillis() + this.f14535e);
        if (com.ironsource.lifecycle.b.d().e()) {
            return;
        }
        h();
    }

    @Override // com.ironsource.ij
    public void a() {
    }

    @Override // com.ironsource.ij
    public void d() {
    }
}
