package com.applovin.impl.mediation;

import com.applovin.impl.l2;
import com.applovin.impl.mediation.a;
import com.applovin.impl.mediation.c;
import com.applovin.impl.t2;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: loaded from: classes2.dex */
public class b implements a.InterfaceC0164a, c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f6088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f6089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f6090c;

    public b(com.applovin.impl.sdk.j jVar) {
        this.f6088a = jVar;
        this.f6089b = new a(jVar);
        this.f6090c = new c(jVar, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void c(t2 t2Var) {
        g gVarA;
        if (t2Var == null || (gVarA = t2Var.A()) == null || !t2Var.w().compareAndSet(false, true)) {
            return;
        }
        l2.e(gVarA.c(), t2Var);
    }

    @Override // com.applovin.impl.mediation.c.a
    public void b(t2 t2Var) {
        c(t2Var);
    }

    public void e(t2 t2Var) {
        long jF0 = t2Var.f0();
        if (jF0 >= 0) {
            this.f6090c.a(t2Var, jF0);
        }
        boolean z10 = Boolean.parseBoolean(this.f6088a.g0().getExtraParameters().get("should_schedule_ad_hidden_on_ad_destroy"));
        if (t2Var.n0() || t2Var.o0() || z10) {
            this.f6089b.a(z10);
            this.f6089b.a(t2Var, this);
        }
    }

    public void a() {
        this.f6090c.a();
        this.f6089b.a();
    }

    @Override // com.applovin.impl.mediation.a.InterfaceC0164a
    public void a(final t2 t2Var) {
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.q
            @Override // java.lang.Runnable
            public final void run() {
                this.f6313a.c(t2Var);
            }
        }, t2Var.e0());
    }
}
