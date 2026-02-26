package androidx.compose.foundation.lazy.grid;

import h9.l;
import java.util.List;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazyGridScrolling.kt */
/* JADX INFO: loaded from: classes.dex */
final class LazyGridScrollingKt$calculateLineAverageMainAxisSize$lineOf$1 extends v implements l<Integer, Integer> {
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ List<LazyGridItemInfo> $visibleItems;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    LazyGridScrollingKt$calculateLineAverageMainAxisSize$lineOf$1(boolean z10, List<? extends LazyGridItemInfo> list) {
        super(1);
        this.$isVertical = z10;
        this.$visibleItems = list;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
        return invoke(num.intValue());
    }

    @NotNull
    public final Integer invoke(int i10) {
        return Integer.valueOf(this.$isVertical ? this.$visibleItems.get(i10).getRow() : this.$visibleItems.get(i10).getColumn());
    }
}
