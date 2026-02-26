package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Rect.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RectKt {
    @SuppressLint({"CheckResult"})
    @NotNull
    public static final Rect and(@NotNull Rect rect, @NotNull Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        return rect3;
    }

    public static final int component1(@NotNull Rect rect) {
        return rect.left;
    }

    public static final int component2(@NotNull Rect rect) {
        return rect.top;
    }

    public static final int component3(@NotNull Rect rect) {
        return rect.right;
    }

    public static final int component4(@NotNull Rect rect) {
        return rect.bottom;
    }

    public static final boolean contains(@NotNull Rect rect, @NotNull Point point) {
        return rect.contains(point.x, point.y);
    }

    @NotNull
    public static final Region minus(@NotNull Rect rect, @NotNull Rect rect2) {
        Region region = new Region(rect);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    @NotNull
    public static final Rect or(@NotNull Rect rect, @NotNull Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.union(rect2);
        return rect3;
    }

    @NotNull
    public static final Rect plus(@NotNull Rect rect, @NotNull Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.union(rect2);
        return rect3;
    }

    @NotNull
    public static final Rect times(@NotNull Rect rect, int i10) {
        Rect rect2 = new Rect(rect);
        rect2.top *= i10;
        rect2.left *= i10;
        rect2.right *= i10;
        rect2.bottom *= i10;
        return rect2;
    }

    @NotNull
    public static final Rect toRect(@NotNull RectF rectF) {
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return rect;
    }

    @NotNull
    public static final RectF toRectF(@NotNull Rect rect) {
        return new RectF(rect);
    }

    @NotNull
    public static final Region toRegion(@NotNull Rect rect) {
        return new Region(rect);
    }

    @NotNull
    public static final RectF transform(@NotNull RectF rectF, @NotNull Matrix matrix) {
        matrix.mapRect(rectF);
        return rectF;
    }

    @NotNull
    public static final Region xor(@NotNull Rect rect, @NotNull Rect rect2) {
        Region region = new Region(rect);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    public static final float component1(@NotNull RectF rectF) {
        return rectF.left;
    }

    public static final float component2(@NotNull RectF rectF) {
        return rectF.top;
    }

    public static final float component3(@NotNull RectF rectF) {
        return rectF.right;
    }

    public static final float component4(@NotNull RectF rectF) {
        return rectF.bottom;
    }

    public static final boolean contains(@NotNull RectF rectF, @NotNull PointF pointF) {
        return rectF.contains(pointF.x, pointF.y);
    }

    @NotNull
    public static final Region toRegion(@NotNull RectF rectF) {
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return new Region(rect);
    }

    @SuppressLint({"CheckResult"})
    @NotNull
    public static final RectF and(@NotNull RectF rectF, @NotNull RectF rectF2) {
        RectF rectF3 = new RectF(rectF);
        rectF3.intersect(rectF2);
        return rectF3;
    }

    @NotNull
    public static final Region minus(@NotNull RectF rectF, @NotNull RectF rectF2) {
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        rectF2.roundOut(rect2);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    @NotNull
    public static final RectF or(@NotNull RectF rectF, @NotNull RectF rectF2) {
        RectF rectF3 = new RectF(rectF);
        rectF3.union(rectF2);
        return rectF3;
    }

    @NotNull
    public static final RectF plus(@NotNull RectF rectF, @NotNull RectF rectF2) {
        RectF rectF3 = new RectF(rectF);
        rectF3.union(rectF2);
        return rectF3;
    }

    @NotNull
    public static final Region xor(@NotNull RectF rectF, @NotNull RectF rectF2) {
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        rectF2.roundOut(rect2);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    @NotNull
    public static final Rect plus(@NotNull Rect rect, int i10) {
        Rect rect2 = new Rect(rect);
        rect2.offset(i10, i10);
        return rect2;
    }

    @NotNull
    public static final RectF times(@NotNull RectF rectF, float f10) {
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f10;
        rectF2.left *= f10;
        rectF2.right *= f10;
        rectF2.bottom *= f10;
        return rectF2;
    }

    @NotNull
    public static final RectF plus(@NotNull RectF rectF, float f10) {
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(f10, f10);
        return rectF2;
    }

    @NotNull
    public static final Rect plus(@NotNull Rect rect, @NotNull Point point) {
        Rect rect2 = new Rect(rect);
        rect2.offset(point.x, point.y);
        return rect2;
    }

    @NotNull
    public static final Rect minus(@NotNull Rect rect, int i10) {
        Rect rect2 = new Rect(rect);
        int i11 = -i10;
        rect2.offset(i11, i11);
        return rect2;
    }

    @NotNull
    public static final RectF plus(@NotNull RectF rectF, @NotNull PointF pointF) {
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(pointF.x, pointF.y);
        return rectF2;
    }

    @NotNull
    public static final RectF times(@NotNull RectF rectF, int i10) {
        float f10 = i10;
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f10;
        rectF2.left *= f10;
        rectF2.right *= f10;
        rectF2.bottom *= f10;
        return rectF2;
    }

    @NotNull
    public static final RectF minus(@NotNull RectF rectF, float f10) {
        RectF rectF2 = new RectF(rectF);
        float f11 = -f10;
        rectF2.offset(f11, f11);
        return rectF2;
    }

    @NotNull
    public static final Rect minus(@NotNull Rect rect, @NotNull Point point) {
        Rect rect2 = new Rect(rect);
        rect2.offset(-point.x, -point.y);
        return rect2;
    }

    @NotNull
    public static final RectF minus(@NotNull RectF rectF, @NotNull PointF pointF) {
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(-pointF.x, -pointF.y);
        return rectF2;
    }
}
