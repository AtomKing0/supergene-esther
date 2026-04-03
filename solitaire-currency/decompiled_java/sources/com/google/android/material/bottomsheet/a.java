package com.google.android.material.bottomsheet;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.s;
import e4.h;
import e4.j;
import x4.g;

/* JADX INFO: compiled from: BottomSheetDialog.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends AppCompatDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BottomSheetBehavior<FrameLayout> f8918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FrameLayout f8919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CoordinatorLayout f8920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FrameLayout f8921d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f8922e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f8923f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f8924g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f8925h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private f f8926i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f8927j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private s4.c f8928k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    private BottomSheetBehavior.g f8929l;

    /* JADX INFO: renamed from: com.google.android.material.bottomsheet.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BottomSheetDialog.java */
    class C0205a implements OnApplyWindowInsetsListener {
        C0205a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            if (a.this.f8926i != null) {
                a.this.f8918a.a0(a.this.f8926i);
            }
            if (windowInsetsCompat != null) {
                a aVar = a.this;
                aVar.f8926i = new f(aVar.f8921d, windowInsetsCompat, null);
                a.this.f8926i.e(a.this.getWindow());
                a.this.f8918a.y(a.this.f8926i);
            }
            return windowInsetsCompat;
        }
    }

    /* JADX INFO: compiled from: BottomSheetDialog.java */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            if (aVar.f8923f && aVar.isShowing() && a.this.j()) {
                a.this.cancel();
            }
        }
    }

    /* JADX INFO: compiled from: BottomSheetDialog.java */
    class c extends AccessibilityDelegateCompat {
        c() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!a.this.f8923f) {
                accessibilityNodeInfoCompat.setDismissable(false);
            } else {
                accessibilityNodeInfoCompat.addAction(1048576);
                accessibilityNodeInfoCompat.setDismissable(true);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            if (i10 == 1048576) {
                a aVar = a.this;
                if (aVar.f8923f) {
                    aVar.cancel();
                    return true;
                }
            }
            return super.performAccessibilityAction(view, i10, bundle);
        }
    }

    /* JADX INFO: compiled from: BottomSheetDialog.java */
    class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: compiled from: BottomSheetDialog.java */
    private static class f extends BottomSheetBehavior.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private final Boolean f8935a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        private final WindowInsetsCompat f8936b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private Window f8937c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f8938d;

        /* synthetic */ f(View view, WindowInsetsCompat windowInsetsCompat, C0205a c0205a) {
            this(view, windowInsetsCompat);
        }

        private void d(View view) {
            if (view.getTop() < this.f8936b.getSystemWindowInsetTop()) {
                Window window = this.f8937c;
                if (window != null) {
                    Boolean bool = this.f8935a;
                    com.google.android.material.internal.d.f(window, bool == null ? this.f8938d : bool.booleanValue());
                }
                view.setPadding(view.getPaddingLeft(), this.f8936b.getSystemWindowInsetTop() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
                return;
            }
            if (view.getTop() != 0) {
                Window window2 = this.f8937c;
                if (window2 != null) {
                    com.google.android.material.internal.d.f(window2, this.f8938d);
                }
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        void a(@NonNull View view) {
            d(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void b(@NonNull View view, float f10) {
            d(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void c(@NonNull View view, int i10) {
            d(view);
        }

        void e(@Nullable Window window) {
            if (this.f8937c == window) {
                return;
            }
            this.f8937c = window;
            if (window != null) {
                this.f8938d = WindowCompat.getInsetsController(window, window.getDecorView()).isAppearanceLightStatusBars();
            }
        }

        private f(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            this.f8936b = windowInsetsCompat;
            g gVarP = BottomSheetBehavior.M(view).P();
            ColorStateList colorStateListV = gVarP != null ? gVarP.v() : ViewCompat.getBackgroundTintList(view);
            if (colorStateListV != null) {
                this.f8935a = Boolean.valueOf(n4.a.h(colorStateListV.getDefaultColor()));
                return;
            }
            Integer numD = s.d(view);
            if (numD != null) {
                this.f8935a = Boolean.valueOf(n4.a.h(numD.intValue()));
            } else {
                this.f8935a = null;
            }
        }
    }

    public a(@NonNull Context context) {
        this(context, 0);
        this.f8927j = getContext().getTheme().obtainStyledAttributes(new int[]{e4.b.f24761r}).getBoolean(0, false);
    }

    private FrameLayout f() {
        if (this.f8919b == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), h.f24849a, null);
            this.f8919b = frameLayout;
            this.f8920c = (CoordinatorLayout) frameLayout.findViewById(e4.f.f24824e);
            FrameLayout frameLayout2 = (FrameLayout) this.f8919b.findViewById(e4.f.f24825f);
            this.f8921d = frameLayout2;
            BottomSheetBehavior<FrameLayout> bottomSheetBehaviorM = BottomSheetBehavior.M(frameLayout2);
            this.f8918a = bottomSheetBehaviorM;
            bottomSheetBehaviorM.y(this.f8929l);
            this.f8918a.k0(this.f8923f);
            this.f8928k = new s4.c(this.f8918a, this.f8921d);
        }
        return this.f8919b;
    }

    private static int getThemeResId(@NonNull Context context, int i10) {
        if (i10 != 0) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(e4.b.f24745b, typedValue, true) ? typedValue.resourceId : j.f24896b;
    }

    private void k() {
        s4.c cVar = this.f8928k;
        if (cVar == null) {
            return;
        }
        if (this.f8923f) {
            cVar.b();
        } else {
            cVar.d();
        }
    }

    private View l(int i10, @Nullable View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        f();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f8919b.findViewById(e4.f.f24824e);
        if (i10 != 0 && view == null) {
            view = getLayoutInflater().inflate(i10, (ViewGroup) coordinatorLayout, false);
        }
        if (this.f8927j) {
            ViewCompat.setOnApplyWindowInsetsListener(this.f8921d, new C0205a());
        }
        this.f8921d.removeAllViews();
        if (layoutParams == null) {
            this.f8921d.addView(view);
        } else {
            this.f8921d.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(e4.f.U).setOnClickListener(new b());
        ViewCompat.setAccessibilityDelegate(this.f8921d, new c());
        this.f8921d.setOnTouchListener(new d());
        return this.f8919b;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> bottomSheetBehaviorG = g();
        if (!this.f8922e || bottomSheetBehaviorG.Q() == 5) {
            super.cancel();
        } else {
            bottomSheetBehaviorG.s0(5);
        }
    }

    @NonNull
    public BottomSheetBehavior<FrameLayout> g() {
        if (this.f8918a == null) {
            f();
        }
        return this.f8918a;
    }

    public boolean h() {
        return this.f8922e;
    }

    void i() {
        this.f8918a.a0(this.f8929l);
    }

    boolean j() {
        if (!this.f8925h) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
            this.f8924g = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
            this.f8925h = true;
        }
        return this.f8924g;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            boolean z10 = this.f8927j && Color.alpha(window.getNavigationBarColor()) < 255;
            FrameLayout frameLayout = this.f8919b;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z10);
            }
            CoordinatorLayout coordinatorLayout = this.f8920c;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z10);
            }
            WindowCompat.setDecorFitsSystemWindows(window, !z10);
            f fVar = this.f8926i;
            if (fVar != null) {
                fVar.e(window);
            }
        }
        k();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        f fVar = this.f8926i;
        if (fVar != null) {
            fVar.e(null);
        }
        s4.c cVar = this.f8928k;
        if (cVar != null) {
            cVar.d();
        }
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    protected void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f8918a;
        if (bottomSheetBehavior == null || bottomSheetBehavior.Q() != 5) {
            return;
        }
        this.f8918a.s0(4);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z10) {
        super.setCancelable(z10);
        if (this.f8923f != z10) {
            this.f8923f = z10;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f8918a;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.k0(z10);
            }
            if (getWindow() != null) {
                k();
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z10) {
        super.setCanceledOnTouchOutside(z10);
        if (z10 && !this.f8923f) {
            this.f8923f = true;
        }
        this.f8924g = z10;
        this.f8925h = true;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(@LayoutRes int i10) {
        super.setContentView(l(i10, null, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(l(0, view, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(l(0, view, layoutParams));
    }

    public a(@NonNull Context context, @StyleRes int i10) {
        super(context, getThemeResId(context, i10));
        this.f8923f = true;
        this.f8924g = true;
        this.f8929l = new e();
        supportRequestWindowFeature(1);
        this.f8927j = getContext().getTheme().obtainStyledAttributes(new int[]{e4.b.f24761r}).getBoolean(0, false);
    }

    /* JADX INFO: compiled from: BottomSheetDialog.java */
    class e extends BottomSheetBehavior.g {
        e() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void c(@NonNull View view, int i10) {
            if (i10 == 5) {
                a.this.cancel();
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void b(@NonNull View view, float f10) {
        }
    }
}
