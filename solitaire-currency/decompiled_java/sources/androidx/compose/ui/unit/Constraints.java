package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Constraints.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class Constraints {
    private static final long FocusMask = 3;
    public static final int Infinity = Integer.MAX_VALUE;
    private static final int MaxFocusBits = 18;
    private static final long MaxFocusHeight = 3;
    private static final long MaxFocusWidth = 1;
    private static final int MaxNonFocusBits = 13;
    private static final int MinFocusBits = 16;
    private static final long MinFocusHeight = 2;
    private static final int MinFocusMask = 65535;
    private static final long MinFocusWidth = 0;
    private static final int MinNonFocusBits = 15;
    private final long value;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final int[] MinHeightOffsets = {18, 20, 17, 15};
    private static final int MaxFocusMask = 262143;
    private static final int MinNonFocusMask = 32767;
    private static final int MaxNonFocusMask = 8191;

    @NotNull
    private static final int[] WidthMask = {65535, MaxFocusMask, MinNonFocusMask, MaxNonFocusMask};

    @NotNull
    private static final int[] HeightMask = {MinNonFocusMask, MaxNonFocusMask, 65535, MaxFocusMask};

    /* JADX INFO: compiled from: Constraints.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        private final int bitsNeedForSize(int i10) {
            if (i10 < Constraints.MaxNonFocusMask) {
                return 13;
            }
            if (i10 < Constraints.MinNonFocusMask) {
                return 15;
            }
            if (i10 < 65535) {
                return 16;
            }
            if (i10 < Constraints.MaxFocusMask) {
                return 18;
            }
            throw new IllegalArgumentException("Can't represent a size of " + i10 + " in Constraints");
        }

        /* JADX INFO: renamed from: createConstraints-Zbe2FdA$ui_unit_release, reason: not valid java name */
        public final long m3648createConstraintsZbe2FdA$ui_unit_release(int i10, int i11, int i12, int i13) {
            long j10;
            int i14 = i13 == Integer.MAX_VALUE ? i12 : i13;
            int iBitsNeedForSize = bitsNeedForSize(i14);
            int i15 = i11 == Integer.MAX_VALUE ? i10 : i11;
            int iBitsNeedForSize2 = bitsNeedForSize(i15);
            if (iBitsNeedForSize + iBitsNeedForSize2 > 31) {
                throw new IllegalArgumentException("Can't represent a width of " + i15 + " and height of " + i14 + " in Constraints");
            }
            if (iBitsNeedForSize2 == 13) {
                j10 = 3;
            } else if (iBitsNeedForSize2 == 18) {
                j10 = 1;
            } else if (iBitsNeedForSize2 == 15) {
                j10 = Constraints.MinFocusHeight;
            } else {
                if (iBitsNeedForSize2 != 16) {
                    throw new IllegalStateException("Should only have the provided constants.");
                }
                j10 = Constraints.MinFocusWidth;
            }
            int i16 = i11 == Integer.MAX_VALUE ? 0 : i11 + 1;
            int i17 = i13 != Integer.MAX_VALUE ? i13 + 1 : 0;
            int i18 = Constraints.MinHeightOffsets[(int) j10];
            return Constraints.m3630constructorimpl((((long) i16) << 33) | j10 | (((long) i10) << Constraints.MinFocusHeight) | (((long) i12) << i18) | (((long) i17) << (i18 + 31)));
        }

        @Stable
        /* JADX INFO: renamed from: fixed-JhjzzOo, reason: not valid java name */
        public final long m3649fixedJhjzzOo(int i10, int i11) {
            if (i10 >= 0 && i11 >= 0) {
                return m3648createConstraintsZbe2FdA$ui_unit_release(i10, i10, i11, i11);
            }
            throw new IllegalArgumentException(("width(" + i10 + ") and height(" + i11 + ") must be >= 0").toString());
        }

        @Stable
        /* JADX INFO: renamed from: fixedHeight-OenEA2s, reason: not valid java name */
        public final long m3650fixedHeightOenEA2s(int i10) {
            if (i10 >= 0) {
                return m3648createConstraintsZbe2FdA$ui_unit_release(0, Integer.MAX_VALUE, i10, i10);
            }
            throw new IllegalArgumentException(("height(" + i10 + ") must be >= 0").toString());
        }

        @Stable
        /* JADX INFO: renamed from: fixedWidth-OenEA2s, reason: not valid java name */
        public final long m3651fixedWidthOenEA2s(int i10) {
            if (i10 >= 0) {
                return m3648createConstraintsZbe2FdA$ui_unit_release(i10, i10, 0, Integer.MAX_VALUE);
            }
            throw new IllegalArgumentException(("width(" + i10 + ") must be >= 0").toString());
        }
    }

    private /* synthetic */ Constraints(long j10) {
        this.value = j10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Constraints m3629boximpl(long j10) {
        return new Constraints(j10);
    }

    /* JADX INFO: renamed from: copy-Zbe2FdA, reason: not valid java name */
    public static final long m3631copyZbe2FdA(long j10, int i10, int i11, int i12, int i13) {
        boolean z10 = true;
        if (!(i12 >= 0 && i10 >= 0)) {
            throw new IllegalArgumentException(("minHeight(" + i12 + ") and minWidth(" + i10 + ") must be >= 0").toString());
        }
        if (!(i11 >= i10 || i11 == Integer.MAX_VALUE)) {
            throw new IllegalArgumentException(("maxWidth(" + i11 + ") must be >= minWidth(" + i10 + ')').toString());
        }
        if (i13 < i12 && i13 != Integer.MAX_VALUE) {
            z10 = false;
        }
        if (z10) {
            return Companion.m3648createConstraintsZbe2FdA$ui_unit_release(i10, i11, i12, i13);
        }
        throw new IllegalArgumentException(("maxHeight(" + i13 + ") must be >= minHeight(" + i12 + ')').toString());
    }

    /* JADX INFO: renamed from: copy-Zbe2FdA$default, reason: not valid java name */
    public static /* synthetic */ long m3632copyZbe2FdA$default(long j10, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = m3643getMinWidthimpl(j10);
        }
        int i15 = i10;
        if ((i14 & 2) != 0) {
            i11 = m3641getMaxWidthimpl(j10);
        }
        int i16 = i11;
        if ((i14 & 4) != 0) {
            i12 = m3642getMinHeightimpl(j10);
        }
        int i17 = i12;
        if ((i14 & 8) != 0) {
            i13 = m3640getMaxHeightimpl(j10);
        }
        return m3631copyZbe2FdA(j10, i15, i16, i17, i13);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3633equalsimpl(long j10, Object obj) {
        return (obj instanceof Constraints) && j10 == ((Constraints) obj).m3647unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3634equalsimpl0(long j10, long j11) {
        return j10 == j11;
    }

    /* JADX INFO: renamed from: getFocusIndex-impl, reason: not valid java name */
    private static final int m3635getFocusIndeximpl(long j10) {
        return (int) (j10 & 3);
    }

    /* JADX INFO: renamed from: getHasBoundedHeight-impl, reason: not valid java name */
    public static final boolean m3636getHasBoundedHeightimpl(long j10) {
        int iM3635getFocusIndeximpl = m3635getFocusIndeximpl(j10);
        return (((int) (j10 >> (MinHeightOffsets[iM3635getFocusIndeximpl] + 31))) & HeightMask[iM3635getFocusIndeximpl]) != 0;
    }

    /* JADX INFO: renamed from: getHasBoundedWidth-impl, reason: not valid java name */
    public static final boolean m3637getHasBoundedWidthimpl(long j10) {
        return (((int) (j10 >> 33)) & WidthMask[m3635getFocusIndeximpl(j10)]) != 0;
    }

    /* JADX INFO: renamed from: getHasFixedHeight-impl, reason: not valid java name */
    public static final boolean m3638getHasFixedHeightimpl(long j10) {
        return m3640getMaxHeightimpl(j10) == m3642getMinHeightimpl(j10);
    }

    /* JADX INFO: renamed from: getHasFixedWidth-impl, reason: not valid java name */
    public static final boolean m3639getHasFixedWidthimpl(long j10) {
        return m3641getMaxWidthimpl(j10) == m3643getMinWidthimpl(j10);
    }

    /* JADX INFO: renamed from: getMaxHeight-impl, reason: not valid java name */
    public static final int m3640getMaxHeightimpl(long j10) {
        int iM3635getFocusIndeximpl = m3635getFocusIndeximpl(j10);
        int i10 = ((int) (j10 >> (MinHeightOffsets[iM3635getFocusIndeximpl] + 31))) & HeightMask[iM3635getFocusIndeximpl];
        if (i10 == 0) {
            return Integer.MAX_VALUE;
        }
        return i10 - 1;
    }

    /* JADX INFO: renamed from: getMaxWidth-impl, reason: not valid java name */
    public static final int m3641getMaxWidthimpl(long j10) {
        int i10 = ((int) (j10 >> 33)) & WidthMask[m3635getFocusIndeximpl(j10)];
        if (i10 == 0) {
            return Integer.MAX_VALUE;
        }
        return i10 - 1;
    }

    /* JADX INFO: renamed from: getMinHeight-impl, reason: not valid java name */
    public static final int m3642getMinHeightimpl(long j10) {
        int iM3635getFocusIndeximpl = m3635getFocusIndeximpl(j10);
        return ((int) (j10 >> MinHeightOffsets[iM3635getFocusIndeximpl])) & HeightMask[iM3635getFocusIndeximpl];
    }

    /* JADX INFO: renamed from: getMinWidth-impl, reason: not valid java name */
    public static final int m3643getMinWidthimpl(long j10) {
        return ((int) (j10 >> MinFocusHeight)) & WidthMask[m3635getFocusIndeximpl(j10)];
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3644hashCodeimpl(long j10) {
        return androidx.compose.animation.a.a(j10);
    }

    /* JADX INFO: renamed from: isZero-impl, reason: not valid java name */
    public static final boolean m3645isZeroimpl(long j10) {
        return m3641getMaxWidthimpl(j10) == 0 || m3640getMaxHeightimpl(j10) == 0;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3646toStringimpl(long j10) {
        int iM3641getMaxWidthimpl = m3641getMaxWidthimpl(j10);
        String strValueOf = iM3641getMaxWidthimpl == Integer.MAX_VALUE ? "Infinity" : String.valueOf(iM3641getMaxWidthimpl);
        int iM3640getMaxHeightimpl = m3640getMaxHeightimpl(j10);
        return "Constraints(minWidth = " + m3643getMinWidthimpl(j10) + ", maxWidth = " + strValueOf + ", minHeight = " + m3642getMinHeightimpl(j10) + ", maxHeight = " + (iM3640getMaxHeightimpl != Integer.MAX_VALUE ? String.valueOf(iM3640getMaxHeightimpl) : "Infinity") + ')';
    }

    public boolean equals(Object obj) {
        return m3633equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3644hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m3646toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m3647unboximpl() {
        return this.value;
    }

    @Stable
    public static /* synthetic */ void getHasFixedHeight$annotations() {
    }

    @Stable
    public static /* synthetic */ void getHasFixedWidth$annotations() {
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    @Stable
    public static /* synthetic */ void isZero$annotations() {
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m3630constructorimpl(long j10) {
        return j10;
    }
}
