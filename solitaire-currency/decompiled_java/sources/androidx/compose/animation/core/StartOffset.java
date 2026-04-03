package androidx.compose.animation.core;

import kotlin.jvm.internal.k;
import v8.q;

/* JADX INFO: compiled from: AnimationSpec.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StartOffset {
    private final long value;

    private /* synthetic */ StartOffset(long j10) {
        this.value = j10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ StartOffset m121boximpl(long j10) {
        return new StartOffset(j10);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static long m123constructorimpl(long j10) {
        return j10;
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ long m124constructorimpl$default(int i10, int i11, int i12, k kVar) {
        if ((i12 & 2) != 0) {
            i11 = StartOffsetType.Companion.m139getDelayEo1U57Q();
        }
        return m122constructorimpl(i10, i11);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m125equalsimpl(long j10, Object obj) {
        return (obj instanceof StartOffset) && j10 == ((StartOffset) obj).m131unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m126equalsimpl0(long j10, long j11) {
        return j10 == j11;
    }

    /* JADX INFO: renamed from: getOffsetMillis-impl, reason: not valid java name */
    public static final int m127getOffsetMillisimpl(long j10) {
        return Math.abs((int) j10);
    }

    /* JADX INFO: renamed from: getOffsetType-Eo1U57Q, reason: not valid java name */
    public static final int m128getOffsetTypeEo1U57Q(long j10) {
        boolean z10 = j10 > 0;
        if (z10) {
            return StartOffsetType.Companion.m140getFastForwardEo1U57Q();
        }
        if (z10) {
            throw new q();
        }
        return StartOffsetType.Companion.m139getDelayEo1U57Q();
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m129hashCodeimpl(long j10) {
        return androidx.compose.animation.a.a(j10);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m130toStringimpl(long j10) {
        return "StartOffset(value=" + j10 + ')';
    }

    public boolean equals(Object obj) {
        return m125equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m129hashCodeimpl(this.value);
    }

    public String toString() {
        return m130toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m131unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m122constructorimpl(int i10, int i11) {
        return m123constructorimpl(i10 * i11);
    }
}
