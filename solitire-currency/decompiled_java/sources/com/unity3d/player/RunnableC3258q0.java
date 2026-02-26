package com.unity3d.player;

import android.graphics.Rect;
import java.util.concurrent.Semaphore;

/* JADX INFO: renamed from: com.unity3d.player.q0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class RunnableC3258q0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f24173a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f24174b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Semaphore f24175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f24176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f24177e;

    RunnableC3258q0(UnityPlayer unityPlayer, Semaphore semaphore, UnityPlayer unityPlayer2) {
        this.f24177e = unityPlayer;
        this.f24175c = semaphore;
        this.f24176d = unityPlayer2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f24177e.reportSoftInputArea(new Rect());
        this.f24177e.reportSoftInputIsVisible(false);
        if (this.f24177e.mSoftInput != null) {
            this.f24176d.setOnHandleFocusListener(new C3254o0(this));
            UnityPlayer unityPlayer = this.f24177e;
            unityPlayer.mSoftInput.f24007g = new C3256p0(this);
            unityPlayer.dismissSoftInput();
        }
    }
}
