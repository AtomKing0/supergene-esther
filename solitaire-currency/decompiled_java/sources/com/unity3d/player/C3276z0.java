package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.z0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class C3276z0 extends V0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f24229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f24230c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C3276z0(UnityPlayer unityPlayer, boolean z10) {
        super(unityPlayer);
        this.f24230c = unityPlayer;
        this.f24229b = z10;
    }

    @Override // com.unity3d.player.V0
    public final void a() {
        this.f24230c.nativeSetKeyboardIsVisible(this.f24229b);
    }
}
