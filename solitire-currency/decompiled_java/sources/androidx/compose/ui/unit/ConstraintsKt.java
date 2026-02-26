package androidx.compose.ui.unit;

import androidx.compose.runtime.Stable;
import n9.o;

/* JADX INFO: compiled from: Constraints.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ConstraintsKt {
    @Stable
    public static final long Constraints(int i10, int i11, int i12, int i13) {
        if (!(i11 >= i10)) {
            throw new IllegalArgumentException(("maxWidth(" + i11 + ") must be >= than minWidth(" + i10 + ')').toString());
        }
        if (!(i13 >= i12)) {
            throw new IllegalArgumentException(("maxHeight(" + i13 + ") must be >= than minHeight(" + i12 + ')').toString());
        }
        if (i10 >= 0 && i12 >= 0) {
            return Constraints.Companion.m3648createConstraintsZbe2FdA$ui_unit_release(i10, i11, i12, i13);
        }
        throw new IllegalArgumentException(("minWidth(" + i10 + ") and minHeight(" + i12 + ") must be >= 0").toString());
    }

    public static /* synthetic */ long Constraints$default(int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = 0;
        }
        if ((i14 & 2) != 0) {
            i11 = Integer.MAX_VALUE;
        }
        if ((i14 & 4) != 0) {
            i12 = 0;
        }
        if ((i14 & 8) != 0) {
            i13 = Integer.MAX_VALUE;
        }
        return Constraints(i10, i11, i12, i13);
    }

    private static final int addMaxWithMinimum(int i10, int i11) {
        return i10 == Integer.MAX_VALUE ? i10 : o.e(i10 + i11, 0);
    }

    @Stable
    /* JADX INFO: renamed from: constrain-4WqzIAM, reason: not valid java name */
    public static final long m3652constrain4WqzIAM(long j10, long j11) {
        return IntSizeKt.IntSize(o.n(IntSize.m3833getWidthimpl(j11), Constraints.m3643getMinWidthimpl(j10), Constraints.m3641getMaxWidthimpl(j10)), o.n(IntSize.m3832getHeightimpl(j11), Constraints.m3642getMinHeightimpl(j10), Constraints.m3640getMaxHeightimpl(j10)));
    }

    /* JADX INFO: renamed from: constrain-N9IONVI, reason: not valid java name */
    public static final long m3653constrainN9IONVI(long j10, long j11) {
        return Constraints(o.n(Constraints.m3643getMinWidthimpl(j11), Constraints.m3643getMinWidthimpl(j10), Constraints.m3641getMaxWidthimpl(j10)), o.n(Constraints.m3641getMaxWidthimpl(j11), Constraints.m3643getMinWidthimpl(j10), Constraints.m3641getMaxWidthimpl(j10)), o.n(Constraints.m3642getMinHeightimpl(j11), Constraints.m3642getMinHeightimpl(j10), Constraints.m3640getMaxHeightimpl(j10)), o.n(Constraints.m3640getMaxHeightimpl(j11), Constraints.m3642getMinHeightimpl(j10), Constraints.m3640getMaxHeightimpl(j10)));
    }

    @Stable
    /* JADX INFO: renamed from: constrainHeight-K40F9xA, reason: not valid java name */
    public static final int m3654constrainHeightK40F9xA(long j10, int i10) {
        return o.n(i10, Constraints.m3642getMinHeightimpl(j10), Constraints.m3640getMaxHeightimpl(j10));
    }

    @Stable
    /* JADX INFO: renamed from: constrainWidth-K40F9xA, reason: not valid java name */
    public static final int m3655constrainWidthK40F9xA(long j10, int i10) {
        return o.n(i10, Constraints.m3643getMinWidthimpl(j10), Constraints.m3641getMaxWidthimpl(j10));
    }

    @Stable
    /* JADX INFO: renamed from: isSatisfiedBy-4WqzIAM, reason: not valid java name */
    public static final boolean m3656isSatisfiedBy4WqzIAM(long j10, long j11) {
        int iM3643getMinWidthimpl = Constraints.m3643getMinWidthimpl(j10);
        int iM3641getMaxWidthimpl = Constraints.m3641getMaxWidthimpl(j10);
        int iM3833getWidthimpl = IntSize.m3833getWidthimpl(j11);
        if (iM3643getMinWidthimpl <= iM3833getWidthimpl && iM3833getWidthimpl <= iM3641getMaxWidthimpl) {
            int iM3642getMinHeightimpl = Constraints.m3642getMinHeightimpl(j10);
            int iM3640getMaxHeightimpl = Constraints.m3640getMaxHeightimpl(j10);
            int iM3832getHeightimpl = IntSize.m3832getHeightimpl(j11);
            if (iM3642getMinHeightimpl <= iM3832getHeightimpl && iM3832getHeightimpl <= iM3640getMaxHeightimpl) {
                return true;
            }
        }
        return false;
    }

    @Stable
    /* JADX INFO: renamed from: offset-NN6Ew-U, reason: not valid java name */
    public static final long m3657offsetNN6EwU(long j10, int i10, int i11) {
        return Constraints(o.e(Constraints.m3643getMinWidthimpl(j10) + i10, 0), addMaxWithMinimum(Constraints.m3641getMaxWidthimpl(j10), i10), o.e(Constraints.m3642getMinHeightimpl(j10) + i11, 0), addMaxWithMinimum(Constraints.m3640getMaxHeightimpl(j10), i11));
    }

    /* JADX INFO: renamed from: offset-NN6Ew-U$default, reason: not valid java name */
    public static /* synthetic */ long m3658offsetNN6EwU$default(long j10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        return m3657offsetNN6EwU(j10, i10, i11);
    }
}
