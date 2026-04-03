package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.ImageBitmap;

/* JADX INFO: compiled from: ImageBitmap.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e1 {
    static {
        ImageBitmap.Companion companion = ImageBitmap.Companion;
    }

    public static /* synthetic */ void a(ImageBitmap imageBitmap, int[] iArr, int i10, int i11, int i12, int i13, int i14, int i15, int i16, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readPixels");
        }
        int i17 = (i16 & 2) != 0 ? 0 : i10;
        int i18 = (i16 & 4) != 0 ? 0 : i11;
        int width = (i16 & 8) != 0 ? imageBitmap.getWidth() : i12;
        imageBitmap.readPixels(iArr, i17, i18, width, (i16 & 16) != 0 ? imageBitmap.getHeight() : i13, (i16 & 32) == 0 ? i14 : 0, (i16 & 64) != 0 ? width : i15);
    }
}
