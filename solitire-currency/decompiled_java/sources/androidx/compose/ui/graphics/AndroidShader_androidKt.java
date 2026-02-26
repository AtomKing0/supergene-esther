package androidx.compose.ui.graphics;

import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.os.Build;
import androidx.annotation.VisibleForTesting;
import androidx.compose.ui.geometry.Offset;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidShader.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidShader_androidKt {
    @NotNull
    /* JADX INFO: renamed from: ActualImageShader-F49vj9s, reason: not valid java name */
    public static final Shader m1506ActualImageShaderF49vj9s(@NotNull ImageBitmap image, int i10, int i11) {
        kotlin.jvm.internal.t.i(image, "image");
        return new BitmapShader(AndroidImageBitmap_androidKt.asAndroidBitmap(image), AndroidTileMode_androidKt.m1511toAndroidTileMode0vamqd0(i10), AndroidTileMode_androidKt.m1511toAndroidTileMode0vamqd0(i11));
    }

    @NotNull
    /* JADX INFO: renamed from: ActualLinearGradientShader-VjE6UOU, reason: not valid java name */
    public static final Shader m1507ActualLinearGradientShaderVjE6UOU(long j10, long j11, @NotNull List<Color> colors, @Nullable List<Float> list, int i10) {
        kotlin.jvm.internal.t.i(colors, "colors");
        validateColorStops(colors, list);
        int iCountTransparentColors = countTransparentColors(colors);
        return new android.graphics.LinearGradient(Offset.m1367getXimpl(j10), Offset.m1368getYimpl(j10), Offset.m1367getXimpl(j11), Offset.m1368getYimpl(j11), makeTransparentColors(colors, iCountTransparentColors), makeTransparentStops(list, colors, iCountTransparentColors), AndroidTileMode_androidKt.m1511toAndroidTileMode0vamqd0(i10));
    }

    @NotNull
    /* JADX INFO: renamed from: ActualRadialGradientShader-8uybcMk, reason: not valid java name */
    public static final Shader m1508ActualRadialGradientShader8uybcMk(long j10, float f10, @NotNull List<Color> colors, @Nullable List<Float> list, int i10) {
        kotlin.jvm.internal.t.i(colors, "colors");
        validateColorStops(colors, list);
        int iCountTransparentColors = countTransparentColors(colors);
        return new android.graphics.RadialGradient(Offset.m1367getXimpl(j10), Offset.m1368getYimpl(j10), f10, makeTransparentColors(colors, iCountTransparentColors), makeTransparentStops(list, colors, iCountTransparentColors), AndroidTileMode_androidKt.m1511toAndroidTileMode0vamqd0(i10));
    }

    @NotNull
    /* JADX INFO: renamed from: ActualSweepGradientShader-9KIMszo, reason: not valid java name */
    public static final Shader m1509ActualSweepGradientShader9KIMszo(long j10, @NotNull List<Color> colors, @Nullable List<Float> list) {
        kotlin.jvm.internal.t.i(colors, "colors");
        validateColorStops(colors, list);
        int iCountTransparentColors = countTransparentColors(colors);
        return new android.graphics.SweepGradient(Offset.m1367getXimpl(j10), Offset.m1368getYimpl(j10), makeTransparentColors(colors, iCountTransparentColors), makeTransparentStops(list, colors, iCountTransparentColors));
    }

    @VisibleForTesting
    public static final int countTransparentColors(@NotNull List<Color> colors) {
        kotlin.jvm.internal.t.i(colors, "colors");
        if (Build.VERSION.SDK_INT >= 26) {
            return 0;
        }
        int iM = kotlin.collections.v.m(colors);
        int i10 = 0;
        for (int i11 = 1; i11 < iM; i11++) {
            if (Color.m1600getAlphaimpl(colors.get(i11).m1608unboximpl()) == 0.0f) {
                i10++;
            }
        }
        return i10;
    }

    @VisibleForTesting
    @NotNull
    public static final int[] makeTransparentColors(@NotNull List<Color> colors, int i10) {
        int i11;
        kotlin.jvm.internal.t.i(colors, "colors");
        if (Build.VERSION.SDK_INT >= 26) {
            int size = colors.size();
            int[] iArr = new int[size];
            for (int i12 = 0; i12 < size; i12++) {
                iArr[i12] = ColorKt.m1653toArgb8_81llA(colors.get(i12).m1608unboximpl());
            }
            return iArr;
        }
        int[] iArr2 = new int[colors.size() + i10];
        int iM = kotlin.collections.v.m(colors);
        int size2 = colors.size();
        int i13 = 0;
        for (int i14 = 0; i14 < size2; i14++) {
            long jM1608unboximpl = colors.get(i14).m1608unboximpl();
            if (Color.m1600getAlphaimpl(jM1608unboximpl) == 0.0f) {
                if (i14 == 0) {
                    i11 = i13 + 1;
                    iArr2[i13] = ColorKt.m1653toArgb8_81llA(Color.m1597copywmQWz5c$default(colors.get(1).m1608unboximpl(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null));
                } else if (i14 == iM) {
                    i11 = i13 + 1;
                    iArr2[i13] = ColorKt.m1653toArgb8_81llA(Color.m1597copywmQWz5c$default(colors.get(i14 - 1).m1608unboximpl(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null));
                } else {
                    int i15 = i13 + 1;
                    iArr2[i13] = ColorKt.m1653toArgb8_81llA(Color.m1597copywmQWz5c$default(colors.get(i14 - 1).m1608unboximpl(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null));
                    i13 = i15 + 1;
                    iArr2[i15] = ColorKt.m1653toArgb8_81llA(Color.m1597copywmQWz5c$default(colors.get(i14 + 1).m1608unboximpl(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null));
                }
                i13 = i11;
            } else {
                iArr2[i13] = ColorKt.m1653toArgb8_81llA(jM1608unboximpl);
                i13++;
            }
        }
        return iArr2;
    }

    @VisibleForTesting
    @Nullable
    public static final float[] makeTransparentStops(@Nullable List<Float> list, @NotNull List<Color> colors, int i10) {
        kotlin.jvm.internal.t.i(colors, "colors");
        if (i10 == 0) {
            if (list != null) {
                return kotlin.collections.d0.M0(list);
            }
            return null;
        }
        float[] fArr = new float[colors.size() + i10];
        fArr[0] = list != null ? list.get(0).floatValue() : 0.0f;
        int iM = kotlin.collections.v.m(colors);
        int i11 = 1;
        for (int i12 = 1; i12 < iM; i12++) {
            long jM1608unboximpl = colors.get(i12).m1608unboximpl();
            float fFloatValue = list != null ? list.get(i12).floatValue() : i12 / kotlin.collections.v.m(colors);
            int i13 = i11 + 1;
            fArr[i11] = fFloatValue;
            if (Color.m1600getAlphaimpl(jM1608unboximpl) == 0.0f) {
                i11 = i13 + 1;
                fArr[i13] = fFloatValue;
            } else {
                i11 = i13;
            }
        }
        fArr[i11] = list != null ? list.get(kotlin.collections.v.m(colors)).floatValue() : 1.0f;
        return fArr;
    }

    private static final void validateColorStops(List<Color> list, List<Float> list2) {
        if (list2 == null) {
            if (list.size() < 2) {
                throw new IllegalArgumentException("colors must have length of at least 2 if colorStops is omitted.");
            }
        } else if (list.size() != list2.size()) {
            throw new IllegalArgumentException("colors and colorStops arguments must have equal length.");
        }
    }
}
