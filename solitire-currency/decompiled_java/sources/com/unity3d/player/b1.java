package com.unity3d.player;

/* JADX INFO: loaded from: classes4.dex */
final class b1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ c1 f24079a;

    b1(c1 c1Var) {
        this.f24079a = c1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i1 i1Var = this.f24079a.f24085a.f24094h;
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
        this.f24079a.f24085a.f24094h.f24121a.onResume();
    }
}
