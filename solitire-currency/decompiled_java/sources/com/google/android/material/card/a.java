package com.google.android.material.card;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import e4.b;
import e4.j;
import x4.k;
import x4.n;

/* JADX INFO: compiled from: MaterialCardView.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends CardView implements Checkable, n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f9004d = {R.attr.state_checkable};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f9005e = {R.attr.state_checked};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f9006f = {b.S};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f9007g = j.f24908n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f9008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f9009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f9010c;

    /* JADX INFO: renamed from: com.google.android.material.card.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MaterialCardView.java */
    public interface InterfaceC0207a {
    }

    private void d() {
        if (Build.VERSION.SDK_INT > 26) {
            throw null;
        }
    }

    @NonNull
    private RectF getBoundsAsRectF() {
        new RectF();
        throw null;
    }

    public boolean e() {
        return false;
    }

    public boolean f() {
        return this.f9010c;
    }

    @Override // androidx.cardview.widget.CardView
    @NonNull
    public ColorStateList getCardBackgroundColor() {
        throw null;
    }

    @NonNull
    public ColorStateList getCardForegroundColor() {
        throw null;
    }

    float getCardViewRadius() {
        return super.getRadius();
    }

    @Nullable
    public Drawable getCheckedIcon() {
        throw null;
    }

    public int getCheckedIconGravity() {
        throw null;
    }

    @Dimension
    public int getCheckedIconMargin() {
        throw null;
    }

    @Dimension
    public int getCheckedIconSize() {
        throw null;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        throw null;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        throw null;
    }

    public ColorStateList getRippleColor() {
        throw null;
    }

    @NonNull
    public k getShapeAppearanceModel() {
        throw null;
    }

    @ColorInt
    @Deprecated
    public int getStrokeColor() {
        throw null;
    }

    @Nullable
    public ColorStateList getStrokeColorStateList() {
        throw null;
    }

    @Dimension
    public int getStrokeWidth() {
        throw null;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f9009b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 3);
        if (e()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f9004d);
        }
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f9005e);
        }
        if (f()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f9006f);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(e());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        getMeasuredWidth();
        getMeasuredHeight();
        throw null;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f9008a) {
            throw null;
        }
    }

    void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@ColorInt int i10) {
        ColorStateList.valueOf(i10);
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f10) {
        super.setCardElevation(f10);
        throw null;
    }

    public void setCardForegroundColor(@Nullable ColorStateList colorStateList) {
        throw null;
    }

    public void setCheckable(boolean z10) {
        throw null;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        if (this.f9009b != z10) {
            toggle();
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        throw null;
    }

    public void setCheckedIconGravity(int i10) {
        throw null;
    }

    public void setCheckedIconMargin(@Dimension int i10) {
        throw null;
    }

    public void setCheckedIconMarginResource(@DimenRes int i10) {
        if (i10 == -1) {
            return;
        }
        getResources().getDimensionPixelSize(i10);
        throw null;
    }

    public void setCheckedIconResource(@DrawableRes int i10) {
        AppCompatResources.getDrawable(getContext(), i10);
        throw null;
    }

    public void setCheckedIconSize(@Dimension int i10) {
        throw null;
    }

    public void setCheckedIconSizeResource(@DimenRes int i10) {
        if (i10 == 0) {
            return;
        }
        getResources().getDimensionPixelSize(i10);
        throw null;
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        throw null;
    }

    @Override // android.view.View
    public void setClickable(boolean z10) {
        super.setClickable(z10);
    }

    @Override // androidx.cardview.widget.CardView
    public void setContentPadding(int i10, int i11, int i12, int i13) {
        throw null;
    }

    public void setDragged(boolean z10) {
        if (this.f9010c != z10) {
            this.f9010c = z10;
            refreshDrawableState();
            d();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f10) {
        super.setMaxCardElevation(f10);
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z10) {
        super.setPreventCornerOverlap(z10);
        throw null;
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f10) {
        super.setRadius(f10);
        throw null;
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        throw null;
    }

    public void setRippleColorResource(@ColorRes int i10) {
        AppCompatResources.getColorStateList(getContext(), i10);
        throw null;
    }

    @Override // x4.n
    public void setShapeAppearanceModel(@NonNull k kVar) {
        setClipToOutline(kVar.u(getBoundsAsRectF()));
        throw null;
    }

    public void setStrokeColor(@ColorInt int i10) {
        setStrokeColor(ColorStateList.valueOf(i10));
    }

    public void setStrokeWidth(@Dimension int i10) {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z10) {
        super.setUseCompatPadding(z10);
        throw null;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (e() && isEnabled()) {
            this.f9009b = !this.f9009b;
            refreshDrawableState();
            d();
            throw null;
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        throw null;
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        throw null;
    }

    public void setOnCheckedChangeListener(@Nullable InterfaceC0207a interfaceC0207a) {
    }
}
