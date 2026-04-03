package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Box.kt */
/* JADX INFO: loaded from: classes.dex */
final class BoxKt$boxMeasurePolicy$1$measure$5 extends v implements h9.l<Placeable.PlacementScope, k0> {
    final /* synthetic */ Alignment $alignment;
    final /* synthetic */ l0 $boxHeight;
    final /* synthetic */ l0 $boxWidth;
    final /* synthetic */ List<Measurable> $measurables;
    final /* synthetic */ Placeable[] $placeables;
    final /* synthetic */ MeasureScope $this_MeasurePolicy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BoxKt$boxMeasurePolicy$1$measure$5(Placeable[] placeableArr, List<? extends Measurable> list, MeasureScope measureScope, l0 l0Var, l0 l0Var2, Alignment alignment) {
        super(1);
        this.$placeables = placeableArr;
        this.$measurables = list;
        this.$this_MeasurePolicy = measureScope;
        this.$boxWidth = l0Var;
        this.$boxHeight = l0Var2;
        this.$alignment = alignment;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
        invoke2(placementScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Placeable.PlacementScope layout) {
        t.i(layout, "$this$layout");
        Placeable[] placeableArr = this.$placeables;
        List<Measurable> list = this.$measurables;
        MeasureScope measureScope = this.$this_MeasurePolicy;
        l0 l0Var = this.$boxWidth;
        l0 l0Var2 = this.$boxHeight;
        Alignment alignment = this.$alignment;
        int length = placeableArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i11 < length) {
            Placeable placeable = placeableArr[i11];
            int i12 = i10 + 1;
            if (placeable == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.compose.ui.layout.Placeable");
            }
            BoxKt.placeInBox(layout, placeable, list.get(i10), measureScope.getLayoutDirection(), l0Var.f29831a, l0Var2.f29831a, alignment);
            i11++;
            i10 = i12;
        }
    }
}
