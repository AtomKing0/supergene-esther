package com.unity3d.player;

import android.graphics.SurfaceTexture;

/* JADX INFO: renamed from: com.unity3d.player.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class C3267v implements SurfaceTexture.OnFrameAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C3269w f24191a;

    C3267v(C3269w c3269w) {
        this.f24191a = c3269w;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        ((Camera2Wrapper) this.f24191a.f24196a).a(surfaceTexture);
    }
}
