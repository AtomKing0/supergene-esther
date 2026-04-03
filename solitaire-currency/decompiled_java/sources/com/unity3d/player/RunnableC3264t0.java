package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.t0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class RunnableC3264t0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f24185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f24186b;

    RunnableC3264t0(UnityPlayer unityPlayer, boolean z10) {
        this.f24186b = unityPlayer;
        this.f24185a = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        S s10 = this.f24186b.mSoftInput;
        if (s10 != null) {
            s10.a(this.f24185a);
        }
    }
}
