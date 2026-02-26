package androidx.compose.ui.text;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextRange.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class TextRange {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long Zero = TextRangeKt.TextRange(0);
    private final long packedValue;

    /* JADX INFO: compiled from: TextRange.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getZero-d9O1mEE, reason: not valid java name */
        public final long m3340getZerod9O1mEE() {
            return TextRange.Zero;
        }
    }

    private /* synthetic */ TextRange(long j10) {
        this.packedValue = j10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextRange m3323boximpl(long j10) {
        return new TextRange(j10);
    }

    /* JADX INFO: renamed from: contains-5zc-tL8, reason: not valid java name */
    public static final boolean m3325contains5zctL8(long j10, long j11) {
        return m3333getMinimpl(j10) <= m3333getMinimpl(j11) && m3332getMaximpl(j11) <= m3332getMaximpl(j10);
    }

    /* JADX INFO: renamed from: contains-impl, reason: not valid java name */
    public static final boolean m3326containsimpl(long j10, int i10) {
        return i10 < m3332getMaximpl(j10) && m3333getMinimpl(j10) <= i10;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3327equalsimpl(long j10, Object obj) {
        return (obj instanceof TextRange) && j10 == ((TextRange) obj).m3339unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3328equalsimpl0(long j10, long j11) {
        return j10 == j11;
    }

    /* JADX INFO: renamed from: getCollapsed-impl, reason: not valid java name */
    public static final boolean m3329getCollapsedimpl(long j10) {
        return m3335getStartimpl(j10) == m3330getEndimpl(j10);
    }

    /* JADX INFO: renamed from: getEnd-impl, reason: not valid java name */
    public static final int m3330getEndimpl(long j10) {
        return (int) (j10 & 4294967295L);
    }

    /* JADX INFO: renamed from: getLength-impl, reason: not valid java name */
    public static final int m3331getLengthimpl(long j10) {
        return m3332getMaximpl(j10) - m3333getMinimpl(j10);
    }

    /* JADX INFO: renamed from: getMax-impl, reason: not valid java name */
    public static final int m3332getMaximpl(long j10) {
        return m3335getStartimpl(j10) > m3330getEndimpl(j10) ? m3335getStartimpl(j10) : m3330getEndimpl(j10);
    }

    /* JADX INFO: renamed from: getMin-impl, reason: not valid java name */
    public static final int m3333getMinimpl(long j10) {
        return m3335getStartimpl(j10) > m3330getEndimpl(j10) ? m3330getEndimpl(j10) : m3335getStartimpl(j10);
    }

    /* JADX INFO: renamed from: getReversed-impl, reason: not valid java name */
    public static final boolean m3334getReversedimpl(long j10) {
        return m3335getStartimpl(j10) > m3330getEndimpl(j10);
    }

    /* JADX INFO: renamed from: getStart-impl, reason: not valid java name */
    public static final int m3335getStartimpl(long j10) {
        return (int) (j10 >> 32);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3336hashCodeimpl(long j10) {
        return androidx.compose.animation.a.a(j10);
    }

    /* JADX INFO: renamed from: intersects-5zc-tL8, reason: not valid java name */
    public static final boolean m3337intersects5zctL8(long j10, long j11) {
        return m3333getMinimpl(j10) < m3332getMaximpl(j11) && m3333getMinimpl(j11) < m3332getMaximpl(j10);
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3338toStringimpl(long j10) {
        return "TextRange(" + m3335getStartimpl(j10) + ", " + m3330getEndimpl(j10) + ')';
    }

    public boolean equals(Object obj) {
        return m3327equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m3336hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m3338toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m3339unboximpl() {
        return this.packedValue;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m3324constructorimpl(long j10) {
        return j10;
    }
}
