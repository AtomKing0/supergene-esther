package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.layout.Placeable;
import h9.l;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: LazyGridMeasure.kt */
/* JADX INFO: loaded from: classes.dex */
final class LazyGridMeasureKt$measureLazyGrid$3 extends v implements l<Placeable.PlacementScope, k0> {
    final /* synthetic */ List<LazyGridPositionedItem> $positionedItems;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyGridMeasureKt$measureLazyGrid$3(List<LazyGridPositionedItem> list) {
        super(1);
        this.$positionedItems = list;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
        invoke2(placementScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Placeable.PlacementScope invoke) {
        t.i(invoke, "$this$invoke");
        List<LazyGridPositionedItem> list = this.$positionedItems;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            list.get(i10).place(invoke);
        }
    }
}
