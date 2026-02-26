package com.unity3d.player;

import android.hardware.camera2.CameraDevice;

/* JADX INFO: renamed from: com.unity3d.player.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class C3263t extends CameraDevice.StateCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C3269w f24184a;

    C3263t(C3269w c3269w) {
        this.f24184a = c3269w;
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onClosed(CameraDevice cameraDevice) {
        C3269w.D.release();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onDisconnected(CameraDevice cameraDevice) {
        AbstractC3275z.Log(5, "Camera2: CameraDevice disconnected.");
        this.f24184a.a(cameraDevice);
        C3269w.D.release();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onError(CameraDevice cameraDevice, int i10) {
        AbstractC3275z.Log(6, "Camera2: Error opeining CameraDevice " + i10);
        this.f24184a.a(cameraDevice);
        C3269w.D.release();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onOpened(CameraDevice cameraDevice) {
        this.f24184a.f24197b = cameraDevice;
        C3269w.D.release();
    }
}
