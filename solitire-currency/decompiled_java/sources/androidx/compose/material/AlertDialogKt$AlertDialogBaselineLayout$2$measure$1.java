package androidx.compose.material;

import androidx.compose.ui.layout.Placeable;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: AlertDialog.kt */
/* JADX INFO: loaded from: classes.dex */
final class AlertDialogKt$AlertDialogBaselineLayout$2$measure$1 extends v implements l<Placeable.PlacementScope, k0> {
    final /* synthetic */ Placeable $textPlaceable;
    final /* synthetic */ int $textPositionY;
    final /* synthetic */ Placeable $titlePlaceable;
    final /* synthetic */ int $titlePositionY;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AlertDialogKt$AlertDialogBaselineLayout$2$measure$1(Placeable placeable, int i10, Placeable placeable2, int i11) {
        super(1);
        this.$titlePlaceable = placeable;
        this.$titlePositionY = i10;
        this.$textPlaceable = placeable2;
        this.$textPositionY = i11;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
        invoke2(placementScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Placeable.PlacementScope layout) {
        t.i(layout, "$this$layout");
        Placeable placeable = this.$titlePlaceable;
        if (placeable != null) {
            Placeable.PlacementScope.place$default(layout, placeable, 0, this.$titlePositionY, 0.0f, 4, null);
        }
        Placeable placeable2 = this.$textPlaceable;
        if (placeable2 != null) {
            Placeable.PlacementScope.place$default(layout, placeable2, 0, this.$textPositionY, 0.0f, 4, null);
        }
    }
}
