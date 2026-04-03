package com.google.android.material.sidesheet;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.activity.BackEventCompat;
import androidx.annotation.GravityInt;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import e4.i;
import e4.j;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import x4.k;

/* JADX INFO: loaded from: classes3.dex */
public class SideSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> implements s4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.google.android.material.sidesheet.d f9547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f9548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private x4.g f9549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private ColorStateList f9550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private k f9551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SideSheetBehavior<V>.d f9552f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f9553g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f9554h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f9555i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f9556j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private ViewDragHelper f9557k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f9558l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f9559m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f9560n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f9561o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f9562p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f9563q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    private WeakReference<V> f9564r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    private WeakReference<View> f9565s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @IdRes
    private int f9566t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private VelocityTracker f9567u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    private s4.g f9568v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f9569w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NonNull
    private final Set<g> f9570x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final ViewDragHelper.Callback f9571y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int f9546z = i.f24894w;
    private static final int A = j.f24905k;

    class a extends ViewDragHelper.Callback {
        a() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(@NonNull View view, int i10, int i11) {
            return MathUtils.clamp(i10, SideSheetBehavior.this.f9547a.g(), SideSheetBehavior.this.f9547a.f());
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(@NonNull View view, int i10, int i11) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(@NonNull View view) {
            return SideSheetBehavior.this.f9560n + SideSheetBehavior.this.G();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i10) {
            if (i10 == 1 && SideSheetBehavior.this.f9554h) {
                SideSheetBehavior.this.f0(1);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(@NonNull View view, int i10, int i11, int i12, int i13) {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            View viewB = SideSheetBehavior.this.B();
            if (viewB != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) viewB.getLayoutParams()) != null) {
                SideSheetBehavior.this.f9547a.p(marginLayoutParams, view.getLeft(), view.getRight());
                viewB.setLayoutParams(marginLayoutParams);
            }
            SideSheetBehavior.this.w(view, i10);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(@NonNull View view, float f10, float f11) {
            int iS = SideSheetBehavior.this.s(view, f10, f11);
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            sideSheetBehavior.k0(view, iS, sideSheetBehavior.j0());
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(@NonNull View view, int i10) {
            return (SideSheetBehavior.this.f9555i == 1 || SideSheetBehavior.this.f9564r == null || SideSheetBehavior.this.f9564r.get() != view) ? false : true;
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SideSheetBehavior.this.f0(5);
            if (SideSheetBehavior.this.f9564r == null || SideSheetBehavior.this.f9564r.get() == null) {
                return;
            }
            ((View) SideSheetBehavior.this.f9564r.get()).requestLayout();
        }
    }

    class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f9575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f9576b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Runnable f9577c = new Runnable() { // from class: com.google.android.material.sidesheet.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f9581a.c();
            }
        };

        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            this.f9576b = false;
            if (SideSheetBehavior.this.f9557k != null && SideSheetBehavior.this.f9557k.continueSettling(true)) {
                b(this.f9575a);
            } else if (SideSheetBehavior.this.f9555i == 2) {
                SideSheetBehavior.this.f0(this.f9575a);
            }
        }

        void b(int i10) {
            if (SideSheetBehavior.this.f9564r == null || SideSheetBehavior.this.f9564r.get() == null) {
                return;
            }
            this.f9575a = i10;
            if (this.f9576b) {
                return;
            }
            ViewCompat.postOnAnimation((View) SideSheetBehavior.this.f9564r.get(), this.f9577c);
            this.f9576b = true;
        }
    }

    public SideSheetBehavior() {
        this.f9552f = new d();
        this.f9554h = true;
        this.f9555i = 5;
        this.f9556j = 5;
        this.f9559m = 0.1f;
        this.f9566t = -1;
        this.f9570x = new LinkedHashSet();
        this.f9571y = new a();
    }

    @Nullable
    private ValueAnimator.AnimatorUpdateListener A() {
        final ViewGroup.MarginLayoutParams marginLayoutParams;
        final View viewB = B();
        if (viewB == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) viewB.getLayoutParams()) == null) {
            return null;
        }
        final int iC = this.f9547a.c(marginLayoutParams);
        return new ValueAnimator.AnimatorUpdateListener() { // from class: y4.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f36627a.U(marginLayoutParams, iC, viewB, valueAnimator);
            }
        };
    }

    @GravityInt
    private int D() {
        com.google.android.material.sidesheet.d dVar = this.f9547a;
        return (dVar == null || dVar.j() == 0) ? 5 : 3;
    }

    @Nullable
    private CoordinatorLayout.LayoutParams M() {
        V v10;
        WeakReference<V> weakReference = this.f9564r;
        if (weakReference == null || (v10 = weakReference.get()) == null || !(v10.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
            return null;
        }
        return (CoordinatorLayout.LayoutParams) v10.getLayoutParams();
    }

    private boolean N() {
        CoordinatorLayout.LayoutParams layoutParamsM = M();
        return layoutParamsM != null && ((ViewGroup.MarginLayoutParams) layoutParamsM).leftMargin > 0;
    }

    private boolean O() {
        CoordinatorLayout.LayoutParams layoutParamsM = M();
        return layoutParamsM != null && ((ViewGroup.MarginLayoutParams) layoutParamsM).rightMargin > 0;
    }

    private boolean P(@NonNull MotionEvent motionEvent) {
        return g0() && r((float) this.f9569w, motionEvent.getX()) > ((float) this.f9557k.getTouchSlop());
    }

    private boolean Q(float f10) {
        return this.f9547a.k(f10);
    }

    private boolean R(@NonNull V v10) {
        ViewParent parent = v10.getParent();
        return parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(v10);
    }

    private boolean S(View view, int i10, boolean z10) {
        int iH = H(i10);
        ViewDragHelper viewDragHelperL = L();
        return viewDragHelperL != null && (!z10 ? !viewDragHelperL.smoothSlideViewTo(view, iH, view.getTop()) : !viewDragHelperL.settleCapturedViewAt(iH, view.getTop()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean T(int i10, View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        e0(i10);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(ViewGroup.MarginLayoutParams marginLayoutParams, int i10, View view, ValueAnimator valueAnimator) {
        this.f9547a.o(marginLayoutParams, f4.a.c(i10, 0, valueAnimator.getAnimatedFraction()));
        view.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(int i10) {
        V v10 = this.f9564r.get();
        if (v10 != null) {
            k0(v10, i10, false);
        }
    }

    private void W(@NonNull CoordinatorLayout coordinatorLayout) {
        int i10;
        View viewFindViewById;
        if (this.f9565s != null || (i10 = this.f9566t) == -1 || (viewFindViewById = coordinatorLayout.findViewById(i10)) == null) {
            return;
        }
        this.f9565s = new WeakReference<>(viewFindViewById);
    }

    private void X(V v10, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i10) {
        ViewCompat.replaceAccessibilityAction(v10, accessibilityActionCompat, null, u(i10));
    }

    private void Y() {
        VelocityTracker velocityTracker = this.f9567u;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f9567u = null;
        }
    }

    private void Z(@NonNull V v10, Runnable runnable) {
        if (R(v10)) {
            v10.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void c0(int i10) {
        com.google.android.material.sidesheet.d dVar = this.f9547a;
        if (dVar == null || dVar.j() != i10) {
            if (i10 == 0) {
                this.f9547a = new com.google.android.material.sidesheet.b(this);
                if (this.f9551e == null || O()) {
                    return;
                }
                k.b bVarV = this.f9551e.v();
                bVarV.E(0.0f).w(0.0f);
                n0(bVarV.m());
                return;
            }
            if (i10 == 1) {
                this.f9547a = new com.google.android.material.sidesheet.a(this);
                if (this.f9551e == null || N()) {
                    return;
                }
                k.b bVarV2 = this.f9551e.v();
                bVarV2.A(0.0f).s(0.0f);
                n0(bVarV2.m());
                return;
            }
            throw new IllegalArgumentException("Invalid sheet edge position value: " + i10 + ". Must be 0 or 1.");
        }
    }

    private void d0(@NonNull V v10, int i10) {
        c0(GravityCompat.getAbsoluteGravity(((CoordinatorLayout.LayoutParams) v10.getLayoutParams()).gravity, i10) == 3 ? 1 : 0);
    }

    private boolean g0() {
        return this.f9557k != null && (this.f9554h || this.f9555i == 1);
    }

    private boolean i0(@NonNull V v10) {
        return (v10.isShown() || ViewCompat.getAccessibilityPaneTitle(v10) != null) && this.f9554h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(View view, int i10, boolean z10) {
        if (!S(view, i10, z10)) {
            f0(i10);
        } else {
            f0(2);
            this.f9552f.b(i10);
        }
    }

    private void l0() {
        V v10;
        WeakReference<V> weakReference = this.f9564r;
        if (weakReference == null || (v10 = weakReference.get()) == null) {
            return;
        }
        ViewCompat.removeAccessibilityAction(v10, 262144);
        ViewCompat.removeAccessibilityAction(v10, 1048576);
        if (this.f9555i != 5) {
            X(v10, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
        }
        if (this.f9555i != 3) {
            X(v10, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
        }
    }

    private void m0() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        WeakReference<V> weakReference = this.f9564r;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        V v10 = this.f9564r.get();
        View viewB = B();
        if (viewB == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) viewB.getLayoutParams()) == null) {
            return;
        }
        this.f9547a.o(marginLayoutParams, (int) ((this.f9560n * v10.getScaleX()) + this.f9563q));
        viewB.requestLayout();
    }

    private void n0(@NonNull k kVar) {
        x4.g gVar = this.f9549c;
        if (gVar != null) {
            gVar.setShapeAppearanceModel(kVar);
        }
    }

    private void o0(@NonNull View view) {
        int i10 = this.f9555i == 5 ? 4 : 0;
        if (view.getVisibility() != i10) {
            view.setVisibility(i10);
        }
    }

    private int q(int i10, V v10) {
        int i11 = this.f9555i;
        if (i11 == 1 || i11 == 2) {
            return i10 - this.f9547a.h(v10);
        }
        if (i11 == 3) {
            return 0;
        }
        if (i11 == 5) {
            return this.f9547a.e();
        }
        throw new IllegalStateException("Unexpected value: " + this.f9555i);
    }

    private float r(float f10, float f11) {
        return Math.abs(f10 - f11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int s(@NonNull View view, float f10, float f11) {
        if (Q(f10)) {
            return 3;
        }
        if (h0(view, f10)) {
            if (!this.f9547a.m(f10, f11) && !this.f9547a.l(view)) {
                return 3;
            }
        } else if (f10 == 0.0f || !e.a(f10, f11)) {
            int left = view.getLeft();
            if (Math.abs(left - C()) < Math.abs(left - this.f9547a.e())) {
                return 3;
            }
        }
        return 5;
    }

    private void t() {
        WeakReference<View> weakReference = this.f9565s;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f9565s = null;
    }

    private AccessibilityViewCommand u(final int i10) {
        return new AccessibilityViewCommand() { // from class: y4.c
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public final boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                return this.f36633a.T(i10, view, commandArguments);
            }
        };
    }

    private void v(@NonNull Context context) {
        if (this.f9551e == null) {
            return;
        }
        x4.g gVar = new x4.g(this.f9551e);
        this.f9549c = gVar;
        gVar.O(context);
        ColorStateList colorStateList = this.f9550d;
        if (colorStateList != null) {
            this.f9549c.Y(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
        this.f9549c.setTint(typedValue.data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(@NonNull View view, int i10) {
        if (this.f9570x.isEmpty()) {
            return;
        }
        float fB = this.f9547a.b(i10);
        Iterator<g> it = this.f9570x.iterator();
        while (it.hasNext()) {
            it.next().b(view, fB);
        }
    }

    private void x(View view) {
        if (ViewCompat.getAccessibilityPaneTitle(view) == null) {
            ViewCompat.setAccessibilityPaneTitle(view, view.getResources().getString(f9546z));
        }
    }

    private int y(int i10, int i11, int i12, int i13) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, i11, i13);
        if (i12 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i12), 1073741824);
        }
        if (size != 0) {
            i12 = Math.min(size, i12);
        }
        return View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE);
    }

    @Nullable
    public View B() {
        WeakReference<View> weakReference = this.f9565s;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int C() {
        return this.f9547a.d();
    }

    public float E() {
        return this.f9559m;
    }

    float F() {
        return 0.5f;
    }

    int G() {
        return this.f9563q;
    }

    int H(int i10) {
        if (i10 == 3) {
            return C();
        }
        if (i10 == 5) {
            return this.f9547a.e();
        }
        throw new IllegalArgumentException("Invalid state to get outer edge offset: " + i10);
    }

    int I() {
        return this.f9562p;
    }

    int J() {
        return this.f9561o;
    }

    int K() {
        return 500;
    }

    @Nullable
    ViewDragHelper L() {
        return this.f9557k;
    }

    @Override // s4.b
    public void a() {
        s4.g gVar = this.f9568v;
        if (gVar == null) {
            return;
        }
        gVar.f();
    }

    public void a0(@IdRes int i10) {
        this.f9566t = i10;
        t();
        WeakReference<V> weakReference = this.f9564r;
        if (weakReference != null) {
            V v10 = weakReference.get();
            if (i10 == -1 || !ViewCompat.isLaidOut(v10)) {
                return;
            }
            v10.requestLayout();
        }
    }

    @Override // s4.b
    public void b(@NonNull BackEventCompat backEventCompat) {
        s4.g gVar = this.f9568v;
        if (gVar == null) {
            return;
        }
        gVar.j(backEventCompat);
    }

    public void b0(boolean z10) {
        this.f9554h = z10;
    }

    @Override // s4.b
    public void c(@NonNull BackEventCompat backEventCompat) {
        s4.g gVar = this.f9568v;
        if (gVar == null) {
            return;
        }
        gVar.l(backEventCompat, D());
        m0();
    }

    @Override // s4.b
    public void d() {
        s4.g gVar = this.f9568v;
        if (gVar == null) {
            return;
        }
        BackEventCompat backEventCompatC = gVar.c();
        if (backEventCompatC == null || Build.VERSION.SDK_INT < 34) {
            e0(5);
        } else {
            this.f9568v.h(backEventCompatC, D(), new b(), A());
        }
    }

    public void e0(final int i10) {
        if (i10 == 1 || i10 == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("STATE_");
            sb.append(i10 == 1 ? "DRAGGING" : "SETTLING");
            sb.append(" should not be set externally.");
            throw new IllegalArgumentException(sb.toString());
        }
        WeakReference<V> weakReference = this.f9564r;
        if (weakReference == null || weakReference.get() == null) {
            f0(i10);
        } else {
            Z(this.f9564r.get(), new Runnable() { // from class: y4.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f36631a.V(i10);
                }
            });
        }
    }

    void f0(int i10) {
        V v10;
        if (this.f9555i == i10) {
            return;
        }
        this.f9555i = i10;
        if (i10 == 3 || i10 == 5) {
            this.f9556j = i10;
        }
        WeakReference<V> weakReference = this.f9564r;
        if (weakReference == null || (v10 = weakReference.get()) == null) {
            return;
        }
        o0(v10);
        Iterator<g> it = this.f9570x.iterator();
        while (it.hasNext()) {
            it.next().a(v10, i10);
        }
        l0();
    }

    boolean h0(@NonNull View view, float f10) {
        return this.f9547a.n(view, f10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean j0() {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.f9564r = null;
        this.f9557k = null;
        this.f9568v = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.f9564r = null;
        this.f9557k = null;
        this.f9568v = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        if (!i0(v10)) {
            this.f9558l = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            Y();
        }
        if (this.f9567u == null) {
            this.f9567u = VelocityTracker.obtain();
        }
        this.f9567u.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.f9569w = (int) motionEvent.getX();
        } else if ((actionMasked == 1 || actionMasked == 3) && this.f9558l) {
            this.f9558l = false;
            return false;
        }
        return (this.f9558l || (viewDragHelper = this.f9557k) == null || !viewDragHelper.shouldInterceptTouchEvent(motionEvent)) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, int i10) {
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v10)) {
            v10.setFitsSystemWindows(true);
        }
        if (this.f9564r == null) {
            this.f9564r = new WeakReference<>(v10);
            this.f9568v = new s4.g(v10);
            x4.g gVar = this.f9549c;
            if (gVar != null) {
                ViewCompat.setBackground(v10, gVar);
                x4.g gVar2 = this.f9549c;
                float elevation = this.f9553g;
                if (elevation == -1.0f) {
                    elevation = ViewCompat.getElevation(v10);
                }
                gVar2.X(elevation);
            } else {
                ColorStateList colorStateList = this.f9550d;
                if (colorStateList != null) {
                    ViewCompat.setBackgroundTintList(v10, colorStateList);
                }
            }
            o0(v10);
            l0();
            if (ViewCompat.getImportantForAccessibility(v10) == 0) {
                ViewCompat.setImportantForAccessibility(v10, 1);
            }
            x(v10);
        }
        d0(v10, i10);
        if (this.f9557k == null) {
            this.f9557k = ViewDragHelper.create(coordinatorLayout, this.f9571y);
        }
        int iH = this.f9547a.h(v10);
        coordinatorLayout.onLayoutChild(v10, i10);
        this.f9561o = coordinatorLayout.getWidth();
        this.f9562p = this.f9547a.i(coordinatorLayout);
        this.f9560n = v10.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v10.getLayoutParams();
        this.f9563q = marginLayoutParams != null ? this.f9547a.a(marginLayoutParams) : 0;
        ViewCompat.offsetLeftAndRight(v10, q(iH, v10));
        W(coordinatorLayout);
        for (g gVar3 : this.f9570x) {
            if (gVar3 instanceof g) {
                gVar3.c(v10);
            }
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v10.getLayoutParams();
        v10.measure(y(i10, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, -1, marginLayoutParams.width), y(i12, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, -1, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull Parcelable parcelable) {
        c cVar = (c) parcelable;
        if (cVar.getSuperState() != null) {
            super.onRestoreInstanceState(coordinatorLayout, v10, cVar.getSuperState());
        }
        int i10 = cVar.f9574a;
        if (i10 == 1 || i10 == 2) {
            i10 = 5;
        }
        this.f9555i = i10;
        this.f9556j = i10;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @NonNull
    public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10) {
        return new c(super.onSaveInstanceState(coordinatorLayout, v10), (SideSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull MotionEvent motionEvent) {
        if (!v10.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f9555i == 1 && actionMasked == 0) {
            return true;
        }
        if (g0()) {
            this.f9557k.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            Y();
        }
        if (this.f9567u == null) {
            this.f9567u = VelocityTracker.obtain();
        }
        this.f9567u.addMovement(motionEvent);
        if (g0() && actionMasked == 2 && !this.f9558l && P(motionEvent)) {
            this.f9557k.captureChildView(v10, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f9558l;
    }

    int z() {
        return this.f9560n;
    }

    protected static class c extends AbsSavedState {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f9574a;

        class a implements Parcelable.ClassLoaderCreator<c> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(@NonNull Parcel parcel) {
                return new c(parcel, (ClassLoader) null);
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
            this.f9574a = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f9574a);
        }

        public c(Parcelable parcelable, @NonNull SideSheetBehavior<?> sideSheetBehavior) {
            super(parcelable);
            this.f9574a = ((SideSheetBehavior) sideSheetBehavior).f9555i;
        }
    }

    public SideSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9552f = new d();
        this.f9554h = true;
        this.f9555i = 5;
        this.f9556j = 5;
        this.f9559m = 0.1f;
        this.f9566t = -1;
        this.f9570x = new LinkedHashSet();
        this.f9571y = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e4.k.f25107x4);
        int i10 = e4.k.f25123z4;
        if (typedArrayObtainStyledAttributes.hasValue(i10)) {
            this.f9550d = u4.c.a(context, typedArrayObtainStyledAttributes, i10);
        }
        if (typedArrayObtainStyledAttributes.hasValue(e4.k.C4)) {
            this.f9551e = k.e(context, attributeSet, 0, A).m();
        }
        int i11 = e4.k.B4;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            a0(typedArrayObtainStyledAttributes.getResourceId(i11, -1));
        }
        v(context);
        this.f9553g = typedArrayObtainStyledAttributes.getDimension(e4.k.f25115y4, -1.0f);
        b0(typedArrayObtainStyledAttributes.getBoolean(e4.k.A4, true));
        typedArrayObtainStyledAttributes.recycle();
        this.f9548b = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
