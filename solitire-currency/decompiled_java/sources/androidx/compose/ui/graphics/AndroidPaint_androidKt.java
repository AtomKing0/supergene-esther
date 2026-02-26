package androidx.compose.ui.graphics;

import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Build;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidPaint.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidPaint_androidKt {

    /* JADX INFO: compiled from: AndroidPaint.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[Paint.Style.values().length];
            iArr[Paint.Style.STROKE.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Paint.Cap.values().length];
            iArr2[Paint.Cap.BUTT.ordinal()] = 1;
            iArr2[Paint.Cap.ROUND.ordinal()] = 2;
            iArr2[Paint.Cap.SQUARE.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[Paint.Join.values().length];
            iArr3[Paint.Join.MITER.ordinal()] = 1;
            iArr3[Paint.Join.BEVEL.ordinal()] = 2;
            iArr3[Paint.Join.ROUND.ordinal()] = 3;
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    @NotNull
    public static final Paint Paint() {
        return new AndroidPaint();
    }

    public static final float getNativeAlpha(@NotNull android.graphics.Paint paint) {
        kotlin.jvm.internal.t.i(paint, "<this>");
        return paint.getAlpha() / 255.0f;
    }

    public static final boolean getNativeAntiAlias(@NotNull android.graphics.Paint paint) {
        kotlin.jvm.internal.t.i(paint, "<this>");
        return paint.isAntiAlias();
    }

    public static final long getNativeColor(@NotNull android.graphics.Paint paint) {
        kotlin.jvm.internal.t.i(paint, "<this>");
        return ColorKt.Color(paint.getColor());
    }

    public static final int getNativeFilterQuality(@NotNull android.graphics.Paint paint) {
        kotlin.jvm.internal.t.i(paint, "<this>");
        return !paint.isFilterBitmap() ? FilterQuality.Companion.m1686getNonefv9h1I() : FilterQuality.Companion.m1684getLowfv9h1I();
    }

    public static final int getNativeStrokeCap(@NotNull android.graphics.Paint paint) {
        kotlin.jvm.internal.t.i(paint, "<this>");
        Paint.Cap strokeCap = paint.getStrokeCap();
        int i10 = strokeCap == null ? -1 : WhenMappings.$EnumSwitchMapping$1[strokeCap.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? StrokeCap.Companion.m1885getButtKaPHkGw() : StrokeCap.Companion.m1887getSquareKaPHkGw() : StrokeCap.Companion.m1886getRoundKaPHkGw() : StrokeCap.Companion.m1885getButtKaPHkGw();
    }

    public static final int getNativeStrokeJoin(@NotNull android.graphics.Paint paint) {
        kotlin.jvm.internal.t.i(paint, "<this>");
        Paint.Join strokeJoin = paint.getStrokeJoin();
        int i10 = strokeJoin == null ? -1 : WhenMappings.$EnumSwitchMapping$2[strokeJoin.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? StrokeJoin.Companion.m1896getMiterLxFBmk8() : StrokeJoin.Companion.m1897getRoundLxFBmk8() : StrokeJoin.Companion.m1895getBevelLxFBmk8() : StrokeJoin.Companion.m1896getMiterLxFBmk8();
    }

    public static final float getNativeStrokeMiterLimit(@NotNull android.graphics.Paint paint) {
        kotlin.jvm.internal.t.i(paint, "<this>");
        return paint.getStrokeMiter();
    }

    public static final float getNativeStrokeWidth(@NotNull android.graphics.Paint paint) {
        kotlin.jvm.internal.t.i(paint, "<this>");
        return paint.getStrokeWidth();
    }

    public static final int getNativeStyle(@NotNull android.graphics.Paint paint) {
        kotlin.jvm.internal.t.i(paint, "<this>");
        Paint.Style style = paint.getStyle();
        return (style == null ? -1 : WhenMappings.$EnumSwitchMapping$0[style.ordinal()]) == 1 ? PaintingStyle.Companion.m1813getStrokeTiuSbCo() : PaintingStyle.Companion.m1812getFillTiuSbCo();
    }

    @NotNull
    public static final android.graphics.Paint makeNativePaint() {
        return new android.graphics.Paint(7);
    }

    public static final void setNativeAlpha(@NotNull android.graphics.Paint paint, float f10) {
        kotlin.jvm.internal.t.i(paint, "<this>");
        paint.setAlpha((int) Math.rint(f10 * 255.0f));
    }

    public static final void setNativeAntiAlias(@NotNull android.graphics.Paint paint, boolean z10) {
        kotlin.jvm.internal.t.i(paint, "<this>");
        paint.setAntiAlias(z10);
    }

    /* JADX INFO: renamed from: setNativeBlendMode-GB0RdKg, reason: not valid java name */
    public static final void m1493setNativeBlendModeGB0RdKg(@NotNull android.graphics.Paint setNativeBlendMode, int i10) {
        kotlin.jvm.internal.t.i(setNativeBlendMode, "$this$setNativeBlendMode");
        if (Build.VERSION.SDK_INT >= 29) {
            WrapperVerificationHelperMethods.INSTANCE.m1935setBlendModeGB0RdKg(setNativeBlendMode, i10);
        } else {
            setNativeBlendMode.setXfermode(new PorterDuffXfermode(AndroidBlendMode_androidKt.m1460toPorterDuffModes9anfk8(i10)));
        }
    }

    /* JADX INFO: renamed from: setNativeColor-4WTKRHQ, reason: not valid java name */
    public static final void m1494setNativeColor4WTKRHQ(@NotNull android.graphics.Paint setNativeColor, long j10) {
        kotlin.jvm.internal.t.i(setNativeColor, "$this$setNativeColor");
        setNativeColor.setColor(ColorKt.m1653toArgb8_81llA(j10));
    }

    public static final void setNativeColorFilter(@NotNull android.graphics.Paint paint, @Nullable ColorFilter colorFilter) {
        kotlin.jvm.internal.t.i(paint, "<this>");
        paint.setColorFilter(colorFilter != null ? AndroidColorFilter_androidKt.asAndroidColorFilter(colorFilter) : null);
    }

    /* JADX INFO: renamed from: setNativeFilterQuality-50PEsBU, reason: not valid java name */
    public static final void m1495setNativeFilterQuality50PEsBU(@NotNull android.graphics.Paint setNativeFilterQuality, int i10) {
        kotlin.jvm.internal.t.i(setNativeFilterQuality, "$this$setNativeFilterQuality");
        setNativeFilterQuality.setFilterBitmap(!FilterQuality.m1679equalsimpl0(i10, FilterQuality.Companion.m1686getNonefv9h1I()));
    }

    public static final void setNativePathEffect(@NotNull android.graphics.Paint paint, @Nullable PathEffect pathEffect) {
        kotlin.jvm.internal.t.i(paint, "<this>");
        AndroidPathEffect androidPathEffect = (AndroidPathEffect) pathEffect;
        paint.setPathEffect(androidPathEffect != null ? androidPathEffect.getNativePathEffect() : null);
    }

    public static final void setNativeShader(@NotNull android.graphics.Paint paint, @Nullable Shader shader) {
        kotlin.jvm.internal.t.i(paint, "<this>");
        paint.setShader(shader);
    }

    /* JADX INFO: renamed from: setNativeStrokeCap-CSYIeUk, reason: not valid java name */
    public static final void m1496setNativeStrokeCapCSYIeUk(@NotNull android.graphics.Paint setNativeStrokeCap, int i10) {
        kotlin.jvm.internal.t.i(setNativeStrokeCap, "$this$setNativeStrokeCap");
        StrokeCap.Companion companion = StrokeCap.Companion;
        setNativeStrokeCap.setStrokeCap(StrokeCap.m1881equalsimpl0(i10, companion.m1887getSquareKaPHkGw()) ? Paint.Cap.SQUARE : StrokeCap.m1881equalsimpl0(i10, companion.m1886getRoundKaPHkGw()) ? Paint.Cap.ROUND : StrokeCap.m1881equalsimpl0(i10, companion.m1885getButtKaPHkGw()) ? Paint.Cap.BUTT : Paint.Cap.BUTT);
    }

    /* JADX INFO: renamed from: setNativeStrokeJoin-kLtJ_vA, reason: not valid java name */
    public static final void m1497setNativeStrokeJoinkLtJ_vA(@NotNull android.graphics.Paint setNativeStrokeJoin, int i10) {
        kotlin.jvm.internal.t.i(setNativeStrokeJoin, "$this$setNativeStrokeJoin");
        StrokeJoin.Companion companion = StrokeJoin.Companion;
        setNativeStrokeJoin.setStrokeJoin(StrokeJoin.m1891equalsimpl0(i10, companion.m1896getMiterLxFBmk8()) ? Paint.Join.MITER : StrokeJoin.m1891equalsimpl0(i10, companion.m1895getBevelLxFBmk8()) ? Paint.Join.BEVEL : StrokeJoin.m1891equalsimpl0(i10, companion.m1897getRoundLxFBmk8()) ? Paint.Join.ROUND : Paint.Join.MITER);
    }

    public static final void setNativeStrokeMiterLimit(@NotNull android.graphics.Paint paint, float f10) {
        kotlin.jvm.internal.t.i(paint, "<this>");
        paint.setStrokeMiter(f10);
    }

    public static final void setNativeStrokeWidth(@NotNull android.graphics.Paint paint, float f10) {
        kotlin.jvm.internal.t.i(paint, "<this>");
        paint.setStrokeWidth(f10);
    }

    /* JADX INFO: renamed from: setNativeStyle--5YerkU, reason: not valid java name */
    public static final void m1498setNativeStyle5YerkU(@NotNull android.graphics.Paint setNativeStyle, int i10) {
        kotlin.jvm.internal.t.i(setNativeStyle, "$this$setNativeStyle");
        setNativeStyle.setStyle(PaintingStyle.m1808equalsimpl0(i10, PaintingStyle.Companion.m1813getStrokeTiuSbCo()) ? Paint.Style.STROKE : Paint.Style.FILL);
    }
}
