package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.d0;
import kotlin.collections.r0;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: LazyGridItemPlacementAnimator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyGridItemPlacementAnimator {
    private final boolean isVertical;

    @NotNull
    private Map<Object, Integer> keyToIndexMap;

    @NotNull
    private final Map<Object, ItemInfo> keyToItemInfoMap;

    @NotNull
    private final Set<Object> positionedKeys;

    @NotNull
    private final o0 scope;
    private int slotsPerLine;
    private int viewportEndItemIndex;
    private int viewportEndItemNotVisiblePartSize;
    private int viewportStartItemIndex;
    private int viewportStartItemNotVisiblePartSize;

    public LazyGridItemPlacementAnimator(@NotNull o0 scope, boolean z10) {
        t.i(scope, "scope");
        this.scope = scope;
        this.isVertical = z10;
        this.keyToItemInfoMap = new LinkedHashMap();
        this.keyToIndexMap = r0.g();
        this.viewportStartItemIndex = -1;
        this.viewportEndItemIndex = -1;
        this.positionedKeys = new LinkedHashSet();
    }

    /* JADX INFO: renamed from: calculateExpectedOffset-tGxSNXI, reason: not valid java name */
    private final int m562calculateExpectedOffsettGxSNXI(int i10, int i11, int i12, long j10, boolean z10, int i13, int i14) {
        boolean z11 = false;
        if (!(this.slotsPerLine != 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i15 = this.viewportEndItemIndex;
        boolean z12 = z10 ? i15 > i10 : i15 < i10;
        if (z10 ? this.viewportStartItemIndex < i10 : this.viewportStartItemIndex > i10) {
            z11 = true;
        }
        if (z12) {
            int iAbs = Math.abs(i10 - this.viewportEndItemIndex);
            int i16 = this.slotsPerLine;
            return i13 + this.viewportEndItemNotVisiblePartSize + (i12 * ((((iAbs + i16) - 1) / i16) - 1)) + m563getMainAxisgyyYBs(j10);
        }
        if (!z11) {
            return i14;
        }
        int iAbs2 = Math.abs(this.viewportStartItemIndex - i10);
        int i17 = this.slotsPerLine;
        return ((this.viewportStartItemNotVisiblePartSize - i11) - (i12 * ((((iAbs2 + i17) - 1) / i17) - 1))) + m563getMainAxisgyyYBs(j10);
    }

    /* JADX INFO: renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m563getMainAxisgyyYBs(long j10) {
        return this.isVertical ? IntOffset.m3792getYimpl(j10) : IntOffset.m3791getXimpl(j10);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void startAnimationsIfNeeded(androidx.compose.foundation.lazy.grid.LazyGridPositionedItem r18, androidx.compose.foundation.lazy.grid.ItemInfo r19) {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator.startAnimationsIfNeeded(androidx.compose.foundation.lazy.grid.LazyGridPositionedItem, androidx.compose.foundation.lazy.grid.ItemInfo):void");
    }

    /* JADX INFO: renamed from: toOffset-Bjo55l4, reason: not valid java name */
    private final long m564toOffsetBjo55l4(int i10) {
        boolean z10 = this.isVertical;
        int i11 = z10 ? 0 : i10;
        if (!z10) {
            i10 = 0;
        }
        return IntOffsetKt.IntOffset(i11, i10);
    }

    /* JADX INFO: renamed from: getAnimatedOffset-YT5a7pE, reason: not valid java name */
    public final long m565getAnimatedOffsetYT5a7pE(@NotNull Object key, int i10, int i11, int i12, long j10) {
        t.i(key, "key");
        ItemInfo itemInfo = this.keyToItemInfoMap.get(key);
        if (itemInfo == null) {
            return j10;
        }
        PlaceableInfo placeableInfo = itemInfo.getPlaceables().get(i10);
        long jM3800unboximpl = placeableInfo.getAnimatedOffset().getValue().m3800unboximpl();
        long jM552getNotAnimatableDeltanOccac = itemInfo.m552getNotAnimatableDeltanOccac();
        long jIntOffset = IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jM3800unboximpl) + IntOffset.m3791getXimpl(jM552getNotAnimatableDeltanOccac), IntOffset.m3792getYimpl(jM3800unboximpl) + IntOffset.m3792getYimpl(jM552getNotAnimatableDeltanOccac));
        long jM604getTargetOffsetnOccac = placeableInfo.m604getTargetOffsetnOccac();
        long jM552getNotAnimatableDeltanOccac2 = itemInfo.m552getNotAnimatableDeltanOccac();
        long jIntOffset2 = IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jM604getTargetOffsetnOccac) + IntOffset.m3791getXimpl(jM552getNotAnimatableDeltanOccac2), IntOffset.m3792getYimpl(jM604getTargetOffsetnOccac) + IntOffset.m3792getYimpl(jM552getNotAnimatableDeltanOccac2));
        if (placeableInfo.getInProgress() && ((m563getMainAxisgyyYBs(jIntOffset2) < i11 && m563getMainAxisgyyYBs(jIntOffset) < i11) || (m563getMainAxisgyyYBs(jIntOffset2) > i12 && m563getMainAxisgyyYBs(jIntOffset) > i12))) {
            k.d(this.scope, null, null, new LazyGridItemPlacementAnimator$getAnimatedOffset$1(placeableInfo, null), 3, null);
        }
        return jIntOffset;
    }

    public final void onMeasured(int i10, int i11, int i12, int i13, boolean z10, @NotNull List<LazyGridPositionedItem> positionedItems, @NotNull LazyMeasuredItemProvider measuredItemProvider) {
        boolean z11;
        boolean z12;
        boolean z13;
        int i14;
        int i15;
        long j10;
        ItemInfo itemInfo;
        LazyGridPositionedItem lazyGridPositionedItem;
        int iM562calculateExpectedOffsettGxSNXI;
        t.i(positionedItems, "positionedItems");
        t.i(measuredItemProvider, "measuredItemProvider");
        int size = positionedItems.size();
        int i16 = 0;
        while (true) {
            if (i16 >= size) {
                z11 = false;
                break;
            } else {
                if (positionedItems.get(i16).getHasAnimations()) {
                    z11 = true;
                    break;
                }
                i16++;
            }
        }
        if (!z11) {
            reset();
            return;
        }
        this.slotsPerLine = i13;
        int i17 = this.isVertical ? i12 : i11;
        int i18 = i10;
        if (z10) {
            i18 = -i18;
        }
        long jM564toOffsetBjo55l4 = m564toOffsetBjo55l4(i18);
        LazyGridPositionedItem lazyGridPositionedItem2 = (LazyGridPositionedItem) d0.i0(positionedItems);
        LazyGridPositionedItem lazyGridPositionedItem3 = (LazyGridPositionedItem) d0.t0(positionedItems);
        int size2 = positionedItems.size();
        for (int i19 = 0; i19 < size2; i19++) {
            LazyGridPositionedItem lazyGridPositionedItem4 = positionedItems.get(i19);
            ItemInfo itemInfo2 = this.keyToItemInfoMap.get(lazyGridPositionedItem4.getKey());
            if (itemInfo2 != null) {
                itemInfo2.setIndex(lazyGridPositionedItem4.getIndex());
                itemInfo2.setCrossAxisSize(lazyGridPositionedItem4.getCrossAxisSize());
                itemInfo2.setCrossAxisOffset(lazyGridPositionedItem4.getCrossAxisOffset());
            }
        }
        LazyGridItemPlacementAnimator$onMeasured$averageLineMainAxisSize$1$lineOf$1 lazyGridItemPlacementAnimator$onMeasured$averageLineMainAxisSize$1$lineOf$1 = new LazyGridItemPlacementAnimator$onMeasured$averageLineMainAxisSize$1$lineOf$1(this, positionedItems);
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        while (i20 < positionedItems.size()) {
            int iIntValue = lazyGridItemPlacementAnimator$onMeasured$averageLineMainAxisSize$1$lineOf$1.invoke(Integer.valueOf(i20)).intValue();
            if (iIntValue == -1) {
                i20++;
            } else {
                int iMax = 0;
                while (i20 < positionedItems.size() && lazyGridItemPlacementAnimator$onMeasured$averageLineMainAxisSize$1$lineOf$1.invoke(Integer.valueOf(i20)).intValue() == iIntValue) {
                    iMax = Math.max(iMax, positionedItems.get(i20).getMainAxisSizeWithSpacings());
                    i20++;
                }
                i21 += iMax;
                i22++;
            }
        }
        int i23 = i21 / i22;
        this.positionedKeys.clear();
        int i24 = 0;
        for (int size3 = positionedItems.size(); i24 < size3; size3 = i15) {
            LazyGridPositionedItem lazyGridPositionedItem5 = positionedItems.get(i24);
            this.positionedKeys.add(lazyGridPositionedItem5.getKey());
            ItemInfo itemInfo3 = this.keyToItemInfoMap.get(lazyGridPositionedItem5.getKey());
            if (itemInfo3 != null) {
                i14 = i24;
                i15 = size3;
                if (lazyGridPositionedItem5.getHasAnimations()) {
                    long jM552getNotAnimatableDeltanOccac = itemInfo3.m552getNotAnimatableDeltanOccac();
                    itemInfo3.m553setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jM552getNotAnimatableDeltanOccac) + IntOffset.m3791getXimpl(jM564toOffsetBjo55l4), IntOffset.m3792getYimpl(jM552getNotAnimatableDeltanOccac) + IntOffset.m3792getYimpl(jM564toOffsetBjo55l4)));
                    startAnimationsIfNeeded(lazyGridPositionedItem5, itemInfo3);
                } else {
                    this.keyToItemInfoMap.remove(lazyGridPositionedItem5.getKey());
                }
            } else if (lazyGridPositionedItem5.getHasAnimations()) {
                ItemInfo itemInfo4 = new ItemInfo(lazyGridPositionedItem5.getIndex(), lazyGridPositionedItem5.getCrossAxisSize(), lazyGridPositionedItem5.getCrossAxisOffset());
                Integer num = this.keyToIndexMap.get(lazyGridPositionedItem5.getKey());
                long jM574getPlaceableOffsetnOccac = lazyGridPositionedItem5.m574getPlaceableOffsetnOccac();
                if (num == null) {
                    iM562calculateExpectedOffsettGxSNXI = m563getMainAxisgyyYBs(jM574getPlaceableOffsetnOccac);
                    j10 = jM574getPlaceableOffsetnOccac;
                    itemInfo = itemInfo4;
                    lazyGridPositionedItem = lazyGridPositionedItem5;
                    i14 = i24;
                    i15 = size3;
                } else {
                    j10 = jM574getPlaceableOffsetnOccac;
                    itemInfo = itemInfo4;
                    lazyGridPositionedItem = lazyGridPositionedItem5;
                    i14 = i24;
                    i15 = size3;
                    iM562calculateExpectedOffsettGxSNXI = m562calculateExpectedOffsettGxSNXI(num.intValue(), lazyGridPositionedItem5.getMainAxisSizeWithSpacings(), i23, jM564toOffsetBjo55l4, z10, i17, !z10 ? m563getMainAxisgyyYBs(jM574getPlaceableOffsetnOccac) : m563getMainAxisgyyYBs(jM574getPlaceableOffsetnOccac) - lazyGridPositionedItem5.getMainAxisSizeWithSpacings());
                }
                long jM3787copyiSbpLlY$default = this.isVertical ? IntOffset.m3787copyiSbpLlY$default(j10, 0, iM562calculateExpectedOffsettGxSNXI, 1, null) : IntOffset.m3787copyiSbpLlY$default(j10, iM562calculateExpectedOffsettGxSNXI, 0, 2, null);
                int placeablesCount = lazyGridPositionedItem.getPlaceablesCount();
                for (int i25 = 0; i25 < placeablesCount; i25++) {
                    itemInfo.getPlaceables().add(new PlaceableInfo(jM3787copyiSbpLlY$default, lazyGridPositionedItem.getMainAxisSize(i25), null));
                    k0 k0Var = k0.f35197a;
                }
                LazyGridPositionedItem lazyGridPositionedItem6 = lazyGridPositionedItem;
                ItemInfo itemInfo5 = itemInfo;
                this.keyToItemInfoMap.put(lazyGridPositionedItem6.getKey(), itemInfo5);
                startAnimationsIfNeeded(lazyGridPositionedItem6, itemInfo5);
            } else {
                i14 = i24;
                i15 = size3;
            }
            i24 = i14 + 1;
        }
        if (z10) {
            this.viewportStartItemIndex = lazyGridPositionedItem3.getIndex();
            this.viewportStartItemNotVisiblePartSize = (i17 - m563getMainAxisgyyYBs(lazyGridPositionedItem3.mo560getOffsetnOccac())) - lazyGridPositionedItem3.getLineMainAxisSize();
            this.viewportEndItemIndex = lazyGridPositionedItem2.getIndex();
            this.viewportEndItemNotVisiblePartSize = (-m563getMainAxisgyyYBs(lazyGridPositionedItem2.mo560getOffsetnOccac())) + (lazyGridPositionedItem2.getLineMainAxisSizeWithSpacings() - (this.isVertical ? IntSize.m3832getHeightimpl(lazyGridPositionedItem2.mo561getSizeYbymL2g()) : IntSize.m3833getWidthimpl(lazyGridPositionedItem2.mo561getSizeYbymL2g())));
        } else {
            this.viewportStartItemIndex = lazyGridPositionedItem2.getIndex();
            this.viewportStartItemNotVisiblePartSize = m563getMainAxisgyyYBs(lazyGridPositionedItem2.mo560getOffsetnOccac());
            this.viewportEndItemIndex = lazyGridPositionedItem3.getIndex();
            this.viewportEndItemNotVisiblePartSize = (m563getMainAxisgyyYBs(lazyGridPositionedItem3.mo560getOffsetnOccac()) + lazyGridPositionedItem3.getLineMainAxisSizeWithSpacings()) - i17;
        }
        Iterator<Map.Entry<Object, ItemInfo>> it = this.keyToItemInfoMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Object, ItemInfo> next = it.next();
            if (!this.positionedKeys.contains(next.getKey())) {
                ItemInfo value = next.getValue();
                long jM552getNotAnimatableDeltanOccac2 = value.m552getNotAnimatableDeltanOccac();
                value.m553setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jM552getNotAnimatableDeltanOccac2) + IntOffset.m3791getXimpl(jM564toOffsetBjo55l4), IntOffset.m3792getYimpl(jM552getNotAnimatableDeltanOccac2) + IntOffset.m3792getYimpl(jM564toOffsetBjo55l4)));
                Integer num2 = measuredItemProvider.getKeyToIndexMap().get(next.getKey());
                List<PlaceableInfo> placeables = value.getPlaceables();
                int size4 = placeables.size();
                int i26 = 0;
                while (true) {
                    if (i26 >= size4) {
                        z12 = false;
                        break;
                    }
                    PlaceableInfo placeableInfo = placeables.get(i26);
                    long jM604getTargetOffsetnOccac = placeableInfo.m604getTargetOffsetnOccac();
                    long jM552getNotAnimatableDeltanOccac3 = value.m552getNotAnimatableDeltanOccac();
                    long jIntOffset = IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jM604getTargetOffsetnOccac) + IntOffset.m3791getXimpl(jM552getNotAnimatableDeltanOccac3), IntOffset.m3792getYimpl(jM604getTargetOffsetnOccac) + IntOffset.m3792getYimpl(jM552getNotAnimatableDeltanOccac3));
                    if (m563getMainAxisgyyYBs(jIntOffset) + placeableInfo.getMainAxisSize() > 0 && m563getMainAxisgyyYBs(jIntOffset) < i17) {
                        z12 = true;
                        break;
                    }
                    i26++;
                }
                List<PlaceableInfo> placeables2 = value.getPlaceables();
                int size5 = placeables2.size();
                int i27 = 0;
                while (true) {
                    if (i27 >= size5) {
                        z13 = false;
                        break;
                    } else {
                        if (placeables2.get(i27).getInProgress()) {
                            z13 = true;
                            break;
                        }
                        i27++;
                    }
                }
                boolean z14 = !z13;
                if ((!z12 && z14) || num2 == null || value.getPlaceables().isEmpty()) {
                    it.remove();
                } else {
                    LazyMeasuredItem lazyMeasuredItemM586getAndMeasureednRnyU$default = LazyMeasuredItemProvider.m586getAndMeasureednRnyU$default(measuredItemProvider, ItemIndex.m541constructorimpl(num2.intValue()), 0, this.isVertical ? Constraints.Companion.m3651fixedWidthOenEA2s(value.getCrossAxisSize()) : Constraints.Companion.m3650fixedHeightOenEA2s(value.getCrossAxisSize()), 2, null);
                    int iM562calculateExpectedOffsettGxSNXI2 = m562calculateExpectedOffsettGxSNXI(num2.intValue(), lazyMeasuredItemM586getAndMeasureednRnyU$default.getMainAxisSizeWithSpacings(), i23, jM564toOffsetBjo55l4, z10, i17, i17);
                    if (z10) {
                        iM562calculateExpectedOffsettGxSNXI2 = (i17 - iM562calculateExpectedOffsettGxSNXI2) - lazyMeasuredItemM586getAndMeasureednRnyU$default.getMainAxisSize();
                    }
                    LazyGridPositionedItem lazyGridPositionedItemPosition = lazyMeasuredItemM586getAndMeasureednRnyU$default.position(iM562calculateExpectedOffsettGxSNXI2, value.getCrossAxisOffset(), i11, i12, -1, -1, lazyMeasuredItemM586getAndMeasureednRnyU$default.getMainAxisSize());
                    positionedItems.add(lazyGridPositionedItemPosition);
                    startAnimationsIfNeeded(lazyGridPositionedItemPosition, value);
                }
            }
        }
        this.keyToIndexMap = measuredItemProvider.getKeyToIndexMap();
    }

    public final void reset() {
        this.keyToItemInfoMap.clear();
        this.keyToIndexMap = r0.g();
        this.viewportStartItemIndex = -1;
        this.viewportStartItemNotVisiblePartSize = 0;
        this.viewportEndItemIndex = -1;
        this.viewportEndItemNotVisiblePartSize = 0;
    }
}
