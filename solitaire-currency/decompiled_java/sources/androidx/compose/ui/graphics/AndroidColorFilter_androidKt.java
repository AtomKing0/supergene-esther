package androidx.compose.ui.graphics;

import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidColorFilter.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidColorFilter_androidKt {
    @NotNull
    /* JADX INFO: renamed from: actualColorMatrixColorFilter-jHG-Opc, reason: not valid java name */
    public static final ColorFilter m1473actualColorMatrixColorFilterjHGOpc(@NotNull float[] colorMatrix) {
        kotlin.jvm.internal.t.i(colorMatrix, "colorMatrix");
        return new ColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }

    @NotNull
    /* JADX INFO: renamed from: actualLightingColorFilter--OWjLjI, reason: not valid java name */
    public static final ColorFilter m1474actualLightingColorFilterOWjLjI(long j10, long j11) {
        return new ColorFilter(new LightingColorFilter(ColorKt.m1653toArgb8_81llA(j10), ColorKt.m1653toArgb8_81llA(j11)));
    }

    @NotNull
    /* JADX INFO: renamed from: actualTintColorFilter-xETnrds, reason: not valid java name */
    public static final ColorFilter m1475actualTintColorFilterxETnrds(long j10, int i10) {
        return new ColorFilter(Build.VERSION.SDK_INT >= 29 ? BlendModeColorFilterHelper.INSTANCE.m1550BlendModeColorFilterxETnrds(j10, i10) : new PorterDuffColorFilter(ColorKt.m1653toArgb8_81llA(j10), AndroidBlendMode_androidKt.m1460toPorterDuffModes9anfk8(i10)));
    }

    @NotNull
    public static final android.graphics.ColorFilter asAndroidColorFilter(@NotNull ColorFilter colorFilter) {
        kotlin.jvm.internal.t.i(colorFilter, "<this>");
        return colorFilter.getNativeColorFilter$ui_graphics_release();
    }

    @NotNull
    public static final ColorFilter asComposeColorFilter(@NotNull android.graphics.ColorFilter colorFilter) {
        kotlin.jvm.internal.t.i(colorFilter, "<this>");
        return new ColorFilter(colorFilter);
    }
}
