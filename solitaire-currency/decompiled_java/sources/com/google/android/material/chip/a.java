package com.google.android.material.chip;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.AttrRes;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.n;
import com.google.android.material.internal.p;
import com.google.android.material.internal.s;
import e4.k;
import f4.h;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import u4.c;
import u4.d;
import x4.g;

/* JADX INFO: compiled from: ChipDrawable.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends g implements Drawable.Callback, n.b {
    private static final int[] J0 = {R.attr.state_enabled};
    private static final ShapeDrawable K0 = new ShapeDrawable(new OvalShape());

    @Nullable
    private ColorStateList A;

    @Nullable
    private PorterDuff.Mode A0;
    private float B;
    private int[] B0;
    private float C;
    private boolean C0;

    @Nullable
    private ColorStateList D;

    @Nullable
    private ColorStateList D0;
    private float E;

    @NonNull
    private WeakReference<InterfaceC0208a> E0;

    @Nullable
    private ColorStateList F;
    private TextUtils.TruncateAt F0;

    @Nullable
    private CharSequence G;
    private boolean G0;
    private boolean H;
    private int H0;

    @Nullable
    private Drawable I;
    private boolean I0;

    @Nullable
    private ColorStateList J;
    private float K;
    private boolean L;
    private boolean M;

    @Nullable
    private Drawable N;

    @Nullable
    private Drawable O;

    @Nullable
    private ColorStateList P;
    private float Q;

    @Nullable
    private CharSequence R;
    private boolean S;
    private boolean T;

    @Nullable
    private Drawable U;

    @Nullable
    private ColorStateList V;

    @Nullable
    private h W;

    @Nullable
    private h X;
    private float Y;
    private float Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private float f9104a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private float f9105b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private float f9106c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private float f9107d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private float f9108e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private float f9109f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    @NonNull
    private final Context f9110g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private final Paint f9111h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    @Nullable
    private final Paint f9112i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private final Paint.FontMetrics f9113j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private final RectF f9114k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private final PointF f9115l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private final Path f9116m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    @NonNull
    private final n f9117n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    @ColorInt
    private int f9118o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    @ColorInt
    private int f9119p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    @ColorInt
    private int f9120q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    @ColorInt
    private int f9121r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    @ColorInt
    private int f9122s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    @ColorInt
    private int f9123t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private boolean f9124u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    @ColorInt
    private int f9125v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private int f9126w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    @Nullable
    private ColorFilter f9127x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    @Nullable
    private PorterDuffColorFilter f9128y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    private ColorStateList f9129z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    @Nullable
    private ColorStateList f9130z0;

    /* JADX INFO: renamed from: com.google.android.material.chip.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ChipDrawable.java */
    public interface InterfaceC0208a {
        void a();
    }

    private a(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i10, @StyleRes int i11) {
        super(context, attributeSet, i10, i11);
        this.C = -1.0f;
        this.f9111h0 = new Paint(1);
        this.f9113j0 = new Paint.FontMetrics();
        this.f9114k0 = new RectF();
        this.f9115l0 = new PointF();
        this.f9116m0 = new Path();
        this.f9126w0 = 255;
        this.A0 = PorterDuff.Mode.SRC_IN;
        this.E0 = new WeakReference<>(null);
        O(context);
        this.f9110g0 = context;
        n nVar = new n(this);
        this.f9117n0 = nVar;
        this.G = "";
        nVar.f().density = context.getResources().getDisplayMetrics().density;
        this.f9112i0 = null;
        int[] iArr = J0;
        setState(iArr);
        k2(iArr);
        this.G0 = true;
        if (v4.b.f35115a) {
            K0.setTint(-1);
        }
    }

    private void A0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (O2()) {
            n0(rect, this.f9114k0);
            RectF rectF = this.f9114k0;
            float f10 = rectF.left;
            float f11 = rectF.top;
            canvas.translate(f10, f11);
            this.N.setBounds(0, 0, (int) this.f9114k0.width(), (int) this.f9114k0.height());
            if (v4.b.f35115a) {
                this.O.setBounds(this.N.getBounds());
                this.O.jumpToCurrentState();
                this.O.draw(canvas);
            } else {
                this.N.draw(canvas);
            }
            canvas.translate(-f10, -f11);
        }
    }

    private void B0(@NonNull Canvas canvas, @NonNull Rect rect) {
        this.f9111h0.setColor(this.f9122s0);
        this.f9111h0.setStyle(Paint.Style.FILL);
        this.f9114k0.set(rect);
        if (!this.I0) {
            canvas.drawRoundRect(this.f9114k0, H0(), H0(), this.f9111h0);
        } else {
            h(new RectF(rect), this.f9116m0);
            super.p(canvas, this.f9111h0, this.f9116m0, s());
        }
    }

    private void C0(@NonNull Canvas canvas, @NonNull Rect rect) {
        Paint paint = this.f9112i0;
        if (paint != null) {
            paint.setColor(ColorUtils.setAlphaComponent(ViewCompat.MEASURED_STATE_MASK, 127));
            canvas.drawRect(rect, this.f9112i0);
            if (N2() || M2()) {
                k0(rect, this.f9114k0);
                canvas.drawRect(this.f9114k0, this.f9112i0);
            }
            if (this.G != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.f9112i0);
            }
            if (O2()) {
                n0(rect, this.f9114k0);
                canvas.drawRect(this.f9114k0, this.f9112i0);
            }
            this.f9112i0.setColor(ColorUtils.setAlphaComponent(SupportMenu.CATEGORY_MASK, 127));
            m0(rect, this.f9114k0);
            canvas.drawRect(this.f9114k0, this.f9112i0);
            this.f9112i0.setColor(ColorUtils.setAlphaComponent(-16711936, 127));
            o0(rect, this.f9114k0);
            canvas.drawRect(this.f9114k0, this.f9112i0);
        }
    }

    private void D0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.G != null) {
            Paint.Align alignS0 = s0(rect, this.f9115l0);
            q0(rect, this.f9114k0);
            if (this.f9117n0.e() != null) {
                this.f9117n0.f().drawableState = getState();
                this.f9117n0.l(this.f9110g0);
            }
            this.f9117n0.f().setTextAlign(alignS0);
            int iSave = 0;
            boolean z10 = Math.round(this.f9117n0.g(g1().toString())) > Math.round(this.f9114k0.width());
            if (z10) {
                iSave = canvas.save();
                canvas.clipRect(this.f9114k0);
            }
            CharSequence charSequenceEllipsize = this.G;
            if (z10 && this.F0 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.f9117n0.f(), this.f9114k0.width(), this.F0);
            }
            CharSequence charSequence = charSequenceEllipsize;
            int length = charSequence.length();
            PointF pointF = this.f9115l0;
            canvas.drawText(charSequence, 0, length, pointF.x, pointF.y, this.f9117n0.f());
            if (z10) {
                canvas.restoreToCount(iSave);
            }
        }
    }

    private boolean M2() {
        return this.T && this.U != null && this.f9124u0;
    }

    private boolean N2() {
        return this.H && this.I != null;
    }

    private boolean O2() {
        return this.M && this.N != null;
    }

    private void P2(@Nullable Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private void Q2() {
        this.D0 = this.C0 ? v4.b.a(this.F) : null;
    }

    @TargetApi(21)
    private void R2() {
        this.O = new RippleDrawable(v4.b.a(e1()), this.N, K0);
    }

    private float Y0() {
        Drawable drawable = this.f9124u0 ? this.U : this.I;
        float fCeil = this.K;
        if (fCeil <= 0.0f && drawable != null) {
            fCeil = (float) Math.ceil(s.c(this.f9110g0, 24));
            if (drawable.getIntrinsicHeight() <= fCeil) {
                return drawable.getIntrinsicHeight();
            }
        }
        return fCeil;
    }

    private float Z0() {
        Drawable drawable = this.f9124u0 ? this.U : this.I;
        float f10 = this.K;
        return (f10 > 0.0f || drawable == null) ? f10 : drawable.getIntrinsicWidth();
    }

    private void a2(@Nullable ColorStateList colorStateList) {
        if (this.f9129z != colorStateList) {
            this.f9129z = colorStateList;
            onStateChange(getState());
        }
    }

    private void j0(@Nullable Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        DrawableCompat.setLayoutDirection(drawable, DrawableCompat.getLayoutDirection(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.N) {
            if (drawable.isStateful()) {
                drawable.setState(V0());
            }
            DrawableCompat.setTintList(drawable, this.P);
            return;
        }
        Drawable drawable2 = this.I;
        if (drawable == drawable2 && this.L) {
            DrawableCompat.setTintList(drawable2, this.J);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    private void k0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (N2() || M2()) {
            float f10 = this.Y + this.Z;
            float fZ0 = Z0();
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f11 = rect.left + f10;
                rectF.left = f11;
                rectF.right = f11 + fZ0;
            } else {
                float f12 = rect.right - f10;
                rectF.right = f12;
                rectF.left = f12 - fZ0;
            }
            float fY0 = Y0();
            float fExactCenterY = rect.exactCenterY() - (fY0 / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fY0;
        }
    }

    @Nullable
    private ColorFilter k1() {
        ColorFilter colorFilter = this.f9127x0;
        return colorFilter != null ? colorFilter : this.f9128y0;
    }

    private void m0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.set(rect);
        if (O2()) {
            float f10 = this.f9109f0 + this.f9108e0 + this.Q + this.f9107d0 + this.f9106c0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF.right = rect.right - f10;
            } else {
                rectF.left = rect.left + f10;
            }
        }
    }

    private static boolean m1(@Nullable int[] iArr, @AttrRes int i10) {
        if (iArr == null) {
            return false;
        }
        for (int i11 : iArr) {
            if (i11 == i10) {
                return true;
            }
        }
        return false;
    }

    private void n0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (O2()) {
            float f10 = this.f9109f0 + this.f9108e0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f11 = rect.right - f10;
                rectF.right = f11;
                rectF.left = f11 - this.Q;
            } else {
                float f12 = rect.left + f10;
                rectF.left = f12;
                rectF.right = f12 + this.Q;
            }
            float fExactCenterY = rect.exactCenterY();
            float f13 = this.Q;
            float f14 = fExactCenterY - (f13 / 2.0f);
            rectF.top = f14;
            rectF.bottom = f14 + f13;
        }
    }

    private void o0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (O2()) {
            float f10 = this.f9109f0 + this.f9108e0 + this.Q + this.f9107d0 + this.f9106c0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f11 = rect.right;
                rectF.right = f11;
                rectF.left = f11 - f10;
            } else {
                int i10 = rect.left;
                rectF.left = i10;
                rectF.right = i10 + f10;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private void q0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (this.G != null) {
            float fL0 = this.Y + l0() + this.f9105b0;
            float fP0 = this.f9109f0 + p0() + this.f9106c0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF.left = rect.left + fL0;
                rectF.right = rect.right - fP0;
            } else {
                rectF.left = rect.left + fP0;
                rectF.right = rect.right - fL0;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private static boolean q1(@Nullable ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private float r0() {
        this.f9117n0.f().getFontMetrics(this.f9113j0);
        Paint.FontMetrics fontMetrics = this.f9113j0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private static boolean r1(@Nullable Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private static boolean s1(@Nullable d dVar) {
        return (dVar == null || dVar.i() == null || !dVar.i().isStateful()) ? false : true;
    }

    private boolean t0() {
        return this.T && this.U != null && this.S;
    }

    private void t1(@Nullable AttributeSet attributeSet, @AttrRes int i10, @StyleRes int i11) {
        TypedArray typedArrayI = p.i(this.f9110g0, attributeSet, k.f24951e0, i10, i11, new int[0]);
        this.I0 = typedArrayI.hasValue(k.P0);
        a2(c.a(this.f9110g0, typedArrayI, k.C0));
        E1(c.a(this.f9110g0, typedArrayI, k.f25039p0));
        S1(typedArrayI.getDimension(k.f25103x0, 0.0f));
        int i12 = k.f25047q0;
        if (typedArrayI.hasValue(i12)) {
            G1(typedArrayI.getDimension(i12, 0.0f));
        }
        W1(c.a(this.f9110g0, typedArrayI, k.A0));
        Y1(typedArrayI.getDimension(k.B0, 0.0f));
        x2(c.a(this.f9110g0, typedArrayI, k.O0));
        C2(typedArrayI.getText(k.f24991j0));
        d dVarF = c.f(this.f9110g0, typedArrayI, k.f24959f0);
        dVarF.l(typedArrayI.getDimension(k.f24967g0, dVarF.j()));
        D2(dVarF);
        int i13 = typedArrayI.getInt(k.f24975h0, 0);
        if (i13 == 1) {
            p2(TextUtils.TruncateAt.START);
        } else if (i13 == 2) {
            p2(TextUtils.TruncateAt.MIDDLE);
        } else if (i13 == 3) {
            p2(TextUtils.TruncateAt.END);
        }
        R1(typedArrayI.getBoolean(k.f25095w0, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            R1(typedArrayI.getBoolean(k.f25071t0, false));
        }
        K1(c.d(this.f9110g0, typedArrayI, k.f25063s0));
        int i14 = k.f25087v0;
        if (typedArrayI.hasValue(i14)) {
            O1(c.a(this.f9110g0, typedArrayI, i14));
        }
        M1(typedArrayI.getDimension(k.f25079u0, -1.0f));
        n2(typedArrayI.getBoolean(k.J0, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            n2(typedArrayI.getBoolean(k.E0, false));
        }
        b2(c.d(this.f9110g0, typedArrayI, k.D0));
        l2(c.a(this.f9110g0, typedArrayI, k.I0));
        g2(typedArrayI.getDimension(k.G0, 0.0f));
        w1(typedArrayI.getBoolean(k.f24999k0, false));
        D1(typedArrayI.getBoolean(k.f25031o0, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            D1(typedArrayI.getBoolean(k.f25015m0, false));
        }
        y1(c.d(this.f9110g0, typedArrayI, k.f25007l0));
        int i15 = k.f25023n0;
        if (typedArrayI.hasValue(i15)) {
            A1(c.a(this.f9110g0, typedArrayI, i15));
        }
        A2(h.b(this.f9110g0, typedArrayI, k.Q0));
        q2(h.b(this.f9110g0, typedArrayI, k.L0));
        U1(typedArrayI.getDimension(k.f25119z0, 0.0f));
        u2(typedArrayI.getDimension(k.N0, 0.0f));
        s2(typedArrayI.getDimension(k.M0, 0.0f));
        I2(typedArrayI.getDimension(k.S0, 0.0f));
        F2(typedArrayI.getDimension(k.R0, 0.0f));
        i2(typedArrayI.getDimension(k.H0, 0.0f));
        d2(typedArrayI.getDimension(k.F0, 0.0f));
        I1(typedArrayI.getDimension(k.f25055r0, 0.0f));
        w2(typedArrayI.getDimensionPixelSize(k.f24983i0, Integer.MAX_VALUE));
        typedArrayI.recycle();
    }

    @NonNull
    public static a u0(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i10, @StyleRes int i11) {
        a aVar = new a(context, attributeSet, i10, i11);
        aVar.t1(attributeSet, i10, i11);
        return aVar;
    }

    private void v0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (M2()) {
            k0(rect, this.f9114k0);
            RectF rectF = this.f9114k0;
            float f10 = rectF.left;
            float f11 = rectF.top;
            canvas.translate(f10, f11);
            this.U.setBounds(0, 0, (int) this.f9114k0.width(), (int) this.f9114k0.height());
            this.U.draw(canvas);
            canvas.translate(-f10, -f11);
        }
    }

    private boolean v1(@NonNull int[] iArr, @NonNull int[] iArr2) {
        boolean z10;
        boolean zOnStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.f9129z;
        int iL = l(colorStateList != null ? colorStateList.getColorForState(iArr, this.f9118o0) : 0);
        boolean state = true;
        if (this.f9118o0 != iL) {
            this.f9118o0 = iL;
            zOnStateChange = true;
        }
        ColorStateList colorStateList2 = this.A;
        int iL2 = l(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.f9119p0) : 0);
        if (this.f9119p0 != iL2) {
            this.f9119p0 = iL2;
            zOnStateChange = true;
        }
        int i10 = n4.a.i(iL, iL2);
        if ((this.f9120q0 != i10) | (v() == null)) {
            this.f9120q0 = i10;
            Y(ColorStateList.valueOf(i10));
            zOnStateChange = true;
        }
        ColorStateList colorStateList3 = this.D;
        int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.f9121r0) : 0;
        if (this.f9121r0 != colorForState) {
            this.f9121r0 = colorForState;
            zOnStateChange = true;
        }
        int colorForState2 = (this.D0 == null || !v4.b.b(iArr)) ? 0 : this.D0.getColorForState(iArr, this.f9122s0);
        if (this.f9122s0 != colorForState2) {
            this.f9122s0 = colorForState2;
            if (this.C0) {
                zOnStateChange = true;
            }
        }
        int colorForState3 = (this.f9117n0.e() == null || this.f9117n0.e().i() == null) ? 0 : this.f9117n0.e().i().getColorForState(iArr, this.f9123t0);
        if (this.f9123t0 != colorForState3) {
            this.f9123t0 = colorForState3;
            zOnStateChange = true;
        }
        boolean z11 = m1(getState(), R.attr.state_checked) && this.S;
        if (this.f9124u0 == z11 || this.U == null) {
            z10 = false;
        } else {
            float fL0 = l0();
            this.f9124u0 = z11;
            if (fL0 != l0()) {
                zOnStateChange = true;
                z10 = true;
            } else {
                z10 = false;
                zOnStateChange = true;
            }
        }
        ColorStateList colorStateList4 = this.f9130z0;
        int colorForState4 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.f9125v0) : 0;
        if (this.f9125v0 != colorForState4) {
            this.f9125v0 = colorForState4;
            this.f9128y0 = com.google.android.material.drawable.b.j(this, this.f9130z0, this.A0);
        } else {
            state = zOnStateChange;
        }
        if (r1(this.I)) {
            state |= this.I.setState(iArr);
        }
        if (r1(this.U)) {
            state |= this.U.setState(iArr);
        }
        if (r1(this.N)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            state |= this.N.setState(iArr3);
        }
        if (v4.b.f35115a && r1(this.O)) {
            state |= this.O.setState(iArr2);
        }
        if (state) {
            invalidateSelf();
        }
        if (z10) {
            u1();
        }
        return state;
    }

    private void w0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.I0) {
            return;
        }
        this.f9111h0.setColor(this.f9119p0);
        this.f9111h0.setStyle(Paint.Style.FILL);
        this.f9111h0.setColorFilter(k1());
        this.f9114k0.set(rect);
        canvas.drawRoundRect(this.f9114k0, H0(), H0(), this.f9111h0);
    }

    private void x0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (N2()) {
            k0(rect, this.f9114k0);
            RectF rectF = this.f9114k0;
            float f10 = rectF.left;
            float f11 = rectF.top;
            canvas.translate(f10, f11);
            this.I.setBounds(0, 0, (int) this.f9114k0.width(), (int) this.f9114k0.height());
            this.I.draw(canvas);
            canvas.translate(-f10, -f11);
        }
    }

    private void y0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.E <= 0.0f || this.I0) {
            return;
        }
        this.f9111h0.setColor(this.f9121r0);
        this.f9111h0.setStyle(Paint.Style.STROKE);
        if (!this.I0) {
            this.f9111h0.setColorFilter(k1());
        }
        RectF rectF = this.f9114k0;
        float f10 = rect.left;
        float f11 = this.E;
        rectF.set(f10 + (f11 / 2.0f), rect.top + (f11 / 2.0f), rect.right - (f11 / 2.0f), rect.bottom - (f11 / 2.0f));
        float f12 = this.C - (this.E / 2.0f);
        canvas.drawRoundRect(this.f9114k0, f12, f12, this.f9111h0);
    }

    private void z0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.I0) {
            return;
        }
        this.f9111h0.setColor(this.f9118o0);
        this.f9111h0.setStyle(Paint.Style.FILL);
        this.f9114k0.set(rect);
        canvas.drawRoundRect(this.f9114k0, H0(), H0(), this.f9111h0);
    }

    public void A1(@Nullable ColorStateList colorStateList) {
        if (this.V != colorStateList) {
            this.V = colorStateList;
            if (t0()) {
                DrawableCompat.setTintList(this.U, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void A2(@Nullable h hVar) {
        this.W = hVar;
    }

    public void B1(@ColorRes int i10) {
        A1(AppCompatResources.getColorStateList(this.f9110g0, i10));
    }

    public void B2(@AnimatorRes int i10) {
        A2(h.c(this.f9110g0, i10));
    }

    public void C1(@BoolRes int i10) {
        D1(this.f9110g0.getResources().getBoolean(i10));
    }

    public void C2(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (TextUtils.equals(this.G, charSequence)) {
            return;
        }
        this.G = charSequence;
        this.f9117n0.k(true);
        invalidateSelf();
        u1();
    }

    public void D1(boolean z10) {
        if (this.T != z10) {
            boolean zM2 = M2();
            this.T = z10;
            boolean zM22 = M2();
            if (zM2 != zM22) {
                if (zM22) {
                    j0(this.U);
                } else {
                    P2(this.U);
                }
                invalidateSelf();
                u1();
            }
        }
    }

    public void D2(@Nullable d dVar) {
        this.f9117n0.j(dVar, this.f9110g0);
    }

    @Nullable
    public Drawable E0() {
        return this.U;
    }

    public void E1(@Nullable ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            onStateChange(getState());
        }
    }

    public void E2(@StyleRes int i10) {
        D2(new d(this.f9110g0, i10));
    }

    @Nullable
    public ColorStateList F0() {
        return this.V;
    }

    public void F1(@ColorRes int i10) {
        E1(AppCompatResources.getColorStateList(this.f9110g0, i10));
    }

    public void F2(float f10) {
        if (this.f9106c0 != f10) {
            this.f9106c0 = f10;
            invalidateSelf();
            u1();
        }
    }

    @Nullable
    public ColorStateList G0() {
        return this.A;
    }

    @Deprecated
    public void G1(float f10) {
        if (this.C != f10) {
            this.C = f10;
            setShapeAppearanceModel(C().w(f10));
        }
    }

    public void G2(@DimenRes int i10) {
        F2(this.f9110g0.getResources().getDimension(i10));
    }

    public float H0() {
        return this.I0 ? H() : this.C;
    }

    @Deprecated
    public void H1(@DimenRes int i10) {
        G1(this.f9110g0.getResources().getDimension(i10));
    }

    public void H2(@Dimension float f10) {
        d dVarH1 = h1();
        if (dVarH1 != null) {
            dVarH1.l(f10);
            this.f9117n0.f().setTextSize(f10);
            a();
        }
    }

    public float I0() {
        return this.f9109f0;
    }

    public void I1(float f10) {
        if (this.f9109f0 != f10) {
            this.f9109f0 = f10;
            invalidateSelf();
            u1();
        }
    }

    public void I2(float f10) {
        if (this.f9105b0 != f10) {
            this.f9105b0 = f10;
            invalidateSelf();
            u1();
        }
    }

    @Nullable
    public Drawable J0() {
        Drawable drawable = this.I;
        if (drawable != null) {
            return DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    public void J1(@DimenRes int i10) {
        I1(this.f9110g0.getResources().getDimension(i10));
    }

    public void J2(@DimenRes int i10) {
        I2(this.f9110g0.getResources().getDimension(i10));
    }

    public float K0() {
        return this.K;
    }

    public void K1(@Nullable Drawable drawable) {
        Drawable drawableJ0 = J0();
        if (drawableJ0 != drawable) {
            float fL0 = l0();
            this.I = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
            float fL02 = l0();
            P2(drawableJ0);
            if (N2()) {
                j0(this.I);
            }
            invalidateSelf();
            if (fL0 != fL02) {
                u1();
            }
        }
    }

    public void K2(boolean z10) {
        if (this.C0 != z10) {
            this.C0 = z10;
            Q2();
            onStateChange(getState());
        }
    }

    @Nullable
    public ColorStateList L0() {
        return this.J;
    }

    public void L1(@DrawableRes int i10) {
        K1(AppCompatResources.getDrawable(this.f9110g0, i10));
    }

    boolean L2() {
        return this.G0;
    }

    public float M0() {
        return this.B;
    }

    public void M1(float f10) {
        if (this.K != f10) {
            float fL0 = l0();
            this.K = f10;
            float fL02 = l0();
            invalidateSelf();
            if (fL0 != fL02) {
                u1();
            }
        }
    }

    public float N0() {
        return this.Y;
    }

    public void N1(@DimenRes int i10) {
        M1(this.f9110g0.getResources().getDimension(i10));
    }

    @Nullable
    public ColorStateList O0() {
        return this.D;
    }

    public void O1(@Nullable ColorStateList colorStateList) {
        this.L = true;
        if (this.J != colorStateList) {
            this.J = colorStateList;
            if (N2()) {
                DrawableCompat.setTintList(this.I, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public float P0() {
        return this.E;
    }

    public void P1(@ColorRes int i10) {
        O1(AppCompatResources.getColorStateList(this.f9110g0, i10));
    }

    @Nullable
    public Drawable Q0() {
        Drawable drawable = this.N;
        if (drawable != null) {
            return DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    public void Q1(@BoolRes int i10) {
        R1(this.f9110g0.getResources().getBoolean(i10));
    }

    @Nullable
    public CharSequence R0() {
        return this.R;
    }

    public void R1(boolean z10) {
        if (this.H != z10) {
            boolean zN2 = N2();
            this.H = z10;
            boolean zN22 = N2();
            if (zN2 != zN22) {
                if (zN22) {
                    j0(this.I);
                } else {
                    P2(this.I);
                }
                invalidateSelf();
                u1();
            }
        }
    }

    public float S0() {
        return this.f9108e0;
    }

    public void S1(float f10) {
        if (this.B != f10) {
            this.B = f10;
            invalidateSelf();
            u1();
        }
    }

    public float T0() {
        return this.Q;
    }

    public void T1(@DimenRes int i10) {
        S1(this.f9110g0.getResources().getDimension(i10));
    }

    public float U0() {
        return this.f9107d0;
    }

    public void U1(float f10) {
        if (this.Y != f10) {
            this.Y = f10;
            invalidateSelf();
            u1();
        }
    }

    @NonNull
    public int[] V0() {
        return this.B0;
    }

    public void V1(@DimenRes int i10) {
        U1(this.f9110g0.getResources().getDimension(i10));
    }

    @Nullable
    public ColorStateList W0() {
        return this.P;
    }

    public void W1(@Nullable ColorStateList colorStateList) {
        if (this.D != colorStateList) {
            this.D = colorStateList;
            if (this.I0) {
                e0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void X0(@NonNull RectF rectF) {
        o0(getBounds(), rectF);
    }

    public void X1(@ColorRes int i10) {
        W1(AppCompatResources.getColorStateList(this.f9110g0, i10));
    }

    public void Y1(float f10) {
        if (this.E != f10) {
            this.E = f10;
            this.f9111h0.setStrokeWidth(f10);
            if (this.I0) {
                super.f0(f10);
            }
            invalidateSelf();
        }
    }

    public void Z1(@DimenRes int i10) {
        Y1(this.f9110g0.getResources().getDimension(i10));
    }

    @Override // com.google.android.material.internal.n.b
    public void a() {
        u1();
        invalidateSelf();
    }

    public TextUtils.TruncateAt a1() {
        return this.F0;
    }

    @Nullable
    public h b1() {
        return this.X;
    }

    public void b2(@Nullable Drawable drawable) {
        Drawable drawableQ0 = Q0();
        if (drawableQ0 != drawable) {
            float fP0 = p0();
            this.N = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
            if (v4.b.f35115a) {
                R2();
            }
            float fP02 = p0();
            P2(drawableQ0);
            if (O2()) {
                j0(this.N);
            }
            invalidateSelf();
            if (fP0 != fP02) {
                u1();
            }
        }
    }

    public float c1() {
        return this.f9104a0;
    }

    public void c2(@Nullable CharSequence charSequence) {
        if (this.R != charSequence) {
            this.R = BidiFormatter.getInstance().unicodeWrap(charSequence);
            invalidateSelf();
        }
    }

    public float d1() {
        return this.Z;
    }

    public void d2(float f10) {
        if (this.f9108e0 != f10) {
            this.f9108e0 = f10;
            invalidateSelf();
            if (O2()) {
                u1();
            }
        }
    }

    @Override // x4.g, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i10 = this.f9126w0;
        int iA = i10 < 255 ? h4.a.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i10) : 0;
        z0(canvas, bounds);
        w0(canvas, bounds);
        if (this.I0) {
            super.draw(canvas);
        }
        y0(canvas, bounds);
        B0(canvas, bounds);
        x0(canvas, bounds);
        v0(canvas, bounds);
        if (this.G0) {
            D0(canvas, bounds);
        }
        A0(canvas, bounds);
        C0(canvas, bounds);
        if (this.f9126w0 < 255) {
            canvas.restoreToCount(iA);
        }
    }

    @Nullable
    public ColorStateList e1() {
        return this.F;
    }

    public void e2(@DimenRes int i10) {
        d2(this.f9110g0.getResources().getDimension(i10));
    }

    @Nullable
    public h f1() {
        return this.W;
    }

    public void f2(@DrawableRes int i10) {
        b2(AppCompatResources.getDrawable(this.f9110g0, i10));
    }

    @Nullable
    public CharSequence g1() {
        return this.G;
    }

    public void g2(float f10) {
        if (this.Q != f10) {
            this.Q = f10;
            invalidateSelf();
            if (O2()) {
                u1();
            }
        }
    }

    @Override // x4.g, android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f9126w0;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public ColorFilter getColorFilter() {
        return this.f9127x0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.B;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.Y + l0() + this.f9105b0 + this.f9117n0.g(g1().toString()) + this.f9106c0 + p0() + this.f9109f0), this.H0);
    }

    @Override // x4.g, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // x4.g, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.I0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.C);
        } else {
            outline.setRoundRect(bounds, this.C);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    @Nullable
    public d h1() {
        return this.f9117n0.e();
    }

    public void h2(@DimenRes int i10) {
        g2(this.f9110g0.getResources().getDimension(i10));
    }

    public float i1() {
        return this.f9106c0;
    }

    public void i2(float f10) {
        if (this.f9107d0 != f10) {
            this.f9107d0 = f10;
            invalidateSelf();
            if (O2()) {
                u1();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // x4.g, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return q1(this.f9129z) || q1(this.A) || q1(this.D) || (this.C0 && q1(this.D0)) || s1(this.f9117n0.e()) || t0() || r1(this.I) || r1(this.U) || q1(this.f9130z0);
    }

    public float j1() {
        return this.f9105b0;
    }

    public void j2(@DimenRes int i10) {
        i2(this.f9110g0.getResources().getDimension(i10));
    }

    public boolean k2(@NonNull int[] iArr) {
        if (Arrays.equals(this.B0, iArr)) {
            return false;
        }
        this.B0 = iArr;
        if (O2()) {
            return v1(getState(), iArr);
        }
        return false;
    }

    float l0() {
        if (N2() || M2()) {
            return this.Z + Z0() + this.f9104a0;
        }
        return 0.0f;
    }

    public boolean l1() {
        return this.C0;
    }

    public void l2(@Nullable ColorStateList colorStateList) {
        if (this.P != colorStateList) {
            this.P = colorStateList;
            if (O2()) {
                DrawableCompat.setTintList(this.N, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void m2(@ColorRes int i10) {
        l2(AppCompatResources.getColorStateList(this.f9110g0, i10));
    }

    public boolean n1() {
        return this.S;
    }

    public void n2(boolean z10) {
        if (this.M != z10) {
            boolean zO2 = O2();
            this.M = z10;
            boolean zO22 = O2();
            if (zO2 != zO22) {
                if (zO22) {
                    j0(this.N);
                } else {
                    P2(this.N);
                }
                invalidateSelf();
                u1();
            }
        }
    }

    public boolean o1() {
        return r1(this.N);
    }

    public void o2(@Nullable InterfaceC0208a interfaceC0208a) {
        this.E0 = new WeakReference<>(interfaceC0208a);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i10) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i10);
        if (N2()) {
            zOnLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.I, i10);
        }
        if (M2()) {
            zOnLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.U, i10);
        }
        if (O2()) {
            zOnLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.N, i10);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i10) {
        boolean zOnLevelChange = super.onLevelChange(i10);
        if (N2()) {
            zOnLevelChange |= this.I.setLevel(i10);
        }
        if (M2()) {
            zOnLevelChange |= this.U.setLevel(i10);
        }
        if (O2()) {
            zOnLevelChange |= this.N.setLevel(i10);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // x4.g, android.graphics.drawable.Drawable, com.google.android.material.internal.n.b
    public boolean onStateChange(@NonNull int[] iArr) {
        if (this.I0) {
            super.onStateChange(iArr);
        }
        return v1(iArr, V0());
    }

    float p0() {
        if (O2()) {
            return this.f9107d0 + this.Q + this.f9108e0;
        }
        return 0.0f;
    }

    public boolean p1() {
        return this.M;
    }

    public void p2(@Nullable TextUtils.TruncateAt truncateAt) {
        this.F0 = truncateAt;
    }

    public void q2(@Nullable h hVar) {
        this.X = hVar;
    }

    public void r2(@AnimatorRes int i10) {
        q2(h.c(this.f9110g0, i10));
    }

    @NonNull
    Paint.Align s0(@NonNull Rect rect, @NonNull PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.G != null) {
            float fL0 = this.Y + l0() + this.f9105b0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                pointF.x = rect.left + fL0;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = rect.right - fL0;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - r0();
        }
        return align;
    }

    public void s2(float f10) {
        if (this.f9104a0 != f10) {
            float fL0 = l0();
            this.f9104a0 = f10;
            float fL02 = l0();
            invalidateSelf();
            if (fL0 != fL02) {
                u1();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j10) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j10);
        }
    }

    @Override // x4.g, android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (this.f9126w0 != i10) {
            this.f9126w0 = i10;
            invalidateSelf();
        }
    }

    @Override // x4.g, android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        if (this.f9127x0 != colorFilter) {
            this.f9127x0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // x4.g, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        if (this.f9130z0 != colorStateList) {
            this.f9130z0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // x4.g, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        if (this.A0 != mode) {
            this.A0 = mode;
            this.f9128y0 = com.google.android.material.drawable.b.j(this, this.f9130z0, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        if (N2()) {
            visible |= this.I.setVisible(z10, z11);
        }
        if (M2()) {
            visible |= this.U.setVisible(z10, z11);
        }
        if (O2()) {
            visible |= this.N.setVisible(z10, z11);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public void t2(@DimenRes int i10) {
        s2(this.f9110g0.getResources().getDimension(i10));
    }

    protected void u1() {
        InterfaceC0208a interfaceC0208a = this.E0.get();
        if (interfaceC0208a != null) {
            interfaceC0208a.a();
        }
    }

    public void u2(float f10) {
        if (this.Z != f10) {
            float fL0 = l0();
            this.Z = f10;
            float fL02 = l0();
            invalidateSelf();
            if (fL0 != fL02) {
                u1();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public void v2(@DimenRes int i10) {
        u2(this.f9110g0.getResources().getDimension(i10));
    }

    public void w1(boolean z10) {
        if (this.S != z10) {
            this.S = z10;
            float fL0 = l0();
            if (!z10 && this.f9124u0) {
                this.f9124u0 = false;
            }
            float fL02 = l0();
            invalidateSelf();
            if (fL0 != fL02) {
                u1();
            }
        }
    }

    public void w2(@Px int i10) {
        this.H0 = i10;
    }

    public void x1(@BoolRes int i10) {
        w1(this.f9110g0.getResources().getBoolean(i10));
    }

    public void x2(@Nullable ColorStateList colorStateList) {
        if (this.F != colorStateList) {
            this.F = colorStateList;
            Q2();
            onStateChange(getState());
        }
    }

    public void y1(@Nullable Drawable drawable) {
        if (this.U != drawable) {
            float fL0 = l0();
            this.U = drawable;
            float fL02 = l0();
            P2(this.U);
            j0(this.U);
            invalidateSelf();
            if (fL0 != fL02) {
                u1();
            }
        }
    }

    public void y2(@ColorRes int i10) {
        x2(AppCompatResources.getColorStateList(this.f9110g0, i10));
    }

    public void z1(@DrawableRes int i10) {
        y1(AppCompatResources.getDrawable(this.f9110g0, i10));
    }

    void z2(boolean z10) {
        this.G0 = z10;
    }
}
