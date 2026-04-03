package com.google.android.material.textfield;

import android.R;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;
import x4.k;

/* JADX INFO: loaded from: classes3.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    private static final int C0 = e4.j.f24902h;
    private static final int[][] D0 = {new int[]{R.attr.state_pressed}, new int[0]};

    @Nullable
    private ColorStateList A;
    private boolean A0;

    @Nullable
    private ColorStateList B;
    private boolean B0;
    private boolean C;
    private CharSequence D;
    private boolean E;

    @Nullable
    private x4.g F;
    private x4.g G;
    private StateListDrawable H;
    private boolean I;

    @Nullable
    private x4.g J;

    @Nullable
    private x4.g K;

    @NonNull
    private x4.k L;
    private boolean M;
    private final int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private int S;

    @ColorInt
    private int T;

    @ColorInt
    private int U;
    private final Rect V;
    private final Rect W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f9657a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private final RectF f9658a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    private final a0 f9659b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private Typeface f9660b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private final s f9661c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    @Nullable
    private Drawable f9662c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    EditText f9663d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private int f9664d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CharSequence f9665e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private final LinkedHashSet<f> f9666e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f9667f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    @Nullable
    private Drawable f9668f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f9669g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private int f9670g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f9671h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private Drawable f9672h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f9673i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private ColorStateList f9674i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final v f9675j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private ColorStateList f9676j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f9677k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    @ColorInt
    private int f9678k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f9679l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    @ColorInt
    private int f9680l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f9681m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    @ColorInt
    private int f9682m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    private e f9683n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private ColorStateList f9684n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private TextView f9685o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    @ColorInt
    private int f9686o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f9687p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    @ColorInt
    private int f9688p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f9689q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    @ColorInt
    private int f9690q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private CharSequence f9691r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    @ColorInt
    private int f9692r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f9693s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    @ColorInt
    private int f9694s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private TextView f9695t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    int f9696t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private ColorStateList f9697u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private boolean f9698u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f9699v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    final com.google.android.material.internal.a f9700v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    private Fade f9701w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private boolean f9702w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    private Fade f9703x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private boolean f9704x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    private ColorStateList f9705y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private ValueAnimator f9706y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    private ColorStateList f9707z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private boolean f9708z0;

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f9661c.h();
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            TextInputLayout.this.f9700v0.c0(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static class d extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TextInputLayout f9714a;

        public d(@NonNull TextInputLayout textInputLayout) {
            this.f9714a = textInputLayout;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            EditText editText = this.f9714a.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f9714a.getHint();
            CharSequence error = this.f9714a.getError();
            CharSequence placeholderText = this.f9714a.getPlaceholderText();
            int counterMaxLength = this.f9714a.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f9714a.getCounterOverflowDescription();
            boolean z10 = !TextUtils.isEmpty(text);
            boolean z11 = !TextUtils.isEmpty(hint);
            boolean z12 = !this.f9714a.P();
            boolean z13 = !TextUtils.isEmpty(error);
            boolean z14 = z13 || !TextUtils.isEmpty(counterOverflowDescription);
            String string = z11 ? hint.toString() : "";
            this.f9714a.f9659b.A(accessibilityNodeInfoCompat);
            if (z10) {
                accessibilityNodeInfoCompat.setText(text);
            } else if (!TextUtils.isEmpty(string)) {
                accessibilityNodeInfoCompat.setText(string);
                if (z12 && placeholderText != null) {
                    accessibilityNodeInfoCompat.setText(string + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                accessibilityNodeInfoCompat.setText(placeholderText);
            }
            if (!TextUtils.isEmpty(string)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    accessibilityNodeInfoCompat.setHintText(string);
                } else {
                    if (z10) {
                        string = ((Object) text) + ", " + string;
                    }
                    accessibilityNodeInfoCompat.setText(string);
                }
                accessibilityNodeInfoCompat.setShowingHintText(!z10);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            accessibilityNodeInfoCompat.setMaxTextLength(counterMaxLength);
            if (z14) {
                if (!z13) {
                    error = counterOverflowDescription;
                }
                accessibilityNodeInfoCompat.setError(error);
            }
            View viewT = this.f9714a.f9675j.t();
            if (viewT != null) {
                accessibilityNodeInfoCompat.setLabelFor(viewT);
            }
            this.f9714a.f9661c.m().o(view, accessibilityNodeInfoCompat);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            this.f9714a.f9661c.m().p(view, accessibilityEvent);
        }
    }

    public interface e {
        int a(@Nullable Editable editable);
    }

    public interface f {
        void a(@NonNull TextInputLayout textInputLayout);
    }

    public interface g {
        void a(@NonNull TextInputLayout textInputLayout, int i10);
    }

    static class h extends AbsSavedState {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        CharSequence f9715a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f9716b;

        class a implements Parcelable.ClassLoaderCreator<h> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(@NonNull Parcel parcel) {
                return new h(parcel, null);
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

        h(Parcelable parcelable) {
            super(parcelable);
        }

        @NonNull
        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f9715a) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            TextUtils.writeToParcel(this.f9715a, parcel, i10);
            parcel.writeInt(this.f9716b ? 1 : 0);
        }

        h(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f9715a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f9716b = parcel.readInt() == 1;
        }
    }

    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, e4.b.Y);
    }

    private Fade A() {
        Fade fade = new Fade();
        fade.setDuration(s4.h.f(getContext(), e4.b.D, 87));
        fade.setInterpolator(s4.h.g(getContext(), e4.b.J, f4.a.f25668a));
        return fade;
    }

    private boolean B() {
        return this.C && !TextUtils.isEmpty(this.D) && (this.F instanceof com.google.android.material.textfield.h);
    }

    private void C() {
        Iterator<f> it = this.f9666e0.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    private void D(Canvas canvas) {
        x4.g gVar;
        if (this.K == null || (gVar = this.J) == null) {
            return;
        }
        gVar.draw(canvas);
        if (this.f9663d.isFocused()) {
            Rect bounds = this.K.getBounds();
            Rect bounds2 = this.J.getBounds();
            float fX = this.f9700v0.x();
            int iCenterX = bounds2.centerX();
            bounds.left = f4.a.c(iCenterX, bounds2.left, fX);
            bounds.right = f4.a.c(iCenterX, bounds2.right, fX);
            this.K.draw(canvas);
        }
    }

    private void E(@NonNull Canvas canvas) {
        if (this.C) {
            this.f9700v0.l(canvas);
        }
    }

    private void F(boolean z10) {
        ValueAnimator valueAnimator = this.f9706y0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f9706y0.cancel();
        }
        if (z10 && this.f9704x0) {
            l(0.0f);
        } else {
            this.f9700v0.c0(0.0f);
        }
        if (B() && ((com.google.android.material.textfield.h) this.F).m0()) {
            y();
        }
        this.f9698u0 = true;
        L();
        this.f9659b.l(true);
        this.f9661c.H(true);
    }

    private x4.g G(boolean z10) {
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(e4.d.f24777a0);
        float f10 = z10 ? dimensionPixelOffset : 0.0f;
        EditText editText = this.f9663d;
        float popupElevation = editText instanceof w ? ((w) editText).getPopupElevation() : getResources().getDimensionPixelOffset(e4.d.f24799r);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(e4.d.Y);
        x4.k kVarM = x4.k.a().A(f10).E(f10).s(dimensionPixelOffset).w(dimensionPixelOffset).m();
        EditText editText2 = this.f9663d;
        x4.g gVarM = x4.g.m(getContext(), popupElevation, editText2 instanceof w ? ((w) editText2).getDropDownBackgroundTintList() : null);
        gVarM.setShapeAppearanceModel(kVarM);
        gVarM.a0(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        return gVarM;
    }

    private static Drawable H(x4.g gVar, int i10, int i11, int[][] iArr) {
        return new RippleDrawable(new ColorStateList(iArr, new int[]{n4.a.j(i11, i10, 0.1f), i10}), gVar, gVar);
    }

    private int I(int i10, boolean z10) {
        return i10 + ((z10 || getPrefixText() == null) ? (!z10 || getSuffixText() == null) ? this.f9663d.getCompoundPaddingLeft() : this.f9661c.y() : this.f9659b.c());
    }

    private int J(int i10, boolean z10) {
        return i10 - ((z10 || getSuffixText() == null) ? (!z10 || getPrefixText() == null) ? this.f9663d.getCompoundPaddingRight() : this.f9659b.c() : this.f9661c.y());
    }

    private static Drawable K(Context context, x4.g gVar, int i10, int[][] iArr) {
        int iC = n4.a.c(context, e4.b.f24756m, "TextInputLayout");
        x4.g gVar2 = new x4.g(gVar.C());
        int iJ = n4.a.j(i10, iC, 0.1f);
        gVar2.Y(new ColorStateList(iArr, new int[]{iJ, 0}));
        gVar2.setTint(iC);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iJ, iC});
        x4.g gVar3 = new x4.g(gVar.C());
        gVar3.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, gVar2, gVar3), gVar});
    }

    private void L() {
        TextView textView = this.f9695t;
        if (textView == null || !this.f9693s) {
            return;
        }
        textView.setText((CharSequence) null);
        TransitionManager.beginDelayedTransition(this.f9657a, this.f9703x);
        this.f9695t.setVisibility(4);
    }

    private boolean Q() {
        return d0() || (this.f9685o != null && this.f9681m);
    }

    private boolean S() {
        return this.O == 1 && this.f9663d.getMinLines() <= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int T(Editable editable) {
        if (editable != null) {
            return editable.length();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U() {
        this.f9663d.requestLayout();
    }

    private void V() {
        p();
        r0();
        A0();
        h0();
        k();
        if (this.O != 0) {
            t0();
        }
        b0();
    }

    private void W() {
        if (B()) {
            RectF rectF = this.f9658a0;
            this.f9700v0.o(rectF, this.f9663d.getWidth(), this.f9663d.getGravity());
            if (rectF.width() <= 0.0f || rectF.height() <= 0.0f) {
                return;
            }
            o(rectF);
            rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.Q);
            ((com.google.android.material.textfield.h) this.F).p0(rectF);
        }
    }

    private void X() {
        if (!B() || this.f9698u0) {
            return;
        }
        y();
        W();
    }

    private static void Y(@NonNull ViewGroup viewGroup, boolean z10) {
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            childAt.setEnabled(z10);
            if (childAt instanceof ViewGroup) {
                Y((ViewGroup) childAt, z10);
            }
        }
    }

    private void a0() {
        TextView textView = this.f9695t;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void b0() {
        EditText editText = this.f9663d;
        if (editText instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i10 = this.O;
                if (i10 == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i10 == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    private boolean e0() {
        return (this.f9661c.G() || ((this.f9661c.A() && M()) || this.f9661c.w() != null)) && this.f9661c.getMeasuredWidth() > 0;
    }

    private boolean f0() {
        return (getStartIconDrawable() != null || (getPrefixText() != null && getPrefixTextView().getVisibility() == 0)) && this.f9659b.getMeasuredWidth() > 0;
    }

    private void g0() {
        if (this.f9695t == null || !this.f9693s || TextUtils.isEmpty(this.f9691r)) {
            return;
        }
        this.f9695t.setText(this.f9691r);
        TransitionManager.beginDelayedTransition(this.f9657a, this.f9701w);
        this.f9695t.setVisibility(0);
        this.f9695t.bringToFront();
        announceForAccessibility(this.f9691r);
    }

    @Nullable
    private Drawable getEditTextBoxBackground() {
        EditText editText = this.f9663d;
        if (!(editText instanceof AutoCompleteTextView) || r.a(editText)) {
            return this.F;
        }
        int iD = n4.a.d(this.f9663d, e4.b.f24750g);
        int i10 = this.O;
        if (i10 == 2) {
            return K(getContext(), this.F, iD, D0);
        }
        if (i10 == 1) {
            return H(this.F, this.U, iD, D0);
        }
        return null;
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.H == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.H = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.H.addState(new int[0], G(false));
        }
        return this.H;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.G == null) {
            this.G = G(true);
        }
        return this.G;
    }

    private void h0() {
        if (this.O == 1) {
            if (u4.c.h(getContext())) {
                this.P = getResources().getDimensionPixelSize(e4.d.E);
            } else if (u4.c.g(getContext())) {
                this.P = getResources().getDimensionPixelSize(e4.d.D);
            }
        }
    }

    private void i0(@NonNull Rect rect) {
        x4.g gVar = this.J;
        if (gVar != null) {
            int i10 = rect.bottom;
            gVar.setBounds(rect.left, i10 - this.R, rect.right, i10);
        }
        x4.g gVar2 = this.K;
        if (gVar2 != null) {
            int i11 = rect.bottom;
            gVar2.setBounds(rect.left, i11 - this.S, rect.right, i11);
        }
    }

    private void j() {
        TextView textView = this.f9695t;
        if (textView != null) {
            this.f9657a.addView(textView);
            this.f9695t.setVisibility(0);
        }
    }

    private void j0() {
        if (this.f9685o != null) {
            EditText editText = this.f9663d;
            k0(editText == null ? null : editText.getText());
        }
    }

    private void k() {
        if (this.f9663d == null || this.O != 1) {
            return;
        }
        if (u4.c.h(getContext())) {
            EditText editText = this.f9663d;
            ViewCompat.setPaddingRelative(editText, ViewCompat.getPaddingStart(editText), getResources().getDimensionPixelSize(e4.d.C), ViewCompat.getPaddingEnd(this.f9663d), getResources().getDimensionPixelSize(e4.d.B));
        } else if (u4.c.g(getContext())) {
            EditText editText2 = this.f9663d;
            ViewCompat.setPaddingRelative(editText2, ViewCompat.getPaddingStart(editText2), getResources().getDimensionPixelSize(e4.d.A), ViewCompat.getPaddingEnd(this.f9663d), getResources().getDimensionPixelSize(e4.d.f24807z));
        }
    }

    private static void l0(@NonNull Context context, @NonNull TextView textView, int i10, int i11, boolean z10) {
        textView.setContentDescription(context.getString(z10 ? e4.i.f24874c : e4.i.f24873b, Integer.valueOf(i10), Integer.valueOf(i11)));
    }

    private void m() {
        x4.g gVar = this.F;
        if (gVar == null) {
            return;
        }
        x4.k kVarC = gVar.C();
        x4.k kVar = this.L;
        if (kVarC != kVar) {
            this.F.setShapeAppearanceModel(kVar);
        }
        if (w()) {
            this.F.c0(this.Q, this.T);
        }
        int iQ = q();
        this.U = iQ;
        this.F.Y(ColorStateList.valueOf(iQ));
        n();
        r0();
    }

    private void m0() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.f9685o;
        if (textView != null) {
            c0(textView, this.f9681m ? this.f9687p : this.f9689q);
            if (!this.f9681m && (colorStateList2 = this.f9705y) != null) {
                this.f9685o.setTextColor(colorStateList2);
            }
            if (!this.f9681m || (colorStateList = this.f9707z) == null) {
                return;
            }
            this.f9685o.setTextColor(colorStateList);
        }
    }

    private void n() {
        if (this.J == null || this.K == null) {
            return;
        }
        if (x()) {
            this.J.Y(this.f9663d.isFocused() ? ColorStateList.valueOf(this.f9678k0) : ColorStateList.valueOf(this.T));
            this.K.Y(ColorStateList.valueOf(this.T));
        }
        invalidate();
    }

    @RequiresApi(29)
    private void n0() {
        ColorStateList colorStateList;
        ColorStateList colorStateListG = this.A;
        if (colorStateListG == null) {
            colorStateListG = n4.a.g(getContext(), e4.b.f24749f);
        }
        EditText editText = this.f9663d;
        if (editText == null || editText.getTextCursorDrawable() == null) {
            return;
        }
        Drawable drawableMutate = DrawableCompat.wrap(this.f9663d.getTextCursorDrawable()).mutate();
        if (Q() && (colorStateList = this.B) != null) {
            colorStateListG = colorStateList;
        }
        DrawableCompat.setTintList(drawableMutate, colorStateListG);
    }

    private void o(@NonNull RectF rectF) {
        float f10 = rectF.left;
        int i10 = this.N;
        rectF.left = f10 - i10;
        rectF.right += i10;
    }

    private void p() {
        int i10 = this.O;
        if (i10 == 0) {
            this.F = null;
            this.J = null;
            this.K = null;
            return;
        }
        if (i10 == 1) {
            this.F = new x4.g(this.L);
            this.J = new x4.g();
            this.K = new x4.g();
        } else {
            if (i10 != 2) {
                throw new IllegalArgumentException(this.O + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            if (!this.C || (this.F instanceof com.google.android.material.textfield.h)) {
                this.F = new x4.g(this.L);
            } else {
                this.F = com.google.android.material.textfield.h.l0(this.L);
            }
            this.J = null;
            this.K = null;
        }
    }

    private int q() {
        return this.O == 1 ? n4.a.i(n4.a.e(this, e4.b.f24756m, 0), this.U) : this.U;
    }

    private void q0() {
        ViewCompat.setBackground(this.f9663d, getEditTextBoxBackground());
    }

    @NonNull
    private Rect r(@NonNull Rect rect) {
        if (this.f9663d == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.W;
        boolean zG = com.google.android.material.internal.s.g(this);
        rect2.bottom = rect.bottom;
        int i10 = this.O;
        if (i10 == 1) {
            rect2.left = I(rect.left, zG);
            rect2.top = rect.top + this.P;
            rect2.right = J(rect.right, zG);
            return rect2;
        }
        if (i10 != 2) {
            rect2.left = I(rect.left, zG);
            rect2.top = getPaddingTop();
            rect2.right = J(rect.right, zG);
            return rect2;
        }
        rect2.left = rect.left + this.f9663d.getPaddingLeft();
        rect2.top = rect.top - v();
        rect2.right = rect.right - this.f9663d.getPaddingRight();
        return rect2;
    }

    private int s(@NonNull Rect rect, @NonNull Rect rect2, float f10) {
        return S() ? (int) (rect2.top + f10) : rect.bottom - this.f9663d.getCompoundPaddingBottom();
    }

    private boolean s0() {
        int iMax;
        if (this.f9663d == null || this.f9663d.getMeasuredHeight() >= (iMax = Math.max(this.f9661c.getMeasuredHeight(), this.f9659b.getMeasuredHeight()))) {
            return false;
        }
        this.f9663d.setMinimumHeight(iMax);
        return true;
    }

    private void setEditText(EditText editText) {
        if (this.f9663d != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f9663d = editText;
        int i10 = this.f9667f;
        if (i10 != -1) {
            setMinEms(i10);
        } else {
            setMinWidth(this.f9671h);
        }
        int i11 = this.f9669g;
        if (i11 != -1) {
            setMaxEms(i11);
        } else {
            setMaxWidth(this.f9673i);
        }
        this.I = false;
        V();
        setTextInputAccessibilityDelegate(new d(this));
        this.f9700v0.i0(this.f9663d.getTypeface());
        this.f9700v0.a0(this.f9663d.getTextSize());
        int i12 = Build.VERSION.SDK_INT;
        this.f9700v0.X(this.f9663d.getLetterSpacing());
        int gravity = this.f9663d.getGravity();
        this.f9700v0.S((gravity & (-113)) | 48);
        this.f9700v0.Z(gravity);
        this.f9696t0 = ViewCompat.getMinimumHeight(editText);
        this.f9663d.addTextChangedListener(new a(editText));
        if (this.f9674i0 == null) {
            this.f9674i0 = this.f9663d.getHintTextColors();
        }
        if (this.C) {
            if (TextUtils.isEmpty(this.D)) {
                CharSequence hint = this.f9663d.getHint();
                this.f9665e = hint;
                setHint(hint);
                this.f9663d.setHint((CharSequence) null);
            }
            this.E = true;
        }
        if (i12 >= 29) {
            n0();
        }
        if (this.f9685o != null) {
            k0(this.f9663d.getText());
        }
        p0();
        this.f9675j.f();
        this.f9659b.bringToFront();
        this.f9661c.bringToFront();
        C();
        this.f9661c.x0();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        v0(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.D)) {
            return;
        }
        this.D = charSequence;
        this.f9700v0.g0(charSequence);
        if (this.f9698u0) {
            return;
        }
        W();
    }

    private void setPlaceholderTextEnabled(boolean z10) {
        if (this.f9693s == z10) {
            return;
        }
        if (z10) {
            j();
        } else {
            a0();
            this.f9695t = null;
        }
        this.f9693s = z10;
    }

    private int t(@NonNull Rect rect, float f10) {
        return S() ? (int) (rect.centerY() - (f10 / 2.0f)) : rect.top + this.f9663d.getCompoundPaddingTop();
    }

    private void t0() {
        if (this.O != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f9657a.getLayoutParams();
            int iV = v();
            if (iV != layoutParams.topMargin) {
                layoutParams.topMargin = iV;
                this.f9657a.requestLayout();
            }
        }
    }

    @NonNull
    private Rect u(@NonNull Rect rect) {
        if (this.f9663d == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.W;
        float fW = this.f9700v0.w();
        rect2.left = rect.left + this.f9663d.getCompoundPaddingLeft();
        rect2.top = t(rect, fW);
        rect2.right = rect.right - this.f9663d.getCompoundPaddingRight();
        rect2.bottom = s(rect, rect2, fW);
        return rect2;
    }

    private int v() {
        float fQ;
        if (!this.C) {
            return 0;
        }
        int i10 = this.O;
        if (i10 == 0) {
            fQ = this.f9700v0.q();
        } else {
            if (i10 != 2) {
                return 0;
            }
            fQ = this.f9700v0.q() / 2.0f;
        }
        return (int) fQ;
    }

    private void v0(boolean z10, boolean z11) {
        ColorStateList colorStateList;
        TextView textView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.f9663d;
        boolean z12 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f9663d;
        boolean z13 = editText2 != null && editText2.hasFocus();
        ColorStateList colorStateList2 = this.f9674i0;
        if (colorStateList2 != null) {
            this.f9700v0.M(colorStateList2);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.f9674i0;
            this.f9700v0.M(ColorStateList.valueOf(colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.f9694s0) : this.f9694s0));
        } else if (d0()) {
            this.f9700v0.M(this.f9675j.r());
        } else if (this.f9681m && (textView = this.f9685o) != null) {
            this.f9700v0.M(textView.getTextColors());
        } else if (z13 && (colorStateList = this.f9676j0) != null) {
            this.f9700v0.R(colorStateList);
        }
        if (z12 || !this.f9702w0 || (isEnabled() && z13)) {
            if (z11 || this.f9698u0) {
                z(z10);
                return;
            }
            return;
        }
        if (z11 || !this.f9698u0) {
            F(z10);
        }
    }

    private boolean w() {
        return this.O == 2 && x();
    }

    private void w0() {
        EditText editText;
        if (this.f9695t == null || (editText = this.f9663d) == null) {
            return;
        }
        this.f9695t.setGravity(editText.getGravity());
        this.f9695t.setPadding(this.f9663d.getCompoundPaddingLeft(), this.f9663d.getCompoundPaddingTop(), this.f9663d.getCompoundPaddingRight(), this.f9663d.getCompoundPaddingBottom());
    }

    private boolean x() {
        return this.Q > -1 && this.T != 0;
    }

    private void x0() {
        EditText editText = this.f9663d;
        y0(editText == null ? null : editText.getText());
    }

    private void y() {
        if (B()) {
            ((com.google.android.material.textfield.h) this.F).n0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(@Nullable Editable editable) {
        if (this.f9683n.a(editable) != 0 || this.f9698u0) {
            L();
        } else {
            g0();
        }
    }

    private void z(boolean z10) {
        ValueAnimator valueAnimator = this.f9706y0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f9706y0.cancel();
        }
        if (z10 && this.f9704x0) {
            l(1.0f);
        } else {
            this.f9700v0.c0(1.0f);
        }
        this.f9698u0 = false;
        if (B()) {
            W();
        }
        x0();
        this.f9659b.l(false);
        this.f9661c.H(false);
    }

    private void z0(boolean z10, boolean z11) {
        int defaultColor = this.f9684n0.getDefaultColor();
        int colorForState = this.f9684n0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.f9684n0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z10) {
            this.T = colorForState2;
        } else if (z11) {
            this.T = colorForState;
        } else {
            this.T = defaultColor;
        }
    }

    void A0() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.F == null || this.O == 0) {
            return;
        }
        boolean z10 = false;
        boolean z11 = isFocused() || ((editText2 = this.f9663d) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.f9663d) != null && editText.isHovered())) {
            z10 = true;
        }
        if (!isEnabled()) {
            this.T = this.f9694s0;
        } else if (d0()) {
            if (this.f9684n0 != null) {
                z0(z11, z10);
            } else {
                this.T = getErrorCurrentTextColors();
            }
        } else if (!this.f9681m || (textView = this.f9685o) == null) {
            if (z11) {
                this.T = this.f9682m0;
            } else if (z10) {
                this.T = this.f9680l0;
            } else {
                this.T = this.f9678k0;
            }
        } else if (this.f9684n0 != null) {
            z0(z11, z10);
        } else {
            this.T = textView.getCurrentTextColor();
        }
        if (Build.VERSION.SDK_INT >= 29) {
            n0();
        }
        this.f9661c.I();
        Z();
        if (this.O == 2) {
            int i10 = this.Q;
            if (z11 && isEnabled()) {
                this.Q = this.S;
            } else {
                this.Q = this.R;
            }
            if (this.Q != i10) {
                X();
            }
        }
        if (this.O == 1) {
            if (!isEnabled()) {
                this.U = this.f9688p0;
            } else if (z10 && !z11) {
                this.U = this.f9692r0;
            } else if (z11) {
                this.U = this.f9690q0;
            } else {
                this.U = this.f9686o0;
            }
        }
        m();
    }

    public boolean M() {
        return this.f9661c.F();
    }

    public boolean N() {
        return this.f9675j.A();
    }

    public boolean O() {
        return this.f9675j.B();
    }

    final boolean P() {
        return this.f9698u0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean R() {
        return this.E;
    }

    public void Z() {
        this.f9659b.m();
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View view, int i10, @NonNull ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i10, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.f9657a.addView(view, layoutParams2);
        this.f9657a.setLayoutParams(layoutParams);
        t0();
        setEditText((EditText) view);
    }

    void c0(@NonNull TextView textView, @StyleRes int i10) {
        boolean z10 = true;
        try {
            TextViewCompat.setTextAppearance(textView, i10);
            if (textView.getTextColors().getDefaultColor() != -65281) {
                z10 = false;
            }
        } catch (Exception unused) {
        }
        if (z10) {
            TextViewCompat.setTextAppearance(textView, e4.j.f24895a);
            textView.setTextColor(ContextCompat.getColor(getContext(), e4.c.f24770a));
        }
    }

    boolean d0() {
        return this.f9675j.l();
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(26)
    public void dispatchProvideAutofillStructure(@NonNull ViewStructure viewStructure, int i10) {
        EditText editText = this.f9663d;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i10);
            return;
        }
        if (this.f9665e != null) {
            boolean z10 = this.E;
            this.E = false;
            CharSequence hint = editText.getHint();
            this.f9663d.setHint(this.f9665e);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i10);
                return;
            } finally {
                this.f9663d.setHint(hint);
                this.E = z10;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i10);
        onProvideAutofillVirtualStructure(viewStructure, i10);
        viewStructure.setChildCount(this.f9657a.getChildCount());
        for (int i11 = 0; i11 < this.f9657a.getChildCount(); i11++) {
            View childAt = this.f9657a.getChildAt(i11);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i11);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i10);
            if (childAt == this.f9663d) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> sparseArray) {
        this.A0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.A0 = false;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        E(canvas);
        D(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f9708z0) {
            return;
        }
        this.f9708z0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        com.google.android.material.internal.a aVar = this.f9700v0;
        boolean zF0 = aVar != null ? aVar.f0(drawableState) | false : false;
        if (this.f9663d != null) {
            u0(ViewCompat.isLaidOut(this) && isEnabled());
        }
        p0();
        A0();
        if (zF0) {
            invalidate();
        }
        this.f9708z0 = false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f9663d;
        return editText != null ? editText.getBaseline() + getPaddingTop() + v() : super.getBaseline();
    }

    @NonNull
    x4.g getBoxBackground() {
        int i10 = this.O;
        if (i10 == 1 || i10 == 2) {
            return this.F;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.U;
    }

    public int getBoxBackgroundMode() {
        return this.O;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.P;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return com.google.android.material.internal.s.g(this) ? this.L.j().a(this.f9658a0) : this.L.l().a(this.f9658a0);
    }

    public float getBoxCornerRadiusBottomStart() {
        return com.google.android.material.internal.s.g(this) ? this.L.l().a(this.f9658a0) : this.L.j().a(this.f9658a0);
    }

    public float getBoxCornerRadiusTopEnd() {
        return com.google.android.material.internal.s.g(this) ? this.L.r().a(this.f9658a0) : this.L.t().a(this.f9658a0);
    }

    public float getBoxCornerRadiusTopStart() {
        return com.google.android.material.internal.s.g(this) ? this.L.t().a(this.f9658a0) : this.L.r().a(this.f9658a0);
    }

    public int getBoxStrokeColor() {
        return this.f9682m0;
    }

    @Nullable
    public ColorStateList getBoxStrokeErrorColor() {
        return this.f9684n0;
    }

    public int getBoxStrokeWidth() {
        return this.R;
    }

    public int getBoxStrokeWidthFocused() {
        return this.S;
    }

    public int getCounterMaxLength() {
        return this.f9679l;
    }

    @Nullable
    CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.f9677k && this.f9681m && (textView = this.f9685o) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    @Nullable
    public ColorStateList getCounterOverflowTextColor() {
        return this.f9707z;
    }

    @Nullable
    public ColorStateList getCounterTextColor() {
        return this.f9705y;
    }

    @Nullable
    @RequiresApi(29)
    public ColorStateList getCursorColor() {
        return this.A;
    }

    @Nullable
    @RequiresApi(29)
    public ColorStateList getCursorErrorColor() {
        return this.B;
    }

    @Nullable
    public ColorStateList getDefaultHintTextColor() {
        return this.f9674i0;
    }

    @Nullable
    public EditText getEditText() {
        return this.f9663d;
    }

    @Nullable
    public CharSequence getEndIconContentDescription() {
        return this.f9661c.l();
    }

    @Nullable
    public Drawable getEndIconDrawable() {
        return this.f9661c.n();
    }

    public int getEndIconMinSize() {
        return this.f9661c.o();
    }

    public int getEndIconMode() {
        return this.f9661c.p();
    }

    @NonNull
    public ImageView.ScaleType getEndIconScaleType() {
        return this.f9661c.q();
    }

    @NonNull
    CheckableImageButton getEndIconView() {
        return this.f9661c.r();
    }

    @Nullable
    public CharSequence getError() {
        if (this.f9675j.A()) {
            return this.f9675j.p();
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.f9675j.n();
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        return this.f9675j.o();
    }

    @ColorInt
    public int getErrorCurrentTextColors() {
        return this.f9675j.q();
    }

    @Nullable
    public Drawable getErrorIconDrawable() {
        return this.f9661c.s();
    }

    @Nullable
    public CharSequence getHelperText() {
        if (this.f9675j.B()) {
            return this.f9675j.s();
        }
        return null;
    }

    @ColorInt
    public int getHelperTextCurrentTextColor() {
        return this.f9675j.u();
    }

    @Nullable
    public CharSequence getHint() {
        if (this.C) {
            return this.D;
        }
        return null;
    }

    @VisibleForTesting
    final float getHintCollapsedTextHeight() {
        return this.f9700v0.q();
    }

    @VisibleForTesting
    final int getHintCurrentCollapsedTextColor() {
        return this.f9700v0.t();
    }

    @Nullable
    public ColorStateList getHintTextColor() {
        return this.f9676j0;
    }

    @NonNull
    public e getLengthCounter() {
        return this.f9683n;
    }

    public int getMaxEms() {
        return this.f9669g;
    }

    @Px
    public int getMaxWidth() {
        return this.f9673i;
    }

    public int getMinEms() {
        return this.f9667f;
    }

    @Px
    public int getMinWidth() {
        return this.f9671h;
    }

    @Nullable
    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f9661c.u();
    }

    @Nullable
    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f9661c.v();
    }

    @Nullable
    public CharSequence getPlaceholderText() {
        if (this.f9693s) {
            return this.f9691r;
        }
        return null;
    }

    @StyleRes
    public int getPlaceholderTextAppearance() {
        return this.f9699v;
    }

    @Nullable
    public ColorStateList getPlaceholderTextColor() {
        return this.f9697u;
    }

    @Nullable
    public CharSequence getPrefixText() {
        return this.f9659b.a();
    }

    @Nullable
    public ColorStateList getPrefixTextColor() {
        return this.f9659b.b();
    }

    @NonNull
    public TextView getPrefixTextView() {
        return this.f9659b.d();
    }

    @NonNull
    public x4.k getShapeAppearanceModel() {
        return this.L;
    }

    @Nullable
    public CharSequence getStartIconContentDescription() {
        return this.f9659b.e();
    }

    @Nullable
    public Drawable getStartIconDrawable() {
        return this.f9659b.f();
    }

    public int getStartIconMinSize() {
        return this.f9659b.g();
    }

    @NonNull
    public ImageView.ScaleType getStartIconScaleType() {
        return this.f9659b.h();
    }

    @Nullable
    public CharSequence getSuffixText() {
        return this.f9661c.w();
    }

    @Nullable
    public ColorStateList getSuffixTextColor() {
        return this.f9661c.x();
    }

    @NonNull
    public TextView getSuffixTextView() {
        return this.f9661c.z();
    }

    @Nullable
    public Typeface getTypeface() {
        return this.f9660b0;
    }

    public void i(@NonNull f fVar) {
        this.f9666e0.add(fVar);
        if (this.f9663d != null) {
            fVar.a(this);
        }
    }

    void k0(@Nullable Editable editable) {
        int iA = this.f9683n.a(editable);
        boolean z10 = this.f9681m;
        int i10 = this.f9679l;
        if (i10 == -1) {
            this.f9685o.setText(String.valueOf(iA));
            this.f9685o.setContentDescription(null);
            this.f9681m = false;
        } else {
            this.f9681m = iA > i10;
            l0(getContext(), this.f9685o, iA, this.f9679l, this.f9681m);
            if (z10 != this.f9681m) {
                m0();
            }
            this.f9685o.setText(BidiFormatter.getInstance().unicodeWrap(getContext().getString(e4.i.f24875d, Integer.valueOf(iA), Integer.valueOf(this.f9679l))));
        }
        if (this.f9663d == null || z10 == this.f9681m) {
            return;
        }
        u0(false);
        A0();
        p0();
    }

    @VisibleForTesting
    void l(float f10) {
        if (this.f9700v0.x() == f10) {
            return;
        }
        if (this.f9706y0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f9706y0 = valueAnimator;
            valueAnimator.setInterpolator(s4.h.g(getContext(), e4.b.I, f4.a.f25669b));
            this.f9706y0.setDuration(s4.h.f(getContext(), e4.b.C, 167));
            this.f9706y0.addUpdateListener(new c());
        }
        this.f9706y0.setFloatValues(this.f9700v0.x(), f10);
        this.f9706y0.start();
    }

    boolean o0() {
        boolean z10;
        if (this.f9663d == null) {
            return false;
        }
        boolean z11 = true;
        if (f0()) {
            int measuredWidth = this.f9659b.getMeasuredWidth() - this.f9663d.getPaddingLeft();
            if (this.f9662c0 == null || this.f9664d0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.f9662c0 = colorDrawable;
                this.f9664d0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this.f9663d);
            Drawable drawable = compoundDrawablesRelative[0];
            Drawable drawable2 = this.f9662c0;
            if (drawable != drawable2) {
                TextViewCompat.setCompoundDrawablesRelative(this.f9663d, drawable2, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
                z10 = true;
            }
            z10 = false;
        } else {
            if (this.f9662c0 != null) {
                Drawable[] compoundDrawablesRelative2 = TextViewCompat.getCompoundDrawablesRelative(this.f9663d);
                TextViewCompat.setCompoundDrawablesRelative(this.f9663d, null, compoundDrawablesRelative2[1], compoundDrawablesRelative2[2], compoundDrawablesRelative2[3]);
                this.f9662c0 = null;
                z10 = true;
            }
            z10 = false;
        }
        if (e0()) {
            int measuredWidth2 = this.f9661c.z().getMeasuredWidth() - this.f9663d.getPaddingRight();
            CheckableImageButton checkableImageButtonK = this.f9661c.k();
            if (checkableImageButtonK != null) {
                measuredWidth2 = measuredWidth2 + checkableImageButtonK.getMeasuredWidth() + MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) checkableImageButtonK.getLayoutParams());
            }
            Drawable[] compoundDrawablesRelative3 = TextViewCompat.getCompoundDrawablesRelative(this.f9663d);
            Drawable drawable3 = this.f9668f0;
            if (drawable3 == null || this.f9670g0 == measuredWidth2) {
                if (drawable3 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.f9668f0 = colorDrawable2;
                    this.f9670g0 = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = compoundDrawablesRelative3[2];
                Drawable drawable5 = this.f9668f0;
                if (drawable4 != drawable5) {
                    this.f9672h0 = drawable4;
                    TextViewCompat.setCompoundDrawablesRelative(this.f9663d, compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], drawable5, compoundDrawablesRelative3[3]);
                } else {
                    z11 = z10;
                }
            } else {
                this.f9670g0 = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                TextViewCompat.setCompoundDrawablesRelative(this.f9663d, compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], this.f9668f0, compoundDrawablesRelative3[3]);
            }
        } else {
            if (this.f9668f0 == null) {
                return z10;
            }
            Drawable[] compoundDrawablesRelative4 = TextViewCompat.getCompoundDrawablesRelative(this.f9663d);
            if (compoundDrawablesRelative4[2] == this.f9668f0) {
                TextViewCompat.setCompoundDrawablesRelative(this.f9663d, compoundDrawablesRelative4[0], compoundDrawablesRelative4[1], this.f9672h0, compoundDrawablesRelative4[3]);
            } else {
                z11 = z10;
            }
            this.f9668f0 = null;
        }
        return z11;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f9700v0.H(configuration);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.f9661c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.B0 = false;
        boolean zS0 = s0();
        boolean zO0 = o0();
        if (zS0 || zO0) {
            this.f9663d.post(new Runnable() { // from class: com.google.android.material.textfield.e0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f9732a.U();
                }
            });
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        EditText editText = this.f9663d;
        if (editText != null) {
            Rect rect = this.V;
            com.google.android.material.internal.c.a(this, editText, rect);
            i0(rect);
            if (this.C) {
                this.f9700v0.a0(this.f9663d.getTextSize());
                int gravity = this.f9663d.getGravity();
                this.f9700v0.S((gravity & (-113)) | 48);
                this.f9700v0.Z(gravity);
                this.f9700v0.O(r(rect));
                this.f9700v0.W(u(rect));
                this.f9700v0.J();
                if (!B() || this.f9698u0) {
                    return;
                }
                W();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (!this.B0) {
            this.f9661c.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.B0 = true;
        }
        w0();
        this.f9661c.x0();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.getSuperState());
        setError(hVar.f9715a);
        if (hVar.f9716b) {
            post(new b());
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        boolean z10 = i10 == 1;
        if (z10 != this.M) {
            float fA = this.L.r().a(this.f9658a0);
            float fA2 = this.L.t().a(this.f9658a0);
            x4.k kVarM = x4.k.a().z(this.L.s()).D(this.L.q()).r(this.L.k()).v(this.L.i()).A(fA2).E(fA).s(this.L.l().a(this.f9658a0)).w(this.L.j().a(this.f9658a0)).m();
            this.M = z10;
            setShapeAppearanceModel(kVarM);
        }
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        h hVar = new h(super.onSaveInstanceState());
        if (d0()) {
            hVar.f9715a = getError();
        }
        hVar.f9716b = this.f9661c.E();
        return hVar;
    }

    void p0() {
        Drawable background;
        TextView textView;
        EditText editText = this.f9663d;
        if (editText == null || this.O != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (DrawableUtils.canSafelyMutateDrawable(background)) {
            background = background.mutate();
        }
        if (d0()) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        } else if (this.f9681m && (textView = this.f9685o) != null) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            DrawableCompat.clearColorFilter(background);
            this.f9663d.refreshDrawableState();
        }
    }

    void r0() {
        EditText editText = this.f9663d;
        if (editText == null || this.F == null) {
            return;
        }
        if ((this.I || editText.getBackground() == null) && this.O != 0) {
            q0();
            this.I = true;
        }
    }

    public void setBoxBackgroundColor(@ColorInt int i10) {
        if (this.U != i10) {
            this.U = i10;
            this.f9686o0 = i10;
            this.f9690q0 = i10;
            this.f9692r0 = i10;
            m();
        }
    }

    public void setBoxBackgroundColorResource(@ColorRes int i10) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), i10));
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f9686o0 = defaultColor;
        this.U = defaultColor;
        this.f9688p0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f9690q0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.f9692r0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        m();
    }

    public void setBoxBackgroundMode(int i10) {
        if (i10 == this.O) {
            return;
        }
        this.O = i10;
        if (this.f9663d != null) {
            V();
        }
    }

    public void setBoxCollapsedPaddingTop(int i10) {
        this.P = i10;
    }

    public void setBoxCornerFamily(int i10) {
        this.L = this.L.v().y(i10, this.L.r()).C(i10, this.L.t()).q(i10, this.L.j()).u(i10, this.L.l()).m();
        m();
    }

    public void setBoxStrokeColor(@ColorInt int i10) {
        if (this.f9682m0 != i10) {
            this.f9682m0 = i10;
            A0();
        }
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.f9678k0 = colorStateList.getDefaultColor();
            this.f9694s0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f9680l0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.f9682m0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.f9682m0 != colorStateList.getDefaultColor()) {
            this.f9682m0 = colorStateList.getDefaultColor();
        }
        A0();
    }

    public void setBoxStrokeErrorColor(@Nullable ColorStateList colorStateList) {
        if (this.f9684n0 != colorStateList) {
            this.f9684n0 = colorStateList;
            A0();
        }
    }

    public void setBoxStrokeWidth(int i10) {
        this.R = i10;
        A0();
    }

    public void setBoxStrokeWidthFocused(int i10) {
        this.S = i10;
        A0();
    }

    public void setBoxStrokeWidthFocusedResource(@DimenRes int i10) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i10));
    }

    public void setBoxStrokeWidthResource(@DimenRes int i10) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i10));
    }

    public void setCounterEnabled(boolean z10) {
        if (this.f9677k != z10) {
            if (z10) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.f9685o = appCompatTextView;
                appCompatTextView.setId(e4.f.O);
                Typeface typeface = this.f9660b0;
                if (typeface != null) {
                    this.f9685o.setTypeface(typeface);
                }
                this.f9685o.setMaxLines(1);
                this.f9675j.e(this.f9685o, 2);
                MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.f9685o.getLayoutParams(), getResources().getDimensionPixelOffset(e4.d.f24787f0));
                m0();
                j0();
            } else {
                this.f9675j.C(this.f9685o, 2);
                this.f9685o = null;
            }
            this.f9677k = z10;
        }
    }

    public void setCounterMaxLength(int i10) {
        if (this.f9679l != i10) {
            if (i10 > 0) {
                this.f9679l = i10;
            } else {
                this.f9679l = -1;
            }
            if (this.f9677k) {
                j0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i10) {
        if (this.f9687p != i10) {
            this.f9687p = i10;
            m0();
        }
    }

    public void setCounterOverflowTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f9707z != colorStateList) {
            this.f9707z = colorStateList;
            m0();
        }
    }

    public void setCounterTextAppearance(int i10) {
        if (this.f9689q != i10) {
            this.f9689q = i10;
            m0();
        }
    }

    public void setCounterTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f9705y != colorStateList) {
            this.f9705y = colorStateList;
            m0();
        }
    }

    @RequiresApi(29)
    public void setCursorColor(@Nullable ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            n0();
        }
    }

    @RequiresApi(29)
    public void setCursorErrorColor(@Nullable ColorStateList colorStateList) {
        if (this.B != colorStateList) {
            this.B = colorStateList;
            if (Q()) {
                n0();
            }
        }
    }

    public void setDefaultHintTextColor(@Nullable ColorStateList colorStateList) {
        this.f9674i0 = colorStateList;
        this.f9676j0 = colorStateList;
        if (this.f9663d != null) {
            u0(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        Y(this, z10);
        super.setEnabled(z10);
    }

    public void setEndIconActivated(boolean z10) {
        this.f9661c.N(z10);
    }

    public void setEndIconCheckable(boolean z10) {
        this.f9661c.O(z10);
    }

    public void setEndIconContentDescription(@StringRes int i10) {
        this.f9661c.P(i10);
    }

    public void setEndIconDrawable(@DrawableRes int i10) {
        this.f9661c.R(i10);
    }

    public void setEndIconMinSize(@IntRange(from = 0) int i10) {
        this.f9661c.T(i10);
    }

    public void setEndIconMode(int i10) {
        this.f9661c.U(i10);
    }

    public void setEndIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f9661c.V(onClickListener);
    }

    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.f9661c.W(onLongClickListener);
    }

    public void setEndIconScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.f9661c.X(scaleType);
    }

    public void setEndIconTintList(@Nullable ColorStateList colorStateList) {
        this.f9661c.Y(colorStateList);
    }

    public void setEndIconTintMode(@Nullable PorterDuff.Mode mode) {
        this.f9661c.Z(mode);
    }

    public void setEndIconVisible(boolean z10) {
        this.f9661c.a0(z10);
    }

    public void setError(@Nullable CharSequence charSequence) {
        if (!this.f9675j.A()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.f9675j.w();
        } else {
            this.f9675j.Q(charSequence);
        }
    }

    public void setErrorAccessibilityLiveRegion(int i10) {
        this.f9675j.E(i10);
    }

    public void setErrorContentDescription(@Nullable CharSequence charSequence) {
        this.f9675j.F(charSequence);
    }

    public void setErrorEnabled(boolean z10) {
        this.f9675j.G(z10);
    }

    public void setErrorIconDrawable(@DrawableRes int i10) {
        this.f9661c.b0(i10);
    }

    public void setErrorIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f9661c.d0(onClickListener);
    }

    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.f9661c.e0(onLongClickListener);
    }

    public void setErrorIconTintList(@Nullable ColorStateList colorStateList) {
        this.f9661c.f0(colorStateList);
    }

    public void setErrorIconTintMode(@Nullable PorterDuff.Mode mode) {
        this.f9661c.g0(mode);
    }

    public void setErrorTextAppearance(@StyleRes int i10) {
        this.f9675j.H(i10);
    }

    public void setErrorTextColor(@Nullable ColorStateList colorStateList) {
        this.f9675j.I(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z10) {
        if (this.f9702w0 != z10) {
            this.f9702w0 = z10;
            u0(false);
        }
    }

    public void setHelperText(@Nullable CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (O()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!O()) {
                setHelperTextEnabled(true);
            }
            this.f9675j.R(charSequence);
        }
    }

    public void setHelperTextColor(@Nullable ColorStateList colorStateList) {
        this.f9675j.L(colorStateList);
    }

    public void setHelperTextEnabled(boolean z10) {
        this.f9675j.K(z10);
    }

    public void setHelperTextTextAppearance(@StyleRes int i10) {
        this.f9675j.J(i10);
    }

    public void setHint(@Nullable CharSequence charSequence) {
        if (this.C) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z10) {
        this.f9704x0 = z10;
    }

    public void setHintEnabled(boolean z10) {
        if (z10 != this.C) {
            this.C = z10;
            if (z10) {
                CharSequence hint = this.f9663d.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.D)) {
                        setHint(hint);
                    }
                    this.f9663d.setHint((CharSequence) null);
                }
                this.E = true;
            } else {
                this.E = false;
                if (!TextUtils.isEmpty(this.D) && TextUtils.isEmpty(this.f9663d.getHint())) {
                    this.f9663d.setHint(this.D);
                }
                setHintInternal(null);
            }
            if (this.f9663d != null) {
                t0();
            }
        }
    }

    public void setHintTextAppearance(@StyleRes int i10) {
        this.f9700v0.P(i10);
        this.f9676j0 = this.f9700v0.p();
        if (this.f9663d != null) {
            u0(false);
            t0();
        }
    }

    public void setHintTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f9676j0 != colorStateList) {
            if (this.f9674i0 == null) {
                this.f9700v0.R(colorStateList);
            }
            this.f9676j0 = colorStateList;
            if (this.f9663d != null) {
                u0(false);
            }
        }
    }

    public void setLengthCounter(@NonNull e eVar) {
        this.f9683n = eVar;
    }

    public void setMaxEms(int i10) {
        this.f9669g = i10;
        EditText editText = this.f9663d;
        if (editText == null || i10 == -1) {
            return;
        }
        editText.setMaxEms(i10);
    }

    public void setMaxWidth(@Px int i10) {
        this.f9673i = i10;
        EditText editText = this.f9663d;
        if (editText == null || i10 == -1) {
            return;
        }
        editText.setMaxWidth(i10);
    }

    public void setMaxWidthResource(@DimenRes int i10) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i10));
    }

    public void setMinEms(int i10) {
        this.f9667f = i10;
        EditText editText = this.f9663d;
        if (editText == null || i10 == -1) {
            return;
        }
        editText.setMinEms(i10);
    }

    public void setMinWidth(@Px int i10) {
        this.f9671h = i10;
        EditText editText = this.f9663d;
        if (editText == null || i10 == -1) {
            return;
        }
        editText.setMinWidth(i10);
    }

    public void setMinWidthResource(@DimenRes int i10) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i10));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@StringRes int i10) {
        this.f9661c.i0(i10);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@DrawableRes int i10) {
        this.f9661c.k0(i10);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z10) {
        this.f9661c.m0(z10);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList colorStateList) {
        this.f9661c.n0(colorStateList);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode mode) {
        this.f9661c.o0(mode);
    }

    public void setPlaceholderText(@Nullable CharSequence charSequence) {
        if (this.f9695t == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.f9695t = appCompatTextView;
            appCompatTextView.setId(e4.f.R);
            ViewCompat.setImportantForAccessibility(this.f9695t, 2);
            Fade fadeA = A();
            this.f9701w = fadeA;
            fadeA.setStartDelay(67L);
            this.f9703x = A();
            setPlaceholderTextAppearance(this.f9699v);
            setPlaceholderTextColor(this.f9697u);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f9693s) {
                setPlaceholderTextEnabled(true);
            }
            this.f9691r = charSequence;
        }
        x0();
    }

    public void setPlaceholderTextAppearance(@StyleRes int i10) {
        this.f9699v = i10;
        TextView textView = this.f9695t;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, i10);
        }
    }

    public void setPlaceholderTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f9697u != colorStateList) {
            this.f9697u = colorStateList;
            TextView textView = this.f9695t;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(@Nullable CharSequence charSequence) {
        this.f9659b.n(charSequence);
    }

    public void setPrefixTextAppearance(@StyleRes int i10) {
        this.f9659b.o(i10);
    }

    public void setPrefixTextColor(@NonNull ColorStateList colorStateList) {
        this.f9659b.p(colorStateList);
    }

    public void setShapeAppearanceModel(@NonNull x4.k kVar) {
        x4.g gVar = this.F;
        if (gVar == null || gVar.C() == kVar) {
            return;
        }
        this.L = kVar;
        m();
    }

    public void setStartIconCheckable(boolean z10) {
        this.f9659b.q(z10);
    }

    public void setStartIconContentDescription(@StringRes int i10) {
        setStartIconContentDescription(i10 != 0 ? getResources().getText(i10) : null);
    }

    public void setStartIconDrawable(@DrawableRes int i10) {
        setStartIconDrawable(i10 != 0 ? AppCompatResources.getDrawable(getContext(), i10) : null);
    }

    public void setStartIconMinSize(@IntRange(from = 0) int i10) {
        this.f9659b.t(i10);
    }

    public void setStartIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f9659b.u(onClickListener);
    }

    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.f9659b.v(onLongClickListener);
    }

    public void setStartIconScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.f9659b.w(scaleType);
    }

    public void setStartIconTintList(@Nullable ColorStateList colorStateList) {
        this.f9659b.x(colorStateList);
    }

    public void setStartIconTintMode(@Nullable PorterDuff.Mode mode) {
        this.f9659b.y(mode);
    }

    public void setStartIconVisible(boolean z10) {
        this.f9659b.z(z10);
    }

    public void setSuffixText(@Nullable CharSequence charSequence) {
        this.f9661c.p0(charSequence);
    }

    public void setSuffixTextAppearance(@StyleRes int i10) {
        this.f9661c.q0(i10);
    }

    public void setSuffixTextColor(@NonNull ColorStateList colorStateList) {
        this.f9661c.r0(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(@Nullable d dVar) {
        EditText editText = this.f9663d;
        if (editText != null) {
            ViewCompat.setAccessibilityDelegate(editText, dVar);
        }
    }

    public void setTypeface(@Nullable Typeface typeface) {
        if (typeface != this.f9660b0) {
            this.f9660b0 = typeface;
            this.f9700v0.i0(typeface);
            this.f9675j.N(typeface);
            TextView textView = this.f9685o;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    void u0(boolean z10) {
        v0(z10, false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r3v46, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v66 */
    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        ?? r32;
        int i11 = C0;
        super(b5.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        this.f9667f = -1;
        this.f9669g = -1;
        this.f9671h = -1;
        this.f9673i = -1;
        this.f9675j = new v(this);
        this.f9683n = new e() { // from class: com.google.android.material.textfield.f0
            @Override // com.google.android.material.textfield.TextInputLayout.e
            public final int a(Editable editable) {
                return TextInputLayout.T(editable);
            }
        };
        this.V = new Rect();
        this.W = new Rect();
        this.f9658a0 = new RectF();
        this.f9666e0 = new LinkedHashSet<>();
        com.google.android.material.internal.a aVar = new com.google.android.material.internal.a(this);
        this.f9700v0 = aVar;
        this.B0 = false;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f9657a = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        TimeInterpolator timeInterpolator = f4.a.f25668a;
        aVar.h0(timeInterpolator);
        aVar.e0(timeInterpolator);
        aVar.S(8388659);
        int[] iArr = e4.k.f25044p5;
        int i12 = e4.k.M5;
        int i13 = e4.k.K5;
        int i14 = e4.k.f24957e6;
        int i15 = e4.k.f24997j6;
        int i16 = e4.k.f25029n6;
        TintTypedArray tintTypedArrayJ = com.google.android.material.internal.p.j(context2, attributeSet, iArr, i10, i11, i12, i13, i14, i15, i16);
        a0 a0Var = new a0(this, tintTypedArrayJ);
        this.f9659b = a0Var;
        this.C = tintTypedArrayJ.getBoolean(e4.k.f25021m6, true);
        setHint(tintTypedArrayJ.getText(e4.k.f25084u5));
        this.f9704x0 = tintTypedArrayJ.getBoolean(e4.k.f25013l6, true);
        this.f9702w0 = tintTypedArrayJ.getBoolean(e4.k.f24973g6, true);
        int i17 = e4.k.f25100w5;
        if (tintTypedArrayJ.hasValue(i17)) {
            setMinEms(tintTypedArrayJ.getInt(i17, -1));
        } else {
            int i18 = e4.k.f25076t5;
            if (tintTypedArrayJ.hasValue(i18)) {
                setMinWidth(tintTypedArrayJ.getDimensionPixelSize(i18, -1));
            }
        }
        int i19 = e4.k.f25092v5;
        if (tintTypedArrayJ.hasValue(i19)) {
            setMaxEms(tintTypedArrayJ.getInt(i19, -1));
        } else {
            int i20 = e4.k.f25068s5;
            if (tintTypedArrayJ.hasValue(i20)) {
                setMaxWidth(tintTypedArrayJ.getDimensionPixelSize(i20, -1));
            }
        }
        this.L = x4.k.e(context2, attributeSet, i10, i11).m();
        this.N = context2.getResources().getDimensionPixelOffset(e4.d.f24781c0);
        this.P = tintTypedArrayJ.getDimensionPixelOffset(e4.k.f25124z5, 0);
        this.R = tintTypedArrayJ.getDimensionPixelSize(e4.k.G5, context2.getResources().getDimensionPixelSize(e4.d.f24783d0));
        this.S = tintTypedArrayJ.getDimensionPixelSize(e4.k.H5, context2.getResources().getDimensionPixelSize(e4.d.f24785e0));
        this.Q = this.R;
        float dimension = tintTypedArrayJ.getDimension(e4.k.D5, -1.0f);
        float dimension2 = tintTypedArrayJ.getDimension(e4.k.C5, -1.0f);
        float dimension3 = tintTypedArrayJ.getDimension(e4.k.A5, -1.0f);
        float dimension4 = tintTypedArrayJ.getDimension(e4.k.B5, -1.0f);
        k.b bVarV = this.L.v();
        if (dimension >= 0.0f) {
            bVarV.A(dimension);
        }
        if (dimension2 >= 0.0f) {
            bVarV.E(dimension2);
        }
        if (dimension3 >= 0.0f) {
            bVarV.w(dimension3);
        }
        if (dimension4 >= 0.0f) {
            bVarV.s(dimension4);
        }
        this.L = bVarV.m();
        ColorStateList colorStateListB = u4.c.b(context2, tintTypedArrayJ, e4.k.f25108x5);
        if (colorStateListB != null) {
            int defaultColor = colorStateListB.getDefaultColor();
            this.f9686o0 = defaultColor;
            this.U = defaultColor;
            if (colorStateListB.isStateful()) {
                this.f9688p0 = colorStateListB.getColorForState(new int[]{-16842910}, -1);
                this.f9690q0 = colorStateListB.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.f9692r0 = colorStateListB.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.f9690q0 = this.f9686o0;
                ColorStateList colorStateList = AppCompatResources.getColorStateList(context2, e4.c.f24772c);
                this.f9688p0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
                this.f9692r0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            this.U = 0;
            this.f9686o0 = 0;
            this.f9688p0 = 0;
            this.f9690q0 = 0;
            this.f9692r0 = 0;
        }
        int i21 = e4.k.f25060r5;
        if (tintTypedArrayJ.hasValue(i21)) {
            ColorStateList colorStateList2 = tintTypedArrayJ.getColorStateList(i21);
            this.f9676j0 = colorStateList2;
            this.f9674i0 = colorStateList2;
        }
        int i22 = e4.k.E5;
        ColorStateList colorStateListB2 = u4.c.b(context2, tintTypedArrayJ, i22);
        this.f9682m0 = tintTypedArrayJ.getColor(i22, 0);
        this.f9678k0 = ContextCompat.getColor(context2, e4.c.f24773d);
        this.f9694s0 = ContextCompat.getColor(context2, e4.c.f24774e);
        this.f9680l0 = ContextCompat.getColor(context2, e4.c.f24775f);
        if (colorStateListB2 != null) {
            setBoxStrokeColorStateList(colorStateListB2);
        }
        int i23 = e4.k.F5;
        if (tintTypedArrayJ.hasValue(i23)) {
            setBoxStrokeErrorColor(u4.c.b(context2, tintTypedArrayJ, i23));
        }
        if (tintTypedArrayJ.getResourceId(i16, -1) != -1) {
            r32 = 0;
            setHintTextAppearance(tintTypedArrayJ.getResourceId(i16, 0));
        } else {
            r32 = 0;
        }
        this.A = tintTypedArrayJ.getColorStateList(e4.k.O5);
        this.B = tintTypedArrayJ.getColorStateList(e4.k.P5);
        int resourceId = tintTypedArrayJ.getResourceId(i14, r32);
        CharSequence text = tintTypedArrayJ.getText(e4.k.Z5);
        int i24 = tintTypedArrayJ.getInt(e4.k.Y5, 1);
        boolean z10 = tintTypedArrayJ.getBoolean(e4.k.f24925a6, r32);
        int resourceId2 = tintTypedArrayJ.getResourceId(i15, r32);
        boolean z11 = tintTypedArrayJ.getBoolean(e4.k.f24989i6, r32);
        CharSequence text2 = tintTypedArrayJ.getText(e4.k.f24981h6);
        int resourceId3 = tintTypedArrayJ.getResourceId(e4.k.f25093v6, r32);
        CharSequence text3 = tintTypedArrayJ.getText(e4.k.f25085u6);
        boolean z12 = tintTypedArrayJ.getBoolean(e4.k.I5, r32);
        setCounterMaxLength(tintTypedArrayJ.getInt(e4.k.J5, -1));
        this.f9689q = tintTypedArrayJ.getResourceId(i12, 0);
        this.f9687p = tintTypedArrayJ.getResourceId(i13, 0);
        setBoxBackgroundMode(tintTypedArrayJ.getInt(e4.k.f25116y5, 0));
        setErrorContentDescription(text);
        setErrorAccessibilityLiveRegion(i24);
        setCounterOverflowTextAppearance(this.f9687p);
        setHelperTextTextAppearance(resourceId2);
        setErrorTextAppearance(resourceId);
        setCounterTextAppearance(this.f9689q);
        setPlaceholderText(text3);
        setPlaceholderTextAppearance(resourceId3);
        int i25 = e4.k.f24965f6;
        if (tintTypedArrayJ.hasValue(i25)) {
            setErrorTextColor(tintTypedArrayJ.getColorStateList(i25));
        }
        int i26 = e4.k.f25005k6;
        if (tintTypedArrayJ.hasValue(i26)) {
            setHelperTextColor(tintTypedArrayJ.getColorStateList(i26));
        }
        int i27 = e4.k.f25037o6;
        if (tintTypedArrayJ.hasValue(i27)) {
            setHintTextColor(tintTypedArrayJ.getColorStateList(i27));
        }
        int i28 = e4.k.N5;
        if (tintTypedArrayJ.hasValue(i28)) {
            setCounterTextColor(tintTypedArrayJ.getColorStateList(i28));
        }
        int i29 = e4.k.L5;
        if (tintTypedArrayJ.hasValue(i29)) {
            setCounterOverflowTextColor(tintTypedArrayJ.getColorStateList(i29));
        }
        int i30 = e4.k.f25101w6;
        if (tintTypedArrayJ.hasValue(i30)) {
            setPlaceholderTextColor(tintTypedArrayJ.getColorStateList(i30));
        }
        s sVar = new s(this, tintTypedArrayJ);
        this.f9661c = sVar;
        boolean z13 = tintTypedArrayJ.getBoolean(e4.k.f25052q5, true);
        tintTypedArrayJ.recycle();
        ViewCompat.setImportantForAccessibility(this, 2);
        if (Build.VERSION.SDK_INT >= 26) {
            ViewCompat.setImportantForAutofill(this, 1);
        }
        frameLayout.addView(a0Var);
        frameLayout.addView(sVar);
        addView(frameLayout);
        setEnabled(z13);
        setHelperTextEnabled(z11);
        setErrorEnabled(z10);
        setCounterEnabled(z12);
        setHelperText(text2);
    }

    public void setEndIconContentDescription(@Nullable CharSequence charSequence) {
        this.f9661c.Q(charSequence);
    }

    public void setEndIconDrawable(@Nullable Drawable drawable) {
        this.f9661c.S(drawable);
    }

    public void setErrorIconDrawable(@Nullable Drawable drawable) {
        this.f9661c.c0(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence charSequence) {
        this.f9661c.j0(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable drawable) {
        this.f9661c.l0(drawable);
    }

    public void setStartIconContentDescription(@Nullable CharSequence charSequence) {
        this.f9659b.r(charSequence);
    }

    public void setStartIconDrawable(@Nullable Drawable drawable) {
        this.f9659b.s(drawable);
    }

    public void setHint(@StringRes int i10) {
        setHint(i10 != 0 ? getResources().getText(i10) : null);
    }

    class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f9709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ EditText f9710b;

        a(EditText editText) {
            this.f9710b = editText;
            this.f9709a = editText.getLineCount();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NonNull Editable editable) {
            TextInputLayout.this.u0(!r0.A0);
            TextInputLayout textInputLayout = TextInputLayout.this;
            if (textInputLayout.f9677k) {
                textInputLayout.k0(editable);
            }
            if (TextInputLayout.this.f9693s) {
                TextInputLayout.this.y0(editable);
            }
            int lineCount = this.f9710b.getLineCount();
            int i10 = this.f9709a;
            if (lineCount != i10) {
                if (lineCount < i10) {
                    int minimumHeight = ViewCompat.getMinimumHeight(this.f9710b);
                    int i11 = TextInputLayout.this.f9696t0;
                    if (minimumHeight != i11) {
                        this.f9710b.setMinimumHeight(i11);
                    }
                }
                this.f9709a = lineCount;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }
}
