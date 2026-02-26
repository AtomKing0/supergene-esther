package com.google.android.material.timepicker;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.timepicker.ClockHandView;
import e4.h;
import e4.j;
import e4.k;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
class ClockFaceView extends e implements ClockHandView.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ClockHandView f9857d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Rect f9858e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RectF f9859f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Rect f9860g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final SparseArray<TextView> f9861h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AccessibilityDelegateCompat f9862i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int[] f9863j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final float[] f9864k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f9865l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f9866m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f9867n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f9868o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String[] f9869p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f9870q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final ColorStateList f9871r;

    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!ClockFaceView.this.isShown()) {
                return true;
            }
            ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ClockFaceView.this.f(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.f9857d.i()) - ClockFaceView.this.f9865l);
            return true;
        }
    }

    class b extends AccessibilityDelegateCompat {
        b() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            int iIntValue = ((Integer) view.getTag(e4.f.f24837r)).intValue();
            if (iIntValue > 0) {
                accessibilityNodeInfoCompat.setTraversalAfter((View) ClockFaceView.this.f9861h.get(iIntValue - 1));
            }
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, iIntValue, 1, false, view.isSelected()));
            accessibilityNodeInfoCompat.setClickable(true);
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            if (i10 != 16) {
                return super.performAccessibilityAction(view, i10, bundle);
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            view.getHitRect(ClockFaceView.this.f9858e);
            float fCenterX = ClockFaceView.this.f9858e.centerX();
            float fCenterY = ClockFaceView.this.f9858e.centerY();
            ClockFaceView.this.f9857d.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, fCenterX, fCenterY, 0));
            ClockFaceView.this.f9857d.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 1, fCenterX, fCenterY, 0));
            return true;
        }
    }

    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, e4.b.f24767x);
    }

    private void n() {
        RectF rectFE = this.f9857d.e();
        TextView textViewP = p(rectFE);
        for (int i10 = 0; i10 < this.f9861h.size(); i10++) {
            TextView textView = this.f9861h.get(i10);
            if (textView != null) {
                textView.setSelected(textView == textViewP);
                textView.getPaint().setShader(o(rectFE, textView));
                textView.invalidate();
            }
        }
    }

    @Nullable
    private RadialGradient o(RectF rectF, TextView textView) {
        textView.getHitRect(this.f9858e);
        this.f9859f.set(this.f9858e);
        textView.getLineBounds(0, this.f9860g);
        RectF rectF2 = this.f9859f;
        Rect rect = this.f9860g;
        rectF2.inset(rect.left, rect.top);
        if (RectF.intersects(rectF, this.f9859f)) {
            return new RadialGradient(rectF.centerX() - this.f9859f.left, rectF.centerY() - this.f9859f.top, rectF.width() * 0.5f, this.f9863j, this.f9864k, Shader.TileMode.CLAMP);
        }
        return null;
    }

    @Nullable
    private TextView p(RectF rectF) {
        float f10 = Float.MAX_VALUE;
        TextView textView = null;
        for (int i10 = 0; i10 < this.f9861h.size(); i10++) {
            TextView textView2 = this.f9861h.get(i10);
            if (textView2 != null) {
                textView2.getHitRect(this.f9858e);
                this.f9859f.set(this.f9858e);
                this.f9859f.union(rectF);
                float fWidth = this.f9859f.width() * this.f9859f.height();
                if (fWidth < f10) {
                    textView = textView2;
                    f10 = fWidth;
                }
            }
        }
        return textView;
    }

    private static float q(float f10, float f11, float f12) {
        return Math.max(Math.max(f10, f11), f12);
    }

    private void s(@StringRes int i10) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int size = this.f9861h.size();
        boolean z10 = false;
        for (int i11 = 0; i11 < Math.max(this.f9869p.length, size); i11++) {
            TextView textView = this.f9861h.get(i11);
            if (i11 >= this.f9869p.length) {
                removeView(textView);
                this.f9861h.remove(i11);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(h.f24855g, (ViewGroup) this, false);
                    this.f9861h.put(i11, textView);
                    addView(textView);
                }
                textView.setText(this.f9869p[i11]);
                textView.setTag(e4.f.f24837r, Integer.valueOf(i11));
                int i12 = (i11 / 12) + 1;
                textView.setTag(e4.f.f24832m, Integer.valueOf(i12));
                if (i12 > 1) {
                    z10 = true;
                }
                ViewCompat.setAccessibilityDelegate(textView, this.f9862i);
                textView.setTextColor(this.f9871r);
                if (i10 != 0) {
                    textView.setContentDescription(getResources().getString(i10, this.f9869p[i11]));
                }
            }
        }
        this.f9857d.q(z10);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.b
    public void a(float f10, boolean z10) {
        if (Math.abs(this.f9870q - f10) > 0.001f) {
            this.f9870q = f10;
            n();
        }
    }

    @Override // com.google.android.material.timepicker.e
    public void f(int i10) {
        if (i10 != e()) {
            super.f(i10);
            this.f9857d.m(e());
        }
    }

    @Override // com.google.android.material.timepicker.e
    protected void h() {
        super.h();
        for (int i10 = 0; i10 < this.f9861h.size(); i10++) {
            this.f9861h.get(i10).setVisibility(0);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.f9869p.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        n();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iQ = (int) (this.f9868o / q(this.f9866m / displayMetrics.heightPixels, this.f9867n / displayMetrics.widthPixels, 1.0f));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iQ, 1073741824);
        setMeasuredDimension(iQ, iQ);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }

    public void r(String[] strArr, @StringRes int i10) {
        this.f9869p = strArr;
        s(i10);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f9858e = new Rect();
        this.f9859f = new RectF();
        this.f9860g = new Rect();
        this.f9861h = new SparseArray<>();
        this.f9864k = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.V0, i10, j.f24916v);
        Resources resources = getResources();
        ColorStateList colorStateListA = u4.c.a(context, typedArrayObtainStyledAttributes, k.X0);
        this.f9871r = colorStateListA;
        LayoutInflater.from(context).inflate(h.f24856h, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(e4.f.f24831l);
        this.f9857d = clockHandView;
        this.f9865l = resources.getDimensionPixelSize(e4.d.f24804w);
        int colorForState = colorStateListA.getColorForState(new int[]{R.attr.state_selected}, colorStateListA.getDefaultColor());
        this.f9863j = new int[]{colorForState, colorForState, colorStateListA.getDefaultColor()};
        clockHandView.b(this);
        int defaultColor = AppCompatResources.getColorStateList(context, e4.c.f24771b).getDefaultColor();
        ColorStateList colorStateListA2 = u4.c.a(context, typedArrayObtainStyledAttributes, k.W0);
        setBackgroundColor(colorStateListA2 != null ? colorStateListA2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new a());
        setFocusable(true);
        typedArrayObtainStyledAttributes.recycle();
        this.f9862i = new b();
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        r(strArr, 0);
        this.f9866m = resources.getDimensionPixelSize(e4.d.J);
        this.f9867n = resources.getDimensionPixelSize(e4.d.K);
        this.f9868o = resources.getDimensionPixelSize(e4.d.f24806y);
    }
}
