package com.unity3d.player;

/* JADX INFO: loaded from: classes4.dex */
abstract class V0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f24035a;

    private V0(UnityPlayer unityPlayer) {
        this.f24035a = unityPlayer;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f24035a.isFinishing()) {
            return;
        }
        a();
    }
}
