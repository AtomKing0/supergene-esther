package com.unity3d.player;

/* JADX INFO: loaded from: classes4.dex */
final class T implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ U f24018a;

    T(U u10) {
        this.f24018a = u10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        S s10 = this.f24018a.f24023d;
        s10.a(s10.b(), true);
    }
}
