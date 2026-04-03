package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RowColumnImpl.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OrientationIndependentConstraints {
    private final int crossAxisMax;
    private final int crossAxisMin;
    private final int mainAxisMax;
    private final int mainAxisMin;

    public /* synthetic */ OrientationIndependentConstraints(long j10, LayoutOrientation layoutOrientation, kotlin.jvm.internal.k kVar) {
        this(j10, layoutOrientation);
    }

    public static /* synthetic */ OrientationIndependentConstraints copy$default(OrientationIndependentConstraints orientationIndependentConstraints, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = orientationIndependentConstraints.mainAxisMin;
        }
        if ((i14 & 2) != 0) {
            i11 = orientationIndependentConstraints.mainAxisMax;
        }
        if ((i14 & 4) != 0) {
            i12 = orientationIndependentConstraints.crossAxisMin;
        }
        if ((i14 & 8) != 0) {
            i13 = orientationIndependentConstraints.crossAxisMax;
        }
        return orientationIndependentConstraints.copy(i10, i11, i12, i13);
    }

    public final int component1() {
        return this.mainAxisMin;
    }

    public final int component2() {
        return this.mainAxisMax;
    }

    public final int component3() {
        return this.crossAxisMin;
    }

    public final int component4() {
        return this.crossAxisMax;
    }

    @NotNull
    public final OrientationIndependentConstraints copy(int i10, int i11, int i12, int i13) {
        return new OrientationIndependentConstraints(i10, i11, i12, i13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrientationIndependentConstraints)) {
            return false;
        }
        OrientationIndependentConstraints orientationIndependentConstraints = (OrientationIndependentConstraints) obj;
        return this.mainAxisMin == orientationIndependentConstraints.mainAxisMin && this.mainAxisMax == orientationIndependentConstraints.mainAxisMax && this.crossAxisMin == orientationIndependentConstraints.crossAxisMin && this.crossAxisMax == orientationIndependentConstraints.crossAxisMax;
    }

    public final int getCrossAxisMax() {
        return this.crossAxisMax;
    }

    public final int getCrossAxisMin() {
        return this.crossAxisMin;
    }

    public final int getMainAxisMax() {
        return this.mainAxisMax;
    }

    public final int getMainAxisMin() {
        return this.mainAxisMin;
    }

    public int hashCode() {
        return (((((this.mainAxisMin * 31) + this.mainAxisMax) * 31) + this.crossAxisMin) * 31) + this.crossAxisMax;
    }

    public final int maxHeight(@NotNull LayoutOrientation orientation) {
        t.i(orientation, "orientation");
        return orientation == LayoutOrientation.Horizontal ? this.crossAxisMax : this.mainAxisMax;
    }

    public final int maxWidth(@NotNull LayoutOrientation orientation) {
        t.i(orientation, "orientation");
        return orientation == LayoutOrientation.Horizontal ? this.mainAxisMax : this.crossAxisMax;
    }

    @NotNull
    public final OrientationIndependentConstraints stretchCrossAxis() {
        int i10 = this.mainAxisMin;
        int i11 = this.mainAxisMax;
        int i12 = this.crossAxisMax;
        return new OrientationIndependentConstraints(i10, i11, i12 != Integer.MAX_VALUE ? i12 : this.crossAxisMin, i12);
    }

    /* JADX INFO: renamed from: toBoxConstraints-OenEA2s, reason: not valid java name */
    public final long m391toBoxConstraintsOenEA2s(@NotNull LayoutOrientation orientation) {
        t.i(orientation, "orientation");
        return orientation == LayoutOrientation.Horizontal ? ConstraintsKt.Constraints(this.mainAxisMin, this.mainAxisMax, this.crossAxisMin, this.crossAxisMax) : ConstraintsKt.Constraints(this.crossAxisMin, this.crossAxisMax, this.mainAxisMin, this.mainAxisMax);
    }

    @NotNull
    public String toString() {
        return "OrientationIndependentConstraints(mainAxisMin=" + this.mainAxisMin + ", mainAxisMax=" + this.mainAxisMax + ", crossAxisMin=" + this.crossAxisMin + ", crossAxisMax=" + this.crossAxisMax + ')';
    }

    public OrientationIndependentConstraints(int i10, int i11, int i12, int i13) {
        this.mainAxisMin = i10;
        this.mainAxisMax = i11;
        this.crossAxisMin = i12;
        this.crossAxisMax = i13;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private OrientationIndependentConstraints(long j10, LayoutOrientation layoutOrientation) {
        LayoutOrientation layoutOrientation2 = LayoutOrientation.Horizontal;
        this(layoutOrientation == layoutOrientation2 ? Constraints.m3643getMinWidthimpl(j10) : Constraints.m3642getMinHeightimpl(j10), layoutOrientation == layoutOrientation2 ? Constraints.m3641getMaxWidthimpl(j10) : Constraints.m3640getMaxHeightimpl(j10), layoutOrientation == layoutOrientation2 ? Constraints.m3642getMinHeightimpl(j10) : Constraints.m3643getMinWidthimpl(j10), layoutOrientation == layoutOrientation2 ? Constraints.m3640getMaxHeightimpl(j10) : Constraints.m3641getMaxWidthimpl(j10));
    }
}
