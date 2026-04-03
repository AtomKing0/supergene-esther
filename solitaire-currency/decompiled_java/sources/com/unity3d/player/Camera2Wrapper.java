package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;
import android.view.Surface;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public class Camera2Wrapper implements y6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f23922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private C3269w f23923b = null;

    public Camera2Wrapper(Context context) {
        this.f23922a = context;
        initCamera2Jni();
    }

    private final native void deinitCamera2Jni();

    private final native void initCamera2Jni();

    private final native void nativeFrameReady(Object obj, Object obj2, Object obj3, int i10, int i11, int i12);

    private final native void nativeSurfaceTextureReady(Object obj);

    public final void a() {
        deinitCamera2Jni();
        closeCamera2();
    }

    protected void closeCamera2() {
        C3269w c3269w = this.f23923b;
        if (c3269w != null) {
            c3269w.a();
        }
        this.f23923b = null;
    }

    protected int getCamera2Count() {
        return C3269w.a(this.f23922a);
    }

    protected int getCamera2FocalLengthEquivalent(int i10) {
        return C3269w.a(this.f23922a, i10);
    }

    protected int[] getCamera2Resolutions(int i10) {
        return C3269w.b(this.f23922a, i10);
    }

    protected int getCamera2SensorOrientation(int i10) {
        return C3269w.c(this.f23922a, i10);
    }

    protected Rect getFrameSizeCamera2() {
        C3269w c3269w = this.f23923b;
        return c3269w != null ? c3269w.c() : new Rect();
    }

    protected boolean initializeCamera2(int i10, int i11, int i12, int i13, int i14, Surface surface) {
        if (this.f23923b != null || UnityPlayer.currentActivity == null) {
            return false;
        }
        C3269w c3269w = new C3269w(this);
        this.f23923b = c3269w;
        return c3269w.a(this.f23922a, i10, i11, i12, i13, i14, surface);
    }

    protected boolean isCamera2AutoFocusPointSupported(int i10) {
        return C3269w.d(this.f23922a, i10);
    }

    protected boolean isCamera2FrontFacing(int i10) {
        return C3269w.e(this.f23922a, i10);
    }

    protected void pauseCamera2() {
        C3269w c3269w = this.f23923b;
        if (c3269w != null) {
            c3269w.d();
        }
    }

    protected boolean setAutoFocusPoint(float f10, float f11) {
        C3269w c3269w = this.f23923b;
        if (c3269w != null) {
            return c3269w.a(f10, f11);
        }
        return false;
    }

    protected void startCamera2() {
        C3269w c3269w = this.f23923b;
        if (c3269w != null) {
            c3269w.h();
        }
    }

    protected void stopCamera2() {
        C3269w c3269w = this.f23923b;
        if (c3269w != null) {
            c3269w.i();
        }
    }

    public final void a(Object obj) {
        nativeSurfaceTextureReady(obj);
    }

    public final void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i10, int i11, int i12) {
        nativeFrameReady(byteBuffer, byteBuffer2, byteBuffer3, i10, i11, i12);
    }
}
