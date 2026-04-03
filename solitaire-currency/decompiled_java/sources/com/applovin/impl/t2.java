package com.applovin.impl;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class t2 extends q2 implements m1 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Bundle f7430t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final AtomicReference f7431u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final AtomicBoolean f7432v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final AtomicBoolean f7433w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f7434x;

    public t2(Map map, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
        super(map, jSONObject, jSONObject2, null, jVar);
        this.f7430t = new Bundle();
        this.f7433w = new AtomicBoolean();
        this.f7431u = new AtomicReference();
        this.f7432v = new AtomicBoolean();
    }

    private long c0() {
        long jA = a("ad_expiration_ms", -1L);
        return jA < 0 ? b("ad_expiration_ms", ((Long) this.f4682a.a(g3.Z6)).longValue()) : jA;
    }

    @Override // com.applovin.impl.q2
    public q2 a(com.applovin.impl.mediation.g gVar) {
        return new t2(this, gVar);
    }

    public void b0() {
        this.f7432v.set(true);
    }

    public long d0() {
        return a("ahdm", ((Long) this.f4682a.a(g3.T6)).longValue());
    }

    public long e0() {
        long jA = a("ad_hidden_on_ad_dismiss_callback_delay_ms", -1L);
        return jA >= 0 ? jA : b("ad_hidden_on_ad_dismiss_callback_delay_ms", ((Long) this.f4682a.a(g3.f5232h7)).longValue());
    }

    public long f0() {
        long jA = a("ad_hidden_timeout_ms", -1L);
        return jA >= 0 ? jA : b("ad_hidden_timeout_ms", ((Long) this.f4682a.a(g3.f5229e7)).longValue());
    }

    public b4 g0() {
        return (b4) this.f7431u.getAndSet(null);
    }

    @Override // com.applovin.impl.m1
    public long getTimeToLiveMillis() {
        return c0() - (SystemClock.elapsedRealtime() - H());
    }

    public long h0() {
        if (H() > 0) {
            return SystemClock.elapsedRealtime() - H();
        }
        return -1L;
    }

    public Bundle i0() {
        return this.f7430t;
    }

    public long j0() {
        long jA = a("fullscreen_display_delay_ms", -1L);
        return jA >= 0 ? jA : ((Long) this.f4682a.a(g3.R6)).longValue();
    }

    public String k0() {
        return b("mcode", "");
    }

    public AtomicBoolean l0() {
        return this.f7433w;
    }

    public boolean m0() {
        return this.f7432v.get();
    }

    public boolean n0() {
        if (a("schedule_ad_hidden_on_ad_dismiss", Boolean.FALSE).booleanValue()) {
            return true;
        }
        return b("schedule_ad_hidden_on_ad_dismiss", (Boolean) this.f4682a.a(g3.f5230f7)).booleanValue();
    }

    public boolean o0() {
        if (a("schedule_ad_hidden_on_single_task_app_relaunch", Boolean.FALSE).booleanValue()) {
            return true;
        }
        return b("schedule_ad_hidden_on_single_task_app_relaunch", (Boolean) this.f4682a.a(g3.f5231g7)).booleanValue();
    }

    public boolean p0() {
        return a("susaode", (Boolean) this.f4682a.a(g3.S6)).booleanValue();
    }

    @Override // com.applovin.impl.m1
    public void setExpired() {
        this.f7434x = true;
    }

    @Override // com.applovin.impl.q2
    public void a(Bundle bundle) {
        Bundle bundle2;
        super.a(bundle);
        if (bundle == null || (bundle2 = bundle.getBundle("applovin_ad_view_info")) == null) {
            return;
        }
        this.f7430t.putBundle("applovin_ad_view_info", bundle2);
    }

    public void a(b4 b4Var) {
        this.f7431u.set(b4Var);
    }

    private t2(t2 t2Var, com.applovin.impl.mediation.g gVar) {
        super(t2Var.i(), t2Var.a(), t2Var.g(), gVar, t2Var.f4682a);
        this.f7430t = new Bundle();
        this.f7433w = new AtomicBoolean();
        this.f7431u = t2Var.f7431u;
        this.f7432v = t2Var.f7432v;
    }
}
