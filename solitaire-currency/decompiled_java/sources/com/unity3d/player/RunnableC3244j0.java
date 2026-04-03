package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.j0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class RunnableC3244j0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f24132a;

    RunnableC3244j0(UnityPlayer unityPlayer) {
        this.f24132a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f24132a.nativeLowMemory();
    }
}
