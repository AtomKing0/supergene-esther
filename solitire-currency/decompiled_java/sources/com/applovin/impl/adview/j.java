package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.applovin.impl.adview.e;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Paint f4846e = new Paint(1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Paint f4847f = new Paint(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float[] f4848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Path f4849d;

    public j(Context context) {
        super(context);
        this.f4848c = new float[]{30.0f, 30.0f, 50.0f, 50.0f, 30.0f, 70.0f, 55.0f, 30.0f, 75.0f, 50.0f, 55.0f, 70.0f};
        f4846e.setARGB(80, 0, 0, 0);
        Paint paint = f4847f;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override // com.applovin.impl.adview.e
    public void a(int i10) {
        setViewScale(i10 / 30.0f);
        a();
    }

    protected float getCenter() {
        return getSize() / 2.0f;
    }

    protected float getStrokeWidth() {
        return this.f4822a * 2.0f;
    }

    @Override // com.applovin.impl.adview.e
    public e.a getStyle() {
        return e.a.TRANSPARENT_SKIP;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float center = getCenter();
        canvas.drawCircle(center, center, center, f4846e);
        Paint paint = f4847f;
        paint.setStrokeWidth(getStrokeWidth());
        canvas.drawPath(this.f4849d, paint);
    }

    private void a() {
        int i10 = 0;
        while (true) {
            float[] fArr = this.f4848c;
            if (i10 < fArr.length) {
                fArr[i10] = fArr[i10] * 0.3f * this.f4822a;
                i10++;
            } else {
                Path path = new Path();
                this.f4849d = path;
                float[] fArr2 = this.f4848c;
                path.moveTo(fArr2[0], fArr2[1]);
                Path path2 = this.f4849d;
                float[] fArr3 = this.f4848c;
                path2.lineTo(fArr3[2], fArr3[3]);
                Path path3 = this.f4849d;
                float[] fArr4 = this.f4848c;
                path3.lineTo(fArr4[4], fArr4[5]);
                Path path4 = this.f4849d;
                float[] fArr5 = this.f4848c;
                path4.moveTo(fArr5[6], fArr5[7]);
                Path path5 = this.f4849d;
                float[] fArr6 = this.f4848c;
                path5.lineTo(fArr6[8], fArr6[9]);
                Path path6 = this.f4849d;
                float[] fArr7 = this.f4848c;
                path6.lineTo(fArr7[10], fArr7[11]);
                return;
            }
        }
    }
}
