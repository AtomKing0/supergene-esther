package com.unity3d.player;

import android.os.SystemClock;
import android.view.KeyEvent;

/* JADX INFO: loaded from: classes4.dex */
final class H0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f23936a;

    H0(UnityPlayer unityPlayer) {
        this.f23936a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        KeyEvent keyEvent = new KeyEvent(jUptimeMillis, jUptimeMillis, 0, 4, 1, 0, -1, 0, 0, 257);
        KeyEvent keyEvent2 = new KeyEvent(jUptimeMillis, jUptimeMillis + 1, 1, 4, 1, 0, -1, 0, 0, 257);
        this.f23936a.mActivity.dispatchKeyEvent(keyEvent);
        this.f23936a.mActivity.dispatchKeyEvent(keyEvent2);
    }
}
