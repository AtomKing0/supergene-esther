package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LazyMeasuredItem.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyGridPositionedItem implements LazyGridItemInfo {
    private final int column;
    private final boolean hasAnimations;
    private final int index;
    private final boolean isVertical;

    @NotNull
    private final Object key;
    private final int lineMainAxisSize;
    private final int mainAxisSpacing;
    private final int maxMainAxisOffset;
    private final int minMainAxisOffset;
    private final long offset;
    private final long placeableOffset;

    @NotNull
    private final LazyGridItemPlacementAnimator placementAnimator;
    private final int row;
    private final long size;
    private final long visualOffset;

    @NotNull
    private final List<LazyGridPlaceableWrapper> wrappers;

    public /* synthetic */ LazyGridPositionedItem(long j10, long j11, int i10, Object obj, int i11, int i12, long j12, int i13, int i14, int i15, int i16, boolean z10, List list, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, long j13, k kVar) {
        this(j10, j11, i10, obj, i11, i12, j12, i13, i14, i15, i16, z10, list, lazyGridItemPlacementAnimator, j13);
    }

    /* JADX INFO: renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m573getMainAxisgyyYBs(long j10) {
        return this.isVertical ? IntOffset.m3792getYimpl(j10) : IntOffset.m3791getXimpl(j10);
    }

    @Nullable
    public final FiniteAnimationSpec<IntOffset> getAnimationSpec(int i10) {
        Object parentData = this.wrappers.get(i10).getParentData();
        if (parentData instanceof FiniteAnimationSpec) {
            return (FiniteAnimationSpec) parentData;
        }
        return null;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int getColumn() {
        return this.column;
    }

    public final int getCrossAxisOffset() {
        return this.isVertical ? IntOffset.m3791getXimpl(mo560getOffsetnOccac()) : IntOffset.m3792getYimpl(mo560getOffsetnOccac());
    }

    public final int getCrossAxisSize() {
        return this.isVertical ? IntSize.m3833getWidthimpl(mo561getSizeYbymL2g()) : IntSize.m3832getHeightimpl(mo561getSizeYbymL2g());
    }

    public final boolean getHasAnimations() {
        return this.hasAnimations;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    @NotNull
    public Object getKey() {
        return this.key;
    }

    public final int getLineMainAxisSize() {
        return this.lineMainAxisSize;
    }

    public final int getLineMainAxisSizeWithSpacings() {
        return this.mainAxisSpacing + this.lineMainAxisSize;
    }

    public final int getMainAxisSize(int i10) {
        return getMainAxisSize(this.wrappers.get(i10).getPlaceable());
    }

    public final int getMainAxisSizeWithSpacings() {
        return this.mainAxisSpacing + (this.isVertical ? IntSize.m3832getHeightimpl(mo561getSizeYbymL2g()) : IntSize.m3833getWidthimpl(mo561getSizeYbymL2g()));
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    /* JADX INFO: renamed from: getOffset-nOcc-ac */
    public long mo560getOffsetnOccac() {
        return this.offset;
    }

    /* JADX INFO: renamed from: getPlaceableOffset-nOcc-ac, reason: not valid java name */
    public final long m574getPlaceableOffsetnOccac() {
        return this.placeableOffset;
    }

    public final int getPlaceablesCount() {
        return this.wrappers.size();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int getRow() {
        return this.row;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    /* JADX INFO: renamed from: getSize-YbymL2g */
    public long mo561getSizeYbymL2g() {
        return this.size;
    }

    public final void place(@NotNull Placeable.PlacementScope scope) {
        t.i(scope, "scope");
        int placeablesCount = getPlaceablesCount();
        for (int i10 = 0; i10 < placeablesCount; i10++) {
            Placeable placeable = this.wrappers.get(i10).getPlaceable();
            int mainAxisSize = this.minMainAxisOffset - getMainAxisSize(placeable);
            int i11 = this.maxMainAxisOffset;
            long jM565getAnimatedOffsetYT5a7pE = getAnimationSpec(i10) != null ? this.placementAnimator.m565getAnimatedOffsetYT5a7pE(getKey(), i10, mainAxisSize, i11, this.placeableOffset) : this.placeableOffset;
            if (m573getMainAxisgyyYBs(jM565getAnimatedOffsetYT5a7pE) > mainAxisSize && m573getMainAxisgyyYBs(jM565getAnimatedOffsetYT5a7pE) < i11) {
                if (this.isVertical) {
                    long j10 = this.visualOffset;
                    Placeable.PlacementScope.m3020placeWithLayeraW9wM$default(scope, placeable, IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jM565getAnimatedOffsetYT5a7pE) + IntOffset.m3791getXimpl(j10), IntOffset.m3792getYimpl(jM565getAnimatedOffsetYT5a7pE) + IntOffset.m3792getYimpl(j10)), 0.0f, null, 6, null);
                } else {
                    long j11 = this.visualOffset;
                    Placeable.PlacementScope.m3019placeRelativeWithLayeraW9wM$default(scope, placeable, IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jM565getAnimatedOffsetYT5a7pE) + IntOffset.m3791getXimpl(j11), IntOffset.m3792getYimpl(jM565getAnimatedOffsetYT5a7pE) + IntOffset.m3792getYimpl(j11)), 0.0f, null, 6, null);
                }
            }
        }
    }

    private LazyGridPositionedItem(long j10, long j11, int i10, Object obj, int i11, int i12, long j12, int i13, int i14, int i15, int i16, boolean z10, List<LazyGridPlaceableWrapper> list, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, long j13) {
        this.offset = j10;
        this.placeableOffset = j11;
        this.index = i10;
        this.key = obj;
        this.row = i11;
        this.column = i12;
        this.size = j12;
        this.lineMainAxisSize = i13;
        this.mainAxisSpacing = i14;
        this.minMainAxisOffset = i15;
        this.maxMainAxisOffset = i16;
        this.isVertical = z10;
        this.wrappers = list;
        this.placementAnimator = lazyGridItemPlacementAnimator;
        this.visualOffset = j13;
        int placeablesCount = getPlaceablesCount();
        boolean z11 = false;
        int i17 = 0;
        while (true) {
            if (i17 >= placeablesCount) {
                break;
            }
            if (getAnimationSpec(i17) != null) {
                z11 = true;
                break;
            }
            i17++;
        }
        this.hasAnimations = z11;
    }

    private final int getMainAxisSize(Placeable placeable) {
        return this.isVertical ? placeable.getHeight() : placeable.getWidth();
    }
}
