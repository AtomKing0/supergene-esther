package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import com.applovin.impl.l4;
import com.applovin.impl.v1;
import com.applovin.impl.z6;
import com.ironsource.v8;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class SessionTracker {
    public static final String ACTION_APPLICATION_PAUSED = "com.applovin.application_paused";
    public static final String ACTION_APPLICATION_RESUMED = "com.applovin.application_resumed";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final j f6904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f6905b = new AtomicBoolean();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f6906c = new AtomicBoolean();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicInteger f6907d = new AtomicInteger();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicLong f6908e = new AtomicLong();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicLong f6909f = new AtomicLong();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Date f6910g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Date f6911h;

    class a extends com.applovin.impl.b {
        a() {
        }

        @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            super.onActivityResumed(activity);
            SessionTracker.this.b();
        }
    }

    class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.USER_PRESENT".equals(action)) {
                if (z6.g()) {
                    SessionTracker.this.b();
                }
            } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                SessionTracker.this.a();
            }
        }
    }

    static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6915a;

        static {
            int[] iArr = new int[e.values().length];
            f6915a = iArr;
            try {
                iArr[e.STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6915a[e.PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6915a[e.RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum e {
        STARTED(v8.h.f15786d0),
        PAUSED(v8.h.f15788e0),
        RESUMED("resumed");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6920a;

        e(String str) {
            this.f6920a = str;
        }

        public String b() {
            return this.f6920a;
        }
    }

    SessionTracker(j jVar) {
        this.f6904a = jVar;
        Application application = (Application) j.n();
        application.registerActivityLifecycleCallbacks(new a());
        application.registerComponentCallbacks(new b());
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        application.registerReceiver(new c(), intentFilter);
    }

    private void d() {
        this.f6904a.I();
        if (n.a()) {
            this.f6904a.I().a("SessionTracker", "Application Resumed");
        }
        this.f6909f.set(System.currentTimeMillis());
        boolean zBooleanValue = ((Boolean) this.f6904a.a(l4.f5642g3)).booleanValue();
        long jLongValue = ((Long) this.f6904a.a(l4.f5650h3)).longValue();
        AppLovinBroadcastManager.sendBroadcastSync(new Intent(ACTION_APPLICATION_RESUMED), null);
        if (this.f6905b.getAndSet(false)) {
            return;
        }
        long millis = TimeUnit.MINUTES.toMillis(jLongValue);
        if (this.f6911h == null || System.currentTimeMillis() - this.f6911h.getTime() >= millis) {
            this.f6904a.B().trackEvent("resumed");
            if (zBooleanValue) {
                this.f6911h = new Date();
            }
        }
        if (!zBooleanValue) {
            this.f6911h = new Date();
        }
        this.f6904a.E().c(v1.f7566p);
    }

    public long getAppEnteredBackgroundTimeMillis() {
        return this.f6908e.get();
    }

    public long getAppEnteredForegroundTimeMillis() {
        return this.f6909f.get();
    }

    public e getCurrentApplicationState() {
        return this.f6906c.get() ? e.PAUSED : this.f6908e.get() != 0 ? e.RESUMED : e.STARTED;
    }

    public long getCurrentApplicationStateDurationMillis() {
        long jM;
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i10 = d.f6915a[getCurrentApplicationState().ordinal()];
        if (i10 == 1) {
            jM = j.m();
        } else if (i10 == 2) {
            jM = this.f6908e.get();
        } else {
            if (i10 != 3) {
                return -1L;
            }
            jM = this.f6909f.get();
        }
        return jCurrentTimeMillis - jM;
    }

    public int getLastTrimMemoryLevel() {
        return this.f6907d.get();
    }

    public boolean isApplicationPaused() {
        return this.f6906c.get();
    }

    public void pauseForClick() {
        this.f6905b.set(true);
    }

    public void resumeForClick() {
        this.f6905b.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f6906c.compareAndSet(false, true)) {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f6906c.compareAndSet(true, false)) {
            d();
        }
    }

    private void c() {
        this.f6904a.I();
        if (n.a()) {
            this.f6904a.I().a("SessionTracker", "Application Paused");
        }
        this.f6908e.set(System.currentTimeMillis());
        AppLovinBroadcastManager.sendBroadcastSync(new Intent(ACTION_APPLICATION_PAUSED), null);
        if (this.f6905b.get()) {
            return;
        }
        boolean zBooleanValue = ((Boolean) this.f6904a.a(l4.f5642g3)).booleanValue();
        long millis = TimeUnit.MINUTES.toMillis(((Long) this.f6904a.a(l4.f5658i3)).longValue());
        if (this.f6910g == null || System.currentTimeMillis() - this.f6910g.getTime() >= millis) {
            this.f6904a.B().trackEvent(v8.h.f15788e0);
            if (zBooleanValue) {
                this.f6910g = new Date();
            }
        }
        if (zBooleanValue) {
            return;
        }
        this.f6910g = new Date();
    }

    class b implements ComponentCallbacks2 {
        b() {
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i10) {
            SessionTracker.this.f6907d.set(i10);
            if (i10 == 20) {
                SessionTracker.this.a();
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }
    }
}
