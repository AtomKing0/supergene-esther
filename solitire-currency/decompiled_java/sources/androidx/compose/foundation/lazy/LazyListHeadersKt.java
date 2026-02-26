package androidx.compose.foundation.lazy;

import java.util.List;
import kotlin.collections.d0;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LazyListHeaders.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListHeadersKt {
    @Nullable
    public static final LazyListPositionedItem findOrComposeLazyListHeader(@NotNull List<LazyListPositionedItem> composedVisibleItems, @NotNull LazyMeasuredItemProvider itemProvider, @NotNull List<Integer> headerIndexes, int i10, int i11, int i12) {
        t.i(composedVisibleItems, "composedVisibleItems");
        t.i(itemProvider, "itemProvider");
        t.i(headerIndexes, "headerIndexes");
        int index = ((LazyListPositionedItem) d0.i0(composedVisibleItems)).getIndex();
        int size = headerIndexes.size();
        int iIntValue = -1;
        int iIntValue2 = -1;
        int i13 = 0;
        while (i13 < size && headerIndexes.get(i13).intValue() <= index) {
            iIntValue = headerIndexes.get(i13).intValue();
            i13++;
            iIntValue2 = ((i13 < 0 || i13 > v.m(headerIndexes)) ? -1 : headerIndexes.get(i13)).intValue();
        }
        int size2 = composedVisibleItems.size();
        int offset = Integer.MIN_VALUE;
        int offset2 = Integer.MIN_VALUE;
        int i14 = -1;
        for (int i15 = 0; i15 < size2; i15++) {
            LazyListPositionedItem lazyListPositionedItem = composedVisibleItems.get(i15);
            if (lazyListPositionedItem.getIndex() == iIntValue) {
                offset = lazyListPositionedItem.getOffset();
                i14 = i15;
            } else if (lazyListPositionedItem.getIndex() == iIntValue2) {
                offset2 = lazyListPositionedItem.getOffset();
            }
        }
        if (iIntValue == -1) {
            return null;
        }
        LazyMeasuredItem lazyMeasuredItemM526getAndMeasureZjPyQlc = itemProvider.m526getAndMeasureZjPyQlc(DataIndex.m486constructorimpl(iIntValue));
        int iMax = offset != Integer.MIN_VALUE ? Math.max(-i10, offset) : -i10;
        if (offset2 != Integer.MIN_VALUE) {
            iMax = Math.min(iMax, offset2 - lazyMeasuredItemM526getAndMeasureZjPyQlc.getSize());
        }
        LazyListPositionedItem lazyListPositionedItemPosition = lazyMeasuredItemM526getAndMeasureZjPyQlc.position(iMax, i11, i12);
        if (i14 != -1) {
            composedVisibleItems.set(i14, lazyListPositionedItemPosition);
        } else {
            composedVisibleItems.add(0, lazyListPositionedItemPosition);
        }
        return lazyListPositionedItemPosition;
    }
}
