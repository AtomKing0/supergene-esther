package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LazyMeasuredItem.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListPositionedItem implements LazyListItemInfo {
    private final boolean hasAnimations;
    private final int index;
    private final boolean isVertical;

    @NotNull
    private final Object key;
    private final int maxMainAxisOffset;
    private final int minMainAxisOffset;
    private final int offset;

    @NotNull
    private final LazyListItemPlacementAnimator placementAnimator;
    private final int size;
    private final int sizeWithSpacings;
    private final long visualOffset;

    @NotNull
    private final List<LazyListPlaceableWrapper> wrappers;

    public /* synthetic */ LazyListPositionedItem(int i10, int i11, Object obj, int i12, int i13, int i14, int i15, boolean z10, List list, LazyListItemPlacementAnimator lazyListItemPlacementAnimator, long j10, k kVar) {
        this(i10, i11, obj, i12, i13, i14, i15, z10, list, lazyListItemPlacementAnimator, j10);
    }

    @Nullable
    public final FiniteAnimationSpec<IntOffset> getAnimationSpec(int i10) {
        Object parentData = this.wrappers.get(i10).getParentData();
        if (parentData instanceof FiniteAnimationSpec) {
            return (FiniteAnimationSpec) parentData;
        }
        return null;
    }

    public final boolean getHasAnimations() {
        return this.hasAnimations;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    @NotNull
    public Object getKey() {
        return this.key;
    }

    public final int getMainAxisSize(int i10) {
        return getMainAxisSize(this.wrappers.get(i10).getPlaceable());
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getOffset() {
        return this.offset;
    }

    /* JADX INFO: renamed from: getOffset-Bjo55l4, reason: not valid java name */
    public final long m517getOffsetBjo55l4(int i10) {
        return this.wrappers.get(i10).m516getOffsetnOccac();
    }

    public final int getPlaceablesCount() {
        return this.wrappers.size();
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getSize() {
        return this.size;
    }

    public final int getSizeWithSpacings() {
        return this.sizeWithSpacings;
    }

    public final void place(@NotNull Placeable.PlacementScope scope) {
        t.i(scope, "scope");
        int placeablesCount = getPlaceablesCount();
        for (int i10 = 0; i10 < placeablesCount; i10++) {
            Placeable placeable = this.wrappers.get(i10).getPlaceable();
            long jM511getAnimatedOffsetYT5a7pE = getAnimationSpec(i10) != null ? this.placementAnimator.m511getAnimatedOffsetYT5a7pE(getKey(), i10, this.minMainAxisOffset - getMainAxisSize(placeable), this.maxMainAxisOffset, m517getOffsetBjo55l4(i10)) : m517getOffsetBjo55l4(i10);
            if (this.isVertical) {
                long j10 = this.visualOffset;
                Placeable.PlacementScope.m3020placeWithLayeraW9wM$default(scope, placeable, IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jM511getAnimatedOffsetYT5a7pE) + IntOffset.m3791getXimpl(j10), IntOffset.m3792getYimpl(jM511getAnimatedOffsetYT5a7pE) + IntOffset.m3792getYimpl(j10)), 0.0f, null, 6, null);
            } else {
                long j11 = this.visualOffset;
                Placeable.PlacementScope.m3019placeRelativeWithLayeraW9wM$default(scope, placeable, IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jM511getAnimatedOffsetYT5a7pE) + IntOffset.m3791getXimpl(j11), IntOffset.m3792getYimpl(jM511getAnimatedOffsetYT5a7pE) + IntOffset.m3792getYimpl(j11)), 0.0f, null, 6, null);
            }
        }
    }

    private LazyListPositionedItem(int i10, int i11, Object obj, int i12, int i13, int i14, int i15, boolean z10, List<LazyListPlaceableWrapper> list, LazyListItemPlacementAnimator lazyListItemPlacementAnimator, long j10) {
        this.offset = i10;
        this.index = i11;
        this.key = obj;
        this.size = i12;
        this.sizeWithSpacings = i13;
        this.minMainAxisOffset = i14;
        this.maxMainAxisOffset = i15;
        this.isVertical = z10;
        this.wrappers = list;
        this.placementAnimator = lazyListItemPlacementAnimator;
        this.visualOffset = j10;
        int placeablesCount = getPlaceablesCount();
        boolean z11 = false;
        int i16 = 0;
        while (true) {
            if (i16 >= placeablesCount) {
                break;
            }
            if (getAnimationSpec(i16) != null) {
                z11 = true;
                break;
            }
            i16++;
        }
        this.hasAnimations = z11;
    }

    private final int getMainAxisSize(Placeable placeable) {
        return this.isVertical ? placeable.getHeight() : placeable.getWidth();
    }
}
