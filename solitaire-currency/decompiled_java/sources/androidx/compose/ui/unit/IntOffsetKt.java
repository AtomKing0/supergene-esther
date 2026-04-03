package androidx.compose.ui.unit;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.util.MathHelpersKt;
import j9.c;

/* JADX INFO: compiled from: IntOffset.kt */
/* JADX INFO: loaded from: classes.dex */
public final class IntOffsetKt {
    @Stable
    public static final long IntOffset(int i10, int i11) {
        return IntOffset.m3785constructorimpl((((long) i11) & 4294967295L) | (((long) i10) << 32));
    }

    @Stable
    /* JADX INFO: renamed from: lerp-81ZRxRo, reason: not valid java name */
    public static final long m3802lerp81ZRxRo(long j10, long j11, float f10) {
        return IntOffset(MathHelpersKt.lerp(IntOffset.m3791getXimpl(j10), IntOffset.m3791getXimpl(j11), f10), MathHelpersKt.lerp(IntOffset.m3792getYimpl(j10), IntOffset.m3792getYimpl(j11), f10));
    }

    @Stable
    /* JADX INFO: renamed from: minus-Nv-tHpc, reason: not valid java name */
    public static final long m3803minusNvtHpc(long j10, long j11) {
        return OffsetKt.Offset(Offset.m1367getXimpl(j10) - IntOffset.m3791getXimpl(j11), Offset.m1368getYimpl(j10) - IntOffset.m3792getYimpl(j11));
    }

    @Stable
    /* JADX INFO: renamed from: minus-oCl6YwE, reason: not valid java name */
    public static final long m3804minusoCl6YwE(long j10, long j11) {
        return OffsetKt.Offset(IntOffset.m3791getXimpl(j10) - Offset.m1367getXimpl(j11), IntOffset.m3792getYimpl(j10) - Offset.m1368getYimpl(j11));
    }

    @Stable
    /* JADX INFO: renamed from: plus-Nv-tHpc, reason: not valid java name */
    public static final long m3805plusNvtHpc(long j10, long j11) {
        return OffsetKt.Offset(Offset.m1367getXimpl(j10) + IntOffset.m3791getXimpl(j11), Offset.m1368getYimpl(j10) + IntOffset.m3792getYimpl(j11));
    }

    @Stable
    /* JADX INFO: renamed from: plus-oCl6YwE, reason: not valid java name */
    public static final long m3806plusoCl6YwE(long j10, long j11) {
        return OffsetKt.Offset(IntOffset.m3791getXimpl(j10) + Offset.m1367getXimpl(j11), IntOffset.m3792getYimpl(j10) + Offset.m1368getYimpl(j11));
    }

    @Stable
    /* JADX INFO: renamed from: round-k-4lQ0M, reason: not valid java name */
    public static final long m3807roundk4lQ0M(long j10) {
        return IntOffset(c.c(Offset.m1367getXimpl(j10)), c.c(Offset.m1368getYimpl(j10)));
    }

    @Stable
    /* JADX INFO: renamed from: toOffset--gyyYBs, reason: not valid java name */
    public static final long m3808toOffsetgyyYBs(long j10) {
        return OffsetKt.Offset(IntOffset.m3791getXimpl(j10), IntOffset.m3792getYimpl(j10));
    }
}
