package androidx.compose.foundation.lazy.grid;

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

/* JADX INFO: compiled from: LazyGridMeasure.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyGridMeasureKt {
    private static final List<LazyGridPositionedItem> calculateItemsOffsets(List<LazyMeasuredLine> list, int i10, int i11, int i12, int i13, int i14, boolean z10, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z11, Density density) {
        int i15 = z10 ? i11 : i10;
        boolean z12 = i12 < Math.min(i15, i13);
        if (z12) {
            if (!(i14 == 0)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        int size = list.size();
        int length = 0;
        for (int i16 = 0; i16 < size; i16++) {
            length += list.get(i16).getItems().length;
        }
        ArrayList arrayList = new ArrayList(length);
        if (z12) {
            int size2 = list.size();
            int[] iArr = new int[size2];
            for (int i17 = 0; i17 < size2; i17++) {
                iArr[i17] = list.get(calculateItemsOffsets$reverseAware(i17, z11, size2)).getMainAxisSize();
            }
            int[] iArr2 = new int[size2];
            for (int i18 = 0; i18 < size2; i18++) {
                iArr2[i18] = 0;
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
                    int mainAxisSize = iArr2[iB];
                    LazyMeasuredLine lazyMeasuredLine = list.get(calculateItemsOffsets$reverseAware(iB, z11, size2));
                    if (z11) {
                        mainAxisSize = (i15 - mainAxisSize) - lazyMeasuredLine.getMainAxisSize();
                    }
                    arrayList.addAll(lazyMeasuredLine.position(mainAxisSize, i10, i11));
                    if (iB == iE) {
                        break;
                    }
                    iB += iF;
                }
            }
        } else {
            int size3 = list.size();
            int mainAxisSizeWithSpacings = i14;
            for (int i19 = 0; i19 < size3; i19++) {
                LazyMeasuredLine lazyMeasuredLine2 = list.get(i19);
                arrayList.addAll(lazyMeasuredLine2.position(mainAxisSizeWithSpacings, i10, i11));
                mainAxisSizeWithSpacings += lazyMeasuredLine2.getMainAxisSizeWithSpacings();
            }
        }
        return arrayList;
    }

    private static final int calculateItemsOffsets$reverseAware(int i10, boolean z10, int i11) {
        return !z10 ? i10 : (i11 - i10) - 1;
    }

    @NotNull
    /* JADX INFO: renamed from: measureLazyGrid-zIfe3eg, reason: not valid java name */
    public static final LazyGridMeasureResult m571measureLazyGridzIfe3eg(int i10, @NotNull LazyMeasuredLineProvider lazyMeasuredLineProvider, @NotNull LazyMeasuredItemProvider measuredItemProvider, int i11, int i12, int i13, int i14, int i15, int i16, float f10, long j10, boolean z10, @Nullable Arrangement.Vertical vertical, @Nullable Arrangement.Horizontal horizontal, boolean z11, @NotNull Density density, @NotNull LazyGridItemPlacementAnimator placementAnimator, @NotNull q<? super Integer, ? super Integer, ? super l<? super Placeable.PlacementScope, k0>, ? extends MeasureResult> layout) {
        int iM593constructorimpl;
        int i17;
        int i18;
        LazyMeasuredLine lazyMeasuredLine;
        LazyMeasuredLineProvider measuredLineProvider = lazyMeasuredLineProvider;
        t.i(measuredLineProvider, "measuredLineProvider");
        t.i(measuredItemProvider, "measuredItemProvider");
        t.i(density, "density");
        t.i(placementAnimator, "placementAnimator");
        t.i(layout, "layout");
        if (!(i13 >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(i14 >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (i10 <= 0) {
            return new LazyGridMeasureResult(null, 0, false, 0.0f, layout.invoke(Integer.valueOf(Constraints.m3643getMinWidthimpl(j10)), Integer.valueOf(Constraints.m3642getMinHeightimpl(j10)), LazyGridMeasureKt$measureLazyGrid$1.INSTANCE), v.l(), -i13, i11 + i14, 0, z11, z10 ? Orientation.Vertical : Orientation.Horizontal, i14);
        }
        int iC = c.c(f10);
        int i19 = i16 - iC;
        int iM593constructorimpl2 = i15;
        if (LineIndex.m596equalsimpl0(iM593constructorimpl2, LineIndex.m593constructorimpl(0)) && i19 < 0) {
            iC += i19;
            i19 = 0;
        }
        ArrayList arrayList = new ArrayList();
        int mainAxisSizeWithSpacings = i19 - i13;
        int i20 = -i13;
        while (mainAxisSizeWithSpacings < 0 && iM593constructorimpl2 - LineIndex.m593constructorimpl(0) > 0) {
            iM593constructorimpl2 = LineIndex.m593constructorimpl(iM593constructorimpl2 - 1);
            LazyMeasuredLine lazyMeasuredLineM589getAndMeasurebKFJvoY = measuredLineProvider.m589getAndMeasurebKFJvoY(iM593constructorimpl2);
            arrayList.add(0, lazyMeasuredLineM589getAndMeasurebKFJvoY);
            mainAxisSizeWithSpacings += lazyMeasuredLineM589getAndMeasurebKFJvoY.getMainAxisSizeWithSpacings();
        }
        if (mainAxisSizeWithSpacings < i20) {
            iC += mainAxisSizeWithSpacings;
            mainAxisSizeWithSpacings = i20;
        }
        int i21 = mainAxisSizeWithSpacings + i13;
        int i22 = i11 + i14;
        int i23 = iM593constructorimpl2;
        int iE = o.e(i22, 0);
        int mainAxisSizeWithSpacings2 = -i21;
        int size = arrayList.size();
        int iM593constructorimpl3 = i23;
        int i24 = i22;
        for (int i25 = 0; i25 < size; i25++) {
            LazyMeasuredLine lazyMeasuredLine2 = (LazyMeasuredLine) arrayList.get(i25);
            iM593constructorimpl3 = LineIndex.m593constructorimpl(iM593constructorimpl3 + 1);
            mainAxisSizeWithSpacings2 += lazyMeasuredLine2.getMainAxisSizeWithSpacings();
        }
        int mainAxisSizeWithSpacings3 = i21;
        int iM593constructorimpl4 = iM593constructorimpl3;
        while (true) {
            if (mainAxisSizeWithSpacings2 > iE && !arrayList.isEmpty()) {
                break;
            }
            int i26 = iE;
            LazyMeasuredLine lazyMeasuredLineM589getAndMeasurebKFJvoY2 = measuredLineProvider.m589getAndMeasurebKFJvoY(iM593constructorimpl4);
            if (lazyMeasuredLineM589getAndMeasurebKFJvoY2.isEmpty()) {
                LineIndex.m593constructorimpl(iM593constructorimpl4 - 1);
                break;
            }
            int i27 = i20;
            int i28 = i24;
            mainAxisSizeWithSpacings2 += lazyMeasuredLineM589getAndMeasurebKFJvoY2.getMainAxisSizeWithSpacings();
            if (mainAxisSizeWithSpacings2 > i27 || ((LazyMeasuredItem) p.f0(lazyMeasuredLineM589getAndMeasurebKFJvoY2.getItems())).m585getIndexVZbfaAc() == i10 - 1) {
                arrayList.add(lazyMeasuredLineM589getAndMeasurebKFJvoY2);
                iM593constructorimpl = i23;
            } else {
                iM593constructorimpl = LineIndex.m593constructorimpl(iM593constructorimpl4 + 1);
                mainAxisSizeWithSpacings3 -= lazyMeasuredLineM589getAndMeasurebKFJvoY2.getMainAxisSizeWithSpacings();
            }
            iM593constructorimpl4 = LineIndex.m593constructorimpl(iM593constructorimpl4 + 1);
            iE = i26;
            i23 = iM593constructorimpl;
            i20 = i27;
            i24 = i28;
            measuredLineProvider = lazyMeasuredLineProvider;
        }
        if (mainAxisSizeWithSpacings2 < i11) {
            int i29 = i11 - mainAxisSizeWithSpacings2;
            mainAxisSizeWithSpacings3 -= i29;
            mainAxisSizeWithSpacings2 += i29;
            int iM593constructorimpl5 = i23;
            while (true) {
                if (mainAxisSizeWithSpacings3 >= i13) {
                    i17 = i20;
                    i18 = 0;
                    break;
                }
                if (iM593constructorimpl5 - LineIndex.m593constructorimpl(0) <= 0) {
                    i18 = 0;
                    i17 = i20;
                    break;
                }
                iM593constructorimpl5 = LineIndex.m593constructorimpl(iM593constructorimpl5 - 1);
                int i30 = i20;
                LazyMeasuredLine lazyMeasuredLineM589getAndMeasurebKFJvoY3 = measuredLineProvider.m589getAndMeasurebKFJvoY(iM593constructorimpl5);
                arrayList.add(0, lazyMeasuredLineM589getAndMeasurebKFJvoY3);
                mainAxisSizeWithSpacings3 += lazyMeasuredLineM589getAndMeasurebKFJvoY3.getMainAxisSizeWithSpacings();
                i20 = i30;
            }
            iC += i29;
            if (mainAxisSizeWithSpacings3 < 0) {
                iC += mainAxisSizeWithSpacings3;
                mainAxisSizeWithSpacings2 += mainAxisSizeWithSpacings3;
                mainAxisSizeWithSpacings3 = i18;
            }
        } else {
            i17 = i20;
            i18 = 0;
        }
        float f11 = (c.a(c.c(f10)) != c.a(iC) || Math.abs(c.c(f10)) < Math.abs(iC)) ? f10 : iC;
        int i31 = -mainAxisSizeWithSpacings3;
        LazyMeasuredLine lazyMeasuredLine3 = (LazyMeasuredLine) d0.i0(arrayList);
        if (i13 > 0) {
            int size2 = arrayList.size();
            LazyMeasuredLine lazyMeasuredLine4 = lazyMeasuredLine3;
            int i32 = i18;
            while (i32 < size2) {
                int mainAxisSizeWithSpacings4 = ((LazyMeasuredLine) arrayList.get(i32)).getMainAxisSizeWithSpacings();
                if (mainAxisSizeWithSpacings3 == 0 || mainAxisSizeWithSpacings4 > mainAxisSizeWithSpacings3 || i32 == v.m(arrayList)) {
                    break;
                }
                mainAxisSizeWithSpacings3 -= mainAxisSizeWithSpacings4;
                i32++;
                lazyMeasuredLine4 = (LazyMeasuredLine) arrayList.get(i32);
            }
            lazyMeasuredLine = lazyMeasuredLine4;
        } else {
            lazyMeasuredLine = lazyMeasuredLine3;
        }
        int i33 = mainAxisSizeWithSpacings3;
        int iM3641getMaxWidthimpl = z10 ? Constraints.m3641getMaxWidthimpl(j10) : ConstraintsKt.m3655constrainWidthK40F9xA(j10, mainAxisSizeWithSpacings2);
        int iM3654constrainHeightK40F9xA = z10 ? ConstraintsKt.m3654constrainHeightK40F9xA(j10, mainAxisSizeWithSpacings2) : Constraints.m3640getMaxHeightimpl(j10);
        int i34 = i24;
        float f12 = f11;
        int i35 = i17;
        List<LazyGridPositionedItem> listCalculateItemsOffsets = calculateItemsOffsets(arrayList, iM3641getMaxWidthimpl, iM3654constrainHeightK40F9xA, mainAxisSizeWithSpacings2, i11, i31, z10, vertical, horizontal, z11, density);
        int i36 = mainAxisSizeWithSpacings2;
        placementAnimator.onMeasured((int) f12, iM3641getMaxWidthimpl, iM3654constrainHeightK40F9xA, i12, z11, listCalculateItemsOffsets, measuredItemProvider);
        return new LazyGridMeasureResult(lazyMeasuredLine, i33, i36 > i11, f12, layout.invoke(Integer.valueOf(iM3641getMaxWidthimpl), Integer.valueOf(iM3654constrainHeightK40F9xA), new LazyGridMeasureKt$measureLazyGrid$3(listCalculateItemsOffsets)), listCalculateItemsOffsets, i35, i34, i10, z11, z10 ? Orientation.Vertical : Orientation.Horizontal, i14);
    }
}
