package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Bitmap.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BitmapKt {
    @NotNull
    public static final Bitmap applyCanvas(@NotNull Bitmap bitmap, @NotNull h9.l<? super Canvas, v8.k0> lVar) {
        lVar.invoke(new Canvas(bitmap));
        return bitmap;
    }

    public static final boolean contains(@NotNull Bitmap bitmap, @NotNull Point point) {
        int i10;
        int width = bitmap.getWidth();
        int i11 = point.x;
        return (i11 >= 0 && i11 < width) && (i10 = point.y) >= 0 && i10 < bitmap.getHeight();
    }

    @NotNull
    public static final Bitmap createBitmap(int i10, int i11, @NotNull Bitmap.Config config) {
        return Bitmap.createBitmap(i10, i11, config);
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i10, int i11, Bitmap.Config config, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return Bitmap.createBitmap(i10, i11, config);
    }

    public static final int get(@NotNull Bitmap bitmap, int i10, int i11) {
        return bitmap.getPixel(i10, i11);
    }

    @NotNull
    public static final Bitmap scale(@NotNull Bitmap bitmap, int i10, int i11, boolean z10) {
        return Bitmap.createScaledBitmap(bitmap, i10, i11, z10);
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap bitmap, int i10, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            z10 = true;
        }
        return Bitmap.createScaledBitmap(bitmap, i10, i11, z10);
    }

    public static final void set(@NotNull Bitmap bitmap, int i10, int i11, @ColorInt int i12) {
        bitmap.setPixel(i10, i11, i12);
    }

    public static final boolean contains(@NotNull Bitmap bitmap, @NotNull PointF pointF) {
        float f10 = pointF.x;
        if (f10 >= 0.0f && f10 < bitmap.getWidth()) {
            float f11 = pointF.y;
            if (f11 >= 0.0f && f11 < bitmap.getHeight()) {
                return true;
            }
        }
        return false;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    @NotNull
    public static final Bitmap createBitmap(int i10, int i11, @NotNull Bitmap.Config config, boolean z10, @NotNull ColorSpace colorSpace) {
        return Bitmap.createBitmap(i10, i11, config, z10, colorSpace);
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i10, int i11, Bitmap.Config config, boolean z10, ColorSpace colorSpace, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i12 & 8) != 0) {
            z10 = true;
        }
        if ((i12 & 16) != 0) {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        return Bitmap.createBitmap(i10, i11, config, z10, colorSpace);
    }
}
