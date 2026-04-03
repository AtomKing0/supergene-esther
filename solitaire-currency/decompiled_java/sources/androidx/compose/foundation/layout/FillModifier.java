package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Size.kt */
/* JADX INFO: loaded from: classes.dex */
final class FillModifier extends InspectorValueInfo implements LayoutModifier {

    @NotNull
    private final Direction direction;
    private final float fraction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FillModifier(@NotNull Direction direction, float f10, @NotNull h9.l<? super InspectorInfo, k0> inspectorInfo) {
        super(inspectorInfo);
        t.i(direction, "direction");
        t.i(inspectorInfo, "inspectorInfo");
        this.direction = direction;
        this.fraction = f10;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(h9.l lVar) {
        return androidx.compose.ui.b.a(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(h9.l lVar) {
        return androidx.compose.ui.b.b(this, lVar);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof FillModifier)) {
            return false;
        }
        FillModifier fillModifier = (FillModifier) obj;
        if (this.direction == fillModifier.direction) {
            return (this.fraction > fillModifier.fraction ? 1 : (this.fraction == fillModifier.fraction ? 0 : -1)) == 0;
        }
        return false;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, p pVar) {
        return androidx.compose.ui.b.c(this, obj, pVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, p pVar) {
        return androidx.compose.ui.b.d(this, obj, pVar);
    }

    public int hashCode() {
        return (this.direction.hashCode() * 31) + Float.floatToIntBits(this.fraction);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i10) {
        return androidx.compose.ui.layout.c.a(this, intrinsicMeasureScope, intrinsicMeasurable, i10);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i10) {
        return androidx.compose.ui.layout.c.b(this, intrinsicMeasureScope, intrinsicMeasurable, i10);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo23measure3p2s80s(@NotNull MeasureScope measure, @NotNull Measurable measurable, long j10) {
        int iM3643getMinWidthimpl;
        int iM3641getMaxWidthimpl;
        int iM3640getMaxHeightimpl;
        int iN;
        t.i(measure, "$this$measure");
        t.i(measurable, "measurable");
        if (!Constraints.m3637getHasBoundedWidthimpl(j10) || this.direction == Direction.Vertical) {
            iM3643getMinWidthimpl = Constraints.m3643getMinWidthimpl(j10);
            iM3641getMaxWidthimpl = Constraints.m3641getMaxWidthimpl(j10);
        } else {
            iM3643getMinWidthimpl = n9.o.n(j9.c.c(Constraints.m3641getMaxWidthimpl(j10) * this.fraction), Constraints.m3643getMinWidthimpl(j10), Constraints.m3641getMaxWidthimpl(j10));
            iM3641getMaxWidthimpl = iM3643getMinWidthimpl;
        }
        if (!Constraints.m3636getHasBoundedHeightimpl(j10) || this.direction == Direction.Horizontal) {
            int iM3642getMinHeightimpl = Constraints.m3642getMinHeightimpl(j10);
            iM3640getMaxHeightimpl = Constraints.m3640getMaxHeightimpl(j10);
            iN = iM3642getMinHeightimpl;
        } else {
            iN = n9.o.n(j9.c.c(Constraints.m3640getMaxHeightimpl(j10) * this.fraction), Constraints.m3642getMinHeightimpl(j10), Constraints.m3640getMaxHeightimpl(j10));
            iM3640getMaxHeightimpl = iN;
        }
        Placeable placeableMo2987measureBRTryo0 = measurable.mo2987measureBRTryo0(ConstraintsKt.Constraints(iM3643getMinWidthimpl, iM3641getMaxWidthimpl, iN, iM3640getMaxHeightimpl));
        return MeasureScope.CC.p(measure, placeableMo2987measureBRTryo0.getWidth(), placeableMo2987measureBRTryo0.getHeight(), null, new FillModifier$measure$1(placeableMo2987measureBRTryo0), 4, null);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i10) {
        return androidx.compose.ui.layout.c.c(this, intrinsicMeasureScope, intrinsicMeasurable, i10);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i10) {
        return androidx.compose.ui.layout.c.d(this, intrinsicMeasureScope, intrinsicMeasurable, i10);
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }
}
