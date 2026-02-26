package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;

/* JADX INFO: compiled from: HeaderScrollingViewBehavior.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class b extends c<View> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Rect f8762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Rect f8763e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f8764f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f8765g;

    public b() {
        this.f8762d = new Rect();
        this.f8763e = new Rect();
        this.f8764f = 0;
    }

    private static int n(int i10) {
        if (i10 == 0) {
            return 8388659;
        }
        return i10;
    }

    @Override // com.google.android.material.appbar.c
    protected void f(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i10) {
        View viewH = h(coordinatorLayout.getDependencies(view));
        if (viewH == null) {
            super.f(coordinatorLayout, view, i10);
            this.f8764f = 0;
            return;
        }
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
        Rect rect = this.f8762d;
        rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, viewH.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((coordinatorLayout.getHeight() + viewH.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
        if (lastWindowInsets != null && ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(view)) {
            rect.left += lastWindowInsets.getSystemWindowInsetLeft();
            rect.right -= lastWindowInsets.getSystemWindowInsetRight();
        }
        Rect rect2 = this.f8763e;
        GravityCompat.apply(n(layoutParams.gravity), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i10);
        int i11 = i(viewH);
        view.layout(rect2.left, rect2.top - i11, rect2.right, rect2.bottom - i11);
        this.f8764f = rect2.top - viewH.getBottom();
    }

    @Nullable
    abstract View h(List<View> list);

    final int i(View view) {
        if (this.f8765g == 0) {
            return 0;
        }
        float fJ = j(view);
        int i10 = this.f8765g;
        return MathUtils.clamp((int) (fJ * i10), 0, i10);
    }

    float j(View view) {
        return 1.0f;
    }

    public final int k() {
        return this.f8765g;
    }

    int l(@NonNull View view) {
        return view.getMeasuredHeight();
    }

    final int m() {
        return this.f8764f;
    }

    public final void o(int i10) {
        this.f8765g = i10;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i10, int i11, int i12, int i13) {
        View viewH;
        WindowInsetsCompat lastWindowInsets;
        int i14 = view.getLayoutParams().height;
        if ((i14 != -1 && i14 != -2) || (viewH = h(coordinatorLayout.getDependencies(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i12);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (ViewCompat.getFitsSystemWindows(viewH) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.getSystemWindowInsetTop() + lastWindowInsets.getSystemWindowInsetBottom();
        }
        int iL = size + l(viewH);
        int measuredHeight = viewH.getMeasuredHeight();
        if (p()) {
            view.setTranslationY(-measuredHeight);
        } else {
            view.setTranslationY(0.0f);
            iL -= measuredHeight;
        }
        coordinatorLayout.onMeasureChild(view, i10, i11, View.MeasureSpec.makeMeasureSpec(iL, i14 == -1 ? 1073741824 : Integer.MIN_VALUE), i13);
        return true;
    }

    protected boolean p() {
        return false;
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8762d = new Rect();
        this.f8763e = new Rect();
        this.f8764f = 0;
    }
}
