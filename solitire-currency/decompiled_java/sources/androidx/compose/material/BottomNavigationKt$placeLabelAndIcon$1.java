package androidx.compose.material;

import androidx.compose.ui.layout.Placeable;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: BottomNavigation.kt */
/* JADX INFO: loaded from: classes.dex */
final class BottomNavigationKt$placeLabelAndIcon$1 extends v implements l<Placeable.PlacementScope, k0> {
    final /* synthetic */ Placeable $iconPlaceable;
    final /* synthetic */ float $iconPositionAnimationProgress;
    final /* synthetic */ int $iconX;
    final /* synthetic */ Placeable $labelPlaceable;
    final /* synthetic */ int $labelX;
    final /* synthetic */ int $labelY;
    final /* synthetic */ int $offset;
    final /* synthetic */ int $selectedIconY;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BottomNavigationKt$placeLabelAndIcon$1(float f10, Placeable placeable, int i10, int i11, int i12, Placeable placeable2, int i13, int i14) {
        super(1);
        this.$iconPositionAnimationProgress = f10;
        this.$labelPlaceable = placeable;
        this.$labelX = i10;
        this.$labelY = i11;
        this.$offset = i12;
        this.$iconPlaceable = placeable2;
        this.$iconX = i13;
        this.$selectedIconY = i14;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
        invoke2(placementScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Placeable.PlacementScope layout) {
        t.i(layout, "$this$layout");
        if (!(this.$iconPositionAnimationProgress == 0.0f)) {
            Placeable.PlacementScope.placeRelative$default(layout, this.$labelPlaceable, this.$labelX, this.$labelY + this.$offset, 0.0f, 4, null);
        }
        Placeable.PlacementScope.placeRelative$default(layout, this.$iconPlaceable, this.$iconX, this.$selectedIconY + this.$offset, 0.0f, 4, null);
    }
}
