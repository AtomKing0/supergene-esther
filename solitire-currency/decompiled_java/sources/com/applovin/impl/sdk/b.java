package com.applovin.impl.sdk;

import com.applovin.impl.l4;
import com.applovin.impl.m1;
import com.applovin.impl.sdk.a;
import com.applovin.impl.t6;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f6989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakReference f6990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WeakReference f6991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private t6 f6992d;

    private b(m1 m1Var, a.InterfaceC0171a interfaceC0171a, j jVar) {
        this.f6990b = new WeakReference(m1Var);
        this.f6991c = new WeakReference(interfaceC0171a);
        this.f6989a = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        d();
        this.f6989a.f().a(this);
    }

    public m1 b() {
        return (m1) this.f6990b.get();
    }

    public void d() {
        a();
        m1 m1VarB = b();
        if (m1VarB == null) {
            return;
        }
        m1VarB.setExpired();
        a.InterfaceC0171a interfaceC0171a = (a.InterfaceC0171a) this.f6991c.get();
        if (interfaceC0171a == null) {
            return;
        }
        interfaceC0171a.onAdExpired(m1VarB);
    }

    public static b a(m1 m1Var, a.InterfaceC0171a interfaceC0171a, j jVar) {
        b bVar = new b(m1Var, interfaceC0171a, jVar);
        bVar.a(m1Var.getTimeToLiveMillis());
        return bVar;
    }

    public void a(long j10) {
        a();
        if (((Boolean) this.f6989a.a(l4.U0)).booleanValue() || !this.f6989a.f0().isApplicationPaused()) {
            this.f6992d = t6.a(j10, this.f6989a, new Runnable() { // from class: com.applovin.impl.sdk.a0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6926a.c();
                }
            });
        }
    }

    public void a() {
        t6 t6Var = this.f6992d;
        if (t6Var != null) {
            t6Var.a();
            this.f6992d = null;
        }
    }
}
