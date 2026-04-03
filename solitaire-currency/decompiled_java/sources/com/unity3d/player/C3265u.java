package com.unity3d.player;

import android.media.Image;
import android.media.ImageReader;

/* JADX INFO: renamed from: com.unity3d.player.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class C3265u implements ImageReader.OnImageAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C3269w f24187a;

    C3265u(C3269w c3269w) {
        this.f24187a = c3269w;
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public final void onImageAvailable(ImageReader imageReader) {
        if (C3269w.D.tryAcquire()) {
            Image imageAcquireNextImage = imageReader.acquireNextImage();
            if (imageAcquireNextImage != null) {
                Image.Plane[] planes = imageAcquireNextImage.getPlanes();
                if (imageAcquireNextImage.getFormat() == 35 && planes != null && planes.length == 3) {
                    ((Camera2Wrapper) this.f24187a.f24196a).a(planes[0].getBuffer(), planes[1].getBuffer(), planes[2].getBuffer(), planes[0].getRowStride(), planes[1].getRowStride(), planes[1].getPixelStride());
                } else {
                    AbstractC3275z.Log(6, "Camera2: Wrong image format.");
                }
                Image image = this.f24187a.f24211p;
                if (image != null) {
                    image.close();
                }
                this.f24187a.f24211p = imageAcquireNextImage;
            }
            C3269w.D.release();
        }
    }
}
