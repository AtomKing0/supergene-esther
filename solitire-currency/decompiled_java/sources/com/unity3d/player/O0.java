package com.unity3d.player;

import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes4.dex */
final class O0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Semaphore f23975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f23976b;

    O0(UnityPlayer unityPlayer, Semaphore semaphore) {
        this.f23976b = unityPlayer;
        this.f23975a = semaphore;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f23976b.shutdown();
        this.f23975a.release();
    }
}
