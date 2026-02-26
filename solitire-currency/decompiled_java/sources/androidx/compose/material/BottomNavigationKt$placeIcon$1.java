package androidx.compose.material;

import androidx.compose.ui.layout.Placeable;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: BottomNavigation.kt */
/* JADX INFO: loaded from: classes.dex */
final class BottomNavigationKt$placeIcon$1 extends v implements l<Placeable.PlacementScope, k0> {
    final /* synthetic */ Placeable $iconPlaceable;
    final /* synthetic */ int $iconY;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BottomNavigationKt$placeIcon$1(Placeable placeable, int i10) {
        super(1);
        this.$iconPlaceable = placeable;
        this.$iconY = i10;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
        invoke2(placementScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Placeable.PlacementScope layout) {
        t.i(layout, "$this$layout");
        Placeable.PlacementScope.placeRelative$default(layout, this.$iconPlaceable, 0, this.$iconY, 0.0f, 4, null);
    }
}
