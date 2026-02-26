package com.unity3d.player;

import android.view.SurfaceHolder;

/* JADX INFO: renamed from: com.unity3d.player.h0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class SurfaceHolderCallbackC3240h0 implements SurfaceHolder.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C3242i0 f24115a;

    SurfaceHolderCallbackC3240h0(C3242i0 c3242i0) {
        this.f24115a = c3242i0;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
        this.f24115a.f24119b.updateGLDisplay(0, surfaceHolder.getSurface());
        this.f24115a.f24119b.sendSurfaceChangedEvent();
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f24115a.f24119b.updateGLDisplay(0, surfaceHolder.getSurface());
        C3242i0 c3242i0 = this.f24115a;
        K k10 = c3242i0.f24120c;
        UnityPlayer unityPlayer = c3242i0.f24119b;
        J j10 = k10.f23951b;
        if (j10 == null || j10.getParent() != null) {
            return;
        }
        unityPlayer.addView(k10.f23951b);
        unityPlayer.bringChildToFront(k10.f23951b);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        C3242i0 c3242i0 = this.f24115a;
        K k10 = c3242i0.f24120c;
        C3235f c3235f = c3242i0.f24118a;
        k10.getClass();
        if (PlatformSupport.NOUGAT_SUPPORT && k10.f23950a != null) {
            if (k10.f23951b == null) {
                k10.f23951b = new J(k10.f23950a);
            }
            k10.f23951b.a(c3235f);
        }
        this.f24115a.f24119b.updateGLDisplay(0, null);
    }
}
