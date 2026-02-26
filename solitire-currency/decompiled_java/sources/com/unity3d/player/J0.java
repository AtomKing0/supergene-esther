package com.unity3d.player;

/* JADX INFO: loaded from: classes4.dex */
final class J0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f23949a;

    J0(UnityPlayer unityPlayer) {
        this.f23949a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UnityPlayer unityPlayer = this.f23949a;
        unityPlayer.removeView(unityPlayer.m_SplashScreen);
        this.f23949a.m_SplashScreen = null;
    }
}
