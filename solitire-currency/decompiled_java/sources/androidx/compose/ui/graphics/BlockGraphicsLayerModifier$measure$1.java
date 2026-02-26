package androidx.compose.ui.graphics;

import androidx.compose.ui.layout.Placeable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GraphicsLayerModifier.kt */
/* JADX INFO: loaded from: classes.dex */
final class BlockGraphicsLayerModifier$measure$1 extends kotlin.jvm.internal.v implements h9.l<Placeable.PlacementScope, v8.k0> {
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ BlockGraphicsLayerModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockGraphicsLayerModifier$measure$1(Placeable placeable, BlockGraphicsLayerModifier blockGraphicsLayerModifier) {
        super(1);
        this.$placeable = placeable;
        this.this$0 = blockGraphicsLayerModifier;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ v8.k0 invoke(Placeable.PlacementScope placementScope) {
        invoke2(placementScope);
        return v8.k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Placeable.PlacementScope layout) {
        kotlin.jvm.internal.t.i(layout, "$this$layout");
        Placeable.PlacementScope.placeWithLayer$default(layout, this.$placeable, 0, 0, 0.0f, this.this$0.layerBlock, 4, null);
    }
}
