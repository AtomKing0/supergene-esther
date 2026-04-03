package com.applovin.impl;

import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.SessionTracker;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes2.dex */
public class t7 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Set f7463f = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f7464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f7465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Runnable f7466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f7467d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Timer f7468e;

    class a extends TimerTask {

        /* JADX INFO: renamed from: com.applovin.impl.t7$a$a, reason: collision with other inner class name */
        class C0177a implements AppLovinBroadcastManager.Receiver {
            C0177a() {
            }

            @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
            public void onReceive(Intent intent, Map map) {
                AppLovinBroadcastManager.unregisterReceiver(this);
                t7.this.c();
            }
        }

        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (!t7.this.f7465b.f0().isApplicationPaused() || t7.this.f7464a) {
                t7.this.c();
            } else {
                AppLovinBroadcastManager.registerReceiver(new C0177a(), new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
            }
        }
    }

    private t7(long j10, boolean z10, com.applovin.impl.sdk.j jVar, Runnable runnable) {
        Timer timer = new Timer();
        this.f7468e = timer;
        if (j10 < 0) {
            throw new IllegalArgumentException("Cannot create wall clock timer. Invalid timer length: " + j10);
        }
        if (jVar == null) {
            throw new IllegalArgumentException("Cannot create wall clock timer. Sdk is null");
        }
        if (runnable == null) {
            throw new IllegalArgumentException("Cannot create wall clock timer. Runnable is null.");
        }
        this.f7464a = z10;
        this.f7465b = jVar;
        this.f7466c = runnable;
        f7463f.add(this);
        timer.schedule(b(), j10);
    }

    public static t7 a(long j10, boolean z10, com.applovin.impl.sdk.j jVar, Runnable runnable) {
        return new t7(j10, z10, jVar, runnable);
    }

    private TimerTask b() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Runnable runnable = this.f7466c;
        if (runnable != null) {
            runnable.run();
            a();
        }
    }

    public void a() {
        synchronized (this.f7467d) {
            this.f7468e.cancel();
            this.f7466c = null;
            f7463f.remove(this);
        }
    }
}
