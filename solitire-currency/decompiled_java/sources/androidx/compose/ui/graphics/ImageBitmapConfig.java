package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ImageBitmap.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class ImageBitmapConfig {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Argb8888 = m1761constructorimpl(0);
    private static final int Alpha8 = m1761constructorimpl(1);
    private static final int Rgb565 = m1761constructorimpl(2);
    private static final int F16 = m1761constructorimpl(3);
    private static final int Gpu = m1761constructorimpl(4);

    /* JADX INFO: compiled from: ImageBitmap.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getAlpha8-_sVssgQ, reason: not valid java name */
        public final int m1767getAlpha8_sVssgQ() {
            return ImageBitmapConfig.Alpha8;
        }

        /* JADX INFO: renamed from: getArgb8888-_sVssgQ, reason: not valid java name */
        public final int m1768getArgb8888_sVssgQ() {
            return ImageBitmapConfig.Argb8888;
        }

        /* JADX INFO: renamed from: getF16-_sVssgQ, reason: not valid java name */
        public final int m1769getF16_sVssgQ() {
            return ImageBitmapConfig.F16;
        }

        /* JADX INFO: renamed from: getGpu-_sVssgQ, reason: not valid java name */
        public final int m1770getGpu_sVssgQ() {
            return ImageBitmapConfig.Gpu;
        }

        /* JADX INFO: renamed from: getRgb565-_sVssgQ, reason: not valid java name */
        public final int m1771getRgb565_sVssgQ() {
            return ImageBitmapConfig.Rgb565;
        }
    }

    private /* synthetic */ ImageBitmapConfig(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ImageBitmapConfig m1760boximpl(int i10) {
        return new ImageBitmapConfig(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1762equalsimpl(int i10, Object obj) {
        return (obj instanceof ImageBitmapConfig) && i10 == ((ImageBitmapConfig) obj).m1766unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1763equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1765toStringimpl(int i10) {
        return m1763equalsimpl0(i10, Argb8888) ? "Argb8888" : m1763equalsimpl0(i10, Alpha8) ? "Alpha8" : m1763equalsimpl0(i10, Rgb565) ? "Rgb565" : m1763equalsimpl0(i10, F16) ? "F16" : m1763equalsimpl0(i10, Gpu) ? "Gpu" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m1762equalsimpl(this.value, obj);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m1764hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1765toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1766unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1761constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1764hashCodeimpl(int i10) {
        return i10;
    }
}
