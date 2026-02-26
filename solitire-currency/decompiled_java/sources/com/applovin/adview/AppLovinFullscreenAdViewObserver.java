package com.applovin.adview;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.applovin.impl.h2;
import com.applovin.impl.p1;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class AppLovinFullscreenAdViewObserver implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lifecycle f4652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h2 f4653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f4654c = new AtomicBoolean(true);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private p1 f4655d;

    public AppLovinFullscreenAdViewObserver(Lifecycle lifecycle, h2 h2Var) {
        this.f4652a = lifecycle;
        this.f4653b = h2Var;
        lifecycle.addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        this.f4652a.removeObserver(this);
        h2 h2Var = this.f4653b;
        if (h2Var != null) {
            h2Var.a();
            this.f4653b = null;
        }
        p1 p1Var = this.f4655d;
        if (p1Var != null) {
            p1Var.c();
            this.f4655d.q();
            this.f4655d = null;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        p1 p1Var = this.f4655d;
        if (p1Var != null) {
            p1Var.r();
            this.f4655d.u();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        p1 p1Var;
        if (this.f4654c.getAndSet(false) || (p1Var = this.f4655d) == null) {
            return;
        }
        p1Var.s();
        this.f4655d.a(0L);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        p1 p1Var = this.f4655d;
        if (p1Var != null) {
            p1Var.t();
        }
    }

    public void setPresenter(p1 p1Var) {
        this.f4655d = p1Var;
    }
}
