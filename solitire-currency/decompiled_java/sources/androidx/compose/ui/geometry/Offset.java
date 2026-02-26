package androidx.compose.ui.geometry;

import androidx.compose.animation.a;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Offset.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class Offset {
    private final long packedValue;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long Zero = OffsetKt.Offset(0.0f, 0.0f);
    private static final long Infinite = OffsetKt.Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    private static final long Unspecified = OffsetKt.Offset(Float.NaN, Float.NaN);

    private /* synthetic */ Offset(long j10) {
        this.packedValue = j10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Offset m1356boximpl(long j10) {
        return new Offset(j10);
    }

    @Stable
    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final float m1357component1impl(long j10) {
        return m1367getXimpl(j10);
    }

    @Stable
    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final float m1358component2impl(long j10) {
        return m1368getYimpl(j10);
    }

    /* JADX INFO: renamed from: copy-dBAh8RU, reason: not valid java name */
    public static final long m1360copydBAh8RU(long j10, float f10, float f11) {
        return OffsetKt.Offset(f10, f11);
    }

    /* JADX INFO: renamed from: copy-dBAh8RU$default, reason: not valid java name */
    public static /* synthetic */ long m1361copydBAh8RU$default(long j10, float f10, float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = m1367getXimpl(j10);
        }
        if ((i10 & 2) != 0) {
            f11 = m1368getYimpl(j10);
        }
        return m1360copydBAh8RU(j10, f10, f11);
    }

    @Stable
    /* JADX INFO: renamed from: div-tuRUvjQ, reason: not valid java name */
    public static final long m1362divtuRUvjQ(long j10, float f10) {
        return OffsetKt.Offset(m1367getXimpl(j10) / f10, m1368getYimpl(j10) / f10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1363equalsimpl(long j10, Object obj) {
        return (obj instanceof Offset) && j10 == ((Offset) obj).m1377unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1364equalsimpl0(long j10, long j11) {
        return j10 == j11;
    }

    @Stable
    /* JADX INFO: renamed from: getDistance-impl, reason: not valid java name */
    public static final float m1365getDistanceimpl(long j10) {
        return (float) Math.sqrt((m1367getXimpl(j10) * m1367getXimpl(j10)) + (m1368getYimpl(j10) * m1368getYimpl(j10)));
    }

    @Stable
    /* JADX INFO: renamed from: getDistanceSquared-impl, reason: not valid java name */
    public static final float m1366getDistanceSquaredimpl(long j10) {
        return (m1367getXimpl(j10) * m1367getXimpl(j10)) + (m1368getYimpl(j10) * m1368getYimpl(j10));
    }

    /* JADX INFO: renamed from: getX-impl, reason: not valid java name */
    public static final float m1367getXimpl(long j10) {
        if (!(j10 != Unspecified)) {
            throw new IllegalStateException("Offset is unspecified".toString());
        }
        m mVar = m.f29832a;
        return Float.intBitsToFloat((int) (j10 >> 32));
    }

    /* JADX INFO: renamed from: getY-impl, reason: not valid java name */
    public static final float m1368getYimpl(long j10) {
        if (!(j10 != Unspecified)) {
            throw new IllegalStateException("Offset is unspecified".toString());
        }
        m mVar = m.f29832a;
        return Float.intBitsToFloat((int) (j10 & 4294967295L));
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1369hashCodeimpl(long j10) {
        return a.a(j10);
    }

    @Stable
    /* JADX INFO: renamed from: isValid-impl, reason: not valid java name */
    public static final boolean m1370isValidimpl(long j10) {
        if ((Float.isNaN(m1367getXimpl(j10)) || Float.isNaN(m1368getYimpl(j10))) ? false : true) {
            return true;
        }
        throw new IllegalStateException("Offset argument contained a NaN value.".toString());
    }

    @Stable
    /* JADX INFO: renamed from: minus-MK-Hz9U, reason: not valid java name */
    public static final long m1371minusMKHz9U(long j10, long j11) {
        return OffsetKt.Offset(m1367getXimpl(j10) - m1367getXimpl(j11), m1368getYimpl(j10) - m1368getYimpl(j11));
    }

    @Stable
    /* JADX INFO: renamed from: plus-MK-Hz9U, reason: not valid java name */
    public static final long m1372plusMKHz9U(long j10, long j11) {
        return OffsetKt.Offset(m1367getXimpl(j10) + m1367getXimpl(j11), m1368getYimpl(j10) + m1368getYimpl(j11));
    }

    @Stable
    /* JADX INFO: renamed from: rem-tuRUvjQ, reason: not valid java name */
    public static final long m1373remtuRUvjQ(long j10, float f10) {
        return OffsetKt.Offset(m1367getXimpl(j10) % f10, m1368getYimpl(j10) % f10);
    }

    @Stable
    /* JADX INFO: renamed from: times-tuRUvjQ, reason: not valid java name */
    public static final long m1374timestuRUvjQ(long j10, float f10) {
        return OffsetKt.Offset(m1367getXimpl(j10) * f10, m1368getYimpl(j10) * f10);
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1375toStringimpl(long j10) {
        if (!OffsetKt.m1386isSpecifiedk4lQ0M(j10)) {
            return "Offset.Unspecified";
        }
        return "Offset(" + GeometryUtilsKt.toStringAsFixed(m1367getXimpl(j10), 1) + ", " + GeometryUtilsKt.toStringAsFixed(m1368getYimpl(j10), 1) + ')';
    }

    @Stable
    /* JADX INFO: renamed from: unaryMinus-F1C5BW0, reason: not valid java name */
    public static final long m1376unaryMinusF1C5BW0(long j10) {
        return OffsetKt.Offset(-m1367getXimpl(j10), -m1368getYimpl(j10));
    }

    public boolean equals(Object obj) {
        return m1363equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m1369hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m1375toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m1377unboximpl() {
        return this.packedValue;
    }

    /* JADX INFO: compiled from: Offset.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getInfinite-F1C5BW0, reason: not valid java name */
        public final long m1381getInfiniteF1C5BW0() {
            return Offset.Infinite;
        }

        /* JADX INFO: renamed from: getUnspecified-F1C5BW0, reason: not valid java name */
        public final long m1382getUnspecifiedF1C5BW0() {
            return Offset.Unspecified;
        }

        /* JADX INFO: renamed from: getZero-F1C5BW0, reason: not valid java name */
        public final long m1383getZeroF1C5BW0() {
            return Offset.Zero;
        }

        @Stable
        /* JADX INFO: renamed from: getInfinite-F1C5BW0$annotations, reason: not valid java name */
        public static /* synthetic */ void m1378getInfiniteF1C5BW0$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getUnspecified-F1C5BW0$annotations, reason: not valid java name */
        public static /* synthetic */ void m1379getUnspecifiedF1C5BW0$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getZero-F1C5BW0$annotations, reason: not valid java name */
        public static /* synthetic */ void m1380getZeroF1C5BW0$annotations() {
        }
    }

    @Stable
    public static /* synthetic */ void getX$annotations() {
    }

    @Stable
    public static /* synthetic */ void getY$annotations() {
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m1359constructorimpl(long j10) {
        return j10;
    }
}
