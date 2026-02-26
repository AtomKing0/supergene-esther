package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import h9.l;
import h9.p;
import h9.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Scaffold.kt */
/* JADX INFO: loaded from: classes.dex */
final class ScaffoldKt$ScaffoldLayout$1$1 extends v implements p<SubcomposeMeasureScope, Constraints, MeasureResult> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ p<Composer, Integer, k0> $bottomBar;
    final /* synthetic */ q<PaddingValues, Composer, Integer, k0> $content;
    final /* synthetic */ p<Composer, Integer, k0> $fab;
    final /* synthetic */ int $fabPosition;
    final /* synthetic */ boolean $isFabDocked;
    final /* synthetic */ p<Composer, Integer, k0> $snackbar;
    final /* synthetic */ p<Composer, Integer, k0> $topBar;

    /* JADX INFO: renamed from: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: Scaffold.kt */
    static final class AnonymousClass1 extends v implements l<Placeable.PlacementScope, k0> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ p<Composer, Integer, k0> $bottomBar;
        final /* synthetic */ q<PaddingValues, Composer, Integer, k0> $content;
        final /* synthetic */ p<Composer, Integer, k0> $fab;
        final /* synthetic */ int $fabPosition;
        final /* synthetic */ boolean $isFabDocked;
        final /* synthetic */ int $layoutHeight;
        final /* synthetic */ int $layoutWidth;
        final /* synthetic */ long $looseConstraints;
        final /* synthetic */ p<Composer, Integer, k0> $snackbar;
        final /* synthetic */ SubcomposeMeasureScope $this_SubcomposeLayout;
        final /* synthetic */ p<Composer, Integer, k0> $topBar;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(SubcomposeMeasureScope subcomposeMeasureScope, p<? super Composer, ? super Integer, k0> pVar, p<? super Composer, ? super Integer, k0> pVar2, p<? super Composer, ? super Integer, k0> pVar3, int i10, int i11, boolean z10, int i12, long j10, p<? super Composer, ? super Integer, k0> pVar4, int i13, q<? super PaddingValues, ? super Composer, ? super Integer, k0> qVar) {
            super(1);
            this.$this_SubcomposeLayout = subcomposeMeasureScope;
            this.$topBar = pVar;
            this.$snackbar = pVar2;
            this.$fab = pVar3;
            this.$fabPosition = i10;
            this.$layoutWidth = i11;
            this.$isFabDocked = z10;
            this.$layoutHeight = i12;
            this.$looseConstraints = j10;
            this.$bottomBar = pVar4;
            this.$$dirty = i13;
            this.$content = qVar;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
            invoke2(placementScope);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Placeable.PlacementScope layout) {
            Object obj;
            Object obj2;
            FabPlacement fabPlacement;
            Object obj3;
            Integer numValueOf;
            int height;
            int iMo290roundToPx0680j_4;
            int height2;
            Object obj4;
            Object obj5;
            t.i(layout, "$this$layout");
            List<Measurable> listSubcompose = this.$this_SubcomposeLayout.subcompose(ScaffoldLayoutContent.TopBar, this.$topBar);
            long j10 = this.$looseConstraints;
            ArrayList arrayList = new ArrayList(listSubcompose.size());
            int size = listSubcompose.size();
            int i10 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                arrayList.add(listSubcompose.get(i11).mo2987measureBRTryo0(j10));
            }
            if (arrayList.isEmpty()) {
                obj = null;
            } else {
                obj = arrayList.get(0);
                int height3 = ((Placeable) obj).getHeight();
                int iM = kotlin.collections.v.m(arrayList);
                if (1 <= iM) {
                    int i12 = 1;
                    while (true) {
                        Object obj6 = arrayList.get(i12);
                        int height4 = ((Placeable) obj6).getHeight();
                        if (height3 < height4) {
                            obj = obj6;
                            height3 = height4;
                        }
                        if (i12 == iM) {
                            break;
                        } else {
                            i12++;
                        }
                    }
                }
            }
            Placeable placeable = (Placeable) obj;
            int height5 = placeable != null ? placeable.getHeight() : 0;
            List<Measurable> listSubcompose2 = this.$this_SubcomposeLayout.subcompose(ScaffoldLayoutContent.Snackbar, this.$snackbar);
            long j11 = this.$looseConstraints;
            ArrayList arrayList2 = new ArrayList(listSubcompose2.size());
            int size2 = listSubcompose2.size();
            for (int i13 = 0; i13 < size2; i13++) {
                arrayList2.add(listSubcompose2.get(i13).mo2987measureBRTryo0(j11));
            }
            if (arrayList2.isEmpty()) {
                obj2 = null;
            } else {
                obj2 = arrayList2.get(0);
                int height6 = ((Placeable) obj2).getHeight();
                int iM2 = kotlin.collections.v.m(arrayList2);
                if (1 <= iM2) {
                    int i14 = 1;
                    while (true) {
                        Object obj7 = arrayList2.get(i14);
                        int height7 = ((Placeable) obj7).getHeight();
                        if (height6 < height7) {
                            obj2 = obj7;
                            height6 = height7;
                        }
                        if (i14 == iM2) {
                            break;
                        } else {
                            i14++;
                        }
                    }
                }
            }
            Placeable placeable2 = (Placeable) obj2;
            int height8 = placeable2 != null ? placeable2.getHeight() : 0;
            List<Measurable> listSubcompose3 = this.$this_SubcomposeLayout.subcompose(ScaffoldLayoutContent.Fab, this.$fab);
            long j12 = this.$looseConstraints;
            ArrayList arrayList3 = new ArrayList();
            Iterator<T> it = listSubcompose3.iterator();
            while (it.hasNext()) {
                Placeable placeableMo2987measureBRTryo0 = ((Measurable) it.next()).mo2987measureBRTryo0(j12);
                if (!((placeableMo2987measureBRTryo0.getHeight() == 0 || placeableMo2987measureBRTryo0.getWidth() == 0) ? false : true)) {
                    placeableMo2987measureBRTryo0 = null;
                }
                if (placeableMo2987measureBRTryo0 != null) {
                    arrayList3.add(placeableMo2987measureBRTryo0);
                }
            }
            if (!arrayList3.isEmpty()) {
                if (arrayList3.isEmpty()) {
                    obj4 = null;
                } else {
                    obj4 = arrayList3.get(0);
                    int width = ((Placeable) obj4).getWidth();
                    int iM3 = kotlin.collections.v.m(arrayList3);
                    if (1 <= iM3) {
                        int i15 = 1;
                        while (true) {
                            Object obj8 = arrayList3.get(i15);
                            int width2 = ((Placeable) obj8).getWidth();
                            if (width < width2) {
                                obj4 = obj8;
                                width = width2;
                            }
                            if (i15 == iM3) {
                                break;
                            } else {
                                i15++;
                            }
                        }
                    }
                }
                t.f(obj4);
                int width3 = ((Placeable) obj4).getWidth();
                if (arrayList3.isEmpty()) {
                    obj5 = null;
                } else {
                    obj5 = arrayList3.get(0);
                    int height9 = ((Placeable) obj5).getHeight();
                    int iM4 = kotlin.collections.v.m(arrayList3);
                    if (1 <= iM4) {
                        int i16 = 1;
                        while (true) {
                            Object obj9 = arrayList3.get(i16);
                            int height10 = ((Placeable) obj9).getHeight();
                            if (height9 < height10) {
                                height9 = height10;
                                obj5 = obj9;
                            }
                            if (i16 == iM4) {
                                break;
                            } else {
                                i16++;
                            }
                        }
                    }
                }
                t.f(obj5);
                fabPlacement = new FabPlacement(this.$isFabDocked, FabPosition.m1034equalsimpl0(this.$fabPosition, FabPosition.Companion.m1039getEnd5ygKITE()) ? this.$this_SubcomposeLayout.getLayoutDirection() == LayoutDirection.Ltr ? (this.$layoutWidth - this.$this_SubcomposeLayout.mo290roundToPx0680j_4(ScaffoldKt.FabSpacing)) - width3 : this.$this_SubcomposeLayout.mo290roundToPx0680j_4(ScaffoldKt.FabSpacing) : (this.$layoutWidth - width3) / 2, width3, ((Placeable) obj5).getHeight());
            } else {
                fabPlacement = null;
            }
            List<Measurable> listSubcompose4 = this.$this_SubcomposeLayout.subcompose(ScaffoldLayoutContent.BottomBar, ComposableLambdaKt.composableLambdaInstance(1529070963, true, new ScaffoldKt$ScaffoldLayout$1$1$1$bottomBarPlaceables$1(fabPlacement, this.$bottomBar, this.$$dirty)));
            long j13 = this.$looseConstraints;
            ArrayList arrayList4 = new ArrayList(listSubcompose4.size());
            int size3 = listSubcompose4.size();
            for (int i17 = 0; i17 < size3; i17++) {
                arrayList4.add(listSubcompose4.get(i17).mo2987measureBRTryo0(j13));
            }
            if (arrayList4.isEmpty()) {
                obj3 = null;
            } else {
                obj3 = arrayList4.get(0);
                int height11 = ((Placeable) obj3).getHeight();
                int iM5 = kotlin.collections.v.m(arrayList4);
                if (1 <= iM5) {
                    int i18 = 1;
                    while (true) {
                        Object obj10 = arrayList4.get(i18);
                        int height12 = ((Placeable) obj10).getHeight();
                        if (height11 < height12) {
                            obj3 = obj10;
                            height11 = height12;
                        }
                        if (i18 == iM5) {
                            break;
                        } else {
                            i18++;
                        }
                    }
                }
            }
            Placeable placeable3 = (Placeable) obj3;
            int height13 = placeable3 != null ? placeable3.getHeight() : 0;
            if (fabPlacement != null) {
                SubcomposeMeasureScope subcomposeMeasureScope = this.$this_SubcomposeLayout;
                boolean z10 = this.$isFabDocked;
                if (height13 == 0) {
                    height = fabPlacement.getHeight();
                    iMo290roundToPx0680j_4 = subcomposeMeasureScope.mo290roundToPx0680j_4(ScaffoldKt.FabSpacing);
                } else if (z10) {
                    height2 = height13 + (fabPlacement.getHeight() / 2);
                    numValueOf = Integer.valueOf(height2);
                } else {
                    height = fabPlacement.getHeight() + height13;
                    iMo290roundToPx0680j_4 = subcomposeMeasureScope.mo290roundToPx0680j_4(ScaffoldKt.FabSpacing);
                }
                height2 = height + iMo290roundToPx0680j_4;
                numValueOf = Integer.valueOf(height2);
            } else {
                numValueOf = null;
            }
            int iIntValue = height8 != 0 ? height8 + (numValueOf != null ? numValueOf.intValue() : height13) : 0;
            int i19 = this.$layoutHeight - height5;
            SubcomposeMeasureScope subcomposeMeasureScope2 = this.$this_SubcomposeLayout;
            List<Measurable> listSubcompose5 = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.MainContent, ComposableLambdaKt.composableLambdaInstance(-1132241596, true, new ScaffoldKt$ScaffoldLayout$1$1$1$bodyContentPlaceables$1(subcomposeMeasureScope2, height13, this.$content, this.$$dirty)));
            long j14 = this.$looseConstraints;
            ArrayList arrayList5 = new ArrayList(listSubcompose5.size());
            int size4 = listSubcompose5.size();
            while (i10 < size4) {
                arrayList5.add(listSubcompose5.get(i10).mo2987measureBRTryo0(Constraints.m3632copyZbe2FdA$default(j14, 0, 0, 0, i19, 7, null)));
                i10++;
                listSubcompose5 = listSubcompose5;
                j14 = j14;
            }
            int size5 = arrayList5.size();
            int i20 = 0;
            while (i20 < size5) {
                Placeable.PlacementScope.place$default(layout, (Placeable) arrayList5.get(i20), 0, height5, 0.0f, 4, null);
                i20++;
                arrayList5 = arrayList5;
                height13 = height13;
            }
            int i21 = height13;
            int size6 = arrayList.size();
            for (int i22 = 0; i22 < size6; i22++) {
                Placeable.PlacementScope.place$default(layout, (Placeable) arrayList.get(i22), 0, 0, 0.0f, 4, null);
            }
            int i23 = this.$layoutHeight;
            int size7 = arrayList2.size();
            for (int i24 = 0; i24 < size7; i24++) {
                Placeable.PlacementScope.place$default(layout, (Placeable) arrayList2.get(i24), 0, i23 - iIntValue, 0.0f, 4, null);
            }
            int i25 = this.$layoutHeight;
            int size8 = arrayList4.size();
            for (int i26 = 0; i26 < size8; i26++) {
                Placeable.PlacementScope.place$default(layout, (Placeable) arrayList4.get(i26), 0, i25 - i21, 0.0f, 4, null);
            }
            if (fabPlacement != null) {
                int i27 = this.$layoutHeight;
                int size9 = arrayList3.size();
                for (int i28 = 0; i28 < size9; i28++) {
                    Placeable placeable4 = (Placeable) arrayList3.get(i28);
                    int left = fabPlacement.getLeft();
                    t.f(numValueOf);
                    Placeable.PlacementScope.place$default(layout, placeable4, left, i27 - numValueOf.intValue(), 0.0f, 4, null);
                }
                k0 k0Var = k0.f35197a;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ScaffoldKt$ScaffoldLayout$1$1(p<? super Composer, ? super Integer, k0> pVar, p<? super Composer, ? super Integer, k0> pVar2, p<? super Composer, ? super Integer, k0> pVar3, int i10, boolean z10, p<? super Composer, ? super Integer, k0> pVar4, int i11, q<? super PaddingValues, ? super Composer, ? super Integer, k0> qVar) {
        super(2);
        this.$topBar = pVar;
        this.$snackbar = pVar2;
        this.$fab = pVar3;
        this.$fabPosition = i10;
        this.$isFabDocked = z10;
        this.$bottomBar = pVar4;
        this.$$dirty = i11;
        this.$content = qVar;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ MeasureResult mo4invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
        return m1121invoke0kLqBqw(subcomposeMeasureScope, constraints.m3647unboximpl());
    }

    @NotNull
    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
    public final MeasureResult m1121invoke0kLqBqw(@NotNull SubcomposeMeasureScope SubcomposeLayout, long j10) {
        t.i(SubcomposeLayout, "$this$SubcomposeLayout");
        int iM3641getMaxWidthimpl = Constraints.m3641getMaxWidthimpl(j10);
        int iM3640getMaxHeightimpl = Constraints.m3640getMaxHeightimpl(j10);
        return MeasureScope.CC.p(SubcomposeLayout, iM3641getMaxWidthimpl, iM3640getMaxHeightimpl, null, new AnonymousClass1(SubcomposeLayout, this.$topBar, this.$snackbar, this.$fab, this.$fabPosition, iM3641getMaxWidthimpl, this.$isFabDocked, iM3640getMaxHeightimpl, Constraints.m3632copyZbe2FdA$default(j10, 0, 0, 0, 0, 10, null), this.$bottomBar, this.$$dirty, this.$content), 4, null);
    }
}
