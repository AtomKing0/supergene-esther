package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class AspectRatioFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f8436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f8437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8438c;

    public interface b {
    }

    private final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f8439a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f8440b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f8441c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f8442d;

        private c() {
        }

        public void a(float f10, float f11, boolean z10) {
            this.f8439a = f10;
            this.f8440b = f11;
            this.f8441c = z10;
            if (this.f8442d) {
                return;
            }
            this.f8442d = true;
            AspectRatioFrameLayout.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8442d = false;
            AspectRatioFrameLayout.a(AspectRatioFrameLayout.this);
        }
    }

    public AspectRatioFrameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8438c = 0;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, y3.q.f36597a, 0, 0);
            try {
                this.f8438c = typedArrayObtainStyledAttributes.getInt(y3.q.f36599b, 0);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        this.f8436a = new c();
    }

    static /* synthetic */ b a(AspectRatioFrameLayout aspectRatioFrameLayout) {
        aspectRatioFrameLayout.getClass();
        return null;
    }

    public int getResizeMode() {
        return this.f8438c;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        float f10;
        float f11;
        super.onMeasure(i10, i11);
        if (this.f8437b <= 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f12 = measuredWidth;
        float f13 = measuredHeight;
        float f14 = f12 / f13;
        float f15 = (this.f8437b / f14) - 1.0f;
        if (Math.abs(f15) <= 0.01f) {
            this.f8436a.a(this.f8437b, f14, false);
            return;
        }
        int i12 = this.f8438c;
        if (i12 != 0) {
            if (i12 != 1) {
                if (i12 == 2) {
                    f10 = this.f8437b;
                } else if (i12 == 4) {
                    if (f15 > 0.0f) {
                        f10 = this.f8437b;
                    } else {
                        f11 = this.f8437b;
                    }
                }
                measuredWidth = (int) (f13 * f10);
            } else {
                f11 = this.f8437b;
            }
            measuredHeight = (int) (f12 / f11);
        } else if (f15 > 0.0f) {
            f11 = this.f8437b;
            measuredHeight = (int) (f12 / f11);
        } else {
            f10 = this.f8437b;
            measuredWidth = (int) (f13 * f10);
        }
        this.f8436a.a(this.f8437b, f14, true);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }

    public void setAspectRatio(float f10) {
        if (this.f8437b != f10) {
            this.f8437b = f10;
            requestLayout();
        }
    }

    public void setResizeMode(int i10) {
        if (this.f8438c != i10) {
            this.f8438c = i10;
            requestLayout();
        }
    }

    public void setAspectRatioListener(@Nullable b bVar) {
    }
}
