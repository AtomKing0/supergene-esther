package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.n0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class RunnableC3252n0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f24163a;

    RunnableC3252n0(UnityPlayer unityPlayer) {
        this.f24163a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C3242i0 c3242i0 = this.f24163a.mGlView;
        if (c3242i0 != null) {
            c3242i0.b();
        }
    }
}
