package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import e4.j;
import e4.k;
import java.lang.ref.WeakReference;
import java.util.List;
import x4.g;
import x4.h;

/* JADX INFO: loaded from: classes3.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.AttachedBehavior {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int f8699y = j.f24898d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8703d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f8704e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f8705f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private WindowInsetsCompat f8706g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<a> f8707h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f8708i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f8709j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f8710k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f8711l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @IdRes
    private int f8712m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private WeakReference<View> f8713n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f8714o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private ValueAnimator f8715p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private ValueAnimator.AnimatorUpdateListener f8716q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final long f8717r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final TimeInterpolator f8718s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int[] f8719t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private Drawable f8720u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    private Integer f8721v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final float f8722w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Behavior f8723x;

    protected static class BaseBehavior<T extends AppBarLayout> extends com.google.android.material.appbar.a<T> {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f8724k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f8725l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private ValueAnimator f8726m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private c f8727n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        @Nullable
        private WeakReference<View> f8728o;

        class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f8729a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ AppBarLayout f8730b;

            a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.f8729a = coordinatorLayout;
                this.f8730b = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                BaseBehavior.this.p(this.f8729a, this.f8730b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        class b extends AccessibilityDelegateCompat {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AppBarLayout f8732a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f8733b;

            b(AppBarLayout appBarLayout, CoordinatorLayout coordinatorLayout) {
                this.f8732a = appBarLayout;
                this.f8733b = coordinatorLayout;
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                View viewF;
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
                if (this.f8732a.getTotalScrollRange() == 0 || (viewF = BaseBehavior.this.F(this.f8733b)) == null || !BaseBehavior.this.B(this.f8732a)) {
                    return;
                }
                if (BaseBehavior.this.m() != (-this.f8732a.getTotalScrollRange())) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    accessibilityNodeInfoCompat.setScrollable(true);
                }
                if (BaseBehavior.this.m() != 0) {
                    if (!viewF.canScrollVertically(-1)) {
                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                        accessibilityNodeInfoCompat.setScrollable(true);
                    } else if ((-this.f8732a.getDownNestedPreScrollRange()) != 0) {
                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                        accessibilityNodeInfoCompat.setScrollable(true);
                    }
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
                if (i10 == 4096) {
                    this.f8732a.setExpanded(false);
                    return true;
                }
                if (i10 != 8192) {
                    return super.performAccessibilityAction(view, i10, bundle);
                }
                if (BaseBehavior.this.m() != 0) {
                    View viewF = BaseBehavior.this.F(this.f8733b);
                    if (!viewF.canScrollVertically(-1)) {
                        this.f8732a.setExpanded(true);
                        return true;
                    }
                    int i11 = -this.f8732a.getDownNestedPreScrollRange();
                    if (i11 != 0) {
                        BaseBehavior.this.onNestedPreScroll(this.f8733b, this.f8732a, viewF, 0, i11, new int[]{0, 0}, 1);
                        return true;
                    }
                }
                return false;
            }
        }

        public BaseBehavior() {
        }

        private static boolean A(int i10, int i11) {
            return (i10 & i11) == i11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean B(AppBarLayout appBarLayout) {
            int childCount = appBarLayout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                if (((d) appBarLayout.getChildAt(i10).getLayoutParams()).f8742a != 0) {
                    return true;
                }
            }
            return false;
        }

        @Nullable
        private View C(@NonNull CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                if ((childAt instanceof NestedScrollingChild) || (childAt instanceof AbsListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        @Nullable
        private static View D(@NonNull AppBarLayout appBarLayout, int i10) {
            int iAbs = Math.abs(i10);
            int childCount = appBarLayout.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = appBarLayout.getChildAt(i11);
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private int E(@NonNull T t10, int i10) {
            int childCount = t10.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = t10.getChildAt(i11);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                d dVar = (d) childAt.getLayoutParams();
                if (A(dVar.c(), 32)) {
                    top -= ((LinearLayout.LayoutParams) dVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) dVar).bottomMargin;
                }
                int i12 = -i10;
                if (top <= i12 && bottom >= i12) {
                    return i11;
                }
            }
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public View F(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                if (((CoordinatorLayout.LayoutParams) childAt.getLayoutParams()).getBehavior() instanceof ScrollingViewBehavior) {
                    return childAt;
                }
            }
            return null;
        }

        private int I(@NonNull T t10, int i10) {
            int iAbs = Math.abs(i10);
            int childCount = t10.getChildCount();
            int topInset = 0;
            int i11 = 0;
            while (true) {
                if (i11 >= childCount) {
                    break;
                }
                View childAt = t10.getChildAt(i11);
                d dVar = (d) childAt.getLayoutParams();
                Interpolator interpolatorD = dVar.d();
                if (iAbs < childAt.getTop() || iAbs > childAt.getBottom()) {
                    i11++;
                } else if (interpolatorD != null) {
                    int iC = dVar.c();
                    if ((iC & 1) != 0) {
                        topInset = 0 + childAt.getHeight() + ((LinearLayout.LayoutParams) dVar).topMargin + ((LinearLayout.LayoutParams) dVar).bottomMargin;
                        if ((iC & 2) != 0) {
                            topInset -= ViewCompat.getMinimumHeight(childAt);
                        }
                    }
                    if (ViewCompat.getFitsSystemWindows(childAt)) {
                        topInset -= t10.getTopInset();
                    }
                    if (topInset > 0) {
                        float f10 = topInset;
                        return Integer.signum(i10) * (childAt.getTop() + Math.round(f10 * interpolatorD.getInterpolation((iAbs - childAt.getTop()) / f10)));
                    }
                }
            }
            return i10;
        }

        private boolean V(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t10) {
            List<View> dependents = coordinatorLayout.getDependents(t10);
            int size = dependents.size();
            for (int i10 = 0; i10 < size; i10++) {
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) dependents.get(i10).getLayoutParams()).getBehavior();
                if (behavior instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) behavior).k() != 0;
                }
            }
            return false;
        }

        private void W(CoordinatorLayout coordinatorLayout, @NonNull T t10) {
            int topInset = t10.getTopInset() + t10.getPaddingTop();
            int iM = m() - topInset;
            int iE = E(t10, iM);
            if (iE >= 0) {
                View childAt = t10.getChildAt(iE);
                d dVar = (d) childAt.getLayoutParams();
                int iC = dVar.c();
                if ((iC & 17) == 17) {
                    int topInset2 = -childAt.getTop();
                    int minimumHeight = -childAt.getBottom();
                    if (iE == 0 && ViewCompat.getFitsSystemWindows(t10) && ViewCompat.getFitsSystemWindows(childAt)) {
                        topInset2 -= t10.getTopInset();
                    }
                    if (A(iC, 2)) {
                        minimumHeight += ViewCompat.getMinimumHeight(childAt);
                    } else if (A(iC, 5)) {
                        int minimumHeight2 = ViewCompat.getMinimumHeight(childAt) + minimumHeight;
                        if (iM < minimumHeight2) {
                            topInset2 = minimumHeight2;
                        } else {
                            minimumHeight = minimumHeight2;
                        }
                    }
                    if (A(iC, 32)) {
                        topInset2 += ((LinearLayout.LayoutParams) dVar).topMargin;
                        minimumHeight -= ((LinearLayout.LayoutParams) dVar).bottomMargin;
                    }
                    v(coordinatorLayout, t10, MathUtils.clamp(x(iM, minimumHeight, topInset2) + topInset, -t10.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private void X(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t10, int i10, int i11, boolean z10) {
            View viewD = D(t10, i10);
            boolean zU = false;
            if (viewD != null) {
                int iC = ((d) viewD.getLayoutParams()).c();
                if ((iC & 1) != 0) {
                    int minimumHeight = ViewCompat.getMinimumHeight(viewD);
                    if (i11 <= 0 || (iC & 12) == 0 ? !((iC & 2) == 0 || (-i10) < (viewD.getBottom() - minimumHeight) - t10.getTopInset()) : (-i10) >= (viewD.getBottom() - minimumHeight) - t10.getTopInset()) {
                        zU = true;
                    }
                }
            }
            if (t10.k()) {
                zU = t10.u(C(coordinatorLayout));
            }
            boolean zR = t10.r(zU);
            if (z10 || (zR && V(coordinatorLayout, t10))) {
                if (t10.getBackground() != null) {
                    t10.getBackground().jumpToCurrentState();
                }
                if (t10.getForeground() != null) {
                    t10.getForeground().jumpToCurrentState();
                }
                if (t10.getStateListAnimator() != null) {
                    t10.getStateListAnimator().jumpToCurrentState();
                }
            }
        }

        private void u(CoordinatorLayout coordinatorLayout, @NonNull T t10) {
            if (ViewCompat.hasAccessibilityDelegate(coordinatorLayout)) {
                return;
            }
            ViewCompat.setAccessibilityDelegate(coordinatorLayout, new b(t10, coordinatorLayout));
        }

        private void v(CoordinatorLayout coordinatorLayout, @NonNull T t10, int i10, float f10) {
            int iAbs = Math.abs(m() - i10);
            float fAbs = Math.abs(f10);
            w(coordinatorLayout, t10, i10, fAbs > 0.0f ? Math.round((iAbs / fAbs) * 1000.0f) * 3 : (int) (((iAbs / t10.getHeight()) + 1.0f) * 150.0f));
        }

        private void w(CoordinatorLayout coordinatorLayout, T t10, int i10, int i11) {
            int iM = m();
            if (iM == i10) {
                ValueAnimator valueAnimator = this.f8726m;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.f8726m.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.f8726m;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f8726m = valueAnimator3;
                valueAnimator3.setInterpolator(f4.a.f25672e);
                this.f8726m.addUpdateListener(new a(coordinatorLayout, t10));
            } else {
                valueAnimator2.cancel();
            }
            this.f8726m.setDuration(Math.min(i11, 600));
            this.f8726m.setIntValues(iM, i10);
            this.f8726m.start();
        }

        private int x(int i10, int i11, int i12) {
            return i10 < (i11 + i12) / 2 ? i11 : i12;
        }

        private boolean z(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t10, @NonNull View view) {
            return t10.i() && coordinatorLayout.getHeight() - view.getHeight() <= t10.getHeight();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
        public int k(@NonNull T t10) {
            return (-t10.getDownNestedScrollRange()) + t10.getTopInset();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public int l(@NonNull T t10) {
            return t10.getTotalScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
        public void n(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t10) {
            W(coordinatorLayout, t10);
            if (t10.k()) {
                t10.r(t10.u(C(coordinatorLayout)));
            }
        }

        @Override // com.google.android.material.appbar.c, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t10, int i10) {
            boolean zOnLayoutChild = super.onLayoutChild(coordinatorLayout, t10, i10);
            int pendingAction = t10.getPendingAction();
            c cVar = this.f8727n;
            if (cVar == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z10 = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i11 = -t10.getUpNestedPreScrollRange();
                        if (z10) {
                            v(coordinatorLayout, t10, i11, 0.0f);
                        } else {
                            p(coordinatorLayout, t10, i11);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z10) {
                            v(coordinatorLayout, t10, 0, 0.0f);
                        } else {
                            p(coordinatorLayout, t10, 0);
                        }
                    }
                }
            } else if (cVar.f8735a) {
                p(coordinatorLayout, t10, -t10.getTotalScrollRange());
            } else if (cVar.f8736b) {
                p(coordinatorLayout, t10, 0);
            } else {
                View childAt = t10.getChildAt(cVar.f8737c);
                p(coordinatorLayout, t10, (-childAt.getBottom()) + (this.f8727n.f8739e ? ViewCompat.getMinimumHeight(childAt) + t10.getTopInset() : Math.round(childAt.getHeight() * this.f8727n.f8738d)));
            }
            t10.n();
            this.f8727n = null;
            g(MathUtils.clamp(e(), -t10.getTotalScrollRange(), 0));
            X(coordinatorLayout, t10, e(), 0, true);
            t10.m(e());
            u(coordinatorLayout, t10);
            return zOnLayoutChild;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
        public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t10, int i10, int i11, int i12, int i13) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) t10.getLayoutParams())).height != -2) {
                return super.onMeasureChild(coordinatorLayout, t10, i10, i11, i12, i13);
            }
            coordinatorLayout.onMeasureChild(t10, i10, i11, View.MeasureSpec.makeMeasureSpec(0, 0), i13);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, @NonNull T t10, View view, int i10, int i11, int[] iArr, int i12) {
            int i13;
            int downNestedPreScrollRange;
            if (i11 != 0) {
                if (i11 < 0) {
                    i13 = -t10.getTotalScrollRange();
                    downNestedPreScrollRange = t10.getDownNestedPreScrollRange() + i13;
                } else {
                    i13 = -t10.getUpNestedPreScrollRange();
                    downNestedPreScrollRange = 0;
                }
                int i14 = i13;
                int i15 = downNestedPreScrollRange;
                if (i14 != i15) {
                    iArr[1] = o(coordinatorLayout, t10, i11, i14, i15);
                }
            }
            if (t10.k()) {
                t10.r(t10.u(view));
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull T t10, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
            if (i13 < 0) {
                iArr[1] = o(coordinatorLayout, t10, i13, -t10.getDownNestedScrollRange(), 0);
            }
            if (i13 == 0) {
                u(coordinatorLayout, t10);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
        public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t10, Parcelable parcelable) {
            if (parcelable instanceof c) {
                S((c) parcelable, true);
                super.onRestoreInstanceState(coordinatorLayout, t10, this.f8727n.getSuperState());
            } else {
                super.onRestoreInstanceState(coordinatorLayout, t10, parcelable);
                this.f8727n = null;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
        public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t10) {
            Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, t10);
            c cVarT = T(parcelableOnSaveInstanceState, t10);
            return cVarT == null ? parcelableOnSaveInstanceState : cVarT;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t10, @NonNull View view, View view2, int i10, int i11) {
            ValueAnimator valueAnimator;
            boolean z10 = (i10 & 2) != 0 && (t10.k() || z(coordinatorLayout, t10, view));
            if (z10 && (valueAnimator = this.f8726m) != null) {
                valueAnimator.cancel();
            }
            this.f8728o = null;
            this.f8725l = i11;
            return z10;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull T t10, View view, int i10) {
            if (this.f8725l == 0 || i10 == 1) {
                W(coordinatorLayout, t10);
                if (t10.k()) {
                    t10.r(t10.u(view));
                }
            }
            this.f8728o = new WeakReference<>(view);
        }

        void S(@Nullable c cVar, boolean z10) {
            if (this.f8727n == null || z10) {
                this.f8727n = cVar;
            }
        }

        @Nullable
        c T(@Nullable Parcelable parcelable, @NonNull T t10) {
            int iE = e();
            int childCount = t10.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = t10.getChildAt(i10);
                int bottom = childAt.getBottom() + iE;
                if (childAt.getTop() + iE <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = AbsSavedState.EMPTY_STATE;
                    }
                    c cVar = new c(parcelable);
                    boolean z10 = iE == 0;
                    cVar.f8736b = z10;
                    cVar.f8735a = !z10 && (-iE) >= t10.getTotalScrollRange();
                    cVar.f8737c = i10;
                    cVar.f8739e = bottom == ViewCompat.getMinimumHeight(childAt) + t10.getTopInset();
                    cVar.f8738d = bottom / childAt.getHeight();
                    return cVar;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
        public int q(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t10, int i10, int i11, int i12) {
            int iM = m();
            int i13 = 0;
            if (i11 == 0 || iM < i11 || iM > i12) {
                this.f8724k = 0;
            } else {
                int iClamp = MathUtils.clamp(i10, i11, i12);
                if (iM != iClamp) {
                    int I = t10.g() ? I(t10, iClamp) : iClamp;
                    boolean zG = g(I);
                    int i14 = iM - iClamp;
                    this.f8724k = iClamp - I;
                    if (zG) {
                        while (i13 < t10.getChildCount()) {
                            d dVar = (d) t10.getChildAt(i13).getLayoutParams();
                            b bVarB = dVar.b();
                            if (bVarB != null && (dVar.c() & 1) != 0) {
                                bVarB.a(t10, t10.getChildAt(i13), e());
                            }
                            i13++;
                        }
                    }
                    if (!zG && t10.g()) {
                        coordinatorLayout.dispatchDependentViewsChanged(t10);
                    }
                    t10.m(e());
                    X(coordinatorLayout, t10, iClamp, iClamp < iM ? -1 : 1, false);
                    i13 = i14;
                }
            }
            u(coordinatorLayout, t10);
            return i13;
        }

        @Override // com.google.android.material.appbar.a
        int m() {
            return e() + this.f8724k;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
        public boolean h(T t10) {
            WeakReference<View> weakReference = this.f8728o;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        protected static class c extends AbsSavedState {
            public static final Parcelable.Creator<c> CREATOR = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            boolean f8735a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            boolean f8736b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f8737c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            float f8738d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            boolean f8739e;

            class a implements Parcelable.ClassLoaderCreator<c> {
                a() {
                }

                @Override // android.os.Parcelable.Creator
                @Nullable
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

            public c(@NonNull Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f8735a = parcel.readByte() != 0;
                this.f8736b = parcel.readByte() != 0;
                this.f8737c = parcel.readInt();
                this.f8738d = parcel.readFloat();
                this.f8739e = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(@NonNull Parcel parcel, int i10) {
                super.writeToParcel(parcel, i10);
                parcel.writeByte(this.f8735a ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.f8736b ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.f8737c);
                parcel.writeFloat(this.f8738d);
                parcel.writeByte(this.f8739e ? (byte) 1 : (byte) 0);
            }

            public c(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: K */
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i10) {
            return super.onLayoutChild(coordinatorLayout, appBarLayout, i10);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: L */
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i10, int i11, int i12, int i13) {
            return super.onMeasureChild(coordinatorLayout, appBarLayout, i10, i11, i12, i13);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: M */
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i10, int i11, int[] iArr, int i12) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i10, i11, iArr, i12);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: N */
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i10, i11, i12, i13, i14, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: O */
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, Parcelable parcelable) {
            super.onRestoreInstanceState(coordinatorLayout, appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: P */
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout) {
            return super.onSaveInstanceState(coordinatorLayout, appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: Q */
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, View view2, int i10, int i11) {
            return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i10, i11);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: R */
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i10) {
            super.onStopNestedScroll(coordinatorLayout, appBarLayout, view, i10);
        }

        @Override // com.google.android.material.appbar.c
        public /* bridge */ /* synthetic */ int e() {
            return super.e();
        }

        @Override // com.google.android.material.appbar.c
        public /* bridge */ /* synthetic */ boolean g(int i10) {
            return super.g(i10);
        }

        @Override // com.google.android.material.appbar.a, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.a, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            return super.onTouchEvent(coordinatorLayout, view, motionEvent);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class ScrollingViewBehavior extends com.google.android.material.appbar.b {
        public ScrollingViewBehavior() {
        }

        private static int r(@NonNull AppBarLayout appBarLayout) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                return ((BaseBehavior) behavior).m();
            }
            return 0;
        }

        private void s(@NonNull View view, @NonNull View view2) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) view2.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                ViewCompat.offsetTopAndBottom(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) behavior).f8724k) + m()) - i(view2));
            }
        }

        private void t(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.k()) {
                    appBarLayout.r(appBarLayout.u(view));
                }
            }
        }

        @Override // com.google.android.material.appbar.b
        float j(View view) {
            int i10;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int iR = r(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + iR > downNestedPreScrollRange) && (i10 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (iR / i10) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.b
        int l(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.l(view);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            s(view, view2);
            t(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onDependentViewRemoved(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            if (view2 instanceof AppBarLayout) {
                ViewCompat.setAccessibilityDelegate(coordinatorLayout, null);
            }
        }

        @Override // com.google.android.material.appbar.c, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i10) {
            return super.onLayoutChild(coordinatorLayout, view, i10);
        }

        @Override // com.google.android.material.appbar.b, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i10, int i11, int i12, int i13) {
            return super.onMeasureChild(coordinatorLayout, view, i10, i11, i12, i13);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect, boolean z10) {
            AppBarLayout appBarLayoutH = h(coordinatorLayout.getDependencies(view));
            if (appBarLayoutH != null) {
                Rect rect2 = new Rect(rect);
                rect2.offset(view.getLeft(), view.getTop());
                Rect rect3 = this.f8762d;
                rect3.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect3.contains(rect2)) {
                    appBarLayoutH.o(false, !z10);
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.b
        @Nullable
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public AppBarLayout h(@NonNull List<View> list) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = list.get(i10);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.f24979h4);
            o(typedArrayObtainStyledAttributes.getDimensionPixelSize(k.f24987i4, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public interface a<T extends AppBarLayout> {
        void a(T t10, int i10);
    }

    public static abstract class b {
        public abstract void a(@NonNull AppBarLayout appBarLayout, @NonNull View view, float f10);
    }

    public static class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Rect f8740a = new Rect();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Rect f8741b = new Rect();

        private static void b(Rect rect, AppBarLayout appBarLayout, View view) {
            view.getDrawingRect(rect);
            appBarLayout.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(0, -appBarLayout.getTopInset());
        }

        @Override // com.google.android.material.appbar.AppBarLayout.b
        public void a(@NonNull AppBarLayout appBarLayout, @NonNull View view, float f10) {
            b(this.f8740a, appBarLayout, view);
            float fAbs = this.f8740a.top - Math.abs(f10);
            if (fAbs > 0.0f) {
                ViewCompat.setClipBounds(view, null);
                view.setTranslationY(0.0f);
                view.setVisibility(0);
                return;
            }
            float fClamp = 1.0f - MathUtils.clamp(Math.abs(fAbs / this.f8740a.height()), 0.0f, 1.0f);
            float fHeight = (-fAbs) - ((this.f8740a.height() * 0.3f) * (1.0f - (fClamp * fClamp)));
            view.setTranslationY(fHeight);
            view.getDrawingRect(this.f8741b);
            this.f8741b.offset(0, (int) (-fHeight));
            if (fHeight >= this.f8741b.height()) {
                view.setVisibility(4);
            } else {
                view.setVisibility(0);
            }
            ViewCompat.setClipBounds(view, this.f8741b);
        }
    }

    private void a() {
        WeakReference<View> weakReference = this.f8713n;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f8713n = null;
    }

    @Nullable
    private Integer b() {
        Drawable drawable = this.f8720u;
        if (drawable instanceof g) {
            return Integer.valueOf(((g) drawable).y());
        }
        ColorStateList colorStateListF = com.google.android.material.drawable.b.f(drawable);
        if (colorStateListF != null) {
            return Integer.valueOf(colorStateListF.getDefaultColor());
        }
        return null;
    }

    @Nullable
    private View c(@Nullable View view) {
        int i10;
        if (this.f8713n == null && (i10 = this.f8712m) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i10) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.f8712m);
            }
            if (viewFindViewById != null) {
                this.f8713n = new WeakReference<>(viewFindViewById);
            }
        }
        WeakReference<View> weakReference = this.f8713n;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private boolean h() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (((d) getChildAt(i10).getLayoutParams()).e()) {
                return true;
            }
        }
        return false;
    }

    private void j() {
        Behavior behavior = this.f8723x;
        BaseBehavior.c cVarT = (behavior == null || this.f8701b == -1 || this.f8705f != 0) ? null : behavior.T(AbsSavedState.EMPTY_STATE, this);
        this.f8701b = -1;
        this.f8702c = -1;
        this.f8703d = -1;
        if (cVarT != null) {
            this.f8723x.S(cVarT, false);
        }
    }

    private boolean l() {
        return getBackground() instanceof g;
    }

    private void p(boolean z10, boolean z11, boolean z12) {
        this.f8705f = (z10 ? 1 : 2) | (z11 ? 4 : 0) | (z12 ? 8 : 0);
        requestLayout();
    }

    private boolean q(boolean z10) {
        if (this.f8709j == z10) {
            return false;
        }
        this.f8709j = z10;
        refreshDrawableState();
        return true;
    }

    private boolean t() {
        return this.f8720u != null && getTopInset() > 0;
    }

    private boolean v() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        return (childAt.getVisibility() == 8 || ViewCompat.getFitsSystemWindows(childAt)) ? false : true;
    }

    private void w(float f10, float f11) {
        ValueAnimator valueAnimator = this.f8715p;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f10, f11);
        this.f8715p = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.f8717r);
        this.f8715p.setInterpolator(this.f8718s);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f8716q;
        if (animatorUpdateListener != null) {
            this.f8715p.addUpdateListener(animatorUpdateListener);
        }
        this.f8715p.start();
    }

    private void x() {
        setWillNotDraw(!t());
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public d generateDefaultLayoutParams() {
        return new d(-1, -2);
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (t()) {
            int iSave = canvas.save();
            canvas.translate(0.0f, -this.f8700a);
            this.f8720u.draw(canvas);
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f8720u;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public d generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public d generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LinearLayout.LayoutParams ? new d((LinearLayout.LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new d((ViewGroup.MarginLayoutParams) layoutParams) : new d(layoutParams);
    }

    boolean g() {
        return this.f8704e;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        Behavior behavior = new Behavior();
        this.f8723x = behavior;
        return behavior;
    }

    int getDownNestedPreScrollRange() {
        int iMin;
        int minimumHeight;
        int i10 = this.f8702c;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i12 = dVar.f8742a;
                if ((i12 & 5) != 5) {
                    if (i11 > 0) {
                        break;
                    }
                } else {
                    int i13 = ((LinearLayout.LayoutParams) dVar).topMargin + ((LinearLayout.LayoutParams) dVar).bottomMargin;
                    if ((i12 & 8) != 0) {
                        minimumHeight = ViewCompat.getMinimumHeight(childAt);
                    } else if ((i12 & 2) != 0) {
                        minimumHeight = measuredHeight - ViewCompat.getMinimumHeight(childAt);
                    } else {
                        iMin = i13 + measuredHeight;
                        if (childCount == 0 && ViewCompat.getFitsSystemWindows(childAt)) {
                            iMin = Math.min(iMin, measuredHeight - getTopInset());
                        }
                        i11 += iMin;
                    }
                    iMin = i13 + minimumHeight;
                    if (childCount == 0) {
                        iMin = Math.min(iMin, measuredHeight - getTopInset());
                    }
                    i11 += iMin;
                }
            }
        }
        int iMax = Math.max(0, i11);
        this.f8702c = iMax;
        return iMax;
    }

    int getDownNestedScrollRange() {
        int i10 = this.f8703d;
        if (i10 != -1) {
            return i10;
        }
        int childCount = getChildCount();
        int i11 = 0;
        int minimumHeight = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            }
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) dVar).topMargin + ((LinearLayout.LayoutParams) dVar).bottomMargin;
                int i12 = dVar.f8742a;
                if ((i12 & 1) == 0) {
                    break;
                }
                minimumHeight += measuredHeight;
                if ((i12 & 2) != 0) {
                    minimumHeight -= ViewCompat.getMinimumHeight(childAt);
                    break;
                }
            }
            i11++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.f8703d = iMax;
        return iMax;
    }

    @IdRes
    public int getLiftOnScrollTargetViewId() {
        return this.f8712m;
    }

    @Nullable
    public g getMaterialShapeBackground() {
        Drawable background = getBackground();
        if (background instanceof g) {
            return (g) background;
        }
        return null;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight == 0) {
            int childCount = getChildCount();
            minimumHeight = childCount >= 1 ? ViewCompat.getMinimumHeight(getChildAt(childCount - 1)) : 0;
            if (minimumHeight == 0) {
                return getHeight() / 3;
            }
        }
        return (minimumHeight * 2) + topInset;
    }

    int getPendingAction() {
        return this.f8705f;
    }

    @Nullable
    public Drawable getStatusBarForeground() {
        return this.f8720u;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    @VisibleForTesting
    final int getTopInset() {
        WindowInsetsCompat windowInsetsCompat = this.f8706g;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.getSystemWindowInsetTop();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i10 = this.f8701b;
        if (i10 != -1) {
            return i10;
        }
        int childCount = getChildCount();
        int i11 = 0;
        int minimumHeight = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            }
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i12 = dVar.f8742a;
                if ((i12 & 1) == 0) {
                    break;
                }
                minimumHeight += measuredHeight + ((LinearLayout.LayoutParams) dVar).topMargin + ((LinearLayout.LayoutParams) dVar).bottomMargin;
                if (i11 == 0 && ViewCompat.getFitsSystemWindows(childAt)) {
                    minimumHeight -= getTopInset();
                }
                if ((i12 & 2) != 0) {
                    minimumHeight -= ViewCompat.getMinimumHeight(childAt);
                    break;
                }
            }
            i11++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.f8701b = iMax;
        return iMax;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    boolean i() {
        return getTotalScrollRange() != 0;
    }

    public boolean k() {
        return this.f8711l;
    }

    void m(int i10) {
        this.f8700a = i10;
        if (!willNotDraw()) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        List<a> list = this.f8707h;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                a aVar = this.f8707h.get(i11);
                if (aVar != null) {
                    aVar.a(this, i10);
                }
            }
        }
    }

    void n() {
        this.f8705f = 0;
    }

    public void o(boolean z10, boolean z11) {
        p(z10, z11, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i10) {
        if (this.f8719t == null) {
            this.f8719t = new int[4];
        }
        int[] iArr = this.f8719t;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + iArr.length);
        boolean z10 = this.f8709j;
        int i11 = e4.b.V;
        if (!z10) {
            i11 = -i11;
        }
        iArr[0] = i11;
        iArr[1] = (z10 && this.f8710k) ? e4.b.W : -e4.b.W;
        int i12 = e4.b.R;
        if (!z10) {
            i12 = -i12;
        }
        iArr[2] = i12;
        iArr[3] = (z10 && this.f8710k) ? e4.b.Q : -e4.b.Q;
        return View.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        boolean z11 = true;
        if (ViewCompat.getFitsSystemWindows(this) && v()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                ViewCompat.offsetTopAndBottom(getChildAt(childCount), topInset);
            }
        }
        j();
        this.f8704e = false;
        int childCount2 = getChildCount();
        int i14 = 0;
        while (true) {
            if (i14 >= childCount2) {
                break;
            }
            if (((d) getChildAt(i14).getLayoutParams()).d() != null) {
                this.f8704e = true;
                break;
            }
            i14++;
        }
        Drawable drawable = this.f8720u;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.f8708i) {
            return;
        }
        if (!this.f8711l && !h()) {
            z11 = false;
        }
        q(z11);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i11);
        if (mode != 1073741824 && ViewCompat.getFitsSystemWindows(this) && v()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = MathUtils.clamp(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i11));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        j();
    }

    boolean r(boolean z10) {
        return s(z10, !this.f8708i);
    }

    boolean s(boolean z10, boolean z11) {
        if (!z11 || this.f8710k == z10) {
            return false;
        }
        this.f8710k = z10;
        refreshDrawableState();
        if (!l()) {
            return true;
        }
        if (this.f8714o) {
            w(z10 ? 0.0f : 1.0f, z10 ? 1.0f : 0.0f);
            return true;
        }
        if (!this.f8711l) {
            return true;
        }
        w(z10 ? 0.0f : this.f8722w, z10 ? this.f8722w : 0.0f);
        return true;
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f10) {
        super.setElevation(f10);
        h.d(this, f10);
    }

    public void setExpanded(boolean z10) {
        o(z10, ViewCompat.isLaidOut(this));
    }

    public void setLiftOnScroll(boolean z10) {
        this.f8711l = z10;
    }

    public void setLiftOnScrollTargetView(@Nullable View view) {
        this.f8712m = -1;
        if (view == null) {
            a();
        } else {
            this.f8713n = new WeakReference<>(view);
        }
    }

    public void setLiftOnScrollTargetViewId(@IdRes int i10) {
        this.f8712m = i10;
        a();
    }

    public void setLiftableOverrideEnabled(boolean z10) {
        this.f8708i = z10;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i10) {
        if (i10 != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i10);
    }

    public void setStatusBarForeground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f8720u;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.f8720u = drawable != null ? drawable.mutate() : null;
            this.f8721v = b();
            Drawable drawable3 = this.f8720u;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f8720u.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.f8720u, ViewCompat.getLayoutDirection(this));
                this.f8720u.setVisible(getVisibility() == 0, false);
                this.f8720u.setCallback(this);
            }
            x();
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarForegroundColor(@ColorInt int i10) {
        setStatusBarForeground(new ColorDrawable(i10));
    }

    public void setStatusBarForegroundResource(@DrawableRes int i10) {
        setStatusBarForeground(AppCompatResources.getDrawable(getContext(), i10));
    }

    @Deprecated
    public void setTargetElevation(float f10) {
        e.a(this, f10);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.f8720u;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
    }

    boolean u(@Nullable View view) {
        View viewC = c(view);
        if (viewC != null) {
            view = viewC;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f8720u;
    }

    public static class d extends LinearLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f8742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private b f8743b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Interpolator f8744c;

        public d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f8742a = 1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.f25014m);
            this.f8742a = typedArrayObtainStyledAttributes.getInt(k.f25030o, 0);
            f(typedArrayObtainStyledAttributes.getInt(k.f25022n, 0));
            int i10 = k.f25038p;
            if (typedArrayObtainStyledAttributes.hasValue(i10)) {
                this.f8744c = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(i10, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        @Nullable
        private b a(int i10) {
            if (i10 != 1) {
                return null;
            }
            return new c();
        }

        @Nullable
        public b b() {
            return this.f8743b;
        }

        public int c() {
            return this.f8742a;
        }

        public Interpolator d() {
            return this.f8744c;
        }

        boolean e() {
            int i10 = this.f8742a;
            return (i10 & 1) == 1 && (i10 & 10) != 0;
        }

        public void f(int i10) {
            this.f8743b = a(i10);
        }

        public void g(int i10) {
            this.f8742a = i10;
        }

        public d(int i10, int i11) {
            super(i10, i11);
            this.f8742a = 1;
        }

        public d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f8742a = 1;
        }

        public d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f8742a = 1;
        }

        @RequiresApi(19)
        public d(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f8742a = 1;
        }
    }
}
