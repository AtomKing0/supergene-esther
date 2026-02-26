package androidx.compose.animation;

import androidx.compose.ui.layout.Placeable;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: EnterExitTransition.kt */
/* JADX INFO: loaded from: classes.dex */
final class SlideModifier$measure$1 extends v implements l<Placeable.PlacementScope, k0> {
    final /* synthetic */ long $measuredSize;
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ SlideModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SlideModifier$measure$1(SlideModifier slideModifier, Placeable placeable, long j10) {
        super(1);
        this.this$0 = slideModifier;
        this.$placeable = placeable;
        this.$measuredSize = j10;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
        invoke2(placementScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Placeable.PlacementScope layout) {
        t.i(layout, "$this$layout");
        Placeable.PlacementScope.m3020placeWithLayeraW9wM$default(layout, this.$placeable, this.this$0.getLazyAnimation().animate(this.this$0.getTransitionSpec(), new SlideModifier$measure$1$slideOffset$1(this.this$0, this.$measuredSize)).getValue().m3800unboximpl(), 0.0f, null, 6, null);
    }
}
