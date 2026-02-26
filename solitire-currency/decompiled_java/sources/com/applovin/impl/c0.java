package com.applovin.impl;

import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.SessionTracker;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class c0 implements AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set f4931c = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final t6 f4932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f4933b;

    private c0(long j10, final boolean z10, com.applovin.impl.sdk.j jVar, final Runnable runnable) {
        this.f4932a = t6.a(j10, z10, jVar, new Runnable() { // from class: com.applovin.impl.p8
            @Override // java.lang.Runnable
            public final void run() {
                this.f6573a.a(z10, runnable);
            }
        });
        this.f4933b = jVar;
        f4931c.add(this);
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
    }

    public long b() {
        return this.f4932a.c();
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            this.f4932a.d();
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            this.f4932a.e();
        }
    }

    public static c0 a(long j10, com.applovin.impl.sdk.j jVar, Runnable runnable) {
        return a(j10, false, jVar, runnable);
    }

    public static c0 a(long j10, boolean z10, com.applovin.impl.sdk.j jVar, Runnable runnable) {
        return new c0(j10, z10, jVar, runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z10, Runnable runnable) {
        if (!z10) {
            a();
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void a() {
        this.f4932a.a();
        AppLovinBroadcastManager.unregisterReceiver(this);
        f4931c.remove(this);
    }
}
