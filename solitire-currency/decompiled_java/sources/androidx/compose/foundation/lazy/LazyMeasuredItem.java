package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import kotlin.collections.p;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LazyMeasuredItem.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyMeasuredItem {
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private final int crossAxisSize;

    @Nullable
    private final Alignment.Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;

    @NotNull
    private final Object key;

    @NotNull
    private final LayoutDirection layoutDirection;

    @NotNull
    private final Placeable[] placeables;

    @NotNull
    private final LazyListItemPlacementAnimator placementAnimator;
    private final boolean reverseLayout;
    private final int size;
    private final int sizeWithSpacings;
    private final int spacing;

    @Nullable
    private final Alignment.Vertical verticalAlignment;
    private final long visualOffset;

    @ExperimentalFoundationApi
    public /* synthetic */ LazyMeasuredItem(int i10, Placeable[] placeableArr, boolean z10, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z11, int i11, int i12, LazyListItemPlacementAnimator lazyListItemPlacementAnimator, int i13, long j10, Object obj, k kVar) {
        this(i10, placeableArr, z10, horizontal, vertical, layoutDirection, z11, i11, i12, lazyListItemPlacementAnimator, i13, j10, obj);
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public final int getIndex() {
        return this.index;
    }

    @NotNull
    public final Object getKey() {
        return this.key;
    }

    public final int getSize() {
        return this.size;
    }

    public final int getSizeWithSpacings() {
        return this.sizeWithSpacings;
    }

    @NotNull
    public final LazyListPositionedItem position(int i10, int i11, int i12) {
        long jIntOffset;
        ArrayList arrayList = new ArrayList();
        int i13 = this.isVertical ? i12 : i11;
        boolean z10 = this.reverseLayout;
        int height = z10 ? (i13 - i10) - this.size : i10;
        int iS = z10 ? p.S(this.placeables) : 0;
        while (true) {
            boolean z11 = this.reverseLayout;
            boolean z12 = true;
            if (!z11 ? iS >= this.placeables.length : iS < 0) {
                z12 = false;
            }
            if (!z12) {
                return new LazyListPositionedItem(i10, this.index, this.key, this.size, this.sizeWithSpacings, -(!z11 ? this.beforeContentPadding : this.afterContentPadding), i13 + (!z11 ? this.afterContentPadding : this.beforeContentPadding), this.isVertical, arrayList, this.placementAnimator, this.visualOffset, null);
            }
            Placeable placeable = this.placeables[iS];
            int size = z11 ? 0 : arrayList.size();
            if (this.isVertical) {
                Alignment.Horizontal horizontal = this.horizontalAlignment;
                if (horizontal == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                jIntOffset = IntOffsetKt.IntOffset(horizontal.align(placeable.getWidth(), i11, this.layoutDirection), height);
            } else {
                Alignment.Vertical vertical = this.verticalAlignment;
                if (vertical == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                jIntOffset = IntOffsetKt.IntOffset(height, vertical.align(placeable.getHeight(), i12));
            }
            long j10 = jIntOffset;
            height += this.isVertical ? placeable.getHeight() : placeable.getWidth();
            arrayList.add(size, new LazyListPlaceableWrapper(j10, placeable, this.placeables[iS].getParentData(), null));
            iS = this.reverseLayout ? iS - 1 : iS + 1;
        }
    }

    private LazyMeasuredItem(int i10, Placeable[] placeableArr, boolean z10, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z11, int i11, int i12, LazyListItemPlacementAnimator lazyListItemPlacementAnimator, int i13, long j10, Object obj) {
        this.index = i10;
        this.placeables = placeableArr;
        this.isVertical = z10;
        this.horizontalAlignment = horizontal;
        this.verticalAlignment = vertical;
        this.layoutDirection = layoutDirection;
        this.reverseLayout = z11;
        this.beforeContentPadding = i11;
        this.afterContentPadding = i12;
        this.placementAnimator = lazyListItemPlacementAnimator;
        this.spacing = i13;
        this.visualOffset = j10;
        this.key = obj;
        int height = 0;
        int iMax = 0;
        for (Placeable placeable : placeableArr) {
            height += this.isVertical ? placeable.getHeight() : placeable.getWidth();
            iMax = Math.max(iMax, !this.isVertical ? placeable.getHeight() : placeable.getWidth());
        }
        this.size = height;
        this.sizeWithSpacings = height + this.spacing;
        this.crossAxisSize = iMax;
    }
}
