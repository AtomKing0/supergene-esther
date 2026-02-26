package com.unity3d.player;

/* JADX INFO: loaded from: classes4.dex */
final class f1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i1 f24101a;

    f1(i1 i1Var) {
        this.f24101a = i1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i1 i1Var = this.f24101a;
        a1 a1Var = i1Var.f24126f;
        if (a1Var != null) {
            i1Var.f24121a.addViewToPlayer(a1Var, true);
            i1 i1Var2 = this.f24101a;
            i1Var2.f24129i = true;
            i1Var2.f24126f.requestFocus();
        }
    }
}
