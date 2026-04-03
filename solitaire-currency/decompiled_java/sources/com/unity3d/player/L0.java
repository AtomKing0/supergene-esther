package com.unity3d.player;

import android.view.Surface;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes4.dex */
final class L0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f23957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Surface f23958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Semaphore f23959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f23960d;

    L0(UnityPlayer unityPlayer, int i10, Surface surface, Semaphore semaphore) {
        this.f23960d = unityPlayer;
        this.f23957a = i10;
        this.f23958b = surface;
        this.f23959c = semaphore;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f23960d.nativeRecreateGfxState(this.f23957a, this.f23958b);
        this.f23959c.release();
    }
}
