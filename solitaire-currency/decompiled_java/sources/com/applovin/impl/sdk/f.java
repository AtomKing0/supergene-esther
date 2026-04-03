package com.applovin.impl.sdk;

import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.g3;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.t6;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class f implements AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private t6 f7030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f7031b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f7032c = new AtomicBoolean();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7033d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final j f7034e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final WeakReference f7035f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f7036g;

    public interface a {
        void onAdRefresh();
    }

    public f(j jVar, a aVar) {
        this.f7035f = new WeakReference(aVar);
        this.f7034e = jVar;
    }

    private void e() {
        if (((Boolean) this.f7034e.a(g3.L6)).booleanValue()) {
            k();
        }
    }

    private void f() {
        if (((Boolean) this.f7034e.a(g3.L6)).booleanValue()) {
            synchronized (this.f7031b) {
                if (this.f7033d) {
                    this.f7034e.I();
                    if (n.a()) {
                        this.f7034e.I().a("AdRefreshManager", "Fullscreen ad dismissed but banner ad refresh paused by publisher. Waiting for publisher to resume banner ad refresh.");
                    }
                } else if (this.f7034e.f0().isApplicationPaused()) {
                    this.f7034e.I();
                    if (n.a()) {
                        this.f7034e.I().a("AdRefreshManager", "Waiting for the application to enter foreground to resume the timer.");
                    }
                } else {
                    t6 t6Var = this.f7030a;
                    if (t6Var != null) {
                        t6Var.e();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        l();
        a aVar = (a) this.f7035f.get();
        if (aVar != null) {
            aVar.onAdRefresh();
        }
    }

    private void k() {
        synchronized (this.f7031b) {
            t6 t6Var = this.f7030a;
            if (t6Var != null) {
                t6Var.d();
            } else {
                this.f7034e.I();
                if (n.a()) {
                    this.f7034e.I().a("AdRefreshManager", "An ad load is in progress. Will pause refresh once the ad finishes loading.");
                }
                this.f7032c.set(true);
            }
        }
    }

    private void l() {
        synchronized (this.f7031b) {
            this.f7030a = null;
            if (!((Boolean) this.f7034e.a(g3.M6)).booleanValue()) {
                AppLovinBroadcastManager.unregisterReceiver(this);
            }
        }
    }

    private void n() {
        synchronized (this.f7031b) {
            t6 t6Var = this.f7030a;
            if (t6Var != null) {
                t6Var.e();
            } else {
                this.f7032c.set(false);
            }
        }
    }

    public long b() {
        long jC;
        synchronized (this.f7031b) {
            t6 t6Var = this.f7030a;
            jC = t6Var != null ? t6Var.c() : -1L;
        }
        return jC;
    }

    public void c() {
        if (((Boolean) this.f7034e.a(g3.K6)).booleanValue()) {
            k();
        }
    }

    public void d() {
        boolean z10;
        a aVar;
        if (((Boolean) this.f7034e.a(g3.K6)).booleanValue()) {
            synchronized (this.f7031b) {
                if (this.f7033d) {
                    this.f7034e.I();
                    if (n.a()) {
                        this.f7034e.I().a("AdRefreshManager", "Application resumed but banner ad refresh paused by publisher. Waiting for publisher to resume banner ad refresh.");
                    }
                    return;
                }
                if (this.f7034e.D().c()) {
                    this.f7034e.I();
                    if (n.a()) {
                        this.f7034e.I().a("AdRefreshManager", "Waiting for the full screen ad to be dismissed to resume the timer.");
                    }
                    return;
                }
                if (this.f7030a != null) {
                    long jB = this.f7036g - b();
                    long jLongValue = ((Long) this.f7034e.a(g3.J6)).longValue();
                    if (jLongValue < 0 || jB <= jLongValue) {
                        this.f7030a.e();
                        z10 = false;
                    } else {
                        a();
                        z10 = true;
                    }
                } else {
                    z10 = false;
                }
                if (!z10 || (aVar = (a) this.f7035f.get()) == null) {
                    return;
                }
                aVar.onAdRefresh();
            }
        }
    }

    public boolean g() {
        return this.f7033d;
    }

    public boolean h() {
        boolean z10;
        synchronized (this.f7031b) {
            z10 = this.f7030a != null;
        }
        return z10;
    }

    public void j() {
        synchronized (this.f7031b) {
            k();
            this.f7033d = true;
        }
    }

    public void m() {
        synchronized (this.f7031b) {
            n();
            this.f7033d = false;
        }
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            c();
            return;
        }
        if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            d();
        } else if ("com.applovin.fullscreen_ad_displayed".equals(action)) {
            e();
        } else if ("com.applovin.fullscreen_ad_hidden".equals(action)) {
            f();
        }
    }

    public void a(long j10) {
        synchronized (this.f7031b) {
            a();
            this.f7036g = j10;
            this.f7030a = t6.a(j10, this.f7034e, new Runnable() { // from class: com.applovin.impl.sdk.h0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7077a.i();
                }
            });
            if (!((Boolean) this.f7034e.a(g3.M6)).booleanValue()) {
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.fullscreen_ad_displayed"));
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.fullscreen_ad_hidden"));
            }
            if (((Boolean) this.f7034e.a(g3.L6)).booleanValue() && (this.f7034e.D().c() || this.f7034e.f0().isApplicationPaused())) {
                this.f7030a.d();
            }
            if (this.f7032c.compareAndSet(true, false) && ((Boolean) this.f7034e.a(g3.N6)).booleanValue()) {
                this.f7034e.I();
                if (n.a()) {
                    this.f7034e.I().a("AdRefreshManager", "Pausing refresh for a previous request.");
                }
                this.f7030a.d();
            }
        }
    }

    public void a() {
        synchronized (this.f7031b) {
            t6 t6Var = this.f7030a;
            if (t6Var != null) {
                t6Var.a();
                l();
            }
        }
    }
}
