package androidx.compose.material;

import androidx.compose.ui.layout.Placeable;
import h9.l;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ListItem.kt */
/* JADX INFO: loaded from: classes.dex */
final class ListItemKt$BaselinesOffsetColumn$1$measure$2 extends v implements l<Placeable.PlacementScope, k0> {
    final /* synthetic */ List<Placeable> $placeables;
    final /* synthetic */ Integer[] $y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ListItemKt$BaselinesOffsetColumn$1$measure$2(List<? extends Placeable> list, Integer[] numArr) {
        super(1);
        this.$placeables = list;
        this.$y = numArr;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
        invoke2(placementScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Placeable.PlacementScope layout) {
        t.i(layout, "$this$layout");
        List<Placeable> list = this.$placeables;
        Integer[] numArr = this.$y;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            Placeable.PlacementScope.placeRelative$default(layout, list.get(i10), 0, numArr[i10].intValue(), 0.0f, 4, null);
        }
    }
}
