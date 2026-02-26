package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
class f extends t {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f9733e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f9734f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    private final TimeInterpolator f9735g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    private final TimeInterpolator f9736h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private EditText f9737i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final View.OnClickListener f9738j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final View.OnFocusChangeListener f9739k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private AnimatorSet f9740l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ValueAnimator f9741m;

    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            f.this.f9800b.a0(true);
        }
    }

    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.f9800b.a0(false);
        }
    }

    f(@NonNull s sVar) {
        super(sVar);
        this.f9738j = new View.OnClickListener() { // from class: com.google.android.material.textfield.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f9730a.G(view);
            }
        };
        this.f9739k = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.e
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                this.f9731a.H(view, z10);
            }
        };
        Context context = sVar.getContext();
        int i10 = e4.b.E;
        this.f9733e = s4.h.f(context, i10, 100);
        this.f9734f = s4.h.f(sVar.getContext(), i10, 150);
        this.f9735g = s4.h.g(sVar.getContext(), e4.b.J, f4.a.f25668a);
        this.f9736h = s4.h.g(sVar.getContext(), e4.b.I, f4.a.f25671d);
    }

    private void A(boolean z10) {
        boolean z11 = this.f9800b.F() == z10;
        if (z10 && !this.f9740l.isRunning()) {
            this.f9741m.cancel();
            this.f9740l.start();
            if (z11) {
                this.f9740l.end();
                return;
            }
            return;
        }
        if (z10) {
            return;
        }
        this.f9740l.cancel();
        this.f9741m.start();
        if (z11) {
            this.f9741m.end();
        }
    }

    private ValueAnimator B(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.f9735g);
        valueAnimatorOfFloat.setDuration(this.f9733e);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f9729a.E(valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    private ValueAnimator C() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(this.f9736h);
        valueAnimatorOfFloat.setDuration(this.f9734f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f9728a.F(valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    private void D() {
        ValueAnimator valueAnimatorC = C();
        ValueAnimator valueAnimatorB = B(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f9740l = animatorSet;
        animatorSet.playTogether(valueAnimatorC, valueAnimatorB);
        this.f9740l.addListener(new a());
        ValueAnimator valueAnimatorB2 = B(1.0f, 0.0f);
        this.f9741m = valueAnimatorB2;
        valueAnimatorB2.addListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(ValueAnimator valueAnimator) {
        this.f9802d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f9802d.setScaleX(fFloatValue);
        this.f9802d.setScaleY(fFloatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(View view) {
        EditText editText = this.f9737i;
        if (editText == null) {
            return;
        }
        Editable text = editText.getText();
        if (text != null) {
            text.clear();
        }
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(View view, boolean z10) {
        A(J());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() {
        A(true);
    }

    private boolean J() {
        EditText editText = this.f9737i;
        return editText != null && (editText.hasFocus() || this.f9802d.hasFocus()) && this.f9737i.getText().length() > 0;
    }

    @Override // com.google.android.material.textfield.t
    void a(@NonNull Editable editable) {
        if (this.f9800b.w() != null) {
            return;
        }
        A(J());
    }

    @Override // com.google.android.material.textfield.t
    int c() {
        return e4.i.f24876e;
    }

    @Override // com.google.android.material.textfield.t
    int d() {
        return e4.e.f24818k;
    }

    @Override // com.google.android.material.textfield.t
    View.OnFocusChangeListener e() {
        return this.f9739k;
    }

    @Override // com.google.android.material.textfield.t
    View.OnClickListener f() {
        return this.f9738j;
    }

    @Override // com.google.android.material.textfield.t
    View.OnFocusChangeListener g() {
        return this.f9739k;
    }

    @Override // com.google.android.material.textfield.t
    public void n(@Nullable EditText editText) {
        this.f9737i = editText;
        this.f9799a.setEndIconVisible(J());
    }

    @Override // com.google.android.material.textfield.t
    void q(boolean z10) {
        if (this.f9800b.w() == null) {
            return;
        }
        A(z10);
    }

    @Override // com.google.android.material.textfield.t
    void s() {
        D();
    }

    @Override // com.google.android.material.textfield.t
    void u() {
        EditText editText = this.f9737i;
        if (editText != null) {
            editText.post(new Runnable() { // from class: com.google.android.material.textfield.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f9717a.I();
                }
            });
        }
    }
}
