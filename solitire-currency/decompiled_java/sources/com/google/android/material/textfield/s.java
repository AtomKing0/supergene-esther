package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: EndCompoundLayout.java */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ViewConstructor"})
class s extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final TextInputLayout f9769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    private final FrameLayout f9770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private final CheckableImageButton f9771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ColorStateList f9772d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private PorterDuff.Mode f9773e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View.OnLongClickListener f9774f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    private final CheckableImageButton f9775g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final d f9776h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f9777i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final LinkedHashSet<TextInputLayout.g> f9778j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ColorStateList f9779k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private PorterDuff.Mode f9780l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f9781m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    private ImageView.ScaleType f9782n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private View.OnLongClickListener f9783o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private CharSequence f9784p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    private final TextView f9785q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f9786r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private EditText f9787s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private final AccessibilityManager f9788t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private AccessibilityManagerCompat.TouchExplorationStateChangeListener f9789u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final TextWatcher f9790v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final TextInputLayout.f f9791w;

    /* JADX INFO: compiled from: EndCompoundLayout.java */
    class a extends com.google.android.material.internal.o {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            s.this.m().a(editable);
        }

        @Override // com.google.android.material.internal.o, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            s.this.m().b(charSequence, i10, i11, i12);
        }
    }

    /* JADX INFO: compiled from: EndCompoundLayout.java */
    class b implements TextInputLayout.f {
        b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(@NonNull TextInputLayout textInputLayout) {
            if (s.this.f9787s == textInputLayout.getEditText()) {
                return;
            }
            if (s.this.f9787s != null) {
                s.this.f9787s.removeTextChangedListener(s.this.f9790v);
                if (s.this.f9787s.getOnFocusChangeListener() == s.this.m().e()) {
                    s.this.f9787s.setOnFocusChangeListener(null);
                }
            }
            s.this.f9787s = textInputLayout.getEditText();
            if (s.this.f9787s != null) {
                s.this.f9787s.addTextChangedListener(s.this.f9790v);
            }
            s.this.m().n(s.this.f9787s);
            s sVar = s.this;
            sVar.h0(sVar.m());
        }
    }

    /* JADX INFO: compiled from: EndCompoundLayout.java */
    class c implements View.OnAttachStateChangeListener {
        c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            s.this.g();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            s.this.M();
        }
    }

    /* JADX INFO: compiled from: EndCompoundLayout.java */
    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SparseArray<t> f9795a = new SparseArray<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final s f9796b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f9797c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f9798d;

        d(s sVar, TintTypedArray tintTypedArray) {
            this.f9796b = sVar;
            this.f9797c = tintTypedArray.getResourceId(e4.k.S5, 0);
            this.f9798d = tintTypedArray.getResourceId(e4.k.f25053q6, 0);
        }

        private t b(int i10) {
            if (i10 == -1) {
                return new g(this.f9796b);
            }
            if (i10 == 0) {
                return new x(this.f9796b);
            }
            if (i10 == 1) {
                return new z(this.f9796b, this.f9798d);
            }
            if (i10 == 2) {
                return new f(this.f9796b);
            }
            if (i10 == 3) {
                return new q(this.f9796b);
            }
            throw new IllegalArgumentException("Invalid end icon mode: " + i10);
        }

        t c(int i10) {
            t tVar = this.f9795a.get(i10);
            if (tVar != null) {
                return tVar;
            }
            t tVarB = b(i10);
            this.f9795a.append(i10, tVarB);
            return tVarB;
        }
    }

    s(TextInputLayout textInputLayout, TintTypedArray tintTypedArray) {
        super(textInputLayout.getContext());
        this.f9777i = 0;
        this.f9778j = new LinkedHashSet<>();
        this.f9790v = new a();
        b bVar = new b();
        this.f9791w = bVar;
        this.f9788t = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f9769a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.END));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f9770b = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        CheckableImageButton checkableImageButtonI = i(this, layoutInflaterFrom, e4.f.N);
        this.f9771c = checkableImageButtonI;
        CheckableImageButton checkableImageButtonI2 = i(frameLayout, layoutInflaterFrom, e4.f.M);
        this.f9775g = checkableImageButtonI2;
        this.f9776h = new d(this, tintTypedArray);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f9785q = appCompatTextView;
        C(tintTypedArray);
        B(tintTypedArray);
        D(tintTypedArray);
        frameLayout.addView(checkableImageButtonI2);
        addView(appCompatTextView);
        addView(frameLayout);
        addView(checkableImageButtonI);
        textInputLayout.i(bVar);
        addOnAttachStateChangeListener(new c());
    }

    private void B(TintTypedArray tintTypedArray) {
        int i10 = e4.k.f25061r6;
        if (!tintTypedArray.hasValue(i10)) {
            int i11 = e4.k.W5;
            if (tintTypedArray.hasValue(i11)) {
                this.f9779k = u4.c.b(getContext(), tintTypedArray, i11);
            }
            int i12 = e4.k.X5;
            if (tintTypedArray.hasValue(i12)) {
                this.f9780l = com.google.android.material.internal.s.i(tintTypedArray.getInt(i12, -1), null);
            }
        }
        int i13 = e4.k.U5;
        if (tintTypedArray.hasValue(i13)) {
            U(tintTypedArray.getInt(i13, 0));
            int i14 = e4.k.R5;
            if (tintTypedArray.hasValue(i14)) {
                Q(tintTypedArray.getText(i14));
            }
            O(tintTypedArray.getBoolean(e4.k.Q5, true));
        } else if (tintTypedArray.hasValue(i10)) {
            int i15 = e4.k.f25069s6;
            if (tintTypedArray.hasValue(i15)) {
                this.f9779k = u4.c.b(getContext(), tintTypedArray, i15);
            }
            int i16 = e4.k.f25077t6;
            if (tintTypedArray.hasValue(i16)) {
                this.f9780l = com.google.android.material.internal.s.i(tintTypedArray.getInt(i16, -1), null);
            }
            U(tintTypedArray.getBoolean(i10, false) ? 1 : 0);
            Q(tintTypedArray.getText(e4.k.f25045p6));
        }
        T(tintTypedArray.getDimensionPixelSize(e4.k.T5, getResources().getDimensionPixelSize(e4.d.Z)));
        int i17 = e4.k.V5;
        if (tintTypedArray.hasValue(i17)) {
            X(u.b(tintTypedArray.getInt(i17, -1)));
        }
    }

    private void C(TintTypedArray tintTypedArray) {
        int i10 = e4.k.f24941c6;
        if (tintTypedArray.hasValue(i10)) {
            this.f9772d = u4.c.b(getContext(), tintTypedArray, i10);
        }
        int i11 = e4.k.f24949d6;
        if (tintTypedArray.hasValue(i11)) {
            this.f9773e = com.google.android.material.internal.s.i(tintTypedArray.getInt(i11, -1), null);
        }
        int i12 = e4.k.f24933b6;
        if (tintTypedArray.hasValue(i12)) {
            c0(tintTypedArray.getDrawable(i12));
        }
        this.f9771c.setContentDescription(getResources().getText(e4.i.f24877f));
        ViewCompat.setImportantForAccessibility(this.f9771c, 2);
        this.f9771c.setClickable(false);
        this.f9771c.setPressable(false);
        this.f9771c.setFocusable(false);
    }

    private void D(TintTypedArray tintTypedArray) {
        this.f9785q.setVisibility(8);
        this.f9785q.setId(e4.f.T);
        this.f9785q.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        ViewCompat.setAccessibilityLiveRegion(this.f9785q, 1);
        q0(tintTypedArray.getResourceId(e4.k.I6, 0));
        int i10 = e4.k.J6;
        if (tintTypedArray.hasValue(i10)) {
            r0(tintTypedArray.getColorStateList(i10));
        }
        p0(tintTypedArray.getText(e4.k.H6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        AccessibilityManager accessibilityManager;
        AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener = this.f9789u;
        if (touchExplorationStateChangeListener == null || (accessibilityManager = this.f9788t) == null) {
            return;
        }
        AccessibilityManagerCompat.removeTouchExplorationStateChangeListener(accessibilityManager, touchExplorationStateChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f9789u == null || this.f9788t == null || !ViewCompat.isAttachedToWindow(this)) {
            return;
        }
        AccessibilityManagerCompat.addTouchExplorationStateChangeListener(this.f9788t, this.f9789u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(t tVar) {
        if (this.f9787s == null) {
            return;
        }
        if (tVar.e() != null) {
            this.f9787s.setOnFocusChangeListener(tVar.e());
        }
        if (tVar.g() != null) {
            this.f9775g.setOnFocusChangeListener(tVar.g());
        }
    }

    private CheckableImageButton i(ViewGroup viewGroup, LayoutInflater layoutInflater, @IdRes int i10) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(e4.h.f24853e, viewGroup, false);
        checkableImageButton.setId(i10);
        u.e(checkableImageButton);
        if (u4.c.g(getContext())) {
            MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        return checkableImageButton;
    }

    private void j(int i10) {
        Iterator<TextInputLayout.g> it = this.f9778j.iterator();
        while (it.hasNext()) {
            it.next().a(this.f9769a, i10);
        }
    }

    private void s0(@NonNull t tVar) {
        tVar.s();
        this.f9789u = tVar.h();
        g();
    }

    private int t(t tVar) {
        int i10 = this.f9776h.f9797c;
        return i10 == 0 ? tVar.d() : i10;
    }

    private void t0(@NonNull t tVar) {
        M();
        this.f9789u = null;
        tVar.u();
    }

    private void u0(boolean z10) {
        if (!z10 || n() == null) {
            u.a(this.f9769a, this.f9775g, this.f9779k, this.f9780l);
            return;
        }
        Drawable drawableMutate = DrawableCompat.wrap(n()).mutate();
        DrawableCompat.setTint(drawableMutate, this.f9769a.getErrorCurrentTextColors());
        this.f9775g.setImageDrawable(drawableMutate);
    }

    private void v0() {
        this.f9770b.setVisibility((this.f9775g.getVisibility() != 0 || G()) ? 8 : 0);
        setVisibility(F() || G() || ((this.f9784p == null || this.f9786r) ? '\b' : (char) 0) == 0 ? 0 : 8);
    }

    private void w0() {
        this.f9771c.setVisibility(s() != null && this.f9769a.N() && this.f9769a.d0() ? 0 : 8);
        v0();
        x0();
        if (A()) {
            return;
        }
        this.f9769a.o0();
    }

    private void y0() {
        int visibility = this.f9785q.getVisibility();
        int i10 = (this.f9784p == null || this.f9786r) ? 8 : 0;
        if (visibility != i10) {
            m().q(i10 == 0);
        }
        v0();
        this.f9785q.setVisibility(i10);
        this.f9769a.o0();
    }

    boolean A() {
        return this.f9777i != 0;
    }

    boolean E() {
        return A() && this.f9775g.isChecked();
    }

    boolean F() {
        return this.f9770b.getVisibility() == 0 && this.f9775g.getVisibility() == 0;
    }

    boolean G() {
        return this.f9771c.getVisibility() == 0;
    }

    void H(boolean z10) {
        this.f9786r = z10;
        y0();
    }

    void I() {
        w0();
        K();
        J();
        if (m().t()) {
            u0(this.f9769a.d0());
        }
    }

    void J() {
        u.d(this.f9769a, this.f9775g, this.f9779k);
    }

    void K() {
        u.d(this.f9769a, this.f9771c, this.f9772d);
    }

    void L(boolean z10) {
        boolean z11;
        boolean zIsActivated;
        boolean zIsChecked;
        t tVarM = m();
        boolean z12 = true;
        if (!tVarM.l() || (zIsChecked = this.f9775g.isChecked()) == tVarM.m()) {
            z11 = false;
        } else {
            this.f9775g.setChecked(!zIsChecked);
            z11 = true;
        }
        if (!tVarM.j() || (zIsActivated = this.f9775g.isActivated()) == tVarM.k()) {
            z12 = z11;
        } else {
            N(!zIsActivated);
        }
        if (z10 || z12) {
            J();
        }
    }

    void N(boolean z10) {
        this.f9775g.setActivated(z10);
    }

    void O(boolean z10) {
        this.f9775g.setCheckable(z10);
    }

    void P(@StringRes int i10) {
        Q(i10 != 0 ? getResources().getText(i10) : null);
    }

    void Q(@Nullable CharSequence charSequence) {
        if (l() != charSequence) {
            this.f9775g.setContentDescription(charSequence);
        }
    }

    void R(@DrawableRes int i10) {
        S(i10 != 0 ? AppCompatResources.getDrawable(getContext(), i10) : null);
    }

    void S(@Nullable Drawable drawable) {
        this.f9775g.setImageDrawable(drawable);
        if (drawable != null) {
            u.a(this.f9769a, this.f9775g, this.f9779k, this.f9780l);
            J();
        }
    }

    void T(@Px int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (i10 != this.f9781m) {
            this.f9781m = i10;
            u.g(this.f9775g, i10);
            u.g(this.f9771c, i10);
        }
    }

    void U(int i10) {
        if (this.f9777i == i10) {
            return;
        }
        t0(m());
        int i11 = this.f9777i;
        this.f9777i = i10;
        j(i11);
        a0(i10 != 0);
        t tVarM = m();
        R(t(tVarM));
        P(tVarM.c());
        O(tVarM.l());
        if (!tVarM.i(this.f9769a.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + this.f9769a.getBoxBackgroundMode() + " is not supported by the end icon mode " + i10);
        }
        s0(tVarM);
        V(tVarM.f());
        EditText editText = this.f9787s;
        if (editText != null) {
            tVarM.n(editText);
            h0(tVarM);
        }
        u.a(this.f9769a, this.f9775g, this.f9779k, this.f9780l);
        L(true);
    }

    void V(@Nullable View.OnClickListener onClickListener) {
        u.h(this.f9775g, onClickListener, this.f9783o);
    }

    void W(@Nullable View.OnLongClickListener onLongClickListener) {
        this.f9783o = onLongClickListener;
        u.i(this.f9775g, onLongClickListener);
    }

    void X(@NonNull ImageView.ScaleType scaleType) {
        this.f9782n = scaleType;
        u.j(this.f9775g, scaleType);
        u.j(this.f9771c, scaleType);
    }

    void Y(@Nullable ColorStateList colorStateList) {
        if (this.f9779k != colorStateList) {
            this.f9779k = colorStateList;
            u.a(this.f9769a, this.f9775g, colorStateList, this.f9780l);
        }
    }

    void Z(@Nullable PorterDuff.Mode mode) {
        if (this.f9780l != mode) {
            this.f9780l = mode;
            u.a(this.f9769a, this.f9775g, this.f9779k, mode);
        }
    }

    void a0(boolean z10) {
        if (F() != z10) {
            this.f9775g.setVisibility(z10 ? 0 : 8);
            v0();
            x0();
            this.f9769a.o0();
        }
    }

    void b0(@DrawableRes int i10) {
        c0(i10 != 0 ? AppCompatResources.getDrawable(getContext(), i10) : null);
        K();
    }

    void c0(@Nullable Drawable drawable) {
        this.f9771c.setImageDrawable(drawable);
        w0();
        u.a(this.f9769a, this.f9771c, this.f9772d, this.f9773e);
    }

    void d0(@Nullable View.OnClickListener onClickListener) {
        u.h(this.f9771c, onClickListener, this.f9774f);
    }

    void e0(@Nullable View.OnLongClickListener onLongClickListener) {
        this.f9774f = onLongClickListener;
        u.i(this.f9771c, onLongClickListener);
    }

    void f0(@Nullable ColorStateList colorStateList) {
        if (this.f9772d != colorStateList) {
            this.f9772d = colorStateList;
            u.a(this.f9769a, this.f9771c, colorStateList, this.f9773e);
        }
    }

    void g0(@Nullable PorterDuff.Mode mode) {
        if (this.f9773e != mode) {
            this.f9773e = mode;
            u.a(this.f9769a, this.f9771c, this.f9772d, mode);
        }
    }

    void h() {
        this.f9775g.performClick();
        this.f9775g.jumpDrawablesToCurrentState();
    }

    void i0(@StringRes int i10) {
        j0(i10 != 0 ? getResources().getText(i10) : null);
    }

    void j0(@Nullable CharSequence charSequence) {
        this.f9775g.setContentDescription(charSequence);
    }

    @Nullable
    CheckableImageButton k() {
        if (G()) {
            return this.f9771c;
        }
        if (A() && F()) {
            return this.f9775g;
        }
        return null;
    }

    void k0(@DrawableRes int i10) {
        l0(i10 != 0 ? AppCompatResources.getDrawable(getContext(), i10) : null);
    }

    @Nullable
    CharSequence l() {
        return this.f9775g.getContentDescription();
    }

    void l0(@Nullable Drawable drawable) {
        this.f9775g.setImageDrawable(drawable);
    }

    t m() {
        return this.f9776h.c(this.f9777i);
    }

    void m0(boolean z10) {
        if (z10 && this.f9777i != 1) {
            U(1);
        } else {
            if (z10) {
                return;
            }
            U(0);
        }
    }

    @Nullable
    Drawable n() {
        return this.f9775g.getDrawable();
    }

    void n0(@Nullable ColorStateList colorStateList) {
        this.f9779k = colorStateList;
        u.a(this.f9769a, this.f9775g, colorStateList, this.f9780l);
    }

    int o() {
        return this.f9781m;
    }

    void o0(@Nullable PorterDuff.Mode mode) {
        this.f9780l = mode;
        u.a(this.f9769a, this.f9775g, this.f9779k, mode);
    }

    int p() {
        return this.f9777i;
    }

    void p0(@Nullable CharSequence charSequence) {
        this.f9784p = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f9785q.setText(charSequence);
        y0();
    }

    @NonNull
    ImageView.ScaleType q() {
        return this.f9782n;
    }

    void q0(@StyleRes int i10) {
        TextViewCompat.setTextAppearance(this.f9785q, i10);
    }

    CheckableImageButton r() {
        return this.f9775g;
    }

    void r0(@NonNull ColorStateList colorStateList) {
        this.f9785q.setTextColor(colorStateList);
    }

    Drawable s() {
        return this.f9771c.getDrawable();
    }

    @Nullable
    CharSequence u() {
        return this.f9775g.getContentDescription();
    }

    @Nullable
    Drawable v() {
        return this.f9775g.getDrawable();
    }

    @Nullable
    CharSequence w() {
        return this.f9784p;
    }

    @Nullable
    ColorStateList x() {
        return this.f9785q.getTextColors();
    }

    void x0() {
        if (this.f9769a.f9663d == null) {
            return;
        }
        ViewCompat.setPaddingRelative(this.f9785q, getContext().getResources().getDimensionPixelSize(e4.d.I), this.f9769a.f9663d.getPaddingTop(), (F() || G()) ? 0 : ViewCompat.getPaddingEnd(this.f9769a.f9663d), this.f9769a.f9663d.getPaddingBottom());
    }

    int y() {
        return ViewCompat.getPaddingEnd(this) + ViewCompat.getPaddingEnd(this.f9785q) + ((F() || G()) ? this.f9775g.getMeasuredWidth() + MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) this.f9775g.getLayoutParams()) : 0);
    }

    TextView z() {
        return this.f9785q;
    }
}
