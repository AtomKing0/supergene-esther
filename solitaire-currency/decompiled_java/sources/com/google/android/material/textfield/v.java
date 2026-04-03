package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: IndicatorViewController.java */
/* JADX INFO: loaded from: classes3.dex */
final class v {

    @Nullable
    private ColorStateList A;
    private Typeface B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    private final TimeInterpolator f9806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    private final TimeInterpolator f9807e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    private final TimeInterpolator f9808f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f9809g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    private final TextInputLayout f9810h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private LinearLayout f9811i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f9812j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private FrameLayout f9813k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private Animator f9814l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final float f9815m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f9816n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f9817o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private CharSequence f9818p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f9819q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    private TextView f9820r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    private CharSequence f9821s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f9822t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f9823u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    private ColorStateList f9824v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private CharSequence f9825w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f9826x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    private TextView f9827y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f9828z;

    /* JADX INFO: compiled from: IndicatorViewController.java */
    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f9829a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f9830b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f9831c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f9832d;

        a(int i10, TextView textView, int i11, TextView textView2) {
            this.f9829a = i10;
            this.f9830b = textView;
            this.f9831c = i11;
            this.f9832d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            v.this.f9816n = this.f9829a;
            v.this.f9814l = null;
            TextView textView = this.f9830b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f9831c == 1 && v.this.f9820r != null) {
                    v.this.f9820r.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f9832d;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.f9832d.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f9832d;
            if (textView != null) {
                textView.setVisibility(0);
                this.f9832d.setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: compiled from: IndicatorViewController.java */
    class b extends View.AccessibilityDelegate {
        b() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            EditText editText = v.this.f9810h.getEditText();
            if (editText != null) {
                accessibilityNodeInfo.setLabeledBy(editText);
            }
        }
    }

    public v(@NonNull TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f9809g = context;
        this.f9810h = textInputLayout;
        this.f9815m = context.getResources().getDimensionPixelSize(e4.d.f24788g);
        int i10 = e4.b.F;
        this.f9803a = s4.h.f(context, i10, 217);
        this.f9804b = s4.h.f(context, e4.b.C, 167);
        this.f9805c = s4.h.f(context, i10, 167);
        int i11 = e4.b.H;
        this.f9806d = s4.h.g(context, i11, f4.a.f25671d);
        TimeInterpolator timeInterpolator = f4.a.f25668a;
        this.f9807e = s4.h.g(context, i11, timeInterpolator);
        this.f9808f = s4.h.g(context, e4.b.J, timeInterpolator);
    }

    private void D(int i10, int i11) {
        TextView textViewM;
        TextView textViewM2;
        if (i10 == i11) {
            return;
        }
        if (i11 != 0 && (textViewM2 = m(i11)) != null) {
            textViewM2.setVisibility(0);
            textViewM2.setAlpha(1.0f);
        }
        if (i10 != 0 && (textViewM = m(i10)) != null) {
            textViewM.setVisibility(4);
            if (i10 == 1) {
                textViewM.setText((CharSequence) null);
            }
        }
        this.f9816n = i11;
    }

    private void M(@Nullable TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void O(@NonNull ViewGroup viewGroup, int i10) {
        if (i10 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean P(@Nullable TextView textView, @NonNull CharSequence charSequence) {
        return ViewCompat.isLaidOut(this.f9810h) && this.f9810h.isEnabled() && !(this.f9817o == this.f9816n && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    private void S(int i10, int i11, boolean z10) {
        if (i10 == i11) {
            return;
        }
        if (z10) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f9814l = animatorSet;
            ArrayList arrayList = new ArrayList();
            i(arrayList, this.f9826x, this.f9827y, 2, i10, i11);
            i(arrayList, this.f9819q, this.f9820r, 1, i10, i11);
            f4.b.a(animatorSet, arrayList);
            animatorSet.addListener(new a(i11, m(i10), i10, m(i11)));
            animatorSet.start();
        } else {
            D(i10, i11);
        }
        this.f9810h.p0();
        this.f9810h.u0(z10);
        this.f9810h.A0();
    }

    private boolean g() {
        return (this.f9811i == null || this.f9810h.getEditText() == null) ? false : true;
    }

    private void i(@NonNull List<Animator> list, boolean z10, @Nullable TextView textView, int i10, int i11, int i12) {
        if (textView == null || !z10) {
            return;
        }
        boolean z11 = false;
        if (i10 == i12 || i10 == i11) {
            ObjectAnimator objectAnimatorJ = j(textView, i12 == i10);
            if (i10 == i12 && i11 != 0) {
                z11 = true;
            }
            if (z11) {
                objectAnimatorJ.setStartDelay(this.f9805c);
            }
            list.add(objectAnimatorJ);
            if (i12 != i10 || i11 == 0) {
                return;
            }
            ObjectAnimator objectAnimatorK = k(textView);
            objectAnimatorK.setStartDelay(this.f9805c);
            list.add(objectAnimatorK);
        }
    }

    private ObjectAnimator j(TextView textView, boolean z10) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z10 ? 1.0f : 0.0f);
        objectAnimatorOfFloat.setDuration(z10 ? this.f9804b : this.f9805c);
        objectAnimatorOfFloat.setInterpolator(z10 ? this.f9807e : this.f9808f);
        return objectAnimatorOfFloat;
    }

    private ObjectAnimator k(TextView textView) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f9815m, 0.0f);
        objectAnimatorOfFloat.setDuration(this.f9803a);
        objectAnimatorOfFloat.setInterpolator(this.f9806d);
        return objectAnimatorOfFloat;
    }

    @Nullable
    private TextView m(int i10) {
        if (i10 == 1) {
            return this.f9820r;
        }
        if (i10 != 2) {
            return null;
        }
        return this.f9827y;
    }

    private int v(boolean z10, @DimenRes int i10, int i11) {
        return z10 ? this.f9809g.getResources().getDimensionPixelSize(i10) : i11;
    }

    private boolean y(int i10) {
        return (i10 != 1 || this.f9820r == null || TextUtils.isEmpty(this.f9818p)) ? false : true;
    }

    boolean A() {
        return this.f9819q;
    }

    boolean B() {
        return this.f9826x;
    }

    void C(TextView textView, int i10) {
        FrameLayout frameLayout;
        if (this.f9811i == null) {
            return;
        }
        if (!z(i10) || (frameLayout = this.f9813k) == null) {
            this.f9811i.removeView(textView);
        } else {
            frameLayout.removeView(textView);
        }
        int i11 = this.f9812j - 1;
        this.f9812j = i11;
        O(this.f9811i, i11);
    }

    void E(int i10) {
        this.f9822t = i10;
        TextView textView = this.f9820r;
        if (textView != null) {
            ViewCompat.setAccessibilityLiveRegion(textView, i10);
        }
    }

    void F(@Nullable CharSequence charSequence) {
        this.f9821s = charSequence;
        TextView textView = this.f9820r;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    void G(boolean z10) {
        if (this.f9819q == z10) {
            return;
        }
        h();
        if (z10) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.f9809g);
            this.f9820r = appCompatTextView;
            appCompatTextView.setId(e4.f.P);
            this.f9820r.setTextAlignment(5);
            Typeface typeface = this.B;
            if (typeface != null) {
                this.f9820r.setTypeface(typeface);
            }
            H(this.f9823u);
            I(this.f9824v);
            F(this.f9821s);
            E(this.f9822t);
            this.f9820r.setVisibility(4);
            e(this.f9820r, 0);
        } else {
            w();
            C(this.f9820r, 0);
            this.f9820r = null;
            this.f9810h.p0();
            this.f9810h.A0();
        }
        this.f9819q = z10;
    }

    void H(@StyleRes int i10) {
        this.f9823u = i10;
        TextView textView = this.f9820r;
        if (textView != null) {
            this.f9810h.c0(textView, i10);
        }
    }

    void I(@Nullable ColorStateList colorStateList) {
        this.f9824v = colorStateList;
        TextView textView = this.f9820r;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    void J(@StyleRes int i10) {
        this.f9828z = i10;
        TextView textView = this.f9827y;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, i10);
        }
    }

    void K(boolean z10) {
        if (this.f9826x == z10) {
            return;
        }
        h();
        if (z10) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.f9809g);
            this.f9827y = appCompatTextView;
            appCompatTextView.setId(e4.f.Q);
            this.f9827y.setTextAlignment(5);
            Typeface typeface = this.B;
            if (typeface != null) {
                this.f9827y.setTypeface(typeface);
            }
            this.f9827y.setVisibility(4);
            ViewCompat.setAccessibilityLiveRegion(this.f9827y, 1);
            J(this.f9828z);
            L(this.A);
            e(this.f9827y, 1);
            this.f9827y.setAccessibilityDelegate(new b());
        } else {
            x();
            C(this.f9827y, 1);
            this.f9827y = null;
            this.f9810h.p0();
            this.f9810h.A0();
        }
        this.f9826x = z10;
    }

    void L(@Nullable ColorStateList colorStateList) {
        this.A = colorStateList;
        TextView textView = this.f9827y;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    void N(Typeface typeface) {
        if (typeface != this.B) {
            this.B = typeface;
            M(this.f9820r, typeface);
            M(this.f9827y, typeface);
        }
    }

    void Q(CharSequence charSequence) {
        h();
        this.f9818p = charSequence;
        this.f9820r.setText(charSequence);
        int i10 = this.f9816n;
        if (i10 != 1) {
            this.f9817o = 1;
        }
        S(i10, this.f9817o, P(this.f9820r, charSequence));
    }

    void R(CharSequence charSequence) {
        h();
        this.f9825w = charSequence;
        this.f9827y.setText(charSequence);
        int i10 = this.f9816n;
        if (i10 != 2) {
            this.f9817o = 2;
        }
        S(i10, this.f9817o, P(this.f9827y, charSequence));
    }

    void e(TextView textView, int i10) {
        if (this.f9811i == null && this.f9813k == null) {
            LinearLayout linearLayout = new LinearLayout(this.f9809g);
            this.f9811i = linearLayout;
            linearLayout.setOrientation(0);
            this.f9810h.addView(this.f9811i, -1, -2);
            this.f9813k = new FrameLayout(this.f9809g);
            this.f9811i.addView(this.f9813k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f9810h.getEditText() != null) {
                f();
            }
        }
        if (z(i10)) {
            this.f9813k.setVisibility(0);
            this.f9813k.addView(textView);
        } else {
            this.f9811i.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f9811i.setVisibility(0);
        this.f9812j++;
    }

    void f() {
        if (g()) {
            EditText editText = this.f9810h.getEditText();
            boolean zG = u4.c.g(this.f9809g);
            LinearLayout linearLayout = this.f9811i;
            int i10 = e4.d.G;
            ViewCompat.setPaddingRelative(linearLayout, v(zG, i10, ViewCompat.getPaddingStart(editText)), v(zG, e4.d.H, this.f9809g.getResources().getDimensionPixelSize(e4.d.F)), v(zG, i10, ViewCompat.getPaddingEnd(editText)), 0);
        }
    }

    void h() {
        Animator animator = this.f9814l;
        if (animator != null) {
            animator.cancel();
        }
    }

    boolean l() {
        return y(this.f9817o);
    }

    int n() {
        return this.f9822t;
    }

    @Nullable
    CharSequence o() {
        return this.f9821s;
    }

    @Nullable
    CharSequence p() {
        return this.f9818p;
    }

    @ColorInt
    int q() {
        TextView textView = this.f9820r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    @Nullable
    ColorStateList r() {
        TextView textView = this.f9820r;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    CharSequence s() {
        return this.f9825w;
    }

    @Nullable
    View t() {
        return this.f9827y;
    }

    @ColorInt
    int u() {
        TextView textView = this.f9827y;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    void w() {
        this.f9818p = null;
        h();
        if (this.f9816n == 1) {
            if (!this.f9826x || TextUtils.isEmpty(this.f9825w)) {
                this.f9817o = 0;
            } else {
                this.f9817o = 2;
            }
        }
        S(this.f9816n, this.f9817o, P(this.f9820r, ""));
    }

    void x() {
        h();
        int i10 = this.f9816n;
        if (i10 == 2) {
            this.f9817o = 0;
        }
        S(i10, this.f9817o, P(this.f9827y, ""));
    }

    boolean z(int i10) {
        return i10 == 0 || i10 == 1;
    }
}
