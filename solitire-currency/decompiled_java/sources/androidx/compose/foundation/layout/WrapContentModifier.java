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
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Size.kt */
/* JADX INFO: loaded from: classes.dex */
final class WrapContentModifier extends InspectorValueInfo implements LayoutModifier {

    @NotNull
    private final Object align;

    @NotNull
    private final p<IntSize, LayoutDirection, IntOffset> alignmentCallback;

    @NotNull
    private final Direction direction;
    private final boolean unbounded;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WrapContentModifier(@NotNull Direction direction, boolean z10, @NotNull p<? super IntSize, ? super LayoutDirection, IntOffset> alignmentCallback, @NotNull Object align, @NotNull h9.l<? super InspectorInfo, k0> inspectorInfo) {
        super(inspectorInfo);
        t.i(direction, "direction");
        t.i(alignmentCallback, "alignmentCallback");
        t.i(align, "align");
        t.i(inspectorInfo, "inspectorInfo");
        this.direction = direction;
        this.unbounded = z10;
        this.alignmentCallback = alignmentCallback;
        this.align = align;
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
        if (!(obj instanceof WrapContentModifier)) {
            return false;
        }
        WrapContentModifier wrapContentModifier = (WrapContentModifier) obj;
        return this.direction == wrapContentModifier.direction && this.unbounded == wrapContentModifier.unbounded && t.d(this.align, wrapContentModifier.align);
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
        return (((this.direction.hashCode() * 31) + androidx.compose.foundation.e.a(this.unbounded)) * 31) + this.align.hashCode();
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
        t.i(measure, "$this$measure");
        t.i(measurable, "measurable");
        Direction direction = this.direction;
        Direction direction2 = Direction.Vertical;
        int iM3643getMinWidthimpl = direction != direction2 ? 0 : Constraints.m3643getMinWidthimpl(j10);
        Direction direction3 = this.direction;
        Direction direction4 = Direction.Horizontal;
        Placeable placeableMo2987measureBRTryo0 = measurable.mo2987measureBRTryo0(ConstraintsKt.Constraints(iM3643getMinWidthimpl, (this.direction == direction2 || !this.unbounded) ? Constraints.m3641getMaxWidthimpl(j10) : Integer.MAX_VALUE, direction3 == direction4 ? Constraints.m3642getMinHeightimpl(j10) : 0, (this.direction == direction4 || !this.unbounded) ? Constraints.m3640getMaxHeightimpl(j10) : Integer.MAX_VALUE));
        int iN = n9.o.n(placeableMo2987measureBRTryo0.getWidth(), Constraints.m3643getMinWidthimpl(j10), Constraints.m3641getMaxWidthimpl(j10));
        int iN2 = n9.o.n(placeableMo2987measureBRTryo0.getHeight(), Constraints.m3642getMinHeightimpl(j10), Constraints.m3640getMaxHeightimpl(j10));
        return MeasureScope.CC.p(measure, iN, iN2, null, new WrapContentModifier$measure$1(this, iN, placeableMo2987measureBRTryo0, iN2, measure), 4, null);
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
