package com.applovin.impl.sdk;

import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.m1;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class a implements AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f6921e = TimeUnit.SECONDS.toMillis(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f6922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f6923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashSet f6924c = new HashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f6925d = new Object();

    /* JADX INFO: renamed from: com.applovin.impl.sdk.a$a, reason: collision with other inner class name */
    public interface InterfaceC0171a {
        void onAdExpired(m1 m1Var);
    }

    public a(j jVar) {
        this.f6922a = jVar;
        this.f6923b = jVar.I();
    }

    private b b(m1 m1Var) {
        synchronized (this.f6925d) {
            if (m1Var == null) {
                return null;
            }
            for (b bVar : this.f6924c) {
                if (m1Var == bVar.b()) {
                    return bVar;
                }
            }
            return null;
        }
    }

    public boolean a(m1 m1Var, InterfaceC0171a interfaceC0171a) {
        synchronized (this.f6925d) {
            if (b(m1Var) != null) {
                if (n.a()) {
                    this.f6923b.a("AdExpirationManager", "Ad expiration already scheduled for ad: " + m1Var);
                }
                return true;
            }
            if (m1Var.getTimeToLiveMillis() <= f6921e) {
                if (n.a()) {
                    this.f6923b.a("AdExpirationManager", "Ad has already expired: " + m1Var);
                }
                m1Var.setExpired();
                return false;
            }
            if (n.a()) {
                this.f6923b.a("AdExpirationManager", "Scheduling ad expiration " + TimeUnit.MILLISECONDS.toSeconds(m1Var.getTimeToLiveMillis()) + " seconds from now for " + m1Var + "...");
            }
            if (this.f6924c.isEmpty()) {
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
            }
            this.f6924c.add(b.a(m1Var, interfaceC0171a, this.f6922a));
            return true;
        }
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            a();
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            b();
        }
    }

    private void b() {
        HashSet<b> hashSet = new HashSet();
        synchronized (this.f6925d) {
            for (b bVar : this.f6924c) {
                m1 m1VarB = bVar.b();
                if (m1VarB == null) {
                    hashSet.add(bVar);
                } else {
                    long timeToLiveMillis = m1VarB.getTimeToLiveMillis();
                    if (timeToLiveMillis <= 0) {
                        if (n.a()) {
                            this.f6923b.a("AdExpirationManager", "Ad expired while app was paused. Preparing to notify listener for ad: " + m1VarB);
                        }
                        hashSet.add(bVar);
                    } else {
                        if (n.a()) {
                            this.f6923b.a("AdExpirationManager", "Rescheduling expiration with remaining " + TimeUnit.MILLISECONDS.toSeconds(timeToLiveMillis) + " seconds for ad: " + m1VarB);
                        }
                        bVar.a(timeToLiveMillis);
                    }
                }
            }
        }
        for (b bVar2 : hashSet) {
            a(bVar2);
            bVar2.d();
        }
    }

    public void a(m1 m1Var) {
        synchronized (this.f6925d) {
            b bVarB = b(m1Var);
            if (bVarB != null) {
                if (n.a()) {
                    this.f6923b.a("AdExpirationManager", "Cancelling expiration timer for ad: " + m1Var);
                }
                bVarB.a();
                a(bVarB);
            }
        }
    }

    public void a(b bVar) {
        synchronized (this.f6925d) {
            this.f6924c.remove(bVar);
            if (this.f6924c.isEmpty()) {
                AppLovinBroadcastManager.unregisterReceiver(this);
            }
        }
    }

    private void a() {
        synchronized (this.f6925d) {
            Iterator it = this.f6924c.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a();
            }
        }
    }
}
