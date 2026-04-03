package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: IntSize.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class IntSize {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long Zero = m3828constructorimpl(0);
    private final long packedValue;

    /* JADX INFO: compiled from: IntSize.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getZero-YbymL2g, reason: not valid java name */
        public final long m3838getZeroYbymL2g() {
            return IntSize.Zero;
        }
    }

    private /* synthetic */ IntSize(long j10) {
        this.packedValue = j10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntSize m3825boximpl(long j10) {
        return new IntSize(j10);
    }

    @Stable
    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final int m3826component1impl(long j10) {
        return m3833getWidthimpl(j10);
    }

    @Stable
    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final int m3827component2impl(long j10) {
        return m3832getHeightimpl(j10);
    }

    @Stable
    /* JADX INFO: renamed from: div-YEO4UFw, reason: not valid java name */
    public static final long m3829divYEO4UFw(long j10, int i10) {
        return IntSizeKt.IntSize(m3833getWidthimpl(j10) / i10, m3832getHeightimpl(j10) / i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3830equalsimpl(long j10, Object obj) {
        return (obj instanceof IntSize) && j10 == ((IntSize) obj).m3837unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3831equalsimpl0(long j10, long j11) {
        return j10 == j11;
    }

    /* JADX INFO: renamed from: getHeight-impl, reason: not valid java name */
    public static final int m3832getHeightimpl(long j10) {
        return (int) (j10 & 4294967295L);
    }

    /* JADX INFO: renamed from: getWidth-impl, reason: not valid java name */
    public static final int m3833getWidthimpl(long j10) {
        return (int) (j10 >> 32);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3834hashCodeimpl(long j10) {
        return androidx.compose.animation.a.a(j10);
    }

    @Stable
    /* JADX INFO: renamed from: times-YEO4UFw, reason: not valid java name */
    public static final long m3835timesYEO4UFw(long j10, int i10) {
        return IntSizeKt.IntSize(m3833getWidthimpl(j10) * i10, m3832getHeightimpl(j10) * i10);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3836toStringimpl(long j10) {
        return m3833getWidthimpl(j10) + " x " + m3832getHeightimpl(j10);
    }

    public boolean equals(Object obj) {
        return m3830equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m3834hashCodeimpl(this.packedValue);
    }

    @Stable
    @NotNull
    public String toString() {
        return m3836toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m3837unboximpl() {
        return this.packedValue;
    }

    @Stable
    public static /* synthetic */ void getHeight$annotations() {
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    @Stable
    public static /* synthetic */ void getWidth$annotations() {
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m3828constructorimpl(long j10) {
        return j10;
    }
}
