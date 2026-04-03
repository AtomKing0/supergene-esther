package com.unity3d.player;

/* JADX INFO: loaded from: classes4.dex */
final class N0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f23969a;

    N0(UnityPlayer unityPlayer) {
        this.f23969a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f23969a.destroy();
    }
}
