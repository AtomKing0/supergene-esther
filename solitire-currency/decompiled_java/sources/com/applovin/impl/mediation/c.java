package com.applovin.impl.mediation;

import com.applovin.impl.t2;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f6093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f6094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f6095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.applovin.impl.c0 f6096d;

    public interface a {
        void b(t2 t2Var);
    }

    c(com.applovin.impl.sdk.j jVar, a aVar) {
        this.f6093a = jVar;
        this.f6094b = jVar.I();
        this.f6095c = aVar;
    }

    public void a(final t2 t2Var, long j10) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f6094b.a("AdHiddenCallbackTimeoutManager", "Scheduling in " + j10 + "ms...");
        }
        this.f6096d = com.applovin.impl.c0.a(j10, this.f6093a, new Runnable() { // from class: com.applovin.impl.mediation.r
            @Override // java.lang.Runnable
            public final void run() {
                this.f6317a.a(t2Var);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(t2 t2Var) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f6094b.a("AdHiddenCallbackTimeoutManager", "Timing out...");
        }
        this.f6095c.b(t2Var);
    }

    public void a() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f6094b.a("AdHiddenCallbackTimeoutManager", "Cancelling timeout");
        }
        com.applovin.impl.c0 c0Var = this.f6096d;
        if (c0Var != null) {
            c0Var.a();
            this.f6096d = null;
        }
    }
}
