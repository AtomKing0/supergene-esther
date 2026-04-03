package androidx.compose.ui;

import androidx.compose.ui.layout.Placeable;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ZIndexModifier.kt */
/* JADX INFO: loaded from: classes.dex */
final class ZIndexModifier$measure$1 extends v implements l<Placeable.PlacementScope, k0> {
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ ZIndexModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ZIndexModifier$measure$1(Placeable placeable, ZIndexModifier zIndexModifier) {
        super(1);
        this.$placeable = placeable;
        this.this$0 = zIndexModifier;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
        invoke2(placementScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Placeable.PlacementScope layout) {
        t.i(layout, "$this$layout");
        layout.place(this.$placeable, 0, 0, this.this$0.zIndex);
    }
}
