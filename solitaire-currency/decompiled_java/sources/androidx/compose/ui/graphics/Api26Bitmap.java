package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.util.DisplayMetrics;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidImageBitmap.android.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
final class Api26Bitmap {

    @NotNull
    public static final Api26Bitmap INSTANCE = new Api26Bitmap();

    private Api26Bitmap() {
    }

    @DoNotInline
    @NotNull
    public static final ColorSpace composeColorSpace$ui_graphics_release(@NotNull Bitmap bitmap) {
        ColorSpace colorSpaceComposeColorSpace$ui_graphics_release;
        kotlin.jvm.internal.t.i(bitmap, "<this>");
        android.graphics.ColorSpace colorSpace = bitmap.getColorSpace();
        return (colorSpace == null || (colorSpaceComposeColorSpace$ui_graphics_release = composeColorSpace$ui_graphics_release(colorSpace)) == null) ? ColorSpaces.INSTANCE.getSrgb() : colorSpaceComposeColorSpace$ui_graphics_release;
    }

    @DoNotInline
    @NotNull
    /* JADX INFO: renamed from: createBitmap-x__-hDU$ui_graphics_release, reason: not valid java name */
    public static final Bitmap m1513createBitmapx__hDU$ui_graphics_release(int i10, int i11, int i12, boolean z10, @NotNull ColorSpace colorSpace) {
        kotlin.jvm.internal.t.i(colorSpace, "colorSpace");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((DisplayMetrics) null, i10, i11, AndroidImageBitmap_androidKt.m1478toBitmapConfig1JJdX4A(i12), z10, toFrameworkColorSpace$ui_graphics_release(colorSpace));
        kotlin.jvm.internal.t.h(bitmapCreateBitmap, "createBitmap(\n          …orkColorSpace()\n        )");
        return bitmapCreateBitmap;
    }

    @DoNotInline
    @NotNull
    public static final android.graphics.ColorSpace toFrameworkColorSpace$ui_graphics_release(@NotNull ColorSpace colorSpace) {
        kotlin.jvm.internal.t.i(colorSpace, "<this>");
        ColorSpaces colorSpaces = ColorSpaces.INSTANCE;
        android.graphics.ColorSpace colorSpace2 = android.graphics.ColorSpace.get(kotlin.jvm.internal.t.d(colorSpace, colorSpaces.getSrgb()) ? ColorSpace.Named.SRGB : kotlin.jvm.internal.t.d(colorSpace, colorSpaces.getAces()) ? ColorSpace.Named.ACES : kotlin.jvm.internal.t.d(colorSpace, colorSpaces.getAcescg()) ? ColorSpace.Named.ACESCG : kotlin.jvm.internal.t.d(colorSpace, colorSpaces.getAdobeRgb()) ? ColorSpace.Named.ADOBE_RGB : kotlin.jvm.internal.t.d(colorSpace, colorSpaces.getBt2020()) ? ColorSpace.Named.BT2020 : kotlin.jvm.internal.t.d(colorSpace, colorSpaces.getBt709()) ? ColorSpace.Named.BT709 : kotlin.jvm.internal.t.d(colorSpace, colorSpaces.getCieLab()) ? ColorSpace.Named.CIE_LAB : kotlin.jvm.internal.t.d(colorSpace, colorSpaces.getCieXyz()) ? ColorSpace.Named.CIE_XYZ : kotlin.jvm.internal.t.d(colorSpace, colorSpaces.getDciP3()) ? ColorSpace.Named.DCI_P3 : kotlin.jvm.internal.t.d(colorSpace, colorSpaces.getDisplayP3()) ? ColorSpace.Named.DISPLAY_P3 : kotlin.jvm.internal.t.d(colorSpace, colorSpaces.getExtendedSrgb()) ? ColorSpace.Named.EXTENDED_SRGB : kotlin.jvm.internal.t.d(colorSpace, colorSpaces.getLinearExtendedSrgb()) ? ColorSpace.Named.LINEAR_EXTENDED_SRGB : kotlin.jvm.internal.t.d(colorSpace, colorSpaces.getLinearSrgb()) ? ColorSpace.Named.LINEAR_SRGB : kotlin.jvm.internal.t.d(colorSpace, colorSpaces.getNtsc1953()) ? ColorSpace.Named.NTSC_1953 : kotlin.jvm.internal.t.d(colorSpace, colorSpaces.getProPhotoRgb()) ? ColorSpace.Named.PRO_PHOTO_RGB : kotlin.jvm.internal.t.d(colorSpace, colorSpaces.getSmpteC()) ? ColorSpace.Named.SMPTE_C : ColorSpace.Named.SRGB);
        kotlin.jvm.internal.t.h(colorSpace2, "get(frameworkNamedSpace)");
        return colorSpace2;
    }

    @DoNotInline
    @NotNull
    public static final androidx.compose.ui.graphics.colorspace.ColorSpace composeColorSpace$ui_graphics_release(@NotNull android.graphics.ColorSpace colorSpace) {
        kotlin.jvm.internal.t.i(colorSpace, "<this>");
        return kotlin.jvm.internal.t.d(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.SRGB)) ? ColorSpaces.INSTANCE.getSrgb() : kotlin.jvm.internal.t.d(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.ACES)) ? ColorSpaces.INSTANCE.getAces() : kotlin.jvm.internal.t.d(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.ACESCG)) ? ColorSpaces.INSTANCE.getAcescg() : kotlin.jvm.internal.t.d(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.ADOBE_RGB)) ? ColorSpaces.INSTANCE.getAdobeRgb() : kotlin.jvm.internal.t.d(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.BT2020)) ? ColorSpaces.INSTANCE.getBt2020() : kotlin.jvm.internal.t.d(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.BT709)) ? ColorSpaces.INSTANCE.getBt709() : kotlin.jvm.internal.t.d(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.CIE_LAB)) ? ColorSpaces.INSTANCE.getCieLab() : kotlin.jvm.internal.t.d(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.CIE_XYZ)) ? ColorSpaces.INSTANCE.getCieXyz() : kotlin.jvm.internal.t.d(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.DCI_P3)) ? ColorSpaces.INSTANCE.getDciP3() : kotlin.jvm.internal.t.d(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.DISPLAY_P3)) ? ColorSpaces.INSTANCE.getDisplayP3() : kotlin.jvm.internal.t.d(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.EXTENDED_SRGB)) ? ColorSpaces.INSTANCE.getExtendedSrgb() : kotlin.jvm.internal.t.d(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB)) ? ColorSpaces.INSTANCE.getLinearExtendedSrgb() : kotlin.jvm.internal.t.d(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.LINEAR_SRGB)) ? ColorSpaces.INSTANCE.getLinearSrgb() : kotlin.jvm.internal.t.d(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.NTSC_1953)) ? ColorSpaces.INSTANCE.getNtsc1953() : kotlin.jvm.internal.t.d(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.PRO_PHOTO_RGB)) ? ColorSpaces.INSTANCE.getProPhotoRgb() : kotlin.jvm.internal.t.d(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.SMPTE_C)) ? ColorSpaces.INSTANCE.getSmpteC() : ColorSpaces.INSTANCE.getSrgb();
    }
}
