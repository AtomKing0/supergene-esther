package com.google.android.material.bottomsheet;

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
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.RoundedCorner;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import androidx.activity.BackEventCompat;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.VisibleForTesting;
import androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.internal.s;
import e4.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import x4.k;

/* JADX INFO: loaded from: classes3.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> implements s4.b {

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private static final int f8862i0 = j.f24899e;
    private boolean A;
    private final BottomSheetBehavior<V>.i B;

    @Nullable
    private ValueAnimator C;
    int D;
    int E;
    int F;
    float G;
    int H;
    float I;
    boolean J;
    private boolean K;
    private boolean L;
    int M;
    int N;

    @Nullable
    ViewDragHelper O;
    private boolean P;
    private int Q;
    private boolean R;
    private float S;
    private int T;
    int U;
    int V;

    @Nullable
    WeakReference<V> W;

    @Nullable
    WeakReference<View> X;

    @Nullable
    WeakReference<View> Y;

    @NonNull
    private final ArrayList<g> Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8863a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    @Nullable
    private VelocityTracker f8864a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f8865b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    @Nullable
    s4.e f8866b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f8867c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    int f8868c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f8869d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private int f8870d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f8871e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    boolean f8872e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f8873f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    @Nullable
    private Map<View, Integer> f8874f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f8875g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    @VisibleForTesting
    final SparseIntArray f8876g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f8877h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private final ViewDragHelper.Callback f8878h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f8879i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private x4.g f8880j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private ColorStateList f8881k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f8882l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f8883m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f8884n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f8885o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f8886p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f8887q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f8888r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f8889s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f8890t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f8891u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f8892v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f8893w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f8894x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f8895y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private k f8896z;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f8897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f8898b;

        a(View view, int i10) {
            this.f8897a = view;
            this.f8898b = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.A0(this.f8897a, this.f8898b, false);
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomSheetBehavior.this.t0(5);
            WeakReference<V> weakReference = BottomSheetBehavior.this.W;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            BottomSheetBehavior.this.W.get().requestLayout();
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.f8880j != null) {
                BottomSheetBehavior.this.f8880j.Z(fFloatValue);
            }
        }
    }

    class d implements s.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f8902a;

        d(boolean z10) {
            this.f8902a = z10;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00a3  */
        @Override // com.google.android.material.internal.s.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public androidx.core.view.WindowInsetsCompat a(android.view.View r11, androidx.core.view.WindowInsetsCompat r12, com.google.android.material.internal.s.d r13) {
            /*
                Method dump skipped, instruction units count: 205
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.d.a(android.view.View, androidx.core.view.WindowInsetsCompat, com.google.android.material.internal.s$d):androidx.core.view.WindowInsetsCompat");
        }
    }

    class e extends ViewDragHelper.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f8904a;

        e() {
        }

        private boolean a(@NonNull View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.V + bottomSheetBehavior.O()) / 2;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(@NonNull View view, int i10, int i11) {
            return view.getLeft();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(@NonNull View view, int i10, int i11) {
            return MathUtils.clamp(i10, BottomSheetBehavior.this.O(), getViewVerticalDragRange(view));
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(@NonNull View view) {
            return BottomSheetBehavior.this.F() ? BottomSheetBehavior.this.V : BottomSheetBehavior.this.H;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i10) {
            if (i10 == 1 && BottomSheetBehavior.this.L) {
                BottomSheetBehavior.this.t0(1);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(@NonNull View view, int i10, int i11, int i12, int i13) {
            BottomSheetBehavior.this.K(i11);
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x00ad  */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
        @Override // androidx.customview.widget.ViewDragHelper.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onViewReleased(@androidx.annotation.NonNull android.view.View r8, float r9, float r10) {
            /*
                Method dump skipped, instruction units count: 308
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.e.onViewReleased(android.view.View, float, float):void");
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(@NonNull View view, int i10) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i11 = bottomSheetBehavior.M;
            if (i11 == 1 || bottomSheetBehavior.f8872e0) {
                return false;
            }
            if (i11 == 3 && bottomSheetBehavior.f8868c0 == i10) {
                WeakReference<View> weakReference = bottomSheetBehavior.Y;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            this.f8904a = System.currentTimeMillis();
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.W;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    class f implements AccessibilityViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8906a;

        f(int i10) {
            this.f8906a = i10;
        }

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand
        public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
            BottomSheetBehavior.this.s0(this.f8906a);
            return true;
        }
    }

    public BottomSheetBehavior() {
        this.f8863a = 0;
        this.f8865b = true;
        this.f8867c = false;
        this.f8882l = -1;
        this.f8883m = -1;
        this.B = new i(this, null);
        this.G = 0.5f;
        this.I = -1.0f;
        this.L = true;
        this.M = 4;
        this.N = 4;
        this.S = 0.1f;
        this.Z = new ArrayList<>();
        this.f8870d0 = -1;
        this.f8876g0 = new SparseIntArray();
        this.f8878h0 = new e();
    }

    @RequiresApi(31)
    private float A(float f10, @Nullable RoundedCorner roundedCorner) {
        if (roundedCorner != null) {
            float radius = roundedCorner.getRadius();
            if (radius > 0.0f && f10 > 0.0f) {
                return radius / f10;
            }
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(View view, int i10, boolean z10) {
        int iR = R(i10);
        ViewDragHelper viewDragHelper = this.O;
        if (!(viewDragHelper != null && (!z10 ? !viewDragHelper.smoothSlideViewTo(view, view.getLeft(), iR) : !viewDragHelper.settleCapturedViewAt(view.getLeft(), iR)))) {
            t0(i10);
            return;
        }
        t0(2);
        D0(i10, true);
        this.B.c(i10);
    }

    private void B() {
        this.F = (int) (this.V * (1.0f - this.G));
    }

    private void B0() {
        WeakReference<V> weakReference = this.W;
        if (weakReference != null) {
            C0(weakReference.get(), 0);
        }
        WeakReference<View> weakReference2 = this.X;
        if (weakReference2 != null) {
            C0(weakReference2.get(), 1);
        }
    }

    private float C() {
        WeakReference<V> weakReference;
        WindowInsets rootWindowInsets;
        if (this.f8880j == null || (weakReference = this.W) == null || weakReference.get() == null || Build.VERSION.SDK_INT < 31) {
            return 0.0f;
        }
        V v10 = this.W.get();
        if (!T() || (rootWindowInsets = v10.getRootWindowInsets()) == null) {
            return 0.0f;
        }
        return Math.max(A(this.f8880j.H(), rootWindowInsets.getRoundedCorner(0)), A(this.f8880j.I(), rootWindowInsets.getRoundedCorner(1)));
    }

    private void C0(View view, int i10) {
        if (view == null) {
            return;
        }
        G(view, i10);
        if (!this.f8865b && this.M != 6) {
            this.f8876g0.put(i10, x(view, e4.i.f24872a, 6));
        }
        if (this.J && X() && this.M != 5) {
            b0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
        }
        int i11 = this.M;
        if (i11 == 3) {
            b0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, this.f8865b ? 4 : 6);
            return;
        }
        if (i11 == 4) {
            b0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, this.f8865b ? 3 : 6);
        } else {
            if (i11 != 6) {
                return;
            }
            b0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
            b0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
        }
    }

    private int D() {
        int i10;
        return this.f8875g ? Math.min(Math.max(this.f8877h, this.V - ((this.U * 9) / 16)), this.T) + this.f8893w : (this.f8885o || this.f8886p || (i10 = this.f8884n) <= 0) ? this.f8873f + this.f8893w : Math.max(this.f8873f, i10 + this.f8879i);
    }

    private void D0(int i10, boolean z10) {
        boolean zU;
        ValueAnimator valueAnimator;
        if (i10 == 2 || this.A == (zU = U()) || this.f8880j == null) {
            return;
        }
        this.A = zU;
        if (!z10 || (valueAnimator = this.C) == null) {
            ValueAnimator valueAnimator2 = this.C;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.C.cancel();
            }
            this.f8880j.Z(this.A ? C() : 1.0f);
            return;
        }
        if (valueAnimator.isRunning()) {
            this.C.reverse();
        } else {
            this.C.setFloatValues(this.f8880j.w(), zU ? C() : 1.0f);
            this.C.start();
        }
    }

    private float E(int i10) {
        float f10;
        float fO;
        int i11 = this.H;
        if (i10 > i11 || i11 == O()) {
            int i12 = this.H;
            f10 = i12 - i10;
            fO = this.V - i12;
        } else {
            int i13 = this.H;
            f10 = i13 - i10;
            fO = i13 - O();
        }
        return f10 / fO;
    }

    private void E0(boolean z10) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.W;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z10) {
                if (this.f8874f0 != null) {
                    return;
                } else {
                    this.f8874f0 = new HashMap(childCount);
                }
            }
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                if (childAt != this.W.get()) {
                    if (z10) {
                        this.f8874f0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        if (this.f8867c) {
                            ViewCompat.setImportantForAccessibility(childAt, 4);
                        }
                    } else if (this.f8867c && (map = this.f8874f0) != null && map.containsKey(childAt)) {
                        ViewCompat.setImportantForAccessibility(childAt, this.f8874f0.get(childAt).intValue());
                    }
                }
            }
            if (!z10) {
                this.f8874f0 = null;
            } else if (this.f8867c) {
                this.W.get().sendAccessibilityEvent(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean F() {
        return W() && X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(boolean z10) {
        V v10;
        if (this.W != null) {
            z();
            if (this.M != 4 || (v10 = this.W.get()) == null) {
                return;
            }
            if (z10) {
                s0(4);
            } else {
                v10.requestLayout();
            }
        }
    }

    private void G(View view, int i10) {
        if (view == null) {
            return;
        }
        ViewCompat.removeAccessibilityAction(view, 524288);
        ViewCompat.removeAccessibilityAction(view, 262144);
        ViewCompat.removeAccessibilityAction(view, 1048576);
        int i11 = this.f8876g0.get(i10, -1);
        if (i11 != -1) {
            ViewCompat.removeAccessibilityAction(view, i11);
            this.f8876g0.delete(i10);
        }
    }

    private AccessibilityViewCommand H(int i10) {
        return new f(i10);
    }

    private void I(@NonNull Context context) {
        if (this.f8896z == null) {
            return;
        }
        x4.g gVar = new x4.g(this.f8896z);
        this.f8880j = gVar;
        gVar.O(context);
        ColorStateList colorStateList = this.f8881k;
        if (colorStateList != null) {
            this.f8880j.Y(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
        this.f8880j.setTint(typedValue.data);
    }

    private void J() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(C(), 1.0f);
        this.C = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.C.addUpdateListener(new c());
    }

    @NonNull
    public static <V extends View> BottomSheetBehavior<V> M(@NonNull V v10) {
        ViewGroup.LayoutParams layoutParams = v10.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
        if (behavior instanceof BottomSheetBehavior) {
            return (BottomSheetBehavior) behavior;
        }
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }

    private int N(int i10, int i11, int i12, int i13) {
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

    private int R(int i10) {
        if (i10 == 3) {
            return O();
        }
        if (i10 == 4) {
            return this.H;
        }
        if (i10 == 5) {
            return this.V;
        }
        if (i10 == 6) {
            return this.F;
        }
        throw new IllegalArgumentException("Invalid state to get top offset: " + i10);
    }

    private float S() {
        VelocityTracker velocityTracker = this.f8864a0;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f8869d);
        return this.f8864a0.getYVelocity(this.f8868c0);
    }

    private boolean T() {
        WeakReference<V> weakReference = this.W;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.W.get().getLocationOnScreen(iArr);
        return iArr[1] == 0;
    }

    private boolean U() {
        return this.M == 3 && (this.f8895y || T());
    }

    private boolean Y(V v10) {
        ViewParent parent = v10.getParent();
        return parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(v10);
    }

    private void b0(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i10) {
        ViewCompat.replaceAccessibilityAction(view, accessibilityActionCompat, null, H(i10));
    }

    private void c0() {
        this.f8868c0 = -1;
        this.f8870d0 = -1;
        VelocityTracker velocityTracker = this.f8864a0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f8864a0 = null;
        }
    }

    private void d0(@NonNull h hVar) {
        int i10 = this.f8863a;
        if (i10 == 0) {
            return;
        }
        if (i10 == -1 || (i10 & 1) == 1) {
            this.f8873f = hVar.f8909b;
        }
        if (i10 == -1 || (i10 & 2) == 2) {
            this.f8865b = hVar.f8910c;
        }
        if (i10 == -1 || (i10 & 4) == 4) {
            this.J = hVar.f8911d;
        }
        if (i10 == -1 || (i10 & 8) == 8) {
            this.K = hVar.f8912e;
        }
    }

    private void e0(V v10, Runnable runnable) {
        if (Y(v10)) {
            v10.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void u0(@NonNull View view) {
        boolean z10 = (Build.VERSION.SDK_INT < 29 || V() || this.f8875g) ? false : true;
        if (this.f8886p || this.f8887q || this.f8888r || this.f8890t || this.f8891u || this.f8892v || z10) {
            s.b(view, new d(z10));
        }
    }

    private boolean w0() {
        return this.O != null && (this.L || this.M == 1);
    }

    private int x(View view, @StringRes int i10, int i11) {
        return ViewCompat.addAccessibilityAction(view, view.getResources().getString(i10), H(i11));
    }

    private void z() {
        int iD = D();
        if (this.f8865b) {
            this.H = Math.max(this.V - iD, this.E);
        } else {
            this.H = this.V - iD;
        }
    }

    void K(int i10) {
        V v10 = this.W.get();
        if (v10 == null || this.Z.isEmpty()) {
            return;
        }
        float fE = E(i10);
        for (int i11 = 0; i11 < this.Z.size(); i11++) {
            this.Z.get(i11).b(v10, fE);
        }
    }

    @Nullable
    @VisibleForTesting
    View L(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View viewL = L(viewGroup.getChildAt(i10));
                if (viewL != null) {
                    return viewL;
                }
            }
        }
        return null;
    }

    public int O() {
        if (this.f8865b) {
            return this.E;
        }
        return Math.max(this.D, this.f8889s ? 0 : this.f8894x);
    }

    x4.g P() {
        return this.f8880j;
    }

    public int Q() {
        return this.M;
    }

    public boolean V() {
        return this.f8885o;
    }

    public boolean W() {
        return this.J;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean X() {
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean Z() {
        return true;
    }

    @Override // s4.b
    public void a() {
        s4.e eVar = this.f8866b0;
        if (eVar == null) {
            return;
        }
        eVar.f();
    }

    public void a0(@NonNull g gVar) {
        this.Z.remove(gVar);
    }

    @Override // s4.b
    public void b(@NonNull BackEventCompat backEventCompat) {
        s4.e eVar = this.f8866b0;
        if (eVar == null) {
            return;
        }
        eVar.j(backEventCompat);
    }

    @Override // s4.b
    public void c(@NonNull BackEventCompat backEventCompat) {
        s4.e eVar = this.f8866b0;
        if (eVar == null) {
            return;
        }
        eVar.l(backEventCompat);
    }

    @Override // s4.b
    public void d() {
        s4.e eVar = this.f8866b0;
        if (eVar == null) {
            return;
        }
        BackEventCompat backEventCompatC = eVar.c();
        if (backEventCompatC == null || Build.VERSION.SDK_INT < 34) {
            s0(this.J ? 5 : 4);
        } else if (this.J) {
            this.f8866b0.h(backEventCompatC, new b());
        } else {
            this.f8866b0.i(backEventCompatC, null);
            s0(4);
        }
    }

    public void f0(boolean z10) {
        this.L = z10;
    }

    public void g0(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.D = i10;
        D0(this.M, true);
    }

    public void h0(boolean z10) {
        if (this.f8865b == z10) {
            return;
        }
        this.f8865b = z10;
        if (this.W != null) {
            z();
        }
        t0((this.f8865b && this.M == 6) ? 3 : this.M);
        D0(this.M, true);
        B0();
    }

    public void i0(boolean z10) {
        this.f8885o = z10;
    }

    public void j0(@FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f10) {
        if (f10 <= 0.0f || f10 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.G = f10;
        if (this.W != null) {
            B();
        }
    }

    public void k0(boolean z10) {
        if (this.J != z10) {
            this.J = z10;
            if (!z10 && this.M == 5) {
                s0(4);
            }
            B0();
        }
    }

    public void l0(@Px int i10) {
        this.f8883m = i10;
    }

    public void m0(@Px int i10) {
        this.f8882l = i10;
    }

    public void n0(int i10) {
        o0(i10, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o0(int r4, boolean r5) {
        /*
            r3 = this;
            r0 = -1
            r1 = 1
            r2 = 0
            if (r4 != r0) goto Lc
            boolean r4 = r3.f8875g
            if (r4 != 0) goto L15
            r3.f8875g = r1
            goto L1f
        Lc:
            boolean r0 = r3.f8875g
            if (r0 != 0) goto L17
            int r0 = r3.f8873f
            if (r0 == r4) goto L15
            goto L17
        L15:
            r1 = r2
            goto L1f
        L17:
            r3.f8875g = r2
            int r4 = java.lang.Math.max(r2, r4)
            r3.f8873f = r4
        L1f:
            if (r1 == 0) goto L24
            r3.F0(r5)
        L24:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.o0(int, boolean):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.W = null;
        this.O = null;
        this.f8866b0 = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.W = null;
        this.O = null;
        this.f8866b0 = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull MotionEvent motionEvent) {
        int i10;
        ViewDragHelper viewDragHelper;
        if (!v10.isShown() || !this.L) {
            this.P = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            c0();
        }
        if (this.f8864a0 == null) {
            this.f8864a0 = VelocityTracker.obtain();
        }
        this.f8864a0.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x10 = (int) motionEvent.getX();
            this.f8870d0 = (int) motionEvent.getY();
            if (this.M != 2) {
                WeakReference<View> weakReference = this.Y;
                View view = weakReference != null ? weakReference.get() : null;
                if (view != null && coordinatorLayout.isPointInChildBounds(view, x10, this.f8870d0)) {
                    this.f8868c0 = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f8872e0 = true;
                }
            }
            this.P = this.f8868c0 == -1 && !coordinatorLayout.isPointInChildBounds(v10, x10, this.f8870d0);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f8872e0 = false;
            this.f8868c0 = -1;
            if (this.P) {
                this.P = false;
                return false;
            }
        }
        if (!this.P && (viewDragHelper = this.O) != null && viewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.Y;
        View view2 = weakReference2 != null ? weakReference2.get() : null;
        return (actionMasked != 2 || view2 == null || this.P || this.M == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.O == null || (i10 = this.f8870d0) == -1 || Math.abs(((float) i10) - motionEvent.getY()) <= ((float) this.O.getTouchSlop())) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, int i10) {
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v10)) {
            v10.setFitsSystemWindows(true);
        }
        if (this.W == null) {
            this.f8877h = coordinatorLayout.getResources().getDimensionPixelSize(e4.d.f24776a);
            u0(v10);
            ViewCompat.setWindowInsetsAnimationCallback(v10, new com.google.android.material.bottomsheet.c(v10));
            this.W = new WeakReference<>(v10);
            this.f8866b0 = new s4.e(v10);
            x4.g gVar = this.f8880j;
            if (gVar != null) {
                ViewCompat.setBackground(v10, gVar);
                x4.g gVar2 = this.f8880j;
                float elevation = this.I;
                if (elevation == -1.0f) {
                    elevation = ViewCompat.getElevation(v10);
                }
                gVar2.X(elevation);
            } else {
                ColorStateList colorStateList = this.f8881k;
                if (colorStateList != null) {
                    ViewCompat.setBackgroundTintList(v10, colorStateList);
                }
            }
            B0();
            if (ViewCompat.getImportantForAccessibility(v10) == 0) {
                ViewCompat.setImportantForAccessibility(v10, 1);
            }
        }
        if (this.O == null) {
            this.O = ViewDragHelper.create(coordinatorLayout, this.f8878h0);
        }
        int top = v10.getTop();
        coordinatorLayout.onLayoutChild(v10, i10);
        this.U = coordinatorLayout.getWidth();
        this.V = coordinatorLayout.getHeight();
        int height = v10.getHeight();
        this.T = height;
        int iMin = this.V;
        int i11 = iMin - height;
        int i12 = this.f8894x;
        if (i11 < i12) {
            if (this.f8889s) {
                int i13 = this.f8883m;
                if (i13 != -1) {
                    iMin = Math.min(iMin, i13);
                }
                this.T = iMin;
            } else {
                int iMin2 = iMin - i12;
                int i14 = this.f8883m;
                if (i14 != -1) {
                    iMin2 = Math.min(iMin2, i14);
                }
                this.T = iMin2;
            }
        }
        this.E = Math.max(0, this.V - this.T);
        B();
        z();
        int i15 = this.M;
        if (i15 == 3) {
            ViewCompat.offsetTopAndBottom(v10, O());
        } else if (i15 == 6) {
            ViewCompat.offsetTopAndBottom(v10, this.F);
        } else if (this.J && i15 == 5) {
            ViewCompat.offsetTopAndBottom(v10, this.V);
        } else if (i15 == 4) {
            ViewCompat.offsetTopAndBottom(v10, this.H);
        } else if (i15 == 1 || i15 == 2) {
            ViewCompat.offsetTopAndBottom(v10, top - v10.getTop());
        }
        D0(this.M, false);
        this.Y = new WeakReference<>(L(v10));
        for (int i16 = 0; i16 < this.Z.size(); i16++) {
            this.Z.get(i16).a(v10);
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v10.getLayoutParams();
        v10.measure(N(i10, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, this.f8882l, marginLayoutParams.width), N(i12, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, this.f8883m, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, float f10, float f11) {
        WeakReference<View> weakReference;
        if (Z() && (weakReference = this.Y) != null && view == weakReference.get()) {
            return this.M != 3 || super.onNestedPreFling(coordinatorLayout, v10, view, f10, f11);
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, int i10, int i11, @NonNull int[] iArr, int i12) {
        if (i12 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.Y;
        View view2 = weakReference != null ? weakReference.get() : null;
        if (!Z() || view == view2) {
            int top = v10.getTop();
            int i13 = top - i11;
            if (i11 > 0) {
                if (i13 < O()) {
                    int iO = top - O();
                    iArr[1] = iO;
                    ViewCompat.offsetTopAndBottom(v10, -iO);
                    t0(3);
                } else {
                    if (!this.L) {
                        return;
                    }
                    iArr[1] = i11;
                    ViewCompat.offsetTopAndBottom(v10, -i11);
                    t0(1);
                }
            } else if (i11 < 0 && !view.canScrollVertically(-1)) {
                if (i13 > this.H && !F()) {
                    int i14 = top - this.H;
                    iArr[1] = i14;
                    ViewCompat.offsetTopAndBottom(v10, -i14);
                    t0(4);
                } else {
                    if (!this.L) {
                        return;
                    }
                    iArr[1] = i11;
                    ViewCompat.offsetTopAndBottom(v10, -i11);
                    t0(1);
                }
            }
            K(v10.getTop());
            this.Q = i11;
            this.R = true;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull Parcelable parcelable) {
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v10, hVar.getSuperState());
        d0(hVar);
        int i10 = hVar.f8908a;
        if (i10 == 1 || i10 == 2) {
            this.M = 4;
            this.N = 4;
        } else {
            this.M = i10;
            this.N = i10;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @NonNull
    public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10) {
        return new h(super.onSaveInstanceState(coordinatorLayout, v10), (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, @NonNull View view2, int i10, int i11) {
        this.Q = 0;
        this.R = false;
        return (i10 & 2) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a9  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onStopNestedScroll(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout r3, @androidx.annotation.NonNull V r4, @androidx.annotation.NonNull android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.O()
            r0 = 3
            if (r3 != r6) goto Lf
            r2.t0(r0)
            return
        Lf:
            boolean r3 = r2.Z()
            if (r3 == 0) goto L24
            java.lang.ref.WeakReference<android.view.View> r3 = r2.Y
            if (r3 == 0) goto L23
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto L23
            boolean r3 = r2.R
            if (r3 != 0) goto L24
        L23:
            return
        L24:
            int r3 = r2.Q
            r5 = 6
            if (r3 <= 0) goto L39
            boolean r3 = r2.f8865b
            if (r3 == 0) goto L2f
            goto Laa
        L2f:
            int r3 = r4.getTop()
            int r6 = r2.F
            if (r3 <= r6) goto Laa
            goto La9
        L39:
            boolean r3 = r2.J
            if (r3 == 0) goto L49
            float r3 = r2.S()
            boolean r3 = r2.x0(r4, r3)
            if (r3 == 0) goto L49
            r0 = 5
            goto Laa
        L49:
            int r3 = r2.Q
            r6 = 4
            if (r3 != 0) goto L8e
            int r3 = r4.getTop()
            boolean r1 = r2.f8865b
            if (r1 == 0) goto L68
            int r5 = r2.E
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.H
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L92
            goto Laa
        L68:
            int r1 = r2.F
            if (r3 >= r1) goto L7e
            int r1 = r2.H
            int r1 = r3 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r3 >= r1) goto L77
            goto Laa
        L77:
            boolean r3 = r2.y0()
            if (r3 == 0) goto La9
            goto L92
        L7e:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.H
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L92
            goto La9
        L8e:
            boolean r3 = r2.f8865b
            if (r3 == 0) goto L94
        L92:
            r0 = r6
            goto Laa
        L94:
            int r3 = r4.getTop()
            int r0 = r2.F
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.H
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L92
        La9:
            r0 = r5
        Laa:
            r3 = 0
            r2.A0(r4, r0, r3)
            r2.R = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull MotionEvent motionEvent) {
        if (!v10.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.M == 1 && actionMasked == 0) {
            return true;
        }
        if (w0()) {
            this.O.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            c0();
        }
        if (this.f8864a0 == null) {
            this.f8864a0 = VelocityTracker.obtain();
        }
        this.f8864a0.addMovement(motionEvent);
        if (w0() && actionMasked == 2 && !this.P && Math.abs(this.f8870d0 - motionEvent.getY()) > this.O.getTouchSlop()) {
            this.O.captureChildView(v10, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.P;
    }

    public void p0(int i10) {
        this.f8863a = i10;
    }

    public void q0(int i10) {
        this.f8871e = i10;
    }

    public void r0(boolean z10) {
        this.K = z10;
    }

    public void s0(int i10) {
        if (i10 == 1 || i10 == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("STATE_");
            sb.append(i10 == 1 ? "DRAGGING" : "SETTLING");
            sb.append(" should not be set externally.");
            throw new IllegalArgumentException(sb.toString());
        }
        if (!this.J && i10 == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i10);
            return;
        }
        int i11 = (i10 == 6 && this.f8865b && R(i10) <= this.E) ? 3 : i10;
        WeakReference<V> weakReference = this.W;
        if (weakReference == null || weakReference.get() == null) {
            t0(i10);
        } else {
            V v10 = this.W.get();
            e0(v10, new a(v10, i11));
        }
    }

    void t0(int i10) {
        V v10;
        if (this.M == i10) {
            return;
        }
        this.M = i10;
        if (i10 == 4 || i10 == 3 || i10 == 6 || (this.J && i10 == 5)) {
            this.N = i10;
        }
        WeakReference<V> weakReference = this.W;
        if (weakReference == null || (v10 = weakReference.get()) == null) {
            return;
        }
        if (i10 == 3) {
            E0(true);
        } else if (i10 == 6 || i10 == 5 || i10 == 4) {
            E0(false);
        }
        D0(i10, true);
        for (int i11 = 0; i11 < this.Z.size(); i11++) {
            this.Z.get(i11).c(v10, i10);
        }
        B0();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean v0(long j10, @FloatRange(from = 0.0d, to = TextSelectionMouseDetectorKt.ClicksSlop) float f10) {
        return false;
    }

    boolean x0(@NonNull View view, float f10) {
        if (this.K) {
            return true;
        }
        if (X() && view.getTop() >= this.H) {
            return Math.abs((((float) view.getTop()) + (f10 * this.S)) - ((float) this.H)) / ((float) D()) > 0.5f;
        }
        return false;
    }

    public void y(@NonNull g gVar) {
        if (this.Z.contains(gVar)) {
            return;
        }
        this.Z.add(gVar);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean y0() {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean z0() {
        return true;
    }

    private class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f8913a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f8914b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Runnable f8915c;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                i.this.f8914b = false;
                ViewDragHelper viewDragHelper = BottomSheetBehavior.this.O;
                if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                    i iVar = i.this;
                    iVar.c(iVar.f8913a);
                    return;
                }
                i iVar2 = i.this;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.M == 2) {
                    bottomSheetBehavior.t0(iVar2.f8913a);
                }
            }
        }

        private i() {
            this.f8915c = new a();
        }

        void c(int i10) {
            WeakReference<V> weakReference = BottomSheetBehavior.this.W;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f8913a = i10;
            if (this.f8914b) {
                return;
            }
            ViewCompat.postOnAnimation(BottomSheetBehavior.this.W.get(), this.f8915c);
            this.f8914b = true;
        }

        /* synthetic */ i(BottomSheetBehavior bottomSheetBehavior, a aVar) {
            this();
        }
    }

    protected static class h extends AbsSavedState {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f8908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f8909b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f8910c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f8911d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f8912e;

        class a implements Parcelable.ClassLoaderCreator<h> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(@NonNull Parcel parcel) {
                return new h(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public h[] newArray(int i10) {
                return new h[i10];
            }
        }

        public h(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f8908a = parcel.readInt();
            this.f8909b = parcel.readInt();
            this.f8910c = parcel.readInt() == 1;
            this.f8911d = parcel.readInt() == 1;
            this.f8912e = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f8908a);
            parcel.writeInt(this.f8909b);
            parcel.writeInt(this.f8910c ? 1 : 0);
            parcel.writeInt(this.f8911d ? 1 : 0);
            parcel.writeInt(this.f8912e ? 1 : 0);
        }

        public h(Parcelable parcelable, @NonNull BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.f8908a = bottomSheetBehavior.M;
            this.f8909b = ((BottomSheetBehavior) bottomSheetBehavior).f8873f;
            this.f8910c = ((BottomSheetBehavior) bottomSheetBehavior).f8865b;
            this.f8911d = bottomSheetBehavior.J;
            this.f8912e = ((BottomSheetBehavior) bottomSheetBehavior).K;
        }
    }

    public BottomSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        int i10;
        super(context, attributeSet);
        this.f8863a = 0;
        this.f8865b = true;
        this.f8867c = false;
        this.f8882l = -1;
        this.f8883m = -1;
        this.B = new i(this, null);
        this.G = 0.5f;
        this.I = -1.0f;
        this.L = true;
        this.M = 4;
        this.N = 4;
        this.S = 0.1f;
        this.Z = new ArrayList<>();
        this.f8870d0 = -1;
        this.f8876g0 = new SparseIntArray();
        this.f8878h0 = new e();
        this.f8879i = context.getResources().getDimensionPixelSize(e4.d.Z);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e4.k.A);
        int i11 = e4.k.E;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            this.f8881k = u4.c.a(context, typedArrayObtainStyledAttributes, i11);
        }
        if (typedArrayObtainStyledAttributes.hasValue(e4.k.W)) {
            this.f8896z = k.e(context, attributeSet, e4.b.f24746c, f8862i0).m();
        }
        I(context);
        J();
        this.I = typedArrayObtainStyledAttributes.getDimension(e4.k.D, -1.0f);
        int i12 = e4.k.B;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            m0(typedArrayObtainStyledAttributes.getDimensionPixelSize(i12, -1));
        }
        int i13 = e4.k.C;
        if (typedArrayObtainStyledAttributes.hasValue(i13)) {
            l0(typedArrayObtainStyledAttributes.getDimensionPixelSize(i13, -1));
        }
        int i14 = e4.k.K;
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(i14);
        if (typedValuePeekValue != null && (i10 = typedValuePeekValue.data) == -1) {
            n0(i10);
        } else {
            n0(typedArrayObtainStyledAttributes.getDimensionPixelSize(i14, -1));
        }
        k0(typedArrayObtainStyledAttributes.getBoolean(e4.k.J, false));
        i0(typedArrayObtainStyledAttributes.getBoolean(e4.k.O, false));
        h0(typedArrayObtainStyledAttributes.getBoolean(e4.k.H, true));
        r0(typedArrayObtainStyledAttributes.getBoolean(e4.k.N, false));
        f0(typedArrayObtainStyledAttributes.getBoolean(e4.k.F, true));
        p0(typedArrayObtainStyledAttributes.getInt(e4.k.L, 0));
        j0(typedArrayObtainStyledAttributes.getFloat(e4.k.I, 0.5f));
        int i15 = e4.k.G;
        TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(i15);
        if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
            g0(typedValuePeekValue2.data);
        } else {
            g0(typedArrayObtainStyledAttributes.getDimensionPixelOffset(i15, 0));
        }
        q0(typedArrayObtainStyledAttributes.getInt(e4.k.M, 500));
        this.f8886p = typedArrayObtainStyledAttributes.getBoolean(e4.k.S, false);
        this.f8887q = typedArrayObtainStyledAttributes.getBoolean(e4.k.T, false);
        this.f8888r = typedArrayObtainStyledAttributes.getBoolean(e4.k.U, false);
        this.f8889s = typedArrayObtainStyledAttributes.getBoolean(e4.k.V, true);
        this.f8890t = typedArrayObtainStyledAttributes.getBoolean(e4.k.P, false);
        this.f8891u = typedArrayObtainStyledAttributes.getBoolean(e4.k.Q, false);
        this.f8892v = typedArrayObtainStyledAttributes.getBoolean(e4.k.R, false);
        this.f8895y = typedArrayObtainStyledAttributes.getBoolean(e4.k.X, true);
        typedArrayObtainStyledAttributes.recycle();
        this.f8869d = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public static abstract class g {
        public abstract void b(@NonNull View view, float f10);

        public abstract void c(@NonNull View view, int i10);

        void a(@NonNull View view) {
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, int i10, int i11, int i12, int i13, int i14, @NonNull int[] iArr) {
    }
}
