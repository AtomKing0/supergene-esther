package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.s;
import e4.b;
import u4.c;
import x4.g;
import x4.k;
import x4.n;

/* JADX INFO: compiled from: MaterialButtonHelper.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @ChecksSdkIntAtLeast(api = 21)
    private static final boolean f8982u = true;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final boolean f8983v = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaterialButton f8984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    private k f8985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8987d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f8988e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f8989f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f8990g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f8991h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private PorterDuff.Mode f8992i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private ColorStateList f8993j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private ColorStateList f8994k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private ColorStateList f8995l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private Drawable f8996m;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f9000q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private LayerDrawable f9002s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f9003t;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f8997n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f8998o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f8999p = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f9001r = true;

    a(MaterialButton materialButton, @NonNull k kVar) {
        this.f8984a = materialButton;
        this.f8985b = kVar;
    }

    private void G(@Dimension int i10, @Dimension int i11) {
        int paddingStart = ViewCompat.getPaddingStart(this.f8984a);
        int paddingTop = this.f8984a.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.f8984a);
        int paddingBottom = this.f8984a.getPaddingBottom();
        int i12 = this.f8988e;
        int i13 = this.f8989f;
        this.f8989f = i11;
        this.f8988e = i10;
        if (!this.f8998o) {
            H();
        }
        ViewCompat.setPaddingRelative(this.f8984a, paddingStart, (paddingTop + i10) - i12, paddingEnd, (paddingBottom + i11) - i13);
    }

    private void H() {
        this.f8984a.setInternalBackground(a());
        g gVarF = f();
        if (gVarF != null) {
            gVarF.X(this.f9003t);
            gVarF.setState(this.f8984a.getDrawableState());
        }
    }

    private void I(@NonNull k kVar) {
        if (f8983v && !this.f8998o) {
            int paddingStart = ViewCompat.getPaddingStart(this.f8984a);
            int paddingTop = this.f8984a.getPaddingTop();
            int paddingEnd = ViewCompat.getPaddingEnd(this.f8984a);
            int paddingBottom = this.f8984a.getPaddingBottom();
            H();
            ViewCompat.setPaddingRelative(this.f8984a, paddingStart, paddingTop, paddingEnd, paddingBottom);
            return;
        }
        if (f() != null) {
            f().setShapeAppearanceModel(kVar);
        }
        if (n() != null) {
            n().setShapeAppearanceModel(kVar);
        }
        if (e() != null) {
            e().setShapeAppearanceModel(kVar);
        }
    }

    private void J() {
        g gVarF = f();
        g gVarN = n();
        if (gVarF != null) {
            gVarF.d0(this.f8991h, this.f8994k);
            if (gVarN != null) {
                gVarN.c0(this.f8991h, this.f8997n ? n4.a.d(this.f8984a, b.f24756m) : 0);
            }
        }
    }

    @NonNull
    private InsetDrawable K(Drawable drawable) {
        return new InsetDrawable(drawable, this.f8986c, this.f8988e, this.f8987d, this.f8989f);
    }

    private Drawable a() {
        g gVar = new g(this.f8985b);
        gVar.O(this.f8984a.getContext());
        DrawableCompat.setTintList(gVar, this.f8993j);
        PorterDuff.Mode mode = this.f8992i;
        if (mode != null) {
            DrawableCompat.setTintMode(gVar, mode);
        }
        gVar.d0(this.f8991h, this.f8994k);
        g gVar2 = new g(this.f8985b);
        gVar2.setTint(0);
        gVar2.c0(this.f8991h, this.f8997n ? n4.a.d(this.f8984a, b.f24756m) : 0);
        if (f8982u) {
            g gVar3 = new g(this.f8985b);
            this.f8996m = gVar3;
            DrawableCompat.setTint(gVar3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(v4.b.a(this.f8995l), K(new LayerDrawable(new Drawable[]{gVar2, gVar})), this.f8996m);
            this.f9002s = rippleDrawable;
            return rippleDrawable;
        }
        v4.a aVar = new v4.a(this.f8985b);
        this.f8996m = aVar;
        DrawableCompat.setTintList(aVar, v4.b.a(this.f8995l));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gVar2, gVar, this.f8996m});
        this.f9002s = layerDrawable;
        return K(layerDrawable);
    }

    @Nullable
    private g g(boolean z10) {
        LayerDrawable layerDrawable = this.f9002s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return f8982u ? (g) ((LayerDrawable) ((InsetDrawable) this.f9002s.getDrawable(0)).getDrawable()).getDrawable(!z10 ? 1 : 0) : (g) this.f9002s.getDrawable(!z10 ? 1 : 0);
    }

    @Nullable
    private g n() {
        return g(true);
    }

    void A(boolean z10) {
        this.f8997n = z10;
        J();
    }

    void B(@Nullable ColorStateList colorStateList) {
        if (this.f8994k != colorStateList) {
            this.f8994k = colorStateList;
            J();
        }
    }

    void C(int i10) {
        if (this.f8991h != i10) {
            this.f8991h = i10;
            J();
        }
    }

    void D(@Nullable ColorStateList colorStateList) {
        if (this.f8993j != colorStateList) {
            this.f8993j = colorStateList;
            if (f() != null) {
                DrawableCompat.setTintList(f(), this.f8993j);
            }
        }
    }

    void E(@Nullable PorterDuff.Mode mode) {
        if (this.f8992i != mode) {
            this.f8992i = mode;
            if (f() == null || this.f8992i == null) {
                return;
            }
            DrawableCompat.setTintMode(f(), this.f8992i);
        }
    }

    void F(boolean z10) {
        this.f9001r = z10;
    }

    int b() {
        return this.f8990g;
    }

    public int c() {
        return this.f8989f;
    }

    public int d() {
        return this.f8988e;
    }

    @Nullable
    public n e() {
        LayerDrawable layerDrawable = this.f9002s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.f9002s.getNumberOfLayers() > 2 ? (n) this.f9002s.getDrawable(2) : (n) this.f9002s.getDrawable(1);
    }

    @Nullable
    g f() {
        return g(false);
    }

    @Nullable
    ColorStateList h() {
        return this.f8995l;
    }

    @NonNull
    k i() {
        return this.f8985b;
    }

    @Nullable
    ColorStateList j() {
        return this.f8994k;
    }

    int k() {
        return this.f8991h;
    }

    ColorStateList l() {
        return this.f8993j;
    }

    PorterDuff.Mode m() {
        return this.f8992i;
    }

    boolean o() {
        return this.f8998o;
    }

    boolean p() {
        return this.f9000q;
    }

    boolean q() {
        return this.f9001r;
    }

    void r(@NonNull TypedArray typedArray) {
        this.f8986c = typedArray.getDimensionPixelOffset(e4.k.f24961f2, 0);
        this.f8987d = typedArray.getDimensionPixelOffset(e4.k.f24969g2, 0);
        this.f8988e = typedArray.getDimensionPixelOffset(e4.k.f24977h2, 0);
        this.f8989f = typedArray.getDimensionPixelOffset(e4.k.f24985i2, 0);
        int i10 = e4.k.f25017m2;
        if (typedArray.hasValue(i10)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i10, -1);
            this.f8990g = dimensionPixelSize;
            z(this.f8985b.w(dimensionPixelSize));
            this.f8999p = true;
        }
        this.f8991h = typedArray.getDimensionPixelSize(e4.k.f25097w2, 0);
        this.f8992i = s.i(typedArray.getInt(e4.k.f25009l2, -1), PorterDuff.Mode.SRC_IN);
        this.f8993j = c.a(this.f8984a.getContext(), typedArray, e4.k.f25001k2);
        this.f8994k = c.a(this.f8984a.getContext(), typedArray, e4.k.f25089v2);
        this.f8995l = c.a(this.f8984a.getContext(), typedArray, e4.k.f25081u2);
        this.f9000q = typedArray.getBoolean(e4.k.f24993j2, false);
        this.f9003t = typedArray.getDimensionPixelSize(e4.k.f25025n2, 0);
        this.f9001r = typedArray.getBoolean(e4.k.f25105x2, true);
        int paddingStart = ViewCompat.getPaddingStart(this.f8984a);
        int paddingTop = this.f8984a.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.f8984a);
        int paddingBottom = this.f8984a.getPaddingBottom();
        if (typedArray.hasValue(e4.k.f24953e2)) {
            t();
        } else {
            H();
        }
        ViewCompat.setPaddingRelative(this.f8984a, paddingStart + this.f8986c, paddingTop + this.f8988e, paddingEnd + this.f8987d, paddingBottom + this.f8989f);
    }

    void s(int i10) {
        if (f() != null) {
            f().setTint(i10);
        }
    }

    void t() {
        this.f8998o = true;
        this.f8984a.setSupportBackgroundTintList(this.f8993j);
        this.f8984a.setSupportBackgroundTintMode(this.f8992i);
    }

    void u(boolean z10) {
        this.f9000q = z10;
    }

    void v(int i10) {
        if (this.f8999p && this.f8990g == i10) {
            return;
        }
        this.f8990g = i10;
        this.f8999p = true;
        z(this.f8985b.w(i10));
    }

    public void w(@Dimension int i10) {
        G(this.f8988e, i10);
    }

    public void x(@Dimension int i10) {
        G(i10, this.f8989f);
    }

    void y(@Nullable ColorStateList colorStateList) {
        if (this.f8995l != colorStateList) {
            this.f8995l = colorStateList;
            boolean z10 = f8982u;
            if (z10 && (this.f8984a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f8984a.getBackground()).setColor(v4.b.a(colorStateList));
            } else {
                if (z10 || !(this.f8984a.getBackground() instanceof v4.a)) {
                    return;
                }
                ((v4.a) this.f8984a.getBackground()).setTintList(v4.b.a(colorStateList));
            }
        }
    }

    void z(@NonNull k kVar) {
        this.f8985b = kVar;
        I(kVar);
    }
}
