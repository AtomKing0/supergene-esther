package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
class q extends t {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @ChecksSdkIntAtLeast(api = 21)
    private static final boolean f9753s = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f9754e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f9755f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    private final TimeInterpolator f9756g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private AutoCompleteTextView f9757h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final View.OnClickListener f9758i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final View.OnFocusChangeListener f9759j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AccessibilityManagerCompat.TouchExplorationStateChangeListener f9760k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f9761l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f9762m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f9763n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f9764o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private AccessibilityManager f9765p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ValueAnimator f9766q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ValueAnimator f9767r;

    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            q.this.r();
            q.this.f9767r.start();
        }
    }

    q(@NonNull s sVar) {
        super(sVar);
        this.f9758i = new View.OnClickListener() { // from class: com.google.android.material.textfield.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f9746a.J(view);
            }
        };
        this.f9759j = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.k
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                this.f9747a.K(view, z10);
            }
        };
        this.f9760k = new AccessibilityManagerCompat.TouchExplorationStateChangeListener() { // from class: com.google.android.material.textfield.l
            @Override // androidx.core.view.accessibility.AccessibilityManagerCompat.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z10) {
                this.f9748a.L(z10);
            }
        };
        this.f9764o = Long.MAX_VALUE;
        Context context = sVar.getContext();
        int i10 = e4.b.E;
        this.f9755f = s4.h.f(context, i10, 67);
        this.f9754e = s4.h.f(sVar.getContext(), i10, 50);
        this.f9756g = s4.h.g(sVar.getContext(), e4.b.J, f4.a.f25668a);
    }

    @NonNull
    private static AutoCompleteTextView D(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator E(int i10, float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.f9756g);
        valueAnimatorOfFloat.setDuration(i10);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.m
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f9749a.I(valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    private void F() {
        this.f9767r = E(this.f9755f, 0.0f, 1.0f);
        ValueAnimator valueAnimatorE = E(this.f9754e, 1.0f, 0.0f);
        this.f9766q = valueAnimatorE;
        valueAnimatorE.addListener(new a());
    }

    private boolean G() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f9764o;
        return jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H() {
        boolean zIsPopupShowing = this.f9757h.isPopupShowing();
        O(zIsPopupShowing);
        this.f9762m = zIsPopupShowing;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(ValueAnimator valueAnimator) {
        this.f9802d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(View view) {
        Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(View view, boolean z10) {
        this.f9761l = z10;
        r();
        if (z10) {
            return;
        }
        O(false);
        this.f9762m = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(boolean z10) {
        AutoCompleteTextView autoCompleteTextView = this.f9757h;
        if (autoCompleteTextView == null || r.a(autoCompleteTextView)) {
            return;
        }
        ViewCompat.setImportantForAccessibility(this.f9802d, z10 ? 2 : 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean M(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (G()) {
                this.f9762m = false;
            }
            Q();
            R();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N() {
        R();
        O(false);
    }

    private void O(boolean z10) {
        if (this.f9763n != z10) {
            this.f9763n = z10;
            this.f9767r.cancel();
            this.f9766q.start();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void P() {
        this.f9757h.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.textfield.o
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f9751a.M(view, motionEvent);
            }
        });
        if (f9753s) {
            this.f9757h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: com.google.android.material.textfield.p
                @Override // android.widget.AutoCompleteTextView.OnDismissListener
                public final void onDismiss() {
                    this.f9752a.N();
                }
            });
        }
        this.f9757h.setThreshold(0);
    }

    private void Q() {
        if (this.f9757h == null) {
            return;
        }
        if (G()) {
            this.f9762m = false;
        }
        if (this.f9762m) {
            this.f9762m = false;
            return;
        }
        if (f9753s) {
            O(!this.f9763n);
        } else {
            this.f9763n = !this.f9763n;
            r();
        }
        if (!this.f9763n) {
            this.f9757h.dismissDropDown();
        } else {
            this.f9757h.requestFocus();
            this.f9757h.showDropDown();
        }
    }

    private void R() {
        this.f9762m = true;
        this.f9764o = System.currentTimeMillis();
    }

    @Override // com.google.android.material.textfield.t
    public void a(Editable editable) {
        if (this.f9765p.isTouchExplorationEnabled() && r.a(this.f9757h) && !this.f9802d.hasFocus()) {
            this.f9757h.dismissDropDown();
        }
        this.f9757h.post(new Runnable() { // from class: com.google.android.material.textfield.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f9750a.H();
            }
        });
    }

    @Override // com.google.android.material.textfield.t
    int c() {
        return e4.i.f24878g;
    }

    @Override // com.google.android.material.textfield.t
    int d() {
        return f9753s ? e4.e.f24816i : e4.e.f24817j;
    }

    @Override // com.google.android.material.textfield.t
    View.OnFocusChangeListener e() {
        return this.f9759j;
    }

    @Override // com.google.android.material.textfield.t
    View.OnClickListener f() {
        return this.f9758i;
    }

    @Override // com.google.android.material.textfield.t
    public AccessibilityManagerCompat.TouchExplorationStateChangeListener h() {
        return this.f9760k;
    }

    @Override // com.google.android.material.textfield.t
    boolean i(int i10) {
        return i10 != 0;
    }

    @Override // com.google.android.material.textfield.t
    boolean j() {
        return true;
    }

    @Override // com.google.android.material.textfield.t
    boolean k() {
        return this.f9761l;
    }

    @Override // com.google.android.material.textfield.t
    boolean l() {
        return true;
    }

    @Override // com.google.android.material.textfield.t
    boolean m() {
        return this.f9763n;
    }

    @Override // com.google.android.material.textfield.t
    public void n(@Nullable EditText editText) {
        this.f9757h = D(editText);
        P();
        this.f9799a.setErrorIconDrawable((Drawable) null);
        if (!r.a(editText) && this.f9765p.isTouchExplorationEnabled()) {
            ViewCompat.setImportantForAccessibility(this.f9802d, 2);
        }
        this.f9799a.setEndIconVisible(true);
    }

    @Override // com.google.android.material.textfield.t
    public void o(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (!r.a(this.f9757h)) {
            accessibilityNodeInfoCompat.setClassName(Spinner.class.getName());
        }
        if (accessibilityNodeInfoCompat.isShowingHintText()) {
            accessibilityNodeInfoCompat.setHintText(null);
        }
    }

    @Override // com.google.android.material.textfield.t
    @SuppressLint({"WrongConstant"})
    public void p(View view, @NonNull AccessibilityEvent accessibilityEvent) {
        if (!this.f9765p.isEnabled() || r.a(this.f9757h)) {
            return;
        }
        boolean z10 = (accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.f9763n && !this.f9757h.isPopupShowing();
        if (accessibilityEvent.getEventType() == 1 || z10) {
            Q();
            R();
        }
    }

    @Override // com.google.android.material.textfield.t
    void s() {
        F();
        this.f9765p = (AccessibilityManager) this.f9801c.getSystemService("accessibility");
    }

    @Override // com.google.android.material.textfield.t
    boolean t() {
        return true;
    }

    @Override // com.google.android.material.textfield.t
    @SuppressLint({"ClickableViewAccessibility"})
    void u() {
        AutoCompleteTextView autoCompleteTextView = this.f9757h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            if (f9753s) {
                this.f9757h.setOnDismissListener(null);
            }
        }
    }
}
