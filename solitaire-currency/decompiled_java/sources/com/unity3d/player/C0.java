package com.unity3d.player;

/* JADX INFO: loaded from: classes4.dex */
final class C0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f23921a;

    C0(UnityPlayer unityPlayer) {
        this.f23921a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f23921a.setupUnityToBePaused();
        this.f23921a.windowFocusChanged(false);
        this.f23921a.m_UnityPlayerLifecycleEvents.onUnityPlayerUnloaded();
    }
}
