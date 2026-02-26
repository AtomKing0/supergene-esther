package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazyMeasuredLine.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyMeasuredLine {
    private final int crossAxisSpacing;
    private final int index;
    private final boolean isVertical;

    @NotNull
    private final LazyMeasuredItem[] items;

    @NotNull
    private final LayoutDirection layoutDirection;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private final int mainAxisSpacing;
    private final int slotsPerLine;

    @NotNull
    private final List<GridItemSpan> spans;

    public /* synthetic */ LazyMeasuredLine(int i10, LazyMeasuredItem[] lazyMeasuredItemArr, List list, boolean z10, int i11, LayoutDirection layoutDirection, int i12, int i13, k kVar) {
        this(i10, lazyMeasuredItemArr, list, z10, i11, layoutDirection, i12, i13);
    }

    /* JADX INFO: renamed from: getIndex-hA7yfN8, reason: not valid java name */
    public final int m588getIndexhA7yfN8() {
        return this.index;
    }

    @NotNull
    public final LazyMeasuredItem[] getItems() {
        return this.items;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    public final int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    public final boolean isEmpty() {
        return this.items.length == 0;
    }

    @NotNull
    public final List<LazyGridPositionedItem> position(int i10, int i11, int i12) {
        LazyMeasuredItem[] lazyMeasuredItemArr = this.items;
        ArrayList arrayList = new ArrayList(lazyMeasuredItemArr.length);
        int length = lazyMeasuredItemArr.length;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int crossAxisSize = 0;
        while (i13 < length) {
            LazyMeasuredItem lazyMeasuredItem = lazyMeasuredItemArr[i13];
            int i16 = i14 + 1;
            int iM535getCurrentLineSpanimpl = GridItemSpan.m535getCurrentLineSpanimpl(this.spans.get(i14).m538unboximpl());
            int i17 = this.layoutDirection == LayoutDirection.Rtl ? (this.slotsPerLine - i15) - iM535getCurrentLineSpanimpl : i15;
            boolean z10 = this.isVertical;
            int i18 = z10 ? this.index : i17;
            if (!z10) {
                i17 = this.index;
            }
            LazyGridPositionedItem lazyGridPositionedItemPosition = lazyMeasuredItem.position(i10, crossAxisSize, i11, i12, i18, i17, this.mainAxisSize);
            crossAxisSize += lazyMeasuredItem.getCrossAxisSize() + this.crossAxisSpacing;
            i15 += iM535getCurrentLineSpanimpl;
            arrayList.add(lazyGridPositionedItemPosition);
            i13++;
            i14 = i16;
        }
        return arrayList;
    }

    private LazyMeasuredLine(int i10, LazyMeasuredItem[] lazyMeasuredItemArr, List<GridItemSpan> list, boolean z10, int i11, LayoutDirection layoutDirection, int i12, int i13) {
        this.index = i10;
        this.items = lazyMeasuredItemArr;
        this.spans = list;
        this.isVertical = z10;
        this.slotsPerLine = i11;
        this.layoutDirection = layoutDirection;
        this.mainAxisSpacing = i12;
        this.crossAxisSpacing = i13;
        int iMax = 0;
        for (LazyMeasuredItem lazyMeasuredItem : lazyMeasuredItemArr) {
            iMax = Math.max(iMax, lazyMeasuredItem.getMainAxisSize());
        }
        this.mainAxisSize = iMax;
        this.mainAxisSizeWithSpacings = iMax + this.mainAxisSpacing;
    }
}
