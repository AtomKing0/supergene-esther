package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Offset.kt */
/* JADX INFO: loaded from: classes.dex */
final class OffsetModifier$measure$1 extends v implements h9.l<Placeable.PlacementScope, k0> {
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ MeasureScope $this_measure;
    final /* synthetic */ OffsetModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OffsetModifier$measure$1(OffsetModifier offsetModifier, Placeable placeable, MeasureScope measureScope) {
        super(1);
        this.this$0 = offsetModifier;
        this.$placeable = placeable;
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
        if (this.this$0.getRtlAware()) {
            Placeable.PlacementScope.placeRelative$default(layout, this.$placeable, this.$this_measure.mo290roundToPx0680j_4(this.this$0.m389getXD9Ej5fM()), this.$this_measure.mo290roundToPx0680j_4(this.this$0.m390getYD9Ej5fM()), 0.0f, 4, null);
        } else {
            Placeable.PlacementScope.place$default(layout, this.$placeable, this.$this_measure.mo290roundToPx0680j_4(this.this$0.m389getXD9Ej5fM()), this.$this_measure.mo290roundToPx0680j_4(this.this$0.m390getYD9Ej5fM()), 0.0f, 4, null);
        }
    }
}
