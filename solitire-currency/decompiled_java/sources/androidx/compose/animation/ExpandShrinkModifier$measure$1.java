package androidx.compose.animation;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: EnterExitTransition.kt */
/* JADX INFO: loaded from: classes.dex */
final class ExpandShrinkModifier$measure$1 extends v implements l<Placeable.PlacementScope, k0> {
    final /* synthetic */ long $offset;
    final /* synthetic */ long $offsetDelta;
    final /* synthetic */ Placeable $placeable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExpandShrinkModifier$measure$1(Placeable placeable, long j10, long j11) {
        super(1);
        this.$placeable = placeable;
        this.$offset = j10;
        this.$offsetDelta = j11;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
        invoke2(placementScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Placeable.PlacementScope layout) {
        t.i(layout, "$this$layout");
        Placeable.PlacementScope.place$default(layout, this.$placeable, IntOffset.m3791getXimpl(this.$offset) + IntOffset.m3791getXimpl(this.$offsetDelta), IntOffset.m3792getYimpl(this.$offset) + IntOffset.m3792getYimpl(this.$offsetDelta), 0.0f, 4, null);
    }
}
