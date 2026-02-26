package androidx.compose.ui.layout;

import androidx.compose.ui.unit.Constraints;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Layout.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultIntrinsicMeasurable implements Measurable {

    @NotNull
    private final IntrinsicMeasurable measurable;

    @NotNull
    private final IntrinsicMinMax minMax;

    @NotNull
    private final IntrinsicWidthHeight widthHeight;

    public DefaultIntrinsicMeasurable(@NotNull IntrinsicMeasurable measurable, @NotNull IntrinsicMinMax minMax, @NotNull IntrinsicWidthHeight widthHeight) {
        t.i(measurable, "measurable");
        t.i(minMax, "minMax");
        t.i(widthHeight, "widthHeight");
        this.measurable = measurable;
        this.minMax = minMax;
        this.widthHeight = widthHeight;
    }

    @NotNull
    public final IntrinsicMeasurable getMeasurable() {
        return this.measurable;
    }

    @NotNull
    public final IntrinsicMinMax getMinMax() {
        return this.minMax;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    @Nullable
    public Object getParentData() {
        return this.measurable.getParentData();
    }

    @NotNull
    public final IntrinsicWidthHeight getWidthHeight() {
        return this.widthHeight;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicHeight(int i10) {
        return this.measurable.maxIntrinsicHeight(i10);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicWidth(int i10) {
        return this.measurable.maxIntrinsicWidth(i10);
    }

    @Override // androidx.compose.ui.layout.Measurable
    @NotNull
    /* JADX INFO: renamed from: measure-BRTryo0, reason: not valid java name */
    public Placeable mo2987measureBRTryo0(long j10) {
        if (this.widthHeight == IntrinsicWidthHeight.Width) {
            return new FixedSizeIntrinsicsPlaceable(this.minMax == IntrinsicMinMax.Max ? this.measurable.maxIntrinsicWidth(Constraints.m3640getMaxHeightimpl(j10)) : this.measurable.minIntrinsicWidth(Constraints.m3640getMaxHeightimpl(j10)), Constraints.m3640getMaxHeightimpl(j10));
        }
        return new FixedSizeIntrinsicsPlaceable(Constraints.m3641getMaxWidthimpl(j10), this.minMax == IntrinsicMinMax.Max ? this.measurable.maxIntrinsicHeight(Constraints.m3641getMaxWidthimpl(j10)) : this.measurable.minIntrinsicHeight(Constraints.m3641getMaxWidthimpl(j10)));
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicHeight(int i10) {
        return this.measurable.minIntrinsicHeight(i10);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicWidth(int i10) {
        return this.measurable.minIntrinsicWidth(i10);
    }
}
