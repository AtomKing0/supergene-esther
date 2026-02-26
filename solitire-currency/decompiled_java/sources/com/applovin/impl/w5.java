package com.applovin.impl;

import com.applovin.impl.r5;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class w5 extends w4 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final WeakReference f7683g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object f7684h;

    protected w5(g4 g4Var, Object obj, String str, com.applovin.impl.sdk.j jVar) {
        super(str, jVar);
        this.f7683g = new WeakReference(g4Var);
        this.f7684h = obj;
    }

    public static void a(long j10, g4 g4Var, Object obj, String str, com.applovin.impl.sdk.j jVar) {
        if (j10 <= 0) {
            return;
        }
        jVar.j0().a(new w5(g4Var, obj, str, jVar), r5.b.TIMEOUT, j10);
    }

    @Override // java.lang.Runnable
    public void run() {
        g4 g4Var = (g4) this.f7683g.get();
        if (g4Var == null || g4Var.c()) {
            return;
        }
        this.f7677a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f7677a.I().d(this.f7678b, "Attempting to timeout pending task " + g4Var.b() + " with " + this.f7684h);
        }
        g4Var.a(this.f7684h);
    }
}
