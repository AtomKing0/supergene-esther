package com.unity3d.player;

import android.content.Context;
import android.view.OrientationEventListener;

/* JADX INFO: loaded from: classes4.dex */
final class D0 extends OrientationEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f23927a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    D0(UnityPlayer unityPlayer, Context context, int i10) {
        super(context, i10);
        this.f23927a = unityPlayer;
    }

    @Override // android.view.OrientationEventListener
    public final void onOrientationChanged(int i10) {
        UnityPlayer unityPlayer = this.f23927a;
        U0 u02 = unityPlayer.m_MainThread;
        u02.f24030f = unityPlayer.mNaturalOrientation;
        u02.f24031g = i10;
        u02.a(S0.f24017j);
    }
}
