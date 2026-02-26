package androidx.compose.ui.layout;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: LayoutModifier.kt */
/* JADX INFO: loaded from: classes.dex */
final class MeasuringIntrinsics {

    @NotNull
    public static final MeasuringIntrinsics INSTANCE = new MeasuringIntrinsics();

    /* JADX INFO: compiled from: LayoutModifier.kt */
    private static final class DefaultIntrinsicMeasurable implements Measurable {

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
        /* JADX INFO: renamed from: measure-BRTryo0 */
        public Placeable mo2987measureBRTryo0(long j10) {
            if (this.widthHeight == IntrinsicWidthHeight.Width) {
                return new EmptyPlaceable(this.minMax == IntrinsicMinMax.Max ? this.measurable.maxIntrinsicWidth(Constraints.m3640getMaxHeightimpl(j10)) : this.measurable.minIntrinsicWidth(Constraints.m3640getMaxHeightimpl(j10)), Constraints.m3640getMaxHeightimpl(j10));
            }
            return new EmptyPlaceable(Constraints.m3641getMaxWidthimpl(j10), this.minMax == IntrinsicMinMax.Max ? this.measurable.maxIntrinsicHeight(Constraints.m3641getMaxWidthimpl(j10)) : this.measurable.minIntrinsicHeight(Constraints.m3641getMaxWidthimpl(j10)));
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

    /* JADX INFO: compiled from: LayoutModifier.kt */
    private enum IntrinsicMinMax {
        Min,
        Max
    }

    /* JADX INFO: compiled from: LayoutModifier.kt */
    private enum IntrinsicWidthHeight {
        Width,
        Height
    }

    private MeasuringIntrinsics() {
    }

    public final int maxHeight$ui_release(@NotNull LayoutModifier modifier, @NotNull IntrinsicMeasureScope instrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i10) {
        t.i(modifier, "modifier");
        t.i(instrinsicMeasureScope, "instrinsicMeasureScope");
        t.i(intrinsicMeasurable, "intrinsicMeasurable");
        return modifier.mo23measure3p2s80s(new IntrinsicsMeasureScope(instrinsicMeasureScope, instrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.Max, IntrinsicWidthHeight.Height), ConstraintsKt.Constraints$default(0, i10, 0, 0, 13, null)).getHeight();
    }

    public final int maxWidth$ui_release(@NotNull LayoutModifier modifier, @NotNull IntrinsicMeasureScope instrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i10) {
        t.i(modifier, "modifier");
        t.i(instrinsicMeasureScope, "instrinsicMeasureScope");
        t.i(intrinsicMeasurable, "intrinsicMeasurable");
        return modifier.mo23measure3p2s80s(new IntrinsicsMeasureScope(instrinsicMeasureScope, instrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.Max, IntrinsicWidthHeight.Width), ConstraintsKt.Constraints$default(0, 0, 0, i10, 7, null)).getWidth();
    }

    public final int minHeight$ui_release(@NotNull LayoutModifier modifier, @NotNull IntrinsicMeasureScope instrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i10) {
        t.i(modifier, "modifier");
        t.i(instrinsicMeasureScope, "instrinsicMeasureScope");
        t.i(intrinsicMeasurable, "intrinsicMeasurable");
        return modifier.mo23measure3p2s80s(new IntrinsicsMeasureScope(instrinsicMeasureScope, instrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.Min, IntrinsicWidthHeight.Height), ConstraintsKt.Constraints$default(0, i10, 0, 0, 13, null)).getHeight();
    }

    public final int minWidth$ui_release(@NotNull LayoutModifier modifier, @NotNull IntrinsicMeasureScope instrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i10) {
        t.i(modifier, "modifier");
        t.i(instrinsicMeasureScope, "instrinsicMeasureScope");
        t.i(intrinsicMeasurable, "intrinsicMeasurable");
        return modifier.mo23measure3p2s80s(new IntrinsicsMeasureScope(instrinsicMeasureScope, instrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.Min, IntrinsicWidthHeight.Width), ConstraintsKt.Constraints$default(0, 0, 0, i10, 7, null)).getWidth();
    }

    /* JADX INFO: compiled from: LayoutModifier.kt */
    private static final class EmptyPlaceable extends Placeable {
        public EmptyPlaceable(int i10, int i11) {
            m3015setMeasuredSizeozmzZPI(IntSizeKt.IntSize(i10, i11));
        }

        @Override // androidx.compose.ui.layout.Measured
        public int get(@NotNull AlignmentLine alignmentLine) {
            t.i(alignmentLine, "alignmentLine");
            return Integer.MIN_VALUE;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.compose.ui.layout.Placeable
        /* JADX INFO: renamed from: placeAt-f8xVGno */
        public void mo2988placeAtf8xVGno(long j10, float f10, @Nullable h9.l<? super GraphicsLayerScope, k0> lVar) {
        }
    }
}
