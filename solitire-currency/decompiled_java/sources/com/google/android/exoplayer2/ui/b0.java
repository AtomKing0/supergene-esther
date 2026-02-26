package com.google.android.exoplayer2.ui;

import a4.o0;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: SubtitlePainter.java */
/* JADX INFO: loaded from: classes2.dex */
final class b0 {
    private int A;
    private int B;
    private int C;
    private int D;
    private StaticLayout E;
    private StaticLayout F;
    private int G;
    private int H;
    private int I;
    private Rect J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f8515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f8516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f8517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f8518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f8519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextPaint f8520f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Paint f8521g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Paint f8522h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private CharSequence f8523i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private Layout.Alignment f8524j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private Bitmap f8525k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f8526l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f8527m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f8528n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f8529o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f8530p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f8531q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f8532r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f8533s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f8534t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f8535u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f8536v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f8537w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f8538x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f8539y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f8540z;

    public b0(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.lineSpacingExtra, R.attr.lineSpacingMultiplier}, 0, 0);
        this.f8519e = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f8518d = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
        typedArrayObtainStyledAttributes.recycle();
        float fRound = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.f8515a = fRound;
        this.f8516b = fRound;
        this.f8517c = fRound;
        TextPaint textPaint = new TextPaint();
        this.f8520f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.f8521g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f8522h = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    private static boolean a(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }

    private void c(Canvas canvas) {
        canvas.drawBitmap(this.f8525k, (Rect) null, this.J, this.f8522h);
    }

    private void d(Canvas canvas, boolean z10) {
        if (z10) {
            e(canvas);
            return;
        }
        a4.a.e(this.J);
        a4.a.e(this.f8525k);
        c(canvas);
    }

    private void e(Canvas canvas) {
        StaticLayout staticLayout = this.E;
        StaticLayout staticLayout2 = this.F;
        if (staticLayout == null || staticLayout2 == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(this.G, this.H);
        if (Color.alpha(this.f8535u) > 0) {
            this.f8521g.setColor(this.f8535u);
            canvas.drawRect(-this.I, 0.0f, staticLayout.getWidth() + this.I, staticLayout.getHeight(), this.f8521g);
        }
        int i10 = this.f8537w;
        if (i10 == 1) {
            this.f8520f.setStrokeJoin(Paint.Join.ROUND);
            this.f8520f.setStrokeWidth(this.f8515a);
            this.f8520f.setColor(this.f8536v);
            this.f8520f.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout2.draw(canvas);
        } else if (i10 == 2) {
            TextPaint textPaint = this.f8520f;
            float f10 = this.f8516b;
            float f11 = this.f8517c;
            textPaint.setShadowLayer(f10, f11, f11, this.f8536v);
        } else if (i10 == 3 || i10 == 4) {
            boolean z10 = i10 == 3;
            int i11 = z10 ? -1 : this.f8536v;
            int i12 = z10 ? this.f8536v : -1;
            float f12 = this.f8516b / 2.0f;
            this.f8520f.setColor(this.f8533s);
            this.f8520f.setStyle(Paint.Style.FILL);
            float f13 = -f12;
            this.f8520f.setShadowLayer(this.f8516b, f13, f13, i11);
            staticLayout2.draw(canvas);
            this.f8520f.setShadowLayer(this.f8516b, f12, f12, i12);
        }
        this.f8520f.setColor(this.f8533s);
        this.f8520f.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas);
        this.f8520f.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas.restoreToCount(iSave);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void f() {
        /*
            r7 = this;
            android.graphics.Bitmap r0 = r7.f8525k
            int r1 = r7.C
            int r2 = r7.A
            int r1 = r1 - r2
            int r3 = r7.D
            int r4 = r7.B
            int r3 = r3 - r4
            float r2 = (float) r2
            float r1 = (float) r1
            float r5 = r7.f8529o
            float r5 = r5 * r1
            float r2 = r2 + r5
            float r4 = (float) r4
            float r3 = (float) r3
            float r5 = r7.f8526l
            float r5 = r5 * r3
            float r4 = r4 + r5
            float r5 = r7.f8531q
            float r1 = r1 * r5
            int r1 = java.lang.Math.round(r1)
            float r5 = r7.f8532r
            r6 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 == 0) goto L2e
            float r3 = r3 * r5
            int r0 = java.lang.Math.round(r3)
            goto L3f
        L2e:
            float r3 = (float) r1
            int r5 = r0.getHeight()
            float r5 = (float) r5
            int r0 = r0.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
            float r3 = r3 * r5
            int r0 = java.lang.Math.round(r3)
        L3f:
            int r3 = r7.f8530p
            r5 = 1
            r6 = 2
            if (r3 != r6) goto L48
            float r3 = (float) r1
        L46:
            float r2 = r2 - r3
            goto L4e
        L48:
            if (r3 != r5) goto L4e
            int r3 = r1 / 2
            float r3 = (float) r3
            goto L46
        L4e:
            int r2 = java.lang.Math.round(r2)
            int r3 = r7.f8528n
            if (r3 != r6) goto L59
            float r3 = (float) r0
        L57:
            float r4 = r4 - r3
            goto L5f
        L59:
            if (r3 != r5) goto L5f
            int r3 = r0 / 2
            float r3 = (float) r3
            goto L57
        L5f:
            int r3 = java.lang.Math.round(r4)
            android.graphics.Rect r4 = new android.graphics.Rect
            int r1 = r1 + r2
            int r0 = r0 + r3
            r4.<init>(r2, r3, r1, r0)
            r7.J = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.b0.f():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void g() {
        /*
            Method dump skipped, instruction units count: 488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.b0.g():void");
    }

    public void b(n3.b bVar, y3.b bVar2, float f10, float f11, float f12, Canvas canvas, int i10, int i11, int i12, int i13) {
        int i14;
        boolean z10 = bVar.f31626d == null;
        if (!z10) {
            i14 = ViewCompat.MEASURED_STATE_MASK;
        } else if (TextUtils.isEmpty(bVar.f31623a)) {
            return;
        } else {
            i14 = bVar.f31634l ? bVar.f31635m : bVar2.f36507c;
        }
        if (a(this.f8523i, bVar.f31623a) && o0.c(this.f8524j, bVar.f31624b) && this.f8525k == bVar.f31626d && this.f8526l == bVar.f31627e && this.f8527m == bVar.f31628f && o0.c(Integer.valueOf(this.f8528n), Integer.valueOf(bVar.f31629g)) && this.f8529o == bVar.f31630h && o0.c(Integer.valueOf(this.f8530p), Integer.valueOf(bVar.f31631i)) && this.f8531q == bVar.f31632j && this.f8532r == bVar.f31633k && this.f8533s == bVar2.f36505a && this.f8534t == bVar2.f36506b && this.f8535u == i14 && this.f8537w == bVar2.f36508d && this.f8536v == bVar2.f36509e && o0.c(this.f8520f.getTypeface(), bVar2.f36510f) && this.f8538x == f10 && this.f8539y == f11 && this.f8540z == f12 && this.A == i10 && this.B == i11 && this.C == i12 && this.D == i13) {
            d(canvas, z10);
            return;
        }
        this.f8523i = bVar.f31623a;
        this.f8524j = bVar.f31624b;
        this.f8525k = bVar.f31626d;
        this.f8526l = bVar.f31627e;
        this.f8527m = bVar.f31628f;
        this.f8528n = bVar.f31629g;
        this.f8529o = bVar.f31630h;
        this.f8530p = bVar.f31631i;
        this.f8531q = bVar.f31632j;
        this.f8532r = bVar.f31633k;
        this.f8533s = bVar2.f36505a;
        this.f8534t = bVar2.f36506b;
        this.f8535u = i14;
        this.f8537w = bVar2.f36508d;
        this.f8536v = bVar2.f36509e;
        this.f8520f.setTypeface(bVar2.f36510f);
        this.f8538x = f10;
        this.f8539y = f11;
        this.f8540z = f12;
        this.A = i10;
        this.B = i11;
        this.C = i12;
        this.D = i13;
        if (z10) {
            a4.a.e(this.f8523i);
            g();
        } else {
            a4.a.e(this.f8525k);
            f();
        }
        d(canvas, z10);
    }
}
