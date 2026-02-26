package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidImageBitmap.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidImageBitmap_androidKt {
    @NotNull
    /* JADX INFO: renamed from: ActualImageBitmap-x__-hDU, reason: not valid java name */
    public static final ImageBitmap m1477ActualImageBitmapx__hDU(int i10, int i11, int i12, boolean z10, @NotNull ColorSpace colorSpace) {
        Bitmap bitmapCreateBitmap;
        kotlin.jvm.internal.t.i(colorSpace, "colorSpace");
        Bitmap.Config configM1478toBitmapConfig1JJdX4A = m1478toBitmapConfig1JJdX4A(i12);
        if (Build.VERSION.SDK_INT >= 26) {
            bitmapCreateBitmap = Api26Bitmap.m1513createBitmapx__hDU$ui_graphics_release(i10, i11, i12, z10, colorSpace);
        } else {
            bitmapCreateBitmap = Bitmap.createBitmap((DisplayMetrics) null, i10, i11, configM1478toBitmapConfig1JJdX4A);
            kotlin.jvm.internal.t.h(bitmapCreateBitmap, "createBitmap(\n          …   bitmapConfig\n        )");
            bitmapCreateBitmap.setHasAlpha(z10);
        }
        return new AndroidImageBitmap(bitmapCreateBitmap);
    }

    @NotNull
    public static final Bitmap asAndroidBitmap(@NotNull ImageBitmap imageBitmap) {
        kotlin.jvm.internal.t.i(imageBitmap, "<this>");
        if (imageBitmap instanceof AndroidImageBitmap) {
            return ((AndroidImageBitmap) imageBitmap).getBitmap$ui_graphics_release();
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Bitmap");
    }

    @NotNull
    public static final ImageBitmap asImageBitmap(@NotNull Bitmap bitmap) {
        kotlin.jvm.internal.t.i(bitmap, "<this>");
        return new AndroidImageBitmap(bitmap);
    }

    @NotNull
    /* JADX INFO: renamed from: toBitmapConfig-1JJdX4A, reason: not valid java name */
    public static final Bitmap.Config m1478toBitmapConfig1JJdX4A(int i10) {
        ImageBitmapConfig.Companion companion = ImageBitmapConfig.Companion;
        if (ImageBitmapConfig.m1763equalsimpl0(i10, companion.m1768getArgb8888_sVssgQ())) {
            return Bitmap.Config.ARGB_8888;
        }
        if (ImageBitmapConfig.m1763equalsimpl0(i10, companion.m1767getAlpha8_sVssgQ())) {
            return Bitmap.Config.ALPHA_8;
        }
        if (ImageBitmapConfig.m1763equalsimpl0(i10, companion.m1771getRgb565_sVssgQ())) {
            return Bitmap.Config.RGB_565;
        }
        int i11 = Build.VERSION.SDK_INT;
        return (i11 < 26 || !ImageBitmapConfig.m1763equalsimpl0(i10, companion.m1769getF16_sVssgQ())) ? (i11 < 26 || !ImageBitmapConfig.m1763equalsimpl0(i10, companion.m1770getGpu_sVssgQ())) ? Bitmap.Config.ARGB_8888 : Bitmap.Config.HARDWARE : Bitmap.Config.RGBA_F16;
    }

    public static final int toImageConfig(@NotNull Bitmap.Config config) {
        kotlin.jvm.internal.t.i(config, "<this>");
        if (config == Bitmap.Config.ALPHA_8) {
            return ImageBitmapConfig.Companion.m1767getAlpha8_sVssgQ();
        }
        if (config == Bitmap.Config.RGB_565) {
            return ImageBitmapConfig.Companion.m1771getRgb565_sVssgQ();
        }
        if (config == Bitmap.Config.ARGB_4444) {
            return ImageBitmapConfig.Companion.m1768getArgb8888_sVssgQ();
        }
        int i10 = Build.VERSION.SDK_INT;
        return (i10 < 26 || config != Bitmap.Config.RGBA_F16) ? (i10 < 26 || config != Bitmap.Config.HARDWARE) ? ImageBitmapConfig.Companion.m1768getArgb8888_sVssgQ() : ImageBitmapConfig.Companion.m1770getGpu_sVssgQ() : ImageBitmapConfig.Companion.m1769getF16_sVssgQ();
    }
}
