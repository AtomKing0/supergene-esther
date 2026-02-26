package com.unity3d.player;

import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes4.dex */
final class P0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Semaphore f23984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f23985b;

    P0(UnityPlayer unityPlayer, Semaphore semaphore) {
        this.f23985b = unityPlayer;
        this.f23984a = semaphore;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f23985b.nativePause()) {
            UnityPlayer unityPlayer = this.f23985b;
            unityPlayer.mQuitting = true;
            unityPlayer.shutdown();
            this.f23985b.queueDestroy();
        }
        this.f23984a.release();
    }
}
