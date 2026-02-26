package androidx.compose.material;

import androidx.compose.ui.layout.Placeable;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ListItem.kt */
/* JADX INFO: loaded from: classes.dex */
final class ListItemKt$OffsetToBaselineOrCenter$1$measure$1 extends v implements l<Placeable.PlacementScope, k0> {
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ int $y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ListItemKt$OffsetToBaselineOrCenter$1$measure$1(Placeable placeable, int i10) {
        super(1);
        this.$placeable = placeable;
        this.$y = i10;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
        invoke2(placementScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Placeable.PlacementScope layout) {
        t.i(layout, "$this$layout");
        Placeable.PlacementScope.placeRelative$default(layout, this.$placeable, 0, this.$y, 0.0f, 4, null);
    }
}
