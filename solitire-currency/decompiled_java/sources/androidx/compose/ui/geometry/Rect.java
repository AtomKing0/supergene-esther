package androidx.compose.ui.geometry;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Rect.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class Rect {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Rect Zero = new Rect(0.0f, 0.0f, 0.0f, 0.0f);
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;

    public Rect(float f10, float f11, float f12, float f13) {
        this.left = f10;
        this.top = f11;
        this.right = f12;
        this.bottom = f13;
    }

    public static /* synthetic */ Rect copy$default(Rect rect, float f10, float f11, float f12, float f13, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = rect.left;
        }
        if ((i10 & 2) != 0) {
            f11 = rect.top;
        }
        if ((i10 & 4) != 0) {
            f12 = rect.right;
        }
        if ((i10 & 8) != 0) {
            f13 = rect.bottom;
        }
        return rect.copy(f10, f11, f12, f13);
    }

    public final float component1() {
        return this.left;
    }

    public final float component2() {
        return this.top;
    }

    public final float component3() {
        return this.right;
    }

    public final float component4() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: contains-k-4lQ0M, reason: not valid java name */
    public final boolean m1393containsk4lQ0M(long j10) {
        return Offset.m1367getXimpl(j10) >= this.left && Offset.m1367getXimpl(j10) < this.right && Offset.m1368getYimpl(j10) >= this.top && Offset.m1368getYimpl(j10) < this.bottom;
    }

    @NotNull
    public final Rect copy(float f10, float f11, float f12, float f13) {
        return new Rect(f10, f11, f12, f13);
    }

    @Stable
    @NotNull
    public final Rect deflate(float f10) {
        return inflate(-f10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rect)) {
            return false;
        }
        Rect rect = (Rect) obj;
        return t.d(Float.valueOf(this.left), Float.valueOf(rect.left)) && t.d(Float.valueOf(this.top), Float.valueOf(rect.top)) && t.d(Float.valueOf(this.right), Float.valueOf(rect.right)) && t.d(Float.valueOf(this.bottom), Float.valueOf(rect.bottom));
    }

    public final float getBottom() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: getBottomCenter-F1C5BW0, reason: not valid java name */
    public final long m1394getBottomCenterF1C5BW0() {
        return OffsetKt.Offset(this.left + (getWidth() / 2.0f), this.bottom);
    }

    /* JADX INFO: renamed from: getBottomLeft-F1C5BW0, reason: not valid java name */
    public final long m1395getBottomLeftF1C5BW0() {
        return OffsetKt.Offset(this.left, this.bottom);
    }

    /* JADX INFO: renamed from: getBottomRight-F1C5BW0, reason: not valid java name */
    public final long m1396getBottomRightF1C5BW0() {
        return OffsetKt.Offset(this.right, this.bottom);
    }

    /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
    public final long m1397getCenterF1C5BW0() {
        return OffsetKt.Offset(this.left + (getWidth() / 2.0f), this.top + (getHeight() / 2.0f));
    }

    /* JADX INFO: renamed from: getCenterLeft-F1C5BW0, reason: not valid java name */
    public final long m1398getCenterLeftF1C5BW0() {
        return OffsetKt.Offset(this.left, this.top + (getHeight() / 2.0f));
    }

    /* JADX INFO: renamed from: getCenterRight-F1C5BW0, reason: not valid java name */
    public final long m1399getCenterRightF1C5BW0() {
        return OffsetKt.Offset(this.right, this.top + (getHeight() / 2.0f));
    }

    public final float getHeight() {
        return this.bottom - this.top;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getMaxDimension() {
        return Math.max(Math.abs(getWidth()), Math.abs(getHeight()));
    }

    public final float getMinDimension() {
        return Math.min(Math.abs(getWidth()), Math.abs(getHeight()));
    }

    public final float getRight() {
        return this.right;
    }

    /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
    public final long m1400getSizeNHjbRc() {
        return SizeKt.Size(getWidth(), getHeight());
    }

    public final float getTop() {
        return this.top;
    }

    /* JADX INFO: renamed from: getTopCenter-F1C5BW0, reason: not valid java name */
    public final long m1401getTopCenterF1C5BW0() {
        return OffsetKt.Offset(this.left + (getWidth() / 2.0f), this.top);
    }

    /* JADX INFO: renamed from: getTopLeft-F1C5BW0, reason: not valid java name */
    public final long m1402getTopLeftF1C5BW0() {
        return OffsetKt.Offset(this.left, this.top);
    }

    /* JADX INFO: renamed from: getTopRight-F1C5BW0, reason: not valid java name */
    public final long m1403getTopRightF1C5BW0() {
        return OffsetKt.Offset(this.right, this.top);
    }

    public final float getWidth() {
        return this.right - this.left;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.left) * 31) + Float.floatToIntBits(this.top)) * 31) + Float.floatToIntBits(this.right)) * 31) + Float.floatToIntBits(this.bottom);
    }

    @Stable
    @NotNull
    public final Rect inflate(float f10) {
        return new Rect(this.left - f10, this.top - f10, this.right + f10, this.bottom + f10);
    }

    @Stable
    @NotNull
    public final Rect intersect(@NotNull Rect other) {
        t.i(other, "other");
        return new Rect(Math.max(this.left, other.left), Math.max(this.top, other.top), Math.min(this.right, other.right), Math.min(this.bottom, other.bottom));
    }

    public final boolean isEmpty() {
        return this.left >= this.right || this.top >= this.bottom;
    }

    public final boolean isFinite() {
        float f10 = this.left;
        if ((Float.isInfinite(f10) || Float.isNaN(f10)) ? false : true) {
            float f11 = this.top;
            if ((Float.isInfinite(f11) || Float.isNaN(f11)) ? false : true) {
                float f12 = this.right;
                if ((Float.isInfinite(f12) || Float.isNaN(f12)) ? false : true) {
                    float f13 = this.bottom;
                    if ((Float.isInfinite(f13) || Float.isNaN(f13)) ? false : true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean isInfinite() {
        return this.left >= Float.POSITIVE_INFINITY || this.top >= Float.POSITIVE_INFINITY || this.right >= Float.POSITIVE_INFINITY || this.bottom >= Float.POSITIVE_INFINITY;
    }

    public final boolean overlaps(@NotNull Rect other) {
        t.i(other, "other");
        return this.right > other.left && other.right > this.left && this.bottom > other.top && other.bottom > this.top;
    }

    @NotNull
    public String toString() {
        return "Rect.fromLTRB(" + GeometryUtilsKt.toStringAsFixed(this.left, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.top, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.right, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.bottom, 1) + ')';
    }

    @Stable
    @NotNull
    public final Rect translate(float f10, float f11) {
        return new Rect(this.left + f10, this.top + f11, this.right + f10, this.bottom + f11);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: translate-k-4lQ0M, reason: not valid java name */
    public final Rect m1404translatek4lQ0M(long j10) {
        return new Rect(this.left + Offset.m1367getXimpl(j10), this.top + Offset.m1368getYimpl(j10), this.right + Offset.m1367getXimpl(j10), this.bottom + Offset.m1368getYimpl(j10));
    }

    /* JADX INFO: compiled from: Rect.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final Rect getZero() {
            return Rect.Zero;
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
    /* JADX INFO: renamed from: getSize-NH-jbRc$annotations, reason: not valid java name */
    public static /* synthetic */ void m1392getSizeNHjbRc$annotations() {
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

    @Stable
    public static /* synthetic */ void isFinite$annotations() {
    }

    @Stable
    public static /* synthetic */ void isInfinite$annotations() {
    }
}
