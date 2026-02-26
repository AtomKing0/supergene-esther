package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorSpace;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ImageBitmap.kt */
/* JADX INFO: loaded from: classes.dex */
public interface ImageBitmap {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: ImageBitmap.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: ImageBitmap.kt */
    public static final class DefaultImpls {
    }

    @NotNull
    ColorSpace getColorSpace();

    /* JADX INFO: renamed from: getConfig-_sVssgQ */
    int mo1476getConfig_sVssgQ();

    boolean getHasAlpha();

    int getHeight();

    int getWidth();

    void prepareToDraw();

    void readPixels(@NotNull int[] iArr, int i10, int i11, int i12, int i13, int i14, int i15);
}
