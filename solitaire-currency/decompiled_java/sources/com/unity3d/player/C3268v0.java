package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.v0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class C3268v0 extends V0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f24192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f24193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f24194d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f24195e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C3268v0(UnityPlayer unityPlayer, boolean z10, String str, int i10) {
        super(unityPlayer);
        this.f24195e = unityPlayer;
        this.f24192b = z10;
        this.f24193c = str;
        this.f24194d = i10;
    }

    @Override // com.unity3d.player.V0
    public final void a() {
        if (this.f24192b) {
            this.f24195e.nativeSoftInputCanceled();
        } else {
            String str = this.f24193c;
            if (str != null) {
                this.f24195e.nativeSetInputString(str);
            }
        }
        if (this.f24194d == 1) {
            this.f24195e.nativeSoftInputClosed();
        }
    }
}
