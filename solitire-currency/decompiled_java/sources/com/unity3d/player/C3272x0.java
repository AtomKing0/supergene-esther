package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.x0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class C3272x0 extends V0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f24223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f24224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f24225d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C3272x0(UnityPlayer unityPlayer, int i10, int i11) {
        super(unityPlayer);
        this.f24225d = unityPlayer;
        this.f24223b = i10;
        this.f24224c = i11;
    }

    @Override // com.unity3d.player.V0
    public final void a() {
        this.f24225d.nativeSetInputSelection(this.f24223b, this.f24224c);
    }
}
