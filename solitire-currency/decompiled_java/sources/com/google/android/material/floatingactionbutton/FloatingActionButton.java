package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimatorRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TintableImageSourceView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.a;
import com.google.android.material.internal.t;
import e4.j;
import f4.h;
import f4.k;
import java.util.List;
import x4.n;

/* JADX INFO: loaded from: classes3.dex */
public class FloatingActionButton extends t implements TintableBackgroundView, TintableImageSourceView, q4.a, n, CoordinatorLayout.AttachedBehavior {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f9296p = j.f24900f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private ColorStateList f9297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private PorterDuff.Mode f9298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private ColorStateList f9299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private PorterDuff.Mode f9300e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private ColorStateList f9301f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f9302g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f9303h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f9304i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f9305j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f9306k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final Rect f9307l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Rect f9308m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    private final AppCompatImageHelper f9309n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private com.google.android.material.floatingactionbutton.a f9310o;

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* JADX INFO: renamed from: e */
        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* JADX INFO: renamed from: h */
        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, View view) {
            return super.onDependentViewChanged(coordinatorLayout, floatingActionButton, view);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* JADX INFO: renamed from: i */
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, int i10) {
            return super.onLayoutChild(coordinatorLayout, floatingActionButton, i10);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            super.onAttachedToLayoutParams(layoutParams);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    class a implements a.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f9314a;

        a(b bVar) {
            this.f9314a = bVar;
        }

        @Override // com.google.android.material.floatingactionbutton.a.k
        public void a() {
            this.f9314a.b(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.a.k
        public void b() {
            this.f9314a.a(FloatingActionButton.this);
        }
    }

    private class c implements w4.b {
        c() {
        }

        @Override // w4.b
        public boolean a() {
            return FloatingActionButton.this.f9306k;
        }

        @Override // w4.b
        public void setBackgroundDrawable(@Nullable Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }

        @Override // w4.b
        public void setShadowPadding(int i10, int i11, int i12, int i13) {
            FloatingActionButton.this.f9307l.set(i10, i11, i12, i13);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i10 + floatingActionButton.f9304i, i11 + FloatingActionButton.this.f9304i, i12 + FloatingActionButton.this.f9304i, i13 + FloatingActionButton.this.f9304i);
        }
    }

    class d<T extends FloatingActionButton> implements a.j {
        d(@NonNull k<T> kVar) {
        }

        @Override // com.google.android.material.floatingactionbutton.a.j
        public void a() {
            throw null;
        }

        @Override // com.google.android.material.floatingactionbutton.a.j
        public void b() {
            throw null;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof d)) {
                return false;
            }
            ((d) obj).getClass();
            throw null;
        }

        public int hashCode() {
            throw null;
        }
    }

    private com.google.android.material.floatingactionbutton.a getImpl() {
        if (this.f9310o == null) {
            this.f9310o = h();
        }
        return this.f9310o;
    }

    @NonNull
    private com.google.android.material.floatingactionbutton.a h() {
        return new com.google.android.material.floatingactionbutton.b(this, new c());
    }

    private int k(int i10) {
        int i11 = this.f9303h;
        if (i11 != 0) {
            return i11;
        }
        Resources resources = getResources();
        return i10 != -1 ? i10 != 1 ? resources.getDimensionPixelSize(e4.d.f24780c) : resources.getDimensionPixelSize(e4.d.f24778b) : Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? k(1) : k(0);
    }

    private void l(@NonNull Rect rect) {
        j(rect);
        int i10 = -this.f9310o.v();
        rect.inset(i10, i10);
    }

    private void q(@NonNull Rect rect) {
        int i10 = rect.left;
        Rect rect2 = this.f9307l;
        rect.left = i10 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    private void r() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f9299d;
        if (colorStateList == null) {
            DrawableCompat.clearColorFilter(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f9300e;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(colorForState, mode));
    }

    @Nullable
    private a.k u(@Nullable b bVar) {
        if (bVar == null) {
            return null;
        }
        return new a(bVar);
    }

    @Override // q4.a
    public boolean a() {
        throw null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().D(getDrawableState());
    }

    public void e(@NonNull Animator.AnimatorListener animatorListener) {
        getImpl().e(animatorListener);
    }

    public void f(@NonNull Animator.AnimatorListener animatorListener) {
        getImpl().f(animatorListener);
    }

    public void g(@NonNull k<? extends FloatingActionButton> kVar) {
        getImpl().g(new d(kVar));
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return this.f9297b;
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f9298c;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().m();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().p();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().s();
    }

    @Nullable
    public Drawable getContentBackground() {
        return getImpl().l();
    }

    @Px
    public int getCustomSize() {
        return this.f9303h;
    }

    public int getExpandedComponentIdHint() {
        throw null;
    }

    @Nullable
    public h getHideMotionSpec() {
        return getImpl().o();
    }

    @ColorInt
    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f9301f;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    @Nullable
    public ColorStateList getRippleColorStateList() {
        return this.f9301f;
    }

    @NonNull
    public x4.k getShapeAppearanceModel() {
        return (x4.k) Preconditions.checkNotNull(getImpl().t());
    }

    @Nullable
    public h getShowMotionSpec() {
        return getImpl().u();
    }

    public int getSize() {
        return this.f9302g;
    }

    int getSizeDimension() {
        return k(this.f9302g);
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    public ColorStateList getSupportImageTintList() {
        return this.f9299d;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f9300e;
    }

    public boolean getUseCompatPadding() {
        return this.f9306k;
    }

    @Deprecated
    public boolean i(@NonNull Rect rect) {
        if (!ViewCompat.isLaidOut(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        q(rect);
        return true;
    }

    public void j(@NonNull Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        q(rect);
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().z();
    }

    public void m(@Nullable b bVar) {
        n(bVar, true);
    }

    void n(@Nullable b bVar, boolean z10) {
        getImpl().w(u(bVar), z10);
    }

    public boolean o() {
        return getImpl().x();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().A();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().C();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i10, int i11) {
        int sizeDimension = getSizeDimension();
        this.f9304i = (sizeDimension - this.f9305j) / 2;
        getImpl().d0();
        int iMin = Math.min(View.resolveSize(sizeDimension, i10), View.resolveSize(sizeDimension, i11));
        Rect rect = this.f9307l;
        setMeasuredDimension(rect.left + iMin + rect.right, iMin + rect.top + rect.bottom);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof z4.a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        z4.a aVar = (z4.a) parcelable;
        super.onRestoreInstanceState(aVar.getSuperState());
        throw null;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = new Bundle();
        }
        new z4.a(parcelableOnSaveInstanceState);
        throw null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            l(this.f9308m);
            if (!this.f9308m.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean p() {
        return getImpl().y();
    }

    public void s(@Nullable b bVar) {
        t(bVar, true);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.f9297b != colorStateList) {
            this.f9297b = colorStateList;
            getImpl().K(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f9298c != mode) {
            this.f9298c = mode;
            getImpl().L(mode);
        }
    }

    public void setCompatElevation(float f10) {
        getImpl().M(f10);
    }

    public void setCompatElevationResource(@DimenRes int i10) {
        setCompatElevation(getResources().getDimension(i10));
    }

    public void setCompatHoveredFocusedTranslationZ(float f10) {
        getImpl().P(f10);
    }

    public void setCompatHoveredFocusedTranslationZResource(@DimenRes int i10) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i10));
    }

    public void setCompatPressedTranslationZ(float f10) {
        getImpl().S(f10);
    }

    public void setCompatPressedTranslationZResource(@DimenRes int i10) {
        setCompatPressedTranslationZ(getResources().getDimension(i10));
    }

    public void setCustomSize(@Px int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (i10 != this.f9303h) {
            this.f9303h = i10;
            requestLayout();
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f10) {
        super.setElevation(f10);
        getImpl().e0(f10);
    }

    public void setEnsureMinTouchTargetSize(boolean z10) {
        if (z10 != getImpl().n()) {
            getImpl().N(z10);
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(@IdRes int i10) {
        throw null;
    }

    public void setHideMotionSpec(@Nullable h hVar) {
        getImpl().O(hVar);
    }

    public void setHideMotionSpecResource(@AnimatorRes int i10) {
        setHideMotionSpec(h.c(getContext(), i10));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().c0();
            if (this.f9299d != null) {
                r();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int i10) {
        this.f9309n.setImageResource(i10);
        r();
    }

    public void setMaxImageSize(int i10) {
        this.f9305j = i10;
        getImpl().R(i10);
    }

    public void setRippleColor(@ColorInt int i10) {
        setRippleColor(ColorStateList.valueOf(i10));
    }

    @Override // android.view.View
    public void setScaleX(float f10) {
        super.setScaleX(f10);
        getImpl().H();
    }

    @Override // android.view.View
    public void setScaleY(float f10) {
        super.setScaleY(f10);
        getImpl().H();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setShadowPaddingEnabled(boolean z10) {
        getImpl().U(z10);
    }

    @Override // x4.n
    public void setShapeAppearanceModel(@NonNull x4.k kVar) {
        getImpl().V(kVar);
    }

    public void setShowMotionSpec(@Nullable h hVar) {
        getImpl().W(hVar);
    }

    public void setShowMotionSpecResource(@AnimatorRes int i10) {
        setShowMotionSpec(h.c(getContext(), i10));
    }

    public void setSize(int i10) {
        this.f9303h = 0;
        if (i10 != this.f9302g) {
            this.f9302g = i10;
            requestLayout();
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintList(@Nullable ColorStateList colorStateList) {
        if (this.f9299d != colorStateList) {
            this.f9299d = colorStateList;
            r();
        }
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f9300e != mode) {
            this.f9300e = mode;
            r();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f10) {
        super.setTranslationX(f10);
        getImpl().I();
    }

    @Override // android.view.View
    public void setTranslationY(float f10) {
        super.setTranslationY(f10);
        getImpl().I();
    }

    @Override // android.view.View
    public void setTranslationZ(float f10) {
        super.setTranslationZ(f10);
        getImpl().I();
    }

    public void setUseCompatPadding(boolean z10) {
        if (this.f9306k != z10) {
            this.f9306k = z10;
            getImpl().B();
        }
    }

    @Override // com.google.android.material.internal.t, android.widget.ImageView, android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    void t(@Nullable b bVar, boolean z10) {
        getImpl().a0(u(bVar), z10);
    }

    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Rect f9311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private b f9312b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f9313c;

        public BaseBehavior() {
            this.f9313c = true;
        }

        private static boolean f(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private void g(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton) {
            Rect rect = floatingActionButton.f9307l;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
            int i10 = 0;
            int i11 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin ? rect.right : floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin ? -rect.left : 0;
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) {
                i10 = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) {
                i10 = -rect.top;
            }
            if (i10 != 0) {
                ViewCompat.offsetTopAndBottom(floatingActionButton, i10);
            }
            if (i11 != 0) {
                ViewCompat.offsetLeftAndRight(floatingActionButton, i11);
            }
        }

        private boolean j(@NonNull View view, @NonNull FloatingActionButton floatingActionButton) {
            return this.f9313c && ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams()).getAnchorId() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        private boolean k(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull FloatingActionButton floatingActionButton) {
            if (!j(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f9311a == null) {
                this.f9311a = new Rect();
            }
            Rect rect = this.f9311a;
            com.google.android.material.internal.c.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.n(this.f9312b, false);
                return true;
            }
            floatingActionButton.t(this.f9312b, false);
            return true;
        }

        private boolean l(@NonNull View view, @NonNull FloatingActionButton floatingActionButton) {
            if (!j(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.n(this.f9312b, false);
                return true;
            }
            floatingActionButton.t(this.f9312b, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull Rect rect) {
            Rect rect2 = floatingActionButton.f9307l;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                k(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (!f(view)) {
                return false;
            }
            l(view, floatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, int i10) {
            List<View> dependencies = coordinatorLayout.getDependencies(floatingActionButton);
            int size = dependencies.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view = dependencies.get(i11);
                if (!(view instanceof AppBarLayout)) {
                    if (f(view) && l(view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (k(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(floatingActionButton, i10);
            g(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e4.k.f25080u1);
            this.f9313c = typedArrayObtainStyledAttributes.getBoolean(e4.k.f25088v1, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.f9301f != colorStateList) {
            this.f9301f = colorStateList;
            getImpl().T(this.f9301f);
        }
    }

    public static abstract class b {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }
}
