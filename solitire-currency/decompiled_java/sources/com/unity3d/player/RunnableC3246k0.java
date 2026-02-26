package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.k0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class RunnableC3246k0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f24136a;

    RunnableC3246k0(UnityPlayer unityPlayer) {
        this.f24136a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f24136a.nativeResume();
    }
}
