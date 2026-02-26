package com.ironsource;

import com.ironsource.g2;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Timer;
import java.util.TimerTask;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public class i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g2 f12534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final xk f12535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final pk f12536c = c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Timer f12537d;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i2.this.f12535b.a();
        }
    }

    class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            i2.this.f12535b.a();
        }
    }

    public i2(g2 g2Var, @NotNull xk xkVar) {
        this.f12534a = g2Var;
        this.f12535b = xkVar;
    }

    private pk c() {
        return new pk(new a(), com.ironsource.lifecycle.b.d(), new nt());
    }

    private synchronized void j() {
        Timer timer = this.f12537d;
        if (timer != null) {
            timer.cancel();
            this.f12537d = null;
        }
    }

    protected g2 b() {
        return this.f12534a;
    }

    protected boolean d() {
        return this.f12534a.c() > 0;
    }

    public void e() {
        if (this.f12534a.e()) {
            IronLog.INTERNAL.verbose();
            b(this.f12534a.c());
        }
    }

    public void f() {
        if (this.f12534a.a() == g2.a.AUTOMATIC_LOAD_AFTER_CLOSE) {
            IronLog.INTERNAL.verbose();
            b(this.f12534a.d());
        }
    }

    public void g() {
        if (this.f12534a.e()) {
            IronLog.INTERNAL.verbose();
            b(0L);
        }
    }

    public void h() {
        if (this.f12534a.a() != g2.a.AUTOMATIC_LOAD_WHILE_SHOW || this.f12534a.d() < 0) {
            return;
        }
        IronLog.INTERNAL.verbose();
        b(this.f12534a.d());
    }

    protected void i() {
        pk pkVar = this.f12536c;
        if (pkVar != null) {
            pkVar.b();
        }
    }

    public void k() {
        if (this.f12534a.a() != g2.a.MANUAL_WITH_AUTOMATIC_RELOAD || this.f12534a.b() <= 0) {
            return;
        }
        IronLog.INTERNAL.verbose();
        a(this.f12534a.b());
    }

    private synchronized void b(long j10) {
        j();
        Timer timer = new Timer();
        this.f12537d = timer;
        timer.schedule(new b(), j10);
    }

    public void a() {
        if (this.f12534a.a() == g2.a.MANUAL_WITH_AUTOMATIC_RELOAD) {
            IronLog.INTERNAL.verbose();
            i();
        }
    }

    protected void a(long j10) {
        pk pkVar = this.f12536c;
        if (pkVar != null) {
            pkVar.a(j10);
        }
    }
}
