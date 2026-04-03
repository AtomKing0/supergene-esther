package com.applovin.impl.sdk.nativeAd;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;
import com.applovin.impl.i0;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ViewConstructor"})
public class AppLovinStarRatingView extends View {
    private static final int DEFAULT_PADDING_DP = 2;
    private static final float DEFAULT_STROKE_WIDTH = 0.5f;
    private static final int DEFAULT_TOTAL_NUMBER_OF_STARS = 5;
    private static final float INTERNAL_ANGLE_OF_PENTAGON_RADIANS = 1.8849556f;
    private static final float SUM_OF_CENTRAL_ANGLES_IN_CIRCLE_RADIANS = 6.2831855f;
    private static final float TWELVE_OCLOCK_POSITION_RADIANS = 4.712389f;
    private static final Paint emptyStarPaint = new Paint(1);
    private static final Paint filledStarPaint = new Paint(1);
    private final float interStarsSpacingDp;
    private final float paddingDp;
    private float sideLength;
    private final Double starRating;

    public AppLovinStarRatingView(Double d10, Context context) {
        super(context);
        this.starRating = d10;
        this.paddingDp = AppLovinSdkUtils.dpToPx(context, 2);
        this.interStarsSpacingDp = AppLovinSdkUtils.dpToPx(context, 2);
        setupPaints();
    }

    private void drawEmptyStars(Canvas canvas, Path path) {
        canvas.drawPath(path, emptyStarPaint);
    }

    private void drawFilledStars(Canvas canvas, Path path) {
        if (this.starRating.doubleValue() == 0.0d) {
            return;
        }
        float fRoundUpToNearestHalfInt = ((float) roundUpToNearestHalfInt(this.starRating.doubleValue())) / 5.0f;
        float fCeil = (float) (((double) this.paddingDp) + (Math.ceil(r0 - 1.0f) * ((double) this.interStarsSpacingDp)));
        canvas.clipPath(path);
        canvas.drawRect(new RectF(0.0f, 0.0f, fCeil + (fRoundUpToNearestHalfInt * 5.0f * this.sideLength), getHeight()), filledStarPaint);
    }

    private Path getCombinedPathForAllStarsWithSide(float f10) {
        PointF pointF = new PointF(0.0f, this.paddingDp);
        float f11 = pointF.x + this.paddingDp;
        Path path = new Path();
        for (int i10 = 0; i10 < 5; i10++) {
            float f12 = pointF.y;
            Path starPath = getStarPath(new RectF(f11, f12, f11 + f10, f12 + f10));
            f11 += this.interStarsSpacingDp + f10;
            path.addPath(starPath);
        }
        return path;
    }

    private static float getDistanceBetweenPoints(PointF pointF, PointF pointF2) {
        return (float) Math.sqrt(Math.pow(pointF.x - pointF2.x, 2.0d) + Math.pow(pointF.y - pointF2.y, 2.0d));
    }

    private static PointF getMidpointBetweenPoints(PointF pointF, PointF pointF2) {
        return new PointF((float) (((double) pointF.x) + (((double) (pointF2.x - pointF.x)) * 0.5d)), (float) (((double) pointF.y) + (((double) (pointF2.y - pointF.y)) * 0.5d)));
    }

    private Path getStarPath(RectF rectF) {
        PointF pointF = new PointF(rectF.centerX(), rectF.centerY());
        List<PointF> starPointsOnACircle = getStarPointsOnACircle(pointF, (float) (((double) rectF.width()) * 0.5d), TWELVE_OCLOCK_POSITION_RADIANS);
        PointF pointF2 = starPointsOnACircle.get(0);
        PointF midpointBetweenPoints = getMidpointBetweenPoints(pointF2, starPointsOnACircle.get(1));
        List<PointF> starPointsOnACircle2 = getStarPointsOnACircle(pointF, getDistanceBetweenPoints(pointF, midpointBetweenPoints) - ((float) (((double) getDistanceBetweenPoints(pointF2, midpointBetweenPoints)) / Math.tan(0.9424778f))), 5.340708f);
        Path path = new Path();
        path.moveTo(pointF2.x, pointF2.y);
        for (int i10 = 0; i10 < 5; i10++) {
            PointF pointF3 = starPointsOnACircle.get(i10);
            PointF pointF4 = starPointsOnACircle2.get(i10);
            path.lineTo(pointF3.x, pointF3.y);
            path.lineTo(pointF4.x, pointF4.y);
        }
        path.close();
        return path;
    }

    private List<PointF> getStarPointsOnACircle(PointF pointF, float f10, float f11) {
        float f12 = SUM_OF_CENTRAL_ANGLES_IN_CIRCLE_RADIANS / 5;
        ArrayList arrayList = new ArrayList(5);
        for (int i10 = 0; i10 < 5; i10++) {
            double d10 = f10;
            double d11 = f11;
            arrayList.add(new PointF((float) (((double) pointF.x) + (Math.cos(d11) * d10)), (float) (((double) pointF.y) + (d10 * Math.sin(d11)))));
            f11 += f12;
        }
        return arrayList;
    }

    private double getTotalHorizontalSpacing() {
        return (this.paddingDp * 2.0f) + (this.interStarsSpacingDp * 4.0f);
    }

    private double roundUpToNearestHalfInt(double d10) {
        return Math.ceil(d10 * 2.0d) / 2.0d;
    }

    private void setupPaints() {
        Paint paint = emptyStarPaint;
        int i10 = R.color.applovin_sdk_starColor;
        paint.setColor(i0.a(i10, getContext()));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(0.5f);
        Paint paint2 = filledStarPaint;
        paint2.setColor(i0.a(i10, getContext()));
        paint2.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.starRating == null) {
            return;
        }
        float fMin = (float) Math.min((((double) getWidth()) - getTotalHorizontalSpacing()) / 5.0d, getHeight() - (this.paddingDp * 2.0f));
        this.sideLength = fMin;
        if (fMin <= 0.0f) {
            return;
        }
        Path combinedPathForAllStarsWithSide = getCombinedPathForAllStarsWithSide(fMin);
        drawEmptyStars(canvas, combinedPathForAllStarsWithSide);
        drawFilledStars(canvas, combinedPathForAllStarsWithSide);
    }
}
