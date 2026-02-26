package com.google.android.material.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: FadeThroughDrawable.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class e extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Drawable f9445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Drawable f9446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float[] f9447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f9448d;

    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        if (this.f9448d != f10) {
            this.f9448d = f10;
            f.a(f10, this.f9447c);
            this.f9445a.setAlpha((int) (this.f9447c[0] * 255.0f));
            this.f9446b.setAlpha((int) (this.f9447c[1] * 255.0f));
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.f9445a.draw(canvas);
        this.f9446b.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return Math.max(this.f9445a.getIntrinsicHeight(), this.f9446b.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.max(this.f9445a.getIntrinsicWidth(), this.f9446b.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return Math.max(this.f9445a.getMinimumHeight(), this.f9446b.getMinimumHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return Math.max(this.f9445a.getMinimumWidth(), this.f9446b.getMinimumWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f9445a.isStateful() || this.f9446b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (this.f9448d <= 0.5f) {
            this.f9445a.setAlpha(i10);
            this.f9446b.setAlpha(0);
        } else {
            this.f9445a.setAlpha(0);
            this.f9446b.setAlpha(i10);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i10, int i11, int i12, int i13) {
        super.setBounds(i10, i11, i12, i13);
        this.f9445a.setBounds(i10, i11, i12, i13);
        this.f9446b.setBounds(i10, i11, i12, i13);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f9445a.setColorFilter(colorFilter);
        this.f9446b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return this.f9445a.setState(iArr) || this.f9446b.setState(iArr);
    }
}
