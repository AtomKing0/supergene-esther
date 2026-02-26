package androidx.compose.material;

import androidx.compose.ui.layout.Placeable;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: NavigationRail.kt */
/* JADX INFO: loaded from: classes.dex */
final class NavigationRailKt$placeIcon$1 extends v implements l<Placeable.PlacementScope, k0> {
    final /* synthetic */ Placeable $iconPlaceable;
    final /* synthetic */ int $iconX;
    final /* synthetic */ int $iconY;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NavigationRailKt$placeIcon$1(Placeable placeable, int i10, int i11) {
        super(1);
        this.$iconPlaceable = placeable;
        this.$iconX = i10;
        this.$iconY = i11;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
        invoke2(placementScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Placeable.PlacementScope layout) {
        t.i(layout, "$this$layout");
        Placeable.PlacementScope.placeRelative$default(layout, this.$iconPlaceable, this.$iconX, this.$iconY, 0.0f, 4, null);
    }
}
