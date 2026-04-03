package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IntRect.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class IntRect {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final IntRect Zero = new IntRect(0, 0, 0, 0);
    private final int bottom;
    private final int left;
    private final int right;
    private final int top;

    public IntRect(int i10, int i11, int i12, int i13) {
        this.left = i10;
        this.top = i11;
        this.right = i12;
        this.bottom = i13;
    }

    public static /* synthetic */ IntRect copy$default(IntRect intRect, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = intRect.left;
        }
        if ((i14 & 2) != 0) {
            i11 = intRect.top;
        }
        if ((i14 & 4) != 0) {
            i12 = intRect.right;
        }
        if ((i14 & 8) != 0) {
            i13 = intRect.bottom;
        }
        return intRect.copy(i10, i11, i12, i13);
    }

    public final int component1() {
        return this.left;
    }

    public final int component2() {
        return this.top;
    }

    public final int component3() {
        return this.right;
    }

    public final int component4() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: contains--gyyYBs, reason: not valid java name */
    public final boolean m3810containsgyyYBs(long j10) {
        return IntOffset.m3791getXimpl(j10) >= this.left && IntOffset.m3791getXimpl(j10) < this.right && IntOffset.m3792getYimpl(j10) >= this.top && IntOffset.m3792getYimpl(j10) < this.bottom;
    }

    @NotNull
    public final IntRect copy(int i10, int i11, int i12, int i13) {
        return new IntRect(i10, i11, i12, i13);
    }

    @Stable
    @NotNull
    public final IntRect deflate(int i10) {
        return inflate(-i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntRect)) {
            return false;
        }
        IntRect intRect = (IntRect) obj;
        return this.left == intRect.left && this.top == intRect.top && this.right == intRect.right && this.bottom == intRect.bottom;
    }

    public final int getBottom() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: getBottomCenter-nOcc-ac, reason: not valid java name */
    public final long m3811getBottomCenternOccac() {
        return IntOffsetKt.IntOffset(this.left + (getWidth() / 2), this.bottom);
    }

    /* JADX INFO: renamed from: getBottomLeft-nOcc-ac, reason: not valid java name */
    public final long m3812getBottomLeftnOccac() {
        return IntOffsetKt.IntOffset(this.left, this.bottom);
    }

    /* JADX INFO: renamed from: getBottomRight-nOcc-ac, reason: not valid java name */
    public final long m3813getBottomRightnOccac() {
        return IntOffsetKt.IntOffset(this.right, this.bottom);
    }

    /* JADX INFO: renamed from: getCenter-nOcc-ac, reason: not valid java name */
    public final long m3814getCenternOccac() {
        return IntOffsetKt.IntOffset(this.left + (getWidth() / 2), this.top + (getHeight() / 2));
    }

    /* JADX INFO: renamed from: getCenterLeft-nOcc-ac, reason: not valid java name */
    public final long m3815getCenterLeftnOccac() {
        return IntOffsetKt.IntOffset(this.left, this.top + (getHeight() / 2));
    }

    /* JADX INFO: renamed from: getCenterRight-nOcc-ac, reason: not valid java name */
    public final long m3816getCenterRightnOccac() {
        return IntOffsetKt.IntOffset(this.right, this.top + (getHeight() / 2));
    }

    public final int getHeight() {
        return this.bottom - this.top;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getMaxDimension() {
        return Math.max(Math.abs(getWidth()), Math.abs(getHeight()));
    }

    public final int getMinDimension() {
        return Math.min(Math.abs(getWidth()), Math.abs(getHeight()));
    }

    public final int getRight() {
        return this.right;
    }

    /* JADX INFO: renamed from: getSize-YbymL2g, reason: not valid java name */
    public final long m3817getSizeYbymL2g() {
        return IntSizeKt.IntSize(getWidth(), getHeight());
    }

    public final int getTop() {
        return this.top;
    }

    /* JADX INFO: renamed from: getTopCenter-nOcc-ac, reason: not valid java name */
    public final long m3818getTopCenternOccac() {
        return IntOffsetKt.IntOffset(this.left + (getWidth() / 2), this.top);
    }

    /* JADX INFO: renamed from: getTopLeft-nOcc-ac, reason: not valid java name */
    public final long m3819getTopLeftnOccac() {
        return IntOffsetKt.IntOffset(this.left, this.top);
    }

    /* JADX INFO: renamed from: getTopRight-nOcc-ac, reason: not valid java name */
    public final long m3820getTopRightnOccac() {
        return IntOffsetKt.IntOffset(this.right, this.top);
    }

    public final int getWidth() {
        return this.right - this.left;
    }

    public int hashCode() {
        return (((((this.left * 31) + this.top) * 31) + this.right) * 31) + this.bottom;
    }

    @Stable
    @NotNull
    public final IntRect inflate(int i10) {
        return new IntRect(this.left - i10, this.top - i10, this.right + i10, this.bottom + i10);
    }

    @Stable
    @NotNull
    public final IntRect intersect(@NotNull IntRect other) {
        t.i(other, "other");
        return new IntRect(Math.max(this.left, other.left), Math.max(this.top, other.top), Math.min(this.right, other.right), Math.min(this.bottom, other.bottom));
    }

    public final boolean isEmpty() {
        return this.left >= this.right || this.top >= this.bottom;
    }

    public final boolean overlaps(@NotNull IntRect other) {
        t.i(other, "other");
        return this.right > other.left && other.right > this.left && this.bottom > other.top && other.bottom > this.top;
    }

    @NotNull
    public String toString() {
        return "IntRect.fromLTRB(" + this.left + ", " + this.top + ", " + this.right + ", " + this.bottom + ')';
    }

    @Stable
    @NotNull
    public final IntRect translate(int i10, int i11) {
        return new IntRect(this.left + i10, this.top + i11, this.right + i10, this.bottom + i11);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: translate--gyyYBs, reason: not valid java name */
    public final IntRect m3821translategyyYBs(long j10) {
        return new IntRect(this.left + IntOffset.m3791getXimpl(j10), this.top + IntOffset.m3792getYimpl(j10), this.right + IntOffset.m3791getXimpl(j10), this.bottom + IntOffset.m3792getYimpl(j10));
    }

    /* JADX INFO: compiled from: IntRect.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final IntRect getZero() {
            return IntRect.Zero;
        }

        @Stable
        public static /* synthetic */ void getZero$annotations() {
        }
    }

    @Stable
    public static /* synthetic */ void getBottom$annotations() {
    }

    @Stable
    public static /* synthetic */ void getHeight$annotations() {
    }

    @Stable
    public static /* synthetic */ void getLeft$annotations() {
    }

    @Stable
    public static /* synthetic */ void getRight$annotations() {
    }

    @Stable
    /* JADX INFO: renamed from: getSize-YbymL2g$annotations, reason: not valid java name */
    public static /* synthetic */ void m3809getSizeYbymL2g$annotations() {
    }

    @Stable
    public static /* synthetic */ void getTop$annotations() {
    }

    @Stable
    public static /* synthetic */ void getWidth$annotations() {
    }

    @Stable
    public static /* synthetic */ void isEmpty$annotations() {
    }
}
