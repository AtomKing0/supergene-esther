package a0;

import android.graphics.Bitmap;
import android.os.Build;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Bitmaps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final int a(@NotNull Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (Exception unused) {
                return b(bitmap.getConfig()) * bitmap.getWidth() * bitmap.getHeight();
            }
        }
        throw new IllegalStateException(("Cannot obtain size for recycled bitmap: " + bitmap + " [" + bitmap.getWidth() + " x " + bitmap.getHeight() + "] + " + bitmap.getConfig()).toString());
    }

    public static final int b(@Nullable Bitmap.Config config) {
        if (config == Bitmap.Config.ALPHA_8) {
            return 1;
        }
        if (config == Bitmap.Config.RGB_565 || config == Bitmap.Config.ARGB_4444) {
            return 2;
        }
        return (Build.VERSION.SDK_INT < 26 || config != Bitmap.Config.RGBA_F16) ? 4 : 8;
    }

    @NotNull
    public static final Bitmap.Config c(@NotNull Bitmap bitmap) {
        Bitmap.Config config = bitmap.getConfig();
        return config == null ? Bitmap.Config.ARGB_8888 : config;
    }

    public static final boolean d(@NotNull Bitmap.Config config) {
        return Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE;
    }

    @NotNull
    public static final Bitmap.Config e(@Nullable Bitmap.Config config) {
        return (config == null || d(config)) ? Bitmap.Config.ARGB_8888 : config;
    }
}
