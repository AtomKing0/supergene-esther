package com.unity3d.player;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;

/* JADX INFO: renamed from: com.unity3d.player.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class C3261s extends CameraCaptureSession.StateCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C3269w f24181a;

    C3261s(C3269w c3269w) {
        this.f24181a = c3269w;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        AbstractC3275z.Log(6, "Camera2: CaptureSession configuration failed.");
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onConfigured(CameraCaptureSession cameraCaptureSession) {
        String str;
        C3269w c3269w = this.f24181a;
        if (c3269w.f24197b == null) {
            return;
        }
        synchronized (c3269w.f24214s) {
            C3269w c3269w2 = this.f24181a;
            c3269w2.f24213r = cameraCaptureSession;
            try {
                c3269w2.f24212q = c3269w2.f24197b.createCaptureRequest(1);
                C3269w c3269w3 = this.f24181a;
                c3269w3.f24212q.addTarget(c3269w3.f24217v);
                C3269w c3269w4 = this.f24181a;
                c3269w4.f24212q.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, c3269w4.f24209n);
                this.f24181a.g();
            } catch (CameraAccessException e10) {
                str = "Camera2: CameraAccessException " + e10;
                AbstractC3275z.Log(6, str);
            } catch (IllegalStateException e11) {
                str = "Camera2: IllegalStateException " + e11;
                AbstractC3275z.Log(6, str);
            }
        }
    }
}
