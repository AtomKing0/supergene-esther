package com.unity3d.player;

/* JADX INFO: loaded from: classes4.dex */
final class c1 implements Y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ d1 f24085a;

    c1(d1 d1Var) {
        this.f24085a = d1Var;
    }

    public final void a(int i10) {
        this.f24085a.f24094h.f24125e.lock();
        i1 i1Var = this.f24085a.f24094h;
        i1Var.f24127g = i10;
        if (i10 == 3 && i1Var.f24129i) {
            i1Var.runOnUiThread(new b1(this));
        }
        if (i10 != 0) {
            this.f24085a.f24094h.f24124d.release();
        }
        this.f24085a.f24094h.f24125e.unlock();
    }
}
