package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.l;
import u4.a;

/* JADX INFO: compiled from: CollapsingTextHelper.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class a {

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private static final boolean f9395t0 = false;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    @NonNull
    private static final Paint f9396u0 = null;
    private Typeface A;
    private Typeface B;
    private Typeface C;
    private u4.a D;
    private u4.a E;

    @Nullable
    private CharSequence G;

    @Nullable
    private CharSequence H;
    private boolean I;
    private boolean K;

    @Nullable
    private Bitmap L;
    private Paint M;
    private float N;
    private float O;
    private float P;
    private float Q;
    private float R;
    private int S;
    private int[] T;
    private boolean U;

    @NonNull
    private final TextPaint V;

    @NonNull
    private final TextPaint W;
    private TimeInterpolator X;
    private TimeInterpolator Y;
    private float Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f9397a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private float f9398a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f9399b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private float f9400b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f9401c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private ColorStateList f9402c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f9403d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private float f9404d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f9405e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private float f9406e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f9407f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private float f9408f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    private final Rect f9409g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private ColorStateList f9410g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    private final Rect f9411h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private float f9412h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    private final RectF f9413i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private float f9414i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private float f9416j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private StaticLayout f9418k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private float f9420l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private float f9422m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ColorStateList f9423n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private float f9424n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ColorStateList f9425o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private CharSequence f9426o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f9427p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f9429q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f9431r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f9433s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f9435t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f9436u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f9437v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Typeface f9438w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Typeface f9439x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Typeface f9440y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Typeface f9441z;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f9415j = 16;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f9417k = 16;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f9419l = 15.0f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f9421m = 15.0f;
    private TextUtils.TruncateAt F = TextUtils.TruncateAt.END;
    private boolean J = true;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private int f9428p0 = 1;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private float f9430q0 = 0.0f;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private float f9432r0 = 1.0f;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private int f9434s0 = l.f9466n;

    /* JADX INFO: renamed from: com.google.android.material.internal.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CollapsingTextHelper.java */
    class C0214a implements a.InterfaceC0706a {
        C0214a() {
        }

        @Override // u4.a.InterfaceC0706a
        public void a(Typeface typeface) {
            a.this.T(typeface);
        }
    }

    public a(View view) {
        this.f9397a = view;
        TextPaint textPaint = new TextPaint(129);
        this.V = textPaint;
        this.W = new TextPaint(textPaint);
        this.f9411h = new Rect();
        this.f9409g = new Rect();
        this.f9413i = new RectF();
        this.f9405e = e();
        H(view.getContext().getResources().getConfiguration());
    }

    private void A(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.f9419l);
        textPaint.setTypeface(this.f9441z);
        textPaint.setLetterSpacing(this.f9414i0);
    }

    private void B(float f10) {
        if (this.f9401c) {
            this.f9413i.set(f10 < this.f9405e ? this.f9409g : this.f9411h);
            return;
        }
        this.f9413i.left = G(this.f9409g.left, this.f9411h.left, f10, this.X);
        this.f9413i.top = G(this.f9429q, this.f9431r, f10, this.X);
        this.f9413i.right = G(this.f9409g.right, this.f9411h.right, f10, this.X);
        this.f9413i.bottom = G(this.f9409g.bottom, this.f9411h.bottom, f10, this.X);
    }

    private static boolean C(float f10, float f11) {
        return Math.abs(f10 - f11) < 1.0E-5f;
    }

    private boolean D() {
        return ViewCompat.getLayoutDirection(this.f9397a) == 1;
    }

    private boolean F(@NonNull CharSequence charSequence, boolean z10) {
        return (z10 ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR).isRtl(charSequence, 0, charSequence.length());
    }

    private static float G(float f10, float f11, float f12, @Nullable TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f12 = timeInterpolator.getInterpolation(f12);
        }
        return f4.a.a(f10, f11, f12);
    }

    private float I(TextPaint textPaint, CharSequence charSequence) {
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    private static boolean L(@NonNull Rect rect, int i10, int i11, int i12, int i13) {
        return rect.left == i10 && rect.top == i11 && rect.right == i12 && rect.bottom == i13;
    }

    private void Q(float f10) {
        this.f9422m0 = f10;
        ViewCompat.postInvalidateOnAnimation(this.f9397a);
    }

    private boolean U(Typeface typeface) {
        u4.a aVar = this.E;
        if (aVar != null) {
            aVar.c();
        }
        if (this.f9440y == typeface) {
            return false;
        }
        this.f9440y = typeface;
        Typeface typefaceB = u4.h.b(this.f9397a.getContext().getResources().getConfiguration(), typeface);
        this.f9439x = typefaceB;
        if (typefaceB == null) {
            typefaceB = this.f9440y;
        }
        this.f9438w = typefaceB;
        return true;
    }

    private void Y(float f10) {
        this.f9424n0 = f10;
        ViewCompat.postInvalidateOnAnimation(this.f9397a);
    }

    @ColorInt
    private static int a(@ColorInt int i10, @ColorInt int i11, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        float f11 = 1.0f - f10;
        return Color.argb(Math.round((Color.alpha(i10) * f11) + (Color.alpha(i11) * f10)), Math.round((Color.red(i10) * f11) + (Color.red(i11) * f10)), Math.round((Color.green(i10) * f11) + (Color.green(i11) * f10)), Math.round((Color.blue(i10) * f11) + (Color.blue(i11) * f10)));
    }

    private void b(boolean z10) {
        StaticLayout staticLayout;
        i(1.0f, z10);
        CharSequence charSequence = this.H;
        if (charSequence != null && (staticLayout = this.f9418k0) != null) {
            this.f9426o0 = TextUtils.ellipsize(charSequence, this.V, staticLayout.getWidth(), this.F);
        }
        CharSequence charSequence2 = this.f9426o0;
        float fI = 0.0f;
        if (charSequence2 != null) {
            this.f9420l0 = I(this.V, charSequence2);
        } else {
            this.f9420l0 = 0.0f;
        }
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.f9417k, this.I ? 1 : 0);
        int i10 = absoluteGravity & 112;
        if (i10 == 48) {
            this.f9431r = this.f9411h.top;
        } else if (i10 != 80) {
            this.f9431r = this.f9411h.centerY() - ((this.V.descent() - this.V.ascent()) / 2.0f);
        } else {
            this.f9431r = this.f9411h.bottom + this.V.ascent();
        }
        int i11 = absoluteGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i11 == 1) {
            this.f9435t = this.f9411h.centerX() - (this.f9420l0 / 2.0f);
        } else if (i11 != 5) {
            this.f9435t = this.f9411h.left;
        } else {
            this.f9435t = this.f9411h.right - this.f9420l0;
        }
        i(0.0f, z10);
        float height = this.f9418k0 != null ? r10.getHeight() : 0.0f;
        StaticLayout staticLayout2 = this.f9418k0;
        if (staticLayout2 == null || this.f9428p0 <= 1) {
            CharSequence charSequence3 = this.H;
            if (charSequence3 != null) {
                fI = I(this.V, charSequence3);
            }
        } else {
            fI = staticLayout2.getWidth();
        }
        StaticLayout staticLayout3 = this.f9418k0;
        this.f9427p = staticLayout3 != null ? staticLayout3.getLineCount() : 0;
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(this.f9415j, this.I ? 1 : 0);
        int i12 = absoluteGravity2 & 112;
        if (i12 == 48) {
            this.f9429q = this.f9409g.top;
        } else if (i12 != 80) {
            this.f9429q = this.f9409g.centerY() - (height / 2.0f);
        } else {
            this.f9429q = (this.f9409g.bottom - height) + this.V.descent();
        }
        int i13 = absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i13 == 1) {
            this.f9433s = this.f9409g.centerX() - (fI / 2.0f);
        } else if (i13 != 5) {
            this.f9433s = this.f9409g.left;
        } else {
            this.f9433s = this.f9409g.right - fI;
        }
        j();
        d0(this.f9399b);
    }

    private boolean b0(Typeface typeface) {
        u4.a aVar = this.D;
        if (aVar != null) {
            aVar.c();
        }
        if (this.B == typeface) {
            return false;
        }
        this.B = typeface;
        Typeface typefaceB = u4.h.b(this.f9397a.getContext().getResources().getConfiguration(), typeface);
        this.A = typefaceB;
        if (typefaceB == null) {
            typefaceB = this.B;
        }
        this.f9441z = typefaceB;
        return true;
    }

    private void c() {
        g(this.f9399b);
    }

    private float d(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        float f11 = this.f9405e;
        return f10 <= f11 ? f4.a.b(1.0f, 0.0f, this.f9403d, f11, f10) : f4.a.b(0.0f, 1.0f, f11, 1.0f, f10);
    }

    private void d0(float f10) {
        h(f10);
        boolean z10 = f9395t0 && this.N != 1.0f;
        this.K = z10;
        if (z10) {
            n();
        }
        ViewCompat.postInvalidateOnAnimation(this.f9397a);
    }

    private float e() {
        float f10 = this.f9403d;
        return f10 + ((1.0f - f10) * 0.5f);
    }

    private boolean f(@NonNull CharSequence charSequence) {
        boolean zD = D();
        return this.J ? F(charSequence, zD) : zD;
    }

    private void g(float f10) {
        float f11;
        B(f10);
        if (!this.f9401c) {
            this.f9436u = G(this.f9433s, this.f9435t, f10, this.X);
            this.f9437v = G(this.f9429q, this.f9431r, f10, this.X);
            d0(f10);
            f11 = f10;
        } else if (f10 < this.f9405e) {
            this.f9436u = this.f9433s;
            this.f9437v = this.f9429q;
            d0(0.0f);
            f11 = 0.0f;
        } else {
            this.f9436u = this.f9435t;
            this.f9437v = this.f9431r - Math.max(0, this.f9407f);
            d0(1.0f);
            f11 = 1.0f;
        }
        TimeInterpolator timeInterpolator = f4.a.f25669b;
        Q(1.0f - G(0.0f, 1.0f, 1.0f - f10, timeInterpolator));
        Y(G(1.0f, 0.0f, f10, timeInterpolator));
        if (this.f9425o != this.f9423n) {
            this.V.setColor(a(v(), t(), f11));
        } else {
            this.V.setColor(t());
        }
        int i10 = Build.VERSION.SDK_INT;
        float f12 = this.f9412h0;
        float f13 = this.f9414i0;
        if (f12 != f13) {
            this.V.setLetterSpacing(G(f13, f12, f10, timeInterpolator));
        } else {
            this.V.setLetterSpacing(f12);
        }
        this.P = G(this.f9404d0, this.Z, f10, null);
        this.Q = G(this.f9406e0, this.f9398a0, f10, null);
        this.R = G(this.f9408f0, this.f9400b0, f10, null);
        int iA = a(u(this.f9410g0), u(this.f9402c0), f10);
        this.S = iA;
        this.V.setShadowLayer(this.P, this.Q, this.R, iA);
        if (this.f9401c) {
            this.V.setAlpha((int) (d(f10) * this.V.getAlpha()));
            if (i10 >= 31) {
                TextPaint textPaint = this.V;
                textPaint.setShadowLayer(this.P, this.Q, this.R, n4.a.a(this.S, textPaint.getAlpha()));
            }
        }
        ViewCompat.postInvalidateOnAnimation(this.f9397a);
    }

    private void h(float f10) {
        i(f10, false);
    }

    private void i(float f10, boolean z10) {
        float f11;
        float f12;
        Typeface typeface;
        if (this.G == null) {
            return;
        }
        float fWidth = this.f9411h.width();
        float fWidth2 = this.f9409g.width();
        if (C(f10, 1.0f)) {
            f11 = this.f9421m;
            f12 = this.f9412h0;
            this.N = 1.0f;
            typeface = this.f9438w;
        } else {
            float f13 = this.f9419l;
            float f14 = this.f9414i0;
            Typeface typeface2 = this.f9441z;
            if (C(f10, 0.0f)) {
                this.N = 1.0f;
            } else {
                this.N = G(this.f9419l, this.f9421m, f10, this.Y) / this.f9419l;
            }
            float f15 = this.f9421m / this.f9419l;
            fWidth = (z10 || this.f9401c || fWidth2 * f15 <= fWidth) ? fWidth2 : Math.min(fWidth / f15, fWidth2);
            f11 = f13;
            f12 = f14;
            typeface = typeface2;
        }
        if (fWidth > 0.0f) {
            boolean z11 = this.O != f11;
            boolean z12 = this.f9416j0 != f12;
            boolean z13 = this.C != typeface;
            StaticLayout staticLayout = this.f9418k0;
            boolean z14 = z11 || z12 || (staticLayout != null && (fWidth > ((float) staticLayout.getWidth()) ? 1 : (fWidth == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z13 || this.U;
            this.O = f11;
            this.f9416j0 = f12;
            this.C = typeface;
            this.U = false;
            this.V.setLinearText(this.N != 1.0f);
            z = z14;
        }
        if (this.H == null || z) {
            this.V.setTextSize(this.O);
            this.V.setTypeface(this.C);
            this.V.setLetterSpacing(this.f9416j0);
            this.I = f(this.G);
            StaticLayout staticLayoutK = k(j0() ? this.f9428p0 : 1, fWidth, this.I);
            this.f9418k0 = staticLayoutK;
            this.H = staticLayoutK.getText();
        }
    }

    private void j() {
        Bitmap bitmap = this.L;
        if (bitmap != null) {
            bitmap.recycle();
            this.L = null;
        }
    }

    private boolean j0() {
        return this.f9428p0 > 1 && (!this.I || this.f9401c) && !this.K;
    }

    private StaticLayout k(int i10, float f10, boolean z10) {
        StaticLayout staticLayoutA = null;
        try {
            staticLayoutA = l.b(this.G, this.V, (int) f10).d(this.F).g(z10).c(i10 == 1 ? Layout.Alignment.ALIGN_NORMAL : y()).f(false).i(i10).h(this.f9430q0, this.f9432r0).e(this.f9434s0).j(null).a();
        } catch (l.a e10) {
            Log.e("CollapsingTextHelper", e10.getCause().getMessage(), e10);
        }
        return (StaticLayout) Preconditions.checkNotNull(staticLayoutA);
    }

    private void m(@NonNull Canvas canvas, float f10, float f11) {
        int alpha = this.V.getAlpha();
        canvas.translate(f10, f11);
        if (!this.f9401c) {
            this.V.setAlpha((int) (this.f9424n0 * alpha));
            if (Build.VERSION.SDK_INT >= 31) {
                TextPaint textPaint = this.V;
                textPaint.setShadowLayer(this.P, this.Q, this.R, n4.a.a(this.S, textPaint.getAlpha()));
            }
            this.f9418k0.draw(canvas);
        }
        if (!this.f9401c) {
            this.V.setAlpha((int) (this.f9422m0 * alpha));
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 31) {
            TextPaint textPaint2 = this.V;
            textPaint2.setShadowLayer(this.P, this.Q, this.R, n4.a.a(this.S, textPaint2.getAlpha()));
        }
        int lineBaseline = this.f9418k0.getLineBaseline(0);
        CharSequence charSequence = this.f9426o0;
        float f12 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f12, this.V);
        if (i10 >= 31) {
            this.V.setShadowLayer(this.P, this.Q, this.R, this.S);
        }
        if (this.f9401c) {
            return;
        }
        String strTrim = this.f9426o0.toString().trim();
        if (strTrim.endsWith("…")) {
            strTrim = strTrim.substring(0, strTrim.length() - 1);
        }
        String str = strTrim;
        this.V.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.f9418k0.getLineEnd(0), str.length()), 0.0f, f12, (Paint) this.V);
    }

    private void n() {
        if (this.L != null || this.f9409g.isEmpty() || TextUtils.isEmpty(this.H)) {
            return;
        }
        g(0.0f);
        int width = this.f9418k0.getWidth();
        int height = this.f9418k0.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.L = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.f9418k0.draw(new Canvas(this.L));
        if (this.M == null) {
            this.M = new Paint(3);
        }
    }

    private float r(int i10, int i11) {
        return (i11 == 17 || (i11 & 7) == 1) ? (i10 / 2.0f) - (this.f9420l0 / 2.0f) : ((i11 & GravityCompat.END) == 8388613 || (i11 & 5) == 5) ? this.I ? this.f9411h.left : this.f9411h.right - this.f9420l0 : this.I ? this.f9411h.right - this.f9420l0 : this.f9411h.left;
    }

    private float s(@NonNull RectF rectF, int i10, int i11) {
        return (i11 == 17 || (i11 & 7) == 1) ? (i10 / 2.0f) + (this.f9420l0 / 2.0f) : ((i11 & GravityCompat.END) == 8388613 || (i11 & 5) == 5) ? this.I ? rectF.left + this.f9420l0 : this.f9411h.right : this.I ? this.f9411h.right : rectF.left + this.f9420l0;
    }

    @ColorInt
    private int u(@Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.T;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    @ColorInt
    private int v() {
        return u(this.f9423n);
    }

    private Layout.Alignment y() {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.f9415j, this.I ? 1 : 0) & 7;
        return absoluteGravity != 1 ? absoluteGravity != 5 ? this.I ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : this.I ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
    }

    private void z(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.f9421m);
        textPaint.setTypeface(this.f9438w);
        textPaint.setLetterSpacing(this.f9412h0);
    }

    public final boolean E() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f9425o;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f9423n) != null && colorStateList.isStateful());
    }

    public void H(@NonNull Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f9440y;
            if (typeface != null) {
                this.f9439x = u4.h.b(configuration, typeface);
            }
            Typeface typeface2 = this.B;
            if (typeface2 != null) {
                this.A = u4.h.b(configuration, typeface2);
            }
            Typeface typeface3 = this.f9439x;
            if (typeface3 == null) {
                typeface3 = this.f9440y;
            }
            this.f9438w = typeface3;
            Typeface typeface4 = this.A;
            if (typeface4 == null) {
                typeface4 = this.B;
            }
            this.f9441z = typeface4;
            K(true);
        }
    }

    public void J() {
        K(false);
    }

    public void K(boolean z10) {
        if ((this.f9397a.getHeight() <= 0 || this.f9397a.getWidth() <= 0) && !z10) {
            return;
        }
        b(z10);
        c();
    }

    public void M(@Nullable ColorStateList colorStateList) {
        if (this.f9425o == colorStateList && this.f9423n == colorStateList) {
            return;
        }
        this.f9425o = colorStateList;
        this.f9423n = colorStateList;
        J();
    }

    public void N(int i10, int i11, int i12, int i13) {
        if (L(this.f9411h, i10, i11, i12, i13)) {
            return;
        }
        this.f9411h.set(i10, i11, i12, i13);
        this.U = true;
    }

    public void O(@NonNull Rect rect) {
        N(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void P(int i10) {
        u4.d dVar = new u4.d(this.f9397a.getContext(), i10);
        if (dVar.i() != null) {
            this.f9425o = dVar.i();
        }
        if (dVar.j() != 0.0f) {
            this.f9421m = dVar.j();
        }
        ColorStateList colorStateList = dVar.f34596c;
        if (colorStateList != null) {
            this.f9402c0 = colorStateList;
        }
        this.f9398a0 = dVar.f34601h;
        this.f9400b0 = dVar.f34602i;
        this.Z = dVar.f34603j;
        this.f9412h0 = dVar.f34605l;
        u4.a aVar = this.E;
        if (aVar != null) {
            aVar.c();
        }
        this.E = new u4.a(new C0214a(), dVar.e());
        dVar.h(this.f9397a.getContext(), this.E);
        J();
    }

    public void R(ColorStateList colorStateList) {
        if (this.f9425o != colorStateList) {
            this.f9425o = colorStateList;
            J();
        }
    }

    public void S(int i10) {
        if (this.f9417k != i10) {
            this.f9417k = i10;
            J();
        }
    }

    public void T(Typeface typeface) {
        if (U(typeface)) {
            J();
        }
    }

    public void V(int i10, int i11, int i12, int i13) {
        if (L(this.f9409g, i10, i11, i12, i13)) {
            return;
        }
        this.f9409g.set(i10, i11, i12, i13);
        this.U = true;
    }

    public void W(@NonNull Rect rect) {
        V(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void X(float f10) {
        if (this.f9414i0 != f10) {
            this.f9414i0 = f10;
            J();
        }
    }

    public void Z(int i10) {
        if (this.f9415j != i10) {
            this.f9415j = i10;
            J();
        }
    }

    public void a0(float f10) {
        if (this.f9419l != f10) {
            this.f9419l = f10;
            J();
        }
    }

    public void c0(float f10) {
        float fClamp = MathUtils.clamp(f10, 0.0f, 1.0f);
        if (fClamp != this.f9399b) {
            this.f9399b = fClamp;
            c();
        }
    }

    public void e0(TimeInterpolator timeInterpolator) {
        this.X = timeInterpolator;
        J();
    }

    public final boolean f0(int[] iArr) {
        this.T = iArr;
        if (!E()) {
            return false;
        }
        J();
        return true;
    }

    public void g0(@Nullable CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.G, charSequence)) {
            this.G = charSequence;
            this.H = null;
            j();
            J();
        }
    }

    public void h0(TimeInterpolator timeInterpolator) {
        this.Y = timeInterpolator;
        J();
    }

    public void i0(Typeface typeface) {
        boolean zU = U(typeface);
        boolean zB0 = b0(typeface);
        if (zU || zB0) {
            J();
        }
    }

    public void l(@NonNull Canvas canvas) {
        int iSave = canvas.save();
        if (this.H == null || this.f9413i.width() <= 0.0f || this.f9413i.height() <= 0.0f) {
            return;
        }
        this.V.setTextSize(this.O);
        float f10 = this.f9436u;
        float f11 = this.f9437v;
        boolean z10 = this.K && this.L != null;
        float f12 = this.N;
        if (f12 != 1.0f && !this.f9401c) {
            canvas.scale(f12, f12, f10, f11);
        }
        if (z10) {
            canvas.drawBitmap(this.L, f10, f11, this.M);
            canvas.restoreToCount(iSave);
            return;
        }
        if (!j0() || (this.f9401c && this.f9399b <= this.f9405e)) {
            canvas.translate(f10, f11);
            this.f9418k0.draw(canvas);
        } else {
            m(canvas, this.f9436u - this.f9418k0.getLineStart(0), f11);
        }
        canvas.restoreToCount(iSave);
    }

    public void o(@NonNull RectF rectF, int i10, int i11) {
        this.I = f(this.G);
        rectF.left = Math.max(r(i10, i11), this.f9411h.left);
        rectF.top = this.f9411h.top;
        rectF.right = Math.min(s(rectF, i10, i11), this.f9411h.right);
        rectF.bottom = this.f9411h.top + q();
    }

    public ColorStateList p() {
        return this.f9425o;
    }

    public float q() {
        z(this.W);
        return -this.W.ascent();
    }

    @ColorInt
    public int t() {
        return u(this.f9425o);
    }

    public float w() {
        A(this.W);
        return -this.W.ascent();
    }

    public float x() {
        return this.f9399b;
    }
}
