package androidx.compose.ui.graphics.colorspace;

import androidx.compose.animation.a;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ColorModel.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class ColorModel {
    private static final long Cmyk;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long Lab;
    private static final long Rgb;
    private static final long Xyz;
    private final long packedValue;

    /* JADX INFO: compiled from: ColorModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getCmyk-xdoWZVw, reason: not valid java name */
        public final long m1944getCmykxdoWZVw() {
            return ColorModel.Cmyk;
        }

        /* JADX INFO: renamed from: getLab-xdoWZVw, reason: not valid java name */
        public final long m1945getLabxdoWZVw() {
            return ColorModel.Lab;
        }

        /* JADX INFO: renamed from: getRgb-xdoWZVw, reason: not valid java name */
        public final long m1946getRgbxdoWZVw() {
            return ColorModel.Rgb;
        }

        /* JADX INFO: renamed from: getXyz-xdoWZVw, reason: not valid java name */
        public final long m1947getXyzxdoWZVw() {
            return ColorModel.Xyz;
        }
    }

    static {
        long j10 = 3;
        long j11 = j10 << 32;
        Rgb = m1937constructorimpl((((long) 0) & 4294967295L) | j11);
        Xyz = m1937constructorimpl((((long) 1) & 4294967295L) | j11);
        Lab = m1937constructorimpl(j11 | (((long) 2) & 4294967295L));
        Cmyk = m1937constructorimpl((j10 & 4294967295L) | (((long) 4) << 32));
    }

    private /* synthetic */ ColorModel(long j10) {
        this.packedValue = j10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ColorModel m1936boximpl(long j10) {
        return new ColorModel(j10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1938equalsimpl(long j10, Object obj) {
        return (obj instanceof ColorModel) && j10 == ((ColorModel) obj).m1943unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1939equalsimpl0(long j10, long j11) {
        return j10 == j11;
    }

    /* JADX INFO: renamed from: getComponentCount-impl, reason: not valid java name */
    public static final int m1940getComponentCountimpl(long j10) {
        return (int) (j10 >> 32);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1941hashCodeimpl(long j10) {
        return a.a(j10);
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1942toStringimpl(long j10) {
        return m1939equalsimpl0(j10, Rgb) ? "Rgb" : m1939equalsimpl0(j10, Xyz) ? "Xyz" : m1939equalsimpl0(j10, Lab) ? "Lab" : m1939equalsimpl0(j10, Cmyk) ? "Cmyk" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m1938equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m1941hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m1942toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m1943unboximpl() {
        return this.packedValue;
    }

    @Stable
    public static /* synthetic */ void getComponentCount$annotations() {
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m1937constructorimpl(long j10) {
        return j10;
    }
}
