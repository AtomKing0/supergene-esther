package com.applovin.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.applovin.sdk.AppLovinMediationProvider;
import com.king.usdk.localnotification.NotificationSchedulerKeys;

/* JADX INFO: loaded from: classes2.dex */
public class e0 extends View {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f5060w = Color.rgb(66, 145, 241);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int f5061x = Color.rgb(66, 145, 241);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int f5062y = Color.rgb(66, 145, 241);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f5063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Paint f5064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Paint f5065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Paint f5066d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RectF f5067e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f5068f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f5069g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f5070h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f5071i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f5072j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f5073k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f5074l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f5075m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f5076n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f5077o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f5078p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f5079q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f5080r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final float f5081s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final float f5082t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final float f5083u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final int f5084v;

    private static class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static float c(Resources resources, float f10) {
            return (f10 * resources.getDisplayMetrics().density) + 0.5f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static float d(Resources resources, float f10) {
            return f10 * resources.getDisplayMetrics().scaledDensity;
        }
    }

    public e0(Context context) {
        this(context, null);
    }

    private float getProgressAngle() {
        return (getProgress() / this.f5072j) * 360.0f;
    }

    protected void a() {
        this.f5073k = f5060w;
        this.f5069g = f5061x;
        this.f5068f = this.f5082t;
        setMax(100);
        setProgress(0);
        this.f5074l = this.f5081s;
        this.f5075m = 0;
        this.f5078p = this.f5083u;
        this.f5070h = f5062y;
    }

    protected void b() {
        TextPaint textPaint = new TextPaint();
        this.f5065c = textPaint;
        textPaint.setColor(this.f5069g);
        this.f5065c.setTextSize(this.f5068f);
        this.f5065c.setAntiAlias(true);
        TextPaint textPaint2 = new TextPaint();
        this.f5066d = textPaint2;
        textPaint2.setColor(this.f5070h);
        this.f5066d.setTextSize(this.f5078p);
        this.f5066d.setAntiAlias(true);
        Paint paint = new Paint();
        this.f5063a = paint;
        paint.setColor(this.f5073k);
        this.f5063a.setStyle(Paint.Style.STROKE);
        this.f5063a.setAntiAlias(true);
        this.f5063a.setStrokeWidth(this.f5074l);
        Paint paint2 = new Paint();
        this.f5064b = paint2;
        paint2.setColor(this.f5075m);
        this.f5064b.setAntiAlias(true);
    }

    public int getFinishedStrokeColor() {
        return this.f5073k;
    }

    public float getFinishedStrokeWidth() {
        return this.f5074l;
    }

    public int getInnerBackgroundColor() {
        return this.f5075m;
    }

    public String getInnerBottomText() {
        return this.f5079q;
    }

    public int getInnerBottomTextColor() {
        return this.f5070h;
    }

    public float getInnerBottomTextSize() {
        return this.f5078p;
    }

    public int getMax() {
        return this.f5072j;
    }

    public String getPrefixText() {
        return this.f5076n;
    }

    public int getProgress() {
        return this.f5071i;
    }

    public String getSuffixText() {
        return this.f5077o;
    }

    public int getTextColor() {
        return this.f5069g;
    }

    public float getTextSize() {
        return this.f5068f;
    }

    @Override // android.view.View
    public void invalidate() {
        b();
        super.invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f10 = this.f5074l;
        this.f5067e.set(f10, f10, getWidth() - f10, getHeight() - f10);
        float width = getWidth();
        float f11 = this.f5074l;
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, ((width - f11) + f11) / 2.0f, this.f5064b);
        canvas.drawArc(this.f5067e, 270.0f, -getProgressAngle(), false, this.f5063a);
        String str = this.f5076n + this.f5071i + this.f5077o;
        if (!TextUtils.isEmpty(str)) {
            canvas.drawText(str, (getWidth() - this.f5065c.measureText(str)) / 2.0f, (getWidth() - (this.f5065c.descent() + this.f5065c.ascent())) / 2.0f, this.f5065c);
        }
        if (TextUtils.isEmpty(getInnerBottomText())) {
            return;
        }
        this.f5066d.setTextSize(this.f5078p);
        canvas.drawText(getInnerBottomText(), (getWidth() - this.f5066d.measureText(getInnerBottomText())) / 2.0f, (getHeight() - this.f5080r) - ((this.f5065c.descent() + this.f5065c.ascent()) / 2.0f), this.f5066d);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        setMeasuredDimension(a(i10), a(i11));
        this.f5080r = getHeight() - ((getHeight() * 3) / 4);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        this.f5069g = bundle.getInt(NotificationSchedulerKeys.KEY_TEXT_COLOR);
        this.f5068f = bundle.getFloat("text_size");
        this.f5078p = bundle.getFloat("inner_bottom_text_size");
        this.f5079q = bundle.getString("inner_bottom_text");
        this.f5070h = bundle.getInt("inner_bottom_text_color");
        this.f5073k = bundle.getInt("finished_stroke_color");
        this.f5074l = bundle.getFloat("finished_stroke_width");
        this.f5075m = bundle.getInt("inner_background_color");
        b();
        setMax(bundle.getInt(AppLovinMediationProvider.MAX));
        setProgress(bundle.getInt("progress"));
        this.f5076n = bundle.getString("prefix");
        this.f5077o = bundle.getString("suffix");
        super.onRestoreInstanceState(bundle.getParcelable("saved_instance"));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("saved_instance", super.onSaveInstanceState());
        bundle.putInt(NotificationSchedulerKeys.KEY_TEXT_COLOR, getTextColor());
        bundle.putFloat("text_size", getTextSize());
        bundle.putFloat("inner_bottom_text_size", getInnerBottomTextSize());
        bundle.putFloat("inner_bottom_text_color", getInnerBottomTextColor());
        bundle.putString("inner_bottom_text", getInnerBottomText());
        bundle.putInt("inner_bottom_text_color", getInnerBottomTextColor());
        bundle.putInt("finished_stroke_color", getFinishedStrokeColor());
        bundle.putInt(AppLovinMediationProvider.MAX, getMax());
        bundle.putInt("progress", getProgress());
        bundle.putString("suffix", getSuffixText());
        bundle.putString("prefix", getPrefixText());
        bundle.putFloat("finished_stroke_width", getFinishedStrokeWidth());
        bundle.putInt("inner_background_color", getInnerBackgroundColor());
        return bundle;
    }

    public void setFinishedStrokeColor(int i10) {
        this.f5073k = i10;
        invalidate();
    }

    public void setFinishedStrokeWidth(float f10) {
        this.f5074l = f10;
        invalidate();
    }

    public void setInnerBackgroundColor(int i10) {
        this.f5075m = i10;
        invalidate();
    }

    public void setInnerBottomText(String str) {
        this.f5079q = str;
        invalidate();
    }

    public void setInnerBottomTextColor(int i10) {
        this.f5070h = i10;
        invalidate();
    }

    public void setInnerBottomTextSize(float f10) {
        this.f5078p = f10;
        invalidate();
    }

    public void setMax(int i10) {
        if (i10 > 0) {
            this.f5072j = i10;
            invalidate();
        }
    }

    public void setPrefixText(String str) {
        this.f5076n = str;
        invalidate();
    }

    public void setProgress(int i10) {
        this.f5071i = i10;
        if (i10 > getMax()) {
            this.f5071i %= getMax();
        }
        invalidate();
    }

    public void setSuffixText(String str) {
        this.f5077o = str;
        invalidate();
    }

    public void setTextColor(int i10) {
        this.f5069g = i10;
        invalidate();
    }

    public void setTextSize(float f10) {
        this.f5068f = f10;
        invalidate();
    }

    public e0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public e0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f5067e = new RectF();
        this.f5071i = 0;
        this.f5076n = "";
        this.f5077o = "";
        this.f5079q = "";
        this.f5082t = a.d(getResources(), 14.0f);
        this.f5084v = (int) a.c(getResources(), 100.0f);
        this.f5081s = a.c(getResources(), 4.0f);
        this.f5083u = a.d(getResources(), 18.0f);
        a();
        b();
    }

    private int a(int i10) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode == 1073741824) {
            return size;
        }
        int i11 = this.f5084v;
        return mode == Integer.MIN_VALUE ? Math.min(i11, size) : i11;
    }
}
