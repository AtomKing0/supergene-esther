package com.unity3d.player;

import android.telephony.PhoneStateListener;

/* JADX INFO: loaded from: classes4.dex */
final class R0 extends PhoneStateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f23996a;

    private R0(UnityPlayer unityPlayer) {
        this.f23996a = unityPlayer;
    }

    @Override // android.telephony.PhoneStateListener
    public final void onCallStateChanged(int i10, String str) {
        this.f23996a.nativeMuteMasterAudio(i10 == 1);
    }
}
