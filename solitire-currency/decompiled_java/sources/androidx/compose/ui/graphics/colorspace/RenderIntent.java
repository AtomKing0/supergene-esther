package androidx.compose.ui.graphics.colorspace;

import androidx.compose.runtime.Immutable;
import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RenderIntent.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class RenderIntent {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Perceptual = m1956constructorimpl(0);
    private static final int Relative = m1956constructorimpl(1);
    private static final int Saturation = m1956constructorimpl(2);
    private static final int Absolute = m1956constructorimpl(3);

    /* JADX INFO: compiled from: RenderIntent.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getAbsolute-uksYyKA, reason: not valid java name */
        public final int m1962getAbsoluteuksYyKA() {
            return RenderIntent.Absolute;
        }

        /* JADX INFO: renamed from: getPerceptual-uksYyKA, reason: not valid java name */
        public final int m1963getPerceptualuksYyKA() {
            return RenderIntent.Perceptual;
        }

        /* JADX INFO: renamed from: getRelative-uksYyKA, reason: not valid java name */
        public final int m1964getRelativeuksYyKA() {
            return RenderIntent.Relative;
        }

        /* JADX INFO: renamed from: getSaturation-uksYyKA, reason: not valid java name */
        public final int m1965getSaturationuksYyKA() {
            return RenderIntent.Saturation;
        }
    }

    private /* synthetic */ RenderIntent(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ RenderIntent m1955boximpl(int i10) {
        return new RenderIntent(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1957equalsimpl(int i10, Object obj) {
        return (obj instanceof RenderIntent) && i10 == ((RenderIntent) obj).m1961unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1958equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1960toStringimpl(int i10) {
        return m1958equalsimpl0(i10, Perceptual) ? "Perceptual" : m1958equalsimpl0(i10, Relative) ? "Relative" : m1958equalsimpl0(i10, Saturation) ? ExifInterface.TAG_SATURATION : m1958equalsimpl0(i10, Absolute) ? "Absolute" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m1957equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1959hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1960toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1961unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1956constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1959hashCodeimpl(int i10) {
        return i10;
    }
}
