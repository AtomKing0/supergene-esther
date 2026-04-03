package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Offset.kt */
/* JADX INFO: loaded from: classes.dex */
final class OffsetPxModifier$measure$1 extends v implements h9.l<Placeable.PlacementScope, k0> {
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ MeasureScope $this_measure;
    final /* synthetic */ OffsetPxModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OffsetPxModifier$measure$1(OffsetPxModifier offsetPxModifier, MeasureScope measureScope, Placeable placeable) {
        super(1);
        this.this$0 = offsetPxModifier;
        this.$this_measure = measureScope;
        this.$placeable = placeable;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
        invoke2(placementScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Placeable.PlacementScope layout) {
        t.i(layout, "$this$layout");
        long jM3800unboximpl = this.this$0.getOffset().invoke(this.$this_measure).m3800unboximpl();
        if (this.this$0.getRtlAware()) {
            Placeable.PlacementScope.placeRelativeWithLayer$default(layout, this.$placeable, IntOffset.m3791getXimpl(jM3800unboximpl), IntOffset.m3792getYimpl(jM3800unboximpl), 0.0f, null, 12, null);
        } else {
            Placeable.PlacementScope.placeWithLayer$default(layout, this.$placeable, IntOffset.m3791getXimpl(jM3800unboximpl), IntOffset.m3792getYimpl(jM3800unboximpl), 0.0f, null, 12, null);
        }
    }
}
