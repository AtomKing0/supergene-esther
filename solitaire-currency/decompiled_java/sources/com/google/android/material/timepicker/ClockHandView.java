package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.s;
import e4.j;
import e4.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import s4.h;

/* JADX INFO: loaded from: classes3.dex */
class ClockHandView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TimeInterpolator f9875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ValueAnimator f9876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f9877d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f9878e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f9879f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f9880g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f9881h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f9882i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List<b> f9883j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f9884k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final float f9885l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Paint f9886m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final RectF f9887n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Px
    private final int f9888o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f9889p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f9890q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private double f9891r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f9892s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f9893t;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    public interface b {
        void a(@FloatRange(from = 0.0d, to = 360.0d) float f10, boolean z10);
    }

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, e4.b.f24767x);
    }

    private void c(float f10, float f11) {
        this.f9893t = r4.a.a((float) (getWidth() / 2), (float) (getHeight() / 2), f10, f11) > ((float) h(2)) + s.c(getContext(), 12) ? 1 : 2;
    }

    private void d(Canvas canvas) {
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f10 = width;
        float fH = h(this.f9893t);
        float fCos = (((float) Math.cos(this.f9891r)) * fH) + f10;
        float f11 = height;
        float fSin = (fH * ((float) Math.sin(this.f9891r))) + f11;
        this.f9886m.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.f9884k, this.f9886m);
        double dSin = Math.sin(this.f9891r);
        double dCos = Math.cos(this.f9891r);
        this.f9886m.setStrokeWidth(this.f9888o);
        canvas.drawLine(f10, f11, width + ((int) (dCos * d)), height + ((int) (d * dSin)), this.f9886m);
        canvas.drawCircle(f10, f11, this.f9885l, this.f9886m);
    }

    private int f(float f10, float f11) {
        int degrees = ((int) Math.toDegrees(Math.atan2(f11 - (getHeight() / 2), f10 - (getWidth() / 2)))) + 90;
        return degrees < 0 ? degrees + 360 : degrees;
    }

    @Dimension
    private int h(int i10) {
        return i10 == 2 ? Math.round(this.f9892s * 0.66f) : this.f9892s;
    }

    private Pair<Float, Float> j(float f10) {
        float fG = g();
        if (Math.abs(fG - f10) > 180.0f) {
            if (fG > 180.0f && f10 < 180.0f) {
                f10 += 360.0f;
            }
            if (fG < 180.0f && f10 > 180.0f) {
                fG += 360.0f;
            }
        }
        return new Pair<>(Float.valueOf(fG), Float.valueOf(f10));
    }

    private boolean k(float f10, float f11, boolean z10, boolean z11, boolean z12) {
        float f12 = f(f10, f11);
        boolean z13 = false;
        boolean z14 = g() != f12;
        if (z11 && z14) {
            return true;
        }
        if (!z14 && !z10) {
            return false;
        }
        if (z12 && this.f9877d) {
            z13 = true;
        }
        o(f12, z13);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(ValueAnimator valueAnimator) {
        p(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
    }

    private void p(@FloatRange(from = 0.0d, to = 360.0d) float f10, boolean z10) {
        float f11 = f10 % 360.0f;
        this.f9889p = f11;
        this.f9891r = Math.toRadians(f11 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float fH = h(this.f9893t);
        float fCos = width + (((float) Math.cos(this.f9891r)) * fH);
        float fSin = height + (fH * ((float) Math.sin(this.f9891r)));
        RectF rectF = this.f9887n;
        int i10 = this.f9884k;
        rectF.set(fCos - i10, fSin - i10, fCos + i10, fSin + i10);
        Iterator<b> it = this.f9883j.iterator();
        while (it.hasNext()) {
            it.next().a(f11, z10);
        }
        invalidate();
    }

    public void b(b bVar) {
        this.f9883j.add(bVar);
    }

    public RectF e() {
        return this.f9887n;
    }

    @FloatRange(from = 0.0d, to = 360.0d)
    public float g() {
        return this.f9889p;
    }

    public int i() {
        return this.f9884k;
    }

    public void m(@Dimension int i10) {
        this.f9892s = i10;
        invalidate();
    }

    public void n(@FloatRange(from = 0.0d, to = 360.0d) float f10) {
        o(f10, false);
    }

    public void o(@FloatRange(from = 0.0d, to = 360.0d) float f10, boolean z10) {
        ValueAnimator valueAnimator = this.f9876c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z10) {
            p(f10, false);
            return;
        }
        Pair<Float, Float> pairJ = j(f10);
        this.f9876c.setFloatValues(((Float) pairJ.first).floatValue(), ((Float) pairJ.second).floatValue());
        this.f9876c.setDuration(this.f9874a);
        this.f9876c.setInterpolator(this.f9875b);
        this.f9876c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.timepicker.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.f9905a.l(valueAnimator2);
            }
        });
        this.f9876c.addListener(new a());
        this.f9876c.start();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        d(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (this.f9876c.isRunning()) {
            return;
        }
        n(g());
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        boolean z11;
        boolean z12;
        int actionMasked = motionEvent.getActionMasked();
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (actionMasked == 0) {
            this.f9878e = x10;
            this.f9879f = y10;
            this.f9880g = true;
            this.f9890q = false;
            z10 = true;
            z11 = false;
            z12 = false;
        } else if (actionMasked == 1 || actionMasked == 2) {
            int i10 = (int) (x10 - this.f9878e);
            int i11 = (int) (y10 - this.f9879f);
            this.f9880g = (i10 * i10) + (i11 * i11) > this.f9881h;
            z11 = this.f9890q;
            boolean z13 = actionMasked == 1;
            if (this.f9882i) {
                c(x10, y10);
            }
            z12 = z13;
            z10 = false;
        } else {
            z11 = false;
            z10 = false;
            z12 = false;
        }
        this.f9890q |= k(x10, y10, z11, z10, z12);
        return true;
    }

    void q(boolean z10) {
        if (this.f9882i && !z10) {
            this.f9893t = 1;
        }
        this.f9882i = z10;
        invalidate();
    }

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f9876c = new ValueAnimator();
        this.f9883j = new ArrayList();
        Paint paint = new Paint();
        this.f9886m = paint;
        this.f9887n = new RectF();
        this.f9893t = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.Y0, i10, j.f24916v);
        this.f9874a = h.f(context, e4.b.f24769z, 200);
        this.f9875b = h.g(context, e4.b.I, f4.a.f25669b);
        this.f9892s = typedArrayObtainStyledAttributes.getDimensionPixelSize(k.f24920a1, 0);
        this.f9884k = typedArrayObtainStyledAttributes.getDimensionPixelSize(k.f24928b1, 0);
        this.f9888o = getResources().getDimensionPixelSize(e4.d.f24805x);
        this.f9885l = r7.getDimensionPixelSize(e4.d.f24803v);
        int color = typedArrayObtainStyledAttributes.getColor(k.Z0, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        n(0.0f);
        this.f9881h = ViewConfiguration.get(context).getScaledTouchSlop();
        ViewCompat.setImportantForAccessibility(this, 2);
        typedArrayObtainStyledAttributes.recycle();
    }
}
