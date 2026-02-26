package androidx.compose.foundation.lazy;

import androidx.compose.ui.layout.Placeable;
import h9.l;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: LazyListMeasure.kt */
/* JADX INFO: loaded from: classes.dex */
final class LazyListMeasureKt$measureLazyList$3 extends v implements l<Placeable.PlacementScope, k0> {
    final /* synthetic */ LazyListPositionedItem $headerItem;
    final /* synthetic */ List<LazyListPositionedItem> $positionedItems;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyListMeasureKt$measureLazyList$3(List<LazyListPositionedItem> list, LazyListPositionedItem lazyListPositionedItem) {
        super(1);
        this.$positionedItems = list;
        this.$headerItem = lazyListPositionedItem;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
        invoke2(placementScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Placeable.PlacementScope invoke) {
        t.i(invoke, "$this$invoke");
        List<LazyListPositionedItem> list = this.$positionedItems;
        LazyListPositionedItem lazyListPositionedItem = this.$headerItem;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            LazyListPositionedItem lazyListPositionedItem2 = list.get(i10);
            if (lazyListPositionedItem2 != lazyListPositionedItem) {
                lazyListPositionedItem2.place(invoke);
            }
        }
        LazyListPositionedItem lazyListPositionedItem3 = this.$headerItem;
        if (lazyListPositionedItem3 != null) {
            lazyListPositionedItem3.place(invoke);
        }
    }
}
