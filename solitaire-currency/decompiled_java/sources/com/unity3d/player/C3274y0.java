package com.unity3d.player;

import android.graphics.Rect;

/* JADX INFO: renamed from: com.unity3d.player.y0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class C3274y0 extends V0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Rect f24226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f24227c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C3274y0(UnityPlayer unityPlayer, Rect rect) {
        super(unityPlayer);
        this.f24227c = unityPlayer;
        this.f24226b = rect;
    }

    @Override // com.unity3d.player.V0
    public final void a() {
        UnityPlayer unityPlayer = this.f24227c;
        Rect rect = this.f24226b;
        unityPlayer.nativeSetInputArea(rect.left, rect.top, rect.right, rect.bottom);
    }
}
