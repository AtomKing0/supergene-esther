package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import h9.s;
import java.util.List;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: RowColumnImpl.kt */
/* JADX INFO: loaded from: classes.dex */
final class RowColumnImplKt$rowColumnMeasurePolicy$1$measure$4 extends v implements h9.l<Placeable.PlacementScope, k0> {
    final /* synthetic */ s<Integer, int[], LayoutDirection, Density, int[], k0> $arrangement;
    final /* synthetic */ l0 $beforeCrossAxisAlignmentLine;
    final /* synthetic */ CrossAxisAlignment $crossAxisAlignment;
    final /* synthetic */ int $crossAxisLayoutSize;
    final /* synthetic */ int $mainAxisLayoutSize;
    final /* synthetic */ int[] $mainAxisPositions;
    final /* synthetic */ List<Measurable> $measurables;
    final /* synthetic */ LayoutOrientation $orientation;
    final /* synthetic */ Placeable[] $placeables;
    final /* synthetic */ RowColumnParentData[] $rowColumnParentData;
    final /* synthetic */ MeasureScope $this_measure;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    RowColumnImplKt$rowColumnMeasurePolicy$1$measure$4(List<? extends Measurable> list, Placeable[] placeableArr, s<? super Integer, ? super int[], ? super LayoutDirection, ? super Density, ? super int[], k0> sVar, int i10, MeasureScope measureScope, int[] iArr, LayoutOrientation layoutOrientation, RowColumnParentData[] rowColumnParentDataArr, CrossAxisAlignment crossAxisAlignment, int i11, l0 l0Var) {
        super(1);
        this.$measurables = list;
        this.$placeables = placeableArr;
        this.$arrangement = sVar;
        this.$mainAxisLayoutSize = i10;
        this.$this_measure = measureScope;
        this.$mainAxisPositions = iArr;
        this.$orientation = layoutOrientation;
        this.$rowColumnParentData = rowColumnParentDataArr;
        this.$crossAxisAlignment = crossAxisAlignment;
        this.$crossAxisLayoutSize = i11;
        this.$beforeCrossAxisAlignmentLine = l0Var;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
        invoke2(placementScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Placeable.PlacementScope layout) {
        int[] iArr;
        int i10;
        t.i(layout, "$this$layout");
        int size = this.$measurables.size();
        int[] iArr2 = new int[size];
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            Placeable placeable = this.$placeables[i12];
            t.f(placeable);
            iArr2[i12] = RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$mainAxisSize(placeable, this.$orientation);
        }
        this.$arrangement.invoke(Integer.valueOf(this.$mainAxisLayoutSize), iArr2, this.$this_measure.getLayoutDirection(), this.$this_measure, this.$mainAxisPositions);
        Placeable[] placeableArr = this.$placeables;
        RowColumnParentData[] rowColumnParentDataArr = this.$rowColumnParentData;
        CrossAxisAlignment crossAxisAlignment = this.$crossAxisAlignment;
        int i13 = this.$crossAxisLayoutSize;
        LayoutOrientation layoutOrientation = this.$orientation;
        MeasureScope measureScope = this.$this_measure;
        l0 l0Var = this.$beforeCrossAxisAlignmentLine;
        int[] iArr3 = this.$mainAxisPositions;
        int length = placeableArr.length;
        int i14 = 0;
        while (i11 < length) {
            Placeable placeable2 = placeableArr[i11];
            int i15 = i14 + 1;
            t.f(placeable2);
            CrossAxisAlignment crossAxisAlignment2 = RowColumnImplKt.getCrossAxisAlignment(rowColumnParentDataArr[i14]);
            if (crossAxisAlignment2 == null) {
                crossAxisAlignment2 = crossAxisAlignment;
            }
            int iRowColumnMeasurePolicy_TDGSqEk$crossAxisSize = i13 - RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(placeable2, layoutOrientation);
            LayoutOrientation layoutOrientation2 = LayoutOrientation.Horizontal;
            Placeable[] placeableArr2 = placeableArr;
            int i16 = length;
            int iAlign$foundation_layout_release = crossAxisAlignment2.align$foundation_layout_release(iRowColumnMeasurePolicy_TDGSqEk$crossAxisSize, layoutOrientation == layoutOrientation2 ? LayoutDirection.Ltr : measureScope.getLayoutDirection(), placeable2, l0Var.f29831a);
            if (layoutOrientation == layoutOrientation2) {
                iArr = iArr3;
                i10 = i11;
                Placeable.PlacementScope.place$default(layout, placeable2, iArr3[i14], iAlign$foundation_layout_release, 0.0f, 4, null);
            } else {
                iArr = iArr3;
                i10 = i11;
                Placeable.PlacementScope.place$default(layout, placeable2, iAlign$foundation_layout_release, iArr[i14], 0.0f, 4, null);
            }
            i11 = i10 + 1;
            i14 = i15;
            length = i16;
            placeableArr = placeableArr2;
            iArr3 = iArr;
        }
    }
}
