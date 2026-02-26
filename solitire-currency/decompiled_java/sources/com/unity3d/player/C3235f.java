package com.unity3d.player;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: com.unity3d.player.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class C3235f extends SurfaceView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f24097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private UnityPlayer f24098b;

    public C3235f(Context context, UnityPlayer unityPlayer) {
        super(context);
        this.f24098b = unityPlayer;
    }

    public final void a(float f10) {
        this.f24097a = f10;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int i10 = f10 <= 0.0f ? -1 : -2;
        layoutParams.width = i10;
        layoutParams.height = i10;
        setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (a()) {
            return this.f24098b.injectEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i10, int i11) {
        if (this.f24097a <= 0.0f) {
            super.onMeasure(i10, i11);
            return;
        }
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        if (size <= 0 || size2 <= 0 || View.MeasureSpec.getMode(i10) != Integer.MIN_VALUE || View.MeasureSpec.getMode(i11) != Integer.MIN_VALUE) {
            super.onMeasure(i10, i11);
            return;
        }
        float f10 = size;
        float f11 = size2;
        float f12 = f10 / f11;
        float f13 = this.f24097a;
        if (f12 < f13) {
            size2 = (int) (f10 / f13);
        } else {
            size = (int) (f11 * f13);
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (a()) {
            return this.f24098b.injectEvent(motionEvent);
        }
        return false;
    }

    public final boolean a() {
        return this.f24097a > 0.0f;
    }
}
