package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.p;
import com.google.android.material.internal.s;
import e4.j;
import java.util.Iterator;
import java.util.LinkedHashSet;
import x4.h;
import x4.k;
import x4.n;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialButton extends AppCompatButton implements Checkable, n {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int[] f8945o = {R.attr.state_checkable};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int[] f8946p = {R.attr.state_checked};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f8947q = j.f24907m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final com.google.android.material.button.a f8948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    private final LinkedHashSet<a> f8949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private b f8950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private PorterDuff.Mode f8951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private ColorStateList f8952e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private Drawable f8953f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private String f8954g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Px
    private int f8955h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Px
    private int f8956i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Px
    private int f8957j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Px
    private int f8958k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f8959l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f8960m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f8961n;

    public interface a {
        void a(MaterialButton materialButton, boolean z10);
    }

    interface b {
        void a(MaterialButton materialButton, boolean z10);
    }

    static class c extends AbsSavedState {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f8962a;

        class a implements Parcelable.ClassLoaderCreator<c> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(@NonNull Parcel parcel) {
                return new c(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new c(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public c[] newArray(int i10) {
                return new c[i10];
            }
        }

        public c(Parcelable parcelable) {
            super(parcelable);
        }

        private void a(@NonNull Parcel parcel) {
            this.f8962a = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f8962a ? 1 : 0);
        }

        public c(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            a(parcel);
        }
    }

    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, e4.b.f24764u);
    }

    private boolean b() {
        int i10 = this.f8961n;
        return i10 == 3 || i10 == 4;
    }

    private boolean c() {
        int i10 = this.f8961n;
        return i10 == 1 || i10 == 2;
    }

    private boolean d() {
        int i10 = this.f8961n;
        return i10 == 16 || i10 == 32;
    }

    private boolean e() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    private boolean f() {
        com.google.android.material.button.a aVar = this.f8948a;
        return (aVar == null || aVar.o()) ? false : true;
    }

    private void g() {
        if (c()) {
            TextViewCompat.setCompoundDrawablesRelative(this, this.f8953f, null, null, null);
        } else if (b()) {
            TextViewCompat.setCompoundDrawablesRelative(this, null, null, this.f8953f, null);
        } else if (d()) {
            TextViewCompat.setCompoundDrawablesRelative(this, null, this.f8953f, null, null);
        }
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(string, 0, string.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float fMax = 0.0f;
        for (int i10 = 0; i10 < lineCount; i10++) {
            fMax = Math.max(fMax, getLayout().getLineWidth(i10));
        }
        return (int) Math.ceil(fMax);
    }

    private void h(boolean z10) {
        Drawable drawable = this.f8953f;
        boolean z11 = true;
        if (drawable != null) {
            Drawable drawableMutate = DrawableCompat.wrap(drawable).mutate();
            this.f8953f = drawableMutate;
            DrawableCompat.setTintList(drawableMutate, this.f8952e);
            PorterDuff.Mode mode = this.f8951d;
            if (mode != null) {
                DrawableCompat.setTintMode(this.f8953f, mode);
            }
            int intrinsicWidth = this.f8955h;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.f8953f.getIntrinsicWidth();
            }
            int intrinsicHeight = this.f8955h;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.f8953f.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f8953f;
            int i10 = this.f8956i;
            int i11 = this.f8957j;
            drawable2.setBounds(i10, i11, intrinsicWidth + i10, intrinsicHeight + i11);
            this.f8953f.setVisible(true, z10);
        }
        if (z10) {
            g();
            return;
        }
        Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this);
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        if ((!c() || drawable3 == this.f8953f) && ((!b() || drawable5 == this.f8953f) && (!d() || drawable4 == this.f8953f))) {
            z11 = false;
        }
        if (z11) {
            g();
        }
    }

    private void i(int i10, int i11) {
        if (this.f8953f == null || getLayout() == null) {
            return;
        }
        if (!c() && !b()) {
            if (d()) {
                this.f8956i = 0;
                if (this.f8961n == 16) {
                    this.f8957j = 0;
                    h(false);
                    return;
                }
                int intrinsicHeight = this.f8955h;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = this.f8953f.getIntrinsicHeight();
                }
                int iMax = Math.max(0, (((((i11 - getTextHeight()) - getPaddingTop()) - intrinsicHeight) - this.f8958k) - getPaddingBottom()) / 2);
                if (this.f8957j != iMax) {
                    this.f8957j = iMax;
                    h(false);
                    return;
                }
                return;
            }
            return;
        }
        this.f8957j = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i12 = this.f8961n;
        if (i12 == 1 || i12 == 3 || ((i12 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i12 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.f8956i = 0;
            h(false);
            return;
        }
        int intrinsicWidth = this.f8955h;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.f8953f.getIntrinsicWidth();
        }
        int textLayoutWidth = ((((i10 - getTextLayoutWidth()) - ViewCompat.getPaddingEnd(this)) - intrinsicWidth) - this.f8958k) - ViewCompat.getPaddingStart(this);
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            textLayoutWidth /= 2;
        }
        if (e() != (this.f8961n == 4)) {
            textLayoutWidth = -textLayoutWidth;
        }
        if (this.f8956i != textLayoutWidth) {
            this.f8956i = textLayoutWidth;
            h(false);
        }
    }

    public boolean a() {
        com.google.android.material.button.a aVar = this.f8948a;
        return aVar != null && aVar.p();
    }

    @NonNull
    String getA11yClassName() {
        if (TextUtils.isEmpty(this.f8954g)) {
            return (a() ? CompoundButton.class : Button.class).getName();
        }
        return this.f8954g;
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @Px
    public int getCornerRadius() {
        if (f()) {
            return this.f8948a.b();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f8953f;
    }

    public int getIconGravity() {
        return this.f8961n;
    }

    @Px
    public int getIconPadding() {
        return this.f8958k;
    }

    @Px
    public int getIconSize() {
        return this.f8955h;
    }

    public ColorStateList getIconTint() {
        return this.f8952e;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f8951d;
    }

    @Dimension
    public int getInsetBottom() {
        return this.f8948a.c();
    }

    @Dimension
    public int getInsetTop() {
        return this.f8948a.d();
    }

    @Nullable
    public ColorStateList getRippleColor() {
        if (f()) {
            return this.f8948a.h();
        }
        return null;
    }

    @NonNull
    public k getShapeAppearanceModel() {
        if (f()) {
            return this.f8948a.i();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (f()) {
            return this.f8948a.j();
        }
        return null;
    }

    @Px
    public int getStrokeWidth() {
        if (f()) {
            return this.f8948a.k();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        return f() ? this.f8948a.l() : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return f() ? this.f8948a.m() : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f8959l;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (f()) {
            h.f(this, this.f8948a.f());
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (a()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f8945o);
        }
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f8946p);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(a());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        setChecked(cVar.f8962a);
    }

    @Override // android.widget.TextView, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.f8962a = this.f8959l;
        return cVar;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.f8948a.q()) {
            toggle();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f8953f != null) {
            if (this.f8953f.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    void setA11yClassName(@Nullable String str) {
        this.f8954g = str;
    }

    @Override // android.view.View
    public void setBackground(@NonNull Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i10) {
        if (f()) {
            this.f8948a.s(i10);
        } else {
            super.setBackgroundColor(i10);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(@NonNull Drawable drawable) {
        if (!f()) {
            super.setBackgroundDrawable(drawable);
        } else {
            if (drawable == getBackground()) {
                getBackground().setState(drawable.getState());
                return;
            }
            Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
            this.f8948a.t();
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(@DrawableRes int i10) {
        setBackgroundDrawable(i10 != 0 ? AppCompatResources.getDrawable(getContext(), i10) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z10) {
        if (f()) {
            this.f8948a.u(z10);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        if (a() && isEnabled() && this.f8959l != z10) {
            this.f8959l = z10;
            refreshDrawableState();
            if (getParent() instanceof MaterialButtonToggleGroup) {
                ((MaterialButtonToggleGroup) getParent()).m(this, this.f8959l);
            }
            if (this.f8960m) {
                return;
            }
            this.f8960m = true;
            Iterator<a> it = this.f8949b.iterator();
            while (it.hasNext()) {
                it.next().a(this, this.f8959l);
            }
            this.f8960m = false;
        }
    }

    public void setCornerRadius(@Px int i10) {
        if (f()) {
            this.f8948a.v(i10);
        }
    }

    public void setCornerRadiusResource(@DimenRes int i10) {
        if (f()) {
            setCornerRadius(getResources().getDimensionPixelSize(i10));
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f10) {
        super.setElevation(f10);
        if (f()) {
            this.f8948a.f().X(f10);
        }
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (this.f8953f != drawable) {
            this.f8953f = drawable;
            h(true);
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i10) {
        if (this.f8961n != i10) {
            this.f8961n = i10;
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(@Px int i10) {
        if (this.f8958k != i10) {
            this.f8958k = i10;
            setCompoundDrawablePadding(i10);
        }
    }

    public void setIconResource(@DrawableRes int i10) {
        setIcon(i10 != 0 ? AppCompatResources.getDrawable(getContext(), i10) : null);
    }

    public void setIconSize(@Px int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f8955h != i10) {
            this.f8955h = i10;
            h(true);
        }
    }

    public void setIconTint(@Nullable ColorStateList colorStateList) {
        if (this.f8952e != colorStateList) {
            this.f8952e = colorStateList;
            h(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f8951d != mode) {
            this.f8951d = mode;
            h(false);
        }
    }

    public void setIconTintResource(@ColorRes int i10) {
        setIconTint(AppCompatResources.getColorStateList(getContext(), i10));
    }

    public void setInsetBottom(@Dimension int i10) {
        this.f8948a.w(i10);
    }

    public void setInsetTop(@Dimension int i10) {
        this.f8948a.x(i10);
    }

    void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    void setOnPressedChangeListenerInternal(@Nullable b bVar) {
        this.f8950c = bVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z10) {
        b bVar = this.f8950c;
        if (bVar != null) {
            bVar.a(this, z10);
        }
        super.setPressed(z10);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (f()) {
            this.f8948a.y(colorStateList);
        }
    }

    public void setRippleColorResource(@ColorRes int i10) {
        if (f()) {
            setRippleColor(AppCompatResources.getColorStateList(getContext(), i10));
        }
    }

    @Override // x4.n
    public void setShapeAppearanceModel(@NonNull k kVar) {
        if (!f()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.f8948a.z(kVar);
    }

    void setShouldDrawSurfaceColorStroke(boolean z10) {
        if (f()) {
            this.f8948a.A(z10);
        }
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        if (f()) {
            this.f8948a.B(colorStateList);
        }
    }

    public void setStrokeColorResource(@ColorRes int i10) {
        if (f()) {
            setStrokeColor(AppCompatResources.getColorStateList(getContext(), i10));
        }
    }

    public void setStrokeWidth(@Px int i10) {
        if (f()) {
            this.f8948a.C(i10);
        }
    }

    public void setStrokeWidthResource(@DimenRes int i10) {
        if (f()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i10));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (f()) {
            this.f8948a.D(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (f()) {
            this.f8948a.E(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.view.View
    @RequiresApi(17)
    public void setTextAlignment(int i10) {
        super.setTextAlignment(i10);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z10) {
        this.f8948a.F(z10);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f8959l);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        int i11 = f8947q;
        super(b5.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        this.f8949b = new LinkedHashSet<>();
        this.f8959l = false;
        this.f8960m = false;
        Context context2 = getContext();
        TypedArray typedArrayI = p.i(context2, attributeSet, e4.k.f24945d2, i10, i11, new int[0]);
        this.f8958k = typedArrayI.getDimensionPixelSize(e4.k.f25049q2, 0);
        this.f8951d = s.i(typedArrayI.getInt(e4.k.f25073t2, -1), PorterDuff.Mode.SRC_IN);
        this.f8952e = u4.c.a(getContext(), typedArrayI, e4.k.f25065s2);
        this.f8953f = u4.c.d(getContext(), typedArrayI, e4.k.f25033o2);
        this.f8961n = typedArrayI.getInteger(e4.k.f25041p2, 1);
        this.f8955h = typedArrayI.getDimensionPixelSize(e4.k.f25057r2, 0);
        com.google.android.material.button.a aVar = new com.google.android.material.button.a(this, k.e(context2, attributeSet, i10, i11).m());
        this.f8948a = aVar;
        aVar.r(typedArrayI);
        typedArrayI.recycle();
        setCompoundDrawablePadding(this.f8958k);
        h(this.f8953f != null);
    }
}
