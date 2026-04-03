package c4;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.BinderThread;
import c4.d;

/* JADX INFO: compiled from: TouchTracker.java */
/* JADX INFO: loaded from: classes2.dex */
final class m extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, d.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f4593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f4594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final GestureDetector f4595e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PointF f4591a = new PointF();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PointF f4592b = new PointF();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile float f4596f = 3.1415927f;

    /* JADX INFO: compiled from: TouchTracker.java */
    public interface a {
        void onScrollChange(PointF pointF);

        boolean onSingleTapUp(MotionEvent motionEvent);
    }

    public m(Context context, a aVar, float f10) {
        this.f4593c = aVar;
        this.f4594d = f10;
        this.f4595e = new GestureDetector(context, this);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.f4591a.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // c4.d.a
    @BinderThread
    public void onOrientationChange(float[] fArr, float f10) {
        this.f4596f = -f10;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
        float x10 = (motionEvent2.getX() - this.f4591a.x) / this.f4594d;
        float y10 = motionEvent2.getY();
        PointF pointF = this.f4591a;
        float f12 = (y10 - pointF.y) / this.f4594d;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d10 = this.f4596f;
        float fCos = (float) Math.cos(d10);
        float fSin = (float) Math.sin(d10);
        PointF pointF2 = this.f4592b;
        pointF2.x -= (fCos * x10) - (fSin * f12);
        float f13 = pointF2.y + (fSin * x10) + (fCos * f12);
        pointF2.y = f13;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f13));
        this.f4593c.onScrollChange(this.f4592b);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.f4593c.onSingleTapUp(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f4595e.onTouchEvent(motionEvent);
    }
}
