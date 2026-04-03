package x4;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import java.util.BitSet;
import x4.k;
import x4.l;
import x4.m;

/* JADX INFO: compiled from: MaterialShapeDrawable.java */
/* JADX INFO: loaded from: classes3.dex */
public class g extends Drawable implements TintAwareDrawable, n {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final String f36084x = "g";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final Paint f36085y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f36086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m.g[] f36087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final m.g[] f36088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final BitSet f36089d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f36090e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Matrix f36091f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Path f36092g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Path f36093h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final RectF f36094i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final RectF f36095j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Region f36096k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Region f36097l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private k f36098m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Paint f36099n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Paint f36100o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final w4.a f36101p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    private final l.b f36102q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final l f36103r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    private PorterDuffColorFilter f36104s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private PorterDuffColorFilter f36105t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f36106u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NonNull
    private final RectF f36107v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f36108w;

    /* JADX INFO: compiled from: MaterialShapeDrawable.java */
    class a implements l.b {
        a() {
        }

        @Override // x4.l.b
        public void a(@NonNull m mVar, Matrix matrix, int i10) {
            g.this.f36089d.set(i10 + 4, mVar.e());
            g.this.f36088c[i10] = mVar.f(matrix);
        }

        @Override // x4.l.b
        public void b(@NonNull m mVar, Matrix matrix, int i10) {
            g.this.f36089d.set(i10, mVar.e());
            g.this.f36087b[i10] = mVar.f(matrix);
        }
    }

    /* JADX INFO: compiled from: MaterialShapeDrawable.java */
    class b implements k.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f36110a;

        b(float f10) {
            this.f36110a = f10;
        }

        @Override // x4.k.c
        @NonNull
        public x4.c a(@NonNull x4.c cVar) {
            return cVar instanceof i ? cVar : new x4.b(this.f36110a, cVar);
        }
    }

    static {
        Paint paint = new Paint(1);
        f36085y = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public g() {
        this(new k());
    }

    private float E() {
        if (N()) {
            return this.f36100o.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean L() {
        c cVar = this.f36086a;
        int i10 = cVar.f36128q;
        return i10 != 1 && cVar.f36129r > 0 && (i10 == 2 || V());
    }

    private boolean M() {
        Paint.Style style = this.f36086a.f36133v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    private boolean N() {
        Paint.Style style = this.f36086a.f36133v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f36100o.getStrokeWidth() > 0.0f;
    }

    private void P() {
        super.invalidateSelf();
    }

    private void S(@NonNull Canvas canvas) {
        if (L()) {
            canvas.save();
            U(canvas);
            if (!this.f36108w) {
                n(canvas);
                canvas.restore();
                return;
            }
            int iWidth = (int) (this.f36107v.width() - getBounds().width());
            int iHeight = (int) (this.f36107v.height() - getBounds().height());
            if (iWidth < 0 || iHeight < 0) {
                throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((int) this.f36107v.width()) + (this.f36086a.f36129r * 2) + iWidth, ((int) this.f36107v.height()) + (this.f36086a.f36129r * 2) + iHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap);
            float f10 = (getBounds().left - this.f36086a.f36129r) - iWidth;
            float f11 = (getBounds().top - this.f36086a.f36129r) - iHeight;
            canvas2.translate(-f10, -f11);
            n(canvas2);
            canvas.drawBitmap(bitmapCreateBitmap, f10, f11, (Paint) null);
            bitmapCreateBitmap.recycle();
            canvas.restore();
        }
    }

    private static int T(int i10, int i11) {
        return (i10 * (i11 + (i11 >>> 7))) >>> 8;
    }

    private void U(@NonNull Canvas canvas) {
        canvas.translate(z(), A());
    }

    @Nullable
    private PorterDuffColorFilter f(@NonNull Paint paint, boolean z10) {
        if (!z10) {
            return null;
        }
        int color = paint.getColor();
        int iL = l(color);
        this.f36106u = iL;
        if (iL != color) {
            return new PorterDuffColorFilter(iL, PorterDuff.Mode.SRC_IN);
        }
        return null;
    }

    private void g(@NonNull RectF rectF, @NonNull Path path) {
        h(rectF, path);
        if (this.f36086a.f36121j != 1.0f) {
            this.f36091f.reset();
            Matrix matrix = this.f36091f;
            float f10 = this.f36086a.f36121j;
            matrix.setScale(f10, f10, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f36091f);
        }
        path.computeBounds(this.f36107v, true);
    }

    private boolean g0(int[] iArr) {
        boolean z10;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f36086a.f36115d == null || color2 == (colorForState2 = this.f36086a.f36115d.getColorForState(iArr, (color2 = this.f36099n.getColor())))) {
            z10 = false;
        } else {
            this.f36099n.setColor(colorForState2);
            z10 = true;
        }
        if (this.f36086a.f36116e == null || color == (colorForState = this.f36086a.f36116e.getColorForState(iArr, (color = this.f36100o.getColor())))) {
            return z10;
        }
        this.f36100o.setColor(colorForState);
        return true;
    }

    private boolean h0() {
        PorterDuffColorFilter porterDuffColorFilter = this.f36104s;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f36105t;
        c cVar = this.f36086a;
        this.f36104s = k(cVar.f36118g, cVar.f36119h, this.f36099n, true);
        c cVar2 = this.f36086a;
        this.f36105t = k(cVar2.f36117f, cVar2.f36119h, this.f36100o, false);
        c cVar3 = this.f36086a;
        if (cVar3.f36132u) {
            this.f36101p.d(cVar3.f36118g.getColorForState(getState(), 0));
        }
        return (ObjectsCompat.equals(porterDuffColorFilter, this.f36104s) && ObjectsCompat.equals(porterDuffColorFilter2, this.f36105t)) ? false : true;
    }

    private void i() {
        k kVarY = C().y(new b(-E()));
        this.f36098m = kVarY;
        this.f36103r.d(kVarY, this.f36086a.f36122k, t(), this.f36093h);
    }

    private void i0() {
        float fK = K();
        this.f36086a.f36129r = (int) Math.ceil(0.75f * fK);
        this.f36086a.f36130s = (int) Math.ceil(fK * 0.25f);
        h0();
        P();
    }

    @NonNull
    private PorterDuffColorFilter j(@NonNull ColorStateList colorStateList, @NonNull PorterDuff.Mode mode, boolean z10) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z10) {
            colorForState = l(colorForState);
        }
        this.f36106u = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    @NonNull
    private PorterDuffColorFilter k(@Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, @NonNull Paint paint, boolean z10) {
        return (colorStateList == null || mode == null) ? f(paint, z10) : j(colorStateList, mode, z10);
    }

    @NonNull
    public static g m(@NonNull Context context, float f10, @Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(n4.a.c(context, e4.b.f24756m, g.class.getSimpleName()));
        }
        g gVar = new g();
        gVar.O(context);
        gVar.Y(colorStateList);
        gVar.X(f10);
        return gVar;
    }

    private void n(@NonNull Canvas canvas) {
        if (this.f36089d.cardinality() > 0) {
            Log.w(f36084x, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f36086a.f36130s != 0) {
            canvas.drawPath(this.f36092g, this.f36101p.c());
        }
        for (int i10 = 0; i10 < 4; i10++) {
            this.f36087b[i10].b(this.f36101p, this.f36086a.f36129r, canvas);
            this.f36088c[i10].b(this.f36101p, this.f36086a.f36129r, canvas);
        }
        if (this.f36108w) {
            int iZ = z();
            int iA = A();
            canvas.translate(-iZ, -iA);
            canvas.drawPath(this.f36092g, f36085y);
            canvas.translate(iZ, iA);
        }
    }

    private void o(@NonNull Canvas canvas) {
        q(canvas, this.f36099n, this.f36092g, this.f36086a.f36112a, s());
    }

    private void q(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull k kVar, @NonNull RectF rectF) {
        if (!kVar.u(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float fA = kVar.t().a(rectF) * this.f36086a.f36122k;
            canvas.drawRoundRect(rectF, fA, fA, paint);
        }
    }

    @NonNull
    private RectF t() {
        this.f36095j.set(s());
        float fE = E();
        this.f36095j.inset(fE, fE);
        return this.f36095j;
    }

    public int A() {
        return (int) (((double) this.f36086a.f36130s) * Math.cos(Math.toRadians(r0.f36131t)));
    }

    public int B() {
        return this.f36086a.f36129r;
    }

    @NonNull
    public k C() {
        return this.f36086a.f36112a;
    }

    @Nullable
    public ColorStateList D() {
        return this.f36086a.f36116e;
    }

    public float F() {
        return this.f36086a.f36123l;
    }

    @Nullable
    public ColorStateList G() {
        return this.f36086a.f36118g;
    }

    public float H() {
        return this.f36086a.f36112a.r().a(s());
    }

    public float I() {
        return this.f36086a.f36112a.t().a(s());
    }

    public float J() {
        return this.f36086a.f36127p;
    }

    public float K() {
        return u() + J();
    }

    public void O(Context context) {
        this.f36086a.f36113b = new p4.a(context);
        i0();
    }

    public boolean Q() {
        p4.a aVar = this.f36086a.f36113b;
        return aVar != null && aVar.d();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean R() {
        return this.f36086a.f36112a.u(s());
    }

    public boolean V() {
        return (R() || this.f36092g.isConvex() || Build.VERSION.SDK_INT >= 29) ? false : true;
    }

    public void W(@NonNull x4.c cVar) {
        setShapeAppearanceModel(this.f36086a.f36112a.x(cVar));
    }

    public void X(float f10) {
        c cVar = this.f36086a;
        if (cVar.f36126o != f10) {
            cVar.f36126o = f10;
            i0();
        }
    }

    public void Y(@Nullable ColorStateList colorStateList) {
        c cVar = this.f36086a;
        if (cVar.f36115d != colorStateList) {
            cVar.f36115d = colorStateList;
            onStateChange(getState());
        }
    }

    public void Z(float f10) {
        c cVar = this.f36086a;
        if (cVar.f36122k != f10) {
            cVar.f36122k = f10;
            this.f36090e = true;
            invalidateSelf();
        }
    }

    public void a0(int i10, int i11, int i12, int i13) {
        c cVar = this.f36086a;
        if (cVar.f36120i == null) {
            cVar.f36120i = new Rect();
        }
        this.f36086a.f36120i.set(i10, i11, i12, i13);
        invalidateSelf();
    }

    public void b0(float f10) {
        c cVar = this.f36086a;
        if (cVar.f36125n != f10) {
            cVar.f36125n = f10;
            i0();
        }
    }

    public void c0(float f10, @ColorInt int i10) {
        f0(f10);
        e0(ColorStateList.valueOf(i10));
    }

    public void d0(float f10, @Nullable ColorStateList colorStateList) {
        f0(f10);
        e0(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.f36099n.setColorFilter(this.f36104s);
        int alpha = this.f36099n.getAlpha();
        this.f36099n.setAlpha(T(alpha, this.f36086a.f36124m));
        this.f36100o.setColorFilter(this.f36105t);
        this.f36100o.setStrokeWidth(this.f36086a.f36123l);
        int alpha2 = this.f36100o.getAlpha();
        this.f36100o.setAlpha(T(alpha2, this.f36086a.f36124m));
        if (this.f36090e) {
            i();
            g(s(), this.f36092g);
            this.f36090e = false;
        }
        S(canvas);
        if (M()) {
            o(canvas);
        }
        if (N()) {
            r(canvas);
        }
        this.f36099n.setAlpha(alpha);
        this.f36100o.setAlpha(alpha2);
    }

    public void e0(@Nullable ColorStateList colorStateList) {
        c cVar = this.f36086a;
        if (cVar.f36116e != colorStateList) {
            cVar.f36116e = colorStateList;
            onStateChange(getState());
        }
    }

    public void f0(float f10) {
        this.f36086a.f36123l = f10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f36086a.f36124m;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.f36086a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.f36086a.f36128q == 2) {
            return;
        }
        if (R()) {
            outline.setRoundRect(getBounds(), H() * this.f36086a.f36122k);
        } else {
            g(s(), this.f36092g);
            com.google.android.material.drawable.b.i(outline, this.f36092g);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        Rect rect2 = this.f36086a.f36120i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.f36096k.set(getBounds());
        g(s(), this.f36092g);
        this.f36097l.setPath(this.f36092g, this.f36096k);
        this.f36096k.op(this.f36097l, Region.Op.DIFFERENCE);
        return this.f36096k;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected final void h(@NonNull RectF rectF, @NonNull Path path) {
        l lVar = this.f36103r;
        c cVar = this.f36086a;
        lVar.e(cVar.f36112a, cVar.f36122k, rectF, this.f36102q, path);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f36090e = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f36086a.f36118g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f36086a.f36117f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f36086a.f36116e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f36086a.f36115d) != null && colorStateList4.isStateful())));
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int l(@ColorInt int i10) {
        float fK = K() + x();
        p4.a aVar = this.f36086a.f36113b;
        return aVar != null ? aVar.c(i10, fK) : i10;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        this.f36086a = new c(this.f36086a);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f36090e = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.n.b
    protected boolean onStateChange(int[] iArr) {
        boolean z10 = g0(iArr) || h0();
        if (z10) {
            invalidateSelf();
        }
        return z10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void p(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull RectF rectF) {
        q(canvas, paint, path, this.f36086a.f36112a, rectF);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void r(@NonNull Canvas canvas) {
        q(canvas, this.f36100o, this.f36093h, this.f36098m, t());
    }

    @NonNull
    protected RectF s() {
        this.f36094i.set(getBounds());
        return this.f36094i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i10) {
        c cVar = this.f36086a;
        if (cVar.f36124m != i10) {
            cVar.f36124m = i10;
            P();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f36086a.f36114c = colorFilter;
        P();
    }

    @Override // x4.n
    public void setShapeAppearanceModel(@NonNull k kVar) {
        this.f36086a.f36112a = kVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(@ColorInt int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        this.f36086a.f36118g = colorStateList;
        h0();
        P();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        c cVar = this.f36086a;
        if (cVar.f36119h != mode) {
            cVar.f36119h = mode;
            h0();
            P();
        }
    }

    public float u() {
        return this.f36086a.f36126o;
    }

    @Nullable
    public ColorStateList v() {
        return this.f36086a.f36115d;
    }

    public float w() {
        return this.f36086a.f36122k;
    }

    public float x() {
        return this.f36086a.f36125n;
    }

    @ColorInt
    public int y() {
        return this.f36106u;
    }

    public int z() {
        return (int) (((double) this.f36086a.f36130s) * Math.sin(Math.toRadians(r0.f36131t)));
    }

    public g(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i10, @StyleRes int i11) {
        this(k.e(context, attributeSet, i10, i11).m());
    }

    public g(@NonNull k kVar) {
        this(new c(kVar, null));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected g(@NonNull c cVar) {
        l lVar;
        this.f36087b = new m.g[4];
        this.f36088c = new m.g[4];
        this.f36089d = new BitSet(8);
        this.f36091f = new Matrix();
        this.f36092g = new Path();
        this.f36093h = new Path();
        this.f36094i = new RectF();
        this.f36095j = new RectF();
        this.f36096k = new Region();
        this.f36097l = new Region();
        Paint paint = new Paint(1);
        this.f36099n = paint;
        Paint paint2 = new Paint(1);
        this.f36100o = paint2;
        this.f36101p = new w4.a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            lVar = l.k();
        } else {
            lVar = new l();
        }
        this.f36103r = lVar;
        this.f36107v = new RectF();
        this.f36108w = true;
        this.f36086a = cVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        h0();
        g0(getState());
        this.f36102q = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: compiled from: MaterialShapeDrawable.java */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class c extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        k f36112a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        p4.a f36113b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        ColorFilter f36114c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        ColorStateList f36115d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        ColorStateList f36116e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        ColorStateList f36117f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        ColorStateList f36118g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        PorterDuff.Mode f36119h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        Rect f36120i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        float f36121j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        float f36122k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        float f36123l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f36124m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        float f36125n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        float f36126o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        float f36127p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        int f36128q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        int f36129r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        int f36130s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        int f36131t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        boolean f36132u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        Paint.Style f36133v;

        public c(@NonNull k kVar, @Nullable p4.a aVar) {
            this.f36115d = null;
            this.f36116e = null;
            this.f36117f = null;
            this.f36118g = null;
            this.f36119h = PorterDuff.Mode.SRC_IN;
            this.f36120i = null;
            this.f36121j = 1.0f;
            this.f36122k = 1.0f;
            this.f36124m = 255;
            this.f36125n = 0.0f;
            this.f36126o = 0.0f;
            this.f36127p = 0.0f;
            this.f36128q = 0;
            this.f36129r = 0;
            this.f36130s = 0;
            this.f36131t = 0;
            this.f36132u = false;
            this.f36133v = Paint.Style.FILL_AND_STROKE;
            this.f36112a = kVar;
            this.f36113b = aVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            g gVar = new g(this);
            gVar.f36090e = true;
            return gVar;
        }

        public c(@NonNull c cVar) {
            this.f36115d = null;
            this.f36116e = null;
            this.f36117f = null;
            this.f36118g = null;
            this.f36119h = PorterDuff.Mode.SRC_IN;
            this.f36120i = null;
            this.f36121j = 1.0f;
            this.f36122k = 1.0f;
            this.f36124m = 255;
            this.f36125n = 0.0f;
            this.f36126o = 0.0f;
            this.f36127p = 0.0f;
            this.f36128q = 0;
            this.f36129r = 0;
            this.f36130s = 0;
            this.f36131t = 0;
            this.f36132u = false;
            this.f36133v = Paint.Style.FILL_AND_STROKE;
            this.f36112a = cVar.f36112a;
            this.f36113b = cVar.f36113b;
            this.f36123l = cVar.f36123l;
            this.f36114c = cVar.f36114c;
            this.f36115d = cVar.f36115d;
            this.f36116e = cVar.f36116e;
            this.f36119h = cVar.f36119h;
            this.f36118g = cVar.f36118g;
            this.f36124m = cVar.f36124m;
            this.f36121j = cVar.f36121j;
            this.f36130s = cVar.f36130s;
            this.f36128q = cVar.f36128q;
            this.f36132u = cVar.f36132u;
            this.f36122k = cVar.f36122k;
            this.f36125n = cVar.f36125n;
            this.f36126o = cVar.f36126o;
            this.f36127p = cVar.f36127p;
            this.f36129r = cVar.f36129r;
            this.f36131t = cVar.f36131t;
            this.f36117f = cVar.f36117f;
            this.f36133v = cVar.f36133v;
            if (cVar.f36120i != null) {
                this.f36120i = new Rect(cVar.f36120i);
            }
        }
    }
}
