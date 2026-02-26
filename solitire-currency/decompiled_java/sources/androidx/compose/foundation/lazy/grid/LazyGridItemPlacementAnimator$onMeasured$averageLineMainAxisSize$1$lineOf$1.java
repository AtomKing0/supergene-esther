package androidx.compose.foundation.lazy.grid;

import h9.l;
import java.util.List;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazyGridItemPlacementAnimator.kt */
/* JADX INFO: loaded from: classes.dex */
final class LazyGridItemPlacementAnimator$onMeasured$averageLineMainAxisSize$1$lineOf$1 extends v implements l<Integer, Integer> {
    final /* synthetic */ List<LazyGridPositionedItem> $positionedItems;
    final /* synthetic */ LazyGridItemPlacementAnimator $this_run;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyGridItemPlacementAnimator$onMeasured$averageLineMainAxisSize$1$lineOf$1(LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, List<LazyGridPositionedItem> list) {
        super(1);
        this.$this_run = lazyGridItemPlacementAnimator;
        this.$positionedItems = list;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
        return invoke(num.intValue());
    }

    @NotNull
    public final Integer invoke(int i10) {
        return Integer.valueOf(this.$this_run.isVertical ? this.$positionedItems.get(i10).getRow() : this.$positionedItems.get(i10).getColumn());
    }
}
