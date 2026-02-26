package com.unity3d.player;

import android.app.Activity;

/* JADX INFO: loaded from: classes4.dex */
final class B0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f23917a;

    B0(UnityPlayer unityPlayer) {
        this.f23917a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UnityPlayer unityPlayer;
        Activity activity;
        if (!this.f23917a.nativeIsAutorotationOn() || (activity = (unityPlayer = this.f23917a).mActivity) == null) {
            return;
        }
        activity.setRequestedOrientation(unityPlayer.mInitialScreenOrientation);
    }
}
