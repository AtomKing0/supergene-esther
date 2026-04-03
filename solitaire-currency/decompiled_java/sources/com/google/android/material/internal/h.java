package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.GravityCompat;

/* JADX INFO: compiled from: ForegroundLinearLayout.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class h extends LinearLayoutCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private Drawable f9453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Rect f9454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Rect f9455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected boolean f9457e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f9458f;

    public h(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f9453a;
        if (drawable != null) {
            if (this.f9458f) {
                this.f9458f = false;
                Rect rect = this.f9454b;
                Rect rect2 = this.f9455c;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f9457e) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f9456d, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    @TargetApi(21)
    public void drawableHotspotChanged(float f10, float f11) {
        super.drawableHotspotChanged(f10, f11);
        Drawable drawable = this.f9453a;
        if (drawable != null) {
            drawable.setHotspot(f10, f11);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f9453a;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f9453a.setState(getDrawableState());
    }

    @Override // android.view.View
    @Nullable
    public Drawable getForeground() {
        return this.f9453a;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f9456d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f9453a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.f9458f = z10 | this.f9458f;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f9458f = true;
    }

    @Override // android.view.View
    public void setForeground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f9453a;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f9453a);
            }
            this.f9453a = drawable;
            this.f9458f = true;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f9456d == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i10) {
        if (this.f9456d != i10) {
            if ((8388615 & i10) == 0) {
                i10 |= GravityCompat.START;
            }
            if ((i10 & 112) == 0) {
                i10 |= 48;
            }
            this.f9456d = i10;
            if (i10 == 119 && this.f9453a != null) {
                this.f9453a.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f9453a;
    }

    public h(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f9454b = new Rect();
        this.f9455c = new Rect();
        this.f9456d = 119;
        this.f9457e = true;
        this.f9458f = false;
        TypedArray typedArrayI = p.i(context, attributeSet, e4.k.f25120z1, i10, 0, new int[0]);
        this.f9456d = typedArrayI.getInt(e4.k.B1, this.f9456d);
        Drawable drawable = typedArrayI.getDrawable(e4.k.A1);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f9457e = typedArrayI.getBoolean(e4.k.C1, true);
        typedArrayI.recycle();
    }
}
