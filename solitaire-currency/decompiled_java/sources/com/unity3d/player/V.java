package com.unity3d.player;

/* JADX INFO: loaded from: classes4.dex */
final class V implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ X f24034a;

    V(X x10) {
        this.f24034a = x10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f24034a.f24003c.requestFocus();
        this.f24034a.f();
    }
}
