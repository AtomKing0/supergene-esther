package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Bundle;
import com.applovin.impl.t2;
import com.applovin.impl.z6;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.applovin.impl.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.c f5955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f5956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f5957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private InterfaceC0164a f5958d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private t2 f5959e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f5960f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f5961g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f5962h;

    /* JADX INFO: renamed from: com.applovin.impl.mediation.a$a, reason: collision with other inner class name */
    public interface InterfaceC0164a {
        void a(t2 t2Var);
    }

    a(com.applovin.impl.sdk.j jVar) {
        this.f5956b = jVar.I();
        this.f5955a = jVar.e();
        this.f5957c = z6.a(com.applovin.impl.sdk.j.n(), "AdActivityObserver", jVar);
    }

    public void a(boolean z10) {
        this.f5960f = z10;
    }

    @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity.getClass().getName().equals(this.f5957c) && (this.f5959e.o0() || this.f5960f)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f5956b.a("AdActivityObserver", "App relaunched via launcher without an ad hidden callback, manually invoking ad hidden");
            }
            if (this.f5958d != null) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f5956b.a("AdActivityObserver", "Invoking callback...");
                }
                this.f5958d.a(this.f5959e);
            }
            a();
            return;
        }
        if (!this.f5962h) {
            this.f5962h = true;
        }
        this.f5961g++;
        if (com.applovin.impl.sdk.n.a()) {
            this.f5956b.a("AdActivityObserver", "Created Activity: " + activity + ", counter is " + this.f5961g);
        }
    }

    @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (this.f5962h) {
            this.f5961g--;
            if (com.applovin.impl.sdk.n.a()) {
                this.f5956b.a("AdActivityObserver", "Destroyed Activity: " + activity + ", counter is " + this.f5961g);
            }
            if (this.f5961g <= 0) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f5956b.a("AdActivityObserver", "Last ad Activity destroyed");
                }
                if (this.f5958d != null) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f5956b.a("AdActivityObserver", "Invoking callback...");
                    }
                    this.f5958d.a(this.f5959e);
                }
                a();
            }
        }
    }

    public void a(t2 t2Var, InterfaceC0164a interfaceC0164a) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f5956b.a("AdActivityObserver", "Starting for ad " + t2Var.getAdUnitId() + "...");
        }
        a();
        this.f5958d = interfaceC0164a;
        this.f5959e = t2Var;
        this.f5955a.a(this);
    }

    public void a() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f5956b.a("AdActivityObserver", "Cancelling...");
        }
        this.f5955a.b(this);
        this.f5958d = null;
        this.f5959e = null;
        this.f5961g = 0;
        this.f5962h = false;
    }
}
