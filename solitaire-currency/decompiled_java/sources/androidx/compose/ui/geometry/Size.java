package androidx.compose.ui.geometry;

import androidx.compose.animation.a;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Size.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class Size {
    private final long packedValue;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long Zero = SizeKt.Size(0.0f, 0.0f);
    private static final long Unspecified = SizeKt.Size(Float.NaN, Float.NaN);

    private /* synthetic */ Size(long j10) {
        this.packedValue = j10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Size m1424boximpl(long j10) {
        return new Size(j10);
    }

    @Stable
    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final float m1425component1impl(long j10) {
        return m1436getWidthimpl(j10);
    }

    @Stable
    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final float m1426component2impl(long j10) {
        return m1433getHeightimpl(j10);
    }

    /* JADX INFO: renamed from: copy-xjbvk4A, reason: not valid java name */
    public static final long m1428copyxjbvk4A(long j10, float f10, float f11) {
        return SizeKt.Size(f10, f11);
    }

    /* JADX INFO: renamed from: copy-xjbvk4A$default, reason: not valid java name */
    public static /* synthetic */ long m1429copyxjbvk4A$default(long j10, float f10, float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = m1436getWidthimpl(j10);
        }
        if ((i10 & 2) != 0) {
            f11 = m1433getHeightimpl(j10);
        }
        return m1428copyxjbvk4A(j10, f10, f11);
    }

    @Stable
    /* JADX INFO: renamed from: div-7Ah8Wj8, reason: not valid java name */
    public static final long m1430div7Ah8Wj8(long j10, float f10) {
        return SizeKt.Size(m1436getWidthimpl(j10) / f10, m1433getHeightimpl(j10) / f10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1431equalsimpl(long j10, Object obj) {
        return (obj instanceof Size) && j10 == ((Size) obj).m1441unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1432equalsimpl0(long j10, long j11) {
        return j10 == j11;
    }

    /* JADX INFO: renamed from: getHeight-impl, reason: not valid java name */
    public static final float m1433getHeightimpl(long j10) {
        if (!(j10 != Unspecified)) {
            throw new IllegalStateException("Size is unspecified".toString());
        }
        m mVar = m.f29832a;
        return Float.intBitsToFloat((int) (j10 & 4294967295L));
    }

    /* JADX INFO: renamed from: getMaxDimension-impl, reason: not valid java name */
    public static final float m1434getMaxDimensionimpl(long j10) {
        return Math.max(Math.abs(m1436getWidthimpl(j10)), Math.abs(m1433getHeightimpl(j10)));
    }

    /* JADX INFO: renamed from: getMinDimension-impl, reason: not valid java name */
    public static final float m1435getMinDimensionimpl(long j10) {
        return Math.min(Math.abs(m1436getWidthimpl(j10)), Math.abs(m1433getHeightimpl(j10)));
    }

    /* JADX INFO: renamed from: getWidth-impl, reason: not valid java name */
    public static final float m1436getWidthimpl(long j10) {
        if (!(j10 != Unspecified)) {
            throw new IllegalStateException("Size is unspecified".toString());
        }
        m mVar = m.f29832a;
        return Float.intBitsToFloat((int) (j10 >> 32));
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1437hashCodeimpl(long j10) {
        return a.a(j10);
    }

    @Stable
    /* JADX INFO: renamed from: isEmpty-impl, reason: not valid java name */
    public static final boolean m1438isEmptyimpl(long j10) {
        return m1436getWidthimpl(j10) <= 0.0f || m1433getHeightimpl(j10) <= 0.0f;
    }

    @Stable
    /* JADX INFO: renamed from: times-7Ah8Wj8, reason: not valid java name */
    public static final long m1439times7Ah8Wj8(long j10, float f10) {
        return SizeKt.Size(m1436getWidthimpl(j10) * f10, m1433getHeightimpl(j10) * f10);
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1440toStringimpl(long j10) {
        if (!(j10 != Companion.m1444getUnspecifiedNHjbRc())) {
            return "Size.Unspecified";
        }
        return "Size(" + GeometryUtilsKt.toStringAsFixed(m1436getWidthimpl(j10), 1) + ", " + GeometryUtilsKt.toStringAsFixed(m1433getHeightimpl(j10), 1) + ')';
    }

    public boolean equals(Object obj) {
        return m1431equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m1437hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m1440toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m1441unboximpl() {
        return this.packedValue;
    }

    /* JADX INFO: compiled from: Size.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getUnspecified-NH-jbRc, reason: not valid java name */
        public final long m1444getUnspecifiedNHjbRc() {
            return Size.Unspecified;
        }

        /* JADX INFO: renamed from: getZero-NH-jbRc, reason: not valid java name */
        public final long m1445getZeroNHjbRc() {
            return Size.Zero;
        }

        @Stable
        /* JADX INFO: renamed from: getUnspecified-NH-jbRc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1442getUnspecifiedNHjbRc$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getZero-NH-jbRc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1443getZeroNHjbRc$annotations() {
        }
    }

    @Stable
    public static /* synthetic */ void getHeight$annotations() {
    }

    @Stable
    public static /* synthetic */ void getMaxDimension$annotations() {
    }

    @Stable
    public static /* synthetic */ void getMinDimension$annotations() {
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    @Stable
    public static /* synthetic */ void getWidth$annotations() {
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m1427constructorimpl(long j10) {
        return j10;
    }
}
