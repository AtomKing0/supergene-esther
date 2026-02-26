package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BitmapPainter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BitmapPainterKt {
    @NotNull
    /* JADX INFO: renamed from: BitmapPainter-QZhYCtY, reason: not valid java name */
    public static final BitmapPainter m2091BitmapPainterQZhYCtY(@NotNull ImageBitmap image, long j10, long j11, int i10) {
        t.i(image, "image");
        BitmapPainter bitmapPainter = new BitmapPainter(image, j10, j11, null);
        bitmapPainter.m2090setFilterQualityvDHp3xo$ui_graphics_release(i10);
        return bitmapPainter;
    }

    /* JADX INFO: renamed from: BitmapPainter-QZhYCtY$default, reason: not valid java name */
    public static /* synthetic */ BitmapPainter m2092BitmapPainterQZhYCtY$default(ImageBitmap imageBitmap, long j10, long j11, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j10 = IntOffset.Companion.m3801getZeronOccac();
        }
        long j12 = j10;
        if ((i11 & 4) != 0) {
            j11 = IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight());
        }
        long j13 = j11;
        if ((i11 & 8) != 0) {
            i10 = FilterQuality.Companion.m1684getLowfv9h1I();
        }
        return m2091BitmapPainterQZhYCtY(imageBitmap, j12, j13, i10);
    }
}
