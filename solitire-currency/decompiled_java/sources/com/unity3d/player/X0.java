package com.unity3d.player;

/* JADX INFO: loaded from: classes4.dex */
final class X0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a1 f24045a;

    X0(a1 a1Var) {
        this.f24045a = a1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f24045a.destroyPlayer();
        this.f24045a.a(3);
    }
}
