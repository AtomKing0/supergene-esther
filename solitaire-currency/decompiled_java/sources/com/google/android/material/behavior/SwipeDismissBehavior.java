package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.widget.ViewDragHelper;

/* JADX INFO: loaded from: classes3.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ViewDragHelper f8790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    c f8791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f8792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f8793d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f8795f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f8794e = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f8796g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f8797h = 0.5f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float f8798i = 0.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    float f8799j = 0.5f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ViewDragHelper.Callback f8800k = new a();

    class a extends ViewDragHelper.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f8801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f8802b = -1;

        a() {
        }

        private boolean a(@NonNull View view, float f10) {
            if (f10 == 0.0f) {
                return Math.abs(view.getLeft() - this.f8801a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.f8797h);
            }
            boolean z10 = ViewCompat.getLayoutDirection(view) == 1;
            int i10 = SwipeDismissBehavior.this.f8796g;
            if (i10 == 2) {
                return true;
            }
            if (i10 == 0) {
                if (z10) {
                    if (f10 >= 0.0f) {
                        return false;
                    }
                } else if (f10 <= 0.0f) {
                    return false;
                }
                return true;
            }
            if (i10 != 1) {
                return false;
            }
            if (z10) {
                if (f10 <= 0.0f) {
                    return false;
                }
            } else if (f10 >= 0.0f) {
                return false;
            }
            return true;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(@NonNull View view, int i10, int i11) {
            int width;
            int width2;
            int width3;
            boolean z10 = ViewCompat.getLayoutDirection(view) == 1;
            int i12 = SwipeDismissBehavior.this.f8796g;
            if (i12 == 0) {
                if (z10) {
                    width = this.f8801a - view.getWidth();
                    width2 = this.f8801a;
                } else {
                    width = this.f8801a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i12 != 1) {
                width = this.f8801a - view.getWidth();
                width2 = view.getWidth() + this.f8801a;
            } else if (z10) {
                width = this.f8801a;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.f8801a - view.getWidth();
                width2 = this.f8801a;
            }
            return SwipeDismissBehavior.h(width, i10, width2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(@NonNull View view, int i10, int i11) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(@NonNull View view) {
            return view.getWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(@NonNull View view, int i10) {
            this.f8802b = i10;
            this.f8801a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                SwipeDismissBehavior.this.f8793d = true;
                parent.requestDisallowInterceptTouchEvent(true);
                SwipeDismissBehavior.this.f8793d = false;
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i10) {
            c cVar = SwipeDismissBehavior.this.f8791b;
            if (cVar != null) {
                cVar.b(i10);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(@NonNull View view, int i10, int i11, int i12, int i13) {
            float width = view.getWidth() * SwipeDismissBehavior.this.f8798i;
            float width2 = view.getWidth() * SwipeDismissBehavior.this.f8799j;
            float fAbs = Math.abs(i10 - this.f8801a);
            if (fAbs <= width) {
                view.setAlpha(1.0f);
            } else if (fAbs >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.g(0.0f, 1.0f - SwipeDismissBehavior.j(width, width2, fAbs), 1.0f));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
        @Override // androidx.customview.widget.ViewDragHelper.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onViewReleased(@androidx.annotation.NonNull android.view.View r3, float r4, float r5) {
            /*
                r2 = this;
                r5 = -1
                r2.f8802b = r5
                int r5 = r3.getWidth()
                boolean r0 = r2.a(r3, r4)
                if (r0 == 0) goto L23
                r0 = 0
                int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r4 < 0) goto L1d
                int r4 = r3.getLeft()
                int r0 = r2.f8801a
                if (r4 >= r0) goto L1b
                goto L1d
            L1b:
                int r0 = r0 + r5
                goto L21
            L1d:
                int r4 = r2.f8801a
                int r0 = r4 - r5
            L21:
                r4 = 1
                goto L26
            L23:
                int r0 = r2.f8801a
                r4 = 0
            L26:
                com.google.android.material.behavior.SwipeDismissBehavior r5 = com.google.android.material.behavior.SwipeDismissBehavior.this
                androidx.customview.widget.ViewDragHelper r5 = r5.f8790a
                int r1 = r3.getTop()
                boolean r5 = r5.settleCapturedViewAt(r0, r1)
                if (r5 == 0) goto L3f
                com.google.android.material.behavior.SwipeDismissBehavior$d r5 = new com.google.android.material.behavior.SwipeDismissBehavior$d
                com.google.android.material.behavior.SwipeDismissBehavior r0 = com.google.android.material.behavior.SwipeDismissBehavior.this
                r5.<init>(r3, r4)
                androidx.core.view.ViewCompat.postOnAnimation(r3, r5)
                goto L4a
            L3f:
                if (r4 == 0) goto L4a
                com.google.android.material.behavior.SwipeDismissBehavior r4 = com.google.android.material.behavior.SwipeDismissBehavior.this
                com.google.android.material.behavior.SwipeDismissBehavior$c r4 = r4.f8791b
                if (r4 == 0) goto L4a
                r4.a(r3)
            L4a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.a.onViewReleased(android.view.View, float, float):void");
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i10) {
            int i11 = this.f8802b;
            return (i11 == -1 || i11 == i10) && SwipeDismissBehavior.this.f(view);
        }
    }

    class b implements AccessibilityViewCommand {
        b() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand
        public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
            boolean z10 = false;
            if (!SwipeDismissBehavior.this.f(view)) {
                return false;
            }
            boolean z11 = ViewCompat.getLayoutDirection(view) == 1;
            int i10 = SwipeDismissBehavior.this.f8796g;
            if ((i10 == 0 && z11) || (i10 == 1 && !z11)) {
                z10 = true;
            }
            int width = view.getWidth();
            if (z10) {
                width = -width;
            }
            ViewCompat.offsetLeftAndRight(view, width);
            view.setAlpha(0.0f);
            c cVar = SwipeDismissBehavior.this.f8791b;
            if (cVar != null) {
                cVar.a(view);
            }
            return true;
        }
    }

    public interface c {
        void a(View view);

        void b(int i10);
    }

    private class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f8805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f8806b;

        d(View view, boolean z10) {
            this.f8805a = view;
            this.f8806b = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar;
            ViewDragHelper viewDragHelper = SwipeDismissBehavior.this.f8790a;
            if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.f8805a, this);
            } else {
                if (!this.f8806b || (cVar = SwipeDismissBehavior.this.f8791b) == null) {
                    return;
                }
                cVar.a(this.f8805a);
            }
        }
    }

    static float g(float f10, float f11, float f12) {
        return Math.min(Math.max(f10, f11), f12);
    }

    static int h(int i10, int i11, int i12) {
        return Math.min(Math.max(i10, i11), i12);
    }

    private void i(ViewGroup viewGroup) {
        if (this.f8790a == null) {
            this.f8790a = this.f8795f ? ViewDragHelper.create(viewGroup, this.f8794e, this.f8800k) : ViewDragHelper.create(viewGroup, this.f8800k);
        }
    }

    static float j(float f10, float f11, float f12) {
        return (f12 - f10) / (f11 - f10);
    }

    private void o(View view) {
        ViewCompat.removeAccessibilityAction(view, 1048576);
        if (f(view)) {
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, new b());
        }
    }

    public boolean f(@NonNull View view) {
        return true;
    }

    public void k(float f10) {
        this.f8799j = g(0.0f, f10, 1.0f);
    }

    public void l(@Nullable c cVar) {
        this.f8791b = cVar;
    }

    public void m(float f10) {
        this.f8798i = g(0.0f, f10, 1.0f);
    }

    public void n(int i10) {
        this.f8796g = i10;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull MotionEvent motionEvent) {
        boolean zIsPointInChildBounds = this.f8792c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zIsPointInChildBounds = coordinatorLayout.isPointInChildBounds(v10, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f8792c = zIsPointInChildBounds;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f8792c = false;
        }
        if (!zIsPointInChildBounds) {
            return false;
        }
        i(coordinatorLayout);
        return !this.f8793d && this.f8790a.shouldInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, int i10) {
        boolean zOnLayoutChild = super.onLayoutChild(coordinatorLayout, v10, i10);
        if (ViewCompat.getImportantForAccessibility(v10) == 0) {
            ViewCompat.setImportantForAccessibility(v10, 1);
            o(v10);
        }
        return zOnLayoutChild;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        if (this.f8790a == null) {
            return false;
        }
        if (this.f8793d && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.f8790a.processTouchEvent(motionEvent);
        return true;
    }
}
