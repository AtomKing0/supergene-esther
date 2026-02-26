package androidx.compose.ui.node;

import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: HitTestResult.kt */
/* JADX INFO: loaded from: classes.dex */
final class DistanceAndInLayer {
    private final long packedValue;

    private /* synthetic */ DistanceAndInLayer(long j10) {
        this.packedValue = j10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DistanceAndInLayer m3053boximpl(long j10) {
        return new DistanceAndInLayer(j10);
    }

    /* JADX INFO: renamed from: compareTo-S_HNhKs, reason: not valid java name */
    public static final int m3054compareToS_HNhKs(long j10, long j11) {
        boolean zM3060isInLayerimpl = m3060isInLayerimpl(j10);
        return zM3060isInLayerimpl != m3060isInLayerimpl(j11) ? zM3060isInLayerimpl ? -1 : 1 : (int) Math.signum(m3058getDistanceimpl(j10) - m3058getDistanceimpl(j11));
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3056equalsimpl(long j10, Object obj) {
        return (obj instanceof DistanceAndInLayer) && j10 == ((DistanceAndInLayer) obj).m3062unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3057equalsimpl0(long j10, long j11) {
        return j10 == j11;
    }

    /* JADX INFO: renamed from: getDistance-impl, reason: not valid java name */
    public static final float m3058getDistanceimpl(long j10) {
        m mVar = m.f29832a;
        return Float.intBitsToFloat((int) (j10 >> 32));
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3059hashCodeimpl(long j10) {
        return androidx.compose.animation.a.a(j10);
    }

    /* JADX INFO: renamed from: isInLayer-impl, reason: not valid java name */
    public static final boolean m3060isInLayerimpl(long j10) {
        return ((int) (j10 & 4294967295L)) != 0;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3061toStringimpl(long j10) {
        return "DistanceAndInLayer(packedValue=" + j10 + ')';
    }

    public boolean equals(Object obj) {
        return m3056equalsimpl(this.packedValue, obj);
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    public int hashCode() {
        return m3059hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m3061toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m3062unboximpl() {
        return this.packedValue;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m3055constructorimpl(long j10) {
        return j10;
    }
}
