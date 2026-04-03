package com.unity3d.player;

/* JADX INFO: loaded from: classes4.dex */
final class G0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f23932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f23933b;

    G0(UnityPlayer unityPlayer, int i10) {
        this.f23933b = unityPlayer;
        this.f23932a = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            UnityPlayer unityPlayer = this.f23933b;
            AbstractC3229c.a(unityPlayer.mActivity, unityPlayer, this.f23932a);
        } catch (Exception e10) {
            AbstractC3275z.Log(6, "Exception when opening Activity Indicator " + e10);
        }
    }
}
