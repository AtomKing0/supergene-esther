package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import kotlin.collections.p;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazyMeasuredItem.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyMeasuredItem {
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;

    @NotNull
    private final Object key;

    @NotNull
    private final LayoutDirection layoutDirection;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private final int mainAxisSpacing;

    @NotNull
    private final Placeable[] placeables;

    @NotNull
    private final LazyGridItemPlacementAnimator placementAnimator;
    private final boolean reverseLayout;
    private final long visualOffset;

    public /* synthetic */ LazyMeasuredItem(int i10, Object obj, boolean z10, int i11, int i12, boolean z11, LayoutDirection layoutDirection, int i13, int i14, Placeable[] placeableArr, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, long j10, k kVar) {
        this(i10, obj, z10, i11, i12, z11, layoutDirection, i13, i14, placeableArr, lazyGridItemPlacementAnimator, j10);
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    /* JADX INFO: renamed from: getIndex-VZbfaAc, reason: not valid java name */
    public final int m585getIndexVZbfaAc() {
        return this.index;
    }

    @NotNull
    public final Object getKey() {
        return this.key;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    public final int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    public final int getMainAxisSpacing() {
        return this.mainAxisSpacing;
    }

    @NotNull
    public final Placeable[] getPlaceables() {
        return this.placeables;
    }

    @NotNull
    public final LazyGridPositionedItem position(int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        ArrayList arrayList = new ArrayList();
        boolean z10 = this.isVertical;
        int i17 = z10 ? i13 : i12;
        int i18 = this.reverseLayout ? (i17 - i10) - this.mainAxisSize : i10;
        int i19 = (z10 && this.layoutDirection == LayoutDirection.Rtl) ? ((z10 ? i12 : i13) - i11) - this.crossAxisSize : i11;
        long jIntOffset = z10 ? IntOffsetKt.IntOffset(i19, i18) : IntOffsetKt.IntOffset(i18, i19);
        int iS = this.reverseLayout ? p.S(this.placeables) : 0;
        while (true) {
            boolean z11 = this.reverseLayout;
            boolean z12 = true;
            if (!z11 ? iS >= this.placeables.length : iS < 0) {
                z12 = false;
            }
            if (!z12) {
                break;
            }
            arrayList.add(z11 ? 0 : arrayList.size(), new LazyGridPlaceableWrapper(jIntOffset, this.placeables[iS], this.placeables[iS].getParentData(), null));
            iS = this.reverseLayout ? iS - 1 : iS + 1;
        }
        long jIntOffset2 = this.isVertical ? IntOffsetKt.IntOffset(i11, i10) : IntOffsetKt.IntOffset(i10, i11);
        int i20 = this.index;
        Object obj = this.key;
        long jIntSize = this.isVertical ? IntSizeKt.IntSize(this.crossAxisSize, this.mainAxisSize) : IntSizeKt.IntSize(this.mainAxisSize, this.crossAxisSize);
        int i21 = this.mainAxisSpacing;
        boolean z13 = this.reverseLayout;
        return new LazyGridPositionedItem(jIntOffset2, jIntOffset, i20, obj, i14, i15, jIntSize, i16, i21, -(!z13 ? this.beforeContentPadding : this.afterContentPadding), i17 + (!z13 ? this.afterContentPadding : this.beforeContentPadding), this.isVertical, arrayList, this.placementAnimator, this.visualOffset, null);
    }

    private LazyMeasuredItem(int i10, Object obj, boolean z10, int i11, int i12, boolean z11, LayoutDirection layoutDirection, int i13, int i14, Placeable[] placeableArr, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, long j10) {
        this.index = i10;
        this.key = obj;
        this.isVertical = z10;
        this.crossAxisSize = i11;
        this.mainAxisSpacing = i12;
        this.reverseLayout = z11;
        this.layoutDirection = layoutDirection;
        this.beforeContentPadding = i13;
        this.afterContentPadding = i14;
        this.placeables = placeableArr;
        this.placementAnimator = lazyGridItemPlacementAnimator;
        this.visualOffset = j10;
        int iMax = 0;
        for (Placeable placeable : placeableArr) {
            iMax = Math.max(iMax, this.isVertical ? placeable.getHeight() : placeable.getWidth());
        }
        this.mainAxisSize = iMax;
        this.mainAxisSizeWithSpacings = iMax + this.mainAxisSpacing;
    }
}
