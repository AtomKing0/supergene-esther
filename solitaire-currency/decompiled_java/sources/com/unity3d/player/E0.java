package com.unity3d.player;

/* JADX INFO: loaded from: classes4.dex */
final class E0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ float f23928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f23929b;

    E0(UnityPlayer unityPlayer, float f10) {
        this.f23929b = unityPlayer;
        this.f23928a = f10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f23929b.mGlView.a(this.f23928a);
    }
}
