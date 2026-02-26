package androidx.compose.material;

import androidx.compose.ui.layout.Placeable;
import h9.l;
import j9.c;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: TouchTarget.kt */
/* JADX INFO: loaded from: classes.dex */
final class MinimumTouchTargetModifier$measure$1 extends v implements l<Placeable.PlacementScope, k0> {
    final /* synthetic */ int $height;
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ int $width;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MinimumTouchTargetModifier$measure$1(int i10, Placeable placeable, int i11) {
        super(1);
        this.$width = i10;
        this.$placeable = placeable;
        this.$height = i11;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
        invoke2(placementScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Placeable.PlacementScope layout) {
        t.i(layout, "$this$layout");
        Placeable.PlacementScope.place$default(layout, this.$placeable, c.c((this.$width - this.$placeable.getWidth()) / 2.0f), c.c((this.$height - this.$placeable.getHeight()) / 2.0f), 0.0f, 4, null);
    }
}
