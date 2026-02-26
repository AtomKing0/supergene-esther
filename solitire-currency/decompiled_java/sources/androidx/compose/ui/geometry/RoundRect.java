package androidx.compose.ui.geometry;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RoundRect.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class RoundRect {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final RoundRect Zero = RoundRectKt.m1421RoundRectgG7oq9Y(0.0f, 0.0f, 0.0f, 0.0f, CornerRadius.Companion.m1352getZerokKHJgLs());

    @Nullable
    private RoundRect _scaledRadiiRect;
    private final float bottom;
    private final long bottomLeftCornerRadius;
    private final long bottomRightCornerRadius;
    private final float left;
    private final float right;
    private final float top;
    private final long topLeftCornerRadius;
    private final long topRightCornerRadius;

    public /* synthetic */ RoundRect(float f10, float f11, float f12, float f13, long j10, long j11, long j12, long j13, k kVar) {
        this(f10, f11, f12, f13, j10, j11, j12, j13);
    }

    @NotNull
    public static final RoundRect getZero() {
        return Companion.getZero();
    }

    private final float minRadius(float f10, float f11, float f12, float f13) {
        float f14 = f11 + f12;
        if (f14 > f13) {
            return !((f14 > 0.0f ? 1 : (f14 == 0.0f ? 0 : -1)) == 0) ? Math.min(f10, f13 / f14) : f10;
        }
        return f10;
    }

    private final RoundRect scaledRadiiRect() {
        RoundRect roundRect = this._scaledRadiiRect;
        if (roundRect != null) {
            return roundRect;
        }
        float fMinRadius = minRadius(minRadius(minRadius(minRadius(1.0f, CornerRadius.m1343getYimpl(this.bottomLeftCornerRadius), CornerRadius.m1343getYimpl(this.topLeftCornerRadius), getHeight()), CornerRadius.m1342getXimpl(this.topLeftCornerRadius), CornerRadius.m1342getXimpl(this.topRightCornerRadius), getWidth()), CornerRadius.m1343getYimpl(this.topRightCornerRadius), CornerRadius.m1343getYimpl(this.bottomRightCornerRadius), getHeight()), CornerRadius.m1342getXimpl(this.bottomRightCornerRadius), CornerRadius.m1342getXimpl(this.bottomLeftCornerRadius), getWidth());
        RoundRect roundRect2 = new RoundRect(this.left * fMinRadius, this.top * fMinRadius, this.right * fMinRadius, this.bottom * fMinRadius, CornerRadiusKt.CornerRadius(CornerRadius.m1342getXimpl(this.topLeftCornerRadius) * fMinRadius, CornerRadius.m1343getYimpl(this.topLeftCornerRadius) * fMinRadius), CornerRadiusKt.CornerRadius(CornerRadius.m1342getXimpl(this.topRightCornerRadius) * fMinRadius, CornerRadius.m1343getYimpl(this.topRightCornerRadius) * fMinRadius), CornerRadiusKt.CornerRadius(CornerRadius.m1342getXimpl(this.bottomRightCornerRadius) * fMinRadius, CornerRadius.m1343getYimpl(this.bottomRightCornerRadius) * fMinRadius), CornerRadiusKt.CornerRadius(CornerRadius.m1342getXimpl(this.bottomLeftCornerRadius) * fMinRadius, CornerRadius.m1343getYimpl(this.bottomLeftCornerRadius) * fMinRadius), null);
        this._scaledRadiiRect = roundRect2;
        return roundRect2;
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

    /* JADX INFO: renamed from: component5-kKHJgLs, reason: not valid java name */
    public final long m1409component5kKHJgLs() {
        return this.topLeftCornerRadius;
    }

    /* JADX INFO: renamed from: component6-kKHJgLs, reason: not valid java name */
    public final long m1410component6kKHJgLs() {
        return this.topRightCornerRadius;
    }

    /* JADX INFO: renamed from: component7-kKHJgLs, reason: not valid java name */
    public final long m1411component7kKHJgLs() {
        return this.bottomRightCornerRadius;
    }

    /* JADX INFO: renamed from: component8-kKHJgLs, reason: not valid java name */
    public final long m1412component8kKHJgLs() {
        return this.bottomLeftCornerRadius;
    }

    /* JADX INFO: renamed from: contains-k-4lQ0M, reason: not valid java name */
    public final boolean m1413containsk4lQ0M(long j10) {
        float fM1367getXimpl;
        float fM1368getYimpl;
        float fM1342getXimpl;
        float fM1343getYimpl;
        if (Offset.m1367getXimpl(j10) < this.left || Offset.m1367getXimpl(j10) >= this.right || Offset.m1368getYimpl(j10) < this.top || Offset.m1368getYimpl(j10) >= this.bottom) {
            return false;
        }
        RoundRect roundRectScaledRadiiRect = scaledRadiiRect();
        if (Offset.m1367getXimpl(j10) < this.left + CornerRadius.m1342getXimpl(roundRectScaledRadiiRect.topLeftCornerRadius) && Offset.m1368getYimpl(j10) < this.top + CornerRadius.m1343getYimpl(roundRectScaledRadiiRect.topLeftCornerRadius)) {
            fM1367getXimpl = (Offset.m1367getXimpl(j10) - this.left) - CornerRadius.m1342getXimpl(roundRectScaledRadiiRect.topLeftCornerRadius);
            fM1368getYimpl = (Offset.m1368getYimpl(j10) - this.top) - CornerRadius.m1343getYimpl(roundRectScaledRadiiRect.topLeftCornerRadius);
            fM1342getXimpl = CornerRadius.m1342getXimpl(roundRectScaledRadiiRect.topLeftCornerRadius);
            fM1343getYimpl = CornerRadius.m1343getYimpl(roundRectScaledRadiiRect.topLeftCornerRadius);
        } else if (Offset.m1367getXimpl(j10) > this.right - CornerRadius.m1342getXimpl(roundRectScaledRadiiRect.topRightCornerRadius) && Offset.m1368getYimpl(j10) < this.top + CornerRadius.m1343getYimpl(roundRectScaledRadiiRect.topRightCornerRadius)) {
            fM1367getXimpl = (Offset.m1367getXimpl(j10) - this.right) + CornerRadius.m1342getXimpl(roundRectScaledRadiiRect.topRightCornerRadius);
            fM1368getYimpl = (Offset.m1368getYimpl(j10) - this.top) - CornerRadius.m1343getYimpl(roundRectScaledRadiiRect.topRightCornerRadius);
            fM1342getXimpl = CornerRadius.m1342getXimpl(roundRectScaledRadiiRect.topRightCornerRadius);
            fM1343getYimpl = CornerRadius.m1343getYimpl(roundRectScaledRadiiRect.topRightCornerRadius);
        } else if (Offset.m1367getXimpl(j10) > this.right - CornerRadius.m1342getXimpl(roundRectScaledRadiiRect.bottomRightCornerRadius) && Offset.m1368getYimpl(j10) > this.bottom - CornerRadius.m1343getYimpl(roundRectScaledRadiiRect.bottomRightCornerRadius)) {
            fM1367getXimpl = (Offset.m1367getXimpl(j10) - this.right) + CornerRadius.m1342getXimpl(roundRectScaledRadiiRect.bottomRightCornerRadius);
            fM1368getYimpl = (Offset.m1368getYimpl(j10) - this.bottom) + CornerRadius.m1343getYimpl(roundRectScaledRadiiRect.bottomRightCornerRadius);
            fM1342getXimpl = CornerRadius.m1342getXimpl(roundRectScaledRadiiRect.bottomRightCornerRadius);
            fM1343getYimpl = CornerRadius.m1343getYimpl(roundRectScaledRadiiRect.bottomRightCornerRadius);
        } else {
            if (Offset.m1367getXimpl(j10) >= this.left + CornerRadius.m1342getXimpl(roundRectScaledRadiiRect.bottomLeftCornerRadius) || Offset.m1368getYimpl(j10) <= this.bottom - CornerRadius.m1343getYimpl(roundRectScaledRadiiRect.bottomLeftCornerRadius)) {
                return true;
            }
            fM1367getXimpl = (Offset.m1367getXimpl(j10) - this.left) - CornerRadius.m1342getXimpl(roundRectScaledRadiiRect.bottomLeftCornerRadius);
            fM1368getYimpl = (Offset.m1368getYimpl(j10) - this.bottom) + CornerRadius.m1343getYimpl(roundRectScaledRadiiRect.bottomLeftCornerRadius);
            fM1342getXimpl = CornerRadius.m1342getXimpl(roundRectScaledRadiiRect.bottomLeftCornerRadius);
            fM1343getYimpl = CornerRadius.m1343getYimpl(roundRectScaledRadiiRect.bottomLeftCornerRadius);
        }
        float f10 = fM1367getXimpl / fM1342getXimpl;
        float f11 = fM1368getYimpl / fM1343getYimpl;
        return (f10 * f10) + (f11 * f11) <= 1.0f;
    }

    @NotNull
    /* JADX INFO: renamed from: copy-MDFrsts, reason: not valid java name */
    public final RoundRect m1414copyMDFrsts(float f10, float f11, float f12, float f13, long j10, long j11, long j12, long j13) {
        return new RoundRect(f10, f11, f12, f13, j10, j11, j12, j13, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoundRect)) {
            return false;
        }
        RoundRect roundRect = (RoundRect) obj;
        return t.d(Float.valueOf(this.left), Float.valueOf(roundRect.left)) && t.d(Float.valueOf(this.top), Float.valueOf(roundRect.top)) && t.d(Float.valueOf(this.right), Float.valueOf(roundRect.right)) && t.d(Float.valueOf(this.bottom), Float.valueOf(roundRect.bottom)) && CornerRadius.m1341equalsimpl0(this.topLeftCornerRadius, roundRect.topLeftCornerRadius) && CornerRadius.m1341equalsimpl0(this.topRightCornerRadius, roundRect.topRightCornerRadius) && CornerRadius.m1341equalsimpl0(this.bottomRightCornerRadius, roundRect.bottomRightCornerRadius) && CornerRadius.m1341equalsimpl0(this.bottomLeftCornerRadius, roundRect.bottomLeftCornerRadius);
    }

    public final float getBottom() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: getBottomLeftCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m1415getBottomLeftCornerRadiuskKHJgLs() {
        return this.bottomLeftCornerRadius;
    }

    /* JADX INFO: renamed from: getBottomRightCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m1416getBottomRightCornerRadiuskKHJgLs() {
        return this.bottomRightCornerRadius;
    }

    public final float getHeight() {
        return this.bottom - this.top;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getRight() {
        return this.right;
    }

    public final float getTop() {
        return this.top;
    }

    /* JADX INFO: renamed from: getTopLeftCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m1417getTopLeftCornerRadiuskKHJgLs() {
        return this.topLeftCornerRadius;
    }

    /* JADX INFO: renamed from: getTopRightCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m1418getTopRightCornerRadiuskKHJgLs() {
        return this.topRightCornerRadius;
    }

    public final float getWidth() {
        return this.right - this.left;
    }

    public int hashCode() {
        return (((((((((((((Float.floatToIntBits(this.left) * 31) + Float.floatToIntBits(this.top)) * 31) + Float.floatToIntBits(this.right)) * 31) + Float.floatToIntBits(this.bottom)) * 31) + CornerRadius.m1344hashCodeimpl(this.topLeftCornerRadius)) * 31) + CornerRadius.m1344hashCodeimpl(this.topRightCornerRadius)) * 31) + CornerRadius.m1344hashCodeimpl(this.bottomRightCornerRadius)) * 31) + CornerRadius.m1344hashCodeimpl(this.bottomLeftCornerRadius);
    }

    @NotNull
    public String toString() {
        long j10 = this.topLeftCornerRadius;
        long j11 = this.topRightCornerRadius;
        long j12 = this.bottomRightCornerRadius;
        long j13 = this.bottomLeftCornerRadius;
        String str = GeometryUtilsKt.toStringAsFixed(this.left, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.top, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.right, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.bottom, 1);
        if (!CornerRadius.m1341equalsimpl0(j10, j11) || !CornerRadius.m1341equalsimpl0(j11, j12) || !CornerRadius.m1341equalsimpl0(j12, j13)) {
            return "RoundRect(rect=" + str + ", topLeft=" + ((Object) CornerRadius.m1348toStringimpl(j10)) + ", topRight=" + ((Object) CornerRadius.m1348toStringimpl(j11)) + ", bottomRight=" + ((Object) CornerRadius.m1348toStringimpl(j12)) + ", bottomLeft=" + ((Object) CornerRadius.m1348toStringimpl(j13)) + ')';
        }
        if (CornerRadius.m1342getXimpl(j10) == CornerRadius.m1343getYimpl(j10)) {
            return "RoundRect(rect=" + str + ", radius=" + GeometryUtilsKt.toStringAsFixed(CornerRadius.m1342getXimpl(j10), 1) + ')';
        }
        return "RoundRect(rect=" + str + ", x=" + GeometryUtilsKt.toStringAsFixed(CornerRadius.m1342getXimpl(j10), 1) + ", y=" + GeometryUtilsKt.toStringAsFixed(CornerRadius.m1343getYimpl(j10), 1) + ')';
    }

    private RoundRect(float f10, float f11, float f12, float f13, long j10, long j11, long j12, long j13) {
        this.left = f10;
        this.top = f11;
        this.right = f12;
        this.bottom = f13;
        this.topLeftCornerRadius = j10;
        this.topRightCornerRadius = j11;
        this.bottomRightCornerRadius = j12;
        this.bottomLeftCornerRadius = j13;
    }

    public /* synthetic */ RoundRect(float f10, float f11, float f12, float f13, long j10, long j11, long j12, long j13, int i10, k kVar) {
        this(f10, f11, f12, f13, (i10 & 16) != 0 ? CornerRadius.Companion.m1352getZerokKHJgLs() : j10, (i10 & 32) != 0 ? CornerRadius.Companion.m1352getZerokKHJgLs() : j11, (i10 & 64) != 0 ? CornerRadius.Companion.m1352getZerokKHJgLs() : j12, (i10 & 128) != 0 ? CornerRadius.Companion.m1352getZerokKHJgLs() : j13, null);
    }

    /* JADX INFO: compiled from: RoundRect.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final RoundRect getZero() {
            return RoundRect.Zero;
        }

        public static /* synthetic */ void getZero$annotations() {
        }
    }
}
