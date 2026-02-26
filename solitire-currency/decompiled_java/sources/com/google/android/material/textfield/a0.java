package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: compiled from: StartCompoundLayout.java */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ViewConstructor"})
class a0 extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextInputLayout f9718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextView f9719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private CharSequence f9720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CheckableImageButton f9721d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ColorStateList f9722e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private PorterDuff.Mode f9723f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f9724g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    private ImageView.ScaleType f9725h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private View.OnLongClickListener f9726i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f9727j;

    a0(TextInputLayout textInputLayout, TintTypedArray tintTypedArray) {
        super(textInputLayout.getContext());
        this.f9718a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.START));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(e4.h.f24854f, (ViewGroup) this, false);
        this.f9721d = checkableImageButton;
        u.e(checkableImageButton);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f9719b = appCompatTextView;
        j(tintTypedArray);
        i(tintTypedArray);
        addView(checkableImageButton);
        addView(appCompatTextView);
    }

    private void C() {
        int i10 = (this.f9720c == null || this.f9727j) ? 8 : 0;
        setVisibility(this.f9721d.getVisibility() == 0 || i10 == 0 ? 0 : 8);
        this.f9719b.setVisibility(i10);
        this.f9718a.o0();
    }

    private void i(TintTypedArray tintTypedArray) {
        this.f9719b.setVisibility(8);
        this.f9719b.setId(e4.f.S);
        this.f9719b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ViewCompat.setAccessibilityLiveRegion(this.f9719b, 1);
        o(tintTypedArray.getResourceId(e4.k.f25117y6, 0));
        int i10 = e4.k.f25125z6;
        if (tintTypedArray.hasValue(i10)) {
            p(tintTypedArray.getColorStateList(i10));
        }
        n(tintTypedArray.getText(e4.k.f25109x6));
    }

    private void j(TintTypedArray tintTypedArray) {
        if (u4.c.g(getContext())) {
            MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) this.f9721d.getLayoutParams(), 0);
        }
        u(null);
        v(null);
        int i10 = e4.k.F6;
        if (tintTypedArray.hasValue(i10)) {
            this.f9722e = u4.c.b(getContext(), tintTypedArray, i10);
        }
        int i11 = e4.k.G6;
        if (tintTypedArray.hasValue(i11)) {
            this.f9723f = com.google.android.material.internal.s.i(tintTypedArray.getInt(i11, -1), null);
        }
        int i12 = e4.k.C6;
        if (tintTypedArray.hasValue(i12)) {
            s(tintTypedArray.getDrawable(i12));
            int i13 = e4.k.B6;
            if (tintTypedArray.hasValue(i13)) {
                r(tintTypedArray.getText(i13));
            }
            q(tintTypedArray.getBoolean(e4.k.A6, true));
        }
        t(tintTypedArray.getDimensionPixelSize(e4.k.D6, getResources().getDimensionPixelSize(e4.d.Z)));
        int i14 = e4.k.E6;
        if (tintTypedArray.hasValue(i14)) {
            w(u.b(tintTypedArray.getInt(i14, -1)));
        }
    }

    void A(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (this.f9719b.getVisibility() != 0) {
            accessibilityNodeInfoCompat.setTraversalAfter(this.f9721d);
        } else {
            accessibilityNodeInfoCompat.setLabelFor(this.f9719b);
            accessibilityNodeInfoCompat.setTraversalAfter(this.f9719b);
        }
    }

    void B() {
        EditText editText = this.f9718a.f9663d;
        if (editText == null) {
            return;
        }
        ViewCompat.setPaddingRelative(this.f9719b, k() ? 0 : ViewCompat.getPaddingStart(editText), editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(e4.d.I), editText.getCompoundPaddingBottom());
    }

    @Nullable
    CharSequence a() {
        return this.f9720c;
    }

    @Nullable
    ColorStateList b() {
        return this.f9719b.getTextColors();
    }

    int c() {
        return ViewCompat.getPaddingStart(this) + ViewCompat.getPaddingStart(this.f9719b) + (k() ? this.f9721d.getMeasuredWidth() + MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) this.f9721d.getLayoutParams()) : 0);
    }

    @NonNull
    TextView d() {
        return this.f9719b;
    }

    @Nullable
    CharSequence e() {
        return this.f9721d.getContentDescription();
    }

    @Nullable
    Drawable f() {
        return this.f9721d.getDrawable();
    }

    int g() {
        return this.f9724g;
    }

    @NonNull
    ImageView.ScaleType h() {
        return this.f9725h;
    }

    boolean k() {
        return this.f9721d.getVisibility() == 0;
    }

    void l(boolean z10) {
        this.f9727j = z10;
        C();
    }

    void m() {
        u.d(this.f9718a, this.f9721d, this.f9722e);
    }

    void n(@Nullable CharSequence charSequence) {
        this.f9720c = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f9719b.setText(charSequence);
        C();
    }

    void o(@StyleRes int i10) {
        TextViewCompat.setTextAppearance(this.f9719b, i10);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        B();
    }

    void p(@NonNull ColorStateList colorStateList) {
        this.f9719b.setTextColor(colorStateList);
    }

    void q(boolean z10) {
        this.f9721d.setCheckable(z10);
    }

    void r(@Nullable CharSequence charSequence) {
        if (e() != charSequence) {
            this.f9721d.setContentDescription(charSequence);
        }
    }

    void s(@Nullable Drawable drawable) {
        this.f9721d.setImageDrawable(drawable);
        if (drawable != null) {
            u.a(this.f9718a, this.f9721d, this.f9722e, this.f9723f);
            z(true);
            m();
        } else {
            z(false);
            u(null);
            v(null);
            r(null);
        }
    }

    void t(@Px int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (i10 != this.f9724g) {
            this.f9724g = i10;
            u.g(this.f9721d, i10);
        }
    }

    void u(@Nullable View.OnClickListener onClickListener) {
        u.h(this.f9721d, onClickListener, this.f9726i);
    }

    void v(@Nullable View.OnLongClickListener onLongClickListener) {
        this.f9726i = onLongClickListener;
        u.i(this.f9721d, onLongClickListener);
    }

    void w(@NonNull ImageView.ScaleType scaleType) {
        this.f9725h = scaleType;
        u.j(this.f9721d, scaleType);
    }

    void x(@Nullable ColorStateList colorStateList) {
        if (this.f9722e != colorStateList) {
            this.f9722e = colorStateList;
            u.a(this.f9718a, this.f9721d, colorStateList, this.f9723f);
        }
    }

    void y(@Nullable PorterDuff.Mode mode) {
        if (this.f9723f != mode) {
            this.f9723f = mode;
            u.a(this.f9718a, this.f9721d, this.f9722e, mode);
        }
    }

    void z(boolean z10) {
        if (k() != z10) {
            this.f9721d.setVisibility(z10 ? 0 : 8);
            B();
            C();
        }
    }
}
