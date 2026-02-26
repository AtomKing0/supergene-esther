package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import j9.c;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: IntOffset.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class IntOffset {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long Zero = IntOffsetKt.IntOffset(0, 0);
    private final long packedValue;

    /* JADX INFO: compiled from: IntOffset.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getZero-nOcc-ac, reason: not valid java name */
        public final long m3801getZeronOccac() {
            return IntOffset.Zero;
        }
    }

    private /* synthetic */ IntOffset(long j10) {
        this.packedValue = j10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntOffset m3782boximpl(long j10) {
        return new IntOffset(j10);
    }

    @Stable
    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final int m3783component1impl(long j10) {
        return m3791getXimpl(j10);
    }

    @Stable
    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final int m3784component2impl(long j10) {
        return m3792getYimpl(j10);
    }

    /* JADX INFO: renamed from: copy-iSbpLlY, reason: not valid java name */
    public static final long m3786copyiSbpLlY(long j10, int i10, int i11) {
        return IntOffsetKt.IntOffset(i10, i11);
    }

    /* JADX INFO: renamed from: copy-iSbpLlY$default, reason: not valid java name */
    public static /* synthetic */ long m3787copyiSbpLlY$default(long j10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = m3791getXimpl(j10);
        }
        if ((i12 & 2) != 0) {
            i11 = m3792getYimpl(j10);
        }
        return m3786copyiSbpLlY(j10, i10, i11);
    }

    @Stable
    /* JADX INFO: renamed from: div-Bjo55l4, reason: not valid java name */
    public static final long m3788divBjo55l4(long j10, float f10) {
        return IntOffsetKt.IntOffset(c.c(m3791getXimpl(j10) / f10), c.c(m3792getYimpl(j10) / f10));
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3789equalsimpl(long j10, Object obj) {
        return (obj instanceof IntOffset) && j10 == ((IntOffset) obj).m3800unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3790equalsimpl0(long j10, long j11) {
        return j10 == j11;
    }

    /* JADX INFO: renamed from: getX-impl, reason: not valid java name */
    public static final int m3791getXimpl(long j10) {
        return (int) (j10 >> 32);
    }

    /* JADX INFO: renamed from: getY-impl, reason: not valid java name */
    public static final int m3792getYimpl(long j10) {
        return (int) (j10 & 4294967295L);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3793hashCodeimpl(long j10) {
        return androidx.compose.animation.a.a(j10);
    }

    @Stable
    /* JADX INFO: renamed from: minus-qkQi6aY, reason: not valid java name */
    public static final long m3794minusqkQi6aY(long j10, long j11) {
        return IntOffsetKt.IntOffset(m3791getXimpl(j10) - m3791getXimpl(j11), m3792getYimpl(j10) - m3792getYimpl(j11));
    }

    @Stable
    /* JADX INFO: renamed from: plus-qkQi6aY, reason: not valid java name */
    public static final long m3795plusqkQi6aY(long j10, long j11) {
        return IntOffsetKt.IntOffset(m3791getXimpl(j10) + m3791getXimpl(j11), m3792getYimpl(j10) + m3792getYimpl(j11));
    }

    @Stable
    /* JADX INFO: renamed from: rem-Bjo55l4, reason: not valid java name */
    public static final long m3796remBjo55l4(long j10, int i10) {
        return IntOffsetKt.IntOffset(m3791getXimpl(j10) % i10, m3792getYimpl(j10) % i10);
    }

    @Stable
    /* JADX INFO: renamed from: times-Bjo55l4, reason: not valid java name */
    public static final long m3797timesBjo55l4(long j10, float f10) {
        return IntOffsetKt.IntOffset(c.c(m3791getXimpl(j10) * f10), c.c(m3792getYimpl(j10) * f10));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3798toStringimpl(long j10) {
        return '(' + m3791getXimpl(j10) + ", " + m3792getYimpl(j10) + ')';
    }

    @Stable
    /* JADX INFO: renamed from: unaryMinus-nOcc-ac, reason: not valid java name */
    public static final long m3799unaryMinusnOccac(long j10) {
        return IntOffsetKt.IntOffset(-m3791getXimpl(j10), -m3792getYimpl(j10));
    }

    public boolean equals(Object obj) {
        return m3789equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m3793hashCodeimpl(this.packedValue);
    }

    @Stable
    @NotNull
    public String toString() {
        return m3798toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m3800unboximpl() {
        return this.packedValue;
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    @Stable
    public static /* synthetic */ void getX$annotations() {
    }

    @Stable
    public static /* synthetic */ void getY$annotations() {
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m3785constructorimpl(long j10) {
        return j10;
    }
}
