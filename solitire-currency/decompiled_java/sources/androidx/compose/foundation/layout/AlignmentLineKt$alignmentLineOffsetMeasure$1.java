package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: AlignmentLine.kt */
/* JADX INFO: loaded from: classes.dex */
final class AlignmentLineKt$alignmentLineOffsetMeasure$1 extends v implements h9.l<Placeable.PlacementScope, k0> {
    final /* synthetic */ AlignmentLine $alignmentLine;
    final /* synthetic */ float $before;
    final /* synthetic */ int $height;
    final /* synthetic */ int $paddingAfter;
    final /* synthetic */ int $paddingBefore;
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ int $width;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AlignmentLineKt$alignmentLineOffsetMeasure$1(AlignmentLine alignmentLine, float f10, int i10, int i11, int i12, Placeable placeable, int i13) {
        super(1);
        this.$alignmentLine = alignmentLine;
        this.$before = f10;
        this.$paddingBefore = i10;
        this.$width = i11;
        this.$paddingAfter = i12;
        this.$placeable = placeable;
        this.$height = i13;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
        invoke2(placementScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Placeable.PlacementScope layout) {
        int width;
        t.i(layout, "$this$layout");
        if (AlignmentLineKt.getHorizontal(this.$alignmentLine)) {
            width = 0;
        } else {
            width = !Dp.m3678equalsimpl0(this.$before, Dp.Companion.m3693getUnspecifiedD9Ej5fM()) ? this.$paddingBefore : (this.$width - this.$paddingAfter) - this.$placeable.getWidth();
        }
        Placeable.PlacementScope.placeRelative$default(layout, this.$placeable, width, AlignmentLineKt.getHorizontal(this.$alignmentLine) ? !Dp.m3678equalsimpl0(this.$before, Dp.Companion.m3693getUnspecifiedD9Ej5fM()) ? this.$paddingBefore : (this.$height - this.$paddingAfter) - this.$placeable.getHeight() : 0, 0.0f, 4, null);
    }
}
