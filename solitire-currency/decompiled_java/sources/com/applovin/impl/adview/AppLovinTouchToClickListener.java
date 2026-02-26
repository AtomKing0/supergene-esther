package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.applovin.impl.k0;
import com.applovin.impl.l4;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: loaded from: classes2.dex */
public class AppLovinTouchToClickListener implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f4745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f4746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f4747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ClickRecognitionState f4748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f4749e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private PointF f4750f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f4751g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Context f4752h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final OnClickListener f4753i;

    public enum ClickRecognitionState {
        DISABLED,
        ACTION_DOWN,
        ACTION_POINTER_UP,
        ACTION_UP
    }

    public interface OnClickListener {
        void onClick(View view, MotionEvent motionEvent);
    }

    public AppLovinTouchToClickListener(com.applovin.impl.sdk.j jVar, l4 l4Var, Context context, OnClickListener onClickListener) {
        this.f4745a = ((Long) jVar.a(l4.f5639g0)).longValue();
        this.f4746b = ((Integer) jVar.a(l4.f5647h0)).intValue();
        this.f4747c = AppLovinSdkUtils.dpToPx(context, ((Integer) jVar.a(l4.f5679l0)).intValue());
        this.f4748d = ClickRecognitionState.values()[((Integer) jVar.a(l4Var)).intValue()];
        this.f4752h = context;
        this.f4753i = onClickListener;
    }

    private void a(View view, MotionEvent motionEvent) {
        this.f4753i.onClick(view, motionEvent);
        this.f4751g = true;
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i10;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 6 && !this.f4751g && this.f4748d == ClickRecognitionState.ACTION_POINTER_UP) {
                    a(view, motionEvent);
                }
            } else if (!this.f4751g && this.f4748d == ClickRecognitionState.ACTION_UP) {
                a(view, motionEvent);
            } else if (this.f4748d == ClickRecognitionState.DISABLED) {
                long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f4749e;
                float fA = a(this.f4750f, new PointF(motionEvent.getX(), motionEvent.getY()));
                if (!this.f4751g) {
                    long j10 = this.f4745a;
                    if ((j10 < 0 || jElapsedRealtime < j10) && ((i10 = this.f4746b) < 0 || fA < i10)) {
                        a(view, motionEvent);
                    }
                }
            }
        } else if (this.f4748d != ClickRecognitionState.ACTION_DOWN) {
            this.f4749e = SystemClock.elapsedRealtime();
            this.f4750f = new PointF(motionEvent.getX(), motionEvent.getY());
            this.f4751g = false;
        } else if (a(motionEvent)) {
            a(view, motionEvent);
        }
        return true;
    }

    private float a(PointF pointF, PointF pointF2) {
        float f10 = pointF.x - pointF2.x;
        float f11 = pointF.y - pointF2.y;
        return a((float) Math.sqrt((f10 * f10) + (f11 * f11)));
    }

    private float a(float f10) {
        return f10 / this.f4752h.getResources().getDisplayMetrics().density;
    }

    private boolean a(MotionEvent motionEvent) {
        if (this.f4747c <= 0) {
            return true;
        }
        Point pointB = k0.b(this.f4752h);
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int i10 = this.f4747c;
        float f10 = i10;
        return rawX >= f10 && rawY >= f10 && rawX <= ((float) (pointB.x - i10)) && rawY <= ((float) (pointB.y - i10));
    }
}
