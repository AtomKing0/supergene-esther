package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Size.kt */
/* JADX INFO: loaded from: classes.dex */
final class WrapContentModifier$measure$1 extends v implements h9.l<Placeable.PlacementScope, k0> {
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ MeasureScope $this_measure;
    final /* synthetic */ int $wrapperHeight;
    final /* synthetic */ int $wrapperWidth;
    final /* synthetic */ WrapContentModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WrapContentModifier$measure$1(WrapContentModifier wrapContentModifier, int i10, Placeable placeable, int i11, MeasureScope measureScope) {
        super(1);
        this.this$0 = wrapContentModifier;
        this.$wrapperWidth = i10;
        this.$placeable = placeable;
        this.$wrapperHeight = i11;
        this.$this_measure = measureScope;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
        invoke2(placementScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Placeable.PlacementScope layout) {
        t.i(layout, "$this$layout");
        Placeable.PlacementScope.m3017place70tqf50$default(layout, this.$placeable, ((IntOffset) this.this$0.alignmentCallback.mo4invoke(IntSize.m3825boximpl(IntSizeKt.IntSize(this.$wrapperWidth - this.$placeable.getWidth(), this.$wrapperHeight - this.$placeable.getHeight())), this.$this_measure.getLayoutDirection())).m3800unboximpl(), 0.0f, 2, null);
    }
}
