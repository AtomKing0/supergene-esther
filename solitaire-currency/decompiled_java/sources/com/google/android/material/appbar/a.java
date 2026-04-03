package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: HeaderBehavior.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class a<V extends View> extends c<V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private Runnable f8752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    OverScroller f8753e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f8754f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f8755g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f8756h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f8757i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private VelocityTracker f8758j;

    /* JADX INFO: renamed from: com.google.android.material.appbar.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HeaderBehavior.java */
    private class RunnableC0204a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CoordinatorLayout f8759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final V f8760b;

        RunnableC0204a(CoordinatorLayout coordinatorLayout, V v10) {
            this.f8759a = coordinatorLayout;
            this.f8760b = v10;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f8760b == null || (overScroller = a.this.f8753e) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                a.this.n(this.f8759a, this.f8760b);
                return;
            }
            a aVar = a.this;
            aVar.p(this.f8759a, this.f8760b, aVar.f8753e.getCurrY());
            ViewCompat.postOnAnimation(this.f8760b, this);
        }
    }

    public a() {
        this.f8755g = -1;
        this.f8757i = -1;
    }

    private void i() {
        if (this.f8758j == null) {
            this.f8758j = VelocityTracker.obtain();
        }
    }

    boolean h(V v10) {
        return false;
    }

    final boolean j(CoordinatorLayout coordinatorLayout, @NonNull V v10, int i10, int i11, float f10) {
        Runnable runnable = this.f8752d;
        if (runnable != null) {
            v10.removeCallbacks(runnable);
            this.f8752d = null;
        }
        if (this.f8753e == null) {
            this.f8753e = new OverScroller(v10.getContext());
        }
        this.f8753e.fling(0, e(), 0, Math.round(f10), 0, 0, i10, i11);
        if (!this.f8753e.computeScrollOffset()) {
            n(coordinatorLayout, v10);
            return false;
        }
        RunnableC0204a runnableC0204a = new RunnableC0204a(coordinatorLayout, v10);
        this.f8752d = runnableC0204a;
        ViewCompat.postOnAnimation(v10, runnableC0204a);
        return true;
    }

    int k(@NonNull V v10) {
        return -v10.getHeight();
    }

    int l(@NonNull V v10) {
        return v10.getHeight();
    }

    int m() {
        return e();
    }

    final int o(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12) {
        return q(coordinatorLayout, v10, m() - i10, i11, i12);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull MotionEvent motionEvent) {
        int iFindPointerIndex;
        if (this.f8757i < 0) {
            this.f8757i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f8754f) {
            int i10 = this.f8755g;
            if (i10 == -1 || (iFindPointerIndex = motionEvent.findPointerIndex(i10)) == -1) {
                return false;
            }
            int y10 = (int) motionEvent.getY(iFindPointerIndex);
            if (Math.abs(y10 - this.f8756h) > this.f8757i) {
                this.f8756h = y10;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f8755g = -1;
            int x10 = (int) motionEvent.getX();
            int y11 = (int) motionEvent.getY();
            boolean z10 = h(v10) && coordinatorLayout.isPointInChildBounds(v10, x10, y11);
            this.f8754f = z10;
            if (z10) {
                this.f8756h = y11;
                this.f8755g = motionEvent.getPointerId(0);
                i();
                OverScroller overScroller = this.f8753e;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f8753e.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f8758j;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout r12, @androidx.annotation.NonNull V r13, @androidx.annotation.NonNull android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r14.getActionMasked()
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 == r2) goto L4e
            r4 = 2
            if (r0 == r4) goto L2d
            r12 = 3
            if (r0 == r12) goto L72
            r12 = 6
            if (r0 == r12) goto L13
            goto L4c
        L13:
            int r12 = r14.getActionIndex()
            if (r12 != 0) goto L1b
            r12 = r2
            goto L1c
        L1b:
            r12 = r3
        L1c:
            int r13 = r14.getPointerId(r12)
            r11.f8755g = r13
            float r12 = r14.getY(r12)
            r13 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 + r13
            int r12 = (int) r12
            r11.f8756h = r12
            goto L4c
        L2d:
            int r0 = r11.f8755g
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r1) goto L36
            return r3
        L36:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r1 = r11.f8756h
            int r7 = r1 - r0
            r11.f8756h = r0
            int r8 = r11.k(r13)
            r9 = 0
            r4 = r11
            r5 = r12
            r6 = r13
            r4.o(r5, r6, r7, r8, r9)
        L4c:
            r12 = r3
            goto L81
        L4e:
            android.view.VelocityTracker r0 = r11.f8758j
            if (r0 == 0) goto L72
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.f8758j
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.f8758j
            int r4 = r11.f8755g
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.l(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.j(r6, r7, r8, r9, r10)
            r12 = r2
            goto L73
        L72:
            r12 = r3
        L73:
            r11.f8754f = r3
            r11.f8755g = r1
            android.view.VelocityTracker r13 = r11.f8758j
            if (r13 == 0) goto L81
            r13.recycle()
            r13 = 0
            r11.f8758j = r13
        L81:
            android.view.VelocityTracker r13 = r11.f8758j
            if (r13 == 0) goto L88
            r13.addMovement(r14)
        L88:
            boolean r13 = r11.f8754f
            if (r13 != 0) goto L90
            if (r12 == 0) goto L8f
            goto L90
        L8f:
            r2 = r3
        L90:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.a.onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    int p(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        return q(coordinatorLayout, v10, i10, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int q(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12) {
        int iClamp;
        int iE = e();
        if (i11 == 0 || iE < i11 || iE > i12 || iE == (iClamp = MathUtils.clamp(i10, i11, i12))) {
            return 0;
        }
        g(iClamp);
        return iE - iClamp;
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8755g = -1;
        this.f8757i = -1;
    }

    void n(CoordinatorLayout coordinatorLayout, V v10) {
    }
}
