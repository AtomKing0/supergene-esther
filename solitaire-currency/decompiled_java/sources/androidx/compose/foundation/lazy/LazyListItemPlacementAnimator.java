package androidx.compose.foundation.lazy;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.d0;
import kotlin.collections.r0;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import n9.i;
import n9.o;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: LazyListItemPlacementAnimator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListItemPlacementAnimator {
    private final boolean isVertical;

    @NotNull
    private Map<Object, Integer> keyToIndexMap;

    @NotNull
    private final Map<Object, ItemInfo> keyToItemInfoMap;

    @NotNull
    private final Set<Object> positionedKeys;

    @NotNull
    private final o0 scope;
    private int viewportEndItemIndex;
    private int viewportEndItemNotVisiblePartSize;
    private int viewportStartItemIndex;
    private int viewportStartItemNotVisiblePartSize;

    public LazyListItemPlacementAnimator(@NotNull o0 scope, boolean z10) {
        t.i(scope, "scope");
        this.scope = scope;
        this.isVertical = z10;
        this.keyToItemInfoMap = new LinkedHashMap();
        this.keyToIndexMap = r0.g();
        this.viewportStartItemIndex = -1;
        this.viewportEndItemIndex = -1;
        this.positionedKeys = new LinkedHashSet();
    }

    /* JADX INFO: renamed from: calculateExpectedOffset-diAxcj4, reason: not valid java name */
    private final int m508calculateExpectedOffsetdiAxcj4(int i10, int i11, int i12, long j10, boolean z10, int i13, int i14, List<LazyListPositionedItem> list) {
        int itemSize = 0;
        int i15 = this.viewportEndItemIndex;
        boolean z11 = z10 ? i15 > i10 : i15 < i10;
        int i16 = this.viewportStartItemIndex;
        boolean z12 = z10 ? i16 < i10 : i16 > i10;
        if (z11) {
            i iVarU = !z10 ? o.u(this.viewportEndItemIndex + 1, i10) : o.u(i10 + 1, this.viewportEndItemIndex);
            int iB = iVarU.b();
            int iE = iVarU.e();
            if (iB <= iE) {
                while (true) {
                    itemSize += getItemSize(list, iB, i12);
                    if (iB == iE) {
                        break;
                    }
                    iB++;
                }
            }
            return i13 + this.viewportEndItemNotVisiblePartSize + itemSize + m509getMainAxisgyyYBs(j10);
        }
        if (!z12) {
            return i14;
        }
        i iVarU2 = !z10 ? o.u(i10 + 1, this.viewportStartItemIndex) : o.u(this.viewportStartItemIndex + 1, i10);
        int iB2 = iVarU2.b();
        int iE2 = iVarU2.e();
        if (iB2 <= iE2) {
            while (true) {
                i11 += getItemSize(list, iB2, i12);
                if (iB2 == iE2) {
                    break;
                }
                iB2++;
            }
        }
        return (this.viewportStartItemNotVisiblePartSize - i11) + m509getMainAxisgyyYBs(j10);
    }

    private final int getItemSize(List<LazyListPositionedItem> list, int i10, int i11) {
        if (!list.isEmpty() && i10 >= ((LazyListPositionedItem) d0.i0(list)).getIndex() && i10 <= ((LazyListPositionedItem) d0.t0(list)).getIndex()) {
            if (i10 - ((LazyListPositionedItem) d0.i0(list)).getIndex() >= ((LazyListPositionedItem) d0.t0(list)).getIndex() - i10) {
                for (int iM = v.m(list); -1 < iM; iM--) {
                    LazyListPositionedItem lazyListPositionedItem = list.get(iM);
                    if (lazyListPositionedItem.getIndex() == i10) {
                        return lazyListPositionedItem.getSizeWithSpacings();
                    }
                    if (lazyListPositionedItem.getIndex() < i10) {
                        break;
                    }
                }
            } else {
                int size = list.size();
                for (int i12 = 0; i12 < size; i12++) {
                    LazyListPositionedItem lazyListPositionedItem2 = list.get(i12);
                    if (lazyListPositionedItem2.getIndex() == i10) {
                        return lazyListPositionedItem2.getSizeWithSpacings();
                    }
                    if (lazyListPositionedItem2.getIndex() > i10) {
                        break;
                    }
                }
            }
        }
        return i11;
    }

    /* JADX INFO: renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m509getMainAxisgyyYBs(long j10) {
        return this.isVertical ? IntOffset.m3792getYimpl(j10) : IntOffset.m3791getXimpl(j10);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void startAnimationsIfNeeded(androidx.compose.foundation.lazy.LazyListPositionedItem r18, androidx.compose.foundation.lazy.ItemInfo r19) {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListItemPlacementAnimator.startAnimationsIfNeeded(androidx.compose.foundation.lazy.LazyListPositionedItem, androidx.compose.foundation.lazy.ItemInfo):void");
    }

    /* JADX INFO: renamed from: toOffset-Bjo55l4, reason: not valid java name */
    private final long m510toOffsetBjo55l4(int i10) {
        boolean z10 = this.isVertical;
        int i11 = z10 ? 0 : i10;
        if (!z10) {
            i10 = 0;
        }
        return IntOffsetKt.IntOffset(i11, i10);
    }

    /* JADX INFO: renamed from: getAnimatedOffset-YT5a7pE, reason: not valid java name */
    public final long m511getAnimatedOffsetYT5a7pE(@NotNull Object key, int i10, int i11, int i12, long j10) {
        t.i(key, "key");
        ItemInfo itemInfo = this.keyToItemInfoMap.get(key);
        if (itemInfo == null) {
            return j10;
        }
        PlaceableInfo placeableInfo = itemInfo.getPlaceables().get(i10);
        long jM3800unboximpl = placeableInfo.getAnimatedOffset().getValue().m3800unboximpl();
        long jM498getNotAnimatableDeltanOccac = itemInfo.m498getNotAnimatableDeltanOccac();
        long jIntOffset = IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jM3800unboximpl) + IntOffset.m3791getXimpl(jM498getNotAnimatableDeltanOccac), IntOffset.m3792getYimpl(jM3800unboximpl) + IntOffset.m3792getYimpl(jM498getNotAnimatableDeltanOccac));
        long jM528getTargetOffsetnOccac = placeableInfo.m528getTargetOffsetnOccac();
        long jM498getNotAnimatableDeltanOccac2 = itemInfo.m498getNotAnimatableDeltanOccac();
        long jIntOffset2 = IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jM528getTargetOffsetnOccac) + IntOffset.m3791getXimpl(jM498getNotAnimatableDeltanOccac2), IntOffset.m3792getYimpl(jM528getTargetOffsetnOccac) + IntOffset.m3792getYimpl(jM498getNotAnimatableDeltanOccac2));
        if (placeableInfo.getInProgress() && ((m509getMainAxisgyyYBs(jIntOffset2) < i11 && m509getMainAxisgyyYBs(jIntOffset) < i11) || (m509getMainAxisgyyYBs(jIntOffset2) > i12 && m509getMainAxisgyyYBs(jIntOffset) > i12))) {
            k.d(this.scope, null, null, new LazyListItemPlacementAnimator$getAnimatedOffset$1(placeableInfo, null), 3, null);
        }
        return jIntOffset;
    }

    public final void onMeasured(int i10, int i11, int i12, boolean z10, @NotNull List<LazyListPositionedItem> positionedItems, @NotNull LazyMeasuredItemProvider itemProvider) {
        boolean z11;
        boolean z12;
        boolean z13;
        int i13;
        int i14;
        long j10;
        ItemInfo itemInfo;
        LazyListPositionedItem lazyListPositionedItem;
        int iM508calculateExpectedOffsetdiAxcj4;
        t.i(positionedItems, "positionedItems");
        t.i(itemProvider, "itemProvider");
        int size = positionedItems.size();
        int i15 = 0;
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
        int i17 = this.isVertical ? i12 : i11;
        int i18 = i10;
        if (z10) {
            i18 = -i18;
        }
        long jM510toOffsetBjo55l4 = m510toOffsetBjo55l4(i18);
        LazyListPositionedItem lazyListPositionedItem2 = (LazyListPositionedItem) d0.i0(positionedItems);
        LazyListPositionedItem lazyListPositionedItem3 = (LazyListPositionedItem) d0.t0(positionedItems);
        int size2 = positionedItems.size();
        int sizeWithSpacings = 0;
        for (int i19 = 0; i19 < size2; i19++) {
            LazyListPositionedItem lazyListPositionedItem4 = positionedItems.get(i19);
            ItemInfo itemInfo2 = this.keyToItemInfoMap.get(lazyListPositionedItem4.getKey());
            if (itemInfo2 != null) {
                itemInfo2.setIndex(lazyListPositionedItem4.getIndex());
            }
            sizeWithSpacings += lazyListPositionedItem4.getSizeWithSpacings();
        }
        int size3 = sizeWithSpacings / positionedItems.size();
        this.positionedKeys.clear();
        int size4 = positionedItems.size();
        int i20 = 0;
        while (i20 < size4) {
            LazyListPositionedItem lazyListPositionedItem5 = positionedItems.get(i20);
            this.positionedKeys.add(lazyListPositionedItem5.getKey());
            ItemInfo itemInfo3 = this.keyToItemInfoMap.get(lazyListPositionedItem5.getKey());
            if (itemInfo3 != null) {
                i13 = i20;
                i14 = size4;
                if (lazyListPositionedItem5.getHasAnimations()) {
                    long jM498getNotAnimatableDeltanOccac = itemInfo3.m498getNotAnimatableDeltanOccac();
                    itemInfo3.m499setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jM498getNotAnimatableDeltanOccac) + IntOffset.m3791getXimpl(jM510toOffsetBjo55l4), IntOffset.m3792getYimpl(jM498getNotAnimatableDeltanOccac) + IntOffset.m3792getYimpl(jM510toOffsetBjo55l4)));
                    startAnimationsIfNeeded(lazyListPositionedItem5, itemInfo3);
                } else {
                    this.keyToItemInfoMap.remove(lazyListPositionedItem5.getKey());
                }
            } else if (lazyListPositionedItem5.getHasAnimations()) {
                ItemInfo itemInfo4 = new ItemInfo(lazyListPositionedItem5.getIndex());
                Integer num = this.keyToIndexMap.get(lazyListPositionedItem5.getKey());
                long jM517getOffsetBjo55l4 = lazyListPositionedItem5.m517getOffsetBjo55l4(i15);
                int mainAxisSize = lazyListPositionedItem5.getMainAxisSize(i15);
                if (num == null) {
                    iM508calculateExpectedOffsetdiAxcj4 = m509getMainAxisgyyYBs(jM517getOffsetBjo55l4);
                    j10 = jM517getOffsetBjo55l4;
                    itemInfo = itemInfo4;
                    lazyListPositionedItem = lazyListPositionedItem5;
                    i13 = i20;
                    i14 = size4;
                } else {
                    j10 = jM517getOffsetBjo55l4;
                    itemInfo = itemInfo4;
                    lazyListPositionedItem = lazyListPositionedItem5;
                    i13 = i20;
                    i14 = size4;
                    iM508calculateExpectedOffsetdiAxcj4 = m508calculateExpectedOffsetdiAxcj4(num.intValue(), lazyListPositionedItem5.getSizeWithSpacings(), size3, jM510toOffsetBjo55l4, z10, i17, !z10 ? m509getMainAxisgyyYBs(jM517getOffsetBjo55l4) : (m509getMainAxisgyyYBs(jM517getOffsetBjo55l4) - lazyListPositionedItem5.getSizeWithSpacings()) + mainAxisSize, positionedItems) + (z10 ? lazyListPositionedItem.getSize() - mainAxisSize : i15);
                }
                long jM3787copyiSbpLlY$default = this.isVertical ? IntOffset.m3787copyiSbpLlY$default(j10, 0, iM508calculateExpectedOffsetdiAxcj4, 1, null) : IntOffset.m3787copyiSbpLlY$default(j10, iM508calculateExpectedOffsetdiAxcj4, 0, 2, null);
                int placeablesCount = lazyListPositionedItem.getPlaceablesCount();
                for (int i21 = i15; i21 < placeablesCount; i21++) {
                    LazyListPositionedItem lazyListPositionedItem6 = lazyListPositionedItem;
                    long jM517getOffsetBjo55l42 = lazyListPositionedItem6.m517getOffsetBjo55l4(i21);
                    long jIntOffset = IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jM517getOffsetBjo55l42) - IntOffset.m3791getXimpl(j10), IntOffset.m3792getYimpl(jM517getOffsetBjo55l42) - IntOffset.m3792getYimpl(j10));
                    itemInfo.getPlaceables().add(new PlaceableInfo(IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jM3787copyiSbpLlY$default) + IntOffset.m3791getXimpl(jIntOffset), IntOffset.m3792getYimpl(jM3787copyiSbpLlY$default) + IntOffset.m3792getYimpl(jIntOffset)), lazyListPositionedItem6.getMainAxisSize(i21), null));
                    k0 k0Var = k0.f35197a;
                }
                LazyListPositionedItem lazyListPositionedItem7 = lazyListPositionedItem;
                ItemInfo itemInfo5 = itemInfo;
                this.keyToItemInfoMap.put(lazyListPositionedItem7.getKey(), itemInfo5);
                startAnimationsIfNeeded(lazyListPositionedItem7, itemInfo5);
            } else {
                i13 = i20;
                i14 = size4;
            }
            i20 = i13 + 1;
            size4 = i14;
            i15 = 0;
        }
        if (z10) {
            this.viewportStartItemIndex = lazyListPositionedItem3.getIndex();
            this.viewportStartItemNotVisiblePartSize = (i17 - lazyListPositionedItem3.getOffset()) - lazyListPositionedItem3.getSize();
            this.viewportEndItemIndex = lazyListPositionedItem2.getIndex();
            this.viewportEndItemNotVisiblePartSize = (-lazyListPositionedItem2.getOffset()) + (lazyListPositionedItem2.getSizeWithSpacings() - lazyListPositionedItem2.getSize());
        } else {
            this.viewportStartItemIndex = lazyListPositionedItem2.getIndex();
            this.viewportStartItemNotVisiblePartSize = lazyListPositionedItem2.getOffset();
            this.viewportEndItemIndex = lazyListPositionedItem3.getIndex();
            this.viewportEndItemNotVisiblePartSize = (lazyListPositionedItem3.getOffset() + lazyListPositionedItem3.getSizeWithSpacings()) - i17;
        }
        Iterator<Map.Entry<Object, ItemInfo>> it = this.keyToItemInfoMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Object, ItemInfo> next = it.next();
            if (!this.positionedKeys.contains(next.getKey())) {
                ItemInfo value = next.getValue();
                long jM498getNotAnimatableDeltanOccac2 = value.m498getNotAnimatableDeltanOccac();
                value.m499setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jM498getNotAnimatableDeltanOccac2) + IntOffset.m3791getXimpl(jM510toOffsetBjo55l4), IntOffset.m3792getYimpl(jM498getNotAnimatableDeltanOccac2) + IntOffset.m3792getYimpl(jM510toOffsetBjo55l4)));
                Integer num2 = itemProvider.getKeyToIndexMap().get(next.getKey());
                List<PlaceableInfo> placeables = value.getPlaceables();
                int size5 = placeables.size();
                int i22 = 0;
                while (true) {
                    if (i22 >= size5) {
                        z12 = false;
                        break;
                    }
                    PlaceableInfo placeableInfo = placeables.get(i22);
                    long jM528getTargetOffsetnOccac = placeableInfo.m528getTargetOffsetnOccac();
                    long jM498getNotAnimatableDeltanOccac3 = value.m498getNotAnimatableDeltanOccac();
                    long jIntOffset2 = IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jM528getTargetOffsetnOccac) + IntOffset.m3791getXimpl(jM498getNotAnimatableDeltanOccac3), IntOffset.m3792getYimpl(jM528getTargetOffsetnOccac) + IntOffset.m3792getYimpl(jM498getNotAnimatableDeltanOccac3));
                    if (m509getMainAxisgyyYBs(jIntOffset2) + placeableInfo.getSize() > 0 && m509getMainAxisgyyYBs(jIntOffset2) < i17) {
                        z12 = true;
                        break;
                    }
                    i22++;
                }
                List<PlaceableInfo> placeables2 = value.getPlaceables();
                int size6 = placeables2.size();
                int i23 = 0;
                while (true) {
                    if (i23 >= size6) {
                        z13 = false;
                        break;
                    } else {
                        if (placeables2.get(i23).getInProgress()) {
                            z13 = true;
                            break;
                        }
                        i23++;
                    }
                }
                boolean z14 = !z13;
                if ((!z12 && z14) || num2 == null || value.getPlaceables().isEmpty()) {
                    it.remove();
                } else {
                    LazyMeasuredItem lazyMeasuredItemM526getAndMeasureZjPyQlc = itemProvider.m526getAndMeasureZjPyQlc(DataIndex.m486constructorimpl(num2.intValue()));
                    int iM508calculateExpectedOffsetdiAxcj42 = m508calculateExpectedOffsetdiAxcj4(num2.intValue(), lazyMeasuredItemM526getAndMeasureZjPyQlc.getSizeWithSpacings(), size3, jM510toOffsetBjo55l4, z10, i17, i17, positionedItems);
                    if (z10) {
                        iM508calculateExpectedOffsetdiAxcj42 = (i17 - iM508calculateExpectedOffsetdiAxcj42) - lazyMeasuredItemM526getAndMeasureZjPyQlc.getSize();
                    }
                    LazyListPositionedItem lazyListPositionedItemPosition = lazyMeasuredItemM526getAndMeasureZjPyQlc.position(iM508calculateExpectedOffsetdiAxcj42, i11, i12);
                    positionedItems.add(lazyListPositionedItemPosition);
                    startAnimationsIfNeeded(lazyListPositionedItemPosition, value);
                }
            }
        }
        this.keyToIndexMap = itemProvider.getKeyToIndexMap();
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
