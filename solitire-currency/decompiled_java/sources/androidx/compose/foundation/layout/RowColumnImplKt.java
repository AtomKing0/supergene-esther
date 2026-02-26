package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import h9.p;
import h9.q;
import h9.s;
import java.util.List;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: RowColumnImpl.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RowColumnImplKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final q<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> MaxIntrinsicHeightMeasureBlock(LayoutOrientation layoutOrientation) {
        return layoutOrientation == LayoutOrientation.Horizontal ? IntrinsicMeasureBlocks.INSTANCE.getHorizontalMaxHeight() : IntrinsicMeasureBlocks.INSTANCE.getVerticalMaxHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final q<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> MaxIntrinsicWidthMeasureBlock(LayoutOrientation layoutOrientation) {
        return layoutOrientation == LayoutOrientation.Horizontal ? IntrinsicMeasureBlocks.INSTANCE.getHorizontalMaxWidth() : IntrinsicMeasureBlocks.INSTANCE.getVerticalMaxWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final q<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> MinIntrinsicHeightMeasureBlock(LayoutOrientation layoutOrientation) {
        return layoutOrientation == LayoutOrientation.Horizontal ? IntrinsicMeasureBlocks.INSTANCE.getHorizontalMinHeight() : IntrinsicMeasureBlocks.INSTANCE.getVerticalMinHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final q<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> MinIntrinsicWidthMeasureBlock(LayoutOrientation layoutOrientation) {
        return layoutOrientation == LayoutOrientation.Horizontal ? IntrinsicMeasureBlocks.INSTANCE.getHorizontalMinWidth() : IntrinsicMeasureBlocks.INSTANCE.getVerticalMinWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CrossAxisAlignment getCrossAxisAlignment(RowColumnParentData rowColumnParentData) {
        if (rowColumnParentData != null) {
            return rowColumnParentData.getCrossAxisAlignment();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RowColumnParentData getData(IntrinsicMeasurable intrinsicMeasurable) {
        Object parentData = intrinsicMeasurable.getParentData();
        if (parentData instanceof RowColumnParentData) {
            return (RowColumnParentData) parentData;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getFill(RowColumnParentData rowColumnParentData) {
        if (rowColumnParentData != null) {
            return rowColumnParentData.getFill();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float getWeight(RowColumnParentData rowColumnParentData) {
        if (rowColumnParentData != null) {
            return rowColumnParentData.getWeight();
        }
        return 0.0f;
    }

    private static final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, p<? super IntrinsicMeasurable, ? super Integer, Integer> pVar, p<? super IntrinsicMeasurable, ? super Integer, Integer> pVar2, int i10, int i11) {
        int iMin = Math.min((list.size() - 1) * i11, i10);
        int size = list.size();
        int iMax = 0;
        float f10 = 0.0f;
        for (int i12 = 0; i12 < size; i12++) {
            IntrinsicMeasurable intrinsicMeasurable = list.get(i12);
            float weight = getWeight(getData(intrinsicMeasurable));
            if (weight == 0.0f) {
                int iMin2 = Math.min(pVar.mo4invoke(intrinsicMeasurable, Integer.MAX_VALUE).intValue(), i10 - iMin);
                iMin += iMin2;
                iMax = Math.max(iMax, pVar2.mo4invoke(intrinsicMeasurable, Integer.valueOf(iMin2)).intValue());
            } else if (weight > 0.0f) {
                f10 += weight;
            }
        }
        int iC = f10 == 0.0f ? 0 : i10 == Integer.MAX_VALUE ? Integer.MAX_VALUE : j9.c.c(Math.max(i10 - iMin, 0) / f10);
        int size2 = list.size();
        for (int i13 = 0; i13 < size2; i13++) {
            IntrinsicMeasurable intrinsicMeasurable2 = list.get(i13);
            float weight2 = getWeight(getData(intrinsicMeasurable2));
            if (weight2 > 0.0f) {
                iMax = Math.max(iMax, pVar2.mo4invoke(intrinsicMeasurable2, Integer.valueOf(iC != Integer.MAX_VALUE ? j9.c.c(iC * weight2) : Integer.MAX_VALUE)).intValue());
            }
        }
        return iMax;
    }

    private static final int intrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, p<? super IntrinsicMeasurable, ? super Integer, Integer> pVar, int i10, int i11) {
        int size = list.size();
        int i12 = 0;
        int iMax = 0;
        int i13 = 0;
        float f10 = 0.0f;
        while (true) {
            if (i12 >= size) {
                return j9.c.c(iMax * f10) + i13 + ((list.size() - 1) * i11);
            }
            IntrinsicMeasurable intrinsicMeasurable = list.get(i12);
            float weight = getWeight(getData(intrinsicMeasurable));
            int iIntValue = pVar.mo4invoke(intrinsicMeasurable, Integer.valueOf(i10)).intValue();
            if (weight == 0.0f) {
                i13 += iIntValue;
            } else if (weight > 0.0f) {
                f10 += weight;
                iMax = Math.max(iMax, j9.c.c(iIntValue / weight));
            }
            i12++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int intrinsicSize(List<? extends IntrinsicMeasurable> list, p<? super IntrinsicMeasurable, ? super Integer, Integer> pVar, p<? super IntrinsicMeasurable, ? super Integer, Integer> pVar2, int i10, int i11, LayoutOrientation layoutOrientation, LayoutOrientation layoutOrientation2) {
        return layoutOrientation == layoutOrientation2 ? intrinsicMainAxisSize(list, pVar, i10, i11) : intrinsicCrossAxisSize(list, pVar2, pVar, i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isRelative(RowColumnParentData rowColumnParentData) {
        CrossAxisAlignment crossAxisAlignment = getCrossAxisAlignment(rowColumnParentData);
        if (crossAxisAlignment != null) {
            return crossAxisAlignment.isRelative$foundation_layout_release();
        }
        return false;
    }

    @NotNull
    /* JADX INFO: renamed from: rowColumnMeasurePolicy-TDGSqEk, reason: not valid java name */
    public static final MeasurePolicy m420rowColumnMeasurePolicyTDGSqEk(@NotNull final LayoutOrientation orientation, @NotNull final s<? super Integer, ? super int[], ? super LayoutDirection, ? super Density, ? super int[], k0> arrangement, final float f10, @NotNull final SizeMode crossAxisSize, @NotNull final CrossAxisAlignment crossAxisAlignment) {
        t.i(orientation, "orientation");
        t.i(arrangement, "arrangement");
        t.i(crossAxisSize, "crossAxisSize");
        t.i(crossAxisAlignment, "crossAxisAlignment");
        return new MeasurePolicy() { // from class: androidx.compose.foundation.layout.RowColumnImplKt$rowColumnMeasurePolicy$1
            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
                t.i(intrinsicMeasureScope, "<this>");
                t.i(measurables, "measurables");
                return ((Number) RowColumnImplKt.MaxIntrinsicHeightMeasureBlock(orientation).invoke(measurables, Integer.valueOf(i10), Integer.valueOf(intrinsicMeasureScope.mo290roundToPx0680j_4(f10)))).intValue();
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
                t.i(intrinsicMeasureScope, "<this>");
                t.i(measurables, "measurables");
                return ((Number) RowColumnImplKt.MaxIntrinsicWidthMeasureBlock(orientation).invoke(measurables, Integer.valueOf(i10), Integer.valueOf(intrinsicMeasureScope.mo290roundToPx0680j_4(f10)))).intValue();
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            @NotNull
            /* JADX INFO: renamed from: measure-3p2s80s */
            public MeasureResult mo8measure3p2s80s(@NotNull MeasureScope measure, @NotNull List<? extends Measurable> list, long j10) {
                int iMax;
                int iJ;
                float f11;
                int i10;
                int i11;
                int iMax2;
                int i12;
                int i13;
                RowColumnParentData[] rowColumnParentDataArr;
                List<? extends Measurable> measurables = list;
                t.i(measure, "$this$measure");
                t.i(measurables, "measurables");
                OrientationIndependentConstraints orientationIndependentConstraints = new OrientationIndependentConstraints(j10, orientation, null);
                int iMo290roundToPx0680j_4 = measure.mo290roundToPx0680j_4(f10);
                int size = list.size();
                Placeable[] placeableArr = new Placeable[size];
                int size2 = list.size();
                RowColumnParentData[] rowColumnParentDataArr2 = new RowColumnParentData[size2];
                for (int i14 = 0; i14 < size2; i14++) {
                    rowColumnParentDataArr2[i14] = RowColumnImplKt.getData(measurables.get(i14));
                }
                int size3 = list.size();
                int i15 = 0;
                int iMax3 = 0;
                int i16 = 0;
                int i17 = 0;
                int iRowColumnMeasurePolicy_TDGSqEk$mainAxisSize = 0;
                boolean z10 = false;
                float f12 = 0.0f;
                while (true) {
                    if (i16 >= size3) {
                        break;
                    }
                    Measurable measurable = measurables.get(i16);
                    RowColumnParentData rowColumnParentData = rowColumnParentDataArr2[i16];
                    float weight = RowColumnImplKt.getWeight(rowColumnParentData);
                    if (weight > 0.0f) {
                        f12 += weight;
                        i17++;
                        i12 = i16;
                        i13 = size3;
                        rowColumnParentDataArr = rowColumnParentDataArr2;
                    } else {
                        int mainAxisMax = orientationIndependentConstraints.getMainAxisMax();
                        i12 = i16;
                        i13 = size3;
                        rowColumnParentDataArr = rowColumnParentDataArr2;
                        Placeable placeableMo2987measureBRTryo0 = measurable.mo2987measureBRTryo0(OrientationIndependentConstraints.copy$default(orientationIndependentConstraints, 0, mainAxisMax != Integer.MAX_VALUE ? mainAxisMax - iRowColumnMeasurePolicy_TDGSqEk$mainAxisSize : Integer.MAX_VALUE, 0, 0, 8, null).m391toBoxConstraintsOenEA2s(orientation));
                        int iMin = Math.min(iMo290roundToPx0680j_4, (mainAxisMax - iRowColumnMeasurePolicy_TDGSqEk$mainAxisSize) - RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$mainAxisSize(placeableMo2987measureBRTryo0, orientation));
                        iRowColumnMeasurePolicy_TDGSqEk$mainAxisSize += RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$mainAxisSize(placeableMo2987measureBRTryo0, orientation) + iMin;
                        iMax3 = Math.max(iMax3, RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(placeableMo2987measureBRTryo0, orientation));
                        boolean z11 = z10 || RowColumnImplKt.isRelative(rowColumnParentData);
                        placeableArr[i12] = placeableMo2987measureBRTryo0;
                        i15 = iMin;
                        z10 = z11;
                    }
                    i16 = i12 + 1;
                    size3 = i13;
                    rowColumnParentDataArr2 = rowColumnParentDataArr;
                }
                int i18 = iMax3;
                RowColumnParentData[] rowColumnParentDataArr3 = rowColumnParentDataArr2;
                if (i17 == 0) {
                    iRowColumnMeasurePolicy_TDGSqEk$mainAxisSize -= i15;
                    iMax = i18;
                    iJ = 0;
                } else {
                    int i19 = iMo290roundToPx0680j_4 * (i17 - 1);
                    int mainAxisMin = (((f12 <= 0.0f || orientationIndependentConstraints.getMainAxisMax() == Integer.MAX_VALUE) ? orientationIndependentConstraints.getMainAxisMin() : orientationIndependentConstraints.getMainAxisMax()) - iRowColumnMeasurePolicy_TDGSqEk$mainAxisSize) - i19;
                    float f13 = f12 > 0.0f ? mainAxisMin / f12 : 0.0f;
                    int iC = 0;
                    for (int i20 = 0; i20 < size2; i20++) {
                        iC += j9.c.c(RowColumnImplKt.getWeight(rowColumnParentDataArr3[i20]) * f13);
                    }
                    int size4 = list.size();
                    int i21 = mainAxisMin - iC;
                    iMax = i18;
                    int i22 = 0;
                    int iRowColumnMeasurePolicy_TDGSqEk$mainAxisSize2 = 0;
                    while (i22 < size4) {
                        if (placeableArr[i22] == null) {
                            Measurable measurable2 = measurables.get(i22);
                            RowColumnParentData rowColumnParentData2 = rowColumnParentDataArr3[i22];
                            float weight2 = RowColumnImplKt.getWeight(rowColumnParentData2);
                            if (!(weight2 > 0.0f)) {
                                throw new IllegalStateException("All weights <= 0 should have placeables".toString());
                            }
                            int iA = j9.c.a(i21);
                            int i23 = i21 - iA;
                            int iMax4 = Math.max(0, j9.c.c(weight2 * f13) + iA);
                            f11 = f13;
                            if (!RowColumnImplKt.getFill(rowColumnParentData2) || iMax4 == Integer.MAX_VALUE) {
                                i10 = size4;
                                i11 = 0;
                            } else {
                                i11 = iMax4;
                                i10 = size4;
                            }
                            Placeable placeableMo2987measureBRTryo02 = measurable2.mo2987measureBRTryo0(new OrientationIndependentConstraints(i11, iMax4, 0, orientationIndependentConstraints.getCrossAxisMax()).m391toBoxConstraintsOenEA2s(orientation));
                            iRowColumnMeasurePolicy_TDGSqEk$mainAxisSize2 += RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$mainAxisSize(placeableMo2987measureBRTryo02, orientation);
                            iMax = Math.max(iMax, RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(placeableMo2987measureBRTryo02, orientation));
                            boolean z12 = z10 || RowColumnImplKt.isRelative(rowColumnParentData2);
                            placeableArr[i22] = placeableMo2987measureBRTryo02;
                            z10 = z12;
                            i21 = i23;
                        } else {
                            f11 = f13;
                            i10 = size4;
                        }
                        i22++;
                        measurables = list;
                        f13 = f11;
                        size4 = i10;
                    }
                    iJ = n9.o.j(iRowColumnMeasurePolicy_TDGSqEk$mainAxisSize2 + i19, orientationIndependentConstraints.getMainAxisMax() - iRowColumnMeasurePolicy_TDGSqEk$mainAxisSize);
                }
                l0 l0Var = new l0();
                if (z10) {
                    iMax2 = 0;
                    for (int i24 = 0; i24 < size; i24++) {
                        Placeable placeable = placeableArr[i24];
                        t.f(placeable);
                        CrossAxisAlignment crossAxisAlignment2 = RowColumnImplKt.getCrossAxisAlignment(rowColumnParentDataArr3[i24]);
                        Integer numCalculateAlignmentLinePosition$foundation_layout_release = crossAxisAlignment2 != null ? crossAxisAlignment2.calculateAlignmentLinePosition$foundation_layout_release(placeable) : null;
                        if (numCalculateAlignmentLinePosition$foundation_layout_release != null) {
                            int i25 = l0Var.f29831a;
                            int iIntValue = numCalculateAlignmentLinePosition$foundation_layout_release.intValue();
                            if (iIntValue == Integer.MIN_VALUE) {
                                iIntValue = 0;
                            }
                            l0Var.f29831a = Math.max(i25, iIntValue);
                            int iRowColumnMeasurePolicy_TDGSqEk$crossAxisSize = RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(placeable, orientation);
                            LayoutOrientation layoutOrientation = orientation;
                            int iIntValue2 = numCalculateAlignmentLinePosition$foundation_layout_release.intValue();
                            if (iIntValue2 == Integer.MIN_VALUE) {
                                iIntValue2 = RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(placeable, layoutOrientation);
                            }
                            iMax2 = Math.max(iMax2, iRowColumnMeasurePolicy_TDGSqEk$crossAxisSize - iIntValue2);
                        }
                    }
                } else {
                    iMax2 = 0;
                }
                int iMax5 = Math.max(iRowColumnMeasurePolicy_TDGSqEk$mainAxisSize + iJ, orientationIndependentConstraints.getMainAxisMin());
                int iMax6 = (orientationIndependentConstraints.getCrossAxisMax() == Integer.MAX_VALUE || crossAxisSize != SizeMode.Expand) ? Math.max(iMax, Math.max(orientationIndependentConstraints.getCrossAxisMin(), l0Var.f29831a + iMax2)) : orientationIndependentConstraints.getCrossAxisMax();
                LayoutOrientation layoutOrientation2 = orientation;
                LayoutOrientation layoutOrientation3 = LayoutOrientation.Horizontal;
                int i26 = layoutOrientation2 == layoutOrientation3 ? iMax5 : iMax6;
                int i27 = layoutOrientation2 == layoutOrientation3 ? iMax6 : iMax5;
                int size5 = list.size();
                int[] iArr = new int[size5];
                for (int i28 = 0; i28 < size5; i28++) {
                    iArr[i28] = 0;
                }
                return MeasureScope.CC.p(measure, i26, i27, null, new RowColumnImplKt$rowColumnMeasurePolicy$1$measure$4(list, placeableArr, arrangement, iMax5, measure, iArr, orientation, rowColumnParentDataArr3, crossAxisAlignment, iMax6, l0Var), 4, null);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
                t.i(intrinsicMeasureScope, "<this>");
                t.i(measurables, "measurables");
                return ((Number) RowColumnImplKt.MinIntrinsicHeightMeasureBlock(orientation).invoke(measurables, Integer.valueOf(i10), Integer.valueOf(intrinsicMeasureScope.mo290roundToPx0680j_4(f10)))).intValue();
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
                t.i(intrinsicMeasureScope, "<this>");
                t.i(measurables, "measurables");
                return ((Number) RowColumnImplKt.MinIntrinsicWidthMeasureBlock(orientation).invoke(measurables, Integer.valueOf(i10), Integer.valueOf(intrinsicMeasureScope.mo290roundToPx0680j_4(f10)))).intValue();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(Placeable placeable, LayoutOrientation layoutOrientation) {
        return layoutOrientation == LayoutOrientation.Horizontal ? placeable.getHeight() : placeable.getWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int rowColumnMeasurePolicy_TDGSqEk$mainAxisSize(Placeable placeable, LayoutOrientation layoutOrientation) {
        return layoutOrientation == LayoutOrientation.Horizontal ? placeable.getWidth() : placeable.getHeight();
    }
}
