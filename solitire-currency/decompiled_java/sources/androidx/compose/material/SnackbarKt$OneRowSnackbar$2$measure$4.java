package androidx.compose.material;

import androidx.compose.ui.layout.Placeable;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Snackbar.kt */
/* JADX INFO: loaded from: classes.dex */
final class SnackbarKt$OneRowSnackbar$2$measure$4 extends v implements l<Placeable.PlacementScope, k0> {
    final /* synthetic */ int $buttonPlaceX;
    final /* synthetic */ int $buttonPlaceY;
    final /* synthetic */ Placeable $buttonPlaceable;
    final /* synthetic */ int $textPlaceY;
    final /* synthetic */ Placeable $textPlaceable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnackbarKt$OneRowSnackbar$2$measure$4(Placeable placeable, int i10, Placeable placeable2, int i11, int i12) {
        super(1);
        this.$textPlaceable = placeable;
        this.$textPlaceY = i10;
        this.$buttonPlaceable = placeable2;
        this.$buttonPlaceX = i11;
        this.$buttonPlaceY = i12;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
        invoke2(placementScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Placeable.PlacementScope layout) {
        t.i(layout, "$this$layout");
        Placeable.PlacementScope.placeRelative$default(layout, this.$textPlaceable, 0, this.$textPlaceY, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(layout, this.$buttonPlaceable, this.$buttonPlaceX, this.$buttonPlaceY, 0.0f, 4, null);
    }
}
