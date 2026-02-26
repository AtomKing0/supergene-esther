package androidx.compose.foundation;

import androidx.compose.ui.layout.Placeable;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Scroll.kt */
/* JADX INFO: loaded from: classes.dex */
final class ScrollingLayoutModifier$measure$1 extends v implements h9.l<Placeable.PlacementScope, k0> {
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ int $side;
    final /* synthetic */ ScrollingLayoutModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScrollingLayoutModifier$measure$1(ScrollingLayoutModifier scrollingLayoutModifier, int i10, Placeable placeable) {
        super(1);
        this.this$0 = scrollingLayoutModifier;
        this.$side = i10;
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
        this.this$0.getScrollerState().setMaxValue$foundation_release(this.$side);
        int iN = n9.o.n(this.this$0.getScrollerState().getValue(), 0, this.$side);
        int i10 = this.this$0.isReversed() ? iN - this.$side : -iN;
        Placeable.PlacementScope.placeRelativeWithLayer$default(layout, this.$placeable, this.this$0.isVertical() ? 0 : i10, this.this$0.isVertical() ? i10 : 0, 0.0f, null, 12, null);
    }
}
