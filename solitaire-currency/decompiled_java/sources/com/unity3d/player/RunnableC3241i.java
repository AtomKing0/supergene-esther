package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class RunnableC3241i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IAssetPackManagerMobileDataConfirmationCallback f24116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f24117b;

    RunnableC3241i(IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback, boolean z10) {
        this.f24116a = iAssetPackManagerMobileDataConfirmationCallback;
        this.f24117b = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f24116a.onMobileDataConfirmationResult(this.f24117b);
    }
}
