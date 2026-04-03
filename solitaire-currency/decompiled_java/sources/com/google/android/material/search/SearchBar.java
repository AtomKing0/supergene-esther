package com.google.android.material.search;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.q;
import e4.b;
import e4.d;
import e4.e;
import e4.j;
import x4.g;
import x4.h;

/* JADX INFO: loaded from: classes3.dex */
public class SearchBar extends Toolbar {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f9500m = j.f24903i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView f9501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f9502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f9503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Drawable f9504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f9505e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f9506f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private View f9507g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private Integer f9508h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private Drawable f9509i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f9510j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f9511k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private g f9512l;

    static class a extends AbsSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0215a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f9514a;

        /* JADX INFO: renamed from: com.google.android.material.search.SearchBar$a$a, reason: collision with other inner class name */
        class C0215a implements Parcelable.ClassLoaderCreator<a> {
            C0215a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new a(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public a[] newArray(int i10) {
                return new a[i10];
            }
        }

        public a(Parcel parcel) {
            this(parcel, null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f9514a);
        }

        public a(Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f9514a = parcel.readString();
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    private int a(int i10, int i11) {
        return i10 == 0 ? i11 : i10;
    }

    private void b() {
        View view = this.f9507g;
        if (view == null) {
            return;
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredWidth2 = (getMeasuredWidth() / 2) - (measuredWidth / 2);
        int i10 = measuredWidth2 + measuredWidth;
        int measuredHeight = this.f9507g.getMeasuredHeight();
        int measuredHeight2 = (getMeasuredHeight() / 2) - (measuredHeight / 2);
        c(this.f9507g, measuredWidth2, measuredHeight2, i10, measuredHeight2 + measuredHeight);
    }

    private void c(View view, int i10, int i11, int i12, int i13) {
        if (ViewCompat.getLayoutDirection(this) == 1) {
            view.layout(getMeasuredWidth() - i12, i11, getMeasuredWidth() - i10, i13);
        } else {
            view.layout(i10, i11, i12, i13);
        }
    }

    @Nullable
    private Drawable d(@Nullable Drawable drawable) {
        int iD;
        if (!this.f9505e || drawable == null) {
            return drawable;
        }
        Integer num = this.f9508h;
        if (num != null) {
            iD = num.intValue();
        } else {
            iD = n4.a.d(this, drawable == this.f9504d ? b.f24753j : b.f24752i);
        }
        Drawable drawableWrap = DrawableCompat.wrap(drawable.mutate());
        DrawableCompat.setTint(drawableWrap, iD);
        return drawableWrap;
    }

    private void e(int i10, int i11) {
        View view = this.f9507g;
        if (view != null) {
            view.measure(i10, i11);
        }
    }

    private void f() {
        if (this.f9503c && (getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            Resources resources = getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(d.f24800s);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(getDefaultMarginVerticalResource());
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            marginLayoutParams.leftMargin = a(marginLayoutParams.leftMargin, dimensionPixelSize);
            marginLayoutParams.topMargin = a(marginLayoutParams.topMargin, dimensionPixelSize2);
            marginLayoutParams.rightMargin = a(marginLayoutParams.rightMargin, dimensionPixelSize);
            marginLayoutParams.bottomMargin = a(marginLayoutParams.bottomMargin, dimensionPixelSize2);
        }
    }

    private void g() {
        if (Build.VERSION.SDK_INT < 34) {
            return;
        }
        boolean z10 = getLayoutDirection() == 1;
        ImageButton imageButtonD = q.d(this);
        int width = (imageButtonD == null || !imageButtonD.isClickable()) ? 0 : z10 ? getWidth() - imageButtonD.getLeft() : imageButtonD.getRight();
        ActionMenuView actionMenuViewA = q.a(this);
        int right = actionMenuViewA != null ? z10 ? actionMenuViewA.getRight() : getWidth() - actionMenuViewA.getLeft() : 0;
        float f10 = -(z10 ? right : width);
        if (!z10) {
            width = right;
        }
        setHandwritingBoundsOffsets(f10, 0.0f, -width, 0.0f);
    }

    private void h() {
        if (getLayoutParams() instanceof AppBarLayout.d) {
            AppBarLayout.d dVar = (AppBarLayout.d) getLayoutParams();
            if (this.f9511k) {
                if (dVar.c() == 0) {
                    dVar.g(53);
                }
            } else if (dVar.c() == 53) {
                dVar.g(0);
            }
        }
    }

    private void setNavigationIconDecorative(boolean z10) {
        ImageButton imageButtonD = q.d(this);
        if (imageButtonD == null) {
            return;
        }
        imageButtonD.setClickable(!z10);
        imageButtonD.setFocusable(!z10);
        Drawable background = imageButtonD.getBackground();
        if (background != null) {
            this.f9509i = background;
        }
        imageButtonD.setBackgroundDrawable(z10 ? null : this.f9509i);
        g();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (this.f9502b && this.f9507g == null && !(view instanceof ActionMenuView)) {
            this.f9507g = view;
            view.setAlpha(0.0f);
        }
        super.addView(view, i10, layoutParams);
    }

    @Nullable
    public View getCenterView() {
        return this.f9507g;
    }

    float getCompatElevation() {
        g gVar = this.f9512l;
        return gVar != null ? gVar.u() : ViewCompat.getElevation(this);
    }

    public float getCornerSize() {
        return this.f9512l.H();
    }

    @DimenRes
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int getDefaultMarginVerticalResource() {
        return d.f24801t;
    }

    @DrawableRes
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int getDefaultNavigationIconResource() {
        return e.f24810c;
    }

    @Nullable
    public CharSequence getHint() {
        return this.f9501a.getHint();
    }

    int getMenuResId() {
        return this.f9510j;
    }

    @ColorInt
    public int getStrokeColor() {
        return this.f9512l.D().getDefaultColor();
    }

    @Dimension
    public float getStrokeWidth() {
        return this.f9512l.F();
    }

    @NonNull
    public CharSequence getText() {
        return this.f9501a.getText();
    }

    @NonNull
    public TextView getTextView() {
        return this.f9501a;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void inflateMenu(@MenuRes int i10) {
        Menu menu = getMenu();
        boolean z10 = menu instanceof MenuBuilder;
        if (z10) {
            ((MenuBuilder) menu).stopDispatchingItemsChanged();
        }
        super.inflateMenu(i10);
        this.f9510j = i10;
        if (z10) {
            ((MenuBuilder) menu).startDispatchingItemsChanged();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.f(this, this.f9512l);
        f();
        h();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(EditText.class.getCanonicalName());
        int i10 = Build.VERSION.SDK_INT;
        accessibilityNodeInfo.setEditable(isEnabled());
        CharSequence text = getText();
        boolean zIsEmpty = TextUtils.isEmpty(text);
        if (i10 >= 26) {
            accessibilityNodeInfo.setHintText(getHint());
            accessibilityNodeInfo.setShowingHintText(zIsEmpty);
        }
        if (zIsEmpty) {
            text = getHint();
        }
        accessibilityNodeInfo.setText(text);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        b();
        g();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        e(i10, i11);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.getSuperState());
        setText(aVar.f9514a);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    @NonNull
    protected Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        CharSequence text = getText();
        aVar.f9514a = text == null ? null : text.toString();
        return aVar;
    }

    public void setCenterView(@Nullable View view) {
        View view2 = this.f9507g;
        if (view2 != null) {
            removeView(view2);
            this.f9507g = null;
        }
        if (view != null) {
            addView(view);
        }
    }

    public void setDefaultScrollFlagsEnabled(boolean z10) {
        this.f9511k = z10;
        h();
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f10) {
        super.setElevation(f10);
        g gVar = this.f9512l;
        if (gVar != null) {
            gVar.X(f10);
        }
    }

    public void setHint(@Nullable CharSequence charSequence) {
        this.f9501a.setHint(charSequence);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@Nullable Drawable drawable) {
        super.setNavigationIcon(d(drawable));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        if (this.f9506f) {
            return;
        }
        super.setNavigationOnClickListener(onClickListener);
        setNavigationIconDecorative(onClickListener == null);
    }

    public void setOnLoadAnimationFadeInEnabled(boolean z10) {
        throw null;
    }

    public void setStrokeColor(@ColorInt int i10) {
        if (getStrokeColor() != i10) {
            this.f9512l.e0(ColorStateList.valueOf(i10));
        }
    }

    public void setStrokeWidth(@Dimension float f10) {
        if (getStrokeWidth() != f10) {
            this.f9512l.f0(f10);
        }
    }

    public void setText(@Nullable CharSequence charSequence) {
        this.f9501a.setText(charSequence);
    }

    public static class ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f9513h;

        public ScrollingViewBehavior() {
            this.f9513h = false;
        }

        private void u(AppBarLayout appBarLayout) {
            appBarLayout.setBackgroundColor(0);
            appBarLayout.setTargetElevation(0.0f);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            boolean zOnDependentViewChanged = super.onDependentViewChanged(coordinatorLayout, view, view2);
            if (!this.f9513h && (view2 instanceof AppBarLayout)) {
                this.f9513h = true;
                u((AppBarLayout) view2);
            }
            return zOnDependentViewChanged;
        }

        @Override // com.google.android.material.appbar.b
        protected boolean p() {
            return true;
        }

        public ScrollingViewBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f9513h = false;
        }
    }

    public void setHint(@StringRes int i10) {
        this.f9501a.setHint(i10);
    }

    public void setText(@StringRes int i10) {
        this.f9501a.setText(i10);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }
}
