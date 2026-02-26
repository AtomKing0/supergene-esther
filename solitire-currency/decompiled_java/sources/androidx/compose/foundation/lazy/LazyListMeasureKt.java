package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import h9.l;
import h9.q;
import j9.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.d0;
import kotlin.collections.p;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import n9.g;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: LazyListMeasure.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListMeasureKt {
    private static final List<LazyListPositionedItem> calculateItemsOffsets(List<LazyMeasuredItem> list, List<LazyMeasuredItem> list2, List<LazyMeasuredItem> list3, int i10, int i11, int i12, int i13, int i14, boolean z10, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z11, Density density) {
        int i15 = z10 ? i11 : i10;
        boolean z12 = i12 < Math.min(i15, i13);
        if (z12) {
            if (!(i14 == 0)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size() + list3.size());
        if (z12) {
            if (!(list2.isEmpty() && list3.isEmpty())) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            int size = list.size();
            int[] iArr = new int[size];
            for (int i16 = 0; i16 < size; i16++) {
                iArr[i16] = list.get(calculateItemsOffsets$reverseAware(i16, z11, size)).getSize();
            }
            int[] iArr2 = new int[size];
            for (int i17 = 0; i17 < size; i17++) {
                iArr2[i17] = 0;
            }
            if (z10) {
                if (vertical == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                vertical.arrange(density, i15, iArr, iArr2);
            } else {
                if (horizontal == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                horizontal.arrange(density, i15, iArr, LayoutDirection.Ltr, iArr2);
            }
            g gVarP = p.P(iArr2);
            if (z11) {
                gVarP = o.s(gVarP);
            }
            int iB = gVarP.b();
            int iE = gVarP.e();
            int iF = gVarP.f();
            if ((iF > 0 && iB <= iE) || (iF < 0 && iE <= iB)) {
                while (true) {
                    int size2 = iArr2[iB];
                    LazyMeasuredItem lazyMeasuredItem = list.get(calculateItemsOffsets$reverseAware(iB, z11, size));
                    if (z11) {
                        size2 = (i15 - size2) - lazyMeasuredItem.getSize();
                    }
                    arrayList.add(lazyMeasuredItem.position(size2, i10, i11));
                    if (iB == iE) {
                        break;
                    }
                    iB += iF;
                }
            }
        } else {
            int size3 = list2.size();
            int sizeWithSpacings = i14;
            for (int i18 = 0; i18 < size3; i18++) {
                LazyMeasuredItem lazyMeasuredItem2 = list2.get(i18);
                sizeWithSpacings -= lazyMeasuredItem2.getSizeWithSpacings();
                arrayList.add(lazyMeasuredItem2.position(sizeWithSpacings, i10, i11));
            }
            int size4 = list.size();
            int sizeWithSpacings2 = i14;
            for (int i19 = 0; i19 < size4; i19++) {
                LazyMeasuredItem lazyMeasuredItem3 = list.get(i19);
                arrayList.add(lazyMeasuredItem3.position(sizeWithSpacings2, i10, i11));
                sizeWithSpacings2 += lazyMeasuredItem3.getSizeWithSpacings();
            }
            int size5 = list3.size();
            for (int i20 = 0; i20 < size5; i20++) {
                LazyMeasuredItem lazyMeasuredItem4 = list3.get(i20);
                arrayList.add(lazyMeasuredItem4.position(sizeWithSpacings2, i10, i11));
                sizeWithSpacings2 += lazyMeasuredItem4.getSizeWithSpacings();
            }
        }
        return arrayList;
    }

    private static final int calculateItemsOffsets$reverseAware(int i10, boolean z10, int i11) {
        return !z10 ? i10 : (i11 - i10) - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    @NotNull
    /* JADX INFO: renamed from: measureLazyList-7Xnphek, reason: not valid java name */
    public static final LazyListMeasureResult m515measureLazyList7Xnphek(int i10, @NotNull LazyMeasuredItemProvider itemProvider, int i11, int i12, int i13, int i14, int i15, float f10, long j10, boolean z10, @NotNull List<Integer> headerIndexes, @Nullable Arrangement.Vertical vertical, @Nullable Arrangement.Horizontal horizontal, boolean z11, @NotNull Density density, @NotNull LazyListItemPlacementAnimator placementAnimator, @NotNull LazyListBeyondBoundsInfo beyondBoundsInfo, @NotNull q<? super Integer, ? super Integer, ? super l<? super Placeable.PlacementScope, k0>, ? extends MeasureResult> layout) {
        int i16;
        int i17;
        int iM486constructorimpl;
        int i18;
        int i19;
        int i20;
        LazyMeasuredItem lazyMeasuredItem;
        List listL;
        List listL2;
        LazyMeasuredItem lazyMeasuredItem2;
        boolean z12;
        int i21;
        LazyListPositionedItem lazyListPositionedItemFindOrComposeLazyListHeader;
        List<LazyListPositionedItem> list;
        t.i(itemProvider, "itemProvider");
        t.i(headerIndexes, "headerIndexes");
        t.i(density, "density");
        t.i(placementAnimator, "placementAnimator");
        t.i(beyondBoundsInfo, "beyondBoundsInfo");
        t.i(layout, "layout");
        if (!(i12 >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(i13 >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (i10 <= 0) {
            return new LazyListMeasureResult(null, 0, false, 0.0f, layout.invoke(Integer.valueOf(Constraints.m3643getMinWidthimpl(j10)), Integer.valueOf(Constraints.m3642getMinHeightimpl(j10)), LazyListMeasureKt$measureLazyList$1.INSTANCE), v.l(), -i12, i11 + i13, 0, z11, z10 ? Orientation.Vertical : Orientation.Horizontal, i13);
        }
        int iM486constructorimpl2 = i14;
        if (iM486constructorimpl2 >= i10) {
            iM486constructorimpl2 = DataIndex.m486constructorimpl(i10 - 1);
            i16 = 0;
        } else {
            i16 = i15;
        }
        int iC = c.c(f10);
        int i22 = i16 - iC;
        if (DataIndex.m489equalsimpl0(iM486constructorimpl2, DataIndex.m486constructorimpl(0)) && i22 < 0) {
            iC += i22;
            i22 = 0;
        }
        ArrayList arrayList = new ArrayList();
        int sizeWithSpacings = i22 - i12;
        int i23 = -i12;
        int iMax = 0;
        while (sizeWithSpacings < 0 && iM486constructorimpl2 - DataIndex.m486constructorimpl(0) > 0) {
            int iM486constructorimpl3 = DataIndex.m486constructorimpl(iM486constructorimpl2 - 1);
            LazyMeasuredItem lazyMeasuredItemM526getAndMeasureZjPyQlc = itemProvider.m526getAndMeasureZjPyQlc(iM486constructorimpl3);
            arrayList.add(0, lazyMeasuredItemM526getAndMeasureZjPyQlc);
            iMax = Math.max(iMax, lazyMeasuredItemM526getAndMeasureZjPyQlc.getCrossAxisSize());
            sizeWithSpacings += lazyMeasuredItemM526getAndMeasureZjPyQlc.getSizeWithSpacings();
            iM486constructorimpl2 = iM486constructorimpl3;
        }
        if (sizeWithSpacings < i23) {
            iC += sizeWithSpacings;
            sizeWithSpacings = i23;
        }
        int i24 = sizeWithSpacings + i12;
        int i25 = i11 + i13;
        int i26 = iM486constructorimpl2;
        int i27 = iMax;
        int iE = o.e(i25, 0);
        int sizeWithSpacings2 = -i24;
        int size = arrayList.size();
        int iM486constructorimpl4 = i26;
        for (int i28 = 0; i28 < size; i28++) {
            LazyMeasuredItem lazyMeasuredItem3 = (LazyMeasuredItem) arrayList.get(i28);
            iM486constructorimpl4 = DataIndex.m486constructorimpl(iM486constructorimpl4 + 1);
            sizeWithSpacings2 += lazyMeasuredItem3.getSizeWithSpacings();
        }
        int sizeWithSpacings3 = i24;
        int i29 = i27;
        int sizeWithSpacings4 = sizeWithSpacings2;
        int iM486constructorimpl5 = iM486constructorimpl4;
        while (true) {
            if ((sizeWithSpacings4 > iE && !arrayList.isEmpty()) || iM486constructorimpl5 >= i10) {
                break;
            }
            int i30 = iE;
            LazyMeasuredItem lazyMeasuredItemM526getAndMeasureZjPyQlc2 = itemProvider.m526getAndMeasureZjPyQlc(iM486constructorimpl5);
            sizeWithSpacings4 += lazyMeasuredItemM526getAndMeasureZjPyQlc2.getSizeWithSpacings();
            if (sizeWithSpacings4 <= i23) {
                i17 = i23;
                if (iM486constructorimpl5 != i10 - 1) {
                    iM486constructorimpl = DataIndex.m486constructorimpl(iM486constructorimpl5 + 1);
                    sizeWithSpacings3 -= lazyMeasuredItemM526getAndMeasureZjPyQlc2.getSizeWithSpacings();
                }
                iM486constructorimpl5 = DataIndex.m486constructorimpl(iM486constructorimpl5 + 1);
                i26 = iM486constructorimpl;
                iE = i30;
                i23 = i17;
            } else {
                i17 = i23;
            }
            int iMax2 = Math.max(i29, lazyMeasuredItemM526getAndMeasureZjPyQlc2.getCrossAxisSize());
            arrayList.add(lazyMeasuredItemM526getAndMeasureZjPyQlc2);
            i29 = iMax2;
            iM486constructorimpl = i26;
            iM486constructorimpl5 = DataIndex.m486constructorimpl(iM486constructorimpl5 + 1);
            i26 = iM486constructorimpl;
            iE = i30;
            i23 = i17;
        }
        int i31 = i23;
        if (sizeWithSpacings4 < i11) {
            int i32 = i11 - sizeWithSpacings4;
            sizeWithSpacings3 -= i32;
            sizeWithSpacings4 += i32;
            int iMax3 = i29;
            int iM486constructorimpl6 = i26;
            while (sizeWithSpacings3 < i12 && iM486constructorimpl6 - DataIndex.m486constructorimpl(0) > 0) {
                iM486constructorimpl6 = DataIndex.m486constructorimpl(iM486constructorimpl6 - 1);
                LazyMeasuredItem lazyMeasuredItemM526getAndMeasureZjPyQlc3 = itemProvider.m526getAndMeasureZjPyQlc(iM486constructorimpl6);
                arrayList.add(0, lazyMeasuredItemM526getAndMeasureZjPyQlc3);
                iMax3 = Math.max(iMax3, lazyMeasuredItemM526getAndMeasureZjPyQlc3.getCrossAxisSize());
                sizeWithSpacings3 += lazyMeasuredItemM526getAndMeasureZjPyQlc3.getSizeWithSpacings();
            }
            iC += i32;
            if (sizeWithSpacings3 < 0) {
                iC += sizeWithSpacings3;
                i29 = iMax3;
                i18 = sizeWithSpacings4 + sizeWithSpacings3;
                sizeWithSpacings3 = 0;
            } else {
                i29 = iMax3;
                i18 = sizeWithSpacings4;
            }
        } else {
            i18 = sizeWithSpacings4;
        }
        float f11 = (c.a(c.c(f10)) != c.a(iC) || Math.abs(c.c(f10)) < Math.abs(iC)) ? f10 : iC;
        int i33 = -sizeWithSpacings3;
        LazyMeasuredItem lazyMeasuredItem4 = (LazyMeasuredItem) d0.i0(arrayList);
        if (i12 > 0) {
            int size2 = arrayList.size();
            LazyMeasuredItem lazyMeasuredItem5 = lazyMeasuredItem4;
            int i34 = sizeWithSpacings3;
            int i35 = 0;
            while (i35 < size2) {
                int sizeWithSpacings5 = ((LazyMeasuredItem) arrayList.get(i35)).getSizeWithSpacings();
                if (i34 == 0 || sizeWithSpacings5 > i34) {
                    break;
                }
                i19 = i29;
                if (i35 == v.m(arrayList)) {
                    break;
                }
                i34 -= sizeWithSpacings5;
                i35++;
                lazyMeasuredItem5 = (LazyMeasuredItem) arrayList.get(i35);
                i29 = i19;
            }
            i19 = i29;
            i20 = i34;
            lazyMeasuredItem = lazyMeasuredItem5;
        } else {
            i19 = i29;
            i20 = sizeWithSpacings3;
            lazyMeasuredItem = lazyMeasuredItem4;
        }
        if (!beyondBoundsInfo.hasIntervals() || ((LazyMeasuredItem) d0.i0(arrayList)).getIndex() <= measureLazyList_7Xnphek$startIndex(beyondBoundsInfo, i10)) {
            listL = v.l();
        } else {
            listL = new ArrayList();
            int index = ((LazyMeasuredItem) d0.i0(arrayList)).getIndex() - 1;
            int iMeasureLazyList_7Xnphek$startIndex = measureLazyList_7Xnphek$startIndex(beyondBoundsInfo, i10);
            if (iMeasureLazyList_7Xnphek$startIndex <= index) {
                while (true) {
                    listL.add(itemProvider.m526getAndMeasureZjPyQlc(DataIndex.m486constructorimpl(index)));
                    if (index == iMeasureLazyList_7Xnphek$startIndex) {
                        break;
                    }
                    index--;
                }
            }
            k0 k0Var = k0.f35197a;
        }
        List list2 = listL;
        if (!beyondBoundsInfo.hasIntervals() || ((LazyMeasuredItem) d0.t0(arrayList)).getIndex() >= measureLazyList_7Xnphek$endIndex(beyondBoundsInfo, i10)) {
            listL2 = v.l();
        } else {
            ArrayList arrayList2 = new ArrayList();
            int index2 = ((LazyMeasuredItem) d0.t0(arrayList)).getIndex();
            int iMeasureLazyList_7Xnphek$endIndex = measureLazyList_7Xnphek$endIndex(beyondBoundsInfo, i10);
            while (index2 < iMeasureLazyList_7Xnphek$endIndex) {
                index2++;
                arrayList2.add(itemProvider.m526getAndMeasureZjPyQlc(DataIndex.m486constructorimpl(index2)));
            }
            k0 k0Var2 = k0.f35197a;
            listL2 = arrayList2;
        }
        boolean z13 = t.d(lazyMeasuredItem, d0.i0(arrayList)) && list2.isEmpty() && listL2.isEmpty();
        int iM3655constrainWidthK40F9xA = ConstraintsKt.m3655constrainWidthK40F9xA(j10, z10 ? i19 : i18);
        int iM3654constrainHeightK40F9xA = ConstraintsKt.m3654constrainHeightK40F9xA(j10, z10 ? i18 : i19);
        List<LazyListPositionedItem> listCalculateItemsOffsets = calculateItemsOffsets(arrayList, list2, listL2, iM3655constrainWidthK40F9xA, iM3654constrainHeightK40F9xA, i18, i11, i33, z10, vertical, horizontal, z11, density);
        if (!headerIndexes.isEmpty()) {
            lazyMeasuredItem2 = lazyMeasuredItem;
            z12 = false;
            i21 = i31;
            lazyListPositionedItemFindOrComposeLazyListHeader = LazyListHeadersKt.findOrComposeLazyListHeader(listCalculateItemsOffsets, itemProvider, headerIndexes, i12, iM3655constrainWidthK40F9xA, iM3654constrainHeightK40F9xA);
        } else {
            lazyMeasuredItem2 = lazyMeasuredItem;
            z12 = false;
            i21 = i31;
            lazyListPositionedItemFindOrComposeLazyListHeader = null;
        }
        LazyListPositionedItem lazyListPositionedItem = lazyListPositionedItemFindOrComposeLazyListHeader;
        placementAnimator.onMeasured((int) f11, iM3655constrainWidthK40F9xA, iM3654constrainHeightK40F9xA, z11, listCalculateItemsOffsets, itemProvider);
        boolean z14 = i18 > i11 ? true : z12;
        MeasureResult measureResultInvoke = layout.invoke(Integer.valueOf(iM3655constrainWidthK40F9xA), Integer.valueOf(iM3654constrainHeightK40F9xA), new LazyListMeasureKt$measureLazyList$3(listCalculateItemsOffsets, lazyListPositionedItem));
        if (z13) {
            list = listCalculateItemsOffsets;
        } else {
            ArrayList arrayList3 = new ArrayList(listCalculateItemsOffsets.size());
            int size3 = listCalculateItemsOffsets.size();
            for (?? r22 = z12; r22 < size3; r22++) {
                LazyListPositionedItem lazyListPositionedItem2 = listCalculateItemsOffsets.get(r22);
                LazyListPositionedItem lazyListPositionedItem3 = lazyListPositionedItem2;
                if (((lazyListPositionedItem3.getIndex() < ((LazyMeasuredItem) d0.i0(arrayList)).getIndex() || lazyListPositionedItem3.getIndex() > ((LazyMeasuredItem) d0.t0(arrayList)).getIndex()) && lazyListPositionedItem3 != lazyListPositionedItem) ? z12 : true) {
                    arrayList3.add(lazyListPositionedItem2);
                }
            }
            list = arrayList3;
        }
        return new LazyListMeasureResult(lazyMeasuredItem2, i20, z14, f11, measureResultInvoke, list, i21, i25, i10, z11, z10 ? Orientation.Vertical : Orientation.Horizontal, i13);
    }

    private static final int measureLazyList_7Xnphek$endIndex(LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo, int i10) {
        return Math.min(lazyListBeyondBoundsInfo.getEnd(), i10 - 1);
    }

    private static final int measureLazyList_7Xnphek$startIndex(LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo, int i10) {
        return Math.min(lazyListBeyondBoundsInfo.getStart(), i10 - 1);
    }
}
