package com.google.android.exoplayer2.ui;

import a4.o0;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.C;
import androidx.media3.ui.DefaultTimeBar;
import com.google.android.exoplayer2.ui.f0;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: DefaultTimeBar.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends View implements f0 {
    private int A;
    private long B;
    private int C;
    private Rect D;
    private ValueAnimator E;
    private float F;
    private boolean G;
    private boolean H;
    private long I;
    private long J;
    private long K;
    private long L;
    private int M;

    @Nullable
    private long[] N;

    @Nullable
    private boolean[] O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f8489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Rect f8490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Rect f8491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f8492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Paint f8493e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Paint f8494f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Paint f8495g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Paint f8496h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Paint f8497i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Paint f8498j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private final Drawable f8499k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f8500l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f8501m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f8502n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f8503o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int f8504p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f8505q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f8506r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f8507s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f8508t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final StringBuilder f8509u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Formatter f8510v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Runnable f8511w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final CopyOnWriteArraySet<f0.a> f8512x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Point f8513y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final float f8514z;

    public b(Context context, @Nullable AttributeSet attributeSet, int i10, @Nullable AttributeSet attributeSet2, int i11) {
        super(context, attributeSet, i10);
        this.f8489a = new Rect();
        this.f8490b = new Rect();
        this.f8491c = new Rect();
        this.f8492d = new Rect();
        Paint paint = new Paint();
        this.f8493e = paint;
        Paint paint2 = new Paint();
        this.f8494f = paint2;
        Paint paint3 = new Paint();
        this.f8495g = paint3;
        Paint paint4 = new Paint();
        this.f8496h = paint4;
        Paint paint5 = new Paint();
        this.f8497i = paint5;
        Paint paint6 = new Paint();
        this.f8498j = paint6;
        paint6.setAntiAlias(true);
        this.f8512x = new CopyOnWriteArraySet<>();
        this.f8513y = new Point();
        float f10 = context.getResources().getDisplayMetrics().density;
        this.f8514z = f10;
        this.f8508t = d(f10, -50);
        int iD = d(f10, 4);
        int iD2 = d(f10, 26);
        int iD3 = d(f10, 4);
        int iD4 = d(f10, 12);
        int iD5 = d(f10, 0);
        int iD6 = d(f10, 16);
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, y3.q.f36602e, i10, i11);
            try {
                Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(y3.q.f36613p);
                this.f8499k = drawable;
                if (drawable != null) {
                    p(drawable);
                    iD2 = Math.max(drawable.getMinimumHeight(), iD2);
                }
                this.f8500l = typedArrayObtainStyledAttributes.getDimensionPixelSize(y3.q.f36606i, iD);
                this.f8501m = typedArrayObtainStyledAttributes.getDimensionPixelSize(y3.q.f36615r, iD2);
                this.f8502n = typedArrayObtainStyledAttributes.getInt(y3.q.f36605h, 0);
                this.f8503o = typedArrayObtainStyledAttributes.getDimensionPixelSize(y3.q.f36604g, iD3);
                this.f8504p = typedArrayObtainStyledAttributes.getDimensionPixelSize(y3.q.f36614q, iD4);
                this.f8505q = typedArrayObtainStyledAttributes.getDimensionPixelSize(y3.q.f36611n, iD5);
                this.f8506r = typedArrayObtainStyledAttributes.getDimensionPixelSize(y3.q.f36612o, iD6);
                int i12 = typedArrayObtainStyledAttributes.getInt(y3.q.f36609l, -1);
                int i13 = typedArrayObtainStyledAttributes.getInt(y3.q.f36610m, -1);
                int i14 = typedArrayObtainStyledAttributes.getInt(y3.q.f36607j, DefaultTimeBar.DEFAULT_BUFFERED_COLOR);
                int i15 = typedArrayObtainStyledAttributes.getInt(y3.q.f36616s, DefaultTimeBar.DEFAULT_UNPLAYED_COLOR);
                int i16 = typedArrayObtainStyledAttributes.getInt(y3.q.f36603f, DefaultTimeBar.DEFAULT_AD_MARKER_COLOR);
                int i17 = typedArrayObtainStyledAttributes.getInt(y3.q.f36608k, DefaultTimeBar.DEFAULT_PLAYED_AD_MARKER_COLOR);
                paint.setColor(i12);
                paint6.setColor(i13);
                paint2.setColor(i14);
                paint3.setColor(i15);
                paint4.setColor(i16);
                paint5.setColor(i17);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        } else {
            this.f8500l = iD;
            this.f8501m = iD2;
            this.f8502n = 0;
            this.f8503o = iD3;
            this.f8504p = iD4;
            this.f8505q = iD5;
            this.f8506r = iD6;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(DefaultTimeBar.DEFAULT_BUFFERED_COLOR);
            paint3.setColor(DefaultTimeBar.DEFAULT_UNPLAYED_COLOR);
            paint4.setColor(DefaultTimeBar.DEFAULT_AD_MARKER_COLOR);
            paint5.setColor(DefaultTimeBar.DEFAULT_PLAYED_AD_MARKER_COLOR);
            this.f8499k = null;
        }
        StringBuilder sb = new StringBuilder();
        this.f8509u = sb;
        this.f8510v = new Formatter(sb, Locale.getDefault());
        this.f8511w = new Runnable() { // from class: y3.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f36511a.j();
            }
        };
        Drawable drawable2 = this.f8499k;
        if (drawable2 != null) {
            this.f8507s = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.f8507s = (Math.max(this.f8505q, Math.max(this.f8504p, this.f8506r)) + 1) / 2;
        }
        this.F = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.E = valueAnimator;
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: y3.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.f36512a.k(valueAnimator2);
            }
        });
        this.J = C.TIME_UNSET;
        this.B = C.TIME_UNSET;
        this.A = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    private static int d(float f10, int i10) {
        return (int) ((i10 * f10) + 0.5f);
    }

    private void e(Canvas canvas) {
        if (this.J <= 0) {
            return;
        }
        Rect rect = this.f8492d;
        int iP = o0.p(rect.right, rect.left, this.f8490b.right);
        int iCenterY = this.f8492d.centerY();
        if (this.f8499k == null) {
            canvas.drawCircle(iP, iCenterY, (int) ((((this.H || isFocused()) ? this.f8506r : isEnabled() ? this.f8504p : this.f8505q) * this.F) / 2.0f), this.f8498j);
            return;
        }
        int intrinsicWidth = ((int) (r2.getIntrinsicWidth() * this.F)) / 2;
        int intrinsicHeight = ((int) (this.f8499k.getIntrinsicHeight() * this.F)) / 2;
        this.f8499k.setBounds(iP - intrinsicWidth, iCenterY - intrinsicHeight, iP + intrinsicWidth, iCenterY + intrinsicHeight);
        this.f8499k.draw(canvas);
    }

    private void f(Canvas canvas) {
        int iHeight = this.f8490b.height();
        int iCenterY = this.f8490b.centerY() - (iHeight / 2);
        int i10 = iHeight + iCenterY;
        if (this.J <= 0) {
            Rect rect = this.f8490b;
            canvas.drawRect(rect.left, iCenterY, rect.right, i10, this.f8495g);
            return;
        }
        Rect rect2 = this.f8491c;
        int i11 = rect2.left;
        int i12 = rect2.right;
        int iMax = Math.max(Math.max(this.f8490b.left, i12), this.f8492d.right);
        int i13 = this.f8490b.right;
        if (iMax < i13) {
            canvas.drawRect(iMax, iCenterY, i13, i10, this.f8495g);
        }
        int iMax2 = Math.max(i11, this.f8492d.right);
        if (i12 > iMax2) {
            canvas.drawRect(iMax2, iCenterY, i12, i10, this.f8494f);
        }
        if (this.f8492d.width() > 0) {
            Rect rect3 = this.f8492d;
            canvas.drawRect(rect3.left, iCenterY, rect3.right, i10, this.f8493e);
        }
        if (this.M == 0) {
            return;
        }
        long[] jArr = (long[]) a4.a.e(this.N);
        boolean[] zArr = (boolean[]) a4.a.e(this.O);
        int i14 = this.f8503o / 2;
        for (int i15 = 0; i15 < this.M; i15++) {
            int iWidth = ((int) ((((long) this.f8490b.width()) * o0.q(jArr[i15], 0L, this.J)) / this.J)) - i14;
            Rect rect4 = this.f8490b;
            canvas.drawRect(rect4.left + Math.min(rect4.width() - this.f8503o, Math.max(0, iWidth)), iCenterY, r10 + this.f8503o, i10, zArr[i15] ? this.f8497i : this.f8496h);
        }
    }

    private long getPositionIncrement() {
        long j10 = this.B;
        if (j10 != C.TIME_UNSET) {
            return j10;
        }
        long j11 = this.J;
        if (j11 == C.TIME_UNSET) {
            return 0L;
        }
        return j11 / ((long) this.A);
    }

    private String getProgressText() {
        return o0.b0(this.f8509u, this.f8510v, this.K);
    }

    private long getScrubberPosition() {
        if (this.f8490b.width() <= 0 || this.J == C.TIME_UNSET) {
            return 0L;
        }
        return (((long) this.f8492d.width()) * this.J) / ((long) this.f8490b.width());
    }

    private boolean i(float f10, float f11) {
        return this.f8489a.contains((int) f10, (int) f11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        v(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(ValueAnimator valueAnimator) {
        this.F = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate(this.f8489a);
    }

    private void l(float f10) {
        Rect rect = this.f8492d;
        Rect rect2 = this.f8490b;
        rect.right = o0.p((int) f10, rect2.left, rect2.right);
    }

    private static int m(float f10, int i10) {
        return (int) (i10 / f10);
    }

    private Point n(MotionEvent motionEvent) {
        this.f8513y.set((int) motionEvent.getX(), (int) motionEvent.getY());
        return this.f8513y;
    }

    private boolean o(long j10) {
        long j11 = this.J;
        if (j11 <= 0) {
            return false;
        }
        long j12 = this.H ? this.I : this.K;
        long jQ = o0.q(j12 + j10, 0L, j11);
        if (jQ == j12) {
            return false;
        }
        if (this.H) {
            y(jQ);
        } else {
            u(jQ);
        }
        w();
        return true;
    }

    private boolean p(Drawable drawable) {
        return o0.f214a >= 23 && q(drawable, getLayoutDirection());
    }

    private static boolean q(Drawable drawable, int i10) {
        return o0.f214a >= 23 && drawable.setLayoutDirection(i10);
    }

    @RequiresApi(29)
    private void r(int i10, int i11) {
        Rect rect = this.D;
        if (rect != null && rect.width() == i10 && this.D.height() == i11) {
            return;
        }
        Rect rect2 = new Rect(0, 0, i10, i11);
        this.D = rect2;
        setSystemGestureExclusionRects(Collections.singletonList(rect2));
    }

    private void u(long j10) {
        this.I = j10;
        this.H = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator<f0.a> it = this.f8512x.iterator();
        while (it.hasNext()) {
            it.next().o(this, j10);
        }
    }

    private void v(boolean z10) {
        removeCallbacks(this.f8511w);
        this.H = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator<f0.a> it = this.f8512x.iterator();
        while (it.hasNext()) {
            it.next().n(this, this.I, z10);
        }
    }

    private void w() {
        this.f8491c.set(this.f8490b);
        this.f8492d.set(this.f8490b);
        long j10 = this.H ? this.I : this.K;
        if (this.J > 0) {
            int iWidth = (int) ((((long) this.f8490b.width()) * this.L) / this.J);
            Rect rect = this.f8491c;
            Rect rect2 = this.f8490b;
            rect.right = Math.min(rect2.left + iWidth, rect2.right);
            int iWidth2 = (int) ((((long) this.f8490b.width()) * j10) / this.J);
            Rect rect3 = this.f8492d;
            Rect rect4 = this.f8490b;
            rect3.right = Math.min(rect4.left + iWidth2, rect4.right);
        } else {
            Rect rect5 = this.f8491c;
            int i10 = this.f8490b.left;
            rect5.right = i10;
            this.f8492d.right = i10;
        }
        invalidate(this.f8489a);
    }

    private void x() {
        Drawable drawable = this.f8499k;
        if (drawable != null && drawable.isStateful() && this.f8499k.setState(getDrawableState())) {
            invalidate();
        }
    }

    private void y(long j10) {
        if (this.I == j10) {
            return;
        }
        this.I = j10;
        Iterator<f0.a> it = this.f8512x.iterator();
        while (it.hasNext()) {
            it.next().k(this, j10);
        }
    }

    @Override // com.google.android.exoplayer2.ui.f0
    public void a(f0.a aVar) {
        a4.a.e(aVar);
        this.f8512x.add(aVar);
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        x();
    }

    public void g(long j10) {
        if (this.E.isStarted()) {
            this.E.cancel();
        }
        this.E.setFloatValues(this.F, 0.0f);
        this.E.setDuration(j10);
        this.E.start();
    }

    @Override // com.google.android.exoplayer2.ui.f0
    public long getPreferredUpdateDelay() {
        int iM = m(this.f8514z, this.f8490b.width());
        if (iM != 0) {
            long j10 = this.J;
            if (j10 != 0 && j10 != C.TIME_UNSET) {
                return j10 / ((long) iM);
            }
        }
        return Long.MAX_VALUE;
    }

    public void h(boolean z10) {
        if (this.E.isStarted()) {
            this.E.cancel();
        }
        this.G = z10;
        this.F = 0.0f;
        invalidate(this.f8489a);
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f8499k;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        f(canvas);
        e(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z10, int i10, @Nullable Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (!this.H || z10) {
            return;
        }
        v(false);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName("android.widget.SeekBar");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.J <= 0) {
            return;
        }
        if (o0.f214a >= 21) {
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
        } else {
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            if (r0 == 0) goto L30
            long r0 = r4.getPositionIncrement()
            r2 = 66
            r3 = 1
            if (r5 == r2) goto L27
            switch(r5) {
                case 21: goto L13;
                case 22: goto L14;
                case 23: goto L27;
                default: goto L12;
            }
        L12:
            goto L30
        L13:
            long r0 = -r0
        L14:
            boolean r0 = r4.o(r0)
            if (r0 == 0) goto L30
            java.lang.Runnable r5 = r4.f8511w
            r4.removeCallbacks(r5)
            java.lang.Runnable r5 = r4.f8511w
            r0 = 1000(0x3e8, double:4.94E-321)
            r4.postDelayed(r5, r0)
            return r3
        L27:
            boolean r0 = r4.H
            if (r0 == 0) goto L30
            r5 = 0
            r4.v(r5)
            return r3
        L30:
            boolean r5 = super.onKeyDown(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.b.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int paddingBottom;
        int iMax;
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i14 - getPaddingRight();
        int i16 = this.G ? 0 : this.f8507s;
        if (this.f8502n == 1) {
            paddingBottom = (i15 - getPaddingBottom()) - this.f8501m;
            int paddingBottom2 = i15 - getPaddingBottom();
            int i17 = this.f8500l;
            iMax = (paddingBottom2 - i17) - Math.max(i16 - (i17 / 2), 0);
        } else {
            paddingBottom = (i15 - this.f8501m) / 2;
            iMax = (i15 - this.f8500l) / 2;
        }
        this.f8489a.set(paddingLeft, paddingBottom, paddingRight, this.f8501m + paddingBottom);
        Rect rect = this.f8490b;
        Rect rect2 = this.f8489a;
        rect.set(rect2.left + i16, iMax, rect2.right - i16, this.f8500l + iMax);
        if (o0.f214a >= 29) {
            r(i14, i15);
        }
        w();
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode == 0) {
            size = this.f8501m;
        } else if (mode != 1073741824) {
            size = Math.min(this.f8501m, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i10), size);
        x();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
        Drawable drawable = this.f8499k;
        if (drawable == null || !q(drawable, i10)) {
            return;
        }
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.isEnabled()
            r1 = 0
            if (r0 == 0) goto L76
            long r2 = r7.J
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L10
            goto L76
        L10:
            android.graphics.Point r0 = r7.n(r8)
            int r2 = r0.x
            int r0 = r0.y
            int r3 = r8.getAction()
            r4 = 1
            if (r3 == 0) goto L5d
            r5 = 3
            if (r3 == r4) goto L4e
            r6 = 2
            if (r3 == r6) goto L28
            if (r3 == r5) goto L4e
            goto L76
        L28:
            boolean r8 = r7.H
            if (r8 == 0) goto L76
            int r8 = r7.f8508t
            if (r0 >= r8) goto L3a
            int r8 = r7.C
            int r2 = r2 - r8
            int r2 = r2 / r5
            int r8 = r8 + r2
            float r8 = (float) r8
            r7.l(r8)
            goto L40
        L3a:
            r7.C = r2
            float r8 = (float) r2
            r7.l(r8)
        L40:
            long r0 = r7.getScrubberPosition()
            r7.y(r0)
            r7.w()
            r7.invalidate()
            return r4
        L4e:
            boolean r0 = r7.H
            if (r0 == 0) goto L76
            int r8 = r8.getAction()
            if (r8 != r5) goto L59
            r1 = r4
        L59:
            r7.v(r1)
            return r4
        L5d:
            float r8 = (float) r2
            float r0 = (float) r0
            boolean r0 = r7.i(r8, r0)
            if (r0 == 0) goto L76
            r7.l(r8)
            long r0 = r7.getScrubberPosition()
            r7.u(r0)
            r7.w()
            r7.invalidate()
            return r4
        L76:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.b.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i10, @Nullable Bundle bundle) {
        if (super.performAccessibilityAction(i10, bundle)) {
            return true;
        }
        if (this.J <= 0) {
            return false;
        }
        if (i10 == 8192) {
            if (o(-getPositionIncrement())) {
                v(false);
            }
        } else {
            if (i10 != 4096) {
                return false;
            }
            if (o(getPositionIncrement())) {
                v(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    public void s() {
        if (this.E.isStarted()) {
            this.E.cancel();
        }
        this.G = false;
        this.F = 1.0f;
        invalidate(this.f8489a);
    }

    @Override // com.google.android.exoplayer2.ui.f0
    public void setAdGroupTimesMs(@Nullable long[] jArr, @Nullable boolean[] zArr, int i10) {
        a4.a.a(i10 == 0 || !(jArr == null || zArr == null));
        this.M = i10;
        this.N = jArr;
        this.O = zArr;
        w();
    }

    public void setAdMarkerColor(@ColorInt int i10) {
        this.f8496h.setColor(i10);
        invalidate(this.f8489a);
    }

    public void setBufferedColor(@ColorInt int i10) {
        this.f8494f.setColor(i10);
        invalidate(this.f8489a);
    }

    @Override // com.google.android.exoplayer2.ui.f0
    public void setBufferedPosition(long j10) {
        if (this.L == j10) {
            return;
        }
        this.L = j10;
        w();
    }

    @Override // com.google.android.exoplayer2.ui.f0
    public void setDuration(long j10) {
        if (this.J == j10) {
            return;
        }
        this.J = j10;
        if (this.H && j10 == C.TIME_UNSET) {
            v(true);
        }
        w();
    }

    @Override // android.view.View, com.google.android.exoplayer2.ui.f0
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (!this.H || z10) {
            return;
        }
        v(true);
    }

    public void setKeyCountIncrement(int i10) {
        a4.a.a(i10 > 0);
        this.A = i10;
        this.B = C.TIME_UNSET;
    }

    public void setKeyTimeIncrement(long j10) {
        a4.a.a(j10 > 0);
        this.A = -1;
        this.B = j10;
    }

    public void setPlayedAdMarkerColor(@ColorInt int i10) {
        this.f8497i.setColor(i10);
        invalidate(this.f8489a);
    }

    public void setPlayedColor(@ColorInt int i10) {
        this.f8493e.setColor(i10);
        invalidate(this.f8489a);
    }

    @Override // com.google.android.exoplayer2.ui.f0
    public void setPosition(long j10) {
        if (this.K == j10) {
            return;
        }
        this.K = j10;
        setContentDescription(getProgressText());
        w();
    }

    public void setScrubberColor(@ColorInt int i10) {
        this.f8498j.setColor(i10);
        invalidate(this.f8489a);
    }

    public void setUnplayedColor(@ColorInt int i10) {
        this.f8495g.setColor(i10);
        invalidate(this.f8489a);
    }

    public void t(long j10) {
        if (this.E.isStarted()) {
            this.E.cancel();
        }
        this.G = false;
        this.E.setFloatValues(this.F, 1.0f);
        this.E.setDuration(j10);
        this.E.start();
    }
}
