package com.unity3d.player;

/* JADX INFO: loaded from: classes4.dex */
final class g1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i1 f24111a;

    g1(i1 i1Var) {
        this.f24111a = i1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i1 i1Var = this.f24111a;
        a1 a1Var = i1Var.f24126f;
        if (a1Var != null) {
            i1Var.f24121a.removeViewFromPlayer(a1Var);
            i1Var.f24129i = false;
            i1Var.f24126f.destroyPlayer();
            i1Var.f24126f = null;
            h1 h1Var = i1Var.f24123c;
            if (h1Var != null) {
                ((A0) h1Var).a();
            }
        }
        this.f24111a.f24121a.onResume();
    }
}
